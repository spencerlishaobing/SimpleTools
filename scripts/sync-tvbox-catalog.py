#!/usr/bin/env python3
"""Resolve a TVBox multi-warehouse URL into a maintainable local inventory.

The output is deliberately an inventory, not executable third-party code.  It
keeps the upstream config snapshots needed to compare future changes and
classifies every site so native/JS/Python adapters can be maintained by name.
"""

from __future__ import annotations

import argparse
import base64
import gzip
import hashlib
import json
import re
import sys
import urllib.error
import urllib.parse
import urllib.request
from datetime import datetime, timezone
from pathlib import Path
from typing import Any


DEFAULT_COLLECTION = (
    "https://github.catvod.com/https://raw.githubusercontent.com/"
    "tushen6/Tomorrow/master/lmw.json"
)
UA = "okhttp/3.15"
FALLBACK_UA = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 Chrome/124 Safari/537.36"
MAX_BODY = 32 * 1024 * 1024


def redact_snapshot_secrets(value: Any) -> Any:
    """Keep upstream snapshots auditable without committing live credentials."""
    if isinstance(value, dict):
        return {
            key: (
                "<redacted>"
                if key.lower() in {"cookie", "authorization"} and val
                else redact_snapshot_secrets(val)
            )
            for key, val in value.items()
        }
    if isinstance(value, list):
        return [redact_snapshot_secrets(item) for item in value]
    return value


def fetch(url: str) -> tuple[bytes, str, str]:
    candidates = [url]
    wrapped = re.search(r"/(https?://.+)$", url)
    if wrapped and wrapped.group(1) not in candidates:
        candidates.append(wrapped.group(1))
    last_error: Exception | None = None
    for candidate in candidates:
        for user_agent in (UA, FALLBACK_UA):
            try:
                request = urllib.request.Request(
                    iri_to_uri(candidate), headers={"User-Agent": user_agent}
                )
                with urllib.request.urlopen(request, timeout=15) as response:
                    data = response.read(MAX_BODY + 1)
                    if len(data) > MAX_BODY:
                        raise ValueError("response exceeds 32 MB")
                    if data.startswith(b"\x1f\x8b"):
                        data = gzip.decompress(data)
                    return data, response.geturl(), response.headers.get("Content-Type", "")
            except (OSError, ValueError, urllib.error.URLError) as exc:
                last_error = exc
    assert last_error is not None
    raise last_error


def iri_to_uri(value: str) -> str:
    """Convert Chinese host/path characters to the ASCII form urllib accepts."""
    parts = urllib.parse.urlsplit(value)
    host = parts.hostname or ""
    ascii_host = host.encode("idna").decode("ascii")
    if ":" in ascii_host and not ascii_host.startswith("["):
        ascii_host = f"[{ascii_host}]"
    user = ""
    if parts.username is not None:
        user = urllib.parse.quote(parts.username, safe="")
        if parts.password is not None:
            user += ":" + urllib.parse.quote(parts.password, safe="")
        user += "@"
    port = f":{parts.port}" if parts.port is not None else ""
    netloc = f"{user}{ascii_host}{port}"
    path = urllib.parse.quote(urllib.parse.unquote(parts.path), safe="/%:@!$&'()*+,;=-._~")
    query = urllib.parse.quote(urllib.parse.unquote(parts.query), safe="=&?/:;+,%@-._~")
    fragment = urllib.parse.quote(urllib.parse.unquote(parts.fragment), safe="=&?/:;+,%@-._~")
    return urllib.parse.urlunsplit((parts.scheme, netloc, path, query, fragment))


def strip_json_comments(text: str) -> str:
    """Strip // and /* */ comments without touching quoted strings."""
    out: list[str] = []
    i = 0
    quoted = False
    escaped = False
    while i < len(text):
        ch = text[i]
        if quoted:
            out.append(ch)
            if escaped:
                escaped = False
            elif ch == "\\":
                escaped = True
            elif ch == '"':
                quoted = False
            i += 1
            continue
        if ch == '"':
            quoted = True
            out.append(ch)
            i += 1
            continue
        if text.startswith("//", i):
            end = text.find("\n", i + 2)
            i = len(text) if end < 0 else end
            continue
        if text.startswith("/*", i):
            end = text.find("*/", i + 2)
            i = len(text) if end < 0 else end + 2
            continue
        out.append(ch)
        i += 1
    return "".join(out)


def decode_base64_tail(tail: bytes) -> str | None:
    compact = re.sub(rb"\s+", b"", tail)
    candidates = [compact]
    candidates.extend(re.findall(rb"[A-Za-z0-9+/=_-]{24,}", tail))
    candidates.sort(key=len, reverse=True)
    for encoded in candidates:
        padded = encoded + b"=" * (-len(encoded) % 4)
        for decoder in (base64.b64decode, base64.urlsafe_b64decode):
            try:
                payload = decoder(padded)
                if payload.startswith(b"\x1f\x8b"):
                    payload = gzip.decompress(payload)
                text = payload.decode("utf-8-sig").lstrip()
                if text.startswith("{"):
                    return text
            except Exception:
                pass
    return None


