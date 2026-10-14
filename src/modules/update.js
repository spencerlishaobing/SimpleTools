/* ===== 版本更新模块（v0.43.0：检测 GitHub 最新版本并一键更新） =====
   启动后延迟自动检查（静默，发现新版本时在版本号旁显示红点）；
   点击版本号手动检查：有更新弹出说明弹窗 → 「立即更新」→ 下载（进度条）→
   启动安装程序（静默安装 + 自动重启应用），全程无需手动操作。 */
(function () {
  'use strict';

  const invoke = (window.__TAURI__ && window.__TAURI__.core && window.__TAURI__.core.invoke) || null;
  const listenFn = (window.__TAURI__ && window.__TAURI__.event && window.__TAURI__.event.listen) || null;

  // ---------- DOM ----------
  const versionBtn = document.getElementById('version-btn');
  const versionText = document.getElementById('version-text');
  const updateDot = document.getElementById('version-update-dot');
  const mask = document.getElementById('update-modal');
  const latestEl = document.getElementById('update-latest');
  const currentEl = document.getElementById('update-current');
  const notesEl = document.getElementById('update-notes');
  const progressWrap = document.getElementById('update-progress');
  const progressFill = document.getElementById('update-progress-fill');
  const progressText = document.getElementById('update-progress-text');
  const laterBtn = document.getElementById('update-later');
  const nowBtn = document.getElementById('update-now');

  /** 初始版本号文本（检查失败时恢复） */
  const versionBase = versionText.textContent;
  /** 启动后自动检查的延迟（毫秒） */
  const AUTO_CHECK_DELAY = 4000;

  const state = {
    info: null,   // UpdateInfo（最近一次检查结果）
    busy: false,  // 更新进行中（下载 / 安装阶段，禁止关闭弹窗与重复触发）
  };

  function fmtMB(n) {
    return (n / 1024 / 1024).toFixed(1) + ' MB';
  }

  function openModal() {
    mask.classList.remove('hidden');
  }

  function closeModal() {
    if (!state.busy) mask.classList.add('hidden');
  }

  /** 重置更新按钮 / 进度区到初始状态（打开弹窗、更新失败时调用，v0.55.0） */
  function resetUpdateButtons() {
    nowBtn.disabled = false;
    laterBtn.disabled = false;
    nowBtn.textContent = '立即更新';
    progressWrap.classList.add('hidden');
  }

  function renderInfo(info) {
    state.info = info;
    latestEl.textContent = info.latest || '—';
    currentEl.textContent = info.current || '—';
    notesEl.textContent = info.notes || '（本次更新暂无说明）';
    // v0.55.0：每次打开弹窗重置按钮状态（避免残留上一次的「下载中 / 正在安装」文案）
    resetUpdateButtons();
  }

  /** 检查更新：silent = 启动时自动检查（不打扰，仅红点提示） */
  async function checkUpdate(silent) {
    if (!invoke || state.busy) return;
    if (!silent) versionText.textContent = '检查更新…';
    try {
      const info = await invoke('update_check');
      state.info = info;
      versionText.textContent = 'v' + info.current;
      if (info.has_update) {
        updateDot.classList.remove('hidden');
        versionBtn.title = '发现新版本 v' + info.latest + '，点击查看';
        if (!silent) {
          renderInfo(info);
          openModal();
        }
      } else {
        updateDot.classList.add('hidden');
        versionBtn.title = '点击检查更新';
        if (!silent) window.toast('已是最新版本 v' + info.current);
      }
    } catch (e) {
      versionText.textContent = versionBase;
      if (!silent) window.toast('检查更新失败：' + (e && e.message ? e.message : e));
    }
  }

  // ---------- 交互 ----------

  // 点击版本号：已知有新版本 → 直接打开弹窗；否则重新检查
  versionBtn.addEventListener('click', function () {
    if (state.busy) return;
    if (state.info && state.info.has_update) {
      renderInfo(state.info);
      openModal();
    } else {
      checkUpdate(false);
    }
  });

  laterBtn.addEventListener('click', closeModal);
  mask.addEventListener('click', function (e) {
    if (e.target === mask) closeModal();
  });

  // 立即更新：下载（进度）→ 启动静默安装（安装器自动关闭旧实例并重启新版本）
  nowBtn.addEventListener('click', async function () {
    if (!invoke || !state.info || state.busy) return;
    state.busy = true;
    nowBtn.disabled = true;
    laterBtn.disabled = true;
    // v0.55.0：按钮不再是普通「立即更新」——随阶段实时显示下载进度 / 安装中
    nowBtn.textContent = '下载中 0%';
    progressWrap.classList.remove('hidden');
    progressFill.style.width = '0%';
    progressText.textContent = '开始下载…';
    try {
      const path = await invoke('update_download', {
        url: state.info.asset_url,
        name: state.info.asset_name,
      });
      nowBtn.textContent = '正在安装…';
      progressText.textContent = '下载完成，正在启动安装程序…';
      await invoke('update_install', { path: path });
      progressText.textContent = '安装程序已启动，应用即将自动关闭并完成更新…';
    } catch (e) {
      state.busy = false;
      resetUpdateButtons();
      window.toast('更新失败：' + (e && e.message ? e.message : e));
    }
  });

  // 下载进度事件
  if (listenFn) {
    listenFn('update-progress', function (ev) {
      const p = ev.payload || {};
      const downloaded = p.downloaded || 0;
      const total = p.total || 0;
      if (total > 0) {
        const pct = Math.min(100, Math.round((downloaded / total) * 100));
        progressFill.style.width = pct + '%';
        progressText.textContent = '下载中 ' + pct + '%（' + fmtMB(downloaded) + ' / ' + fmtMB(total) + '）';
        // v0.55.0：按钮文案同步下载进度
        if (state.busy) nowBtn.textContent = '下载中 ' + pct + '%';
      } else {
        progressText.textContent = '下载中（已接收 ' + fmtMB(downloaded) + '）';
        if (state.busy) nowBtn.textContent = '下载中…';
      }
    });
  }

  // 启动后延迟自动检查（静默）
  setTimeout(function () {
    checkUpdate(true);
  }, AUTO_CHECK_DELAY);
})();
