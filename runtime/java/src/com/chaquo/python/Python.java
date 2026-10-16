package com.chaquo.python;
/** 桌面 Android 兼容层桩：Chaquo Python 在桌面端不可用，仅满足类链接。 */
public class Python {
    public static Python getInstance(){return new Python();}
    public PyObject getModule(String name){return null;}
}
