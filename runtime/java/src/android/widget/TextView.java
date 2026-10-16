package android.widget;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class TextView extends android.view.View {

    public TextView(){}
    public TextView(android.content.Context context){}
    public void setText(CharSequence text){}
    public CharSequence getText(){return "";}
    public void setTextColor(int color){}
    public void setTextSize(float size){}
    public void setGravity(int gravity){}
    public void setBackgroundColor(int color){}
    public void setPadding(int l,int t,int r,int b){}
    public void setLayoutParams(android.view.ViewGroup.LayoutParams params){}
    public void setSingleLine(boolean singleLine){}
    public void setMaxLines(int maxlines){}
    public void setEllipsize(android.text.TextUtils.TruncateAt where){}
    public void setTextIsSelectable(boolean selectable){}
}
