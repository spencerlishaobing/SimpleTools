package android.net.wifi;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class WifiManager {

    public WifiInfo getConnectionInfo(){return new WifiInfo();}
    public boolean isWifiEnabled(){return false;}
    public boolean setWifiEnabled(boolean enabled){return false;}
}
