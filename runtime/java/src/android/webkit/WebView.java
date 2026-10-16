package android.webkit;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class WebView extends android.view.ViewGroup {

    public void loadUrl(String url){}
    public void loadData(String data,String mimeType,String encoding){}
    public void loadDataWithBaseURL(String baseUrl,String data,String mimeType,String encoding,String historyUrl){}
    public void setWebViewClient(WebViewClient client){}
    public void setWebChromeClient(WebChromeClient client){}
    public void stopLoading(){}
    public void destroy(){}
    public WebSettings getSettings(){return new WebSettings();}
    public void setLayoutParams(android.view.ViewGroup.LayoutParams params){}
    public void setBackgroundColor(int color){}
}
