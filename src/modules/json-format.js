/* ===== JSON 格式化模块 ===== */
(function () {
  'use strict';

  const input = document.getElementById('json-input');
  const output = document.getElementById('json-output');
  const statusEl = document.getElementById('json-status');
  const unescapeCheck = document.getElementById('json-unescape');
  const indentBtn = document.getElementById('json-indent-btn');
  const indentLabel = document.getElementById('json-indent-label');

  function setStatus(msg, type) {
    statusEl.textContent = msg || '';
    statusEl.className = 'status-bar' + (type ? ' ' + type : '');
  }

  /**
   * 去除整体转义：处理从日志/代码里复制出来的被转义 JSON 字符串。
   * 例：'{\"name\":\"test\"}' → '{"name":"test"}'
   */
  function unescapeText(text) {
    let s = text.trim();
    // 外层若被引号包裹（如 "{\"a\":1}"），先剥掉外层引号
    if (s.length >= 2 && s.startsWith('"') && s.endsWith('"')) {
      try {
        return JSON.parse(s); // 标准 JSON 字符串解析（会完成全部去转义）
      } catch (_) {
        s = s.slice(1, -1);
      }
    }
    // 无外层引号：逐段还原转义序列
    return s.replace(/\\(u[0-9a-fA-F]{4}|.)/g, (m, c) => {
      switch (c[0]) {
        case '"': return '"';
        case '\\': return '\\';
        case '/': return '/';
        case 'b': return '\b';
        case 'f': return '\f';
        case 'n': return '\n';
        case 'r': return '\r';
        case 't': return '\t';
        case 'u': return String.fromCharCode(parseInt(c.slice(1), 16));
        default: return m;
      }
    });
  }

  function parseJson(text) {
    try {
      return { ok: true, value: JSON.parse(text) };
    } catch (e) {
      return { ok: false, error: e };
    }
  }

  /** 解析输入：先直接解析；失败且开启去转义时，去转义后重试 */
  function resolveInput(raw) {
    const text = raw.trim();
    let parsed = parseJson(text);
    if (parsed.ok) return { parsed, usedUnescape: false };
    if (unescapeCheck.checked) {
      const restored = unescapeText(text);
      if (restored !== text) {
        const retry = parseJson(restored);
        if (retry.ok) return { parsed: retry, usedUnescape: true };
      }
    }
    return { parsed, usedUnescape: false };
  }

  function getIndent() {
    return indentValue === 'tab' ? '\t' : Number(indentValue);
  }

  // ---------- 缩进选择（自定义下拉，v0.31.1 替代原生 select——原生弹层选项上下间距无法调整） ----------

  const INDENT_OPTIONS = [
    { value: '2', label: '2 空格' },
    { value: '4', label: '4 空格' },
    { value: 'tab', label: 'Tab' },
  ];
  const INDENT_CHECK_ICON = '<svg class="select-check" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.5" stroke-linecap="round" stroke-linejoin="round" aria-hidden="true"><polyline points="20 6 9 17 4 12"/></svg>';
  let indentValue = '2';
  let indentMenuEl = null;
  let indentMenuDocHandler = null;

  function closeIndentMenu() {
    if (indentMenuEl) {
      indentMenuEl.remove();
      indentMenuEl = null;
    }
    if (indentMenuDocHandler) {
      document.removeEventListener('click', indentMenuDocHandler);
      indentMenuDocHandler = null;
    }
    indentBtn.setAttribute('aria-expanded', 'false');
  }

  function openIndentMenu() {
    closeIndentMenu();
    const menu = document.createElement('div');
    menu.className = 'export-menu select-menu';
    menu.setAttribute('role', 'listbox');
    menu.innerHTML = INDENT_OPTIONS.map((o) =>
      '<button type="button" role="option" data-indent="' + o.value + '"' + (o.value === indentValue ? ' class="is-active"' : '') + '>' +
      '<span>' + o.label + '</span>' + (o.value === indentValue ? INDENT_CHECK_ICON : '') + '</button>').join('');
    document.body.appendChild(menu);
    const rect = indentBtn.getBoundingClientRect();
    let left = rect.left;
    if (left + menu.offsetWidth > window.innerWidth - 8) left = window.innerWidth - menu.offsetWidth - 8;
    if (left < 8) left = 8;
    let top = rect.bottom + 6;
    if (top + menu.offsetHeight > window.innerHeight - 8) top = rect.top - menu.offsetHeight - 6;
    menu.style.left = left + 'px';
    menu.style.top = top + 'px';
    indentMenuEl = menu;
    indentBtn.setAttribute('aria-expanded', 'true');
    menu.querySelectorAll('button[data-indent]').forEach((b) => {
      b.addEventListener('click', (e) => {
        e.stopPropagation();
        indentValue = b.getAttribute('data-indent');
        const opt = INDENT_OPTIONS.find((o) => o.value === indentValue);
        indentLabel.textContent = opt ? opt.label : indentValue;
        closeIndentMenu();
      });
    });
    setTimeout(() => {
      indentMenuDocHandler = (ev) => {
        if (indentMenuEl && !indentMenuEl.contains(ev.target)) closeIndentMenu();
      };
      document.addEventListener('click', indentMenuDocHandler);
    }, 0);
  }

  indentBtn.addEventListener('click', (e) => {
    e.stopPropagation();
    if (indentMenuEl) {
      closeIndentMenu();
      return;
    }
    openIndentMenu();
  });

  /** 写入格式化历史记录（内容过大时提示并跳过） */
  function recordHistory(raw, result) {
    if (window.historyStore.add('json', { input: raw, output: result }) === 'too-large') {
      window.toast('内容过大，未加入历史记录');
    }
  }

  function format() {
    const raw = input.value;
    if (!raw.trim()) {
      setStatus('请先输入 JSON 文本', 'error');
      output.value = '';
      return;
    }
    const { parsed, usedUnescape } = resolveInput(raw);
    if (!parsed.ok) {
      output.value = '';
      setStatus('解析失败：' + parsed.error.message, 'error');
      return;
    }
    output.value = JSON.stringify(parsed.value, null, getIndent());
    const lines = output.value.split('\n').length;
    setStatus(
      (usedUnescape ? '已自动去除转义，' : '') + '格式化成功 · ' + lines + ' 行',
      'success'
    );
    recordHistory(raw, output.value);
  }

  function minify() {
    const raw = input.value;
    if (!raw.trim()) {
      setStatus('请先输入 JSON 文本', 'error');
      output.value = '';
      return;
    }
    const { parsed, usedUnescape } = resolveInput(raw);
    if (!parsed.ok) {
      output.value = '';
      setStatus('解析失败：' + parsed.error.message, 'error');
      return;
    }
    output.value = JSON.stringify(parsed.value);
    setStatus(
      (usedUnescape ? '已自动去除转义，' : '') + '已压缩为单行 · ' + output.value.length + ' 字符',
      'success'
    );
    recordHistory(raw, output.value);
  }

  async function copyResult() {
    const text = output.value;
    if (!text) {
      window.toast('没有可复制的结果');
      return;
    }
    const ok = await window.copyText(text, '已复制格式化结果');
    if (ok) setStatus('已复制到剪贴板', 'success');
  }

  async function copyInput() {
    if (!input.value) {
      window.toast('没有可复制的输入内容');
      return;
    }
    await window.copyText(input.value, '已复制输入内容');
  }

  document.getElementById('json-format').addEventListener('click', format);
  document.getElementById('json-minify').addEventListener('click', minify);
  document.getElementById('json-copy-input').addEventListener('click', copyInput);
  document.getElementById('json-copy-output').addEventListener('click', copyResult);

  document.getElementById('json-clear').addEventListener('click', () => {
    input.value = '';
    output.value = '';
    setStatus('');
    input.focus();
  });

  // 输入变化时清除旧状态提示
  input.addEventListener('input', () => {
    if (statusEl.classList.contains('error')) setStatus('');
  });

  // ---------- 历史记录 ----------

  window.historyStore.bindPanel({
    kind: 'json',
    label: '格式化记录',
    btn: document.getElementById('json-history-btn'),
    pop: document.getElementById('json-history-pop'),
    list: document.getElementById('json-history-list'),
    clear: document.getElementById('json-history-clear'),
    onRestore(rec) {
      input.value = rec.input;
      output.value = rec.output;
      setStatus('已恢复历史记录（' + (rec.output.split('\n').length) + ' 行）', 'success');
      input.focus();
    },
  });
})();
