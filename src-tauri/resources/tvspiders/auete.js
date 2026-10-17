/**
 * 奥特影视（Auete）本地爬虫适配器
 * 站点：https://www.aeete.com（原 auete.cc，站内搜索有安全验证，暂不提供搜索）
 * 结构：首页/分类页 ul.threadlist > li 卡片；详情页多 play-card 线路 + 剧集链接；
 *       播放页内联 var now=base64decode("m3u8 地址")
 */
const BASE = 'https://www.aeete.com';
const UA = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0 Safari/537.36';
const CATS = [
  { id: '/Movie', name: '电影' },
  { id: '/Tv', name: '电视剧' },
  { id: '/Zy', name: '综艺' },
  { id: '/Dm', name: '动漫' },
  { id: '/qita', name: '其他' },
];

function fetchHtml(path) {
  const url = /^https?:/i.test(path) ? path : BASE + path;
  const r = req(url, { headers: { 'User-Agent': UA } });
  if (r.code !== 200) throw Error('站点返回 ' + r.code);
  return r.content;
}

function firstHref(html) {
  const m = html.match(/href="([^"]+)"/);
  return m ? m[1] : '';
}

function parseItems(html) {
  const out = [];
  for (const block of pdfa(html, 'ul.threadlist&&li')) {
    const href = firstHref(block);
    const name = pdfh(block, 'h2&&a&&title') || pdfh(block, 'h2&&a&&Text') || '';
    if (!href || !name) continue;
    out.push({
      vod_id: href,
      vod_name: name,
      vod_pic: pdfh(block, 'img&&src') || pdfh(block, 'img&&data-src') || '',
      vod_remarks: pdfh(block, 'span.hdtag&&Text') || '',
    });
  }
  return out;
}

function textVar(html, name) {
  const m = html.match(new RegExp('var\\s+' + name + "\\s*=\\s*'([^']*)'"));
  return m ? m[1] : '';
}

export default {
  init() {},
  home() {
    const html = fetchHtml('/');
    return { class: CATS.map((c) => ({ type_id: c.id, type_name: c.name })), list: parseItems(html) };
  },
  category(tid, page) {
    const base = tid || '/Movie';
    const current = String(page || '1');
    const path = base + (current === '1' ? '/index.html' : '/index' + current + '.html');
    return { list: parseItems(fetchHtml(path)) };
  },
  search() {
    // 站内搜索 /auete4so.php 有安全验证拦截，直接返回空（不阻塞全源搜索）
    return { list: [] };
  },
  detail(id) {
    const html = fetchHtml(id);
    // 标题：“《团圆必胜》 / 副标题” → 团圆必胜；完全匹配不到时用页面标题
    const raw = textVar(html, 'vod_name') || pdfh(html, 'h1&&Text') || pdfh(html, 'title&&Text') || '';
    const name = (raw.match(/《([^》]+)》/) || [null, raw.split('/')[0].trim()])[1];
    const pic = textVar(html, 'vod_pic') || '';
    const summary = pdfh(html, 'div.message&&Text') || '';
    const from = [];
    const urls = [];
    for (const card of pdfa(html, 'div.play-card')) {
      const raw = pdfh(card, 'div.card-header&&b&&Text') || pdfh(card, 'div.card-header&&Text') || '线路';
      let line = raw.replace(/《[^》]*》/g, '').trim() || '线路';
      const episodes = [];
      for (const item of pdfa(card, 'ul.episode-list&&li')) {
        const href = firstHref(item);
        if (!href) continue;
        const title = pdfh(item, 'a&&title') || pdfh(item, 'a&&Text') || '正片';
        episodes.push(title + '$' + href);
      }
      if (episodes.length) {
        from.push(line);
        urls.push(episodes.join('#'));
      }
    }
    if (!from.length) throw Error('未找到播放线路');
    return {
      list: [{
        vod_id: id,
        vod_name: name,
        vod_pic: pic,
        vod_content: summary.slice(0, 800),
        vod_play_from: from.join('$$$'),
        vod_play_url: urls.join('$$$'),
      }],
    };
  },
  play(flag, id) {
    const html = fetchHtml(id);
    const m = html.match(/var\s+now\s*=\s*base64decode\("([^"]+)"\)/);
    if (!m) throw Error('未找到播放地址（站点结构可能已变化）');
    return { parse: 0, url: base64Decode(m[1]), header: { 'User-Agent': UA } };
  },
};
