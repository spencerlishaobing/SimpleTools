const {test}=require('node:test');
const assert=require('node:assert/strict');
global.DOMParser=require('@xmldom/xmldom').DOMParser;
const C=require('../src/modules/tvbox-core.js');
test('JSONC preserves URLs and commas inside strings',()=>{
  assert.deepEqual(C.json('{/* comment */"url":"https://a.test/a,b}","list":[1,2,], // note\n}'),{url:'https://a.test/a,b}',list:[1,2]});
});
test('XML source categories, CDATA, episodes and paging normalize',()=>{
  const result=C.response('<rss><class><ty id="1">电影</ty></class><list page="2" pagecount="3"><video><id>9</id><name>测试</name><des><![CDATA[<p>简介</p>]]></des><dl><dd flag="4K"><![CDATA[一$https://v.test/a?key=a$b#二$https://v.test/b]]></dd></dl></video></list></rss>',0);
  assert.equal(result.class[0].type_name,'电影');assert.equal(result.pagecount,3);
  assert.equal(C.lines(result.list[0])[0].episodes[0].url,'https://v.test/a?key=a$b');
});
test('remote protocol uses base64 UTF-8 filters and play flags',()=>{
  const s={type:4,api:'https://s.test/api',ext:'拓展'};
  const u=new URL(C.request(s,'category',{t:'电影',page:2,filters:{year:'2026',地区:'中国'}}));
  assert.deepEqual(JSON.parse(Buffer.from(u.searchParams.get('ext'),'base64').toString()),{year:'2026',地区:'中国'});
  assert.equal(u.searchParams.get('extend'),'拓展');assert.equal(u.searchParams.get('filter'),'true');
  assert.equal(new URL(C.request(s,'play',{id:'token',flag:'4K'})).searchParams.get('play'),'token');
});
test('XML queries use videolist and JSON uses detail',()=>{
  assert.equal(new URL(C.request({type:0,api:'https://s.test'},'detail',{id:9})).searchParams.get('ac'),'videolist');
  assert.equal(new URL(C.request({type:1,api:'https://s.test'},'search',{keyword:'电影'})).searchParams.get('ac'),'detail');
});
test('M3U metadata and VLC headers survive parsing',()=>{
  const channels=C.playlist('#EXTM3U\n#EXTINF:-1 tvg-id="cctv1" tvg-logo="https://a.test/logo.png" group-title="央视",综合\n#EXTVLCOPT:http-user-agent=Custom UA\nhttps://v.test/live.m3u8|Referer=https%3A%2F%2Fa.test');
  assert.equal(channels[0].epgId,'cctv1');assert.equal(channels[0].group,'央视');assert.equal(channels[0].headers['User-Agent'],'Custom UA');assert.equal(channels[0].headers.Referer,'https://a.test');
});
test('inline live headers and multi-line channels inherit group settings',()=>{
  const list=C.liveItems([{name:'组',ua:'test',channels:[{name:'台',urls:['https://v.test/1','https://v.test/2']}]}]);
  assert.equal(list[0].urls.length,2);assert.equal(list[0].headers['User-Agent'],'test');assert.equal(list[0].group,'组');
});
test('XMLTV matches display names and converts time zones',()=>{
  const result=C.epg('<tv><channel id="c1"><display-name>频道</display-name></channel><programme channel="c1" start="20261016080000 +0800" stop="20261016090000 +0800"><title>新闻</title></programme></tv>',{name:'频道'});
  assert.equal(result[0].title,'新闻');assert.equal(result[0].start,Date.parse('2026-10-16T00:00:00Z'));
});
test('resume restarts completed episodes and keeps mid-play progress',()=>{
  assert.equal(C.resume({position:120,duration:3600}),120);assert.equal(C.resume({position:3590,duration:3600}),0);
});
test('unsafe schemes rejected; source compatibility accepts JS, Python and Android JAR',()=>{
  assert.throws(()=>C.url('javascript:alert(1)'));assert.equal(C.supported({type:3,api:'https://s.test/spider.js'}),true);assert.equal(C.supported({type:3,api:'csp_Jar'}),true);
});
test('backup merges reassign colliding profile IDs and preserve history links',()=>{
  const existing={profiles:[{id:'p',base:'https://a.test',config:{sites:[]}}],profileId:'p',history:[],favorites:[],prefs:{volume:80}};
  const incoming={profiles:[{id:'p',base:'https://b.test',config:{sites:[]}}],profileId:'p',history:[{key:'p:s:1:0:0',context:{profileId:'p'},position:20}],favorites:[{key:'p:s:1',profileId:'p'}],prefs:{volume:20}};
  const result=C.mergeData(existing,incoming);assert.equal(result.profiles.length,2);assert.equal(result.history[0].context.profileId,'p-import-1');assert.equal(result.favorites[0].profileId,'p-import-1');assert.equal(result.prefs.volume,80);assert.equal(incoming.history[0].context.profileId,'p');
});
test('M3U EPG reference and imported channel IDs survive normalization',()=>{
  const channels=C.playlist('#EXTM3U x-tvg-url="https://epg.test/guide.xml.gz"\n#EXTINF:-1 tvg-id="c1",频道\nhttps://live.test/a.m3u8');
  const list=C.liveItems([{channels:channels.map(c=>({...c,urls:[c.url]}))}]);assert.equal(list[0].epgId,'c1');assert.equal(list[0].epg,'https://epg.test/guide.xml.gz');assert.throws(()=>C.playlist('#EXTM3U\n#EXT-X-TARGETDURATION:5\n#EXTINF:5\nhttps://a.test/1.ts'),/HLS/);
});
