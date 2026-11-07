param(
    [Parameter(Mandatory = $true)] [string] $Jar,
    [string] $Label = ""
)

$ErrorActionPreference = 'Stop'
$project = Split-Path -Parent $PSScriptRoot
$jarPath = (Resolve-Path -LiteralPath $Jar).Path
$sha = (Get-FileHash -LiteralPath $jarPath -Algorithm SHA256).Hash.ToLowerInvariant()
$stamp = Get-Date -Format 'yyyyMMdd'
$safeLabel = ($Label -replace '[^0-9A-Za-z._-]', '-').Trim('-')
$name = if ($safeLabel) { "$stamp-$safeLabel-$($sha.Substring(0,12))" } else { "$stamp-$($sha.Substring(0,12))" }
$relative = "reverse-engineering/fantaiying-snapshots/$name"
$output = Join-Path $project $relative
if (Test-Path -LiteralPath $output) {
    Write-Output "snapshot already exists: $output"
    exit 0
}

New-Item -ItemType Directory -Force $output | Out-Null
Copy-Item -LiteralPath $jarPath -Destination (Join-Path $output 'source.jar')
Set-Content -LiteralPath (Join-Path $output 'source-sha256.txt') -Value "$sha  source.jar" -Encoding UTF8
& (Join-Path $PSScriptRoot 'decompile-fantaiying.ps1') -Jar (Join-Path $output 'source.jar') -Output $relative
if ($LASTEXITCODE -ne 0) { throw "反编译快照失败：$LASTEXITCODE" }

$classes = & jar tf (Join-Path $output 'source.jar') | Where-Object { $_ -like '*.class' } | Sort-Object
Set-Content -LiteralPath (Join-Path $output 'classes.txt') -Value $classes -Encoding UTF8
$latest = Join-Path $project 'reverse-engineering/fantaiying-snapshots/LATEST.txt'
Set-Content -LiteralPath $latest -Value $name -Encoding UTF8
Write-Output "snapshot=$output sha256=$sha"
