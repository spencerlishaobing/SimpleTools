package android.content;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class ClipboardManager {

    public ClipData getPrimaryClip(){return null;}
    public void setPrimaryClip(ClipData clip){}
    public CharSequence getText(){return null;}
    public boolean hasPrimaryClip(){return false;}
}
