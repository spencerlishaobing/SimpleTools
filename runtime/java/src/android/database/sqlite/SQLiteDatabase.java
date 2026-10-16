package android.database.sqlite;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class SQLiteDatabase extends SQLiteClosable {

    public static SQLiteDatabase openOrCreateDatabase(String path,android.database.sqlite.SQLiteDatabase.CursorFactory factory){return new SQLiteDatabase();}
    public static SQLiteDatabase openDatabase(String path,CursorFactory factory,int flags){return openOrCreateDatabase(path,factory);}
    public static SQLiteDatabase openDatabase(String path,CursorFactory factory,int flags,android.database.DatabaseErrorHandler errorHandler){return openOrCreateDatabase(path,factory);}
    public static boolean deleteDatabase(java.io.File file){return file!=null&&file.delete();}
    public int getVersion(){return 0;}
    public void setVersion(int version){}
    public void beginTransaction(){}
    public void setTransactionSuccessful(){}
    public void endTransaction(){}
    public String getPath(){return null;}
    public boolean isReadOnly(){return false;}
    public boolean isDbLockedByCurrentThread(){return false;}
    public interface CursorFactory {android.database.Cursor newCursor(android.database.sqlite.SQLiteDatabase db,String masterQuery,String editTable,java.util.List<String> bindArgs);}
    public void execSQL(String sql){}
    public void execSQL(String sql,Object[] bindArgs){}
    public long insert(String table,String nullColumnHack,android.content.ContentValues values){return -1;}
    public android.database.Cursor rawQuery(String sql,String[] selectionArgs){return new EmptyCursor();}
    public android.database.Cursor query(String table,String[] columns,String selection,String[] selectionArgs,String groupBy,String having,String orderBy){return new EmptyCursor();}
    /** 空游标：本地缓存表尚未创建时按 Android 习惯返回空结果而不是 null，避免片源初始化抛 NPE 日志。 */
    private static final class EmptyCursor implements android.database.Cursor {
        public int getCount(){return 0;}public int getPosition(){return 0;}
        public boolean moveToFirst(){return false;}public boolean moveToNext(){return false;}public boolean moveToPosition(int p){return false;}
        public int getColumnIndex(String c){return -1;}public int getColumnIndexOrThrow(String c){return -1;}
        public String getColumnName(int i){return null;}
        public String getString(int i){return null;}public int getInt(int i){return 0;}public long getLong(int i){return 0;}
        public float getFloat(int i){return 0f;}public double getDouble(int i){return 0d;}public byte[] getBlob(int i){return null;}
        public boolean isNull(int i){return true;}public boolean isClosed(){return false;}public void close(){}
    }
    public int delete(String table,String whereClause,String[] whereArgs){return 0;}
    public int update(String table,android.content.ContentValues values,String whereClause,String[] whereArgs){return 0;}
    public void close(){}
    public boolean isOpen(){return false;}
}
