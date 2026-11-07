/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider;

import com.github.catvod.spider.merge.Bo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Youtube {
    public static String fetch(String object) {
        Object object2;
        block4: {
            try {
                object2 = new HashMap();
                ((HashMap)object2).put("User-Agent", "Mozilla/5.0 (X11; Linux aarch64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36");
                object2 = Bo.B((String)object, object2);
                object2 = Pattern.compile("hlsManifestUrl\\S*?(https\\S*?\\.m3u8)").matcher((CharSequence)object2);
                if (((Matcher)object2).find()) break block4;
                return "";
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return object;
            }
        }
        object2 = ((Matcher)object2).group(1);
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("User-Agent", "Mozilla/5.0 (X11; Linux aarch64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36");
        object2 = Youtube.yq(Bo.B((String)object2, hashMap));
        boolean bl = ((String)object2).isEmpty();
        if (!bl) {
            object = object2;
        }
        return object;
    }

    private static String yq(String string) {
        Object object;
        Iterator<String> iterator = Arrays.asList("301", "300", "96", "95", "94").iterator();
        Object object2 = "";
        do {
            object = object2;
            if (!iterator.hasNext()) break;
            object = iterator.next();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("https:/.*/");
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append("/.*index.m3u8");
            object = Pattern.compile(((StringBuilder)object2).toString()).matcher(string);
            object = ((Matcher)object).find() ? ((Matcher)object).group() : "";
            object2 = object;
        } while (((String)object).isEmpty());
        return object;
    }
}

