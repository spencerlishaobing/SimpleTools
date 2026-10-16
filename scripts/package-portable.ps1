<#
SimpleTools TVBOX 便携包打包（tvbox 分支专用）
================================================
用法（在 tvbox 分支执行过 npm run build 之后）：
  powershell -ExecutionPolicy Bypass -File scripts/package-portable.ps1 -Version 0.58.0

产物：
  src-tauri\target\release\bundle\SimpleTools_<v>_tvbox_portable.zip
  内含 SimpleTools.exe + resources/ + 使用说明.txt

说明：release.ps1 -Tvbox 发布时会自动把该 zip 作为第三个资产上传（存在才上传）。
#>
param([Parameter(Mandatory = $true)][string]$Version)

$ErrorActionPreference = 'Stop'
$v = $Version.Trim().TrimStart('v', 'V')
if ($v -notmatch '^\d+\.\d+\.\d+$') { throw "bad version '$Version' (expect X.Y.Z)" }

$release = Join-Path $PSScriptRoot '..\src-tauri\target\release'
if (-not (Test-Path -LiteralPath (Join-Path $release 'simpletools.exe'))) { throw '未找到构建产物，请先执行 npm run build' }
if (-not (Test-Path -LiteralPath (Join-Path $release 'resources\java\host.jar'))) { throw 'resources 运行时缺失，请先执行 npm run build（会运行 prepare-tvbox-all.ps1）' }
if (Get-Process -Name simpletools -ErrorAction SilentlyContinue) { throw '应用正在运行，请先关闭后再打包（exe 会被文件锁占用）' }

$name = "SimpleTools_${v}_tvbox_portable"
$bundle = Join-Path $release 'bundle'
$dst = Join-Path $bundle $name
if (Test-Path -LiteralPath $dst) { Remove-Item -Recurse -Force $dst }
New-Item -ItemType Directory -Force -Path $dst | Out-Null

Copy-Item (Join-Path $release 'simpletools.exe') (Join-Path $dst 'SimpleTools.exe')
robocopy (Join-Path $release 'resources') (Join-Path $dst 'resources') /E /MT /NFL /NDL /NJH /NJS /NP | Out-Null
if ($LASTEXITCODE -ge 8) { throw "resources 复制失败（robocopy $LASTEXITCODE）" }

$readme = @"
SimpleTools $v 免安装便携版（TVBOX 版）

完整解压本 ZIP 后，双击 SimpleTools.exe 使用。
请保持 resources 文件夹与 EXE 位于同一目录，否则影音内核与片源运行时无法加载。

TVBOX：顶部导航「影视 / 搜索 / 直播 / 收藏 / 历史 / 设置」；
在「设置」中粘贴配置地址（支持多仓合集），回到影视页筛选片源、选分类或搜索影片。

说明：
- 内置 libmpv / OpenJDK / Python，无需另装播放器、Java 或 Python；
- 磁力/种子下载依赖 resources/aria2；
- 删除本文件夹即卸载；用户数据保存在 %APPDATA%\com.simpletools.desktop（可按需清理）。
"@
[System.IO.File]::WriteAllText((Join-Path $dst '使用说明.txt'), $readme, (New-Object System.Text.UTF8Encoding $true))

$zip = Join-Path $bundle "$name.zip"
if (Test-Path -LiteralPath $zip) { Remove-Item -Force $zip }
tar -a -cf $zip -C $bundle $name
if ($LASTEXITCODE -ne 0) { throw 'zip 打包失败（tar -a）' }

$sizeMB = [math]::Round((Get-Item -LiteralPath $zip).Length / 1MB, 1)
Write-Output "PORTABLE-OK $zip ($sizeMB MB)"
