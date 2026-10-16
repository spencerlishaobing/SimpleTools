<#
SimpleTools 一键发布 GitHub Release
====================================
用法（在任意位置执行）：
  powershell -ExecutionPolicy Bypass -File release.ps1 -Version 0.34.0
  powershell -ExecutionPolicy Bypass -File release.ps1 -Version 0.34.0 -NotesFile .\notes.md
  powershell -ExecutionPolicy Bypass -File release.ps1 -Version 0.34.0 -DryRun
  TVBOX 版（仅限 tvbox 分支，标签与资产自动带 tvbox 标识）：
  powershell -ExecutionPolicy Bypass -File release.ps1 -Version 0.34.0 -Tvbox
  网络被干扰导致 fetch/push/API 失败时附加：-Proxy http://127.0.0.1:44447

流程：校验（版本三处一致 / 工作区干净 / HEAD 已推送 / tag 未被占用 / 安装包与免安装 exe 存在）
      -> 打 tag -> 推 tag -> 创建 Release -> 上传资产（NSIS 安装包 + 免安装 exe）

说明：
- 凭据复用 Windows 凭据管理器中 git push 已保存的 GitHub 凭据（运行时动态读取，不落盘）；
- 失败后修复可重跑：tag / Release / 资产已存在的步骤会自动跳过（续跑模式）；
- -DryRun 只做校验与连通性测试，不产生任何远端变更。
#>
param(
  [Parameter(Mandatory = $true)][string]$Version,
  [string]$Installer = '',
  [string]$PortableExe = '',
  [string]$Notes = '',
  [string]$NotesFile = '',
  [string]$Proxy = '',
  [switch]$DryRun,
  [switch]$Tvbox
)

