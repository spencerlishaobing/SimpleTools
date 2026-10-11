/* ===== 记事本模块（本地缓存 + 拖动排序） ===== */
(function () {
  'use strict';

  const invoke = (window.__TAURI__ && window.__TAURI__.core && window.__TAURI__.core.invoke) || null;

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

  const state = {
    notes: [],      // [{ id, title, content, updated_at }]
    currentId: null,
  };

  const multi = { active: false, selected: new Set() };  // 批量操作（多选）模式

  const SAVE_DELAY = 500;
  let saveTimer = null;
  let saving = false;

  // ---------- 工具 ----------

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
    listEl.innerHTML = '';
    for (const n of state.notes) {
      const selected = multi.active && multi.selected.has(n.id);
      const li = document.createElement('li');
      li.className = 'note-item' + (n.id === state.currentId ? ' active' : '') +
        (selected ? ' selected' : '');
      li.dataset.id = n.id;
      li.draggable = !multi.active;
      li.innerHTML =
        (multi.active ? '<span class="note-check">' + (selected ? '✓' : '') + '</span>' : '') +
        '<div class="note-item-title">' + esc(n.title || '未命名') + '</div>' +
        '<div class="note-item-meta">' + formatTime(n.updated_at) + '</div>' +
        '<button class="note-item-remove" title="删除该记录">×</button>';
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
    emptyEl.style.display = state.notes.length ? 'none' : 'block';
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
    renderList();
  }

  // ---------- 操作 ----------

  function createNote() {
    const now = Date.now();
    const note = { id: genId(), title: '新记录', content: '', updated_at: now };
    state.notes.unshift(note);
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
      } else {
        editorEl.classList.add('hidden');
        titleEl.value = '';
        contentEl.value = '';
        metaEl.textContent = '';
      }
    }
    exitMulti();
    scheduleSave(true);
  }

  // ---------- 编辑事件 ----------

  function getLi(id) {
    return listEl.querySelector('.note-item[data-id="' + id + '"]');
  }

  titleEl.addEventListener('input', () => {
    const note = getCurrent();
    if (!note) return;
    note.title = titleEl.value;
    note.updated_at = Date.now();
    const li = getLi(note.id);
    if (li) {
      li.querySelector('.note-item-title').textContent = note.title || '未命名';
      li.querySelector('.note-item-meta').textContent = formatTime(note.updated_at);
    }
    scheduleSave();
  });

  contentEl.addEventListener('input', () => {
    const note = getCurrent();
    if (!note) return;
    note.content = contentEl.value;
    note.updated_at = Date.now();
    const li = getLi(note.id);
    if (li) li.querySelector('.note-item-meta').textContent = formatTime(note.updated_at);
    scheduleSave();
  });

  // 失焦时立即落盘，减少关窗丢数据的窗口期
  window.addEventListener('blur', () => doSave(true));

  document.getElementById('note-new').addEventListener('click', createNote);
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

  multiBtn.addEventListener('click', enterMulti);
  multiExitBtn.addEventListener('click', exitMulti);
  selAllBtn.addEventListener('click', toggleSelectAll);
  delSelBtn.addEventListener('click', deleteSelected);

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
      state.notes = Array.isArray(notes) ? notes : [];
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
