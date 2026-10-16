package android.util;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class DisplayMetrics {

    public int widthPixels=1280,heightPixels=720,densityDpi=160;
    public float density=1f,scaledDensity=1f,xdpi=160f,ydpi=160f;
    public void setToDefaults(){}
}
