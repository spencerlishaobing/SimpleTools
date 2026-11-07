package android.widget;
import android.content.Context;
/** 桌面端提示桩：片源失败提示与部分自定义 UI 调用会走到这里，记录内容便于诊断。 */
public class Toast {
    public static final int LENGTH_SHORT=0;
    public static final int LENGTH_LONG=1;
    private CharSequence text="";

    public static Toast makeText(Context context,CharSequence text,int duration){
        Toast t=new Toast();
        t.text=text;
        try{System.err.println("[UI-PROBE] Toast.makeText text="+(text==null?"":String.valueOf(text)));}catch(Throwable ignored){}
        return t;
    }
    public static Toast makeText(Context context,int resId,int duration){return new Toast();}
    public void show(){
        try{System.err.println("[UI-PROBE] Toast.show text="+(text==null?"":String.valueOf(text)));}catch(Throwable ignored){}
    }
    public void cancel(){}
    public void setDuration(int duration){}
    public void setText(CharSequence text){this.text=text;}
}
