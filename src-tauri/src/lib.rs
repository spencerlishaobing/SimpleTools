mod accounts;
mod backup;
mod capture;
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
        .manage(capture::CaptureState::default())
        .invoke_handler(tauri::generate_handler![
            accounts::accounts_load,
            accounts::accounts_save,
            accounts::accounts_export,
            datadir::data_dir_info,
            datadir::data_dir_set,
            datadir::storage_info,
            datadir::open_in_explorer,
            backup::data_export,
            backup::data_import,
            backup::data_import_prepare,
            backup::data_merge_write,
            backup::data_backup_list,
            backup::data_restore,
            notes::notes_load,
            notes::notes_save,
            notes::notes_backup,
            notes::notes_export,
            notes::note_image_import,
            history::history_load,
            history::history_save,
            md5calc::md5_text,
            md5calc::md5_file,
            textfile::read_text_file,
            textfile::write_text_file,
            titlebar::set_titlebar_color,
            titlebar::set_window_icon,
            winsec::hello_availability,
            winsec::hello_verify,
            capture::capture_info,
            capture::capture_start,
            capture::capture_stop,
            capture::capture_list,
            capture::capture_detail,
            capture::capture_clear,
            capture::capture_export_ca
        ])
        .run(tauri::generate_context!())
        .expect("error while running tauri application");
}
