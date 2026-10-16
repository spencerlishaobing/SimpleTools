package android.graphics;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实位图。 */
public class Bitmap {
    public enum Config {ALPHA_8,RGB_565,ARGB_4444,ARGB_8888};
    public int getWidth(){return 0;}
    public int getHeight(){return 0;}
    public Config getConfig(){return Config.ARGB_8888;}
    public boolean isRecycled(){return false;}
    public void recycle(){}
}
