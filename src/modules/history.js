/* ===== 历史记录模块（格式化 / 对比 / MD5 / 转换记录：恢复、删除、多选批量删除） ===== */
(function () {
  'use strict';

  const invoke = (window.__TAURI__ && window.__TAURI__.core && window.__TAURI__.core.invoke) || null;

  const MAX_ITEMS = 50;       // 每类最多保留条数
  const MAX_TEXT = 500_000;   // 单字段最大字符数，超过则不记录
  const SAVE_DELAY = 400;     // 保存防抖延迟

  // 内存数据（invoke 不可用时的降级 / 无头测试环境）
  const state = { json: [], diff: [], md5: [], str: [] };
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
      invoke('history_save', {
        data: { json: state.json, diff: state.diff, md5: state.md5, str: state.str },
      }).catch(function () { /* 保存失败不打断主流程 */ });
    }, SAVE_DELAY);
  }

  // 单条记录归一化（兼容旧数据缺字段）：id 缺失补生成、time 缺失补 0、各内容字段补空串/
  // 缺省类型；字段集合与 Rust 侧记录结构一一对应
  function normRec(kind, r) {
    const rec = r && typeof r === 'object' ? r : {};
    const id = rec.id || genId();
    const time = Number(rec.time) || 0;
    const str = function (v) { return String(v == null ? '' : v); };
    if (kind === 'json') {
      return { id, input: str(rec.input), output: str(rec.output), time };
    }
    if (kind === 'diff') {
      return { id, left: str(rec.left), right: str(rec.right), time };
    }
    if (kind === 'md5') {
      return {
        id,
        kind: rec.kind === 'file' ? 'file' : 'text',
        input: str(rec.input),
        hash: str(rec.hash),
        time,
      };
    }
    return { id, input: str(rec.input), time };
  }

  async function load() {
    if (!invoke) return;
    try {
      const data = await invoke('history_load');
      if (data) {
        for (const kind of ['json', 'diff', 'md5', 'str']) {
          if (Array.isArray(data[kind])) {
            state[kind] = data[kind]
              .filter((r) => r && typeof r === 'object')
              .map((r) => normRec(kind, r));
          }
        }
      }
    } catch (e) { /* 首次使用或文件损坏时按空数据继续 */ }
    ['json', 'diff', 'md5', 'str'].forEach(render);
  }

  // ---------- 数据操作 ----------

  function isDuplicate(kind, rec) {
    const top = state[kind][0];
    if (!top) return false;
    if (kind === 'json') return top.input === rec.input && top.output === rec.output;
    if (kind === 'diff') return top.left === rec.left && top.right === rec.right;
    if (kind === 'md5') return top.kind === rec.kind && top.input === rec.input && top.hash === rec.hash;
    return top.input === rec.input; // str
  }

  /**
   * 新增记录。返回 'ok' | 'dup'（与最新一条重复，跳过）| 'too-large'（内容过大，跳过）
   */
  function add(kind, rec) {
    if (kind === 'json') {
      if (rec.input.length > MAX_TEXT || rec.output.length > MAX_TEXT) return 'too-large';
    } else if (kind === 'diff') {
      if (rec.left.length > MAX_TEXT || rec.right.length > MAX_TEXT) return 'too-large';
    } else if (kind === 'md5') {
      if (rec.input.length > MAX_TEXT || rec.hash.length > MAX_TEXT) return 'too-large';
    } else if (rec.input.length > MAX_TEXT) {
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

  // ---------- 多选模式 ----------

  /** 在弹层头部插入“多选”按钮，并生成多选工具条（默认隐藏） */
  function buildMultiUI(kind) {
    const p = pane[kind];
    const head = p.pop.querySelector('.hist-head');
    p.head = head;

    const multiBtn = document.createElement('button');
    multiBtn.type = 'button';
    multiBtn.className = 'hist-multi';
    multiBtn.id = kind + '-history-multi';
    multiBtn.textContent = '多选';
    multiBtn.title = '多选：勾选记录后批量删除';
    head.insertBefore(multiBtn, p.clear);

    const bar = document.createElement('div');
    bar.className = 'hist-head hist-head-multi hidden';
    bar.id = kind + '-history-multi-bar';
    bar.innerHTML =
      '<span class="hist-title" id="' + kind + '-history-count">已选 0 项</span>' +
      '<div class="hist-actions">' +
      '<button class="hist-act" id="' + kind + '-history-selall">全选</button>' +
      '<button class="hist-act danger" id="' + kind + '-history-delsel" disabled>删除选中</button>' +
      '<button class="hist-act" id="' + kind + '-history-exit">取消</button>' +
      '</div>';
    head.after(bar);

    p.multiBtn = multiBtn;
    p.multiBar = bar;
    p.countEl = bar.querySelector('.hist-title');
    p.selAllBtn = bar.querySelector('#' + kind + '-history-selall');
    p.delSelBtn = bar.querySelector('#' + kind + '-history-delsel');

    multiBtn.addEventListener('click', function () { enterMulti(kind); });
    p.selAllBtn.addEventListener('click', function () { toggleSelectAll(kind); });
    p.delSelBtn.addEventListener('click', function () { deleteSelected(kind); });
    bar.querySelector('#' + kind + '-history-exit')
      .addEventListener('click', function () { exitMulti(kind); });
  }

  function enterMulti(kind) {
    const p = pane[kind];
    if (!p || p.multi || !state[kind].length) return;
    p.multi = true;
    p.selected.clear();
    p.head.classList.add('hidden');
    p.multiBar.classList.remove('hidden');
    p.pop.classList.add('hist-multi-mode');
    render(kind);
  }

  function exitMulti(kind) {
    const p = pane[kind];
    if (!p || !p.multi) return;
    p.multi = false;
    p.selected.clear();
    p.head.classList.remove('hidden');
    p.multiBar.classList.add('hidden');
    p.pop.classList.remove('hist-multi-mode');
    render(kind);
  }

  function toggleSelect(kind, id) {
    const p = pane[kind];
    if (p.selected.has(id)) p.selected.delete(id);
    else p.selected.add(id);
    render(kind);
  }

  function toggleSelectAll(kind) {
    const p = pane[kind];
    if (p.selected.size >= state[kind].length) p.selected.clear();
    else state[kind].forEach(function (r) { p.selected.add(r.id); });
    render(kind);
  }

  async function deleteSelected(kind) {
    const p = pane[kind];
    if (!p.multi || !p.selected.size) return;
    const n = p.selected.size;
    const ok = await window.showConfirm('确定删除选中的 ' + n + ' 条' + p.label + '？此操作不可恢复。', {
      title: '删除选中',
      okText: '删除',
    });
    if (!ok) return;
    state[kind] = state[kind].filter(function (r) { return !p.selected.has(r.id); });
    scheduleSave();
    exitMulti(kind);
  }

  function updateMultiBar(kind) {
    const p = pane[kind];
    if (!p || !p.multiBar) return;
    const total = state[kind].length;
    const n = p.selected.size;
    p.countEl.textContent = '已选 ' + n + ' 项';
    p.selAllBtn.textContent = total && n >= total ? '取消全选' : '全选';
    p.delSelBtn.disabled = !n;
    p.multiBtn.disabled = !total;
  }

  // ---------- 渲染 ----------

  function summaryHtml(kind, rec) {
    if (kind === 'json') {
      return '<div class="hist-item-summary">' + esc(digest(rec.input, 90)) + '</div>';
    }
    if (kind === 'diff') {
      return '<div class="hist-item-lines">' +
        '<div class="hist-line"><span class="hist-tag tag-left">左</span>' +
        esc(digest(rec.left, 60)) + '</div>' +
        '<div class="hist-line"><span class="hist-tag tag-right">右</span>' +
        esc(digest(rec.right, 60)) + '</div></div>';
    }
    if (kind === 'md5') {
      return '<div class="hist-item-lines">' +
        '<div class="hist-line"><span class="hist-tag tag-kind">' +
        (rec.kind === 'file' ? '件' : '文') + '</span>' + esc(digest(rec.input, 46)) + '</div>' +
        '<div class="hist-line hist-hash">' + esc(rec.hash) + '</div></div>';
    }
    // str
    return '<div class="hist-item-summary">' + esc(digest(rec.input, 90)) + '</div>';
  }

  function render(kind) {
    const p = pane[kind];
    if (!p) return;
    const list = state[kind];
    p.list.innerHTML = '';
    p.clear.disabled = !list.length;
    if (!list.length) {
      p.list.innerHTML = '<div class="hist-empty">暂无记录</div>';
      updateMultiBar(kind);
      return;
    }
    for (const rec of list) {
      const selected = p.multi && p.selected.has(rec.id);
      const item = document.createElement('div');
      item.className = 'hist-item' + (selected ? ' selected' : '');
      item.dataset.id = rec.id;
      item.title = p.multi ? '点击勾选 / 取消勾选' : '点击恢复此记录';
      item.innerHTML =
        (p.multi ? '<span class="hist-check">' + (selected ? '✓' : '') + '</span>' : '') +
        '<div class="hist-item-main">' + summaryHtml(kind, rec) +
        '<div class="hist-item-time">' + formatTime(rec.time) + '</div></div>' +
        (p.multi ? '' : '<button class="hist-item-del" title="删除该记录">×</button>');
      p.list.appendChild(item);
    }
    updateMultiBar(kind);
  }

  // ---------- 弹层开关 ----------

  function closePop() {
    if (!openKind) return;
    const kind = openKind;
    openKind = null;
    const p = pane[kind];
    if (p) {
      if (p.multi) exitMulti(kind);
      p.pop.classList.add('hidden');
      p.btn.classList.remove('active');
    }
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
    opts.multi = false;
    opts.selected = new Set();
    pane[kind] = opts;
    buildMultiUI(kind);

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
      if (pane[kind].multi) {
        // 多选模式：点击整条切换勾选
        toggleSelect(kind, item.dataset.id);
        return;
      }
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

  // 点击空白处关闭弹层
  document.addEventListener('click', function () { closePop(); });

  window.historyStore = {
    add: add,
    bindPanel: bindPanel,
  };

  load();
})();
