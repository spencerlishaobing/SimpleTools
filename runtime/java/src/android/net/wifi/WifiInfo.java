package android.net.wifi;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class WifiInfo {

    public String getMacAddress(){return "02:00:00:00:00:00";}
    public String getSSID(){return null;}
    public String getBSSID(){return null;}
    public int getIpAddress(){return 0;}
}
