# TVBOX 桌面版 · v0.58.1

按 TVBoxOS 的配置与采集约定独立实现 Windows 桌面影音功能，交互采用鼠标和键盘。内嵌开源 libmpv、QuickJS、Python 与 OpenJDK，无需另装播放器、Python、Java 或 Android 环境。兼容影视仓生态的多仓合集与“加密配置”地址：图片 / 文本外壳内的 Base64 配置自动解密；主流 JAR / Python / JS 片源可直接运行（详见「影视仓生态兼容」）。

## 使用

在侧栏打开 TVBOX。界面按 TVBox 交互组织：顶部导航（影视 / 搜索 / 直播 / 收藏 / 历史 / 设置），右上角筛选与切换片源。影视页为标题栏搜索框 + 分类胶囊 + 筛选 + 海报网格（海报角标显示更新集数）；点击影片进入整页详情：海报、信息、线路胶囊、剧集网格与返回。播放控制默认一行（播放 / 进度 / 上下一集 / 全屏），点「更多」展开音量、音轨、字幕、倍速与解析线路；状态栏结果类消息自动淡出。设置页集中管理：配置地址加载（支持多仓，含手机扫码与本地文件导入）、配置仓切换与重命名删除、播放设置、配置编辑与导出、本地与直链播放。配置支持切换、重命名、编辑 JSON 与导出；重新加载相同地址会更新该配置。

支持顶层 `urls` 数组的多仓配置网址。导入后每个仓作为具名配置出现在“配置列表”中，切换时才加载该仓的 `sites` / `lives`；不可用的仓不会阻止其他仓导入。多仓原始网址保留在配置网址输入框中，便于重新加载。单个仓首次加载后保存在应用数据中。加载请求默认使用 OkHttp 客户端标识，与安卓端 TVBox / 影视仓保持一致，避免源站按客户端类型返回不同内容。

点播可选择片源、分类、筛选条件，单源或全源搜索，进入详情后选择线路和剧集。全源搜索最多同时请求四个源，切换页面会停止继续派发旧搜索。收藏支持影片与频道。

直播支持分组、频道名搜索、同频道多线路、台标、M3U 的 tvg-id / group-title / VLC 请求头、TXT 分组列表、内联频道与远程直播列表。支持 XMLTV（含 gzip 文件）与 `epg_data` JSON 节目单，匹配频道 ID / 名称并高亮当前节目。URL 模板支持 `{name}`、`{epg}`、`{date}`。

## 手机扫码配置

设置 → 手机扫码配置，手机与电脑处于同一局域网，扫描相应网卡二维码。手机页面可发送 HTTP(S) 配置网址、粘贴 JSON 或选择 JSON 文件（最大 1 MB），电脑自动导入并加载首页。页面只表示发送成功，配置加载结果显示在电脑端。优先使用原版 9978 端口，占用时自动分配端口；多网卡分别显示二维码。Windows 防火墙需允许应用在当前私人网络接收入站连接。

二维码包含本次会话随机密钥，关闭或重新开启入口后旧码失效。服务默认关闭，不提供远程文件浏览或遥控。手机页面、二维码均本地生成，不依赖第三方二维码服务。

## 播放

- 网络播放启用缓冲与欠载暂停，前向缓存上限 256 MiB、回看缓存 64 MiB，网络超时 20 秒。
- 默认由内置 libmpv 在 SimpleTools 管理的原生播放窗口中渲染视频，没有外部播放器进程。
- 暂停、前后跳转、拖动进度、音量、倍速、画面比例、音轨、字幕切换与本地字幕导入；原生窗口启用 mpv OSC 控件。
- 自动续播、自动下一集、片头片尾跳过可在播放偏好中设置。本地支持多选视频作为播放列表。退出原生播放窗口时记录最终进度，播放中约每五秒保存一次。
- TVBOX 主面板快捷键：Space 暂停、左右箭头前后十秒、F 全屏、N 下一集；输入文字时不触发。
- 支持 HTTP(S)、RTSP、RTMP、UDP / RTP 和本地视频。4K / 8K 使用 `hwdec=auto-safe` 自动尝试硬件解码，亦可切换软件解码；面板显示分辨率、解码器及缓存信息。
- 备选 WebView video 依赖系统编码支持，不能设置自定义请求头。音轨 / 字幕高级操作主要用于 libmpv。

