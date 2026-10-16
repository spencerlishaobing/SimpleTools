package android.view;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口服务。 */
public interface WindowManager {
    class LayoutParams {
        public static final int TYPE_APPLICATION=2,TYPE_PHONE=2003,TYPE_APPLICATION_OVERLAY=2038;
        public static final int FLAG_NOT_FOCUSABLE=8,FLAG_NOT_TOUCHABLE=16,FLAG_LAYOUT_NO_LIMITS=512,FLAG_LAYOUT_IN_SCREEN=256;
        public static final int MATCH_PARENT=-1,WRAP_CONTENT=-2;
        public int width,height,x,y,gravity,format,flags,type;
        public float alpha=1f;
        public LayoutParams(){}
        public LayoutParams(int width,int height){this.width=width;this.height=height;}
        public LayoutParams(int width,int height,int type){this.width=width;this.height=height;this.type=type;}
    }
}
