package android.database;
/** 桌面 Android 兼容层桩：数据库错误回调在桌面端无真实实现。 */
public interface DatabaseErrorHandler {
    void onCorruption(android.database.sqlite.SQLiteDatabase dbObj);
}
