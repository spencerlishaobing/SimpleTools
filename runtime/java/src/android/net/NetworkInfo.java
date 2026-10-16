package android.net;
/** 桌面端网络状态桩：始终视为已连接（真实网络错误会由实际请求返回）。 */
public class NetworkInfo {
    public enum State { CONNECTING, CONNECTED, DISCONNECTED, DISCONNECTING, SUSPENDED, UNKNOWN }
    public enum DetailedState { IDLE, SCANNING, CONNECTING, AUTHENTICATING, OBTAINING_IPADDR, CONNECTED, SUSPENDED, DISCONNECTING, DISCONNECTED, FAILED, BLOCKED, VERIFYING_POOR_LINK, CAPTIVE_PORTAL_CHECK }
    public boolean isConnected(){return true;}
    public boolean isAvailable(){return true;}
    public boolean isConnectedOrConnecting(){return true;}
    public int getType(){return 1;}
    public int getSubtype(){return 0;}
    public State getState(){return State.CONNECTED;}
    public DetailedState getDetailedState(){return DetailedState.CONNECTED;}
    public String getTypeName(){return "WIFI";}
    public String getSubtypeName(){return "";}
    public String getReason(){return null;}
    public String getExtraInfo(){return null;}
}
