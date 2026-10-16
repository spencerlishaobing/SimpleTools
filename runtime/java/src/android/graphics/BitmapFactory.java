package android.graphics;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class BitmapFactory {

    public static Bitmap decodeFile(String pathName){return null;}
    public static Bitmap decodeFile(String pathName,Options opts){return null;}
    public static Bitmap decodeByteArray(byte[] data,int offset,int length){return null;}
    public static Bitmap decodeStream(java.io.InputStream is){return null;}
    public static class Options {public boolean inJustDecodeBounds;public int inSampleSize=1;public Config inPreferredConfig;}
    public enum Config {ALPHA_8,RGB_565,ARGB_4444,ARGB_8888};
}
