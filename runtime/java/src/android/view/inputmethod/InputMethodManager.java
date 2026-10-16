package android.view.inputmethod;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class InputMethodManager {

    public void hideSoftInputFromWindow(android.os.IBinder windowToken,int flags){}
    public void showSoftInput(android.view.View view,int flags){}
    public static final int SHOW_FORCED=2,SHOW_IMPLICIT=1;
}
