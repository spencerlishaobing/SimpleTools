# 玩偶（WoGG）本机适配基准

目标是让正式播放链路不依赖饭太硬 JAR 或 Android API。JAR、CFR、JADX 与 `javap` 输出只作为行为证据和新版差异分析材料保留。

## 正式运行链路

| 能力 | 本机实现 | 当前策略 |
|---|---|---|
| 域名 | `src-tauri/resources/tvspiders/wogg.js` | `ext.siteUrl/site` 优先；否则轮询内置候选并拒绝跳转占位页 |
| 首页与分类 | `wogg.js` | 解析真实 HTML，保留电影、剧集、臻彩、短漫剧、动漫、综艺、纪录片、音乐 |
| 筛选 | `wogg.js` | 类型、年代、地区、字母映射为 TVBox filters |
| 搜索 | `wogg.js` | 原站 `/vodsearch/`，返回标准 `vod_*` 字段 |
| 详情 | `wogg.js` | 提取片名、海报、元数据、简介及夸克/UC/百度/阿里分享 |
| 真实选集名 | `tvbox.js` + `cloudrive.rs` | 进入详情即递归展开网盘目录，使用真实文件名代替“打开资源” |
| 封面 | `wogg.js` + `tvbox_image` + `tvbox_poster_search` | 原图代理失败后按片名查找封面并回写卡片/详情对象 |
| 播放 | `cloudrive.rs` + libmpv | 本机解析网盘转码/下载地址，播放器不调用 JAR `playerContent` |
| 登录 | `cloudrive.rs` | 夸克本地生成官方扫码 SVG；登录态保存并推送，页面不依赖 Android Dialog/WebView |

## 证据与回归

- 饭太硬 `csp_WoGGGuard` 的真实调用基准保留在反编译工作区；它用于比较字段和站点行为，不是正式依赖。
- 2026-11-08 真实基准：JAR 首页返回影片 `vod_id=134111`；详情同时给出夸克与百度资源，百度文件名为 `Marrow.2026..1080p.中英字幕.mp4.mp4`。
- 本机适配器必须通过 `bundled_wogg_adapter_keeps_filters_posters_and_cloud_routes`，并在发布前对当前域名执行首页、搜索、详情的联网烟雾测试。
- 域名是易变数据。新版 JAR 如果改变域名获取方式，应把新候选写入配置/适配器，而不是把 JAR 重新放回正式播放链路。

## 新版 JAR 处理

运行：

```powershell
powershell -ExecutionPolicy Bypass -File scripts/snapshot-fantaiying.ps1 -Jar <新JAR路径> -Label upstream
```

每个输入按日期和 SHA-256 建独立目录，不覆盖旧版。对比 `classes.txt`，再重点查看 `WoGG`、`Pan`、`Cloud_*`、`ProxyOrigin` 的 Java、字节码和真实网络响应。

REA 可作为证据收集与调用链分析助手，但不是构建依赖。当前 REA 6.8.0 要求 Node `^22.23.4`、`^24.22.1` 或 `>=26.12.1`；本机 Node 24.11.1 不满足要求，升级 Node 后再注册其 MCP，避免为了单次构建改变系统运行时。
