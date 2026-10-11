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

  const RENDER_DEBOUNCE = 120;
  const SEARCH_DEBOUNCE = 280;

  let rawHtml = '';      // 渲染后的原始 HTML（搜索重建 / 复制 HTML 用）
  let headings = [];     // [{ id, level, text }]
  let headingEls = [];   // 标题对应的 DOM 元素（目录高亮用）
  let renderTimer = null;

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

  // 链接 / 图片地址过滤：屏蔽危险协议
  function safeUrl(u) {
    const s = String(u).trim();
    if (/^(javascript|vbscript|file|data):/i.test(s)) return '#';
    return s;
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
    t = t.replace(/!\[([^\]]*)\]\(([^)\s]+)\)/g, (m, alt, url) =>
      '<img src="' + safeUrl(url) + '" alt="' + alt + '">');
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
        const id = 'md-h-' + (ctx.headings.length + 1);
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
    render();
    inputEl.focus();
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
