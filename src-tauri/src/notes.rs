use serde::{Deserialize, Serialize};
use std::fs;
use std::path::PathBuf;
use tauri::AppHandle;

/// 单条记事记录
#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct Note {
    pub id: String,
    pub title: String,
    pub content: String,
    /// 类型："text" 普通文本 / "md" Markdown 笔记；旧数据缺省按 text 处理
    #[serde(default = "default_note_type", rename = "type")]
    pub note_type: String,
    /// 最后更新时间（毫秒时间戳）
    pub updated_at: u64,
}

/// serde 缺省值：旧版数据（无 type 字段）视作普通文本
fn default_note_type() -> String {
    "text".to_string()
}

/// 记事本数据文件路径：{数据目录}/notes.json
/// （数据目录默认 {AppData}/com.simpletools.desktop，可在「应用设置」中自定义）
fn notes_path(app: &AppHandle) -> Result<PathBuf, String> {
    Ok(crate::datadir::data_dir(app)?.join("notes.json"))
}

/// 读取全部记录（文件不存在时返回空列表）
#[tauri::command]
pub fn notes_load(app: AppHandle) -> Result<Vec<Note>, String> {
    let path = notes_path(&app)?;
    if !path.exists() {
        return Ok(Vec::new());
    }
    let data = fs::read_to_string(&path).map_err(|e| format!("读取失败: {e}"))?;
    if data.trim().is_empty() {
        return Ok(Vec::new());
    }
    serde_json::from_str(&data).map_err(|e| format!("解析失败: {e}"))
}

/// 全量保存记录（先写临时文件再重命名，避免写入中断损坏数据）
#[tauri::command]
pub fn notes_save(app: AppHandle, notes: Vec<Note>) -> Result<(), String> {
    let path = notes_path(&app)?;
    write_atomic(&path, &notes)
}

/// 手动备份：将当前数据复制一份到 notes.backup.json
#[tauri::command]
pub fn notes_backup(app: AppHandle) -> Result<String, String> {
    let path = notes_path(&app)?;
    if !path.exists() {
        return Err("暂无可备份的数据".into());
    }
    let backup = path.with_file_name("notes.backup.json");
    fs::copy(&path, &backup).map_err(|e| format!("备份失败: {e}"))?;
    Ok(backup.to_string_lossy().to_string())
}

/// 导出文件条目：文件名与内容由前端组装（JSON / TXT），后端只负责写入
#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct ExportFile {
    pub name: String,
    pub content: String,
}

/// 导出记事本数据到用户选择的文件夹，返回写入的文件数
#[tauri::command]
pub fn notes_export(dir: String, files: Vec<ExportFile>) -> Result<usize, String> {
    if files.is_empty() {
        return Err("没有可导出的内容".into());
    }
    let dir = PathBuf::from(&dir);
    if !dir.is_dir() {
        return Err("目标文件夹不存在".into());
    }
    for f in &files {
        // 仅允许纯文件名，禁止路径分隔符与上级目录跳转
        if f.name.is_empty()
            || f.name == "."
            || f.name == ".."
            || f.name.contains('/')
            || f.name.contains('\\')
        {
            return Err(format!("非法文件名: {}", f.name));
        }
        fs::write(dir.join(&f.name), &f.content)
            .map_err(|e| format!("写入 {} 失败: {e}", f.name))?;
    }
    Ok(files.len())
}

fn write_atomic(path: &PathBuf, notes: &[Note]) -> Result<(), String> {
    if let Some(parent) = path.parent() {
        fs::create_dir_all(parent).map_err(|e| format!("创建目录失败: {e}"))?;
    }
    let data = serde_json::to_string_pretty(notes).map_err(|e| format!("序列化失败: {e}"))?;
    let tmp = path.with_extension("json.tmp");
    fs::write(&tmp, data).map_err(|e| format!("写入失败: {e}"))?;
    fs::rename(&tmp, path).map_err(|e| format!("保存失败: {e}"))?;
    Ok(())
}

#[cfg(test)]
mod tests {
    use super::Note;

    /// 旧版数据（无 type 字段）反序列化时缺省为 text，保证升级后兼容
    #[test]
    fn legacy_json_defaults_type_to_text() {
        let legacy = r#"[{"id":"n1","title":"t","content":"c","updated_at":1}]"#;
        let notes: Vec<Note> = serde_json::from_str(legacy).expect("旧数据应能解析");
        assert_eq!(notes[0].note_type, "text");
    }

    /// type 字段以 JSON 键 "type" 序列化，且 md 类型往返一致
    #[test]
    fn note_type_roundtrip() {
        let note = Note {
            id: "n1".into(),
            title: "t".into(),
            content: "c".into(),
            note_type: "md".into(),
            updated_at: 1,
        };
        let json = serde_json::to_string(&note).expect("应能序列化");
        assert!(json.contains(r#""type":"md""#));
        let back: Note = serde_json::from_str(&json).expect("应能反序列化");
        assert_eq!(back.note_type, "md");
    }
}
