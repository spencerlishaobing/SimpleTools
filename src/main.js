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
    btn.addEventListener('click', () => {
      const target = btn.dataset.panel;
      navItems.forEach((b) => b.classList.toggle('active', b === btn));
      panels.forEach((p) => p.classList.toggle('active', p.id === 'panel-' + target));
    });
  });

  // ---------- 主题切换（浅色 / 深色 / 卡其色，三态循环，持久化） ----------
  const THEME_KEY = 'simpletools-theme';
  const THEME_NEXT = { light: 'dark', dark: 'khaki', khaki: 'light' };
  const THEME_LABEL = { light: '深色模式', dark: '卡其模式', khaki: '浅色模式' };
  const themeToggle = document.getElementById('theme-toggle');
  const themeLabel = document.getElementById('theme-label');

  function currentTheme() {
    const t = document.documentElement.getAttribute('data-theme');
    return t === 'dark' || t === 'khaki' ? t : 'light';
  }

  function updateToggleUI(theme) {
    // 按钮文案/图标始终表示"点击后将切换到的模式"
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
  }

  themeToggle.addEventListener('click', () => {
    applyTheme(THEME_NEXT[currentTheme()]);
  });

  updateToggleUI(currentTheme());
})();
