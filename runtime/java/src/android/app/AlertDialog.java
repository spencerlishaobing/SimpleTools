package android.app;
/** 桌面 Android 兼容层桩：满足外置片源的类链接与验证，桌面端无真实窗口服务实现。 */
public class AlertDialog extends Dialog {
    private final String title;
    private final String message;
    private final String view;

    public AlertDialog(){this(null,null,null);}
    public AlertDialog(String title,String message,String view){this.title=title;this.message=message;this.view=view;}

    /** Builder 为 UI 路径调用方准备的最小形态：桌面端 create/show 均替换为探测日志。 */
    public static class Builder {
        private String title="";
        private String message="";
        private String view="";
        public Builder(android.content.Context context){}
        public Builder setTitle(CharSequence title){this.title=title==null?"":title.toString();return this;}
        public Builder setTitle(int titleId){return this;}
        public Builder setMessage(CharSequence message){this.message=message==null?"":message.toString();return this;}
        public Builder setPositiveButton(CharSequence text,android.content.DialogInterface.OnClickListener listener){return this;}
        public Builder setNegativeButton(CharSequence text,android.content.DialogInterface.OnClickListener listener){return this;}
        public Builder setNeutralButton(CharSequence text,android.content.DialogInterface.OnClickListener listener){return this;}
        public Builder setCancelable(boolean cancelable){return this;}
        public Builder setView(android.view.View view){this.view=view==null?"":view.toString();return this;}
        public Builder setIcon(int iconId){return this;}
        public AlertDialog create(){return new AlertDialog(title,message,view);}
        public AlertDialog show(){
            probe("AlertDialog.show","title="+title+" | message="+message+" | view="+view);
            return create();
        }
    }

    public void show(){probe("AlertDialog(instance).show","title="+title+" | message="+message+" | view="+view);}
}
