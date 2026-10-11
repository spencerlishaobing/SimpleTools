mod md5calc;
mod notes;

#[cfg_attr(mobile, tauri::mobile_entry_point)]
pub fn run() {
    tauri::Builder::default()
        .plugin(tauri_plugin_clipboard_manager::init())
        .plugin(tauri_plugin_dialog::init())
        .invoke_handler(tauri::generate_handler![
            notes::notes_load,
            notes::notes_save,
            notes::notes_backup,
            md5calc::md5_text,
            md5calc::md5_file
        ])
        .run(tauri::generate_context!())
        .expect("error while running tauri application");
}
