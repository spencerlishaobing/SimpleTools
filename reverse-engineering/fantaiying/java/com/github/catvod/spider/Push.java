/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.text.TextUtils
 */
package com.github.catvod.spider;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.Youtube;
import com.github.catvod.spider.merge.Bo;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.eY;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.qq_0;
import com.github.catvod.spider.merge.uA;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Push
extends Pan {
    @Override
    public String detailContent(List<String> object) {
        String string = object.get(0).trim();
        uA.dT(false);
        if (string.contains("quark") && !string.contains("192.168") && !string.contains("127.0.0")) {
            return super.detailContent((List<String>)object);
        }
        if (string.contains("aliyundrive") && !string.contains("192.168") && !string.contains("127.0.0")) {
            return super.detailContent((List<String>)object);
        }
        if (string.contains("alipan") && !string.contains("192.168") && !string.contains("127.0.0")) {
            return super.detailContent((List<String>)object);
        }
        if (string.contains("drive.uc.cn") && !string.contains("192.168") && !string.contains("127.0.0")) {
            return super.detailContent((List<String>)object);
        }
        if (string.contains("pan.baidu.com") && !string.contains("192.168") && !string.contains("127.0.0")) {
            return super.detailContent((List<String>)object);
        }
        if (!string.startsWith("magnet") && !string.startsWith("cili")) {
            Ef ef = new Ef();
            ef.G(string);
            ef.Gc("FongMi");
            object = string.startsWith("file://") ? new File(string).getName() : string;
            ef.G4((String)object);
            ef.dT("https://pic.rmb.bdstatic.com/bjh/1d0b02d0f57f0a42201f92caba5107ed.jpeg");
            ef.F5(TextUtils.join((CharSequence)"$$$", Arrays.asList("\u76f4\u9023", "\u55c5\u63a2", "\u89e3\u6790")));
            ef.v3(TextUtils.join((CharSequence)"$$$", Arrays.asList(eY.yq("\u64ad\u653e$", string), eY.yq("\u64ad\u653e$", string), eY.yq("\u64ad\u653e$", string))));
            return Tq.v(ef);
        }
        return super.detailContent((List<String>)object);
    }

    @Override
    public void init(Context context, String string) {
        super.init(context, string);
    }

    @Override
    public String playerContent(String object, String string, List<String> list) {
        block13: {
            block11: {
                block9: {
                    block12: {
                        block10: {
                            Object object2;
                            Object object3;
                            Object object4;
                            Object object52;
                            block8: {
                                if (!string.contains("youtube.com")) break block8;
                                object = new Tq();
                                string = Youtube.fetch(string);
                                break block9;
                            }
                            if (!((String)object).equals("\u76f4\u9023")) break block10;
                            object = new Tq();
                            ((Tq)object).g1(string);
                            list = new ArrayList<String>();
                            if (string.startsWith("file://") && ((File)(object52 = new File(string.replace("file://", "")))).getParentFile() != null) {
                                object4 = ((File)object52).getParentFile().listFiles();
                                Objects.requireNonNull(object4);
                                for (Object object52 : object4) {
                                    object3 = ME.dT(((File)object52).getName());
                                    if (!ME.xa((String)object3)) continue;
                                    object2 = new qq_0();
                                    ((qq_0)object2).N(ME.g1(((File)object52).getName()));
                                    object2 = ((qq_0)object2).SN((String)object3);
                                    object3 = oi_0.yq("file://");
                                    ((StringBuilder)object3).append(((File)object52).getAbsolutePath());
                                    ((qq_0)object2).zH(((StringBuilder)object3).toString());
                                    ((ArrayList)list).add((String)object2);
                                }
                            }
                            if (string.startsWith("http://")) {
                                object4 = Arrays.asList("mp4", "mkv");
                                object52 = Arrays.asList("srt", "ass");
                                if (object4.contains(ME.dT(string))) {
                                    object4 = object52.iterator();
                                    while (object4.hasNext()) {
                                        String string2 = (String)object4.next();
                                        object52 = ME.g1(string).concat(".").concat(string2);
                                        if (Bo.B((String)object52, null).length() > 100) continue;
                                        object2 = Uri.parse((String)object52).getLastPathSegment();
                                        object3 = new qq_0();
                                        ((qq_0)object3).N((String)object2);
                                        object2 = ((qq_0)object3).SN(string2);
                                        ((qq_0)object2).zH((String)object52);
                                        ((ArrayList)list).add((String)object2);
                                    }
                                }
                            }
                            ((Tq)object).O(list);
                            break block11;
                        }
                        if (!((String)object).equals("\u55c5\u63a2")) break block12;
                        object = new Tq();
                        ((Tq)object).F5();
                        break block9;
                    }
                    if (!((String)object).equals("\u89e3\u6790")) break block13;
                    object = new Tq();
                    ((Tq)object).F5();
                    ((Tq)object).q();
                }
                ((Tq)object).g1(string);
            }
            return ((Tq)object).toString();
        }
        return super.playerContent((String)object, string, list);
    }
}

