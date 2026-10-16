package android.widget;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实列表/视图。 */
public class RelativeLayout extends android.view.ViewGroup {
    public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams {
        public static final int TRUE=-1;
        public int[] rules=new int[22];
        public int alignWithParentIfMissing;
        public LayoutParams(){}
        public LayoutParams(int width,int height){super(width,height);}
        public void addRule(int verb){}
        public void addRule(int verb,int anchor){}
    }
    public RelativeLayout(){}
    public RelativeLayout(android.content.Context context){}
}
