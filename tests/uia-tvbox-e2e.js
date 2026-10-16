/* TVBOX v0.58.0 真机 E2E（WebView2 CDP 远程调试）：
 * 面板结构 → 真实 tvbox_fetch 拉取饭太硬加密配置（IDN + okhttp UA + JPEG/`**`/Base64/JSONC 全链路）
 * → 多仓 lmw.json 导入 → 切换到饭太硬仓（解密配置加载）→ 加壳源友好报错 → 设置页 → 截图
 * 前置：应用以 WEBVIEW2_ADDITIONAL_BROWSER_ARGUMENTS=--remote-debugging-port=9222 启动
 * 用法：node tests/uia-tvbox-e2e.js [version]
 */
const fs = require('node:fs');
const path = require('node:path');

const VER = process.argv[2] || '0.58.0';
const PORT = Number(process.env.CDP_PORT || 9222);
const ROOT = path.join(__dirname, '..');
const sleep = (ms) => new Promise((r) => setTimeout(r, ms));

let msgId = 0;
function cdp(ws, method, params, timeoutMs = 8000) {
  const id = ++msgId;
  return new Promise((resolve, reject) => {
    const onMsg = (ev) => {
      let m;
      try { m = JSON.parse(ev.data); } catch { return; }
      if (m.id !== id) return;
      ws.removeEventListener('message', onMsg);
      clearTimeout(timer);
      m.error ? reject(new Error(method + ': ' + JSON.stringify(m.error))) : resolve(m.result);
    };
    const timer = setTimeout(() => { ws.removeEventListener('message', onMsg); reject(new Error(method + ': cdp timeout')); }, timeoutMs);
    ws.addEventListener('message', onMsg);
    ws.send(JSON.stringify({ id, method, params }));
  });
}
async function evaluate(ws, expression, timeoutMs = 15000) {
  const r = await cdp(ws, 'Runtime.evaluate', { expression, returnByValue: true, awaitPromise: true }, timeoutMs);
  if (r.exceptionDetails) throw new Error('evaluate: ' + JSON.stringify(r.exceptionDetails.exception));
  return r.result && r.result.value;
}
async function shot(ws, file) {
  try {
    try { await cdp(ws, 'Page.bringToFront', {}, 5000); } catch { /* best effort */ }
    await cdp(ws, 'Page.enable', {}, 10000);
    const s = await cdp(ws, 'Page.captureScreenshot', { format: 'png' }, 30000);
    fs.writeFileSync(path.join(ROOT, file), Buffer.from(s.data, 'base64'));
    console.log('SHOT|' + file);
  } catch (e) {
    // 截图仅为验证证据；窗口最小化等情况下 captureScreenshot 可能不可用，不影响断言结果
    console.log('SHOT-FAIL|' + file + '|' + e.message);
  }
}
async function poll(ws, expression, timeoutMs, stepMs = 700) {
  const end = Date.now() + timeoutMs;
  let last;
  while (Date.now() < end) {
    last = await evaluate(ws, expression);
    if (last) return last;
    await sleep(stepMs);
  }
  return last;
}

