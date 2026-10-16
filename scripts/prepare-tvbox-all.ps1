$ErrorActionPreference = 'Stop'
& powershell -NoProfile -ExecutionPolicy Bypass -File (Join-Path $PSScriptRoot 'prepare-tvbox.ps1')
if ($LASTEXITCODE -ne 0) { throw 'mpv preparation failed' }
& python (Join-Path $PSScriptRoot 'prepare-tvbox-runtimes.py')
if ($LASTEXITCODE -ne 0) { throw 'TVBox compatibility runtime preparation failed' }