$ErrorActionPreference = 'Stop'
$ProgressPreference = 'SilentlyContinue'
[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12

$RepoSlug = 'spencerlishaobing/SimpleTools'
$ApiBase = "https://api.github.com/repos/$RepoSlug"
$RepoDir = $PSScriptRoot

function Fail([string]$msg) {
  Write-Output "RELEASE-FAIL: $msg"
  exit 1
}

# ---------- 版本归一 ----------
$v = $Version.Trim().TrimStart('v', 'V')
if ($v -notmatch '^\d+\.\d+\.\d+$') { Fail "bad version '$Version' (expect X.Y.Z)" }
$tag = "v$v"

# ---------- 分支与 TVBOX 版本（防止把 TVBOX 构建当成标准版发布，或反之） ----------
$branch = (git -C $RepoDir rev-parse --abbrev-ref HEAD).Trim()
if ($Tvbox -and $branch -ne 'tvbox') { Fail "-Tvbox requires the tvbox branch (current: $branch)" }
if (-not $Tvbox -and $branch -eq 'tvbox') { Fail "on tvbox branch use -Tvbox (refusing to publish the TVBOX build as a standard release)" }
if ($Tvbox) { $tag = "v$v-tvbox" }

# ---------- 版本号一致校验（tauri.conf.json / package.json / Cargo.toml） ----------
$confVer = (Get-Content (Join-Path $RepoDir 'src-tauri\tauri.conf.json') -Raw -Encoding UTF8 | ConvertFrom-Json).version
$pkgVer = (Get-Content (Join-Path $RepoDir 'package.json') -Raw -Encoding UTF8 | ConvertFrom-Json).version
$cargoVer = (Select-String -Path (Join-Path $RepoDir 'src-tauri\Cargo.toml') -Pattern '^version\s*=\s*"([^"]+)"' | Select-Object -First 1).Matches[0].Groups[1].Value
foreach ($pair in @(@('tauri.conf.json', $confVer), @('package.json', $pkgVer), @('Cargo.toml', $cargoVer))) {
  if ($pair[1] -ne $v) { Fail "version mismatch: $($pair[0]) = $($pair[1]), expect $v (sync versions first)" }
}

# ---------- 发布说明 ----------
if (-not $Notes -and $NotesFile) {
  if (-not (Test-Path -LiteralPath $NotesFile)) { Fail "notes file not found: $NotesFile" }
  $Notes = [System.IO.File]::ReadAllText((Resolve-Path -LiteralPath $NotesFile).Path, [System.Text.Encoding]::UTF8).Trim()
}

# ---------- 发布产物定位与指纹（NSIS 安装包 + 免安装 exe） ----------
if (-not $Installer) {
  $Installer = Join-Path $RepoDir "src-tauri\target\release\bundle\nsis\SimpleTools_${v}_x64-setup.exe"
}
if (-not $PortableExe) {
  $PortableExe = Join-Path $RepoDir 'src-tauri\target\release\SimpleTools.exe'
}
if (-not (Test-Path -LiteralPath $Installer)) { Fail "installer not found: $Installer" }
if (-not (Test-Path -LiteralPath $PortableExe)) { Fail "portable exe not found: $PortableExe" }
$inst = Get-Item -LiteralPath $Installer
$assetName = $inst.Name
$sha = (Get-FileHash -LiteralPath $Installer -Algorithm SHA256).Hash
$sizeMB = [math]::Round($inst.Length / 1MB, 2)
$portable = Get-Item -LiteralPath $PortableExe
# 免安装 exe 上传时改用带版本名（原文件名固定为 SimpleTools.exe，多版本下载易混淆）
$portableAssetName = "SimpleTools_${v}_x64-portable.exe"
if ($Tvbox) {
  # TVBOX 版：资产名带 tvbox 标识，避免与标准版混淆
  $assetName = $assetName -replace '_x64-setup', '_tvbox_x64-setup'
  $portableAssetName = "SimpleTools_${v}_x64-portable-tvbox.exe"
}
$portableSha = (Get-FileHash -LiteralPath $PortableExe -Algorithm SHA256).Hash
$portableMB = [math]::Round($portable.Length / 1MB, 2)
$assets = @(
  @{ Name = $assetName;         File = $Installer;   MB = $sizeMB;     Sha = $sha },
  @{ Name = $portableAssetName; File = $PortableExe; MB = $portableMB; Sha = $portableSha }
)

# ---------- git 封装（可选代理） ----------
$gitArgs = @('-C', $RepoDir)
if ($Proxy) { $gitArgs += @('-c', "http.proxy=$Proxy", '-c', "https.proxy=$Proxy") }
function Invoke-Git([string[]]$argv) {
  # git 的进度信息（push/fetch）写 stderr；在 ErrorActionPreference=Stop 下经 2>&1 捕获会被
  # 误判为 NativeCommandError 终止错误，故调用期间临时降级 EAP（PowerShell 5.1 已知行为，勿删）
  $prev = $ErrorActionPreference
  $ErrorActionPreference = 'Continue'
  $out = & git @gitArgs @argv 2>&1
  $code = $LASTEXITCODE
  $ErrorActionPreference = $prev
  if ($code -ne 0) { Fail "git $($argv -join ' ') failed: $($out -join ' | ')" }
  return ($out -join "`n")
}

# ---------- git 状态校验 ----------
$dirty = (Invoke-Git @('status', '--porcelain', '-uno')).Trim()
Invoke-Git @('fetch', 'origin', 'main', '--quiet') | Out-Null
$ahead = (Invoke-Git @('rev-list', '--count', 'origin/main..HEAD')).Trim()
$behind = (Invoke-Git @('rev-list', '--count', 'HEAD..origin/main')).Trim()
$headCommit = (Invoke-Git @('rev-parse', 'HEAD')).Trim().Substring(0, 7)

$warnings = @()
if ($dirty) {
  $msg = "working tree has uncommitted changes (commit & push first):`n$dirty"
  if ($DryRun) { $warnings += $msg } else { Fail $msg }
}
if ($ahead -ne '0') {
  $msg = "local is ahead of origin/main by $ahead commit(s) (push first)"
  if ($DryRun) { $warnings += $msg } else { Fail $msg }
}
if ($behind -ne '0') { Fail "local is behind origin/main by $behind commit(s) (pull first)" }

# ---------- tag 占用检查（支持续跑） ----------
$localTag = (Invoke-Git @('tag', '--list', $tag)).Trim()
if ($localTag) {
  $tagCommit = (Invoke-Git @('rev-list', '-n', '1', $tag)).Trim()
  $fullHead = (Invoke-Git @('rev-parse', 'HEAD')).Trim()
  if ($tagCommit -ne $fullHead) {
    # 续跑场景（tag 已推、之后又有修复提交）：提示并复用，不中断
    Write-Output "STEP tag $tag exists at $($tagCommit.Substring(0, 7)) (HEAD $($fullHead.Substring(0, 7))), reuse"
  }
}
$remoteTag = (Invoke-Git @('ls-remote', '--tags', 'origin', "refs/tags/$tag")).Trim()

# ---------- 凭据（复用 Windows 凭据管理器，动态读取） ----------
$credOut = "protocol=https`nhost=github.com`n" | git credential fill 2>$null
$token = ''
foreach ($line in @($credOut)) {
  if ("$line" -match '^password=(.+)$') { $token = $Matches[1].Trim(); break }
}
if (-not $token) { Fail "cannot get GitHub credential from Windows Credential Manager" }

$headers = @{
  Authorization = "token $token"
  'User-Agent'  = 'SimpleTools-release'
  Accept        = 'application/vnd.github+json'
}
$proxyArg = @{}
if ($Proxy) { $proxyArg['Proxy'] = $Proxy }

function Api([string]$Method, [string]$Uri, $JsonBody) {
  $p = @{ Method = $Method; Uri = $Uri; Headers = $headers; UseBasicParsing = $true } + $proxyArg
  if ($JsonBody) {
    $p.Body = [System.Text.Encoding]::UTF8.GetBytes(($JsonBody | ConvertTo-Json -Depth 6))
    $p.ContentType = 'application/json; charset=utf-8'
  }
  return Invoke-RestMethod @p
}
function ApiErrorText($err) {
  try {
    $r = $err.Exception.Response
    if ($r) {
      $sr = New-Object System.IO.StreamReader($r.GetResponseStream())
      $t = $sr.ReadToEnd()
      if ($t) { return $t }
    }
  } catch { }
  return $err.Exception.Message
}

# ---------- API 预检（凭据 + 网络） ----------
try { $me = Api 'GET' 'https://api.github.com/user' } catch { Fail "GitHub API check failed (credential or network): $(ApiErrorText $_)" }

# ---------- DryRun：只报告计划 ----------
if ($DryRun) {
  Write-Output "RELEASE-PLAN $tag"
  Write-Output "  repo      : $RepoSlug"
  Write-Output "  branch    : $branch$(if ($Tvbox) { ' (TVBOX 版)' } else { ' (标准版)' })"
  Write-Output "  api user  : $($me.login)"
  Write-Output "  head      : $headCommit (ahead=$ahead behind=$behind)"
  Write-Output "  tag       : $(if ($localTag) { 'exists (reuse)' } else { 'will create' }) local / $(if ($remoteTag) { 'exists (reuse)' } else { 'will push' }) remote"
  foreach ($a in $assets) {
    Write-Output "  asset     : $($a.Name) ($($a.MB) MB)"
    Write-Output "    file    : $($a.File)"
    Write-Output "    sha256  : $($a.Sha)"
  }
  Write-Output "  notes     : $(if ($Notes) { "provided ($($Notes.Length) chars)" } else { 'default' })"
  foreach ($w in $warnings) { Write-Output "RELEASE-WARN: $w" }
  Write-Output 'RELEASE-DRYRUN-OK'
  exit 0
}

# ---------- 1) tag ----------
if (-not $localTag) { Invoke-Git @('tag', $tag) | Out-Null; Write-Output "STEP tag created: $tag" }
else { Write-Output "STEP tag exists: $tag" }
if (-not $remoteTag) { Invoke-Git @('push', 'origin', $tag) | Out-Null; Write-Output "STEP tag pushed" }
else { Write-Output "STEP remote tag exists, skip push" }

# ---------- 2) Release ----------
$releaseNotes = @"
## SimpleTools $tag

Windows x64 安装包（NSIS 向导安装）：

- 安装包：$assetName（$sizeMB MB）
- SHA256：``$sha``

Windows x64 免安装单文件（双击即用，无需安装）：

- 免安装：$portableAssetName（$portableMB MB）
- SHA256：``$portableSha``

$Notes
"@
$releaseNotes = $releaseNotes.Trim()

$release = $null
try {
  $release = Api 'GET' "$ApiBase/releases/tags/$tag"
  Write-Output "STEP release exists: #$($release.id)"
} catch {
  $status = 0
  try { $status = [int]$_.Exception.Response.StatusCode } catch { }
  if ($status -ne 404) { Fail "query release failed: $(ApiErrorText $_)" }
}
if (-not $release) {
  $release = Api 'POST' "$ApiBase/releases" @{
    tag_name   = $tag
    name       = $(if ($Tvbox) { "SimpleTools $v · TVBOX 版" } else { "SimpleTools $tag" })
    body       = $releaseNotes
    draft      = $false
    prerelease = $false
  }
  Write-Output "STEP release created: #$($release.id)"
}

# ---------- 3) 上传资产（安装包 + 免安装 exe，各自幂等跳过） ----------
foreach ($a in $assets) {
  $exists = $false
  foreach ($ra in @($release.assets)) { if ($ra.name -eq $a.Name) { $exists = $true; break } }
  if ($exists) {
    Write-Output "STEP asset exists, skip upload: $($a.Name)"
    continue
  }
  $uploadUri = ($release.upload_url -replace '\{.*$', '') + '?name=' + [uri]::EscapeDataString($a.Name)
  $up = @{ Method = 'Post'; Uri = $uploadUri; Headers = $headers; InFile = $a.File; ContentType = 'application/octet-stream'; UseBasicParsing = $true } + $proxyArg
  try { Invoke-WebRequest @up | Out-Null } catch { Fail "asset upload failed ($($a.Name)): $(ApiErrorText $_)" }
  Write-Output "STEP asset uploaded: $($a.Name) ($($a.MB) MB)"
}

Write-Output "RELEASE-OK $tag https://github.com/$RepoSlug/releases/tag/$tag"
exit 0