实际 DLL 已通过 3840×2160 与 7680×4320 合成视频的无窗口加载、播放选项和控制测试。这不代表已验证显卡输出、HDR 或真实网络 4K / 8K 片源流畅度；设备、编码、片源和带宽仍决定实际效果。

## 源兼容范围

| 类型 | 当前支持 |
|---|---|
| type=0 | XML 采集接口，class/ty、video、dl/dd，videolist 查询 |
| type=1 | JSON 采集接口，class/list、vod_*、分类/搜索/详情/分页 |
| type=4 | TVBox remote 协议，filter、base64 ext、extend、play/flag |
| type=3，api 为 .js | QuickJS 源码模块，默认导出 Spider 或 `__jsEvalReturn` / `__JS_SPIDER__`，支持相对模块导入与 async 方法 |
| JAR / csp_* | 内置 JVM 反射加载 Spider；普通 `.class` JAR 直接运行，DEX JAR / 原始 DEX 首次转换并缓存 |
| Python `.py` | 内置 CPython 3.13，支持常见 Spider 接口、持久实例与 localProxy |
| 加密配置 | 图片（JPEG / PNG / 常见图片 MIME）或纯文本外壳 + `**` + Base64，内层可再套 GZIP、含 JSONC 注释；按响应内容自动识别解密（饭太硬实测）；十六进制加密变体（`$#lintech#$` / `$#347#$` 等）识别后给出明确提示 |
| QuickJS 专用字节码 | 未实现；需提供源码 JS 或远程接口 |

JS 提供 home / homeVod / category / detail / search / play 调度，`req` / `http` / `fetch` 网络请求、HTML 选择器 `pdfh` / `pdfa` / `pd`、URL 工具、MD5、Base64、随机数、TextEncoder / TextDecoder 与分源 local 存储。HTTP 请求有超时和响应大小限制，运行时限制约 96 MB 内存与 30 秒执行时间，不暴露进程或原生模块接口。不是完整 Android JS 环境：某些脚本的代理、RSA/AES 宿主扩展、计时器、动态模板或字节码仍可能不兼容。

JSON 配置支持 BOM、注释与尾随逗号。远程与本地配置支持相对地址；服务端重定向后的相对地址仍以输入的配置地址为基准。响应支持声明的字符编码和 gzip 内容。

## 内置 Java / Python 片源

配置仍使用原版字段：全局 `spider` 或单源 `jar` 提供 JAR 地址，`api: "csp_类名"` 指定 Spider 类；`api` 为 `.py` 地址时进入 Python 适配器。相对路径按配置地址解析，JAR 支持 `;md5;校验值`。不需要 Android SDK、模拟器或 ADB。

