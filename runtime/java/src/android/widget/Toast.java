package android.widget;
import android.content.Context;
/** 桌面端提示桩：片源失败提示与部分自定义 UI 调用会走到这里，静默吞掉即可。 */
public class Toast {
    public static final int LENGTH_SHORT=0;
    public static final int LENGTH_LONG=1;
    private static final Toast INSTANCE=new Toast();
    public static Toast makeText(Context context,CharSequence text,int duration){return INSTANCE;}
    public static Toast makeText(Context context,int resId,int duration){return INSTANCE;}
    public void show(){}
    public void cancel(){}
    public void setDuration(int duration){}
    public void setText(CharSequence text){}
}
