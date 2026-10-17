/**
 * 豆瓣片单（本地）适配器 v2
 * 分类（class）与筛选（filters）与 Android 端豆瓣源（csp_Douban）的配置保持一致；
 * 数据来源：m.douban.com rexxar 集合（热门/榜单）与 movie.douban.com 条件搜索（筛选）。
 * 定位：片单展示源 —— 不提供播放详情（前端点击卡片后自动跨仓搜索可播源）。
 */
const UA = 'Mozilla/5.0 (iPhone; CPU iPhone OS 16_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148';
const REFERER = 'https://m.douban.com/';
const SEARCH_BASE = 'https://movie.douban.com';
// 与 Android 端豆瓣源一致的分类与筛选定义
const SCHEMA = {
 "class": [
  {
   "type_id": "hot_gaia",
   "type_name": "热门电影"
  },
  {
   "type_id": "tv_hot",
   "type_name": "热播剧集"
  },
  {
   "type_id": "anime_hot",
   "type_name": "热门动漫"
  },
  {
   "type_id": "show_hot",
   "type_name": "热播综艺"
  },
  {
   "type_id": "movie",
   "type_name": "电影筛选"
  },
  {
   "type_id": "tv",
   "type_name": "电视筛选"
  },
  {
   "type_id": "rank_list_movie",
   "type_name": "电影榜单"
  },
  {
   "type_id": "rank_list_tv",
   "type_name": "电视剧榜单"
  }
 ],
 "filters": {
  "anime_hot": [
   {
    "key": "类型",
    "name": "类型",
    "value": [
     {
      "n": "全部",
      "v": ""
     },
     {
      "n": "热血",
      "v": "热血"
     },
     {
      "n": "搞笑",
      "v": "搞笑"
     },
     {
      "n": "恋爱",
      "v": "恋爱"
     },
     {
      "n": "校园",
      "v": "校园"
     },
     {
      "n": "科幻",
      "v": "科幻"
     },
     {
      "n": "奇幻",
      "v": "奇幻"
     },
     {
      "n": "悬疑",
      "v": "悬疑"
     },
     {
      "n": "治愈",
      "v": "治愈"
     },
     {
      "n": "运动",
      "v": "运动"
     },
     {
      "n": "机甲",
      "v": "机甲"
     },
     {
      "n": "少女",
      "v": "少女"
     },
     {
      "n": "少年",
      "v": "少年"
     }
    ]
   },
   {
    "key": "地区",
    "name": "地区",
    "value": [
     {
      "n": "全部",
      "v": ""
     },
     {
      "n": "日本",
      "v": "日本"
     },
     {
      "n": "中国大陆",
      "v": "中国大陆"
     },
     {
      "n": "美国",
      "v": "美国"
     },
     {
      "n": "韩国",
      "v": "韩国"
     },
     {
      "n": "英国",
      "v": "英国"
     },
     {
      "n": "法国",
      "v": "法国"
     }
    ]
   },
   {
    "key": "sort",
    "name": "排序",
    "value": [
     {
      "n": "近期热度",
      "v": "T"
     },
     {
      "n": "首播时间",
      "v": "R"
     },
     {
      "n": "高分优先",
      "v": "S"
     }
    ]
   },
   {
    "key": "年代",
    "name": "年代",
    "value": [
     {
      "n": "全部",
      "v": ""
     },
     {
      "n": "2026",
      "v": "2026"
     },
     {
      "n": "2025",
      "v": "2025"
     },
     {
      "n": "2024",
      "v": "2024"
     },
     {
      "n": "2023",
      "v": "2023"
     },
     {
      "n": "2022",
      "v": "2022"
     },
     {
      "n": "2021",
      "v": "2021"
     },
     {
      "n": "2020",
      "v": "2020"
     },
     {
      "n": "2019",
      "v": "2019"
     },
     {
      "n": "2010年代",
      "v": "2010年代"
     },
     {
      "n": "2000年代",
      "v": "2000年代"
     },
     {
      "n": "90年代",
      "v": "90年代"
     },
     {
      "n": "更早",
      "v": "更早"
     }
    ]
   }
  ],
  "hot_gaia": [
   {
    "key": "sort",
    "name": "排序",
    "value": [
     {
      "n": "热度",
      "v": "recommend"
     },
     {
      "n": "最新",
      "v": "time"
     },
     {
      "n": "评分",
      "v": "rank"
     }
    ]
   },
   {
    "key": "area",
    "name": "地区",
    "value": [
     {
      "n": "全部",
      "v": "全部"
     },
     {
      "n": "华语",
      "v": "华语"
     },
     {
      "n": "欧美",
      "v": "欧美"
     },
     {
      "n": "韩国",
      "v": "韩国"
     },
     {
      "n": "日本",
      "v": "日本"
     }
    ]
   }
  ],
  "movie": [
   {
    "key": "类型",
    "name": "类型",
    "value": [
     {
      "n": "全部类型",
      "v": ""
     },
     {
      "n": "喜剧",
      "v": "喜剧"
     },
     {
      "n": "爱情",
      "v": "爱情"
     },
     {
      "n": "动作",
      "v": "动作"
     },
     {
      "n": "科幻",
      "v": "科幻"
     },
     {
      "n": "动画",
      "v": "动画"
     },
     {
      "n": "悬疑",
      "v": "悬疑"
     },
     {
      "n": "犯罪",
      "v": "犯罪"
     },
     {
      "n": "惊悚",
      "v": "惊悚"
     },
     {
      "n": "冒险",
      "v": "冒险"
     },
     {
      "n": "音乐",
      "v": "音乐"
     },
     {
      "n": "历史",
      "v": "历史"
     },
     {
      "n": "奇幻",
      "v": "奇幻"
     },
     {
      "n": "恐怖",
      "v": "恐怖"
     },
     {
      "n": "战争",
      "v": "战争"
     },
     {
      "n": "传记",
      "v": "传记"
     },
     {
      "n": "歌舞",
      "v": "歌舞"
     },
     {
      "n": "武侠",
      "v": "武侠"
     },
     {
      "n": "情色",
      "v": "情色"
     },
     {
      "n": "灾难",
      "v": "灾难"
     },
     {
      "n": "西部",
      "v": "西部"
     },
     {
      "n": "纪录片",
      "v": "纪录片"
     },
     {
      "n": "短片",
      "v": "短片"
     }
    ]
   },
   {
    "key": "地区",
    "name": "地区",
    "value": [
     {
      "n": "全部地区",
      "v": ""
     },
     {
      "n": "华语",
      "v": "华语"
     },
     {
      "n": "欧美",
      "v": "欧美"
     },
     {
      "n": "中国",
      "v": "中国"
     },
     {
      "n": "美国",
      "v": "美国"
     },
     {
      "n": "中国香港",
      "v": "中国香港"
     },
     {
      "n": "中国台湾",
      "v": "中国台湾"
     },
     {
      "n": "韩国",
      "v": "韩国"
     },
     {
      "n": "日本",
      "v": "日本"
     },
     {
      "n": "英国",
      "v": "英国"
     },
     {
      "n": "法国",
      "v": "法国"
     },
     {
      "n": "菲律宾",
      "v": "菲律宾"
     },
     {
      "n": "德国",
      "v": "德国"
     },
     {
      "n": "意大利",
      "v": "意大利"
     },
     {
      "n": "西班牙",
      "v": "西班牙"
     },
     {
      "n": "印度",
      "v": "印度"
     },
     {
      "n": "泰国",
      "v": "泰国"
     },
     {
      "n": "俄罗斯",
      "v": "俄罗斯"
     },
     {
      "n": "加拿大",
      "v": "加拿大"
     },
     {
      "n": "澳大利亚",
      "v": "澳大利亚"
     },
     {
      "n": "爱尔兰",
      "v": "爱尔兰"
     },
     {
      "n": "瑞典",
      "v": "瑞典"
     },
     {
      "n": "巴西",
      "v": "巴西"
     },
     {
      "n": "丹麦",
      "v": "丹麦"
     }
    ]
   },
   {
    "key": "sort",
    "name": "排序",
    "value": [
     {
      "n": "近期热度",
      "v": "T"
     },
     {
      "n": "首映时间",
      "v": "R"
     },
     {
      "n": "高分优先",
      "v": "S"
     }
    ]
   },
   {
    "key": "年代",
    "name": "年代",
    "value": [
     {
      "n": "全部年代",
      "v": ""
     },
     {
      "n": "2026",
      "v": "2026"
     },
     {
      "n": "2025",
      "v": "2025"
     },
     {
      "n": "2024",
      "v": "2024"
     },
     {
      "n": "2023",
      "v": "2023"
     },
     {
      "n": "2022",
      "v": "2022"
     },
     {
      "n": "2021",
      "v": "2021"
     },
     {
      "n": "2020",
      "v": "2020"
     },
     {
      "n": "2019",
      "v": "2019"
     },
     {
      "n": "2010年代",
      "v": "2010年代"
     },
     {
      "n": "2000年代",
      "v": "2000年代"
     },
     {
      "n": "90年代",
      "v": "90年代"
     },
     {
      "n": "80年代",
      "v": "80年代"
     },
     {
      "n": "70年代",
      "v": "70年代"
     },
     {
      "n": "60年代",
      "v": "60年代"
     },
     {
      "n": "更早",
      "v": "更早"
     }
    ]
   }
  ],
  "rank_list_movie": [
   {
    "key": "榜单",
    "name": "榜单",
    "value": [
     {
      "n": "实时热门电影",
      "v": "movie_real_time_hotest"
     },
     {
      "n": "一周口碑电影榜",
      "v": "movie_weekly_best"
     },
     {
      "n": "豆瓣电影Top250",
      "v": "movie_top250"
     }
    ]
   }
  ],
  "rank_list_tv": [
   {
    "key": "榜单",
    "name": "榜单",
    "value": [
     {
      "n": "实时热门电视",
      "v": "tv_real_time_hotest"
     },
     {
      "n": "华语口碑剧集榜",
      "v": "tv_chinese_best_weekly"
     },
     {
      "n": "全球口碑剧集榜",
      "v": "tv_global_best_weekly"
     },
     {
      "n": "国内口碑综艺榜",
      "v": "show_chinese_best_weekly"
     },
     {
      "n": "国外口碑综艺榜",
      "v": "show_global_best_weekly"
     }
    ]
   }
  ],
  "show_hot": [
   {
    "key": "type",
    "name": "分类",
    "value": [
     {
      "n": "综合",
      "v": "show_hot"
     },
     {
      "n": "国内",
      "v": "show_domestic"
     },
     {
      "n": "国外",
      "v": "show_foreign"
     }
    ]
   }
  ],
  "tv": [
   {
    "key": "类型",
    "name": "类型",
    "value": [
     {
      "n": "不限",
      "v": ""
     },
     {
      "n": "电视剧",
      "v": "电视剧"
     },
     {
      "n": "综艺",
      "v": "综艺"
     }
    ]
   },
   {
    "key": "电视剧形式",
    "name": "电视剧形式",
    "value": [
     {
      "n": "不限",
      "v": ""
     },
     {
      "n": "喜剧",
      "v": "喜剧"
     },
     {
      "n": "爱情",
      "v": "爱情"
     },
     {
      "n": "悬疑",
      "v": "悬疑"
     },
     {
      "n": "动画",
      "v": "动画"
     },
     {
      "n": "武侠",
      "v": "武侠"
     },
     {
      "n": "古装",
      "v": "古装"
     },
     {
      "n": "家庭",
      "v": "家庭"
     },
     {
      "n": "犯罪",
      "v": "犯罪"
     },
     {
      "n": "科幻",
      "v": "科幻"
     },
     {
      "n": "恐怖",
      "v": "恐怖"
     },
     {
      "n": "历史",
      "v": "历史"
     },
     {
      "n": "战争",
      "v": "战争"
     },
     {
      "n": "动作",
      "v": "动作"
     },
     {
      "n": "冒险",
      "v": "冒险"
     },
     {
      "n": "传记",
      "v": "传记"
     },
     {
      "n": "剧情",
      "v": "剧情"
     },
     {
      "n": "奇幻",
      "v": "奇幻"
     },
     {
      "n": "惊悚",
      "v": "惊悚"
     },
     {
      "n": "灾难",
      "v": "灾难"
     },
     {
      "n": "歌舞",
      "v": "歌舞"
     },
     {
      "n": "音乐",
      "v": "音乐"
     }
    ]
   },
   {
    "key": "综艺形式",
    "name": "综艺形式",
    "value": [
     {
      "n": "不限",
      "v": ""
     },
     {
      "n": "真人秀",
      "v": "真人秀"
     },
     {
      "n": "脱口秀",
      "v": "脱口秀"
     },
     {
      "n": "音乐",
      "v": "音乐"
     },
     {
      "n": "歌舞",
      "v": "歌舞"
     }
    ]
   },
   {
    "key": "地区",
    "name": "地区",
    "value": [
     {
      "n": "全部地区",
      "v": ""
     },
     {
      "n": "华语",
      "v": "华语"
     },
     {
      "n": "欧美",
      "v": "欧美"
     },
     {
      "n": "中国",
      "v": "中国"
     },
     {
      "n": "美国",
      "v": "美国"
     },
     {
      "n": "中国香港",
      "v": "中国香港"
     },
     {
      "n": "韩国",
      "v": "韩国"
     },
     {
      "n": "日本",
      "v": "日本"
     },
     {
      "n": "英国",
      "v": "英国"
     },
     {
      "n": "泰国",
      "v": "泰国"
     },
     {
      "n": "中国台湾",
      "v": "中国台湾"
     },
     {
      "n": "意大利",
      "v": "意大利"
     },
     {
      "n": "法国",
      "v": "法国"
     },
     {
      "n": "德国",
      "v": "德国"
     },
     {
      "n": "西班牙",
      "v": "西班牙"
     },
     {
      "n": "俄罗斯",
      "v": "俄罗斯"
     },
     {
      "n": "瑞典",
      "v": "瑞典"
     },
     {
      "n": "巴西",
      "v": "巴西"
     },
     {
      "n": "丹麦",
      "v": "丹麦"
     },
     {
      "n": "印度",
      "v": "印度"
     },
     {
      "n": "加拿大",
      "v": "加拿大"
     },
     {
      "n": "爱尔兰",
      "v": "爱尔兰"
     },
     {
      "n": "澳大利亚",
      "v": "澳大利亚"
     }
    ]
   },
   {
    "key": "sort",
    "name": "排序",
    "value": [
     {
      "n": "近期热度",
      "v": "T"
     },
     {
      "n": "首播时间",
      "v": "R"
     },
     {
      "n": "高分优先",
      "v": "S"
     }
    ]
   },
   {
    "key": "年代",
    "name": "年代",
    "value": [
     {
      "n": "全部",
      "v": ""
     },
     {
      "n": "2026",
      "v": "2026"
     },
     {
      "n": "2025",
      "v": "2025"
     },
     {
      "n": "2024",
      "v": "2024"
     },
     {
      "n": "2023",
      "v": "2023"
     },
     {
      "n": "2022",
      "v": "2022"
     },
     {
      "n": "2021",
      "v": "2021"
     },
     {
      "n": "2020",
      "v": "2020"
     },
     {
      "n": "2019",
      "v": "2019"
     },
     {
      "n": "2010年代",
      "v": "2010年代"
     },
     {
      "n": "2000年代",
      "v": "2000年代"
     },
     {
      "n": "90年代",
      "v": "90年代"
     },
     {
      "n": "80年代",
      "v": "80年代"
     },
     {
      "n": "70年代",
      "v": "70年代"
     },
     {
      "n": "60年代",
      "v": "60年代"
     },
     {
      "n": "更早",
      "v": "更早"
     }
    ]
   },
   {
    "key": "平台",
    "name": "平台",
    "value": [
     {
      "n": "全部",
      "v": ""
     },
     {
      "n": "腾讯视频",
      "v": "腾讯视频"
     },
     {
      "n": "爱奇艺",
      "v": "爱奇艺"
     },
     {
      "n": "优酷",
      "v": "优酷"
     },
     {
      "n": "湖南卫视",
      "v": "湖南卫视"
     },
     {
      "n": "Netflix",
      "v": "Netflix"
     },
     {
      "n": "HBO",
      "v": "HBO"
     },
     {
      "n": "BBC",
      "v": "BBC"
     },
     {
      "n": "NHK",
      "v": "NHK"
     },
     {
      "n": "CBS",
      "v": "CBS"
     },
     {
      "n": "NBC",
      "v": "NBC"
     },
     {
      "n": "tvN",
      "v": "tvN"
     }
    ]
   }
  ],
  "tv_hot": [
   {
    "key": "type",
    "name": "分类",
    "value": [
     {
      "n": "综合",
      "v": "tv_hot"
     },
     {
      "n": "国产剧",
      "v": "tv_domestic"
     },
     {
      "n": "欧美剧",
      "v": "tv_american"
     },
     {
      "n": "日剧",
      "v": "tv_japanese"
     },
     {
      "n": "韩剧",
      "v": "tv_korean"
     },
     {
      "n": "动画",
      "v": "tv_animation"
     }
    ]
   }
  ]
 }
};

