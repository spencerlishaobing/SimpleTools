package com.github.catvod.crawler;
public class SpiderDebug {
    public static void log(String message) { android.util.Log.i("TVBoxSpider",message); }
    public static void log(Throwable error) { android.util.Log.e("TVBoxSpider","Error",error); }
}
