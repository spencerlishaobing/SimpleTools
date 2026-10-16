package android.content.res;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class Resources {

    public Configuration getConfiguration(){return new Configuration();}
    public int getIdentifier(String name,String defType,String defPackage){return 0;}
    public String getString(int id){return "";}
    public android.util.DisplayMetrics getDisplayMetrics(){return new android.util.DisplayMetrics();}
    public float getDimension(int id){return 0f;}
    public int getDimensionPixelSize(int id){return 0;}
}
