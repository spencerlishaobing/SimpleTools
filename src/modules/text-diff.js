/* ===== 文本对比模块（左侧差异绿色 / 右侧差异红色） ===== */
(function () {
  'use strict';

  const leftEl = document.getElementById('diff-left');
  const rightEl = document.getElementById('diff-right');
  const resultEl = document.getElementById('diff-result');
  const statsEl = document.getElementById('diff-stats');
  const ignoreWs = document.getElementById('diff-ignore-space');
  const extractCheck = document.getElementById('diff-extract-json');
  const treeWrap = document.getElementById('diff-tree-wrap');
  const treeCheck = document.getElementById('diff-tree');
  const treeActionsEl = document.getElementById('diff-tree-actions');

  let resultText = ''; // 最近一次对比的纯文本形式（供复制）

  const MAX_MATRIX = 4_000_000;   // 行级 DP 规模上限（n*m）
  const MAX_CHAR_MATRIX = 250_000; // 行内字符 DP 规模上限
  const SIM_THRESHOLD = 0.25;      // 判定为"修改行"的最低相似度

  // ---------- 基础工具 ----------

  const ESC_MAP = { '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;', "'": '&#39;' };
  function esc(s) {
    return String(s).replace(/[&<>"']/g, (c) => ESC_MAP[c]);
  }

  function splitLines(text) {
    if (text === '') return [];
    const lines = text.split(/\r\n|\r|\n/);
    if (lines.length > 1 && lines[lines.length - 1] === '') lines.pop();
    return lines;
  }

  /** LCS 动态规划表（dp[i][j] = a[i..] 与 b[j..] 的 LCS 长度） */
  function lcsMatrix(a, b) {
    const n = a.length;
    const m = b.length;
    const dp = new Array(n + 1);
    for (let i = 0; i <= n; i++) dp[i] = new Uint32Array(m + 1);
    for (let i = n - 1; i >= 0; i--) {
      const row = dp[i];
      const next = dp[i + 1];
      const ai = a[i];
      for (let j = m - 1; j >= 0; j--) {
        row[j] = ai === b[j] ? next[j + 1] + 1 : (next[j] >= row[j + 1] ? next[j] : row[j + 1]);
      }
    }
    return dp;
  }

  // ---------- 行级 diff ----------

  /**
   * 行级 diff：公共前后缀裁剪 + 中段 LCS。
   * 返回 [{ type: 'same'|'del'|'ins', li, ri }]（li/ri 为 0 基行号）
   */
  function diffLines(aKeys, bKeys) {
    const n = aKeys.length;
    const m = bKeys.length;
    const ops = [];

    let s = 0;
    while (s < n && s < m && aKeys[s] === bKeys[s]) s++;
    let ea = n;
    let eb = m;
    while (ea > s && eb > s && aKeys[ea - 1] === bKeys[eb - 1]) {
      ea--;
      eb--;
    }

    for (let i = 0; i < s; i++) ops.push({ type: 'same', li: i, ri: i });

    const midN = ea - s;
    const midM = eb - s;
    if (midN > 0 && midM > 0 && midN * midM > MAX_MATRIX) {
      // 规模过大：中段整体标记为差异，避免界面卡死
      for (let i = s; i < ea; i++) ops.push({ type: 'del', li: i });
      for (let j = s; j < eb; j++) ops.push({ type: 'ins', ri: j });
    } else if (midN > 0 && midM > 0) {
      const dp = lcsMatrix(aKeys.slice(s, ea), bKeys.slice(s, eb));
      let i = 0;
      let j = 0;
      while (i < midN && j < midM) {
        if (aKeys[s + i] === bKeys[s + j]) {
          ops.push({ type: 'same', li: s + i, ri: s + j });
          i++;
          j++;
        } else if (dp[i + 1][j] >= dp[i][j + 1]) {
          ops.push({ type: 'del', li: s + i });
          i++;
        } else {
          ops.push({ type: 'ins', ri: s + j });
          j++;
        }
      }
      while (i < midN) {
        ops.push({ type: 'del', li: s + i });
        i++;
      }
      while (j < midM) {
        ops.push({ type: 'ins', ri: s + j });
        j++;
      }
    } else {
      for (let i = s; i < ea; i++) ops.push({ type: 'del', li: i });
      for (let j = s; j < eb; j++) ops.push({ type: 'ins', ri: j });
    }

    for (let i = 0; i < n - ea; i++) ops.push({ type: 'same', li: ea + i, ri: eb + i });
    return ops;
  }

  // ---------- 行内字符级 diff ----------

  /**
   * 字符级 diff：返回片段数组 [{ kind: 'same'|'a'|'b', text }]。
   * kind='a' 仅左侧有的字符（绿色高亮），kind='b' 仅右侧有的字符（红色高亮）。
   */
  function diffChars(a, b) {
    const segs = [];
    const n = a.length;
    const m = b.length;

    let s = 0;
    while (s < n && s < m && a[s] === b[s]) s++;
    let ea = n;
    let eb = m;
    while (ea > s && eb > s && a[ea - 1] === b[eb - 1]) {
      ea--;
      eb--;
    }

    if (s > 0) segs.push({ kind: 'same', text: a.slice(0, s) });

    const midA = a.slice(s, ea);
    const midB = b.slice(s, eb);
    if (midA.length === 0) {
      if (midB.length) segs.push({ kind: 'b', text: midB });
    } else if (midB.length === 0) {
      segs.push({ kind: 'a', text: midA });
    } else if (midA.length * midB.length > MAX_CHAR_MATRIX) {
      segs.push({ kind: 'a', text: midA });
      segs.push({ kind: 'b', text: midB });
    } else {
      const dp = lcsMatrix(midA, midB);
      let i = 0;
      let j = 0;
      let buf = '';
      let bufKind = '';
      const flush = () => {
        if (buf) {
          segs.push({ kind: bufKind, text: buf });
          buf = '';
        }
      };
      const push = (kind, ch) => {
        if (bufKind !== kind) {
          flush();
          bufKind = kind;
        }
        buf += ch;
      };
      while (i < midA.length && j < midB.length) {
        if (midA[i] === midB[j]) {
          push('same', midA[i]);
          i++;
          j++;
        } else if (dp[i + 1][j] >= dp[i][j + 1]) {
          push('a', midA[i]);
          i++;
        } else {
          push('b', midB[j]);
          j++;
        }
      }
      while (i < midA.length) {
        push('a', midA[i]);
        i++;
      }
      while (j < midB.length) {
        push('b', midB[j]);
        j++;
      }
      flush();
    }

    if (ea < n) segs.push({ kind: 'same', text: a.slice(ea) });
    return segs;
  }

  function segsToHtmlPair(segs) {
    let left = '';
    let right = '';
    for (const seg of segs) {
      if (seg.kind === 'same') {
        const t = esc(seg.text);
        left += t;
        right += t;
      } else if (seg.kind === 'a') {
        left += '<span class="hl-green">' + esc(seg.text) + '</span>';
      } else {
        right += '<span class="hl-red">' + esc(seg.text) + '</span>';
      }
    }
    return { left, right };
  }

  /** 相似度（0~1）：小文本用字符级 LCS 比例，大文本用字符频率重叠 */
  function similarity(a, b) {
    if (a === b) return 1;
    if (!a.length && !b.length) return 1;
    if (!a.length || !b.length) return 0;
    const total = a.length + b.length;
    if (a.length * b.length <= MAX_CHAR_MATRIX) {
      const dp = lcsMatrix(a, b);
      return (2 * dp[0][0]) / total;
    }
    const freq = new Map();
    for (const ch of a) freq.set(ch, (freq.get(ch) || 0) + 1);
    let common = 0;
    for (const ch of b) {
      const c = freq.get(ch);
      if (c) {
        common++;
        freq.set(ch, c - 1);
      }
    }
    return (2 * common) / total;
  }

  /** 把相邻的"删除段 + 新增段"按相似度配对成"修改行" */
  function pairModified(ops, aKeys, bKeys) {
    const out = [];
    let i = 0;
    while (i < ops.length) {
      if (ops[i].type === 'same') {
        out.push(ops[i]);
        i++;
        continue;
      }
      const dels = [];
      const inss = [];
      while (i < ops.length && ops[i].type !== 'same') {
        (ops[i].type === 'del' ? dels : inss).push(ops[i]);
        i++;
      }
      const pairs = Math.min(dels.length, inss.length);
      let k = 0;
      for (; k < pairs; k++) {
        const d = dels[k];
        const s = inss[k];
        if (similarity(aKeys[d.li], bKeys[s.ri]) >= SIM_THRESHOLD) {
          out.push({ type: 'mod', del: d, ins: s });
        } else {
          out.push(d);
          out.push(s);
        }
      }
      for (; k < dels.length; k++) out.push(dels[k]);
      for (; k < inss.length; k++) out.push(inss[k]);
    }
    return out;
  }

  // ---------- 渲染 ----------

  function cellHtml(side, cls, lineNo, content, isHtml) {
    const fullCls = 'diff-cell ' + side + (cls ? ' ' + cls : '');
    let body;
    if (content === null || content === '') body = '\u200b';
    else body = isHtml ? content : esc(content);
    return (
      '<div class="' + fullCls + '">' +
      '<span class="ln">' + (lineNo || '') + '</span>' +
      '<span class="code">' + body + '</span>' +
      '</div>'
    );
  }

  function renderResult(paireOps, aRaw, bRaw) {
    const rows = [];
    const textLines = [];
    let sameCount = 0;
    let delCount = 0;
    let insCount = 0;
    let modCount = 0;

    for (const op of paireOps) {
      if (op.type === 'same') {
        sameCount++;
        textLines.push(aRaw[op.li]);
        rows.push(
          '<div class="diff-row">' +
          cellHtml('left', '', op.li + 1, aRaw[op.li], false) +
          cellHtml('right', '', op.ri + 1, bRaw[op.ri], false) +
          '</div>'
        );
      } else if (op.type === 'del') {
        delCount++;
        textLines.push('- ' + aRaw[op.li]);
        rows.push(
          '<div class="diff-row">' +
          cellHtml('left', 'del', op.li + 1, aRaw[op.li], false) +
          cellHtml('right', 'placeholder', '', null, false) +
          '</div>'
        );
      } else if (op.type === 'ins') {
        insCount++;
        textLines.push('+ ' + bRaw[op.ri]);
        rows.push(
          '<div class="diff-row">' +
          cellHtml('left', 'placeholder', '', null, false) +
          cellHtml('right', 'ins', op.ri + 1, bRaw[op.ri], false) +
          '</div>'
        );
      } else {
        modCount++;
        textLines.push('- ' + aRaw[op.del.li]);
        textLines.push('+ ' + bRaw[op.ins.ri]);
        const { left, right } = segsToHtmlPair(diffChars(aRaw[op.del.li], bRaw[op.ins.ri]));
        rows.push(
          '<div class="diff-row">' +
          cellHtml('left', 'del', op.del.li + 1, left, true) +
          cellHtml('right', 'ins', op.ins.ri + 1, right, true) +
          '</div>'
        );
      }
    }

    resultText = textLines.join('\n');
    treeActionsEl.classList.add('hidden');
    resultEl.classList.remove('tree-mode');
    resultEl.innerHTML = '<div class="diff-table">' + rows.join('') + '</div>';
    statsEl.textContent =
      '相同 ' + sameCount + ' 行 · 左侧独有 ' + delCount +
      ' 行 · 右侧独有 ' + insCount + ' 行 · 修改 ' + modCount + ' 行';
  }

  // ---------- 自动提取 JSON + 树形对比（v0.33.0） ----------

  /** 格式化提取出的 JSON 值（固定 2 空格缩进，与面板缩进设置无关） */
  function pretty(v) {
    return JSON.stringify(v, null, 2);
  }

  /** 提取后用于对比的文本：严格提取 → 格式化；非严格片段 → 去转义原文；失败 → 原文 */
  function pickCompareText(extracted, fallback) {
    if (!extracted.ok) return fallback;
    return extracted.strict ? pretty(extracted.value) : extracted.text;
  }

  /** 树形对比视图：左右两棵可折叠树，差异节点高亮（绿 = 左侧独有 / 旧值，红 = 右侧独有 / 新值） */
  function renderTreeCompare(lv, rv) {
    const marks = window.JsonTree.diffMarks(lv, rv);
    // 先渲染到游离容器，任一超限则整体放弃（退回文本对比）
    const lBox = document.createElement('div');
    const rBox = document.createElement('div');
    if (!window.JsonTree.render(lBox, lv, { markSet: marks.left, markClass: 'jt-mark-l' }).ok ||
        !window.JsonTree.render(rBox, rv, { markSet: marks.right, markClass: 'jt-mark-r' }).ok) {
      return false;
    }
    resultEl.classList.add('tree-mode');
    resultEl.innerHTML = '';
    const cmp = document.createElement('div');
    cmp.className = 'jt-compare';
    const paneL = document.createElement('div');
    paneL.className = 'jt-compare-pane';
    const headL = document.createElement('div');
    headL.className = 'jt-pane-head left';
    headL.textContent = '左侧（旧）';
    paneL.appendChild(headL);
    lBox.className = 'json-tree-view jt-inline';
    paneL.appendChild(lBox);
    const paneR = document.createElement('div');
    paneR.className = 'jt-compare-pane';
    const headR = document.createElement('div');
    headR.className = 'jt-pane-head right';
    headR.textContent = '右侧（新）';
    paneR.appendChild(headR);
    rBox.className = 'json-tree-view jt-inline';
    paneR.appendChild(rBox);
    cmp.appendChild(paneL);
    cmp.appendChild(paneR);
    resultEl.appendChild(cmp);
    treeActionsEl.classList.remove('hidden');
    statsEl.textContent = '已自动提取 JSON 树形对比 · 差异 ' + marks.count + ' 处';
    resultText = '【左侧】\n' + pretty(lv) + '\n\n【右侧】\n' + pretty(rv);
    return true;
  }

  // ---------- 主流程 ----------

  function run() {
    const leftText = leftEl.value;
    const rightText = rightEl.value;

    if (!leftText && !rightText) {
      window.toast('请先输入需要对比的文本');
      return;
    }

    // 自动提取 JSON（可选）：从两侧文本中提取 JSON 片段并去转义
    let lText = leftText;
    let rText = rightText;
    let extractNote = '';
    if (extractCheck.checked) {
      const lJson = window.JsonTree.extractJson(leftText);
      const rJson = window.JsonTree.extractJson(rightText);
      lText = pickCompareText(lJson, leftText);
      rText = pickCompareText(rJson, rightText);
      if (lJson.ok || rJson.ok) {
        const sides = lJson.ok && rJson.ok ? '两侧' : (lJson.ok ? '左侧' : '右侧');
        const loose = (lJson.ok && !lJson.strict) || (rJson.ok && !rJson.strict);
        extractNote = ' · 已提取' + sides + ' ' + (loose ? '{…} 片段' : 'JSON');
      } else {
        window.toast('未在两侧文本中提取到 JSON，已按原文对比');
      }
      // 树形结构开关（仅勾选「自动提取 JSON」后显示）：两侧都提取到严格 JSON 时生效
      if (treeCheck.checked) {
        if (lJson.ok && lJson.strict && rJson.ok && rJson.strict) {
          if (renderTreeCompare(lJson.value, rJson.value)) {
            if (window.historyStore.add('diff', { left: leftText, right: rightText }) === 'too-large') {
              window.toast('内容过大，未加入历史记录');
            }
            return;
          }
          window.toast('JSON 过大，已按格式化文本对比');
        } else {
          window.toast('未能在两侧同时提取到有效 JSON，已按文本对比');
        }
      }
    }

    const aRaw = splitLines(lText);
    const bRaw = splitLines(rText);
    const ignore = ignoreWs.checked;
    const norm = ignore ? (s) => s.trim() : (s) => s;
    const aKeys = aRaw.map(norm);
    const bKeys = bRaw.map(norm);

    const ops = diffLines(aKeys, bKeys);
    const paired = pairModified(ops, aKeys, bKeys);

    if (paired.length === 0) {
      resultText = '';
      treeActionsEl.classList.add('hidden');
      resultEl.classList.remove('tree-mode');
      resultEl.innerHTML = '<div class="diff-empty">两段文本都为空</div>';
      statsEl.textContent = '';
      return;
    }

    renderResult(paired, aRaw, bRaw);
    if (extractNote && statsEl.textContent) statsEl.textContent += extractNote;

    // 写入对比历史记录（内容过大时提示并跳过；与最新一条重复时自动跳过）
    if (window.historyStore.add('diff', { left: leftText, right: rightText }) === 'too-large') {
      window.toast('内容过大，未加入历史记录');
    }
  }

  document.getElementById('diff-run').addEventListener('click', run);

  // 自动提取 JSON 开关：联动显示 / 隐藏「JSON 树形结构」子开关
  extractCheck.addEventListener('change', () => {
    treeWrap.classList.toggle('hidden', !extractCheck.checked);
  });

  // 树形视图：展开 / 折叠全部
  document.getElementById('diff-tree-expand').addEventListener('click', () => {
    resultEl.querySelectorAll('.json-tree-view').forEach((t) => window.JsonTree.expandAll(t));
  });
  document.getElementById('diff-tree-collapse').addEventListener('click', () => {
    resultEl.querySelectorAll('.json-tree-view').forEach((t) => window.JsonTree.collapseAll(t));
  });

  document.getElementById('diff-swap').addEventListener('click', () => {
    const tmp = leftEl.value;
    leftEl.value = rightEl.value;
    rightEl.value = tmp;
    if (resultEl.querySelector('.diff-table') || resultEl.querySelector('.jt-compare')) run();
  });

  document.getElementById('diff-clear').addEventListener('click', () => {
    leftEl.value = '';
    rightEl.value = '';
    resultText = '';
    statsEl.textContent = '';
    treeActionsEl.classList.add('hidden');
    resultEl.classList.remove('tree-mode');
    resultEl.innerHTML =
      '<div class="diff-empty">在上方输入两段文本后点击"对比"，差异处左侧显示绿色、右侧显示红色</div>';
  });

  // ---------- 复制 ----------

  document.getElementById('diff-copy-left').addEventListener('click', async () => {
    if (!leftEl.value) {
      window.toast('左侧文本为空');
      return;
    }
    await window.copyText(leftEl.value, '已复制左侧文本');
  });

  document.getElementById('diff-copy-right').addEventListener('click', async () => {
    if (!rightEl.value) {
      window.toast('右侧文本为空');
      return;
    }
    await window.copyText(rightEl.value, '已复制右侧文本');
  });

  document.getElementById('diff-copy-result').addEventListener('click', async () => {
    if (!resultText) {
      window.toast('暂无对比结果');
      return;
    }
    await window.copyText(resultText, '已复制对比结果');
  });

  // ---------- 历史记录 ----------

  window.historyStore.bindPanel({
    kind: 'diff',
    label: '对比记录',
    btn: document.getElementById('diff-history-btn'),
    pop: document.getElementById('diff-history-pop'),
    list: document.getElementById('diff-history-list'),
    clear: document.getElementById('diff-history-clear'),
    onRestore(rec) {
      leftEl.value = rec.left;
      rightEl.value = rec.right;
      run();
    },
  });
})();
