/* ===== Markdown 预览模块（自研解析器 + 阅读体验：TOC / 搜索 / 字号 / 宽度 / 进度条） ===== */
(function () {
  'use strict';

  const invoke = (window.__TAURI__ && window.__TAURI__.core && window.__TAURI__.core.invoke) || null;
  const dialogApi = (window.__TAURI__ && window.__TAURI__.dialog) || null;
  const eventApi = (window.__TAURI__ && window.__TAURI__.event) || null;

  const panelEl = document.getElementById('panel-md');
  const inputEl = document.getElementById('md-input');
  const docNameEl = document.getElementById('md-doc-name');
  const readerWrap = document.getElementById('md-reader-wrap');
  const readerEl = document.getElementById('md-reader');
  const emptyEl = document.getElementById('md-empty');
  const tocEl = document.getElementById('md-toc');
  const tocListEl = document.getElementById('md-toc-list');
  const progressBar = document.getElementById('md-progress-bar');
  const fontLabel = document.getElementById('md-font-label');
  const searchEl = document.getElementById('md-search');
  const searchInput = document.getElementById('md-search-input');
  const searchCount = document.getElementById('md-search-count');
  const searchSyncEl = document.getElementById('md-search-sync');

  const RENDER_DEBOUNCE = 120;
  const SEARCH_DEBOUNCE = 280;

  let rawHtml = '';      // 渲染后的原始 HTML（搜索重建 / 复制 HTML 用）
  let headings = [];     // [{ id, level, text }]
  let headingEls = [];   // 标题对应的 DOM 元素（目录高亮用）
  let renderTimer = null;
  let docDir = '';       // 当前打开文档所在目录（本地图片相对路径的解析基准）
  let docPath = '';      // 当前打开 / 保存的文档完整路径（保存时直接覆写；为空则另存为）

  // ---------- 基础工具 ----------

  function escapeHtml(s) {
    return String(s)
      .replace(/&/g, '&amp;')
      .replace(/</g, '&lt;')
      .replace(/>/g, '&gt;')
      .replace(/"/g, '&quot;');
  }

  function stripTags(s) {
    return String(s).replace(/<[^>]*>/g, '');
  }

  // 链接地址过滤：屏蔽危险协议（链接点击只复制不导航）
  function safeUrl(u) {
    const s = String(u).trim();
    if (/^(javascript|vbscript|file|data):/i.test(s)) return '#';
    return s;
  }

  // ---------- 图片地址解析（网络 / data:image / 本地路径） ----------

  // 本地路径 → Tauri asset 协议 URL（真实应用环境；无 Tauri 接口时返回空）
  function toAssetUrl(p) {
    const api = window.__TAURI__ && window.__TAURI__.core;
    if (api && typeof api.convertFileSrc === 'function') {
      try { return api.convertFileSrc(p); } catch (e) { return ''; }
    }
    return '';
  }

  // 目录 + 相对路径拼接（处理 ./ 与 ../）
  function joinPath(dir, rel) {
    const parts = dir.replace(/\\/g, '/').split('/');
    rel.replace(/\\/g, '/').split('/').forEach((seg) => {
      if (!seg || seg === '.') return;
      if (seg === '..') parts.pop();
      else parts.push(seg);
    });
    return parts.join('\\');
  }

  // 图片地址解析：https/http 与 data:image 原样；本地路径（绝对 / file:// / 基于文档目录的相对路径）转 asset 协议；
  // javascript:/vbscript:/blob: 及非图片 data: 拒绝（返回空，由调用方渲染占位）
  function resolveImageSrc(u) {
    const s = String(u).trim();
    if (!s) return '';
    if (/^https?:\/\//i.test(s)) return s;
    if (/^data:image\//i.test(s)) return s;
    if (/^(javascript|vbscript|data|blob):/i.test(s)) return '';
    let p = s;
    if (/^file:/i.test(p)) {
      try { p = decodeURIComponent(p.replace(/^file:\/{0,3}/i, '')); } catch (e) { p = s.replace(/^file:\/{0,3}/i, ''); }
    } else {
      try { p = decodeURIComponent(p); } catch (e) { /* 含裸 % 时保留原样 */ }
    }
    if (/^[a-zA-Z]:[\\/]/.test(p) || /^\\\\/.test(p)) return toAssetUrl(p);
    if (docDir) return toAssetUrl(joinPath(docDir, p));
    return '';
  }

  // ---------- 行内解析 ----------

  function renderInline(text) {
    // 1) 先提取行内代码，避免内部被其它规则处理
    const codes = [];
    let t = String(text).replace(/`([^`\n]+)`/g, (m, c) => {
      codes.push(c);
      return '\u0000' + (codes.length - 1) + '\u0000';
    });
    // 2) 转义 HTML：原始 HTML 标签按文本显示，防止注入
    t = escapeHtml(t);
    // 3) 图片 / 链接
    t = t.replace(/!\[([^\]]*)\]\(([^)\n]+)\)/g, (m, alt, url) => {
      const src = resolveImageSrc(url);
      if (!src) return '<span class="md-img-broken">' + (alt || '图片无法加载') + '</span>';
      return '<img src="' + src + '" alt="' + alt + '">';
    });
    t = t.replace(/\[([^\]]+)\]\(([^)\s]+)\)/g, (m, label, url) =>
      '<a href="' + safeUrl(url) + '">' + label + '</a>');
    // 4) 粗体 / 斜体 / 删除线（先强后弱，带边界约束避免误伤乘号等）
    t = t.replace(/\*\*([^*]+)\*\*/g, '<strong>$1</strong>');
    t = t.replace(/__([^_]+)__/g, '<strong>$1</strong>');
    t = t.replace(/(^|[^*\w])\*([^\s*][^*\n]*?)\*(?=$|[^*\w])/g, '$1<em>$2</em>');
    t = t.replace(/(^|[^\w_])_([^\s_][^_\n]*?)_(?=$|[^\w_])/g, '$1<em>$2</em>');
    t = t.replace(/~~([^~]+)~~/g, '<del>$1</del>');
    // 5) 裸 URL 自动链接（跳过已生成的标签内部）
    t = t.replace(/(^|[^"'&=\w\/<>])(https?:\/\/[^\s<>)"'，。；]+)/g, (m, pre, url) =>
      pre + '<a href="' + url + '">' + url + '</a>');
    // 6) 还原行内代码
    t = t.replace(/\u0000(\d+)\u0000/g, (m, i) => '<code>' + escapeHtml(codes[+i]) + '</code>');
    return t;
  }

  // ---------- 块级解析 ----------

  function isTableSep(l) {
    return l.includes('-') && /^\s*\|?[\s:|-]*$/.test(l);
  }

  function isBlockStart(lines, i) {
    const l = lines[i];
    if (/^\s*(```|~~~)/.test(l)) return true;
    if (/^#{1,6}\s+/.test(l)) return true;
    if (/^\s*>/.test(l)) return true;
    if (/^\s*([-*_])(\s*\1){2,}\s*$/.test(l)) return true;
    if (/^\s*([-*+]|\d{1,9}[.)])\s+/.test(l)) return true;
    if (l.includes('|') && i + 1 < lines.length && isTableSep(lines[i + 1])) return true;
    return false;
  }

  function parseBlocks(lines, ctx) {
    const out = [];
    let i = 0;
    const n = lines.length;

    while (i < n) {
      const line = lines[i];

      if (!line.trim()) {
        i++;
        continue;
      }

      // 围栏代码块 ``` / ~~~
      const mFence = line.match(/^\s*(`{3,}|~{3,})\s*([^\s`]*)\s*$/);
      if (mFence) {
        const marker = mFence[1][0];
        const lang = (mFence[2] || '').replace(/[^A-Za-z0-9_+#-]/g, '');
        const buf = [];
        i++;
        const closeRe = new RegExp('^\\s*' + (marker === '`' ? '`{3,}' : '~{3,}') + '\\s*$');
        while (i < n && !closeRe.test(lines[i])) {
          buf.push(lines[i]);
          i++;
        }
        if (i < n) i++; // 跳过结束围栏
        out.push('<pre class="md-code"><code' + (lang ? ' class="language-' + lang + '"' : '') + '>' +
          escapeHtml(buf.join('\n')) + '</code></pre>');
        continue;
      }

      // 分割线
      if (/^\s*([-*_])(\s*\1){2,}\s*$/.test(line)) {
        out.push('<hr>');
        i++;
        continue;
      }

      // 标题
      const mHead = line.match(/^(#{1,6})\s+(.*)$/);
      if (mHead) {
        const level = mHead[1].length;
        const inner = renderInline(mHead[2].replace(/\s+#+\s*$/, '').trim());
        const id = (ctx.idPrefix || 'md-h-') + (ctx.headings.length + 1);
        ctx.headings.push({ id, level, text: stripTags(inner) });
        out.push('<h' + level + ' id="' + id + '">' + inner + '</h' + level + '>');
        i++;
        continue;
      }

      // 引用（连续 > 行；中间空行若后面仍是 > 则合并为同一引用块）
      if (/^\s*>/.test(line)) {
        const buf = [];
        while (i < n) {
          if (/^\s*>/.test(lines[i])) {
            buf.push(lines[i].replace(/^\s*>\s?/, ''));
            i++;
          } else if (!lines[i].trim() && i + 1 < n && /^\s*>/.test(lines[i + 1])) {
            buf.push('');
            i++;
          } else {
            break;
          }
        }
        out.push('<blockquote>' + parseBlocks(buf, ctx) + '</blockquote>');
        continue;
      }

      // 表格（当前行含 |，下一行是分隔行）
      if (line.includes('|') && i + 1 < n && isTableSep(lines[i + 1])) {
        const splitRow = (row) =>
          row.trim().replace(/^\|/, '').replace(/\|$/, '').split('|').map((s) => s.trim());
        const heads = splitRow(line);
        const aligns = splitRow(lines[i + 1]).map((s) => {
          if (/^:-+:$/.test(s)) return 'center';
          if (/^-+:$/.test(s)) return 'right';
          if (/^:-+$/.test(s)) return 'left';
          return '';
        });
        i += 2;
        const rows = [];
        while (i < n && lines[i].trim() && lines[i].includes('|')) {
          rows.push(splitRow(lines[i]));
          i++;
        }
        let html = '<table class="md-table"><thead><tr>';
        heads.forEach((h, c) => {
          html += '<th' + (aligns[c] ? ' class="ta-' + aligns[c] + '"' : '') + '>' + renderInline(h) + '</th>';
        });
        html += '</tr></thead><tbody>';
        rows.forEach((r) => {
          html += '<tr>';
          for (let c = 0; c < heads.length; c++) {
            html += '<td' + (aligns[c] ? ' class="ta-' + aligns[c] + '"' : '') + '>' + renderInline(r[c] || '') + '</td>';
          }
          html += '</tr>';
        });
        html += '</tbody></table>';
        out.push(html);
        continue;
      }

      // 列表（无序 / 有序 / 任务，支持缩进嵌套；顶层有序与无序互不混合）
      const mList = line.match(/^(\s*)([-*+]|\d{1,9}[.)])\s+/);
      if (mList) {
        const baseIndent = mList[1].length;
        const firstOrdered = /\d/.test(mList[2]);
        const raw = [];
        while (i < n) {
          const cur = lines[i];
          if (!cur.trim()) {
            if (i + 1 < n && /^\s*([-*+]|\d{1,9}[.)])\s+/.test(lines[i + 1])) {
              raw.push('');
              i++;
              continue;
            }
            break;
          }
          const mCur = cur.match(/^(\s*)([-*+]|\d{1,9}[.)])\s+/);
          if (mCur) {
            if (mCur[1].length <= baseIndent && /\d/.test(mCur[2]) !== firstOrdered) break;
            raw.push(cur);
          } else {
            const indent = cur.match(/^\s*/)[0].length;
            if (indent <= baseIndent) break;
            raw.push(cur);
          }
          i++;
        }
        out.push(renderListBlock(raw, baseIndent, ctx));
        continue;
      }

      // 段落（行内换行显示为换行）
      const buf = [];
      while (i < n && lines[i].trim() && !isBlockStart(lines, i)) {
        buf.push(lines[i]);
        i++;
      }
      out.push('<p>' + renderInline(buf.join('\n')).replace(/\n/g, '<br>') + '</p>');
    }
    return out.join('\n');
  }

  function renderListBlock(raw, baseIndent, ctx) {
    const items = [];
    let cur = null;
    for (const l of raw) {
      if (!l.trim()) {
        if (cur) cur.body.push('');
        continue;
      }
      const m = l.match(/^(\s*)([-*+]|\d{1,9}[.)])\s+(.*)$/);
      const indent = l.match(/^\s*/)[0].length;
      if (m && indent <= baseIndent) {
        cur = { marker: m[2], text: m[3], body: [] };
        items.push(cur);
      } else if (cur) {
        cur.body.push(l.slice(Math.min(indent, baseIndent + 2)));
      }
    }
    if (!items.length) return '';

    const ordered = /\d/.test(items[0].marker);
    const start = ordered ? parseInt(items[0].marker, 10) : 1;
    const lis = items.map((it) => {
      const mTask = it.text.match(/^\[([ xX])\]\s*(.*)$/);
      let task = false;
      let inner;
      if (mTask) {
        task = true;
        inner = '<input type="checkbox" disabled' +
          (mTask[1].toLowerCase() === 'x' ? ' checked' : '') + '> ' + renderInline(mTask[2]);
      } else {
        inner = renderInline(it.text);
      }
      let bodyHtml = '';
      if (it.body.some((l) => l.trim())) {
        bodyHtml = parseBlocks(it.body, ctx);
      }
      return '<li' + (task ? ' class="md-task"' : '') + '>' + inner + bodyHtml + '</li>';
    });
    const tag = ordered ? 'ol' : 'ul';
    const attr = ordered && start !== 1 ? ' start="' + start + '"' : '';
    return '<' + tag + attr + '>' + lis.join('') + '</' + tag + '>';
  }

  // ---------- 渲染主流程 ----------

  function render() {
    const md = inputEl.value;
    headings = [];
    const html = md.trim()
      ? parseBlocks(md.replace(/\r\n?/g, '\n').split('\n'), { headings })
      : '';
    rawHtml = html;
    readerEl.innerHTML = html;
    readerEl.classList.toggle('hidden', !html);
    emptyEl.classList.toggle('hidden', !!html);
    headingEls = headings.map((h) => document.getElementById(h.id));
    buildToc();
    if (!searchEl.classList.contains('hidden') && searchInput.value.trim()) {
      applySearch(searchInput.value);
    }
    updateProgress();
    updateActiveHeading();
  }

  // ---------- 对外渲染接口 ----------

  // 渲染 Markdown 源码为 HTML（与预览面板同一解析器；供记事本 Markdown 笔记复用）
  // options：{ idPrefix } 自定义标题 id 前缀（避免与预览面板同文档 id 冲突）；
  //           { headings } 传入数组时收集标题信息 [{ id, level, text }]（供笔记内目录使用）
  window.mdRender = function (md, options) {
    const s = String(md == null ? '' : md);
    if (!s.trim()) return '';
    const opts = options || {};
    const ctx = {
      idPrefix: opts.idPrefix || 'md-h-',
      headings: opts.headings || [],
    };
    return parseBlocks(s.replace(/\r\n?/g, '\n').split('\n'), ctx);
  };

  // ---------- 目录（TOC） ----------

  function buildToc() {
    if (!headings.length) {
      tocListEl.innerHTML = '<div class="md-toc-empty">无标题</div>';
      return;
    }
    tocListEl.innerHTML = headings.map((h) =>
      '<button type="button" class="md-toc-item lv' + h.level + '" data-id="' + h.id + '">' +
      escapeHtml(h.text || '未命名标题') + '</button>'
    ).join('');
  }

  tocListEl.addEventListener('click', (e) => {
    const item = e.target && e.target.closest ? e.target.closest('.md-toc-item') : null;
    if (!item) return;
    const el = document.getElementById(item.dataset.id);
    if (el) el.scrollIntoView({ behavior: 'smooth', block: 'start' });
  });

  document.getElementById('md-toc-btn').addEventListener('click', () => {
    tocEl.classList.toggle('hidden');
  });

  // ---------- 进度条 + 目录高亮（滚动联动） ----------

  let scrollTick = false;
  readerWrap.addEventListener('scroll', () => {
    if (scrollTick) return;
    scrollTick = true;
    requestAnimationFrame(() => {
      scrollTick = false;
      updateProgress();
      updateActiveHeading();
    });
  });

  function updateProgress() {
    const max = readerWrap.scrollHeight - readerWrap.clientHeight;
    const p = max > 0 ? Math.min(1, readerWrap.scrollTop / max) : 0;
    progressBar.style.width = (p * 100).toFixed(2) + '%';
  }

  function updateActiveHeading() {
    const items = tocListEl.children;
    if (!headings.length || !items.length) return;
    const top = readerWrap.scrollTop + 80;
    let idx = -1;
    for (let k = 0; k < headingEls.length; k++) {
      const el = headingEls[k];
      if (el && el.offsetTop <= top) idx = k;
      else break;
    }
    for (let k = 0; k < items.length; k++) {
      if (items[k].classList) items[k].classList.toggle('active', k === idx);
    }
  }

  // ---------- 全文搜索（高亮 + 计数 + 上下导航） ----------

  let searchTimer = null;
  let marks = [];
  let markIdx = -1;

  function applySearch(term) {
    readerEl.innerHTML = rawHtml; // 先重建，清除旧高亮
    headingEls = headings.map((h) => document.getElementById(h.id));
    marks = [];
    markIdx = -1;
    const q = String(term).trim();
    if (!q) {
      searchCount.textContent = '';
      return;
    }
    const walker = document.createTreeWalker(readerEl, NodeFilter.SHOW_TEXT, null);
    const textNodes = [];
    while (walker.nextNode()) {
      if (walker.currentNode.nodeValue.trim()) textNodes.push(walker.currentNode);
    }
    const lower = q.toLowerCase();
    for (const node of textNodes) {
      const text = node.nodeValue;
      const tl = text.toLowerCase();
      let idx = tl.indexOf(lower);
      if (idx === -1) continue;
      const frag = document.createDocumentFragment();
      let pos = 0;
      while (idx !== -1) {
        if (idx > pos) frag.appendChild(document.createTextNode(text.slice(pos, idx)));
        const mk = document.createElement('mark');
        mk.className = 'md-mark';
        mk.textContent = text.slice(idx, idx + q.length);
        frag.appendChild(mk);
        marks.push(mk);
        pos = idx + q.length;
        idx = tl.indexOf(lower, pos);
      }
      if (pos < text.length) frag.appendChild(document.createTextNode(text.slice(pos)));
      node.parentNode.replaceChild(frag, node);
    }
    if (!marks.length) {
      searchCount.textContent = '无结果';
      return;
    }
    navTo(0);
  }

  function navTo(idx) {
    if (!marks.length) return;
    if (markIdx >= 0 && marks[markIdx]) marks[markIdx].classList.remove('current');
    markIdx = ((idx % marks.length) + marks.length) % marks.length;
    const mk = marks[markIdx];
    mk.classList.add('current');
    mk.scrollIntoView({ block: 'center' });
    searchCount.textContent = (markIdx + 1) + '/' + marks.length;
    syncSource(mk);
  }

  // ---------- 源文件联动（v0.25.0）：切换命中时左侧源文件同步滚动到对应位置 ----------

  // 勾选框状态（与记事本 Markdown 笔记共用同一项；默认开启）
  const SYNC_KEY = 'simpletools-md-search-sync';
  let searchSync = true;
  try { searchSync = localStorage.getItem(SYNC_KEY) !== '0'; } catch (e) { /* ignore */ }
  searchSyncEl.checked = searchSync;

  searchSyncEl.addEventListener('change', () => {
    searchSync = searchSyncEl.checked;
    try { localStorage.setItem(SYNC_KEY, searchSync ? '1' : '0'); } catch (e) { /* ignore */ }
  });

  // 在文本中查找关键字的第 n 个匹配（大小写不敏感；数量不足时循环取模），返回字符索引，未找到返回 -1
  function findNthMatch(text, q, n) {
    const lower = String(text).toLowerCase();
    const k = String(q).toLowerCase();
    if (!k) return -1;
    const all = [];
    let i = lower.indexOf(k);
    while (i !== -1) {
      all.push(i);
      i = lower.indexOf(k, i + k.length);
    }
    if (!all.length) return -1;
    return all[((n % all.length) + all.length) % all.length];
  }

  // 把 textarea 滚动到指定字符位置（镜像测量：用同款式隐藏 div 定位命中处的高度）
  function scrollTextareaTo(ta, index) {
    if (!ta || index < 0) return;
    const cs = getComputedStyle(ta);
    const mirror = document.createElement('div');
    try {
      const copy = ['fontFamily', 'fontSize', 'fontWeight', 'fontStyle', 'letterSpacing',
        'lineHeight', 'textTransform', 'textIndent', 'paddingTop', 'paddingRight',
        'paddingBottom', 'paddingLeft', 'whiteSpace', 'wordBreak', 'overflowWrap'];
      copy.forEach((p) => { mirror.style[p] = cs[p]; });
      mirror.style.position = 'absolute';
      mirror.style.visibility = 'hidden';
      mirror.style.left = '-9999px';
      mirror.style.top = '0';
      mirror.style.width = ta.clientWidth + 'px';
      mirror.textContent = ta.value.slice(0, index);
      const marker = document.createElement('span');
      marker.textContent = '\u200b';
      mirror.appendChild(marker);
      document.body.appendChild(mirror);
      const markerTop = marker.getBoundingClientRect().top - mirror.getBoundingClientRect().top;
      const lineH = parseFloat(cs.lineHeight) || (parseFloat(cs.fontSize) || 13) * 1.5;
      const max = ta.scrollHeight - ta.clientHeight;
      ta.scrollTop = Math.max(0, Math.min(max, markerTop - ta.clientHeight / 2 + lineH / 2));
    } catch (e) { /* 测量失败时保持原滚动位置 */ } finally {
      mirror.remove();
    }
  }

  // 供记事本 Markdown 笔记复用
  window.mdScrollTextareaTo = scrollTextareaTo;
  window.mdFindNthMatch = findNthMatch;

  function syncSource(mk) {
    if (!searchSync || !mk || markIdx < 0) return;
    const q = searchInput.value.trim();
    if (!q) return;
    const idx = findNthMatch(inputEl.value, q, markIdx);
    if (idx >= 0) scrollTextareaTo(inputEl, idx);
  }

  function closeSearch() {
    searchEl.classList.add('hidden');
    searchInput.value = '';
    searchCount.textContent = '';
    if (marks.length) {
      marks = [];
      markIdx = -1;
      readerEl.innerHTML = rawHtml; // 清除高亮
      headingEls = headings.map((h) => document.getElementById(h.id));
    }
  }

  document.getElementById('md-search-btn').addEventListener('click', () => {
    if (searchEl.classList.contains('hidden')) {
      searchEl.classList.remove('hidden');
      searchInput.focus();
      searchInput.select();
    } else {
      closeSearch();
    }
  });

  searchInput.addEventListener('input', () => {
    clearTimeout(searchTimer);
    searchTimer = setTimeout(() => applySearch(searchInput.value), SEARCH_DEBOUNCE);
  });

  searchInput.addEventListener('keydown', (e) => {
    if (e.key === 'Enter') {
      e.preventDefault();
      if (!marks.length) applySearch(searchInput.value);
      else navTo(markIdx + (e.shiftKey ? -1 : 1));
    } else if (e.key === 'Escape') {
      e.preventDefault();
      closeSearch();
    }
  });

  document.getElementById('md-search-prev').addEventListener('click', () => navTo(markIdx - 1));
  document.getElementById('md-search-next').addEventListener('click', () => navTo(markIdx + 1));
  document.getElementById('md-search-close').addEventListener('click', closeSearch);

  // ---------- 字号 / 阅读宽度 ----------

  const FONT_KEY = 'simpletools-md-font';
  const WIDTH_KEY = 'simpletools-md-width';
  const FONT_MIN = 13;
  const FONT_MAX = 20;
  const WIDTHS = { narrow: 560, normal: 760, wide: 1100 };

  let fontSize = parseInt(localStorage.getItem(FONT_KEY), 10);
  if (isNaN(fontSize)) fontSize = 16;
  fontSize = Math.max(FONT_MIN, Math.min(FONT_MAX, fontSize));

  let mdWidth = localStorage.getItem(WIDTH_KEY) || 'normal';
  if (!WIDTHS[mdWidth]) mdWidth = 'normal';

  function applyFont() {
    readerEl.style.fontSize = fontSize + 'px';
    fontLabel.textContent = String(fontSize);
    try { localStorage.setItem(FONT_KEY, String(fontSize)); } catch (e) { /* ignore */ }
    updateActiveHeading();
  }

  function applyWidth() {
    readerEl.style.setProperty('--md-w', WIDTHS[mdWidth] + 'px');
    document.querySelectorAll('.md-width-btn').forEach((b) => {
      b.classList.toggle('active', b.dataset.width === mdWidth);
    });
    try { localStorage.setItem(WIDTH_KEY, mdWidth); } catch (e) { /* ignore */ }
  }

  document.getElementById('md-font-dec').addEventListener('click', () => {
    if (fontSize > FONT_MIN) {
      fontSize--;
      applyFont();
    }
  });

  document.getElementById('md-font-inc').addEventListener('click', () => {
    if (fontSize < FONT_MAX) {
      fontSize++;
      applyFont();
    }
  });

  document.querySelectorAll('.md-width-btn').forEach((b) => {
    b.addEventListener('click', () => {
      mdWidth = b.dataset.width;
      applyWidth();
    });
  });

  // ---------- 打开文件 / 拖入 ----------

  async function openFile(path) {
    if (!path) return;
    if (!invoke) {
      window.toast('Tauri 接口不可用（请通过应用运行）');
      return;
    }
    try {
      const r = await invoke('read_text_file', { path });
      inputEl.value = r.content || '';
      docNameEl.textContent = r.name || '未命名';
      docDir = String(path).replace(/[\\/][^\\/]*$/, '');
      docPath = String(path);
      render();
      window.toast('已打开 ' + (r.name || path));
    } catch (e) {
      window.toast('打开失败：' + e);
    }
  }

  document.getElementById('md-open').addEventListener('click', async () => {
    if (!dialogApi || !dialogApi.open) {
      window.toast('Tauri 接口不可用（请通过应用运行）');
      return;
    }
    try {
      const selected = await dialogApi.open({
        multiple: false,
        title: '选择 Markdown 文件',
        filters: [{ name: 'Markdown / 文本', extensions: ['md', 'markdown', 'txt'] }],
      });
      if (!selected) return;
      const path = typeof selected === 'string'
        ? selected
        : (selected && selected.path) || (Array.isArray(selected) ? selected[0] : null);
      if (path) openFile(path);
    } catch (e) {
      window.toast('打开文件选择器失败：' + e);
    }
  });

  function panelActive() {
    return panelEl.classList.contains('active');
  }

  // OS 文件拖入（Tauri 原生拖放事件；仅在面板激活时响应）
  if (eventApi && eventApi.listen) {
    eventApi.listen('tauri://drag-enter', () => {
      if (panelActive()) panelEl.classList.add('md-drag');
    });
    eventApi.listen('tauri://drag-leave', () => panelEl.classList.remove('md-drag'));
    eventApi.listen('tauri://drag-drop', (e) => {
      panelEl.classList.remove('md-drag');
      if (!panelActive()) return;
      const paths = e && e.payload && e.payload.paths;
      if (paths && paths.length) openFile(paths[0]);
      else window.toast('未检测到文件路径');
    });
  }

  // ---------- 清空 / 复制 ----------

  document.getElementById('md-clear').addEventListener('click', () => {
    inputEl.value = '';
    docNameEl.textContent = '未命名';
    docDir = '';
    docPath = '';
    render();
    inputEl.focus();
  });

  // ---------- 保存（已有路径直接覆写；无路径弹另存为） ----------

  async function saveFile() {
    if (!invoke) {
      window.toast('Tauri 接口不可用（请通过应用运行）');
      return;
    }
    const content = inputEl.value;
    if (!content) {
      window.toast('暂无可保存的内容');
      return;
    }
    let path = docPath;
    if (!path) {
      if (!dialogApi || !dialogApi.save) {
        window.toast('Tauri 接口不可用（请通过应用运行）');
        return;
      }
      try {
        path = await dialogApi.save({
          title: '保存 Markdown 文件',
          defaultPath: (docNameEl.textContent || '未命名') + '.md',
          filters: [{ name: 'Markdown / 文本', extensions: ['md', 'markdown', 'txt'] }],
        });
      } catch (e) {
        window.toast('保存文件选择器失败：' + e);
        return;
      }
      if (!path) return; // 用户取消
    }
    try {
      const name = await invoke('write_text_file', { path, content });
      docPath = path;
      docDir = String(path).replace(/[\\/][^\\/]*$/, '');
      docNameEl.textContent = name || '未命名';
      window.toast('已保存到 ' + (name || path));
    } catch (e) {
      window.toast('保存失败：' + e);
    }
  }

  document.getElementById('md-save').addEventListener('click', saveFile);

  // Ctrl+S 快捷保存
  inputEl.addEventListener('keydown', (e) => {
    if ((e.ctrlKey || e.metaKey) && e.key.toLowerCase() === 's') {
      e.preventDefault();
      saveFile();
    }
  });

  document.getElementById('md-copy-src').addEventListener('click', () => {
    if (!inputEl.value) {
      window.toast('暂无可复制的内容');
      return;
    }
    window.copyText(inputEl.value, '已复制 Markdown 源码');
  });

  document.getElementById('md-copy-html').addEventListener('click', () => {
    if (!rawHtml) {
      window.toast('暂无渲染内容');
      return;
    }
    window.copyText(rawHtml, '已复制渲染 HTML');
  });

  // 图片加载失败 → 占位样式（error 事件不冒泡，需捕获阶段监听）
  readerEl.addEventListener('error', (e) => {
    const el = e.target;
    if (el && el.tagName === 'IMG') el.classList.add('md-img-failed');
  }, true);

  // 渲染结果中的链接点击：不跳转（避免 WebView 导航），改为复制链接
  readerEl.addEventListener('click', (e) => {
    const a = e.target && e.target.closest ? e.target.closest('a[href]') : null;
    if (!a) return;
    e.preventDefault();
    const href = a.getAttribute('href') || '';
    if (href && href !== '#') {
      window.copyText(href, '链接已复制');
    } else {
      window.toast('该链接无法打开');
    }
  });

  // ---------- 输入联动 ----------

  inputEl.addEventListener('input', () => {
    clearTimeout(renderTimer);
    renderTimer = setTimeout(render, RENDER_DEBOUNCE);
  });

  // ---------- 初始化 ----------

  applyFont();
  applyWidth();
  render();
})();
