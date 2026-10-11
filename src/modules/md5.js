/* ===== MD5 计算模块（字符串实时计算 + 文件选择/拖入） ===== */
(function () {
  'use strict';

  const invoke = (window.__TAURI__ && window.__TAURI__.core && window.__TAURI__.core.invoke) || null;
  const dialogApi = (window.__TAURI__ && window.__TAURI__.dialog) || null;
  const eventApi = (window.__TAURI__ && window.__TAURI__.event) || null;

  const textEl = document.getElementById('md5-text');
  const formatBtn = document.getElementById('md5-format-btn');
  const formatLabel = document.getElementById('md5-format-label');
  const textResultEl = document.getElementById('md5-text-result');
  const fileResultEl = document.getElementById('md5-file-result');
  const fileInfoEl = document.getElementById('md5-file-info');
  const dropEl = document.getElementById('md5-drop');

  const TEXT_DEBOUNCE = 120;

  let textHash = '';  // 原始小写 hex
  let fileHash = '';
  let calcTimer = null;

  // ---------- 格式转换 ----------

  function hexToBytes(hex) {
    const bytes = new Uint8Array(hex.length / 2);
    for (let i = 0; i < bytes.length; i++) {
      bytes[i] = parseInt(hex.substr(i * 2, 2), 16);
    }
    return bytes;
  }

  function formatHash(hex) {
    if (!hex) return '';
    switch (formatValue) {
      case 'upper': return hex.toUpperCase();
      case 'base64': return btoa(String.fromCharCode.apply(null, hexToBytes(hex)));
      default: return hex;
    }
  }

  // ---------- 结果格式选择（自定义下拉，v0.31.1 替代原生 select——原生弹层选项上下间距无法调整） ----------

  const FORMAT_OPTIONS = [
    { value: 'lower', label: '小写（hex）' },
    { value: 'upper', label: '大写（HEX）' },
    { value: 'base64', label: 'Base64' },
  ];
  const FORMAT_CHECK_ICON = '<svg class="select-check" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.5" stroke-linecap="round" stroke-linejoin="round" aria-hidden="true"><polyline points="20 6 9 17 4 12"/></svg>';
  let formatValue = 'lower';
  let formatMenuEl = null;
  let formatMenuDocHandler = null;

  function closeFormatMenu() {
    if (formatMenuEl) {
      formatMenuEl.remove();
      formatMenuEl = null;
    }
    if (formatMenuDocHandler) {
      document.removeEventListener('click', formatMenuDocHandler);
      formatMenuDocHandler = null;
    }
    formatBtn.setAttribute('aria-expanded', 'false');
  }

  function openFormatMenu() {
    closeFormatMenu();
    const menu = document.createElement('div');
    menu.className = 'export-menu select-menu';
    menu.setAttribute('role', 'listbox');
    menu.innerHTML = FORMAT_OPTIONS.map((o) =>
      '<button type="button" role="option" data-format="' + o.value + '"' + (o.value === formatValue ? ' class="is-active"' : '') + '>' +
      '<span>' + o.label + '</span>' + (o.value === formatValue ? FORMAT_CHECK_ICON : '') + '</button>').join('');
    document.body.appendChild(menu);
    const rect = formatBtn.getBoundingClientRect();
    let left = rect.left;
    if (left + menu.offsetWidth > window.innerWidth - 8) left = window.innerWidth - menu.offsetWidth - 8;
    if (left < 8) left = 8;
    let top = rect.bottom + 6;
    if (top + menu.offsetHeight > window.innerHeight - 8) top = rect.top - menu.offsetHeight - 6;
    menu.style.left = left + 'px';
    menu.style.top = top + 'px';
    formatMenuEl = menu;
    formatBtn.setAttribute('aria-expanded', 'true');
    menu.querySelectorAll('button[data-format]').forEach((b) => {
      b.addEventListener('click', (e) => {
        e.stopPropagation();
        formatValue = b.getAttribute('data-format');
        const opt = FORMAT_OPTIONS.find((o) => o.value === formatValue);
        formatLabel.textContent = opt ? opt.label : formatValue;
        renderResults();
        closeFormatMenu();
      });
    });
    setTimeout(() => {
      formatMenuDocHandler = (ev) => {
        if (formatMenuEl && !formatMenuEl.contains(ev.target)) closeFormatMenu();
      };
      document.addEventListener('click', formatMenuDocHandler);
    }, 0);
  }

  formatBtn.addEventListener('click', (e) => {
    e.stopPropagation();
    if (formatMenuEl) {
      closeFormatMenu();
      return;
    }
    openFormatMenu();
  });

  function humanSize(n) {
    if (n < 1024) return n + ' B';
    if (n < 1024 * 1024) return (n / 1024).toFixed(1) + ' KB';
    if (n < 1024 * 1024 * 1024) return (n / 1024 / 1024).toFixed(1) + ' MB';
    return (n / 1024 / 1024 / 1024).toFixed(2) + ' GB';
  }

  function setValue(el, text, isEmpty) {
    el.textContent = text || '—';
    el.classList.toggle('empty', !!isEmpty);
    el.classList.remove('error');
  }

  function setError(el, msg) {
    el.textContent = msg;
    el.classList.remove('empty');
    el.classList.add('error');
  }

  function renderResults() {
    setValue(textResultEl, textHash ? formatHash(textHash) : '—', !textHash);
    setValue(fileResultEl, fileHash ? formatHash(fileHash) : '—', !fileHash);
  }

  // ---------- 字符串计算（防抖，输入即算） ----------

  textEl.addEventListener('input', () => {
    clearTimeout(calcTimer);
    const text = textEl.value;
    if (!text) {
      textHash = '';
      renderResults();
      return;
    }
    if (!invoke) {
      setError(textResultEl, 'Tauri 接口不可用（请通过应用运行）');
      return;
    }
    calcTimer = setTimeout(async () => {
      const text = textEl.value;
      try {
        textHash = await invoke('md5_text', { text: text });
        renderResults();
        // 写入字符串计算历史记录
        window.historyStore.add('md5', { kind: 'text', input: text, hash: textHash });
      } catch (e) {
        textHash = '';
        setError(textResultEl, String(e));
      }
    }, TEXT_DEBOUNCE);
  });

  // ---------- 文件计算 ----------

  async function calcFile(path) {
    if (!path || !invoke) {
      window.toast('Tauri 接口不可用（请通过应用运行）');
      return;
    }
    fileHash = '';
    setValue(fileResultEl, '正在计算…', false);
    fileInfoEl.textContent = '正在计算：' + path;
    dropEl.classList.remove('over');
    try {
      const r = await invoke('md5_file', { path });
      fileHash = r.hash;
      fileInfoEl.textContent = r.name + '（' + humanSize(r.size) + '）';
      renderResults();
      // 写入文件计算历史记录
      window.historyStore.add('md5', { kind: 'file', input: fileInfoEl.textContent, hash: fileHash });
    } catch (e) {
      setError(fileResultEl, String(e));
      fileInfoEl.textContent = '';
    }
  }

  // 点击选择文件
  dropEl.addEventListener('click', async () => {
    if (!dialogApi || !dialogApi.open) {
      window.toast('Tauri 接口不可用（请通过应用运行）');
      return;
    }
    try {
      const selected = await dialogApi.open({ multiple: false, title: '选择要计算 MD5 的文件' });
      if (!selected) return;
      const path = typeof selected === 'string'
        ? selected
        : (selected && selected.path) || (Array.isArray(selected) ? selected[0] : null);
      if (path) calcFile(path);
    } catch (e) {
      window.toast('打开文件选择器失败：' + e);
    }
  });

  // OS 文件拖入（Tauri 原生拖放事件；网页内部拖拽不受影响，仅在 MD5 面板激活时响应）
  if (eventApi && eventApi.listen) {
    const panelEl = document.getElementById('panel-md5');
    const panelActive = () => panelEl.classList.contains('active');
    eventApi.listen('tauri://drag-enter', () => {
      if (panelActive()) dropEl.classList.add('over');
    });
    eventApi.listen('tauri://drag-leave', () => dropEl.classList.remove('over'));
    eventApi.listen('tauri://drag-drop', (e) => {
      dropEl.classList.remove('over');
      if (!panelActive()) return;
      const paths = e && e.payload && e.payload.paths;
      if (paths && paths.length) {
        calcFile(paths[0]);
      } else {
        window.toast('未检测到文件路径');
      }
    });
  }

  // ---------- 复制 ----------

  document.getElementById('md5-text-copy').addEventListener('click', async () => {
    if (!textHash) {
      window.toast('暂无可复制的结果');
      return;
    }
    await window.copyText(formatHash(textHash), '已复制 MD5');
  });

  document.getElementById('md5-file-copy').addEventListener('click', async () => {
    if (!fileHash) {
      window.toast('暂无可复制的结果');
      return;
    }
    await window.copyText(formatHash(fileHash), '已复制 MD5');
  });

  // ---------- 历史记录 ----------

  window.historyStore.bindPanel({
    kind: 'md5',
    label: 'MD5 记录',
    btn: document.getElementById('md5-history-btn'),
    pop: document.getElementById('md5-history-pop'),
    list: document.getElementById('md5-history-list'),
    clear: document.getElementById('md5-history-clear'),
    onRestore(rec) {
      if (rec.kind === 'file') {
        fileHash = rec.hash;
        fileInfoEl.textContent = rec.input;
      } else {
        textEl.value = rec.input;
        textHash = rec.hash;
      }
      renderResults();
    },
  });
})();
