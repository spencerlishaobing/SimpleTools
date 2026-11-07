/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.JC;
import com.github.catvod.spider.merge.Nh;
import com.github.catvod.spider.merge.mc;

public final class rV {
    public static final mc yq;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object;
        block29: {
            int n2;
            Object object2;
            block28: {
                object2 = System.getProperty("java.specification.version");
                if (object2 != null) {
                    int n3;
                    int n4 = JC.t0((CharSequence)object2, 0, 6);
                    if (n4 < 0) {
                        n2 = Integer.parseInt((String)object2);
                        n2 *= 65536;
                        break block28;
                    }
                    int n5 = n4 + 1;
                    n2 = n3 = JC.t0((CharSequence)object2, n5, 4);
                    if (n3 < 0) {
                        n2 = ((String)object2).length();
                    }
                    object = ((String)object2).substring(0, n4);
                    Nh.tF(object, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    object2 = ((String)object2).substring(n5, n2);
                    Nh.tF(object2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    try {
                        n3 = Integer.parseInt((String)object);
                        n2 = Integer.parseInt((String)object2);
                        n2 += n3 * 65536;
                    }
                    catch (NumberFormatException numberFormatException) {}
                }
                n2 = 65542;
            }
            if (n2 >= 65544 || n2 < 65536) {
                try {
                    object2 = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
                    Nh.tF(object2, "forName(\"kotlin.internal\u2026entations\").newInstance()");
                    try {
                        object = (mc)object2;
                        break block29;
                    }
                    catch (ClassCastException classCastException) {
                        ClassLoader classLoader = object2.getClass().getClassLoader();
                        ClassLoader classLoader2 = mc.class.getClassLoader();
                        if (!Nh.yq(classLoader, classLoader2)) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Instance class was loaded from a different classloader: ");
                            stringBuilder.append(classLoader);
                            stringBuilder.append(", base type classloader: ");
                            stringBuilder.append(classLoader2);
                            object2 = new ClassNotFoundException(stringBuilder.toString(), classCastException);
                            throw object2;
                        }
                        throw classCastException;
                    }
                }
                catch (ClassNotFoundException classNotFoundException) {
                    try {
                        object2 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                        Nh.tF(object2, "forName(\"kotlin.internal\u2026entations\").newInstance()");
                        try {
                            object = (mc)object2;
                            break block29;
                        }
                        catch (ClassCastException classCastException) {
                            ClassLoader classLoader = object2.getClass().getClassLoader();
                            ClassLoader classLoader3 = mc.class.getClassLoader();
                            if (!Nh.yq(classLoader, classLoader3)) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Instance class was loaded from a different classloader: ");
                                stringBuilder.append(classLoader);
                                stringBuilder.append(", base type classloader: ");
                                stringBuilder.append(classLoader3);
                                object2 = new ClassNotFoundException(stringBuilder.toString(), classCastException);
                                throw object2;
                            }
                            throw classCastException;
                        }
                    }
                    catch (ClassNotFoundException classNotFoundException2) {
                        // empty catch block
                    }
                }
            }
            if (n2 >= 65543 || n2 < 65536) {
                try {
                    object2 = Class.forName("kotlin.internal.jdk7.JDK7PlatformImplementations").newInstance();
                    Nh.tF(object2, "forName(\"kotlin.internal\u2026entations\").newInstance()");
                    try {
                        object = (mc)object2;
                        break block29;
                    }
                    catch (ClassCastException classCastException) {
                        ClassLoader classLoader = object2.getClass().getClassLoader();
                        ClassLoader classLoader4 = mc.class.getClassLoader();
                        if (!Nh.yq(classLoader, classLoader4)) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Instance class was loaded from a different classloader: ");
                            stringBuilder.append(classLoader);
                            stringBuilder.append(", base type classloader: ");
                            stringBuilder.append(classLoader4);
                            object2 = new ClassNotFoundException(stringBuilder.toString(), classCastException);
                            throw object2;
                        }
                        throw classCastException;
                    }
                }
                catch (ClassNotFoundException classNotFoundException) {
                    try {
                        object2 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                        Nh.tF(object2, "forName(\"kotlin.internal\u2026entations\").newInstance()");
                        try {
                            object = (mc)object2;
                            break block29;
                        }
                        catch (ClassCastException classCastException) {
                            object2 = object2.getClass().getClassLoader();
                            ClassLoader classLoader = mc.class.getClassLoader();
                            if (!Nh.yq(object2, classLoader)) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Instance class was loaded from a different classloader: ");
                                stringBuilder.append(object2);
                                stringBuilder.append(", base type classloader: ");
                                stringBuilder.append(classLoader);
                                ClassNotFoundException classNotFoundException3 = new ClassNotFoundException(stringBuilder.toString(), classCastException);
                                throw classNotFoundException3;
                            }
                            throw classCastException;
                        }
                    }
                    catch (ClassNotFoundException classNotFoundException4) {}
                }
            }
            object = new mc();
        }
        yq = object;
    }
}

