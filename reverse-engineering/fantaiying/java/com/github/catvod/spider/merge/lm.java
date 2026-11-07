/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.gson.annotations.SerializedName
 */
package com.github.catvod.spider.merge;

import android.text.TextUtils;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.gl_0;
import com.github.catvod.spider.merge.k_0;
import com.github.catvod.spider.merge.oX;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.uA;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class lm {
    @SerializedName(value="directors")
    private List<N> B;
    @SerializedName(value="source_list_source")
    private List<SN> G;
    @SerializedName(value="dataList")
    private List<lm> G4;
    @SerializedName(value="year")
    private String Gc;
    @SerializedName(value="types")
    private List<N> KJ;
    @SerializedName(value="area")
    private String M;
    @SerializedName(alternate={"path"}, value="thumbnail")
    private String N;
    @SerializedName(value="id")
    private String SN;
    @SerializedName(value="description")
    private String i;
    @SerializedName(value="actors")
    private List<N> q;
    @SerializedName(value="playlist")
    private N t0;
    @SerializedName(value="title")
    private String tF;
    @SerializedName(value="jump_id")
    private String yq;
    @SerializedName(value="mask")
    private String zH;

    public final String B() {
        String string;
        String string2 = string = this.Gc;
        if (string == null) {
            string2 = "";
        }
        return string2;
    }

    public final Ef G(String string) {
        String string2 = TextUtils.isEmpty((CharSequence)this.yq) ? "" : this.yq;
        return new Ef(string2, this.t0(), this.i(string));
    }

    public final Ef G4(String object) {
        boolean bl = TextUtils.isEmpty((CharSequence)this.SN);
        String string = "";
        String string2 = bl ? "" : this.SN;
        String string3 = this.t0();
        String string4 = this.i((String)object);
        object = TextUtils.isEmpty((CharSequence)this.zH) ? ((object = this.t0) == null ? string : ((N)object).SN()) : this.zH;
        return new Ef(string2, string3, string4, (String)object);
    }

    public final String Gc() {
        List<N> list = this.KJ;
        list = list == null ? "" : this.M(list, false);
        return list;
    }

    public final String KJ() {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        List<SN> list = this.G;
        Object object = list;
        if (list == null) {
            object = Collections.emptyList();
        }
        object = object.iterator();
        while (object.hasNext()) {
            arrayList.add(((SN)object.next()).SN());
        }
        if (!uA.yq) {
            object = oi_0.yq((String)arrayList.get(0));
            ((StringBuilder)object).append(uA.tF);
            object = ((StringBuilder)object).toString();
            arrayList.remove(0);
            arrayList.add(0, object);
        }
        return TextUtils.join((CharSequence)"$$$", arrayList);
    }

    public final String M(List<N> object, boolean bl) {
        CharSequence charSequence = new StringBuilder();
        object = object.iterator();
        while (object.hasNext()) {
            ((StringBuilder)charSequence).append(((N)object.next()).N(bl));
            ((StringBuilder)charSequence).append(" ");
        }
        charSequence = ((StringBuilder)charSequence).toString();
        int n2 = gl_0.yq;
        object = charSequence;
        if (charSequence != null) {
            object = charSequence;
            if (((String)charSequence).length() > 1) {
                object = ((String)charSequence).substring(0, ((String)charSequence).length() - 1);
            }
        }
        return object;
    }

    public final List<lm> N() {
        List<lm> list;
        List<lm> list2 = list = this.G4;
        if (list == null) {
            list2 = Collections.emptyList();
        }
        return list2;
    }

    public final String SN() {
        String string;
        String string2 = string = this.M;
        if (string == null) {
            string2 = "";
        }
        return string2;
    }

    public final String i(String charSequence) {
        if (TextUtils.isEmpty((CharSequence)this.N)) {
            charSequence = "";
        } else {
            charSequence = oX.yq("http://", (String)charSequence);
            ((StringBuilder)charSequence).append(this.N);
            charSequence = ((StringBuilder)charSequence).toString();
        }
        return charSequence;
    }

    public final String q() {
        ArrayList<String> arrayList = new ArrayList<String>();
        List<SN> list = this.G;
        List<SN> list2 = list;
        if (list == null) {
            list2 = Collections.emptyList();
        }
        for (SN sN : list2) {
            list2 = new ArrayList<SN>();
            for (yq yq2 : sN.yq()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(yq2.yq());
                stringBuilder.append("$");
                stringBuilder.append(yq2.SN());
                ((ArrayList)list2).add((SN)((Object)stringBuilder.toString()));
            }
            arrayList.add(TextUtils.join((CharSequence)"#", list2));
        }
        return TextUtils.join((CharSequence)"$$$", arrayList);
    }

    public final String t0() {
        String string = TextUtils.isEmpty((CharSequence)this.tF) ? "" : this.tF;
        return string;
    }

    public final String tF() {
        boolean bl = TextUtils.isEmpty((CharSequence)this.i);
        String string = "";
        if (!bl) {
            string = this.i.replace("\u3000", "");
        }
        return string;
    }

    public final String yq() {
        List<N> list = this.q;
        list = list == null ? "" : this.M(list, true);
        return list;
    }

    public final String zH() {
        List<N> list = this.B;
        list = list == null ? "" : this.M(list, true);
        return list;
    }

    public static final class N {
        @SerializedName(alternate={"name"}, value="title")
        private String yq;

        private String SN() {
            String string = TextUtils.isEmpty((CharSequence)this.yq) ? "" : this.yq;
            return string;
        }

        public final String N(boolean bl) {
            String string = bl ? String.format("[a=cr:{\"id\":\"%s\",\"name\":\"%s\"}/]%s[/a]", k_0.i(new StringBuilder(), this.SN(), "/{pg}"), this.SN(), this.SN()) : this.SN();
            return string;
        }
    }

    public static final class SN {
        @SerializedName(value="source_list")
        private List<yq> SN;
        @SerializedName(value="name")
        private String yq;

        public final String SN() {
            String string = TextUtils.isEmpty((CharSequence)this.yq) ? "" : this.yq;
            return string;
        }

        public final List<yq> yq() {
            List<yq> list;
            List<yq> list2 = list = this.SN;
            if (list == null) {
                list2 = Collections.emptyList();
            }
            return list2;
        }
    }

    public static final class yq {
        @SerializedName(value="url")
        private String SN;
        @SerializedName(value="source_name")
        private String yq;

        public final String SN() {
            String string = TextUtils.isEmpty((CharSequence)this.SN) ? "" : this.SN.replaceAll("ftp", "tvbox-xg:ftp");
            return string;
        }

        public final String yq() {
            String string = TextUtils.isEmpty((CharSequence)this.yq) ? "" : this.yq;
            return string;
        }
    }
}

