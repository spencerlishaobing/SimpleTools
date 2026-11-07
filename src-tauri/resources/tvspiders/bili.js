/** Bilibili local adapter for the csp_Bili/BiliGuard family. */
const API = 'https://api.bilibili.com';
const WEB = 'https://www.bilibili.com';
const UA = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 Chrome/124 Safari/537.36';
let profile = { class: [], filters: {} };

function getJson(url) {
  const response = req(url, { headers: { 'User-Agent': UA, Referer: WEB + '/' } });
  if (response.code !== 200) throw Error('哔哩接口返回 ' + response.code);
  const data = JSON.parse(response.content);
  if (data.code !== undefined && data.code !== 0) throw Error(data.message || ('哔哩接口错误 ' + data.code));
  return data.data === undefined ? data : data.data;
}

function clean(value) {
  return String(value || '')
    .replace(/<[^>]+>/g, '')
    .replace(/&quot;/g, '"').replace(/&#39;/g, "'")
    .replace(/&amp;/g, '&').replace(/&lt;/g, '<').replace(/&gt;/g, '>');
}

function image(value) {
  const url = String(value || '');
  return url.startsWith('//') ? 'https:' + url : url;
}

function duration(value) {
  if (typeof value === 'string') return value;
  const seconds = Number(value || 0);
  const h = Math.floor(seconds / 3600), m = Math.floor(seconds / 60) % 60, s = seconds % 60;
  return (h ? h + ':' + String(m).padStart(2, '0') : String(m)) + ':' + String(s).padStart(2, '0');
}

function searchVideos(keyword, page, filters = {}) {
  const query = new URLSearchParams();
  query.set('search_type', 'video');
  query.set('keyword', keyword);
  query.set('page', String(page || 1));
  const order = filters.order && filters.order !== '0' ? filters.order : 'totalrank';
  query.set('order', order);
  if (filters.duration && filters.duration !== '0') query.set('duration', filters.duration);
  const data = getJson(API + '/x/web-interface/search/type?' + query.toString());
  return {
    page: Number(data.page || page || 1),
    pagecount: Number(data.numPages || 1),
    total: Number(data.numResults || 0),
    limit: Number(data.pagesize || 20),
    list: (data.result || []).map(item => ({
      vod_id: item.bvid || String(item.arcurl || '').split('/video/')[1] || '',
      vod_name: clean(item.title),
      vod_pic: image(item.pic),
      vod_remarks: duration(item.duration),
      vod_content: clean(item.description),
    })).filter(item => item.vod_id),
  };
}

export default {
  init(ext) {
    let options = ext || {};
    if (typeof options === 'string') {
      try { options = JSON.parse(options); } catch (_) { options = { json: options }; }
    }
    if (options.json) {
      try { profile = getJson(String(options.json)); } catch (_) { profile = { class: [], filters: {} }; }
    }
  },
  home() {
    return { class: profile.class || [], filters: profile.filters || {}, list: [] };
  },
  category(tid, page, _filter, filters) {
    const values = filters || {};
    return searchVideos(values.tid || tid, page, values);
  },
  search(keyword, _quick, page) {
    return searchVideos(keyword, page || 1, {});
  },
  detail(id) {
    const bvid = String(id).match(/BV[0-9A-Za-z]+/)?.[0] || String(id);
    const data = getJson(API + '/x/web-interface/view?bvid=' + encodeURIComponent(bvid));
    const pages = data.pages || [{ page: 1, part: data.title || '正片' }];
    const episodes = pages.map((item, index) => {
      const page = Number(item.page || index + 1);
      return clean(item.part || ('第' + page + '集')) + '$' + WEB + '/video/' + bvid + '?p=' + page;
    });
    return { list: [{
      vod_id: bvid,
      vod_name: clean(data.title),
      vod_pic: image(data.pic),
      vod_content: clean(data.desc),
      vod_remarks: duration(data.duration),
      vod_play_from: '哔哩网页',
      vod_play_url: episodes.join('#'),
    }] };
  },
  play(_flag, id) {
    return { parse: 1, url: String(id), header: { 'User-Agent': UA, Referer: WEB + '/' } };
  },
};
