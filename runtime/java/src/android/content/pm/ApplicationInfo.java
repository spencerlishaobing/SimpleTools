package android.content.pm;
/** Android 真实继承关系：ApplicationInfo extends PackageItemInfo（饭太硬 Pan 的内部类依赖此类型可赋值性，否则 VerifyError） */
public class ApplicationInfo extends PackageItemInfo {
    public String packageName="com.simpletools.desktop";
    public String sourceDir="";
    public String publicSourceDir="";
    public String dataDir="";
    public int flags=0;
    public int targetSdkVersion=34;
    public int minSdkVersion=23;
    public int uid=10000;
    public boolean enabled=true;
}
