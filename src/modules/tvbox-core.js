/* TVBox protocol adapters. Pure helpers shared by the desktop UI and tests. */
(function (root) {
  'use strict';
  const supported = s => [0,1,4].includes(Number(s.type)) || (Number(s.type) === 3 && (/\.(?:js|py)(?:[?#]|$)/i.test(String(s.api || '').split(';')[0]) || /^(?:csp_|com\.github\.catvod\.spider\.)/.test(String(s.api || ''))));
  function url(value, base) {
    const u = new URL(String(value), base || undefined);
    if (!['http:','https:','file:'].includes(u.protocol)) throw Error('只支持 HTTP(S) 地址或本地配置文件');
    return u.href;
  }
  function json(text) {
    // JSONC support without evaluating configuration as executable code.
    const input = String(text).replace(/^\uFEFF/, ''); let output = '', quoted = false, escaped = false;
    for (let i=0; i<input.length; i++) {
      const c = input[i], next = input[i+1];
      if (quoted) { output += c; if (escaped) escaped = false; else if (c === '\\') escaped = true; else if (c === '"') quoted = false; continue; }
      if (c === '"') { quoted = true; output += c; }
      else if (c === '/' && next === '/') { while (i<input.length && input[i] !== '\n') i++; output += '\n'; }
      else if (c === '/' && next === '*') { i += 2; while (i<input.length && !(input[i] === '*' && input[i+1] === '/')) i++; i++; output += ' '; }
      else if (c === ',') { let k=i+1; while (/\s/.test(input[k] || '') && k<input.length) k++; if (!['}',']'].includes(input[k])) output += c; }
      else output += c;
    }
    let cleaned='';quoted=false;escaped=false;
    for(let i=0;i<output.length;i++) {const c=output[i];if(quoted){cleaned+=c;if(escaped)escaped=false;else if(c==='\\')escaped=true;else if(c==='"')quoted=false;}else if(c==='"'){quoted=true;cleaned+=c;}else if(c===','){let k=i+1;while(k<output.length&&/\s/.test(output[k]))k++;if(!['}',']'].includes(output[k]))cleaned+=c;}else cleaned+=c;}
    return JSON.parse(cleaned);
  }
  function parseXml(text) {
    const doc = new DOMParser().parseFromString(text,'application/xml');
    if (doc.getElementsByTagName('parsererror').length) throw Error('XML 接口格式无效');
    return doc;
  }
  const tags = (node,tag) => Array.from(node.getElementsByTagName(tag));
  const content = (node,tag) => tags(node,tag)[0]?.textContent || '';
  function response(text, type) {
    if (Number(type) !== 0 && !String(text).trim().startsWith('<')) {
      let data = json(text); if (data.data && !data.list) data = data.data;
      return {...data, list:Array.isArray(data.list) ? data.list : [], class:Array.isArray(data.class) ? data.class : []};
    }
    const doc = parseXml(text), list = tags(doc,'list')[0];
    return {
      class:tags(doc,'ty').map(c => ({type_id:c.getAttribute('id'),type_name:c.textContent})),
      page:Number(list?.getAttribute('page') || 1), pagecount:Number(list?.getAttribute('pagecount') || 1),
      list:tags(doc,'video').map(v => {
        const result = {};
        for (const [k,t] of Object.entries({vod_id:'id',vod_name:'name',vod_pic:'pic',vod_remarks:'note',vod_content:'des',vod_year:'year',vod_area:'area',vod_actor:'actor',vod_director:'director',type_name:'type'})) result[k] = content(v,t);
        const lines = tags(v,'dd');
        result.vod_play_from = lines.map(l => l.getAttribute('flag') || '默认').join('$$$');
        result.vod_play_url = lines.map(l => l.textContent).join('$$$'); return result;
      })
    };
  }
  function request(site, action, args = {}, base) {
    const u = new URL(url(site.api,base)), type = Number(site.type);
    const params = {};
    if (action === 'home') { if (type === 4) params.filter = 'true'; }
    if (action === 'category') Object.assign(params,{ac:type === 0 ? 'videolist':'detail',t:args.t || '',pg:args.page || 1});
    if (action === 'search') Object.assign(params,{ac:type === 0 ? 'videolist':'detail',wd:args.keyword,pg:args.page || 1});
    if (action === 'detail') Object.assign(params,{ac:type === 0 ? 'videolist':'detail',ids:args.id});
    if (action === 'play') Object.assign(params,{play:args.id,flag:args.flag || ''});
    if (type === 4) {
      if (site.ext) params.extend = typeof site.ext === 'string' ? (/^\.\.?\//.test(site.ext)?url(site.ext,base):site.ext) : JSON.stringify(site.ext);
      if (action === 'category') { params.filter = 'true'; params.ext = utf8Base64(JSON.stringify(args.filters || {})); }
    } else if (args.filters) { Object.assign(params,args.filters); params.f = JSON.stringify(args.filters); }
    for (const [k,v] of Object.entries(params)) u.searchParams.set(k,String(v));
    return u.href;
  }
  function utf8Base64(s) {
    return btoa(Array.from(new TextEncoder().encode(s), b => String.fromCharCode(b)).join(''));
  }
  function lines(v) {
    const flags = String(v.vod_play_from || '').split('$$$');
    return String(v.vod_play_url || '').split('$$$').map((line,i) => ({name:flags[i] || `线路 ${i+1}`,episodes:line.split('#').filter(Boolean).map((e,n) => {
      const split = e.indexOf('$'); return {name:split<0 ? `第 ${n+1} 集`:e.slice(0,split),url:split<0 ? e:e.slice(split+1)};
    })})).filter(l => l.episodes.length);
  }
  function media(raw) {
    const value = String(raw), pipe = value.indexOf('|'), headers = {};
    if (pipe < 0) return {url:value,headers};
    new URLSearchParams(value.slice(pipe+1)).forEach((v,k) => { headers[k] = v; });
    return {url:value.slice(0,pipe),headers};
  }
  function playlist(text, base) {
    if(/#EXT-X-TARGETDURATION/i.test(text))throw Error('这是 HLS 视频清单，请使用播放直链功能');
    const out = []; let metadata = {}, group = '',epg='';
    for (const raw of String(text).split(/\r?\n/)) {
      const line = raw.trim();
      if(line.startsWith('#EXTM3U')) {epg=line.match(/(?:x-tvg-url|url-tvg)="([^"]+)"/)?.[1]||'';}
      else if (line.startsWith('#EXTINF:')) {
        const attrs = {}; for (const m of line.matchAll(/([\w-]+)="([^"]*)"/g)) attrs[m[1]] = m[2];
        metadata = {name:line.slice(line.lastIndexOf(',')+1).trim() || attrs['tvg-name'] || '频道',group:attrs['group-title'] || group,logo:attrs['tvg-logo'] || '',epgId:attrs['tvg-id'] || attrs['tvg-name'] || '',headers:{}};
      } else if (line.startsWith('#EXTVLCOPT:')) {
        const [key,...rest] = line.slice(11).split('='); const h = {'http-user-agent':'User-Agent','http-referrer':'Referer'}[key];
        if (h) (metadata.headers ||= {})[h] = rest.join('=');
      } else if (line && !line.startsWith('#')) {
        let name, rawUrl;
        if (/^(https?:|rtsp:|rtmp:|udp:)/i.test(line)) { name=metadata.name || '频道'; rawUrl=line; }
        else {
          const comma=line.indexOf(','); if (comma<0) continue;
          name=line.slice(0,comma); rawUrl=line.slice(comma+1).trim();
          if (rawUrl === '#genre#') { group=name; continue; }
        }
        const m = media(rawUrl);
        if (!/^(https?:|rtsp:|rtmp:|udp:)/i.test(m.url)) continue;
        out.push({...metadata,name,group:metadata.group || group,epg:metadata.epg||epg,url:m.url,headers:{...metadata.headers,...m.headers}}); metadata={};
      }
    }
    return out;
  }
  function liveItems(items, base, parent = {}) {
    const out = [];
    for (const item of Array.isArray(items) ? items : []) {
      const inherited = {...parent,...item,headers:{...parent.headers,...item.headers}};
      if (item.ua) inherited.headers['User-Agent'] = item.ua;
      if (item.referer) inherited.headers.Referer = item.referer;
      if (Array.isArray(item.channels)) out.push(...liveItems(item.channels,base,{...inherited,group:item.name || parent.group}));
      else if (Array.isArray(item.urls)) out.push({name:item.name || '频道',group:parent.group || '',logo:item.logo || '',epg:item.epg || parent.epg || '',epgId:item.epgId || item.tvgId || item.name || '',urls:item.urls,headers:inherited.headers,url:item.urls[0]});
      else if (item.url) out.push({remote:url(item.url,base),group:item.name || '',headers:inherited.headers,epg:item.epg || ''});
    }
    return out;
  }
  function epg(text, channel, day = new Date()) {
    if (!String(text).trim().startsWith('<')) {
      const data=json(text), date=data.date || `${day.getFullYear()}-${String(day.getMonth()+1).padStart(2,'0')}-${String(day.getDate()).padStart(2,'0')}`;
      return (data.epg_data || data.list || []).map(e => ({title:e.title || e.name,start:new Date(`${date}T${e.start}:00`).getTime(),end:new Date(`${date}T${e.end}:00`).getTime()}));
    }
    const doc=parseXml(text), channelNodes=tags(doc,'channel');
    const found=channelNodes.find(c => c.getAttribute('id') === channel.epgId || tags(c,'display-name').some(n => n.textContent === channel.name));
    const id=found?.getAttribute('id') || channel.epgId || channel.name;
    return tags(doc,'programme').filter(p => p.getAttribute('channel') === id).map(p => ({title:content(p,'title'),start:xmlTime(p.getAttribute('start')),end:xmlTime(p.getAttribute('stop'))})).filter(p => Number.isFinite(p.start) && Number.isFinite(p.end));
  }
  function xmlTime(s) {
    const m = String(s).match(/^(\d{4})(\d{2})(\d{2})(\d{2})(\d{2})(\d{2})?\s*([+-]\d{4}|Z)?/);
    if (!m) return NaN;
    const tz=m[7] ? m[7].replace(/([+-]\d{2})(\d{2})/,'$1:$2') : '+08:00';
    return Date.parse(`${m[1]}-${m[2]}-${m[3]}T${m[4]}:${m[5]}:${m[6] || '00'}${tz}`);
  }
  function resume(record) { return record && record.position > 5 && (!record.duration || record.position < record.duration-15) ? record.position:0; }
  function mergeData(existing,incoming) {
    const out=JSON.parse(JSON.stringify(existing||{})),input=JSON.parse(JSON.stringify(incoming||{}));
    out.profiles=Array.isArray(out.profiles)?out.profiles:[];const mapping={};
    for(const p of input.profiles||[]) {
      const same=out.profiles.find(q=>q.base===p.base&&JSON.stringify(q.config)===JSON.stringify(p.config));
      if(same){mapping[p.id]=same.id;continue;}
      const old=p.id;let id=old||'imported',n=1;while(out.profiles.some(q=>q.id===id))id=`${old}-import-${n++}`;
      p.id=id;mapping[old]=id;out.profiles.push(p);
    }
    const remap=item=>{
      const old=item.context?.profileId||item.profileId,next=mapping[old]||old;
      if(item.context)item.context.profileId=next;if(item.profileId)item.profileId=next;
      if(item.key&&old&&item.key.startsWith(old+':'))item.key=next+item.key.slice(old.length);return item;
    };
    const unique=(items,key)=>{const seen=new Set();return items.filter(i=>{const k=key(i);if(seen.has(k))return false;seen.add(k);return true;});};
    out.history=unique([...(out.history||[]),...(input.history||[]).map(remap)].sort((a,b)=>(b.time||0)-(a.time||0)),h=>h.key||h.url).slice(0,100);
    out.favorites=unique([...(out.favorites||[]),...(input.favorites||[]).map(remap)],f=>f.key);
    out.profileId=out.profileId||mapping[input.profileId]||out.profiles[0]?.id||'';
    out.prefs={...input.prefs,...out.prefs};return out;
  }
  const api={supported,url,json,response,request,lines,media,playlist,liveItems,epg,xmlTime,resume,mergeData};
  if (typeof module !== 'undefined' && module.exports) module.exports=api; else root.TVBoxCore=api;
})(globalThis);
