use serde::Serialize;
use std::fs;
use std::path::PathBuf;

/// 读取到的文本文件内容
#[derive(Serialize)]
pub struct TextFile {
    /// 文件名（含扩展名）
    pub name: String,
    /// 文本内容（UTF-8，自动去除 BOM；非 UTF-8 字节以替换字符兜底）
    pub content: String,
}

/// 读取本地文本文件（供 Markdown 预览打开 .md 等文本文件）
#[tauri::command]
pub fn read_text_file(path: String) -> Result<TextFile, String> {
    let p = PathBuf::from(&path);
    if !p.is_file() {
        return Err("文件不存在或不是文件".into());
    }
    let bytes = fs::read(&p).map_err(|e| format!("读取失败: {e}"))?;
    // 去除 UTF-8 BOM，避免渲染时开头出现零宽字符
    let bytes: &[u8] = if bytes.starts_with(&[0xEF, 0xBB, 0xBF]) {
        &bytes[3..]
    } else {
        &bytes[..]
    };
    let name = p
        .file_name()
        .map(|s| s.to_string_lossy().into_owned())
        .unwrap_or(path);
    Ok(TextFile {
        name,
        content: String::from_utf8_lossy(bytes).into_owned(),
    })
}

/// 将文本内容写入本地文件（供 Markdown 预览保存 .md 等文本文件）
/// 返回写入的文件名（含扩展名）
#[tauri::command]
pub fn write_text_file(path: String, content: String) -> Result<String, String> {
    let p = PathBuf::from(&path);
    fs::write(&p, content.as_bytes()).map_err(|e| format!("写入失败: {e}"))?;
    let name = p
        .file_name()
        .map(|s| s.to_string_lossy().into_owned())
        .unwrap_or(path);
    Ok(name)
}
