package android.widget;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实布局。 */
public class FrameLayout extends android.view.ViewGroup {
    public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams {
        public int gravity;
        public LayoutParams(){}
        public LayoutParams(int width,int height){super(width,height);}
        public LayoutParams(android.view.ViewGroup.LayoutParams source){super(source);}
    }
    public FrameLayout(){}
    public FrameLayout(android.content.Context context){}
    public void setPadding(int l,int t,int r,int b){}
    public void setBackgroundColor(int color){}
    public void setLayoutParams(android.view.ViewGroup.LayoutParams params){}
}
