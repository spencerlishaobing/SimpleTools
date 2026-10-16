package android.graphics;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class Rect {

    public int left,top,right,bottom;
    public Rect(){}
    public Rect(int left,int top,int right,int bottom){this.left=left;this.top=top;this.right=right;this.bottom=bottom;}
    public int width(){return right-left;}
    public int height(){return bottom-top;}
    public void set(int left,int top,int right,int bottom){this.left=left;this.top=top;this.right=right;this.bottom=bottom;}
}
