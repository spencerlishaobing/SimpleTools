package android.database;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实数据库游标。 */
public interface Cursor {
    int getCount();
    int getPosition();
    boolean moveToFirst();
    boolean moveToNext();
    boolean moveToPosition(int position);
    int getColumnIndex(String columnName);
    int getColumnIndexOrThrow(String columnName);
    String getColumnName(int columnIndex);
    String getString(int columnIndex);
    int getInt(int columnIndex);
    long getLong(int columnIndex);
    float getFloat(int columnIndex);
    double getDouble(int columnIndex);
    byte[] getBlob(int columnIndex);
    boolean isNull(int columnIndex);
    boolean isClosed();
    void close();
}
