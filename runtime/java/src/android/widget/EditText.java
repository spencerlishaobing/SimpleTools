package android.widget;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class EditText extends TextView {

    public EditText(){}
    public EditText(android.content.Context context){}
    public void setText(CharSequence text){}
    public CharSequence getText(){return "";}
    public void setHint(CharSequence hint){}
    public void setSelection(int index){}
}
