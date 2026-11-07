param(
    [Parameter(Mandatory = $true)] [string] $Jar,
    [string] $Output = "reverse-engineering/fantaiying"
)

$ErrorActionPreference = 'Stop'
$project = Split-Path -Parent $PSScriptRoot
$jarPath = (Resolve-Path -LiteralPath $Jar).Path
$cfr = Join-Path $project '_probe/cfr.jar'
if (-not (Test-Path -LiteralPath $cfr)) { throw "缺少 CFR：$cfr" }

$outputPath = Join-Path $project $Output
$javaPath = Join-Path $outputPath 'java'
$bytecodePath = Join-Path $outputPath 'bytecode'
New-Item -ItemType Directory -Force $javaPath, $bytecodePath | Out-Null

& java -jar $cfr $jarPath --outputdir $javaPath --silent true
if ($LASTEXITCODE -ne 0) { throw "CFR 执行失败：$LASTEXITCODE" }

$warningFiles = rg -l 'Decompilation failed|Exception decompiling|Unable to fully structure code|Could not resolve type clashes' $javaPath -g '*.java'
$javaRoot = (Resolve-Path -LiteralPath $javaPath).Path
foreach ($file in $warningFiles) {
    $full = (Resolve-Path -LiteralPath $file).Path
    $relative = $full.Substring($javaRoot.Length + 1).Replace('\', '.').Replace('/', '.')
    $className = $relative.Substring(0, $relative.Length - 5)
    $destination = Join-Path $bytecodePath ($className + '.javap.txt')
    New-Item -ItemType Directory -Force (Split-Path $destination) | Out-Null
    & javap -classpath $jarPath -c -p -s $className 2>&1 | Set-Content -LiteralPath $destination -Encoding UTF8
}

$classCount = (& jar tf $jarPath | Where-Object { $_ -like '*.class' }).Count
$javaCount = (Get-ChildItem $javaPath -Recurse -Filter '*.java').Count
$fallbackCount = (Get-ChildItem $bytecodePath -Recurse -Filter '*.txt').Count
Write-Output "class=$classCount java=$javaCount bytecodeFallback=$fallbackCount output=$outputPath"
