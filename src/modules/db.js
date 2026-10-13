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
  const pagerEl = document.getElementById('db-pager');
  const pagerInfoEl = document.getElementById('db-pager-info');
  const pageSizeEl = document.getElementById('db-page-size');
  const pageFirstBtn = document.getElementById('db-page-first');
  const pagePrevBtn = document.getElementById('db-page-prev');
  const pageNextBtn = document.getElementById('db-page-next');
  const pageLastBtn = document.getElementById('db-page-last');
  const pageInputEl = document.getElementById('db-page-input');
  const pageTotalEl = document.getElementById('db-page-total');
  const rownumToggleBtn = document.getElementById('db-rownum-toggle');

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
    // 分页（v0.41.0）
    page: 1,
    pageSize: 100,
    total: 0,
    paged: false,        // 后端是否为分页模式（PRAGMA 等回退语句为 false）
    lastSql: '',         // 最近一次执行的 SQL（翻页 / 跳页 / 改每页数量均基于它）
    lastResult: null,    // 最近一次结果（切换行号口径时本地重渲染）
    rownumMode: 'total', // total（按数据总数编号）| page（按每页编号）
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
    // 重置查询与分页状态
    state.page = 1;
    state.total = 0;
    state.paged = false;
    state.lastSql = '';
    state.lastResult = null;
    pagerEl.classList.add('hidden');
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
        '<span class="db-table-arrow">▸</span>' +
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

  /** 整体设置编辑器内容（光标置于末尾） */
  function setEditorValue(v) {
    editorEl.value = v;
    editorEl.selectionStart = editorEl.selectionEnd = v.length;
    closeSuggest();
  }

  /** 标识符加双引号（防表名含特殊字符破坏 SQL） */
  function quoteIdent(name) {
    return '"' + String(name).replace(/"/g, '""') + '"';
  }

  // 双击表名行：查询该表数据（SELECT * FROM "表名"，v0.41.0）
  // 单击仍为展开 / 收起：双击的两次 click 会抵消展开状态，最终仅触发查询
  tablesEl.addEventListener('dblclick', function (e) {
    const row = e.target.closest('.db-table-row');
    if (!row || !invoke || !state.info) return;
    const nameEl = row.querySelector('.db-table-name');
    if (!nameEl) return;
    const sql = 'SELECT * FROM ' + quoteIdent(nameEl.textContent);
    setEditorValue(sql);
    runQuery(1);
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

  /**
   * 测量编辑器光标相对元素左上角的坐标（v0.45.0：镜像测量法）。
   * 原理：创建与编辑器排版一致的隐藏镜像元素，在光标前文本末尾插入零宽标记，
   * 读取标记的 offsetTop / offsetLeft（兼容换行 / 中英文混合 / 自动换行）。
   */
  function caretPosition() {
    const cs = getComputedStyle(editorEl);
    let mirror = document.getElementById('db-caret-mirror');
    if (!mirror) {
      mirror = document.createElement('div');
      mirror.id = 'db-caret-mirror';
      document.body.appendChild(mirror);
    }
    ['fontFamily', 'fontSize', 'fontWeight', 'fontStyle', 'letterSpacing', 'lineHeight',
      'paddingTop', 'paddingRight', 'paddingBottom', 'paddingLeft',
      'borderTopWidth', 'borderLeftWidth', 'boxSizing', 'tabSize'].forEach(function (k) {
      mirror.style[k] = cs[k];
    });
    mirror.style.position = 'absolute';
    mirror.style.left = '-9999px';
    mirror.style.top = '0';
    mirror.style.visibility = 'hidden';
    mirror.style.pointerEvents = 'none';
    mirror.style.whiteSpace = 'pre-wrap';
    mirror.style.wordWrap = 'break-word';
    mirror.style.overflowWrap = 'break-word';
    mirror.style.width = editorEl.clientWidth + 'px';
    mirror.style.height = 'auto';
    mirror.textContent = editorEl.value.slice(0, editorEl.selectionStart);
    const marker = document.createElement('span');
    marker.textContent = '\u200b';
    mirror.appendChild(marker);
    const lineHeight = parseFloat(cs.lineHeight) || 20;
    const pos = { left: marker.offsetLeft, top: marker.offsetTop, lineHeight: lineHeight };
    mirror.textContent = '';
    return pos;
  }

  /** 把提示下拉定位到光标（输入文字）下方（v0.45.0）；右侧边界超出时向左收敛 */
  function positionSuggest() {
    const caret = caretPosition();
    let left = editorEl.offsetLeft + caret.left;
    const top = editorEl.offsetTop + caret.top - editorEl.scrollTop + caret.lineHeight + 4;
    const maxLeft = editorEl.offsetLeft + editorEl.clientWidth - 230;
    if (left > maxLeft) left = Math.max(editorEl.offsetLeft, maxLeft);
    suggestEl.style.left = left + 'px';
    suggestEl.style.top = top + 'px';
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
    positionSuggest();
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

  /** 行复制图标（v0.44.0：复制该行为 JSON 数据） */
  const ROW_COPY_SVG = '<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" aria-hidden="true"><rect x="9" y="9" width="13" height="13" rx="2" ry="2" /><path d="M5 15H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h9a2 2 0 0 1 2 2v1" /></svg>';

  function renderResult(res) {
    const rows = res.rows || [];
    const cols = res.columns || [];
    // 行号口径：total = 按数据总数（跨页连续编号）；page = 按每页（当前页内 1 起）
    const base = state.rownumMode === 'total' && res.paged ? (res.page - 1) * res.page_size : 0;
    let h = '<table class="db-table"><thead><tr><th class="db-idx">#</th>';
    cols.forEach(function (c) {
      h += '<th>' + esc(c) + '</th>';
    });
    h += '<th class="db-copy-col" title="每行可复制为 JSON"></th></tr></thead><tbody>';
    rows.forEach(function (r, i) {
      h += '<tr><td class="db-idx">' + (base + i + 1) + '</td>';
      r.forEach(function (v) {
        if (v === null) h += '<td class="db-null">NULL</td>';
        else if (typeof v === 'number') h += '<td class="db-num">' + esc(v) + '</td>';
        else h += '<td>' + esc(v) + '</td>';
      });
      h += '<td class="db-copy-col"><button class="db-row-copy" data-row="' + i + '" title="复制该行（JSON）">' + ROW_COPY_SVG + '</button></td>';
      h += '</tr>';
    });
    h += '</tbody></table>';
    resultEl.innerHTML = h;
    resultEmptyEl.classList.add('hidden');
    const parts = [(res.paged ? '本页 ' : '') + rows.length + ' 行', res.elapsed_ms + ' ms'];
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

  // 行复制（v0.44.0）：把该行输出为 JSON（列名 → 值；重复列名自动加 _2 / _3 后缀防覆盖）
  resultEl.addEventListener('click', function (e) {
    const btn = e.target.closest('.db-row-copy');
    if (!btn || !state.lastResult) return;
    const idx = Number(btn.dataset.row);
    const rows = state.lastResult.rows || [];
    const cols = state.lastResult.columns || [];
    const row = rows[idx];
    if (!row) return;
    const counter = {};
    const obj = {};
    cols.forEach(function (c, i) {
      let key = c;
      if (counter[key] != null) {
        counter[key] += 1;
        key = c + '_' + counter[key];
      } else {
        counter[key] = 1;
      }
      obj[key] = i < row.length ? row[i] : null;
    });
    window.copyText(JSON.stringify(obj, null, 2), '已复制该行 JSON');
  });

  // ---------- 分页（v0.41.0） ----------

  function totalPages() {
    return Math.max(1, Math.ceil(state.total / (state.pageSize || 1)));
  }

  function updateRownumToggle() {
    rownumToggleBtn.textContent = state.rownumMode === 'total' ? '行号：总计' : '行号：每页';
  }

  function renderPager(res) {
    if (!res.paged) {
      pagerEl.classList.add('hidden');
      return;
    }
    pagerEl.classList.remove('hidden');
    const tp = totalPages();
    if (res.total === 0) {
      pagerInfoEl.textContent = '共 0 条';
    } else {
      const startN = (res.page - 1) * res.page_size + 1;
      const endN = Math.min(res.page * res.page_size, res.total);
      pagerInfoEl.textContent = '第 ' + startN + '-' + endN + ' 条 · 共 ' + res.total + ' 条';
    }
    pageSizeEl.value = state.pageSize;
    pageInputEl.value = res.page;
    pageInputEl.max = tp;
    pageTotalEl.textContent = tp;
    pageFirstBtn.disabled = pagePrevBtn.disabled = res.page <= 1;
    pageNextBtn.disabled = pageLastBtn.disabled = res.page >= tp;
    updateRownumToggle();
  }

  /** 执行指定 SQL（翻页 / 跳页 / 改每页数量共用；记录 lastSql 供后续翻页） */
  async function execSql(sql, page) {
    runBtn.disabled = true;
    statusEl.textContent = '查询中…';
    statusEl.classList.remove('is-error');
    try {
      const res = await invoke('db_query', {
        path: state.info.path,
        sql: sql,
        page: page || 1,
        size: state.pageSize,
      });
      state.lastSql = sql;
      state.lastResult = res;
      state.page = res.page || 1;
      state.total = res.total || 0;
      state.paged = !!res.paged;
      if (res.paged && res.page_size) state.pageSize = res.page_size;
      renderResult(res);
      renderPager(res);
    } catch (e) {
      renderError(e && e.message ? e.message : String(e));
      state.paged = false;
      state.lastResult = null;
      pagerEl.classList.add('hidden');
    }
    runBtn.disabled = false;
  }

  async function runQuery(page) {
    if (!invoke || !state.info) return;
    const sql = editorEl.value.trim();
    if (!sql) {
      window.toast('请输入 SQL 语句');
      editorEl.focus();
      return;
    }
    await execSql(sql, page || 1);
  }

  /** 翻页 / 跳页：基于最近一次执行的 SQL 重新查询 */
  function gotoPage(p) {
    if (!state.lastSql || !state.paged) return;
    const target = Math.min(Math.max(1, p), totalPages());
    execSql(state.lastSql, target);
  }

  runBtn.addEventListener('click', function () { runQuery(1); });
  pageFirstBtn.addEventListener('click', function () { gotoPage(1); });
  pagePrevBtn.addEventListener('click', function () { gotoPage(state.page - 1); });
  pageNextBtn.addEventListener('click', function () { gotoPage(state.page + 1); });
  pageLastBtn.addEventListener('click', function () { gotoPage(totalPages()); });
  pageInputEl.addEventListener('keydown', function (e) {
    if (e.key !== 'Enter') return;
    e.preventDefault();
    gotoPage(Number(pageInputEl.value) || 1);
  });
  // 每页数量：回车生效（回到第一页重新查询）
  pageSizeEl.addEventListener('keydown', function (e) {
    if (e.key !== 'Enter') return;
    e.preventDefault();
    const v = Math.min(Math.max(Number(pageSizeEl.value) || 100, 1), 2000);
    state.pageSize = v;
    pageSizeEl.value = v;
    if (state.lastSql && state.paged) execSql(state.lastSql, 1);
  });
  // 行号口径切换（总计 / 每页）：本地重渲染
  rownumToggleBtn.addEventListener('click', function () {
    state.rownumMode = state.rownumMode === 'total' ? 'page' : 'total';
    updateRownumToggle();
    if (state.lastResult) renderResult(state.lastResult);
  });
})();
