/* ===== JSON 格式化模块 ===== */
(function () {
  'use strict';

  const input = document.getElementById('json-input');
  const output = document.getElementById('json-output');
  const statusEl = document.getElementById('json-status');
  const unescapeCheck = document.getElementById('json-unescape');
  const indentSelect = document.getElementById('json-indent');

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
    return indentSelect.value === 'tab' ? '\t' : Number(indentSelect.value);
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

  // 快捷键：Ctrl+Enter 格式化；Ctrl+Shift+Enter 压缩
  input.addEventListener('keydown', (e) => {
    if (e.ctrlKey && e.key === 'Enter') {
      e.preventDefault();
      if (e.shiftKey) minify();
      else format();
    }
  });

  // 输入变化时清除旧状态提示
  input.addEventListener('input', () => {
    if (statusEl.classList.contains('error')) setStatus('');
  });
})();
