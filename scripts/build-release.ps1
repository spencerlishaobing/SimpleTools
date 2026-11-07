# SimpleTools 发布构建：注入 Rust + VS Build Tools 环境后执行 tauri build
$ErrorActionPreference = 'Stop'
$vc = 'F:\VS\BuildTools\VC\Auxiliary\Build\vcvars64.bat'
if (Test-Path $vc) {
  $lines = & $env:ComSpec /c "`"$vc`" >nul 2>&1 && set"
  foreach ($line in $lines) {
    if ($line -match '^([^=]+)=(.*)$') {
      Set-Item -Path ('Env:' + $matches[1]) -Value $matches[2] -ErrorAction SilentlyContinue
    }
  }
  Write-Host "VS env injected: $((Get-Command link.exe -ErrorAction SilentlyContinue).Source)"
} else {
  Write-Host "vcvars64.bat not found: $vc"
}
$env:CARGO_HOME = 'F:\Rust\cargo'
$env:RUSTUP_HOME = 'F:\Rust\rustup'
$env:Path = 'F:\Rust\cargo\bin;' + $env:Path
Set-Location 'F:\SimpleTools\SimpleTools'
# Tauri API 正常时会覆盖侧栏版本；API 暂不可用时 HTML 仍必须显示真实包版本。
$version = (Get-Content package.json -Raw -Encoding UTF8 | ConvertFrom-Json).version
$indexPath = Join-Path (Get-Location) 'src\index.html'
$index = Get-Content $indexPath -Raw -Encoding UTF8
$index = [regex]::Replace($index, '(<span id="version-text">)v[^<]+(</span>)', "`$1v$version`$2")
[IO.File]::WriteAllText($indexPath, $index, [Text.UTF8Encoding]::new($false))
$tag = if ($args.Count -gt 0) { $args[0] } else { '--no-bundle' }
if ($tag -eq '--no-bundle') {
  npx tauri build --no-bundle
} else {
  npx tauri build
}
exit $LASTEXITCODE
