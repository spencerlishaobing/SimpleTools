use serde::{Deserialize, Serialize};
use std::fs;
use std::path::{Path, PathBuf};
use tauri::AppHandle;

/// 单条记事记录
///
/// 兼容原则（v0.32.0）：核心字段全部 `serde(default)` —— 旧版本备份 / 数据文件缺字段时
/// 按默认值解析（id/title/content 为空串、updated_at 为 0），不因单个字段缺失导致整个
/// 文件解析失败；前端加载时会为缺失的 id 生成 UUID 完成归一化
#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct Note {
    #[serde(default)]
    pub id: String,
    #[serde(default)]
    pub title: String,
    #[serde(default)]
    pub content: String,
    /// 类型："text" 普通笔记（富文本内容）/ "md" Markdown 笔记 / "task" 任务笔记；旧数据缺省按 text 处理
    #[serde(default = "default_note_type", rename = "type")]
    pub note_type: String,
    /// 普通笔记内容是否为富文本 HTML（v0.34.0：旧版纯文本数据加载时由前端转换并回写 true；
    /// 缺省 false 兼容旧数据，false 时不写出保持旧文件干净）
    #[serde(default, skip_serializing_if = "is_false")]
    pub rich: bool,
    /// 任务笔记的任务列表（仅 type = "task" 使用；其余类型序列化时省略）
    #[serde(default, skip_serializing_if = "Vec::is_empty")]
    pub tasks: Vec<TaskItem>,
    /// 任务笔记是否启用自动序号（缺省 true；仅 false 时写出，保持旧文件干净）
    #[serde(default = "default_true", skip_serializing_if = "is_true")]
    pub auto_no: bool,
    /// 最后更新时间（毫秒时间戳）
    #[serde(default)]
    pub updated_at: u64,
}

/// 任务笔记内的单条任务
#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct TaskItem {
    #[serde(default)]
    pub id: String,
    /// 类型："simple" 简单任务（text 纯文本）/ "rich" 富文本任务（title + content HTML）
    #[serde(default = "default_task_kind", rename = "kind")]
    pub task_kind: String,
    /// 简单任务文本（富文本任务为空，序列化时省略）
    #[serde(default, skip_serializing_if = "String::is_empty")]
    pub text: String,
    /// 富文本任务标题（必选，简单任务为空，序列化时省略）
    #[serde(default, skip_serializing_if = "String::is_empty")]
    pub title: String,
    /// 富文本任务内容（HTML，简单任务为空，序列化时省略）
    #[serde(default, skip_serializing_if = "String::is_empty")]
    pub content: String,
    /// 完成状态（未完成时省略）
    #[serde(default, skip_serializing_if = "is_false")]
    pub done: bool,
}

/// serde 缺省值：旧版数据（无 type 字段）视作普通笔记（text）
fn default_note_type() -> String {
    "text".to_string()
}

/// serde 缺省值：任务类型缺省为简单任务
fn default_task_kind() -> String {
    "simple".to_string()
}

fn default_true() -> bool {
    true
}

fn is_true(b: &bool) -> bool {
    *b
}

fn is_false(b: &bool) -> bool {
    !*b
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

// ---------- 富文本图片收纳（v0.33.0）----------
// 插入图片时把文件复制到「数据目录 / images/」，笔记内容以相对路径引用（数据自包含）：
// 备份导出 / 导入 / 数据目录迁移均整体携带 images 目录，换机不丢图

/// 拆分文件名主干与扩展名（退化时使用默认值，保证重组后仍有扩展名）
fn split_name(name: &str) -> (String, String) {
    let p = Path::new(name);
    let stem = p
        .file_stem()
        .and_then(|s| s.to_str())
        .unwrap_or("image")
        .to_string();
    let ext = p
        .extension()
        .and_then(|s| s.to_str())
        .unwrap_or("png")
        .to_lowercase();
    (stem, ext)
}

/// 清洗图片文件名：替换 Windows 非法字符（含控制字符）为下划线，
/// 去掉尾部点 / 空格，主干限长 60，空主干回退为 image
fn sanitize_image_name(raw: &str) -> String {
    let base = Path::new(raw)
        .file_name()
        .and_then(|s| s.to_str())
        .unwrap_or("image");
    let cleaned: String = base
        .chars()
        .map(|c| {
            if c.is_control() || r#"\/:*?"<>|"#.contains(c) {
                '_'
            } else {
                c
            }
        })
        .collect();
    let cleaned = cleaned.trim_end_matches(['.', ' ']).to_string();
    let (mut stem, ext) = split_name(&cleaned);
    if stem.is_empty() {
        stem = "image".to_string();
    }
    if stem.chars().count() > 60 {
        stem = stem.chars().take(60).collect();
    }
    format!("{stem}.{ext}")
}

