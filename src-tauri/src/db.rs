//! 数据库读取（v0.37.0）：SQLite .db 文件只读查询
//!
//! 用途：打开本地 SQLite 数据库文件（.db / .sqlite / .sqlite3 / .db3 等），以只读方式
//! 执行 SQL 查询并浏览数据；打开时读取 schema（表 / 视图 + 列名与类型），前端据此提供
//! 表名 / 字段名 / SQL 关键字的输入提示，帮助快速编写语句。
//!
//! 说明：
//! - 只读打开（SQLITE_OPEN_READ_ONLY）：写操作（INSERT / UPDATE / DELETE / CREATE 等）
//!   会被 SQLite 拒绝（attempt to write a readonly database），保证原文件不被修改
//! - 每次查询按路径重新打开连接（SQLite 打开开销极小），不持有长期句柄
//! - 查询结果最多返回 5000 行（超出截断并标记），单元格文本超长截断，BLOB 以占位显示

use rusqlite::{types::ValueRef, Connection, OpenFlags};
use serde::Serialize;
use serde_json::Value as JsonValue;
use std::{
    fs,
    path::{Path, PathBuf},
    time::Instant,
};

/// 查询结果最多返回的行数（超出截断并在结果中标记）
const MAX_ROWS: usize = 5000;
/// 单个单元格文本最长保留的字符数（超出截断）
const CELL_MAX: usize = 4096;

// ---------------------------------------------------------------------------
// 数据模型
// ---------------------------------------------------------------------------

/// 表的列信息
#[derive(Debug, Clone, Serialize)]
pub struct DbColumn {
    pub name: String,
    /// 声明类型（CREATE TABLE 中的类型，可能为空）
    pub decl_type: String,
    /// 是否主键
    pub pk: bool,
}

/// 表 / 视图信息
#[derive(Debug, Clone, Serialize)]
pub struct DbTable {
    pub name: String,
    /// table / view
    pub kind: String,
    pub columns: Vec<DbColumn>,
}

/// 打开结果（文件信息 + schema，供表结构浏览与输入提示）
#[derive(Debug, Clone, Serialize)]
pub struct DbInfo {
    pub path: String,
    pub name: String,
    pub size: u64,
    pub tables: Vec<DbTable>,
}

/// 查询结果（v0.41.0 分页：每页行数 / 页码 / 总行数；paged=false 时返回全部行）
#[derive(Debug, Clone, Serialize)]
pub struct DbQueryResult {
    pub columns: Vec<String>,
    pub rows: Vec<Vec<JsonValue>>,
    /// 当前页码（1 起；paged=false 时为 1）
    pub page: u32,
    /// 每页行数（paged=false 时为 0）
    pub page_size: u32,
    /// 符合查询条件的总行数（分页模式）
    pub total: u64,
    /// 是否分页模式（false = 原样执行回退：PRAGMA 等无法包装子查询的语句）
    pub paged: bool,
    /// 非分页模式下超上限截断
    pub truncated: bool,
    pub elapsed_ms: u64,
}

// ---------------------------------------------------------------------------
// 打开与 schema 读取
// ---------------------------------------------------------------------------

/// 只读打开数据库（文件不存在 / 非 SQLite 格式时给出友好提示）
/// 注意：SQLite 对文件头是惰性验证（打开时不一定报错，首次查询才暴露），
/// 这里主动校验 SQLite 文件头魔术字节，打开阶段即拦截非 SQLite 文件
fn open_ro(path: &Path) -> Result<Connection, String> {
    if !path.is_file() {
        return Err("文件不存在".into());
    }
    use std::io::Read;
    let mut head = [0u8; 16];
    let mut f = fs::File::open(path).map_err(|e| format!("无法读取文件：{e}"))?;
    let n = f.read(&mut head).unwrap_or(0);
    if n < 16 || &head[..15] != b"SQLite format 3" {
        return Err("该文件不是有效的 SQLite 数据库（支持 .db / .sqlite / .sqlite3 / .db3）".into());
    }
    Connection::open_with_flags(path, OpenFlags::SQLITE_OPEN_READ_ONLY).map_err(|e| {
        let msg = e.to_string();
        if msg.contains("file is encrypted") {
            "该数据库已加密，暂不支持打开".into()
        } else {
            format!("无法打开数据库：{msg}")
        }
    })
}

