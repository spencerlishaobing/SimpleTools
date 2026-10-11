/* ===== 历史记录模块（JSON 格式化记录 / 文本对比记录） ===== */
(function () {
  'use strict';

  const invoke = (window.__TAURI__ && window.__TAURI__.core && window.__TAURI__.core.invoke) || null;

  const MAX_ITEMS = 50;       // 每类最多保留条数
  const MAX_TEXT = 500_000;   // 单字段最大字符数，超过则不记录
  const SAVE_DELAY = 400;     // 保存防抖延迟

  // 内存数据（invoke 不可用时的降级 / 无头测试环境）
  const state = { json: [], diff: [] };
  const pane = {};            // kind → { btn, pop, list, clear, onRestore }
  let openKind = null;
  let saveTimer = null;

  // ---------- 工具 ----------

  const ESC_MAP = { '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;', "'": '&#39;' };
  function esc(s) {
    return String(s).replace(/[&<>"']/g, (c) => ESC_MAP[c]);
  }

  function genId() {
    if (window.crypto && crypto.randomUUID) return crypto.randomUUID();
    return 'h-' + Date.now() + '-' + Math.random().toString(16).slice(2);
  }

  function pad2(x) {
    return String(x).padStart(2, '0');
  }

  function formatTime(ts) {
    const d = new Date(ts);
    return pad2(d.getMonth() + 1) + '-' + pad2(d.getDate()) + ' ' +
      pad2(d.getHours()) + ':' + pad2(d.getMinutes()) + ':' + pad2(d.getSeconds());
  }

  /** 生成单行摘要：折叠空白并截断 */
  function digest(text, max) {
    const s = String(text || '').replace(/\s+/g, ' ').trim();
    if (!s) return '（空）';
    return s.length > max ? s.slice(0, max) + '…' : s;
  }

  // ---------- 持久化 ----------

  function scheduleSave() {
    if (!invoke) return;
    clearTimeout(saveTimer);
    saveTimer = setTimeout(function () {
      invoke('history_save', { data: { json: state.json, diff: state.diff } })
        .catch(function () { /* 保存失败不打断主流程 */ });
    }, SAVE_DELAY);
  }

  async function load() {
    if (!invoke) return;
    try {
      const data = await invoke('history_load');
      if (data) {
        if (Array.isArray(data.json)) state.json = data.json;
        if (Array.isArray(data.diff)) state.diff = data.diff;
      }
    } catch (e) { /* 首次使用或文件损坏时按空数据继续 */ }
    render('json');
    render('diff');
  }

  // ---------- 数据操作 ----------

  function isDuplicate(kind, rec) {
    const top = state[kind][0];
    if (!top) return false;
    if (kind === 'json') return top.input === rec.input && top.output === rec.output;
    return top.left === rec.left && top.right === rec.right;
  }

  /**
   * 新增记录。返回 'ok' | 'dup'（与最新一条重复，跳过）| 'too-large'（内容过大，跳过）
   */
  function add(kind, rec) {
    if (kind === 'json') {
      if (rec.input.length > MAX_TEXT || rec.output.length > MAX_TEXT) return 'too-large';
    } else if (rec.left.length > MAX_TEXT || rec.right.length > MAX_TEXT) {
      return 'too-large';
    }
    if (isDuplicate(kind, rec)) return 'dup';
    rec.id = genId();
    rec.time = Date.now();
    state[kind].unshift(rec);
    if (state[kind].length > MAX_ITEMS) state[kind].length = MAX_ITEMS;
    scheduleSave();
    render(kind);
    return 'ok';
  }

  function removeItem(kind, id) {
    const idx = state[kind].findIndex(function (r) { return r.id === id; });
    if (idx < 0) return;
    state[kind].splice(idx, 1);
    scheduleSave();
    render(kind);
  }

  function clearAll(kind) {
    state[kind] = [];
    scheduleSave();
    render(kind);
  }

  // ---------- 渲染 ----------

  function summaryHtml(kind, rec) {
    if (kind === 'json') {
      return '<div class="hist-item-summary">' + esc(digest(rec.input, 90)) + '</div>';
    }
    return '<div class="hist-item-lines">' +
      '<div class="hist-line"><span class="hist-tag tag-left">左</span>' +
      esc(digest(rec.left, 60)) + '</div>' +
      '<div class="hist-line"><span class="hist-tag tag-right">右</span>' +
      esc(digest(rec.right, 60)) + '</div></div>';
  }

  function render(kind) {
    const p = pane[kind];
    if (!p) return;
    const list = state[kind];
    p.list.innerHTML = '';
    p.clear.disabled = !list.length;
    if (!list.length) {
      p.list.innerHTML = '<div class="hist-empty">暂无记录</div>';
      return;
    }
    for (const rec of list) {
      const item = document.createElement('div');
      item.className = 'hist-item';
      item.dataset.id = rec.id;
      item.title = '点击恢复此记录';
      item.innerHTML =
        '<div class="hist-item-main">' + summaryHtml(kind, rec) +
        '<div class="hist-item-time">' + formatTime(rec.time) + '</div></div>' +
        '<button class="hist-item-del" title="删除该记录">×</button>';
      p.list.appendChild(item);
    }
  }

  // ---------- 弹层开关 ----------

  function closePop() {
    if (!openKind) return;
    const p = pane[openKind];
    if (p) {
      p.pop.classList.add('hidden');
      p.btn.classList.remove('active');
    }
    openKind = null;
  }

  function togglePop(kind) {
    const wasOpen = openKind === kind;
    closePop();
    if (wasOpen) return;
    const p = pane[kind];
    p.pop.classList.remove('hidden');
    p.btn.classList.add('active');
    openKind = kind;
  }

  // ---------- 绑定面板 ----------

  /**
   * 为一个面板绑定历史记录下拉。
   * opts: { kind, label, btn, pop, list, clear, onRestore(record) }
   */
  function bindPanel(opts) {
    const kind = opts.kind;
    pane[kind] = opts;

    opts.btn.addEventListener('click', function (e) {
      e.stopPropagation();
      togglePop(kind);
    });

    opts.pop.addEventListener('click', function (e) {
      e.stopPropagation(); // 点击弹层内部不关闭
    });

    opts.list.addEventListener('click', function (e) {
      const item = e.target.closest('.hist-item');
      if (!item) return;
      if (e.target.closest('.hist-item-del')) {
        removeItem(kind, item.dataset.id);
        return;
      }
      const rec = state[kind].find(function (r) { return r.id === item.dataset.id; });
      if (rec) {
        closePop();
        opts.onRestore(rec);
      }
    });

    opts.clear.addEventListener('click', async function () {
      if (!state[kind].length) return;
      const ok = await window.showConfirm('确定清空全部' + opts.label + '？此操作不可恢复。', {
        title: '清空' + opts.label,
        okText: '清空',
      });
      if (ok) clearAll(kind);
    });

    render(kind);
  }

  // 点击空白处或按 Esc 关闭弹层
  document.addEventListener('click', function () { closePop(); });
  document.addEventListener('keydown', function (e) {
    if (e.key === 'Escape') closePop();
  });

  window.historyStore = {
    add: add,
    bindPanel: bindPanel,
  };

  load();
})();
