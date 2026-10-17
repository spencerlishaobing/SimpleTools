mod accounts;
mod backup;
mod capture;
mod datadir;
mod db;
mod history;
mod md5calc;
mod mock;
mod notes;
mod textfile;
mod titlebar;
mod tvbox;
mod tvexternal;
mod tvremote;
mod tvplayer;
mod tvp2p;
mod tvsniff;
mod tvspider;
mod update;
mod winsec;

use tauri::Manager;

#[cfg_attr(mobile, tauri::mobile_entry_point)]
pub fn run() {
    tauri::Builder::default()
        // 单实例限制（v0.52.0）：重复启动时聚焦已有窗口（必须第一个注册）
        .plugin(tauri_plugin_single_instance::init(|app, _args, _cwd| {
            if let Some(w) = app.get_webview_window("main") {
                let _ = w.show();
                let _ = w.unminimize();
                let _ = w.set_focus();
            }
        }))
        .plugin(tauri_plugin_clipboard_manager::init())
        .plugin(tauri_plugin_dialog::init())
        .manage(capture::CaptureState::default())
        .manage(mock::MockState::default())
        .manage(tvplayer::PlayerState::default())
        .manage(tvplayer::SurfaceState::default())
        .manage(tvp2p::P2pState::default())
        .manage(tvremote::RemoteState::default())
        .manage(tvexternal::ExternalState::default())
        .setup(|app| {
            // 模拟服务器：启动时载入已保存的接口规则（数据目录 mock-rules.json）
            mock::init_load(app.handle());
            // 抓包诊断（v0.50.0）：安装 tracing 捕获层（hudsucker 警告 / 错误 → 诊断列表）
            capture::init_diag(app.handle().clone());
            // v0.54.0：启动防白闪——窗口初始隐藏（tauri.conf visible:false），
            // 按已保存主题设置窗口底色后再显示，首帧即为主题色
            let theme = datadir::boot_theme(app.handle());
            let (r, g, b) = match theme.as_str() {
                "dark" => (15u8, 23u8, 42u8), // #0f172a
                "khaki" => (15, 14, 12),      // #0f0e0c
                _ => (246, 247, 249),         // light / mix #f6f7f9
            };
            if let Some(w) = app.get_webview_window("main") {
                let _ = w.set_background_color(Some(tauri::window::Color(r, g, b, 255)));
                let _ = w.show();
            }
            Ok(())
        })
        .invoke_handler(|invoke| {
            // External parser pages must never access application commands or local data.
            if invoke.message.webview().label() != "main" {
                invoke.resolver.reject("此窗口无权调用应用命令");
                return true;
            }
            let handler: fn(tauri::ipc::Invoke<tauri::Wry>) -> bool = tauri::generate_handler![
                accounts::accounts_load,
                accounts::accounts_save,
                accounts::accounts_export,
                datadir::data_dir_info,
                datadir::data_dir_set,
                datadir::app_set_theme,
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
                capture::capture_export_ca,
                capture::capture_diag_list,
                capture::capture_diag_clear,
                mock::mock_info,
                mock::mock_start,
                mock::mock_stop,
                mock::mock_rules,
                mock::mock_rule_add,
                mock::mock_rule_delete,
                mock::mock_requests,
                mock::mock_request_detail,
                mock::mock_clear_requests,
                mock::mock_public_retry,
                db::db_open,
                db::db_query,
                tvremote::tvbox_remote_start,
                tvremote::tvbox_remote_stop,
                tvexternal::tvbox_external,
                tvexternal::tvbox_external_stop,
                tvexternal::tvbox_external_warm,
                tvexternal::tvspiders_registry,
                tvexternal::tvbox_live_builtin,
                tvbox::tvbox_fetch,
                tvbox::tvbox_load,
                tvbox::tvbox_save,
                tvbox::tvbox_image,
                tvbox::tvbox_hot_list,
                tvspider::tvbox_spider,
                tvsniff::tvbox_sniff,
                tvplayer::tvplayer_play,
                tvplayer::tvplayer_surface,
                tvplayer::tvplayer_surface_hide,
                tvplayer::tvplayer_control,
                tvplayer::tvplayer_status,
                tvp2p::tvbox_prepare_media,
                tvp2p::tvbox_cancel_p2p,
                update::update_check,
                update::update_download,
                update::update_install
            ];
            handler(invoke)
        })
        .run(tauri::generate_context!())
        .expect("error while running tauri application");
}
