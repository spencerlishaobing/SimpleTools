package android.util;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class TypedValue {

    public static final int COMPLEX_UNIT_PX=0,COMPLEX_UNIT_DIP=1,COMPLEX_UNIT_SP=2;
    public static int applyDimension(int unit,float value,DisplayMetrics metrics){
        if(unit==COMPLEX_UNIT_PX)return (int)value;
        float density=metrics==null?1f:Math.max(1f,metrics.density);
        return (int)(value*density+0.5f);
    }
}
