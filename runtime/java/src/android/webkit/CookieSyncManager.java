package android.webkit;

/** 桌面兼容层：CookieSyncManager（旧 API，网盘 JAR 偶尔引用，空实现即可） */
public class CookieSyncManager {
    private static final CookieSyncManager INSTANCE = new CookieSyncManager();

    public static CookieSyncManager createInstance(android.content.Context context) { return INSTANCE; }
    public static CookieSyncManager getInstance() { return INSTANCE; }
    public void sync() { CookieManager.getInstance().flush(); }
    public void startSync() { }
    public void stopSync() { }
    public void resetSync() { }
}
