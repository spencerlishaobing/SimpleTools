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

  const state = {
    notes: [],      // [{ id, title, content, updated_at }]
    currentId: null,
  };

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
      const li = document.createElement('li');
      li.className = 'note-item' + (n.id === state.currentId ? ' active' : '');
      li.dataset.id = n.id;
      li.draggable = true;
      li.innerHTML =
        '<div class="note-item-title">' + esc(n.title || '未命名') + '</div>' +
        '<div class="note-item-meta">' + formatTime(n.updated_at) + '</div>' +
        '<button class="note-item-remove" title="删除该记录">×</button>';
      li.addEventListener('click', () => selectNote(n.id));
      li.querySelector('.note-item-remove').addEventListener('click', (e) => {
        e.stopPropagation();
        removeNote(n.id);
      });
      listEl.appendChild(li);
    }
    emptyEl.style.display = state.notes.length ? 'none' : 'block';
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
