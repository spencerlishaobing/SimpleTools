# 生成应用源图标（1024x1024 PNG）：渐变圆角方块 + ST 字样
Add-Type -AssemblyName System.Drawing

$size = 1024
$bmp = New-Object System.Drawing.Bitmap($size, $size)
$g = [System.Drawing.Graphics]::FromImage($bmp)
$g.SmoothingMode = [System.Drawing.Drawing2D.SmoothingMode]::AntiAlias
$g.TextRenderingHint = [System.Drawing.Text.TextRenderingHint]::AntiAliasGridFit

# 圆角矩形路径
$r = 200
$path = New-Object System.Drawing.Drawing2D.GraphicsPath
$path.AddArc(0, 0, $r * 2, $r * 2, 180, 90)
$path.AddArc($size - $r * 2, 0, $r * 2, $r * 2, 270, 90)
$path.AddArc($size - $r * 2, $size - $r * 2, $r * 2, $r * 2, 0, 90)
$path.AddArc(0, $size - $r * 2, $r * 2, $r * 2, 90, 90)
$path.CloseFigure()

# 蓝紫渐变填充
$c1 = [System.Drawing.Color]::FromArgb(255, 59, 130, 246)
$c2 = [System.Drawing.Color]::FromArgb(255, 139, 92, 246)
$p1 = New-Object System.Drawing.Point(0, 0)
$p2 = New-Object System.Drawing.Point($size, $size)
$brush = New-Object System.Drawing.Drawing2D.LinearGradientBrush($p1, $p2, $c1, $c2)
$g.FillPath($brush, $path)

# 居中绘制 ST
$font = New-Object System.Drawing.Font('Segoe UI', 340, [System.Drawing.FontStyle]::Bold)
$sf = New-Object System.Drawing.StringFormat
$sf.Alignment = [System.Drawing.StringAlignment]::Center
$sf.LineAlignment = [System.Drawing.StringAlignment]::Center
$rectF = New-Object System.Drawing.RectangleF(0, 0, $size, $size)
$g.DrawString('ST', $font, [System.Drawing.Brushes]::White, $rectF, $sf)

$g.Dispose()

$out = Join-Path $PSScriptRoot '..\app-icon.png'
$bmp.Save($out, [System.Drawing.Imaging.ImageFormat]::Png)
$bmp.Dispose()
Write-Host "图标已生成: $out"
