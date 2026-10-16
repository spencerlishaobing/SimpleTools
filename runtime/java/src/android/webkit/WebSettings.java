package android.webkit;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class WebSettings {

    public void setJavaScriptEnabled(boolean flag){}
    public void setDomStorageEnabled(boolean flag){}
    public void setUserAgentString(String ua){}
    public String getUserAgentString(){return "";}
    public void setAllowFileAccess(boolean allow){}
    public void setCacheMode(int mode){}
}
