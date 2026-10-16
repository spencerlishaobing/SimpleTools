package android.app;
/** 桌面端没有真实窗口：最小 Activity 桩，满足 spider 对 Activity 类型的引用与反射检查。 */
public class Activity extends android.content.Context {
    public Activity(){super();}
    public void runOnUiThread(Runnable action){action.run();}
    public void finish(){}
    public boolean isFinishing(){return false;}
}