/// 读取单表的列信息（PRAGMA table_info；表名转义防注入）
fn table_columns(conn: &Connection, table: &str) -> Result<Vec<DbColumn>, String> {
    let safe = table.replace('"', "\"\"");
    let sql = format!("PRAGMA table_info(\"{safe}\")");
    let mut stmt = conn
        .prepare(&sql)
        .map_err(|e| format!("读取表结构失败：{e}"))?;
    let cols = stmt
        .query_map([], |r| {
            Ok(DbColumn {
                name: r.get::<_, String>(1)?,
                decl_type: r.get::<_, Option<String>>(2)?.unwrap_or_default(),
                pk: r.get::<_, i64>(5).unwrap_or(0) != 0,
            })
        })
        .map_err(|e| format!("读取表结构失败：{e}"))?
        .collect::<Result<Vec<_>, _>>()
        .map_err(|e| format!("读取表结构失败：{e}"))?;
    Ok(cols)
}

/// 读取 schema：全部表与视图（跳过 sqlite_ 系统表）及其列信息
fn read_schema(conn: &Connection) -> Result<Vec<DbTable>, String> {
    let mut stmt = conn
        .prepare(
            "SELECT name, type FROM sqlite_master \
             WHERE type IN ('table', 'view') AND name NOT LIKE 'sqlite_%' \
             ORDER BY type, name",
        )
        .map_err(|e| format!("读取数据库结构失败：{e}"))?;
    let list = stmt
        .query_map([], |r| Ok((r.get::<_, String>(0)?, r.get::<_, String>(1)?)))
        .map_err(|e| format!("读取数据库结构失败：{e}"))?
        .collect::<Result<Vec<_>, _>>()
        .map_err(|e| format!("读取数据库结构失败：{e}"))?;
    let mut tables = Vec::with_capacity(list.len());
    for (name, kind) in list {
        let columns = table_columns(conn, &name)?;
        tables.push(DbTable {
            name,
            kind,
            columns,
        });
    }
    Ok(tables)
}

// ---------------------------------------------------------------------------
// 查询执行
// ---------------------------------------------------------------------------

/// 单元格值 → JSON：NULL / 数字 / 文本（超长截断）；BLOB 以字节数占位
fn value_to_json(v: ValueRef<'_>) -> JsonValue {
    match v {
        ValueRef::Null => JsonValue::Null,
        ValueRef::Integer(i) => JsonValue::from(i),
        ValueRef::Real(f) => JsonValue::from(f),
        ValueRef::Text(t) => {
            let s = String::from_utf8_lossy(t);
            if s.chars().count() > CELL_MAX {
                JsonValue::String(s.chars().take(CELL_MAX).collect::<String>() + "…[截断]")
            } else {
                JsonValue::String(s.into_owned())
            }
        }
        ValueRef::Blob(b) => JsonValue::String(format!("[BLOB {} 字节]", b.len())),
    }
}

/// SQL 错误 → 友好提示（只读拒绝 / 语法错误分别说明）
fn friendly_sql_error(e: &rusqlite::Error) -> String {
    let msg = e.to_string();
    if msg.contains("readonly database") {
        "只读模式：仅支持查询语句（SELECT / PRAGMA 等），无法修改数据库文件".into()
    } else if msg.contains("no such table") {
        format!("表不存在：{msg}")
    } else if msg.contains("no such column") {
        format!("字段不存在：{msg}")
    } else {
        format!("SQL 执行错误：{msg}")
    }
}

