package android.graphics.drawable;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class Drawable {

    public static abstract class ConstantState {public abstract Drawable newDrawable();}
    public ConstantState getConstantState(){return null;}
    public void setBounds(int left,int top,int right,int bottom){}
    public int getIntrinsicWidth(){return 0;}
    public int getIntrinsicHeight(){return 0;}
}
