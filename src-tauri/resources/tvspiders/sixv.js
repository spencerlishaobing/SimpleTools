/** 新6V：公开网页、磁力和网盘资源，不依赖 JAR。 */
const BASE = 'https://www.xb6v.com';
const UA = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 Chrome/124 Safari/537.36';
const CATS = [['qian50m.html','最新50部'],['xijupian','喜剧片'],['dongzuopian','动作片'],['aiqingpian','爱情片'],['kehuanpian','科幻片'],['kongbupian','恐怖片'],['juqingpian','剧情片'],['zhanzhengpian','战争片'],['jilupian','纪录片'],['donghuapian','动画片'],['dianshiju','电视剧'],['ZongYi','综艺']];
function abs(v){ return /^https?:\/\//i.test(v||'') ? v : BASE+'/'+String(v||'').replace(/^\/+/, ''); }
function clean(v){ return String(v||'').replace(/<[^>]+>/g,' ').replace(/&nbsp;|&#160;/gi,' ').replace(/&amp;/gi,'&').replace(/&quot;/gi,'"').replace(/\s+/g,' ').trim(); }
function get(path){ const r=req(abs(path),{headers:{'User-Agent':UA,Referer:BASE+'/',Accept:'text/html'}}); if(r.code!==200)throw Error('新6V返回 '+r.code); return r.content; }
function cards(doc){
  const out=[],seen={}; let m;
  // 直接从带 class="zoom" 的链接开始匹配：新版页面顶部菜单的 <a> 会先吞掉后面的列表项，
  // 用旧的“任意 <a> 再过滤”写法会把所有卡片吞到菜单匹配里，导致列表恒为空。
  const re=/<a\b([^>]*class=["'][^"']*zoom[^"']*["'][^>]*)>[\s\S]*?<img\b([^>]*)>/gi;
  while((m=re.exec(doc))){ const href=(m[1].match(/href=["']([^"']+)/i)||[])[1], raw=(m[1].match(/title=["']([^"']+)/i)||[])[1], pic=(m[2].match(/(?:src|data-src)=["']([^"']+)/i)||[])[1]; const name=clean(raw); if(!href||!name||seen[href])continue; seen[href]=1; out.push({vod_id:abs(href),vod_name:name,vod_pic:abs(pic||''),vod_remarks:/2160|4k/i.test(m[0])?'4K':''}); }
  return out;
}
function categoryPath(tid,page){ const p=Math.max(1,Number(page)||1), id=tid||'qian50m.html'; if(/\.html$/i.test(id))return '/'+id; return '/'+id+'/'+(p>1?'index_'+p+'.html':''); }
export default {
  init(){},
  home(){ return {class:CATS.map(v=>({type_id:v[0],type_name:v[1]})),list:cards(get('/'))}; },
  category(tid,page){ const p=Math.max(1,Number(page)||1),list=cards(get(categoryPath(tid,p))); return {page:p,pagecount:list.length?p+1:p,limit:list.length,total:list.length?2147483647:0,list}; },
  search(keyword,page){
    if(Number(page)>1)return {page:Number(page),pagecount:Number(page),list:[]};
    const body='show=title&tempid=1&tbname=article&keyboard='+encodeURIComponent(keyword||'')+'&Submit='+encodeURIComponent('搜索')+'&dopost=search';
    const r=req(BASE+'/e/search/so.php',{method:'POST',headers:{'Content-Type':'application/x-www-form-urlencoded','User-Agent':UA,Referer:BASE+'/'},body});
    if(r.code!==200)throw Error('新6V搜索返回 '+r.code); return {page:1,pagecount:1,list:cards(r.content)};
  },
  detail(id){
    const doc=get(id), title=clean((doc.match(/<h1\b[^>]*>([\s\S]*?)<\/h1>/i)||doc.match(/<title>([\s\S]*?)<\/title>/i)||[])[1]).replace(/-新版6v[\s\S]*$/i,''), block=(doc.match(/<div\b[^>]*id=["']post_content["'][^>]*>([\s\S]*?)<\/div>\s*<\/div>/i)||[])[1]||doc;
    const pic=(block.match(/<img\b[^>]*src=["']([^"']+)/i)||[])[1]||'', links=[], seen={}; let m; const re=/<a\b[^>]*href=["'](magnet:\?[^"']+|ed2k:\/\/[^"']+|https?:\/\/(?:pan\.quark\.cn|drive\.uc\.cn|(?:pan|yun)\.baidu\.com|(?:www\.)?(?:alipan|aliyundrive)\.com)\/s\/[^"']+)["'][^>]*>([\s\S]*?)<\/a>/gi;
    while((m=re.exec(block))){const url=m[1].replace(/&amp;/g,'&'),name=clean(m[2])||(/magnet:/i.test(url)?'磁力资源':'网盘资源');if(!seen[url]){seen[url]=1;links.push(name+'$'+url);}}
    links.sort((a,b)=>/pan\.|drive\.uc|alipan|aliyundrive/i.test(b)-/pan\.|drive\.uc|alipan|aliyundrive/i.test(a));
    if(!links.length)throw Error('新6V详情页没有可用下载资源');
    return {list:[{vod_id:id,vod_name:title,vod_pic:abs(pic),vod_content:clean(block).slice(0,1200),vod_play_from:'下载资源',vod_play_url:links.join('#')}]};
  },
  play(flag,id){ return {parse:0,url:id}; },
};