function fetchJson(url, referer) {
  const r = req(url, { headers: { 'User-Agent': UA, Referer: referer || REFERER } });
  if (r.code !== 200) throw Error('豆瓣返回 ' + r.code);
  try {
    return JSON.parse(r.content);
  } catch (e) {
    throw Error('豆瓣数据解析失败（接口可能有变）');
  }
}

function fromCollection(items) {
  return (items || []).map((v) => ({
    vod_id: 'subject:' + v.id,
    vod_name: v.title || '',
    vod_pic: (v.pic && (v.pic.normal || v.pic.large)) || (v.cover && v.cover.url) || '',
    vod_remarks: v.rating && v.rating.value ? '豆瓣 ' + v.rating.value : '',
  }));
}

function collection(id, start, count) {
  const data = fetchJson('https://m.douban.com/rexxar/api/v2/subject_collection/' + encodeURIComponent(id) + '/items?start=' + start + '&count=' + (count || 20));
  return fromCollection(data.subject_collection_items);
}

const SORT_MAP = { recommend: 'T', time: 'R', rank: 'S' };

function pick(extend, keys) {
  for (const key of keys) {
    const value = extend[key];
    if (value !== undefined && value !== null && String(value) !== '' && String(value) !== '全部' && String(value) !== '不限' && !/^全部/.test(String(value))) return String(value);
  }
  return '';
}

