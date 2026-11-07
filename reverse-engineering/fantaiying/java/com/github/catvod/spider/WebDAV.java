/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.github.catvod.crawler.Spider
 *  com.github.catvod.crawler.SpiderDebug
 *  com.thegrizzlylabs.sardineandroid.DavResource
 *  com.thegrizzlylabs.sardineandroid.Sardine
 *  okhttp3.Response
 *  okhttp3.ResponseBody
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.content.Context;
import android.text.TextUtils;
import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\u0638\ufead\u062e\ufee1;
import com.github.catvod.parser.\u0645\u0641\u0630\u062d;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufe8f\ufe8e\ufeb5\u0641;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufe9d\u0631\ufe8f\u064a;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.parser.\ufeb9\ufec9\u0648\u062d;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.ProxyOrigin;
import com.github.catvod.spider.merge.Bo;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.Jz;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.WN;
import com.github.catvod.spider.merge.oX;
import com.github.catvod.spider.merge.of;
import com.github.catvod.spider.merge.p9;
import com.github.catvod.spider.merge.qq_0;
import com.github.catvod.spider.merge.rs_0;
import com.github.catvod.spider.merge.uA;
import com.github.catvod.spider.merge.w2;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufea5\ufea9\u0633\ufed5;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufebd\u0640\u0648\u062b;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\u0636\u0634\ufec1\u0631;
import com.github.catvod.spider.\u0640\u0633\ufea5\u0631;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufe8e\u0627\ufecd\u062a;
import com.github.catvod.spider.\ufe8e\ufeb9\u0647\u0642;
import com.github.catvod.spider.\ufe99\u062c\u0643\ufec1;
import com.github.catvod.spider.\ufea5\u062d\ufebd\u0633;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import com.github.catvod.spider.\ufeaf\u0633\u0648\ufee9;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import com.github.catvod.spider.\ufeb5\ufe8e\ufead\u0632;
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import com.thegrizzlylabs.sardineandroid.DavResource;
import com.thegrizzlylabs.sardineandroid.Sardine;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class WebDAV
extends Spider {
    private static String N;
    private static List<String> SN;
    private static final short[] short;
    private static long tF;
    private static List<WN> yq;

    static {
        short = WebDAV.$d2j$hex$4fe793b0$decode_S("840a840a840a22062206220683058305830516057002b307a407a707a407b307a407b3071e0814080e085a081a081208030816081308160803081608f50ce60ce90ce00ce20c090b0b0b0b0b0d0b180b1c0b450b0d0b060b0b0b070b0c0b010b060b0f0bc302c502d302c4029b02d702d102d302d802c202a603aa03ab03ab03a003a603b103ac03aa03ab036c07630760077c076a075002730261027b0271023202d7041a042e042f04330434042904320421043a042f0432043404350497068c06810690068606c806dd06a9069106de06dc06b50c100b0b0b060b170b010b520bd602fa02fb02e102f002fb02e102b802c702f402fb02f202f0027a0c560c570c4d0c5c0c570c4d0c140c750c5c0c570c5e0c4d0c510cab05ba05ba05a605a305a905ab05be05a305a505a405e505a505a905be05e705b905be05b805af05ab05a70522043304200437043c042604ec0c5c0352034e03400358034503530344037905690565057a056f0511070007060704071c0709071e0733071c070d070b0709071a040b04190419041d04050418040e04c50cf10cf00cec0ceb0cf60ced0cfe0ce50cf00ced0ceb0cea0c55091b090a09130955091c090909550909091f091b090809190912093206200627062106240633061409f707ea07fc07fd07ea07f009fd09f409e109a502b902b902bd02be02f702e202e202a402a002aa02fd02fa02e302be02a202aa02a202b802ae02a902a302e302ae02a202a002e202bb02ff02e202b902a502b802a002af02e202bf02a802b902b402bd02a8029202a802b502ae02a102b802a902a8029202aa02a402ab02e202a802b502b902e202ac02b802b902a202e202bc02e202f402f802e202ae02bf02a202bd02e202b502b402e202ac02a402e202b902e202fd02e202f202ac02bd02bd02a402a902f002fc02ff02ff02eb02b802bf02a102f002a502b902b902bd02be02f702e202e202a202be02be02f902a102a402bb02a402a802ba02e302a002a202a702a402e302ae02a202a002e202b902a502a9029202ab02a402a102a802e202ff02fd02ff02f802e202fd02fa02e202ff02f502e202a802a902a902fc02a902ab02af02fc02fc02ac02ab02a902fa02fa02af02fd02fd02fe02fc02fd02f802fa02f902fc02fd02f402ab02fc02a902fe02f802af02e302a702bd02aa02690c2e0c340c280c90048c048c0488048b04c204d704d704910495049f04c804cf04d6048b0497049f0497048d049b049c049604d6049b0497049504d7048e04ca04d7048c0490048d0495049a04d7048a049d048c04810488049d04a7049d0480049b0494048d049c049d04a7049f0491049e04d7049d0480048c04d70499048d048c049704d7048904d704c104cd04d7049b048a0497048804d70480048104d70499049104d7048c04d704c804d704c70499048804880491049c04c504c904ca04ca04de048d048a049404c50490048c048c0488048b04c204d704d7048b04c904d6049104950499049f049d0490048d049a04d6049b049b04d7049104950499049f049d048b04d704ca04c804ca04ce04d704c804cb04d704c804c904d7049d04cb049b04c904c9049d049b04c104cd04c1049d04cc049904c104c90499049c04c1049b04cf04c1049904c904c904cf04ca049a04cc049c04cb04ca04cf04a608ba08ba08be08bd08f408e108e108a708a308a908fe08f908e008bd08a108a908a108bb08ad08aa08a008e008ad08a108a308e108b808fc08e108ba08a608bb08a308ac08e108bc08ab08ba08b708be08ab089108ab08b608ad08a208bb08aa08ab089108a908a708a808e108ab08b608ba08e108af08bb08ba08a108e108bf08e108f708fb08e108ad08bc08a108be08e108b608b708e108af08a708e108ba08e108fe08e108f108af08be08be08a708aa08f308ff08fc08fc08e808bb08bc08a208f308a608ba08ba08be08bd08f408e108e108a108bd08bd08fa08a208a708b808a708ab08b908e008a308a108a408a708e008ad08a108a308e108ba08a608aa089108a808a708a208ab08e108fc08fe08fc08fb08e108fe08f908e108fc08f608e108af08f808ac08aa08ac08fc08fc08ad08ad08fa08ac08fe08ac08a808ad08f908ac08fd08fd08fd08a808ab08ad08fb08aa08fe08fc08f908ac08f708fb08ff08e008a408be08a908830a250c2a0c260c2e0c2c023e022e02550be90c92065f055c0c010c060c000c1f0cc70ae108dd08e1083c0867945a86145f28713b053405380530059b5eb35b3d0a270a340a2b0a4547926de96e389d13051605030512057f0a720a7b0a6e0ae36afe572f91fa5e1a20af05bd05ad054f2ff008f108e708f70868097509630962097509a065bd588b633d59240636063606080208021a0250055105570539062506250621063e083f08140838023802380211030d032d031103ce049304940492048d044908200c");
    }

    private static WN N(String string) {
        List<WN> list = yq;
        return list.get(list.indexOf(new WN(string)));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private String SN(WN object, DavResource object2, List<DavResource> davResource) {
        Object object3;
        String string;
        CharSequence charSequence;
        StringBuilder stringBuilder = new StringBuilder();
        Object object4 = davResource.iterator();
        while (true) {
            boolean bl = object4.hasNext();
            charSequence = \ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(short, 0, 3, 2810);
            string = \u062b\ufec1\ufeb1\u062d.\u0637\u0647\u0635\u0630(short, 3, 3, 1634);
            if (!bl) break;
            object3 = (DavResource)object4.next();
            if (!ME.g1(object3.getName()).equals(ME.g1(object2.getName()))) continue;
            stringBuilder.append((String)charSequence);
            stringBuilder.append(object3.getName());
            stringBuilder.append(string);
            stringBuilder.append(ME.dT(object3.getName()));
            stringBuilder.append(string);
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(((WN)object).zH());
            ((StringBuilder)charSequence).append(object3.getPath());
            stringBuilder.append(((StringBuilder)charSequence).toString());
        }
        if (stringBuilder.length() > 0) {
            return stringBuilder.toString();
        }
        object2 = new StringBuilder();
        object3 = davResource.iterator();
        while (object3.hasNext()) {
            davResource = (DavResource)object3.next();
            ((StringBuilder)object2).append((String)charSequence);
            ((StringBuilder)object2).append(davResource.getName());
            ((StringBuilder)object2).append(string);
            ((StringBuilder)object2).append(ME.dT(davResource.getName()));
            ((StringBuilder)object2).append(string);
            object4 = new StringBuilder();
            ((StringBuilder)object4).append(((WN)object).zH());
            ((StringBuilder)object4).append(davResource.getPath());
            ((StringBuilder)object2).append(((StringBuilder)object4).toString());
        }
        return ((StringBuilder)object2).toString();
    }

    /*
     * Enabled aggressive block sorting
     */
    private List<qq_0> i(String[] stringArray) {
        ArrayList<qq_0> arrayList = new ArrayList<qq_0>();
        int n = stringArray.length;
        int n2 = 0;
        while (n2 < n) {
            String string = stringArray[n2];
            String string2 = \ufeaf\u0633\u0648\ufee9.\u062e\u0645\u0644\u0648(short, 6, 3, 1475);
            if (string.contains(string2)) {
                String[] stringArray2 = string.split(string2);
                String string3 = stringArray2[0];
                String string4 = stringArray2[1];
                String string5 = this.zH(stringArray2[2]);
                qq_0 qq_02 = new qq_0();
                qq_02.N(string3);
                qq_0 qq_03 = qq_02.SN(string4);
                qq_03.zH(string5);
                arrayList.add(qq_03);
            }
            ++n2;
        }
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     */
    private List<DavResource> tF(WN object, String string, List<String> list) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append(((WN)object).tF());
        if (!string.startsWith(((WN)object).t0())) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(((WN)object).t0());
            stringBuilder.append(string);
            string = stringBuilder.toString();
        }
        ((StringBuilder)object2).append(string);
        string = ((StringBuilder)object2).toString();
        object = ((WN)object).q().list(string);
        object.remove(0);
        object2 = object.iterator();
        while (object2.hasNext()) {
            string = (DavResource)object2.next();
            if ((string.isDirectory() || string.getName().contains(\ufe8f\ufe8e\ufeb5\u0641.\u062f\u0627\u0640\ufee1(short, 9, 1, 1336))) && (string.isDirectory() || list.contains(ME.dT(string.getName())))) continue;
            object2.remove();
        }
        return object;
    }

    /*
     * Exception decompiling
     */
    public static Object[] vod(Map<String, String> var0, String var1_1, Map<String, String> var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous, and can't clone.
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:611)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:94)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:517)
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

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static String yq(WebDAV object, WN object2, String object3) {
        void var0_19;
        Object object4;
        String string;
        block2: {
            WN wN;
            Objects.requireNonNull(object);
            string = "";
            WN wN2 = wN = null;
            try {
                Response response;
                WN wN3 = wN;
                JSONObject jSONObject = new JSONObject();
                WN wN4 = wN;
                jSONObject.put(\u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(short, 162, 6, 1106), (Object)\ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644(short, 168, 1, 3267));
                WN wN5 = wN;
                jSONObject.put(\ufe95\u0627\ufe8e\u0644.\u062d\u0636\ufea9\u0640(short, 169, 8, 823), (Object)response);
                WN wN6 = wN;
                jSONObject.put(\ufe8e\ufeb9\u0647\u0642.\ufee1\u062f\ufedd\u0643(short, 177, 5, 1290), 0);
                WN wN7 = wN;
                jSONObject.put(\ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(short, 182, 4, 1889), 1);
                WN wN8 = wN;
                jSONObject.put(\ufea1\u0645\u062b\u0634.\u0638\ufec9\u0630\ufe95(short, 186, 8, 1900), 100);
                WN wN9 = wN;
                jSONObject.put(\ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(short, 194, 8, 1130), (Object)"");
                WN wN10 = wN;
                response = ME.yq();
                WN wN11 = wN;
                response.put((String)\ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(short, 202, 13, 3204), (String)((WN)object4).KJ());
                WN wN13 = wN;
                wN13 = wN;
                StringBuilder stringBuilder = new StringBuilder();
                WN wN14 = wN;
                stringBuilder.append(((WN)object4).tF());
                WN wN15 = wN;
                stringBuilder.append(\ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644(short, 215, 14, 2426));
                WN wN16 = wN;
                Response response2 = response = w2.dT(stringBuilder.toString(), jSONObject.toString(), response);
                object4 = response;
                if (response.code() != 200) break block2;
                Response response3 = response;
                Object object5 = object4 = response.body().string();
                return var0_19;
            }
            catch (Exception exception) {
                SpiderDebug.log((Throwable)exception);
                object4 = wN2;
            }
        }
        String string2 = string;
        if (object4 == null) return var0_19;
        object4.close();
        String string3 = string;
        return var0_19;
    }

    private String zH(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ProxyOrigin.getOwnProxyUrl(\u062d\ufeb9\ufeab\ufef1.\ufeed\u0638\u0635\ufed5(short, 229, 6, 1605)));
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static InputStream \u062b\u0640\ufe95\u062a(Object object) {
        if (\ufe99\u062e\u0642\u0644.\ufe99\ufec9\ufec5\u0646() > 0) return null;
        return ((ResponseBody)object).byteStream();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static WN \u062e\u0644\ufebd\ufeb5(Object object) {
        if (\u0633\u064a\u0644\u0637.\ufec1\u062e\u0643\ufedd() < 0) return null;
        return WebDAV.N((String)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static ResponseBody \u0631\u0633\u062a\ufed5(Object object) {
        if (\u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead() < 0) return null;
        return ((Response)object).body();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static long \u0631\u0637\u0634\u0639() {
        if (\ufea9\ufe8f\u0647\ufead.\ufe95\ufeb1\ufeaf\u0641() < 0) return 0L;
        return tF;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Response \u0647\u0637\ufe95\ufead(Object object, Object object2) {
        if (\u062d\u062e\ufe8e\u0645.\u0637\ufea1\ufed5\ufeab() > 0) return null;
        return Bo.zH((String)object, (Map)object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static short[] \ufebd\ufead\ufeb9\ufe99() {
        if (\u0636\u0634\ufec1\u0631.\u0648\ufedd\ufeb5\ufed9() <= 0) return null;
        return short;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public String categoryContent(String object, String object2, boolean bl, HashMap<String, String> cloneable) {
        void var5_15;
        void var2_5;
        Object object3;
        String string;
        ArrayList<Ef> arrayList;
        String string2;
        String string3 = URLDecoder.decode((String)object);
        object = string3.contains(string2 = \ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644(short, 235, 1, 2363)) ? string3.substring(0, string3.indexOf(string2)) : string3;
        boolean bl2 = string3.contains(string2);
        String string4 = "";
        if (bl2) {
            String string5 = string3.substring(string3.indexOf(string2));
        } else {
            String string6 = "";
        }
        if (((HashMap)((Object)arrayList)).containsKey(string = \ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(short, 236, 5, 1944))) {
            String string7 = (String)((HashMap)((Object)arrayList)).get(string);
        } else {
            String string8 = "";
        }
        if (((HashMap)((Object)arrayList)).containsKey(object3 = \ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(short, 241, 4, 2436))) {
            string4 = (String)((HashMap)((Object)arrayList)).get(object3);
        }
        ArrayList<DavResource> arrayList2 = new ArrayList<DavResource>();
        ArrayList<DavResource> arrayList3 = new ArrayList<DavResource>();
        arrayList = new ArrayList<Ef>();
        object3 = WebDAV.N((String)object);
        for (DavResource davResource : this.tF((WN)object3, (String)var2_5, ME.N)) {
            if (davResource.isDirectory()) {
                arrayList2.add(davResource);
                continue;
            }
            arrayList3.add(davResource);
        }
        if (!TextUtils.isEmpty((CharSequence)string4) && !TextUtils.isEmpty((CharSequence)var5_15)) {
            of.yq(string4, (String)var5_15, arrayList2);
            of.yq(string4, (String)var5_15, arrayList3);
        }
        object = arrayList2.iterator();
        while (object.hasNext()) {
            arrayList.add(((WN)object3).dT((DavResource)object.next(), \u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(short, 245, 183, 717)));
        }
        Iterator iterator = arrayList3.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                object = new Tq();
                ((Tq)object).b(arrayList);
                ((Tq)object).dT(1, 1, 0, 1);
                return ((Tq)object).toString();
            }
            DavResource davResource = (DavResource)iterator.next();
            object = davResource.getName().contains(\ufebd\u0640\u0648\u062b.\ufea5\u0639\u0631\ufe95(short, 428, 4, 3143)) ? \ufee9\u0631\ufeb5\u0628.\u0636\ufeab\u0634\u0633(short, 432, 172, 1272) : \ufeb9\u0643\ufed9\ufed5.\u0628\u062f\ufea1\u0642(short, 604, 183, 2254);
            arrayList.add(((WN)object3).dT(davResource, (String)object));
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public String detailContent(List<String> object) {
        Object object2;
        Object object3 = URLDecoder.decode((String)object.get(0));
        object = ((String)object3).contains((CharSequence)(object2 = \ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(short, 787, 1, 2732))) ? ((String)object3).substring(0, ((String)object3).indexOf((String)object2)) : object3;
        String string = ((String)object3).substring(0, ((String)object3).lastIndexOf((String)object2));
        if (string.contains((CharSequence)object2)) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append(string.substring(string.indexOf((String)object2)));
            ((StringBuilder)object3).append((String)object2);
            object3 = ((StringBuilder)object3).toString();
        } else {
            object3 = "";
        }
        string = string.substring(string.lastIndexOf((String)object2) + 1);
        WN wN = WebDAV.N((String)object);
        object3 = this.tF(wN, (String)object3, SN);
        ArrayList<DavResource> arrayList = new ArrayList<DavResource>();
        Object object4 = object3.iterator();
        while (object4.hasNext()) {
            object2 = (DavResource)object4.next();
            if (!ME.xa(object2.getName())) continue;
            arrayList.add((DavResource)object2);
        }
        of.yq(\ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(short, 788, 4, 3147), \u062a\u0635\ufeb1\u0642.\u0637\u0636\u062a\ufedd(short, 792, 3, 589), (List<DavResource>)object3);
        object4 = new ArrayList();
        Iterator iterator = object3.iterator();
        while (true) {
            boolean bl = iterator.hasNext();
            object3 = \ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(short, 795, 1, 2934);
            if (!bl) {
                object2 = new Ef();
                ((Ef)object2).G(string);
                ((Ef)object2).G4(string);
                ((Ef)object2).F5((String)object);
                ((Ef)object2).v3(TextUtils.join((CharSequence)object3, (Iterable)object4));
                return Tq.v((Ef)object2);
            }
            DavResource davResource = (DavResource)iterator.next();
            object3 = davResource.getName().replace((CharSequence)object3, "").replace(\ufe99\u062c\u0643\ufec1.\u0648\u0634\u063a\ufeb1(short, 796, 1, 3241), "").replace(\ufeab\u062d\u063a\ufea9.\u062f\u0642\ufebd\u064a(short, 797, 1, 1716), "").replace(\ufecd\u0642\u062e\ufe9d.\u0637\ufee9\u0635\u0630(short, 798, 1, 1396), "");
            if (!ME.g9(davResource.getName())) continue;
            bl = davResource.getName().contains(\u062f\ufead\ufeaf\u062d.\ufec9\u0630\ufed9\ufeb1(short, 799, 5, 3186));
            object2 = \ufeaf\u0633\u0648\ufee9.\u062e\u0645\u0644\u0648(short, 804, 1, 2787);
            if (bl) {
                object3 = oX.yq((String)object3, (String)object2);
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(wN.zH());
                ((StringBuilder)object2).append(davResource.getPath());
            } else {
                object3 = oX.yq((String)object3, (String)object2);
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(wN.zH());
                ((StringBuilder)object2).append(davResource.getPath());
                ((StringBuilder)object2).append(\u062f\ufead\ufeaf\u062d.\ufec9\u0630\ufed9\ufeb1(short, 805, 3, 2209));
                ((StringBuilder)object2).append(davResource.getContentLength());
            }
            ((StringBuilder)object3).append(URLEncoder.encode(((StringBuilder)object2).toString()));
            ((StringBuilder)object3).append(this.SN(wN, davResource, arrayList));
            ((ArrayList)object4).add(((StringBuilder)object3).toString());
        }
    }

    public String homeContent(boolean bl) {
        ArrayList<Jz> arrayList = new ArrayList<Jz>();
        LinkedHashMap<String, List<p9>> linkedHashMap = new LinkedHashMap<String, List<p9>>();
        for (WN object2 : yq) {
            arrayList.add(new Jz(object2.zH(), object2.zH(), \ufea9\ufe8f\u0647\ufead.\ufea9\u0643\ufedd\ufeed(short, 808, 1, 2061)));
        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String string = ((Jz)iterator.next()).yq();
            ArrayList<p9> arrayList2 = new ArrayList<p9>();
            Object object = \u062d\ufeb9\ufeab\ufef1.\ufeed\u0638\u0635\ufed5(short, 809, 2, 3191);
            List<p9.yq> list = Arrays.asList(new p9.yq((String)object, ""), new p9.yq(\u062a\u0635\ufeb1\u0642.\u0637\u0636\u062a\ufedd(short, 811, 2, 2841), \u0636\u0634\ufec1\u0631.\u062c\u063a\u0643\u0627(short, 813, 4, 1365)), new p9.yq(\ufeb9\u0627\ufea5\ufe9d.\u062a\ufef1\u062d\u0641(short, 817, 2, 1980), \ufe8e\ufeb9\u0647\u0642.\ufee1\u062f\ufedd\u0643(short, 819, 4, 2638)), new p9.yq(\ufea5\u062d\ufebd\u0633.\ufea5\ufeb1\u0643\ufe8f(short, 823, 4, 2219), \ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(short, 827, 4, 1399)));
            arrayList2.add(new p9(\u062a\ufee1\ufe8e\ufeb9.\ufec5\ufecd\ufea9\ufea5(short, 831, 4, 2571), \ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(short, 835, 4, 2417), list));
            object = Arrays.asList(new p9.yq((String)object, ""), new p9.yq(\u062a\u0635\ufeb1\u0642.\u0637\u0636\u062a\ufedd(short, 839, 1, 2844), \ufee9\u0631\ufeb5\u0628.\u0636\ufeab\u0634\u0633(short, 840, 3, 1486)), new p9.yq(\u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(short, 843, 1, 1096), \ufebd\u0640\u0648\u062b.\ufea5\u0639\u0631\ufe95(short, 844, 4, 2196)));
            arrayList2.add(new p9(\ufeb5\ufe8e\ufead\u0632.\ufe8f\ufef1\u0648\ufe95(short, 848, 5, 2311), \ufeab\u0632\u062f\u0640.\u062f\u0627\ufe95\u0631(short, 853, 4, 1586), (List<p9.yq>)object));
            ((AbstractMap)linkedHashMap).put(string, arrayList2);
        }
        return Tq.g9(arrayList, linkedHashMap);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void init(Context object, String string) {
        SN = object = new ArrayList<String>(Arrays.asList(\ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(short, 857, 3, 1605), \u0635\u0631\u0645\u0628.\u0646\u0627\u062a\u062d(short, 860, 3, 635), \u0645\u0641\u0630\u062d.\u0642\u062a\u0630\ufebd(short, 863, 3, 1315)));
        ((ArrayList)object).addAll(ME.N);
        N = string;
        object = yq;
        if (object != null && !object.isEmpty()) {
            return;
        }
        if (N.startsWith(\u0646\ufecd\ufead\u0647.\u0640\u062e\ufed5\ufeaf(short, 866, 4, 1617))) {
            N = Bo.B(N, null);
        }
        if (N.startsWith(\ufeb9\u0643\ufed9\ufed5.\u0628\u062f\ufea1\u0642(short, 870, 2, 2064))) {
            object = new StringBuilder();
            ((StringBuilder)object).append(ProxyOrigin.getFileUrl());
            ((StringBuilder)object).append(N.replace(\ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(short, 872, 1, 2106), ""));
            N = Bo.B(((StringBuilder)object).toString(), null);
        }
        yq = WN.yq(N);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String playerContent(String object, String stringArray, List<String> object2) {
        uA.dT(false);
        stringArray = stringArray.split(\ufeb9\u0643\ufed9\ufed5.\u0628\u062f\ufea1\u0642(short, 873, 3, 582));
        String[] stringArray2 = URLDecoder.decode(stringArray[0]).split(\ufeb5\ufe8e\ufead\u0632.\ufe8f\ufef1\u0648\ufe95(short, 876, 4, 849));
        if (stringArray2.length > 1) {
            tF = Long.parseLong(stringArray2[1]);
        }
        if (!stringArray2[0].contains(\u0635\u0631\u0645\u0628.\u0646\u0627\u062a\u062d(short, 880, 5, 1248))) {
            object = new Tq();
            ((Tq)object).g1(this.zH(URLEncoder.encode(stringArray2[0])));
            ((Tq)object).O(this.i(stringArray));
            return ((Tq)object).toString();
        }
        CharSequence charSequence = stringArray2[0];
        object = \ufeb9\ufec9\u0648\u062d.\ufee9\u0637\ufef1\u0644(short, 885, 1, 2150);
        object = ((String)charSequence).contains((CharSequence)object) ? stringArray2[0].substring(0, stringArray2[0].indexOf((String)object)) : stringArray2[0];
        WN wN = WebDAV.N((String)object);
        charSequence = new StringBuilder();
        Sardine sardine = wN.q();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(wN.tF());
        stringBuilder.append(stringArray2[0].substring(((String)object).length()));
        object = new BufferedReader(new InputStreamReader(sardine.get(stringBuilder.toString())));
        try {
            String string;
            while ((string = ((BufferedReader)object).readLine()) != null) {
                ((StringBuilder)charSequence).append(string);
                ((StringBuilder)charSequence).append(\ufeb5\ufe8e\ufead\u0632.\ufe8f\ufef1\u0648\ufe95(short, 886, 1, 3114));
            }
        }
        finally {
            ((BufferedReader)object).close();
        }
        if (((StringBuilder)charSequence).length() > 0) {
            ((StringBuilder)charSequence).setLength(((StringBuilder)charSequence).length() - 1);
        }
        object = new Tq();
        ((Tq)object).g1(Bo.N(((StringBuilder)charSequence).toString(), ME.yq()));
        ((Tq)object).O(this.i(stringArray));
        return ((Tq)object).toString();
    }

    public String searchContent(String object, boolean bl) {
        ArrayList arrayList = new ArrayList();
        ArrayList<Job> arrayList2 = new ArrayList<Job>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (WN wN : yq) {
            if (!wN.B().booleanValue()) continue;
            wN.SN();
            arrayList2.add(new Job(this, wN, (String)object));
        }
        object = executorService.invokeAll(arrayList2, 6L, TimeUnit.SECONDS).iterator();
        while (object.hasNext()) {
            arrayList.addAll((Collection)((Future)object.next()).get());
        }
        return Tq.ee(arrayList);
    }

    private static long[] $d2j$hex$4fe793b0$decode_J(String src) {
        byte[] d = WebDAV.$d2j$hex$4fe793b0$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$4fe793b0$decode_I(String src) {
        byte[] d = WebDAV.$d2j$hex$4fe793b0$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$4fe793b0$decode_S(String src) {
        byte[] d = WebDAV.$d2j$hex$4fe793b0$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$4fe793b0$decode_B(String src) {
        char[] d = src.toCharArray();
        byte[] ret = new byte[src.length() / 2];
        for (int i2 = 0; i2 < ret.length; ++i2) {
            int ll;
            int hh;
            char h = d[2 * i2];
            char l = d[2 * i2 + 1];
            if (h >= '0' && h <= '9') {
                hh = h - 48;
            } else if (h >= 'a' && h <= 'f') {
                hh = h - 97 + 10;
            } else if (h >= 'A' && h <= 'F') {
                hh = h - 65 + 10;
            } else {
                throw new RuntimeException();
            }
            if (l >= '0' && l <= '9') {
                ll = l - 48;
            } else if (l >= 'a' && l <= 'f') {
                ll = l - 97 + 10;
            } else if (l >= 'A' && l <= 'F') {
                ll = l - 65 + 10;
            } else {
                throw new RuntimeException();
            }
            ret[i2] = (byte)(hh << 4 | ll);
        }
        return ret;
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    class Job
    implements Callable<List<Ef>> {
        private static final short[] short = Job.$d2j$hex$788e41fd$decode_S("080b0d0b180b0d0b9d05d805c405c405c005c3058a059f059f05d705d905c405d805c505d2059e05d305df05dd059f05d105dc05d905c305c4059d05df05c205d7059f05d105dc05d905c305c40502034c035d03440302034c035803590345030203410342034a0344034303020345034c035e034503a501a301b501a201be01b101bd01b5019a0a8b0a990a990a9d0a850a980a8e0a81069a069e06b1068d0681068a068b06e60afd0af90af70afc0af903cd03cc03d003d703ca03d103c203d903cc03d103d703d603ef08a108b008a908ef08ad08a50806080508170801083b081408050810080c08330b360b230b360b85078907880792078307880792078e039403b80383038e0395034e0c410c4d0c450c83049204810496049d0487047701e104fd04fd04f904fa04b304a604a604e004e404ee04b904be04a704fa04e604ee04e604fc04ea04ed04e704a704ea04e604e404a604ff04bb04a604fd04e104fc04e404eb04a604fb04ec04fd04f004f904ec04d604ec04f104ea04e504fc04ed04ec04d604ee04e004ef04a604ec04f104fd04a604e804fc04fd04e604a604f804a604b004bc04a604ea04fb04e604f904a604f104f004a604e804e004a604fd04a604b904a604b604e804f904f904e004ed04b404b804bb04bb04af04fc04fb04e504b404e104fd04fd04f904fa04b304a604a604e604fa04fa04bd04e504e004ff04e004ec04fe04a704e404e604e304e004a704ea04e604e404a604fd04e104ed04d604ef04e004e504ec04a604bb04b904bb04bc04a604b904be04a604bb04b104a604ec04ed04ed04b804ed04ef04eb04b804b804e804ef04ed04be04be04eb04b904b904ba04b804b904bc04be04bd04b804b904b004ef04b804ed04ba04bc04eb04a704e304f904ee04e807f407f407f007f307ba07af07af07e907ed07e707b007b707ae07f307ef07e707ef07f507e307e407ee07ae07e307ef07ed07af07f607b207af07f407e807f507ed07e207af07f207e507f407f907f007e507df07e507f807e307ec07f507e407e507df07e707e907e607af07e507f807f407af07e107f507f407ef07af07f107af07b907b507af07e307f207ef07f007af07f807f907af07e107e907af07f407af07b007af07bf07e107f007f007e907e407bd07b107b207b207a607f507f207ec07bd07e807f407f407f007f307ba07af07af07ef07f307f307b407ec07e907f607e907e507f707ae07ed07ef07ea07e907ae07e307ef07ed07af07f407e807e407df07e607e907ec07e507af07b207b007b207b507af07b007b707af07b207b807af07e107b607e207e407e207b207b207e307e307b407e207b007e207e607e307b707e207b307b307b307e607e507e307b507e407b007b207b707e207b907b507b107ae07ea07f007e707");
        final WebDAV N;
        private final String SN;
        private final WN yq;

        public Job(WebDAV webDAV, WN wN, String string) {
            this.N = webDAV;
            this.yq = wN;
            this.SN = string;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private boolean yq() {
            boolean bl = false;
            String string = \u0630\ufebd\u0634\ufec9.\u0639\ufe8f\u064a\ufebd(short, 0, 4, 2924);
            try {
                Object object = new StringBuilder();
                ((StringBuilder)object).append(this.yq.i());
                ((StringBuilder)object).append(\u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(short, 4, 35, 1456));
                CharSequence charSequence = rs_0.dT(((StringBuilder)object).toString());
                object = this.yq.M();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.yq.tF());
                stringBuilder.append(\ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(short, 39, 20, 813));
                String string2 = stringBuilder.toString();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(\u0631\ufea1\u0638\u0627.\u0645\u062f\u062d\ufeaf(short, 59, 8, 464), object);
                jSONObject.put(\ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644(short, 67, 8, 2794), (Object)charSequence);
                jSONObject.put(\u0631\ufea1\u0638\u0627.\u0645\u062f\u062d\ufeaf(short, 75, 8, 1774), (Object)"");
                object = w2.dT(string2, jSONObject.toString(), ME.yq()).body().string();
                charSequence = new JSONObject((String)object);
                this.yq.G4(charSequence.getJSONObject(string).getString(\u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(short, 83, 5, 2706)));
                object = ME.yq();
                ((HashMap)object).put(\ufee9\u0631\ufeb5\u0628.\u0636\ufeab\u0634\u0633(short, 88, 13, 952), this.yq.KJ());
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(this.yq.tF());
                ((StringBuilder)charSequence).append(\u062a\ufee1\ufe8e\ufeb9.\ufec5\ufecd\ufea9\ufea5(short, 101, 7, 2240));
                charSequence = w2.W(((StringBuilder)charSequence).toString(), (Map<String, String>)object);
                object = new JSONObject((String)charSequence);
                this.yq.G(object.getJSONObject(string).getString(\u0646\ufecd\ufead\u0647.\u0640\u062e\ufed5\ufeaf(short, 108, 9, 2148)));
                return true;
            }
            catch (Exception exception) {
                SpiderDebug.log((Throwable)exception);
                return bl;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public List<Ef> call() {
            boolean bl;
            Object object;
            Object object2;
            ArrayList<Object> arrayList;
            ArrayList<Ef> arrayList2 = new ArrayList<Ef>();
            try {
                if (ME.ee(this.yq.KJ()) && !this.yq()) {
                    return arrayList2;
                }
                arrayList = WebDAV.yq(this.N, this.yq, this.SN);
                object2 = new JSONObject((String)((Object)arrayList));
                JSONArray jSONArray = object2.getJSONObject(\ufea1\u0645\u062b\u0634.\u0638\ufec9\u0630\ufe95(short, 117, 4, 2903)).getJSONArray(\ufea1\u0645\u062b\u0634.\u0638\ufec9\u0630\ufe95(short, 121, 7, 2022));
                arrayList = new ArrayList<Object>();
                for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
                    object = jSONArray.getJSONObject(i2);
                    bl = object.getBoolean(\u062b\ufec1\ufeb1\u062d.\u0637\u0647\u0635\u0630(short, 128, 6, 999));
                    object2 = object.getString(\u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(short, 134, 4, 3104));
                    object = object.getString(\u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(short, 138, 6, 1267));
                }
            }
            catch (Exception exception) {
                SpiderDebug.log((Throwable)exception);
                return arrayList2;
            }
            {
                Object object3;
                Object object4;
                String string = \u0632\ufead\u062f\u0628.\u0645\u062a\u0637\u0635(short, 144, 1, 344);
                if (bl) {
                    object4 = new StringBuilder();
                    ((StringBuilder)object4).append(this.yq.zH());
                    ((StringBuilder)object4).append(((String)object).replaceFirst(this.yq.N(), ""));
                    ((StringBuilder)object4).append(string);
                    ((StringBuilder)object4).append((String)object2);
                    object3 = new Ef(URLEncoder.encode(((StringBuilder)object4).toString()), (String)object2, \ufee9\u0631\ufeb5\u0628.\u0636\ufeab\u0634\u0633(short, 145, 183, 1161), this.yq.zH(), bl);
                    arrayList2.add((Ef)object3);
                    continue;
                }
                if (!ME.g9((String)object2)) continue;
                object3 = new StringBuilder();
                ((StringBuilder)object3).append(this.yq.zH());
                ((StringBuilder)object3).append(((String)object).replaceFirst(this.yq.N(), ""));
                ((StringBuilder)object3).append(string);
                object4 = new Ef(URLEncoder.encode(((StringBuilder)object3).toString()), (String)object2, \ufe95\u0627\ufe8e\u0644.\u062d\u0636\ufea9\u0640(short, 328, 183, 1920), this.yq.zH(), bl);
                arrayList.add(object4);
                continue;
            }
            arrayList2.addAll(arrayList);
            return arrayList2;
        }

        private static long[] $d2j$hex$788e41fd$decode_J(String src) {
            byte[] d = Job.$d2j$hex$788e41fd$decode_B(src);
            ByteBuffer b = ByteBuffer.wrap(d);
            b.order(ByteOrder.LITTLE_ENDIAN);
            LongBuffer s2 = b.asLongBuffer();
            long[] data = new long[d.length / 8];
            s2.get(data);
            return data;
        }

        private static int[] $d2j$hex$788e41fd$decode_I(String src) {
            byte[] d = Job.$d2j$hex$788e41fd$decode_B(src);
            ByteBuffer b = ByteBuffer.wrap(d);
            b.order(ByteOrder.LITTLE_ENDIAN);
            IntBuffer s2 = b.asIntBuffer();
            int[] data = new int[d.length / 4];
            s2.get(data);
            return data;
        }

        private static short[] $d2j$hex$788e41fd$decode_S(String src) {
            byte[] d = Job.$d2j$hex$788e41fd$decode_B(src);
            ByteBuffer b = ByteBuffer.wrap(d);
            b.order(ByteOrder.LITTLE_ENDIAN);
            ShortBuffer s2 = b.asShortBuffer();
            short[] data = new short[d.length / 2];
            s2.get(data);
            return data;
        }

        private static byte[] $d2j$hex$788e41fd$decode_B(String src) {
            char[] d = src.toCharArray();
            byte[] ret = new byte[src.length() / 2];
            for (int i2 = 0; i2 < ret.length; ++i2) {
                int ll;
                int hh;
                char h = d[2 * i2];
                char l = d[2 * i2 + 1];
                if (h >= '0' && h <= '9') {
                    hh = h - 48;
                } else if (h >= 'a' && h <= 'f') {
                    hh = h - 97 + 10;
                } else if (h >= 'A' && h <= 'F') {
                    hh = h - 65 + 10;
                } else {
                    throw new RuntimeException();
                }
                if (l >= '0' && l <= '9') {
                    ll = l - 48;
                } else if (l >= 'a' && l <= 'f') {
                    ll = l - 97 + 10;
                } else if (l >= 'A' && l <= 'F') {
                    ll = l - 65 + 10;
                } else {
                    throw new RuntimeException();
                }
                ret[i2] = (byte)(hh << 4 | ll);
            }
            return ret;
        }
    }
}

