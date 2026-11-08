# SimpleTools

SimpleTools 是一款基于 Tauri 2 + Rust 的 Windows 桌面工具箱，安装体积小，数据默认保存在本机。

## 功能介绍

- 记事本：普通笔记、Markdown 笔记、任务笔记、全文搜索、图片和备份。
- 账号密码：本地分组管理、DPAPI 加密、Windows Hello 验证和批量导出。
- JSON：格式化、压缩、自动去转义、树形查看和历史记录。
- 文本对比：行级、字符级和 JSON 结构差异。
- Markdown：实时预览、目录、搜索和本地图片。
- 数据库：只读查询 SQLite，支持结构查看、智能提示和分页。
- 网络工具：HTTP/HTTPS 抓包、模拟服务器和局域网调试。
- 其他工具：MD5、字符串转换、二维码和时间戳等。

![SimpleTools 功能界面](screenshots/notes.png)

## 分支用途

- `main`：标准轻量版，只包含常用工具，不携带 TVBOX、JVM、Python 和 libmpv 影音运行时。
- `tvbox`：影音增强版，在标准版基础上增加 TVBOX、多仓/单仓片源、网盘、直播及原生播放器功能。

项目只长期维护以上两个分支；饭太硬破解、反编译和多仓维护资料存放在独立的私有资料仓库，不再使用单独的影视仓开发分支。

## 更新日志

版本变化统一维护在 [更新日志](CHANGELOG.md)。
