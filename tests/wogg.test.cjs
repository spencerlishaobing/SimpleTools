const {test}=require('node:test');
const assert=require('node:assert/strict');
const fs=require('node:fs');
const vm=require('node:vm');
test('Wogg search cards use search template and preserve image URL queries',()=>{
  const html='<main><div class="module-search-item"><div class="module-item-pic"><img data-src="https://image.test/a?x=1&amp;y=2"></div><h3><a href="/voddetail/81745.html" title="唐朝好男人2">唐朝好男人2</a></h3></div><div class="module-search-item"><h3><a href="/voddetail/12.html" title="唐朝好男人">唐朝好男人</a></h3></div></main>';
  const ctx={req:()=>({code:200,content:html})};vm.createContext(ctx);
  vm.runInContext(fs.readFileSync('src-tauri/resources/tvspiders/wogg.js','utf8').replace('export default','globalThis.spider='),ctx);
  ctx.spider.init({});const r=ctx.spider.search('唐朝',1);
  assert.equal(r.list.length,2);assert.equal(r.list[0].vod_id,'81745');
  assert.equal(r.list[0].vod_pic,'https://image.test/a?x=1&y=2');
});
