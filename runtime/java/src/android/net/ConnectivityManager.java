package android.net;
/** 桌面端连接管理器桩：始终返回“已连接”的固定网络信息。 */
public class ConnectivityManager {
    private static final NetworkInfo INFO=new NetworkInfo();
    public NetworkInfo getActiveNetworkInfo(){return INFO;}
    public NetworkInfo[] getAllNetworkInfo(){return new NetworkInfo[]{INFO};}
    public NetworkInfo getNetworkInfo(int networkType){return INFO;}
    public boolean isActiveNetworkMetered(){return false;}
    public boolean isDefaultNetworkActive(){return true;}
}
