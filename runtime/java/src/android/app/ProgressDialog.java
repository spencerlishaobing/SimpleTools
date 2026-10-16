package android.app;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class ProgressDialog extends AlertDialog {

    public static ProgressDialog show(android.content.Context context,CharSequence title,CharSequence message){return new ProgressDialog();}
    public void setMessage(CharSequence message){}
    public void setProgress(int value){}
    public void setMax(int max){}
    public void setIndeterminate(boolean indeterminate){}
}
