package android.app;

import android.content.Context;

/** 桌面兼容层：ActivityThread（部分 spider 通过 currentActivityThread().getApplication() 取上下文，缺失会导致 home 返回空） */
public final class ActivityThread {
    private static final ActivityThread INSTANCE = new ActivityThread();
    private static Application application;
    /** 反射兼容：饭太硬 JAR（InitOrigin.getActivity）反射读取本字段获取宿主 Activity 以展示登录二维码 */
    public static final java.util.Map<Object,Object> mActivities = new java.util.concurrent.ConcurrentHashMap<>();
    public static final class ActivityClientRecord {
        public android.app.Activity activity;
        public boolean paused;
        public ActivityClientRecord(){}
        public ActivityClientRecord(android.app.Activity a){this.activity=a;}
    }
    private static android.app.Activity mainActivity;

    public static void setApplication(Application app) {
        application = app;
        if (mainActivity == null) {
            try {
                mainActivity = new android.app.Activity();
                mActivities.put("main", new ActivityClientRecord(mainActivity));
            } catch (Throwable ignored) { }
        }
    }
    public static ActivityThread currentActivityThread() { return INSTANCE; }
    public static Application currentApplication() { return application; }
    public static String currentPackageName() { return "com.simpletools.desktop"; }

    public Application getApplication() { return application; }
    public Context getSystemContext() { return application; }
    public Context getSystemUiContext() { return application; }
    public String getProcessName() { return currentPackageName(); }
}
