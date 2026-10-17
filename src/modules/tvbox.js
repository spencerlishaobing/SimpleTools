(function () {
  'use strict';
  const C=window.TVBoxCore, $=id=>document.getElementById('tv-'+id);
  const invoke=window.__TAURI__?.core?.invoke, dialog=window.__TAURI__?.dialog;
  const OLD_KEY='simpletools-tvbox';
  let db={profiles:[],profileId:'',history:[],favorites:[],unmatched:{},searchHistory:[],sourceHealth:{},prefs:{resume:true,autoNext:true,speed:1,volume:100,skipIntro:0,skipOutro:0,hwdec:'auto-safe',selfParser:false,liveTimeout:15}};
  let page=1,keyword='',filters={},homeData={},homeSeed={site:'',data:null},view='home',generation=0,playGeneration=0,saveTimer,saveQueue=Promise.resolve();
  let liveChannels=[],liveView=[],liveSources=null,liveCurrent='',liveGroup='',current=null,queue=null,sniffPending=null,lastSave=0,trackSignature='',busyPoll=false;
  let searchPanelOpen=false;
  // 程序化修改站点下拉时置位，避免 value 赋值触发的 change 把 remembered 源覆盖（WebView2 行为差异）
  let siteProgrammatic=false;
  let xsearch={word:'',groups:[],profileId:'',done:0,total:0,running:false,token:0};
  let statusTimer=null;
  const status=message=>{
    const node=$('status');node.textContent=message;node.classList.remove('is-idle');
    clearTimeout(statusTimer);
    // 结果类消息自动淡出，进行中/播放中的消息保持可见
    if(!/正在|加载中|播放中/.test(String(message)))statusTimer=setTimeout(()=>node.classList.add('is-idle'),8000);
  };
  // 全局加载框（复用 main.js 的 #app-loading）：超过 250ms 才显示，快速操作不闪烁；
  // 嵌套调用按深度计数，最外层结束时才隐藏
  let loadingDepth=0,loadingLabel='';
  function beginLoading(text){
    loadingDepth++;
    if(text)loadingLabel=text;
    window.showLoading?.(loadingLabel||'加载中…');
  }
  function endLoading(){
    loadingDepth=Math.max(0,loadingDepth-1);
    if(loadingDepth)return;
    loadingLabel='';window.hideLoading?.();
  }
  async function withLoading(fn,text){
    beginLoading(text);
    try{return await fn();}finally{endLoading();}
  }
  // 播放器起播等待提示：只显示在视频区内（隐藏 mpv 子窗口让提示可见）+ 控制条转圈，
  // 不使用全屏遮罩——加载期间仍可在下方列表切换频道/直播源；loaded/失败/关闭时结束，30 秒兜底
  let playLoading=false,playLoadingTimer=null;
  function playingVideoArea(){return document.getElementById('panel-tvbox').classList.contains('tv-player-mode');}
  function beginPlayLoading(text){
    if(playLoading)endPlayLoading(); // 换台/换集：先结束上一轮，避免计数泄漏
    playLoading=true;$('buffer').classList.remove('hidden');
    $('surface-loading-text').textContent=text||'正在加载视频…';
    $('surface-loading').classList.remove('hidden');
    // mpv 渲染在原生子窗口上（会挡住 WebView 提示）：加载期间先隐藏子窗口，loaded 后再显示画面
    if($('engine').value!=='web')hideSurface();
    clearTimeout(playLoadingTimer);
    // 直播超时较短（15 秒，对齐 Android 换源习惯），点播 30 秒
    playLoadingTimer=setTimeout(()=>{
      if(!playLoading)return;
      const wasLive=!!current?.meta?.live;
      endPlayLoading();
      if(wasLive){status('直播源连接超时，尝试切换…');run(()=>liveSwitchNext());}
      else status('视频加载较慢，仍在尝试连接…');
    },current?.meta?.live?(Math.max(5,Math.min(30,Number(db.prefs.liveTimeout)||15))*1000):30000);
  }
  function endPlayLoading(){
    if(!playLoading)return;playLoading=false;clearTimeout(playLoadingTimer);
    $('buffer').classList.add('hidden');
    $('surface-loading').classList.add('hidden');
    // 显示 mpv 子窗口（如果仍在播放界面且没有新的加载在等）
    if($('engine').value!=='web')setTimeout(()=>{if(!playLoading&&playingVideoArea())syncSurface();},80);
  }
  const profile=()=>db.profiles.find(p=>p.id===db.profileId) || {id:'',config:{},base:'',name:''};
  const config=()=>profile().config || {};
  const sites=()=>Array.isArray(config().sites)?config().sites:[];
  const stamp=()=>Date.now().toString(36)+'-'+Math.random().toString(36).slice(2,8);
  const time=seconds=>{const n=Math.max(0,Math.floor(Number(seconds)||0));return (n>=3600?Math.floor(n/3600)+':':'')+String(Math.floor(n/60)%60).padStart(2,'0')+':'+String(n%60).padStart(2,'0');};
  function persist(immediate=false) {
    clearTimeout(saveTimer);
    const save=()=>{
      const data=JSON.parse(JSON.stringify(db));
      if (invoke) saveQueue=saveQueue.catch(()=>{}).then(()=>invoke('tvbox_save',{data})).catch(e=>status('保存 TVBOX 数据失败：'+e));
      else { try { localStorage.setItem(OLD_KEY,JSON.stringify(data)); } catch(e) { status('保存失败：'+e); } }
      return saveQueue;
    };
    if(immediate)return save(); saveTimer=setTimeout(save,300);
  }
  async function run(fn) { try { await fn(); } catch(e) { endPlayLoading(); status(String(e?.message||e)); } }
  function el(tag,text,className) { const node=document.createElement(tag);if(text!==undefined)node.textContent=text;if(className)node.className=className;return node; }
  function button(text,fn,className) {const b=el('button',text,className);b.onclick=()=>run(fn);return b;}
  function option(select,value,label) {const o=el('option',label);o.value=String(value);select.append(o);}
  function address(value,base=profile().base) {return C.url(value,base);}
  async function fetchText(url,headers={}) {
    if(!invoke)throw Error('请在 SimpleTools 桌面应用中使用');
    if(url.startsWith('file:')) {let path=decodeURIComponent(new URL(url).pathname).replace(/^\/([a-z]:)/i,'$1');return (await invoke('read_text_file',{path})).content;}
    return invoke('tvbox_fetch',{url,headers});
  }
  function selectedSite(){const s=sites()[Number($('site').value)];if(!s)throw Error('请先加载配置并选择片源');if(!C.supported(s))throw Error('无法识别此片源的接口类型');return s;}
  // ===== 本地解析策略：内置站点爬虫（resources/tvspiders）优先；JAR 自带解析需在设置中开启「源自带解析兼容」 =====
  let adapters=null;
  async function ensureAdapters(){
    if(adapters!==null)return adapters;
    adapters=[];
    if(invoke){try{const reg=await invoke('tvspiders_registry');adapters=(reg&&Array.isArray(reg.sites))?reg.sites.filter(a=>a&&a.url&&Array.isArray(a.match)):[];}catch(_){adapters=[];}}
    return adapters;
  }
  function localAdapter(s){
    const key=String(s.api||'').replace(/^csp_/i,'').replace(/Guard$/i,'');
    const name=String(s.name||'');
    const extText=typeof s.ext==='string'?s.ext:JSON.stringify(s.ext||'');
    for(const adapter of adapters||[])for(const term of adapter.match){const t=String(term||'').trim();if(t&&(key.includes(t)||name.includes(t)||extText.includes(t)))return adapter;}
    return null;
  }
  const unmatchedSeen=new Set();
  // 未适配站点记录（保存到 tvbox.json 的 unmatched）：版本升级时据此逐个适配
  function noteUnmatched(s){
    const key=s.key||s.api||s.name;if(!key||unmatchedSeen.has(key))return;unmatchedSeen.add(key);
    db.unmatched=db.unmatched&&typeof db.unmatched==='object'?db.unmatched:{};
    db.unmatched[key]={name:s.name||'',api:String(s.api||''),ext:typeof s.ext==='string'?s.ext.slice(0,800):s.ext,time:Date.now()};
    persist();updateUnmatchedInfo();
  }
  function updateUnmatchedInfo(){
    const node=$('unmatched');if(!node)return;
    const n=Object.keys(db.unmatched||{}).length;
    node.textContent=n?`未适配站点：${n} 个（已记录，将在后续版本适配）`:`本地解析：全部已适配 ✓`;
  }
  async function apiRaw(s,action,args={},p=profile()) {
    if(Number(s.type)===3) {
      let ext=s.ext ?? '';if(typeof ext==='string'&&/^[{[]/.test(ext.trim())){try{ext=C.json(ext);}catch(_){/* plain extension */}}
      if(typeof ext==='string'&&/^\.\.?\//.test(ext))ext=address(ext,p.base);
      const sourceApi=String(s.api).split(';')[0];
      const isJs=/\.js(?:[?#]|$)/i.test(sourceApi),isPy=/\.py(?:[?#]|$)/i.test(sourceApi);
      // 1) 内置本地爬虫优先（毫秒级，无 JVM / DEX 转换）
      if(!isJs&&!isPy){
        await ensureAdapters();
        const adapter=localAdapter(s);
        if(adapter){
          // 已适配站点从待适配清单移除（之前记录过或旧版本遗留）
          const siteKey=s.key||s.api||s.name;
          if(siteKey&&db.unmatched&&db.unmatched[siteKey]){delete db.unmatched[siteKey];persist();updateUnmatchedInfo();}
          return invoke('tvbox_spider',{api:adapter.url,key:s.key||s.name||'local',ext,action,args:{...args,flags:p.config.flags||[]}});
        }
      }
      // 2) JS / Python 脚本源本身就是轻量解析器，直接运行
      if(isJs)return invoke('tvbox_spider',{api:address(sourceApi,p.base),key:s.key||s.name||'js',ext,action,args:{...args,flags:p.config.flags||[]}});
      let jar=s.jar||p.config.spider||'';
      if(jar){const parts=jar.split(';md5;');parts[0]=address(parts[0],p.base);jar=parts.join(';md5;');}
      if(isPy){
        status('正在运行 Python 片源…');
        return invoke('tvbox_external',{api:address(sourceApi,p.base),jar:jar||null,key:s.key||s.name||'source',ext,action,args:{...args,flags:p.config.flags||[]}});
      }
      // 3) JAR 自带解析（慢）：未适配站点先记录；默认策略下提示可开启自带解析
      noteUnmatched(s);
      if(!db.prefs.selfParser)throw Error(`「${s.name||'该站点'}」暂未适配本地解析（已记录到待适配清单）；可在设置中勾选「源自带解析兼容」使用片源自带爬虫`);
      status('正在加载 JAR 片源（同一 JAR 仅首次转换，之后所有源共享缓存）…');
      return invoke('tvbox_external',{api:sourceApi,jar:jar||null,key:s.key||s.name||'source',ext,action,args:{...args,flags:p.config.flags||[]}});
    }
    const data=await fetchText(C.request(s,action,args,p.base),s.header||s.headers||{});
    return action==='play'?C.json(data):C.response(data,s.type);
  }
  // ===== 源健康度（借鉴 LibreTV）：连续失败 3 次阶梯停用（30 分钟 → 24 小时 → 7 天），
  // 搜索时跳过冷却中的源，避免反复打坏源；设置页可一键恢复
  const HEALTH_LEVELS=[30*60*1000,24*60*60*1000,7*24*60*60*1000];
  function sourceKey(s,p=profile()){return `${p.id}:${s.key||s.api||s.name}`;}
  function isSourceCooling(key){const entry=db.sourceHealth&&db.sourceHealth[key];return !!(entry&&entry.until&&entry.until>Date.now());}
  function recordSourceResult(key,ok){
    if(!key)return;
    db.sourceHealth=db.sourceHealth&&typeof db.sourceHealth==='object'?db.sourceHealth:{};
    const prev=db.sourceHealth[key]||{fails:0,until:0,level:0};
    if(ok){db.sourceHealth[key]={fails:0,until:0,level:0};persist();updateHealthInfo();return;}
    const fails=(prev.fails||0)+1;
    if(fails>=3){
      const level=Math.min(Math.max(prev.level||0,0)+1,3);
      const until=Date.now()+HEALTH_LEVELS[level-1];
      db.sourceHealth[key]={fails:0,until,level};
      status(`源连续失败，已暂停 ${level===1?'30 分钟':level===2?'24 小时':'7 天'}（设置页可恢复）`);
    }else db.sourceHealth[key]={fails,until:prev.until||0,level:prev.level||0};
    persist();updateHealthInfo();
  }
  function coolingSourceCount(){
    const p=profile();let count=0;
    (sites()||[]).forEach(s=>{if(isSourceCooling(sourceKey(s,p)))count++;});
    return count;
  }
  function updateHealthInfo(){
    const node=$('health-info');if(!node)return;
    const count=coolingSourceCount();
    node.textContent=count?`源健康：${count} 个源冷却中`:'源健康：正常';
  }
  function resetSourceHealth(){
    db.sourceHealth={};persist();updateHealthInfo();status('已恢复所有源的可用状态，源健康计数已重置');
  }
  // 请求包装：统一记录源健康度（本地未适配/配置问题不计入网络失败）
  async function api(s,action,args={},p=profile()) {
    const key=sourceKey(s,p);
    try{const result=await apiRaw(s,action,args,p);recordSourceResult(key,true);return result;}
    catch(error){const message=String(error&&error.message||error);if(!/暂未适配/.test(message))recordSourceResult(key,false);throw error;}
  }
  function switchView(next) {
    const prev=view;view=next;generation++;
    searchPanelOpen=false;
    const panel=document.getElementById('panel-tvbox');panel.dataset.view=next;panel.classList.remove('tv-detail-mode');
    // 集成式播放区域（v0.58.4）：播放中切换导航不再退出视频区，视频继续在列表上方播放，
    // 关闭播放统一由「关闭视频区」按钮或播放结束触发
    $('settings-panel').classList.add('hidden');$('library').classList.remove('hidden');$('settings-tab').classList.remove('is-selected');$('detail-back').classList.add('hidden');$('clear-history').classList.toggle('hidden',next!=='history');
    for(const key of ['home','live','favorites','history'])$(key).classList.toggle('is-selected',next===key);
    $('find').classList.remove('is-selected');
    $('section-title').textContent=({home:'影视',live:'电视直播',favorites:'我的收藏',history:'观看记录'})[next]||'影视';
    $('onboarding').classList.toggle('hidden',next!=='home'||sites().length>0||(config().lives||[]).length>0);
    $('detail').replaceChildren();$('epg').replaceChildren();$('filters').replaceChildren();$('categories').replaceChildren();
    // 搜索框按视图区分用途：影视搜片名，直播筛频道，互不串台（直播过滤词不会带进影视搜索）
    if(next!=='home'||prev==='live')$('keyword').value='';
    $('keyword').placeholder=next==='live'?'输入频道名筛选…':'输入片名搜索…';
    renderSidenav();
  }
  function renderSiteOptions(term='') {
    const select=$('site'),previous=select.value,word=term.trim().toLowerCase();select.replaceChildren();
    sites().forEach((s,i)=>{
      if(word&&!`${s.name||''} ${s.key||''} ${s.api||''}`.toLowerCase().includes(word))return;
      option(select,i,`${C.supported(s)?'':'[环境不兼容] '}${s.name||s.key||'片源'}`);
    });
    select.disabled=!select.options.length;
    if(select.options.length)select.value=Array.from(select.options).some(o=>o.value===previous)?previous:select.options[0].value;
    return select.options.length;
  }
  function setup() {
    const p=profile();$('profile').replaceChildren();db.profiles.forEach(p=>option($('profile'),p.id,p.name));$('profile').value=p.id;
    $('profile-name').value=p.name;const configUrl=p.collectionBase||p.base;$('config-url').value=configUrl.startsWith('http')?configUrl:'';
    $('config-editor').value=p.id?JSON.stringify(config(),null,2):'';
    $('site-filter').value='';renderSiteOptions();
    // 让下拉与已记住的片源保持一致（部分环境下 options 重建会触发 change，可能把 selectedSite 改错）
    const remembered=sites().findIndex(s=>s.key===db.selectedSite||s.api===db.selectedSite||s.name===db.selectedSite);
    if(remembered>=0){siteProgrammatic=true;$('site').value=String(remembered);setTimeout(()=>{siteProgrammatic=false;},0);}
    $('parser').replaceChildren();option($('parser'),'auto','自动解析');option($('parser'),'direct','只播直链');
    (config().parses||[]).forEach((p,i)=>option($('parser'),i,p.name||`解析 ${i+1}`));
    $('category').replaceChildren();$('results').replaceChildren();homeData={};filters={};page=1;keyword='';lastBrowseHadMore=false;loadMoreBusy=false;
    // 切仓后直播缓存失效：内置源保留，当前仓的 lives 重新懒加载
    liveSources=null;liveCurrent='';liveChannels=[];liveView=[];liveGroup='';
    $('prev').disabled=$('next').disabled=true;switchView('home');
    updateUnmatchedInfo();ensureAdapters().then(updateUnmatchedInfo).catch(()=>{});
    status(p.id?`${sites().length} 个点播源 · 已保存到应用数据目录。选择片源或进入直播。`:'加载或导入 TVBox 配置，也可以直接播放本地或网络视频。');
  }
  function applyPreferences() {
    for(const [id,key] of [['resume','resume'],['auto-next','autoNext']])$(id).checked=db.prefs[key]!==false;
    for(const [id,key] of [['speed','speed'],['volume','volume'],['skip-intro','skipIntro'],['skip-outro','skipOutro'],['hwdec','hwdec']])$(id).value=String(db.prefs[key]??'');
    $('self-parser').checked=db.prefs.selfParser===true;
    $('live-timeout').value=String(db.prefs.liveTimeout??15);
    updateHealthInfo();
  }
  const hasSources=conf=>conf&&(Array.isArray(conf.sites)||Array.isArray(conf.lives));
  async function loadCollectionProfile(p) {
    if(hasSources(p.config))return;
    beginLoading(`正在加载「${p.name}」配置…`);
    try{
      const clean=String(await fetchText(p.base)).replace(/^\uFEFF/,'').trim();
      if(!clean.startsWith('{'))throw Error(`「${p.name}」没有返回 TVBox JSON 配置`);
      const conf=C.json(clean);
      if(!hasSources(conf))throw Error(`「${p.name}」配置缺少 sites 或 lives 数组`);
      p.config=conf;await persist(true);
    }finally{endLoading();}
  }
  async function importCollection(conf,base) {
    beginLoading('正在导入多仓配置…');
    try{
      const entries=[];
      for(const [index,item] of conf.urls.entries()){
        const value=typeof item==='string'?item:item?.url||item?.api;
        if(!value)continue;
        try{
          const url=address(value,base);
          if(!entries.some(e=>e.url===url))entries.push({url,name:String(item?.name||`配置 ${index+1}`)});
        }catch(_){/* skip invalid collection entry */}
      }
      if(!entries.length)throw Error('多仓配置没有有效的配置地址');
      const profiles=entries.map(({url,name})=>{
        let p=db.profiles.find(p=>p.collectionBase===base&&p.base===url);
        if(p){p.name=name;return p;}
        p={id:stamp(),name,base:url,collectionBase:base,config:{}};db.profiles.push(p);return p;
      });
      db.profileId=profiles[0].id;await persist(true);setup();
      let lastError;
      for(const p of profiles){
        beginLoading(`正在加载「${p.name}」…（共 ${profiles.length} 个仓）`);
        try{
          await loadCollectionProfile(p);
        }catch(e){lastError=e;}finally{endLoading();}
        if(!hasSources(p.config))continue;
        db.profileId=p.id;await persist(true);setup();
        let browseError='';
        if(sites().some(C.supported))try{await browse(true);}catch(e){browseError=String(e?.message||e);}
        status(`已导入 ${profiles.length} 个配置仓 · 当前：${p.name}${browseError?' · 首页加载失败：'+browseError:''}`);return;
      }
      throw Error(`已导入 ${profiles.length} 个配置仓，但暂时无法加载：${lastError?.message||'网络连接失败'}`);
    }finally{endLoading();}
  }
  async function importConfig(text,base='',name='') {
    beginLoading('正在加载配置…');
    try{
      const clean=String(text).replace(/^\uFEFF/,'').trim();
      const conf=clean.startsWith('{')?C.json(clean):{lives:[{name:name||'导入直播',channels:C.playlist(clean,base).map(c=>({...c,urls:[c.url]}))}]};
      if(conf&&!hasSources(conf)&&Array.isArray(conf.urls))return importCollection(conf,base);
      if(!hasSources(conf))throw Error('配置需包含 sites、lives 或 urls 数组');
      if(!clean.startsWith('{')&&!conf.lives[0].channels.length)throw Error('未找到有效频道，支持 M3U 与“频道名,地址”列表');
      let p=db.profiles.find(p=>base&&p.base===base);
      if(p){p.config=conf;if(name)p.name=name;}
      else {p={id:stamp(),name:name||conf.name||`配置 ${db.profiles.length+1}`,base,config:conf};db.profiles.push(p);}
      db.profileId=p.id;await persist(true);setup();
      if(sites().some(C.supported))await browse(true);
    }finally{endLoading();}
  }
  function renderFilters() {
    $('filters').replaceChildren();const groups=homeData.filters?.[$('category').value]||[];
    for(const group of groups) {
      const label=el('label',group.name||group.key),select=el('select');select.setAttribute('aria-label',group.name||group.key);
      (group.value||[]).forEach(v=>option(select,v.v,v.n));select.value=filters[group.key]??group.init??'';
      select.onchange=()=>run(()=>{filters[group.key]=select.value;page=1;return browse();});label.append(select);$('filters').append(label);
    }
  }
  // 左侧分组导航（左右布局）：影视 = 分类列；直播 = 直播源列 + 分组列（多层分组多列）
  function renderSidenav(){
    const nav=$('sidenav');if(!nav)return;
    nav.replaceChildren();
    if(view==='live'){
      const sources=ensureLiveSources();
      const sourceCol=el('div',undefined,'tv-nav-col');
      sources.forEach(s=>{const b=button(s.name,()=>run(()=>loadLiveSource(s.id)));b.classList.toggle('is-selected',s.id===liveCurrent);sourceCol.append(b);});
      nav.append(sourceCol);
      const groups=[...new Set(liveChannels.map(c=>c.group).filter(Boolean))];
      if(groups.length){
        const col=el('div',undefined,'tv-nav-col');
        const all=button('全部分组',()=>{liveGroup='';renderLive();});all.classList.toggle('is-selected',!liveGroup);col.append(all);
        groups.forEach(g=>{const b=button(g,()=>{liveGroup=g;renderLive();});b.classList.toggle('is-selected',liveGroup===g);col.append(b);});
        nav.append(col);
      }
    }else if(view==='xsearch'){
      const col=el('div',undefined,'tv-nav-col');
      // 第一项「全部」：聚合所有仓的搜索结果（参考 Android 全源搜索）
      const total=xsearch.groups.reduce((n,g)=>n+g.count,0);
      const all=button(`全部${total?` (${total})`:''}`,()=>{xsearch.profileId='__all__';renderSidenav();renderXSearch();});
      all.classList.toggle('is-selected',xsearch.profileId==='__all__');
      col.append(all);
      xsearch.groups.forEach(g=>{
        const b=button(`${g.name}${g.count?` (${g.count})`:''}`,()=>{xsearch.profileId=g.profileId;renderSidenav();renderXSearch();});
        b.classList.toggle('is-selected',xsearch.profileId===g.profileId);
        col.append(b);
      });
      if(col.children.length)nav.append(col);
    }
  }
  // ===== 搜索页（参考 Android）：搜索历史 / 热门搜索 / 猜你想搜 =====
  function recordSearch(word){
    word=String(word||'').trim();if(!word)return;
    db.searchHistory=Array.isArray(db.searchHistory)?db.searchHistory:[];
    db.searchHistory=[word,...db.searchHistory.filter(w=>w!==word)].slice(0,20);persist();
  }
  // 热门搜索数据源（借鉴 LibreTV）：配置 hot → 豆瓣电影周榜（60s 免 key API，失败静默）→ 当前源首页影片名兑底
  let hotWordsCache=[],hotWordsRequested=false;
  async function ensureHotWords(){
    if(hotWordsRequested||!invoke)return;
    hotWordsRequested=true;
    try{
      const json=await invoke('tvbox_hot_list',{id:'douban_movie_weekly'});
      const data=json&&json.data;
      if(Array.isArray(data))hotWordsCache=data.map(entry=>String(entry&&entry.title||'').trim()).filter(Boolean).slice(0,12);
      if(hotWordsCache.length&&searchPanelOpen)renderSearchPanel();
    }catch(_){/* 网络失败：保持首页影片名兑底 */}
  }
  function hotSearchWords(){
    const hot=config().hot;
    if(typeof hot==='string'&&hot.trim())return hot.split(/[\s,，、|]+/).map(s=>s.trim()).filter(Boolean).slice(0,12);
    if(Array.isArray(hot))return hot.map(s=>String(s).trim()).filter(Boolean).slice(0,12);
    if(hotWordsCache.length)return hotWordsCache;
    ensureHotWords();
    // 配置无 hot 字段时：用当前源首页影片名作为热门
    const list=(homeData.list&&homeData.list.length?homeData.list:((homeSeed.data&&homeSeed.data.list)||[]));
    return [...new Set(list.map(v=>String(v.vod_name||'').trim()).filter(Boolean))].slice(0,12);
  }
  function suggestSearchWords(word){
    word=String(word||'').trim().toLowerCase();if(!word)return [];
    const pool=[...(db.searchHistory||[]),...hotSearchWords()];
    return [...new Set(pool.filter(w=>w&&w.toLowerCase().includes(word)&&w.toLowerCase()!==word))].slice(0,8);
  }
  function startSearch(word,all=false){
    word=String(word||'').trim();if(!word)return;
    recordSearch(word);
    $('keyword').value=word;
    searchPanelOpen=false;
    if(view==='live')return renderLive();
    if(all)return searchAll();
    page=1;keyword=word;return browse();
  }
  function renderSearchPanel(){
    searchPanelOpen=true;
    closeDetail();
    $('results').replaceChildren();$('prev').disabled=$('next').disabled=true;
    const panel=el('div',undefined,'tv-search-panel');
    const word=$('keyword').value.trim();
    const section=(title,words,opts={})=>{
      if(!words.length)return;
      const box=el('div',undefined,'tv-search-section');
      const head=el('div',undefined,'tv-search-head');head.append(el('strong',title));
      if(opts.clear)head.append(button('清空历史',()=>{db.searchHistory=[];persist();renderSearchPanel();},'tv-search-clear'));
      const chips=el('div',undefined,'tv-search-chips');
      words.forEach(w=>{
        const wrap=el('div',undefined,'tv-search-chip-wrap');
        wrap.append(button(w,()=>startSearch(w),'tv-search-chip'));
        if(opts.deletable)wrap.append(button('×',()=>{db.searchHistory=(db.searchHistory||[]).filter(x=>x!==w);persist();renderSearchPanel();},'tv-search-del'));
        chips.append(wrap);
      });
      box.append(head,chips);panel.append(box);
    };
    if(word)section('猜你想搜',suggestSearchWords(word));
    section('热门搜索',hotSearchWords().filter(w=>w!==word));
    section('搜索历史',(db.searchHistory||[]).slice(0,20),{deletable:true,clear:(db.searchHistory||[]).length>0});
    if(!panel.children.length)panel.append(el('div','输入片名后回车或点「搜索」：支持单源搜索与全源搜索，搜索记录会保存在本地。','tv-empty'));
    $('results').append(panel);
    status('搜索历史与热门搜索 · 输入片名可开始搜索');
  }
  // 图片懒加载：进入视口附近才真正请求（带 @Referer 后缀的图也延迟到视口内才走后台代理），加载完成淡入
  const posterObserver=typeof IntersectionObserver!=='undefined'?new IntersectionObserver(entries=>{
    for(const entry of entries){if(!entry.isIntersecting)continue;posterObserver.unobserve(entry.target);loadPoster(entry.target);}
  },{rootMargin:'300px'}):null;
  function loadPoster(img){
    const target=img.dataset.src;if(!target)return;
    if(img.dataset.proxy==='1'&&invoke)invoke('tvbox_image',{url:target,referer:img.dataset.referer||null,userAgent:img.dataset.ua||null}).then(data=>{img.src=data;}).catch(()=>img.remove());
    else img.src=target;
  }
  function poster(node,url,base) {
    if(!url)return;
    try{
      let src=String(url),referer='',userAgent='';
      // TVBox 图片地址可带 @Referer=... / @User-Agent=... 防盗链参数（安卓端图片加载器解析）；桌面 <img> 无法带请求头
      const at=src.search(/@(?:Referer|Refer|User-Agent|Cookie)/i);
      if(at>0){
        const suffix=src.slice(at+1);src=src.slice(0,at);
        const rm=suffix.match(/Referer=([^@]+)/i);if(rm){try{referer=decodeURIComponent(rm[1]);}catch(_){referer=rm[1];}}
        const um=suffix.match(/User-Agent=([^@]+)/i);if(um)userAgent=um[1];
      }
      const target=address(src,base);
      // 豆瓣图床默认也要求 Referer（无 @ 后缀时直连会 418）：统一走后台代理并带站点 Referer
      const isDouban=/doubanio\.com/i.test(target);
      let proxyReferer=referer;
      if(!proxyReferer){if(isDouban)proxyReferer='https://movie.douban.com/';else try{proxyReferer=new URL(target).origin+'/';}catch(_){/* invalid */}}
      const img=el('img');img.loading='lazy';img.referrerPolicy='no-referrer';img.alt='';
      img.dataset.src=target;
      if((at>0||isDouban)&&invoke){img.dataset.proxy='1';img.dataset.referer=proxyReferer||'';if(userAgent)img.dataset.ua=userAgent;}
      img.onload=()=>img.classList.add('is-loaded');
      // 直连失败（防盗链 / 需要 Referer 的图床）时，回退到后台代理带站点 Referer 重试一次
      img.onerror=()=>{
        if(!invoke||img.dataset.fallback)return img.remove();
        img.dataset.fallback='1';
        invoke('tvbox_image',{url:target,referer:proxyReferer||null,userAgent:userAgent||null}).then(data=>{img.src=data;}).catch(()=>img.remove());
      };
      node.prepend(img);
      if(posterObserver)posterObserver.observe(img);else loadPoster(img);
    }catch(_){/* invalid poster */}
  }
  function movieCard(v,s,p) {
    const card=button('',()=>detail(v.vod_id,s,p,null,v),'tv-card'),art=el('div',undefined,'tv-poster');
    art.append(el('span','TV','tv-poster-fallback'));poster(art,v.vod_pic,p.base);
    if(v.vod_remarks)art.append(el('span',v.vod_remarks,'tv-card-remark'));
    card.append(art,el('strong',v.vod_name||'未命名'));
    card.append(el('small',[v.vod_year,v.vod_area,s.name].filter(Boolean).join(' · ')));
    return card;
  }
  // ===== 搜索结果处理（借鉴 LibreTV cms-parser）：部分源站做分词/OR 模糊搜索（搜「摔跤吧！爸爸」返回一堆「爸爸XXX」），
  // 按归一化关键词过滤不相关结果，精确命中（忽略标点差异）排最前；过滤后为空时退回原列表
  function normalizeTitle(value){return String(value||'').toLowerCase().replace(/[\s\p{P}\p{S}]+/gu,'');}
  function isRelevantTitle(name,word){
    const target=normalizeTitle(name),query=normalizeTitle(word);
    if(!target||!query)return true;
    if(target.includes(query))return true;
    const tokens=String(word||'').trim().split(/\s+/);
    return tokens.length>1&&tokens.every(token=>{const part=normalizeTitle(token);return part&&target.includes(part);});
  }
  function filterRelevantResults(list,word){
    if(!word||!Array.isArray(list))return list||[];
    const filtered=list.filter(v=>isRelevantTitle(v&&v.vod_name,word));
    return filtered.length?filtered:list;
  }
  function sortSearchResults(list,word){
    const exact=normalizeTitle(word);
    // 相关性分段：精确命中(0) → 包含关键词(1) → 其他(2)，同段按名称
    const rank=name=>{
      const target=normalizeTitle(name);
      if(!exact||!target)return 2;
      if(target===exact)return 0;
      if(target.includes(exact))return 1;
      const tokens=String(word||'').trim().split(/\s+/);
      if(tokens.length>1&&tokens.every(token=>{const part=normalizeTitle(token);return part&&target.includes(part);}))return 1;
      return 2;
    };
    return (list||[]).slice().sort((a,b)=>{
      const ra=rank(a&&a.vod_name),rb=rank(b&&b.vod_name);
      if(ra!==rb)return ra-rb;
      return String(a&&a.vod_name||'').localeCompare(String(b&&b.vod_name||''),'zh-Hans-CN');
    });
  }
  function searchResultList(list,word){return sortSearchResults(filterRelevantResults(list,word),word);}
  // 单请求超时（借鉴 LibreTV 搜索单源死线）：坏源/慢源不拖住整体队列
  function withTimeout(promise,ms,message){return Promise.race([promise,new Promise((_,reject)=>setTimeout(()=>reject(new Error(message||'请求超时')),ms))]);}
  function renderMovies(list,s,p=profile(),append=false) {
    if(!append)$('results').replaceChildren();
    for(const v of list) $('results').append(movieCard(v,s,p));
    if(!$('results').children.length)$('results').append(el('div','没有找到相关内容，试试其他分类、片源或关键词','tv-empty'));
  }
  async function browse(reset=false) {
    if(view!=='home')switchView('home');
    closeDetail();
    searchPanelOpen=false;
    const token=++generation,s=selectedSite(),p=profile();
    if(reset){page=1;keyword='';filters={};$('keyword').value='';$('category').replaceChildren();homeData={};homeSeed={site:'',data:null};}
    beginLoading('正在加载 '+(s.name||'片源')+'…');
    try{
      status('正在加载 '+(s.name||'片源')+'…');
      if(!homeData.class) {
        const loaded=await api(s,'home',{},p);if(token!==generation)return;homeData=loaded;
        option($('category'),'','推荐 / 全部');(homeData.class||[]).forEach(c=>option($('category'),c.type_id,c.type_name));
      }
      const category=$('category').value||'';
      $('categories').replaceChildren();for(const opt of $('category').options){const tab=button(opt.textContent,()=>{$('category').value=opt.value;return $('category').onchange();});tab.classList.toggle('is-selected',opt.value===category);$('categories').append(tab);}
      renderSidenav();
      let data;
      const siteId=s.key||s.api||'';
      // 首页数据：home 带推荐时直接用；否则自动拉第一个分类的封面（分类先渲染，封面随后到）
      // 首屏结果缓存到 homeSeed，回主页时直接展示缓存、不重新请求
      if(!keyword&&!category&&page===1&&homeData.list?.length)data=homeData;
      else if(!keyword&&!category&&page===1&&homeSeed.site===siteId&&homeSeed.data)data=homeSeed.data;
      else data=await api(s,keyword?'search':'category',{keyword,t:category,page,filters},p);
      if(keyword&&data)data={...data,list:searchResultList(data.list||[],keyword)};
      if(!keyword&&!category&&page===1&&Array.isArray(data?.list)&&data.list.length)homeSeed={site:siteId,data};
      if(token!==generation)return;renderFilters();renderMovies(data.list||[],s,p);$('detail').replaceChildren();
      $('page').textContent=`第 ${page} 页${Number(data.pagecount)>0?' / '+data.pagecount:''}`;$('prev').disabled=page<=1;
      $('next').disabled=!data.list?.length||(Number(data.pagecount)>0&&page>=Number(data.pagecount));
      status(data.list?.length?`${data.list.length} 部影片 · ${s.name||'当前源'}`:'没有影片，尝试分类、搜索或其他片源');
      // 是否还有下一页（供滚动到底自动加载）
      lastBrowseHadMore=!data.list?.length?false:(Number(data.pagecount)>0?page<Number(data.pagecount):true);
    }finally{endLoading();}
  }
  // 分页加载（参考 Android）：列表滚动到底自动加载下一页（保留底部按钮）
  let loadMoreBusy=false,lastBrowseHadMore=false;
  async function loadMore(){
    const panel=document.getElementById('panel-tvbox');
    if(loadMoreBusy||!lastBrowseHadMore||view!=='home'||searchPanelOpen||panel.classList.contains('tv-detail-mode'))return;
    if(!sites().length)return;
    loadMoreBusy=true;page++;
    const s=selectedSite(),p=profile(),token=++generation,category=$('category').value||'';
    beginLoading('正在加载第 '+page+' 页…');
    try{
      status('正在加载第 '+page+' 页…');
      const data=await api(s,keyword?'search':'category',{keyword,t:category,page,filters},p);
      if(token!==generation)return;
      renderMovies(data.list||[],s,p,true);
      lastBrowseHadMore=Number(data.pagecount)>0?page<Number(data.pagecount):(data.list||[]).length>0;
      $('page').textContent=`第 ${page} 页${Number(data.pagecount)>0?' / '+data.pagecount:''}`;
      $('prev').disabled=page<=1;
      $('next').disabled=!data.list?.length||(Number(data.pagecount)>0&&page>=Number(data.pagecount));
      status((data.list||[]).length?`已加载第 ${page} 页 · 当前共 ${$('results').querySelectorAll('.tv-card').length} 部影片`:'已全部加载');
    }catch(e){page--;status('加载更多失败：'+e.message);}finally{loadMoreBusy=false;endLoading();}
  }
  const loadMoreObserver=typeof IntersectionObserver!=='undefined'?new IntersectionObserver(entries=>{
    if(entries.some(entry=>entry.isIntersecting))run(()=>loadMore());
  },{rootMargin:'480px'}):null;
  async function searchAll() {
    const word=$('keyword').value.trim();if(!word)throw Error('输入片名后搜索');searchPanelOpen=false;lastBrowseHadMore=false;switchView('home');const token=++generation,p=profile();
    $('results').replaceChildren();$('prev').disabled=$('next').disabled=true;
    const all=sites().filter(s=>C.supported(s)&&Number(s.searchable??1)!==0);
    const sources=all.filter(s=>!isSourceCooling(sourceKey(s,p)));
    const cooling=all.length-sources.length;
    if(cooling)status(`全源搜索：跳过 ${cooling} 个冷却中的源（可在设置页恢复）`);let index=0,done=0,failed=0;
    async function worker(){while(token===generation&&index<sources.length){const s=sources[index++];try{const data=await withTimeout(api(s,'search',{keyword:word,page:1},p),15000);if(token!==generation)return;renderMovies(searchResultList(data.list||[],word),s,p,true);}catch(_){failed++;}done++;if(token===generation)status(`全源搜索 ${done}/${sources.length} · ${failed} 个源失败`);}}
    await Promise.all(Array.from({length:Math.min(4,sources.length)},worker));
  }
  // 跨仓搜索（参考 Android）：点片单源卡片时直接匹配所有配置仓，按仓顺序呈现（左列仓、右侧该仓结果，按源分组）
  async function searchProfiles(word){
    word=String(word||'').trim();if(!word)throw Error('输入片名后搜索');
    recordSearch(word);$('keyword').value=word;
    view='xsearch';const token=++generation;
    const panel=document.getElementById('panel-tvbox');panel.dataset.view='xsearch';panel.classList.remove('tv-detail-mode');
    $('settings-panel').classList.add('hidden');$('library').classList.remove('hidden');$('settings-tab').classList.remove('is-selected');$('detail-back').classList.add('hidden');$('clear-history').classList.add('hidden');
    for(const key of ['home','live','favorites','history'])$(key).classList.remove('is-selected');
    $('section-title').textContent='跨仓搜索';$('onboarding').classList.add('hidden');
    $('detail').replaceChildren();$('epg').replaceChildren();$('filters').replaceChildren();$('categories').replaceChildren();
    $('prev').disabled=$('next').disabled=true;
    const targets=[];
    db.profiles.forEach(p=>{const list=(p.config&&p.config.sites||[]).filter(s=>C.supported(s)&&Number(s.searchable??1)!==0);if(list.length)targets.push({profileId:p.id,name:p.name||'未命名仓',sites:list});});
    xsearch={word,groups:targets.map(t=>({profileId:t.profileId,name:t.name,sites:t.sites.map(s=>({site:s,list:[]})),count:0,done:0})),profileId:'__all__',done:0,total:targets.reduce((n,t)=>n+t.sites.length,0),running:true,token};
    renderSidenav();renderXSearch();
    status(`跨仓搜索「${word}」：${targets.length} 个仓 · ${xsearch.total} 个源`);
    if(!targets.length){xsearch.running=false;status('没有可搜索的仓，请先在设置中加载或导入配置');return;}
    // 后台异步搜索：不弹全局加载框，只在状态栏显示进度；搜索期间可正常切仓、看已有结果、进详情
    const jobs=[];xsearch.groups.forEach(group=>group.sites.forEach(entry=>jobs.push({group,entry})));
    let index=0;const total=jobs.length;
    async function worker(){
      while(index<total&&xsearch.token===token){
        const job=jobs[index++],p=db.profiles.find(x=>x.id===job.group.profileId);
        if(!p)continue;
        if(isSourceCooling(sourceKey(job.entry.site,p))){
          job.entry.error=true;job.group.done++;xsearch.done++;
          if(xsearch.token!==token)return;
          if(view==='xsearch')scheduleXSearchRender();
          continue;
        }
        try{const data=await withTimeout(api(job.entry.site,'search',{keyword:word,page:1},p),15000);if(xsearch.token!==token)return;job.entry.list=searchResultList(Array.isArray(data.list)?data.list:[],word);if(job.entry.list.length)job.group.count+=job.entry.list.length;}
        catch(_){job.entry.error=true;}
        job.group.done++;xsearch.done++;
        if(xsearch.token!==token)return;
        if(view==='xsearch'){scheduleXSearchRender();status(`跨仓搜索 ${xsearch.done}/${total} · ${xsearch.groups.reduce((n,g)=>n+g.count,0)} 个结果`);}
      }
    }
    await Promise.all(Array.from({length:Math.min(4,Math.max(total,1))},worker));
    if(xsearch.token!==token)return;
    xsearch.running=false;
    if(view==='xsearch'){renderSidenav();renderXSearch();status(`跨仓搜索完成：${xsearch.groups.reduce((n,g)=>n+g.count,0)} 个结果 · 「${word}」`);}
  }
  // 结果渐显节流：最多每 400ms 刷新一次，并保持滚动位置，避免打断用户浏览/选择
  let xsearchRenderTimer=0;
  function scheduleXSearchRender(){
    if(xsearchRenderTimer)return;
    xsearchRenderTimer=setTimeout(()=>{
      xsearchRenderTimer=0;
      if(view!=='xsearch')return;
      const panel=document.getElementById('panel-tvbox'),library=$('library');
      const panelTop=panel?panel.scrollTop:0,libTop=library?library.scrollTop:0;
      renderSidenav();renderXSearch();
      if(panel)panel.scrollTop=panelTop;if(library)library.scrollTop=libTop;
    },400);
  }
  function renderXSearch(){
    if(view!=='xsearch')return;
    const container=$('results');container.replaceChildren();
    const all=xsearch.profileId==='__all__';
    const groups=all?xsearch.groups:xsearch.groups.filter(g=>g.profileId===xsearch.profileId);
    if(!groups.length){container.append(el('div','没有可搜索的仓','tv-empty'));return;}
    const totalCount=xsearch.groups.reduce((n,g)=>n+g.count,0);
    const head=el('div',undefined,'tv-xsearch-head');
    head.append(el('strong',all?`「全部」的搜索结果`:`「${groups[0].name}」的搜索结果`),el('span',`${all?totalCount:groups[0].count} 个 · ${xsearch.done}/${xsearch.total} 个源已返回${xsearch.running?' · 搜索中…':''}`,'tv-cluster-label'));
    container.append(head);
    let any=false;
    for(const group of groups){
      const hits=group.sites.filter(e=>e.list.length);
      if(!hits.length)continue;
      any=true;
      if(all)container.append(el('h3',`${group.name} · ${group.count}`,'tv-xsearch-profile'));
      const p=db.profiles.find(x=>x.id===group.profileId)||profile();
      for(const entry of hits){
        const wrap=el('div',undefined,'tv-xsearch-site');
        wrap.append(el('h4',`${entry.site.name||entry.site.key||'片源'} · ${entry.list.length}`));
        const grid=el('div',undefined,'tv-grid');
        for(const v of entry.list)grid.append(movieCard(v,entry.site,p));
        wrap.append(grid);container.append(wrap);
      }
    }
    if(!any)container.append(el('div',xsearch.running?'正在搜索…':'没有找到相关影片','tv-empty'));
  }
  function movieKey(v,s,p){return `${p.id}:${s.key||s.api}:${v.vod_id}`;}
  async function detail(id,s,p=profile(),resumeContext=null,movie=null) {
    const token=++generation;status('正在加载影片详情…');
    let data;beginLoading('正在加载影片详情…');
    try{data=await api(s,'detail',{id},p);}finally{endLoading();}
    if(token!==generation)return;
    const v=data.list?.[0];
    if(!v){
      // 片单展示源（如豆瓣推荐）：不提供播放详情。自动拿片名去其他片源搜索，闭环到可播放的源
      const name=String(movie?.vod_name||'').trim();
      if(name){status(`「${s.name}」为片单推荐源，已为你跨仓搜索「${name}」`);await searchProfiles(name);return;}
      throw Error('该片源仅提供片单推荐，暂无可播放详情');
    }
    const choices=C.lines(v),container=$('detail');container.replaceChildren();$('epg').replaceChildren();
    const panel=document.getElementById('panel-tvbox');panel.classList.add('tv-detail-mode');$('detail-back').classList.remove('hidden');$('section-title').textContent=v.vod_name||'影片详情';
    const key=movieKey(v,s,p),heading=el('div',undefined,'tv-detail-heading');heading.append(el('h3',v.vod_name||'影片详情'));
    const favorite=button('',()=>{const index=db.favorites.findIndex(f=>f.key===key);if(index>=0)db.favorites.splice(index,1);else db.favorites.push({key,kind:'movie',movie:v,site:s,profileId:p.id,base:p.base});favorite.textContent=db.favorites.some(f=>f.key===key)?'★ 已收藏':'☆ 收藏';persist();});
    favorite.textContent=db.favorites.some(f=>f.key===key)?'★ 已收藏':'☆ 收藏';heading.append(favorite);container.append(heading);
    const body=el('div',undefined,'tv-detail-body'),art=el('div',undefined,'tv-detail-poster');
    art.append(el('span','TV','tv-poster-fallback'));poster(art,v.vod_pic,p.base);body.append(art);
    const info=el('div',undefined,'tv-detail-info');
    info.append(el('p',[v.type_name,v.vod_year,v.vod_area,v.vod_director?'导演 '+v.vod_director:'',v.vod_actor?'主演 '+v.vod_actor:''].filter(Boolean).join(' · '),'tv-detail-meta'));
    const summary=el('p',String(v.vod_content||'').replace(/<[^>]*>/g,'')||'暂无简介','tv-synopsis');info.append(summary);
    container.append(body);body.append(info);
    if(!choices.length){status('此影片没有播放线路');return;}
    const chips=el('div',undefined,'tv-line-chips');info.append(chips,el('h4','选集','tv-episodes-title'));
    const row=el('div',undefined,'tv-episodes');info.append(row);
    function renderLine(lineIndex){row.replaceChildren();chips.querySelectorAll('button').forEach((chip,i)=>chip.classList.toggle('is-selected',i===lineIndex));const line=choices[lineIndex];line.episodes.forEach((ep,i)=>{
      const context={profileId:p.id,siteKey:s.key||s.api,vodId:String(v.vod_id),vodName:v.vod_name,line:lineIndex,index:i,flag:line.name};
      const b=button(ep.name,()=>playEpisode({episodes:line.episodes,index:i,site:s,profile:p,context,choices,lineIndex}));
      if(db.history.some(h=>h.context?.profileId===p.id&&h.context?.vodId===String(v.vod_id)&&h.context?.line===lineIndex&&h.context?.index===i))b.classList.add('tv-watched');row.append(b);
    });}
    choices.forEach((line,i)=>chips.append(button(line.name,()=>renderLine(i),'tv-line-chip')));
    const startLine=Math.min(resumeContext?.line||0,choices.length-1);renderLine(startLine);
    status('选择线路与剧集开始观看');
    if(resumeContext){const line=choices[startLine],index=Math.min(resumeContext.index||0,line.episodes.length-1);await playEpisode({episodes:line.episodes,index,site:s,profile:p,context:{...resumeContext,flag:line.name}});}
    container.scrollIntoView?.({behavior:'smooth',block:'nearest'});
  }
  async function resolveEpisode(raw,s,p,flag) {
    let result={url:raw,parse:0};
    if(s&&(Number(s.type)===4||Number(s.type)===3))result=await api(s,'play',{id:raw,flag},p);
    if(!result?.url)throw Error('播放接口没有返回地址');
    if(typeof result.header==='string'){try{result.header=C.json(result.header);}catch(_){throw Error('播放接口请求头格式无效');}}
    let target=result.url;if(Array.isArray(target))target=target.find(v=>typeof v==='string'&&/^(https?|rtsp|rtmp):/.test(v));
    if(typeof target!=='string')throw Error('播放地址格式不兼容');
    if(result.playUrl)target=result.playUrl+target;
    const parsed=C.media(target);result={...result,...parsed,headers:{...s?.headers,...s?.header,...result.header,...parsed.headers}};
    if(result.url.startsWith('proxy://go=SuperParse&')){
      const params=new URLSearchParams(result.url.slice('proxy://'.length));
      const encoded=params.get('url')||'';
      let sourceUrl;
      try{
        const rawBytes=atob(encoded.replace(/-/g,'+').replace(/_/g,'/')+'='.repeat((4-encoded.length%4)%4));
        sourceUrl=new TextDecoder('utf-8',{fatal:true}).decode(Uint8Array.from(rawBytes,c=>c.charCodeAt(0)));
      }catch(_){throw Error('JAR 网页解析地址编码无效');}
      sourceUrl=address(sourceUrl,p.base);
      const parseFlag=params.get('flag')||flag||'';
      const webParsers=(p.config.parses||[]).filter(parser=>Number(parser.type)===0&&parser.url);
      const matched=webParsers.filter(parser=>{
        let ext=parser.ext;
        if(typeof ext==='string'){try{ext=C.json(ext);}catch(_){return false;}}
        return Array.isArray(ext?.flag)&&ext.flag.includes(parseFlag);
      });
      const available=matched.length?matched:webParsers;
      const selected=available.includes((p.config.parses||[])[Number($('parser').value)])
        ?(p.config.parses||[])[Number($('parser').value)]:available[0];
      if(!selected)return {url:sourceUrl,headers:result.headers,sniff:true};
      const pattern=address(String(selected.url),p.base);
      return {url:pattern.includes('{url}')?pattern.replace('{url}',encodeURIComponent(sourceUrl)):pattern+encodeURIComponent(sourceUrl),headers:result.headers,sniff:true};
    }
    if(/^(magnet:\?|thunder:\/\/)/i.test(result.url)||/\.torrent(?:[?#]|$)/i.test(result.url))return result;
    const selection=$('parser').value||'auto',need=result.parse===1||result.parse==='1'||result.jx===1||Boolean(s?.playerUrl);
    if(selection==='direct'||(selection==='auto'&&!need))return result;
    const parsers=p.config.parses||[],parser=selection==='auto'?parsers[0]:parsers[Number(selection)];
    if(!parser&&s?.playerUrl)return {url:s.playerUrl+encodeURIComponent(result.url),sniff:true,headers:result.headers};
    if(!parser)return {...result,sniff:true};
    const pattern=String(parser.url),url=pattern.includes('{url}')?address(pattern.replace('{url}',encodeURIComponent(result.url)),p.base):address(pattern,p.base)+encodeURIComponent(result.url);
    if(Number(parser.type)!==1)return {url,sniff:true,headers:result.headers};
    const data=C.json(await fetchText(url,parser.header||parser.ext?.header||{})),resolved=data.data?.url?data.data:data;
    if(!resolved.url)throw Error('解析接口未返回直链');
    return {url:resolved.url,headers:{...result.headers,...resolved.header,...resolved.headers}};
  }
  async function playEpisode(next) {
    queue=next;const ep=next.episodes[next.index];if(!ep)throw Error('没有下一集');
    const context={...next.context,index:next.index,line:next.lineIndex??next.context?.line};queue.context=context;
    await play(ep.url,`${context.vodName||'视频'} · ${ep.name}`,{site:next.site,profile:next.profile,context,live:!!next.live,channel:ep.channel});
    renderStageSide();
  }
  async function nextEpisode(delta=1) {
    if(!queue||!queue.episodes[queue.index+delta]){status(delta>0?'已是最后一集':'已是第一集');return;}
    if(queue.local){queue={...queue,index:queue.index+delta};const ep=queue.episodes[queue.index];return play(ep.url,ep.name,{local:true,localQueue:true});}
    await playEpisode({...queue,index:queue.index+delta});
  }
  // ===== 集成式视频区（v0.58.4）：视频嵌入列表上方（mpv 渲染到主窗口内的原生子窗口），
  // 播放中下方列表/详情保持可见 —— 选集、换线路、换频道都在同一界面完成，没有独立播放界面 =====
  function enterStage(name,live){
    const panel=document.getElementById('panel-tvbox');
    // 从设置页直接播放（直链 / 本地视频）时收起设置、回到列表，视频区与列表同屏
    if(view==='settings'){
      $('settings-panel').classList.add('hidden');$('library').classList.remove('hidden');$('settings-tab').classList.remove('is-selected');
      view='home';panel.dataset.view='home';$('home').classList.add('is-selected');$('section-title').textContent='影视';
    }
    panel.classList.add('tv-player-mode');
    panel.classList.toggle('tv-live-mode',!!live); // 直播模式：隐藏字幕控件
    $('stage').classList.remove('hidden');$('controls').classList.remove('hidden');if(name)$('now').textContent=name;
    $('episode-prev').textContent=live?'上一个':'上一集';$('episode-next').textContent=live?'下一个':'下一集';
    syncSurface();
  }
  // 视频区全屏（应用内，v0.58.5）：隐藏导航/列表/侧栏，视频区占满面板，控制条固定底部；不动应用窗口
  function stageFullscreen(on){
    const panel=document.getElementById('panel-tvbox');
    const active=on===undefined?!panel.classList.contains('tv-stage-full'):!!on;
    panel.classList.toggle('tv-stage-full',active);
    $('fullscreen').textContent=active?'退出全屏':'全屏';
    if(active){
      const apply=()=>{const h=Math.ceil($('controls').getBoundingClientRect().height+10);panel.style.setProperty('--tv-full-bottom',h+'px');};
      apply();setTimeout(apply,120);
    }else{
      panel.classList.remove('tv-stage-full-more');
      panel.style.removeProperty('--tv-full-bottom');
    }
    setTimeout(()=>syncSurface(),120);
  }
  function hideSurface(){if(invoke)invoke('tvplayer_surface_hide').catch(()=>{});}
  function exitStage(){
    const panel=document.getElementById('panel-tvbox');panel.classList.remove('tv-player-mode','tv-stage-full','tv-stage-full-more','tv-live-mode');
    panel.style.removeProperty('--tv-full-bottom');$('fullscreen').textContent='全屏';
    $('stage').classList.add('hidden');$('controls').classList.add('hidden');$('stage-side').replaceChildren();hideSurface();
  }
  // 停止播放并关闭视频区（保存进度）：切换导航不再调用，只有「关闭视频区」按钮与播放结束会走到这里
  async function stopStage(message){
    const v=$('video');const live=!!current?.meta?.live;
    endPlayLoading();
    if($('engine').value==='web'&&current&&v&&Number.isFinite(v.duration)&&v.duration>0)updateProgress({session:current.session,position:v.currentTime,duration:v.duration,width:v.videoWidth,height:v.videoHeight});
    if(v&&!v.paused)v.pause();
    if(current){
      current.manualStop=true;
      try{const state=await invoke('tvplayer_status');if(state)updateProgress(state);}catch(_){/* save best effort */}
      if($('engine').value!=='web'){try{await invoke('tvplayer_control',{action:'stop',value:null});}catch(_){/* 播放器可能已关闭 */}}
    }
    current=null;queue=null;trackSignature='';liveFailCount=0;$('now').textContent='尚未播放';
    await persist(true);exitStage();
    status(message||(live?'已关闭直播，播放停止':'播放已停止，进度已保存'));
  }
  async function syncSurface(){
    const panel=document.getElementById('panel-tvbox');
    if(!panel.classList.contains('tv-player-mode')||$('engine').value!=='mpv'||!invoke)return;
    const r=$('surface').getBoundingClientRect();const d=window.devicePixelRatio||1;
    if(r.width<40||r.height<40)return;
    try{await invoke('tvplayer_surface',{x:r.x*d,y:r.y*d,w:r.width*d,h:r.height*d});}catch(_){/* 面窗口仅 Windows 有效 */}
  }
  function sideChips(items,current,onPick){
    const box=el('div',undefined,'tv-side-chips');
    items.forEach((item,i)=>{const b=button(item.label,onPick(i));if(i===current)b.classList.add('is-selected');box.append(b);});
    return box;
  }
  function renderStageSide(currentChannel){
    const side=$('stage-side');side.replaceChildren();
    if(queue?.live){renderLiveSide(currentChannel||queue.episodes[queue.index]?.channel);return;}
    if(!queue)return;
    if(Array.isArray(queue.choices)&&queue.choices.length>1){
      side.append(el('h4','线路'));
      side.append(sideChips(queue.choices.map((line,i)=>({label:line.name||`线路${i+1}`})),queue.lineIndex||0,i=>()=>playEpisode({...queue,episodes:queue.choices[i].episodes,lineIndex:i,index:0,context:{...queue.context,line:i,flag:queue.choices[i].name}})));
    }
    if(queue.episodes?.length){
      side.append(el('h4','选集'));
      side.append(sideChips(queue.episodes.map((ep,i)=>({label:ep.name||`第${i+1}集`})),queue.index,i=>()=>playEpisode({...queue,index:i})));
    }
  }
  function renderLiveSide(channel){
    const side=$('stage-side');side.replaceChildren();
    if(!channel)return;
    const urls=channel.urls||[channel.url];
    if(urls.length>1){
      side.append(el('h4','线路'));
      side.append(sideChips(urls.map((u,i)=>({label:`线路 ${i+1}`})),Math.max(0,urls.indexOf(channel.url)),i=>()=>play(urls[i],channel.name,{headers:channel.headers,live:true,channel,context:{live:true,channel},liveUrlIndex:i})));
    }
    const pool=(liveView.length?liveView:liveChannels).filter(c=>c.url);
    const group=channel.group||'';
    const list=pool.filter(c=>(c.group||'')===group).slice(0,40);
    if(list.length>1){
      side.append(el('h4',group?`频道 · ${group}`:'频道'));
      side.append(sideChips(list.map(c=>({label:c.name})),list.findIndex(c=>c.url===channel.url),i=>()=>playChannel(list[i])));
    }
    const key='live:'+channel.url;
    side.append(button(db.favorites.some(f=>f.key===key)?'★ 已收藏频道':'☆ 收藏频道',()=>{const i=db.favorites.findIndex(f=>f.key===key);if(i>=0)db.favorites.splice(i,1);else db.favorites.push({key,kind:'live',channel});persist();renderLiveSide(channel);}));
  }
  async function launch(url,name,meta,token) {
    if(token!==playGeneration)return;
    const live=!!meta.live;
    if($('engine').value==='web'&&Object.keys(meta.headers||{}).length)throw Error('此片源需要请求头，请使用内置 libmpv');
    const raw=meta.raw||url,recordKey=meta.context?`${meta.context.profileId}:${meta.context.siteKey}:${meta.context.vodId}:${meta.context.line}:${meta.context.index}`:raw;
    const old=live?null:db.history.find(h=>h.key===recordKey||(!h.key&&h.url===url));
    const start=live?0:db.prefs.resume?Math.max(C.resume(old),meta.context?Number(db.prefs.skipIntro)||0:0):meta.context?Number(db.prefs.skipIntro)||0:0;
    if(current){try{const state=await invoke('tvplayer_status');if(state)updateProgress(state);}catch(_){/* retain last known progress */}}
    if(token!==playGeneration)return;
    const session=stamp();current={session,key:recordKey,meta,url,name,manualStop:false,eofTriggered:false};trackSignature='';$('controls').classList.remove('hidden');
    enterStage(name,live);
    beginPlayLoading(live?'正在连接直播源…':'正在加载视频…');
    if($('engine').value==='web'){
      await invoke('tvplayer_surface_hide').catch(()=>{});
      const video=$('video');video.src=meta.local?window.__TAURI__.core.convertFileSrc(url):url;video.classList.remove('hidden');video.playbackRate=Number(db.prefs.speed)||1;video.volume=Math.min(1,Number(db.prefs.volume)/100);
      video.onloadedmetadata=()=>{video.currentTime=Math.min(start,video.duration||start);};
      video.onloadeddata=()=>endPlayLoading();
      try{await video.play();}catch(e){endPlayLoading();throw e;}
    }else{
      $('video').pause();$('video').removeAttribute('src');$('video').classList.add('hidden');
      try{
        // 子窗口已由 enterStage 创建（wid 可用）；加载期间保持隐藏，让视频区提示可见，loaded 后再显示画面
        await invoke('tvplayer_play',{target:url,title:name,headers:meta.headers||{},session,options:{...db.prefs,start,subDelay:Number($('sub-delay').value)||0}});
      }catch(e){endPlayLoading();throw e;}
    }
    renderStageSide(meta.channel);
    if(!live){
      const record={...old,key:recordKey,name,url,raw,sniffPage:meta.sniffPage,headers:meta.headers||{},local:!!meta.local,context:meta.context,position:start,duration:old?.duration||0,time:Date.now()};
      db.history=[record,...db.history.filter(h=>h.key!==recordKey&&(h.key||h.url!==url))].slice(0,100);persist();
    }
    $('now').textContent=name;
    $('episode-prev').disabled=!queue||queue.index<=0;$('episode-next').disabled=!queue||queue.index>=queue.episodes.length-1;
    if(playLoading)status(live?`正在连接直播源：${name}…`:start>0?`正在加载视频（将从 ${time(start)} 继续）：${name}…`:`正在加载视频：${name}…`);
  }
  async function play(raw,name,meta={}) {
    if(!invoke)throw Error('请在桌面应用中播放');const token=++playGeneration;sniffPending=null;$('sniff-results').replaceChildren();
    await invoke('tvbox_cancel_p2p');
    if(!meta.context&&!meta.localQueue)queue=null;
    const p=meta.profile||profile();let result;
    if(meta.local)result={url:raw,headers:meta.headers||{}};
    else if(meta.resolved)result={url:raw,headers:meta.headers||{}};
    else result=await withLoading(()=>resolveEpisode(raw,meta.site,p,meta.context?.flag||''),'正在解析播放地址…');
    if(token!==playGeneration)return;
    if(result.sniff){await sniff(result.url,name,{...meta,raw,headers:result.headers},token);return;}
    let url=result.url;
    if(/^(magnet:\?|thunder:\/\/)/i.test(url)||/\.torrent(?:[?#]|$)/i.test(url)){
      status('正在获取视频文件，磁力链接和种子需要先下载完成…');
      const torrent=/^magnet:/i.test(url)||/\.torrent(?:[?#]|$)/i.test(url);
      if(torrent&&!/^magnet:/i.test(url)&&!meta.local)url=address(url,p.base);
      url=await invoke('tvbox_prepare_media',{target:url});
      if(token!==playGeneration)return;
      if(torrent)meta.local=true;
    }
    if(/^tvbox-xg:/i.test(url))throw Error('此线路依赖原项目的私有 P2P 协议，尚无可用的桌面实现');
    if(!meta.local&&!/^(rtsp|rtmp|udp|rtp|ftp):/i.test(url))url=address(url,p.base);
    if(url.startsWith('file:')){url=decodeURIComponent(new URL(url).pathname).replace(/^\/([a-z]:)/i,'$1');meta.local=true;}
    await launch(url,name,{...meta,raw,headers:{...meta.headers,...result.headers}},token);
  }
  async function sniff(url,name,meta,token=++playGeneration) {
    if(!meta.context)queue=null;$('sniff-results').replaceChildren();
    const session=stamp();sniffPending={session,url,name,meta:{...meta,raw:meta.raw||url,sniffPage:url},token,seen:new Set()};
    await invoke('tvbox_sniff',{url:address(url),session});status('已打开网页解析窗口。在网页中点击播放，识别到的地址会显示在此处。');
  }
  function updateProgress(snapshot) {
    if(!current||snapshot.session!==current.session)return;
    const mediaInfo=[snapshot.width?`${snapshot.width} × ${snapshot.height}`:'',snapshot.hwdec&&snapshot.hwdec!=='no'?`硬解 ${snapshot.hwdec}`:'软件解码',snapshot.codec||'',snapshot.buffer?`缓存 ${Math.round(snapshot.buffer)} 秒`:''].filter(Boolean).join(' · ');
    if(current.meta?.live){
      // 直播：mpv 的 FILE_LOADED 只代表打开了输入流（坏源也会触发），
      // 只有拿到真实视频尺寸或进度前进才判为播放成功（结束加载提示、重置失败计数）
      if(playLoading&&(Number(snapshot.width)>0||Number(snapshot.position)>0.5)){
        liveFailCount=0;endPlayLoading();status('正在直播：'+current.name);
      }
      const position=Number(snapshot.position)||0,duration=Number(snapshot.duration)||0;$('time').textContent=`${time(position)} / ${time(duration)}`;$('seek').max=String(duration||100);$('seek').value=String(position);$('info').textContent=mediaInfo;return;
    }
    const h=db.history.find(h=>h.key===current.key);if(!h)return;
    const position=Number(snapshot.position)||0,duration=Number(snapshot.duration)||0;
    if(position>0)h.position=position;if(duration>0)h.duration=duration;
    $('time').textContent=`${time(position)} / ${time(duration)}`;$('seek').max=String(duration||100);$('seek').value=String(position);
    $('info').textContent=[snapshot.width?`${snapshot.width} × ${snapshot.height}`:'',snapshot.hwdec&&snapshot.hwdec!=='no'?`硬解 ${snapshot.hwdec}`:'软件解码',snapshot.codec||'',snapshot.buffer?`缓存 ${Math.round(snapshot.buffer)} 秒`:''].filter(Boolean).join(' · ');
    if(Array.isArray(snapshot.tracks))renderTracks(snapshot.tracks);
    if(Date.now()-lastSave>5000){persist();lastSave=Date.now();}
    const outro=Number(db.prefs.skipOutro)||0;
    if(outro>0&&duration>outro*2&&position>=duration-outro&&db.prefs.autoNext&&queue&&!current.eofTriggered){current.eofTriggered=true;run(()=>nextEpisode());}
  }
  function renderTracks(tracks){const signature=JSON.stringify(tracks.map(t=>[t.id,t.type,t.title,t.lang,t.selected]));if(signature===trackSignature)return;trackSignature=signature;
    for(const [id,type]of [['audio','audio'],['subtitles','sub']]){const select=$(id);select.replaceChildren();option(select,'auto',type==='audio'?'自动音轨':'自动字幕');if(type==='sub')option(select,'no','关闭字幕');tracks.filter(t=>t.type===type).forEach(t=>{option(select,t.id,`${t.id} · ${t.title||t.lang||t.codec||'轨道'}`);if(t.selected)select.value=String(t.id);});}
  }
  async function control(action,value) {
    if(action==='stop')return stopStage();
    if(action==='fullscreen'){
      // 全屏 = 视频区域全屏（不动应用窗口）：web 用 video 元素全屏，mpv 用应用内视频区全屏
      if($('engine').value==='web'){const v=$('video');if(document.fullscreenElement)return document.exitFullscreen();return v.requestFullscreen?.();}
      return stageFullscreen();
    }
    if($('engine').value==='web'){
      const v=$('video');if(action==='pause')return v.paused?v.play():v.pause();if(action==='seek')v.currentTime=Number(value);if(action==='forward')v.currentTime+=10;if(action==='backward')v.currentTime=Math.max(0,v.currentTime-10);if(action==='speed')v.playbackRate=Number(value);if(action==='volume')v.volume=Math.min(1,Number(value)/100);return;
    }
    await invoke('tvplayer_control',{action,value:value??null});
  }
  function completed(){if(!current||current.manualStop||current.eofTriggered)return;current.eofTriggered=true;if(current.meta?.live){status('直播中断或结束');return;}const h=db.history.find(h=>h.key===current.key);if(h){h.position=h.duration||h.position;persist();}if(db.prefs.autoNext&&queue?.episodes[queue.index+1]){run(()=>nextEpisode());return;}run(()=>stopStage('播放结束，已回到列表'));}
  // 旧版本可能把直播频道写进观看记录（key=频道地址、无点播上下文）——启动与展示时自动清理，直播不需要历史
  const isLiveRecord=h=>!h.context&&!h.sniffPage&&String(h.key||'')===String(h.url||'')&&/\.(?:m3u8|m3u|flv|ts)(?:[?#]|$)/i.test(String(h.url||''));
  function historyItems() {
    switchView('history');$('results').replaceChildren();$('prev').disabled=$('next').disabled=true;
    const keep=db.history.filter(h=>!isLiveRecord(h));
    if(keep.length!==db.history.length){db.history=keep;persist();}
    for(const h of db.history){const wrapper=el('div',undefined,'tv-record'),b=button(h.name,()=>replay(h));wrapper.append(b,el('small',`${time(h.position)} / ${time(h.duration)} · ${new Date(h.time||Date.now()).toLocaleString()}`));wrapper.append(button('移除',()=>{db.history=db.history.filter(item=>item!==h);persist();historyItems();}));$('results').append(wrapper);}
    if(!db.history.length)$('results').append(el('div','暂无观看记录，播放过的影片会自动出现在这里','tv-empty'));
    status(`${db.history.length} 条观看记录`);
  }
  async function replay(h) {
    if(h.context){const p=db.profiles.find(p=>p.id===h.context.profileId),s=p?.config.sites?.find(s=>(s.key||s.api)===h.context.siteKey);if(p&&s){await detail(h.context.vodId,s,p,h.context);return;}}
    if(h.sniffPage)return sniff(h.sniffPage,h.name,{raw:h.raw,headers:h.headers},++playGeneration);
    await play(h.raw||h.url,h.name,{headers:h.headers,local:h.local,resolved:true});
  }
  function favorites() {
    switchView('favorites');$('results').replaceChildren();$('prev').disabled=$('next').disabled=true;
    for(const f of db.favorites){
      const card=el('div',undefined,'tv-favorite'),b=button('',()=>f.kind==='movie'?detail(f.movie.vod_id,f.site,db.profiles.find(p=>p.id===f.profileId)||{id:f.profileId,base:f.base,config:{}}):playChannel(f.channel),'tv-card');
      const art=el('div',undefined,'tv-poster');art.append(el('span','TV','tv-poster-fallback'));poster(art,f.movie?.vod_pic||f.channel?.logo,f.base);
      b.append(art,el('strong',f.kind==='movie'?f.movie.vod_name:f.channel.name));
      card.append(b,button('取消收藏',()=>{db.favorites=db.favorites.filter(item=>item!==f);persist();favorites();}));$('results').append(card);
    }
    if(!db.favorites.length)$('results').append(el('div','还没有收藏，在影片详情或直播频道点击「收藏」即可','tv-empty'));
    status(`${db.favorites.length} 个收藏`);
  }
  // ===== 直播（参考 Android 影视仓）：内置源优先；按仓隔离；选中哪个直播源才加载哪个（不一次性加载全部） =====
  function ensureLiveSources(){
    const lives=Array.isArray(config().lives)?config().lives:[];
    const items=[{id:'builtin',name:'内置源',builtin:true}];
    lives.forEach((item,i)=>items.push({id:'cfg'+i,name:String(item?.name||`直播源 ${i+1}`),item}));
    if(liveSources===null||liveSources.length!==items.length||liveSources.some((s,i)=>s.id!==items[i].id||s.name!==items[i].name))liveSources=items;
    if(!liveSources.some(s=>s.id===liveCurrent))liveCurrent='builtin';
    return liveSources;
  }
  // 同名频道合并多线路（对齐 Android 的「一个频道多个源可以切换」）
  function mergeLiveChannels(items){
    const map=new Map();
    for(const c of items){
      const name=String(c.name||'').trim();if(!name)continue;
      const urls=(Array.isArray(c.urls)?c.urls:(c.url?[c.url]:[])).filter(Boolean);
      if(!urls.length)continue;
      const key=name.replace(/\s+/g,'').toLowerCase();
      const entry=map.get(key);
      if(entry){for(const u of urls)if(!entry.urls.includes(u))entry.urls.push(u);continue;}
      map.set(key,{name,group:c.group||'',logo:c.logo||'',epg:c.epg||'',epgId:c.epgId||'',headers:c.headers||{},urls:[...urls]});
    }
    return [...map.values()].map(c=>({...c,url:c.urls[0]}));
  }
  async function loadLiveSource(id,force=false){
    const source=ensureLiveSources().find(s=>s.id===id)||ensureLiveSources()[0];
    // 已在直播视图时不走 switchView（不清空筛选区，加载期间仍可切换其他直播源）
    if(view!=='live')switchView('live');
    if(!force&&liveCurrent===source.id&&liveChannels.length){renderLive();return;}
    const token=++generation;liveCurrent=source.id;liveGroup='';
    status(source.builtin?'正在加载内置直播源…':`正在加载「${source.name}」…`);
    beginLoading(source.builtin?'正在加载内置直播源…':`正在加载「${source.name}」…`);
    try{
      let channels=[];
      if(source.builtin){
        const data=await invoke('tvbox_live_builtin');
        for(const group of (data&&Array.isArray(data.groups)?data.groups:[])){
          for(const c of (group.channels||[]))channels.push({name:c.name,group:group.name,logo:c.logo||'',urls:Array.isArray(c.urls)?c.urls:[],source:'内置源'});
        }
      }else{
        const item=source.item||{};
        let items=[];
        if(item.channels||item.urls){items=C.liveItems([item],profile().base);}
        else{
          const remote=item.remote||address(item.url,profile().base);
          const text=await fetchText(remote,item.headers||{});
          items=text.trim().startsWith('{')?C.liveItems(C.json(text).lives||[],remote):C.playlist(text,remote);
          items=items.map(c=>({...c,group:c.group||item.group||'',epg:c.epg||item.epg,headers:{...item.headers,...c.headers}}));
        }
        for(const c of items)channels.push({name:c.name,group:c.group||'',logo:c.logo||'',epg:c.epg||'',epgId:c.epgId||'',headers:c.headers||{},urls:Array.isArray(c.urls)?c.urls:[c.url],source:source.name});
      }
      if(token!==generation)return;
      liveChannels=mergeLiveChannels(channels);
      renderLive();
      const groups=new Set(liveChannels.map(c=>c.group).filter(Boolean));
      status(liveChannels.length?`${liveChannels.length} 个频道 · ${source.name}${groups.size>1?` · ${groups.size} 个分组`:''}`:`「${source.name}」暂无频道`);
    }catch(e){
      if(token!==generation)return;
      liveChannels=[];renderLive();
      status(`「${source.name}」加载失败：${e?.message||e}${source.builtin?'':'（可切回内置源）'}`);
    }finally{endLoading();}
  }
  async function loadLive(force=false){switchView('live');ensureLiveSources();await loadLiveSource(liveCurrent,force);}
  function renderLive() {
    $('results').replaceChildren();$('prev').disabled=$('next').disabled=true;
    // 直播源/分组筛选已移到左侧分组导航（左右布局）
    $('filters').replaceChildren();
    renderSidenav();
    const word=$('keyword').value.trim().toLowerCase();
    liveView=liveChannels.filter(c=>(!liveGroup||c.group===liveGroup)&&(!word||`${c.name} ${c.group}`.toLowerCase().includes(word)));
    liveView.forEach(c=>{const b=button('',()=>playChannel(c),'tv-channel');poster(b,c.logo);b.append(el('strong',c.name),el('small',[c.group,c.urls.length>1?`${c.urls.length} 源`:''].filter(Boolean).join(' · ')||'直播'));$('results').append(b);});
    if(!liveView.length)$('results').append(el('div',liveChannels.length?'没有匹配的频道，试试其他分组或关键词':'此直播源暂无频道，试试切换其他直播源','tv-empty'));
  }
  // 直播自动换源（参考 Android）：当前源超时/失败 → 换该频道下一个源；已是最后一个源 → 换下一个频道；
  // 连续失败超过 12 次停止，避免坏源造成无限循环
  let liveFailCount=0;
  async function liveSwitchNext(){
    if(!current?.meta?.live||current.manualStop)return false;
    const channel=current.meta.channel;
    if(++liveFailCount>12){status('多个直播源连续失败，已停止自动换源，请手动选择频道或直播源');return false;}
    const urls=(channel&&(channel.urls||[channel.url]))||[];
    const idx=Number(current.meta.liveUrlIndex)||0;
    if(channel&&idx<urls.length-1){
      const next=idx+1;
      status(`直播源不可用，切换线路 ${next+1}/${urls.length}：${channel.name}`);
      await play(urls[next],channel.name,{headers:channel.headers,live:true,channel,context:{live:true,channel},liveUrlIndex:next});
      return true;
    }
    if(queue?.live&&queue.index<queue.episodes.length-1){
      status(`「${channel?channel.name:'当前频道'}」所有线路不可用，切换下一个频道`);
      await nextEpisode(1);
      return true;
    }
    status('已是最后一个频道，无法自动换源，请手动选择频道');
    return false;
  }
  async function playChannel(channel) {
    // 换台范围 = 当前筛选出的频道列表；每个频道的多个源在播放界面侧栏切换
    const pool=(liveView.length?liveView:liveChannels).filter(c=>c.url);
    const list=pool.length?pool:[channel];
    const index=Math.max(0,list.findIndex(c=>c.url===channel.url));
    queue={episodes:list.map(c=>({name:c.name,url:c.url,channel:c})),index,live:true};
    const urls=channel.urls||[channel.url];
    await play(urls[0],channel.name,{headers:channel.headers,live:true,channel,context:{live:true,channel},liveUrlIndex:0});
  }
  function playChannelDetails(channel){status(db.favorites.some(f=>f.key==='live:'+channel.url)?'频道已收藏':'已取消收藏');}
  async function showEpg(channel) {
    const date=new Date(),day=`${date.getFullYear()}-${String(date.getMonth()+1).padStart(2,'0')}-${String(date.getDate()).padStart(2,'0')}`;
    const source=String(channel.epg||config().epg||'').replaceAll('{name}',encodeURIComponent(channel.name)).replaceAll('{epg}',encodeURIComponent(channel.epgId||channel.name)).replaceAll('{date}',day);
    const list=C.epg(await fetchText(address(source)),channel,date),now=Date.now();$('epg').replaceChildren(el('h3',`${channel.name} · 节目单`));
    list.filter(p=>p.end>=new Date(date.getFullYear(),date.getMonth(),date.getDate()).getTime()).slice(0,100).forEach(p=>{const row=el('div',`${new Date(p.start).toLocaleTimeString([], {hour:'2-digit',minute:'2-digit'})} — ${new Date(p.end).toLocaleTimeString([], {hour:'2-digit',minute:'2-digit'})}  ${p.title}`,'tv-program');if(p.start<=now&&p.end>now)row.classList.add('is-selected');$('epg').append(row);});if(!list.length)$('epg').append(el('p','没有匹配到节目单'));
  }
  // Phone configuration uses an ephemeral LAN session, enabled only from Settings.
  function openSettings(){view='settings';generation++;const panel=document.getElementById('panel-tvbox');panel.dataset.view='settings';panel.classList.remove('tv-detail-mode');$('detail-back').classList.add('hidden');$('settings-panel').classList.remove('hidden');$('library').classList.add('hidden');for(const key of ['home','live','favorites','history'])$(key).classList.remove('is-selected');$('settings-tab').classList.add('is-selected');}
  $('settings-tab').onclick=openSettings;
  $('onboard-config').onclick=()=>{$('settings-tab').click();$('config-url').focus();};
  $('onboard-phone').onclick=()=>{$('settings-tab').click();$('phone-start').click();};
  $('onboard-local').onclick=()=>$('local').click();
  if(loadMoreObserver)loadMoreObserver.observe($('sentinel'));
  $('find').onclick=()=>run(async()=>{
    closeDetail();
    if(view!=='home')switchView('home');
    const word=$('keyword').value.trim();
    if(word)return startSearch(word);
    $('keyword').value='';
    renderSearchPanel();
    $('keyword').focus();
  });
  $('phone-start').onclick=()=>run(async()=>{const result=await invoke('tvbox_remote_start');$('phone').replaceChildren(el('p','手机与电脑连接同一网络，扫描对应网卡的二维码。配置完成后可关闭此入口。'));for(const code of result.codes){const card=el('div'),img=el('img');img.src='data:image/svg+xml;charset=utf-8,'+encodeURIComponent(code.svg);img.alt='手机配置二维码';card.append(img,el('p',code.url.split('#')[0]));$('phone').append(card);}$('phone').classList.remove('hidden');$('phone-stop').classList.remove('hidden');});
  $('runtime-stop').onclick=()=>run(async()=>{await invoke('tvbox_external_stop');status('Python / Java 片源运行时已停止，下次使用时自动启动');});
  $('phone-stop').onclick=()=>run(async()=>{await invoke('tvbox_remote_stop');$('phone').replaceChildren();$('phone').classList.add('hidden');$('phone-stop').classList.add('hidden');status('手机配置入口已关闭');});
  window.__TAURI__?.event?.listen('tvbox-phone-config',event=>run(async()=>{const text=String(event.payload).trim();status('正在加载手机发送的配置…');if(text.startsWith('{'))await importConfig(text,'','手机配置');else{const url=address(text);await importConfig(await fetchText(url),url);}})).catch(()=>{});
  // Configuration and navigation.
  function closeDetail(){
    const panel=document.getElementById('panel-tvbox');panel.classList.remove('tv-detail-mode');
    $('detail').replaceChildren();$('epg').replaceChildren();$('detail-back').classList.add('hidden');
    $('section-title').textContent=({home:'影视',live:'电视直播',favorites:'我的收藏',history:'观看记录',settings:'配置与设置'})[view]||'影视';
  }
  // 「影视」导航：回到主页列表——已有分类与封面时直接展示缓存（不重新请求），避免每次回来都等片源加载
  function goHome(){
    closeDetail();
    page=1;keyword='';filters={};$('keyword').value='';$('category').value='';
    if(view!=='home')switchView('home');
    if(sites().length)run(()=>browse(false));
    else status('先在「设置」加载配置，或打开本地视频试播');
  }
  $('detail-back').onclick=()=>closeDetail();
  $('load').onclick=()=>run(async()=>{const url=address($('config-url').value.trim());await importConfig(await fetchText(url),url);});
  $('import').onclick=()=>run(async()=>{const path=await dialog.open({multiple:false,filters:[{name:'TVBox 配置 / 直播',extensions:['json','m3u','m3u8','txt']}]});if(path){const local=new URL('file:///');local.pathname='/'+path.replace(/\\/g,'/');await importConfig((await invoke('read_text_file',{path})).content,local.href,path.split(/[\\/]/).pop());}});
  $('export').onclick=()=>run(async()=>{const path=await dialog.save({defaultPath:'tvbox-config.json',filters:[{name:'TVBox 配置',extensions:['json']}]});if(path){await invoke('write_text_file',{path,content:JSON.stringify(config(),null,2)});status('配置已导出');}});
  $('apply-config').onclick=()=>run(async()=>{const conf=C.json($('config-editor').value);if(!Array.isArray(conf.sites)&&!Array.isArray(conf.lives))throw Error('配置需包含 sites 或 lives');if(!profile().id)return importConfig($('config-editor').value);profile().config=conf;await persist(true);setup();});
  $('profile').onchange=()=>run(async()=>{const stay=view==='settings';db.profileId=$('profile').value;const p=profile();persist();setup();if(p.collectionBase){status(`正在加载「${p.name}」…`);await loadCollectionProfile(p);setup();if(!stay&&sites().some(C.supported))await browse(true);}if(stay)openSettings();});
  $('rename').onclick=()=>{const stay=view==='settings';const name=$('profile-name').value.trim();if(profile().id&&name){profile().name=name;persist();setup();if(stay)openSettings();}};
  $('delete-profile').onclick=()=>run(async()=>{const stay=view==='settings';if(!profile().id)return;if(!await window.showConfirm('删除当前片源配置？收藏和观看记录将保留。'))return;db.profiles=db.profiles.filter(p=>p.id!==db.profileId);db.profileId=db.profiles[0]?.id||'';await persist(true);setup();if(stay)openSettings();});
  $('home').onclick=()=>run(()=>goHome());$('live').onclick=()=>run(()=>loadLive(view==='live'));$('favorites').onclick=favorites;$('history').onclick=historyItems;
  $('site-filter').oninput=()=>{const count=renderSiteOptions($('site-filter').value);status(count?`找到 ${count} 个片源 · 从右侧列表选择`: '没有匹配的片源，试试其他关键词');};
  $('site-filter').onkeydown=e=>{if(e.key==='Enter'&&$('site').options.length)run(()=>browse(true));};
  $('site').onchange=()=>{
    if(siteProgrammatic)return;
    run(async()=>{const s=sites()[Number($('site').value)];if(!s)return;if(s.key===db.selectedSite||s.api===db.selectedSite||s.name===db.selectedSite)return;db.selectedSite=s.key||s.api||s.name;persist();await browse(true);});
  };$('category').onchange=()=>run(()=>{page=1;keyword='';filters={};return browse();});
  $('search').onclick=()=>run(()=>{
    if(view==='live')return renderLive();
    const word=$('keyword').value.trim();
    if(!word){renderSearchPanel();$('keyword').focus();return;}
    return startSearch(word);
  });
  $('search-all').onclick=()=>run(()=>{
    const word=$('keyword').value.trim();
    if(!word){renderSearchPanel();$('keyword').focus();return;}
    return startSearch(word,true);
  });
  $('keyword').oninput=()=>{if(searchPanelOpen)renderSearchPanel();};
  $('keyword').onkeydown=e=>{if(e.key==='Enter')$('search').click();};$('prev').onclick=()=>run(()=>{if(page>1)page--;return browse();});$('next').onclick=()=>run(()=>{page++;return browse();});
  $('clear-history').onclick=()=>run(async()=>{if(await window.showConfirm('清空全部观看记录与续播进度？')){db.history=[];persist();historyItems();}});
  $('local').onclick=()=>run(async()=>{const paths=await dialog.open({multiple:true,filters:[{name:'视频',extensions:['mp4','mkv','mov','avi','ts','webm','m4v','flv','m2ts']}]});if(!paths)return;const list=(Array.isArray(paths)?paths:[paths]).map(path=>({name:path.split(/[\\/]/).pop(),url:path}));if(!list.length)return;queue={episodes:list,index:0,local:true};await play(list[0].url,list[0].name,{local:true,localQueue:true});});
  $('play').onclick=()=>run(()=>play($('direct').value.trim(),'网络视频'));
  $('sniff').onclick=()=>run(()=>sniff($('direct').value.trim(),'网页视频',{}));
  for(const action of ['pause','stop','forward','backward','fullscreen'])$(action).onclick=()=>run(()=>control(action));
  $('more-toggle').onclick=()=>{const more=$('controls-more');const collapsed=more.classList.toggle('hidden');$('more-toggle').textContent=collapsed?'更多 ⌄':'收起 ⌃';const panel=document.getElementById('panel-tvbox');if(panel.classList.contains('tv-stage-full')){panel.classList.toggle('tv-stage-full-more',!collapsed);setTimeout(()=>{const h=Math.ceil($('controls').getBoundingClientRect().height+10);panel.style.setProperty('--tv-full-bottom',h+'px');syncSurface();},120);}};
  $('episode-prev').onclick=()=>run(()=>nextEpisode(-1));$('episode-next').onclick=()=>run(()=>nextEpisode(1));
  for(const [id,action]of [['speed','speed'],['volume','volume'],['sub-delay','sub-delay'],['audio','aid'],['subtitles','sid'],['aspect','aspect']])$(id).onchange=()=>run(async()=>{const value=['speed','volume','sub-delay'].includes(id)?Number($(id).value):$(id).value;if(id==='speed'||id==='volume'){db.prefs[id]=value;persist();}if(current)await control(action,value);});
  $('seek').onchange=()=>run(()=>control('seek',Number($('seek').value)));
  $('subtitle-file').onclick=()=>run(async()=>{const path=await dialog.open({multiple:false,filters:[{name:'字幕',extensions:['srt','ass','ssa','vtt','sub']}]});if(path)await control('subtitle',path);});
  for(const [id,key]of [['resume','resume'],['auto-next','autoNext'],['skip-intro','skipIntro'],['skip-outro','skipOutro'],['hwdec','hwdec']])$(id).onchange=()=>{db.prefs[key]=['resume','autoNext'].includes(key)?$(id).checked:key==='hwdec'?$(id).value:Math.max(0,Math.min(600,Number($(id).value)||0));persist();};
  $('self-parser').onchange=()=>{db.prefs.selfParser=$('self-parser').checked;persist();updateUnmatchedInfo();status(db.prefs.selfParser?'已开启源自带解析兼容：未适配站点将回退到片源自带爬虫':'已切换为纯本地解析：未适配站点会提示并记录到待适配清单');};
  $('live-timeout').onchange=()=>{db.prefs.liveTimeout=Math.max(5,Math.min(30,Number($('live-timeout').value)||15));$('live-timeout').value=String(db.prefs.liveTimeout);persist();status(`直播换源超时：${db.prefs.liveTimeout} 秒`);};
  $('reset-health').onclick=()=>resetSourceHealth();
  $('video').onerror=()=>{const live=!!current?.meta?.live&&!current?.manualStop;endPlayLoading();if(live){status('直播源播放失败，尝试换源…');run(()=>liveSwitchNext());}else status('WebView 无法播放此编码或地址，请使用内置 libmpv');};$('video').onended=completed;
  $('video').ontimeupdate=()=>{if(current&&$('engine').value==='web')updateProgress({session:current.session,position:$('video').currentTime,duration:$('video').duration,width:$('video').videoWidth,height:$('video').videoHeight});};
  document.addEventListener('keydown',e=>{if(!document.getElementById('panel-tvbox').classList.contains('active')||e.target.closest('input,textarea,select,[contenteditable]')||e.ctrlKey||e.altKey||e.metaKey)return;const action={' ':'pause',ArrowLeft:'backward',ArrowRight:'forward',f:'fullscreen',F:'fullscreen'}[e.key];if(action){e.preventDefault();run(()=>control(action));}else if(e.key==='n'||e.key==='N'){$('episode-next').click();}else if(e.key==='Escape'&&document.getElementById('panel-tvbox').classList.contains('tv-stage-full')){e.preventDefault();stageFullscreen(false);}});
  // 视频区域跟随窗口尺寸变化（全屏时重算控制条预留高度）；加载期间不显示子窗口（避免遮住视频区提示）
  let surfaceSyncTimer=0;
  window.addEventListener('resize',()=>{clearTimeout(surfaceSyncTimer);surfaceSyncTimer=setTimeout(()=>{const panel=document.getElementById('panel-tvbox');if(panel.classList.contains('tv-stage-full')){const h=Math.ceil($('controls').getBoundingClientRect().height+10);panel.style.setProperty('--tv-full-bottom',h+'px');}if(!playLoading)syncSurface();},120);});
  const tvPanel=document.getElementById('panel-tvbox');
  new MutationObserver(()=>{if(!tvPanel.classList.contains('active')&&tvPanel.classList.contains('tv-player-mode'))hideSurface();}).observe(tvPanel,{attributes:true,attributeFilter:['class']});
  tvPanel.addEventListener('panel-shown',()=>{if(!tvPanel.classList.contains('tv-player-mode'))return;renderStageSide(current?.meta?.channel);if(!playLoading)setTimeout(()=>syncSurface(),120);});
  window.__TAURI__?.event?.listen('tvbox-player-event',event=>{
    const data=event.payload;if(!current||data.session!==current.session)return;
    if(data.kind==='closed'){endPlayLoading();updateProgress(data);persist(true);current.manualStop=true;status('播放窗口已关闭，进度已保存');}
    else if(data.kind==='loaded'){
      // 直播：FILE_LOADED 不代表有画面（坏源会一直重试），保持加载提示与 15 秒超时，等 updateProgress 确认真实画面
      if(current.meta?.live)status('正在连接直播源：'+current.name+'…');
      else {liveFailCount=0;endPlayLoading();status('正在播放：'+current.name);}
    }
    else if(data.kind==='ended'){
      // 直播超时/失败自动换源（参考 Android）：同频道换下一个源，最后一个源则换下一个频道
      const live=!!current?.meta?.live&&!current?.manualStop;
      endPlayLoading();
      if(live){status(data.error<0?'直播源连接失败，尝试换源…':'直播流中断，尝试换源…');run(()=>liveSwitchNext());}
      else if(data.error<0)status(`播放失败（内核 ${data.error}），请切换线路或检查片源`);
      else if(data.reason===0)completed();
    }
  }).catch(()=>{});
  window.__TAURI__?.event?.listen('tvbox-sniff-result',event=>{const data=event.payload,p=sniffPending;if(!p||p.session!==data.session||p.token!==playGeneration||p.seen.has(data.url))return;p.seen.add(data.url);const b=button(`播放识别结果 ${p.seen.size} · ${data.url.slice(0,100)}`,()=>launch(data.url,p.name,{...p.meta,headers:{...p.meta.headers,Referer:data.referer,'User-Agent':data.ua}},p.token));$('sniff-results').append(b);status(`已识别 ${p.seen.size} 个媒体地址，请选择播放（可能包含广告）`);}).catch(()=>{});
  setInterval(async()=>{if(!current||busyPoll||$('engine').value!=='mpv')return;busyPoll=true;try{const state=await invoke('tvplayer_status');if(state)updateProgress(state);}catch(_){/* next poll retries */}finally{busyPoll=false;}},2000);
  window.TVBOXReady=(async()=>{
    let data=null;if(invoke){try{data=await invoke('tvbox_load');}catch(e){status(String(e));}}
    if(!data){try{const old=JSON.parse(localStorage.getItem(OLD_KEY)||'null');if(old?.profiles)data=old;else if(old?.config)data={profiles:[{id:'migrated',name:'原配置',base:old.base||'',config:old.config}],profileId:'migrated',history:old.history||[]};}catch(_){/* no legacy data */}}
    if(data){db={...db,...data,prefs:{...db.prefs,...data.prefs}};db.profiles=Array.isArray(db.profiles)?db.profiles:[];db.history=Array.isArray(db.history)?db.history.filter(h=>!isLiveRecord(h)):[];db.favorites=Array.isArray(db.favorites)?db.favorites:[];db.unmatched=db.unmatched&&typeof db.unmatched==='object'?db.unmatched:{};db.searchHistory=Array.isArray(db.searchHistory)?db.searchHistory:[];db.sourceHealth=db.sourceHealth&&typeof db.sourceHealth==='object'?db.sourceHealth:{}};
    applyPreferences();setup();if(data)await persist(true);if(profile().collectionBase&&!hasSources(config()))await run(async()=>{await loadCollectionProfile(profile());setup();});
    // 有 JAR 源时后台预热内置 JVM（首次点开片源时不再等进程启动）；延迟启动避免抢启动资源
    if(invoke&&sites().some(s=>/^(?:csp_|com\.github\.catvod\.spider\.)/.test(String(s.api||''))))setTimeout(()=>invoke('tvbox_external_warm').catch(()=>{}),3000);
    // 预取豆瓣热榜（热门搜索数据源），打开搜索面板时即可展示
    setTimeout(()=>ensureHotWords(),1500);
    if(sites().some(C.supported)){
      // 优先恢复上次使用的片源；否则选普通接口源（加载快），避免默认落到 JAR / Python 源等很久
      const saved=db.selectedSite;
      let index=sites().findIndex(s=>C.supported(s)&&(s.key||s.api||s.name)===saved);
      if(index<0)index=sites().findIndex(s=>C.supported(s)&&[0,1,4].includes(Number(s.type)||0));
      if(index<0)index=sites().findIndex(C.supported);
      if(index>=0){
        // 记住的源不可用时自然回退到可用源，并显式同步 selectedSite（不依赖 change 事件）
        const fallback=sites()[index],key=fallback.key||fallback.api||fallback.name;
        if(key&&key!==db.selectedSite){db.selectedSite=key;persist();}
        siteProgrammatic=true;$('site').value=String(index);setTimeout(()=>{siteProgrammatic=false;},0);
      }
      await run(()=>browse(true));
    }
  })();
})();
