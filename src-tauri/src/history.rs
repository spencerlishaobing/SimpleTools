use serde::{Deserialize, Serialize};
use std::fs;
use std::path::PathBuf;
use tauri::AppHandle;

/// 单条 JSON 格式化记录（input 为原始输入，output 为格式化/压缩结果）
///
/// 兼容原则（v0.32.0）：记录字段全部 `serde(default)` —— 旧版本数据缺字段时按默认值
/// 解析（字符串为空串、time 为 0），不因单条记录字段缺失导致整个文件解析失败
#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct JsonRecord {
    #[serde(default)]
    pub id: String,
    #[serde(default)]
    pub input: String,
    #[serde(default)]
    pub output: String,
    /// 记录时间（毫秒时间戳）
    #[serde(default)]
    pub time: u64,
}

/// 单条文本对比记录
#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct DiffRecord {
    #[serde(default)]
    pub id: String,
    #[serde(default)]
    pub left: String,
    #[serde(default)]
    pub right: String,
    /// 记录时间（毫秒时间戳）
    #[serde(default)]
    pub time: u64,
}

/// 单条 MD5 计算记录（kind: "text" 字符串 / "file" 文件）
#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct Md5Record {
    #[serde(default)]
    pub id: String,
    #[serde(default)]
    pub kind: String,
    /// 文本原文或"文件名（大小）"
    #[serde(default)]
    pub input: String,
    /// 原始小写 hex 哈希
    #[serde(default)]
    pub hash: String,
    /// 记录时间（毫秒时间戳）
    #[serde(default)]
    pub time: u64,
}

/// 单条字符串转换记录
#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct StrRecord {
    #[serde(default)]
    pub id: String,
    #[serde(default)]
    pub input: String,
    /// 记录时间（毫秒时间戳）
    #[serde(default)]
    pub time: u64,
}

/// 全部历史记录数据
#[derive(Debug, Clone, Default, Serialize, Deserialize)]
pub struct HistoryData {
    #[serde(default)]
    pub json: Vec<JsonRecord>,
    #[serde(default)]
    pub diff: Vec<DiffRecord>,
    #[serde(default)]
    pub md5: Vec<Md5Record>,
    #[serde(default)]
    pub str: Vec<StrRecord>,
}

/// 历史数据文件路径：{数据目录}/history.json
/// （数据目录默认 {AppData}/com.simpletools.desktop，可在「应用设置」中自定义）
fn history_path(app: &AppHandle) -> Result<PathBuf, String> {
    Ok(crate::datadir::data_dir(app)?.join("history.json"))
}

/// 读取全部历史记录（文件不存在时返回空数据）
#[tauri::command]
pub fn history_load(app: AppHandle) -> Result<HistoryData, String> {
    let path = history_path(&app)?;
    if !path.exists() {
        return Ok(HistoryData::default());
    }
    let data = fs::read_to_string(&path).map_err(|e| format!("读取失败: {e}"))?;
    if data.trim().is_empty() {
        return Ok(HistoryData::default());
    }
    serde_json::from_str(&data).map_err(|e| format!("解析失败: {e}"))
}

/// 全量保存历史记录（先写临时文件再重命名，避免写入中断损坏数据）
#[tauri::command]
pub fn history_save(app: AppHandle, data: HistoryData) -> Result<(), String> {
    let path = history_path(&app)?;
    write_atomic(&path, &data)
}

fn write_atomic(path: &PathBuf, data: &HistoryData) -> Result<(), String> {
    if let Some(parent) = path.parent() {
        fs::create_dir_all(parent).map_err(|e| format!("创建目录失败: {e}"))?;
    }
    let text = serde_json::to_string_pretty(data).map_err(|e| format!("序列化失败: {e}"))?;
    let tmp = path.with_extension("json.tmp");
    fs::write(&tmp, text).map_err(|e| format!("写入失败: {e}"))?;
    fs::rename(&tmp, path).map_err(|e| format!("保存失败: {e}"))?;
    Ok(())
}

#[cfg(test)]
mod tests {
    use super::HistoryData;

    /// 旧版数据缺字段：四个列表缺省为空、记录缺字段按默认值解析，不导致整文件失败（v0.32.0）
    #[test]
    fn legacy_missing_fields_parse() {
        // 列表缺省
        let empty: HistoryData = serde_json::from_str("{}").expect("空对象应能解析");
        assert!(empty.json.is_empty() && empty.diff.is_empty() && empty.md5.is_empty() && empty.str.is_empty());
        // 记录缺 id / time / 各内容字段
        let legacy = r#"{"json":[{"input":"a","output":"b"}],"diff":[{"left":"x"}],"md5":[{"hash":"h"}],"str":[{"input":"s"}]}"#;
        let data: HistoryData = serde_json::from_str(legacy).expect("缺字段记录应能解析");
        assert_eq!(data.json[0].id, "");
        assert_eq!(data.json[0].time, 0);
        assert_eq!(data.json[0].output, "b");
        assert_eq!(data.diff[0].right, "");
        assert_eq!(data.md5[0].kind, "");
        assert_eq!(data.md5[0].hash, "h");
        assert_eq!(data.str[0].input, "s");
    }

    /// 规范数据往返：字段完整时序列化后能原样反序列化
    #[test]
    fn history_roundtrip() {
        let data: HistoryData = serde_json::from_str(
            r#"{"json":[{"id":"j1","input":"a","output":"b","time":1}],"diff":[],"md5":[],"str":[]}"#,
        )
        .expect("应能解析");
        let json = serde_json::to_string(&data).expect("应能序列化");
        let back: HistoryData = serde_json::from_str(&json).expect("应能反序列化");
        assert_eq!(back.json[0].time, 1);
        assert_eq!(back.json.len(), 1);
    }
}
