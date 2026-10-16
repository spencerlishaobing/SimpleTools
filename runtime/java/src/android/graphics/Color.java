package android.graphics;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class Color {

    public static final int BLACK=0xFF000000,WHITE=0xFFFFFFFF,RED=0xFFFF0000,GREEN=0xFF00FF00,BLUE=0xFF0000FF,TRANSPARENT=0;
    public static int rgb(int red,int green,int blue){return 0xFF000000|(red<<16)|(green<<8)|blue;}
    public static int argb(int alpha,int red,int green,int blue){return (alpha<<24)|(red<<16)|(green<<8)|blue;}
    public static int parseColor(String colorString){try{String s=colorString.startsWith("#")?colorString.substring(1):colorString;if(s.length()==6)s="FF"+s;return (int)Long.parseLong(s,16);}catch(Exception e){return BLACK;}}
}
