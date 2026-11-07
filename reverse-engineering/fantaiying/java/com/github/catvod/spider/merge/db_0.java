/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package com.github.catvod.spider.merge;

import android.os.Build;
import com.github.catvod.spider.merge.BL;
import com.github.catvod.spider.merge.k_0;
import com.github.catvod.spider.merge.zh_0;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Renamed from com.github.catvod.spider.merge.db
 */
public final class db_0 {
    public static final int SN = 0;
    private static final Pattern yq = Pattern.compile("\\[(\\d{2}):(\\d{2})\\.(\\d{2,3})]");

    public static List<yq> N(String object) {
        String string;
        ArrayList<yq> arrayList = new ArrayList<yq>();
        BufferedReader bufferedReader = new BufferedReader(new StringReader((String)object));
        while ((string = bufferedReader.readLine()) != null) {
            object = yq.matcher(string);
            while (((Matcher)object).find()) {
                int n2 = Integer.parseInt(((Matcher)object).group(1));
                int n3 = Integer.parseInt(((Matcher)object).group(2));
                String string2 = ((Matcher)object).group(3);
                int n4 = string2.length() == 2 ? Integer.parseInt(string2) * 10 : Integer.parseInt(string2);
                arrayList.add(new yq(n3 * 1000 + n2 * 60 * 1000 + n4, string.substring(((Matcher)object).end()).trim()));
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            arrayList.sort(BL.yq());
        }
        return arrayList;
    }

    private static String SN(long l) {
        long l2 = l / 1000L;
        l = l % 1000L / 10L;
        return String.format("%d:%02d:%02d.%02d", l2 / 3600L, l2 % 3600L / 60L, l2 % 60L, l);
    }

    public static String yq(List<yq> list) {
        StringBuilder stringBuilder = zh_0.N("[Script Info]\n", "ScriptType: v4.00+\n", "Collisions: Normal\n", "PlayResX: 1280\n", "PlayResY: 720\n");
        k_0.t0(stringBuilder, "Timer: 100.0000\n", "\n", "[V4+ Styles]\n", "Format: Name, Fontname, Fontsize, PrimaryColour, SecondaryColour, OutlineColour, BackColour, Bold, Italic, Underline, StrikeOut, ScaleX, ScaleY, Spacing, Angle, BorderStyle, Outline, Shadow, Alignment, MarginL, MarginR, MarginV, Encoding\n");
        k_0.t0(stringBuilder, "Style: KTV,Roboto,70,&H4D9A51E6,&HB3FFFFFF,&H00000000,&H64000000,-1,0,0,0,100,85,0,0,1,5,5,2,10,10,100,1\n", "\n", "[Events]\n", "Format: Layer, Start, End, Style, Name, MarginL, MarginR, MarginV, Effect, Text\n");
        int n2 = 0;
        while (n2 < list.size()) {
            yq yq2 = list.get(n2);
            Object object = ++n2 < list.size() ? list.get(n2) : null;
            String string = db_0.SN(yq2.yq);
            long l = object != null ? ((yq)object).yq : yq2.yq + 3000L;
            String string2 = db_0.SN(l);
            object = yq2.SN;
            object = object == null ? "" : ((String)object).replace("\\", "\\\\").replace(",", "\\,");
            stringBuilder.append(String.format("Dialogue: 0,%s,%s,KTV,,0,0,0,,%s\n", string, string2, object));
        }
        return stringBuilder.toString();
    }

    public static final class yq {
        String SN;
        long yq;

        yq(long l, String string) {
            this.yq = l;
            this.SN = string;
        }
    }
}

