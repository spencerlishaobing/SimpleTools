package android.content.pm;
/** 最小包管理器桩：spider 常用 getPackageInfo 读取版本号 / 签名校验，桌面端返回固定信息。 */
public class PackageManager {
    public static class NameNotFoundException extends Exception {
        public NameNotFoundException(){super("Package not found");}
        public NameNotFoundException(String message){super(message);}
    }
    public PackageInfo getPackageInfo(String packageName,int flags)throws NameNotFoundException{
        PackageInfo info=new PackageInfo();
        info.packageName=packageName==null?"com.simpletools.desktop":packageName;
        info.signatures=new Signature[]{new Signature()};
        return info;
    }
    public PackageInfo getPackageInfo(String packageName,int flags,int userId)throws NameNotFoundException{return getPackageInfo(packageName,flags);}
    /** 应用名参与部分片源的白名单校验，返回 TVBox 生态内的通用名称。 */
    public CharSequence getApplicationLabel(ApplicationInfo info){return "TVBox";}
    public ApplicationInfo getApplicationInfo(String packageName,int flags)throws NameNotFoundException{
        ApplicationInfo info=new ApplicationInfo();
        info.packageName=packageName==null?"com.simpletools.desktop":packageName;
        return info;
    }
    public String[] getPackagesForUid(int uid){return new String[0];}
    public java.util.List<PackageInfo> getInstalledPackages(int flags){return new java.util.ArrayList<>();}
    public boolean isPackageInstalled(String packageName){return false;}
}
