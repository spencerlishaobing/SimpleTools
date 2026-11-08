const fs=require('node:fs'),vm=require('node:vm'),assert=require('node:assert/strict');
const source=fs.readFileSync('src-tauri/resources/tvspiders/wogg.js','utf8').replace('export default','globalThis.adapter =');
let html='';const c={req:()=>({code:200,content:html})};vm.createContext(c);vm.runInContext(source,c);
for(const input of ['/db.php?url=https://img.doubanio.com/a.jpg','https://site.test/db.php?url=https%3A%2F%2Fimg.doubanio.com%2Fa.jpg','//img.doubanio.com/a.jpg'])assert(c.picture(input).startsWith('https://img.doubanio.com/a.jpg@Referer=https://api.douban.com/'));
assert.equal(c.picture(''),'');assert.equal(c.picture('/poster.jpg'),'https://www.wogg.net/poster.jpg');
assert(c.picture('/db.php?url=https://doubanio.com.evil.test/a.jpg').startsWith('https://www.wogg.net/db.php'));
assert(c.picture('https://img.doubanio.com/a.jpg@Referer=custom@User-Agent=custom').endsWith('@Referer=custom@User-Agent=custom'));
html="<div class='module-item'><a href='/voddetail/42.html' title='Film'></a><img data-src='/db.php?url=https://img.doubanio.com/a.jpg'><div class='module-item-text'>4K</div></div>";
assert(c.adapter.home().list[0].vod_pic.startsWith('https://img.doubanio.com/a.jpg@'));
assert(c.adapter.search('Film',1).list[0].vod_pic.startsWith('https://img.doubanio.com/a.jpg@'));
html="<div class='video-cover'><img data-src='/db.php?url=https://img.doubanio.com/a.jpg'></div><h1 class='page-title'>Film</h1><a href='https://pan.quark.cn/s/test'>Play</a>";
assert(c.adapter.detail('42').list[0].vod_pic.startsWith('https://img.doubanio.com/a.jpg@'));
console.log('10 WoGG image normalization and adapter-path assertions passed');

html="<div class='module-search-item'><div class='video-info-header'><h3><a href='/voddetail/77.html'>A &amp; B</a></h3></div><div class='module-item-pic'><img data-src='/plain.jpg'></div></div>";
const result=c.adapter.search('A',1).list;
assert.equal(result.length,1);assert.equal(result[0].vod_name,'A & B');assert.equal(result[0].vod_id,'77');
console.log('Search without title attribute: 3 assertions passed');
