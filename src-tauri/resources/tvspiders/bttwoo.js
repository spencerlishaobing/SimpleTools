/*
 * 比特兔（Bttwoo / bttwo.life）本地爬虫适配器（不依赖 JAR）
 * 站点为 Alpine.js 前端渲染的 VOD 站：
 *   - 首页 / 分类：/filter?classify=1|2|3&page=N，卡片 div[data-vod-id]，链接 /play/{vid}
 *   - 搜索：/search?q=关键词，卡片 div.group.relative
 *   - 详情：/play/{vid}（详情即播放页），剧集以 <a> 上的 data-line/data-episode/dataid 三元组列出
 *   - 播放：需带 Referer 新鲜取详情页 userlink，交 Rust wasmi 执行上游 nbmovie_wasm
 *            的 build_play_url(dataid, vid, quality, userlink) 得到 /video/play?... 签名路径，
 *            再 GET 该路径即返回 JSON（quality_urls[].url 为 m3u8 直链）。
 * 说明：QuickJS 沙箱无 WebAssembly，签名函数 __nbmovieSign 由 Rust 侧（nbmovie.rs，wasmi）提供。
 */
const BASE = 'https://www.bttwo.life';
const UA = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0 Safari/537.36';
const CATS = [
  { id: '/filter?classify=1&page=', name: '电影' },
  { id: '/filter?classify=2&page=', name: '电视剧' },
  { id: '/filter?classify=3&page=', name: '动漫' },
];

function headers(extra) {
  const h = { 'User-Agent': UA };
  if (extra) for (const k in extra) h[k] = extra[k];
  return h;
}

function fetchHtml(path, ref) {
  const url = /^https?:/i.test(path) ? path : BASE + path;
  const r = req(url, { headers: headers(ref ? { Referer: ref } : null) });
  if (r.code !== 200) throw Error('站点返回 ' + r.code);
  return r.content;
}

function absolute(path) {
  const value = String(path || '').trim();
  if (!value) return '';
  if (value.startsWith('//')) return 'https:' + value;
  try { return new URL(value, BASE + '/').href; } catch (_) { return value; }
}

// 从 /play/{vid} 形式的链接或裸 id 提取 vid
function vidOf(id) {
  const s = String(id || '').trim();
  const m = s.match(/\/play\/([\w-]+)/) || s.match(/^\/?([\w-]+)$/);
  return m ? m[1] : s;
}

// 通用卡片解析：home / 分类（div[data-vod-id]）与搜索（div.group.relative）合并处理
function parseCards(html) {
  const out = [];
  const seen = {};
  const blocks = [].concat(
    safeMany(html, 'div[data-vod-id]'),
    safeMany(html, 'div.group.relative')
  );
  for (const block of blocks) {
    const href = pdfh(block, 'a&&href') || '';
    const vid = vidOf(href);
    if (!vid || /^\/?$/.test(vid) || seen[vid]) continue;
    seen[vid] = 1;
    const name = pdfh(block, 'h3&&Text') || pdfh(block, 'a&&title') || pdfh(block, 'img&&alt') || '';
    if (!name) continue;
    const pic = absolute(pdfh(block, 'img&&data-src') || pdfh(block, 'img&&src') || '');
    out.push({
      vod_id: vid,
      vod_name: name.trim(),
      vod_pic: pic,
      vod_remarks: pdfh(block, 'span&&Text') || '',
    });
  }
  return out;
}

function safeMany(html, rule) {
  try { const a = pdfa(html, rule); return Array.isArray(a) ? a : []; } catch (_) { return []; }
}

// 从播放页提取当前会话新鲜 userlink（编码在 navbar 的 x-data 中，含时间成分，必须现取现用）
function extractUserlink(page) {
  const m = String(page).match(/userlink:'([^']+)'/);
  if (!m || !m[1]) throw Error('未取到 userlink（站点结构可能已变）');
  return m[1];
}

export default {
  init() {},
  home() {
    const html = fetchHtml('/');
    return { class: CATS.map((c) => ({ type_id: c.id, type_name: c.name })), list: parseCards(html).slice(0, 60) };
  },
  category(tid, page) {
    const base = tid || CATS[0].id;
    const current = String(page || '1');
    return { list: parseCards(fetchHtml(base + current, BASE + '/')) };
  },
  search(keyword) {
    const q = encodeURIComponent(String(keyword || '').trim());
    if (!q) return { list: [] };
    return { list: parseCards(fetchHtml('/search?q=' + q, BASE + '/')) };
  },
  detail(id) {
    const vid = vidOf(id);
    const page = fetchHtml('/play/' + vid, BASE + '/');
    const rawTitle = (String(page).match(/<title>([^<]+)<\/title>/) || [null, ''])[1];
    const name = rawTitle.split(/\s*[-|]\s*/)[0].trim() || vid;
    const pic = absolute(pdfh(page, 'meta[property=og:image]&&content') || '');
    const blurb = pdfh(page, 'meta[property=og:description]&&content') || pdfh(page, 'meta[name=description]&&content') || '';
    // 剧集三元组：data-line="L" data-episode="E" dataid="D"（仅取第一条线路）
    const eps = [];
    const re = /data-line="(\d+)" data-episode="(\d+)" dataid="(\d+)"/g;
    let m;
    while ((m = re.exec(page))) {
      if (m[1] !== '1') continue;
      const label = '第' + m[2] + '集';
      eps.push({ ep: Number(m[2]) || (eps.length + 1), id: vid + '@' + m[3], label });
    }
    if (!eps.length) throw Error('未找到剧集（可能已下架）');
    // 单集（电影）显示“正片”
    const single = eps.length === 1;
    const url = eps
      .sort((a, b) => a.ep - b.ep)
      .map((e) => (single ? '正片' : e.label) + '$' + e.id)
      .join('#');
    return {
      list: [{
        vod_id: vid,
        vod_name: name,
        vod_pic: pic,
        vod_content: String(blurb).slice(0, 800),
        vod_play_from: '比特兔',
        vod_play_url: url,
      }],
    };
  },
  play(flag, id) {
    const s = String(id || '');
    const at = s.lastIndexOf('@');
    if (at < 0) throw Error('播放参数格式错误：' + s);
    const vid = s.slice(0, at);
    const dataid = s.slice(at + 1);
    // 现取新鲜 userlink（同会话），Rust wasmi 生成签名路径
    const page = fetchHtml('/play/' + vid, BASE + '/play/' + vid);
    const userlink = extractUserlink(page);
    const path = __nbmovieSign(dataid, vid, '1080', userlink);
    if (!path || path[0] !== '/') throw Error('签名失败：' + String(path).slice(0, 40));
    const r = req(BASE + path, { headers: headers({ Referer: BASE + '/play/' + vid }) });
    if (r.code !== 200) throw Error('播放接口返回 ' + r.code);
    let data;
    try { data = JSON.parse(r.content); } catch (_) { throw Error('播放接口返回非 JSON'); }
    const list = (data && data.data && data.data.quality_urls) || [];
    if (!list.length) throw Error('未返回播放地址' + (data && data.message ? '：' + data.message : ''));
    // 取最高码率、未锁定的清晰度
    const ok = list.filter((q) => q && q.url && !q.locked);
    const pool = ok.length ? ok : list.filter((q) => q && q.url);
    if (!pool.length) throw Error('清晰度不可用（可能是 VIP）');
    pool.sort((a, b) => (Number(b.bitrate) || 0) - (Number(a.bitrate) || 0));
    return { parse: 0, url: pool[0].url, header: { 'User-Agent': UA, Referer: BASE + '/' } };
  },
};
