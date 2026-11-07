/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Nh;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;

public final class mc {
    public final void yq(Throwable throwable, Throwable throwable2) {
        Method method = yq.yq;
        if (method != null) {
            method.invoke(throwable, throwable2);
        }
    }

    private static final class yq {
        public static final Method yq;

        static {
            int n2;
            GenericDeclaration genericDeclaration;
            Method[] methodArray = Throwable.class.getMethods();
            Nh.tF(methodArray, "throwableMethods");
            int n3 = methodArray.length;
            int n4 = 0;
            int n5 = 0;
            while (true) {
                Method method;
                block8: {
                    block7: {
                        genericDeclaration = null;
                        Object var6_7 = null;
                        if (n5 >= n3) break;
                        method = methodArray[n5];
                        boolean bl = Nh.yq(method.getName(), "addSuppressed");
                        n2 = 1;
                        if (!bl) break block7;
                        Class<?>[] classArray = method.getParameterTypes();
                        Nh.tF(classArray, "it.parameterTypes");
                        genericDeclaration = var6_7;
                        if (classArray.length == 1) {
                            genericDeclaration = classArray[0];
                        }
                        if (Nh.yq(genericDeclaration, Throwable.class)) break block8;
                    }
                    n2 = 0;
                }
                if (n2 != 0) {
                    genericDeclaration = method;
                    break;
                }
                ++n5;
            }
            yq = genericDeclaration;
            n2 = methodArray.length;
            for (n5 = n4; n5 < n2 && !Nh.yq(methodArray[n5].getName(), "getSuppressed"); ++n5) {
            }
        }
    }
}

