/** TVBox 手机推送：把用户推送的直链、磁力或网盘分享链接交给内置播放链路。 */
const TYPES = [
  ['push', '推送播放'],
  ['history', '最近推送'],
];

function text(value) {
  return String(value == null ? '' : value).trim();
}

function decode(value) {
  let current = text(value);
  try { current = decodeURIComponent(current); } catch (_) {}
  return current;
}

function extract(value) {
  const raw = decode(value);
  if (!raw) return '';
  // 兼容 TVBox 常见的“名称$地址”、JSON 推送和纯地址。
  try {
    const data = JSON.parse(raw);
    for (const key of ['url', 'link', 'playUrl', 'vod_id']) {
      if (data && data[key]) return text(data[key]);
    }
  } catch (_) {}
  const dollar = raw.lastIndexOf('$');
  if (dollar >= 0 && /^(?:https?|magnet|ed2k|thunder|ftp):/i.test(raw.slice(dollar + 1))) {
    return raw.slice(dollar + 1).trim();
  }
  const match = raw.match(/(?:https?:\/\/|magnet:\?|ed2k:\/\/|thunder:\/\/|ftp:\/\/)[^\s"'<>]+/i);
  return match ? match[0].replace(/[，。；;]+$/, '') : raw;
}

function label(url) {
  if (/pan\.quark\.cn/i.test(url)) return '夸克网盘';
  if (/drive\.uc\.cn/i.test(url)) return 'UC网盘';
  if (/(?:pan|yun)\.baidu\.com/i.test(url)) return '百度网盘';
  if (/(?:alipan|aliyundrive)\.com/i.test(url)) return '阿里云盘';
  if (/^magnet:/i.test(url)) return '磁力资源';
  if (/^ed2k:/i.test(url)) return 'ED2K资源';
  return '推送播放';
}

function item(value) {
  const url = extract(value);
  if (!url) throw Error('推送内容为空');
  const name = label(url);
  return {
    vod_id: url,
    vod_name: name,
    vod_pic: '',
    vod_remarks: /^https?:/i.test(url) ? '已接收' : '下载资源',
    vod_content: url,
    vod_play_from: name,
    vod_play_url: name + '$' + url,
  };
}

export default {
  init() {},
  home() {
    return { class: TYPES.map(v => ({ type_id: v[0], type_name: v[1] })), list: [] };
  },
  category(_tid, page) {
    return { page: Number(page) || 1, pagecount: 1, limit: 0, total: 0, list: [] };
  },
  search(keyword, page) {
    if (Number(page) > 1 || !text(keyword)) return { page: Number(page) || 1, pagecount: 1, list: [] };
    return { page: 1, pagecount: 1, list: [item(keyword)] };
  },
  detail(id) {
    return { list: [item(id)] };
  },
  play(_flag, id) {
    const url = extract(id);
    if (!url) throw Error('推送地址为空');
    return { parse: 0, url };
  },
};
