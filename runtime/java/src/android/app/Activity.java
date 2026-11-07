package android.app;
/** 桌面端没有真实窗口：最小 Activity 桩，满足 spider 对 Activity 类型的引用与反射检查。 */
public class Activity extends android.content.Context {
    public Activity(){super();}
    public void runOnUiThread(Runnable action){action.run();}
    public void finish(){}
    public boolean isFinishing(){return false;}
    /** 反射兼容：饭太硬 InitOrigin.getActivity 拿到 Activity 后会取 ComponentName。 */
    public android.content.ComponentName getComponentName(){return new android.content.ComponentName(getPackageName(),"com.simpletools.tvbridge.Main");}
    public android.content.Intent getIntent(){return new android.content.Intent();}
    private final android.view.Window window=new android.view.Window();
    public android.view.Window getWindow(){return window;}
    private final android.view.WindowManager windowManager=new android.view.WindowManager(){};
    public android.view.WindowManager getWindowManager(){return windowManager;}
}
