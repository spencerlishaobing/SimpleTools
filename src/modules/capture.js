/* ===== 抓包模块（v0.35.0：MITM HTTP/S 代理，手机设置代理后实时捕获请求 / 响应） =====
   数据流：后端每捕获一条会话即通过 capture-session 事件推送摘要（不含 headers / 正文），
   前端节流批量渲染列表；点击某行再用 capture_detail 按需拉取完整详情（降低 IPC 压力）。 */
(function () {
  'use strict';

  const invoke = (window.__TAURI__ && window.__TAURI__.core && window.__TAURI__.core.invoke) || null;
  const dialogApi = (window.__TAURI__ && window.__TAURI__.dialog) || null;
  const listenFn = (window.__TAURI__ && window.__TAURI__.event && window.__TAURI__.event.listen) || null;

  // ---------- DOM ----------
  const panelEl = document.getElementById('panel-capture');
  const statusEl = document.getElementById('cap-status');
  const toggleBtn = document.getElementById('cap-toggle');
  const exportBtn = document.getElementById('cap-export-ca');
  const clearBtn = document.getElementById('cap-clear');
  const ipEl = document.getElementById('cap-ip');
  const portEl = document.getElementById('cap-port');
  const filterWrap = document.getElementById('cap-filters');
  const searchEl = document.getElementById('cap-search');
  const countEl = document.getElementById('cap-count');
  const listEl = document.getElementById('cap-list');
  const emptyEl = document.getElementById('cap-empty');
  const detailEmptyEl = document.getElementById('cap-detail-empty');
  const detailInnerEl = document.getElementById('cap-detail-inner');
  const dMethodEl = document.getElementById('cap-d-method');
  const dUrlEl = document.getElementById('cap-d-url');
  const dCodeEl = document.getElementById('cap-d-code');
  const dMetaEl = document.getElementById('cap-d-meta');
  const tabsEl = document.getElementById('cap-tabs');
  const tabContentEl = document.getElementById('cap-tab-content');
  const tabCopyBtn = document.getElementById('cap-tab-copy');

  /** 列表最多渲染的行数（内存记录本身由后端控制上限） */
  const MAX_ROWS = 1000;
  /** 事件批量渲染节流（毫秒）：高频请求下合并多次 DOM 操作 */
  const FLUSH_MS = 120;
  /** 搜索输入防抖（毫秒） */
  const SEARCH_DEBOUNCE = 150;

  const state = {
    running: false,
    sessions: [],   // SessionBrief 列表（含未渲染进 DOM 的旧记录）
    selectedId: 0,
    detail: null,   // SessionFull（当前选中会话的完整详情）
    tab: 'res-body',
    filter: 'all',  // all / ok / fail
    keyword: '',
  };

  let pendingBuf = [];      // 待批量渲染的摘要
  let flushTimer = null;
  let searchTimer = null;

  // ---------- 小工具 ----------

  function esc(s) {
    return String(s == null ? '' : s)
      .replace(/&/g, '&amp;')
      .replace(/</g, '&lt;')
      .replace(/>/g, '&gt;')
      .replace(/"/g, '&quot;');
  }

  function fmtSize(n) {
    if (!n) return '—';
    if (n < 1024) return n + ' B';
    if (n < 1024 * 1024) return (n / 1024).toFixed(1) + ' KB';
    return (n / 1024 / 1024).toFixed(1) + ' MB';
  }

  function fmtDur(ms) {
    if (ms < 1000) return ms + ' ms';
    return (ms / 1000).toFixed(2) + ' s';
  }

  function fmtTime(at) {
    const d = new Date(at);
    const p = (x) => String(x).padStart(2, '0');
    return p(d.getHours()) + ':' + p(d.getMinutes()) + ':' + p(d.getSeconds());
  }

  /** 传输失败（未取得响应）或 HTTP 错误（>= 400）都算失败 */
  function isFail(b) {
    return b.state === 'error' || b.status >= 400;
  }

  const KNOWN_METHODS = ['get', 'post', 'put', 'delete', 'patch', 'head', 'options'];

  function methodCls(m) {
    const s = String(m || '').toLowerCase();
    return KNOWN_METHODS.indexOf(s) >= 0 ? 'm-' + s : 'm-other';
  }

  function codeCls(status) {
    if (!status) return 'c-none';
    if (status < 300) return 'c-ok';
    if (status < 400) return 'c-warn';
    return 'c-err';
  }

  function match(brief) {
    if (state.filter === 'fail' && !isFail(brief)) return false;
    if (state.filter === 'ok' && isFail(brief)) return false;
    if (state.keyword) {
      const s = (brief.method + ' ' + brief.host + brief.path).toLowerCase();
      if (s.indexOf(state.keyword) < 0) return false;
    }
    return true;
  }

  // ---------- 列表渲染 ----------

  function rowHtml(b) {
    const fail = isFail(b);
    const portSuffix = (b.scheme === 'https' && b.port === 443) || (b.scheme === 'http' && b.port === 80)
      ? '' : ':' + b.port;
    return '<div class="cap-row' + (fail ? ' is-fail' : '') + (b.id === state.selectedId ? ' active' : '')
      + '" data-id="' + b.id + '">'
      + '<span class="cap-st ' + (fail ? 'err' : 'ok') + '" title="'
      + (b.state === 'error' ? esc(b.error) : '已收到响应') + '"></span>'
      + '<span class="cap-method ' + methodCls(b.method) + '">' + esc(b.method) + '</span>'
      + '<span class="cap-url"><span class="cap-host">' + esc(b.host + portSuffix) + '</span>'
      + '<span class="cap-path">' + esc(b.path) + '</span></span>'
      + '<span class="cap-code ' + codeCls(b.status) + '">' + (b.status ? b.status : '—') + '</span>'
      + '<span class="cap-dur">' + fmtDur(b.duration) + '</span>'
      + '<span class="cap-size">' + fmtSize(b.status ? b.res_size : b.req_size) + '</span>'
      + '</div>';
  }

  function updateCount(visible) {
    const total = state.sessions.length;
    countEl.textContent = (state.keyword || state.filter !== 'all')
      ? visible + ' / ' + total + ' 条'
      : visible + ' 条';
  }

  function updateEmpty(visible) {
    emptyEl.classList.toggle('hidden', visible > 0);
  }

  /** 节流批量追加渲染（常态路径：新会话到达） */
  function flush() {
    flushTimer = null;
    if (!pendingBuf.length) return;
    const items = pendingBuf;
    pendingBuf = [];

    const atBottom = listEl.scrollTop + listEl.clientHeight >= listEl.scrollHeight - 24;
    let html = '';
    for (const b of items) {
      if (match(b)) html += rowHtml(b);
    }
    if (html) listEl.insertAdjacentHTML('beforeend', html);
    while (listEl.children.length > MAX_ROWS) listEl.removeChild(listEl.firstChild);

    updateCount(listEl.children.length);
    updateEmpty(listEl.children.length);
    if (html && atBottom) listEl.scrollTop = listEl.scrollHeight;
  }

  function scheduleFlush() {
    if (flushTimer) return;
    flushTimer = setTimeout(flush, FLUSH_MS);
  }

  /** 全量重渲染（过滤 / 搜索变化、回填、清空后使用） */
  function rebuild(scrollBottom) {
    // 从尾部往前取最近 MAX_ROWS 条匹配项（与列表「新条目在下」的顺序一致）
    const matched = [];
    for (let i = state.sessions.length - 1; i >= 0 && matched.length < MAX_ROWS; i--) {
      if (match(state.sessions[i])) matched.push(state.sessions[i]);
    }
    matched.reverse();
    listEl.innerHTML = matched.map(rowHtml).join('');
    updateCount(matched.length);
    updateEmpty(matched.length);
    if (scrollBottom) listEl.scrollTop = listEl.scrollHeight;
  }

  function onSession(brief) {
    if (!brief || typeof brief.id !== 'number') return;
    state.sessions.push(brief);
    pendingBuf.push(brief);
    scheduleFlush();
  }

  // ---------- 详情渲染 ----------

  /** JSON 文本美化（仅对完整可解析的 JSON 生效，失败保留原文） */
  function prettyBody(text) {
    if (!text) return '';
    const t = text.trim();
    if ((t.charAt(0) === '{' && t.charAt(t.length - 1) === '}') ||
        (t.charAt(0) === '[' && t.charAt(t.length - 1) === ']')) {
      try {
        return JSON.stringify(JSON.parse(t), null, 2);
      } catch (e) { /* 非法 JSON 保留原文 */ }
    }
    return text;
  }

  function bodyDisplay(text, truncated, skipped) {
    if (skipped) return '[此响应体积过大或为流式数据，未记录正文]\n\n（HTML / JSON / 文本等常规响应会完整记录，仅记录前 256 KB）';
    if (!text) return '[无正文]';
    let out = prettyBody(text);
    if (truncated) out += '\n\n[内容过长，仅记录前 256 KB]';
    return out;
  }

  function reqHeadersText(d) {
    const lines = [d.method + ' ' + d.path + ' HTTP/1.1', ''];
    d.req_headers.forEach(function (pair) { lines.push(pair[0] + ': ' + pair[1]); });
    return lines.join('\n');
  }

  function resHeadersText(d) {
    const lines = ['HTTP/1.1 ' + (d.status || '—'), ''];
    d.res_headers.forEach(function (pair) { lines.push(pair[0] + ': ' + pair[1]); });
    return lines.join('\n');
  }

  function tabText(d, tab) {
    switch (tab) {
      case 'req-headers': return reqHeadersText(d);
      case 'req-body': return bodyDisplay(d.req_body, d.req_truncated, false);
      case 'res-headers': return resHeadersText(d);
      default: return bodyDisplay(d.res_body, d.res_truncated, d.res_skipped);
    }
  }

  function applyTabActive() {
    tabsEl.querySelectorAll('.cap-tab').forEach(function (btn) {
      btn.classList.toggle('active', btn.dataset.capTab === state.tab);
    });
  }

  function renderDetail() {
    const d = state.detail;
    if (!d) return;
    dMethodEl.textContent = d.method;
    dMethodEl.className = 'cap-d-method ' + methodCls(d.method);
    const portSuffix = (d.scheme === 'https' && d.port === 443) || (d.scheme === 'http' && d.port === 80)
      ? '' : ':' + d.port;
    dUrlEl.textContent = d.scheme + '://' + d.host + portSuffix + d.path;
    dCodeEl.textContent = d.state === 'error' ? '无响应' : (d.status || '—');
    dCodeEl.className = 'cap-d-code ' + (d.state === 'error' ? 'c-err' : codeCls(d.status));

    const meta = [];
    meta.push('<span>时间 ' + fmtTime(d.at) + '</span>');
    meta.push('<span>耗时 ' + fmtDur(d.duration) + '</span>');
    meta.push('<span>请求 ' + fmtSize(d.req_size) + '</span>');
    meta.push('<span>响应 ' + fmtSize(d.res_size) + '</span>');
    if (d.content_type) meta.push('<span>' + esc(d.content_type) + '</span>');
    if (d.state === 'error' && d.error) meta.push('<span class="cap-meta-err">' + esc(d.error) + '</span>');
    dMetaEl.innerHTML = meta.join('');

    applyTabActive();
    tabContentEl.textContent = tabText(d, state.tab);
  }

  async function selectRow(id) {
    if (id === state.selectedId && state.detail) return;
    state.selectedId = id;
    state.detail = null;
    listEl.querySelectorAll('.cap-row.active').forEach(function (r) { r.classList.remove('active'); });
    const row = listEl.querySelector('.cap-row[data-id="' + id + '"]');
    if (row) row.classList.add('active');

    detailEmptyEl.classList.add('hidden');
    detailInnerEl.classList.remove('hidden');
    tabContentEl.textContent = '加载中…';

    if (!invoke) return;
    let d = null;
    try {
      d = await invoke('capture_detail', { id: id });
    } catch (e) {
      // 记录可能已被新请求挤出内存上限
    }
    if (state.selectedId !== id) return; // 用户已切换到其他行
    if (!d) {
      state.detail = null;
      tabContentEl.textContent = '[记录已不在内存中（超过 2000 条上限被淘汰）]';
      return;
    }
    state.detail = d;
    renderDetail();
  }

  // ---------- 运行状态 ----------

  function applyInfo(info) {
    if (!info) return;
    state.running = !!info.running;
    statusEl.classList.toggle('is-running', state.running);
    statusEl.innerHTML = '<i class="cap-dot"></i>' + (state.running ? '抓包中' : '已停止');
    toggleBtn.textContent = state.running ? '停止抓包' : '启动抓包';
    toggleBtn.classList.toggle('primary', !state.running);
    toggleBtn.classList.toggle('danger-solid', state.running);
    const addrs = info.addrs || [];
    ipEl.textContent = addrs.length ? addrs[0] : '本机 IP';
    ipEl.title = addrs.length ? ('本机局域网 IP：' + addrs.join(' / ')) : '未检测到局域网 IP（请确认已连接网络）';
    portEl.textContent = info.port;
  }

  async function refreshInfo() {
    if (!invoke) return;
    try {
      applyInfo(await invoke('capture_info'));
    } catch (e) { /* 忽略 */ }
  }

  /** 回填面板打开前已捕获的记录（按 id 去重合并，避免与事件推送重复） */
  async function backfill() {
    if (!invoke) return;
    let list = [];
    try {
      list = (await invoke('capture_list')) || [];
    } catch (e) {
      return;
    }
    const known = {};
    state.sessions.forEach(function (s) { known[s.id] = true; });
    const older = list.filter(function (s) { return !known[s.id]; });
    if (!older.length) return;
    state.sessions = older.concat(state.sessions);
    rebuild(true);
  }

  async function toggleCapture() {
    if (!invoke) return;
    toggleBtn.disabled = true;
    try {
      if (state.running) {
        await invoke('capture_stop');
        await refreshInfo();
        window.toast('已停止抓包');
      } else {
        const info = await invoke('capture_start');
        applyInfo(info);
        window.toast('抓包已启动，请在手机上设置代理');
      }
    } catch (e) {
      window.toast('操作失败：' + (e && e.message ? e.message : e));
      await refreshInfo();
    }
    toggleBtn.disabled = false;
  }

  // ---------- 事件绑定 ----------

  toggleBtn.addEventListener('click', toggleCapture);

  exportBtn.addEventListener('click', async function () {
    if (!invoke || !dialogApi) return;
    let path = null;
    try {
      path = await dialogApi.save({
        title: '导出根证书',
        defaultPath: 'SimpleTools-Capture-CA.crt',
        filters: [{ name: '证书文件', extensions: ['crt', 'pem'] }],
      });
    } catch (e) {
      return;
    }
    if (!path) return; // 用户取消
    try {
      await invoke('capture_export_ca', { path: path });
      window.toast('证书已导出，请在手机上安装并信任');
    } catch (e) {
      window.toast('导出失败：' + (e && e.message ? e.message : e));
    }
  });

  clearBtn.addEventListener('click', async function () {
    if (!invoke || !state.sessions.length) return;
    const ok = await window.showConfirm('将清空已捕获的 ' + state.sessions.length + ' 条会话记录，确定继续？', {
      title: '清空记录',
      okText: '清空',
    });
    if (!ok) return;
    try {
      await invoke('capture_clear');
    } catch (e) {
      window.toast('清空失败：' + (e && e.message ? e.message : e));
      return;
    }
    state.sessions = [];
    pendingBuf = [];
    state.selectedId = 0;
    state.detail = null;
    listEl.innerHTML = '';
    detailInnerEl.classList.add('hidden');
    detailEmptyEl.classList.remove('hidden');
    updateCount(0);
    updateEmpty(0);
    window.toast('已清空记录');
  });

  filterWrap.addEventListener('click', function (e) {
    const btn = e.target.closest('.cap-filter-btn');
    if (!btn) return;
    state.filter = btn.dataset.capFilter;
    filterWrap.querySelectorAll('.cap-filter-btn').forEach(function (b) {
      b.classList.toggle('active', b === btn);
    });
    rebuild(false);
  });

  searchEl.addEventListener('input', function () {
    clearTimeout(searchTimer);
    searchTimer = setTimeout(function () {
      state.keyword = searchEl.value.trim().toLowerCase();
      rebuild(false);
    }, SEARCH_DEBOUNCE);
  });

  listEl.addEventListener('click', function (e) {
    const row = e.target.closest('.cap-row');
    if (!row) return;
    selectRow(Number(row.dataset.id));
  });

  tabsEl.addEventListener('click', function (e) {
    const btn = e.target.closest('.cap-tab');
    if (!btn) return;
    state.tab = btn.dataset.capTab;
    applyTabActive();
    if (state.detail) tabContentEl.textContent = tabText(state.detail, state.tab);
  });

  tabCopyBtn.addEventListener('click', function () {
    if (!state.detail) return;
    const text = tabText(state.detail, state.tab);
    if (!text) return;
    window.copyText(text);
  });

  // 面板由隐藏变为可见：刷新运行状态；首次打开时回填已捕获记录
  panelEl.addEventListener('panel-shown', function () {
    refreshInfo();
    backfill();
  });

  // ---------- 初始化 ----------

  if (listenFn) {
    listenFn('capture-session', function (ev) {
      onSession(ev.payload);
    });
  }
  refreshInfo();
  backfill();
})();
