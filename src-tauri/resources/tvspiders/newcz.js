/**
 * 厂长资源（NewCz）桌面适配器。
 *
 * 站点是 WordPress 影视模板；这里只依赖公开页面结构，不依赖 Android/JAR。
 * 播放页通常直接包含 m3u8，若站点改为脚本播放器则交给现有嗅探器。
 */
const BASE = 'https://www.4kcz.com';
const UA = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0 Safari/537.36';
const CATS = [
  ['movie_bt', '全部'],
  ['dbtop250', '豆瓣电影 Top250'],
  ['movie_bt_series/dyy', '电影'],
  ['movie_bt_series/guochanju', '国产剧'],
  ['movie_bt_series/mj', '美剧'],
  ['movie_bt_series/hj', '韩剧'],
  ['movie_bt_series/rj', '日剧'],
  ['movie_bt_series/huayudianying', '华语电影'],
  ['movie_bt_series/meiguodianying', '欧美电影'],
  ['movie_bt_series/hanguodianying', '韩国电影'],
  ['movie_bt_series/ribendianying', '日本电影'],
];

function absolute(path) {
  if (/^https?:\/\//i.test(path || '')) return path;
  return BASE + '/' + String(path || '').replace(/^\/+/, '');
}

function html(path) {
  const r = req(absolute(path), {
    headers: { 'User-Agent': UA, Referer: BASE + '/', Accept: 'text/html,application/xhtml+xml' },
  });
  if (r.code !== 200) throw Error('厂长资源返回 ' + r.code);
  if (/SafeLine|Access Forbidden|访问已被拦截/.test(r.content)) throw Error('厂长资源触发访问保护，请稍后重试');
  return r.content;
}

function clean(value) {
  return String(value || '')
    .replace(/<[^>]+>/g, ' ')
    .replace(/&nbsp;/g, ' ')
    .replace(/&amp;/g, '&')
    .replace(/&#0*39;|&apos;/g, "'")
    .replace(/&quot;/g, '"')
    .replace(/\s+/g, ' ')
    .trim();
}

function attr(block, name) {
  const m = block.match(new RegExp('\\b' + name + '=["\\\']([^"\\\']+)', 'i'));
  return m ? m[1].replace(/&#038;/g, '&') : '';
}

function cards(doc) {
  const found = [], seen = {};
  const re = /<li\b[\s\S]*?<\/li>/gi;
  let m;
  while ((m = re.exec(doc))) {
    const block = m[0];
    const link = block.match(/href=["']([^"']*\/movie\/\d+\.html)["']/i);
    if (!link) continue;
    const id = absolute(link[1]);
    if (seen[id]) continue;
    const title = block.match(/(?:class=["'][^"']*dytit[^"']*["'][\s\S]*?|<a\b[^>]*href=["'][^"']*\/movie\/\d+\.html["'][^>]*?)title=["']([^"']+)/i);
    const image = block.match(/\b(?:data-original|data-src|src)=["']([^"']+)["']/i);
    const remark = block.match(/class=["'][^"']*(?:jidi|hdinfo|qb|tags?)[^"']*["'][^>]*>([\s\S]*?)<\//i);
    const name = clean(title ? title[1] : '');
    if (!name) continue;
    seen[id] = true;
    found.push({ vod_id: id, vod_name: name, vod_pic: image ? absolute(image[1]) : '', vod_remarks: clean(remark ? remark[1] : '') });
  }
  return found;
}

function meta(doc, label) {
  const re = new RegExp(label + '[：:]?\\s*(?:<[^>]+>\\s*)*([^<\\n]+)', 'i');
  const m = doc.match(re);
  return clean(m ? m[1] : '');
}

export default {
  init() {},
  home() {
    return { class: CATS.map((x) => ({ type_id: x[0], type_name: x[1] })), list: cards(html('/')) };
  },
  category(tid, page) {
    const p = Math.max(1, Number(page) || 1);
    const path = '/' + (tid || 'movie_bt') + (p > 1 ? '/page/' + p : '');
    const list = cards(html(path));
    return { page: p, pagecount: list.length ? p + 1 : p, limit: list.length, total: list.length ? 2147483647 : 0, list };
  },
  search(keyword, page) {
    const p = Math.max(1, Number(page) || 1);
    return { page: p, list: cards(html('/page/' + p + '?s=' + encodeURIComponent(keyword || ''))) };
  },
  detail(id) {
    const doc = html(id);
    const title = clean((doc.match(/<h1\b[^>]*>([\s\S]*?)<\/h1>/i) || doc.match(/<title>([\s\S]*?)<\/title>/i) || [])[1]);
    const pic = (doc.match(/(?:property=["']og:image["'][^>]*content|content=["']([^"']+)["'][^>]*property=["']og:image)/i) || [])[1] || '';
    const description = clean((doc.match(/(?:class=["'][^"']*(?:yp_context|jianjie|entry-content)[^"']*["'])[^>]*>([\s\S]*?)<\/div>/i) || [])[1]);
    const episodes = [], seen = {};
    const re = /<a\b([^>]*href=["']([^"']*\/v_play\/[^"']+\.html)["'][^>]*)>([\s\S]*?)<\/a>/gi;
    let m;
    while ((m = re.exec(doc))) {
      const url = m[2].replace(/^\//, '');
      if (seen[url]) continue;
      seen[url] = true;
      episodes.push((clean(attr(m[1], 'title')) || clean(m[3]) || '正片') + '$' + url);
    }
    if (!episodes.length) throw Error('厂长资源未找到播放线路');
    return { list: [{
      vod_id: id, vod_name: title.replace(/\s*[-_].*$/, ''), vod_pic: absolute(pic),
      vod_year: meta(doc, '年份'), vod_area: meta(doc, '地区'), vod_actor: meta(doc, '主演'),
      vod_director: meta(doc, '导演'), vod_content: description.slice(0, 1000),
      vod_play_from: '专线', vod_play_url: episodes.join('#'),
    }] };
  },
  play(flag, id) {
    const page = absolute(id);
    const doc = html(page);
    const direct = doc.match(/https?:\\?\/\\?\/[^"'<>\s]+?\.m3u8(?:\?[^"'<>\s]*)?/i);
    if (direct) return { parse: 0, url: direct[0].replace(/\\\//g, '/'), header: { 'User-Agent': UA, Referer: page } };
    return { parse: 1, url: page, header: { 'User-Agent': UA, Referer: BASE + '/' } };
  },
};
