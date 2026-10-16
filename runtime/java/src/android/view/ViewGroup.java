package android.view;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实布局。 */
public class ViewGroup extends View {
    public static class LayoutParams {
        public int width,height;
        public LayoutParams(){}
        public LayoutParams(int width,int height){this.width=width;this.height=height;}
    }
    public static class MarginLayoutParams extends LayoutParams {
        public int leftMargin,topMargin,rightMargin,bottomMargin;
        public MarginLayoutParams(){}
        public MarginLayoutParams(int width,int height){super(width,height);}
        public MarginLayoutParams(LayoutParams source){if(source!=null){width=source.width;height=source.height;}}
        public void setMargins(int left,int top,int right,int bottom){leftMargin=left;topMargin=top;rightMargin=right;bottomMargin=bottom;}
    }
    public void addView(View child){}
    public void addView(View child,int index){}
    public void removeAllViews(){}
    public int getChildCount(){return 0;}
    public View getChildAt(int index){return null;}
}
