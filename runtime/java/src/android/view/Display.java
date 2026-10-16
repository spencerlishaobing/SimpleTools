package android.view;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class Display {

    public int getWidth(){return 1280;}
    public int getHeight(){return 720;}
    public int getRotation(){return 0;}
}
