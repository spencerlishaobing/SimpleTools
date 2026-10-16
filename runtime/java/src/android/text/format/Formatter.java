package android.text.format;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class Formatter {

    public static String formatFileSize(android.content.Context context,long number){return number+" B";}
    public static String formatIpAddress(int ipv4Address){return "";}
}