def decode_config(data: bytes) -> tuple[dict[str, Any], str]:
    for match in reversed(list(re.finditer(rb"\*\*", data))):
        decoded = decode_base64_tail(data[match.end() :])
        if decoded:
            return json.loads(strip_json_comments(decoded)), "image-base64"
    text = data.decode("utf-8-sig", errors="strict").strip()
    if text.startswith("<"):
        raise ValueError("server returned HTML instead of a TVBox config")
    if re.fullmatch(r"[0-9a-fA-F\s]+", text) and len(text) >= 40:
        head = bytes.fromhex("".join(text.split())[:64]).decode("utf-8", "ignore")
        marker = re.search(r"\$#([^#]+)#\$", head)
        if marker:
            raise ValueError(f"unsupported keyed hex envelope: {marker.group(1)}")
    return json.loads(strip_json_comments(text)), "json"


def safe_name(value: str, fallback: str) -> str:
    value = re.sub(r"[^0-9A-Za-z\u4e00-\u9fff_-]+", "-", value).strip("-")
    return (value[:48] or fallback).lower()


def source_kind(site: dict[str, Any]) -> str:
    api = str(site.get("api", "")).split(";", 1)[0].lower()
    source_type = int(site.get("type", 0) or 0)
    if source_type != 3:
        return "standard-api"
    if re.search(r"\.py(?:[?#]|$)", api):
        return "python"
    if re.search(r"\.js(?:[?#]|$)", api):
        return "javascript"
    if api.startswith("csp_"):
        return "guarded-jar" if api.endswith("guard") else "jar"
    return "custom"


def public_site(site: dict[str, Any], warehouse_id: str) -> dict[str, Any]:
    api = str(site.get("api", ""))
    ext = site.get("ext")
    ext_text = ext if isinstance(ext, str) else json.dumps(ext, ensure_ascii=False, sort_keys=True)
    return {
        "warehouse": warehouse_id,
        "key": str(site.get("key", "")),
        "name": str(site.get("name", "")),
        "type": site.get("type", 0),
        "api": api,
        "kind": source_kind(site),
        "searchable": site.get("searchable"),
        "filterable": site.get("filterable"),
        "hasExt": bool(ext_text),
        "extSha256": hashlib.sha256(ext_text.encode("utf-8")).hexdigest() if ext_text else "",
    }


def resolve_url(value: str, base: str) -> str:
    return urllib.parse.urljoin(base, value)


def sync(collection_url: str, output: Path) -> dict[str, Any]:
    root_data, root_url, _ = fetch(collection_url)
    root, root_format = decode_config(root_data)
    queue: list[tuple[str, str, str, int]] = []
    for index, item in enumerate(root.get("urls", []), 1):
        if isinstance(item, str):
            value, name = item, f"配置 {index}"
        else:
            value = str(item.get("url") or item.get("api") or "")
            name = str(item.get("name") or f"配置 {index}")
        if value:
            queue.append((name, resolve_url(value, root_url), "", 0))

    snapshots = output / "configs"
    snapshots.mkdir(parents=True, exist_ok=True)
    for old_snapshot in snapshots.glob("w??-*.json"):
        old_snapshot.unlink()
    seen: set[str] = set()
    warehouses: list[dict[str, Any]] = []
    sources: list[dict[str, Any]] = []
    while queue:
        name, url, parent, depth = queue.pop(0)
        if url in seen or depth > 2:
            continue
        seen.add(url)
        warehouse_id = f"w{len(warehouses)+1:02d}-{safe_name(name, 'warehouse')}"
        entry: dict[str, Any] = {
            "id": warehouse_id,
            "name": name,
            "url": url,
            "parent": parent,
            "status": "error",
        }
        try:
            data, final_url, content_type = fetch(url)
            config, encoding = decode_config(data)
            entry.update(
                status="ok",
                finalUrl=final_url,
                contentType=content_type,
                encoding=encoding,
                siteCount=len(config.get("sites", [])),
                liveCount=len(config.get("lives", [])),
                parseCount=len(config.get("parses", [])),
                spider=str(config.get("spider", "")),
            )
            snapshot = snapshots / f"{warehouse_id}.json"
            snapshot.write_text(
                json.dumps(redact_snapshot_secrets(config), ensure_ascii=False, indent=2) + "\n",
                encoding="utf-8",
            )
            entry["snapshot"] = snapshot.relative_to(output).as_posix()
            for site in config.get("sites", []):
                if isinstance(site, dict):
                    sources.append(public_site(site, warehouse_id))
            for index, child in enumerate(config.get("urls", []), 1):
                if isinstance(child, str):
                    child_url, child_name = child, f"{name} / 配置 {index}"
                else:
                    child_url = str(child.get("url") or child.get("api") or "")
                    child_name = str(child.get("name") or f"{name} / 配置 {index}")
                if child_url:
                    queue.append((child_name, resolve_url(child_url, final_url), warehouse_id, depth + 1))
        except Exception as exc:
            entry["error"] = str(exc)
        warehouses.append(entry)

    kinds: dict[str, int] = {}
    for site in sources:
        kinds[site["kind"]] = kinds.get(site["kind"], 0) + 1
    registry_path = output.parent / "registry.json"
    try:
        adapters = json.loads(registry_path.read_text(encoding="utf-8")).get("sites", [])
    except (OSError, json.JSONDecodeError):
        adapters = []
    for site in sources:
        key = re.sub(r"^csp_", "", site["api"], flags=re.I)
        key = re.sub(r"Guard$", "", key, flags=re.I)
        haystack = f"{key}\n{site['name']}".lower()
        site["localAdapter"] = next(
            (
                str(adapter.get("id", ""))
                for adapter in adapters
                if any(
                    re.sub(r"Guard$", "", re.sub(r"^csp_", "", str(term), flags=re.I), flags=re.I)
                    == key
                    for term in adapter.get("exact", [])
                )
                or any(str(term).strip().lower() in haystack for term in adapter.get("match", []))
            ),
            "",
        )
        site["migration"] = (
            site["localAdapter"]
            or {
                "standard-api": "native-api",
                "javascript": "quickjs-upstream",
                "python": "embedded-python-upstream",
            }.get(site["kind"], "")
        )
    catalog = {
        "schema": 1,
        "generatedAt": datetime.now(timezone.utc).isoformat(),
        "collection": {"url": collection_url, "resolvedUrl": root_url, "encoding": root_format},
        "summary": {
            "warehouses": len(warehouses),
            "workingWarehouses": sum(1 for item in warehouses if item["status"] == "ok"),
            "sources": len(sources),
            "sourceKinds": dict(sorted(kinds.items())),
            "locallyAdapted": sum(1 for site in sources if site["localAdapter"]),
            "jarFreeReady": sum(1 for site in sources if site["migration"]),
        },
        "warehouses": warehouses,
        "sources": sources,
    }
    (output / "catalog.json").write_text(
        json.dumps(catalog, ensure_ascii=False, indent=2) + "\n", encoding="utf-8"
    )
    return catalog


