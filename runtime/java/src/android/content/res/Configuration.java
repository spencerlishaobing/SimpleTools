package android.content.res;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class Configuration {

    public static final int ORIENTATION_PORTRAIT=1,ORIENTATION_LANDSCAPE=2;
    public int orientation=ORIENTATION_PORTRAIT;
    public int screenWidthDp=1280,screenHeightDp=720;
    public int densityDpi=160;
}
