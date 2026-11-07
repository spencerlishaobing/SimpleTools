/** 文采影视（Jpys）公开 JSON API 适配器，不依赖 JAR。 */
const BASE = 'https://www.ghw9zwp5.com';
const API = BASE + '/api/mw-movie/anonymous';
const UA = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 Chrome/124 Safari/537.36';
const CATS = [['1', '电影'], ['2', '电视剧'], ['4', '动漫'], ['3', '综艺']];
const AREAS = ['', '中国大陆', '中国香港', '中国台湾', '美国', '日本', '韩国', '泰国', '印度', '其他'];
const YEARS = ['', '2026', '2025', '2024', '2023', '2022', '2021', '2020', '2019', '2018', '2017', '2016', '2015', '2014', '2013', '2012', '2011', '2010'];

function get(path) {
  const r = req(API + path, { headers: { 'User-Agent': UA, Referer: BASE + '/', Origin: BASE } });
  if (r.code !== 200) throw Error('文采影视返回 ' + r.code);
  const data = JSON.parse(r.content);
  if (Number(data.code) !== 200) throw Error(data.msg || '文采影视接口失败');
  return data.data;
}

function image(value) {
  const url = String(value || '').trim();
  if (!url) return '';
  if (url.startsWith('//')) return 'https:' + url;
  try { return new URL(url, BASE + '/').href; } catch (_) { return url; }
}

function item(v) {
  return {
    vod_id: String(v.vodId), vod_name: v.vodName || '', vod_pic: image(v.vodPic),
    vod_remarks: v.vodVersion || v.vodRemarks || (v.vodSerial ? '更新至' + v.vodSerial : ''),
  };
}

function filters() {
  const out = {};
  for (const c of CATS) out[c[0]] = [
    { key: 'area', name: '地区', value: AREAS.map((v) => ({ n: v || '全部', v })) },
    { key: 'year', name: '年份', value: YEARS.map((v) => ({ n: v || '全部', v })) },
  ];
  return out;
}

export default {
  init() {},
  home() {
    const rows = get('/home/hotSearch') || [];
    return { class: CATS.map((c) => ({ type_id: c[0], type_name: c[1] })), filters: filters(), list: rows.map(item) };
  },
  category(tid, page, extend) {
    const p = Math.max(1, Number(page) || 1), f = extend || {};
    const q = '?type1=' + encodeURIComponent(tid || '1') + '&pageNum=' + p +
      '&area=' + encodeURIComponent(f.area || '') + '&year=' + encodeURIComponent(f.year || '');
    const data = get('/video/list' + q) || {};
    const rows = data.list || [];
    return { page: Number(data.pageNum) || p, pagecount: Number(data.totalPage) || p, limit: Number(data.pageSize) || rows.length, total: Number(data.totalCount) || rows.length, list: rows.map(item) };
  },
  search(keyword, page) {
    const p = Math.max(1, Number(page) || 1);
    const data = get('/video/searchByWord?keyword=' + encodeURIComponent(keyword || '') + '&pageNum=' + p + '&pageSize=20') || {};
    const block = data.result || data.typeResult || {}, rows = block.list || [];
    return { page: Number(block.pageNum) || p, pagecount: Number(block.totalPage) || p, total: Number(block.totalCount) || rows.length, limit: Number(block.pageSize) || rows.length, list: rows.map(item) };
  },
  detail(id) {
    const v = get('/video/detail?id=' + encodeURIComponent(id)) || {};
    const episodes = (v.episodeList || []).map((e) => (e.name || '正片') + '$' + v.vodId + '@' + e.nid);
    if (!episodes.length) throw Error('文采影视未返回播放分集');
    return { list: [{
      vod_id: String(v.vodId), vod_name: v.vodName || '', vod_pic: image(v.vodPic),
      type_name: v.typeName || v.vodClass || '', vod_year: v.vodYear || '', vod_area: v.vodArea || '',
      vod_actor: v.vodActor || '', vod_director: v.vodDirector || '', vod_content: v.vodContent || v.vodBlurb || '',
      vod_play_from: '爱电影', vod_play_url: episodes.join('#'),
    }] };
  },
  play(flag, id) {
    const pair = String(id).split('@');
    if (pair.length !== 2) throw Error('文采影视播放参数无效');
    const data = get('/v2/video/episode/url?clientType=3&id=' + encodeURIComponent(pair[0]) + '&nid=' + encodeURIComponent(pair[1])) || {};
    const streams = (data.list || []).filter((x) => /^https?:\/\//i.test(x.url || '')).sort((a, b) => Number(b.resolution || 0) - Number(a.resolution || 0));
    if (!streams.length) throw Error('文采影视未返回播放地址');
    return { parse: 0, url: streams[0].url, header: { Origin: BASE, Referer: BASE + '/', 'User-Agent': UA } };
  },
};
