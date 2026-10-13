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

  // ---------- 全局加载遮罩（v0.47.0：耗时操作显示特色数据脉冲加载框） ----------
  // 不足 250ms 的操作不显示（避免一闪而过的干扰）；已显示时再次调用仅更新文案
  const appLoadingEl = document.getElementById('app-loading');
  const loadingTextEl = document.getElementById('loading-text');
  let loadingShowTimer = null;
  let loadingVisible = false;

  window.showLoading = function (text) {
    if (!appLoadingEl) return;
    if (loadingTextEl) loadingTextEl.textContent = text || '处理中…';
    if (loadingVisible || loadingShowTimer) return;
    loadingShowTimer = setTimeout(function () {
      loadingShowTimer = null;
      loadingVisible = true;
      appLoadingEl.classList.remove('hidden');
    }, 250);
  };

  window.hideLoading = function () {
    if (loadingShowTimer) {
      clearTimeout(loadingShowTimer);
      loadingShowTimer = null;
    }
    if (!loadingVisible) return;
    loadingVisible = false;
    appLoadingEl.classList.add('hidden');
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
      // 含换行的长文案（覆盖 / 合并导入）启用 pre-line 保留分节换行；单行文案不受影响
      msgEl.classList.toggle('is-multiline', message.indexOf('\n') >= 0);
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

  // ---------- 屏蔽 WebView 默认右键菜单 ----------
  // 桌面应用不应出现浏览器默认菜单（刷新 / 另存为 / 打印等）：页面区域统一拦截默认菜单，
  // 输入场景（输入框 / 富文本编辑器）保留默认菜单，便于右键粘贴 / 复制
  document.addEventListener('contextmenu', function (e) {
    const t = e.target;
    if (t && t.closest && t.closest('input, textarea, [contenteditable]')) return;
    e.preventDefault();
  });

  // ---------- 全局文件拖放守卫（v0.33.0） ----------
  // 背景：tauri.conf.json 设 dragDropEnabled=false（wry 原生拖放会吞掉页内 dragover/drop 事件，
  // 页内拖拽排序必须用它换成 WebView2 内建拖放）。此后文件拖到窗口任意位置若无阻止，
  // WebView 会把它当作导航目标直接打开该文件；这里统一阻止「含文件拖拽」的默认行为，
  // 具体落点（MD5 / Markdown 面板）由各自模块的 drop 监听自行处理。
  function hasFiles(e) {
    const t = e.dataTransfer && e.dataTransfer.types;
    return !!t && Array.prototype.indexOf.call(t, 'Files') !== -1;
  }
  document.addEventListener('dragover', function (e) {
    if (hasFiles(e)) e.preventDefault();
  });
  document.addEventListener('drop', function (e) {
    if (hasFiles(e)) e.preventDefault();
  });

  // ---------- 面板切换 ----------
  const navItems = document.querySelectorAll('.nav-item');
  const panels = document.querySelectorAll('.panel');

  function activatePanel(target) {
    navItems.forEach((b) => b.classList.toggle('active', b.dataset.panel === target));
    panels.forEach((p) => p.classList.toggle('active', p.id === 'panel-' + target));
    // 面板由隐藏变为可见后通知（供在隐藏状态下无法测量的模块重算布局，如账号备注高度）
    const panel = document.getElementById('panel-' + target);
    if (panel && panel.classList.contains('active')) panel.dispatchEvent(new CustomEvent('panel-shown'));
  }

  navItems.forEach((btn) => {
    btn.addEventListener('click', async () => {
      const target = btn.dataset.panel;
      markNavSeen(target); // 点击新功能后移除「新」角标（v0.38.0）
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
  // 默认隐藏的功能（v0.42.0：默认仅显示「记事本」与「账号密码」，其余功能可在设置中勾选恢复）
  // 注意：需与 index.html head 内联脚本的 NH_DEFAULT 保持一致
  const NAV_HIDDEN_DEFAULT = ['json', 'diff', 'md5', 'str', 'md', 'capture', 'mock', 'db'];
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
      const raw = localStorage.getItem(NAV_HIDDEN_KEY);
      // 未配置过（首次运行）：默认仅显示核心功能；已配置过：完全按用户选择（空数组 = 全部显示）
      if (raw === null) return new Set(NAV_HIDDEN_DEFAULT);
      const arr = JSON.parse(raw);
      return new Set(Array.isArray(arr) ? arr.filter((k) => typeof k === 'string') : []);
    } catch (e) {
      return new Set(NAV_HIDDEN_DEFAULT);
    }
  })();

  function writeNavHidden() {
    try {
      // 始终写入（含空数组）：空数组 = 全部显示，与「未配置」的默认隐藏语义区分
      localStorage.setItem(NAV_HIDDEN_KEY, JSON.stringify([...navHidden]));
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
  // 引导样式（head 内联生成）已完成首帧隐藏使命，移除后由 nav-hidden class 接管
  const navBootStyle = document.getElementById('nav-hidden-boot');
  if (navBootStyle) navBootStyle.remove();
  // 启动兜底：默认激活的面板被用户配置隐藏时，自动切到第一个可见功能
  ensureActiveNav();

  // ---------- 新功能提示（v0.38.0）：红色「新」角标，点击对应功能后消失（持久记忆） ----------
  const NAV_SEEN_KEY = 'simpletools-nav-seen';
  // 需要提示的新功能（后续版本发布新功能时加入；用户点击后消失，已点击记录持久保存）
  const NEW_FEATURES = ['capture', 'mock', 'db'];
  const navSeen = (function () {
    try {
      const arr = JSON.parse(localStorage.getItem(NAV_SEEN_KEY) || '[]');
      return new Set(Array.isArray(arr) ? arr.filter((k) => typeof k === 'string') : []);
    } catch (e) {
      return new Set();
    }
  })();

  function markNavSeen(key) {
    if (NEW_FEATURES.indexOf(key) < 0 || navSeen.has(key)) return;
    navSeen.add(key);
    try { localStorage.setItem(NAV_SEEN_KEY, JSON.stringify([...navSeen])); } catch (e) { /* ignore */ }
    navItems.forEach((btn) => {
      if (btn.dataset.panel === key) {
        const badge = btn.querySelector('.nav-new-badge');
        if (badge) badge.remove();
      }
    });
  }

  // 初始化：未点击过的新功能在侧边栏显示红色「新」角标
  navItems.forEach((btn) => {
    if (NEW_FEATURES.indexOf(btn.dataset.panel) >= 0 && !navSeen.has(btn.dataset.panel)) {
      const badge = document.createElement('span');
      badge.className = 'nav-new-badge';
      badge.textContent = '新';
      btn.appendChild(badge);
    }
  });

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

  // 窗口（标题栏左上角 / 任务栏）小图标随主题切换：与侧边栏品牌图标同款（v0.29.0）
  // light / dark / mix → 蓝紫渐变；khaki → 卡其金渐变（Rust 端按 theme 选择内置图标）
  function syncWindowIcon(theme) {
    if (!invokeApi) return;
    try {
      const p = invokeApi('set_window_icon', { theme });
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
    syncWindowIcon(theme);
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
  syncWindowIcon(currentTheme());

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

  // 设置弹窗（v0.31.0：横版左右布局 — 左侧分类导航切换右侧内容）
  const settingsNav = document.getElementById('settings-nav');
  const settingsPanes = document.querySelectorAll('#settings-modal .settings-pane');

  function setSettingsTab(tab) {
    settingsNav.querySelectorAll('.settings-nav-item').forEach((b) => {
      const on = b.dataset.settingsTab === tab;
      b.classList.toggle('is-active', on);
      b.setAttribute('aria-selected', on ? 'true' : 'false');
    });
    settingsPanes.forEach((p) => {
      p.classList.toggle('is-active', p.dataset.settingsPane === tab);
    });
  }

  settingsNav.addEventListener('click', (e) => {
    const btn = e.target.closest('.settings-nav-item');
    if (btn) setSettingsTab(btn.dataset.settingsTab);
  });

  function openSettings() {
    accLockSwitch.checked = accLockEnabled();
    refreshDataDirInfo();
    setSettingsTab('display'); // 每次打开回到首个分类（不记忆上次停留位置）
    settingsMask.classList.remove('hidden');
    settingsCloseBtn.focus();
  }

  function closeSettings() {
    closeDataioMenu();
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
    window.showLoading('正在迁移数据…');
    try {
      await invokeApi('data_dir_set', { dir: newDir });
      // 成功：保持遮罩到重载（切换文案，避免中间空档闪动）
      window.showLoading('迁移完成，正在重新加载…');
      setTimeout(function () { location.reload(); }, 900);
    } catch (e) {
      window.hideLoading();
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
    'notes.json': { label: '记事本', desc: '笔记内容（普通笔记 / Markdown），输入自动保存' },
    'accounts.json': { label: '账号密码', desc: '分组与条目（含备注），经 DPAPI 加密存储' },
    'history.json': { label: '历史记录', desc: '格式化 / 对比 / MD5 / 转换记录，各最多 50 条' },
    'notes.backup.json': { label: '记事本备份', desc: '点记事本「备份」按钮生成的数据副本' },
    'images': { label: '富文本图片', desc: '任务笔记与普通笔记富文本插入的本地图片（相对路径引用，随数据迁移与备份）' },
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
    // 图片目录（v0.33.0）：补尾斜杠与数据文件区分
    code.textContent = f.name === 'images' ? 'images/' : f.name;
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

  // ---------- 数据导入导出（v0.30.0）：一键备份 / 恢复全部用户数据与应用配置（ZIP / 文件夹） ----------
  // - 导出：ZIP 压缩包（保存对话框）或文件夹（在其中自动创建带时间戳的子文件夹）
  // - 导入：从 ZIP / 文件夹恢复；确认后由后端先把将被覆盖的数据自动备份到
  //   「数据目录 / import-backup-时间戳 /」，再整文件覆盖；成功后重新加载应用
  // - 账号密码密文与当前 Windows 用户绑定，跨用户导入只能恢复其余数据（确认弹窗中说明）
  const dataExportBtn = document.getElementById('data-export-btn');
  const dataImportBtn = document.getElementById('data-import-btn');

  // 时间戳（与记事本导出命名一致）：20261011-153045
  function stampNow() {
    const d = new Date();
    const pad = (x) => String(x).padStart(2, '0');
    return d.getFullYear() + pad(d.getMonth() + 1) + pad(d.getDate()) + '-' +
      pad(d.getHours()) + pad(d.getMinutes()) + pad(d.getSeconds());
  }

  // 弹窗内选择菜单（复用导出菜单样式；dataio-menu 层级盖过设置弹窗）
  // items 支持可选 desc（第二行小字说明，如导入方式选择）；onClose 在「点外部关闭」时回调，
  // 选择菜单项本身不触发（供 Promise 化选择流程区分「选中」与「取消」）
  let dataioMenuEl = null;
  let dataioMenuDocHandler = null;
  let dataioMenuOnClose = null;
  let dataioMenuPicking = false;

  function closeDataioMenu() {
    const onClose = dataioMenuPicking ? null : dataioMenuOnClose;
    dataioMenuOnClose = null;
    if (dataioMenuEl) {
      dataioMenuEl.remove();
      dataioMenuEl = null;
    }
    if (dataioMenuDocHandler) {
      document.removeEventListener('click', dataioMenuDocHandler, true);
      dataioMenuDocHandler = null;
    }
    if (onClose) onClose();
  }

  function openDataioMenu(anchor, items, onClose) {
    closeDataioMenu();
    dataioMenuOnClose = onClose || null;
    const menu = document.createElement('div');
    menu.className = 'export-menu dataio-menu';
    menu.innerHTML = items.map((it) =>
      '<button type="button" data-opt="' + it.key + '">' + it.icon +
      (it.desc
        ? '<span class="dataio-text"><span class="dataio-label">' + it.label + '</span><span class="dataio-desc">' + it.desc + '</span></span>'
        : '<span>' + it.label + '</span>') +
      '</button>').join('');
    document.body.appendChild(menu);
    const rect = anchor.getBoundingClientRect();
    let left = rect.left;
    if (left + menu.offsetWidth > window.innerWidth - 8) left = window.innerWidth - menu.offsetWidth - 8;
    if (left < 8) left = 8;
    let top = rect.bottom + 6;
    if (top + menu.offsetHeight > window.innerHeight - 8) top = rect.top - menu.offsetHeight - 6;
    menu.style.left = left + 'px';
    menu.style.top = top + 'px';
    dataioMenuEl = menu;
    menu.querySelectorAll('button[data-opt]').forEach((b) => {
      b.addEventListener('click', (e) => {
        e.stopPropagation();
        const key = b.getAttribute('data-opt');
        const item = items.find((it) => it.key === key);
        dataioMenuPicking = true;
        closeDataioMenu();
        dataioMenuPicking = false;
        if (item) item.run();
      });
    });
    setTimeout(() => {
      dataioMenuDocHandler = (ev) => {
        if (dataioMenuEl && !dataioMenuEl.contains(ev.target)) closeDataioMenu();
      };
      // 捕获阶段监听（v0.31.1）：设置弹窗遮罩会 stopPropagation 拦截冒泡（在弹窗内点击
      // 空白处时 click 到不了 document），捕获阶段先于遮罩处理执行，确保菜单可靠关闭
      document.addEventListener('click', dataioMenuDocHandler, true);
    }, 0);
  }

  const DATAIO_ICON_ARCHIVE = '<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" aria-hidden="true">' +
    '<rect x="2" y="3" width="20" height="5" rx="1"/><path d="M4 8v11a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8"/><path d="M10 12h4"/></svg>';
  const DATAIO_ICON_FOLDER = '<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" aria-hidden="true">' +
    '<path d="M22 19a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h5l2 3h9a2 2 0 0 1 2 2z"/></svg>';
  const DATAIO_ICON_MERGE = '<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" aria-hidden="true">' +
    '<path d="M12 3v7"/><path d="M8 7l4 4 4-4"/><path d="M4 13v5a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2v-5"/></svg>';

  // ---------- 数据合并（v0.32.0）：导入「合并」模式的内存合并逻辑（纯函数，供探针直接断言） ----------
  // 合并前为全部新增实体重新生成 UUID（笔记 / 任务 / 分组 / 条目 / 历史记录），
  // 避免与当前数据中的 ID 冲突；现有实体保持原 ID 不变
  const MERGE_UUID_RE = /^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$/i;
  const HIST_KINDS = ['json', 'diff', 'md5', 'str'];
  const HIST_MAX = 50;

  function mergeUuid() {
    if (window.crypto && crypto.randomUUID) return crypto.randomUUID();
    return 'id-' + Date.now().toString(16) + '-' + Math.random().toString(16).slice(2);
  }

  function mergeClone(v) {
    return JSON.parse(JSON.stringify(v));
  }

  // 笔记合并：重名不覆盖，自动改名为「名称-N」后新建（原名已带 -N 后缀时从 N+1 继续递增查找）
  // 兼容旧结构：非数组输入按空处理，非对象项跳过；现有项缺 id 时补 UUID（已有 ID 保持不变）
  function mergeNotes(existing, incoming) {
    const result = (Array.isArray(existing) ? existing : [])
      .filter((n) => n && typeof n === 'object').map(mergeClone);
    for (const note of result) {
      if (!note.id) note.id = mergeUuid();
      if (Array.isArray(note.tasks)) {
        for (const t of note.tasks) {
          if (t && typeof t === 'object' && !t.id) t.id = mergeUuid();
        }
      }
    }
    const titles = new Set(result.map((n) => String(n.title == null ? '' : n.title)));
    for (const src of Array.isArray(incoming) ? incoming : []) {
      if (!src || typeof src !== 'object') continue;
      const note = mergeClone(src);
      note.id = mergeUuid();
      if (Array.isArray(note.tasks)) {
        note.tasks.forEach((t) => { if (t && typeof t === 'object') t.id = mergeUuid(); });
      }
      const raw = String(note.title == null ? '' : note.title);
      let title = raw;
      if (titles.has(title)) {
        const m = /^(.*?)-(\d+)$/.exec(raw);
        const base = m ? m[1] : raw;
        let n = m ? parseInt(m[2], 10) + 1 : 1;
        while (titles.has(base + '-' + n)) n += 1;
        title = base + '-' + n;
      }
      note.title = title;
      titles.add(title);
      result.push(note);
    }
    return result;
  }

  // 分组合并：同名分组归一（只保留一个）；条目按账号去重（账号非空且组内已存在则跳过，空账号直接加入）
  // 兼容旧结构：非数组输入按空处理，非对象项跳过；现有组 / 条目缺 id 时补 UUID，缺 items 时补空数组
  function mergeAccounts(existing, incoming) {
    const result = (Array.isArray(existing) ? existing : [])
      .filter((g) => g && typeof g === 'object').map(mergeClone);
    for (const g of result) {
      if (!g.id) g.id = mergeUuid();
      if (!Array.isArray(g.items)) g.items = [];
      for (const it of g.items) {
        if (it && typeof it === 'object' && !it.id) it.id = mergeUuid();
      }
    }
    for (const src of Array.isArray(incoming) ? incoming : []) {
      if (!src || typeof src !== 'object') continue;
      const group = mergeClone(src);
      group.id = mergeUuid();
      const name = String(group.name == null ? '' : group.name);
      const srcItems = Array.isArray(group.items) ? group.items : [];
      let target = result.find((g) => String(g.name == null ? '' : g.name) === name);
      if (!target) {
        target = { id: group.id, name: group.name, items: [] };
        result.push(target);
      }
      if (!Array.isArray(target.items)) target.items = [];
      for (const srcItem of srcItems) {
        if (!srcItem || typeof srcItem !== 'object') continue;
        const item = mergeClone(srcItem);
        item.id = mergeUuid();
        const account = String(item.account == null ? '' : item.account);
        const dup = account !== '' &&
          target.items.some((it) => it && String(it.account == null ? '' : it.account) === account);
        if (!dup) target.items.push(item);
      }
    }
    return result;
  }

  // 历史记录去重键（按内容比较，与 history.js 的各类型字段对应）
  function histKey(kind, r) {
    if (kind === 'json') return 'j\u0000' + (r.input || '') + '\u0000' + (r.output || '');
    if (kind === 'diff') return 'd\u0000' + (r.left || '') + '\u0000' + (r.right || '');
    if (kind === 'md5') return 'm\u0000' + (r.kind || '') + '\u0000' + (r.input || '') + '\u0000' + (r.hash || '');
    return 's\u0000' + (r.input || '');
  }

  // 历史合并：四类各自按内容去重 → 时间倒序 → 每类最多保留 50 条（与 history.js MAX_ITEMS 一致）；
  // 兼容旧结构：非数组按空处理，非对象记录跳过；现有记录缺 id 时补 UUID，新增记录重排 UUID
  function mergeHistory(existing, incoming) {
    const out = {};
    for (const kind of HIST_KINDS) {
      const seen = new Set();
      const list = [];
      const cur = Array.isArray(existing && existing[kind]) ? existing[kind] : [];
      const inc = Array.isArray(incoming && incoming[kind]) ? incoming[kind] : [];
      for (const r of cur) {
        if (!r || typeof r !== 'object') continue;
        const key = histKey(kind, r);
        if (seen.has(key)) continue;
        seen.add(key);
        const rec = mergeClone(r);
        if (!rec.id) rec.id = mergeUuid();
        list.push(rec);
      }
      for (const r of inc) {
        if (!r || typeof r !== 'object') continue;
        const key = histKey(kind, r);
        if (seen.has(key)) continue;
        seen.add(key);
        const rec = mergeClone(r);
        rec.id = mergeUuid();
        list.push(rec);
      }
      list.sort((a, b) => (b.time || 0) - (a.time || 0));
      out[kind] = list.slice(0, HIST_MAX);
    }
    return out;
  }

  window.__dataMerge = {
    mergeNotes: mergeNotes,
    mergeAccounts: mergeAccounts,
    mergeHistory: mergeHistory,
    uuidRe: MERGE_UUID_RE,
  };

  // 导出：zip=保存对话框选择备份文件位置；dir=选择目标文件夹后在其中创建时间戳子文件夹
  async function runDataExport(kind) {
    if (!invokeApi || !dialogApi || !dialogApi.open) {
      window.toast('Tauri 接口不可用（请通过应用运行）');
      return;
    }
    const stamp = stampNow();
    let dest = '';
    try {
      if (kind === 'zip') {
        if (!dialogApi.save) {
          window.toast('当前环境不支持保存对话框');
          return;
        }
        const picked = await dialogApi.save({
          defaultPath: 'SimpleTools_backup_' + stamp + '.zip',
          filters: [{ name: 'ZIP 压缩包', extensions: ['zip'] }],
          title: '导出数据（ZIP 压缩包）',
        });
        dest = typeof picked === 'string' ? picked : (picked && picked.path) || '';
        if (dest && !/\.zip$/i.test(dest)) dest += '.zip';
      } else {
        const picked = await dialogApi.open({ directory: true, multiple: false, title: '选择导出位置' });
        const dir = typeof picked === 'string' ? picked : (picked && picked.path) || '';
        if (dir) dest = dir + (/[\\/]$/.test(dir) ? '' : '\\') + 'SimpleTools_backup_' + stamp;
      }
    } catch (e) {
      window.toast('无法打开文件选择框');
      return;
    }
    if (!dest) return;
    window.showLoading('正在导出数据…');
    try {
      const res = await invokeApi('data_export', { dest, format: kind });
      const n = (res && res.files && res.files.length) || 0;
      const ic = (res && res.image_count) || 0;
      window.toast('已导出 ' + n + ' 个数据文件' + (ic ? '、' + ic + ' 张图片' : ''));
    } catch (e) {
      window.toast('导出失败：' + ((e && e.message) || e));
    } finally {
      window.hideLoading();
    }
  }

  // 导入：zip=选备份文件；dir=选备份文件夹；选完文件后再选导入方式（覆盖 / 合并）
  async function runDataImport(kind) {
    if (!invokeApi || !dialogApi || !dialogApi.open) {
      window.toast('Tauri 接口不可用（请通过应用运行）');
      return;
    }
    let source = '';
    try {
      if (kind === 'zip') {
        const picked = await dialogApi.open({
          multiple: false,
          title: '选择要导入的备份文件',
          filters: [{ name: 'ZIP 压缩包', extensions: ['zip'] }],
        });
        source = typeof picked === 'string' ? picked : (picked && picked.path) || '';
      } else {
        const picked = await dialogApi.open({ directory: true, multiple: false, title: '选择要导入的备份文件夹' });
        source = typeof picked === 'string' ? picked : (picked && picked.path) || '';
      }
    } catch (e) {
      window.toast('无法打开文件选择框');
      return;
    }
    if (!source) return;
    const mode = await chooseImportMode();
    if (mode === 'overwrite') await runOverwriteImport(source);
    else if (mode === 'merge') await runMergeImport(source);
  }

  // 选完备份文件后弹出「覆盖 / 合并」方式菜单（点外部关闭视为取消）
  function chooseImportMode() {
    return new Promise((resolve) => {
      openDataioMenu(dataImportBtn, [
        {
          key: 'overwrite', label: '覆盖导入', icon: DATAIO_ICON_ARCHIVE,
          desc: '用备份数据替换当前数据（与旧版一致）',
          run: () => resolve('overwrite'),
        },
        {
          key: 'merge', label: '合并导入', icon: DATAIO_ICON_MERGE,
          desc: '保留当前数据再合并：相同分组归一、笔记重名自动改名、重复记录去重',
          run: () => resolve('merge'),
        },
      ], () => resolve(null));
    });
  }

  // 读取当前数据目录（确认弹窗展示备份完整路径用；失败时回退通用描述，不阻断导入流程）
  async function resolveDataDirForMsg() {
    try {
      const info = await invokeApi('data_dir_info');
      if (info && info.current) return info.current;
    } catch (e) { /* 读取失败：用通用描述 */ }
    return '数据目录';
  }

  // 覆盖导入：确认后由后端导入（自动备份 → 整文件覆盖 → 重载）
  // 确认文案三要素：说明覆盖规则；备份提示（完整路径 = 数据目录 + 本次时间戳）；如何恢复旧数据；加密限制风险
  async function runOverwriteImport(source) {
    const backupName = 'import-backup-' + stampNow();
    const backupPath = (await resolveDataDirForMsg()) + '\\' + backupName;
    const ok = await window.showConfirm(
      '将用所选备份完整替换当前数据（同名覆盖，备份中未包含的文件不受影响）。\n\n' +
      '备份提示：导入前会自动把当前数据备份到：\n' + backupPath + '\n\n' +
      '如何恢复旧数据：若导入结果不理想，点「恢复数据」（设置 → 数据恢复），选择本次备份即可一键还原到导入前的状态。\n\n' +
      '注意：账号密码数据经系统加密，仅能在导出时的同一 Windows 用户下恢复。',
      { title: '覆盖导入', okText: '开始导入' }
    );
    if (!ok) return;
    dataImportBtn.disabled = true;
    dataExportBtn.disabled = true;
    window.showLoading('正在导入数据…');
    try {
      const res = await invokeApi('data_import', { source, backupName });
      let msg = '已导入 ' + ((res && res.imported && res.imported.length) || 0) + ' 个文件';
      const ic = (res && res.image_count) || 0;
      if (ic) msg += '、' + ic + ' 张图片';
      if (res && res.fallback) msg += '（存储位置不可用，已回退默认目录）';
      window.showLoading('导入完成，正在重新加载…');
      window.toast(msg + '，正在重新加载…');
      setTimeout(function () { location.reload(); }, 1000);
    } catch (e) {
      window.hideLoading();
      window.toast('导入失败：' + ((e && e.message) || e));
      dataImportBtn.disabled = false;
      dataExportBtn.disabled = false;
    }
  }

  // 合并导入：读取备份明文 + 当前数据 → 内存合并（含统计）→ 确认后由后端备份并整体落盘
  async function runMergeImport(source) {
    let prep;
    window.showLoading('正在读取备份…');
    try {
      prep = await invokeApi('data_import_prepare', { source });
    } catch (e) {
      window.toast('读取备份失败：' + ((e && e.message) || e));
      return;
    } finally {
      window.hideLoading();
    }
    const loadSafe = async (cmd) => {
      try {
        return await invokeApi(cmd);
      } catch (e) {
        return null;
      }
    };
    const warnings = ((prep && prep.warnings) || []).slice();
    const curNotes = prep.notes ? await loadSafe('notes_load') : null;
    const curAccounts = prep.accounts ? await loadSafe('accounts_load') : null;
    const curHistory = prep.history ? await loadSafe('history_load') : null;
    // 当前数据读取失败时跳过对应文件的合并（宁可少写，不覆盖丢失）
    if (prep.notes && curNotes === null) warnings.push('当前笔记数据读取失败，已跳过笔记合并');
    if (prep.accounts && curAccounts === null) warnings.push('当前账号数据读取失败，已跳过账号合并');
    if (prep.history && curHistory === null) warnings.push('当前历史记录读取失败，已跳过历史合并');

    const merged = {
      notes: prep.notes && curNotes !== null ? mergeNotes(curNotes, prep.notes) : null,
      accounts: prep.accounts && curAccounts !== null ? mergeAccounts(curAccounts, prep.accounts) : null,
      history: prep.history && curHistory !== null ? mergeHistory(curHistory, prep.history) : null,
    };
    if (merged.notes === null && merged.accounts === null && merged.history === null) {
      window.toast('备份中没有可合并的数据');
      return;
    }

    // 统计（供确认弹窗展示合并影响：新增条数 / 自动改名数）
    const parts = [];
    let totalAdded = 0;
    if (merged.notes) {
      const added = merged.notes.length - curNotes.length;
      totalAdded += added;
      let renamed = 0;
      for (let i = 0; i < prep.notes.length; i++) {
        const srcTitle = String((prep.notes[i] || {}).title == null ? '' : prep.notes[i].title);
        if (merged.notes[curNotes.length + i].title !== srcTitle) renamed += 1;
      }
      parts.push('笔记新增 ' + added + ' 条' + (renamed ? '（' + renamed + ' 条重名自动改名）' : ''));
    }
    if (merged.accounts) {
      const countItems = (gs) => (gs || []).reduce((s, g) => s + (((g.items || []).length)), 0);
      const addedItems = countItems(merged.accounts) - countItems(curAccounts);
      const addedGroups = merged.accounts.length - curAccounts.length;
      totalAdded += addedItems;
      parts.push('账号新增 ' + addedGroups + ' 个分组、' + addedItems + ' 条记录');
    }
    if (merged.history) {
      const countHist = (h) => HIST_KINDS.reduce((s, k) => s + (((h && h[k]) || []).length), 0);
      const addedHist = countHist(merged.history) - countHist(curHistory);
      totalAdded += addedHist;
      parts.push('历史记录新增 ' + addedHist + ' 条');
    }
    if (totalAdded <= 0) {
      window.toast('没有需要合并的新数据，已跳过');
      return;
    }
    // 确认文案：合并说明（规则）→ 本次合并统计 → 备份提示（完整路径 + 恢复指引）→ 风险提示
    const backupName = 'import-backup-' + stampNow();
    const backupPath = (await resolveDataDirForMsg()) + '\\' + backupName;
    let msg = '合并说明：保留当前数据，把备份内容合并进来 —— 相同分组自动归一、重复记录自动去重、笔记重名自动改名（如「名称-1」）。\n\n' +
      '本次合并：' + parts.join('；') + '。\n\n' +
      '备份提示：合并前会自动把当前数据备份到：\n' + backupPath + '\n若合并结果不理想，点「恢复数据」（设置 → 数据恢复），选择本次备份即可一键还原到合并前的状态。\n\n' +
      '风险提示：合并后新旧数据合为一体、无法自动拆分；账号密码数据经系统加密，仅能在导出时的同一 Windows 用户下恢复。';
    if (warnings.length) msg += '\n\n注意：' + warnings.join('；') + '。';
    const ok = await window.showConfirm(msg, { title: '合并导入', okText: '开始合并' });
    if (!ok) return;
    dataImportBtn.disabled = true;
    dataExportBtn.disabled = true;
    window.showLoading('正在合并数据…');
    try {
      const res = await invokeApi('data_merge_write', {
        notes: merged.notes,
        accounts: merged.accounts,
        history: merged.history,
        backupName: backupName,
      });
      let out = '已合并 ' + ((res && res.written && res.written.length) || 0) + ' 个数据文件';
      if (warnings.length) out += '（' + warnings.join('；') + '）';
      window.showLoading('合并完成，正在重新加载…');
      window.toast(out + '，正在重新加载…');
      setTimeout(function () { location.reload(); }, 1000);
    } catch (e) {
      window.hideLoading();
      window.toast('合并失败：' + ((e && e.message) || e));
      dataImportBtn.disabled = false;
      dataExportBtn.disabled = false;
    }
  }

  dataExportBtn.addEventListener('click', function (e) {
    e.stopPropagation();
    openDataioMenu(dataExportBtn, [
      { key: 'zip', label: '导出为 ZIP 压缩包', icon: DATAIO_ICON_ARCHIVE, run: function () { runDataExport('zip'); } },
      { key: 'dir', label: '导出到文件夹', icon: DATAIO_ICON_FOLDER, run: function () { runDataExport('dir'); } },
    ]);
  });
  dataImportBtn.addEventListener('click', function (e) {
    e.stopPropagation();
    openDataioMenu(dataImportBtn, [
      { key: 'zip', label: '从 ZIP 压缩包导入', icon: DATAIO_ICON_ARCHIVE, run: function () { runDataImport('zip'); } },
      { key: 'dir', label: '从文件夹导入', icon: DATAIO_ICON_FOLDER, run: function () { runDataImport('dir'); } },
    ]);
  });

  // ---------- 数据恢复（v0.32.0）：从自动备份列表选择 → 覆盖恢复 ----------
  // 列表 = 数据目录下的 import-backup-* 文件夹（导入 / 合并前自动生成）；
  // 恢复直接覆盖当前数据，不再生成新备份（恢复本身即回退操作）
  const dataRestoreBtn = document.getElementById('data-restore-btn');
  const restoreModal = document.getElementById('restore-modal');
  const restoreListEl = document.getElementById('restore-list');
  const restoreEmptyEl = document.getElementById('restore-empty');
  const restoreCloseBtn = document.getElementById('restore-close');

  // import-backup-20261011-153045 → 2026-10-11 15:30:45（名称不合规时原样展示）
  function formatBackupTime(name) {
    const m = /^import-backup-(\d{8})-(\d{6})$/.exec(name);
    if (!m) return name;
    const d = m[1];
    const t = m[2];
    return d.slice(0, 4) + '-' + d.slice(4, 6) + '-' + d.slice(6, 8) + ' ' +
      t.slice(0, 2) + ':' + t.slice(2, 4) + ':' + t.slice(4, 6);
  }

  function formatSize(bytes) {
    if (bytes >= 1024 * 1024) return (bytes / 1024 / 1024).toFixed(1) + ' MB';
    if (bytes >= 1024) return (bytes / 1024).toFixed(1) + ' KB';
    return bytes + ' B';
  }

  async function openRestoreModal() {
    if (!invokeApi) {
      window.toast('Tauri 接口不可用（请通过应用运行）');
      return;
    }
    restoreModal.classList.remove('hidden');
    restoreListEl.innerHTML = '<li class="restore-loading">读取中…</li>';
    restoreEmptyEl.classList.add('hidden');
    let list = [];
    try {
      list = (await invokeApi('data_backup_list')) || [];
    } catch (e) {
      window.toast('读取备份列表失败：' + ((e && e.message) || e));
    }
    renderRestoreList(list);
  }

  function renderRestoreList(list) {
    restoreListEl.innerHTML = '';
    if (!list.length) {
      restoreEmptyEl.classList.remove('hidden');
      return;
    }
    restoreEmptyEl.classList.add('hidden');
    for (const b of list) {
      const li = document.createElement('li');
      li.className = 'restore-item';
      const files = (b.files || []).length;
      const ic = b.image_count || 0;
      li.innerHTML =
        '<div class="restore-item-text">' +
        '<div class="restore-item-time">' + formatBackupTime(b.name) + '</div>' +
        '<div class="restore-item-meta">' + b.name + ' · ' + files + ' 个文件' +
        (ic ? '、' + ic + ' 张图片' : '') + ' · ' + formatSize(b.size || 0) + '</div>' +
        '</div>' +
        '<button class="btn restore-run">恢复</button>';
      li.querySelector('.restore-run').addEventListener('click', () => runRestore(b.name));
      restoreListEl.appendChild(li);
    }
  }

  async function runRestore(name) {
    const ok = await window.showConfirm(
      '将用备份「' + formatBackupTime(name) + '」覆盖当前数据（笔记 / 账号密码 / 历史记录 / 记事本备份 / 富文本图片，备份中若包含应用设置则一并还原）。恢复操作不会再生成备份，当前数据将被直接替换。',
      { title: '恢复数据', okText: '覆盖恢复' }
    );
    if (!ok) return;
    dataRestoreBtn.disabled = true;
    dataImportBtn.disabled = true;
    dataExportBtn.disabled = true;
    window.showLoading('正在恢复数据…');
    try {
      const res = await invokeApi('data_restore', { name });
      const n = (res && res.restored && res.restored.length) || 0;
      const ic = (res && res.image_count) || 0;
      window.showLoading('恢复完成，正在重新加载…');
      window.toast('已恢复 ' + n + ' 个数据文件' + (ic ? '、' + ic + ' 张图片' : '') + '，正在重新加载…');
      setTimeout(function () { location.reload(); }, 1000);
    } catch (e) {
      window.hideLoading();
      window.toast('恢复失败：' + ((e && e.message) || e));
      dataRestoreBtn.disabled = false;
      dataImportBtn.disabled = false;
      dataExportBtn.disabled = false;
    }
  }

  dataRestoreBtn.addEventListener('click', function (e) {
    e.stopPropagation();
    openRestoreModal();
  });
  restoreCloseBtn.addEventListener('click', function () {
    restoreModal.classList.add('hidden');
  });
  restoreModal.addEventListener('click', function (e) {
    e.stopPropagation();
    if (e.target === restoreModal) restoreModal.classList.add('hidden');
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

  // ---------- 启动初始化动画收尾（v0.47.0）----------
  // 主界面已在遮罩下完成渲染（全程无闪动）；最短展示 800ms 保证动画完整，随后淡出移除
  (function finishBootSplash() {
    const splash = document.getElementById('boot-splash');
    if (!splash) return;
    const started = performance.now();
    const textEl = document.getElementById('boot-text');
    const steps = ['正在初始化界面…', '加载本地数据…', '准备就绪'];
    let si = 0;
    const textTimer = setInterval(function () {
      si = Math.min(si + 1, steps.length - 1);
      if (textEl) textEl.textContent = steps[si];
    }, 260);
    const finish = function () {
      clearInterval(textTimer);
      const wait = Math.max(0, 800 - (performance.now() - started));
      setTimeout(function () {
        splash.classList.add('is-done');
        setTimeout(function () { splash.remove(); }, 400);
      }, wait);
    };
    if (document.readyState === 'complete') finish();
    else window.addEventListener('load', finish);
  })();
})();
