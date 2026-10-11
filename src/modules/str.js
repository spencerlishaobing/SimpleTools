/* ===== 字符串转换模块（大小写 + 命名风格，输入即生成） ===== */
(function () {
  'use strict';

  const inputEl = document.getElementById('str-input');
  const resultsEl = document.getElementById('str-results');

  // ---------- 转换逻辑 ----------

  // 拆词：支持下划线 / 中划线 / 空格 / 点分隔；同时拆分已有驼峰（含连续大写缩写）
  function tokenize(s) {
    return s
      .replace(/([a-z0-9])([A-Z])/g, '$1 $2')     // userName -> user Name
      .replace(/([A-Z]+)([A-Z][a-z])/g, '$1 $2')  // HTTPServer -> HTTP Server
      .split(/[_\-\s.]+/)
      .filter(function (w) { return w.length > 0; });
  }

  function capitalize(w) {
    return w.charAt(0).toUpperCase() + w.slice(1).toLowerCase();
  }

  function lowerAll(tokens) {
    return tokens.map(function (w) { return w.toLowerCase(); });
  }

  const TRANSFORMS = [
    {
      key: 'upper', label: '全部大写',
      fn: function (s) { return s.toUpperCase(); }
    },
    {
      key: 'lower', label: '全部小写',
      fn: function (s) { return s.toLowerCase(); }
    },
    {
      key: 'title', label: '首字母大写',
      fn: function (s) { return tokenize(s).map(capitalize).join(' '); }
    },
    {
      key: 'camel', label: '驼峰命名',
      fn: function (s) {
        return tokenize(s).map(function (w, i) {
          return i === 0 ? w.toLowerCase() : capitalize(w);
        }).join('');
      }
    },
    {
      key: 'pascal', label: '大驼峰命名',
      fn: function (s) { return tokenize(s).map(capitalize).join(''); }
    },
    {
      key: 'snake', label: '下划线命名',
      fn: function (s) { return lowerAll(tokenize(s)).join('_'); }
    },
    {
      key: 'kebab', label: '中划线命名',
      fn: function (s) { return lowerAll(tokenize(s)).join('-'); }
    },
    {
      key: 'constant', label: '常量命名',
      fn: function (s) {
        return tokenize(s).map(function (w) { return w.toUpperCase(); }).join('_');
      }
    }
  ];

  const state = {}; // key -> 当前结果文本

  // ---------- 渲染 ----------

  function buildRows() {
    resultsEl.innerHTML = TRANSFORMS.map(function (t) {
      return (
        '<div class="str-row" data-key="' + t.key + '">' +
        '<span class="str-label">' + t.label + '</span>' +
        '<span class="str-value empty">—</span>' +
        '<button class="pane-copy" title="复制' + t.label + '结果">复制</button>' +
        '</div>'
      );
    }).join('');
  }

  function render() {
    const text = inputEl.value;
    TRANSFORMS.forEach(function (t) {
      if (!text) {
        state[t.key] = '';
      } else {
        // 多行输入按行分别转换，保留原行数
        state[t.key] = text.split('\n').map(function (line) {
          return t.fn(line);
        }).join('\n');
      }
      const val = state[t.key];
      const el = resultsEl.querySelector('.str-row[data-key="' + t.key + '"] .str-value');
      el.textContent = val || '—';
      el.classList.toggle('empty', !val);
    });
  }

  // ---------- 事件 ----------

  inputEl.addEventListener('input', render);

  resultsEl.addEventListener('click', async function (e) {
    const btn = e.target.closest('.pane-copy');
    if (!btn) return;
    const row = btn.closest('.str-row');
    const val = state[row.dataset.key];
    if (!val) {
      window.toast('暂无内容可复制');
      return;
    }
    await window.copyText(val, '已复制「' + row.querySelector('.str-label').textContent + '」');
  });

  // ---------- 初始化 ----------

  buildRows();
  render();
})();
