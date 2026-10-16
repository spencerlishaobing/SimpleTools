package android.widget;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class ImageView extends android.view.View {

    public enum ScaleType {MATRIX,FIT_XY,FIT_START,FIT_CENTER,FIT_END,CENTER,CENTER_CROP,CENTER_INSIDE};
    public ImageView(){}
    public ImageView(android.content.Context context){}
    public void setImageBitmap(android.graphics.Bitmap bm){}
    public void setImageDrawable(android.graphics.drawable.Drawable drawable){}
    public void setScaleType(ScaleType scaleType){}
    public void setAdjustViewBounds(boolean adjustViewBounds){}
}
