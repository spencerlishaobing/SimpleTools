/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.github.catvod.crawler.Spider
 */
package com.github.catvod.spider;

import android.text.TextUtils;
import com.github.catvod.crawler.Spider;
import com.github.catvod.spider.merge.Am;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.Jz;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.TO;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.iK;
import com.github.catvod.spider.merge.p9;
import com.github.catvod.spider.merge.zm_0;
import java.net.URLEncoder;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class Dm84
extends Spider {
    private String SN = "https://hhjx.hhplayer.com/api/parse";
    private String yq = "http://dmbus.cc";

    private HashMap<String, String> N(String string) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("User-Agent", "Mozilla/5.0 (X11; Linux aarch64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36");
        if (!ME.ee(string)) {
            hashMap.put("origin", string);
        }
        hashMap.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        hashMap.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
        return hashMap;
    }

    private HashMap<String, String> SN() {
        return this.N("");
    }

    private p9 yq(String string, String string2, List<String> object) {
        ArrayList<p9.yq> arrayList = new ArrayList<p9.yq>();
        Iterator<String> iterator = object.iterator();
        while (iterator.hasNext()) {
            String string3 = iterator.next();
            if (string3.isEmpty()) continue;
            String string4 = string3.replace("\u6309", "");
            object = string3;
            if (string2.equals("by")) {
                object = string3.replace("\u6309\u65f6\u95f4", "time").replace("\u6309\u4eba\u6c14", "hits").replace("\u6309\u8bc4\u5206", "score");
            }
            arrayList.add(new p9.yq(string4, (String)object));
        }
        return new p9(string2, string, arrayList);
    }

    public String categoryContent(String object, String string, boolean bl, HashMap<String, String> object2) {
        ArrayList<Ef> arrayList = new ArrayList<Ef>();
        if (((HashMap)object2).get("type") == null) {
            ((HashMap)object2).put((String)"type", (String)"");
        }
        if (((HashMap)object2).get("year") == null) {
            ((HashMap)object2).put((String)"year", (String)"");
        }
        if (((HashMap)object2).get("by") == null) {
            ((HashMap)object2).put((String)"by", (String)"time");
        }
        String string2 = ((HashMap)object2).get("by");
        Object object32 = URLEncoder.encode(((HashMap)object2).get("type"));
        object2 = ((HashMap)object2).get("year");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.yq);
        stringBuilder.append(String.format("/show-%s--%s-%s--%s-%s.html", object, string2, object32, object2, string));
        for (Object object32 : Am.yq(zm_0.SN(stringBuilder.toString(), this.SN(), 0)).cS("div.item")) {
            string2 = ((hN)object32).cS("a.cover").yq("data-bg");
            object2 = ((hN)object32).cS("a.title").yq("href");
            string = ((hN)object32).cS("a.title").t0();
            if (TO.zH(string)) continue;
            object32 = ((hN)object32).cS("span.desc").t0();
            arrayList.add(new Ef(((String)object2).split("/")[2], string, string2, (String)object32));
        }
        return Tq.ee(arrayList);
    }

    public String detailContent(List<String> kb_02) {
        Cloneable cloneable = Am.yq(zm_0.SN(this.yq.concat("/v/").concat(kb_02.get(0)), this.SN(), 0));
        Object object = ((hN)cloneable).cS("h1.v_title").t0();
        Object object2 = ((hN)cloneable).cS("p.v_desc > span.desc").t0();
        String string = ((hN)cloneable).cS("meta[property=og:image]").yq("content");
        String string2 = ((hN)cloneable).cS("meta[name=og:video:area]").yq("content");
        Object object3 = ((hN)cloneable).cS("meta[name=og:video:class]").yq("content");
        CharSequence charSequence = ((hN)cloneable).cS("meta[name=og:video:actor]").yq("content");
        String string3 = ((hN)cloneable).cS("meta[property=og:description]").yq("content");
        String string4 = ((hN)cloneable).cS("meta[name=og:video:release_date]").yq("content");
        Object object4 = ((hN)cloneable).cS("meta[name=og:video:director]").yq("content");
        Ef ef = new Ef();
        ef.G(kb_02.get(0));
        ef.dT(string);
        ef.ee(string4);
        ef.G4((String)object);
        ef.KJ(string2);
        ef.M((String)charSequence);
        ef.W((String)object2);
        ef.q(string3);
        ef.B((String)object4);
        ef.Gc((String)object3);
        object3 = new LinkedHashMap();
        kb_02 = ((hN)cloneable).cS("ul.tab_control > li");
        object2 = ((hN)cloneable).cS("ul.play_list");
        for (int i2 = 0; i2 < ((AbstractCollection)kb_02).size(); ++i2) {
            string3 = ((hN)((AbstractList)kb_02).get(i2)).Fo();
            cloneable = ((hN)((AbstractList)object2).get(i2)).cS("a");
            object = new ArrayList();
            for (int i4 = 0; i4 < ((AbstractCollection)((Object)cloneable)).size(); ++i4) {
                object4 = (hN)((AbstractList)((Object)cloneable)).get(i4);
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(((hN)object4).Fo());
                ((StringBuilder)charSequence).append("$");
                ((StringBuilder)charSequence).append(((iK)object4).N("href"));
                ((ArrayList)object).add(((StringBuilder)charSequence).toString());
            }
            if (((ArrayList)object).size() <= 0) continue;
            object3.put(string3, TextUtils.join((CharSequence)"#", (Iterable)object));
        }
        if (object3.size() > 0) {
            ef.F5(TextUtils.join((CharSequence)"$$$", ((LinkedHashMap)object3).keySet()));
            ef.v3(TextUtils.join((CharSequence)"$$$", ((LinkedHashMap)object3).values()));
        }
        return Tq.v(ef);
    }

    public String homeContent(boolean bl) {
        Object object;
        ArrayList<Ef> arrayList = new ArrayList<Ef>();
        ArrayList<Jz> arrayList2 = new ArrayList<Jz>();
        LinkedHashMap<String, List<p9>> linkedHashMap = new LinkedHashMap<String, List<p9>>();
        Object object2 = Am.yq(zm_0.SN(this.yq, this.SN(), 0));
        for (hN object3 : ((hN)object2).cS("ul.nav_row > li > a")) {
            if (!object3.N("href").startsWith("/list")) continue;
            arrayList2.add(new Jz(object3.N("href").split("-")[1].substring(0, 1), object3.Fo().substring(0, 2)));
        }
        for (Jz jz : arrayList2) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(this.yq);
            ((StringBuilder)object2).append("/list-");
            ((StringBuilder)object2).append(jz.yq());
            ((StringBuilder)object2).append(".html");
            object2 = Am.yq(zm_0.SN(((StringBuilder)object2).toString(), this.SN(), 0));
            object = ((hN)object2).cS("ul.list_filter > li > div");
            ArrayList<p9> arrayList3 = new ArrayList<p9>();
            arrayList3.add(this.yq("\u7c7b\u578b", "type", ((hN)((AbstractList)object).get(0)).cS("a").SN()));
            arrayList3.add(this.yq("\u65f6\u95f4", "year", ((hN)((AbstractList)object).get(1)).cS("a").SN()));
            arrayList3.add(this.yq("\u6392\u5e8f", "by", ((hN)((AbstractList)object).get(2)).cS("a").SN()));
            ((AbstractMap)linkedHashMap).put(jz.yq(), arrayList3);
        }
        for (ArrayList<p9> arrayList3 : ((hN)object2).cS("div.item")) {
            object = ((hN)((Object)arrayList3)).cS("a.cover").yq("data-bg");
            object2 = ((hN)((Object)arrayList3)).cS("a.title").yq("href");
            String string = ((hN)((Object)arrayList3)).cS("a.title").t0();
            arrayList3 = ((hN)((Object)arrayList3)).cS("span.desc").t0();
            arrayList.add(new Ef(((String)object2).split("/")[2], string, (String)object, (String)((Object)arrayList3)));
        }
        return Tq.Gd(arrayList2, arrayList, linkedHashMap);
    }

    /*
     * Exception decompiling
     */
    public String playerContent(String var1_1, String var2_2, List<String> var3_4) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [22[UNCONDITIONALDOLOOP]], but top level block is 13[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public String searchContent(String string, boolean bl) {
        ArrayList<Ef> arrayList = new ArrayList<Ef>();
        for (Object object : Am.yq(zm_0.SN(this.yq.concat("/s----------.html?wd=").concat(string), this.SN(), 0)).cS("div.item")) {
            String string2 = ((hN)object).cS("a.cover").yq("data-bg");
            String string3 = ((hN)object).cS("a.title").yq("href");
            string = ((hN)object).cS("a.title").t0();
            if (TO.zH(string)) continue;
            object = ((hN)object).cS("span.desc").t0();
            arrayList.add(new Ef(string3.split("/")[2], string, string2, (String)object));
        }
        return Tq.ee(arrayList);
    }
}

