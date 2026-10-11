/* ===== MD5 计算模块（字符串实时计算 + 文件选择/拖入） ===== */
(function () {
  'use strict';

  const invoke = (window.__TAURI__ && window.__TAURI__.core && window.__TAURI__.core.invoke) || null;
  const dialogApi = (window.__TAURI__ && window.__TAURI__.dialog) || null;

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

  // ---------- 拖入文件（v0.33.0：HTML5 拖放） ----------
  // 背景：wry 的原生拖放处理器会顶替 WebView2 内部的拖放目标，页内拖拽（笔记排序等）收不到
  // dragover / drop 事件——已在 tauri.conf.json 设 dragDropEnabled=false 恢复 HTML5 拖拽，
  // 原生 tauri://drag-drop 事件随之废弃。HTML5 拖入的文件拿不到真实路径，改为按内容分块计算。

  // 纯 JS 增量 MD5（RFC 1321）：update 可多次喂入字节块，最后 hex() 输出小写摘要
  const MD5_SHIFT = [
    7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22,
    5, 9, 14, 20, 5, 9, 14, 20, 5, 9, 14, 20, 5, 9, 14, 20,
    4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23,
    6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21,
  ];
  const MD5_K = new Uint32Array(64);
  for (let i = 0; i < 64; i++) MD5_K[i] = (Math.abs(Math.sin(i + 1)) * 4294967296) >>> 0;

  function createMd5() {
    let a0 = 0x67452301;
    let b0 = 0xefcdab89;
    let c0 = 0x98badcfe;
    let d0 = 0x10325476;
    const tail = new Uint8Array(64); // 未满 64 字节的尾部缓存
    const m = new Uint32Array(16);   // 单块消息字（复用，避免每块分配）
    let tailLen = 0;
    let lengthLo = 0; // 已喂入字节数（低 32 位）
    let lengthHi = 0; // 已喂入字节数（高 32 位）

    function processBlock(bytes, off) {
      for (let i = 0; i < 16; i++) {
        const j = off + i * 4;
        m[i] = (bytes[j] | (bytes[j + 1] << 8) | (bytes[j + 2] << 16) | (bytes[j + 3] << 24)) >>> 0;
      }
      let a = a0;
      let b = b0;
      let c = c0;
      let d = d0;
      for (let i = 0; i < 64; i++) {
        let f;
        let g;
        if (i < 16) {
          f = (b & c) | (~b & d);
          g = i;
        } else if (i < 32) {
          f = (d & b) | (~d & c);
          g = (5 * i + 1) & 15;
        } else if (i < 48) {
          f = b ^ c ^ d;
          g = (3 * i + 5) & 15;
        } else {
          f = c ^ (b | ~d);
          g = (7 * i) & 15;
        }
        const sum = (a + f + MD5_K[i] + m[g]) | 0;
        const t = d;
        d = c;
        c = b;
        b = (b + ((sum << MD5_SHIFT[i]) | (sum >>> (32 - MD5_SHIFT[i])))) | 0;
        a = t;
      }
      a0 = (a0 + a) | 0;
      b0 = (b0 + b) | 0;
      c0 = (c0 + c) | 0;
      d0 = (d0 + d) | 0;
    }

    function update(bytes) {
      const len = bytes.length;
      const prevLo = lengthLo;
      lengthLo = (lengthLo + len) >>> 0;
      if (lengthLo < prevLo) lengthHi = (lengthHi + 1) >>> 0;
      let off = 0;
      if (tailLen > 0) {
        const need = 64 - tailLen;
        if (len < need) {
          tail.set(bytes, tailLen);
          tailLen += len;
          return;
        }
        tail.set(bytes.subarray(0, need), tailLen);
        processBlock(tail, 0);
        tailLen = 0;
        off = need;
      }
      const end = len - 64;
      while (off <= end) {
        processBlock(bytes, off);
        off += 64;
      }
      if (off < len) {
        tail.set(bytes.subarray(off), 0);
        tailLen = len - off;
      }
    }

    function hex() {
      tail[tailLen] = 0x80;
      let n = tailLen + 1;
      if (n > 56) {
        for (let i = n; i < 64; i++) tail[i] = 0;
        processBlock(tail, 0);
        n = 0;
      }
      for (let i = n; i < 56; i++) tail[i] = 0;
      const bitLo = (lengthLo << 3) >>> 0;
      const bitHi = ((lengthHi << 3) | (lengthLo >>> 29)) >>> 0;
      tail[56] = bitLo & 0xff;
      tail[57] = (bitLo >>> 8) & 0xff;
      tail[58] = (bitLo >>> 16) & 0xff;
      tail[59] = (bitLo >>> 24) & 0xff;
      tail[60] = bitHi & 0xff;
      tail[61] = (bitHi >>> 8) & 0xff;
      tail[62] = (bitHi >>> 16) & 0xff;
      tail[63] = (bitHi >>> 24) & 0xff;
      processBlock(tail, 0);
      const words = [a0, b0, c0, d0];
      let out = '';
      for (let k = 0; k < 4; k++) {
        for (let i = 0; i < 4; i++) out += ((words[k] >>> (8 * i)) & 0xff).toString(16).padStart(2, '0');
      }
      return out;
    }

    return { update: update, hex: hex };
  }

  const DROP_CHUNK_SIZE = 8 * 1024 * 1024;

  // 按内容分块计算拖入文件的 MD5（8 MB 一块，大文件不占内存；点击选择仍走 Rust 流式计算）
  async function calcDroppedFile(file) {
    fileHash = '';
    setValue(fileResultEl, '正在计算…', false);
    fileInfoEl.textContent = '正在计算：' + file.name;
    dropEl.classList.remove('over');
    try {
      const hasher = createMd5();
      let off = 0;
      while (off < file.size) {
        const buf = await file.slice(off, Math.min(off + DROP_CHUNK_SIZE, file.size)).arrayBuffer();
        hasher.update(new Uint8Array(buf));
        off += buf.byteLength;
        if (file.size > DROP_CHUNK_SIZE) {
          setValue(fileResultEl, '正在计算… ' + Math.floor((off / file.size) * 100) + '%', false);
        }
      }
      fileHash = hasher.hex();
      fileInfoEl.textContent = file.name + '（' + humanSize(file.size) + '）';
      renderResults();
      // 写入文件计算历史记录（与点击选择路径一致）
      window.historyStore.add('md5', { kind: 'file', input: fileInfoEl.textContent, hash: fileHash });
    } catch (e) {
      setError(fileResultEl, String(e));
      fileInfoEl.textContent = '';
    }
  }

  // 面板激活时，文件悬停在窗口任意处 → 高亮拖放区；松手 → 计算
  const panelEl = document.getElementById('panel-md5');
  const panelActive = () => panelEl.classList.contains('active');
  const isFileDrag = (e) => {
    const t = e.dataTransfer && e.dataTransfer.types;
    return !!t && Array.prototype.indexOf.call(t, 'Files') !== -1;
  };
  document.addEventListener('dragover', (e) => {
    if (!panelActive() || !isFileDrag(e)) return;
    e.preventDefault();
    e.dataTransfer.dropEffect = 'copy';
    dropEl.classList.add('over');
  });
  document.addEventListener('dragleave', (e) => {
    if (!e.relatedTarget || e.clientX <= 0 || e.clientY <= 0) dropEl.classList.remove('over');
  });
  document.addEventListener('drop', (e) => {
    if (!isFileDrag(e)) return;
    dropEl.classList.remove('over');
    if (!panelActive()) return;
    e.preventDefault();
    const file = e.dataTransfer.files && e.dataTransfer.files[0];
    if (!file) {
      window.toast('未检测到文件（暂不支持文件夹）');
      return;
    }
    calcDroppedFile(file);
  });

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
