package android.view;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class Window {

    public View getDecorView(){return null;}
    public void setLayout(int width,int height){}
    public void addFlags(int flags){}
    public void clearFlags(int flags){}
}
