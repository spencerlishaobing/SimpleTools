/* ===== 模拟服务器模块（v0.36.0：本地 HTTP 接口模拟 + 请求采集） =====
   数据流：后端收到请求 → 记录（内存上限 500）+ mock-request 事件推送摘要 → 前端节流批量渲染；
   点击记录行展开详情（mock_request_detail 按需拉取请求头 / 请求参数 / 请求正文）。
   接口规则持久化于数据目录 mock-rules.json，服务运行中增删即时生效。 */
(function () {
  'use strict';

  const invoke = (window.__TAURI__ && window.__TAURI__.core && window.__TAURI__.core.invoke) || null;
  const listenFn = (window.__TAURI__ && window.__TAURI__.event && window.__TAURI__.event.listen) || null;

  // ---------- DOM ----------
  const panelEl = document.getElementById('panel-mock');
  const statusEl = document.getElementById('mock-status');
  const toggleBtn = document.getElementById('mock-toggle');
  const clearBtn = document.getElementById('mock-clear');
  const ipEl = document.getElementById('mock-ip');
  const portEl = document.getElementById('mock-port');
  const copyLanBtn = document.getElementById('mock-copy-lan');
  const upnpBadgeEl = document.getElementById('mock-upnp-badge');
  const publicUrlEl = document.getElementById('mock-public-url');
  const copyPublicBtn = document.getElementById('mock-copy-public');
  const retryBtn = document.getElementById('mock-upnp-retry');
  const upnpMsgEl = document.getElementById('mock-upnp-msg');
  const v6LineEl = document.getElementById('mock-v6-line');
  const v6UrlEl = document.getElementById('mock-v6-url');
  const copyV6Btn = document.getElementById('mock-copy-v6');
  const ruleCountEl = document.getElementById('mock-rule-count');
  const ruleAddBtn = document.getElementById('mock-rule-add-btn');
  const ruleFormEl = document.getElementById('mock-rule-form');
  const ruleMethodEl = document.getElementById('mock-rule-method');
  const rulePathEl = document.getElementById('mock-rule-path');
  const ruleStatusEl = document.getElementById('mock-rule-status');
  const ruleBodyEl = document.getElementById('mock-rule-body');
  const ruleSaveBtn = document.getElementById('mock-rule-save');
  const ruleCancelBtn = document.getElementById('mock-rule-cancel');
  const ruleListEl = document.getElementById('mock-rule-list');
  const ruleEmptyEl = document.getElementById('mock-rule-empty');
  const countEl = document.getElementById('mock-count');
  const listEl = document.getElementById('mock-list');
  const emptyEl = document.getElementById('mock-empty');

  /** 列表最多保留的请求行数（与后端上限一致） */
  const MAX_ROWS = 500;
  /** 事件批量渲染节流（毫秒） */
  const FLUSH_MS = 120;
  /** 未填写时的默认响应体 */
  const DEFAULT_BODY = '{"code":0,"message":"ok"}';

  const state = {
    running: false,
    rules: [],        // MockRule 列表
    requests: [],     // MockRequestBrief 列表
    lastIp: '',       // 当前展示的本机 IP（复制接口地址用）
    upnp: null,       // 最近一次 UPnP 穿透状态
    v6Url: '',        // 公网 IPv6 访问地址（无则空）
  };

  let pendingBuf = [];
  let flushTimer = null;

  // ---------- 小工具 ----------

  function esc(s) {
    return String(s == null ? '' : s)
      .replace(/&/g, '&amp;')
      .replace(/</g, '&lt;')
      .replace(/>/g, '&gt;')
      .replace(/"/g, '&quot;');
  }

  function fmtTime(at) {
    const d = new Date(at || 0);
    const p = (n) => (n < 10 ? '0' + n : '' + n);
    return p(d.getHours()) + ':' + p(d.getMinutes()) + ':' + p(d.getSeconds());
  }

  function methodClass(m) {
    return 'm-' + String(m || '').toLowerCase();
  }

  /** 解析查询串 / urlencoded 正文为键值对（解码失败保留原文） */
  function parsePairs(q) {
    if (!q) return [];
    return q.split('&').filter(Boolean).map(function (pair) {
      const i = pair.indexOf('=');
      const k = i < 0 ? pair : pair.slice(0, i);
      const v = i < 0 ? '' : pair.slice(i + 1);
      let dk = k;
      let dv = v;
      try { dk = decodeURIComponent(k.replace(/\+/g, ' ')); } catch (e) { /* 保留原文 */ }
      try { dv = decodeURIComponent(v.replace(/\+/g, ' ')); } catch (e) { /* 保留原文 */ }
      return [dk, dv];
    });
  }

  /** 正文展示：JSON 结构自动美化，其余原文 */
  function prettyBody(body) {
    const t = String(body || '').trim();
    if (t.startsWith('{') || t.startsWith('[')) {
      try { return JSON.stringify(JSON.parse(t), null, 2); } catch (e) { /* 非合法 JSON：原文 */ }
    }
    return body;
  }

  function kvRows(pairs) {
    return '<div class="mock-kv">' + pairs.map(function (kv) {
      return '<div class="mock-kv-row"><span class="mock-kv-k">' + esc(kv[0]) +
        '</span><span class="mock-kv-v">' + esc(kv[1]) + '</span></div>';
    }).join('') + '</div>';
  }

  // ---------- 规则渲染 ----------

  function ruleRowHtml(r) {
    const resp = (r.status ? r.status + ' · ' : '') + (r.body ? r.body.slice(0, 60) : '(空响应)');
    return '<div class="mock-rule-row" data-id="' + esc(r.id) + '">' +
      '<span class="mock-method ' + methodClass(r.method) + '">' + esc(r.method) + '</span>' +
      '<span class="mock-rule-path" title="' + esc(r.path) + '">' + esc(r.path) + '</span>' +
      '<span class="mock-rule-resp" title="' + esc(resp) + '">' + esc(resp) + '</span>' +
      '<button class="mock-rule-copy" data-id="' + esc(r.id) + '" title="复制完整接口地址">复制地址</button>' +
      '<button class="mock-rule-del" data-id="' + esc(r.id) + '" title="删除该接口">×</button>' +
      '</div>';
  }

  function renderRules() {
    ruleCountEl.textContent = state.rules.length + ' 个';
    ruleListEl.innerHTML = state.rules.map(ruleRowHtml).join('');
    ruleEmptyEl.classList.toggle('hidden', state.rules.length > 0);
  }

  // ---------- 请求记录渲染 ----------

  function reqRowHtml(b) {
    const codeCls = b.matched ? (b.status >= 400 ? 'c-err' : 'c-ok') : 'c-miss';
    return '<div class="mock-row' + (b.matched ? '' : ' is-miss') + '" data-id="' + esc(b.id) + '">' +
      '<span class="mock-row-time">' + fmtTime(b.at) + '</span>' +
      '<span class="mock-method ' + methodClass(b.method) + '">' + esc(b.method) + '</span>' +
      '<span class="mock-row-path" title="' + esc(b.path) + '">' + esc(b.path) + '</span>' +
      '<span class="mock-row-src" title="来源 IP">' + esc(b.source) + '</span>' +
      '<span class="mock-code ' + codeCls + '">' + b.status + '</span>' +
      '<span class="mock-row-arrow">›</span>' +
      '</div>';
  }

  function updateCount() {
    countEl.textContent = state.requests.length + ' 条请求';
  }

  function updateEmpty() {
    emptyEl.classList.toggle('hidden', state.requests.length > 0);
  }

  function atBottom() {
    return listEl.scrollHeight - listEl.scrollTop - listEl.clientHeight < 40;
  }

  /** 节流批量追加（贴底时自动跟随滚动） */
  function flush() {
    flushTimer = null;
    if (!pendingBuf.length) return;
    const stick = atBottom();
    const html = pendingBuf.map(reqRowHtml).join('');
    pendingBuf = [];
    listEl.insertAdjacentHTML('beforeend', html);
    while (listEl.children.length > MAX_ROWS) listEl.removeChild(listEl.firstElementChild);
    updateCount();
    updateEmpty();
    if (stick) listEl.scrollTop = listEl.scrollHeight;
  }

  function onRequest(b) {
    if (!b) return;
    state.requests.push(b);
    if (state.requests.length > MAX_ROWS) state.requests.shift();
    pendingBuf.push(b);
    if (!flushTimer) flushTimer = setTimeout(flush, FLUSH_MS);
  }

  function rebuildRequests(list, scrollBottom) {
    state.requests = list;
    listEl.innerHTML = list.map(reqRowHtml).join('');
    updateCount();
    updateEmpty();
    if (scrollBottom) listEl.scrollTop = listEl.scrollHeight;
  }

  /** 回填面板打开前已记录的请求（服务端为准；合并进行中的事件缓冲避免竞态丢行） */
  async function backfill() {
    if (!invoke) return;
    let list = [];
    try {
      list = (await invoke('mock_requests')) || [];
    } catch (e) {
      return;
    }
    const known = {};
    list.forEach(function (b) { known[b.id] = true; });
    pendingBuf.forEach(function (b) { if (!known[b.id]) list.push(b); });
    pendingBuf = [];
    clearTimeout(flushTimer);
    flushTimer = null;
    rebuildRequests(list, true);
  }

  // ---------- 详情展开 ----------

  function detailHtml(d) {
    let h = '';
    // 请求头
    h += '<div class="mock-detail-sec">请求头</div>';
    if (d.headers && d.headers.length) {
      h += kvRows(d.headers);
    } else {
      h += '<div class="mock-detail-none">无</div>';
    }
    // 请求参数
    h += '<div class="mock-detail-sec">请求参数</div>';
    let hasParams = false;
    const qs = parsePairs(d.query);
    if (qs.length) {
      hasParams = true;
      h += '<div class="mock-detail-sub">Query 参数</div>' + kvRows(qs);
    }
    if (d.body) {
      hasParams = true;
      const ctype = d.content_type ? '（' + esc(d.content_type) + '）' : '';
      h += '<div class="mock-detail-sub">请求正文' + (d.body_truncated ? '（超过 256KB，仅记录前 256KB）' : '') + ctype + '</div>' +
        '<pre class="mock-detail-body">' + esc(prettyBody(d.body)) + '</pre>';
    }
    if (!hasParams) {
      h += '<div class="mock-detail-none">无查询参数与请求正文</div>';
    }
    return h;
  }

  // ---------- 运行状态 ----------

  /** UPnP 穿透状态标签（中文） */
  const UPnP_LABEL = {
    idle: '未检测',
    pending: '检测中',
    mapped: '已开放',
    unsupported: '路由器不支持',
    failed: '失败',
    cgnat: '共享公网',
  };

  /** 重试按钮可见性：服务运行中且处于可重试的失败类状态（v0.39.0） */
  function updateRetryVisible() {
    const stState = (state.upnp && state.upnp.state) || 'idle';
    const canRetry = state.running && ['unsupported', 'failed', 'cgnat'].indexOf(stState) >= 0;
    retryBtn.classList.toggle('hidden', !canRetry);
  }

  /** 渲染 UPnP 穿透状态（事件 mock-upnp / 面板刷新时调用） */
  function renderUpnp(st) {
    if (!st) return;
    state.upnp = st;
    upnpBadgeEl.textContent = UPnP_LABEL[st.state] || st.state || '未检测';
    upnpBadgeEl.className = 'mock-upnp-badge s-' + (st.state || 'idle');
    publicUrlEl.textContent = st.public_url || '—';
    publicUrlEl.classList.toggle('is-dim', !st.public_url);
    copyPublicBtn.classList.toggle('hidden', !st.public_url);
    upnpMsgEl.textContent = st.message ||
      '启动服务后会自动通过路由器 UPnP 开放外网端口（无需第三方软件）；运营商支持 IPv6 时外网设备可直接访问';
    updateRetryVisible();
  }

  function applyInfo(info) {
    if (!info) return;
    state.running = !!info.running;
    statusEl.classList.toggle('is-running', state.running);
    statusEl.innerHTML = '<i class="mock-dot"></i>' + (state.running ? '运行中' : '已停止');
    toggleBtn.textContent = state.running ? '停止服务' : '启动服务';
    toggleBtn.classList.toggle('primary', !state.running);
    toggleBtn.classList.toggle('danger-solid', state.running);
    const addrs = info.addrs || [];
    state.lastIp = addrs.length ? addrs[0] : '';
    ipEl.textContent = addrs.length ? addrs[0] : '本机 IP';
    ipEl.title = addrs.length ? ('本机局域网 IP：' + addrs.join(' / ')) : '未检测到局域网 IP（请确认已连接网络）';
    portEl.textContent = info.port;
    copyLanBtn.classList.toggle('hidden', !state.lastIp);
    // UPnP 穿透状态（v0.39.0）：内网地址之外自动尝试开放外网端口
    renderUpnp(info.upnp || { state: 'idle', public_url: '', message: '' });
    // 公网 IPv6（v0.39.0）：运营商支持时外网（IPv6）设备可直接访问
    const v6 = info.ipv6 || [];
    if (v6.length) {
      v6LineEl.classList.remove('hidden');
      v6UrlEl.textContent = 'http://[' + v6[0] + ']:' + info.port;
      v6UrlEl.title = v6.length > 1 ? ('本机公网 IPv6：\n' + v6.join('\n')) : '支持 IPv6 的外网设备可直接访问';
      state.v6Url = 'http://[' + v6[0] + ']:' + info.port;
    } else {
      v6LineEl.classList.add('hidden');
      state.v6Url = '';
    }
  }

  async function refreshInfo() {
    if (!invoke) return;
    try {
      applyInfo(await invoke('mock_info'));
    } catch (e) { /* 忽略 */ }
  }

  async function refreshRules() {
    if (!invoke) return;
    try {
      state.rules = (await invoke('mock_rules')) || [];
      renderRules();
    } catch (e) { /* 忽略 */ }
  }

  async function toggleService() {
    if (!invoke) return;
    toggleBtn.disabled = true;
    try {
      if (state.running) {
        await invoke('mock_stop');
        await refreshInfo();
        window.toast('模拟服务已停止');
      } else {
        const info = await invoke('mock_start');
        applyInfo(info);
        window.toast('模拟服务已启动：' + (state.lastIp ? 'http://' + state.lastIp + ':' + info.port : '请在客户端填写本机 IP 与端口'));
      }
    } catch (e) {
      window.toast('操作失败：' + (e && e.message ? e.message : e));
      await refreshInfo();
    }
    toggleBtn.disabled = false;
  }

  // ---------- 添加规则表单 ----------

  function openRuleForm() {
    ruleFormEl.classList.remove('hidden');
    ruleAddBtn.classList.add('hidden');
    ruleMethodEl.value = 'ANY';
    rulePathEl.value = '';
    ruleStatusEl.value = '200';
    ruleBodyEl.value = '';
    rulePathEl.focus();
  }

  function closeRuleForm() {
    ruleFormEl.classList.add('hidden');
    ruleAddBtn.classList.remove('hidden');
  }

  async function saveRule() {
    if (!invoke) return;
    const path = rulePathEl.value.trim();
    if (!path) {
      window.toast('请填写接口路径（如 /api/login）');
      rulePathEl.focus();
      return;
    }
    const status = Number(ruleStatusEl.value) || 200;
    if (status < 100 || status > 599) {
      window.toast('状态码需在 100 - 599 之间');
      return;
    }
    const body = ruleBodyEl.value.trim() || DEFAULT_BODY;
    ruleSaveBtn.disabled = true;
    try {
      state.rules = (await invoke('mock_rule_add', {
        rule: { method: ruleMethodEl.value, path: path, status: status, body: body },
      })) || [];
      renderRules();
      closeRuleForm();
      window.toast('已添加接口：' + path);
    } catch (e) {
      window.toast('添加失败：' + (e && e.message ? e.message : e));
    }
    ruleSaveBtn.disabled = false;
  }

  // ---------- 事件绑定 ----------

  toggleBtn.addEventListener('click', toggleService);
  ruleAddBtn.addEventListener('click', openRuleForm);
  ruleCancelBtn.addEventListener('click', closeRuleForm);
  ruleSaveBtn.addEventListener('click', saveRule);
  rulePathEl.addEventListener('keydown', function (e) {
    if (e.key === 'Enter') saveRule();
  });

  // 地址复制与 UPnP 重试（v0.39.0）
  copyLanBtn.addEventListener('click', function () {
    if (state.lastIp) window.copyText('http://' + state.lastIp + ':' + portEl.textContent);
  });
  copyPublicBtn.addEventListener('click', function () {
    if (state.upnp && state.upnp.public_url) window.copyText(state.upnp.public_url);
  });
  copyV6Btn.addEventListener('click', function () {
    if (state.v6Url) window.copyText(state.v6Url);
  });
  retryBtn.addEventListener('click', async function () {
    if (!invoke || retryBtn.disabled) return;
    retryBtn.disabled = true;
    renderUpnp({ state: 'pending', public_url: '', message: '正在重新检测路由器…' });
    try {
      const st = await invoke('mock_public_retry');
      renderUpnp(st);
    } catch (e) {
      window.toast('重试失败：' + (e && e.message ? e.message : e));
      await refreshInfo();
    }
    retryBtn.disabled = false;
  });

  // 规则行：复制完整接口地址 / 删除（确认弹窗）
  ruleListEl.addEventListener('click', async function (e) {
    const copyBtn = e.target.closest('.mock-rule-copy');
    if (copyBtn) {
      const r = state.rules.find((x) => x.id === Number(copyBtn.dataset.id));
      if (!r) return;
      const base = state.lastIp ? 'http://' + state.lastIp + ':' + portEl.textContent : '';
      window.copyText(base + r.path);
      return;
    }
    const delBtn = e.target.closest('.mock-rule-del');
    if (!delBtn || !invoke) return;
    const r = state.rules.find((x) => x.id === Number(delBtn.dataset.id));
    if (!r) return;
    const ok = await window.showConfirm('删除接口 ' + r.method + ' ' + r.path + '？', {
      title: '删除接口',
      okText: '删除',
    });
    if (!ok) return;
    try {
      state.rules = (await invoke('mock_rule_delete', { id: r.id })) || [];
      renderRules();
      window.toast('已删除接口');
    } catch (err) {
      window.toast('删除失败：' + (err && err.message ? err.message : err));
    }
  });

  // 请求记录行：点击展开详情（再次点击收起）
  listEl.addEventListener('click', async function (e) {
    const row = e.target.closest('.mock-row');
    if (!row || !invoke) return;
    const next = row.nextElementSibling;
    if (next && next.classList.contains('mock-detail')) {
      next.remove();
      row.classList.remove('is-open');
      return;
    }
    row.classList.add('is-open');
    const detail = document.createElement('div');
    detail.className = 'mock-detail';
    detail.innerHTML = '<div class="mock-detail-none">加载中…</div>';
    row.insertAdjacentElement('afterend', detail);
    try {
      const d = await invoke('mock_request_detail', { id: Number(row.dataset.id) });
      if (!d) {
        detail.innerHTML = '<div class="mock-detail-none">[记录已不在内存中（超过 500 条上限被淘汰）]</div>';
        return;
      }
      detail.innerHTML = detailHtml(d);
    } catch (err) {
      detail.innerHTML = '<div class="mock-detail-none">读取失败：' + esc(err && err.message ? err.message : err) + '</div>';
    }
  });

  clearBtn.addEventListener('click', async function () {
    if (!invoke || !state.requests.length) return;
    const ok = await window.showConfirm('将清空已记录的 ' + state.requests.length + ' 条请求，确定继续？', {
      title: '清空记录',
      okText: '清空',
    });
    if (!ok) return;
    try {
      await invoke('mock_clear_requests');
    } catch (e) {
      window.toast('清空失败：' + (e && e.message ? e.message : e));
      return;
    }
    state.requests = [];
    pendingBuf = [];
    clearTimeout(flushTimer);
    flushTimer = null;
    listEl.innerHTML = '';
    updateCount();
    updateEmpty();
    window.toast('已清空请求记录');
  });

  // 面板由隐藏变为可见：刷新状态 / 规则；首次打开时回填已记录请求
  panelEl.addEventListener('panel-shown', function () {
    refreshInfo();
    refreshRules();
    backfill();
  });

  // ---------- 初始化 ----------

  if (listenFn) {
    listenFn('mock-request', function (ev) {
      onRequest(ev.payload);
    });
    listenFn('mock-upnp', function (ev) {
      renderUpnp(ev.payload);
    });
  }
  refreshInfo();
  refreshRules();
  backfill();
})();
