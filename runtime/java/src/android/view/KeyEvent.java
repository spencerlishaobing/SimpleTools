package android.view;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class KeyEvent {

    public static final int ACTION_DOWN=0,ACTION_UP=1;
    public static final int KEYCODE_BACK=4,KEYCODE_ENTER=66,KEYCODE_DPAD_CENTER=23,KEYCODE_DPAD_UP=19,KEYCODE_DPAD_DOWN=20,KEYCODE_DPAD_LEFT=21,KEYCODE_DPAD_RIGHT=22,KEYCODE_MENU=82;
    public int getKeyCode(){return 0;}
    public int getAction(){return ACTION_DOWN;}
}
