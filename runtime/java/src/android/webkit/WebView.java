package android.webkit;
/** 桌面 Android 兼容层桩：满足外置片源的类链接与验证，桌面端无真实窗口服务实现。 */
public class WebView extends android.view.ViewGroup {

    // 探测：JAR 若用 WebView 展示二维码/HTML，记录内容便于桌面端转发
    public void loadUrl(String url){
        try{System.err.println("[UI-PROBE] WebView.loadUrl url="+(url!=null&&url.length()>300?url.substring(0,300):url));}catch(Throwable ignored){}
    }
    public void loadData(String data,String mimeType,String encoding){
        try{System.err.println("[UI-PROBE] WebView.loadData data="+(data!=null&&data.length()>300?data.substring(0,300):data));}catch(Throwable ignored){}
    }
    public void loadDataWithBaseURL(String baseUrl,String data,String mimeType,String encoding,String historyUrl){
        try{System.err.println("[UI-PROBE] WebView.loadDataWithBaseURL base="+baseUrl+" data="+(data!=null&&data.length()>300?data.substring(0,300):data));}catch(Throwable ignored){}
    }
    public void setWebViewClient(WebViewClient client){}
    public void setWebChromeClient(WebChromeClient client){}
    public void stopLoading(){}
    public void destroy(){}
    public WebSettings getSettings(){return new WebSettings();}
    public void setLayoutParams(android.view.ViewGroup.LayoutParams params){}
    public void setBackgroundColor(int color){}
}
