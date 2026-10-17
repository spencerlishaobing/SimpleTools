package android.app;

import android.content.Context;

/** 桌面兼容层：ActivityThread（部分 spider 通过 currentActivityThread().getApplication() 取上下文，缺失会导致 home 返回空） */
public final class ActivityThread {
    private static final ActivityThread INSTANCE = new ActivityThread();
    private static Application application;

    public static void setApplication(Application app) { application = app; }
    public static ActivityThread currentActivityThread() { return INSTANCE; }
    public static Application currentApplication() { return application; }
    public static String currentPackageName() { return "com.simpletools.desktop"; }

    public Application getApplication() { return application; }
    public Context getSystemContext() { return application; }
    public Context getSystemUiContext() { return application; }
    public String getProcessName() { return currentPackageName(); }
}