/// 复制图片到数据目录的 images/ 文件夹，返回文件名（引用时拼为 images/<文件名>）。
/// 命名规则：清洗后的原文件名；同名同内容直接复用（不重复存储）；同名不同内容加序号（-2 / -3 …）
pub(crate) fn copy_image_to_dir(src: &Path, images_dir: &Path) -> Result<String, String> {
    if !src.is_file() {
        return Err("图片文件不存在".into());
    }
    let raw = src.file_name().and_then(|s| s.to_str()).unwrap_or("");
    if !crate::datadir::has_image_ext(raw) {
        return Err("仅支持 png / jpg / jpeg / gif / webp / bmp 图片".into());
    }
    let bytes = fs::read(src).map_err(|e| format!("读取图片失败: {e}"))?;
    fs::create_dir_all(images_dir).map_err(|e| format!("创建图片目录失败: {e}"))?;
    let name = sanitize_image_name(raw);
    let (stem, ext) = split_name(&name);
    for i in 1..1000 {
        let candidate = if i == 1 {
            name.clone()
        } else {
            format!("{stem}-{i}.{ext}")
        };
        let dest = images_dir.join(&candidate);
        if !dest.exists() {
            fs::write(&dest, &bytes).map_err(|e| format!("写入图片失败: {e}"))?;
            return Ok(candidate);
        }
        if fs::read(&dest).ok().as_deref() == Some(bytes.as_slice()) {
            return Ok(candidate);
        }
    }
    Err("图片重名过多，无法生成文件名".into())
}

/// 导入富文本图片：把用户选择的本地图片复制到「数据目录 / images/」，
/// 返回相对路径（images/<文件名>）供笔记内容引用
#[tauri::command]
pub fn note_image_import(app: AppHandle, source: String) -> Result<String, String> {
    if source.trim().is_empty() {
        return Err("图片路径为空".into());
    }
    let src = PathBuf::from(source.trim());
    let images_dir = crate::datadir::data_dir(&app)?.join(crate::datadir::IMAGES_DIR);
    let name = copy_image_to_dir(&src, &images_dir)?;
    Ok(format!("{}/{}", crate::datadir::IMAGES_DIR, name))
}

#[cfg(test)]
mod tests {
    use super::{copy_image_to_dir, Note, TaskItem};

    /// 图片导入复制（v0.33.0）：新图复制、同名同内容复用、同名不同内容加序号、
    /// 非法扩展名拒绝、文件名清洗
    #[test]
    fn copy_image_to_dir_variants() {
        let dir = std::env::temp_dir().join("simpletools_img_import_test");
        let _ = std::fs::remove_dir_all(&dir);
        let src_dir = dir.join("src");
        let img_dir = dir.join("images");
        std::fs::create_dir_all(&src_dir).unwrap();

        // 新图片：复制并返回清洗后的文件名
        let a = src_dir.join("a-photo.png");
        std::fs::write(&a, b"AAA").unwrap();
        let name = copy_image_to_dir(&a, &img_dir).unwrap();
        assert_eq!(name, "a-photo.png");
        assert_eq!(std::fs::read(img_dir.join(&name)).unwrap(), b"AAA");

        // 同名同内容 → 复用（目录中仍只有 1 个文件）
        let name2 = copy_image_to_dir(&a, &img_dir).unwrap();
        assert_eq!(name2, "a-photo.png");
        assert_eq!(std::fs::read_dir(&img_dir).unwrap().count(), 1);

        // 同名不同内容 → 加序号 -2
        std::fs::write(&a, b"BBB").unwrap();
        let name3 = copy_image_to_dir(&a, &img_dir).unwrap();
        assert_eq!(name3, "a-photo-2.png");
        assert_eq!(std::fs::read(img_dir.join(&name3)).unwrap(), b"BBB");

        // 非法扩展名 → 拒绝
        let bad = src_dir.join("evil.exe");
        std::fs::write(&bad, b"X").unwrap();
        assert!(copy_image_to_dir(&bad, &img_dir).is_err());

        // 非法字符清洗（: ? → _；空格保留）
        let weird = src_dir.join("we ird:name?.png");
        std::fs::write(&weird, b"CCC").unwrap();
        let name4 = copy_image_to_dir(&weird, &img_dir).unwrap();
        assert_eq!(name4, "we ird_name_.png");

        let _ = std::fs::remove_dir_all(&dir);
    }

    /// 旧版数据（无 type 字段）反序列化时缺省为 text，保证升级后兼容
    #[test]
    fn legacy_json_defaults_type_to_text() {
        let legacy = r#"[{"id":"n1","title":"t","content":"c","updated_at":1}]"#;
        let notes: Vec<Note> = serde_json::from_str(legacy).expect("旧数据应能解析");
        assert_eq!(notes[0].note_type, "text");
        // 旧数据无 tasks / auto_no 字段：任务列表为空、自动序号缺省开启
        assert!(notes[0].tasks.is_empty());
        assert!(notes[0].auto_no);
    }

