package android.provider;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实系统设置。 */
public class Settings {
    public static final String ACTION_SETTINGS="android.settings.SETTINGS";
    public static class Secure {
        public static final String ANDROID_ID="android_id";
        public static String getString(android.content.ContentResolver cr,String name){return null;}
        public static int getInt(android.content.ContentResolver cr,String name,int def){return def;}
    }
}
