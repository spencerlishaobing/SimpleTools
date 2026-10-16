const {test}=require('node:test');
const assert=require('node:assert/strict');
const fs=require('node:fs');
const {JSDOM}=require('jsdom');
const base='https://source.test/config.json';
const tick=()=>new Promise(resolve=>setTimeout(resolve,20));
async function app(t,config,respond=()=>undefined,extra={}) {
  const dom=new JSDOM(fs.readFileSync('src/index.html','utf8'),{url:'http://localhost/',runScripts:'outside-only'});t.after(()=>dom.window.close());
  const w=dom.window,calls=[],events={},saved={profiles:[{id:'p1',name:'测试配置',config,base}],profileId:'p1',...extra};
  w.TextEncoder=TextEncoder;w.TextDecoder=TextDecoder;w.showConfirm=async()=>true;
  w.HTMLMediaElement.prototype.pause=function(){};
  w.__TAURI__={core:{convertFileSrc:p=>'asset://'+p,invoke:async(name,args)=>{
    calls.push({name,args});if(name==='tvbox_load')return saved;if(name==='tvbox_save')return;
    return respond(name,args);
  }},event:{listen:async(name,fn)=>{events[name]=fn;return()=>{};}},dialog:{open:async()=>null,save:async()=>null}};
  w.eval(fs.readFileSync('src/modules/tvbox-core.js','utf8'));w.eval(fs.readFileSync('src/modules/tvbox.js','utf8'));await w.TVBOXReady;
  const get=id=>w.document.getElementById('tv-'+id);get('engine').value='mpv';get('site').value='0';
  return {w,get,calls,events,dom};
}
const source={name:'测试',key:'test',type:1,api:'/api'};
test('settings and search navigation preserve the library and phone configuration imports',async t=>{
  const a=await app(t,{sites:[source]},(name,args)=>name==='tvbox_remote_start'?{codes:[{url:'http://192.168.1.2:9978/#token',svg:'<svg xmlns="http://www.w3.org/2000/svg"/>'}]}:catalogue(name,args));
  a.get('settings-tab').click();assert.equal(a.get('library').classList.contains('hidden'),true);
  await a.get('phone-start').onclick();assert.match(a.get('phone').querySelector('img').src,/^data:image\/svg\+xml/);
  await a.events['tvbox-phone-config']({payload:JSON.stringify({name:'手机片源',sites:[source]})});
  assert.match(a.get('profile').textContent,/手机配置/);assert.equal(a.get('library').classList.contains('hidden'),false);
  await a.get('phone-stop').onclick();assert.ok(a.calls.some(c=>c.name==='tvbox_remote_stop'));assert.equal(a.get('phone').children.length,0);
  a.get('find').click();assert.equal(a.w.document.activeElement,a.get('keyword'));
});
test('empty TVBOX home explains setup and leads to the configuration form',async t=>{
  const a=await app(t,{});
  assert.equal(a.get('onboarding').classList.contains('hidden'),false);
  a.get('onboard-config').click();
  assert.equal(a.get('settings-panel').classList.contains('hidden'),false);
  assert.equal(a.w.document.activeElement,a.get('config-url'));
});
test('multi-warehouse URL imports named configurations and loads them on selection',async t=>{
  const collection='https://github.catvod.com/https://raw.githubusercontent.com/tushen6/Tomorrow/master/lmw.json';
  const first='https://example.test/first.json',second='https://example.test/second.json';
  const a=await app(t,{},(name,args)=>{
    if(name!=='tvbox_fetch')return;
    if(args.url===collection)return JSON.stringify({urls:[{name:'第一仓',url:first},{name:'第二仓',url:second}]});
    if(args.url===first)return JSON.stringify({sites:[{name:'第一片源',type:1,api:'https://source.test/api'}]});
    if(args.url===second)return JSON.stringify({sites:[{name:'第二片源',type:1,api:'https://source.test/api'}]});
    return catalogue(name,args);
  });
  a.get('config-url').value=collection;await a.get('load').onclick();
  assert.match(a.get('profile').textContent,/第一仓/);
  assert.match(a.get('profile').textContent,/第二仓/);
  assert.match(a.get('site').textContent,/第一片源/);
  assert.equal(a.get('config-url').value,collection);
  a.get('profile').value=a.get('profile').options[2].value;await a.get('profile').onchange();
  assert.match(a.get('site').textContent,/第二片源/);
  assert.equal(a.get('config-url').value,collection);
});
test('source filter narrows a large warehouse without changing source indexes',async t=>{
  const a=await app(t,{sites:[{...source,name:'影片 A'},{...source,name:'影片 B',key:'second'}]},catalogue);
  a.get('site-filter').value='影片 B';a.get('site-filter').oninput();
  assert.equal(a.get('site').options.length,1);
  assert.equal(a.get('site').value,'1');
  await a.get('site').onchange();
  assert.equal(a.calls.findLast(c=>c.name==='tvbox_fetch').args.url.startsWith('https://source.test/'),true);
});
function catalogue(name,args) {
  if(name!=='tvbox_fetch')return;
  const url=new URL(args.url);
  return JSON.stringify(url.searchParams.has('ids')?{list:[{vod_id:2,vod_name:'电影',vod_play_from:'4K',vod_play_url:'一$https://video.test/a.mkv?token=a$b#二$https://video.test/b.mkv'}]}:{class:[{type_id:1,type_name:'电影'}],list:[{vod_id:2,vod_name:'电影'}],pagecount:1});
}
async function episode(a,index=0){await a.get('home').onclick();await a.get('results').querySelector('button').onclick();await a.get('detail').querySelectorAll('.tv-episodes button')[index].onclick();}
test('browse and signed episode URL reach embedded player intact',async t=>{
  const a=await app(t,{sites:[source]},catalogue);await episode(a);
  const call=a.calls.findLast(c=>c.name==='tvplayer_play');assert.equal(call.args.target,'https://video.test/a.mkv?token=a$b');assert.ok(call.args.session);
});
test('JAR source resolves global spider URL and dispatches to built-in JVM',async t=>{
  const a=await app(t,{spider:'./spider.jar;md5;abc',sites:[{type:3,api:'csp_Test',key:'jar',ext:'custom'}]},(name,args)=>name==='tvbox_external'?{class:[],list:[]}:undefined);
  await a.get('home').onclick();const call=a.calls.findLast(c=>c.name==='tvbox_external');assert.equal(call.args.api,'csp_Test');assert.equal(call.args.jar,'https://source.test/spider.jar;md5;abc');assert.equal(call.args.ext,'custom');
});
test('Python source resolves script URL and keeps structured extension',async t=>{
  const a=await app(t,{sites:[{type:3,api:'./source.py',key:'python',ext:{host:'https://example.com'}}]},(name,args)=>name==='tvbox_external'?{class:[],list:[]}:undefined);
  await a.get('home').onclick();const call=a.calls.findLast(c=>c.name==='tvbox_external');assert.equal(call.args.api,'https://source.test/source.py');assert.equal(call.args.ext.host,'https://example.com');
});