    /// 旧版数据缺核心字段（id / title / content / updated_at）时按默认值解析，不导致整文件失败；
    /// 任务子项缺 id 同样兼容（v0.32.0）
    #[test]
    fn legacy_missing_core_fields_parse() {
        let legacy = r#"[{"title":"只有标题"},{"id":"n2","content":"只有内容"}]"#;
        let notes: Vec<Note> = serde_json::from_str(legacy).expect("缺字段旧数据应能解析");
        assert_eq!(notes.len(), 2);
        assert_eq!(notes[0].id, "");
        assert_eq!(notes[0].title, "只有标题");
        assert_eq!(notes[0].content, "");
        assert_eq!(notes[0].updated_at, 0);
        assert_eq!(notes[0].note_type, "text");
        assert_eq!(notes[1].title, "");
        // 任务笔记：任务子项缺 id 按空串解析，其余字段 default 生效
        let task_legacy =
            r#"[{"id":"n1","type":"task","tasks":[{"text":"买牛奶","done":true}],"updated_at":1}]"#;
        let tnotes: Vec<Note> = serde_json::from_str(task_legacy).expect("任务缺 id 应能解析");
        assert_eq!(tnotes[0].tasks.len(), 1);
        assert_eq!(tnotes[0].tasks[0].id, "");
        assert_eq!(tnotes[0].tasks[0].task_kind, "simple");
        assert!(tnotes[0].tasks[0].done);
    }

    /// type 字段以 JSON 键 "type" 序列化，且 md 类型往返一致
    #[test]
    fn note_type_roundtrip() {
        let note = Note {
            id: "n1".into(),
            title: "t".into(),
            content: "c".into(),
            note_type: "md".into(),
            rich: false,
            tasks: Vec::new(),
            auto_no: true,
            updated_at: 1,
        };
        let json = serde_json::to_string(&note).expect("应能序列化");
        assert!(json.contains(r#""type":"md""#));
        // 非任务笔记：tasks 为空与 auto_no 为 true 时不写出，保持旧文件格式干净
        assert!(!json.contains("tasks"));
        assert!(!json.contains("auto_no"));
        let back: Note = serde_json::from_str(&json).expect("应能反序列化");
        assert_eq!(back.note_type, "md");
    }

    /// 任务笔记往返：kind 以 JSON 键 "kind" 序列化；空字段与 false 值不写出；auto_no=false 保留
    #[test]
    fn task_note_roundtrip() {
        let note = Note {
            id: "n1".into(),
            title: "任务组".into(),
            content: String::new(),
            note_type: "task".into(),
            rich: false,
            tasks: vec![
                TaskItem {
                    id: "t1".into(),
                    task_kind: "simple".into(),
                    text: "买牛奶".into(),
                    title: String::new(),
                    content: String::new(),
                    done: true,
                },
                TaskItem {
                    id: "t2".into(),
                    task_kind: "rich".into(),
                    text: String::new(),
                    title: "方案评审".into(),
                    content: "<b>要点</b>".into(),
                    done: false,
                },
            ],
            auto_no: false,
            updated_at: 2,
        };
        let json = serde_json::to_string(&note).expect("应能序列化");
        assert!(json.contains(r#""kind":"rich""#));
        assert!(json.contains(r#""auto_no":false"#));
        // simple 任务不写出空 title / content；rich 任务不写出空 text
        assert!(!json.contains(r#""title":"""#));
        assert!(!json.contains(r#""text":"""#));
        let back: Note = serde_json::from_str(&json).expect("应能反序列化");
        assert_eq!(back.tasks.len(), 2);
        assert_eq!(back.tasks[0].task_kind, "simple");
        assert!(back.tasks[0].done);
        assert_eq!(back.tasks[1].title, "方案评审");
        assert_eq!(back.tasks[1].content, "<b>要点</b>");
        assert!(!back.auto_no);
    }

    /// v0.34.0 普通笔记富文本标记：rich=true 写出、缺省 false 兼容旧数据、false 不写出
    #[test]
    fn rich_note_roundtrip() {
        let note = Note {
            id: "n1".into(),
            title: "笔记".into(),
            content: "<b>要点</b>".into(),
            note_type: "text".into(),
            rich: true,
            tasks: Vec::new(),
            auto_no: true,
            updated_at: 3,
        };
        let json = serde_json::to_string(&note).expect("应能序列化");
        assert!(json.contains(r#""rich":true"#));
        let mut back: Note = serde_json::from_str(&json).expect("应能反序列化");
        assert!(back.rich);
        // 旧数据无 rich 字段：缺省 false（按纯文本，前端加载时转换）
        let legacy: Note =
            serde_json::from_str(r#"{"id":"n2","type":"text","content":"纯文本"}"#).expect("旧数据应能解析");
        assert!(!legacy.rich);
        // rich=false 时不写出该字段，保持旧文件格式干净
        back.rich = false;
        assert!(!serde_json::to_string(&back).expect("应能序列化").contains("rich"));
    }
}
