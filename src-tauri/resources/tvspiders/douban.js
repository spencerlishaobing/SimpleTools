/**
 * 豆瓣片单（本地）适配器
 * 数据：movie.douban.com/j/new_search_subjects（分类 + 类型/地区/年份/排序条件搜索）
 *       movie.douban.com/j/subject_suggest（关键词联想搜索）
 * 定位：片单展示源 —— 不提供播放详情（前端点击卡片后会自动跨仓搜索可播源）。
 * 封面为 img*.doubanio.com（桌面端图片代理已兼容防盗链）。
 */
const BASE = 'https://movie.douban.com';
const UA = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0 Safari/537.36';
const CATS = [
  { id: '电影', name: '电影' },
  { id: '电视剧', name: '电视剧' },
  { id: '综艺', name: '综艺' },
  { id: '纪录片', name: '纪录片' },
];
const SORTS = [
  { n: '近期热门', v: 'T' },
  { n: '评分最高', v: 'S' },
  { n: '标记最多', v: 'U' },
];
const GENRES = ['剧情', '喜剧', '动作', '爱情', '科幻', '动画', '悬疑', '惊悚', '恐怖', '犯罪', '同性', '音乐', '歌舞', '历史', '战争', '奇幻', '冒险', '灾难', '武侠', '情色'];
const COUNTRIES = ['中国大陆', '美国', '香港', '台湾', '日本', '韩国', '英国', '法国', '德国', '意大利', '西班牙', '印度', '泰国', '俄罗斯', '加拿大', '澳大利亚', '爱尔兰', '瑞典', '巴西', '丹麦'];
const YEARS = Array.from({ length: 27 }, (_, i) => String(2026 - i));

function fetchJson(url) {
  const r = req(url, { headers: { 'User-Agent': UA, Referer: BASE + '/' } });
  if (r.code !== 200) throw Error('豆瓣返回 ' + r.code);
  try {
    return JSON.parse(r.content);
  } catch (e) {
    throw Error('豆瓣数据解析失败（接口可能有变）');
  }
}

function subjectUrl(tag, start, filters) {
  const f = filters || {};
  let url = BASE + '/j/new_search_subjects?sort=' + encodeURIComponent(f.sort || 'T') + '&range=0,10&tags=' + encodeURIComponent(tag || '电影') + '&start=' + start;
  if (f.genres) url += '&genres=' + encodeURIComponent(f.genres);
  if (f.countries) url += '&countries=' + encodeURIComponent(f.countries);
  if (f.year) url += '&year=' + encodeURIComponent(f.year);
  return url;
}

function parseSubjects(list) {
  if (!Array.isArray(list)) return [];
  return list.map((v) => ({
    vod_id: 'subject:' + v.id,
    vod_name: v.title || '',
    vod_pic: v.cover || '',
    vod_remarks: v.rate ? '豆瓣 ' + v.rate : '',
  }));
}

const filters = {};
for (const c of CATS) {
  filters[c.id] = [
    { key: 'sort', name: '排序', value: SORTS.map((s) => ({ n: s.n, v: s.v })) },
    { key: 'genres', name: '类型', value: GENRES.map((g) => ({ n: g, v: g })) },
    { key: 'countries', name: '地区', value: COUNTRIES.map((g) => ({ n: g, v: g })) },
    { key: 'year', name: '年份', value: YEARS.map((y) => ({ n: y, v: y })) },
  ];
}
// 默认分类（推荐/全部，type_id 为空）与「电影」共用同一套筛选条件
filters[''] = filters['电影'];

export default {
  init() {},
  home() {
    const data = fetchJson(subjectUrl('电影', 0, {}));
    return { class: CATS.map((c) => ({ type_id: c.id, type_name: c.name })), filters, list: parseSubjects(data.data) };
  },
  category(tid, page, filter, extend) {
    const p = Math.max(1, Number(page) || 1);
    const data = fetchJson(subjectUrl(tid || '电影', (p - 1) * 20, extend || {}));
    return { list: parseSubjects(data.data), page: p };
  },
  search(keyword) {
    // 豆瓣联想搜索（关键词）：返回片单列表；点击后前端自动跨仓搜索找可播源
    const word = String(keyword || '').trim();
    if (!word) return { list: [] };
    const data = fetchJson(BASE + '/j/subject_suggest?q=' + encodeURIComponent(word));
    if (!Array.isArray(data)) return { list: [] };
    return {
      list: data.map((v) => ({
        vod_id: 'subject:' + v.id,
        vod_name: v.title || '',
        vod_pic: v.img || '',
        vod_remarks: v.year ? String(v.year) : '',
      })),
    };
  },
  detail() {
    // 片单展示源：不提供播放详情（前端会自动转到跨仓搜索找可播源）
    return { list: [] };
  },
  play() {
    throw Error('豆瓣为片单展示源，不支持直接播放（请点击卡片跨仓搜索）');
  },
};