/// 分页执行：包装子查询取总数与当前页（返回 Err 表示不支持分页包装，由调用方回退原样执行）
fn run_paged(
    conn: &Connection,
    body: &str,
    page: u32,
    page_size: u32,
) -> Result<(u64, Vec<String>, Vec<Vec<JsonValue>>), String> {
    let total: u64 = conn
        .query_row(&format!("SELECT COUNT(*) FROM ({body})"), [], |r| {
            r.get::<_, i64>(0)
        })
        .map(|n| n.max(0) as u64)
        .map_err(|e| friendly_sql_error(&e))?;
    let offset = (page.saturating_sub(1) as u64) * page_size as u64;
    let page_sql = format!("SELECT * FROM ({body}) LIMIT {page_size} OFFSET {offset}");
    let mut stmt = conn.prepare(&page_sql).map_err(|e| friendly_sql_error(&e))?;
    let columns: Vec<String> = stmt.column_names().iter().map(|s| s.to_string()).collect();
    let col_count = stmt.column_count();
    let mut rows_out: Vec<Vec<JsonValue>> = Vec::new();
    {
        let mut rows = stmt.query([]).map_err(|e| friendly_sql_error(&e))?;
        while let Some(row) = rows.next().map_err(|e| friendly_sql_error(&e))? {
            let mut rec = Vec::with_capacity(col_count);
            for i in 0..col_count {
                let v = row.get_ref(i).map_err(|e| friendly_sql_error(&e))?;
                rec.push(value_to_json(v));
            }
            rows_out.push(rec);
        }
    }
    Ok((total, columns, rows_out))
}

/// 原样执行（无分页；超 MAX_ROWS 截断）——供 PRAGMA 等无法包装子查询的语句回退使用
fn run_plain(
    conn: &Connection,
    sql: &str,
) -> Result<(Vec<String>, Vec<Vec<JsonValue>>, bool), String> {
    let mut stmt = conn.prepare(sql).map_err(|e| friendly_sql_error(&e))?;
    let columns: Vec<String> = stmt.column_names().iter().map(|s| s.to_string()).collect();
    let col_count = stmt.column_count();
    let mut rows_out: Vec<Vec<JsonValue>> = Vec::new();
    let mut truncated = false;
    {
        let mut rows = stmt.query([]).map_err(|e| friendly_sql_error(&e))?;
        while let Some(row) = rows.next().map_err(|e| friendly_sql_error(&e))? {
            if rows_out.len() >= MAX_ROWS {
                truncated = true;
                break;
            }
            let mut rec = Vec::with_capacity(col_count);
            for i in 0..col_count {
                let v = row.get_ref(i).map_err(|e| friendly_sql_error(&e))?;
                rec.push(value_to_json(v));
            }
            rows_out.push(rec);
        }
    }
    Ok((columns, rows_out, truncated))
}

// ---------------------------------------------------------------------------
// Tauri 命令
// ---------------------------------------------------------------------------

/// 打开数据库文件（只读）：返回文件信息与 schema
#[tauri::command]
pub fn db_open(path: String) -> Result<DbInfo, String> {
    let p = PathBuf::from(path.trim());
    let conn = open_ro(&p)?;
    let tables = read_schema(&conn)?;
    let size = fs::metadata(&p).map(|m| m.len()).unwrap_or(0);
    Ok(DbInfo {
        path: crate::datadir::display_path(&p),
        name: p
            .file_name()
            .map(|s| s.to_string_lossy().to_string())
            .unwrap_or_default(),
        size,
        tables,
    })
}