test('inline and remote M3U channels appear and can play',async t=>{
  const a=await app(t,{lives:[{channels:[{name:'一',urls:['https://live.test/1']}]},{url:'/live.m3u'}]},()=> '#EXTM3U\n#EXTINF:-1,二\nhttps://live.test/2');
  await a.get('live').onclick();assert.equal(a.get('results').children.length,2);await a.get('results').children[1].onclick();assert.equal(a.calls.findLast(c=>c.name==='tvplayer_play').args.target,'https://live.test/2');
});
test('resume loads progress persisted in native data',async t=>{
  const a=await app(t,{sites:[source]},catalogue,{history:[{key:'p1:test:2:0:0',name:'电影',url:'https://video.test/a.mkv',position:120,duration:3600}]});await episode(a);
  assert.equal(a.calls.findLast(c=>c.name==='tvplayer_play').args.options.start,120);
});
test('EOF advances to next episode; stop events do not',async t=>{
  const a=await app(t,{sites:[source]},catalogue);await episode(a);const first=a.calls.findLast(c=>c.name==='tvplayer_play');
  a.events['tvbox-player-event']({payload:{kind:'ended',session:first.args.session,reason:2,error:0}});await tick();assert.equal(a.calls.filter(c=>c.name==='tvplayer_play').length,1);
  a.events['tvbox-player-event']({payload:{kind:'ended',session:first.args.session,reason:0,error:0}});await tick();assert.equal(a.calls.findLast(c=>c.name==='tvplayer_play').args.target,'https://video.test/b.mkv');
});
test('closing playback window persists final progress',async t=>{
  const a=await app(t,{sites:[source]},catalogue);await episode(a);const call=a.calls.findLast(c=>c.name==='tvplayer_play');
  a.events['tvbox-player-event']({payload:{kind:'closed',session:call.args.session,position:123,duration:3600,width:3840,height:2160}});await tick();
  const saved=a.calls.findLast(c=>c.name==='tvbox_save').args.data;assert.equal(saved.history[0].position,123);assert.equal(saved.history[0].duration,3600);
});
test('movie favorites persist and render safely',async t=>{
  const a=await app(t,{sites:[source]},catalogue);await a.get('home').onclick();await a.get('results').querySelector('button').onclick();await a.get('detail').querySelector('.tv-detail-heading button').onclick();a.get('favorites').onclick();assert.equal(a.get('results').children.length,1);
});
test('source type4 play result and JSON parser headers are honored',async t=>{
  const s={...source,type:4};const a=await app(t,{sites:[s],parses:[{name:'解析',type:1,url:'https://parser.test/?url='}]},(name,args)=>{
    if(name!=='tvbox_fetch')return;const url=new URL(args.url);
    if(url.hostname==='parser.test')return JSON.stringify({url:'https://video.test/resolved.m3u8',header:{Cookie:'key=value'}});
    if(url.searchParams.has('play'))return JSON.stringify({url:'https://page.test/movie?id=1',parse:1});return catalogue(name,args);
  });await episode(a);const call=a.calls.findLast(c=>c.name==='tvplayer_play');assert.equal(call.args.target,'https://video.test/resolved.m3u8');assert.equal(call.args.headers.Cookie,'key=value');
});
test('JAR webParse proxy resolves flag-matched web parser and opens sniff window',async t=>{
  const sourceUrl='https://video.test/watch?name=中文&episode=1';
  const encoded=Buffer.from(sourceUrl).toString('base64url');
  const s={...source,type:4};
  const a=await app(t,{sites:[s],parses:[
    {name:'其他线路',type:0,url:'https://other.test/?url=',ext:{flag:['Other']}},
    {name:'目标线路',type:0,url:'https://parser.test/?url=',ext:'{"flag":["4K"]}'},
  ]},(name,args)=>{
    if(name!=='tvbox_fetch')return;
    const url=new URL(args.url);
    if(url.searchParams.has('play'))return JSON.stringify({url:`proxy://go=SuperParse&flag=4K&url=${encoded}`,parse:1});
    return catalogue(name,args);
  });
  await episode(a);
  const sniff=a.calls.findLast(c=>c.name==='tvbox_sniff');
  assert.equal(new URL(sniff.args.url).origin,'https://parser.test');
  assert.equal(new URL(sniff.args.url).searchParams.get('url'),new URL(sourceUrl).href);
  assert.equal(a.calls.some(c=>c.name==='tvplayer_play'),false);
});
test('JS sources dispatch through the embedded QuickJS adapter',async t=>{
  const a=await app(t,{sites:[{...source,type:3,api:'./spider.js'}]},(name,args)=>name==='tvbox_spider'?{class:[{type_id:1,type_name:'电影'}],list:[{vod_id:2,vod_name:'JS 电影'}]}:undefined);
  await a.get('home').onclick();assert.equal(a.calls.findLast(c=>c.name==='tvbox_spider').args.api,'https://source.test/spider.js');assert.match(a.get('results').textContent,/JS 电影/);
});
test('sniff candidates use the source UA and referer in native playback',async t=>{
  const a=await app(t,{});a.get('direct').value='https://page.test/watch';await a.get('sniff').onclick();const call=a.calls.findLast(c=>c.name==='tvbox_sniff');
  a.events['tvbox-sniff-result']({payload:{session:call.args.session,url:'https://video.test/v.m3u8',referer:'https://page.test/watch',ua:'test'}});await a.get('sniff-results').querySelector('button').onclick();
  assert.equal(a.calls.findLast(c=>c.name==='tvplayer_play').args.headers.Referer,'https://page.test/watch');
});
test('unsafe protocols are rejected before native playback',async t=>{
  const a=await app(t,{});a.get('direct').value='javascript:alert(1)';await a.get('play').onclick();assert.equal(a.calls.filter(c=>c.name==='tvplayer_play').length,0);assert.match(a.get('status').textContent,/HTTP/);
});
test('magnet downloads a local video before native playback',async t=>{
  const a=await app(t,{},name=>name==='tvbox_prepare_media'?'F:\\TVBOX\\movie.mkv':undefined);
  a.get('direct').value='magnet:?xt=urn:btih:0123456789abcdef';await a.get('play').onclick();
  assert.equal(a.calls.find(c=>c.name==='tvbox_prepare_media').args.target,'magnet:?xt=urn:btih:0123456789abcdef');
  assert.equal(a.calls.findLast(c=>c.name==='tvplayer_play').args.target,'F:\\TVBOX\\movie.mkv');
});
test('Thunder URL is decoded before native playback',async t=>{
  const a=await app(t,{},name=>name==='tvbox_prepare_media'?'https://video.test/movie.mp4':undefined);
  a.get('direct').value='thunder://QUFodHRwczovL2V4YW1wbGUub3JnL21vdmllLm1wNFpa';await a.get('play').onclick();
  assert.equal(a.calls.findLast(c=>c.name==='tvplayer_play').args.target,'https://video.test/movie.mp4');
});
test('torrent episode bypasses webpage parser and starts native download',async t=>{
  const torrentCatalogue=(name,args)=>{
    if(name!=='tvbox_fetch')return;
    const url=new URL(args.url);
    return JSON.stringify(url.searchParams.has('ids')?{list:[{vod_id:2,vod_name:'电影',vod_play_from:'BT',vod_play_url:'一$magnet:?xt=urn:btih:0123456789abcdef'}]}:{class:[],list:[{vod_id:2,vod_name:'电影'}]});
  };
  const a=await app(t,{sites:[source],parses:[{name:'网页解析',type:0,url:'https://parser.test/?url='}]},(name,args)=>name==='tvbox_prepare_media'?'F:\\TVBOX\\episode.mkv':torrentCatalogue(name,args));
  await episode(a);
  assert.ok(a.calls.some(c=>c.name==='tvbox_prepare_media'));
  assert.equal(a.calls.some(c=>c.name==='tvbox_sniff'),false);
});
test('local multiple selection supports next episode',async t=>{
  const a=await app(t,{});a.w.__TAURI__.dialog.open=async()=>['F:\\movie1.mkv','F:\\movie2.mkv'];await a.get('local').onclick();await a.get('episode-next').onclick();assert.equal(a.calls.findLast(c=>c.name==='tvplayer_play').args.target,'F:\\movie2.mkv');
});