- 普通 JAR 通过 URLClassLoader 按类名创建 Spider；DEX 使用随包的 dex2jar 2.4 转换为 JVM 字节码，再执行相同接口。转换按内容与配置身份缓存，并自动修补 dex2jar 的已知类文件缺陷（字段 ConstantValue 类型不匹配导致的 ClassFormatError，如 ``HashMap`` 字段携带 String 常量）。
- ftyguard（神の蝶）加壳的 JAR 会在桌面端自动离线解包：guard 载荷是整文件字节值映射（字节值 ∈ {1,2,5,6} 时异或 7，通过 ftyguard_v8.so 仿真逐字节比对与 CRC 全量校验确认），还原出标准 JAR（classes.dex + META-INF）后再走 dex2jar 转换。个别 dex2jar 产物缺少 StackMapTable（复杂 switch 分支），以禁用字节码验证的方式加载（-Xverify:none），方法体实测可执行。兼容层为此补齐 View / WebView / AlertDialog / ListView / SQLiteDatabase 等常用 UI 与数据库桩类，并初始化外置片源自带的 InitOrigin 上下文；实测饭太硬加壳源（AiDj、Pan 等）可完成加载与 home 调用。
- Java / Python 均覆盖 home、category、detail、search、play，以及本地媒体代理。源实例会复用，停止运行时后自动重建。Java 代理返回的 HLS 中常见 localhost:9978 代理地址会重写到当前会话。
- Java 兼容层实现 Context 文件目录、SharedPreferences、PackageManager/签名与应用信息、网络状态、Bundle、Base64、TextUtils、Uri、Log、Handler / Looper 等常用接口，并提供 JSON、OkHttp、Jsoup、Gson。部分 TVBox 生态片源（如饭太硬同系列的 csp_* 源）会用应用签名 / 包名 / 应用名做来源校验：兼容层内置影视仓 6.2.8 的公开签名证书（APK 内公开分发的证书）并使用主流客户端包名，使这类片源可在桌面端运行；校验不通过时片源自身的提示（如“接口暂时没有适配此app”）也可正常显示。它不是完整 Android 平台：依赖 WebView、Android Service、JNI `.so`、Android Keystore 或其他未实现 API 的 JAR 仍会报具体缺失类 / 方法；DEX 转换也可能遇到不支持的字节码。当前验证使用自建接口测试片源与真实 csp_* 片源，不能等同于所有第三方 JAR 均兼容。
- Python 包含 requests、lxml、pycryptodome、beautifulsoup4、pyquery、jsonpath、ujson、cachetools。提供 `base.spider.Spider` 常用工具；依赖额外模块、多源依赖注入或 Android 的 Python 桥接接口的脚本仍可能需要适配。
- 运行时在应用私有子进程中按需启动，接口只绑定本机并验证会话密钥。超时会重置运行时；Windows Job Object 在应用退出时清理子进程和 DEX 转换进程。设置中“停止片源兼容后台”可立即释放资源。
- Python / Java 片源属于可执行代码，拥有当前用户权限，并非安全沙箱；只导入可信片源。已启用配置会在首页恢复时执行。
- `tvbox-java` / `tvbox-python` 是当前数据目录下的运行缓存，不纳入配置备份，清除后可重建。片源自行写入缓存目录的登录信息不随配置备份迁移。

开发构建需要 Python 3.13 和 JDK（含 javac）；安装后的使用不需要系统 Python 或 Java。`scripts/prepare-tvbox-all.ps1` 准备运行时，JRE 与 dex2jar 下载固定版本并验证 SHA256；来源与依赖锁定记录在 `runtime/java`。JRE 的许可证随完整运行时保留，dex2jar 的许可证随转换组件提供。

## 解析

type=1 JSON 解析器支持前缀地址或 `{url}` 占位符，读取解析返回直链和请求头。源播放接口可返回 User-Agent、Referer、Cookie 等请求头；换片会清空上一片源请求头。

type=0 网页解析器与手动“网页解析”使用独立 WebView，捕获常见媒体资源 URL、video/src、fetch/XHR 与 iframe 转发结果。识别结果由用户选择，避免误选广告。此窗口不能调用本地应用命令，弹出新窗口被禁止。加密 DRM、blob-only 播放、WebView 检测、验证码与复杂反爬不保证兼容。

JAR 片源调用 `SpiderApi.webParse(url, flag)` 时会得到与原项目相同格式的 `proxy://go=SuperParse` 地址。TVBOX 播放层解码该地址，按 `flag` 优先选取配置中的 type=0 网页解析器，打开独立网页嗅探窗口；没有匹配标识时使用可用的网页解析器，没有配置时直接嗅探原页面。可在解析方式中手动选择其他解析器后重试。这里实现的是对应的桌面解析行为，不运行 Android 的本地 `SuperParse` HTTP 代理。

