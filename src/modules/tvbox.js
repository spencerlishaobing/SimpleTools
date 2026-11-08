(function () {
  'use strict';
  const C=window.TVBoxCore, $=id=>document.getElementById('tv-'+id);
  const invoke=window.__TAURI__?.core?.invoke, dialog=window.__TAURI__?.dialog;
  const OLD_KEY='simpletools-tvbox';
  let db={profiles:[],profileId:'',history:[],favorites:[],unmatched:{},searchHistory:[],cache:{},prefs:{resume:true,autoNext:true,speed:1,volume:100,skipIntro:0,skipOutro:0,hwdec:'auto',selfParser:false,liveTimeout:15,secureDns:'off',cacheTtl:0}};
  let page=1,keyword='',filters={},homeData={},homeSeed={site:'',data:null},view='home',generation=0,playGeneration=0,saveTimer,saveQueue=Promise.resolve();
  let liveChannels=[],liveView=[],liveSources=null,liveCurrent='',liveGroup='',current=null,queue=null,sniffPending=null,lastSave=0,trackSignature='',busyPoll=false;
  let searchPanelOpen=false;
  // 程序化修改站点下拉时置位，避免 value 赋值触发的 change 把 remembered 源覆盖（WebView2 行为差异）
  let siteProgrammatic=false;
  // 用户最近一次真实操作站点下拉的时间（只有用户操作触发的 change 才生效，程序化 change 一律忽略）
  let siteUserTouched=0;
  let xsearch={word:'',groups:[],current:'__all__',done:0,total:0,running:false,token:0};
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
  // 源列表：indexs=1 的推荐源优先展示（对齐 Android 首页推荐源）；保持与 site 下拉 value 索引一致
  const sites=()=>{const list=Array.isArray(config().sites)?config().sites:[];return [...list].sort((a,b)=>Number(b.indexs===1)-Number(a.indexs===1));};
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
    if(invoke){try{const reg=await invoke('tvspiders_registry');adapters=(reg&&Array.isArray(reg.sites))?reg.sites.filter(a=>a&&a.url&&(Array.isArray(a.match)||Array.isArray(a.exact))):[];}catch(_){adapters=[];}}
    return adapters;
  }
  function localAdapter(s){
    // 统一小写比较：仓库里的 api 大小写混用（csp_Wogg / csp_SeedHub），之前大小写敏感导致这些源漏适配、回退到不存在的 JAR 类
    const norm=v=>String(v||'').replace(/^csp_/i,'').replace(/Guard$/i,'').toLowerCase();
    const key=norm(s.api);
    const name=String(s.name||'').toLowerCase();
    const extText=(typeof s.ext==='string'?s.ext:JSON.stringify(s.ext||'')).toLowerCase();
    for(const adapter of adapters||[]){
      if((adapter.exact||[]).some(term=>norm(term)===key))return adapter;
      for(const term of adapter.match||[]){const t=String(term||'').trim().toLowerCase();if(t&&(key.includes(t)||name.includes(t)||extText.includes(t)))return adapter;}
    }
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
  // 请求取消：切仓/切源/取消弹窗时中止挂起的 JAR/Python 请求（避免阻塞与旧数据回写）
  const pendingRequests=new Set();
  let requestSeq=0;
  function cancelPendingTVBox(){
    const list=[...pendingRequests];pendingRequests.clear();
    for(const token of list)invoke('tvbox_cancel',{token}).catch(()=>{});
  }
  // 弹窗被取消：中止挂起的片源请求（用户取消弹窗 = 放弃当前操作）
  window.addEventListener('st-confirm-cancel',()=>cancelPendingTVBox());
  // 已加载/转换过的 JAR（同一 JAR 只提示一次“正在加载”）
  const jarReady=new Set();
  async function apiRaw(s,action,args={},p=profile(),cancelToken=null) {
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
          try{
            return await invoke('tvbox_spider',{api:adapter.url,key:s.key||s.name||'local',ext,action,args:{...args,flags:p.config.flags||[]}});
          }catch(error){
            // 站点临时触发 WAF 或改版时保留可用性：用户允许源自带解析时继续走下方 JAR。
            // 未开启兼容时仍把本地适配器的明确错误交给界面展示。
            if(!db.prefs.selfParser)throw error;
            status('内置解析暂不可用，正在回退源自带解析…');
          }
        }
      }
      // 2) JS / Python 脚本源本身就是轻量解析器，直接运行
      if(isJs)return invoke('tvbox_spider',{api:address(sourceApi,p.base),key:s.key||s.name||'js',ext,action,args:{...args,flags:p.config.flags||[]}});
      let jar=s.jar||p.config.spider||'';
      if(jar){const parts=jar.split(';md5;');parts[0]=address(parts[0],p.base);jar=parts.join(';md5;');}
      if(isPy){
        status('正在运行 Python 片源…');
        return invoke('tvbox_external',{api:address(sourceApi,p.base),jar:jar||null,key:s.key||s.name||'source',ext,action,args:{...args,flags:p.config.flags||[]},cancelToken});
      }
      // 3) JAR 自带解析（慢）：未适配站点先记录；默认策略下提示可开启自带解析
      noteUnmatched(s);
      // 搜索时不受“源自带解析兼容”开关限制（对齐 Android：搜索包含全部可搜索源，包括 JAR 源）
      if(!db.prefs.selfParser&&action!=='search')throw Error(`「${s.name||'该站点'}」暂未适配本地解析（已记录到待适配清单）；可在设置中勾选「源自带解析兼容」使用片源自带爬虫`);
      // JAR 首次加载/转换提示只在首次显示（后续源共享缓存，不再反复提示）
      if(!jarReady.has(jar))status('正在加载 JAR 片源（首次转换，之后所有源共享缓存）…');
      const task=invoke('tvbox_external',{api:sourceApi,jar:jar||null,key:s.key||s.name||'source',ext,action,args:{...args,flags:p.config.flags||[]},cancelToken});
      task.then(()=>jarReady.add(jar)).catch(()=>{});
      return task;
    }
    const data=await fetchText(C.request(s,action,args,p.base),s.header||s.headers||{});
    return action==='play'?C.json(data):C.response(data,s.type);
  }
  // 源健康度/冷却已移除（对齐 Android：不做源停用，全部源每次搜索都参与）
  function sourceKey(s,p=profile()){return `${p.id}:${s.key||s.api||s.name}`;}
  // 请求包装：统一超时/取消（不记录源健康度）
  async function api(s,action,args={},p=profile()) {
    const cancelToken=`r${++requestSeq}-${Date.now()}`;
    pendingRequests.add(cancelToken);
    // 单源超时：优先用配置的 timeout 秒数（对齐 Android），默认 30 秒
    const timeoutMs=Math.max(5,Number(s?.timeout)||30)*1000;
    try{return await withTimeout(apiRaw(s,action,args,p,cancelToken),timeoutMs,`片源响应超时（${Math.round(timeoutMs/1000)} 秒）`);}
    finally{pendingRequests.delete(cancelToken);}
  }
  function switchView(next) {
    const prev=view;view=next;generation++;
    // 切换视图：取消上个视图尚未完成的片源请求，释放后台资源
    cancelPendingTVBox();
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
    const select=$('site'),previous=select.value,word=term.trim().toLowerCase();
    // 重建下拉期间全程标记程序化（WebView2 下 options 重建/赋值会异步触发 change，会把 remembered 源覆盖成第一个源）
    siteProgrammatic=true;
    try{
      select.replaceChildren();
      sites().forEach((s,i)=>{
        if(word&&!`${s.name||''} ${s.key||''} ${s.api||''}`.toLowerCase().includes(word))return;
        option(select,i,`${C.supported(s)?'':'[环境不兼容] '}${s.name||s.key||'片源'}`);
      });
      select.disabled=!select.options.length;
      if(select.options.length)select.value=Array.from(select.options).some(o=>o.value===previous)?previous:select.options[0].value;
      return select.options.length;
    }finally{setTimeout(()=>{siteProgrammatic=false;},0);}
  }
  function setup() {
    const p=profile();$('profile').replaceChildren();db.profiles.forEach(p=>option($('profile'),p.id,p.name));$('profile').value=p.id;
    $('profile-name').value=p.name;const configUrl=p.collectionBase||p.base;$('config-url').value=configUrl.startsWith('http')?configUrl:'';
    $('config-editor').value=p.id?JSON.stringify(config(),null,2):'';
    renderSiteOptions();
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
    for(const [id,key] of [['speed','speed'],['volume','volume'],['skip-intro','skipIntro'],['skip-outro','skipOutro'],['hwdec','hwdec'],['secure-dns','secureDns']])$(id).value=String(db.prefs[key]??'');
    $('cache-ttl').value=String(db.prefs.cacheTtl??0);
    $('sub-size').value=String(db.prefs.subSize??55);
    $('sub-color').value=String(db.prefs.subColor||'#ffffff');
    $('sub-bold').checked=db.prefs.subBold===true;
    $('self-parser').checked=db.prefs.selfParser===true;
    $('live-timeout').value=String(db.prefs.liveTimeout??15);
  }
  const hasSources=conf=>conf&&(Array.isArray(conf.sites)||Array.isArray(conf.lives));
  async function loadCollectionProfile(p) {
    if(hasSources(p.config))return;
    beginLoading(`正在加载「${p.name}」配置…`);
    try{
      const clean=String(await withTimeout(fetchText(p.base),30000,'配置加载超时（30 秒），请检查网络后重试')).replace(/^\uFEFF/,'').trim();
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
  let filterPanelOpen=false;
  function renderFilters() {
    const box=$('filters');box.replaceChildren();
    // 筛选条件完全跟随当前分类（来自源配置 filters[type_id]）：不同分类有各自的筛选，
    // 当前分类没有配置筛选时不显示（不回退到其他分类，避免显示不相关条件）
    let groups=homeData.filters?.[$('category').value];
    groups=groups||[];
    if(!groups.length){filterPanelOpen=false;return;}
    // 已选条件（参考 Android）：每个条件默认选中「全部」；已选条数显示在筛选按钮上
    const chosen=groups.map(group=>{
      const current=String(filters[group.key]??'');
      if(current==='')return null;
      const opt=(group.value||[]).find(o=>String(o.v)===current);
      return opt?`${group.name}=${opt.n}`:null;
    }).filter(Boolean);
    const head=el('div',undefined,'tv-filter-head');
    const toggle=button(`${filterPanelOpen?'收起':'筛选'}${chosen.length?` (${chosen.length})`:''}`,()=>{filterPanelOpen=!filterPanelOpen;renderFilters();},'tv-filter-toggle');
    toggle.classList.toggle('is-expanded',filterPanelOpen);
    if(filterPanelOpen)toggle.classList.add('is-open');
    head.append(toggle,el('span',chosen.length?chosen.join(' · '):'全部','tv-filter-summary'));
    box.append(head);
    if(!filterPanelOpen)return;
    for(const group of groups){
      const row=el('div',undefined,'tv-filter-row');
      row.append(el('span',group.name||group.key,'tv-filter-name'));
      const opts=el('div',undefined,'tv-filter-options');
      const current=String(filters[group.key]??'');
      // 「全部」选项（默认选中）——对齐 Android 每行筛选的「全部」项
      const allChip=button('全部',()=>{delete filters[group.key];page=1;run(()=>browse());},'tv-filter-opt');
      if(current==='')allChip.classList.add('is-selected');
      opts.append(allChip);
      for(const opt of (group.value||[])){
        if(String(opt.v)==='')continue; // 配置里的空值统一由「全部」承担
        const chip=button(opt.n,()=>{filters[group.key]=opt.v;page=1;run(()=>browse());},'tv-filter-opt');
        if(String(opt.v)===current)chip.classList.add('is-selected');
        opts.append(chip);
      }
      row.append(opts);box.append(row);
    }
  }
  // 左侧分组导航（左右布局）：影视 = 分类列；直播 = 直播源列 + 分组列（多层分组多列）
  // 左侧源/分组列表：按钮文字最多一行，放不下时 title + hover 跑马灯
  function navButton(text,onclick){
    const b=button('',onclick);b.title=text;b.append(el('span',text));return b;
  }
  function renderSidenav(){
    const nav=$('sidenav');if(!nav)return;
    nav.replaceChildren();
    if(view==='live'){
      const sources=ensureLiveSources();
      const sourceCol=el('div',undefined,'tv-nav-col');
      sources.forEach(s=>{const b=navButton(s.name,()=>run(()=>loadLiveSource(s.id)));b.classList.toggle('is-selected',s.id===liveCurrent);sourceCol.append(b);});
      nav.append(sourceCol);
      const groups=[...new Set(liveChannels.map(c=>c.group).filter(Boolean))];
      if(groups.length){
        const col=el('div',undefined,'tv-nav-col');
        const all=navButton('全部分组',()=>{liveGroup='';renderLive();});all.classList.toggle('is-selected',!liveGroup);col.append(all);
        groups.forEach(g=>{const b=navButton(g,()=>{liveGroup=g;renderLive();});b.classList.toggle('is-selected',liveGroup===g);col.append(b);});
        nav.append(col);
      }
    }else if(view==='xsearch'){
      const col=el('div',undefined,'tv-nav-col');
      // 只显示有结果的源（搜索进行中随结果陆续出现）
      const visible=xsearch.groups.filter(g=>g.count>0);
      if(xsearch.current!=='__all__'&&!visible.some(g=>g.key===xsearch.current))xsearch.current='__all__';
      // 第一项「全部」：当前仓所有源搜索结果的合集
      const total=xsearch.groups.reduce((n,g)=>n+g.count,0);
      const all=navButton(`全部${total?` (${total})`:''}`,()=>{xsearch.current='__all__';renderSidenav();renderXSearch();});
      all.classList.toggle('is-selected',xsearch.current==='__all__');
      col.append(all);
      visible.forEach(g=>{
        const b=navButton(`${g.name}${g.count?` (${g.count})`:''}`,()=>{xsearch.current=g.key;renderSidenav();renderXSearch();});
        b.dataset.key=g.key;
        b.classList.toggle('is-selected',xsearch.current===g.key);
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
  function startSearch(word){
    word=String(word||'').trim();if(!word)return;
    if(view==='live'){recordSearch(word);$('keyword').value=word;searchPanelOpen=false;return renderLive();}
    return searchWarehouse(word);
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
  // 图片加载队列：不再依赖 IntersectionObserver（WebView2 窗口后台/不可见时 IO 不回调，封面会一直空白），
  // 直接加载并限制并发 6 个，避免一次渲染几百张图打爆后台图片代理
  const posterQueue=[];
  let posterActive=0;
  let posterDebugCount=0;
  function loadPoster(img){
    const target=img.dataset.src;if(!target)return Promise.resolve();
    if(img.dataset.loading==='1')return Promise.resolve();
    img.dataset.loading='1';
    if(img.dataset.proxy==='1'&&invoke)return invoke('tvbox_image',{url:target,referer:img.dataset.referer||null,userAgent:img.dataset.ua||null}).then(data=>{img.src=data;}).catch(()=>{img.remove();});
    img.src=target;return Promise.resolve();
  }
  function queuePoster(img){posterQueue.push(img);pumpPoster();}
  function pumpPoster(){
    while(posterActive<6&&posterQueue.length){
      const img=posterQueue.shift();
      // 注意：poster() 在卡片还未插入 DOM 时调用，不能因 isConnected=false 丢弃（<img> 不挂载也能加载）
      if(!img)continue;
      posterActive++;
      loadPoster(img).finally(()=>{posterActive--;pumpPoster();});
    }
  }
  function posterUrl(value){
    if(typeof value==='string')return value.trim();
    if(Array.isArray(value))return posterUrl(value.find(Boolean));
    if(value&&typeof value==='object')return posterUrl(value.url||value.src||value.pic||value.normal||value.large);
    return '';
  }
  const posterSearchCache=new Map();
  let posterRepairBudget=36;
  async function posterFor(title){
    const key=normalizeTitle(title);if(!key)return '';
    let pending=posterSearchCache.get(key);
    if(!pending){pending=invoke('tvbox_poster_search',{title:String(title).trim()}).catch(()=> '');posterSearchCache.set(key,pending);}
    return await pending;
  }
  async function enrichMissingPosters(list,word){
    if(!invoke||!Array.isArray(list)||!list.length)return list;
    const missing=list.filter(v=>!posterUrl(v?.vod_pic));
    if(!missing.length)return list;
    // 兜底：搜索词本身的封面（列表同名资源可共用）
    let fallback='';
    if(String(word||'').trim())fallback=await posterFor(word);
    // 搜索页先立即填充同一影视关键词的代表封面，避免每个源都等待最多 24 次
    // 外部查询后才渲染，造成几十秒全是占位图。不同标题的精确匹配由卡片层异步修复。
    if(fallback)for(const v of missing)if(!v.vod_pic)v.vod_pic=fallback;
    if(fallback)return list;
    // 逐条按各自片名匹配（前 24 条，并发 4）：标题清洗 + 相似度在 Rust 侧完成，命中率远高于共用搜索词
    const targets=missing.slice(0,24);
    let index=0;
    const workers=Array.from({length:4},async()=>{
      while(index<targets.length){
        const v=targets[index++];
        const title=String(v?.vod_name||'').trim();
        const found=title?await posterFor(title):'';
        v.vod_pic=found||fallback;
      }
    });
    await Promise.all(workers);
    for(const v of missing.slice(24))if(!v.vod_pic&&fallback)v.vod_pic=fallback;
    return list;
  }
  // 相对海报必须相对于影片/资源站解析。之前统一使用多仓配置地址，导致 /poster.jpg
  // 被拼到 github.catvod.com 等配置代理域名，列表与详情页都会显示失败。
  function posterBase(v,s,p){
    for(const candidate of [v?.vod_id,s?.api,p?.base]){
      const value=String(candidate||'').split(';')[0];
      if(/^https?:\/\//i.test(value)){try{return new URL('.',value).href;}catch(_){/* next */}}
    }
    return p?.base||'';
  }
  function poster(node,url,base) {
    url=posterUrl(url);if(!url)return;
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
      const isSiteImageProxy=/\/db\.php\?url=/i.test(target);
      let proxyReferer=referer;
      if(!proxyReferer){
        if(isDouban)proxyReferer='https://movie.douban.com/';
        else try{proxyReferer=base?new URL(base).origin+'/':new URL(target).origin+'/';}catch(_){/* invalid */}
      }
      const img=el('img');img.referrerPolicy='no-referrer';img.alt='';
      img.dataset.src=target;
      if((at>0||isDouban||isSiteImageProxy)&&invoke){img.dataset.proxy='1';img.dataset.referer=proxyReferer||'';if(userAgent)img.dataset.ua=userAgent;}
      img.onload=()=>img.classList.add('is-loaded');
      // 直连失败（防盗链 / 需要 Referer 的图床）时，回退到后台代理带站点 Referer 重试一次
      img.onerror=()=>{
        if(!invoke||img.dataset.fallback)return img.remove();
        img.dataset.fallback='1';
        invoke('tvbox_image',{url:target,referer:proxyReferer||null,userAgent:userAgent||null}).then(data=>{img.src=data;}).catch(()=>img.remove());
      };
      node.prepend(img);
      if(posterDebugCount<3)console.log('[poster-v3]',target.slice(0,60),'proxy='+(img.dataset.proxy||''),'queue='+posterQueue.length,'active='+posterActive);
      posterDebugCount++;
      queuePoster(img);
    }catch(error){console.error('poster failed',error);}
  }
  function movieCard(v,s,p,onActivate) {
    // 片单型数据（豆豆/玩偶 home 夹带片单项）没有 vod_id：点卡片直接按片名搜当前仓，不去等 30 秒详情超时
    const activate=onActivate||(()=>{
      const vid=String(v.vod_id||'').trim();
      // 豆瓣片单卡（subject:xxx）没有可播详情：直接按片名搜索，避免等 JAR 详情 30 秒超时
      if(/^subject:/i.test(vid)){
        const name=String(v.vod_name||'').trim();
        if(!name){status('该卡片没有可用的详情信息');return;}
        status(`「${name}」为片单推荐，正在当前仓搜索…`);
        return run(()=>searchWarehouse(name));
      }
      if(!vid){
        const name=String(v.vod_name||'').trim();
        if(!name){status('该卡片没有可用的详情信息');return;}
        status(`「${name}」为片单推荐，正在当前仓搜索…`);
        return run(()=>searchWarehouse(name));
      }
      return detail(v.vod_id,s,p,null,v);
    });
    const card=button('',activate,'tv-card'),art=el('div',undefined,'tv-poster');
    // 调试/防误触：卡片上记录原始 id 与名称（无 vod_id 的片单卡会走按名转搜）
    card.dataset.vid=String(v.vod_id||'');card.dataset.name=String(v.vod_name||'');
    art.append(el('span','TV','tv-poster-fallback'));
    const initialPoster=posterUrl(v.vod_pic);
    if(initialPoster)poster(art,initialPoster,posterBase(v,s,p));
    else if(invoke){
      // 首页、历史、网盘聚合项不一定经过 enrichMissingPosters；在卡片层再兜底一次，
      // 查到后回写原对象，随后进入详情页也能继续复用同一张封面。
      posterFor(v.vod_name).then(found=>{
        if(!found||art.querySelector('img'))return;
        v.vod_pic=found;poster(art,found,posterBase(v,s,p));
      }).catch(()=>{});
    }
    // 一些源会返回格式正确但已失效/防盗链不可用的图片地址。给原图与代理重试留出时间，
    // 仍未成功才按片名查公共海报；设置页面级预算，避免长列表瞬间发出过多请求。
    if(invoke&&initialPoster&&posterRepairBudget>0)setTimeout(()=>{
      if(art.querySelector('img.is-loaded')||posterRepairBudget<=0)return;
      posterRepairBudget--;
      posterFor(v.vod_name).then(found=>{
        if(!found||posterUrl(found)===initialPoster||art.querySelector('img.is-loaded'))return;
        art.querySelectorAll('img').forEach(img=>img.remove());
        v.vod_pic=found;poster(art,found,posterBase(v,s,p));
      }).catch(()=>{});
    },4500);
    if(v.vod_remarks)art.append(el('span',v.vod_remarks,'tv-card-remark'));
    // 标题最多一行（CSS 截断）；完整名称放 title / 内部 span 供 hover 跑马灯
    const name=String(v.vod_name||'未命名');
    const title=el('strong');title.title=name;title.append(el('span',name));
    card.append(art,title);
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
  function searchResultList(list,word){return filterRelevantResults(list,word);}
  // 单请求超时（借鉴 LibreTV 搜索单源死线）：坏源/慢源不拖住整体队列
  function withTimeout(promise,ms,message){return Promise.race([promise,new Promise((_,reject)=>setTimeout(()=>reject(new Error(message||'请求超时')),ms))]);}
  // 慢操作提示（不中断）：切换源/仓超过 30 秒仅提示“较慢”（JAR 首次转换可能更久，完成后正常渲染）
  function warnAfter(ms,message){const timer=setTimeout(()=>status(message),ms);return ()=>clearTimeout(timer);}
  // 搜索并发数：多源并行请求（每源 1 请求、不同站点互不影响；后端 JVM 16 线程池 / Python ThreadingHTTPServer 均支持并行）
  // 搜索并发：对齐 Android FastSearchActivity（SDK≥30 最大 18 线程，单源超时 10s→我们 8s 快速失败）
  // 一个多仓可能展开出近千个可搜索站点，其中相当一部分需要启动 JVM/JAR
  // 适配器。Windows 下同时拉起十几个 JVM 会让宿主进程触发 0xc0000409
  // (BEX64)；搜索虽快一点，但整机与应用都不稳定。限制为 4 个并发，和
  // 海报补全并发保持一致，剩余源继续排队渐进展示。
  const SEARCH_CONCURRENCY=4;
  // 搜索单源超时：对齐 Android FastSearchActivity（SEARCH_SITE_TIMEOUT_SECONDS = 10）
  const SEARCH_SOURCE_TIMEOUT=10000;
  // 源配置 style 布局（对齐 Android）：list=列表行、rect/oval=海报图标样式；ratio=封面比例
  function applyResultStyle(s){
    const results=$('results');if(!results)return;
    results.classList.remove('tv-style-list','tv-style-rect','tv-style-oval');
    const style=(s&&s.style)||{};const type=String(style.type||'').toLowerCase();
    if(type==='list')results.classList.add('tv-style-list');
    else if(type==='rect')results.classList.add('tv-style-rect');
    else if(type==='oval')results.classList.add('tv-style-oval');
    // ratio：封面宽高比（如 1.597 / 3.8），无配置则用默认海报比例
    const ratio=Number(style.ratio);
    if(ratio>0&&ratio<10)results.style.setProperty('--tv-poster-ratio',String(ratio));else results.style.removeProperty('--tv-poster-ratio');
  }
  function renderMovies(list,s,p=profile(),append=false) {
    if(!append)$('results').replaceChildren();
    applyResultStyle(s);
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
        // 切源/回列表：优先用本地持久缓存（设置可选 1 天/1 周/1 年/永久），命中秒开
        const homeCacheKey=sourceKey(s,p);
        const cacheTtl=Number(db.prefs.cacheTtl)||0;
        const homeCached=db.cache&&db.cache[homeCacheKey];
        const fresh=homeCached&&(cacheTtl===0||Date.now()-Number(homeCached.at||0)<cacheTtl);
        if(fresh){homeData=homeCached.data;}
        else{const loaded=await api(s,'home',{},p);if(token!==generation)return;homeData=loaded;db.cache=db.cache&&typeof db.cache==='object'?db.cache:{};db.cache[homeCacheKey]={at:Date.now(),data:loaded};persist();}
        // class 缺失/为空时也置为空数组，避免每次 browse 重复请求并重复追加默认分类
        if(!Array.isArray(homeData.class))homeData.class=[];
        $('category').replaceChildren();
        option($('category'),'','推荐 / 全部');const seenCats=new Set(['推荐 / 全部']);(homeData.class||[]).forEach(c=>{const name=String(c.type_name||'').trim();if(!name||seenCats.has(name))return;seenCats.add(name);option($('category'),c.type_id,name);});
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
      if(keyword&&data){data={...data,list:searchResultList(data.list||[],keyword)};await enrichMissingPosters(data.list,keyword);}
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
      if(keyword)await enrichMissingPosters(data.list||[],keyword);
      if(token!==generation)return;
      renderMovies(data.list||[],s,p,true);
      lastBrowseHadMore=Number(data.pagecount)>0?page<Number(data.pagecount):(data.list||[]).length>0;
      $('page').textContent=`第 ${page} 页${Number(data.pagecount)>0?' / '+data.pagecount:''}`;
      $('prev').disabled=page<=1;
      $('next').disabled=!data.list?.length||(Number(data.pagecount)>0&&page>=Number(data.pagecount));
      status((data.list||[]).length?`已加载第 ${page} 页 · 当前共 ${$('results').querySelectorAll('.tv-card').length} 部影片`:'已全部加载');
    }catch(e){if(token!==generation)return;page--;status('加载更多失败：'+e.message);}finally{loadMoreBusy=false;endLoading();}
  }
  const loadMoreObserver=typeof IntersectionObserver!=='undefined'?new IntersectionObserver(entries=>{
    if(entries.some(entry=>entry.isIntersecting))run(()=>loadMore());
  },{rootMargin:'480px'}):null;
  // 搜索视图（参考 Android）：只搜当前仓的源——搜索框在第一行，左侧源列表（第一项「全部」=所有源结果的合集），
  // 右侧是选中源的结果宫格（按搜索结果返回顺序排列）；后台并发搜索，结果渐显不阻塞
  async function searchWarehouse(word){
    word=String(word||'').trim();if(!word)throw Error('输入片名后搜索');
    recordSearch(word);$('keyword').value=word;searchPanelOpen=false;
    delete $('results').dataset.xsearchBuilt; // 新搜索：重新建搜索视图骨架
    view='xsearch';const token=++generation;
    const panel=document.getElementById('panel-tvbox');panel.dataset.view='xsearch';panel.classList.remove('tv-detail-mode');
    $('settings-panel').classList.add('hidden');$('library').classList.remove('hidden');$('settings-tab').classList.remove('is-selected');$('detail-back').classList.add('hidden');$('clear-history').classList.add('hidden');
    for(const key of ['home','live','favorites','history'])$(key).classList.remove('is-selected');
    $('section-title').textContent='搜索';$('onboarding').classList.add('hidden');
    $('detail').replaceChildren();$('epg').replaceChildren();$('filters').replaceChildren();$('categories').replaceChildren();
    $('prev').disabled=$('next').disabled=true;
    const p=profile();
    const all=sites().filter(s=>C.supported(s)&&Number(s.searchable??1)!==0);
    // 对齐 Android：搜索尝试全部可搜索源
    const sources=all;
    xsearch={word,groups:sources.map(s=>({key:sourceKey(s,p),name:s.name||s.key||'源',site:s,list:[],count:0,done:0})),current:'__all__',done:0,total:sources.length,running:true,token};
    renderSidenav();renderXSearch();
    status(`搜索「${word}」：当前仓 ${sources.length} 个源`);
    if(!sources.length){xsearch.running=false;status('当前仓没有可搜索的源，请先在设置中加载或导入配置');return;}
    let index=0;const total=sources.length;
    async function worker(){
      while(index<total&&xsearch.token===token){
        const group=xsearch.groups[index++];
        try{const timeout=Math.min(45000,Math.max(SEARCH_SOURCE_TIMEOUT,(Number(group.site.timeout)||20)*1000));const data=await withTimeout(api(group.site,'search',{keyword:word,page:1},p),timeout);if(xsearch.token!==token)return;group.list=filterRelevantResults(Array.isArray(data.list)?data.list:[],word);if(group.list.length)group.count+=group.list.length;}
        catch(_){if(xsearch.token!==token)return;group.error=true;}
        if(xsearch.token!==token)return;
        group.done=1;xsearch.done++;
        if(view==='xsearch'){scheduleXSearchRender();status(`搜索 ${xsearch.done}/${total} · ${xsearch.groups.reduce((n,g)=>n+g.count,0)} 个结果`);}
      }
    }
    await Promise.all(Array.from({length:Math.min(SEARCH_CONCURRENCY,Math.max(total,1))},worker));
    if(xsearch.token!==token)return;
    xsearch.running=false;
    if(view==='xsearch'){updateXSearchSidenav();renderXSearch();status(`搜索完成：${xsearch.groups.reduce((n,g)=>n+g.count,0)} 个结果 · 「${word}」`);}
  }
  // 结果渐显节流：最多每 400ms 刷新一次；只更新计数文字 + 增量追加新源结果（不重建 DOM，避免闪动）
  let xsearchRenderTimer=0;
  function scheduleXSearchRender(){
    if(xsearchRenderTimer)return;
    xsearchRenderTimer=setTimeout(()=>{
      xsearchRenderTimer=0;
      if(view!=='xsearch')return;
      updateXSearchSidenav();
      renderXSearch();
    },400);
  }
  // 左侧源列表：只更新按钮文字（计数），不重建 DOM（保留选中态与滚动位置）
  function updateXSearchSidenav(){
    const nav=$('sidenav');if(!nav)return;
    // 只显示有数据的源（搜索进行中随结果陆续出现；0 结果源不占列表）
    const visible=xsearch.groups.filter(g=>g.count>0);
    const btns=nav.querySelectorAll('.tv-nav-col button');
    if(btns.length!==visible.length+1)return renderSidenav();
    const total=xsearch.groups.reduce((n,g)=>n+g.count,0);
    const setText=(btn,text)=>{btn.title=text;const span=btn.querySelector('span');if(span)span.textContent=text;else btn.textContent=text;};
    setText(btns[0],`全部${total?` (${total})`:''}`);
    visible.forEach((g,i)=>{const btn=btns[i+1];if(btn.dataset.key!==g.key)return renderSidenav();setText(btn,`${g.name}${g.count?` (${g.count})`:''}`);});
  }
  function renderXSearch(){
    if(view!=='xsearch')return;
    const container=$('results');
    // 首次进入搜索视图只建一次骨架（头部），卡片直接参与 #tv-results 自身的网格，之后仅增量更新
    if(!container.dataset.xsearchBuilt){
      container.replaceChildren();
      const head=el('div',undefined,'tv-xsearch-head');head.append(el('strong',''),el('span','','tv-cluster-label'));
      container.append(head);
      container.dataset.xsearchBuilt='1';
    }
    const head=container.querySelector('.tv-xsearch-head');
    if(!head)return;
    const all=xsearch.current==='__all__';
    const groups=all?xsearch.groups:xsearch.groups.filter(g=>g.key===xsearch.current);
    const totalCount=xsearch.groups.reduce((n,g)=>n+g.count,0);
    head.querySelector('strong').textContent=all?`「${xsearch.word}」的全部结果`:`「${groups[0]?groups[0].name:''}」的搜索结果`;
    head.querySelector('span').textContent=`${all?totalCount:(groups[0]?groups[0].count:0)} 个 · ${xsearch.done}/${xsearch.total} 个源已返回${xsearch.running?' · 搜索中…':''}`;
    // 切源：移除不在当前视图的组（源数据已缓存，切回时重建该组即可）
    const wanted=new Set(groups.map(g=>g.key));
    for(const child of [...container.children]){
      if(child.dataset&&child.dataset.key&&!wanted.has(child.dataset.key))child.remove();
    }
    // 增量：新完成的源直接追加组（组用 display:contents，卡片直接参与外层网格；按完成顺序 = 结果出来顺序）
    const p=profile();
    for(const group of groups){
      if(!group.list.length)continue;
      let groupEl=null;
      for(const child of container.children){if(child.dataset&&child.dataset.key===group.key){groupEl=child;break;}}
      if(!groupEl){
        groupEl=el('div',undefined,'tv-xsearch-group');
        groupEl.style.display='contents';
        groupEl.dataset.key=group.key;
        container.append(groupEl);
      }
      if(!groupEl.dataset.rendered){
        for(const v of group.list)groupEl.append(movieCard(v,group.site,p));
        groupEl.dataset.rendered='1';
      }
    }
    // 空状态
    let empty=container.querySelector('.tv-empty');
    if(!container.querySelector('.tv-xsearch-group')){
      if(!empty)container.append(el('div',xsearch.running?'正在搜索…':'没有找到相关影片','tv-empty'));
      else empty.textContent=xsearch.running?'正在搜索…':'没有找到相关影片';
    }else if(empty)empty.remove();
  }
  function movieKey(v,s,p){return `${p.id}:${s.key||s.api}:${v.vod_id}`;}
  // 每源 home 持久缓存（默认永久，设置可选 1 天/1 周/1 年）：切源/切回秒开
  const siteHomeCache=new Map();
  // 详情内存缓存：同源同 id 5 分钟内复用（慢源/网盘源来回点列表不必重复请求，体验对齐 Android）
  const detailCache=new Map();
  async function detail(id,s,p=profile(),resumeContext=null,movie=null) {
    // 片单型数据（无 vod_id）：不请求详情，直接按片名搜索当前仓（对齐 Android 片单点卡片）
    if(!String(id||'').trim()){
      const name=String(movie?.vod_name||'').trim();
      if(name){status(`「${name}」无详情，正在按片名搜索当前仓…`);return searchWarehouse(name);}
      throw Error('该影片没有可用于详情解析的 ID');
    }
    const token=++generation;status('正在加载影片详情…');
    // 详情不弹全局遮罩：详情区先占位，避免慢源阻塞整个界面（对齐 Android 页面内加载）
    $('detail').replaceChildren(el('div','正在加载影片详情…','tv-empty'));
    let data;
    const cacheKey=`${sourceKey(s,p)}|${id}`;
    const cached=detailCache.get(cacheKey);
    if(cached&&Date.now()-cached.at<300000)data=cached.data;
    else try{
      // 夸克/UC/百度/阿里 分享直接读取目录并把真实视频文件展示为选集，避免只显示“打开资源”且播放错文件。
      if(/^https?:\/\/(?:pan\.quark\.cn|drive\.uc\.cn|pan\.baidu\.com|(?:www\.)?(?:alipan|aliyundrive)\.com)\/s\//i.test(String(id))&&invoke){
        const cloud=await withTimeout(invoke('tvbox_cloud_detail',{url:String(id)}),30000,'网盘目录加载超时');
        const files=Array.isArray(cloud?.files)?cloud.files:[];
        if(files.length){
          const fallbackName=String(movie?.vod_name||'网盘资源');
          data={list:[{vod_id:String(id),vod_name:fallbackName,vod_pic:movie?.vod_pic||'',vod_content:`共找到 ${files.length} 个视频文件`,vod_play_from:cloud.site==='uc'?'UC网盘':cloud.site==='baidu'?'百度网盘':cloud.site==='alipan'?'阿里云盘':'夸克网盘',vod_play_url:files.map(file=>`${String(file.name||'视频').replace(/[$#]/g,'·')}$${file.play}`).join('#')}]};
        }
      }
      if(!data)data=await withTimeout(api(s,'detail',{id},p),30000,'详情加载超时（30 秒），该源响应过慢');
      detailCache.set(cacheKey,{at:Date.now(),data});
    }
    catch(error){
      if(token!==generation)throw error;
      // 片单/推荐类源（豆豆等 searchable=0）：详情超时/失败时按片名去当前仓搜索其他可播源（对齐 Android 片单点卡片）
      const name=String(movie?.vod_name||'').trim();
      if(name){status(`「${s.name||'当前源'}」详情不可用，正在按片名搜索「${name}」`);await searchWarehouse(name);return;}
      $('detail').replaceChildren(el('div',`加载失败：${error&&error.message?error.message:error}`,'tv-empty'));throw error;
    }
    if(token!==generation)return;
    const v=data.list?.[0];
    if(!v){
      // 片单展示源（如豆瓣推荐）：不提供播放详情。自动拿片名去其他片源搜索，闭环到可播放的源
      const name=String(movie?.vod_name||'').trim();
      if(name){status(`「${s.name}」为片单推荐源，正在当前仓搜索「${name}」`);await searchWarehouse(name);return;}
      throw Error('该片源仅提供片单推荐，暂无可播放详情');
    }
    // 不少接口的详情响应省略海报，但列表响应已有完整 vod_pic；保留列表海报用于详情、收藏和播放历史。
    if(!posterUrl(v.vod_pic)&&posterUrl(movie?.vod_pic))v.vod_pic=movie.vod_pic;
    const choices=C.lines(v);
    // A site detail page (notably WoGG) often exposes one cloud share as a generic
    // "打开资源" episode. Expand Quark/UC/Baidu/Alipan shares here so the detail page shows
    // the real filenames/episodes before playback, matching TVBox's Pan detail behavior.
    if(invoke){
      const expanded=new Map();
      await Promise.all(choices.flatMap(line=>line.episodes.map(async ep=>{
        const share=String(ep.url||'').match(/^https?:\/\/(?:pan\.quark\.cn|drive\.uc\.cn|pan\.baidu\.com|(?:www\.)?(?:alipan|aliyundrive)\.com)\/s\/[^\s"'<>]+/i)?.[0];
        if(!share)return;
        let pending=expanded.get(share);
        if(!pending){pending=withTimeout(invoke('tvbox_cloud_detail',{url:share}),30000,'网盘目录加载超时').catch(()=>null);expanded.set(share,pending);}
        const cloud=await pending,files=Array.isArray(cloud?.files)?cloud.files:[];
        if(!files.length)return;
        ep._cloudFiles=files.map(file=>({
          name:String(file.name||'视频').replace(/[$#]/g,'·'),
          url:String(file.play||share)
        }));
      })));
      for(const line of choices){
        const result=[];
        for(const ep of line.episodes)result.push(...(ep._cloudFiles||[ep]));
        line.episodes=result;
      }
    }
    const container=$('detail');container.replaceChildren();$('epg').replaceChildren();
    const panel=document.getElementById('panel-tvbox');panel.classList.add('tv-detail-mode');$('detail-back').classList.remove('hidden');$('section-title').textContent=v.vod_name||'影片详情';
    const key=movieKey(v,s,p),heading=el('div',undefined,'tv-detail-heading');heading.append(el('h3',v.vod_name||'影片详情'));
    const favorite=button('',()=>{const index=db.favorites.findIndex(f=>f.key===key);if(index>=0)db.favorites.splice(index,1);else db.favorites.push({key,kind:'movie',movie:v,site:s,profileId:p.id,base:p.base});favorite.textContent=db.favorites.some(f=>f.key===key)?'★ 已收藏':'☆ 收藏';persist();});
    favorite.textContent=db.favorites.some(f=>f.key===key)?'★ 已收藏':'☆ 收藏';heading.append(favorite);container.append(heading);
    const body=el('div',undefined,'tv-detail-body'),art=el('div',undefined,'tv-detail-poster');
    art.append(el('span','TV','tv-poster-fallback'));poster(art,v.vod_pic,posterBase(v,s,p));body.append(art);
    const info=el('div',undefined,'tv-detail-info');
    info.append(el('p',[v.type_name,v.vod_year,v.vod_area,v.vod_director?'导演 '+v.vod_director:'',v.vod_actor?'主演 '+v.vod_actor:''].filter(Boolean).join(' · '),'tv-detail-meta'));
    const summary=el('p',String(v.vod_content||'').replace(/<[^>]*>/g,'')||'暂无简介','tv-synopsis');info.append(summary);
    container.append(body);body.append(info);
    if(!choices.length){
      // 片单型数据（无播放线路）：按片名搜当前仓其他可播源（对齐 Android 片单点卡片）
      const nm=String(v.vod_name||movie?.vod_name||'').trim();
      if(nm){status(`「${s.name}」无播放线路，正在按片名搜索「${nm}」`);await searchWarehouse(nm);return;}
      status('此影片没有播放线路');return;
    }
    const episodes=el('section',undefined,'tv-detail-playlist');container.append(episodes);
    const chips=el('div',undefined,'tv-line-chips');episodes.append(chips,el('h4','选集','tv-episodes-title'));
    const row=el('div',undefined,'tv-episodes');episodes.append(row);
    function renderLine(lineIndex){row.replaceChildren();chips.querySelectorAll('button').forEach((chip,i)=>chip.classList.toggle('is-selected',i===lineIndex));const line=choices[lineIndex];line.episodes.forEach((ep,i)=>{
      const context={profileId:p.id,siteKey:s.key||s.api,vodId:String(v.vod_id),vodName:v.vod_name,line:lineIndex,index:i,flag:line.name,poster:v.vod_pic||''};
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
    // 网盘分享链接：优先走自研直连解析（不依赖 JAR 的 Android UI 登录弹窗）
    const rawText=String(raw).trim();
    // 阿里分享内单文件引用（详情页选集）：交回 Rust 按 file_id 取转码地址
    if(rawText.startsWith('alipan://')&&invoke){
      status('正在获取阿里云盘播放地址…');
      const cloud=await invoke('tvbox_cloud_play',{url:rawText});
      if(cloud&&cloud.url)return {url:cloud.url,headers:{'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.54 Safari/537.36',Referer:'https://www.alipan.com/'}};
      throw Error('阿里云盘播放地址获取失败');
    }
    // 百度分享文件直链（详情页选集）：直接交给播放器，带 Referer/UA
    if(/^https?:\/\/[^/]*(?:baidupcs|pcs\.baidu)\.com\//i.test(rawText)){
      return {url:rawText,headers:{'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.54 Safari/537.36',Referer:'https://pan.baidu.com/'}};
    }
    const cloudMatch=rawText.match(/https?:\/\/(?:pan\.quark\.cn|drive\.uc\.cn|(?:pan|yun)\.baidu\.com|(?:www\.)?(?:alipan|aliyundrive)\.com)\/s\/[^\s"'<>]+/i);
    const isCloudShare=Boolean(cloudMatch);
    // 饭太硬等 JAR 的网盘 ep 是 JSON（含 sId/sToken）：夸克可直接拼分享链接走自研直连（用登录 Cookie 转存/取直链）
    let shareUrl=isCloudShare?cloudMatch[0].replace(/[，。；;]+$/,''):'';
    let cloudPayload=shareUrl;
    if(!shareUrl&&rawText.startsWith('{')&&rawText.includes('"sId"')){
      try{
        const ep=JSON.parse(rawText);
        // 有具体 fid 时必须保留完整 JSON；Rust 可直接播放用户选中的文件。
        // 只有旧格式缺少 fid 时才退化为分享链接并重新遍历目录。
        if(ep&&ep.sId){if(ep.fid){cloudPayload=rawText;shareUrl='json';}else{shareUrl='https://pan.quark.cn/s/'+ep.sId;cloudPayload=shareUrl;}}
      }catch(_){/* 非 JSON：交给片源 */}
    }
    let cloudResolveError=null;
    if(shareUrl){
      try{
        status('正在解析网盘直链…');
        const cloud=await invoke('tvbox_cloud_play',{url:String(cloudPayload)});
        if(cloud&&cloud.url){
          status(`网盘直链已获取${cloud.name?`：${cloud.name}`:''}`);
          const referer=cloud.site==='baidu'?'https://pan.baidu.com/':(cloud.site==='uc'?'https://drive.uc.cn/':(cloud.site==='alipan'?'https://www.alipan.com/':'https://pan.quark.cn/'));
          // 夸克 CDN（m3u8/分片）校验登录态：必须携带 cookie，否则 412 Precondition Failed
          return {url:cloud.url,headers:{'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.54 Safari/537.36',Referer:referer,...(cloud.cookie?{Cookie:cloud.cookie}:{})}};
        }
      }catch(error){
        cloudResolveError=error;
        status(`网盘直连失败：${error&&error.message?error.message:error}，尝试片源解析…`);
      }
    }
    let result={url:raw,parse:0};
    if(s&&(Number(s.type)===4||Number(s.type)===3))result=await api(s,'play',{id:raw,flag},p);
    if(!result)throw Error('播放接口没有返回内容');
    // JAR 明确的错误信息优先展示（如「需登录」「解析失败」）
    if(result.error)throw Error(String(result.error).slice(0,120));
    let rawUrl=result.url;
    // JAR 可能返回 JSON 字符串或数组（多地址）：宽松兼容
    if(typeof rawUrl==='string'&&/^[\[{]/.test(rawUrl.trim())){try{rawUrl=C.json(rawUrl);}catch(_){/* keep raw */}}
    if(rawUrl===undefined||rawUrl===null||rawUrl===''){
      if(Number(s?.type)===3)throw Error('该片源需要先登录云盘（夸克 / UC / 百度 / 阿里）才能播放：请到「设置 → 云盘登录」扫码登录后重试');
      throw Error('播放接口没有返回地址');
    }
    if(typeof result.header==='string'){try{result.header=C.json(result.header);}catch(_){/* ignore */}}
    let target=rawUrl;
    if(Array.isArray(target)){
      const strings=target.filter(v=>typeof v==='string'&&v.trim());
      target=strings.find(v=>/^(https?|rtsp|rtmp|ftp):/.test(v))||strings[0];
    }
    // Some adapters return an address object; cloud episode descriptors are
    // not addresses and must not hide the original resolver failure.
    if(target&&typeof target==='object'&&!Array.isArray(target)){
      if(target.sId||target.fid){
        if(cloudResolveError)throw Error('网盘解析失败：'+(cloudResolveError.message||String(cloudResolveError)));
        throw Error('片源返回了网盘文件信息，但未返回可播放地址，请重新打开详情后重试');
      }
      if(typeof target.url==='string'){
        result.header={...result.header,...(target.headers||target.header||{})};
        target=target.url;
      }
    }
    if(typeof target!=='string'||!target.trim()){
      if(cloudResolveError)throw Error('网盘解析失败：'+(cloudResolveError.message||String(cloudResolveError)));
      throw Error('播放接口未返回有效地址，请切换线路或重新打开详情');
    }
    if(result.playUrl)target=result.playUrl+target;
    const parsed=C.media(target);result={...result,...parsed,headers:{...s?.headers,...s?.header,...result.header,...parsed.headers}};
    // 通用接管（兼容所有 JAR）：JAR 返回本地代理地址时，按「网盘类型 + 文件名」从用户网盘找同名文件取直链/转码 m3u8，
    // 不依赖 JAR 内部的映射表与混淆类名
    const proxyMatch=/^https?:\/\/127\.0\.0\.1:\d+\/proxy\/play\/([^/]+)\/[^/]*\/([^/?#]+)/i.exec(String(result.url));
    if(proxyMatch){
      try{
        const netName=decodeURIComponent(proxyMatch[1]);
        const fileName=decodeURIComponent(proxyMatch[2]);
        const netSite=/夸/.test(netName)?'quark':/优|uc/i.test(netName)?'uc':/喳|百/.test(netName)?'baidu':/阿/.test(netName)?'ali':'';
        if(netSite&&fileName){
          status(`正在接管网盘代理：${fileName}`);
          const found=await invoke('tvbox_cloud_find',{site:netSite,name:fileName});
          if(found&&found.url){
            const referer=found.site==='uc'?'https://drive.uc.cn/':'https://pan.quark.cn/';
            return {url:found.url,headers:{'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.54 Safari/537.36',Referer:referer,...(found.cookie?{Cookie:found.cookie}:{})}};
          }
        }
      }catch(error){
        status(`网盘代理接管失败：${error&&error.message?error.message:error}，使用片源原地址`);
      }
    }
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
    if(/^(magnet:\?|thunder:\/\/|ed2k:\/\/)/i.test(result.url)||/\.torrent(?:[?#]|$)/i.test(result.url))return result;
    // 已经是媒体直链（m3u8/mp4/flv/ts 等）时忽略 parse 标记，直接播放（很多 JAR 误标 parse=1）
    if(/\.(?:m3u8|mp4|flv|mkv|ts|mov|m4v|webm|mp3|m4a|aac)(?:[?#]|$)/i.test(result.url))return result;
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
  // 侦测 JAR 播放时落盘的新鲜二维码 token：代表本次播放正在等待网盘登录，立即弹官方扫码码
  function watchQuarkQr(onRetry){
    let stopped=false,shown=false,timer=0;
    const tick=async()=>{
      if(stopped)return;
      try{
        const qr=await invoke('tvbox_cloud_qr');
        if(qr.token&&!shown){shown=true;startQuarkLogin(onRetry);}
      }catch(ignored){}
      if(!stopped)timer=setTimeout(tick,1500);
    };
    timer=setTimeout(tick,800);
    return {stop(){stopped=true;clearTimeout(timer);}};
  }
  async function playEpisode(next) {
    queue=next;const ep=next.episodes[next.index];if(!ep)throw Error('没有下一集');
    const context={...next.context,index:next.index,line:next.lineIndex??next.context?.line};queue.context=context;
    // 网盘源播放不再侦测 JAR 自己的扫码 token（它内部会一直轮询，不代表需要用户扫码）：
    // 登录统一走官方扫码，播放失败（未登录）时直接弹码
    const qrProbe={stop(){}};
    try{
      await play(ep.url,`${context.vodName||'视频'} · ${ep.name}`,{site:next.site,profile:next.profile,context,live:!!next.live,channel:ep.channel});
      qrProbe.stop();
    }catch(error){
      // 解析/播放失败：停留在当前界面（详情选集/视频区），只提示错误，不自动跳到搜索页
      qrProbe.stop();
      endPlayLoading();
      const name=String(context.vodName||'').trim();
      const message=error&&error.message?error.message:String(error||'未知错误');
      status(`「${name||'该影片'}」播放失败：${message}（可重试或切换其他线路）`);
      // 网盘源未登录：按线路网盘弹扫码（夸克用官方二维码弹窗，与 Android 一致）
      if(!next.live&&(message.includes('登录云盘')||message.includes('未扫码')||message.includes('授权')||/登录态(?:缺失|失效|过期)/.test(message))){
        const lineFlag=String(context.flag||'');
        const net=/优汐|uc/i.test(lineFlag)?'uc':/喳|百/.test(lineFlag)?'baidu':/阿/.test(lineFlag)?'alipan':'quark';
        if(net==='quark')await startQuarkLogin(()=>playEpisode(next));
        else await invoke('tvbox_cloud_login',{site:net});
        status(`请扫码登录${net==='quark'?'夸克':net==='uc'?'UC':net==='baidu'?'百度':'阿里云盘'}网盘；登录成功后自动保存，重新点播放即可`);
        return;
      }
      throw error;
    }
    renderStageSide();
  }
  async function nextEpisode(delta=1) {
    if(!queue||!queue.episodes[queue.index+delta]){status(delta>0?'已是最后一集':'已是第一集');return;}
    if(queue.local){queue={...queue,index:queue.index+delta};const ep=queue.episodes[queue.index];return play(ep.url,ep.name,{local:true,localQueue:true});}
    await playEpisode({...queue,index:queue.index+delta});
  }
  // 播放器独立主视图：底层列表保留状态但不与播放器同时显示，返回后原位恢复。
  function enterStage(name,live){
    $('skip-intro-btn').classList.add('hidden');$('skip-outro-btn').classList.add('hidden');
    const panel=document.getElementById('panel-tvbox');
    // 从设置页直接播放（直链 / 本地视频）时收起设置、回到列表，视频区与列表同屏
    if(view==='settings'){
      $('settings-panel').classList.add('hidden');$('library').classList.remove('hidden');$('settings-tab').classList.remove('is-selected');
      view='home';panel.dataset.view='home';$('home').classList.add('is-selected');$('section-title').textContent='影视';
    }
    panel.classList.add('tv-player-mode');
    panel.classList.toggle('tv-live-mode',!!live); // 直播模式：隐藏字幕控件
    panel.classList.toggle('tv-vod-mode',!live);
    $('stage').classList.remove('hidden');$('controls').classList.remove('hidden');if(name)$('now').textContent=name;
    $('episode-prev').textContent=live?'上一个':'上一集';$('episode-next').textContent=live?'下一个':'下一集';
    syncSurface();
  }
  // 真全屏：内容区铺满的同时显式切换 Windows 主窗口全屏；mpv 子窗口继续跟随 surface。
  let fullControlsTimer=0;
  function renderPauseState(paused){
    if(current)current.paused=paused;
    $('pause').innerHTML=paused?'<svg viewBox="0 0 24 24" aria-hidden="true"><path d="M8 5v14l11-7z"/></svg>':'<svg viewBox="0 0 24 24" aria-hidden="true"><path d="M6 5h4v14H6zm8 0h4v14h-4z"/></svg>';
    $('pause').setAttribute('aria-label',paused?'播放':'暂停');$('pause').title=(paused?'播放':'暂停')+'（空格）';
  }
  renderPauseState(false);
  function showFullscreenControls(){
    clearTimeout(fullControlsTimer);
    const panel=document.getElementById('panel-tvbox');
    if(!panel.classList.contains('tv-stage-full'))return;
    panel.classList.remove('tv-controls-idle');syncSurface();
    fullControlsTimer=setTimeout(()=>{
      if(!panel.classList.contains('tv-stage-full'))return;
      if(surfaceCoveredByDialog()){showFullscreenControls();return;}
      panel.classList.add('tv-controls-idle');syncSurface();
    },3000);
  }
  async function stageFullscreen(on){
    const panel=document.getElementById('panel-tvbox');
    const active=on===undefined?!panel.classList.contains('tv-stage-full'):!!on;
    panel.classList.toggle('tv-stage-full',active);
    panel.classList.toggle('tv-native-full',active&&$('engine').value==='mpv');
    clearTimeout(fullControlsTimer);panel.classList.remove('tv-controls-idle');
    if(active)showFullscreenControls();
    $('fullscreen').textContent=active?'退出全屏':'全屏';
    if(invoke){
      try{await invoke('tvplayer_fullscreen',{fullscreen:active});}
      catch(_){/* 开发预览环境保留应用内铺满兜底 */}
    }
    setTimeout(()=>{syncSurface();startSurfaceLoop();},120);
  }
  function hideSurface(){if(invoke)invoke('tvplayer_surface_hide').catch(()=>{});}
  function exitStage(){
    clearTimeout(fullControlsTimer);
    const panel=document.getElementById('panel-tvbox');panel.classList.remove('tv-player-mode','tv-stage-full','tv-live-mode','tv-vod-mode');
    $('fullscreen').textContent='全屏';
    panel.classList.remove('tv-controls-idle');
    panel.classList.remove('tv-native-full');
    if(invoke)invoke('tvplayer_fullscreen',{fullscreen:false}).catch(()=>{});
    cancelAnimationFrame(surfaceRaf);surfaceRaf=0;lastSurfaceRect='';
    $('stage').classList.add('hidden');$('controls').classList.add('hidden');$('stage-side').replaceChildren();hideSurface();
  }
  // 停止播放并返回来源视图（保存点播进度）。
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
  // 原生视频子窗口跟随：逐帧对比 surface rect，变化才重新定位（滚动/缩放/布局动画都实时贴合）
  let surfaceRaf=0,lastSurfaceRect='';
  function surfaceCoveredByDialog(){
    if(!window.document)return false;
    return [...document.querySelectorAll('.modal-mask:not(.hidden),dialog[open]')].some(node=>{
      const style=getComputedStyle(node);
      return style.display!=='none'&&style.visibility!=='hidden'&&node.getClientRects().length>0;
    });
  }
  let surfaceDialogBlocked=false;
  function updateSurfaceDialogVisibility(){
    if(!window.document){surfaceDialogObserver.disconnect();return;}
    const blocked=surfaceCoveredByDialog();
    if(blocked===surfaceDialogBlocked)return;
    surfaceDialogBlocked=blocked;lastSurfaceRect='';
    if(blocked){
      hideSurface();
      if(current){
        // Set a state, never toggle: repeated observers or an already paused
        // movie must not accidentally resume behind a dialog.
        renderPauseState(true);
        if($('engine').value==='web')$('video').pause();
        else invoke('tvplayer_control',{action:'set-pause',value:true}).catch(()=>{});
      }
    }else if(!playLoading)syncSurface();
  }
  const surfaceDialogObserver=new MutationObserver(updateSurfaceDialogVisibility);
  surfaceDialogObserver.observe(document.body,{subtree:true,childList:true,attributes:true,attributeFilter:['class','style','open']});
  function startSurfaceLoop(){
    cancelAnimationFrame(surfaceRaf);
    const tick=()=>{
      const panel=document.getElementById('panel-tvbox');
      if(!panel.classList.contains('tv-player-mode')||$('engine').value!=='mpv'){surfaceRaf=0;return;}
      const r=$('surface').getBoundingClientRect();
      if(r.width>4&&r.height>4){
        const key=[Math.round(r.x),Math.round(r.y),Math.round(r.width),Math.round(r.height)].join(',');
        if(key!==lastSurfaceRect){lastSurfaceRect=key;syncSurface();}
      }
      surfaceRaf=requestAnimationFrame(tick);
    };
    surfaceRaf=requestAnimationFrame(tick);
  }
  async function syncSurface(){
    const panel=document.getElementById('panel-tvbox');
    if(!panel.classList.contains('tv-player-mode')||$('engine').value!=='mpv'||!invoke)return;
    if(surfaceCoveredByDialog()){hideSurface();return;}
    const r=$('surface').getBoundingClientRect();const d=window.devicePixelRatio||1;
    if(r.width<40||r.height<40)return;
    try{await invoke('tvplayer_surface',{x:r.x*d,y:r.y*d,w:r.width*d,h:r.height*d});if(surfaceCoveredByDialog())hideSurface();}catch(_){/* 面窗口仅 Windows 有效 */}
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
      side.append(sideChips(urls.map((u,i)=>({label:`线路 ${i+1}`})),Number(current?.meta?.liveUrlIndex)||0,i=>()=>{
        liveAttempted.clear();liveFailCount=0;
        return play(urls[i],channel.name,{headers:channel.headers,live:true,channel,context:{live:true,channel},liveUrlIndex:i});
      }));
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
    // 换源按钮：直播不显示；源配置 changeable=0 时不可换源（对齐 Android）
    const switchable=!meta?.live&&(!meta?.site||Number(meta.site.changeable)!==0);$('switch-source').classList.toggle('hidden',!switchable);
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
    // 应用字幕样式（字号/颜色/粗体，对齐 Android 字幕设置）
    if($('engine').value!=='web')applySubStyle();
    renderStageSide(meta.channel);
    if(!live){
      const record={...old,key:recordKey,name,url,raw,sniffPage:meta.sniffPage,headers:meta.headers||{},local:!!meta.local,context:meta.context,cover:meta.context?.poster||old?.cover||'',position:start,duration:old?.duration||0,time:Date.now()};
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
    else {status('正在解析播放地址…');result=await withTimeout(resolveEpisode(raw,meta.site,p,meta.context?.flag||''),90000,'解析播放地址超时（90 秒），该源响应过慢');}
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
  function actualQuality(width,height){
    const w=Number(width)||0,h=Number(height)||0;
    if(w>=7000||h>=4000)return '8K';
    if(w>=3800||h>=2100)return '4K';
    if(w>=2500||h>=1400)return '2K/QHD';
    if(w>=2000&&h>=1000)return 'DCI 2K';
    if(w>=1900||h>=1050)return '1080P';
    if(w>=1200||h>=700)return '720P';
    return w&&h?'标清':'';
  }
  function mediaSummary(snapshot){
    const w=Number(snapshot.width)||0,h=Number(snapshot.height)||0,fps=Number(snapshot.fps)||0;
    const fpsText=fps>0?`${fps.toFixed(Math.abs(fps-Math.round(fps))<.05?0:2)} FPS${fps>=50?' · 高帧率':''}`:'';
    return [actualQuality(w,h),w&&h?`${w} × ${h}`:'',fpsText,snapshot.hwdec&&snapshot.hwdec!=='no'?`硬解 ${snapshot.hwdec}`:'软件解码',snapshot.codec||'',snapshot.buffer?`缓存 ${Math.round(snapshot.buffer)} 秒`:''].filter(Boolean).join(' · ');
  }
  function updateProgress(snapshot) {
    if(!current||snapshot.session!==current.session)return;
    if(typeof snapshot.pause==='boolean')renderPauseState(snapshot.pause);
    // 内置音轨/字幕轨：只要拿到轨道列表就刷新（不依赖观看记录，老片/直接播也能切换）
    if(Array.isArray(snapshot.tracks)){renderTracks(snapshot.tracks);const choice=db.subtitleChoices?.[current?.key];if(current&&!current.meta?.live&&!current.subtitleRestored&&choice!==undefined&&(choice==='auto'||choice==='no'||snapshot.tracks.some(t=>t.type==='sub'&&String(t.id)===String(choice)))){current.subtitleRestored=true;control('sid',choice).catch(()=>{if(current)current.subtitleRestored=false;});}}
    const mediaInfo=mediaSummary(snapshot);
    if(current.meta?.live){
    $('skip-intro-btn').classList.add('hidden');$('skip-outro-btn').classList.add('hidden');
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
    const introSec=Number(db.prefs.skipIntro)||0,outroSec=Number(db.prefs.skipOutro)||0;
    $('skip-intro-btn').classList.toggle('hidden',!(introSec>0&&position<introSec-1));
    $('skip-outro-btn').classList.toggle('hidden',!(outroSec>0&&duration>outroSec+10&&position>=duration-outroSec-1));
    $('time').textContent=`${time(position)} / ${time(duration)}`;$('seek').max=String(duration||100);$('seek').value=String(position);
    $('info').textContent=mediaInfo;
    if(Date.now()-lastSave>5000){persist();lastSave=Date.now();}
    const outro=Number(db.prefs.skipOutro)||0;
    if(outro>0&&duration>outro*2&&position>=duration-outro&&db.prefs.autoNext&&queue&&!current.eofTriggered){current.eofTriggered=true;run(()=>nextEpisode());}
  }
  // 字幕样式（mpv））：字号 sub-font-size、颜色 sub-color（#RRGGBB）、粗体 sub-bold
  function applySubStyle(){
    if(!current||$('engine').value==='web'||!invoke)return;
    const size=Math.max(20,Math.min(120,Number(db.prefs.subSize)||55));
    const selected=String(db.prefs.subColor||'#ffffff');
    const color=/^#[0-9a-f]{6}$/i.test(selected)?selected:'#ffffff';
    invoke('tvplayer_control',{action:'sub-font-size',value:size}).catch(()=>{});
    invoke('tvplayer_control',{action:'sub-color',value:color}).catch(()=>{});
    invoke('tvplayer_control',{action:'sub-bold',value:db.prefs.subBold===true}).catch(()=>{});
  }
  // 字幕样式修改：保存并即时应用
  for(const [id,key] of [['sub-size','subSize'],['sub-color','subColor'],['sub-bold','subBold']]){
    const node=$(id);if(!node)continue;
    node.oninput=node.onchange=()=>{
      db.prefs[key]=key==='subBold'?node.checked:key==='subSize'?Math.max(20,Math.min(120,Number(node.value)||55)):node.value;
      persist();applySubStyle();
    };
  }
  function renderTracks(tracks){const signature=JSON.stringify(tracks.map(t=>[t.id,t.type,t.title,t.lang,t.codec,t.selected]));if(signature===trackSignature)return;trackSignature=signature;
    for(const [id,type]of [['audio','audio'],['subtitles','sub']]){const select=$(id);select.replaceChildren();option(select,'auto',type==='audio'?'自动音轨':'自动字幕');if(type==='sub')option(select,'no','关闭字幕');tracks.filter(t=>t.type===type).forEach(t=>{
      const detail=[t.title,t.lang?'['+t.lang+']':'',t.codec?'('+t.codec+')':''].filter(Boolean).join(' ');
      option(select,t.id,`${t.id} · ${detail||'轨道'}`);
      if(t.selected)select.value=String(t.id);
    });}
  }
  async function control(action,value) {
    if(action==='stop')return stopStage();
    if(action==='fullscreen'){
      return stageFullscreen();
    }
    if($('engine').value==='web'){
      const v=$('video');if(action==='pause'){const paused=!v.paused;renderPauseState(paused);return paused?v.pause():v.play();}if(action==='seek')v.currentTime=Number(value);if(action==='forward')v.currentTime+=10;if(action==='backward')v.currentTime=Math.max(0,v.currentTime-10);if(action==='speed')v.playbackRate=Number(value);if(action==='volume')v.volume=Math.min(1,Number(value)/100);return;
    }
    if(action==='pause'){const before=!!current?.paused;renderPauseState(!before);try{await invoke('tvplayer_control',{action:'set-pause',value:!before});}catch(e){renderPauseState(before);throw e;}return;}
    await invoke('tvplayer_control',{action,value:value??null});
  }
  function completed(){if(!current||current.manualStop||current.eofTriggered)return;current.eofTriggered=true;if(current.meta?.live){status('直播中断或结束');return;}const h=db.history.find(h=>h.key===current.key);if(h){h.position=h.duration||h.position;persist();}if(db.prefs.autoNext&&queue?.episodes[queue.index+1]){run(()=>nextEpisode());return;}run(()=>stopStage('播放结束，已回到列表'));}
  // 旧版本可能把直播频道写进观看记录（key=频道地址、无点播上下文）——启动与展示时自动清理，直播不需要历史
  const isLiveRecord=h=>!h.context&&!h.sniffPage&&String(h.key||'')===String(h.url||'')&&/\.(?:m3u8|m3u|flv|ts)(?:[?#]|$)/i.test(String(h.url||''));
  function historyItems() {
    switchView('history');$('results').replaceChildren();$('prev').disabled=$('next').disabled=true;
    const keep=db.history.filter(h=>!isLiveRecord(h));
    if(keep.length!==db.history.length){db.history=keep;persist();}
    // 与搜索结果一致的宫格：海报 + 单行标题 + 小字（进度/时长 · 站点），角标显示已看百分比
    const p=profile();
    for(const h of db.history){
      const percent=h.duration>0?Math.min(99,Math.max(1,Math.round((Number(h.position)||0)/h.duration*100))):0;
      let siteName='直链';
      if(h.context){
        const owner=db.profiles.find(x=>x.id===h.context.profileId);
        const site=(owner?.config?.sites||[]).find(s=>(s.key||s.api)===h.context.siteKey);
        siteName=site?.name||'片源';
      }
      const v={vod_id:h.context?.vodId||h.key||h.url,vod_name:h.name||'未命名',vod_pic:h.cover||'',vod_year:`${time(h.position)} / ${time(h.duration)}`,vod_area:'',vod_remarks:percent?`${percent}%`:''};
      $('results').append(movieCard(v,{name:siteName},p,()=>replay(h)));
    }
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
      const art=el('div',undefined,'tv-poster');art.append(el('span','TV','tv-poster-fallback'));poster(art,f.movie?.vod_pic||f.channel?.logo,f.movie?posterBase(f.movie,f.site,{base:f.base}):f.base);
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
    $('results').replaceChildren(el('div','正在加载直播源…','tv-empty'));
    try{
      let channels=[];
      if(source.builtin){
        // 使用每 15 分钟自动更新的公开频道表；直连失败再试镜像，均失败才回退随包静态表。
        const remotes=['https://raw.githubusercontent.com/hujingguang/ChinaIPTV/main/cnTV_AutoUpdate.m3u8','https://peterhchina.github.io/iptv/CNTV-V4.m3u'];
        const refreshed=await Promise.allSettled(remotes.map(async remote=>{
          const text=await withTimeout(fetchText(remote,{}),12000,'内置直播更新超时');
          return C.playlist(text,remote);
        }));
        for(const result of refreshed)if(result.status==='fulfilled')for(const c of result.value)channels.push({...c,urls:Array.isArray(c.urls)?c.urls:[c.url],source:'内置每日更新'});
        if(!channels.length){
          const data=await invoke('tvbox_live_builtin');
          for(const group of (data&&Array.isArray(data.groups)?data.groups:[])){
            for(const c of (group.channels||[]))channels.push({name:c.name,group:group.name,logo:c.logo||'',urls:Array.isArray(c.urls)?c.urls:[],source:'内置离线备份'});
          }
        }
      }else{
        const item=source.item||{};
        let items=[];
        if(item.channels||item.urls){items=C.liveItems([item],profile().base);}
        else{
          const remote=item.remote||address(item.url,profile().base);
          const text=await withTimeout(fetchText(remote,item.headers||{}),30000,'直播源加载超时（30 秒）');
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
    }}
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
  // 自动换源只在当前频道内尝试，所有线路失败后停留当前频道，不擅自换台。
  // 连续失败超过 12 次停止，避免坏源造成无限循环
  let liveFailCount=0;
  let liveSwitchBusy=false;
  const liveAttempted=new Set();
  async function liveSwitchNext(){
    if(!current?.meta?.live||current.manualStop||liveSwitchBusy)return false;
    liveSwitchBusy=true;
    try{
    const channel=current.meta.channel;
    if(++liveFailCount>12){status('多个直播源连续失败，已停止自动换源，请手动选择频道或直播源');return false;}
    const urls=(channel&&(channel.urls||[channel.url]))||[];
    const idx=Number(current.meta.liveUrlIndex)||0;
    liveAttempted.add(urls[idx]);
    const next=urls.findIndex((url,i)=>i!==idx&&!liveAttempted.has(url));
    if(channel&&next>=0){
      liveAttempted.add(urls[next]);
      status(`直播源不可用，切换线路 ${next+1}/${urls.length}：${channel.name}`);
      await play(urls[next],channel.name,{headers:channel.headers,live:true,channel,context:{live:true,channel},liveUrlIndex:next});
      return true;
    }
    status(`「${channel?.name||'当前频道'}」所有线路均不可用，请手动重试或选择其他直播源`);
    return false;
    }finally{liveSwitchBusy=false;}
  }
  async function playChannel(channel) {
    liveAttempted.clear();liveFailCount=0;
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
  $('settings-tab').onclick=()=>run(()=>navigateFromPlayer(()=>openSettings()));
  $('onboard-config').onclick=()=>{$('settings-tab').click();$('config-url').focus();};
  $('onboard-phone').onclick=()=>{$('settings-tab').click();$('phone-start').click();};
  $('onboard-local').onclick=()=>$('local').click();
  if(loadMoreObserver)loadMoreObserver.observe($('sentinel'));
  $('find').onclick=()=>run(()=>navigateFromPlayer(async()=>{
    closeDetail();
    if(view!=='home')switchView('home');
    const word=$('keyword').value.trim();
    if(word)return startSearch(word);
    $('keyword').value='';
    renderSearchPanel();
    $('keyword').focus();
  }));
  $('phone-start').onclick=()=>run(async()=>{const result=await invoke('tvbox_remote_start');$('phone').replaceChildren(el('p','手机与电脑连接同一网络，扫描对应网卡的二维码。配置完成后可关闭此入口。'));for(const code of result.codes){const card=el('div'),img=el('img');img.src='data:image/svg+xml;charset=utf-8,'+encodeURIComponent(code.svg);img.alt='手机配置二维码';card.append(img,el('p',code.url.split('#')[0]));$('phone').append(card);}$('phone').classList.remove('hidden');$('phone-stop').classList.remove('hidden');});
  $('runtime-stop').onclick=()=>run(async()=>{await invoke('tvbox_external_stop');status('Python / Java 片源运行时已停止，下次使用时自动启动');});
  $('phone-stop').onclick=()=>run(async()=>{await invoke('tvbox_remote_stop');$('phone').replaceChildren();$('phone').classList.add('hidden');$('phone-stop').classList.add('hidden');status('手机配置入口已关闭');});
  window.__TAURI__?.event?.listen('tvbox-phone-config',event=>run(async()=>{const text=String(event.payload).trim();status('正在加载手机发送的配置…');if(text.startsWith('{'))await importConfig(text,'','手机配置');else{const url=address(text);await importConfig(await fetchText(url),url);}})).catch(()=>{});
  // Configuration and navigation.
  function closeDetail(){
    cancelPendingTVBox(); // 关闭详情：取消未完成的详情请求
    const panel=document.getElementById('panel-tvbox');panel.classList.remove('tv-detail-mode');
    $('detail').replaceChildren();$('epg').replaceChildren();$('detail-back').classList.add('hidden');
    // 返回时恢复进入详情前的页面标题（搜索页返回仍显示「搜索」，保留搜索结果与源列表）
    $('section-title').textContent=({home:'影视',live:'电视直播',favorites:'我的收藏',history:'观看记录',settings:'配置与设置',xsearch:'搜索'})[view]||'影视';
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
  // 换源（对齐 Android changeable=1）：用当前片名搜索当前仓其他源，找到后直接进入详情并播放原集
  async function switchSource(){
    const meta=current?.meta;if(!meta)throw Error('当前没有播放内容');
    if(meta.live)throw Error('直播源不支持换源');
    const name=String(meta.context?.vodName||'').trim();
    if(!name)throw Error('无法确定当前片名，不能换源');
    const p=meta.profile||profile();
    const siteKey=x=>x?(x.key||x.api||x.name||''):'';
    const currentKey=siteKey(meta.site);
    status(`正在搜索「${name}」的其他源…`);
    const candidates=sites().filter(s=>C.supported(s)&&Number(s.searchable??1)!==0&&siteKey(s)!==currentKey);
    for(const s of candidates){
      try{
        const data=await withTimeout(api(s,'search',{keyword:name,page:1},p),Math.min(Number(s.timeout)||15,15)*1000);
        const items=filterRelevant(name,data.list||[]);
        if(!items.length)continue;
        const found=items[0];
        status(`已换到「${s.name}」：${found.vod_name}`);
        await detail(String(found.vod_id),s,p,{...meta.context,vodName:name,index:meta.context?.index||0,line:0});
        return;
      }catch(_){/* 尝试下一个源 */}
    }
    throw Error('没有找到其他可播源');
  }
  $('switch-source').onclick=()=>run(()=>switchSource());
  $('load').onclick=()=>run(async()=>{const url=address($('config-url').value.trim());await importConfig(await fetchText(url),url);});
  $('import').onclick=()=>run(async()=>{const path=await dialog.open({multiple:false,filters:[{name:'TVBox 配置 / 直播',extensions:['json','m3u','m3u8','txt']}]});if(path){const local=new URL('file:///');local.pathname='/'+path.replace(/\\/g,'/');await importConfig((await invoke('read_text_file',{path})).content,local.href,path.split(/[\\/]/).pop());}});
  $('export').onclick=()=>run(async()=>{const path=await dialog.save({defaultPath:'tvbox-config.json',filters:[{name:'TVBox 配置',extensions:['json']}]});if(path){await invoke('write_text_file',{path,content:JSON.stringify(config(),null,2)});status('配置已导出');}});
  $('apply-config').onclick=()=>run(async()=>{const conf=C.json($('config-editor').value);if(!Array.isArray(conf.sites)&&!Array.isArray(conf.lives))throw Error('配置需包含 sites 或 lives');if(!profile().id)return importConfig($('config-editor').value);profile().config=conf;await persist(true);setup();});
  $('profile').onchange=()=>run(async()=>{const stay=view==='settings';cancelPendingTVBox();db.profileId=$('profile').value;const p=profile();persist();setup();if(p.collectionBase){status(`正在加载「${p.name}」…`);const done=warnAfter(30000,'切换仓较慢（已超过 30 秒），请稍候…');try{await loadCollectionProfile(p);setup();if(!stay&&sites().some(C.supported))await browse(true);}finally{done();}}if(stay)openSettings();});
  $('rename').onclick=()=>{const stay=view==='settings';const name=$('profile-name').value.trim();if(profile().id&&name){profile().name=name;persist();setup();if(stay)openSettings();}};
  $('delete-profile').onclick=()=>run(async()=>{const stay=view==='settings';if(!profile().id)return;if(!await window.showConfirm('删除当前片源配置？收藏和观看记录将保留。'))return;db.profiles=db.profiles.filter(p=>p.id!==db.profileId);db.profileId=db.profiles[0]?.id||'';await persist(true);setup();if(stay)openSettings();});
  async function navigateFromPlayer(action){
    if(playingVideoArea())await stopStage('已停止播放');
    return action();
  }
  $('home').onclick=()=>run(()=>navigateFromPlayer(()=>goHome()));
  $('live').onclick=()=>run(()=>navigateFromPlayer(()=>loadLive(view==='live')));
  $('favorites').onclick=()=>run(()=>navigateFromPlayer(()=>favorites()));
  $('history').onclick=()=>run(()=>navigateFromPlayer(()=>historyItems()));
  $('site').addEventListener('pointerdown',()=>{siteUserTouched=Date.now();});
  $('site').addEventListener('keydown',()=>{siteUserTouched=Date.now();});
  $('site').onchange=()=>{
    if(siteProgrammatic)return;
    // 用户真实切换（鼠标下拉可能停留很久）：不再用时间窗判定，仅靠 programmatic 标记
    run(async()=>{const s=sites()[Number($('site').value)];if(!s)return;if(s.key===db.selectedSite||s.api===db.selectedSite||s.name===db.selectedSite)return;cancelPendingTVBox();db.selectedSite=s.key||s.api||s.name;persist();const done=warnAfter(30000,'切换源较慢（已超过 30 秒，JAR 源首次加载需转换），请稍候…');try{await browse(true);}finally{done();}});
  };$('category').onchange=()=>run(()=>{page=1;keyword='';filters={};filterPanelOpen=false;return browse();});
  // 卡片标题 / 左侧源名称 / 详情选集 / 播放侧栏项：最多一行，放不下时 hover 跑马灯滚动显示全名
  function attachMarquee(container,selector){
    if(!container)return;
    const pick=event=>event.target.closest?event.target.closest(selector):null;
    container.addEventListener('mouseover',event=>{
      const node=pick(event);
      if(!node||node.classList.contains('is-marquee'))return;
      // 详情/播放侧栏按钮是纯文本：首次 hover 时动态包 span（跑马灯需要内层可移动元素）
      let inner=node.querySelector(':scope > span');
      if(!inner){
        const text=node.textContent;
        if(!text)return;
        inner=document.createElement('span');inner.textContent=text;node.textContent='';node.append(inner);node.title=text;
      }
      const style=getComputedStyle(node);
      const pad=(parseFloat(style.paddingLeft)||0)+(parseFloat(style.paddingRight)||0);
      const overflow=inner.scrollWidth-(node.clientWidth-pad);
      if(overflow<=2)return;
      node.style.setProperty('--tv-marquee-shift',`-${overflow}px`);
      // 跑马灯速度：约 80px/秒（之前 30px/秒太慢），最短 1.6 秒
      node.style.setProperty('--tv-marquee-duration',`${Math.max(1.6,Math.round(overflow/80*10)/10)}s`);
      node.classList.add('is-marquee');
    });
    container.addEventListener('mouseout',event=>{
      const node=pick(event);
      if(node)node.classList.remove('is-marquee');
    });
  }
  attachMarquee($('results'),'.tv-card strong,.tv-channel strong,.tv-nav-col button');
  attachMarquee($('sidenav'),'.tv-card strong,.tv-nav-col button');
  attachMarquee($('detail'),'.tv-episodes button,.tv-line-chips button');
  attachMarquee($('stage-side'),'button');
  // 搜索面板：点击空白处收起（点结果区空白则恢复列表；点导航/源交给各自逻辑）
  document.addEventListener('pointerdown',event=>{
    if(!searchPanelOpen)return;
    const target=event.target;
    if(target.closest&&(target.closest('#tv-searchbar')||target.closest('.tv-search-panel')))return;
    searchPanelOpen=false;
    if(target.closest&&target.closest('#tv-results'))run(()=>goHome());
  },true);
  $('search').onclick=()=>run(()=>{
    if(view==='live')return renderLive();
    const word=$('keyword').value.trim();
    if(!word){renderSearchPanel();$('keyword').focus();return;}
    return startSearch(word);
  });
  $('keyword').oninput=()=>{if(searchPanelOpen)renderSearchPanel();};
  // 点搜索框即显示搜索面板（热门/历史/联想，参考 Android 搜索页）
  $('keyword').addEventListener('focus',()=>{if(view==='home'&&!searchPanelOpen&&!$('keyword').value.trim())renderSearchPanel();});
  $('keyword').onkeydown=e=>{if(e.key==='Enter')$('search').click();};$('prev').onclick=()=>run(()=>{if(page>1)page--;return browse();});$('next').onclick=()=>run(()=>{page++;return browse();});
  $('clear-history').onclick=()=>run(async()=>{if(await window.showConfirm('清空全部观看记录与续播进度？')){db.history=[];persist();historyItems();}});
  // 云盘登录：夸克用应用内官方二维码弹窗（与 Android 一致）；UC/百度/阿里打开官方登录窗口
  for(const [id,site] of [['cloud-quark','quark'],['cloud-uc','uc'],['cloud-baidu','baidu'],['cloud-alipan','alipan']]){
    const node=$(id);
    if(node)node.onclick=()=>run(async()=>{
      if(site==='quark'){await startQuarkLogin();return;}
      await invoke('tvbox_cloud_login',{site});
      status('已打开云盘登录窗口：会自动弹出扫码登录，扫码确认后窗口自动关闭即登录成功');
    });
  }
  // 夸克扫码二维码弹窗（二维码由本地 qrcode 库生成，避免第三方 PNG 在 WebView2 中显示成破图/文本）
  let qrRefreshTimer=0;
  function quarkQrVisual(qr){
    return qr.svg||'<div style="width:240px;height:240px;display:grid;place-items:center;color:#666;">二维码生成失败，请刷新</div>';
  }
  function showQuarkQr(qr,onRetry){
    document.getElementById('quark-qr-mask')?.remove();
    const mask=document.createElement('div');
    mask.id='quark-qr-mask';
    mask.style.cssText='position:fixed;inset:0;z-index:9999;background:rgba(0,0,0,.55);display:flex;align-items:center;justify-content:center;';
    const card=document.createElement('div');
    card.style.cssText='background:#fff;border-radius:12px;padding:20px 22px;max-width:320px;text-align:center;box-shadow:0 12px 40px rgba(0,0,0,.3);';
    card.innerHTML=`<div style="font-size:15px;font-weight:600;color:#111;margin-bottom:10px;">夸克网盘扫码登录</div><div class="qr-box" style="display:flex;justify-content:center;">${quarkQrVisual(qr)}</div><div style="font-size:12px;color:#666;margin-top:10px;line-height:1.6;">打开夸克 App → 扫一扫<br/>扫码确认后自动登录，无需手动填写任何信息<br/><span style="color:#999;">二维码 3 分钟内有效，过期自动刷新</span></div><div style="margin-top:14px;display:flex;gap:10px;justify-content:center;"><button id="quark-qr-retry" style="border:none;background:#3b82f6;color:#fff;border-radius:8px;padding:7px 18px;cursor:pointer;">已扫码，重试播放</button><button id="quark-qr-close" style="border:1px solid #ddd;background:#f7f7f7;border-radius:8px;padding:7px 18px;cursor:pointer;">关闭</button></div>`;
    mask.appendChild(card);
    document.body.appendChild(mask);
    const stopRefresh=()=>clearInterval(qrRefreshTimer);
    mask.onclick=(e)=>{if(e.target===mask){stopRefresh();mask.remove();}};
    card.querySelector('#quark-qr-close').onclick=()=>{stopRefresh();mask.remove();};
    card.querySelector('#quark-qr-retry').onclick=()=>{stopRefresh();mask.remove();if(typeof onRetry==='function')onRetry();};
    status('请用手机夸克 App 扫码登录（扫码确认后自动登录）');
  }
  // 生成官方扫码登录二维码（Rust 后台轮询，登录成功自动写 Cookie）；每 150 秒自动换新码
  async function startQuarkLogin(onRetry){
    try{
      const qr=await invoke('tvbox_quark_qr_start');
      showQuarkQr(qr,onRetry);
      clearInterval(qrRefreshTimer);
      qrRefreshTimer=setInterval(async()=>{
        const mask=document.getElementById('quark-qr-mask');
        if(!mask){clearInterval(qrRefreshTimer);return;}
        try{
          const fresh=await invoke('tvbox_quark_qr_start');
          const box=mask.querySelector('.qr-box');
          if(box)box.innerHTML=quarkQrVisual(fresh);
        }catch(ignored){}
      },150000);
    }catch(error){
      status(`生成扫码登录失败：${error&&error.message?error.message:error}`);
    }
  }
  window.__TAURI__?.event?.listen('cloud-login-error',event=>{status(String(event.payload||'网盘登录未完成'));}).catch(()=>{});
  // 登录成功（登录窗口检测到 __puus 后自动关闭并通知）：验证真实登录态并推送到 JAR
  if(window.__TAURI__&&window.__TAURI__.event)window.__TAURI__.event.listen('cloud-login-done',async()=>{
    clearInterval(qrRefreshTimer);
    document.getElementById('quark-qr-mask')?.remove();
    try{
      const r=await invoke('tvbox_cloud_apply');
      status(r&&r.applied?'云盘登录成功：登录态已保存并应用（长期有效），直接播放即可':'云盘登录态已保存，播放网盘源时自动使用');
    }catch(error){
      status(`云盘登录态应用失败：${error&&error.message?error.message:error}`);
    }
  });
  $('local').onclick=()=>run(async()=>{const paths=await dialog.open({multiple:true,filters:[{name:'视频',extensions:['mp4','mkv','mov','avi','ts','webm','m4v','flv','m2ts']}]});if(!paths)return;const list=(Array.isArray(paths)?paths:[paths]).map(path=>({name:path.split(/[\\/]/).pop(),url:path}));if(!list.length)return;queue={episodes:list,index:0,local:true};await play(list[0].url,list[0].name,{local:true,localQueue:true});});
  $('play').onclick=()=>run(()=>play($('direct').value.trim(),'网络视频'));
  $('sniff').onclick=()=>run(()=>sniff($('direct').value.trim(),'网页视频',{}));
  for(const action of ['pause','stop','forward','backward','fullscreen'])$(action).onclick=()=>run(()=>control(action));
  $('more-toggle').textContent='更多';
  $('more-toggle').onclick=()=>{const more=$('controls-more');const collapsed=more.classList.toggle('hidden');$('more-toggle').textContent=collapsed?'更多':'收起';$('more-toggle').classList.toggle('is-expanded',!collapsed);requestAnimationFrame(()=>{syncSurface();startSurfaceLoop();});showFullscreenControls();};
  $('episode-prev').onclick=()=>run(()=>nextEpisode(-1));$('episode-next').onclick=()=>run(()=>nextEpisode(1));
  for(const [id,action]of [['speed','speed'],['volume','volume'],['sub-delay','sub-delay'],['audio','aid'],['subtitles','sid'],['aspect','aspect']])$(id).onchange=()=>run(async()=>{const value=['speed','volume','sub-delay'].includes(id)?Number($(id).value):$(id).value;if(id==='speed'||id==='volume'){db.prefs[id]=value;persist();}if(id==='subtitles'&&current&&!current.meta?.live){db.subtitleChoices=db.subtitleChoices||{};db.subtitleChoices[current.key]=value;persist();}if(current)await control(action,value);});
  $('seek').onchange=()=>run(()=>control('seek',Number($('seek').value)));
  $('subtitle-file').onclick=()=>run(async()=>{const path=await dialog.open({multiple:false,filters:[{name:'字幕',extensions:['srt','ass','ssa','vtt','sub']}]});if(path)await control('subtitle',path);});
  // 跳过片头/片尾（对齐 Android：片头跳到设定秒数，片尾直接下一集）
  $('skip-intro-btn').onclick=()=>run(()=>control('seek',Math.max(0,Number(db.prefs.skipIntro)||0)));
  $('skip-outro-btn').onclick=()=>run(()=>{if(queue&&Array.isArray(queue.episodes)&&queue.index<queue.episodes.length-1)return nextEpisode(1);return stopStage('已跳过片尾');});
  // 在线字幕（参考 Android）：用配置里的字幕接口搜索，或直接粘贴字幕链接加载
  function subtitleApis(){
    const list=profile().config.subtitles;
    if(!Array.isArray(list))return [];
    return list.map(item=>typeof item==='string'?item:(item&&(item.api||item.url))||'').filter(Boolean);
  }
  async function loadSubtitleUrl(url){
    const path=await invoke('tvbox_subtitle_load',{url});
    await control('subtitle',path);
    // 新字幕轨加载后立即刷新轨道列表（选新轨并显示，替换内置字幕）
    try{const st=await invoke('tvplayer_status');if(st)updateProgress(st);}catch(_){}
    status('字幕已加载（已切换为新字幕）');
  }
  // Android setSearchWord 清洗：去括号/扩展名，截断 36 字
  function subtitleKeyword(name){
    let wd=String(name||'');
    wd=wd.replace(/(?:（|《|\(|\[|【|\.mp4|\.mkv|\.avi|\.MP4|\.MKV|\.AVI)/g,'');
    wd=wd.replace(/(?:）》|:|\)|\]|】|\.)/g,' ');
    return wd.slice(0,36).trim();
  }
  let subtitleSearchToken=0,subtitleBusy=false,subtitleClose=null;
  function openSubtitleDialog(){
    if(subtitleClose)return;
    const content=$('sub-panel'),anchor=document.createComment('subtitle-panel');content.before(anchor);
    const mask=el('div',undefined,'modal-mask'),box=el('section',undefined,'tv-sub-dialog');
    box.setAttribute('role','dialog');box.setAttribute('aria-modal','true');box.setAttribute('aria-label','在线字幕');
    const close=()=>{if(subtitleBusy)return;subtitleSearchToken++;anchor.replaceWith(content);content.classList.add('hidden');mask.remove();subtitleClose=null;$('sub-online').focus();};
    subtitleClose=close;
    const heading=el('div',undefined,'tv-detail-heading');heading.append(el('h3','在线字幕'),button('关闭',close));
    content.classList.remove('hidden');box.append(heading,content);mask.append(box);document.body.append(mask);
    mask.addEventListener('keydown',e=>{if(e.key==='Escape'){e.preventDefault();e.stopPropagation();close();}});
    $('sub-word').focus();
  }
  async function chooseSubtitle(url,label,preparedPath=null){
    if(subtitleBusy)return;
    subtitleBusy=true;const session=current?.session;
    const controls=[...$('sub-panel').querySelectorAll('button,input')];controls.forEach(n=>n.disabled=true);
    $('sub-hint').textContent='正在加载：'+label;
    try{
      const files=preparedPath?[{path:preparedPath}]:await invoke('tvbox_subtitle_prepare',{url});
      if(current?.session!==session)throw Error('影片已切换，请重新选择字幕');
      if(files.length>1){
        const list=$('sub-list');list.replaceChildren();
        $('sub-hint').textContent='请选择字幕包中的一个文件';
        list.append(button('返回搜索结果',()=>searchSubtitles()));
        for(const file of files)list.append(button(file.name,()=>chooseSubtitle(file.url||url,file.name,file.path),'tv-sub-item'));
        return;
      }
      const path=files[0]?.path;if(!path)throw Error('没有可加载的字幕文件');
      if(current?.session!==session)throw Error('影片已切换，请重新选择字幕');
      await control('subtitle',path);
      try{const st=await invoke('tvplayer_status');if(st)updateProgress(st);}catch(_){}
      status('已切换字幕：'+label);subtitleBusy=false;subtitleClose?.();
    }catch(error){$('sub-hint').textContent='加载失败：'+(error?.message||String(error));}
    finally{subtitleBusy=false;controls.forEach(n=>n.disabled=false);}
  }
  async function searchSubtitles(){
    if(subtitleBusy)return;
    const token=++subtitleSearchToken;const list=$('sub-list');list.replaceChildren();
    const name=String(current?.meta?.context?.vodName||queue?.context?.vodName||current?.name||'').trim();
    let word=$('sub-word').value.trim();
    if(!word){word=subtitleKeyword(name);$('sub-word').value=word;}
    if(!word){$('sub-hint').textContent='请先播放影片或输入字幕关键词';return;}
    $('sub-hint').textContent='正在搜索字幕…';
    const apis=subtitleApis();
    let items;try{items=await invoke('tvbox_subtitle_search',{apis,name:word});}catch(error){if(token===subtitleSearchToken)$('sub-hint').textContent='搜索失败：'+(error?.message||String(error));return;}
    if(token!==subtitleSearchToken)return;
    $('sub-hint').textContent=items.length?`找到 ${items.length} 条字幕（关键词：${word}），点击即可加载`:'没有找到字幕，可换用“片名 年份/季集”重新搜索';
    for(const item of items.slice(0,30)){
      const b=button(`${item.title}${item.lang?` · ${item.lang}`:''}`,()=>chooseSubtitle(item.url,item.title),'tv-sub-item');
      b.title=item.title;
      list.append(b);
    }
  }
  $('sub-online').onclick=()=>run(async()=>{
    openSubtitleDialog();
    // 默认关键词 = 片名清洗后；已有输入则不覆盖
    if(!$('sub-word').value.trim()){
      const name=String(current?.meta?.context?.vodName||queue?.context?.vodName||current?.name||'').trim();
      $('sub-word').value=subtitleKeyword(name);
    }
    await searchSubtitles();
  });
  $('sub-search').onclick=()=>run(()=>searchSubtitles());
  $('sub-word').onkeydown=e=>{if(e.key==='Enter')$('sub-search').click();};
  $('sub-load').onclick=()=>run(async()=>{const url=$('sub-url').value.trim();if(!url)throw Error('请粘贴字幕链接');await chooseSubtitle(url,'链接字幕');});
  for(const [id,key]of [['resume','resume'],['auto-next','autoNext'],['skip-intro','skipIntro'],['skip-outro','skipOutro'],['hwdec','hwdec']])$(id).onchange=()=>{db.prefs[key]=['resume','autoNext'].includes(key)?$(id).checked:key==='hwdec'?$(id).value:Math.max(0,Math.min(600,Number($(id).value)||0));persist();};
  $('self-parser').onchange=()=>{db.prefs.selfParser=$('self-parser').checked;persist();updateUnmatchedInfo();status(db.prefs.selfParser?'已开启源自带解析兼容：未适配站点将回退到片源自带爬虫':'已切换为纯本地解析：未适配站点会提示并记录到待适配清单');};
  $('live-timeout').onchange=()=>{db.prefs.liveTimeout=Math.max(5,Math.min(30,Number($('live-timeout').value)||15));$('live-timeout').value=String(db.prefs.liveTimeout);persist();status(`直播换源超时：${db.prefs.liveTimeout} 秒`);};
  // 安全 DNS（DoH，参考 Android）：作用于应用自身网络请求
  $('cache-ttl').onchange=()=>{db.prefs.cacheTtl=Number($('cache-ttl').value)||0;persist();status(db.prefs.cacheTtl===0?'数据缓存：永久有效（已加载的片源数据会一直保留）':`数据缓存：${$('cache-ttl').selectedOptions[0].textContent} 内有效`);};
  $('secure-dns').onchange=()=>{db.prefs.secureDns=$('secure-dns').value||'off';persist();invoke('tvbox_dns_set',{mode:db.prefs.secureDns}).catch(()=>{});status(db.prefs.secureDns==='off'?'安全 DNS 已关闭（使用系统 DNS）':'安全 DNS 已开启：'+$('secure-dns').selectedOptions[0].textContent+'（应用自身网络请求生效）');};
  $('video').onerror=()=>{const live=!!current?.meta?.live&&!current?.manualStop;endPlayLoading();if(live){status('直播源播放失败，尝试换源…');run(()=>liveSwitchNext());}else status('WebView 无法播放此编码或地址，请使用内置 libmpv');};$('video').onended=completed;
  $('video').ontimeupdate=()=>{if(current&&$('engine').value==='web')updateProgress({session:current.session,position:$('video').currentTime,duration:$('video').duration,width:$('video').videoWidth,height:$('video').videoHeight});};
  document.addEventListener('keydown',e=>{if(!document.getElementById('panel-tvbox').classList.contains('active')||e.target.closest('input,textarea,select,[contenteditable]')||e.ctrlKey||e.altKey||e.metaKey)return;const action={' ':'pause',ArrowLeft:'backward',ArrowRight:'forward',f:'fullscreen',F:'fullscreen'}[e.key];if(action){e.preventDefault();run(()=>control(action));}else if(e.key==='n'||e.key==='N'){$('episode-next').click();}else if(e.key==='Escape'&&document.getElementById('panel-tvbox').classList.contains('tv-stage-full')){e.preventDefault();stageFullscreen(false);}});
  document.addEventListener('keydown',e=>{if(e.key==='Escape'&&document.getElementById('panel-tvbox').classList.contains('tv-stage-full')){e.preventDefault();stageFullscreen(false);}else showFullscreenControls();},true);
  $('stage').addEventListener('pointerdown',showFullscreenControls);
  $('controls').addEventListener('pointermove',showFullscreenControls);
  $('stage').addEventListener('pointermove',showFullscreenControls);
  $('controls').addEventListener('pointerdown',showFullscreenControls);
  // 视频区域跟随窗口尺寸变化（全屏时重算控制条预留高度）；加载期间不显示子窗口（避免遮住视频区提示）
  let surfaceSyncTimer=0;
  window.addEventListener('resize',()=>{clearTimeout(surfaceSyncTimer);surfaceSyncTimer=setTimeout(()=>{if(!playLoading)syncSurface();},120);});
  const tvPanel=document.getElementById('panel-tvbox');
  new MutationObserver(()=>{if(!tvPanel.classList.contains('active')&&tvPanel.classList.contains('tv-player-mode'))hideSurface();}).observe(tvPanel,{attributes:true,attributeFilter:['class']});
  tvPanel.addEventListener('panel-shown',()=>{if(!tvPanel.classList.contains('tv-player-mode'))return;renderStageSide(current?.meta?.channel);if(!playLoading)setTimeout(()=>syncSurface(),120);});
  window.__TAURI__?.event?.listen('tvbox-player-event',event=>{
    const data=event.payload;if(!current||data.session!==current.session)return;
    if(data.kind==='input'){
      if(data.action==='tvbox-controls')showFullscreenControls();
      else if(data.action==='tvbox-paused')renderPauseState(true);
      else if(data.action==='tvbox-playing')renderPauseState(false);
      else if(data.action==='tvbox-exit-fullscreen')stageFullscreen(false);
      else if(data.action==='tvbox-fullscreen')stageFullscreen();
      else if(data.action==='tvbox-episode-prev')$('episode-prev').click();
      else if(data.action==='tvbox-episode-next')$('episode-next').click();
      else if(data.action==='tvbox-subtitle-file')$('subtitle-file').click();

    }
    else if(data.kind==='closed'){endPlayLoading();updateProgress(data);persist(true);current.manualStop=true;status('播放窗口已关闭，进度已保存');}
    else if(data.kind==='loaded'){
      // 直播：FILE_LOADED 不代表有画面（坏源会一直重试），保持加载提示与 15 秒超时，等 updateProgress 确认真实画面
      if(current.meta?.live)status('正在连接直播源：'+current.name+'…');
      else {liveFailCount=0;endPlayLoading();status('正在播放：'+current.name);}
    }
    else if(data.kind==='ended'){
      // 直播超时/失败仅尝试当前频道尚未失败的线路。
      const live=!!current?.meta?.live&&!current?.manualStop;
      endPlayLoading();
      if(live){status(data.error<0?'直播源连接失败，尝试换源…':'直播流中断，尝试换源…');run(()=>liveSwitchNext());}
      else if(data.error<0)status(`播放失败（内核 ${data.error}），请切换线路或检查片源（网盘源请先在设置中登录云盘）`);
      else if(data.reason===0)completed();
    }
  }).catch(()=>{});
  
  
  let tvboxStarted=false;
  async function startTVBox(){
    if(tvboxStarted)return;tvboxStarted=true;window.__tvboxStarted=true;
    setInterval(async()=>{if(!current||busyPoll||$('engine').value!=='mpv')return;busyPoll=true;try{const state=await invoke('tvplayer_status');if(state)updateProgress(state);}catch(_){/* next poll retries */}finally{busyPoll=false;}},2000);
window.__TAURI__?.event?.listen('tvbox-sniff-result',event=>{const data=event.payload,p=sniffPending;if(!p||p.session!==data.session||p.token!==playGeneration||p.seen.has(data.url))return;p.seen.add(data.url);const b=button(`播放识别结果 ${p.seen.size} · ${data.url.slice(0,100)}`,()=>launch(data.url,p.name,{...p.meta,headers:{...p.meta.headers,Referer:data.referer,'User-Agent':data.ua}},p.token));$('sniff-results').append(b);status(`已识别 ${p.seen.size} 个媒体地址，请选择播放（可能包含广告）`);}).catch(()=>{});

    let data=null;if(invoke){try{data=await invoke('tvbox_load');}catch(e){status(String(e));}}
    if(!data){try{const old=JSON.parse(localStorage.getItem(OLD_KEY)||'null');if(old?.profiles)data=old;else if(old?.config)data={profiles:[{id:'migrated',name:'原配置',base:old.base||'',config:old.config}],profileId:'migrated',history:old.history||[]};}catch(_){/* no legacy data */}}
    if(data){db={...db,...data,prefs:{...db.prefs,...data.prefs}};if(db.prefs.hwdec==='auto-safe')db.prefs.hwdec='auto';/* 默认硬解：旧配置迁移到优先硬解 */db.profiles=Array.isArray(db.profiles)?db.profiles:[];db.history=Array.isArray(db.history)?db.history.filter(h=>!isLiveRecord(h)):[];db.favorites=Array.isArray(db.favorites)?db.favorites:[];db.unmatched=db.unmatched&&typeof db.unmatched==='object'?db.unmatched:{};db.searchHistory=Array.isArray(db.searchHistory)?db.searchHistory:[];delete db.sourceHealth;};
    applyPreferences();setup();if(data)await persist(true);if(profile().collectionBase&&!hasSources(config()))await run(async()=>{await loadCollectionProfile(profile());setup();});
    // 应用安全 DNS 设置（在首次网络请求前生效）
    if(db.prefs.secureDns&&db.prefs.secureDns!=='off')invoke('tvbox_dns_set',{mode:db.prefs.secureDns}).catch(()=>{});
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
  }
  // 首次切到 TVBOX 时才初始化（应用启动不加载 TVBOX 数据，节省资源）
  window.TVBOXActivate=()=>startTVBox().catch(error=>console.error('TVBOX 初始化失败',error));
  window.TVBOXReady=()=>startTVBox().catch(error=>console.error('TVBOX 初始化失败',error));
  // 离开 TVBOX 面板：取消所有挂起请求（释放后台资源，避免无意义执行）
  window.TVBOXDeactivate=()=>cancelPendingTVBox();
})();
