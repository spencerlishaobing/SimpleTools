/* ===== 记事本模块（本地缓存 + 拖动排序） ===== */
(function () {
  'use strict';

  const invoke = (window.__TAURI__ && window.__TAURI__.core && window.__TAURI__.core.invoke) || null;
  const dialogApi = (window.__TAURI__ && window.__TAURI__.dialog) || null;

  const listEl = document.getElementById('notes-list');
  const emptyEl = document.getElementById('notes-empty');
  const editorEl = document.getElementById('notes-editor');
  const titleEl = document.getElementById('note-title');
  const contentEl = document.getElementById('note-content');
  const statusEl = document.getElementById('note-status');
  const metaEl = document.getElementById('note-meta');
  const toolbarEl = document.querySelector('.notes-toolbar');
  const sideEl = document.querySelector('.notes-side');
  const multiBtn = document.getElementById('note-multi');
  const multiBar = document.getElementById('notes-multi-bar');
  const multiCountEl = document.getElementById('notes-multi-count');
  const selAllBtn = document.getElementById('notes-selall');
  const delSelBtn = document.getElementById('notes-delsel');
  const multiExitBtn = document.getElementById('notes-multi-exit');
  const exportSelBtn = document.getElementById('notes-exportsel');
  const searchEl = document.getElementById('notes-search');
  const searchClearEl = document.getElementById('notes-search-clear');
  const searchModeEl = document.getElementById('notes-search-mode');
  const searchModeLabelEl = document.getElementById('notes-search-mode-label');
  const bodyWrapEl = document.getElementById('note-body-wrap');
  const noteMdRenderEl = document.getElementById('note-md-render');
  const noteMdScrollEl = document.getElementById('note-md-scroll');
  const noteMdTocEl = document.getElementById('note-md-toc');
  const noteMdTocListEl = document.getElementById('note-md-toc-list');
  const noteMdTocBtn = document.getElementById('note-md-toc-btn');
  const noteMdSearchBtn = document.getElementById('note-md-search-btn');
  const noteMdSearchEl = document.getElementById('note-md-search');
  const noteMdSearchInput = document.getElementById('note-md-search-input');
  const noteMdSearchCount = document.getElementById('note-md-search-count');
  const noteMdSearchSyncEl = document.getElementById('note-md-search-sync');
  const taskWrapEl = document.getElementById('note-task-wrap');
  const taskListEl = document.getElementById('task-list');
  const taskEmptyEl = document.getElementById('task-empty');
  const taskCountEl = document.getElementById('task-count');
  const taskAutoNoEl = document.getElementById('task-auto-no');
  const taskDetailEl = document.getElementById('task-detail');
  const taskDetailTitleEl = document.getElementById('task-detail-title');
  const taskRichEditorEl = document.getElementById('task-rich-editor');
  const noteRichEditorEl = document.getElementById('note-rich-editor');

  const state = {
    // [{ id, title, content, type: 'text' | 'md' | 'task', rich, tasks, auto_no, updated_at }]
    //   type='text' 普通笔记：content 为富文本 HTML（v0.34.0 起；旧版纯文本加载时自动转换，rich 标记内容格式）
    //   type='task' 任务笔记：tasks 为任务列表（简单 / 富文本任务），auto_no 是否启用自动序号
    notes: [],
    currentId: null,
    filter: '',     // 搜索关键字（过滤列表显示）
    searchMode: 'title',  // 搜索范围：'title' 标题（默认）/ 'content' 内容（模糊）
  };

  const multi = { active: false, selected: new Set() };  // 批量操作（多选）模式

  const SAVE_DELAY = 500;
  let saveTimer = null;
  let saving = false;
  // 数据加载完成前（含加载失败）禁止落盘：blur 立即保存用于防丢数据，
  // 但加载阶段的失焦（如自动化焦点抖动）会把尚未加载的空数组覆盖写盘
  let loaded = false;

  // ---------- 工具 ----------

  // 类型图标（线性 24 viewBox）：普通笔记（文档）/ Markdown（M↓ 徽标）
  const ICON_ATTRS = 'viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" ' +
    'stroke-linecap="round" stroke-linejoin="round" aria-hidden="true"';
  const ICON_TEXT = '<svg class="note-type-icon" ' + ICON_ATTRS + '>' +
    '<path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"/>' +
    '<polyline points="14 2 14 8 20 8"/>' +
    '<line x1="16" y1="13" x2="8" y2="13"/>' +
    '<line x1="16" y1="17" x2="8" y2="17"/>' +
    '<polyline points="10 9 9 9 8 9"/></svg>';
  const ICON_MD = '<svg class="note-type-icon is-md" ' + ICON_ATTRS + '>' +
    '<rect x="3" y="3" width="18" height="18" rx="4.5"/>' +
    '<path d="M7 15.5V8.5l3 3 3-3v7"/>' +
    '<path d="M17 8.5v6.5m0 0l-2-2m2 2l2-2"/></svg>';
  const ICON_TASK = '<svg class="note-type-icon is-task" ' + ICON_ATTRS + '>' +
    '<rect x="3" y="4" width="18" height="16" rx="3"/>' +
    '<polyline points="7.5 12.5 10.5 15.5 16 9.5"/></svg>';

  function noteIcon(type) {
    if (type === 'md') return ICON_MD;
    if (type === 'task') return ICON_TASK;
    return ICON_TEXT;
  }

  const ESC_MAP = { '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;', "'": '&#39;' };
  function esc(s) {
    return String(s).replace(/[&<>"']/g, (c) => ESC_MAP[c]);
  }

  // 命中高亮：把 text 中所有匹配 keyword 的片段（大小写不敏感）包裹为 <mark> 后返回安全 HTML
  // 注意：必须先分段再逐段转义，不能先转义后匹配（转义会改变命中位置）
  function hlHtml(text, keyword) {
    const s = String(text == null ? '' : text);
    const kw = String(keyword || '');
    if (!kw) return esc(s);
    const lower = s.toLowerCase();
    const k = kw.toLowerCase();
    let out = '';
    let i = 0;
    while (i < s.length) {
      const idx = lower.indexOf(k, i);
      if (idx < 0) {
        out += esc(s.slice(i));
        break;
      }
      out += esc(s.slice(i, idx)) + '<mark class="note-hl">' + esc(s.slice(idx, idx + k.length)) + '</mark>';
      i = idx + k.length;
    }
    return out;
  }

  // 内容摘要：折叠空白后取首个命中位置的前后上下文（供内容搜索时列表展示）
  function pickSnippet(text, keyword) {
    const s = String(text == null ? '' : text).replace(/\s+/g, ' ').trim();
    const kw = String(keyword || '');
    if (!s || !kw) return '';
    const idx = s.toLowerCase().indexOf(kw.toLowerCase());
    if (idx < 0) return '';
    const start = Math.max(0, idx - 12);
    const end = Math.min(s.length, idx + kw.length + 24);
    return (start > 0 ? '…' : '') + s.slice(start, end) + (end < s.length ? '…' : '');
  }

  function genId() {
    if (window.crypto && crypto.randomUUID) return crypto.randomUUID();
    return 'n-' + Date.now() + '-' + Math.random().toString(16).slice(2);
  }

  // ---------- 数据目录缓存（富文本图片相对路径解析用，v0.33.0） ----------
  // 图片以相对路径（images/xxx.png）存在数据目录的 images/ 文件夹；显示时需拼出绝对路径。
  // 数据目录切换（data_dir_set）后会整页重载，缓存无需失效逻辑
  let dataDirCache = '';
  let dataDirPromise = null;

  function ensureDataDir() {
    if (dataDirCache || !invoke) return Promise.resolve(dataDirCache);
    if (!dataDirPromise) {
      dataDirPromise = invoke('data_dir_info')
        .then((info) => {
          dataDirCache = (info && info.current) || '';
          return dataDirCache;
        })
        .catch(() => {
          dataDirPromise = null; // 失败允许下次重试
          return '';
        });
    }
    return dataDirPromise;
  }

  // 图片引用是否为相对路径（非绝对路径 / 网络 / 内嵌）
  function isRelativeImgRef(ref) {
    const s = String(ref || '');
    return !!s && !/^(https?|data):/i.test(s) &&
      !/^[a-zA-Z]:[\\/]/.test(s) && !/^\\\\/.test(s) && !/^\//.test(s);
  }

  // 图片引用 → 本地绝对路径：绝对路径原样返回；相对路径基于数据目录拼接（数据目录未知时返回空串）
  function imgAbsPath(ref) {
    const s = String(ref || '');
    if (!s) return '';
    if (!isRelativeImgRef(s)) return s;
    if (!dataDirCache) return '';
    return dataDirCache.replace(/[\\/]+$/, '') + '\\' + s.replace(/\//g, '\\');
  }

  function formatTime(ts) {
    const d = new Date(ts);
    const pad = (x) => String(x).padStart(2, '0');
    return d.getFullYear() + '-' + pad(d.getMonth() + 1) + '-' + pad(d.getDate()) +
      ' ' + pad(d.getHours()) + ':' + pad(d.getMinutes());
  }

  function timeNow() {
    const d = new Date();
    const pad = (x) => String(x).padStart(2, '0');
    return pad(d.getHours()) + ':' + pad(d.getMinutes()) + ':' + pad(d.getSeconds());
  }

  function setSaveStatus(cls, text) {
    statusEl.className = 'save-status' + (cls ? ' ' + cls : '');
    statusEl.textContent = text;
  }

  function getCurrent() {
    return state.notes.find((n) => n.id === state.currentId) || null;
  }

  // ---------- 持久化 ----------

  function scheduleSave() {
    setSaveStatus('saving', '正在保存...');
    clearTimeout(saveTimer);
    saveTimer = setTimeout(doSave, SAVE_DELAY);
  }

  async function doSave(now) {
    if (now) clearTimeout(saveTimer);
    if (!invoke || saving || !loaded) return;
    saving = true;
    try {
      await invoke('notes_save', { notes: state.notes });
      setSaveStatus('saved', '已保存 ' + timeNow());
    } catch (e) {
      setSaveStatus('', '保存失败：' + e);
    } finally {
      saving = false;
    }
  }

  // ---------- 渲染 ----------

  function renderList() {
    // 搜索过滤：按当前范围（标题 / 内容）仅显示匹配记录（过滤状态下禁用拖动排序）
    // 内容模式下任务笔记按任务级命中（简单任务文本 / 富文本标题 / 富文本内容）匹配
    const raw = state.filter.trim();
    const kw = raw.toLowerCase();
    const isContent = state.searchMode === 'content';
    const visible = kw
      ? state.notes.filter((n) => {
        if (isContent && n.type === 'task') return taskHits(n, kw).length > 0;
        // 普通笔记内容为富文本 HTML，匹配前先转纯文本（v0.34.0）
        const src = isContent ? (n.type === 'text' ? htmlToText(n.content) : (n.content || '')) : (n.title || '');
        return src.toLowerCase().indexOf(kw) >= 0;
      })
      : state.notes;
    listEl.innerHTML = '';
    for (const n of visible) {
      const selected = multi.active && multi.selected.has(n.id);
      const li = document.createElement('li');
      li.className = 'note-item' + (n.id === state.currentId ? ' active' : '') +
        (selected ? ' selected' : '');
      li.dataset.id = n.id;
      li.draggable = !multi.active && !kw;
      // 搜索时：标题命中片段高亮；内容模式额外展示命中摘要行（任务笔记改为命中任务行）
      const titleHtml = kw ? hlHtml(n.title || '未命名', raw) : esc(n.title || '未命名');
      const snippet = kw && isContent && n.type !== 'task'
        ? pickSnippet(n.type === 'text' ? htmlToText(n.content) : n.content, raw) : '';
      let hitsHtml = '';
      if (kw && isContent && n.type === 'task' && !multi.active) {
        hitsHtml = taskHits(n, kw).map((h) => {
          if (h.kind === 'content') {
            // 富文本内容命中：只显示标题 + 「内容匹配」标记，点击进入详情并高亮命中词
            return '<div class="note-task-hit" data-task-id="' + h.taskId + '" data-hit="content" title="点击进入富文本详情">' +
              '<span class="task-hit-name">' + esc(h.task.title || '未命名任务') + '</span>' +
              '<span class="task-hit-badge">内容匹配</span></div>';
          }
          const label = h.kind === 'title' ? (h.task.title || '未命名任务') : h.task.text;
          return '<div class="note-task-hit" data-task-id="' + h.taskId + '" data-hit="' + h.kind + '" title="点击查看任务">' +
            '<span class="task-hit-name">' + hlHtml(label, raw) + '</span>' +
            (h.kind === 'title' ? '<span class="task-hit-badge is-rich">富文本</span>' : '') + '</div>';
        }).join('');
      }
      li.innerHTML =
        (multi.active ? '<span class="note-check">' + (selected ? '✓' : '') + '</span>' : '') +
        '<div class="note-item-title">' + noteIcon(n.type) +
        '<span class="note-item-name">' + titleHtml + '</span></div>' +
        (snippet ? '<div class="note-item-snippet">' + hlHtml(snippet, raw) + '</div>' : '') +
        (hitsHtml ? '<div class="note-item-hits">' + hitsHtml + '</div>' : '') +
        '<div class="note-item-meta">' + formatTime(n.updated_at) + '</div>' +
        '<button class="note-item-remove" title="删除该记录">' +
        '<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" ' +
        'stroke-linecap="round" stroke-linejoin="round">' +
        '<polyline points="3 6 5 6 21 6"/>' +
        '<path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"/>' +
        '<line x1="10" y1="11" x2="10" y2="17"/>' +
        '<line x1="14" y1="11" x2="14" y2="17"/>' +
        '</svg></button>';
      li.addEventListener('click', () => {
        if (multi.active) toggleSelect(n.id);
        else selectNote(n.id);
      });
      li.querySelector('.note-item-remove').addEventListener('click', (e) => {
        e.stopPropagation();
        removeNote(n.id);
      });
      // 命中任务行：点击进入任务组定位 / 打开富文本详情
      li.querySelectorAll('.note-task-hit').forEach((el) => {
        el.addEventListener('click', (e) => {
          e.stopPropagation();
          if (!multi.active) openTaskHit(n.id, el.dataset.taskId, el.dataset.hit, raw);
        });
      });
      listEl.appendChild(li);
    }
    if (!state.notes.length) {
      emptyEl.textContent = '暂无记录，点击"新建记录"开始';
      emptyEl.style.display = 'block';
    } else if (!visible.length) {
      emptyEl.textContent = '没有匹配「' + state.filter.trim() + '」的记录';
      emptyEl.style.display = 'block';
    } else {
      emptyEl.style.display = 'none';
    }
    updateMultiUI();
  }

  function selectNote(id) {
    const note = state.notes.find((n) => n.id === id);
    if (!note) return;
    if (id !== state.currentId && taskDetailId) syncTaskRichContent(); // 离开前落盘未保存的富文本编辑
    state.currentId = id;
    titleEl.value = note.title;
    contentEl.value = note.type === 'md' ? note.content : ''; // 普通笔记内容走富文本编辑器（见 setEditorMode）
    metaEl.textContent = '最后更新:' + formatTime(note.updated_at);
    editorEl.classList.remove('hidden');
    setEditorMode(note.type);
    renderList();
  }

  // 编辑器模式：普通笔记富文本单栏（v0.34.0）/ Markdown 笔记左编辑右实时预览 / 任务笔记任务组
  let mdPreviewTimer = null;

  // ---------- Markdown 笔记：预览渲染 + 目录 + 全文搜索（v0.25.0，移植自 Markdown 预览面板） ----------

  const NOTE_MD_EMPTY = '<div class="note-md-empty">输入 Markdown 内容，此处实时渲染预览</div>';
  let noteHeadings = [];     // 当前笔记的标题 [{ id, level, text }]（目录用）
  let noteHeadingEls = [];   // 标题对应 DOM 元素（目录高亮用）
  let noteRawHtml = '';      // 渲染后的原始 HTML（搜索重建 / 清除高亮用）

  // Markdown 笔记预览：复用 Markdown 预览面板的解析器（window.mdRender）；
  // 标题 id 加 note- 前缀，避免与预览面板的 md-h-* 在同文档内冲突
  function renderMdPreview() {
    if (!bodyWrapEl.classList.contains('is-md')) return;
    noteHeadings = [];
    const html = (typeof window.mdRender === 'function')
      ? window.mdRender(contentEl.value, { idPrefix: 'note-md-h-', headings: noteHeadings })
      : '';
    noteRawHtml = html;
    noteMdRenderEl.innerHTML = html || NOTE_MD_EMPTY;
    noteHeadingEls = noteHeadings.map((h) => document.getElementById(h.id));
    buildNoteToc();
    // 搜索进行中：重建后重新高亮
    if (!noteMdSearchEl.classList.contains('hidden') && noteMdSearchInput.value.trim()) {
      applyNoteSearch(noteMdSearchInput.value);
    }
    updateNoteActiveHeading();
  }

  function setEditorMode(type) {
    const isMd = type === 'md';
    const isTask = type === 'task';
    const isRich = !isMd && !isTask; // 普通笔记：富文本编辑器（v0.34.0）
    bodyWrapEl.classList.toggle('is-md', isMd);
    bodyWrapEl.classList.toggle('is-task', isTask);
    bodyWrapEl.classList.toggle('is-rich', isRich);
    clearTimeout(mdPreviewTimer);
    // 切换笔记 / 模式时回到任务组列表视图
    taskDetailId = null;
    taskHighlightTerm = '';
    taskDetailEl.classList.add('hidden');
    taskWrapEl.classList.remove('hidden');
    if (isMd) renderMdPreview();
    if (isTask) renderTaskList();
    if (isRich) renderNoteRich();
  }

  // ---- 目录 ----

  function buildNoteToc() {
    if (!noteHeadings.length) {
      noteMdTocListEl.innerHTML = '<div class="md-toc-empty">无标题</div>';
      return;
    }
    noteMdTocListEl.innerHTML = noteHeadings.map((h) =>
      '<button type="button" class="md-toc-item lv' + h.level + '" data-id="' + h.id + '">' +
      esc(h.text || '未命名标题') + '</button>'
    ).join('');
  }

  noteMdTocListEl.addEventListener('click', (e) => {
    const item = e.target && e.target.closest ? e.target.closest('.md-toc-item') : null;
    if (!item) return;
    const el = document.getElementById(item.dataset.id);
    if (el) el.scrollIntoView({ behavior: 'smooth', block: 'start' });
  });

  noteMdTocBtn.addEventListener('click', () => {
    noteMdTocEl.classList.toggle('hidden');
  });

  // 目录高亮：预览滚动时标记当前所在章节
  let noteTocTick = false;
  noteMdScrollEl.addEventListener('scroll', () => {
    if (noteTocTick) return;
    noteTocTick = true;
    requestAnimationFrame(() => {
      noteTocTick = false;
      updateNoteActiveHeading();
    });
  });

  function updateNoteActiveHeading() {
    const items = noteMdTocListEl.children;
    if (!noteHeadings.length || !items.length) return;
    const base = noteMdScrollEl.offsetTop;
    const top = noteMdScrollEl.scrollTop + 80;
    let idx = -1;
    for (let k = 0; k < noteHeadingEls.length; k++) {
      const el = noteHeadingEls[k];
      if (el && el.offsetTop - base <= top) idx = k;
      else break;
    }
    for (let k = 0; k < items.length; k++) {
      if (items[k].classList) items[k].classList.toggle('active', k === idx);
    }
  }

  // ---- 全文搜索（高亮 + 计数 + 上下导航 + 源文件联动） ----

  let noteSearchTimer = null;
  let noteMarks = [];
  let noteMarkIdx = -1;

  // 勾选框状态（与 Markdown 预览面板共用同一项；默认开启）
  let noteSyncSrc = true;
  try { noteSyncSrc = localStorage.getItem('simpletools-md-search-sync') !== '0'; } catch (e) { /* ignore */ }
  noteMdSearchSyncEl.checked = noteSyncSrc;

  noteMdSearchSyncEl.addEventListener('change', () => {
    noteSyncSrc = noteMdSearchSyncEl.checked;
    try { localStorage.setItem('simpletools-md-search-sync', noteSyncSrc ? '1' : '0'); } catch (e) { /* ignore */ }
  });

  function applyNoteSearch(term) {
    noteMdRenderEl.innerHTML = noteRawHtml || NOTE_MD_EMPTY; // 先重建，清除旧高亮
    noteHeadingEls = noteHeadings.map((h) => document.getElementById(h.id));
    noteMarks = [];
    noteMarkIdx = -1;
    const q = String(term).trim();
    if (!q) {
      noteMdSearchCount.textContent = '';
      return;
    }
    const walker = document.createTreeWalker(noteMdRenderEl, NodeFilter.SHOW_TEXT, null);
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
        noteMarks.push(mk);
        pos = idx + q.length;
        idx = tl.indexOf(lower, pos);
      }
      if (pos < text.length) frag.appendChild(document.createTextNode(text.slice(pos)));
      node.parentNode.replaceChild(frag, node);
    }
    if (!noteMarks.length) {
      noteMdSearchCount.textContent = '无结果';
      return;
    }
    noteNavTo(0);
  }

  function noteNavTo(idx) {
    if (!noteMarks.length) return;
    if (noteMarkIdx >= 0 && noteMarks[noteMarkIdx]) noteMarks[noteMarkIdx].classList.remove('current');
    noteMarkIdx = ((idx % noteMarks.length) + noteMarks.length) % noteMarks.length;
    const mk = noteMarks[noteMarkIdx];
    mk.classList.add('current');
    mk.scrollIntoView({ block: 'center' });
    noteMdSearchCount.textContent = (noteMarkIdx + 1) + '/' + noteMarks.length;
    syncNoteSource(mk);
  }

  // 源文件联动：切换命中时左侧源文件同步滚动到对应位置（镜像测量复用预览面板实现）
  function syncNoteSource(mk) {
    if (!noteSyncSrc || !mk || noteMarkIdx < 0) return;
    const q = noteMdSearchInput.value.trim();
    if (!q) return;
    if (typeof window.mdFindNthMatch !== 'function' || typeof window.mdScrollTextareaTo !== 'function') return;
    const idx = window.mdFindNthMatch(contentEl.value, q, noteMarkIdx);
    if (idx >= 0) window.mdScrollTextareaTo(contentEl, idx);
  }

  function openNoteSearch() {
    noteMdSearchEl.classList.remove('hidden');
    noteMdSearchInput.focus();
    noteMdSearchInput.select();
  }

  function closeNoteSearch() {
    noteMdSearchEl.classList.add('hidden');
    noteMdSearchInput.value = '';
    noteMdSearchCount.textContent = '';
    if (noteMarks.length) {
      noteMarks = [];
      noteMarkIdx = -1;
      noteMdRenderEl.innerHTML = noteRawHtml || NOTE_MD_EMPTY; // 清除高亮
      noteHeadingEls = noteHeadings.map((h) => document.getElementById(h.id));
    }
  }

  noteMdSearchBtn.addEventListener('click', () => {
    if (noteMdSearchEl.classList.contains('hidden')) openNoteSearch();
    else closeNoteSearch();
  });

  noteMdSearchInput.addEventListener('input', () => {
    clearTimeout(noteSearchTimer);
    noteSearchTimer = setTimeout(() => applyNoteSearch(noteMdSearchInput.value), 280);
  });

  document.getElementById('note-md-search-prev').addEventListener('click', () => noteNavTo(noteMarkIdx - 1));
  document.getElementById('note-md-search-next').addEventListener('click', () => noteNavTo(noteMarkIdx + 1));
  document.getElementById('note-md-search-close').addEventListener('click', closeNoteSearch);

  // ---------- 任务笔记（v0.28.0：任务组 + 简单 / 富文本任务 + 完成状态 + 自动序号） ----------

  let taskDetailId = null;      // 当前打开的富文本任务 id（null = 停留任务组列表视图）
  let taskHighlightTerm = '';   // 搜索命中富文本内容后进入详情时的高亮词（仅展示用，不落盘）

  // 富文本内容白名单：仅保留编辑器产生的行内 / 列表 / 图片标签，其余标签解包为文本
  const RICH_TAG_WHITELIST = {
    B: 1, STRONG: 1, I: 1, EM: 1, U: 1, S: 1, DEL: 1,
    UL: 1, OL: 1, LI: 1, BR: 1, DIV: 1, P: 1, IMG: 1,
  };
  const RICH_DROP_TAGS = {
    SCRIPT: 1, STYLE: 1, IFRAME: 1, OBJECT: 1, EMBED: 1,
    LINK: 1, META: 1, SVG: 1, MATH: 1, TEMPLATE: 1,
  };

  function sanitizeRichHtml(html) {
    const root = document.createElement('div');
    root.innerHTML = String(html == null ? '' : html);
    const walk = (node) => {
      for (const child of Array.from(node.childNodes)) {
        if (child.nodeType !== 1) continue;
        const tag = child.tagName;
        if (RICH_DROP_TAGS[tag]) { child.remove(); continue; }
        if (!RICH_TAG_WHITELIST[tag]) {
          walk(child);
          while (child.firstChild) node.insertBefore(child.firstChild, child);   // 解包：保留文本与子元素
          child.remove();
          continue;
        }
        if (tag === 'IMG') {
          const src = child.getAttribute('src') || '';
          const path = child.getAttribute('data-path') || '';
          const keepPath = path && !/^(javascript|vbscript|blob):/i.test(path) ? path : '';
          const keepSrc = src && !/^(javascript|vbscript|blob):/i.test(src) ? src : '';
          for (const a of Array.from(child.attributes)) child.removeAttribute(a.name);
          if (!keepSrc && !keepPath) { child.remove(); continue; }
          child.setAttribute('src', keepSrc || keepPath);
          if (keepPath) child.setAttribute('data-path', keepPath);
          continue;
        }
        for (const a of Array.from(child.attributes)) child.removeAttribute(a.name);
        walk(child);
      }
    };
    walk(root);
    return root.innerHTML;
  }

  // 富文本 HTML → 纯文本（搜索匹配 / 复制 / 导出用；块级元素与 <br> 转行）
  function htmlToText(html) {
    const tmp = document.createElement('div');
    tmp.innerHTML = sanitizeRichHtml(html);
    tmp.querySelectorAll('br').forEach((br) => br.parentNode.replaceChild(document.createTextNode('\n'), br));
    tmp.querySelectorAll('div, p, li').forEach((el) => el.appendChild(document.createTextNode('\n')));
    return String(tmp.textContent || '').replace(/\n{3,}/g, '\n\n').trim();
  }

  // 任务笔记整体纯文本（复制 / TXT 导出）
  function taskNoteToText(n) {
    const lines = [];
    (n.tasks || []).forEach((t, i) => {
      const no = n.auto_no !== false ? (i + 1) + '. ' : '';
      const box = t.done ? '[x] ' : '[ ] ';
      if (t.kind === 'rich') {
        lines.push(no + box + (t.title || '未命名任务'));
        const plain = htmlToText(t.content);
        if (plain) plain.split('\n').forEach((l) => lines.push('    ' + l));
      } else {
        lines.push(no + box + (t.text || ''));
      }
    });
    return lines.join('\n');
  }

  // 从磁盘读入的任务数据归一化（兼容缺字段的旧数据）
  function normTask(t) {
    return {
      id: t.id || genId(),
      kind: t.kind === 'rich' ? 'rich' : 'simple',
      text: String(t.text == null ? '' : t.text),
      title: String(t.title == null ? '' : t.title),
      content: String(t.content == null ? '' : t.content),
      done: !!t.done,
    };
  }

  function isTaskNote(n) { return !!n && n.type === 'task'; }

  function getTask(note, id) {
    if (!isTaskNote(note) || !id) return null;
    return note.tasks.find((t) => t.id === id) || null;
  }

  // 内容模式下任务笔记的命中（富文本标题命中优先，不再重复计入内容命中）
  function taskHits(note, kw) {
    const hits = [];
    for (const t of (note.tasks || [])) {
      if (t.kind === 'rich') {
        if ((t.title || '').toLowerCase().indexOf(kw) >= 0) {
          hits.push({ taskId: t.id, kind: 'title', task: t });
        } else {
          const plain = htmlToText(t.content);
          if (plain && plain.toLowerCase().indexOf(kw) >= 0) {
            hits.push({ taskId: t.id, kind: 'content', task: t });
          }
        }
      } else if ((t.text || '').toLowerCase().indexOf(kw) >= 0) {
        hits.push({ taskId: t.id, kind: 'text', task: t });
      }
    }
    return hits;
  }

  // ---- 任务组列表视图 ----

  function updateTaskCount() {
    const note = getCurrent();
    if (!isTaskNote(note)) return;
    const total = note.tasks.length;
    const done = note.tasks.filter((t) => t.done).length;
    taskCountEl.textContent = total ? '已完成 ' + done + ' / ' + total : '';
  }

  function renderTaskList() {
    const note = getCurrent();
    if (!isTaskNote(note)) return;
    taskAutoNoEl.checked = note.auto_no !== false;
    taskListEl.innerHTML = '';
    note.tasks.forEach((t, i) => {
      const li = document.createElement('li');
      li.className = 'task-item' + (t.kind === 'rich' ? ' is-rich' : '') + (t.done ? ' done' : '');
      li.dataset.id = t.id;
      li.draggable = true;
      const noHtml = note.auto_no !== false ? '<span class="task-no">' + (i + 1) + '.</span>' : '';
      const checkHtml = '<label class="task-check" title="标记完成 / 未完成">' +
        '<input type="checkbox" class="task-done"' + (t.done ? ' checked' : '') + ' /></label>';
      if (t.kind === 'rich') {
        li.innerHTML = noHtml + checkHtml +
          '<div class="task-main">' +
          '<button type="button" class="task-open" title="打开富文本详情">' + esc(t.title || '未命名任务') + '</button>' +
          '<span class="task-badge">富文本</span></div>' +
          '<div class="task-actions"><button class="task-btn danger" data-act="remove" title="删除该任务">删除</button></div>';
      } else {
        li.innerHTML = noHtml + checkHtml +
          '<div class="task-main"><span class="task-text" title="点击编辑">' +
          (t.text ? esc(t.text) : '<span class="task-text-empty">点击编辑内容</span>') +
          '</span></div>' +
          '<div class="task-actions"><button class="task-btn danger" data-act="remove" title="删除该任务">删除</button></div>';
      }
      taskListEl.appendChild(li);
    });
    updateTaskCount();
    taskEmptyEl.style.display = note.tasks.length ? 'none' : 'block';
  }

  taskListEl.addEventListener('click', (e) => {
    const li = e.target.closest('.task-item');
    if (!li || li.classList.contains('editing')) return;
    if (e.target.closest('.task-check')) return;   // 勾选框由 change 处理，不触发编辑 / 详情
    const note = getCurrent();
    const task = getTask(note, li.dataset.id);
    if (!task) return;
    if (e.target.closest('[data-act="remove"]')) { removeTask(task.id); return; }
    if (task.kind === 'rich') openTaskDetail(task.id);
    else startEditSimple(li, task);
  });

  taskListEl.addEventListener('change', (e) => {
    const cb = e.target.closest('.task-done');
    if (!cb) return;
    const li = cb.closest('.task-item');
    const note = getCurrent();
    const task = getTask(note, li.dataset.id);
    if (!task) return;
    task.done = cb.checked;
    note.updated_at = Date.now();
    li.classList.toggle('done', task.done);
    updateTaskCount();
    scheduleSave();
  });

  // 简单任务行内编辑（保存 / 取消按钮提交，无键盘快捷操作；textarea 高度随内容自适应）
  function startEditSimple(li, task) {
    li.classList.add('editing');
    const mainEl = li.querySelector('.task-main');
    mainEl.innerHTML = '<textarea class="task-inline-input" spellcheck="false" rows="1"></textarea>' +
      '<button class="task-btn primary" data-inline="ok">保存</button>' +
      '<button class="task-btn" data-inline="cancel">取消</button>';
    const input = mainEl.querySelector('.task-inline-input');
    input.value = task.text;
    const syncHeight = () => {
      input.style.height = 'auto';
      input.style.height = input.scrollHeight + 'px';
    };
    syncHeight();
    input.focus();
    input.addEventListener('input', syncHeight);
    const finish = (save) => {
      if (save) {
        task.text = input.value.trim();
        const note = getCurrent();
        if (note) note.updated_at = Date.now();
        scheduleSave();
      }
      renderTaskList();
    };
    mainEl.querySelector('[data-inline="ok"]').addEventListener('click', () => finish(true));
    mainEl.querySelector('[data-inline="cancel"]').addEventListener('click', () => finish(false));
  }

  async function removeTask(taskId) {
    const note = getCurrent();
    const idx = isTaskNote(note) ? note.tasks.findIndex((t) => t.id === taskId) : -1;
    if (idx < 0) return;
    const task = note.tasks[idx];
    const label = (task.kind === 'rich' ? task.title : task.text) || '未命名任务';
    const ok = await window.showConfirm('确定删除任务「' + label + '」吗？删除后无法恢复。', {
      title: '删除任务',
      okText: '删除',
    });
    if (!ok) return;
    note.tasks.splice(idx, 1);
    note.updated_at = Date.now();
    renderTaskList();
    scheduleSave();
  }

  function addSimpleTask() {
    const note = getCurrent();
    if (!isTaskNote(note)) return;
    const task = { id: genId(), kind: 'simple', text: '', title: '', content: '', done: false };
    note.tasks.push(task);
    note.updated_at = Date.now();
    renderTaskList();
    scheduleSave();
    const li = taskListEl.querySelector('.task-item[data-id="' + task.id + '"]');
    if (li) startEditSimple(li, task);
  }

  function addRichTask() {
    const note = getCurrent();
    if (!isTaskNote(note)) return;
    const task = { id: genId(), kind: 'rich', text: '', title: '新任务', content: '', done: false };
    note.tasks.push(task);
    note.updated_at = Date.now();
    renderTaskList();
    scheduleSave();
    openTaskDetail(task.id);
    taskDetailTitleEl.focus();
    taskDetailTitleEl.select();
  }

  taskAutoNoEl.addEventListener('change', () => {
    const note = getCurrent();
    if (!isTaskNote(note)) return;
    note.auto_no = taskAutoNoEl.checked;
    note.updated_at = Date.now();
    renderTaskList();
    scheduleSave();
  });

  document.getElementById('task-add-simple').addEventListener('click', addSimpleTask);
  document.getElementById('task-add-rich').addEventListener('click', addRichTask);

  // ---- 富文本任务详情（所见即所得编辑） ----

  // 本地路径 → Tauri asset 协议 URL（无 Tauri 接口时返回空）
  function toAssetUrl(p) {
    const api = window.__TAURI__ && window.__TAURI__.core;
    if (api && typeof api.convertFileSrc === 'function') {
      try { return api.convertFileSrc(p); } catch (e) { return ''; }
    }
    return '';
  }

  // 编辑器内图片（任务详情与普通笔记共用）：data-path 记录原始引用（落盘用，v0.33.0 起新图为新格式相对路径 images/xxx），
  // src 换为 asset URL 显示；相对路径基于数据目录解析（未知时先读取一次）
  async function hydrateImages(editorEl) {
    const imgs = Array.from(editorEl.querySelectorAll('img'));
    const needDir = imgs.some((img) =>
      isRelativeImgRef(img.getAttribute('data-path') || '') ||
      isRelativeImgRef(img.getAttribute('src') || ''));
    if (needDir) await ensureDataDir();
    imgs.forEach((img) => {
      const p = img.getAttribute('data-path');
      if (p) {
        const url = toAssetUrl(imgAbsPath(p) || p);
        if (url) img.setAttribute('src', url);
        return;
      }
      const src = img.getAttribute('src') || '';
      if (src && !/^(https?|data):/i.test(src)) {
        const abs = isRelativeImgRef(src) ? (imgAbsPath(src) || src) : src;
        const url = toAssetUrl(abs);
        if (url) { img.setAttribute('data-path', src); img.setAttribute('src', url); }
      }
    });
  }

  // 序列化编辑器内容（任务详情与普通笔记共用）：图片 src 还原为原始路径；mark 高亮由白名单清洗自动解包
  function serializeRichContent(editorEl) {
    const clone = editorEl.cloneNode(true);
    clone.querySelectorAll('img').forEach((img) => {
      const p = img.getAttribute('data-path');
      if (p) { img.setAttribute('src', p); img.removeAttribute('data-path'); }
    });
    return sanitizeRichHtml(clone.innerHTML);
  }

  function syncTaskRichContent() {
    const note = getCurrent();
    const task = getTask(note, taskDetailId);
    if (!task) return;
    task.content = serializeRichContent(taskRichEditorEl);
    note.updated_at = Date.now();
    scheduleSave();
  }

  async function openTaskDetail(id) {
    const note = getCurrent();
    const task = getTask(note, id);
    if (!task || task.kind !== 'rich') return;
    taskDetailId = id;
    taskDetailTitleEl.value = task.title || '';
    taskRichEditorEl.innerHTML = sanitizeRichHtml(task.content || '');
    taskWrapEl.classList.add('hidden');
    taskDetailEl.classList.remove('hidden');
    await hydrateImages(taskRichEditorEl);
    applyTaskDetailHighlight();
  }

  function closeTaskDetail() {
    if (!taskDetailId) return;
    syncTaskRichContent();   // 返回前最终落盘一次
    taskDetailId = null;
    taskHighlightTerm = '';
    taskDetailEl.classList.add('hidden');
    taskWrapEl.classList.remove('hidden');
    renderTaskList();
  }

  document.getElementById('task-detail-back').addEventListener('click', closeTaskDetail);

  taskDetailTitleEl.addEventListener('input', () => {
    const note = getCurrent();
    const task = getTask(note, taskDetailId);
    if (!task) return;
    task.title = taskDetailTitleEl.value;
    note.updated_at = Date.now();
    scheduleSave();
  });

  taskRichEditorEl.addEventListener('input', syncTaskRichContent);

  // 粘贴统一转纯文本插入，避免带入外部样式与危险标签（任务详情与普通笔记共用）
  function bindRichPaste(editorEl, syncFn) {
    editorEl.addEventListener('paste', (e) => {
      e.preventDefault();
      const text = (e.clipboardData && e.clipboardData.getData('text/plain')) || '';
      if (!text) return;
      const html = text.split(/\r\n|\r|\n/).map((line) => esc(line)).join('<br>');
      document.execCommand('insertHTML', false, html);
      syncFn();
    });
  }

  bindRichPaste(taskRichEditorEl, syncTaskRichContent);

  // 工具栏：mousedown 阻止默认，避免点击按钮时编辑器选区丢失（任务详情与普通笔记共用）
  function bindRichToolbar(editorEl, syncFn, commands) {
    commands.forEach(([id, cmd]) => {
      const btn = document.getElementById(id);
      if (!btn) return;
      btn.addEventListener('mousedown', (e) => e.preventDefault());
      btn.addEventListener('click', () => {
        editorEl.focus();
        document.execCommand(cmd, false, null);
        syncFn();
      });
    });
  }

  bindRichToolbar(taskRichEditorEl, syncTaskRichContent, [
    ['task-tool-bold', 'bold'],
    ['task-tool-italic', 'italic'],
    ['task-tool-underline', 'underline'],
    ['task-tool-ul', 'insertUnorderedList'],
    ['task-tool-ol', 'insertOrderedList'],
  ]);

  // 插入本地图片（任务详情与普通笔记共用）：复制到数据目录 images/，内容存相对路径
  async function insertImageInto(editorEl, syncFn) {
    if (!dialogApi || !dialogApi.open) {
      window.toast('Tauri 接口不可用（请通过应用运行）');
      return;
    }
    let picked = null;
    try {
      picked = await dialogApi.open({
        multiple: false,
        title: '选择图片',
        filters: [{ name: '图片', extensions: ['png', 'jpg', 'jpeg', 'gif', 'webp', 'bmp'] }],
      });
    } catch (e) {
      window.toast('打开文件选择器失败：' + e);
      return;
    }
    const p = typeof picked === 'string' ? picked : (picked && picked.path) || (Array.isArray(picked) ? picked[0] : null);
    if (!p) return;
    // v0.33.0：图片复制到数据目录 images/，内容存相对路径（数据自包含，随备份导出 / 导入）
    let rel = '';
    try {
      rel = await invoke('note_image_import', { source: p });
    } catch (e) {
      window.toast('插入图片失败：' + e);
      return;
    }
    await ensureDataDir();
    editorEl.focus();
    // 折叠选区到末尾，避免选中文本时插图直接替换选区内容
    const sel = window.getSelection();
    if (sel && sel.rangeCount) {
      const r = sel.getRangeAt(0).cloneRange();
      r.collapse(false);
      sel.removeAllRanges();
      sel.addRange(r);
    }
    const url = toAssetUrl(imgAbsPath(rel)) || rel;
    document.execCommand('insertHTML', false,
      '<img src="' + esc(url) + '" data-path="' + esc(rel) + '">');
    syncFn();
  }

  // 绑定图片按钮：mousedown 阻止默认保住编辑器选区，点击走插入流程
  function bindRichImage(id, editorEl, syncFn) {
    const btn = document.getElementById(id);
    if (!btn) return;
    btn.addEventListener('mousedown', (e) => e.preventDefault());
    btn.addEventListener('click', () => insertImageInto(editorEl, syncFn));
  }

  bindRichImage('task-tool-image', taskRichEditorEl, syncTaskRichContent);

  // 搜索命中富文本内容进入详情：正文中高亮命中词（序列化时自动清除，不落盘）
  function applyTaskDetailHighlight() {
    if (!taskHighlightTerm) return;
    const q = taskHighlightTerm.toLowerCase();
    const walker = document.createTreeWalker(taskRichEditorEl, NodeFilter.SHOW_TEXT, null);
    const nodes = [];
    while (walker.nextNode()) nodes.push(walker.currentNode);
    for (const node of nodes) {
      const text = node.nodeValue;
      const tl = text.toLowerCase();
      let idx = tl.indexOf(q);
      if (idx === -1) continue;
      const frag = document.createDocumentFragment();
      let pos = 0;
      while (idx !== -1) {
        if (idx > pos) frag.appendChild(document.createTextNode(text.slice(pos, idx)));
        const mk = document.createElement('mark');
        mk.className = 'md-mark';
        mk.textContent = text.slice(idx, idx + q.length);
        frag.appendChild(mk);
        pos = idx + q.length;
        idx = tl.indexOf(q, pos);
      }
      if (pos < text.length) frag.appendChild(document.createTextNode(text.slice(pos)));
      node.parentNode.replaceChild(frag, node);
    }
    const first = taskRichEditorEl.querySelector('mark.md-mark');
    if (first) first.scrollIntoView({ block: 'center' });
  }

  // 任务级搜索命中：文本 / 标题命中进入任务组并定位高亮；内容命中进入富文本详情并高亮
  function openTaskHit(noteId, taskId, hitKind, keyword) {
    selectNote(noteId);
    if (hitKind === 'content') {
      taskHighlightTerm = keyword;
      openTaskDetail(taskId);
      return;
    }
    const li = taskListEl.querySelector('.task-item[data-id="' + taskId + '"]');
    if (li) {
      li.classList.add('hit');
      li.scrollIntoView({ block: 'nearest' });
    }
  }

  // ---------- 普通笔记：富文本编辑（v0.34.0，与富文本任务同款所见即所得编辑器） ----------

  // 旧版纯文本内容 → 富文本 HTML（转义 + 换行转 <br>；仅在数据加载时对旧版普通笔记执行一次）
  function plainToRichHtml(text) {
    return String(text == null ? '' : text)
      .split(/\r\n|\r|\n/)
      .map((line) => esc(line))
      .join('<br>');
  }

  function renderNoteRich() {
    const note = getCurrent();
    noteRichEditorEl.innerHTML = sanitizeRichHtml((note && note.content) || '');
    if (note) hydrateImages(noteRichEditorEl);
  }

  function syncNoteRichContent() {
    const note = getCurrent();
    if (!note || note.type !== 'text') return;
    note.content = serializeRichContent(noteRichEditorEl);
    note.updated_at = Date.now();
    const li = getLi(note.id);
    if (li) li.querySelector('.note-item-meta').textContent = formatTime(note.updated_at);
    if (state.filter && state.searchMode === 'content') renderList(); // 内容过滤中修改内容需同步
    scheduleSave();
  }

  noteRichEditorEl.addEventListener('input', syncNoteRichContent);
  bindRichPaste(noteRichEditorEl, syncNoteRichContent);
  bindRichToolbar(noteRichEditorEl, syncNoteRichContent, [
    ['note-tool-bold', 'bold'],
    ['note-tool-italic', 'italic'],
    ['note-tool-underline', 'underline'],
    ['note-tool-ul', 'insertUnorderedList'],
    ['note-tool-ol', 'insertOrderedList'],
  ]);
  bindRichImage('note-tool-image', noteRichEditorEl, syncNoteRichContent);

  // ---------- 操作 ----------

  // 新建记录（type: 'text' 普通笔记 / 'md' Markdown 笔记 / 'task' 任务笔记）
  function createNote(type) {
    const isMd = type === 'md';
    const isTask = type === 'task';
    const now = Date.now();
    const note = {
      id: genId(),
      title: isMd ? '新 Markdown 笔记' : (isTask ? '新任务组' : '新记录'),
      content: '',
      type: isMd ? 'md' : (isTask ? 'task' : 'text'),
      rich: !isMd && !isTask, // 普通笔记内容为富文本 HTML（v0.34.0）
      tasks: [],
      auto_no: true,
      updated_at: now,
    };
    state.notes.unshift(note);
    clearNoteSearch(); // 新建后显示全部记录，确保新记录可见
    renderList();
    selectNote(note.id);
    titleEl.focus();
    titleEl.select();
    scheduleSave();
  }

  async function removeNote(id) {
    const idx = state.notes.findIndex((n) => n.id === id);
    if (idx < 0) return;
    const note = state.notes[idx];
    // 弹窗确认后再删除，避免误操作丢失记录
    const ok = await window.showConfirm(
      '确定删除「' + (note.title || '未命名') + '」吗？删除后无法恢复。',
      { title: '删除记录', okText: '删除' }
    );
    if (!ok) return;
    state.notes.splice(idx, 1);
    if (state.currentId === id) {
      const next = state.notes[idx] || state.notes[idx - 1] || null;
      state.currentId = next ? next.id : null;
      if (next) {
        selectNote(next.id);
      } else {
        editorEl.classList.add('hidden');
        titleEl.value = '';
        contentEl.value = '';
        metaEl.textContent = '';
        setEditorMode('text');
      }
    }
    renderList();
    scheduleSave(true);
  }

  async function backup() {
    if (!invoke) return;
    try {
      const path = await invoke('notes_backup');
      window.toast('已备份到：' + path);
    } catch (e) {
      window.toast(String(e));
    }
  }

  // ---------- 批量操作（多选 / 全选 / 批量删除） ----------

  function enterMulti() {
    if (multi.active || !state.notes.length) return;
    clearNoteSearch(); // 批量模式基于全部记录，先退出标题过滤
    multi.active = true;
    multi.selected.clear();
    sideEl.classList.add('batch-mode');
    toolbarEl.classList.add('hidden');
    multiBar.classList.remove('hidden');
    renderList();
  }

  function exitMulti() {
    if (!multi.active) return;
    multi.active = false;
    multi.selected.clear();
    sideEl.classList.remove('batch-mode');
    toolbarEl.classList.remove('hidden');
    multiBar.classList.add('hidden');
    renderList();
  }

  function toggleSelect(id) {
    if (multi.selected.has(id)) multi.selected.delete(id);
    else multi.selected.add(id);
    renderList();
  }

  function toggleSelectAll() {
    if (multi.selected.size >= state.notes.length) multi.selected.clear();
    else state.notes.forEach((n) => multi.selected.add(n.id));
    renderList();
  }

  function updateMultiUI() {
    const total = state.notes.length;
    const n = multi.selected.size;
    multiCountEl.textContent = '已选 ' + n + ' 项';
    selAllBtn.textContent = total && n >= total ? '取消全选' : '全选';
    selAllBtn.disabled = !total;
    exportSelBtn.disabled = !n;
    delSelBtn.disabled = !n;
  }

  async function deleteSelected() {
    const n = multi.selected.size;
    if (!n) return;
    const ok = await window.showConfirm('确定删除选中的 ' + n + ' 条记录吗？删除后无法恢复。', {
      title: '批量删除',
      okText: '删除',
    });
    if (!ok) return;
    const firstIdx = state.notes.findIndex((note) => multi.selected.has(note.id));
    state.notes = state.notes.filter((note) => !multi.selected.has(note.id));
    if (state.currentId && !state.notes.some((note) => note.id === state.currentId)) {
      const next = state.notes[Math.min(firstIdx, state.notes.length - 1)] || null;
      state.currentId = next ? next.id : null;
      if (next) {
        titleEl.value = next.title;
        contentEl.value = next.content;
        metaEl.textContent = '最后更新:' + formatTime(next.updated_at);
        editorEl.classList.remove('hidden');
        setEditorMode(next.type);
      } else {
        editorEl.classList.add('hidden');
        titleEl.value = '';
        contentEl.value = '';
        metaEl.textContent = '';
        setEditorMode('text');
      }
    }
    exitMulti();
    scheduleSave(true);
  }

  // ---------- 导出（单条 / 批量，JSON / TXT，自选文件夹） ----------

  let exportMenuEl = null;
  let exportMenuDocHandler = null;

  function closeExportMenu() {
    if (exportMenuEl) {
      exportMenuEl.remove();
      exportMenuEl = null;
    }
    if (exportMenuDocHandler) {
      document.removeEventListener('click', exportMenuDocHandler);
      exportMenuDocHandler = null;
    }
  }

  // 点「导出」后弹出格式选择菜单（贴按钮定位，空间不足时上移）
  function openExportMenu(btn, notes) {
    closeExportMenu();
    const menu = document.createElement('div');
    menu.className = 'export-menu';
    menu.innerHTML =
      '<button type="button" data-fmt="json">导出为 JSON</button>' +
      '<button type="button" data-fmt="txt">导出为 TXT</button>';
    document.body.appendChild(menu);
    const rect = btn.getBoundingClientRect();
    let left = rect.right - menu.offsetWidth;
    if (left < 8) left = 8;
    let top = rect.bottom + 6;
    if (top + menu.offsetHeight > window.innerHeight - 8) {
      top = rect.top - menu.offsetHeight - 6;
    }
    menu.style.left = left + 'px';
    menu.style.top = top + 'px';
    exportMenuEl = menu;
    menu.querySelectorAll('button[data-fmt]').forEach((b) => {
      b.addEventListener('click', (e) => {
        e.stopPropagation();
        const fmt = b.dataset.fmt;
        closeExportMenu();
        runExport(notes, fmt);
      });
    });
    setTimeout(() => {
      exportMenuDocHandler = (ev) => {
        if (exportMenuEl && !exportMenuEl.contains(ev.target)) closeExportMenu();
      };
      document.addEventListener('click', exportMenuDocHandler);
    }, 0);
  }

  // 点「新建记录」后弹出类型菜单（普通笔记 / Markdown 笔记 / 任务笔记；与导出菜单共用弹出 / 关闭机制）
  function openNewNoteMenu(btn) {
    closeExportMenu();
    const menu = document.createElement('div');
    menu.className = 'export-menu note-type-menu';
    menu.innerHTML =
      '<button type="button" data-note-type="text">' + ICON_TEXT + '普通笔记</button>' +
      '<button type="button" data-note-type="md">' + ICON_MD + 'Markdown 笔记</button>' +
      '<button type="button" data-note-type="task">' + ICON_TASK + '任务笔记</button>';
    document.body.appendChild(menu);
    const rect = btn.getBoundingClientRect();
    let left = rect.left;
    if (left + menu.offsetWidth > window.innerWidth - 8) {
      left = window.innerWidth - menu.offsetWidth - 8;
    }
    if (left < 8) left = 8;
    let top = rect.bottom + 6;
    if (top + menu.offsetHeight > window.innerHeight - 8) {
      top = rect.top - menu.offsetHeight - 6;
    }
    menu.style.left = left + 'px';
    menu.style.top = top + 'px';
    exportMenuEl = menu;
    menu.querySelectorAll('button[data-note-type]').forEach((b) => {
      b.addEventListener('click', (e) => {
        e.stopPropagation();
        const type = b.dataset.noteType;
        closeExportMenu();
        createNote(type);
      });
    });
    setTimeout(() => {
      exportMenuDocHandler = (ev) => {
        if (exportMenuEl && !exportMenuEl.contains(ev.target)) closeExportMenu();
      };
      document.addEventListener('click', exportMenuDocHandler);
    }, 0);
  }

  // 清洗文件名：替换 Windows 非法字符，去掉结尾的点 / 空格并限长
  function sanitizeName(title) {
    let name = String(title || '').trim().replace(/[\\/:*?"<>|\u0000-\u001f]/g, '_');
    name = name.replace(/[\. ]+$/, '').trim();
    if (!name) name = '未命名';
    if (name.length > 60) name = name.slice(0, 60);
    return name;
  }

  function pad2(x) {
    return String(x).padStart(2, '0');
  }

  function exportStamp() {
    const d = new Date();
    return d.getFullYear() + pad2(d.getMonth() + 1) + pad2(d.getDate()) + '-' +
      pad2(d.getHours()) + pad2(d.getMinutes()) + pad2(d.getSeconds());
  }

  function noteToJson(n) {
    const out = { title: n.title, content: n.content, type: n.type || 'text', updated_at: n.updated_at };
    if (n.type === 'text' && n.rich) out.rich = true; // v0.34.0：普通笔记内容为富文本 HTML
    if (n.type === 'task') {
      out.tasks = (n.tasks || []).map((t) => ({
        id: t.id, kind: t.kind, text: t.text, title: t.title, content: t.content, done: !!t.done,
      }));
      out.auto_no = n.auto_no !== false;
    }
    return out;
  }

  // 组装待写入文件：JSON 单条为对象、批量为数组单文件；TXT 每篇一个文件（重名自动加序号）
  function buildExportFiles(notes, fmt) {
    if (fmt === 'json') {
      if (notes.length === 1) {
        return [{
          name: sanitizeName(notes[0].title) + '.json',
          content: JSON.stringify(noteToJson(notes[0]), null, 2),
        }];
      }
      return [{
        name: 'notes-export-' + exportStamp() + '.json',
        content: JSON.stringify(notes.map(noteToJson), null, 2),
      }];
    }
    const used = new Set();
    const files = [];
    for (const n of notes) {
      const base = sanitizeName(n.title);
      let name = base;
      for (let i = 2; used.has(name.toLowerCase()); i++) name = base + '(' + i + ')';
      used.add(name.toLowerCase());
      const body = (n.title ? n.title + '\n\n' : '') +
        (n.type === 'task' ? taskNoteToText(n)
          : (n.type === 'text' ? htmlToText(n.content) : (n.content || '')));
      files.push({ name: name + '.txt', content: '\uFEFF' + body });
    }
    return files;
  }

  // 选择文件夹后写入（TXT 带 UTF-8 BOM，兼容 Windows 记事本）
  async function runExport(notes, fmt) {
    if (!invoke || !dialogApi || !dialogApi.open) {
      window.toast('Tauri 接口不可用（请通过应用运行）');
      return;
    }
    if (!notes.length) {
      window.toast('没有可导出的记录');
      return;
    }
    let dir = null;
    try {
      const picked = await dialogApi.open({
        directory: true,
        multiple: false,
        title: '选择导出文件夹',
      });
      dir = typeof picked === 'string'
        ? picked
        : (picked && picked.path) || (Array.isArray(picked) ? picked[0] : null);
    } catch (e) {
      window.toast('打开文件夹选择器失败：' + e);
      return;
    }
    if (!dir) return; // 用户取消选择
    try {
      const count = await invoke('notes_export', { dir: dir, files: buildExportFiles(notes, fmt) });
      window.toast('已导出 ' + count + ' 个文件');
    } catch (e) {
      window.toast('导出失败：' + e);
    }
  }

  // ---------- 编辑事件 ----------

  function getLi(id) {
    return listEl.querySelector('.note-item[data-id="' + id + '"]');
  }

  // ---------- 搜索过滤（标题 / 内容双模式） ----------

  // 模式按钮与占位符同步当前搜索范围
  function syncSearchModeUI() {
    const isContent = state.searchMode === 'content';
    searchModeLabelEl.textContent = isContent ? '内容' : '标题';
    searchModeEl.classList.toggle('is-content', isContent);
    searchModeEl.title = isContent
      ? '搜索范围：内容模糊匹配——点击切换为标题'
      : '搜索范围：标题——点击切换为内容模糊匹配';
    searchEl.placeholder = isContent ? '搜索内容（模糊匹配）' : '搜索标题（关键字）';
  }

  function clearNoteSearch() {
    if (!state.filter && !searchEl.value) return;
    state.filter = '';
    searchEl.value = '';
    searchClearEl.classList.add('hidden');
  }

  searchEl.addEventListener('input', () => {
    state.filter = searchEl.value;
    searchClearEl.classList.toggle('hidden', !state.filter.trim());
    renderList();
  });

  searchClearEl.addEventListener('click', () => {
    clearNoteSearch();
    renderList();
  });

  searchModeEl.addEventListener('click', () => {
    state.searchMode = state.searchMode === 'title' ? 'content' : 'title';
    syncSearchModeUI();
    renderList();
  });

  titleEl.addEventListener('input', () => {
    const note = getCurrent();
    if (!note) return;
    note.title = titleEl.value;
    note.updated_at = Date.now();
    const li = getLi(note.id);
    if (li) {
      li.querySelector('.note-item-name').textContent = note.title || '未命名';
      li.querySelector('.note-item-meta').textContent = formatTime(note.updated_at);
    }
    if (state.filter) renderList(); // 过滤中修改标题需同步过滤结果
    scheduleSave();
  });

  contentEl.addEventListener('input', () => {
    const note = getCurrent();
    if (!note) return;
    note.content = contentEl.value;
    note.updated_at = Date.now();
    const li = getLi(note.id);
    if (li) li.querySelector('.note-item-meta').textContent = formatTime(note.updated_at);
    if (state.filter && state.searchMode === 'content') renderList(); // 内容过滤中修改内容需同步
    // Markdown 笔记：防抖同步右侧实时预览
    if (bodyWrapEl.classList.contains('is-md')) {
      clearTimeout(mdPreviewTimer);
      mdPreviewTimer = setTimeout(renderMdPreview, 150);
    }
    scheduleSave();
  });

  // 失焦时立即落盘，减少关窗丢数据的窗口期
  window.addEventListener('blur', () => doSave(true));

  document.getElementById('note-new').addEventListener('click', (e) => {
    e.stopPropagation();
    openNewNoteMenu(e.currentTarget);
  });
  document.getElementById('note-backup').addEventListener('click', backup);
  document.getElementById('note-copy').addEventListener('click', async () => {
    if (!state.currentId) {
      window.toast('请先选择一条记录');
      return;
    }
    const note = getCurrent();
    const text = isTaskNote(note)
      ? taskNoteToText(note)
      : (note.type === 'text' ? htmlToText(note.content) : contentEl.value);
    if (!text) {
      window.toast('内容为空，无可复制');
      return;
    }
    await window.copyText(text, '已复制内容到剪贴板');
  });
  document.getElementById('note-delete').addEventListener('click', () => {
    if (state.currentId) removeNote(state.currentId);
    else window.toast('请先选择一条记录');
  });
  document.getElementById('note-export').addEventListener('click', (e) => {
    e.stopPropagation();
    const note = getCurrent();
    if (!note) {
      window.toast('请先选择一条记录');
      return;
    }
    openExportMenu(e.currentTarget, [note]);
  });

  multiBtn.addEventListener('click', enterMulti);
  multiExitBtn.addEventListener('click', exitMulti);
  selAllBtn.addEventListener('click', toggleSelectAll);
  delSelBtn.addEventListener('click', deleteSelected);
  exportSelBtn.addEventListener('click', (e) => {
    e.stopPropagation();
    const notes = state.notes.filter((n) => multi.selected.has(n.id));
    if (!notes.length) return;
    openExportMenu(e.currentTarget, notes);
  });

  // ---------- 拖动排序（v0.33.0：虚线空位随拖拽实时移动，见 drag-sort.js） ----------

  window.DragSort.init({
    listEl,
    itemSelector: '.note-item',
    // 空位移动已在 DOM 上就位：drop 时仅按最新 DOM 顺序落盘，不再整表重渲染
    onDrop: (el, newIndex) => {
      const from = state.notes.findIndex((n) => n.id === el.dataset.id);
      if (from < 0 || from === newIndex) return;
      const item = state.notes.splice(from, 1)[0];
      state.notes.splice(newIndex, 0, item);
      scheduleSave(true);
    },
  });

  // ---------- 任务拖动排序（任务组视图整行可拖；按钮 / 勾选框上按下或编辑中不启动） ----------

  window.DragSort.init({
    listEl: taskListEl,
    itemSelector: '.task-item',
    canStart: (e, li) => !li.classList.contains('editing') && !e.target.closest('button, input, label'),
    onDrop: (el, newIndex) => {
      const note = getCurrent();
      if (!isTaskNote(note)) return;
      const from = note.tasks.findIndex((t) => t.id === el.dataset.id);
      if (from < 0 || from === newIndex) return;
      const item = note.tasks.splice(from, 1)[0];
      note.tasks.splice(newIndex, 0, item);
      scheduleSave(true);
    },
    // 空位每次移动（含取消恢复）后按最新 DOM 顺序刷新自动序号
    onPreviewOrder: refreshTaskNos,
  });

  function refreshTaskNos() {
    const note = getCurrent();
    if (!isTaskNote(note) || note.auto_no === false) return;
    taskListEl.querySelectorAll('.task-item').forEach((li, i) => {
      const noEl = li.querySelector('.task-no');
      if (noEl) noEl.textContent = (i + 1) + '.';
    });
  }

  // ---------- 初始化 ----------

  async function init() {
    if (!invoke) {
      setSaveStatus('', 'Tauri 接口不可用（请通过应用运行）');
      return;
    }
    let migrated = false; // v0.34.0：旧版纯文本 → 富文本 HTML 的转换标记（转换后立即回写 rich）
    try {
      const notes = await invoke('notes_load');
      // 归一化（兼容旧数据缺字段）：无 type 按 text；任务笔记补全 tasks / auto_no；
      // id 缺失补生成、title / content 缺失补空串、updated_at 缺失补 0；
      // v0.34.0：普通笔记为富文本 HTML，旧版纯文本内容加载时一次性转换并置 rich
      state.notes = (Array.isArray(notes) ? notes : [])
        .filter((n) => n && typeof n === 'object')
        .map((n) => {
          const type = n.type === 'md' ? 'md' : (n.type === 'task' ? 'task' : 'text');
          let content = String(n.content == null ? '' : n.content);
          let rich = !!n.rich;
          if (type === 'text' && !rich) {
            content = plainToRichHtml(content);
            rich = true;
            migrated = true;
          }
          return {
            id: n.id || genId(),
            title: String(n.title == null ? '' : n.title),
            content,
            type,
            rich,
            tasks: type === 'task' && Array.isArray(n.tasks) ? n.tasks.map(normTask) : [],
            auto_no: n.auto_no === undefined ? true : !!n.auto_no,
            updated_at: Number(n.updated_at) || 0,
          };
        });
      loaded = true; // 加载成功后才允许保存（见 doSave）
    } catch (e) {
      window.toast('加载记事本失败：' + e);
      state.notes = [];
    }
    renderList();
    if (state.notes.length) {
      selectNote(state.notes[0].id);
      setSaveStatus('', '就绪');
    } else {
      editorEl.classList.add('hidden');
    }
    if (migrated) scheduleSave(); // 转换结果尽快回写（rich 标记），避免下次启动重复转换
  }

  init();
})();
