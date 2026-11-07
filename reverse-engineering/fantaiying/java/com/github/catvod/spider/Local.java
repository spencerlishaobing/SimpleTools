/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Environment
 *  com.github.catvod.crawler.Spider
 */
package com.github.catvod.spider;

import android.content.Context;
import android.os.Environment;
import com.github.catvod.crawler.Spider;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.Jz;
import com.github.catvod.spider.merge.Ki;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.qq_0;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class Local
extends Spider {
    private SimpleDateFormat yq;

    private Ef yq(File object) {
        Ef ef = new Ef();
        ef.G(((File)object).getAbsolutePath());
        ef.G4(((File)object).getName());
        String string = ((File)object).isDirectory() ? "https://img07.sogoucdn.com/v2/thumb/retype_exclude_gif/ext/auto/q/95/crop/xy/ai/t/0/?appid=122&url=https://oss4liview.moji.com/thd_file/2025/07/28/edd1dfb11afd77b00310574109f1d35b.jpg" : "https://img07.sogoucdn.com/v2/thumb/retype_exclude_gif/ext/auto/q/95/crop/xy/ai/t/0/?appid=122&url=https://oss4liview.moji.com/thd_file/2025/07/28/a6bdb22cc4b0bfc7b333fec5d027b951.jpg";
        ef.dT(string);
        ef.W(this.yq.format(((File)object).lastModified()));
        object = ((File)object).isDirectory() ? "folder" : "file";
        ef.v((String)object);
        return ef;
    }

    public String categoryContent(String object3, String object2, boolean bl, HashMap<String, String> cloneable) {
        ArrayList arrayList = new ArrayList();
        ArrayList<Ef> arrayList2 = new ArrayList<Ef>();
        ArrayList<Ef> arrayList3 = new ArrayList<Ef>();
        File[] fileArray = new File((String)object3).listFiles();
        if (fileArray == null) {
            return Tq.ee(arrayList);
        }
        Arrays.sort(fileArray, Ki.yq);
        for (File file : fileArray) {
            if (file.getName().startsWith(".")) continue;
            if (file.isDirectory()) {
                arrayList3.add(this.yq(file));
                continue;
            }
            if (!ME.N.contains(ME.dT(file.getName()))) continue;
            arrayList2.add(this.yq(file));
        }
        arrayList.addAll(arrayList3);
        arrayList.addAll(arrayList2);
        return Tq.ee(arrayList);
    }

    public String detailContent(List<String> object) {
        File file = new File(object.get(0));
        object = new Ef();
        ((Ef)object).Gc("FongMi");
        ((Ef)object).G(file.getAbsolutePath());
        ((Ef)object).G4(file.getName());
        ((Ef)object).dT("https://img07.sogoucdn.com/v2/thumb/retype_exclude_gif/ext/auto/q/95/crop/xy/ai/t/0/?appid=122&url=https://oss4liview.moji.com/thd_file/2025/07/28/a6bdb22cc4b0bfc7b333fec5d027b951.jpg");
        ((Ef)object).F5("\u64ad\u653e");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file.getName());
        stringBuilder.append("$");
        stringBuilder.append(file.getAbsolutePath());
        ((Ef)object).v3(stringBuilder.toString());
        return Tq.v((Ef)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String homeContent(boolean bl) {
        List<Object> list;
        ArrayList<Jz> arrayList = new ArrayList<Jz>();
        arrayList.add(new Jz(Environment.getExternalStorageDirectory().getAbsolutePath(), "\u672c\u5730\u6587\u4ef6", "1"));
        File[] fileArray = new File("/storage").listFiles();
        if (fileArray == null) {
            list = new ArrayList<Ef>();
            return Tq.xa(arrayList, list);
        }
        list = Arrays.asList("emulated", "sdcard", "self");
        for (File file : fileArray) {
            if (list.contains(file.getName())) continue;
            arrayList.add(new Jz(file.getAbsolutePath(), file.getName(), "1"));
        }
        list = new ArrayList();
        return Tq.xa(arrayList, list);
    }

    public void init(Context context, String string) {
        this.yq = new SimpleDateFormat("yyyyy/MM/dd HH:mm:ss", Locale.getDefault());
    }

    public String playerContent(String object, String object2, List<String> list) {
        Tq tq = new Tq();
        object = new StringBuilder();
        object.append("file://");
        object.append((String)object2);
        tq.g1(object.toString());
        object = new File((String)object2);
        object = object.getParentFile() == null ? null : object.getParentFile().listFiles();
        if (object != null && ((File[])object).length != 0) {
            list = new ArrayList<String>();
            int n = ((File[])object).length;
            int n2 = 0;
            while (true) {
                object2 = list;
                if (n2 < n) {
                    object2 = object[n2];
                    Object object3 = ME.dT(((File)object2).getName());
                    if (ME.xa((String)object3)) {
                        Object object4 = new qq_0();
                        ((qq_0)object4).N(ME.g1(((File)object2).getName()));
                        object3 = ((qq_0)object4).SN((String)object3);
                        object4 = oi_0.yq("file://");
                        ((StringBuilder)object4).append(((File)object2).getAbsolutePath());
                        ((qq_0)object3).zH(((StringBuilder)object4).toString());
                        ((ArrayList)list).add((String)object3);
                    }
                    ++n2;
                    continue;
                }
                break;
            }
        } else {
            object2 = Collections.emptyList();
        }
        tq.O((List<qq_0>)object2);
        return tq.toString();
    }
}

