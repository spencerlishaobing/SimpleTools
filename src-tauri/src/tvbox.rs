use std::time::Duration;

fn http_url(value: &str) -> Result<reqwest::Url, String> {
    let url = reqwest::Url::parse(value).map_err(|_| "网址无效".to_string())?;
    if !matches!(url.scheme(), "http" | "https") {
        return Err("仅支持 HTTP / HTTPS".into());
    }
    Ok(url)
}

#[tauri::command]
pub async fn tvbox_fetch(
    url: String,
    headers: Option<serde_json::Value>,
) -> Result<String, String> {
    let url = http_url(&url)?;
    let client = reqwest::Client::builder()
        .timeout(Duration::from_secs(25))
        .build()
        .map_err(|e| e.to_string())?;
    let mut request = client.get(url);
    if let Some(serde_json::Value::Object(map)) = headers {
        for (key, value) in map {
            request = request.header(key, value.as_str().ok_or("请求头必须是字符串")?);
        }
    }
    let mut response = request
        .send()
        .await
        .map_err(|e| format!("连接失败：{e}"))?
        .error_for_status()
        .map_err(|e| format!("接口错误：{e}"))?;
    let content_type = response
        .headers()
        .get(reqwest::header::CONTENT_TYPE)
        .and_then(|v| v.to_str().ok())
        .unwrap_or("")
        .to_lowercase();
    let mut data = Vec::new();
    while let Some(chunk) = response.chunk().await.map_err(|e| e.to_string())? {
        if data.len() + chunk.len() > 32 * 1024 * 1024 {
            return Err("配置或接口响应超过 32 MB".into());
        }
        data.extend_from_slice(&chunk);
    }
    if data.starts_with(&[0x1f, 0x8b]) {
        use std::io::Read;
        let mut uncompressed = Vec::new();
        flate2::read::GzDecoder::new(&data[..])
            .take(32 * 1024 * 1024 + 1)
            .read_to_end(&mut uncompressed)
            .map_err(|e| format!("GZIP 解压失败：{e}"))?;
        if uncompressed.len() > 32 * 1024 * 1024 {
            return Err("解压后的响应超过 32 MB".into());
        }
        data = uncompressed;
    }
    let charset = content_type
        .split("charset=")
        .nth(1)
        .unwrap_or("utf-8")
        .trim_matches(['\"', '\'', ' '])
        .split(';')
        .next()
        .unwrap_or("utf-8");
    let encoding =
        encoding_rs::Encoding::for_label(charset.as_bytes()).unwrap_or(encoding_rs::UTF_8);
    let (text, _, errors) = encoding.decode(&data);
    if errors {
        return Err(format!("响应字符编码无法识别：{charset}"));
    }
    Ok(text.trim_start_matches('\u{feff}').to_string())
}

#[tauri::command]
pub fn tvbox_load(app: tauri::AppHandle) -> Result<Option<serde_json::Value>, String> {
    let path = crate::datadir::data_dir(&app)?.join("tvbox.json");
    if !path.exists() {
        return Ok(None);
    }
    let bytes = std::fs::read(path).map_err(|e| e.to_string())?;
    serde_json::from_slice(&bytes)
        .map(Some)
        .map_err(|e| format!("TVBOX 数据读取失败：{e}"))
}

#[tauri::command]
pub fn tvbox_save(app: tauri::AppHandle, data: serde_json::Value) -> Result<(), String> {
    if !data.is_object() {
        return Err("TVBOX 数据必须是对象".into());
    }
    let bytes = serde_json::to_vec_pretty(&data).map_err(|e| e.to_string())?;
    if bytes.len() > 16 * 1024 * 1024 {
        return Err("TVBOX 数据超过 16 MB".into());
    }
    let path = crate::datadir::data_dir(&app)?.join("tvbox.json");
    let tmp = path.with_extension("json.tmp");
    std::fs::write(&tmp, bytes).map_err(|e| e.to_string())?;
    std::fs::rename(tmp, path).map_err(|e| e.to_string())
}
