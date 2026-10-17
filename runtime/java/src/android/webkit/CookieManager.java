package android.webkit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 桌面兼容层：CookieManager
 * 网盘系 JAR（夸克/UC/百度/阿里等）通过本类读取登录后的 Cookie。
 * 桌面端登录窗口（WebView）写入的 Cookie 由 Rust 侧保存到 JVM 工作目录的
 * cloud-cookies.txt（每行：domain \t name=value; name2=value2），本类懒加载并按域名匹配返回，
 * 从而实现「扫码登录网盘 → JAR 鉴权播放」。
 */
public class CookieManager {
    private static final CookieManager INSTANCE = new CookieManager();
    private static final String FILE_NAME = "cloud-cookies.txt";
    private final Map<String, String> cookies = new LinkedHashMap<String, String>();
    private long loadedAt = 0;

    public static CookieManager getInstance() { return INSTANCE; }

    private synchronized void reload() {
        File file = new File(FILE_NAME);
        if (!file.isFile()) return;
        if (file.lastModified() <= loadedAt) return;
        loadedAt = file.lastModified();
        cookies.clear();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                int tab = line.indexOf('\t');
                if (tab <= 0) continue;
                String domain = line.substring(0, tab).trim().toLowerCase();
                String value = line.substring(tab + 1).trim();
                if (!domain.isEmpty() && !value.isEmpty()) cookies.put(domain, value);
            }
        } catch (Exception ignored) { }
    }

    public String getCookie(String url) {
        reload();
        if (url == null) return "";
        String host;
        try { host = new URI(url).getHost(); } catch (Exception e) { return ""; }
        if (host == null) return "";
        host = host.toLowerCase();
        StringBuilder out = new StringBuilder();
        for (Map.Entry<String, String> entry : cookies.entrySet()) {
            String domain = entry.getKey();
            if (host.equals(domain) || host.endsWith("." + domain)) {
                if (out.length() > 0) out.append("; ");
                out.append(entry.getValue());
            }
        }
        return out.toString();
    }

    /** 运行时写入（仅内存，桌面端以登录窗口写文件为准，避免覆盖） */
    public void setCookie(String url, String value) {
        if (url == null || value == null) return;
        String host;
        try { host = new URI(url).getHost(); } catch (Exception e) { return; }
        if (host == null) return;
        cookies.put(host.toLowerCase(), value);
    }

    public void setCookie(String url, String value, Object callback) { setCookie(url, value); }
    public void removeAllCookies() { cookies.clear(); }
    public void removeSessionCookies() { }
    public void flush() { }
    public void setAcceptCookie(boolean accept) { }
    public boolean acceptCookie() { return true; }
    public void setAcceptThirdPartyCookies(Object webview, boolean accept) { }
}
