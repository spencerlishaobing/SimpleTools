# TVBox 多仓解析报告

- 入口：`https://github.catvod.com/https://raw.githubusercontent.com/tushen6/Tomorrow/master/lmw.json`
- 仓库：8/16 可解析
- 片源：572
- 类型：guarded-jar 145、jar 388、javascript 13、python 12、standard-api 14

## 仓库

| 名称 | 状态 | 片源 | 格式 | 地址/错误 |
|---|---:|---:|---|---|
| 🤓网络🤓 | ok | 98 | json | https://8815.kstore.vip/tvbox/wmz |
| 👽饭太硬👿 | ok | 49 | image-base64 | https://www.xn--sss604efuw.cc/tv |
| 🐼肥猫🐼 | ok | 40 | json | http://xn--z7x900a.net/tv |
| 🐂王二小🐮 | ok | 99 | json | https://9280.kstore.vip/aiwex.json |
| 🐿️嗷呜🐿️ | ok | 76 | image-base64 | https://file.icve.com.cn/file_doc/52/5/0D10142205D4C759BD9FCA9D1C7F63AB.png |
| 💫潇洒💫 | error | 0 |  | HTTP Error 404:  |
| 🐟摸鱼🐟 | error | 0 |  | HTTP Error 503: Service Unavailable |
| 🤓东篱🤓 | ok | 93 | image-base64 | https://16151.kstore.space |
| 👿小米👿 | error | 0 |  | <urlopen error _ssl.c:1015: The handshake operation timed out> |
| 🔮巧记🔮 | error | 0 |  | HTTP Error 503: Service Unavailable |
| 🐯虎斑🐯 | error | 0 |  | unsupported keyed hex envelope: lintech |
| 🌈欧歌🌈 | error | 0 |  | <urlopen error [SSL: SSLV3_ALERT_HANDSHAKE_FAILURE] sslv3 alert handshake failure (_ssl.c:1032)> |
| 🍎南风🍎 | error | 0 |  | unsupported keyed hex envelope: 347 |
| ⚪PG⚪ | ok | 74 | json | https://www.252035.xyz/p/jsm.json |
| 🌱真心🌱 | ok | 43 | json | https://www.252035.xyz/z/FongMi.json |
| 📚道长📚 | error | 0 |  | HTTP Error 404: Not Found |

## 后续重写顺序

1. `standard-api`：由通用 API 适配器直接接管。
2. `javascript` / `python`：审查后本地化脚本及依赖。
3. `guarded-jar`：按站点逐个重写，不再加载加固 JAR。

## 饭太硬迁移清单

