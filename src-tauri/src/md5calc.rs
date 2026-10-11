use md5::{Digest, Md5};
use serde::Serialize;
use std::fs::File;
use std::io::Read;
use std::path::{Path, PathBuf};

#[derive(Serialize)]
pub struct FileMd5Result {
    /// 小写十六进制摘要
    pub hash: String,
    /// 文件名
    pub name: String,
    /// 文件大小（字节）
    pub size: u64,
}

/// 计算字符串的 MD5（UTF-8 编码），返回小写十六进制
#[tauri::command]
pub fn md5_text(text: String) -> String {
    let mut hasher = Md5::new();
    hasher.update(text.as_bytes());
    format!("{:x}", hasher.finalize())
}

/// 流式计算文件 MD5（大文件不占内存），返回小写十六进制
#[tauri::command]
pub async fn md5_file(path: String) -> Result<FileMd5Result, String> {
    tauri::async_runtime::spawn_blocking(move || {
        let p = PathBuf::from(&path);
        let meta = std::fs::metadata(&p).map_err(|e| format!("无法读取文件：{e}"))?;
        if meta.is_dir() {
            return Err("选中的是文件夹，请选择文件".to_string());
        }
        let hash = hash_file(&p)?;
        let name = p
            .file_name()
            .map(|s| s.to_string_lossy().to_string())
            .unwrap_or(path);
        Ok(FileMd5Result {
            hash,
            name,
            size: meta.len(),
        })
    })
    .await
    .map_err(|e| format!("计算任务失败：{e}"))?
}

/// 分块读取文件并计算 MD5
fn hash_file(path: &Path) -> Result<String, String> {
    let mut file = File::open(path).map_err(|e| format!("打开文件失败：{e}"))?;
    let mut hasher = Md5::new();
    let mut buf = vec![0u8; 1024 * 1024];
    loop {
        let n = file.read(&mut buf).map_err(|e| format!("读取文件失败：{e}"))?;
        if n == 0 {
            break;
        }
        hasher.update(&buf[..n]);
    }
    Ok(format!("{:x}", hasher.finalize()))
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn text_md5_empty() {
        assert_eq!(md5_text(String::new()), "d41d8cd98f00b204e9800998ecf8427e");
    }

    #[test]
    fn text_md5_abc() {
        assert_eq!(md5_text("abc".to_string()), "900150983cd24fb0d6963f7d28e17f72");
    }

    #[test]
    fn file_md5_small_file() {
        let p = std::env::temp_dir().join("simpletools_md5_test.txt");
        std::fs::write(&p, b"abc").unwrap();
        let hash = hash_file(&p).unwrap();
        let _ = std::fs::remove_file(&p);
        assert_eq!(hash, "900150983cd24fb0d6963f7d28e17f72");
    }

    #[test]
    fn file_md5_larger_than_buffer() {
        // 内容跨越 1MB 缓冲区边界，验证分块拼接正确
        let p = std::env::temp_dir().join("simpletools_md5_test_large.bin");
        let data = vec![0xABu8; 1024 * 1024 * 3 + 123];
        std::fs::write(&p, &data).unwrap();
        let hash = hash_file(&p).unwrap();
        let _ = std::fs::remove_file(&p);
        let mut hasher = Md5::new();
        hasher.update(&data);
        assert_eq!(hash, format!("{:x}", hasher.finalize()));
    }
}
