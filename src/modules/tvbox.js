(function () {
  'use strict';
  const C=window.TVBoxCore, $=id=>document.getElementById('tv-'+id);
  const invoke=window.__TAURI__?.core?.invoke, dialog=window.__TAURI__?.dialog;
  const OLD_KEY='simpletools-tvbox';
  let db={profiles:[],profileId:'',history:[],favorites:[],prefs:{resume:true,autoNext:true,speed:1,volume:100,skipIntro:0,skipOutro:0,hwdec:'auto-safe'}};
  let page=1,keyword='',filters={},homeData={},view='home',generation=0,playGeneration=0,saveTimer,saveQueue=Promise.resolve();
  let liveChannels=[],current=null,queue=null,sniffPending=null,lastSave=0,trackSignature='',busyPoll=false;
  let statusTimer=null;
  const status=message=>{
    const node=$('status');node.textContent=message;node.classList.remove('is-idle');
    clearTimeout(statusTimer);
    // 结果类消息自动淡出，进行中/播放中的消息保持可见
    if(!/正在|加载中|播放中/.test(String(message)))statusTimer=setTimeout(()=>node.classList.add('is-idle'),8000);
  };
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
  async function run(fn) { try { await fn(); } catch(e) { status(String(e?.message||e)); } }
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
  async function api(s,action,args={},p=profile()) {
    if(Number(s.type)===3) {
      let ext=s.ext ?? '';if(typeof ext==='string'&&/^[{[]/.test(ext.trim())){try{ext=C.json(ext);}catch(_){/* plain extension */}}
      if(typeof ext==='string'&&/^\.\.?\//.test(ext))ext=address(ext,p.base);
      const sourceApi=String(s.api).split(';')[0];
      if(!/\.js(?:[?#]|$)/i.test(sourceApi)){
        const py=/\.py(?:[?#]|$)/i.test(sourceApi);let jar=s.jar||p.config.spider||'';
        if(jar){const parts=jar.split(';md5;');parts[0]=address(parts[0],p.base);jar=parts.join(';md5;');}
        status(py?'正在运行 Python 片源…':'正在加载 JAR 片源（DEX 首次转换后会缓存）…');
        return invoke('tvbox_external',{api:py?address(sourceApi,p.base):sourceApi,jar:jar||null,key:s.key||s.name||'source',ext,action,args:{...args,flags:p.config.flags||[]}});
      }
      return invoke('tvbox_spider',{api:address(String(s.api).split(';')[0],p.base),key:s.key||s.name||'js',ext,action,args:{...args,flags:p.config.flags||[]}});
    }
    const data=await fetchText(C.request(s,action,args,p.base),s.header||s.headers||{});
    return action==='play'?C.json(data):C.response(data,s.type);
  }
  function switchView(next) {
    view=next;generation++;
    const panel=document.getElementById('panel-tvbox');panel.dataset.view=next;panel.classList.remove('tv-detail-mode');
    $('settings-panel').classList.add('hidden');$('library').classList.remove('hidden');$('settings-tab').classList.remove('is-selected');$('detail-back').classList.add('hidden');$('clear-history').classList.toggle('hidden',next!=='history');
    for(const key of ['home','live','favorites','history'])$(key).classList.toggle('is-selected',next===key);
    $('find').classList.remove('is-selected');
    $('section-title').textContent=({home:'影视',live:'电视直播',favorites:'我的收藏',history:'观看记录'})[next]||'影视';
    $('onboarding').classList.toggle('hidden',next!=='home'||sites().length>0||(config().lives||[]).length>0);
    $('detail').replaceChildren();$('epg').replaceChildren();$('filters').replaceChildren();$('categories').replaceChildren();
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
    $('parser').replaceChildren();option($('parser'),'auto','自动解析');option($('parser'),'direct','只播直链');
    (config().parses||[]).forEach((p,i)=>option($('parser'),i,p.name||`解析 ${i+1}`));
    $('category').replaceChildren();$('results').replaceChildren();homeData={};filters={};page=1;keyword='';
    $('prev').disabled=$('next').disabled=true;switchView('home');
    status(p.id?`${sites().length} 个点播源 · 已保存到应用数据目录。选择片源或进入直播。`:'加载或导入 TVBox 配置，也可以直接播放本地或网络视频。');
  }
  function applyPreferences() {
    for(const [id,key] of [['resume','resume'],['auto-next','autoNext']])$(id).checked=db.prefs[key]!==false;
    for(const [id,key] of [['speed','speed'],['volume','volume'],['skip-intro','skipIntro'],['skip-outro','skipOutro'],['hwdec','hwdec']])$(id).value=String(db.prefs[key]??'');
  }
  const hasSources=conf=>conf&&(Array.isArray(conf.sites)||Array.isArray(conf.lives));
  async function loadCollectionProfile(p) {
    if(hasSources(p.config))return;
    const clean=String(await fetchText(p.base)).replace(/^\uFEFF/,'').trim();
    if(!clean.startsWith('{'))throw Error(`「${p.name}」没有返回 TVBox JSON 配置`);
    const conf=C.json(clean);
    if(!hasSources(conf))throw Error(`「${p.name}」配置缺少 sites 或 lives 数组`);
    p.config=conf;await persist(true);
  }
  async function importCollection(conf,base) {
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
      try{
        await loadCollectionProfile(p);
      }catch(e){lastError=e;}
      if(!hasSources(p.config))continue;
      db.profileId=p.id;await persist(true);setup();
      let browseError='';
      if(sites().some(C.supported))try{await browse(true);}catch(e){browseError=String(e?.message||e);}
      status(`已导入 ${profiles.length} 个配置仓 · 当前：${p.name}${browseError?' · 首页加载失败：'+browseError:''}`);return;
    }
    throw Error(`已导入 ${profiles.length} 个配置仓，但暂时无法加载：${lastError?.message||'网络连接失败'}`);
  }
  async function importConfig(text,base='',name='') {
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
  }
  function renderFilters() {
    $('filters').replaceChildren();const groups=homeData.filters?.[$('category').value]||[];
    for(const group of groups) {
      const label=el('label',group.name||group.key),select=el('select');select.setAttribute('aria-label',group.name||group.key);
      (group.value||[]).forEach(v=>option(select,v.v,v.n));select.value=filters[group.key]??group.init??'';
      select.onchange=()=>run(()=>{filters[group.key]=select.value;page=1;return browse();});label.append(select);$('filters').append(label);
    }
  }
  function poster(node,url,base) {if(!url)return;try{const img=el('img');img.src=address(url,base);img.loading='lazy';img.referrerPolicy='no-referrer';img.alt='';img.onerror=()=>img.remove();node.prepend(img);}catch(_){/* invalid poster */}}
  function renderMovies(list,s,p=profile(),append=false) {
    if(!append)$('results').replaceChildren();
    for(const v of list) {
      const card=button('',()=>detail(v.vod_id,s,p),'tv-card'),art=el('div',undefined,'tv-poster');
      art.append(el('span','TV','tv-poster-fallback'));poster(art,v.vod_pic,p.base);
      if(v.vod_remarks)art.append(el('span',v.vod_remarks,'tv-card-remark'));
      card.append(art,el('strong',v.vod_name||'未命名'));
      card.append(el('small',[v.vod_year,v.vod_area,s.name].filter(Boolean).join(' · ')));$('results').append(card);
    }
    if(!$('results').children.length)$('results').append(el('div','没有找到相关内容，试试其他分类、片源或关键词','tv-empty'));
  }
  async function browse(reset=false) {
    if(view!=='home')switchView('home');const token=++generation,s=selectedSite(),p=profile();
    if(reset){page=1;keyword='';filters={};$('keyword').value='';$('category').replaceChildren();homeData={};}
    status('正在加载 '+(s.name||'片源')+'…');
    if(!homeData.class) {
      const loaded=await api(s,'home',{},p);if(token!==generation)return;homeData=loaded;
      option($('category'),'','推荐 / 全部');(homeData.class||[]).forEach(c=>option($('category'),c.type_id,c.type_name));
    }
    const category=$('category').value||'';
    $('categories').replaceChildren();for(const opt of $('category').options){const tab=button(opt.textContent,()=>{$('category').value=opt.value;return $('category').onchange();});tab.classList.toggle('is-selected',opt.value===category);$('categories').append(tab);}
    let data;
    if(!keyword&&!category&&page===1&&homeData.list?.length)data=homeData;
    else if(!keyword&&!category&&Number(s.type)===3)data=homeData;
    else data=await api(s,keyword?'search':'category',{keyword,t:category,page,filters},p);
    if(token!==generation)return;renderFilters();renderMovies(data.list||[],s,p);$('detail').replaceChildren();
    $('page').textContent=`第 ${page} 页${Number(data.pagecount)>0?' / '+data.pagecount:''}`;$('prev').disabled=page<=1;
    $('next').disabled=!data.list?.length||(Number(data.pagecount)>0&&page>=Number(data.pagecount));
    status(data.list?.length?`${data.list.length} 部影片 · ${s.name||'当前源'}`:'没有影片，尝试分类、搜索或其他片源');
  }
  async function searchAll() {
    const word=$('keyword').value.trim();if(!word)throw Error('输入片名后搜索');switchView('home');const token=++generation,p=profile();
    $('results').replaceChildren();$('prev').disabled=$('next').disabled=true;
    const sources=sites().filter(s=>C.supported(s)&&Number(s.searchable??1)!==0);let index=0,done=0,failed=0;
    async function worker(){while(token===generation&&index<sources.length){const s=sources[index++];try{const data=await api(s,'search',{keyword:word,page:1},p);if(token!==generation)return;renderMovies(data.list||[],s,p,true);}catch(_){failed++;}done++;if(token===generation)status(`全源搜索 ${done}/${sources.length} · ${failed} 个源失败`);}}
    await Promise.all(Array.from({length:Math.min(4,sources.length)},worker));
  }
  function movieKey(v,s,p){return `${p.id}:${s.key||s.api}:${v.vod_id}`;}
  async function detail(id,s,p=profile(),resumeContext=null) {
    const token=++generation;status('正在加载影片详情…');const data=await api(s,'detail',{id},p);if(token!==generation)return;
    const v=data.list?.[0];if(!v)throw Error('没有影片详情');const choices=C.lines(v),container=$('detail');container.replaceChildren();$('epg').replaceChildren();
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
      const b=button(ep.name,()=>playEpisode({episodes:line.episodes,index:i,site:s,profile:p,context}));
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
    const context={...next.context,index:next.index};queue.context=context;
    await play(ep.url,`${context.vodName||'视频'} · ${ep.name}`,{site:next.site,profile:next.profile,context});
  }
  async function nextEpisode(delta=1) {
    if(!queue||!queue.episodes[queue.index+delta]){status(delta>0?'已是最后一集':'已是第一集');return;}
    if(queue.local){queue={...queue,index:queue.index+delta};const ep=queue.episodes[queue.index];return play(ep.url,ep.name,{local:true,localQueue:true});}
    await playEpisode({...queue,index:queue.index+delta});
  }
  async function launch(url,name,meta,token) {
    if(token!==playGeneration)return;
    const raw=meta.raw||url,recordKey=meta.context?`${meta.context.profileId}:${meta.context.siteKey}:${meta.context.vodId}:${meta.context.line}:${meta.context.index}`:raw;
    const old=db.history.find(h=>h.key===recordKey||(!h.key&&h.url===url));
    const start=db.prefs.resume?Math.max(C.resume(old),meta.context?Number(db.prefs.skipIntro)||0:0):meta.context?Number(db.prefs.skipIntro)||0:0;
    if(current){try{const state=await invoke('tvplayer_status');if(state)updateProgress(state);}catch(_){/* retain last known progress */}}
    if(token!==playGeneration)return;
    const session=stamp();current={session,key:recordKey,meta,url,name,manualStop:false,eofTriggered:false};trackSignature='';$('controls').classList.remove('hidden');
    if($('engine').value==='web'){
      if(Object.keys(meta.headers||{}).length)throw Error('此片源需要请求头，请使用内置 libmpv');
      const video=$('video');video.src=meta.local?window.__TAURI__.core.convertFileSrc(url):url;video.classList.remove('hidden');video.playbackRate=Number(db.prefs.speed)||1;video.volume=Math.min(1,Number(db.prefs.volume)/100);video.onloadedmetadata=()=>{video.currentTime=Math.min(start,video.duration||start);};await video.play();
    }else{
      $('video').pause();$('video').removeAttribute('src');$('video').classList.add('hidden');
      await invoke('tvplayer_play',{target:url,title:name,headers:meta.headers||{},session,options:{...db.prefs,start,subDelay:Number($('sub-delay').value)||0}});
    }
    const record={...old,key:recordKey,name,url,raw,sniffPage:meta.sniffPage,headers:meta.headers||{},local:!!meta.local,context:meta.context,position:start,duration:old?.duration||0,time:Date.now()};
    db.history=[record,...db.history.filter(h=>h.key!==recordKey&&(h.key||h.url!==url))].slice(0,100);persist();$('now').textContent=name;
    $('episode-prev').disabled=!queue||queue.index<=0;$('episode-next').disabled=!queue||queue.index>=queue.episodes.length-1;
    status(start>0?`从 ${time(start)} 继续：${name}`:`正在播放：${name}`);
  }
  async function play(raw,name,meta={}) {
    if(!invoke)throw Error('请在桌面应用中播放');const token=++playGeneration;sniffPending=null;$('sniff-results').replaceChildren();
    await invoke('tvbox_cancel_p2p');
    if(!meta.context&&!meta.localQueue)queue=null;
    const p=meta.profile||profile();let result;
    if(meta.local)result={url:raw,headers:meta.headers||{}};
    else if(meta.resolved)result={url:raw,headers:meta.headers||{}};
    else result=await resolveEpisode(raw,meta.site,p,meta.context?.flag||'');
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
    if(action==='stop'&&current){current.manualStop=true;try{const state=await invoke('tvplayer_status');if(state)updateProgress(state);}catch(_){}await persist(true);}
    if($('engine').value==='web'){
      const v=$('video');if(action==='pause')return v.paused?v.play():v.pause();if(action==='stop')return v.pause();if(action==='seek')v.currentTime=Number(value);if(action==='forward')v.currentTime+=10;if(action==='backward')v.currentTime=Math.max(0,v.currentTime-10);if(action==='speed')v.playbackRate=Number(value);if(action==='volume')v.volume=Math.min(1,Number(value)/100);if(action==='fullscreen')return v.requestFullscreen();return;
    }
    await invoke('tvplayer_control',{action,value:value??null});
  }
  function completed(){if(!current||current.manualStop||current.eofTriggered)return;current.eofTriggered=true;const h=db.history.find(h=>h.key===current.key);if(h){h.position=h.duration||h.position;persist();}if(db.prefs.autoNext&&queue?.episodes[queue.index+1])run(()=>nextEpisode());else status('播放结束');}
  function historyItems() {
    switchView('history');$('results').replaceChildren();$('prev').disabled=$('next').disabled=true;
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
  async function loadLive() {
    switchView('live');const token=++generation;status('正在加载直播…');const p=profile(),items=C.liveItems(config().lives,p.base),loaded=[],failures=[];
    for(const item of items){if(item.remote){try{const text=await fetchText(item.remote,item.headers);const remote=text.trim().startsWith('{')?C.liveItems(C.json(text).lives||[],item.remote):C.playlist(text,item.remote);loaded.push(...remote.map(c=>({...c,group:c.group||item.group,epg:c.epg||item.epg,headers:{...item.headers,...c.headers}})));}catch(e){failures.push(item.group||item.remote);}}else loaded.push(item);if(token!==generation)return;}
    liveChannels=loaded;renderLive();status(`${loaded.length} 个频道${failures.length?' · '+failures.length+' 个列表加载失败':''}`);
  }
  function renderLive(group='') {
    $('results').replaceChildren();$('prev').disabled=$('next').disabled=true;
    if(!group){$('filters').replaceChildren();const select=el('select');select.setAttribute('aria-label','频道分组');option(select,'','全部分组');[...new Set(liveChannels.map(c=>c.group).filter(Boolean))].forEach(g=>option(select,g,g));select.onchange=()=>renderLive(select.value);$('filters').append(select);}
    const word=$('keyword').value.trim().toLowerCase();
    liveChannels.filter(c=>(!group||c.group===group)&&(!word||`${c.name} ${c.group}`.toLowerCase().includes(word))).forEach(c=>{const b=button('',()=>playChannel(c),'tv-channel');poster(b,c.logo);b.append(el('strong',c.name),el('small',c.group||'直播'));$('results').append(b);});
    if(!$('results').children.length)$('results').append(el('div','没有匹配的频道，试试其他分组或关键词','tv-empty'));
  }
  async function playChannel(channel) {
    const panel=$('detail');panel.replaceChildren();panel.append(el('h3',channel.name));const row=el('div',undefined,'tv-toolbar');
    const urls=channel.urls||[channel.url];urls.forEach((url,i)=>row.append(button(`线路 ${i+1}`,()=>play(url,channel.name,{headers:channel.headers}))));
    const key='live:'+channel.url;row.append(button(db.favorites.some(f=>f.key===key)?'★ 已收藏':'☆ 收藏频道',()=>{const i=db.favorites.findIndex(f=>f.key===key);if(i>=0)db.favorites.splice(i,1);else db.favorites.push({key,kind:'live',channel});persist();return playChannelDetails(channel);}));
    if(channel.epg||config().epg)row.append(button('节目单',()=>showEpg(channel)));panel.append(row);
    await play(urls[0],channel.name,{headers:channel.headers});
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
  $('find').onclick=()=>{switchView('home');$('keyword').focus();$('keyword').select?.();};
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
  $('detail-back').onclick=()=>closeDetail();
  $('load').onclick=()=>run(async()=>{const url=address($('config-url').value.trim());await importConfig(await fetchText(url),url);});
  $('import').onclick=()=>run(async()=>{const path=await dialog.open({multiple:false,filters:[{name:'TVBox 配置 / 直播',extensions:['json','m3u','m3u8','txt']}]});if(path){const local=new URL('file:///');local.pathname='/'+path.replace(/\\/g,'/');await importConfig((await invoke('read_text_file',{path})).content,local.href,path.split(/[\\/]/).pop());}});
  $('export').onclick=()=>run(async()=>{const path=await dialog.save({defaultPath:'tvbox-config.json',filters:[{name:'TVBox 配置',extensions:['json']}]});if(path){await invoke('write_text_file',{path,content:JSON.stringify(config(),null,2)});status('配置已导出');}});
  $('apply-config').onclick=()=>run(async()=>{const conf=C.json($('config-editor').value);if(!Array.isArray(conf.sites)&&!Array.isArray(conf.lives))throw Error('配置需包含 sites 或 lives');if(!profile().id)return importConfig($('config-editor').value);profile().config=conf;await persist(true);setup();});
  $('profile').onchange=()=>run(async()=>{const stay=view==='settings';db.profileId=$('profile').value;const p=profile();persist();setup();if(p.collectionBase){status(`正在加载「${p.name}」…`);await loadCollectionProfile(p);setup();if(!stay&&sites().some(C.supported))await browse(true);}if(stay)openSettings();});
  $('rename').onclick=()=>{const stay=view==='settings';const name=$('profile-name').value.trim();if(profile().id&&name){profile().name=name;persist();setup();if(stay)openSettings();}};
  $('delete-profile').onclick=()=>run(async()=>{const stay=view==='settings';if(!profile().id)return;if(!await window.showConfirm('删除当前片源配置？收藏和观看记录将保留。'))return;db.profiles=db.profiles.filter(p=>p.id!==db.profileId);db.profileId=db.profiles[0]?.id||'';await persist(true);setup();if(stay)openSettings();});
  $('home').onclick=()=>run(()=>browse(true));$('live').onclick=()=>run(loadLive);$('favorites').onclick=favorites;$('history').onclick=historyItems;
  $('site-filter').oninput=()=>{const count=renderSiteOptions($('site-filter').value);status(count?`找到 ${count} 个片源 · 从右侧列表选择`: '没有匹配的片源，试试其他关键词');};
  $('site-filter').onkeydown=e=>{if(e.key==='Enter'&&$('site').options.length)run(()=>browse(true));};
  $('site').onchange=()=>run(()=>browse(true));$('category').onchange=()=>run(()=>{page=1;keyword='';filters={};return browse();});
  $('search').onclick=()=>run(()=>{if(view==='live')return renderLive();page=1;keyword=$('keyword').value.trim();return browse();});$('search-all').onclick=()=>run(searchAll);
  $('keyword').onkeydown=e=>{if(e.key==='Enter')$('search').click();};$('prev').onclick=()=>run(()=>{if(page>1)page--;return browse();});$('next').onclick=()=>run(()=>{page++;return browse();});
  $('clear-history').onclick=()=>run(async()=>{if(await window.showConfirm('清空全部观看记录与续播进度？')){db.history=[];persist();historyItems();}});
  $('local').onclick=()=>run(async()=>{const paths=await dialog.open({multiple:true,filters:[{name:'视频',extensions:['mp4','mkv','mov','avi','ts','webm','m4v','flv','m2ts']}]});if(!paths)return;const list=(Array.isArray(paths)?paths:[paths]).map(path=>({name:path.split(/[\\/]/).pop(),url:path}));if(!list.length)return;queue={episodes:list,index:0,local:true};await play(list[0].url,list[0].name,{local:true,localQueue:true});});
  $('play').onclick=()=>run(()=>play($('direct').value.trim(),'网络视频'));
  $('sniff').onclick=()=>run(()=>sniff($('direct').value.trim(),'网页视频',{}));
  for(const action of ['pause','stop','forward','backward','fullscreen'])$(action).onclick=()=>run(()=>control(action));
  $('more-toggle').onclick=()=>{const more=$('controls-more');const collapsed=more.classList.toggle('hidden');$('more-toggle').textContent=collapsed?'更多 ⌄':'收起 ⌃';};
  $('episode-prev').onclick=()=>run(()=>nextEpisode(-1));$('episode-next').onclick=()=>run(()=>nextEpisode(1));
  for(const [id,action]of [['speed','speed'],['volume','volume'],['sub-delay','sub-delay'],['audio','aid'],['subtitles','sid'],['aspect','aspect']])$(id).onchange=()=>run(async()=>{const value=['speed','volume','sub-delay'].includes(id)?Number($(id).value):$(id).value;if(id==='speed'||id==='volume'){db.prefs[id]=value;persist();}if(current)await control(action,value);});
  $('seek').onchange=()=>run(()=>control('seek',Number($('seek').value)));
  $('subtitle-file').onclick=()=>run(async()=>{const path=await dialog.open({multiple:false,filters:[{name:'字幕',extensions:['srt','ass','ssa','vtt','sub']}]});if(path)await control('subtitle',path);});
  for(const [id,key]of [['resume','resume'],['auto-next','autoNext'],['skip-intro','skipIntro'],['skip-outro','skipOutro'],['hwdec','hwdec']])$(id).onchange=()=>{db.prefs[key]=['resume','autoNext'].includes(key)?$(id).checked:key==='hwdec'?$(id).value:Math.max(0,Math.min(600,Number($(id).value)||0));persist();};
  $('video').onerror=()=>status('WebView 无法播放此编码或地址，请使用内置 libmpv');$('video').onended=completed;
  $('video').ontimeupdate=()=>{if(current&&$('engine').value==='web')updateProgress({session:current.session,position:$('video').currentTime,duration:$('video').duration,width:$('video').videoWidth,height:$('video').videoHeight});};
  document.addEventListener('keydown',e=>{if(!document.getElementById('panel-tvbox').classList.contains('active')||e.target.closest('input,textarea,select,[contenteditable]')||e.ctrlKey||e.altKey||e.metaKey)return;const action={' ':'pause',ArrowLeft:'backward',ArrowRight:'forward',f:'fullscreen',F:'fullscreen'}[e.key];if(action){e.preventDefault();run(()=>control(action));}else if(e.key==='n'||e.key==='N'){$('episode-next').click();}});
  window.__TAURI__?.event?.listen('tvbox-player-event',event=>{
    const data=event.payload;if(!current||data.session!==current.session)return;
    if(data.kind==='closed'){updateProgress(data);persist(true);current.manualStop=true;status('播放窗口已关闭，进度已保存');}
    else if(data.kind==='loaded')status('视频已加载：'+current.name);
    else if(data.kind==='ended'){if(data.error<0)status(`播放失败（内核 ${data.error}），请切换线路或检查片源`);else if(data.reason===0)completed();}
  }).catch(()=>{});
  window.__TAURI__?.event?.listen('tvbox-sniff-result',event=>{const data=event.payload,p=sniffPending;if(!p||p.session!==data.session||p.token!==playGeneration||p.seen.has(data.url))return;p.seen.add(data.url);const b=button(`播放识别结果 ${p.seen.size} · ${data.url.slice(0,100)}`,()=>launch(data.url,p.name,{...p.meta,headers:{...p.meta.headers,Referer:data.referer,'User-Agent':data.ua}},p.token));$('sniff-results').append(b);status(`已识别 ${p.seen.size} 个媒体地址，请选择播放（可能包含广告）`);}).catch(()=>{});
  setInterval(async()=>{if(!current||busyPoll||$('engine').value!=='mpv')return;busyPoll=true;try{const state=await invoke('tvplayer_status');if(state)updateProgress(state);}catch(_){/* next poll retries */}finally{busyPoll=false;}},2000);
  window.TVBOXReady=(async()=>{
    let data=null;if(invoke){try{data=await invoke('tvbox_load');}catch(e){status(String(e));}}
    if(!data){try{const old=JSON.parse(localStorage.getItem(OLD_KEY)||'null');if(old?.profiles)data=old;else if(old?.config)data={profiles:[{id:'migrated',name:'原配置',base:old.base||'',config:old.config}],profileId:'migrated',history:old.history||[]};}catch(_){/* no legacy data */}}
    if(data){db={...db,...data,prefs:{...db.prefs,...data.prefs}};db.profiles=Array.isArray(db.profiles)?db.profiles:[];db.history=Array.isArray(db.history)?db.history:[];db.favorites=Array.isArray(db.favorites)?db.favorites:[];}
    applyPreferences();setup();if(data)await persist(true);if(profile().collectionBase&&!hasSources(config()))await run(async()=>{await loadCollectionProfile(profile());setup();});if(sites().some(C.supported)){const index=sites().findIndex(C.supported);$('site').value=String(index);await run(()=>browse(true));}
  })();
})();