## 数据与备份

- `tvbox.json`：配置列表、收藏、最近 100 条观看记录与进度、播放偏好。
- `tvbox-script-local.json`：分源隔离的 JS local 键值存储。
- 两者位于当前应用数据目录，参与位置迁移、ZIP / 文件夹备份、覆盖导入与恢复。
- 合并导入会保留当前播放偏好、合并收藏和记录；同 ID 的不同配置自动分开，并重映射记录引用。脚本存储同键保留当前值。
- 旧版 localStorage TVBOX 数据在首次读取时迁入文件。收藏 / 历史中没有配置来源的旧记录按原地址直接播放。

## 磁力、种子与迅雷链接

TVBOX 内置 aria2 1.37.0 Windows 版作为独立的 BitTorrent 下载进程。磁力链接和 `.torrent` 地址会下载到应用缓存，完成后自动选择最大的常见视频文件交给 libmpv 播放。新播放请求会取消前一个下载任务。下载期间需要保留足够磁盘空间；当前是下载完成后播放，不支持边下边播或种子内文件选择。

`thunder://` 链接会先按迅雷常见的 `AA…ZZ` Base64 格式解出 HTTP(S) / FTP 地址，再交给播放器。`tvbox-xg:` 等依赖原项目私有 P2P 协议的链接尚不能播放。aria2 来源、校验值及许可证见 `src-tauri/resources/aria2/provenance.json` 和同目录的 `COPYING`。

## 尚未覆盖

专用 JS 字节码、DLNA 投屏、私有 P2P 协议、弹幕、DoH/Hosts 规则、十六进制加密配置（`$#lintech#$` 等变体，会给出明确提示）、其他加固方案（360 加固、DexHelper、libshell 等，解密依赖 ARM 运行库，会给出明确提示）、依赖 WebView 交互 / JNI 的原生能力、完整 Android 爬虫宿主接口和 DRM。当前实现未复制 TVBoxOS 的 Java 源码或媒体资源。

## 内核与构建

固定使用 `mpv v0.41.0-1186-ga2cd83c56` Windows x86_64 构建：

- [Windows 构建仓库](https://github.com/shinchiro/mpv-winbuild-cmake/tree/20261016)
- [对应 mpv 源码](https://github.com/mpv-player/mpv/tree/a2cd83c56d)
- 原始下载地址与压缩包 / DLL SHA256：`src-tauri/resources/mpv/provenance.json`。
- `scripts/prepare-tvbox.ps1` 在开发和打包前准备固定资源并验证哈希。DLL 不提交 Git；安装包携带 DLL、来源与许可证。首次构建需联网。
- DLL 未压缩约 121 MB，原工具版的小安装包大小说明不再适用。复制免安装 exe 时须同时携带完整 `resources` 目录。
- mpv 许可证随包提供：`resources/mpv/Copyright.txt` / `COPYING.txt`。正式分发需要保留内核和依赖的对应可重建源码、构建说明，并遵守实际构建的许可证。

## 验证

```powershell
node --test tests/tvbox*.test.cjs
node tests/uia-tvbox-e2e.js
python tests/libmpv-smoke.py
python tests/tvbox-runtimes.py
cd src-tauri
cargo test --offline --lib
cargo test --offline --lib windows_job_terminates_packaged_worker -- --ignored
```

协议和 DOM 流程使用本地模拟接口测试，QuickJS 测试执行真实脚本并请求本地 HTTP 服务。`tests/uia-tvbox-e2e.js` 通过 WebView2 CDP 连接运行中的应用（需以 `WEBVIEW2_ADDITIONAL_BROWSER_ARGUMENTS=--remote-debugging-port=9222` 启动），验证面板结构、加密配置解密、多仓导入、加壳提示与截图。桌面自动操作工具拒绝访问 SimpleTools，尚未完成原生窗口视觉和点击验收。
