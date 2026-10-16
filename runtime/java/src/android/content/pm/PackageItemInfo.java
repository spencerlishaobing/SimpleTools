package android.content.pm;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class PackageItemInfo {

    public String packageName,name;
    public android.content.pm.ApplicationInfo applicationInfo=new android.content.pm.ApplicationInfo();
}
