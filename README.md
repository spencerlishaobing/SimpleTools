# SimpleTools

常用工具合集 —— 基于 **Tauri 2 + Rust** 的 Windows 桌面小工具，界面简约、开箱即用。
安装包仅约 1.2 MB，默认白色主题，支持暗黑模式。

## 效果预览

### JSON 格式化（自动去转义）

从日志、代码里复制的被转义字符串（`{\"a\":1}`）可直接粘贴，自动还原并格式化，输入 / 输出均可一键复制。

![JSON 格式化](screenshots/json.png)

### 文本对比（左侧绿色 / 右侧红色）

按行 + 字符级对比，差异处左侧绿色、右侧红色标记，带行号与差异统计。

![文本对比](screenshots/diff.png)

### 记事本（本地缓存 + 拖动排序）

左侧记录列表、右侧标题与正文编辑，自动保存到本地；支持拖动排序、删除弹窗确认、一键复制正文。

![记事本](screenshots/notes.png)

### MD5 计算（字符串 + 文件）

字符串输入实时计算；文件可点击选择或直接从资源管理器拖入（大文件流式计算）；结果支持小写 hex / 大写 HEX / Base64 三种格式。

![MD5 计算](screenshots/md5.png)

### 字符串转换（大小写 + 命名风格）

输入一个字符串，自动生成全大写 / 全小写 / 首字母大写 / 驼峰 / 大驼峰 / 下划线 / 中划线 / 常量共 8 种结果，点击行尾即可复制；自动识别下划线、中划线、空格、点分隔及已有驼峰，多行输入按行转换。

![字符串转换](screenshots/str.png)

### 暗黑模式

侧边栏底部一键切换，选择自动记忆，切换带平滑过渡。

![暗黑模式](screenshots/dark.png)

## 功能支持

- [x] **JSON 格式化** —— 格式化 / 压缩；自动去转义（默认开启、可选）；2 / 4 空格或 Tab 缩进；输入输出一键复制；`Ctrl+Enter` 快捷格式化
- [x] **文本对比** —— 行级 + 字符级差异高亮（左侧绿、右侧红）；忽略首尾空白选项；交换左右 / 清空；`Ctrl+Enter` 快捷对比
- [x] **记事本** —— 左列表右详情；标题 + 正文；本地缓存自动保存（原子写入防损坏）；`Ctrl+N` 新建；列表拖动排序；删除弹窗确认；复制正文；数据备份
- [x] **MD5 计算** —— 字符串实时计算（UTF-8）；文件点击选择或拖入计算（1 MB 分块流式，不占内存）；小写 / 大写 / Base64 三种输出格式；一键复制
- [x] **字符串转换** —— 输入即生成 8 种格式：全大写 / 全小写 / 首字母大写 / 驼峰（camelCase）/ 大驼峰（PascalCase）/ 下划线（snake_case）/ 中划线（kebab-case）/ 常量（CONSTANT_CASE）；自动识别下划线、中划线、空格、点分隔与已有驼峰；多行按行转换；逐行一键复制
- [x] **界面主题** —— 默认简约白色；暗黑模式一键切换并记忆；切换平滑过渡
- [x] **全局体验** —— 无边框简约布局、Toast 轻提示、剪贴板复制三级降级（Tauri 插件 → 浏览器 API → 兜底方案）

> 后续新增功能会持续更新本 README 的功能清单与效果截图（见文末[更新日志](#更新日志)）。

## 构建与运行

```powershell
# 安装前端工具链（仅首次）
npm install

# 开发模式（热重载）
npm run dev

# 构建发布版（免安装 exe + NSIS 安装包）
npm run build
```

构建产物：

- 安装包：`src-tauri/target/release/bundle/nsis/SimpleTools_0.2.0_x64-setup.exe`
- 免安装单文件：`src-tauri/target/release/SimpleTools.exe`

> 首次构建约需几分钟（Rust 编译）；前端为静态资源，修改 `src/` 后需重新执行 `npm run build` 才生效。

## 技术栈

| 层 | 说明 |
| --- | --- |
| 后端 | Rust + Tauri 2（`src-tauri/`） |
| 剪贴板 | 官方 `tauri-plugin-clipboard-manager`（前端带三级降级兜底） |
| 文件选择 | 官方 `tauri-plugin-dialog` |
| MD5 | `md-5` crate（流式读取，1 MB 分块） |
| 前端 | 原生 HTML / CSS / JavaScript（`src/`，无框架、无打包） |
| 数据存储 | `%APPDATA%\com.simpletools.desktop\notes.json`（原子写入） |

## 开发环境

> 仅开发者需要；普通用户下载安装包即可使用。

| 组件 | 位置 / 版本 |
| --- | --- |
| Rust 工具链 | `F:\Rust\rustup`（RUSTUP_HOME）、`F:\Rust\cargo`（CARGO_HOME），rustc 1.99.0 |
| crates 镜像 | `F:\Rust\cargo\config.toml` → rsproxy 国内镜像 |
| VS Build Tools 2022 | `F:\VS\BuildTools`（MSVC v14.44 + Windows 11 SDK 22621） |
| Windows SDK | `F:\Windows Kits\10` |
| Node.js | v24（用于 tauri-cli 与前端脚本） |

## 目录结构

```
SimpleTools/
├── screenshots/          # README 效果截图
├── src/                  # 前端（静态资源，直接作为 frontendDist）
│   ├── index.html
│   ├── styles.css
│   ├── main.js           # 导航 & Toast & 主题切换 & 复制 / 弹窗组件
│   └── modules/
│       ├── json-format.js  # JSON 格式化
│       ├── text-diff.js    # 文本对比（LCS diff）
│       ├── notes.js        # 记事本（拖动排序 + 自动保存）
│       ├── md5.js          # MD5 计算（字符串 + 文件）
│       └── str.js          # 字符串转换（大小写 + 命名风格）
├── src-tauri/            # Rust 后端
│   ├── Cargo.toml
│   ├── tauri.conf.json
│   ├── capabilities/
│   ├── icons/
│   └── src/
│       ├── main.rs
│       ├── lib.rs
│       ├── notes.rs      # 记事本存储命令（load/save/backup）
│       └── md5calc.rs    # MD5 命令（含单元测试）
└── scripts/
    └── gen-icon.ps1      # 重新生成应用图标
```

## 更新日志

### v0.2.0（2026-10-11）

- 新增「字符串转换」工具：大小写转换（全大写 / 全小写 / 首字母大写）、命名风格互转（驼峰 / 大驼峰 / 下划线 / 中划线 / 常量）；自动识别下划线、中划线、空格、点分隔及已有驼峰；多行按行转换，结果一键复制

### v0.1.0（2026-10-11）

首个版本发布：

- JSON 格式化：格式化 / 压缩、自动去转义、缩进选择、一键复制
- 文本对比：行级 + 字符级差异高亮（左绿右红）、差异统计
- 记事本：本地缓存、拖动排序、删除弹窗确认、复制正文、数据备份
- MD5 计算：字符串 + 文件（拖入 / 选择）、三种输出格式、一键复制
- 界面主题：默认白色、暗黑模式切换并记忆
