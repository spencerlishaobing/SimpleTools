package android.app;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class Dialog {

    public Dialog(){}
    public Dialog(android.content.Context context){}
    public void show(){}
    public void dismiss(){}
    public void cancel(){}
    public boolean isShowing(){return false;}
    public void setTitle(CharSequence title){}
    public void setCancelable(boolean flag){}
}