def write_report(catalog: dict[str, Any], path: Path) -> None:
    summary = catalog["summary"]
    lines = [
        "# TVBox 多仓解析报告",
        "",
        f"- 入口：`{catalog['collection']['url']}`",
        f"- 仓库：{summary['workingWarehouses']}/{summary['warehouses']} 可解析",
        f"- 片源：{summary['sources']}",
        "- 类型：" + "、".join(f"{k} {v}" for k, v in summary["sourceKinds"].items()),
        "",
        "## 仓库",
        "",
        "| 名称 | 状态 | 片源 | 格式 | 地址/错误 |",
        "|---|---:|---:|---|---|",
    ]
    for item in catalog["warehouses"]:
        detail = item.get("finalUrl") or item.get("error", "")
        detail = str(detail).replace("|", "\\|")
        lines.append(
            f"| {item['name']} | {item['status']} | {item.get('siteCount', 0)} | "
            f"{item.get('encoding', '')} | {detail} |"
        )
    lines.extend(["", "## 后续重写顺序", "", "1. `standard-api`：由通用 API 适配器直接接管。", "2. `javascript` / `python`：审查后本地化脚本及依赖。", "3. `guarded-jar`：按站点逐个重写，不再加载加固 JAR。", ""])
    fanhard_ids = {
        item["id"] for item in catalog["warehouses"] if "饭太硬" in item["name"]
    }
    fanhard = [site for site in catalog["sources"] if site["warehouse"] in fanhard_ids]
    if fanhard:
        lines.extend(
            [
                "## 饭太硬迁移清单",
                "",
                "| 名称 | 原接口 | 类型 | 本地适配器 |",
                "|---|---|---|---|",
            ]
        )
        for site in fanhard:
            display_name = site["name"].replace("|", "\\|")
            lines.append(
                f"| {display_name} | `{site['api']}` | "
                f"{site['kind']} | {site['migration'] or '待重写'} |"
            )
        lines.append("")
    path.write_text("\n".join(lines), encoding="utf-8")


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--collection", default=DEFAULT_COLLECTION)
    parser.add_argument(
        "--output",
        type=Path,
        default=Path("src-tauri/resources/tvspiders/upstream"),
    )
    parser.add_argument("--report", type=Path, default=Path("docs/TVBOX-SOURCES.md"))
    args = parser.parse_args()
    try:
        args.output.mkdir(parents=True, exist_ok=True)
        catalog = sync(args.collection, args.output)
        args.report.parent.mkdir(parents=True, exist_ok=True)
        write_report(catalog, args.report)
        print(json.dumps(catalog["summary"], ensure_ascii=False))
        return 0 if catalog["summary"]["workingWarehouses"] else 2
    except (OSError, ValueError, json.JSONDecodeError, urllib.error.URLError) as exc:
        print(f"同步失败：{exc}", file=sys.stderr)
        return 1


if __name__ == "__main__":
    raise SystemExit(main())
