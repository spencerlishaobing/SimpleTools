const {test}=require('node:test');
const assert=require('node:assert/strict');
const fs=require('node:fs');
const {JSDOM}=require('jsdom');

test('phone page submits configuration using the QR token and removes it from browser history',async t=>{
  const dom=new JSDOM(fs.readFileSync('src/tvbox-phone.html','utf8'),{url:'http://192.168.1.2:9978/#session-secret',runScripts:'outside-only'});
  t.after(()=>dom.window.close());const w=dom.window,calls=[];
  w.fetch=async(url,args)=>{calls.push({url,args});return {text:async()=> '已发送到电脑'};};
  w.eval(w.document.querySelector('script').textContent);
  assert.equal(w.location.hash,'');w.document.getElementById('config').value='https://example.com/tv.json';
  await w.document.querySelector('form').onsubmit({preventDefault(){}});
  assert.equal(calls[0].url,'/config');assert.equal(calls[0].args.headers['X-TVBOX-Token'],'session-secret');
  assert.equal(calls[0].args.body,'https://example.com/tv.json');assert.match(w.document.getElementById('status').textContent,/已发送/);
});

test('phone page without QR token cannot submit',t=>{
  const dom=new JSDOM(fs.readFileSync('src/tvbox-phone.html','utf8'),{url:'http://localhost:9978/',runScripts:'outside-only'});
  t.after(()=>dom.window.close());dom.window.eval(dom.window.document.querySelector('script').textContent);
  assert.equal(dom.window.document.getElementById('send').disabled,true);
});
