# Pin binary versions and verify GitHub's release SHA256 before extraction.
$ErrorActionPreference = 'Stop'
$ProgressPreference = 'SilentlyContinue'
function Get-CoreHash([string]$path) {
    $stream = [System.IO.File]::OpenRead([System.IO.Path]::GetFullPath($path))
    $sha = [System.Security.Cryptography.SHA256]::Create()
    try { return ([System.BitConverter]::ToString($sha.ComputeHash($stream))).Replace('-', '').ToLowerInvariant() }
    finally { $stream.Dispose(); $sha.Dispose() }
}
$coreDir = Join-Path $PSScriptRoot '../src-tauri/resources/mpv'
$metadata = Get-Content (Join-Path $coreDir 'provenance.json') -Raw | ConvertFrom-Json
$dllPath = Join-Path $coreDir 'libmpv-2.dll'
if (Test-Path -LiteralPath $dllPath) {
    if ((Get-CoreHash $dllPath) -eq $metadata.dll_sha256) { exit 0 }
    throw 'libmpv DLL hash mismatch. Restore the pinned binary before building.'
}
$archivePath = Join-Path $coreDir 'core.7z'
if (-not (Test-Path -LiteralPath $archivePath)) {
    [Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12
    $client = New-Object System.Net.WebClient
    try { $client.DownloadFile($metadata.browser_download_url, [System.IO.Path]::GetFullPath($archivePath)) }
    finally { $client.Dispose() }
}
$archiveHash = Get-CoreHash $archivePath
if ($metadata.digest -ne ('sha256:' + $archiveHash)) { throw 'libmpv archive SHA256 mismatch' }
tar -xf $archivePath -C $coreDir
if ($LASTEXITCODE -ne 0) { throw 'libmpv extraction failed' }
if ((Get-CoreHash $dllPath) -ne $metadata.dll_sha256) { throw 'libmpv DLL SHA256 mismatch' }

# aria2: BitTorrent / magnet download component (same pinned version + SHA256 flow as libmpv)
$ariaDir = Join-Path $PSScriptRoot '../src-tauri/resources/aria2'
$ariaMeta = Get-Content (Join-Path $ariaDir 'provenance.json') -Raw | ConvertFrom-Json
$ariaExe = Join-Path $ariaDir 'aria2c.exe'
if (-not (Test-Path -LiteralPath $ariaExe)) {
    $ariaZip = Join-Path $ariaDir 'aria2.zip'
    if (-not (Test-Path -LiteralPath $ariaZip)) {
        [Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12
        $client = New-Object System.Net.WebClient
        try { $client.DownloadFile($ariaMeta.source, [System.IO.Path]::GetFullPath($ariaZip)) }
        finally { $client.Dispose() }
    }
    if ((Get-CoreHash $ariaZip) -ne $ariaMeta.archiveSha256) { throw 'aria2 archive SHA256 mismatch' }
    Add-Type -AssemblyName System.IO.Compression.FileSystem
    $ariaArchive = [System.IO.Compression.ZipFile]::OpenRead([System.IO.Path]::GetFullPath($ariaZip))
    try {
        $entry = $ariaArchive.Entries | Where-Object { $_.Name -eq 'aria2c.exe' } | Select-Object -First 1
        if (-not $entry) { throw 'aria2c.exe not found in archive' }
        [System.IO.Compression.ZipFileExtensions]::ExtractToFile($entry, [System.IO.Path]::GetFullPath($ariaExe), $true)
    }
    finally { $ariaArchive.Dispose() }
}
