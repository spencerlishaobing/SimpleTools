/* ===== 账号密码管理（分组 + 条目增删改 + 备注 + 复制 + 搜索过滤 + 命中高亮） ===== */
(function () {
  'use strict';

  const invoke = (window.__TAURI__ && window.__TAURI__.core && window.__TAURI__.core.invoke) || null;
  const dialogApi = (window.__TAURI__ && window.__TAURI__.dialog) || null;

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
  // 数据加载完成前（含加载失败）禁止落盘：blur 立即保存用于防丢数据，
  // 但加载阶段的失焦（如自动化焦点抖动）会把尚未加载的空数组覆盖写盘
  let loaded = false;
  let searchTimer = null;

  // ---------- 工具 ----------

  const ESC_MAP = { '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;', "'": '&#39;' };
  function esc(s) {
    return String(s).replace(/[&<>"']/g, (c) => ESC_MAP[c]);
  }

  // 命中高亮：把 text 中所有匹配 keyword 的片段（大小写不敏感）包裹为 <mark> 后返回安全 HTML
  // 注意：必须先分段再逐段转义，不能先转义后匹配（转义会改变命中位置）
  function hlHtml(text, keyword) {
    const s = String(text == null ? '' : text);
    const kw = String(keyword || '');
    if (!kw) return esc(s);
    const lower = s.toLowerCase();
    const k = kw.toLowerCase();
    let out = '';
    let i = 0;
    while (i < s.length) {
      const idx = lower.indexOf(k, i);
      if (idx < 0) {
        out += esc(s.slice(i));
        break;
      }
      out += esc(s.slice(i, idx)) + '<mark class="acc-hl">' + esc(s.slice(idx, idx + k.length)) + '</mark>';
      i = idx + k.length;
    }
    return out;
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

  // 拖拽手柄图标（两列三点）
  const GRIP_SVG =
    '<svg viewBox="0 0 24 24" fill="currentColor" aria-hidden="true">' +
    '<circle cx="9" cy="6" r="1.7"/><circle cx="15" cy="6" r="1.7"/>' +
    '<circle cx="9" cy="12" r="1.7"/><circle cx="15" cy="12" r="1.7"/>' +
    '<circle cx="9" cy="18" r="1.7"/><circle cx="15" cy="18" r="1.7"/></svg>';

  // 复制操作图标（人形 = 复制账号 / 锁 = 复制密码 / 双矩形 = 一键复制）
  const USER_SVG =
    '<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" ' +
    'stroke-linecap="round" stroke-linejoin="round">' +
    '<path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"/>' +
    '<circle cx="12" cy="7" r="4"/></svg>';

  const LOCK_SVG =
    '<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" ' +
    'stroke-linecap="round" stroke-linejoin="round">' +
    '<rect x="4" y="11" width="16" height="10" rx="2"/>' +
    '<path d="M8 11V7a4 4 0 0 1 8 0v4"/></svg>';

  const COPY_SVG =
    '<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" ' +
    'stroke-linecap="round" stroke-linejoin="round">' +
    '<rect x="9" y="9" width="13" height="13" rx="2"/>' +
    '<path d="M5 15H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h9a2 2 0 0 1 2 2v1"/></svg>';

  function actionButtons(withRemove) {
    let html =
      '<button class="acc-icon-btn acc-copy-account" title="复制账号">' + USER_SVG + '</button>' +
      '<button class="acc-icon-btn acc-copy-password" title="复制密码">' + LOCK_SVG + '</button>' +
      '<button class="acc-icon-btn acc-copy-both" title="一键复制账号和密码">' + COPY_SVG + '</button>';
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
    if (!invoke || saving || !loaded) return;
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
      li.draggable = true;
      li.innerHTML =
        '<span class="acc-group-item-name">' + esc(g.name || '未命名分组') + '</span>' +
        '<span class="acc-group-item-count">' + g.items.length + '</span>';
      li.addEventListener('click', () => selectGroup(g.id));
      groupListEl.appendChild(li);
    }
    groupEmptyEl.classList.toggle('hidden', state.groups.length > 0);
  }

  // 备注（账号描述）textarea 高度随内容自适应：全量展示、无内部滚动
  function syncNoteHeight(el) {
    el.style.height = 'auto';
    el.style.height = el.scrollHeight + 'px';
  }

  function itemRowHtml(item) {
    return '<li class="acc-item" data-id="' + esc(item.id) + '">' +
      '<span class="acc-item-grip" draggable="true" title="拖拽排序">' + GRIP_SVG + '</span>' +
      '<div class="acc-item-main">' +
      '<div class="acc-item-fields">' +
      '<input class="acc-input acc-item-account" value="' + esc(item.account) + '"' +
      ' placeholder="账号" spellcheck="false" autocomplete="off" />' +
      '<input class="acc-input acc-item-password" type="' + (state.showPwd ? 'text' : 'password') + '"' +
      ' value="' + esc(item.password) + '" placeholder="密码" spellcheck="false" autocomplete="off" />' +
      '</div>' +
      '<textarea class="acc-item-note" placeholder="备注（可选）" spellcheck="false"' +
      ' rows="1">' + esc(item.note || '') + '</textarea>' +
      '</div>' +
      actionButtons(true) +
      '</li>';
  }

  function renderGroupView() {
    const g = currentGroup();
    if (!g) return;
    groupNameEl.value = g.name || '';
    itemListEl.innerHTML = g.items.map(itemRowHtml).join('');
    itemListEl.querySelectorAll('.acc-item-note').forEach(syncNoteHeight);
    itemEmptyEl.classList.toggle('hidden', g.items.length > 0);
  }

  // 搜索匹配：分组名 / 账号 / 备注 三者模糊匹配（大小写不敏感）；
  // 分组名命中则组内条目全部列出；同一条目命中多处只保留一次（天然去重）
  function searchMatches() {
    const kw = state.keyword.trim().toLowerCase();
    const out = [];
    for (const g of state.groups) {
      const groupHit = String(g.name || '').toLowerCase().indexOf(kw) >= 0;
      for (const it of g.items) {
        const accountHit = !!(it.account && it.account.toLowerCase().indexOf(kw) >= 0);
        const noteHit = !!(it.note && String(it.note).toLowerCase().indexOf(kw) >= 0);
        if (groupHit || accountHit || noteHit) {
          out.push({ group: g, item: it });
        }
      }
    }
    return out;
  }

  function renderSearch() {
    const matches = searchMatches();
    const kw = state.keyword.trim();
    searchHeadEl.textContent = '找到 ' + matches.length + ' 条匹配（按分组名 / 账号 / 备注关键字）';
    searchListEl.innerHTML = matches.map((m) => {
      const it = m.item;
      const pwdText = it.password ? (state.showPwd ? it.password : '••••••') : '（空）';
      return '<li class="acc-item acc-search-item" data-id="' + esc(it.id) + '">' +
        '<span class="acc-search-group">' + hlHtml(m.group.name || '未命名分组', kw) + '</span>' +
        '<span class="acc-search-account">' + hlHtml(it.account, kw) + '</span>' +
        (it.note ? '<span class="acc-search-note" title="备注">' + hlHtml(it.note, kw) + '</span>' : '') +
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

  // ---------- 分组拖动排序（侧栏整行可拖；v0.33.0 空位跟随模型见 drag-sort.js） ----------

  window.DragSort.init({
    listEl: groupListEl,
    itemSelector: '.acc-group-item',
    // 空位移动已在 DOM 上就位：drop 时仅按最新 DOM 顺序落盘，不整表重渲染
    onDrop: (el, newIndex) => {
      const from = state.groups.findIndex((g) => g.id === el.dataset.id);
      if (from < 0 || from === newIndex) return;
      const g = state.groups.splice(from, 1)[0];
      state.groups.splice(newIndex, 0, g);
      scheduleSave(true);
    },
  });

  // ---------- 条目操作 ----------

  function addItem() {
    const g = currentGroup();
    if (!g) {
      window.toast('请先选择分组');
      return;
    }
    g.items.push({ id: genId(), account: '', password: '', note: '', updated_at: Date.now() });
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

  // ---------- 条目拖动排序（手柄拖拽：行内均为输入框 / 按钮，手柄提供明确的拖动区） ----------

  window.DragSort.init({
    listEl: itemListEl,
    itemSelector: '.acc-item',
    handleSelector: '.acc-item-grip',
    onDrop: (el, newIndex) => {
      const g = currentGroup();
      if (!g) return;
      const from = g.items.findIndex((it) => it.id === el.dataset.id);
      if (from < 0 || from === newIndex) return;
      const item = g.items.splice(from, 1)[0];
      g.items.splice(newIndex, 0, item);
      scheduleSave(true);
    },
  });

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

  // ---------- 批量导出（TXT / 表格 CSV，自选文件夹） ----------

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

  // 点「导出」后弹出范围 / 格式选择菜单（贴按钮定位，空间不足时上移）
  function openExportMenu(btn) {
    closeExportMenu();
    const total = state.groups.reduce((s, g) => s + g.items.length, 0);
    if (!total) {
      window.toast('暂无可导出的账号');
      return;
    }
    const hasGroup = !!currentGroup();
    const menu = document.createElement('div');
    menu.className = 'export-menu';
    menu.innerHTML =
      '<button type="button" data-scope="group" data-fmt="txt"' + (hasGroup ? '' : ' disabled') + '>导出当前分组 · TXT</button>' +
      '<button type="button" data-scope="group" data-fmt="csv"' + (hasGroup ? '' : ' disabled') + '>导出当前分组 · 表格 CSV</button>' +
      '<button type="button" data-scope="all" data-fmt="txt">导出全部账号 · TXT</button>' +
      '<button type="button" data-scope="all" data-fmt="csv">导出全部账号 · 表格 CSV</button>';
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
        const scope = b.dataset.scope;
        const fmt = b.dataset.fmt;
        closeExportMenu();
        runExport(scope, fmt);
      });
    });
    setTimeout(() => {
      exportMenuDocHandler = (ev) => {
        if (exportMenuEl && !exportMenuEl.contains(ev.target)) closeExportMenu();
      };
      document.addEventListener('click', exportMenuDocHandler);
    }, 0);
  }

  function pad2(x) {
    return String(x).padStart(2, '0');
  }

  function exportStamp() {
    const d = new Date();
    return d.getFullYear() + pad2(d.getMonth() + 1) + pad2(d.getDate()) + '-' +
      pad2(d.getHours()) + pad2(d.getMinutes()) + pad2(d.getSeconds());
  }

  // 清洗文件名：替换 Windows 非法字符，去掉结尾的点 / 空格并限长
  function sanitizeFileName(name) {
    let n = String(name || '').trim().replace(/[\\/:*?"<>|\u0000-\u001f]/g, '_');
    n = n.replace(/[\. ]+$/, '').trim();
    if (!n) n = '未命名';
    if (n.length > 60) n = n.slice(0, 60);
    return n;
  }

  // TXT 格式：导出时间 + 按分组罗列（UTF-8 BOM，兼容 Windows 记事本）
  function buildTxt(groups) {
    const d = new Date();
    const stampText = d.getFullYear() + '-' + pad2(d.getMonth() + 1) + '-' + pad2(d.getDate()) + ' ' +
      pad2(d.getHours()) + ':' + pad2(d.getMinutes()) + ':' + pad2(d.getSeconds());
    const total = groups.reduce((s, g) => s + g.items.length, 0);
    let out = '账号密码导出 · ' + stampText + '\n分组数：' + groups.length + '  条目数：' + total + '\n';
    for (const g of groups) {
      out += '\n【' + (g.name || '未命名分组') + '】（' + g.items.length + ' 条）\n';
      if (!g.items.length) {
        out += '（空分组）\n';
        continue;
      }
      g.items.forEach((it, i) => {
        out += (i + 1) + '. 账号：' + (it.account || '（空）') + '\n   密码：' + (it.password || '（空）') + '\n';
        if (it.note) out += '   备注：' + it.note + '\n';
      });
    }
    return '\uFEFF' + out;
  }

  // CSV 字段转义（RFC 4180）：含逗号 / 引号 / 换行时加引号
  function csvField(v) {
    const s = String(v == null ? '' : v);
    if (/[",\r\n]/.test(s)) return '"' + s.replace(/"/g, '""') + '"';
    return s;
  }

  // 表格 CSV：表头 + 每条一行（UTF-8 BOM，Excel 直接打开）
  function buildCsv(groups) {
    let out = '分组,账号,密码,备注\r\n';
    for (const g of groups) {
      for (const it of g.items) {
        out += [csvField(g.name || '未命名分组'), csvField(it.account), csvField(it.password), csvField(it.note)].join(',') + '\r\n';
      }
    }
    return '\uFEFF' + out;
  }

  // 选择文件夹后写入（文件名带导出时间戳）
  async function runExport(scope, fmt) {
    if (!invoke || !dialogApi || !dialogApi.open) {
      window.toast('Tauri 接口不可用（请通过应用运行）');
      return;
    }
    const groups = scope === 'group' ? [currentGroup()].filter(Boolean) : state.groups;
    const total = groups.reduce((s, g) => s + g.items.length, 0);
    if (!groups.length || !total) {
      window.toast('没有可导出的账号');
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
    const base = scope === 'group'
      ? sanitizeFileName(groups[0].name) + '-账号密码'
      : '账号密码-全部';
    const name = base + '-' + exportStamp() + (fmt === 'csv' ? '.csv' : '.txt');
    const content = fmt === 'csv' ? buildCsv(groups) : buildTxt(groups);
    try {
      const count = await invoke('accounts_export', { dir, files: [{ name, content }] });
      window.toast('已导出 ' + total + ' 条账号（' + count + ' 个文件）');
    } catch (e) {
      window.toast('导出失败：' + e);
    }
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
    } else if (e.target.classList.contains('acc-item-note')) {
      item.note = e.target.value;
      item.updated_at = Date.now();
      syncNoteHeight(e.target);
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
  document.getElementById('acc-export').addEventListener('click', (e) => {
    e.stopPropagation();
    openExportMenu(e.currentTarget);
  });

  // ---------- 初始化 ----------

  async function init() {
    if (!invoke) {
      setSaveStatus('', 'Tauri 接口不可用（请通过应用运行）');
      renderAll();
      return;
    }
    try {
      const groups = await invoke('accounts_load');
      // 归一化（兼容旧数据缺字段）：分组 / 条目 id 缺失补生成，名称 / 账号 / 密码补空串，
      // 备注非字符串补空、updated_at 缺失补 0
      state.groups = (Array.isArray(groups) ? groups : [])
        .filter((g) => g && typeof g === 'object')
        .map((g) => ({
          id: g.id || genId(),
          name: String(g.name == null ? '' : g.name),
          items: (Array.isArray(g.items) ? g.items : [])
            .filter((it) => it && typeof it === 'object')
            .map((it) => ({
              id: it.id || genId(),
              account: String(it.account == null ? '' : it.account),
              password: String(it.password == null ? '' : it.password),
              note: typeof it.note === 'string' ? it.note : '',
              updated_at: Number(it.updated_at) || 0,
            })),
        }));
      loaded = true; // 加载成功后才允许保存（见 doSave）
    } catch (e) {
      window.toast('加载账号密码失败：' + e);
      state.groups = [];
    }
    if (state.groups.length) state.currentGroupId = state.groups[0].id;
    renderAll();
    setSaveStatus('', '就绪');
  }

  init();

  // 面板由隐藏变为可见时（activatePanel 派发 panel-shown）：重算备注 textarea 高度
  // （面板隐藏状态下 scrollHeight 为 0，初始化渲染会算出 0 高度）
  document.getElementById('panel-accounts').addEventListener('panel-shown', () => {
    itemListEl.querySelectorAll('.acc-item-note').forEach(syncNoteHeight);
  });
})();
