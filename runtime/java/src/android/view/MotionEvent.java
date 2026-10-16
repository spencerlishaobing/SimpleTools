package android.view;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class MotionEvent {

    public static final int ACTION_DOWN=0,ACTION_UP=1,ACTION_MOVE=2;
    public float getX(){return 0f;}
    public float getY(){return 0f;}
    public int getAction(){return ACTION_DOWN;}
    public int getPointerCount(){return 1;}
}
