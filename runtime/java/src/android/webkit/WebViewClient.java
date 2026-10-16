package android.webkit;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class WebViewClient {

    public boolean shouldOverrideUrlLoading(WebView view,String url){return false;}
    public boolean shouldOverrideUrlLoading(WebView view,WebResourceRequest request){return false;}
    public android.webkit.WebResourceResponse shouldInterceptRequest(WebView view,WebResourceRequest request){return null;}
    public void onPageFinished(WebView view,String url){}
    public void onPageStarted(WebView view,String url,Object favicon){}
    public void onReceivedError(WebView view,int errorCode,String description,String failingUrl){}
}
