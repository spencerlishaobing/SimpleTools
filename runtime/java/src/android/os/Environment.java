package android.os;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class Environment {

    public static java.io.File getExternalStorageDirectory(){return new java.io.File(System.getProperty("java.io.tmpdir",".tmp"));}
    public static String getExternalStorageState(){return "mounted";}
    public static java.io.File getDataDirectory(){return new java.io.File(System.getProperty("java.io.tmpdir",".tmp"));}
}
