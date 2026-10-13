/* ===== JSON 树形视图（可折叠）+ JSON 片段提取工具 =====
 * 供 JSON 格式化面板（树形视图）与文本对比面板（自动提取 JSON + 树形对比）共用。
 * 对外 API（window.JsonTree）：
 *   render(container, value, { markSet, markClass })  渲染可折叠树；行数超限时返回 { ok:false }
 *   expandAll(container) / collapseAll(container)     展开 / 折叠该容器内所有节点
 *   extractJson(text)                                 从混杂文本中提取 JSON 片段（含去转义）
 *   diffMarks(leftValue, rightValue)                  结构级差异标记（Set，按节点路径）
 */
(function () {
  'use strict';

  const MAX_ROWS = 8000;  // 树形渲染行数上限（超过则拒绝，避免界面卡顿、退回文本显示）
  const INDENT = 14;      // 每层缩进 px

  const STATES = new WeakMap();  // container -> { rows, lineEls }
  const BOUND = new WeakSet();   // 已绑定折叠点击的容器

  const ESC_MAP = { '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;', "'": '&#39;' };
  function esc(s) {
    return String(s).replace(/[&<>"']/g, (c) => ESC_MAP[c]);
  }

  // ---------- JSON 片段提取 ----------

  function tryParse(s) {
    try {
      return { ok: true, value: JSON.parse(s) };
    } catch (_) {
      return { ok: false };
    }
  }

  /** 轻量去转义：还原 \" \\ \/（\n \t \uXXXX 等保留给 JSON.parse 处理） */
  function unescapeLite(s) {
    return s.replace(/\\(["\\/])/g, '$1');
  }

  /** 扫描最外层平衡的 {…} / […] 片段（识别 JSON 字符串与转义，引号 / 括号内的不计数） */
  function scanCandidates(text) {
    const out = [];
    let depth = 0;
    let start = -1;
    let inStr = false;
    let escOn = false;
    for (let i = 0; i < text.length; i++) {
      const c = text[i];
      if (inStr) {
        if (escOn) escOn = false;
        else if (c === '\\') escOn = true;
        else if (c === '"') inStr = false;
        continue;
      }
      if (c === '"') {
        inStr = true;
        continue;
      }
      if (c === '{' || c === '[') {
        if (depth === 0) start = i;
        depth++;
      } else if ((c === '}' || c === ']') && depth > 0) {
        depth--;
        if (depth === 0 && start >= 0) {
          out.push(text.slice(start, i + 1));
          start = -1;
        }
      }
    }
    return out;
  }

  /**
   * 从混杂文本中提取 JSON：
   * 1) 整段（或剥外层引号后）可直接解析 → 直接作为结果
   * 2) 扫描 {…} / […] 平衡片段，原文失败则去转义后重试，取最长的可解析片段
   * 3) 都无法解析时，取最长的平衡片段（去转义后）作为「非严格」结果（仍可用于文本对比）
   * 返回 { ok, strict, value?, text }；strict=false 时 text 为去转义后的片段原文
   */
  function extractJson(raw) {
    let text = String(raw || '').trim();
    if (!text) return { ok: false };
    // 外层引号包裹的 JSON 字符串（如 "{\"a\":1}"）：解析后取内层继续
    for (let round = 0; round < 3; round++) {
      const whole = tryParse(text);
      if (!whole.ok) break;
      if (typeof whole.value === 'string' && /^\s*[{[]/.test(whole.value)) {
        text = whole.value.trim();
        continue;
      }
      return { ok: true, strict: true, value: whole.value, text: text };
    }
    const segs = scanCandidates(text);
    const un = unescapeLite(text);
    if (un !== text) {
      for (const s of scanCandidates(un)) segs.push(s);
    }
    if (!segs.length) return { ok: false };
    let best = null;
    let bestLen = -1;
    for (const seg of segs) {
      let parsed = tryParse(seg);
      let outText = seg;
      if (!parsed.ok) {
        outText = unescapeLite(seg);
        parsed = tryParse(outText);
        if (!parsed.ok) continue;
      }
      if (seg.length > bestLen) {
        best = { value: parsed.value, text: outText };
        bestLen = seg.length;
      }
    }
    if (best) return { ok: true, strict: true, value: best.value, text: best.text };
    let longest = segs[0];
    for (const seg of segs) {
      if (seg.length > longest.length) longest = seg;
    }
    return { ok: true, strict: false, value: undefined, text: unescapeLite(longest).trim() };
  }

  // ---------- 行模型构建 ----------

  /**
   * 字符串值 → JSON 对象/数组（v0.48.0 内嵌 JSON 字符串解析）：
   * trim 后以 { / [ 开头且能成功解析为对象/数组时返回解析值，否则 undefined（保持普通字符串）
   */
  function parseEmbedded(v) {
    if (typeof v !== 'string') return undefined;
    const t = v.trim();
    if (!t || (t[0] !== '{' && t[0] !== '[')) return undefined;
    const parsed = tryParse(t);
    if (parsed.ok && parsed.value !== null && typeof parsed.value === 'object') return parsed.value;
    return undefined;
  }

  /**
   * 值 → 行模型数组（行式渲染：每行一个 token，容器行为 open / close 配对）。
   * path 规则（与 diffMarks 一致）：对象成员 parent + '.' + key，数组元素 parent + '[i]'
   * v0.48.0：expandEmbedded 开启时，值为 JSON（对象/数组）的字符串自动解析展开，
   * open 行标记 embedded（原始字符串，供角标 / 悬停查看），最多递归 8 层，防解析爆炸
   */
  function buildRows(v, key, depth, path, isLast, rows, embeddedSrc, embedDepth, expandEmbedded) {
    embedDepth = embedDepth || 0;
    if (expandEmbedded && embeddedSrc === undefined && embedDepth < 8) {
      const decoded = parseEmbedded(v);
      if (decoded !== undefined) {
        buildRows(decoded, key, depth, path, isLast, rows, v, embedDepth + 1, expandEmbedded);
        return;
      }
    }
    if (v !== null && typeof v === 'object') {
      const isArr = Array.isArray(v);
      const keys = isArr ? null : Object.keys(v);
      const size = isArr ? v.length : keys.length;
      const row = { kind: 'open', depth: depth, key: key, arr: isArr, isLast: isLast, path: path, size: size, hasChildren: size > 0, collapsed: false };
      if (embeddedSrc !== undefined) row.embedded = embeddedSrc;
      rows.push(row);
      if (size > 0) {
        if (isArr) {
          for (let i = 0; i < v.length; i++) {
            buildRows(v[i], null, depth + 1, path + '[' + i + ']', i === v.length - 1, rows, undefined, embedDepth, expandEmbedded);
          }
        } else {
          for (let i = 0; i < keys.length; i++) {
            const k = keys[i];
            buildRows(v[k], k, depth + 1, path + '.' + k, i === keys.length - 1, rows, undefined, embedDepth, expandEmbedded);
          }
        }
        row.endIdx = rows.length;
        rows.push({ kind: 'close', depth: depth, key: null, arr: isArr, isLast: isLast, path: path });
      }
      return;
    }
    rows.push({ kind: 'leaf', depth: depth, key: key, isLast: isLast, path: path, value: v });
  }

  function leafValueHtml(v) {
    if (v === null) return '<span class="jt-null">null</span>';
    if (typeof v === 'string') return '<span class="jt-str">"' + esc(v) + '"</span>';
    if (typeof v === 'number') return '<span class="jt-num">' + String(v) + '</span>';
    return '<span class="jt-bool">' + (v ? 'true' : 'false') + '</span>';
  }

  function lineHtml(row, idx, markSet, markClass) {
    let cls = 'jt-line';
    if (row.kind === 'open' && row.hasChildren) cls += ' jt-can-collapse';
    if (markSet && markSet.has(row.path)) cls += ' ' + markClass;
    const pad = 6 + row.depth * INDENT;
    let body = '';
    if (row.kind === 'open') {
      body += '<span class="jt-toggle' + (row.hasChildren ? '' : ' jt-toggle-empty') + '">\u25be</span>';
      if (row.key !== null) body += '<span class="jt-key">"' + esc(row.key) + '"</span><span class="jt-punct">: </span>';
      if (row.embedded !== undefined) {
        const tip = String(row.embedded).length > 300 ? String(row.embedded).slice(0, 300) + '…' : String(row.embedded);
        body += '<span class="jt-embed-badge" title="' + esc('内嵌 JSON 字符串已解析，原始内容：\n' + tip) + '">JSON</span>';
      }
      const open = row.arr ? '[' : '{';
      const close = row.arr ? ']' : '}';
      body += '<span class="jt-punct">' + open + '</span>';
      if (row.hasChildren) {
        body += '<span class="jt-summary">\u2026 ' + row.size + ' 项 ' + close + (row.isLast ? '' : ',') + '</span>';
      } else {
        body += '<span class="jt-punct">' + close + (row.isLast ? '' : ',') + '</span>';
      }
    } else if (row.kind === 'close') {
      body += '<span class="jt-toggle jt-toggle-empty">\u25be</span>';
      body += '<span class="jt-punct">' + (row.arr ? ']' : '}') + (row.isLast ? '' : ',') + '</span>';
    } else {
      body += '<span class="jt-toggle jt-toggle-empty">\u25be</span>';
      if (row.key !== null) body += '<span class="jt-key">"' + esc(row.key) + '"</span><span class="jt-punct">: </span>';
      body += leafValueHtml(row.value);
      if (!row.isLast) body += '<span class="jt-punct">,</span>';
    }
    return '<div class="' + cls + '" data-idx="' + idx + '" style="padding-left:' + pad + 'px">' + body + '</div>';
  }

  // ---------- 折叠交互 ----------

  /** 按折叠状态重算行显隐（折叠容器区间内的行隐藏；被外层区间覆盖的内层容器跳过，避免重复标记） */
  function applyVisibility(st) {
    const hidden = new Uint8Array(st.rows.length);
    let covered = -1;
    for (let i = 0; i < st.rows.length; i++) {
      const r = st.rows[i];
      if (r.kind === 'open' && r.hasChildren && r.collapsed) {
        if (r.endIdx <= covered) continue;
        const from = Math.max(i + 1, covered + 1);
        for (let j = from; j <= r.endIdx; j++) hidden[j] = 1;
        covered = r.endIdx;
      }
    }
    for (let i = 0; i < st.lineEls.length; i++) {
      st.lineEls[i].classList.toggle('jt-hidden', hidden[i] === 1);
    }
  }

  function setCollapsed(st, idx, collapsed) {
    const row = st.rows[idx];
    if (!row || row.kind !== 'open' || !row.hasChildren || row.collapsed === collapsed) return;
    row.collapsed = collapsed;
    const el = st.lineEls[idx];
    el.classList.toggle('jt-collapsed', collapsed);
    const t = el.querySelector('.jt-toggle');
    if (t) t.textContent = collapsed ? '\u25b8' : '\u25be';
  }

  function onTreeClick(e) {
    const container = e.currentTarget;
    const st = STATES.get(container);
    if (!st) return;
    const line = e.target.closest ? e.target.closest('.jt-line') : null;
    if (!line) return;
    const idx = Number(line.getAttribute('data-idx'));
    const row = st.rows[idx];
    if (!row || row.kind !== 'open' || !row.hasChildren) return;
    setCollapsed(st, idx, !row.collapsed);
    applyVisibility(st);
  }

  function setAllCollapsed(container, collapsed) {
    const st = STATES.get(container);
    if (!st) return;
    for (let i = 0; i < st.rows.length; i++) setCollapsed(st, i, collapsed);
    applyVisibility(st);
  }

  // ---------- 渲染 ----------

  function render(container, value, options) {
    const opts = options || {};
    const rows = [];
    buildRows(value, null, 0, '', true, rows, undefined, 0, !!opts.expandEmbedded);
    if (rows.length > MAX_ROWS) return { ok: false, reason: 'too-large' };
    let html = '';
    for (let i = 0; i < rows.length; i++) html += lineHtml(rows[i], i, opts.markSet, opts.markClass);
    container.innerHTML = '<div class="jt-body">' + html + '</div>';
    const lineEls = Array.prototype.slice.call(container.querySelectorAll('.jt-line'));
    STATES.set(container, { rows: rows, lineEls: lineEls });
    if (!BOUND.has(container)) {
      BOUND.add(container);
      container.addEventListener('click', onTreeClick);
    }
    return { ok: true, rows: rows.length };
  }

  // ---------- 结构级差异标记 ----------

  /** 把某个值及其全部子孙的 path 加入标记集合 */
  function addSubtree(v, p, set) {
    set.add(p);
    if (Array.isArray(v)) {
      for (let i = 0; i < v.length; i++) addSubtree(v[i], p + '[' + i + ']', set);
    } else if (v !== null && typeof v === 'object') {
      for (const k of Object.keys(v)) addSubtree(v[k], p + '.' + k, set);
    }
  }

  /**
   * 结构级差异：递归比较两侧值，把有差异的节点路径分别标入 left / right 集合。
   * 语义与文本对比一致：绿（left）= 左侧独有 / 旧值，红（right）= 右侧独有 / 新值。
   * 返回 { left, right, count }（count 为差异点数量：键级 / 元素级 / 改值各计 1）
   */
  function diffMarks(l, r) {
    const left = new Set();
    const right = new Set();
    let count = 0;
    function walk(lv, rv, lp, rp) {
      const lObj = lv !== null && typeof lv === 'object';
      const rObj = rv !== null && typeof rv === 'object';
      if (lObj && rObj && Array.isArray(lv) === Array.isArray(rv)) {
        let has = false;
        if (Array.isArray(lv)) {
          const n = Math.max(lv.length, rv.length);
          for (let i = 0; i < n; i++) {
            const lp2 = lp + '[' + i + ']';
            const rp2 = rp + '[' + i + ']';
            if (i < lv.length && i < rv.length) {
              if (walk(lv[i], rv[i], lp2, rp2)) has = true;
            } else if (i < lv.length) {
              addSubtree(lv[i], lp2, left);
              count++;
              has = true;
            } else {
              addSubtree(rv[i], rp2, right);
              count++;
              has = true;
            }
          }
        } else {
          const keys = [];
          const seen = new Set();
          for (const k of Object.keys(lv)) { keys.push(k); seen.add(k); }
          for (const k of Object.keys(rv)) {
            if (!seen.has(k)) keys.push(k);
          }
          for (const k of keys) {
            const lHas = Object.prototype.hasOwnProperty.call(lv, k);
            const rHas = Object.prototype.hasOwnProperty.call(rv, k);
            if (lHas && rHas) {
              if (walk(lv[k], rv[k], lp + '.' + k, rp + '.' + k)) has = true;
            } else if (lHas) {
              addSubtree(lv[k], lp + '.' + k, left);
              count++;
              has = true;
            } else {
              addSubtree(rv[k], rp + '.' + k, right);
              count++;
              has = true;
            }
          }
        }
        if (has && lp !== '') {
          left.add(lp);
          right.add(rp);
        }
        return has;
      }
      if (lv !== rv) {
        left.add(lp);
        right.add(rp);
        count++;
        return true;
      }
      return false;
    }
    walk(l, r, '', '');
    return { left: left, right: right, count: count };
  }

  window.JsonTree = {
    render: render,
    expandAll: function (container) { setAllCollapsed(container, false); },
    collapseAll: function (container) { setAllCollapsed(container, true); },
    extractJson: extractJson,
    diffMarks: diffMarks,
  };
})();