function searchSubjects(tag, start, extend) {
  const f = extend || {};
  const rawSort = pick(f, ['sort', '排序']) || 'T';
  const sort = SORT_MAP[rawSort] || rawSort;
  let url = SEARCH_BASE + '/j/new_search_subjects?sort=' + encodeURIComponent(sort) + '&range=0,10&tags=' + encodeURIComponent(tag) + '&start=' + start;
  const genres = pick(f, ['类型', 'genres', '电视剧形式', '综艺形式']);
  const countries = pick(f, ['地区', 'countries', 'area']);
  const year = pick(f, ['年代', 'year']);
  if (genres) url += '&genres=' + encodeURIComponent(genres);
  if (countries) url += '&countries=' + encodeURIComponent(countries);
  if (year) url += '&year=' + encodeURIComponent(year);
  const data = fetchJson(url, SEARCH_BASE + '/');
  return (data.data || []).map((v) => ({
    vod_id: 'subject:' + v.id,
    vod_name: v.title || '',
    vod_pic: v.cover || '',
    vod_remarks: v.rate ? '豆瓣 ' + v.rate : '',
  }));
}

export default {
  init() {},
  home() {
    return { class: SCHEMA.class, filters: SCHEMA.filters, list: collection('movie_hot_gaia', 0, 20) };
  },
  category(tid, page, filter, extend) {
    const p = Math.max(1, Number(page) || 1);
    const start = (p - 1) * 20;
    const f = extend || {};
    const t = tid || 'hot_gaia'; // 空分类（推荐/全部）等同于热门电影
    let list = [];
    if (t === 'movie') {
      list = searchSubjects('电影', start, f);
    } else if (t === 'tv') {
      list = searchSubjects(pick(f, ['类型']) || '电视剧', start, f);
    } else if (t === 'hot_gaia') {
      list = (pick(f, ['排序']) || pick(f, ['地区'])) ? searchSubjects('电影', start, f) : collection('movie_hot_gaia', start, 20);
    } else if (t === 'anime_hot') {
      list = (pick(f, ['类型']) || pick(f, ['地区']) || pick(f, ['年代']) || pick(f, ['排序'])) ? searchSubjects('动画', start, f) : collection('anime_hot', start, 20);
    } else if (t === 'tv_hot') {
      list = collection(pick(f, ['分类']) || 'tv_hot', start, 20);
    } else if (t === 'show_hot') {
      list = collection(pick(f, ['分类']) || 'show_hot', start, 20);
    } else if (t === 'rank_list_movie') {
      list = collection(pick(f, ['榜单']) || 'movie_real_time_hotest', start, 20);
    } else if (t === 'rank_list_tv') {
      list = collection(pick(f, ['榜单']) || 'tv_real_time_hotest', start, 20);
    }
    return { list, page: p };
  },
  search(keyword) {
    const word = String(keyword || '').trim();
    if (!word) return { list: [] };
    const data = fetchJson(SEARCH_BASE + '/j/subject_suggest?q=' + encodeURIComponent(word), SEARCH_BASE + '/');
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
    return { list: [] };
  },
  play() {
    throw Error('豆瓣为片单展示源，不支持直接播放（请点击卡片跨仓搜索）');
  },
};
