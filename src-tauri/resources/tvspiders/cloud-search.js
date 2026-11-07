/** 内置网盘聚合搜索：用于替代 Pan 派生搜索 JAR，播放统一交给 Rust Pan 兼容层。 */
const BASE = 'https://www.melost.cn';
const UA = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 Chrome/124 Safari/537.36';
const FORMATS = ['.mp4', '.mkv', '.m2ts', '.flv', '.rmvb', '.wmv', '.mov', '.m3u8', '.avi', '.mpg', '.mpeg', '.webm'];
function clean(v) { return String(v || '').replace(/<[^>]+>/g, '').replace(/\s+/g, ' ').trim(); }
function query(keyword, page, type) {
  const body = { page: Math.max(1, Number(page) || 1), q: keyword || '', user: '', exact: true, distinct: true, share_time: '', order: 'create_desc', size: 15, type, exclude_user: [], format: FORMATS, adv_params: { wechat_pwd: '', platform: 'pc' } };
  const r = req(BASE + '/v1/search/disk', { method: 'POST', headers: { 'Content-Type': 'application/json', Origin: BASE, Referer: BASE + '/film/' + encodeURIComponent(keyword || ''), 'User-Agent': UA }, body: JSON.stringify(body) });
  if (r.code !== 200) return { list: [], total: 0 };
  const v = JSON.parse(r.content); return Number(v.code) === 200 ? (v.data || {}) : { list: [], total: 0 };
}
function item(v) {
  const type = /quark/i.test(v.disk_type || v.link || '') ? '夸克' : /baidu|BDY/i.test(v.disk_type || '') || /baidu\.com/i.test(v.link || '') ? '百度' : '网盘';
  return { vod_id: v.link, vod_name: clean(v.disk_name) || type + '资源', vod_pic: '', vod_remarks: type + (v.size ? ' · ' + (Math.round(Number(v.size) / 1073741824 * 10) / 10) + ' GB' : ''), vod_content: clean(v.files) };
}
export default {
  init() {}, home() { return { class: [], list: [] }; },
  category() { return { page: 1, pagecount: 1, limit: 0, total: 0, list: [] }; },
  search(keyword, page) {
    const groups = [query(keyword, page, 'QUARK'), query(keyword, page, 'BDY')];
    const seen = {}, rows = [];
    for (const v of groups[0].list || []) if (v.link && !seen[v.link]) { seen[v.link] = 1; rows.push(item(v)); }
    for (const v of groups[1].list || []) if (v.link && !seen[v.link]) { seen[v.link] = 1; rows.push(item(v)); }
    const p = Math.max(1, Number(page) || 1), total = Number(groups[0].total || 0) + Number(groups[1].total || 0);
    return { page: p, pagecount: Math.max(1, Math.ceil(total / 30)), limit: 30, total, list: rows };
  },
  detail(id) { return { list: [{ vod_id: id, vod_name: '网盘资源', vod_content: '由内置 Pan 兼容层遍历目录并选择视频。', vod_play_from: '内置网盘', vod_play_url: '打开资源$' + id }] }; },
  play(flag, id) { return { parse: 1, url: id }; },
};