(async () => {
  let page = null;
  for (let i = 0; i < 60 && !page; i++) {
    try {
      const targets = await (await fetch('http://127.0.0.1:' + PORT + '/json/list')).json();
      page = targets.find((t) => t.type === 'page' && t.webSocketDebuggerUrl) || null;
    } catch { }
    if (!page) await sleep(500);
  }
  if (!page) { console.log('CDP-FAIL: no page target'); process.exit(1); }
  console.log('TARGET|' + page.title + '|' + page.url);

  const ws = new WebSocket(page.webSocketDebuggerUrl);
  await new Promise((res, rej) => { ws.addEventListener('open', res); ws.addEventListener('error', rej); });
  ws.addEventListener('close', () => { console.log('CDP-CLOSED: devtools session ended'); process.exit(3); });
  ws.addEventListener('error', () => { console.log('CDP-ERROR: devtools session error'); process.exit(3); });

  const fails = [];
  const T = (name, ok, actual) => { console.log((ok ? 'PASS|' : 'FAIL|') + name + '|' + String(actual).slice(0, 260)); if (!ok) fails.push(name); };
  const log = (name, actual) => console.log('INFO|' + name + '|' + String(actual).slice(0, 300));

  // 等启动层退出
  await poll(ws, `!document.getElementById('boot-splash')`, 8000);
  await sleep(400);

  // 1) 打开 TVBOX 面板（先回影视首页，避免上次会话残留视图）+ 结构断言
  await evaluate(ws, `document.querySelector('.nav-item[data-panel="tvbox"]').click(); true`);
  await sleep(300);
  await evaluate(ws, `document.getElementById('tv-home').click(); true`);
  await sleep(500);
  const ui = JSON.parse(await evaluate(ws, `(() => {
    const panel = document.getElementById('panel-tvbox');
    return JSON.stringify({
      active: panel.classList.contains('active'),
      view: panel.dataset.view,
      topbar: !!panel.querySelector('.tv-topbar'),
      navCount: panel.querySelectorAll('.tv-nav button').length,
      searchbarVisible: !!document.getElementById('tv-searchbar').offsetWidth,
      status: document.getElementById('tv-status').textContent.slice(0, 60),
      clusterLabel: !!panel.querySelector('.tv-topbar-sources .tv-cluster-label'),
      topbarSelects: panel.querySelectorAll('.tv-topbar-sources select').length,
      profileInSettings: !!document.getElementById('tv-settings-panel').querySelector('#tv-profile'),
      moreHidden: document.getElementById('tv-controls-more').classList.contains('hidden'),
    });
  })()`));
  T('panel active', ui.active === true, ui.view + '/' + ui.topbar);
  T('nav 6 buttons + topbar', ui.navCount === 6 && ui.topbar === true, 'nav=' + ui.navCount);
  T('home view + searchbar visible', ui.view === 'home' && ui.searchbarVisible === true, ui.view + '/' + ui.searchbarVisible);
  T('compact topbar (label + filter + one site select)', ui.clusterLabel === true && ui.topbarSelects === 1, 'label=' + ui.clusterLabel + ' selects=' + ui.topbarSelects);
  T('profile select moved into settings', ui.profileInSettings === true, String(ui.profileInSettings));
  T('player extras collapsed by default', ui.moreHidden === true, String(ui.moreHidden));

  // 2) 真实拉取饭太硬加密配置（Rust 侧：IDN + okhttp UA + 图片外壳解密），并在页面内按 TVBoxCore 规则解析
  const conf = JSON.parse(await evaluate(ws, `window.__TAURI__.core.invoke('tvbox_fetch', { url: 'https://www.饭太硬.cc/tv' }).then(t => { try { const c = window.TVBoxCore.json(t); return JSON.stringify({ head: t.slice(0, 40), sites: (c.sites || []).length, lives: (c.lives || []).length, first: (c.sites || [])[0] && (c.sites[0].api || '') }); } catch (e) { return JSON.stringify({ head: t.slice(0, 60), error: String(e) }); } })`, 45000));
  T('encrypted 饭太硬 config decrypted via Rust', conf.sites >= 45 && conf.lives >= 4 && !conf.error, JSON.stringify(conf));

  // 3) 多仓 lmw.json 导入（使用用户实际的 catvod 代理地址；网络抖动时重试一次点击）
  await evaluate(ws, `(() => { const el = document.getElementById('tv-config-url'); el.value = 'https://github.catvod.com/https://raw.githubusercontent.com/tushen6/Tomorrow/master/lmw.json'; return true; })()`);
  await evaluate(ws, `document.getElementById('tv-load').click(); true`);
  await sleep(4000);
  if (String(await evaluate(ws, `document.getElementById('tv-status').textContent`)).includes('连接失败')) {
    log('import retry', 'first load hit a network error, retrying once');
    await evaluate(ws, `document.getElementById('tv-load').click(); true`);
  }
  const imported = JSON.parse(await poll(ws, `(() => {
    const prof = document.getElementById('tv-profile');
    if (prof.options.length < 10) return null;
    return JSON.stringify({ profiles: prof.options.length, sites: document.getElementById('tv-site').options.length });
  })()`, 90000, 1500) || '{}');
  T('lmw.json multi-warehouse imported (>=10 profiles)', Number(imported.profiles) >= 10, JSON.stringify(imported));

  // 首仓浏览海报为网络依赖项：记录结果（源站波动时不断言失败）
  const cards = await poll(ws, `document.getElementById('tv-results').querySelectorAll('.tv-card').length`, 45000, 1500);
  log('first repo posters', 'cards=' + cards + ' status=' + (await evaluate(ws, `document.getElementById('tv-status').textContent.slice(0,150)`)));
  await shot(ws, `_uia-tvbox-home-v${VER}.png`);

  // 4) 切换到「饭太硬」仓：解密配置加载 + 49 个源
  const hasFty = await evaluate(ws, `[...document.getElementById('tv-profile').options].some(o => o.textContent.includes('饭太硬'))`);
  T('饭太硬 profile present', hasFty === true, String(hasFty));
  await evaluate(ws, `(() => {
    const prof = document.getElementById('tv-profile');
    const opt = [...prof.options].find(o => o.textContent.includes('饭太硬'));
    prof.value = opt.value; prof.dispatchEvent(new Event('change'));
    return true;
  })()`);
  const fty = JSON.parse(await poll(ws, `(() => {
    const site = document.getElementById('tv-site');
    if (site.options.length >= 40) return JSON.stringify({ sites: site.options.length });
    if (site.options.length > 0 && document.getElementById('tv-status').textContent.includes('失败')) return JSON.stringify({ sites: site.options.length, failed: true });
    return null;
  })()`, 60000, 1500) || '{}');
  T('饭太硬 decrypted config gives ~49 sites', Number(fty.sites) >= 40, JSON.stringify(fty));

  // 5) 选择一个受保护（Guard / ftyguard 加壳）源：桌面端应自动离线解包，不再提示无法运行
  await evaluate(ws, `(() => {
    const site = document.getElementById('tv-site');
    site.value = site.options[0].value; site.dispatchEvent(new Event('change'));
    return true;
  })()`);
  const guardResult = JSON.parse(await poll(ws, `(() => {
    const t = document.getElementById('tv-status').textContent;
    if (t.includes('无法运行')) return JSON.stringify({ blocked: t });
    if (t.includes('加载中') || t.trim() === '') return null;
    return JSON.stringify({ t: t.slice(0, 120) });
  })()`, 120000, 1200) || '{}');
  T('ftyguard jar unwraps offline (no ARM runtime error)', guardResult.blocked === undefined && guardResult.t !== undefined, JSON.stringify(guardResult));
  await shot(ws, `_uia-tvbox-fantaiying-v${VER}.png`);

  // 6) 设置页视图切换 + 截图
  await evaluate(ws, `document.getElementById('tv-settings-tab').click(); true`);
  await sleep(400);
  const settings = JSON.parse(await evaluate(ws, `(() => {
    const panel = document.getElementById('panel-tvbox');
    return JSON.stringify({
      view: panel.dataset.view,
      settingsShown: !document.getElementById('tv-settings-panel').classList.contains('hidden'),
      libraryHidden: document.getElementById('tv-library').classList.contains('hidden'),
      sourcesHidden: getComputedStyle(panel.querySelector('.tv-topbar-sources')).display === 'none',
    });
  })()`));
  T('settings view toggles cleanly', settings.view === 'settings' && settings.settingsShown && settings.libraryHidden && settings.sourcesHidden, JSON.stringify(settings));
  await shot(ws, `_uia-tvbox-settings-v${VER}.png`);

  console.log('----');
  console.log('TOTAL=' + (fails.length === 0 ? 'ALL-PASS' : 'FAIL=' + fails.length) + '|' + fails.join(','));
  ws.close();
  process.exit(fails.length ? 1 : 0);
})().catch((e) => { console.log('E2E-ERROR|' + e.message); process.exit(2); });
