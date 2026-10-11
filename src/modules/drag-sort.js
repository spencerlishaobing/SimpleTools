/* 列表拖拽排序（笔记 / 任务 / 账号分组 / 账号条目共用）
 *
 * v0.33.0 空位跟随模型：
 * - 拖起后源行原位变为虚线「空位」框（子内容淡出），空位随 dragover 实时移动到目标插入点；
 * - 其余行以 FLIP 过渡平滑让位，全程无循环闪动动画；
 * - 松开按最新 DOM 顺序落盘（onDrop），取消（ESC、拖出窗口）自动滑回原位。
 *
 * 用法：window.DragSort.init({ listEl, itemSelector, handleSelector?, canStart?, onDrop?, onPreviewOrder? })
 * - handleSelector：限定拖拽发起区（账号条目行仅手柄可发起）
 * - canStart(e, li)：追加发起条件，返回 false 时禁止该行发起拖拽
 * - onDrop(el, newIndex)：松开回调；newIndex 为最新 DOM 顺序下标，直接用于数据层 splice 落盘
 * - onPreviewOrder()：空位每次移动后回调（用于依赖顺序的轻量刷新，如任务自动序号）
 */
(function () {
  'use strict';

  const MOVE_MS = 170;                                          // 空位移动 / 让位过渡时长
  const FLIP_TRANSITION = 'transform ' + (MOVE_MS / 1000) + 's ease';

  // 直接子项（过滤空态提示等非条目节点）
  function directItems(listEl, itemSelector) {
    return Array.from(listEl.children).filter((el) => el.matches(itemSelector));
  }

  // FLIP：记录重排前位置 -> mutate 重排 -> 位移行倒置补偿并播放过渡
  function flip(listEl, itemSelector, mutate) {
    const items = directItems(listEl, itemSelector);
    // 清掉上一轮可能残留的内联动画样式，让测量落在真实布局位置上
    items.forEach((el) => {
      if (el.style.transform) {
        el.style.transition = 'none';
        el.style.transform = '';
      }
    });
    void listEl.offsetHeight;
    const before = new Map();
    items.forEach((el) => before.set(el, el.getBoundingClientRect().top));
    mutate();
    let moved = false;
    items.forEach((el) => {
      const dy = before.get(el) - el.getBoundingClientRect().top;
      if (Math.abs(dy) < 1) return;
      moved = true;
      el.style.transition = 'none';
      el.style.transform = 'translateY(' + dy + 'px)';
    });
    if (!moved) return;
    void listEl.offsetHeight;                                   // 让倒置样式先落地，再开始过渡
    items.forEach((el) => {
      if (!el.style.transform) return;
      el.style.transition = FLIP_TRANSITION;
      el.style.transform = '';
    });
    // 动画结束后清掉内联过渡（跳过期间又开始新动画的元素），恢复样式表过渡语义
    setTimeout(() => {
      items.forEach((el) => {
        if (!el.style.transform) el.style.transition = '';
      });
    }, MOVE_MS + 60);
  }

  function init(opts) {
    const listEl = opts.listEl;
    const itemSelector = opts.itemSelector;
    const handleSelector = opts.handleSelector || null;
    const canStart = opts.canStart || null;
    const onDrop = opts.onDrop || null;
    const onPreviewOrder = opts.onPreviewOrder || null;

    let dragEl = null;        // 当前拖拽行（= 列表中的虚线空位）
    let startNext = null;     // 拖起时源行的下一兄弟（取消时恢复原位用）
    let dropped = false;

    // 移动空位：把 dragEl 插到目标行前 / 后（已就位时直接跳过）
    function moveTo(li, beforeItem) {
      if (!dragEl || li === dragEl || !li.isConnected) return;
      if (beforeItem ? li.previousElementSibling === dragEl : li.nextElementSibling === dragEl) return;
      flip(listEl, itemSelector, () => {
        if (beforeItem) listEl.insertBefore(dragEl, li);
        else listEl.insertBefore(dragEl, li.nextElementSibling);
      });
      if (onPreviewOrder) onPreviewOrder();
    }

    listEl.addEventListener('dragstart', (e) => {
      const li = e.target.closest(itemSelector);
      if (!li || !listEl.contains(li)) return;
      if (handleSelector && !e.target.closest(handleSelector)) return;
      if (canStart && !canStart(e, li)) {
        e.preventDefault();
        return;
      }
      dragEl = li;
      startNext = li.nextElementSibling;
      dropped = false;
      if (e.dataTransfer) {
        e.dataTransfer.effectAllowed = 'move';
        e.dataTransfer.setData('text/plain', li.dataset.id || '');
      }
      // 等浏览器抓完拖拽快照（原样行）后再切换虚线空位，避免快照带上拖拽样式；
      // 无头环境无渲染帧，rAF 可能不调度，用 setTimeout 兜底（幂等，真机上 rAF 先执行）
      const mark = () => {
        if (dragEl === li && li.isConnected) li.classList.add('dragging');
      };
      requestAnimationFrame(mark);
      setTimeout(mark, 30);
    });

    listEl.addEventListener('dragover', (e) => {
      if (!dragEl) return;
      e.preventDefault();
      if (e.dataTransfer) e.dataTransfer.dropEffect = 'move';
      const li = e.target.closest(itemSelector);
      if (li === dragEl) return;
      if (!li || !listEl.contains(li)) {
        // 拖到列表空白：贴到最前 / 最后
        const items = directItems(listEl, itemSelector);
        const first = items[0];
        const last = items[items.length - 1];
        if (!first || first === dragEl) return;
        const fr = first.getBoundingClientRect();
        const lr = last.getBoundingClientRect();
        if (e.clientY < fr.top + fr.height / 2) moveTo(first, true);
        else if (e.clientY > lr.top + lr.height / 2) moveTo(last, false);
        return;
      }
      const rect = li.getBoundingClientRect();
      moveTo(li, e.clientY - rect.top < rect.height / 2);
    });

    listEl.addEventListener('drop', (e) => {
      if (!dragEl) return;
      e.preventDefault();
      // 快速拖放（dragover 未及重排）时，按松开位置先把空位校到位
      const li = e.target.closest(itemSelector);
      if (li && li !== dragEl && listEl.contains(li)) {
        const rect = li.getBoundingClientRect();
        moveTo(li, e.clientY - rect.top < rect.height / 2);
      }
      if (dropped) return;
      dropped = true;
      const el = dragEl;
      dragEl = null;
      startNext = null;
      const newIndex = directItems(listEl, itemSelector).indexOf(el);
      if (onDrop && newIndex >= 0) onDrop(el, newIndex);
      el.classList.remove('dragging');
    });

    listEl.addEventListener('dragend', () => {
      if (!dragEl || dropped) return;
      const el = dragEl;
      const ref = startNext && startNext.parentNode === listEl ? startNext : null;
      dragEl = null;
      startNext = null;
      if (!el) return;
      if (el.parentNode === listEl) {
        // 从预览位置滑回原位（同样走 FLIP 过渡）
        flip(listEl, itemSelector, () => {
          listEl.insertBefore(el, ref);
        });
        if (onPreviewOrder) onPreviewOrder();
      }
      el.classList.remove('dragging');
    });
  }

  window.DragSort = { init: init };
})();
