/** 玩偶哥哥：影片目录、筛选、搜索、详情及网盘线路。 */
// 玩偶域名会轮换。饭太硬 JAR 会把最新可用域写入 wogg_site；本机适配器不依赖
// 该 Android SharedPreferences，改为 ext 优先 + 内置候选自动探测。
const DEFAULT_BASES = ['https://www.wogg.net','https://woggpan.888484.xyz','https://www.wogg.live','https://wogg.xxooo.cf','https://woggpan.xxooo.cf'];
let bases=DEFAULT_BASES.slice(), activeBase=bases[0];
const UA = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 Chrome/135 Safari/537.36';
const CATS = [['1','电影'],['2','剧集'],['44','臻彩'],['6','短漫剧'],['3','动漫'],['4','综艺'],['46','纪录片'],['5','音乐']];
const GENRES = ['喜剧','爱情','动作','恐怖','科幻','剧情','犯罪','奇幻','战争','悬疑','武侠','冒险','古装','历史','惊悚'];
const AREAS = [['中国大陆','大陆'],['中国香港','中国香港'],['中国台湾','中国台湾'],['美国','美国'],['韩国','韩国'],['日本','日本'],['西班牙','西班牙'],['泰国','泰国'],['法国','法国'],['英国','英国'],['德国','德国'],['印度','印度'],['其他','其他']];
function decode(v){ return String(v||'').replace(/&amp;/gi,'&').replace(/&quot;/gi,'"').replace(/&#39;|&apos;/gi,"'").replace(/&nbsp;/gi,' ').replace(/&#(\d+);/g,(_,n)=>String.fromCharCode(Number(n))); }
function clean(v){ return decode(String(v||'').replace(/<[^>]+>/g,' ')).replace(/\s+/g,' ').trim(); }
function root(v){return String(v||'').replace(/\/+$/,'');}
function abs(v){ v=decode(v); return /^https?:\/\//i.test(v)?v:root(activeBase)+'/'+String(v||'').replace(/^\/+/, ''); }
function get(path){
  let last='';
  const order=[activeBase].concat(bases.filter(x=>x!==activeBase));
  for(const base of order){
    const url=/^https?:\/\//i.test(path)?path:root(base)+'/'+String(path||'').replace(/^\/+/, '');
    try{
      const r=req(url,{headers:{'User-Agent':UA,Referer:root(base)+'/',Accept:'text/html,application/xhtml+xml'}});
      const body=String(r.content||'');
      if(r.code===200&&body.length>100&&!/<title>Redirecting\.\.\.<\/title>/i.test(body)){activeBase=root(base);return body;}
      last=`${base} HTTP ${r.code}`;
    }catch(e){last=String(e&&e.message||e);}
  }
  throw Error('玩偶站点暂不可用：'+last);
}
function idOf(v){ const m=String(v||'').match(/(?:voddetail\/)?(\d+)/); return m?m[1]:String(v||''); }
function cards(doc){
  const out=[],seen={}; let m; const re=/<div\b[^>]*class=["'][^"']*module-(?:search-)?item(?:\s|["'])[^>]*>([\s\S]*?)(?=<div\b[^>]*class=["'][^"']*module-(?:search-)?item(?:\s|["'])|<\/main>|$)/gi;
  while((m=re.exec(doc))){ const b=m[1], href=(b.match(/href=["']([^"']*\/voddetail\/\d+\.html)/i)||[])[1], name=decode((b.match(/class=["'][^"']*module-item-title[^"']*["'][^>]*title=["']([^"']+)/i)||b.match(/href=["'][^"']*\/voddetail\/\d+\.html["'][^>]*title=["']([^"']+)/i)||[])[1]), pic=(b.match(/<img\b[^>]*data-src=["']([^"']+)/i)||b.match(/<img\b[^>]*src=["']([^"']+)/i)||[])[1], remark=clean((b.match(/class=["'][^"']*module-item-text[^"']*["'][^>]*>([\s\S]*?)<\/div>/i)||[])[1]), year=clean((b.match(/class=["'][^"']*module-item-caption[^"']*["'][^>]*>\s*<span[^>]*>([\s\S]*?)<\/span>/i)||[])[1]); if(!href||!name||seen[href])continue; seen[href]=1; out.push({vod_id:idOf(href),vod_name:name,vod_pic:abs(pic||''),vod_remarks:remark,vod_year:year}); }
  return out;
}
function values(xs){ return [{n:'全部',v:''}].concat(xs.map(x=>({n:Array.isArray(x)?x[1]:x,v:Array.isArray(x)?x[0]:x}))); }
function filters(){ const years=[]; for(let y=new Date().getFullYear();y>=2010;y--)years.push(String(y)); const f={}; for(const c of CATS){ const rows=[]; if(['1','2','44'].includes(c[0]))rows.push({key:'3',name:'类型',value:values(GENRES)}); if(c[0]!=='6')rows.push({key:'11',name:'年代',value:values(years)}); if(['1','2','3','4','44'].includes(c[0]))rows.push({key:'1',name:'地区',value:values(AREAS)}); if(c[0]==='5')rows.push({key:'5',name:'字母',value:values('ABCDEFGHIJKLMNOPQRSTUVWXYZ'.split(''))}); f[c[0]]=rows; } return f; }
function pageCount(doc,p){ const ns=[]; let m,re=/(?:vodshow\/[^"']*?--------|page\/)(\d+)(?:---|\.html)/gi; while((m=re.exec(doc)))ns.push(Number(m[1])); return Math.max(p,...ns.filter(Number.isFinite)); }
function field(doc,label){ const re=new RegExp('<span[^>]*class=["\'][^"\']*video-info-itemtitle[^"\']*["\'][^>]*>\\s*'+label+'[：:]?\\s*<\\/span>\\s*<div[^>]*>([\\s\\S]*?)<\\/div>','i'); return clean((doc.match(re)||[])[1]); }
export default {
  init(ext){
    let cfg=ext;
    if(typeof cfg==='string'){try{cfg=JSON.parse(cfg);}catch(_){cfg={siteUrl:cfg};}}
    const supplied=[];
    const add=v=>{if(Array.isArray(v))v.forEach(add);else if(/^https?:\/\//i.test(String(v||'')))supplied.push(root(v));};
    if(cfg&&typeof cfg==='object'){add(cfg.siteUrl);add(cfg.site);}
    bases=[...new Set(supplied.concat(DEFAULT_BASES))];activeBase=bases[0];
  },
  home(){ const doc=get('/'); return {class:CATS.map(x=>({type_id:x[0],type_name:x[1]})),filters:filters(),list:cards(doc)}; },
  category(tid,page,filter,ext){ const p=Math.max(1,Number(page)||1), e=ext||{}, area=e['1']||'', genre=e['3']||'', letter=e['5']||'', year=e['11']||''; const path='/vodshow/'+encodeURIComponent(tid)+'-'+encodeURIComponent(area)+'--'+encodeURIComponent(genre)+'-'+''+'-'+encodeURIComponent(letter)+'---'+p+'---'+encodeURIComponent(year)+'.html', doc=get(path), list=cards(doc); return {page:p,pagecount:pageCount(doc,p),limit:list.length,total:list.length?2147483647:0,list}; },
  search(keyword,page){ const p=Math.max(1,Number(page)||1), path='/vodsearch/'+(p>1?'----------'+p+'---':'-------------')+'.html?wd='+encodeURIComponent(keyword||''), doc=get(path); if(doc.length<5000&&/维护/.test(doc))return {page:p,pagecount:p,limit:0,total:0,list:[]}; const list=cards(doc); return {page:p,pagecount:pageCount(doc,p),limit:list.length,total:list.length?2147483647:0,list}; },
  detail(id){ const vid=idOf(id),doc=get('/voddetail/'+vid+'.html'); const name=clean((doc.match(/<h1\b[^>]*class=["'][^"']*page-title[^"']*["'][^>]*>([\s\S]*?)<\/h1>/i)||[])[1]), pic=(doc.match(/<div\b[^>]*class=["'][^"']*video-cover[^"']*["'][\s\S]*?<img\b[^>]*data-src=["']([^"']+)/i)||[])[1], type=clean((doc.match(/class=["'][^"']*video-info-aux[^"']*["'][\s\S]*?class=["'][^"']*video-tag-icon[^"']*["'][^>]*>([\s\S]*?)<\/span>/i)||[])[1]), content=clean((doc.match(/<p\b[^>]*class=["']sqjj_a[^"']*["'][^>]*>([\s\S]*?)<\/p>/i)||doc.match(/<p\b[^>]*class=["']zkjj_a[^"']*["'][^>]*>([\s\S]*?)<\/p>/i)||[])[1]), links=[],seen={}; let m; const re=/https?:\/\/(?:pan\.quark\.cn|drive\.uc\.cn|(?:pan|yun)\.baidu\.com|(?:www\.)?(?:alipan|aliyundrive)\.com)\/s\/[^"'<>\s)]+/gi; while((m=re.exec(decode(doc)))){const u=m[0].replace(/&amp;/g,'&');if(!seen[u]){seen[u]=1;links.push(u);}} const from=[],urls=[]; for(const u of links){const flag=/quark/i.test(u)?'夸克网盘':/uc\.cn/i.test(u)?'UC网盘':/baidu/i.test(u)?'百度网盘':'阿里云盘';from.push(flag);urls.push((name||'影片')+' · '+flag+'$'+u);} if(!links.length)throw Error('玩偶详情页没有可用网盘资源'); return {list:[{vod_id:vid,vod_name:name||('玩偶资源 '+vid),vod_pic:abs(pic||''),type_name:type,vod_year:field(doc,'年代'),vod_remarks:field(doc,'备注'),vod_director:field(doc,'导演'),vod_actor:field(doc,'主演'),vod_content:content,vod_play_from:from.join('$$$'),vod_play_url:urls.join('$$$')}]}; },
  play(flag,id){ return {parse:0,url:id}; }
};
