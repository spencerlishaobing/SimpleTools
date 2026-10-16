package com.chaquo.python;
/** 桌面 Android 兼容层桩：Chaquo Python 在桌面端不可用，仅满足类链接。 */
public class PyException extends RuntimeException {
    public PyException(){super();}
    public PyException(String message){super(message);}
}
