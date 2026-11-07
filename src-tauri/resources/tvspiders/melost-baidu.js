/** 影盘社百度网盘搜索（BpanSo），结果交给桌面端原生网盘解析。 */
const BASE = 'https://www.melost.cn';
const UA = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 Chrome/124 Safari/537.36';
const FORMATS = ['.mp4', '.mkv', '.flv', '.rmvb', '.wmv', '.mov', '.m3u8', '.avi', '.mpg', '.mpeg'];

function clean(value) { return String(value || '').replace(/<[^>]+>/g, '').replace(/\s+/g, ' ').trim(); }
function searchDisk(keyword, page) {
  const p = Math.max(1, Number(page) || 1);
  const body = { page: p, q: keyword || '', user: '', exact: true, distinct: true, share_time: '', order: 'create_desc', size: 15, type: 'BDY', exclude_user: [], format: FORMATS, adv_params: { wechat_pwd: '', platform: 'pc' } };
  const r = req(BASE + '/v1/search/disk', { method: 'POST', headers: { 'Content-Type': 'application/json', Origin: BASE, Referer: BASE + '/film/' + encodeURIComponent(keyword || ''), 'User-Agent': UA }, body: JSON.stringify(body) });
  if (r.code !== 200) throw Error('影盘社返回 ' + r.code);
  const data = JSON.parse(r.content);
  if (Number(data.code) !== 200) throw Error(data.msg || '影盘社搜索失败');
  return data.data || {};
}
function item(v) { return { vod_id: v.link, vod_name: clean(v.disk_name) || '百度网盘资源', vod_pic: '', vod_remarks: [v.shared_time, v.size ? Math.round(Number(v.size) / 1073741824 * 10) / 10 + ' GB' : ''].filter(Boolean).join(' · '), vod_content: clean(v.files) }; }
function detail(id) { return { list: [{ vod_id: id, vod_name: '百度网盘资源', vod_content: '点击正片后由内置百度网盘解析器读取目录和视频文件。', vod_play_from: '百度网盘', vod_play_url: '打开资源$' + id }] }; }

export default {
  init() {},
  home() { return { class: [], list: [] }; },
  category() { return { page: 1, pagecount: 1, limit: 0, total: 0, list: [] }; },
  search(keyword, page) { const data = searchDisk(keyword, page); const rows = (data.list || []).filter((v) => /^https?:\/\/(pan|yun)\.baidu\.com\/s\//i.test(v.link || '')); return { page: Math.max(1, Number(page) || 1), pagecount: Math.max(1, Math.ceil(Number(data.total || rows.length) / Number(data.per_size || 15))), limit: Number(data.per_size) || 15, total: Number(data.total) || rows.length, list: rows.map(item) }; },
  detail,
  play(flag, id) { return { parse: 1, url: id }; },
};