| 名称 | 原接口 | 类型 | 本地适配器 |
|---|---|---|---|
| 豆豆┃片单 <修复漫剧、海绵> | `csp_DouDouGuard` | guarded-jar | 待重写 |
| 🗂我的云盘┃配置 | `csp_MyDriveGuard` | guarded-jar | 待重写 |
| 👽玩偶哥哥┃4K弹幕 | `csp_WoGGGuard` | guarded-jar | cloud-search |
| 🚀荐影┃预告片 | `csp_YGPGuard` | guarded-jar | ygp |
| 🎙️易听┃音乐 | `csp_MusicGuard` | guarded-jar | 待重写 |
| 💡聚剧┃四盘 | `csp_SeedhubGuard` | guarded-jar | cloud-search |
| 🌞光影┃不卡 | `csp_T4Guard` | guarded-jar | 待重写 |
| 👒原创┃不卡 | `csp_YCyzGuard` | guarded-jar | 待重写 |
| 📔厂长┃不卡 | `csp_NewCzGuard` | guarded-jar | newcz |
| 🐬海绵┃不卡 | `csp_HmysGuard` | guarded-jar | 待重写 |
| 🌟立播┃不卡 | `csp_LibvioGuard` | guarded-jar | 待重写 |
| 👀瓜子┃不卡 | `csp_AppgzGuard` | guarded-jar | 待重写 |
| 🍄比特┃不卡 | `csp_BttwooGuard` | guarded-jar | 待重写 |
| 🍓糯米┃秒播 | `csp_NmyswvGuard` | guarded-jar | 待重写 |
| 💮文采┃秒播 | `csp_JpysGuard` | guarded-jar | jpys |
| 🧀奶酪┃秒播 | `csp_T4Guard` | guarded-jar | 待重写 |
| 📺热播┃多线 | `csp_AppTTGuard` | guarded-jar | 待重写 |
| 🌸茉莉┃多线 | `csp_App99Guard` | guarded-jar | 待重写 |
| 🐻剧圈┃多线 | `csp_AppSxGuard` | guarded-jar | 待重写 |
| 🥝荐片┃多线 | `csp_JPJGuard` | guarded-jar | 待重写 |
| 🏝奥特┃多线 | `csp_AueteGuard` | guarded-jar | auete |
| 🧲新6V┃磁力 | `csp_SixVGuard` | guarded-jar | sixv |
| ❤️AI┃短漫剧 | `csp_AiDjGuard` | guarded-jar | 待重写 |
| 🦉咕咕┃动漫 | `csp_AppSxGuard` | guarded-jar | 待重写 |
| 🚌巴士┃动漫 | `csp_Dm84Guard` | guarded-jar | 待重写 |
| ⚽八八┃看球 | `csp_KanqiuGuard` | guarded-jar | 待重写 |
| 🏀多多┃回放 | `csp_DoubaoGuard` | guarded-jar | 待重写 |
| 🏐吃瓜┃看球 | `csp_LiveGzGuard` | guarded-jar | 待重写 |
| 🎮一直播┃直播 | `csp_AllliveGuard` | guarded-jar | 待重写 |
| 🎶明星┃MV | `csp_BiliGuard` | guarded-jar | bili |
| 🎧有声┃小说 | `csp_Tingshu275Guard` | guarded-jar | 待重写 |
| 🚑急救┃教学 | `csp_FirstAidGuard` | guarded-jar | 待重写 |
| 🐯虎牙┃直播 | `https://git.yylx.win/https://raw.githubusercontent.com/fantaiying7/EXT/refs/heads/main/drpy2.min.js` | javascript | quickjs-upstream |
| 🐟斗鱼┃直播 | `https://git.yylx.win/https://raw.githubusercontent.com/fantaiying7/EXT/refs/heads/main/drpy2.min.js` | javascript | quickjs-upstream |
| 🎈盘搜┃四盘 | `csp_S_zpsGuard` | guarded-jar | cloud-search |
| 🦋易搜┃四盘 | `csp_S_zpsGuard` | guarded-jar | cloud-search |
| 🐌盘她┃夸父 | `csp_YpanSoGuard` | guarded-jar | melost-quark |
| 🐞盘他┃嘟嘟 | `csp_BpanSoGuard` | guarded-jar | melost-baidu |
| 🌶️抠抠┃搜搜 | `csp_KkSsGuard` | guarded-jar | cloud-search |
| 🌈优汐┃搜搜 | `csp_UuSsGuard` | guarded-jar | cloud-search |
| 🅱哔哔合集┃弹幕 | `csp_BiliGuard` | guarded-jar | bili |
| 🅱哔哔演唱会┃弹幕 | `csp_BiliGuard` | guarded-jar | bili |
| 📚儿童┃启蒙 | `https://git.yylx.win/https://raw.githubusercontent.com/fantaiying7/EXT/refs/heads/main/drpy2.min.js` | javascript | quickjs-upstream |
| 📚少儿┃教育 | `csp_BiliGuard` | guarded-jar | bili |
| 📚小学┃课堂 | `csp_BiliGuard` | guarded-jar | bili |
| 📚初中┃课堂 | `csp_BiliGuard` | guarded-jar | bili |
| 📚高中┃课堂 | `csp_BiliGuard` | guarded-jar | bili |
| 🛴手机┃推送 | `csp_PushGuard` | guarded-jar | push |
| 请勿信视频中任何广告 | `csp_XPathGuard` | guarded-jar | 待重写 |
