package android.app;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class AlertDialog extends Dialog {

    /** Builder 为 UI 路径调用方准备的最小形态：桌面端 create/show 均替身为空实现。 */
    public static class Builder {
        public Builder(android.content.Context context){}
        public Builder setTitle(CharSequence title){return this;}
        public Builder setTitle(int titleId){return this;}
        public Builder setMessage(CharSequence message){return this;}
        public Builder setPositiveButton(CharSequence text,android.content.DialogInterface.OnClickListener listener){return this;}
        public Builder setNegativeButton(CharSequence text,android.content.DialogInterface.OnClickListener listener){return this;}
        public Builder setNeutralButton(CharSequence text,android.content.DialogInterface.OnClickListener listener){return this;}
        public Builder setCancelable(boolean cancelable){return this;}
        public Builder setView(android.view.View view){return this;}
        public Builder setIcon(int iconId){return this;}
        public AlertDialog create(){return new AlertDialog();}
        public AlertDialog show(){return create();}
    }
}
