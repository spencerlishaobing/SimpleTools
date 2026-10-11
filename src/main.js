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
        document.removeEventListener('keydown', onKey);
        resolve(result);
      }
      function onOk() { cleanup(true); }
      function onCancel() { cleanup(false); }
      function onMask(e) { if (e.target === mask) cleanup(false); }
      function onKey(e) { if (e.key === 'Escape') cleanup(false); }

      okBtn.addEventListener('click', onOk);
      cancelBtn.addEventListener('click', onCancel);
      mask.addEventListener('click', onMask);
      document.addEventListener('keydown', onKey);
    });
  };

  // 弹窗内的点击不冒泡到 document（避免误触发其他组件的“点击空白关闭”逻辑）
  document.getElementById('confirm-modal').addEventListener('click', function (e) {
    e.stopPropagation();
  });

  // ---------- 面板切换 ----------
  const navItems = document.querySelectorAll('.nav-item');
  const panels = document.querySelectorAll('.panel');

  navItems.forEach((btn) => {
    btn.addEventListener('click', async () => {
      const target = btn.dataset.panel;
      // 「账号密码」安全锁：开启后需先通过 Windows Hello 验证
      if (target === 'accounts' && accLockEnabled()) {
        const ok = await requireHelloVerify('验证以查看「账号密码」');
        if (!ok) return;
      }
      navItems.forEach((b) => b.classList.toggle('active', b === btn));
      panels.forEach((p) => p.classList.toggle('active', p.id === 'panel-' + target));
    });
  });

  // ---------- 主题切换（浅色 / 深色 / 卡其色：点按钮弹出菜单直接选择，持久化） ----------
  const THEME_KEY = 'simpletools-theme';
  const THEME_ORDER = ['light', 'dark', 'khaki'];
  const THEME_LABEL = { light: '浅色模式', dark: '深色模式', khaki: '卡其模式' };
  const themeToggle = document.getElementById('theme-toggle');
  const themeLabel = document.getElementById('theme-label');
  const invokeApi = (window.__TAURI__ && window.__TAURI__.core && window.__TAURI__.core.invoke) || null;

  // 各主题的系统标题栏配色（背景 / 标题文字 / 下边框，与主题变量一致）
  const TITLEBAR_COLORS = {
    light: { bg: '#f6f7f9', text: '#1f2937', border: '#e2e8f0' },
    dark: { bg: '#0f172a', text: '#e2e8f0', border: '#334155' },
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
    return t === 'dark' || t === 'khaki' ? t : 'light';
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

  // 安全提示弹窗（Windows Hello 不可用时说明原因；点「知道了」/ 遮罩 / Esc / Enter 关闭）
  function showAuthNotice(tip) {
    return new Promise(function (resolve) {
      authTipEl.textContent = tip;
      authMask.classList.remove('hidden');

      function cleanup() {
        authMask.classList.add('hidden');
        authOkBtn.removeEventListener('click', cleanup);
        authMask.removeEventListener('click', onMask);
        document.removeEventListener('keydown', onKey);
        resolve();
      }
      function onMask(e) { if (e.target === authMask) cleanup(); }
      function onKey(e) {
        if (e.key === 'Enter' || e.key === 'Escape') { e.preventDefault(); cleanup(); }
      }

      authOkBtn.addEventListener('click', cleanup);
      authMask.addEventListener('click', onMask);
      document.addEventListener('keydown', onKey);
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
    settingsMask.classList.remove('hidden');
    settingsCloseBtn.focus();
  }

  function closeSettings() {
    settingsMask.classList.add('hidden');
  }

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
  document.addEventListener('keydown', function (e) {
    // 校验弹窗打开时，Esc 只关闭校验弹窗（由校验弹窗自身的监听处理）
    if (e.key === 'Escape' && !settingsMask.classList.contains('hidden') && authMask.classList.contains('hidden')) {
      closeSettings();
    }
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
