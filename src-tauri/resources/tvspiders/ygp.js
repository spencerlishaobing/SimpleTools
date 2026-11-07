/** 荐影预告片：使用哔哩哔哩公开接口提供预告片搜索和分P播放。 */
const API = 'https://api.bilibili.com';
const WEB = 'https://www.bilibili.com';
const UA = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 Chrome/124 Safari/537.36';

function json(url) {
  const r = req(url, { headers: { 'User-Agent': UA, Referer: WEB + '/' } });
  if (r.code !== 200) throw Error('预告片接口返回 ' + r.code);
  const value = JSON.parse(r.content);
  if (value.code !== 0) throw Error(value.message || ('预告片接口错误 ' + value.code));
  return value.data || {};
}
function clean(v) { return String(v || '').replace(/<[^>]+>/g, '').replace(/&amp;/g, '&').replace(/&quot;/g, '"').trim(); }
function pic(v) { v = String(v || ''); return v.startsWith('//') ? 'https:' + v : v; }
function search(keyword, page) {
  const p = Math.max(1, Number(page) || 1);
  const q = new URLSearchParams();
  q.set('search_type', 'video');
  q.set('keyword', clean(keyword) + ' 预告片');
  q.set('order', 'totalrank');
  q.set('page', String(p));
  const data = json(API + '/x/web-interface/search/type?' + q.toString());
  return { page: p, pagecount: Number(data.numPages || 1), total: Number(data.numResults || 0), limit: Number(data.pagesize || 20), list: (data.result || []).map(v => ({
    vod_id: v.bvid,
    vod_name: clean(v.title),
    vod_pic: pic(v.pic),
    vod_remarks: String(v.duration || ''),
    vod_content: clean(v.description),
  })).filter(v => v.vod_id) };
}

export default {
  init() {},
  home() { return { class: [{ type_id: '电影', type_name: '电影预告' }, { type_id: '电视剧', type_name: '剧集预告' }, { type_id: '动画', type_name: '动画预告' }], list: [] }; },
  category(tid, page) { return search(tid, page); },
  search(keyword, _quick, page) { return search(keyword, page); },
  detail(id) {
    const bvid = (String(id).match(/BV[0-9A-Za-z]+/) || [String(id)])[0];
    const data = json(API + '/x/web-interface/view?bvid=' + encodeURIComponent(bvid));
    const pages = data.pages && data.pages.length ? data.pages : [{ page: 1, part: data.title || '预告片' }];
    return { list: [{ vod_id: bvid, vod_name: clean(data.title), vod_pic: pic(data.pic), vod_content: clean(data.desc), vod_play_from: '哔哩网页', vod_play_url: pages.map((v, i) => clean(v.part || ('预告片' + (i + 1))) + '$' + WEB + '/video/' + bvid + '?p=' + Number(v.page || i + 1)).join('#') }] };
  },
  play(_flag, id) { return { parse: 1, url: String(id), header: { 'User-Agent': UA, Referer: WEB + '/' } }; },
};
