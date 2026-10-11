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
  const bodyWrapEl = document.getElementById('note-body-wrap');
  const noteMdRenderEl = document.getElementById('note-md-render');

  const state = {
    notes: [],      // [{ id, title, content, type: 'text' | 'md', updated_at }]
    currentId: null,
    filter: '',     // 标题搜索关键字（过滤列表显示）
  };

  const multi = { active: false, selected: new Set() };  // 批量操作（多选）模式

  const SAVE_DELAY = 500;
  let saveTimer = null;
  let saving = false;

  // ---------- 工具 ----------

  // 类型图标（线性 24 viewBox）：普通文本（文档）/ Markdown（M↓ 徽标）
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

  function noteIcon(type) {
    return type === 'md' ? ICON_MD : ICON_TEXT;
  }

  const ESC_MAP = { '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;', "'": '&#39;' };
  function esc(s) {
    return String(s).replace(/[&<>"']/g, (c) => ESC_MAP[c]);
  }

  function genId() {
    if (window.crypto && crypto.randomUUID) return crypto.randomUUID();
    return 'n-' + Date.now() + '-' + Math.random().toString(16).slice(2);
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
    if (!invoke || saving) return;
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
    // 标题过滤：有关键字时仅显示匹配记录（过滤状态下禁用拖动排序）
    const kw = state.filter.trim().toLowerCase();
    const visible = kw
      ? state.notes.filter((n) => (n.title || '').toLowerCase().indexOf(kw) >= 0)
      : state.notes;
    listEl.innerHTML = '';
    for (const n of visible) {
      const selected = multi.active && multi.selected.has(n.id);
      const li = document.createElement('li');
      li.className = 'note-item' + (n.id === state.currentId ? ' active' : '') +
        (selected ? ' selected' : '');
      li.dataset.id = n.id;
      li.draggable = !multi.active && !kw;
      li.innerHTML =
        (multi.active ? '<span class="note-check">' + (selected ? '✓' : '') + '</span>' : '') +
        '<div class="note-item-title">' + noteIcon(n.type) +
        '<span class="note-item-name">' + esc(n.title || '未命名') + '</span></div>' +
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
    state.currentId = id;
    titleEl.value = note.title;
    contentEl.value = note.content;
    metaEl.textContent = '最后更新:' + formatTime(note.updated_at);
    editorEl.classList.remove('hidden');
    setEditorMode(note.type === 'md');
    renderList();
  }

  // 编辑器模式：普通文本单栏 / Markdown 笔记左编辑右实时预览
  let mdPreviewTimer = null;

  // Markdown 笔记预览：复用 Markdown 预览面板的解析器（window.mdRender）
  function renderMdPreview() {
    if (!bodyWrapEl.classList.contains('is-md')) return;
    const html = (typeof window.mdRender === 'function') ? window.mdRender(contentEl.value) : '';
    noteMdRenderEl.innerHTML = html ||
      '<div class="note-md-empty">输入 Markdown 内容，此处实时渲染预览</div>';
  }

  function setEditorMode(isMd) {
    bodyWrapEl.classList.toggle('is-md', isMd);
    clearTimeout(mdPreviewTimer);
    if (isMd) renderMdPreview();
  }

  // ---------- 操作 ----------

  // 新建记录（type: 'text' 普通文本 / 'md' Markdown 笔记）
  function createNote(type) {
    const isMd = type === 'md';
    const now = Date.now();
    const note = {
      id: genId(),
      title: isMd ? '新 Markdown 笔记' : '新记录',
      content: '',
      type: isMd ? 'md' : 'text',
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
        setEditorMode(false);
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
        setEditorMode(next.type === 'md');
      } else {
        editorEl.classList.add('hidden');
        titleEl.value = '';
        contentEl.value = '';
        metaEl.textContent = '';
        setEditorMode(false);
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

  // 点「新建记录」后弹出类型菜单（普通文本 / Markdown 笔记；与导出菜单共用弹出 / 关闭机制）
  function openNewNoteMenu(btn) {
    closeExportMenu();
    const menu = document.createElement('div');
    menu.className = 'export-menu note-type-menu';
    menu.innerHTML =
      '<button type="button" data-note-type="text">' + ICON_TEXT + '普通文本</button>' +
      '<button type="button" data-note-type="md">' + ICON_MD + 'Markdown 笔记</button>';
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
    return { title: n.title, content: n.content, type: n.type || 'text', updated_at: n.updated_at };
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
      const body = (n.title ? n.title + '\n\n' : '') + (n.content || '');
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

  // ---------- 标题搜索过滤 ----------

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

  searchEl.addEventListener('keydown', (e) => {
    if (e.key === 'Escape' && searchEl.value) {
      e.stopPropagation();
      clearNoteSearch();
      renderList();
    }
  });

  searchClearEl.addEventListener('click', () => {
    clearNoteSearch();
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
    const text = contentEl.value;
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

  // ---------- 拖动排序 ----------

  let dragId = null;

  listEl.addEventListener('dragstart', (e) => {
    const li = e.target.closest('.note-item');
    if (!li) return;
    dragId = li.dataset.id;
    li.classList.add('dragging');
    e.dataTransfer.effectAllowed = 'move';
    e.dataTransfer.setData('text/plain', dragId);
  });

  listEl.addEventListener('dragover', (e) => {
    e.preventDefault();
    e.dataTransfer.dropEffect = 'move';
    const li = e.target.closest('.note-item');
    listEl.querySelectorAll('.drag-over-top, .drag-over-bottom').forEach((el) => {
      el.classList.remove('drag-over-top', 'drag-over-bottom');
    });
    if (!li || li.dataset.id === dragId) return;
    const rect = li.getBoundingClientRect();
    const before = e.clientY - rect.top < rect.height / 2;
    li.classList.add(before ? 'drag-over-top' : 'drag-over-bottom');
  });

  listEl.addEventListener('drop', (e) => {
    e.preventDefault();
    const li = e.target.closest('.note-item');
    const targetId = li && li.dataset.id;
    const before = li && li.classList.contains('drag-over-top');
    if (dragId && targetId && targetId !== dragId) {
      moveNote(dragId, targetId, before);
    }
    cleanupDrag();
  });

  listEl.addEventListener('dragend', cleanupDrag);

  function cleanupDrag() {
    dragId = null;
    listEl.querySelectorAll('.dragging, .drag-over-top, .drag-over-bottom').forEach((el) => {
      el.classList.remove('dragging', 'drag-over-top', 'drag-over-bottom');
    });
  }

  function moveNote(fromId, targetId, before) {
    const from = state.notes.findIndex((n) => n.id === fromId);
    if (from < 0) return;
    const item = state.notes.splice(from, 1)[0];
    let to = state.notes.findIndex((n) => n.id === targetId);
    if (to < 0) {
      state.notes.splice(from, 0, item);
      return;
    }
    if (!before) to += 1;
    state.notes.splice(to, 0, item);
    renderList();
    scheduleSave(true);
  }

  // ---------- 初始化 ----------

  async function init() {
    if (!invoke) {
      setSaveStatus('', 'Tauri 接口不可用（请通过应用运行）');
      return;
    }
    try {
      const notes = await invoke('notes_load');
      // 归一化：旧数据无 type 字段按 text 处理
      state.notes = (Array.isArray(notes) ? notes : []).map((n) => ({
        id: n.id,
        title: n.title,
        content: n.content,
        type: n.type === 'md' ? 'md' : 'text',
        updated_at: n.updated_at,
      }));
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
  }

  init();
})();