/// 执行 SQL 查询（只读连接；分页模式返回当前页与总数，每页 1-2000 行）
#[tauri::command]
pub fn db_query(
    path: String,
    sql: String,
    page: u32,
    size: u32,
) -> Result<DbQueryResult, String> {
    let sql = sql.trim().to_string();
    if sql.is_empty() {
        return Err("请输入 SQL 语句".into());
    }
    let page = page.max(1);
    let size = size.clamp(1, 2000);
    let p = PathBuf::from(path.trim());
    let conn = open_ro(&p)?;
    let start = Instant::now();
    // 包装子查询用的语句体（去尾分号）
    let body = sql.trim_end_matches(';').trim().to_string();

    // 分页模式：包装子查询取总数与当前页；包装失败（PRAGMA 等）回退为原样执行
    if let Ok((total, columns, rows)) = run_paged(&conn, &body, page, size) {
        return Ok(DbQueryResult {
            columns,
            rows,
            page,
            page_size: size,
            total,
            paged: true,
            truncated: false,
            elapsed_ms: start.elapsed().as_millis() as u64,
        });
    }

    // 回退：原样执行（无分页，上限 5000 行）
    let (columns, rows, truncated) = run_plain(&conn, &sql)?;
    Ok(DbQueryResult {
        columns,
        rows,
        page: 1,
        page_size: 0,
        total: 0,
        paged: false,
        truncated,
        elapsed_ms: start.elapsed().as_millis() as u64,
    })
}

// ---------------------------------------------------------------------------
// 单元测试
// ---------------------------------------------------------------------------

#[cfg(test)]
mod tests {
    use super::{db_open, db_query, read_schema, Connection};
    use std::fs;

    /// 创建临时测试数据库（可写），返回路径
    fn make_test_db(name: &str) -> std::path::PathBuf {
        let p = std::env::temp_dir().join(format!("simpletools_db_test_{name}.db"));
        let _ = fs::remove_file(&p);
        let conn = Connection::open(&p).expect("创建测试库");
        conn.execute_batch(
            "CREATE TABLE users (id INTEGER PRIMARY KEY, name TEXT NOT NULL, age INTEGER);
             CREATE TABLE orders (oid INTEGER PRIMARY KEY, amount REAL, user_id INTEGER, note BLOB);
             INSERT INTO users (id, name, age) VALUES (1, '张三', 25), (2, '李四', 30);
             INSERT INTO orders (oid, amount, user_id) VALUES (10, 9.5, 1);
             CREATE VIEW v_users AS SELECT name FROM users;",
        )
        .expect("建表插数据");
        p
    }

    /// 打开数据库：schema 包含表与视图、列名 / 类型 / 主键与列数正确
    #[test]
    fn open_reads_schema() {
        let p = make_test_db("schema");
        let info = db_open(p.to_string_lossy().to_string()).expect("应能打开");
        assert!(info.name.ends_with(".db"));
        assert_eq!(info.tables.len(), 3, "2 张表 + 1 个视图");
        let users = info.tables.iter().find(|t| t.name == "users").unwrap();
        assert_eq!(users.kind, "table");
        assert_eq!(users.columns.len(), 3);
        assert_eq!(users.columns[0].name, "id");
        assert!(users.columns[0].pk, "id 应为主键");
        assert_eq!(users.columns[1].decl_type, "TEXT");
        let view = info.tables.iter().find(|t| t.name == "v_users").unwrap();
        assert_eq!(view.kind, "view");
        let _ = fs::remove_file(&p);
    }

    /// 查询：返回列名与行数据（NULL / 数字 / 文本类型正确；默认分页模式）
    #[test]
    fn query_returns_rows() {
        let p = make_test_db("query");
        let path = p.to_string_lossy().to_string();
        let res = db_query(
            path.clone(),
            "SELECT id, name, age FROM users ORDER BY id".into(),
            1,
            100,
        )
        .expect("查询应成功");
        assert_eq!(res.columns, vec!["id", "name", "age"]);
        assert!(res.paged, "SELECT 应为分页模式");
        assert_eq!(res.total, 2);
        assert_eq!(res.page, 1);
        assert_eq!(res.rows.len(), 2);
        assert_eq!(res.rows[0][0], serde_json::json!(1));
        assert_eq!(res.rows[0][1], serde_json::json!("张三"));
        // NULL 值（orders.note 未插入）
        let res2 = db_query(path, "SELECT note FROM orders".into(), 1, 100).expect("查询应成功");
        assert_eq!(res2.rows[0][0], serde_json::Value::Null);
        let _ = fs::remove_file(&p);
    }

