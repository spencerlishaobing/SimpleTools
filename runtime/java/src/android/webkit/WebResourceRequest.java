package android.webkit;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证。 */
public interface WebResourceRequest {
    android.net.Uri getUrl();
    boolean isForMainFrame();
    String getMethod();
    java.util.Map<String,String> getRequestHeaders();
}
