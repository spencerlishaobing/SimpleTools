package android.app;
import android.os.Bundle;
import java.io.File;
/** 桌面端 Application：spider 的 Init.init 会把传入的 Context 强转为 Application，必须使用本类实例。 */
public class Application extends android.content.Context {
    public Application(){super();}
    public Application(File root){super(root);}
    /** 生命周期回调接口桩：桌面端没有真实 Activity 生命周期，注册后不会收到回调。 */
    public interface ActivityLifecycleCallbacks {
        void onActivityCreated(Activity activity,Bundle savedInstanceState);
        void onActivityStarted(Activity activity);
        void onActivityResumed(Activity activity);
        void onActivityPaused(Activity activity);
        void onActivityStopped(Activity activity);
        void onActivitySaveInstanceState(Activity activity,Bundle outState);
        void onActivityDestroyed(Activity activity);
    }
    private final java.util.List<ActivityLifecycleCallbacks> lifecycleCallbacks=new java.util.ArrayList<>();
    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback){if(callback!=null)lifecycleCallbacks.add(callback);}
    public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback){lifecycleCallbacks.remove(callback);}
}
