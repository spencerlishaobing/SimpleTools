# 饭太硬 JAR 反编译工作区

本目录用于把饭太硬源从 Android JAR 逐步迁移为 SimpleTools 内置适配器。这里的 Java 是逆向分析材料，不参与正式程序编译。

历史版本不得覆盖。收到新版 JAR 时使用 `scripts/snapshot-fantaiying.ps1` 建立按日期和 SHA-256 命名的独立快照；玩偶迁移与回归基准见 `WOGG-COMPATIBILITY.md`。

## 完整性

- 输入：桌面兼容层由 DEX 转换得到的 `converted-v2.4g.jar`
- JAR 类文件：1181 个（包含匿名类和内部类）
- CFR 顶层 Java 文件：765 个
- 包含 CFR 结构化警告的 Java 文件：103 个
- 对上述 103 个文件均生成了 `javap -c -p -s` 字节码兜底
- 输入文件 SHA-256 见 `source-sha256.txt`

目录说明：

- `java/`：CFR 反编译出的完整 Java 源码树
- `bytecode/`：反编译不完整类的 JVM 指令、字段和方法签名
- `class-index.csv`：类名、Java 路径、方法数量和警告数量
- `cfr-summary.txt`：CFR 原始失败摘要

## 阅读顺序

1. 从 `java/com/github/catvod/spider/<源名>.java` 的 `init`、`homeContent`、`categoryContent`、`searchContent`、`detailContent`、`playerContent` 开始。
2. 跟进 `java/com/github/catvod/spider/Pan.java`、`Cloud_quark.java`、`Cloud_uc.java`、`Cloud_baidu.java`、`Cloud_ali.java`，梳理网盘分发。
3. 跟进 `java/com/github/catvod/spider/merge/` 下的网络、签名、加解密和模型类。类名已混淆，调用关系比类名更可靠。
4. 遇到 `Decompilation failed`、`Unable to fully structure code` 或明显不合理的控制流，立即切到 `bytecode/` 中的同名 `.javap.txt`。
5. 用 Java 宿主进行一次真实调用，记录请求和返回，再用内置 JS/Rust 实现相同行为。反编译代码仅用于确认算法和字段，不应直接复制进产品。

## 已识别的主要层次

- `com.github.catvod.spider.*`：TVBox Spider 入口和站点适配
- `com.github.catvod.spider.Pan`：网盘搜索结果的线路汇总与播放分发
- `Cloud_*`：各网盘登录、目录遍历和播放地址获取
- `ProxyOrigin`：JAR 本地代理、扫码登录和媒体转发入口
- `Init` / `InitOrigin`：Android 上下文、反射桥及原生初始化
- `merge.*`：被混淆的 HTTP、JSON、签名、加密、并发和数据模型实现

## 关键限制

CFR 输出不是可直接重新编译的源码。控制流混淆、非法标识符、DEX 转换损失和原生方法会让部分方法表现为伪代码。迁移时应以“Java 结构 + javap 字节码 + 实际网络行为”三者相互验证，不能只看某一份 Java 文件。

