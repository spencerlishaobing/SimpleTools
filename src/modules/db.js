/* ===== 数据库查询模块（v0.37.0：SQLite .db 文件只读查询 + 输入智能提示） =====
   打开数据库（db_open）读取 schema（表 / 视图 + 列），前端据表名 / 字段名 / SQL 关键字
   构建输入补全候选（前缀匹配优先，↑↓ 选择、Enter / Tab 补全、Esc 关闭）；
   执行查询（db_query，只读连接）渲染结果表格（NULL 灰色 / 数字右对齐 / 行号列）。 */
(function () {
  'use strict';

  const invoke = (window.__TAURI__ && window.__TAURI__.core && window.__TAURI__.core.invoke) || null;
  const dialogApi = (window.__TAURI__ && window.__TAURI__.dialog) || null;

  // ---------- DOM ----------
  const openBtn = document.getElementById('db-open');
  const filePillEl = document.getElementById('db-file-pill');
  const emptyStateEl = document.getElementById('db-empty-state');
  const bodyEl = document.getElementById('db-body');
  const tableCountEl = document.getElementById('db-table-count');
  const tablesEl = document.getElementById('db-tables');
  const editorEl = document.getElementById('db-editor');
  const suggestEl = document.getElementById('db-suggest');
  const runBtn = document.getElementById('db-run');
  const statusEl = document.getElementById('db-status');
  const resultEl = document.getElementById('db-result');
  const resultEmptyEl = document.getElementById('db-result-empty');

  /** SQL 关键字（输入补全用；执行时大小写不敏感） */
  const SQL_KEYWORDS = [
    'SELECT', 'FROM', 'WHERE', 'GROUP', 'BY', 'HAVING', 'ORDER', 'LIMIT', 'OFFSET',
    'JOIN', 'LEFT', 'RIGHT', 'INNER', 'OUTER', 'CROSS', 'ON', 'AS', 'ASC', 'DESC',
    'AND', 'OR', 'NOT', 'IN', 'IS', 'LIKE', 'GLOB', 'BETWEEN', 'EXISTS', 'CASE',
    'WHEN', 'THEN', 'ELSE', 'END', 'DISTINCT', 'UNION', 'ALL', 'WITH',
    'INSERT', 'INTO', 'VALUES', 'UPDATE', 'SET', 'DELETE', 'CREATE', 'TABLE',
    'INDEX', 'VIEW', 'DROP', 'ALTER', 'PRAGMA',
    'COUNT', 'SUM', 'AVG', 'MIN', 'MAX', 'TOTAL', 'COALESCE', 'IFNULL', 'NULLIF',
    'CAST', 'SUBSTR', 'LENGTH', 'UPPER', 'LOWER', 'TRIM', 'LTRIM', 'RTRIM',
    'REPLACE', 'ROUND', 'ABS', 'DATE', 'TIME', 'DATETIME', 'STRFTIME', 'JULIANDAY',
    'NULL', 'TRUE', 'FALSE', 'INTEGER', 'TEXT', 'REAL', 'BLOB', 'NUMERIC',
    'PRIMARY', 'KEY', 'AUTOINCREMENT', 'DEFAULT', 'UNIQUE', 'CHECK',
  ];
  /** 最多显示的补全项数 */
  const SUGGEST_MAX = 10;

  const state = {
    info: null,          // DbInfo（打开后）
    candidates: [],      // 全部补全候选：{ label, kind: kw|table|col, table? }
    suggestItems: [],    // 当前下拉项
    suggestIndex: 0,
  };

  // ---------- 小工具 ----------

  function esc(s) {
    return String(s == null ? '' : s)
      .replace(/&/g, '&amp;')
      .replace(/</g, '&lt;')
      .replace(/>/g, '&gt;')
      .replace(/"/g, '&quot;');
  }

  function fmtSize(n) {
    if (!n) return '0 B';
    if (n < 1024) return n + ' B';
    if (n < 1024 * 1024) return (n / 1024).toFixed(1) + ' KB';
    return (n / 1024 / 1024).toFixed(1) + ' MB';
  }

  // ---------- 打开数据库 ----------

  function buildCandidates(info) {
    const list = [];
    SQL_KEYWORDS.forEach(function (k) {
      list.push({ label: k, kind: 'kw' });
    });
    ((info && info.tables) || []).forEach(function (t) {
      list.push({ label: t.name, kind: 'table' });
      (t.columns || []).forEach(function (c) {
        list.push({ label: c.name, kind: 'col', table: t.name });
      });
    });
    return list;
  }

  function applyDb(info) {
    state.info = info;
    state.candidates = buildCandidates(info);
    emptyStateEl.classList.add('hidden');
    bodyEl.classList.remove('hidden');
    filePillEl.classList.remove('hidden');
    filePillEl.textContent = info.name + ' · ' + ((info.tables || []).length) + ' 张表';
    filePillEl.title = info.path + '（' + fmtSize(info.size) + ' · 只读打开）';
    renderTables();
    resultEl.innerHTML = '';
    resultEmptyEl.classList.remove('hidden');
    statusEl.textContent = '已打开 ' + info.name + '，输入 SQL 后点击「执行查询」';
    statusEl.classList.remove('is-error');
    editorEl.focus();
  }

  openBtn.addEventListener('click', async function () {
    if (!invoke || !dialogApi) return;
    let path = null;
    try {
      path = await dialogApi.open({
        title: '打开 SQLite 数据库',
        multiple: false,
        filters: [{ name: 'SQLite 数据库', extensions: ['db', 'sqlite', 'sqlite3', 'db3'] }],
      });
    } catch (e) {
      return;
    }
    if (!path) return; // 用户取消
    const p = typeof path === 'string' ? path : path[0];
    try {
      const info = await invoke('db_open', { path: p });
      applyDb(info);
      window.toast('已打开 ' + info.name + '（只读）');
    } catch (e) {
      window.toast('打开失败：' + (e && e.message ? e.message : e));
    }
  });

  // ---------- 表结构侧栏 ----------

  function renderTables() {
    const tables = (state.info && state.info.tables) || [];
    tableCountEl.textContent = tables.length + ' 张';
    tablesEl.innerHTML = tables.map(function (t) {
      const cols = (t.columns || []).map(function (c) {
        return '<div class="db-col-item" data-col="' + esc(c.name) + '" title="点击插入列名">' +
          '<span class="db-col-name">' + esc(c.name) + '</span>' +
          '<span class="db-col-type">' + esc(c.decl_type || '') + '</span>' +
          (c.pk ? '<span class="db-col-pk">PK</span>' : '') +
          '</div>';
      }).join('');
      return '<div class="db-table-item">' +
        '<div class="db-table-row" title="点击展开 / 收起列">' +
        '<span class="db-table-arrow">›</span>' +
        '<span class="db-table-name">' + esc(t.name) + '</span>' +
        '<span class="db-table-kind">' + (t.kind === 'view' ? '视图' : '') + '</span>' +
        '<span class="db-table-colcount">' + (t.columns || []).length + '</span>' +
        '</div>' +
        '<div class="db-col-list hidden">' + cols + '</div>' +
        '</div>';
    }).join('');
  }

  tablesEl.addEventListener('click', function (e) {
    // 列项：插入列名到编辑器
    const colItem = e.target.closest('.db-col-item');
    if (colItem) {
      insertAtCursor(colItem.dataset.col);
      return;
    }
    // 表行：展开 / 收起列列表
    const row = e.target.closest('.db-table-row');
    if (!row) return;
    const item = row.closest('.db-table-item');
    const list = item.querySelector('.db-col-list');
    const open = !list.classList.contains('hidden');
    list.classList.toggle('hidden', open);
    row.querySelector('.db-table-arrow').classList.toggle('open', !open);
  });

  // ---------- 编辑器插入与补全 ----------

  /** 光标前的标识符 token（字母 / 数字 / 下划线） */
  function currentToken() {
    const pos = editorEl.selectionStart;
    const m = editorEl.value.slice(0, pos).match(/[A-Za-z_][A-Za-z0-9_]*$/);
    return m ? m[0] : '';
  }

  function insertAtCursor(text) {
    const pos = editorEl.selectionStart;
    const before = editorEl.value.slice(0, pos);
    const after = editorEl.value.slice(pos);
    const pad = before && !/[\s(,]$/.test(before) ? ' ' : '';
    const insert = pad + text + ' ';
    editorEl.value = before + insert + after;
    editorEl.selectionStart = editorEl.selectionEnd = pos + insert.length;
    editorEl.focus();
    closeSuggest();
  }

  function closeSuggest() {
    suggestEl.classList.add('hidden');
    state.suggestItems = [];
    state.suggestIndex = 0;
  }

  function renderSuggest() {
    suggestEl.innerHTML = state.suggestItems.map(function (c, i) {
      const kindLabel = c.kind === 'kw' ? 'K' : (c.kind === 'table' ? 'T' : 'C');
      const sub = c.kind === 'col' && c.table
        ? '<span class="db-suggest-sub">' + esc(c.table) + '</span>'
        : '';
      return '<div class="db-suggest-item' + (i === state.suggestIndex ? ' active' : '') + '" data-i="' + i + '" title="' +
        (c.kind === 'kw' ? '关键字' : (c.kind === 'table' ? '表' : '字段' + (c.table ? '（' + esc(c.table) + '）' : ''))) + '">' +
        '<span class="db-suggest-kind k-' + c.kind + '">' + kindLabel + '</span>' +
        '<span class="db-suggest-label">' + esc(c.label) + '</span>' + sub + '</div>';
    }).join('');
    const active = suggestEl.querySelector('.db-suggest-item.active');
    if (active) active.scrollIntoView({ block: 'nearest' });
  }

  /** 输入变化：按光标 token 生成候选（前缀匹配优先，按 关键字 → 表 → 字段 排序） */
  function updateSuggest() {
    const tok = currentToken();
    if (!tok || !state.info) {
      closeSuggest();
      return;
    }
    const lower = tok.toLowerCase();
    const prefix = [];
    const contains = [];
    state.candidates.forEach(function (c) {
      const l = c.label.toLowerCase();
      if (l === lower) return; // 与输入完全一致不再提示
      if (l.startsWith(lower)) prefix.push(c);
      else if (l.indexOf(lower) >= 0) contains.push(c);
    });
    const rank = { kw: 0, table: 1, col: 2 };
    const sorter = function (a, b) {
      return (rank[a.kind] - rank[b.kind]) || (a.label.length - b.label.length) || a.label.localeCompare(b.label);
    };
    prefix.sort(sorter);
    contains.sort(sorter);
    const items = prefix.concat(contains).slice(0, SUGGEST_MAX);
    if (!items.length) {
      closeSuggest();
      return;
    }
    state.suggestItems = items;
    state.suggestIndex = 0;
    renderSuggest();
    suggestEl.classList.remove('hidden');
  }

  function moveSuggest(delta) {
    const n = state.suggestItems.length;
    if (!n) return;
    state.suggestIndex = (state.suggestIndex + delta + n) % n;
    renderSuggest();
  }

  /** 应用补全：替换光标前的 token；关键字后补空格 */
  function applySuggest(i) {
    const c = state.suggestItems[i];
    if (!c) return;
    const pos = editorEl.selectionStart;
    const before = editorEl.value.slice(0, pos);
    const after = editorEl.value.slice(pos);
    const m = before.match(/[A-Za-z_][A-Za-z0-9_]*$/);
    const start = m ? pos - m[0].length : pos;
    const insert = c.label + (c.kind === 'kw' ? ' ' : '');
    editorEl.value = before.slice(0, start) + insert + after;
    editorEl.selectionStart = editorEl.selectionEnd = start + insert.length;
    closeSuggest();
    editorEl.focus();
  }

  editorEl.addEventListener('input', updateSuggest);
  editorEl.addEventListener('keydown', function (e) {
    if (suggestEl.classList.contains('hidden')) return;
    if (e.key === 'ArrowDown') {
      e.preventDefault();
      moveSuggest(1);
    } else if (e.key === 'ArrowUp') {
      e.preventDefault();
      moveSuggest(-1);
    } else if (e.key === 'Enter' || e.key === 'Tab') {
      e.preventDefault();
      applySuggest(state.suggestIndex);
    } else if (e.key === 'Escape') {
      e.preventDefault();
      closeSuggest();
    }
  });
  editorEl.addEventListener('blur', function () {
    setTimeout(closeSuggest, 150);
  });
  // 下拉内点击：阻止默认（避免编辑器失焦）后应用补全
  suggestEl.addEventListener('mousedown', function (e) {
    e.preventDefault();
  });
  suggestEl.addEventListener('click', function (e) {
    const item = e.target.closest('.db-suggest-item');
    if (item) applySuggest(Number(item.dataset.i));
  });

  // ---------- 执行查询与结果渲染 ----------

  function renderResult(res) {
    const rows = res.rows || [];
    const cols = res.columns || [];
    let h = '<table class="db-table"><thead><tr><th class="db-idx">#</th>';
    cols.forEach(function (c) {
      h += '<th>' + esc(c) + '</th>';
    });
    h += '</tr></thead><tbody>';
    rows.forEach(function (r, i) {
      h += '<tr><td class="db-idx">' + (i + 1) + '</td>';
      r.forEach(function (v) {
        if (v === null) h += '<td class="db-null">NULL</td>';
        else if (typeof v === 'number') h += '<td class="db-num">' + esc(v) + '</td>';
        else h += '<td>' + esc(v) + '</td>';
      });
      h += '</tr>';
    });
    h += '</tbody></table>';
    resultEl.innerHTML = h;
    resultEmptyEl.classList.add('hidden');
    const parts = [rows.length + ' 行', res.elapsed_ms + ' ms'];
    if (res.truncated) parts.push('已截断（仅显示前 5000 行）');
    statusEl.textContent = '查询完成：' + parts.join(' · ');
    statusEl.classList.remove('is-error');
  }

  function renderError(msg) {
    resultEl.innerHTML = '<div class="db-error">' + esc(msg) + '</div>';
    resultEmptyEl.classList.add('hidden');
    statusEl.textContent = '查询出错';
    statusEl.classList.add('is-error');
  }

  async function runQuery() {
    if (!invoke || !state.info) return;
    const sql = editorEl.value.trim();
    if (!sql) {
      window.toast('请输入 SQL 语句');
      editorEl.focus();
      return;
    }
    runBtn.disabled = true;
    statusEl.textContent = '查询中…';
    statusEl.classList.remove('is-error');
    try {
      const res = await invoke('db_query', { path: state.info.path, sql: sql });
      renderResult(res);
    } catch (e) {
      renderError(e && e.message ? e.message : String(e));
    }
    runBtn.disabled = false;
  }

  runBtn.addEventListener('click', runQuery);
})();