    /// 分页：总数 / 页切分 / 越界页返回空 / PRAGMA 回退为非分页
    #[test]
    fn query_pagination() {
        let p = make_test_db("paging");
        let path = p.to_string_lossy().to_string();
        {
            let conn = Connection::open(&p).unwrap();
            conn.execute_batch("CREATE TABLE nums (n INTEGER);").unwrap();
            for i in 1..=250 {
                conn.execute("INSERT INTO nums (n) VALUES (?1)", [i]).unwrap();
            }
        }
        // 第一页
        let p1 = db_query(path.clone(), "SELECT n FROM nums ORDER BY n".into(), 1, 100).unwrap();
        assert!(p1.paged);
        assert_eq!(p1.total, 250);
        assert_eq!(p1.rows.len(), 100);
        assert_eq!(p1.rows[0][0], serde_json::json!(1));
        // 第三页（尾页 50 行）
        let p3 = db_query(path.clone(), "SELECT n FROM nums ORDER BY n".into(), 3, 100).unwrap();
        assert_eq!(p3.rows.len(), 50);
        assert_eq!(p3.rows[0][0], serde_json::json!(201));
        // 越界页：空行但总数正确
        let p9 = db_query(path.clone(), "SELECT n FROM nums ORDER BY n".into(), 9, 100).unwrap();
        assert_eq!(p9.rows.len(), 0);
        assert_eq!(p9.total, 250);
        // PRAGMA：无法包装子查询 → 回退为非分页原样执行
        let pr = db_query(path.clone(), "PRAGMA table_info(\"nums\")".into(), 1, 100).unwrap();
        assert!(!pr.paged);
        assert_eq!(pr.rows.len(), 1);
        let _ = fs::remove_file(&p);
    }

    /// 只读保护：写操作被拒绝且给出只读提示
    #[test]
    fn write_rejected_readonly() {
        let p = make_test_db("readonly");
        let path = p.to_string_lossy().to_string();
        let err = db_query(path.clone(), "UPDATE users SET age = 1".into(), 1, 100).unwrap_err();
        assert!(err.contains("只读") || err.contains("readonly"), "错误应提示只读：{err}");
        // 原始数据未被修改
        let res = db_query(path, "SELECT age FROM users WHERE id = 1".into(), 1, 100).unwrap();
        assert_eq!(res.rows[0][0], serde_json::json!(25));
        let _ = fs::remove_file(&p);
    }

    /// 非 SQLite 文件打开报错（友好提示）
    #[test]
    fn open_non_db_rejected() {
        let p = std::env::temp_dir().join("simpletools_db_test_notdb.db");
        fs::write(&p, b"this is not a sqlite file at all").unwrap();
        let err = db_open(p.to_string_lossy().to_string()).unwrap_err();
        assert!(err.contains("不是有效的 SQLite"), "应提示非 SQLite 文件：{err}");
        let _ = fs::remove_file(&p);
    }

    /// schema 读取：忽略 sqlite_ 系统表
    #[test]
    fn schema_skips_system_tables() {
        let p = make_test_db("sys");
        let conn = Connection::open(&p).unwrap();
        // WITHOUT ROWID 等场景会生成 sqlite_ 内部表（这里手动建一个带 autoincrement 的表触发）
        conn.execute_batch(
            "CREATE TABLE seq_test (id INTEGER PRIMARY KEY AUTOINCREMENT, v TEXT);
             INSERT INTO seq_test (v) VALUES ('a');",
        )
        .unwrap();
        let tables = read_schema(&conn).unwrap();
        assert!(tables.iter().all(|t| !t.name.starts_with("sqlite_")));
        let _ = fs::remove_file(&p);
    }
}
