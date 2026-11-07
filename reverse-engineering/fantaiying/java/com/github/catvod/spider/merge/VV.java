/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.V;
import com.github.catvod.spider.merge.YG;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class VV {
    private static final Map<Class<?>, Class<?>> N;
    private static final Map<Class<?>, Class<?>> SN;
    private static final Map<String, String> tF;
    private static final Map<String, Class<?>> yq;
    public static final int zH = 0;

    static {
        HashMap object2 = new HashMap();
        yq = object2;
        Class<Boolean> clazz = Boolean.TYPE;
        object2.put("boolean", clazz);
        object2.put("byte", Byte.TYPE);
        object2.put("char", Character.TYPE);
        object2.put("short", Short.TYPE);
        Class<Integer> clazz2 = Integer.TYPE;
        object2.put("int", clazz2);
        Class<Long> clazz3 = Long.TYPE;
        object2.put("long", clazz3);
        object2.put("double", Double.TYPE);
        Serializable serializable = Float.TYPE;
        object2.put("float", (Class<?>)serializable);
        object2.put("void", Void.TYPE);
        HashMap hashMap = new HashMap();
        SN = hashMap;
        hashMap.put(clazz, Boolean.class);
        hashMap.put(Byte.TYPE, Byte.class);
        hashMap.put(Character.TYPE, Character.class);
        hashMap.put(Short.TYPE, Short.class);
        hashMap.put(clazz2, Integer.class);
        hashMap.put(clazz3, Long.class);
        hashMap.put(Double.TYPE, Double.class);
        hashMap.put((Class<?>)serializable, Float.class);
        serializable = Void.TYPE;
        hashMap.put((Class<?>)serializable, (Class<?>)serializable);
        N = new HashMap();
        for (Map.Entry<Class<?>, Class<?>> entry : hashMap.entrySet()) {
            Class<?> clazz4;
            serializable = entry.getKey();
            if (serializable.equals(clazz4 = entry.getValue())) continue;
            ((HashMap)N).put(clazz4, (Class<?>)serializable);
        }
        serializable = V.tF("int", "I", "boolean", "Z");
        ((HashMap)serializable).put("float", "F");
        ((HashMap)serializable).put("long", "J");
        ((HashMap)serializable).put("short", "S");
        ((HashMap)serializable).put("byte", "B");
        ((HashMap)serializable).put("double", "D");
        ((HashMap)serializable).put("char", "C");
        HashMap hashMap2 = new HashMap();
        for (Map.Entry entry : ((HashMap)serializable).entrySet()) {
            hashMap2.put(entry.getValue(), entry.getKey());
        }
        Collections.unmodifiableMap(serializable);
        tF = Collections.unmodifiableMap(hashMap2);
    }

    public static String yq(Class<?> object) {
        Object object2 = "";
        if (object == null) {
            return "";
        }
        if (YG.N((CharSequence)(object = ((Class)object).getName()))) {
            object = object2;
        } else {
            int n2;
            StringBuilder stringBuilder = new StringBuilder();
            boolean bl = ((String)object).startsWith("[");
            int n3 = 0;
            object2 = object;
            if (bl) {
                object2 = object;
                while (((String)object2).charAt(0) == '[') {
                    object2 = ((String)object2).substring(1);
                    stringBuilder.append("[]");
                }
                object = object2;
                if (((String)object2).charAt(0) == 'L') {
                    object = object2;
                    if (((String)object2).charAt(((String)object2).length() - 1) == ';') {
                        object = ((String)object2).substring(1, ((String)object2).length() - 1);
                    }
                }
                Map<String, String> map = tF;
                object2 = object;
                if (map.containsKey(object)) {
                    object2 = map.get(object);
                }
            }
            if ((n2 = ((String)object2).lastIndexOf(46)) != -1) {
                n3 = n2 + 1;
            }
            n3 = ((String)object2).indexOf(36, n3);
            object = object2 = ((String)object2).substring(n2 + 1);
            if (n3 != -1) {
                object = ((String)object2).replace('$', '.');
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append((Object)stringBuilder);
            object = ((StringBuilder)object2).toString();
        }
        return object;
    }
}

