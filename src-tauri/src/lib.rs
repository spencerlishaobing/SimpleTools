mod accounts;
mod datadir;
mod history;
mod md5calc;
mod notes;
mod textfile;
mod titlebar;
mod winsec;

#[cfg_attr(mobile, tauri::mobile_entry_point)]
pub fn run() {
    tauri::Builder::default()
        .plugin(tauri_plugin_clipboard_manager::init())
        .plugin(tauri_plugin_dialog::init())
        .invoke_handler(tauri::generate_handler![
            accounts::accounts_load,
            accounts::accounts_save,
            accounts::accounts_export,
            datadir::data_dir_info,
            datadir::data_dir_set,
            datadir::storage_info,
            datadir::open_in_explorer,
            notes::notes_load,
            notes::notes_save,
            notes::notes_backup,
            notes::notes_export,
            history::history_load,
            history::history_save,
            md5calc::md5_text,
            md5calc::md5_file,
            textfile::read_text_file,
            textfile::write_text_file,
            titlebar::set_titlebar_color,
            winsec::hello_availability,
            winsec::hello_verify
        ])
        .run(tauri::generate_context!())
        .expect("error while running tauri application");
}
