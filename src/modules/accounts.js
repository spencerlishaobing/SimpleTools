/* ===== 账号密码管理（分组 + 条目增删改 + 复制 + 搜索过滤） ===== */
(function () {
  'use strict';

  const invoke = (window.__TAURI__ && window.__TAURI__.core && window.__TAURI__.core.invoke) || null;

  const searchEl = document.getElementById('acc-search');
  const searchClearEl = document.getElementById('acc-search-clear');
  const groupListEl = document.getElementById('acc-group-list');
  const groupEmptyEl = document.getElementById('acc-group-empty');
  const statusEl = document.getElementById('acc-status');
  const togglePwdBtn = document.getElementById('acc-toggle-pwd');
  const groupViewEl = document.getElementById('acc-group-view');
  const groupNameEl = document.getElementById('acc-group-name');
  const itemListEl = document.getElementById('acc-item-list');
  const itemEmptyEl = document.getElementById('acc-item-empty');
  const searchViewEl = document.getElementById('acc-search-view');
  const searchHeadEl = document.getElementById('acc-search-head');
  const searchListEl = document.getElementById('acc-search-list');
  const searchEmptyEl = document.getElementById('acc-search-empty');
  const mainEmptyEl = document.getElementById('acc-main-empty');

  const state = {
    groups: [],          // [{ id, name, items: [{ id, account, password, updated_at }] }]
    currentGroupId: null,
    keyword: '',
    showPwd: false,
  };

  const SAVE_DELAY = 500;
  let saveTimer = null;
  let saving = false;
  let searchTimer = null;

  // ---------- 工具 ----------

  const ESC_MAP = { '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;', "'": '&#39;' };
  function esc(s) {
    return String(s).replace(/[&<>"']/g, (c) => ESC_MAP[c]);
  }

  function genId() {
    if (window.crypto && crypto.randomUUID) return crypto.randomUUID();
    return 'a-' + Date.now() + '-' + Math.random().toString(16).slice(2);
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

  function currentGroup() {
    return state.groups.find((g) => g.id === state.currentGroupId) || null;
  }

  function isSearching() {
    return state.keyword.trim().length > 0;
  }

  function findItemById(id) {
    for (const g of state.groups) {
      const item = g.items.find((it) => it.id === id);
      if (item) return item;
    }
    return null;
  }

  const TRASH_SVG =
    '<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" ' +
    'stroke-linecap="round" stroke-linejoin="round">' +
    '<polyline points="3 6 5 6 21 6"/>' +
    '<path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"/>' +
    '<line x1="10" y1="11" x2="10" y2="17"/>' +
    '<line x1="14" y1="11" x2="14" y2="17"/>' +
    '</svg>';

  function actionButtons(withRemove) {
    let html =
      '<button class="btn small acc-copy-account" title="复制账号">复制账号</button>' +
      '<button class="btn small acc-copy-password" title="复制密码">复制密码</button>' +
      '<button class="btn small acc-copy-both" title="一键复制账号和密码">一键复制</button>';
    if (withRemove) {
      html += '<button class="acc-item-remove" title="删除该账号">' + TRASH_SVG + '</button>';
    }
    return '<div class="acc-item-actions">' + html + '</div>';
  }

  // ---------- 持久化 ----------

  function scheduleSave(now) {
    setSaveStatus('saving', '正在保存...');
    clearTimeout(saveTimer);
    saveTimer = setTimeout(doSave, SAVE_DELAY);
  }

  async function doSave(now) {
    if (now) clearTimeout(saveTimer);
    if (!invoke || saving) return;
    saving = true;
    try {
      await invoke('accounts_save', { groups: state.groups });
      setSaveStatus('saved', '已保存 ' + timeNow());
    } catch (e) {
      setSaveStatus('', '保存失败：' + e);
    } finally {
      saving = false;
    }
  }

  window.addEventListener('blur', () => doSave(true));

  // ---------- 渲染 ----------

  function renderGroupList() {
    groupListEl.innerHTML = '';
    for (const g of state.groups) {
      const li = document.createElement('li');
      li.className = 'acc-group-item' + (g.id === state.currentGroupId ? ' active' : '');
      li.dataset.id = g.id;
      li.innerHTML =
        '<span class="acc-group-item-name">' + esc(g.name || '未命名分组') + '</span>' +
        '<span class="acc-group-item-count">' + g.items.length + '</span>';
      li.addEventListener('click', () => selectGroup(g.id));
      groupListEl.appendChild(li);
    }
    groupEmptyEl.classList.toggle('hidden', state.groups.length > 0);
  }

  function itemRowHtml(item) {
    return '<li class="acc-item" data-id="' + esc(item.id) + '">' +
      '<input class="acc-input acc-item-account" value="' + esc(item.account) + '"' +
      ' placeholder="账号" spellcheck="false" autocomplete="off" />' +
      '<input class="acc-input acc-item-password" type="' + (state.showPwd ? 'text' : 'password') + '"' +
      ' value="' + esc(item.password) + '" placeholder="密码" spellcheck="false" autocomplete="off" />' +
      actionButtons(true) +
      '</li>';
  }

  function renderGroupView() {
    const g = currentGroup();
    if (!g) return;
    groupNameEl.value = g.name || '';
    itemListEl.innerHTML = g.items.map(itemRowHtml).join('');
    itemEmptyEl.classList.toggle('hidden', g.items.length > 0);
  }

  function searchMatches() {
    const kw = state.keyword.trim().toLowerCase();
    const out = [];
    for (const g of state.groups) {
      for (const it of g.items) {
        if (it.account && it.account.toLowerCase().indexOf(kw) >= 0) {
          out.push({ group: g, item: it });
        }
      }
    }
    return out;
  }

  function renderSearch() {
    const matches = searchMatches();
    searchHeadEl.textContent = '找到 ' + matches.length + ' 条匹配（按账号关键字）';
    searchListEl.innerHTML = matches.map((m) => {
      const it = m.item;
      const pwdText = it.password ? (state.showPwd ? it.password : '••••••') : '（空）';
      return '<li class="acc-item acc-search-item" data-id="' + esc(it.id) + '">' +
        '<span class="acc-search-group">' + esc(m.group.name || '未命名分组') + '</span>' +
        '<span class="acc-search-account">' + esc(it.account) + '</span>' +
        '<span class="acc-search-password">' + esc(pwdText) + '</span>' +
        actionButtons(false) +
        '</li>';
    }).join('');
    searchEmptyEl.classList.toggle('hidden', matches.length > 0);
  }

  function renderMainView() {
    if (isSearching()) {
      groupViewEl.classList.add('hidden');
      mainEmptyEl.classList.add('hidden');
      searchViewEl.classList.remove('hidden');
      renderSearch();
    } else if (currentGroup()) {
      searchViewEl.classList.add('hidden');
      mainEmptyEl.classList.add('hidden');
      groupViewEl.classList.remove('hidden');
      renderGroupView();
    } else {
      searchViewEl.classList.add('hidden');
      groupViewEl.classList.add('hidden');
      mainEmptyEl.classList.remove('hidden');
    }
  }

  function renderAll() {
    renderGroupList();
    renderMainView();
  }

  // ---------- 分组操作 ----------

  function selectGroup(id) {
    state.currentGroupId = id;
    if (isSearching()) clearSearch();
    renderAll();
  }

  function createGroup() {
    const g = { id: genId(), name: '新分组', items: [] };
    state.groups.push(g);
    state.currentGroupId = g.id;
    if (isSearching()) clearSearch();
    renderAll();
    groupNameEl.focus();
    groupNameEl.select();
    scheduleSave(true);
  }

  async function removeGroup() {
    const g = currentGroup();
    if (!g) {
      window.toast('请先选择分组');
      return;
    }
    const ok = await window.showConfirm(
      '确定删除分组「' + (g.name || '未命名分组') + '」（含 ' + g.items.length + ' 个账号）吗？删除后无法恢复。',
      { title: '删除分组', okText: '删除' }
    );
    if (!ok) return;
    const idx = state.groups.findIndex((x) => x.id === g.id);
    state.groups.splice(idx, 1);
    const next = state.groups[idx] || state.groups[idx - 1] || null;
    state.currentGroupId = next ? next.id : null;
    renderAll();
    scheduleSave(true);
  }

  // ---------- 条目操作 ----------

  function addItem() {
    const g = currentGroup();
    if (!g) {
      window.toast('请先选择分组');
      return;
    }
    g.items.push({ id: genId(), account: '', password: '', updated_at: Date.now() });
    renderGroupView();
    const rows = itemListEl.querySelectorAll('.acc-item');
    const last = rows[rows.length - 1];
    if (last) last.querySelector('.acc-item-account').focus();
    renderGroupList();
    scheduleSave(true);
  }

  async function removeItem(id) {
    const g = currentGroup();
    if (!g) return;
    const idx = g.items.findIndex((it) => it.id === id);
    if (idx < 0) return;
    const it = g.items[idx];
    const ok = await window.showConfirm(
      '确定删除账号「' + (it.account || '未填账号') + '」吗？删除后无法恢复。',
      { title: '删除账号', okText: '删除' }
    );
    if (!ok) return;
    g.items.splice(idx, 1);
    renderGroupView();
    renderGroupList();
    scheduleSave(true);
  }

  async function copyItem(item, kind) {
    if (kind === 'account') {
      if (!item.account) {
        window.toast('账号为空，无可复制');
        return;
      }
      await window.copyText(item.account, '已复制账号');
    } else if (kind === 'password') {
      if (!item.password) {
        window.toast('密码为空，无可复制');
        return;
      }
      await window.copyText(item.password, '已复制密码');
    } else {
      if (!item.account && !item.password) {
        window.toast('账号和密码均为空，无可复制');
        return;
      }
      await window.copyText('账号：' + item.account + '\n密码：' + item.password, '已复制账号和密码');
    }
  }

  function handleCopyClick(e, itemFn) {
    const li = e.target.closest('.acc-item');
    if (!li) return;
    const item = itemFn(li.dataset.id);
    if (!item) return;
    if (e.target.closest('.acc-copy-account')) copyItem(item, 'account');
    else if (e.target.closest('.acc-copy-password')) copyItem(item, 'password');
    else if (e.target.closest('.acc-copy-both')) copyItem(item, 'both');
  }

  // ---------- 搜索 ----------

  function clearSearch() {
    clearTimeout(searchTimer);
    searchEl.value = '';
    state.keyword = '';
    searchClearEl.classList.add('hidden');
    renderMainView();
  }

  // ---------- 事件绑定 ----------

  // 组视图：条目编辑 + 复制 + 删除（事件委托）
  itemListEl.addEventListener('input', (e) => {
    const li = e.target.closest('.acc-item');
    if (!li) return;
    const g = currentGroup();
    if (!g) return;
    const item = g.items.find((it) => it.id === li.dataset.id);
    if (!item) return;
    if (e.target.classList.contains('acc-item-account')) {
      item.account = e.target.value;
      item.updated_at = Date.now();
      scheduleSave();
    } else if (e.target.classList.contains('acc-item-password')) {
      item.password = e.target.value;
      item.updated_at = Date.now();
      scheduleSave();
    }
  });

  itemListEl.addEventListener('click', (e) => {
    const li = e.target.closest('.acc-item');
    if (!li) return;
    const g = currentGroup();
    if (!g) return;
    const item = g.items.find((it) => it.id === li.dataset.id);
    if (!item) return;
    if (e.target.closest('.acc-item-remove')) removeItem(item.id);
    else handleCopyClick(e, () => item);
  });

  // 搜索结果：复制（事件委托）
  searchListEl.addEventListener('click', (e) => handleCopyClick(e, findItemById));

  // 组名直接编辑
  groupNameEl.addEventListener('input', () => {
    const g = currentGroup();
    if (!g) return;
    g.name = groupNameEl.value;
    const li = groupListEl.querySelector('.acc-group-item[data-id="' + g.id + '"] .acc-group-item-name');
    if (li) li.textContent = g.name || '未命名分组';
    scheduleSave();
  });

  // 搜索输入（防抖过滤）
  searchEl.addEventListener('input', () => {
    clearTimeout(searchTimer);
    searchTimer = setTimeout(() => {
      state.keyword = searchEl.value;
      searchClearEl.classList.toggle('hidden', !isSearching());
      renderMainView();
    }, 120);
  });

  searchEl.addEventListener('keydown', (e) => {
    if (e.key === 'Escape' && searchEl.value) {
      e.stopPropagation();
      clearSearch();
    }
  });

  searchClearEl.addEventListener('click', clearSearch);

  // 显示 / 隐藏密码
  togglePwdBtn.addEventListener('click', () => {
    state.showPwd = !state.showPwd;
    togglePwdBtn.textContent = state.showPwd ? '隐藏密码' : '显示密码';
    itemListEl.querySelectorAll('.acc-item-password').forEach((inp) => {
      inp.type = state.showPwd ? 'text' : 'password';
    });
    if (isSearching()) renderSearch();
  });

  document.getElementById('acc-new-group').addEventListener('click', createGroup);
  document.getElementById('acc-del-group').addEventListener('click', removeGroup);
  document.getElementById('acc-add-item').addEventListener('click', addItem);

  // ---------- 初始化 ----------

  async function init() {
    if (!invoke) {
      setSaveStatus('', 'Tauri 接口不可用（请通过应用运行）');
      renderAll();
      return;
    }
    try {
      const groups = await invoke('accounts_load');
      state.groups = Array.isArray(groups) ? groups : [];
      state.groups.forEach((g) => {
        if (!Array.isArray(g.items)) g.items = [];
      });
    } catch (e) {
      window.toast('加载账号密码失败：' + e);
      state.groups = [];
    }
    if (state.groups.length) state.currentGroupId = state.groups[0].id;
    renderAll();
    setSaveStatus('', '就绪');
  }

  init();
})();
