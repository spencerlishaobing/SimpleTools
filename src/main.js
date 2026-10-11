/* ===== 主入口：导航切换 + 全局 Toast + 主题切换 ===== */
(function () {
  'use strict';

  // ---------- Toast 提示 ----------
  const toastEl = document.getElementById('toast');
  let toastTimer = null;

  window.toast = function (msg) {
    toastEl.textContent = msg;
    toastEl.classList.add('show');
    clearTimeout(toastTimer);
    toastTimer = setTimeout(() => toastEl.classList.remove('show'), 2200);
  };

  // ---------- 统一的剪贴板复制（三级降级，确保可靠） ----------
  window.copyText = async function (text, okMsg) {
    if (!text) return false;
    const done = () => {
      window.toast(okMsg || '已复制到剪贴板');
      return true;
    };
    // 1) Tauri 官方 clipboard 插件（最可靠）
    try {
      const cm = (window.__TAURI__ &&
        (window.__TAURI__.clipboardManager || window.__TAURI__['clipboard-manager'])) || null;
      if (cm && cm.writeText) {
        await cm.writeText(text);
        return done();
      }
    } catch (e) { /* 继续降级 */ }
    // 2) 浏览器 Clipboard API
    try {
      await navigator.clipboard.writeText(text);
      return done();
    } catch (e) { /* 继续降级 */ }
    // 3) execCommand 兜底
    try {
      const ta = document.createElement('textarea');
      ta.value = text;
      ta.style.position = 'fixed';
      ta.style.opacity = '0';
      document.body.appendChild(ta);
      ta.select();
      const ok = document.execCommand('copy');
      document.body.removeChild(ta);
      if (ok) return done();
    } catch (e) { /* ignore */ }
    window.toast('复制失败，请手动选择文本复制');
    return false;
  };

  // ---------- 通用确认弹窗（替代原生 confirm，两者均安全可靠） ----------
  window.showConfirm = function (message, opts) {
    opts = opts || {};
    return new Promise(function (resolve) {
      const mask = document.getElementById('confirm-modal');
      const titleEl = document.getElementById('confirm-title');
      const msgEl = document.getElementById('confirm-message');
      const okBtn = document.getElementById('confirm-ok');
      const cancelBtn = document.getElementById('confirm-cancel');

      titleEl.textContent = opts.title || '确认操作';
      msgEl.textContent = message;
      okBtn.textContent = opts.okText || '确定';
      mask.classList.remove('hidden');
      cancelBtn.focus(); // 默认焦点放在取消上，避免误回车删除

      function cleanup(result) {
        mask.classList.add('hidden');
        okBtn.removeEventListener('click', onOk);
        cancelBtn.removeEventListener('click', onCancel);
        mask.removeEventListener('click', onMask);
        resolve(result);
      }
      function onOk() { cleanup(true); }
      function onCancel() { cleanup(false); }
      function onMask(e) { if (e.target === mask) cleanup(false); }

      okBtn.addEventListener('click', onOk);
      cancelBtn.addEventListener('click', onCancel);
      mask.addEventListener('click', onMask);
    });
  };

  // 弹窗内的点击不冒泡到 document（避免误触发其他组件的“点击空白关闭”逻辑）
  document.getElementById('confirm-modal').addEventListener('click', function (e) {
    e.stopPropagation();
  });

  // ---------- 面板切换 ----------
  const navItems = document.querySelectorAll('.nav-item');
  const panels = document.querySelectorAll('.panel');

  function activatePanel(target) {
    navItems.forEach((b) => b.classList.toggle('active', b.dataset.panel === target));
    panels.forEach((p) => p.classList.toggle('active', p.id === 'panel-' + target));
  }

  navItems.forEach((btn) => {
    btn.addEventListener('click', async () => {
      const target = btn.dataset.panel;
      // 「账号密码」安全锁：开启后需先通过 Windows Hello 验证
      if (target === 'accounts' && accLockEnabled()) {
        const ok = await requireHelloVerify('验证以查看「账号密码」');
        if (!ok) return;
      }
      activatePanel(target);
    });
  });

  // ---------- 功能显示（v0.26.0）：侧边栏导航样式（图标 / 名称 / 两者）+ 功能显隐 ----------
  // - 导航样式：both（图标 + 名称，默认）/ icon（仅图标，侧边栏缩窄为 64px）/ label（仅名称）
  // - 功能显隐：取消勾选的功能从侧边栏隐藏（数据不受影响），至少保留一个功能
  // - 持久化于 localStorage；页面加载时由 head 内联脚本尽早应用样式，避免启动时闪动
  const NAV_STYLE_KEY = 'simpletools-nav-style';
  const NAV_HIDDEN_KEY = 'simpletools-nav-hidden';
  const NAV_STYLE_ALL = ['both', 'icon', 'label'];
  const navStyleGroup = document.getElementById('nav-style-group');
  const navFeatureGrid = document.getElementById('nav-feature-grid');
  const htmlRoot = document.documentElement;

  function readNavStyle() {
    try {
      const v = localStorage.getItem(NAV_STYLE_KEY);
      return NAV_STYLE_ALL.indexOf(v) >= 0 ? v : 'both';
    } catch (e) {
      return 'both';
    }
  }

  const navHidden = (function () {
    try {
      const arr = JSON.parse(localStorage.getItem(NAV_HIDDEN_KEY) || '[]');
      return new Set(Array.isArray(arr) ? arr.filter((k) => typeof k === 'string') : []);
    } catch (e) {
      return new Set();
    }
  })();

  function writeNavHidden() {
    try {
      if (navHidden.size) localStorage.setItem(NAV_HIDDEN_KEY, JSON.stringify([...navHidden]));
      else localStorage.removeItem(NAV_HIDDEN_KEY);
    } catch (e) { /* ignore */ }
  }

  function applyNavStyle(style) {
    if (style === 'both') htmlRoot.removeAttribute('data-nav-style');
    else htmlRoot.setAttribute('data-nav-style', style);
    // 仅图标模式下给按钮加悬停提示（提示功能名）
    navItems.forEach((btn) => {
      const label = btn.querySelector('.nav-label');
      if (style === 'icon' && label) btn.title = label.textContent.trim();
      else btn.removeAttribute('title');
    });
    navStyleGroup.querySelectorAll('.nav-style-item').forEach((b) => {
      b.classList.toggle('is-active', b.dataset.navStyle === style);
    });
  }

  function applyNavHidden() {
    navItems.forEach((btn) => {
      btn.classList.toggle('nav-hidden', navHidden.has(btn.dataset.panel));
    });
    navFeatureGrid.querySelectorAll('input[data-feature]').forEach((cb) => {
      cb.checked = !navHidden.has(cb.dataset.feature);
      cb.closest('.nav-feature-item').classList.toggle('is-on', cb.checked);
    });
  }

  // 当前激活的功能被隐藏时，自动切到第一个可见功能
  // （「账号密码」需 Hello 校验：自动切换不绕过校验，改选下一个可见功能；无替代时保持现状）
  function ensureActiveNav() {
    const list = Array.prototype.slice.call(navItems);
    const active = list.find((b) => b.classList.contains('active'));
    if (active && !active.classList.contains('nav-hidden')) return;
    const visible = list.filter((b) => !b.classList.contains('nav-hidden'));
    if (!visible.length) return;
    let target = visible[0];
    if (target.dataset.panel === 'accounts' && accLockEnabled()) {
      const alt = visible.find((b) => b.dataset.panel !== 'accounts');
      if (!alt) return;
      target = alt;
    }
    activatePanel(target.dataset.panel);
  }

  navStyleGroup.addEventListener('click', (e) => {
    const btn = e.target.closest('.nav-style-item');
    if (!btn) return;
    try { localStorage.setItem(NAV_STYLE_KEY, btn.dataset.navStyle); } catch (err) { /* ignore */ }
    applyNavStyle(btn.dataset.navStyle);
  });

  navFeatureGrid.addEventListener('change', (e) => {
    const cb = e.target.closest('input[data-feature]');
    if (!cb) return;
    const key = cb.dataset.feature;
    // 至少保留一个功能：取消最后一个可见功能时阻止
    if (!cb.checked && !navHidden.has(key) && navHidden.size >= navItems.length - 1) {
      cb.checked = true;
      window.toast('至少需要保留一个功能');
      return;
    }
    if (cb.checked) navHidden.delete(key);
    else navHidden.add(key);
    writeNavHidden();
    applyNavHidden();
    ensureActiveNav();
  });

  applyNavStyle(readNavStyle());
  applyNavHidden();

  // ---------- 主题切换（浅色 / 深色 / 深浅混搭 / 卡其色：点按钮弹出菜单直接选择，持久化） ----------
  const THEME_KEY = 'simpletools-theme';
  const THEME_ORDER = ['light', 'dark', 'mix', 'khaki'];
  const THEME_LABEL = { light: '浅色模式', dark: '深色模式', mix: '深浅混搭', khaki: '卡其模式' };
  const themeToggle = document.getElementById('theme-toggle');
  const themeLabel = document.getElementById('theme-label');
  const invokeApi = (window.__TAURI__ && window.__TAURI__.core && window.__TAURI__.core.invoke) || null;
  const dialogApi = (window.__TAURI__ && window.__TAURI__.dialog) || null;

  // 各主题的系统标题栏配色（背景 / 标题文字 / 下边框，与主题变量一致）
  // 深浅混搭（v0.21.0）：标题栏跟随深色侧边栏（#020617），与深色功能菜单连成一体
  const TITLEBAR_COLORS = {
    light: { bg: '#f6f7f9', text: '#1f2937', border: '#e2e8f0' },
    dark: { bg: '#0f172a', text: '#e2e8f0', border: '#334155' },
    mix: { bg: '#020617', text: '#e2e8f0', border: '#1e293b' },
    khaki: { bg: '#0f0e0c', text: '#e8e0d0', border: '#2e2b24' },
  };

  function syncTitlebar(theme) {
    if (!invokeApi) return;
    const c = TITLEBAR_COLORS[theme] || TITLEBAR_COLORS.light;
    try {
      const p = invokeApi('set_titlebar_color', { bg: c.bg, text: c.text, border: c.border });
      if (p && p.catch) p.catch(() => {});
    } catch (e) { /* ignore */ }
  }

  function currentTheme() {
    const t = document.documentElement.getAttribute('data-theme');
    return t === 'dark' || t === 'khaki' || t === 'mix' ? t : 'light';
  }

  function updateToggleUI(theme) {
    // 按钮文案表示当前主题（图标由 CSS 按 data-theme 显示当前主题对应图标）
    themeLabel.textContent = THEME_LABEL[theme];
  }

  function applyTheme(theme) {
    if (theme === 'light') {
      document.documentElement.removeAttribute('data-theme');
    } else {
      document.documentElement.setAttribute('data-theme', theme);
    }
    try {
      localStorage.setItem(THEME_KEY, theme);
    } catch (e) { /* ignore */ }
    updateToggleUI(theme);
    syncTitlebar(theme);
  }

  // ---------- 主题选择菜单（点按钮弹出，直接点选；复用导出菜单样式与关闭机制） ----------
  const THEME_MENU_ICONS = {
    light: '<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" aria-hidden="true">' +
      '<circle cx="12" cy="12" r="5"/><line x1="12" y1="1" x2="12" y2="3"/><line x1="12" y1="21" x2="12" y2="23"/>' +
      '<line x1="4.22" y1="4.22" x2="5.64" y2="5.64"/><line x1="18.36" y1="18.36" x2="19.78" y2="19.78"/>' +
      '<line x1="1" y1="12" x2="3" y2="12"/><line x1="21" y1="12" x2="23" y2="12"/>' +
      '<line x1="4.22" y1="19.78" x2="5.64" y2="18.36"/><line x1="18.36" y1="5.64" x2="19.78" y2="4.22"/></svg>',
    dark: '<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" aria-hidden="true">' +
      '<path d="M21 12.79A9 9 0 1 1 11.21 3 7 7 0 0 0 21 12.79z"/></svg>',
    mix: '<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" aria-hidden="true">' +
      '<circle cx="12" cy="12" r="9"/><path d="M12 3a9 9 0 0 0 0 18z" fill="currentColor" stroke="none"/></svg>',
    khaki: '<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" aria-hidden="true">' +
      '<path d="M18 8h1a4 4 0 0 1 0 8h-1"/><path d="M2 8h16v9a4 4 0 0 1-4 4H6a4 4 0 0 1-4-4V8z"/>' +
      '<line x1="6" y1="1" x2="6" y2="4"/><line x1="10" y1="1" x2="10" y2="4"/><line x1="14" y1="1" x2="14" y2="4"/></svg>',
  };
  const THEME_CHECK_ICON = '<svg class="theme-check" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.5" stroke-linecap="round" stroke-linejoin="round" aria-hidden="true"><polyline points="20 6 9 17 4 12"/></svg>';

  let themeMenuEl = null;
  let themeMenuDocHandler = null;

  function closeThemeMenu() {
    if (themeMenuEl) {
      themeMenuEl.remove();
      themeMenuEl = null;
    }
    if (themeMenuDocHandler) {
      document.removeEventListener('click', themeMenuDocHandler);
      themeMenuDocHandler = null;
    }
  }

  // 点主题按钮后弹出菜单（贴按钮左缘定位；按钮位于侧边栏底部，默认向上弹出）
  function openThemeMenu() {
    closeThemeMenu();
    const cur = currentTheme();
    const menu = document.createElement('div');
    menu.className = 'export-menu theme-menu';
    menu.innerHTML = THEME_ORDER.map((t) =>
      '<button type="button" data-theme-opt="' + t + '"' + (t === cur ? ' class="is-active"' : '') + '>' +
      THEME_MENU_ICONS[t] + '<span>' + THEME_LABEL[t] + '</span>' +
      (t === cur ? THEME_CHECK_ICON : '') + '</button>').join('');
    document.body.appendChild(menu);
    const rect = themeToggle.getBoundingClientRect();
    let left = rect.left;
    if (left + menu.offsetWidth > window.innerWidth - 8) left = window.innerWidth - menu.offsetWidth - 8;
    if (left < 8) left = 8;
    let top = rect.top - menu.offsetHeight - 6;
    if (top < 8) top = rect.bottom + 6;
    menu.style.left = left + 'px';
    menu.style.top = top + 'px';
    themeMenuEl = menu;
    menu.querySelectorAll('button[data-theme-opt]').forEach((b) => {
      b.addEventListener('click', (e) => {
        e.stopPropagation();
        const t = b.dataset.themeOpt;
        closeThemeMenu();
        applyTheme(t);
      });
    });
    setTimeout(() => {
      themeMenuDocHandler = (ev) => {
        if (themeMenuEl && !themeMenuEl.contains(ev.target)) closeThemeMenu();
      };
      document.addEventListener('click', themeMenuDocHandler);
    }, 0);
  }

  themeToggle.addEventListener('click', (e) => {
    e.stopPropagation();
    openThemeMenu();
  });

  updateToggleUI(currentTheme());
  syncTitlebar(currentTheme());

  // ---------- 应用设置：账号密码安全锁（v0.15.0；v0.19.0 起改为 Windows Hello 验证） ----------
  // - 账号密码数据由 Rust 侧 DPAPI 加密落盘（见 src-tauri/winsec.rs）
  // - 开启本开关后进入「账号密码」需完成 Windows Hello 验证（PIN / 指纹 / 面容），开关的开启/关闭同样需要验证
  // - Windows Hello 不可用（未配置 PIN 等）时给出提示
  const ACC_LOCK_KEY = 'simpletools-acc-lock';
  const settingsBtn = document.getElementById('settings-btn');
  const settingsMask = document.getElementById('settings-modal');
  const settingsCloseBtn = document.getElementById('settings-close');
  const accLockSwitch = document.getElementById('acc-lock-switch');
  const authMask = document.getElementById('auth-modal');
  const authTipEl = document.getElementById('auth-tip');
  const authOkBtn = document.getElementById('auth-ok');
  const dataDirPathEl = document.getElementById('data-dir-path');
  const dataDirChangeBtn = document.getElementById('data-dir-change');
  const dataDirResetBtn = document.getElementById('data-dir-reset');
  let dataDirInfo = null;

  function accLockEnabled() {
    try {
      return localStorage.getItem(ACC_LOCK_KEY) === '1';
    } catch (e) {
      return false;
    }
  }

  function setAccLock(on) {
    try {
      if (on) localStorage.setItem(ACC_LOCK_KEY, '1');
      else localStorage.removeItem(ACC_LOCK_KEY);
    } catch (e) { /* ignore */ }
  }

  // 安全提示弹窗（Windows Hello 不可用时说明原因；点「知道了」/ 遮罩关闭）
  function showAuthNotice(tip) {
    return new Promise(function (resolve) {
      authTipEl.textContent = tip;
      authMask.classList.remove('hidden');

      function cleanup() {
        authMask.classList.add('hidden');
        authOkBtn.removeEventListener('click', cleanup);
        authMask.removeEventListener('click', onMask);
        resolve();
      }
      function onMask(e) { if (e.target === authMask) cleanup(); }

      authOkBtn.addEventListener('click', cleanup);
      authMask.addEventListener('click', onMask);
      setTimeout(function () { authOkBtn.focus(); }, 30);
    });
  }

  // Windows Hello 身份校验：verified → true；取消 / 失败 / 环境不可用均 false
  // （验证交互由系统 Hello 弹窗接管，自绘弹窗仅用于展示不可用原因）
  async function requireHelloVerify(tip) {
    if (!invokeApi) return false;
    let avail;
    try {
      avail = await invokeApi('hello_availability');
    } catch (e) {
      window.toast('无法检测 Windows Hello 状态，请稍后重试');
      return false;
    }
    if (avail === 'not_configured') {
      await showAuthNotice('此功能需要先配置 Windows Hello：请在「Windows 设置 → 账户 → 登录选项」中设置 PIN 码、指纹或面容');
      return false;
    }
    if (avail === 'device_not_present') {
      await showAuthNotice('当前电脑不支持 Windows Hello 验证（未检测到可用的验证设备）');
      return false;
    }
    if (avail === 'disabled_by_policy') {
      await showAuthNotice('Windows Hello 已被系统策略禁用，无法完成验证');
      return false;
    }
    if (avail === 'device_busy') {
      await showAuthNotice('Windows Hello 当前被占用，请稍后重试');
      return false;
    }
    if (avail !== 'available') {
      await showAuthNotice('Windows Hello 当前不可用，无法完成验证');
      return false;
    }
    let result;
    try {
      result = await invokeApi('hello_verify', { message: tip });
    } catch (e) {
      window.toast('Windows Hello 验证失败，请重试');
      return false;
    }
    if (result === 'verified') return true;
    if (result === 'canceled') return false;
    if (result === 'retries_exhausted') {
      window.toast('验证失败次数过多，请稍后重试');
      return false;
    }
    window.toast('Windows Hello 验证未通过，请重试');
    return false;
  }

  // 设置弹窗
  function openSettings() {
    accLockSwitch.checked = accLockEnabled();
    refreshDataDirInfo();
    settingsMask.classList.remove('hidden');
    settingsCloseBtn.focus();
  }

  function closeSettings() {
    settingsMask.classList.add('hidden');
  }

  // ---------- 数据存储位置（v0.22.0）：查看 / 更改 / 恢复默认；切换时迁移数据 ----------
  // - 数据目录默认 {AppData}/com.simpletools.desktop，可在设置中选择自定义文件夹
  // - 迁移由 Rust 侧执行（复制 + 逐文件大小校验，原位置文件保留），成功后重新加载应用生效
  async function refreshDataDirInfo() {
    if (!invokeApi) return;
    try {
      dataDirInfo = await invokeApi('data_dir_info');
      dataDirPathEl.textContent = '当前：' + dataDirInfo.current + (dataDirInfo.is_custom ? '（自定义）' : '（默认）');
      dataDirResetBtn.classList.toggle('hidden', !dataDirInfo.is_custom);
    } catch (e) {
      dataDirPathEl.textContent = '当前：读取失败';
    }
  }

  // 迁移到新目录：确认 → 后端迁移 → 成功后重新加载（各面板从新目录读取数据）
  async function migrateDataDir(newDir) {
    if (!invokeApi || !newDir) return;
    if (!dataDirInfo) await refreshDataDirInfo();
    const current = dataDirInfo ? dataDirInfo.current : '';
    if (current && newDir.toLowerCase() === current.toLowerCase()) {
      window.toast('新位置与当前位置相同');
      return;
    }
    const ok = await window.showConfirm(
      '将把数据文件（记事本 / 账号密码 / 历史记录）迁移到：' + newDir + '。原位置文件保留（不删除）。',
      { title: '迁移数据存储位置', okText: '开始迁移' }
    );
    if (!ok) return;
    dataDirChangeBtn.disabled = true;
    dataDirResetBtn.disabled = true;
    try {
      await invokeApi('data_dir_set', { dir: newDir });
      window.toast('数据已迁移，正在重新加载…');
      setTimeout(function () { location.reload(); }, 900);
    } catch (e) {
      window.toast('迁移失败：' + ((e && e.message) || e));
      dataDirChangeBtn.disabled = false;
      dataDirResetBtn.disabled = false;
    }
  }

  dataDirChangeBtn.addEventListener('click', async function () {
    if (!invokeApi || !dialogApi || !dialogApi.open) {
      window.toast('Tauri 接口不可用（请通过应用运行）');
      return;
    }
    let picked = null;
    try {
      picked = await dialogApi.open({ directory: true, multiple: false, title: '选择数据存储文件夹' });
    } catch (e) {
      window.toast('无法打开文件夹选择框');
      return;
    }
    const dir = typeof picked === 'string' ? picked : (picked && picked.path) || '';
    if (!dir) return;
    await migrateDataDir(dir);
  });

  dataDirResetBtn.addEventListener('click', function () {
    if (dataDirInfo && dataDirInfo.default) migrateDataDir(dataDirInfo.default);
  });

  // ---------- 数据存储说明（v0.23.0）：展示各数据文件的当前位置与大小，可打开对应文件夹 ----------
  // - 路径由 storage_info 实时解析，切换数据存储位置后随之变化（不写死）
  // - 「打开」按钮调 open_in_explorer：文件已生成时在资源管理器中定位，否则打开所在目录
  const STORAGE_FILE_META = {
    'notes.json': { label: '记事本', desc: '笔记内容（普通文本 / Markdown），输入自动保存' },
    'accounts.json': { label: '账号密码', desc: '分组与条目（含备注），经 DPAPI 加密存储' },
    'history.json': { label: '历史记录', desc: '格式化 / 对比 / MD5 / 转换记录，各最多 50 条' },
    'notes.backup.json': { label: '记事本备份', desc: '点记事本「备份」按钮生成的数据副本' },
    'settings.json': { label: '应用设置', desc: '记录数据存储位置等配置' },
  };
  const dataDirHelpBtn = document.getElementById('data-dir-help');
  const storageMask = document.getElementById('storage-modal');
  const storageCloseBtn = document.getElementById('storage-close');
  const storageDirTagEl = document.getElementById('storage-dir-tag');
  const storageDirPathEl = document.getElementById('storage-dir-path');
  const storageOpenDirBtn = document.getElementById('storage-open-dir');
  const storageListEl = document.getElementById('storage-list');
  const storageSettingsListEl = document.getElementById('storage-settings-list');

  function fmtFileSize(n) {
    if (!n) return '0 B';
    if (n < 1024) return n + ' B';
    if (n < 1024 * 1024) return (n / 1024).toFixed(1) + ' KB';
    return (n / 1024 / 1024).toFixed(1) + ' MB';
  }

  // 单个数据文件行：文件名 + 用途说明 + 状态（大小 / 未生成）+ 打开按钮
  function renderStorageItem(f) {
    const meta = STORAGE_FILE_META[f.name] || { label: '', desc: '' };
    const li = document.createElement('li');
    li.className = 'storage-item';
    li.title = f.path;

    const text = document.createElement('div');
    text.className = 'storage-item-text';
    const nameRow = document.createElement('div');
    nameRow.className = 'storage-item-name';
    const code = document.createElement('code');
    code.textContent = f.name;
    nameRow.appendChild(code);
    const label = document.createElement('span');
    label.className = 'storage-item-label';
    label.textContent = meta.label;
    nameRow.appendChild(label);
    const desc = document.createElement('div');
    desc.className = 'storage-item-desc';
    desc.textContent = meta.desc;
    text.appendChild(nameRow);
    text.appendChild(desc);

    const status = document.createElement('span');
    status.className = 'storage-item-status';
    status.textContent = f.exists ? fmtFileSize(f.size) : '未生成';

    const openBtn = document.createElement('button');
    openBtn.className = 'btn storage-item-open';
    openBtn.setAttribute('data-file', f.name);
    openBtn.textContent = '打开';

    li.appendChild(text);
    li.appendChild(status);
    li.appendChild(openBtn);
    return li;
  }

  function renderStorageInfo(info) {
    storageDirTagEl.textContent = info.is_custom ? '（自定义）' : '（默认）';
    storageDirPathEl.textContent = info.current;
    storageListEl.textContent = '';
    (info.files || []).forEach(function (f) { storageListEl.appendChild(renderStorageItem(f)); });
    storageSettingsListEl.textContent = '';
    if (info.settings) storageSettingsListEl.appendChild(renderStorageItem(info.settings));
  }

  async function openStorageHelp() {
    storageMask.classList.remove('hidden');
    storageCloseBtn.focus();
    if (!invokeApi) return;
    try {
      renderStorageInfo(await invokeApi('storage_info'));
    } catch (e) {
      storageDirPathEl.textContent = '读取失败：' + ((e && e.message) || e);
    }
  }

  // 打开数据文件所在位置（file 为空时打开数据目录）
  async function openStorageTarget(file) {
    if (!invokeApi) return;
    try {
      await invokeApi('open_in_explorer', { file: file || null });
    } catch (e) {
      window.toast('无法打开：' + ((e && e.message) || e));
    }
  }

  function closeStorageHelp() {
    storageMask.classList.add('hidden');
  }

  dataDirHelpBtn.addEventListener('click', openStorageHelp);
  storageCloseBtn.addEventListener('click', closeStorageHelp);
  storageMask.addEventListener('click', function (e) {
    if (e.target === storageMask) closeStorageHelp();
  });
  storageOpenDirBtn.addEventListener('click', function () { openStorageTarget(''); });
  [storageListEl, storageSettingsListEl].forEach(function (listEl) {
    listEl.addEventListener('click', function (e) {
      const btn = e.target.closest('button[data-file]');
      if (btn) openStorageTarget(btn.getAttribute('data-file'));
    });
  });

  settingsBtn.addEventListener('click', openSettings);
  settingsCloseBtn.addEventListener('click', closeSettings);
  settingsMask.addEventListener('click', function (e) {
    if (e.target === settingsMask) closeSettings();
  });
  // 弹窗内点击不冒泡到 document（避免误触发其他组件的“点击空白关闭”逻辑）
  settingsMask.addEventListener('click', function (e) {
    e.stopPropagation();
  });
  authMask.addEventListener('click', function (e) {
    e.stopPropagation();
  });

  // 开关切换：先回滚视觉状态，校验通过后再应用（开启/关闭都需要校验）
  accLockSwitch.addEventListener('change', async function () {
    const want = accLockSwitch.checked;
    accLockSwitch.checked = !want;
    accLockSwitch.disabled = true;
    try {
      const ok = await requireHelloVerify(want ? '验证以开启查看校验' : '验证以关闭查看校验');
      if (ok) {
        accLockSwitch.checked = want;
        setAccLock(want);
        window.toast(want ? '已开启：查看「账号密码」需 Windows Hello 验证' : '已关闭查看校验');
      }
    } finally {
      accLockSwitch.disabled = false;
    }
  });

  accLockSwitch.checked = accLockEnabled();
})();
