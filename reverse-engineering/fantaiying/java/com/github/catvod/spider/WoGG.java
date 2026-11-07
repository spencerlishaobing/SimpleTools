/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.github.catvod.crawler.SpiderDebug
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.content.Context;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufe9d\u0631\ufe8f\u064a;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeaf\u062b\ufed5\ufec1;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.parser.\ufeb9\ufec9\u0648\u062d;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.merge.Am;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.U7;
import com.github.catvod.spider.merge.cu_0;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.iK;
import com.github.catvod.spider.merge.k_0;
import com.github.catvod.spider.merge.p7;
import com.github.catvod.spider.merge.w2;
import com.github.catvod.spider.merge.z2_0;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0641\u0631\ufeed\u0643;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufea5\ufea9\u0633\ufed5;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufebd\u0640\u0648\u062b;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.merge.\ufee9\ufee1\u0627\u0641;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\u0636\u0634\ufec1\u0631;
import com.github.catvod.spider.\u0640\u0633\ufea5\u0631;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufe8e\u0627\ufecd\u062a;
import com.github.catvod.spider.\ufe8e\ufeb9\u0647\u0642;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import com.github.catvod.spider.\ufeb5\ufe8e\ufead\u0632;
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class WoGG
extends Pan {
    private static boolean n;
    private static final short[] short;
    private String O = \ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(short, 0, 22, 2038);
    private Pattern g1 = Pattern.compile(\u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(short, 22, 21, 3014));
    private String s = \u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(short, 43, 111, 354);

    static {
        short = WoGG.$d2j$hex$8cf49daf$decode_S("9e078207820786078507cc07d907d9078107990791079107d8078e078e07990799079907d80795079007d907e90bb00ba90ba20ba20ba30bb20ba70baf0baa0be90bee0b9a0ba20bed0bef0be80bae0bb20bab0baa0b2f010d0118010b010e010e0103014d0157014c01520142014a0135010b010c0106010d011501110142012c0136014201530152014c0152015901420135010b010c0154015601590142011a01540156014b0142012301120112010e01070135010701000129010e0116014d015701510155014c015101540142014a0129012a0136012f012e014e0142010e010b0109010701420125010701010109010d014b01420121010a0110010d010f0107014d015301510157014c0152014c0152014c0152014201310103010401030110010b014d015701510155014c0151015401b102f702eb02f202f3020802c104d804d304c404df04d804c00498044c7b9358250c280c370c6f0c2c0c2e0c250c340c2d0c240c6c0c280c350c240c2c0c600a6d0a720a2a0a690a6b0a600a710a680a610a290a6d0a700a610a690a290a740a6d0a670a3a0a650a0f0a120a0f0a170a1e0aa001a401ae01e701a501a801b301b001a501a601a801ad01ac01ad0108010d0118010d0141011f011e010f016403690376032e036d036f03640375036c0365032d036903740365036d032d03740365037803740346074b0754070c074f074d07460757074e0747070f074b07560747074f070f0741074307520756074b074d074c0702075107520743074c070d0817080008030871026802630258026e026302d606cf06c406ff06ce06c106cd06c506350c2c0c270c1c0c330c2a0c200c880691069a06a1068c069b0693069f068c0695068d06c60bdf0bd40bef0bc90bd50bd10bc20b9204d404c804d104d004df01c601cd01cd01cc01dd01c801c001c5018601a3777c54ca01c701d8018001d801c701ca01cb01c1018301cd01c101d801cb01dc018e01ca01c701d8018001c301c101ca01db01c201cb018301c701da01cb01c3018301de01c701cd018e01c701c301c9018001c201cf01d401d701c201c101cf01ca01230a2e0a360ae10be40bf10be40ba80bf60bf70be60bdf01d201cd019501cd01d201df01de01d4019601d201d501dd01d4019601d201cf01de01d601c8013c043f042e0421046104390426042b042a04200462042604210429042004620426043b042a0422043b0426043b0423042a04940a990a860ade0a860a990a940a950a9f0add0a990a9e0a960a9f0add0a990a840a950a9d0aa4534b66b9f5105af86ef6fe64047e06384c176d19fdbc562b46d2f71655b4676bf8b756c38afc555149d30b8d0bd00bd20bc90bc90bfc0bc20b24064963088b979679542206ad09a009bf09e709bf09a009ad09ac09a609e409a009a709af09a609e409a809bc09b109e909a80910011d0102015a0102011d01100111011b0159011d011a0112011b015901150101010c0154014a01540110011d0102015a01000115011301590118011d011a011f0154011501c507c807d7078f07d707c807c507c407ce078c07c807cf07c707ce078c07c007d407d90781079f078107c0078f07d507c007c6078c07cd07c807cf07ca075c0441045c0444044d04abfd5883ca5daafdfc01450acd08d408df08e408d208df085b0b420b490b720b430b4c0b400b480b580641064a0671065e0647064d0621013801330108012e01320136012501d003c903c203f903d403c303cb03c703d403cd03d503880691069a06a1069f069d068a0691068c06300429042204190422042f0434042304250432042904340443065a0651066a0656065a065b06410650065b06410663037a0371034a037403670370037403be0bb30bba0baf0b950ba40bab0ba70baf0be809e509ec09f909c309f809fd09f209f109e909ad0ba00bbf0be70ba40ba60bad0bbc0ba50bac0be40bbb0ba60bbe0be40ba00ba70baf0ba60be90bf70be90ba80b8102840291028402c802860289028c02950287028a02840297028102c802910280029d0291027107650778077a076407bc05a005ad05b505bf05d102d102d10203041a0411042a040504190414040c042a04000407041904470c5e0c550c6e0c410c5d0c500c480c6e0c570c430c5e0c5c0c555db58a2e96306d108bc468a65bff8ed852448a58f91d7d295f9759ee48318ee207e707fd07fa074d0a510a510a550a1f0a0a0a0a0a520a4a0a420a420a550a440a4b0a0b0a1d0a1d0a1d0a110a1d0a110a0b0a5d0a5c0a5f0a0a0abd09a109a109a509ef09fa09fa09b009b109b209b009ba09bb09b209fb09a209ba09b209b209fb09e609e609e609e709e609e709fb09ad09ac09af09fa090b0a170a170a130a590a4c0a4c0a140a140a140a4d0a140a0c0a040a040a4d0a0f0a0a0a150a060a4c0a23063f063f063b067106640664063c0624062c062c063b062a062506650678067806780679067806790665063306320631066406360a2a0a2a0a2e0a640a710a710a290a290a290a700a290a310a390a390a700a300a3b0a2a0a710ad107c907c107c107f907d507cf07d207c3070b0200021a020d020e0201023d08760870083c0862087a0862082d08670860087e082f08020510052705240527053005270530057f052a05360536053205310578056d056d05230532052b056c0526052d053705200523052c056c0521052d052f056d05020517053105270530056f050305250527052c0536057f050f052d0538052b052e052e0523056d0577056c05720562056a0515052b052c0526052d053505310562050c0516056205730572056c0572057905620515052b052c0574057605790562053a05740576056b0562050305320532052e05270515052705200509052b0536056d057705710575056c057105740562056a0509050a0516050f050e056e0562052e052b0529052705620505052705210529052d056b05620501052a0530052d052f0527056d057305730572056c0572056c0572056c0572056205110523052405230530052b056d057705710575056c0571057405190801080908090831081d0807081a080b0803011f011f011b01fd02f802e202e502680cd570915a2c0cdd567c92120212020f8b9d552a031d7fdb67975a7b01f253716e360b447fc28339033b03ad7a525b4076e901e39d4044b07f6f5ca604a904ac04b404a504b204b3049d0b900b8f0bd70b940b960b9d0b8c0b950b9c0bd40b950b900b970b9c0b8a0bd40b950b900b8a0b8d0bf108fc08e308bb08f808fa08f108e008f908f008b808fc08e108f008f80836053b0524057c053f053d05360527053e0537057f053b05260537053f057f0522053b0531056c0533055d0740075d0745074c07600564056e05270565056805730570056505660568056d056c056d051d0418040d04180454040a040b041a04e904e404fb04a304e004e204e904f804e104e804a004e404f904e804e004a004ee04ec04fd04f904e404e204e304ad04fe04fd04ec04e3049e0893088c08d408970895089e088f0896089f08d70893088e089f089708d7088e089f0882088e08fa01e001f701f401820b9b0b900bab0b9d0b900b890290029b02a00291029e0292029a02bd0aa40aaf0a940abb0aa20aa80ad502cc02c702fc02d102c602ce02c202d102c802d00282039b039003ab038d039103950386037b07740779076b076b07b901a301be01af019f01b801a601c109d909d109d1099a04980488048f048004ac06b006b006b406b80ba10baa0bbd0bab0baf0bbc0bad0ba60be10be30be30be30be30be30be30be30be30be30be30be30be30be30be00ba60bba0ba30ba20bf10bb90baa0bf30b217afe59280625063a06620621062306280639062006290661063f0629062d063e062f06240661062506380629062106be06b306ac06f406ac06b306be06bf06b506f706b306b406bc06b506f706b206bf06bb06be06bf06a806fa06fa06b206e906fa06fa06bb06a001ad01b201ea01b201ad01a001a101ab01e901ad01aa01a201ab01e901ac01a101a501a001a101b601e401a501ea01b201ad01a001a101ab01e901b701a101b601ad01a501a801c109cc09d3098b09c809ca09c109d009c909c0098809cc09d109c009c8098809d509cc09c6098509cc09c809c209dc0bd90bcc0bd90b950bcb0bca0bdb0b11040b041c041f046e0277027c02470271027c02580941094a09710940094f0943094b0974076d0766075d0772076b076107c303da03d103ea03c703d003d803d403c703de03c603e806ed06f706f006");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static short[] \u062f\u0642\ufeab\ufe8e() {
        if (\u062d\ufeb9\ufeab\ufef1.\ufe8e\u0645\u0632\u0628() > 0) return null;
        return short;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0630\ufed9\ufead\ufedd(Object object) {
        if (\ufe99\u062e\u0642\u0644.\ufe99\ufec9\ufec5\u0646() > 0) return null;
        return ((WoGG)((Object)object)).O;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String \u0640\u0645\ufeb1\u064a(Object object) {
        if (\ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637() > 0) return null;
        return ((WoGG)((Object)object)).s;
    }

    public static void \ufebd\u0638\ufe8e\ufe9d(Object object) {
        if (\u0641\u0631\ufeed\u0643.\ufeb5\ufe8f\u0630\u0647() > 0) {
            SpiderDebug.log((Throwable)((Throwable)object));
        }
    }

    /*
     * Exception decompiling
     */
    public String categoryContent(String var1_1, String var2_3, boolean var3_4, HashMap<String, String> var4_5) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 2[TRYBLOCK] [3 : 224->312)] java.lang.Exception
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
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
     * Exception decompiling
     */
    @Override
    public String detailContent(List<String> var1_1) {
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
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void getKey() {
        String string;
        this.O = string = new cu_0().yq(new ArrayList<String>(Arrays.asList(\u0646\ufecd\ufead\u0647.\u0640\u062e\ufed5\ufeaf(short, 796, 26, 2597), \u062f\ufead\ufeaf\u062d.\ufec9\u0630\ufed9\ufeb1(short, 822, 31, 2517), \ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(short, 853, 21, 2659), \ufeb9\u0643\ufed9\ufed5.\u0628\u062f\ufea1\u0642(short, 874, 26, 1611), \u062a\u0635\ufeb1\u0642.\u0637\u0636\u062a\ufedd(short, 900, 20, 2654))));
        if (string.length() <= 4) {
            return;
        }
        string = this.O;
        p7.i(\u0631\ufea1\u0638\u0627.\u0645\u062f\u062d\ufeaf(short, 920, 9, 1958), string);
    }

    public String getPic(String string) {
        CharSequence charSequence = string;
        if (string.contains(\u0636\u0634\ufec1\u0631.\u062c\u063a\u0643\u0627(short, 929, 6, 623))) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string.replace(\u062d\ufeb9\ufeab\ufef1.\ufeed\u0638\u0635\ufed5(short, 935, 12, 2066), ""));
            ((StringBuilder)charSequence).append(\ufeab\u0632\u062f\u0640.\u062f\u0627\ufe95\u0631(short, 947, 155, 1346));
            charSequence = ((StringBuilder)charSequence).toString();
        }
        return charSequence;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void getSite() {
        String string = p7.tF(\ufeb9\ufec9\u0648\u062d.\ufee9\u0637\ufef1\u0644(short, 1102, 9, 2158));
        if (string.contains(\ufeb5\ufe8e\ufead\u0632.\ufe8f\ufef1\u0648\ufe95(short, 1111, 4, 363))) {
            this.O = string;
            return;
        }
        this.getKey();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String homeContent(boolean var1_1) {
        block17: {
            block19: {
                block18: {
                    var7_2 = \ufebd\u0640\u0648\u062b.\ufea5\u0639\u0631\ufe95(WoGG.short, 1115, 4, 657);
                    var8_3 = new JSONArray();
                    var6_4 = new JSONObject();
                    U7.B(\u062f\ufead\ufeaf\u062d.\ufec9\u0630\ufed9\ufeb1(WoGG.short, 1119, 1, 3161), \ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(WoGG.short, 1120, 2, 1504), var8_3);
                    U7.B(\u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(WoGG.short, 1122, 1, 3102), \u0636\u0634\ufec1\u0631.\u062c\u063a\u0643\u0627(WoGG.short, 1123, 2, 1210), var8_3);
                    U7.B(\u0641\ufeb5\ufeb1\ufee1.\u0639\u0630\ufeaf\ufe95(WoGG.short, 1125, 2, 550), \ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(WoGG.short, 1127, 2, 2804), var8_3);
                    U7.B(\ufee9\u0631\ufeb5\u0628.\u0636\ufeab\u0634\u0633(WoGG.short, 1129, 1, 796), \ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(WoGG.short, 1130, 3, 2288), var8_3);
                    U7.B(\u062d\ufeb9\ufeab\ufef1.\ufeed\u0638\u0635\ufed5(WoGG.short, 1133, 1, 328), \ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644(WoGG.short, 1134, 2, 346), var8_3);
                    U7.B(\ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(WoGG.short, 1136, 1, 2818), \ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(WoGG.short, 1137, 2, 440), var8_3);
                    U7.B(\u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(WoGG.short, 1139, 2, 781), \ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(WoGG.short, 1141, 3, 1031), var8_3);
                    U7.B(\u0641\ufeb5\ufeb1\ufee1.\u0639\u0630\ufeaf\ufe95(WoGG.short, 1144, 1, 476), \ufeb9\ufec9\u0648\u062d.\ufee9\u0637\ufef1\u0644(WoGG.short, 1145, 2, 2576), var8_3);
                    var5_5 = w2.v(this.O, ME.M(this.s), 3);
                    if (ME.ee((String)var5_5)) break block18;
                    var4_7 = var5_5;
                    if (var5_5.contains(\ufed9\ufe9d\ufeed\ufeb5.\u0638\ufec1\u063a\u0644(WoGG.short, 1147, 2, 3097))) break block19;
                }
                var4_7 = this.refTry(this.O);
            }
            var5_5 = Am.yq(var4_7);
            if (var1_1) {
                var9_9 = \ufea9\u0643\u062d\u063a.\ufea1\u0633\ufe8e\u0627(WoGG.short, 1149, 7, 1216);
                var4_7 = new JSONObject("{\"1\":[{\"key\":\"3\",\"name\":\"\u7c7b\u578b\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u559c\u5267\",\"v\":\"\u559c\u5267\"},{\"n\":\"\u7231\u60c5\",\"v\":\"\u7231\u60c5\"},{\"n\":\"\u52a8\u4f5c\",\"v\":\"\u52a8\u4f5c\"},{\"n\":\"\u6050\u6016\",\"v\":\"\u6050\u6016\"},{\"n\":\"\u79d1\u5e7b\",\"v\":\"\u79d1\u5e7b\"},{\"n\":\"\u5267\u60c5\",\"v\":\"\u5267\u60c5\"},{\"n\":\"\u72af\u7f6a\",\"v\":\"\u72af\u7f6a\"},{\"n\":\"\u5947\u5e7b\",\"v\":\"\u5947\u5e7b\"},{\"n\":\"\u6218\u4e89\",\"v\":\"\u6218\u4e89\"},{\"n\":\"\u60ac\u7591\",\"v\":\"\u60ac\u7591\"},{\"n\":\"\u6b66\u4fa0\",\"v\":\"\u6b66\u4fa0\"},{\"n\":\"\u5192\u9669\",\"v\":\"\u5192\u9669\"},{\"n\":\"\u53e4\u88c5\",\"v\":\"\u53e4\u88c5\"},{\"n\":\"\u5386\u53f2\",\"v\":\"\u5386\u53f2\"},{\"n\":\"\u60ca\u609a\",\"v\":\"\u60ca\u609a\"}]},{\"key\":\"11\",\"name\":\"\u5e74\u4ee3\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\": \"2026\", \"v\": \"2026\"},{\"n\": \"2025\", \"v\": \"2025\"},{\"n\":\"2024\",\"v\":\"2024\"},{\"n\":\"2023\",\"v\":\"2023\"},{\"n\":\"2022\",\"v\":\"2022\"},{\"n\":\"2021\",\"v\":\"2021\"},{\"n\":\"2020\",\"v\":\"2020\"},{\"n\":\"2019\",\"v\":\"2019\"},{\"n\":\"2018\",\"v\":\"2018\"},{\"n\":\"2017\",\"v\":\"2017\"},{\"n\":\"2016\",\"v\":\"2016\"},{\"n\":\"2015\",\"v\":\"2015\"},{\"n\":\"2014\",\"v\":\"2014\"},{\"n\":\"2013\",\"v\":\"2013\"},{\"n\":\"2012\",\"v\":\"2012\"},{\"n\":\"2011\",\"v\":\"2011\"}]},{\"key\":\"1\",\"name\":\"\u5730\u533a\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u5927\u9646\",\"v\":\"\u4e2d\u56fd\u5927\u9646\"},{\"n\":\"\u4e2d\u56fd\u9999\u6e2f\",\"v\":\"\u4e2d\u56fd\u9999\u6e2f\"},{\"n\":\"\u4e2d\u56fd\u53f0\u6e7e\",\"v\":\"\u4e2d\u56fd\u53f0\u6e7e\"},{\"n\":\"\u7f8e\u56fd\",\"v\":\"\u7f8e\u56fd\"},{\"n\":\"\u97e9\u56fd\",\"v\":\"\u97e9\u56fd\"},{\"n\":\"\u65e5\u672c\",\"v\":\"\u65e5\u672c\"},{\"n\":\"\u897f\u73ed\u7259\",\"v\":\"\u897f\u73ed\u7259\"},{\"n\":\"\u6cf0\u56fd\",\"v\":\"\u6cf0\u56fd\"},{\"n\":\"\u6cd5\u56fd\",\"v\":\"\u6cd5\u56fd\"},{\"n\":\"\u82f1\u56fd\",\"v\":\"\u82f1\u56fd\"},{\"n\":\"\u5fb7\u56fd\",\"v\":\"\u5fb7\u56fd\"},{\"n\":\"\u5370\u5ea6\",\"v\":\"\u5370\u5ea6\"},{\"n\":\"\u5176\u4ed6\",\"v\":\"\u5176\u4ed6\"}]}],\"44\":[{\"key\":\"3\",\"name\":\"\u7c7b\u578b\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u559c\u5267\",\"v\":\"\u559c\u5267\"},{\"n\":\"\u7231\u60c5\",\"v\":\"\u7231\u60c5\"},{\"n\":\"\u52a8\u4f5c\",\"v\":\"\u52a8\u4f5c\"},{\"n\":\"\u6050\u6016\",\"v\":\"\u6050\u6016\"},{\"n\":\"\u79d1\u5e7b\",\"v\":\"\u79d1\u5e7b\"},{\"n\":\"\u5267\u60c5\",\"v\":\"\u5267\u60c5\"},{\"n\":\"\u72af\u7f6a\",\"v\":\"\u72af\u7f6a\"},{\"n\":\"\u5947\u5e7b\",\"v\":\"\u5947\u5e7b\"},{\"n\":\"\u6218\u4e89\",\"v\":\"\u6218\u4e89\"},{\"n\":\"\u60ac\u7591\",\"v\":\"\u60ac\u7591\"},{\"n\":\"\u6b66\u4fa0\",\"v\":\"\u6b66\u4fa0\"},{\"n\":\"\u5192\u9669\",\"v\":\"\u5192\u9669\"},{\"n\":\"\u53e4\u88c5\",\"v\":\"\u53e4\u88c5\"},{\"n\":\"\u5386\u53f2\",\"v\":\"\u5386\u53f2\"},{\"n\":\"\u60ca\u609a\",\"v\":\"\u60ca\u609a\"}]},{\"key\":\"11\",\"name\":\"\u5e74\u4ee3\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\": \"2026\", \"v\": \"2026\"},{\"n\": \"2025\", \"v\": \"2025\"},{\"n\":\"2024\",\"v\":\"2024\"},{\"n\":\"2023\",\"v\":\"2023\"},{\"n\":\"2022\",\"v\":\"2022\"},{\"n\":\"2021\",\"v\":\"2021\"},{\"n\":\"2020\",\"v\":\"2020\"},{\"n\":\"2019\",\"v\":\"2019\"},{\"n\":\"2018\",\"v\":\"2018\"},{\"n\":\"2017\",\"v\":\"2017\"},{\"n\":\"2016\",\"v\":\"2016\"},{\"n\":\"2015\",\"v\":\"2015\"},{\"n\":\"2014\",\"v\":\"2014\"},{\"n\":\"2013\",\"v\":\"2013\"},{\"n\":\"2012\",\"v\":\"2012\"},{\"n\":\"2011\",\"v\":\"2011\"}]},{\"key\":\"1\",\"name\":\"\u5730\u533a\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u5927\u9646\",\"v\":\"\u4e2d\u56fd\u5927\u9646\"},{\"n\":\"\u4e2d\u56fd\u9999\u6e2f\",\"v\":\"\u4e2d\u56fd\u9999\u6e2f\"},{\"n\":\"\u4e2d\u56fd\u53f0\u6e7e\",\"v\":\"\u4e2d\u56fd\u53f0\u6e7e\"},{\"n\":\"\u7f8e\u56fd\",\"v\":\"\u7f8e\u56fd\"},{\"n\":\"\u97e9\u56fd\",\"v\":\"\u97e9\u56fd\"},{\"n\":\"\u65e5\u672c\",\"v\":\"\u65e5\u672c\"},{\"n\":\"\u897f\u73ed\u7259\",\"v\":\"\u897f\u73ed\u7259\"},{\"n\":\"\u6cf0\u56fd\",\"v\":\"\u6cf0\u56fd\"},{\"n\":\"\u6cd5\u56fd\",\"v\":\"\u6cd5\u56fd\"},{\"n\":\"\u82f1\u56fd\",\"v\":\"\u82f1\u56fd\"},{\"n\":\"\u5fb7\u56fd\",\"v\":\"\u5fb7\u56fd\"},{\"n\":\"\u5370\u5ea6\",\"v\":\"\u5370\u5ea6\"},{\"n\":\"\u5176\u4ed6\",\"v\":\"\u5176\u4ed6\"}]}],\"2\":[{\"key\":\"3\",\"name\":\"\u7c7b\u578b\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u559c\u5267\",\"v\":\"\u559c\u5267\"},{\"n\":\"\u7231\u60c5\",\"v\":\"\u7231\u60c5\"},{\"n\":\"\u52a8\u4f5c\",\"v\":\"\u52a8\u4f5c\"},{\"n\":\"\u6050\u6016\",\"v\":\"\u6050\u6016\"},{\"n\":\"\u79d1\u5e7b\",\"v\":\"\u79d1\u5e7b\"},{\"n\":\"\u5267\u60c5\",\"v\":\"\u5267\u60c5\"},{\"n\":\"\u72af\u7f6a\",\"v\":\"\u72af\u7f6a\"},{\"n\":\"\u5947\u5e7b\",\"v\":\"\u5947\u5e7b\"},{\"n\":\"\u6218\u4e89\",\"v\":\"\u6218\u4e89\"},{\"n\":\"\u60ac\u7591\",\"v\":\"\u60ac\u7591\"},{\"n\":\"\u6b66\u4fa0\",\"v\":\"\u6b66\u4fa0\"},{\"n\":\"\u5192\u9669\",\"v\":\"\u5192\u9669\"},{\"n\":\"\u53e4\u88c5\",\"v\":\"\u53e4\u88c5\"},{\"n\":\"\u5386\u53f2\",\"v\":\"\u5386\u53f2\"},{\"n\":\"\u60ca\u609a\",\"v\":\"\u60ca\u609a\"}]},{\"key\":\"11\",\"name\":\"\u5e74\u4ee3\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\": \"2026\", \"v\": \"2026\"},{\"n\": \"2025\", \"v\": \"2025\"},{\"n\":\"2024\",\"v\":\"2024\"},{\"n\":\"2023\",\"v\":\"2023\"},{\"n\":\"2022\",\"v\":\"2022\"},{\"n\":\"2021\",\"v\":\"2021\"},{\"n\":\"2020\",\"v\":\"2020\"},{\"n\":\"2019\",\"v\":\"2019\"},{\"n\":\"2018\",\"v\":\"2018\"},{\"n\":\"2017\",\"v\":\"2017\"},{\"n\":\"2016\",\"v\":\"2016\"},{\"n\":\"2015\",\"v\":\"2015\"},{\"n\":\"2014\",\"v\":\"2014\"},{\"n\":\"2013\",\"v\":\"2013\"},{\"n\":\"2012\",\"v\":\"2012\"},{\"n\":\"2011\",\"v\":\"2011\"}]},{\"key\":\"1\",\"name\":\"\u5730\u533a\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u5927\u9646\",\"v\":\"\u4e2d\u56fd\u5927\u9646\"},{\"n\":\"\u4e2d\u56fd\u9999\u6e2f\",\"v\":\"\u4e2d\u56fd\u9999\u6e2f\"},{\"n\":\"\u4e2d\u56fd\u53f0\u6e7e\",\"v\":\"\u4e2d\u56fd\u53f0\u6e7e\"},{\"n\":\"\u7f8e\u56fd\",\"v\":\"\u7f8e\u56fd\"},{\"n\":\"\u97e9\u56fd\",\"v\":\"\u97e9\u56fd\"},{\"n\":\"\u65e5\u672c\",\"v\":\"\u65e5\u672c\"},{\"n\":\"\u897f\u73ed\u7259\",\"v\":\"\u897f\u73ed\u7259\"},{\"n\":\"\u6cf0\u56fd\",\"v\":\"\u6cf0\u56fd\"},{\"n\":\"\u6cd5\u56fd\",\"v\":\"\u6cd5\u56fd\"},{\"n\":\"\u82f1\u56fd\",\"v\":\"\u82f1\u56fd\"},{\"n\":\"\u5fb7\u56fd\",\"v\":\"\u5fb7\u56fd\"},{\"n\":\"\u5370\u5ea6\",\"v\":\"\u5370\u5ea6\"},{\"n\":\"\u5176\u4ed6\",\"v\":\"\u5176\u4ed6\"}]}],\"6\":[{\"key\":\"3\",\"name\":\"\u7c7b\u578b\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u7537\u9891\",\"v\":\"\u7537\u9891\"},{\"n\":\"\u5973\u9891\",\"v\":\"\u5973\u9891\"},{\"n\":\"\u90fd\u5e02\",\"v\":\"\u90fd\u5e02\"},{\"n\":\"\u751c\u5ba0\",\"v\":\"\u751c\u5ba0\"},{\"n\":\"\u5e74\u4ee3\",\"v\":\"\u5e74\u4ee3\"},{\"n\":\"\u7a7f\u8d8a\",\"v\":\"\u7a7f\u8d8a\"},{\"n\":\"\u53e4\u88c5\",\"v\":\"\u53e4\u88c5\"},{\"n\":\"\u4eb2\u60c5\",\"v\":\"\u4eb2\u60c5\"},{\"n\":\"\u5947\u5e7b\",\"v\":\"\u5947\u5e7b\"},{\"n\":\"\u840c\u5b9d\",\"v\":\"\u840c\u5b9d\"},{\"n\":\"\u91cd\u751f\",\"v\":\"\u91cd\u751f\"},{\"n\":\"\u5192\u9669\",\"v\":\"\u5192\u9669\"},{\"n\":\"\u9006\u88ad\",\"v\":\"\u9006\u88ad\"},{\"n\":\"\u8650\u604b\",\"v\":\"\u8650\u604b\"},{\"n\":\"\u590d\u4ec7\",\"v\":\"\u590d\u4ec7\"},{\"n\":\"\u4fee\u4ed9\",\"v\":\"\u4fee\u4ed9\"},{\"n\":\"\u9274\u5b9d\",\"v\":\"\u9274\u5b9d\"}]},{\"key\":\"11\",\"name\":\"\u5e74\u4ee3\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\": \"2026\", \"v\": \"2026\"},{\"n\": \"2025\", \"v\": \"2025\"},{\"n\":\"2024\",\"v\":\"2024\"},{\"n\":\"2023\",\"v\":\"2023\"},{\"n\":\"2022\",\"v\":\"2022\"},{\"n\":\"2021\",\"v\":\"2021\"}]}],\"5\":[{\"key\":\"5\",\"name\":\"\u5b57\u6bcd\",\"value\":[{\"n\":\"A\",\"v\":\"A\"},{\"n\":\"B\",\"v\":\"B\"},{\"n\":\"C\",\"v\":\"C\"},{\"n\":\"D\",\"v\":\"D\"},{\"n\":\"E\",\"v\":\"E\"},{\"n\":\"F\",\"v\":\"F\"},{\"n\":\"G\",\"v\":\"G\"},{\"n\":\"H\",\"v\":\"H\"},{\"n\":\"I\",\"v\":\"I\"},{\"n\":\"J\",\"v\":\"J\"},{\"n\":\"K\",\"v\":\"K\"},{\"n\":\"L\",\"v\":\"L\"},{\"n\":\"M\",\"v\":\"M\"},{\"n\":\"N\",\"v\":\"N\"},{\"n\":\"O\",\"v\":\"O\"},{\"n\":\"P\",\"v\":\"P\"},{\"n\":\"Q\",\"v\":\"Q\"},{\"n\":\"R\",\"v\":\"R\"},{\"n\":\"S\",\"v\":\"S\"},{\"n\":\"T\",\"v\":\"T\"},{\"n\":\"U\",\"v\":\"U\"},{\"n\":\"V\",\"v\":\"V\"},{\"n\":\"W\",\"v\":\"W\"},{\"n\":\"X\",\"v\":\"X\"},{\"n\":\"Y\",\"v\":\"Y\"},{\"n\":\"Z\",\"v\":\"Z\"},{\"n\":\"0-9\",\"v\":\"0-9\"}]}],\"4\":[{\"key\":\"11\",\"name\":\"\u5e74\u4ee3\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\": \"2026\", \"v\": \"2026\"},{\"n\": \"2025\", \"v\": \"2025\"},{\"n\":\"2024\",\"v\":\"2024\"},{\"n\":\"2023\",\"v\":\"2023\"},{\"n\":\"2022\",\"v\":\"2022\"},{\"n\":\"2021\",\"v\":\"2021\"},{\"n\":\"2020\",\"v\":\"2020\"},{\"n\":\"2019\",\"v\":\"2019\"},{\"n\":\"2018\",\"v\":\"2018\"},{\"n\":\"2017\",\"v\":\"2017\"},{\"n\":\"2016\",\"v\":\"2016\"},{\"n\":\"2015\",\"v\":\"2015\"},{\"n\":\"2014\",\"v\":\"2014\"},{\"n\":\"2013\",\"v\":\"2013\"},{\"n\":\"2012\",\"v\":\"2012\"},{\"n\":\"2011\",\"v\":\"2011\"}]},{\"key\":\"1\",\"name\":\"\u5730\u533a\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u5927\u9646\",\"v\":\"\u4e2d\u56fd\u5927\u9646\"},{\"n\":\"\u4e2d\u56fd\u9999\u6e2f\",\"v\":\"\u4e2d\u56fd\u9999\u6e2f\"},{\"n\":\"\u4e2d\u56fd\u53f0\u6e7e\",\"v\":\"\u4e2d\u56fd\u53f0\u6e7e\"},{\"n\":\"\u7f8e\u56fd\",\"v\":\"\u7f8e\u56fd\"},{\"n\":\"\u97e9\u56fd\",\"v\":\"\u97e9\u56fd\"},{\"n\":\"\u65e5\u672c\",\"v\":\"\u65e5\u672c\"},{\"n\":\"\u897f\u73ed\u7259\",\"v\":\"\u897f\u73ed\u7259\"},{\"n\":\"\u82f1\u56fd\",\"v\":\"\u82f1\u56fd\"},{\"n\":\"\u5176\u4ed6\",\"v\":\"\u5176\u4ed6\"}]}],\"46\":[{\"key\":\"11\",\"name\":\"\u5e74\u4ee3\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\": \"2026\", \"v\": \"2026\"},{\"n\": \"2025\", \"v\": \"2025\"},{\"n\":\"2024\",\"v\":\"2024\"},{\"n\":\"2023\",\"v\":\"2023\"},{\"n\":\"2022\",\"v\":\"2022\"},{\"n\":\"2021\",\"v\":\"2021\"},{\"n\":\"2020\",\"v\":\"2020\"},{\"n\":\"2019\",\"v\":\"2019\"},{\"n\":\"2018\",\"v\":\"2018\"},{\"n\":\"2017\",\"v\":\"2017\"},{\"n\":\"2016\",\"v\":\"2016\"},{\"n\":\"2015\",\"v\":\"2015\"},{\"n\":\"2014\",\"v\":\"2014\"},{\"n\":\"2013\",\"v\":\"2013\"},{\"n\":\"2012\",\"v\":\"2012\"},{\"n\":\"2011\",\"v\":\"2011\"},{\"n\":\"2010\",\"v\":\"2010\"}]}],\"3\":[{\"key\":\"11\",\"name\":\"\u5e74\u4ee3\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\": \"2026\", \"v\": \"2026\"},{\"n\": \"2025\", \"v\": \"2025\"},{\"n\":\"2024\",\"v\":\"2024\"},{\"n\":\"2023\",\"v\":\"2023\"},{\"n\":\"2022\",\"v\":\"2022\"},{\"n\":\"2021\",\"v\":\"2021\"},{\"n\":\"2020\",\"v\":\"2020\"},{\"n\":\"2019\",\"v\":\"2019\"},{\"n\":\"2018\",\"v\":\"2018\"},{\"n\":\"2017\",\"v\":\"2017\"},{\"n\":\"2016\",\"v\":\"2016\"},{\"n\":\"2015\",\"v\":\"2015\"},{\"n\":\"2014\",\"v\":\"2014\"},{\"n\":\"2013\",\"v\":\"2013\"},{\"n\":\"2012\",\"v\":\"2012\"},{\"n\":\"2011\",\"v\":\"2011\"}]},{\"key\":\"1\",\"name\":\"\u5730\u533a\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u5927\u9646\",\"v\":\"\u4e2d\u56fd\u5927\u9646\"},{\"n\":\"\u7f8e\u56fd\",\"v\":\"\u7f8e\u56fd\"},{\"n\":\"\u65e5\u672c\",\"v\":\"\u65e5\u672c\"},{\"n\":\"\u97e9\u56fd\",\"v\":\"\u97e9\u56fd\"},{\"n\":\"\u82f1\u56fd\",\"v\":\"\u82f1\u56fd\"},{\"n\":\"\u6cd5\u56fd\",\"v\":\"\u6cd5\u56fd\"},{\"n\":\"\u5176\u4ed6\",\"v\":\"\u5176\u4ed6\"}]}]}");
                var6_4.put((String)var9_9, (Object)var4_7);
            }
            var4_7 = new JSONArray();
            var9_9 = var5_5.cS(\u062b\ufec1\ufeb1\u062d.\u0637\u0647\u0635\u0630(WoGG.short, 1156, 21, 3065));
            var2_10 = 0;
lbl29:
            // 2 sources

            while (var2_10 < var9_9.size()) {
                var5_5 = ((hN)var9_9.get(var2_10)).cS(\ufe95\u0627\ufe8e\u0644.\u062d\u0636\ufea9\u0640(WoGG.short, 1177, 15, 2197));
                ** GOTO lbl36
            }
            break block17;
            {
                catch (Exception var4_8) {
                    SpiderDebug.log((Throwable)var4_8);
                    return "";
                }
lbl36:
                // 2 sources

                block10: for (var3_11 = 0; var3_11 < var5_5.size(); ++var3_11) {
                    var13_16 = (hN)var5_5.get(var3_11);
                    var14_17 = var13_16.cS(\ufeaf\u062b\ufed5\ufec1.\u062e\ufeab\ufee9\u0628(WoGG.short, 1192, 21, 1362)).tF();
                    var11_14 = var14_17.N(\u062a\ufee1\ufe8e\ufeb9.\ufec5\ufecd\ufea9\ufea5(WoGG.short, 1213, 5, 1833));
                    var12_15 = this.getPic(z2_0.yq(\ufea9\u0643\u062d\u063a.\ufea1\u0633\ufe8e\u0627(WoGG.short, 1218, 14, 1289), (hN)var13_16).N(\u062a\u0635\ufeb1\u0642.\u0637\u0636\u062a\ufedd(WoGG.short, 1232, 8, 1145)));
                    var10_12 = z2_0.yq(\ufee9\ufee1\u0627\u0641.\ufea1\ufebd\u063a\u0630(WoGG.short, 1240, 28, 1165), (hN)var13_16).Fo();
                    var13_16 = z2_0.yq(\u0631\u0640\ufec1\ufee9.\ufe95\ufeed\u062c\ufec1(WoGG.short, 1268, 20, 2298), (hN)var13_16).Fo();
                    if ((var14_17 = this.g1.matcher(var14_17.N(\u0632\ufead\u062f\u0628.\u0645\u062a\u0637\u0635(WoGG.short, 1288, 4, 402)))).find()) ** GOTO lbl-1000
lbl44:
                    // 2 sources

                    continue block10;
lbl-1000:
                    // 1 sources

                    {
                        var15_18 = var14_17.group(1);
                    }
                    try {
                        var14_17 = new JSONObject();
                        var14_17.put(\u0635\u0631\u0645\u0628.\u0646\u0627\u062a\u062d(WoGG.short, 1292, 6, 3060), (Object)var15_18);
                        var14_17.put(\ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(WoGG.short, 1298, 8, 767), (Object)var11_14);
                        var14_17.put(\ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(WoGG.short, 1306, 7, 2763), (Object)var12_15);
                        var14_17.put(\u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(WoGG.short, 1313, 11, 675), var13_16);
                        var14_17.put(\ufed9\ufe9d\ufeed\ufeb5.\u0638\ufec1\u063a\u0644(WoGG.short, 1324, 8, 1012), (Object)var10_12);
                        var4_7.put(var14_17);
                    }
                    catch (Exception var10_13) {}
                    {
                        SpiderDebug.log((Throwable)var10_13);
                    }
                    ** continue;
                }
            }
            ++var2_10;
            ** GOTO lbl29
        }
        var6_4.put(\u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(WoGG.short, 1332, 5, 1816), (Object)var8_3);
        var6_4.put(var7_2, (Object)var4_7);
        {
            catch (Exception var5_6) {
                SpiderDebug.log((Throwable)var5_6);
                ** continue;
            }
lbl76:
            // 2 sources

            while (true) {
                var6_4.put(var7_2, (Object)var4_7);
                return var6_4.toString();
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void init(Context context, String string) {
        String string2 = \ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(short, 1337, 7, 458);
        try {
            JSONObject jSONObject = new JSONObject(string);
            super.init(context, string);
            if (jSONObject.has(string2)) {
                this.O = jSONObject.getString(string2);
                return;
            }
            this.getSite();
            return;
        }
        catch (Exception exception) {
            SpiderDebug.log((Throwable)exception);
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public String playerContent(String string, String string2, List<String> list) {
        JSONObject jSONObject = new JSONObject();
        if (!this.O.contains(\ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(short, 1344, 4, 2486))) {
            if (!this.O.contains(\ufeab\u062d\u063a\ufea9.\u062f\u0642\ufebd\u064a(short, 1348, 5, 1262))) return jSONObject.toString();
        }
        try {
            return super.playerContent(string, string2, list);
        }
        catch (Exception exception) {
            return "";
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String refTry(String string) {
        if (n) return "";
        this.getKey();
        n = true;
        if (string.startsWith(\ufe8e\ufeb9\u0647\u0642.\ufee1\u062f\ufedd\u0643(short, 1353, 4, 1732))) {
            string = this.O;
            return w2.v(string, ME.M(this.s), 7);
        }
        string = k_0.i(new StringBuilder(), this.O, string);
        return w2.v(string, ME.M(this.s), 7);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String searchContent(String string, boolean bl) {
        Object object = \ufea9\u0643\u062d\u063a.\ufea1\u0633\ufe8e\u0627(short, 1357, 32, 3022);
        try {
            String string2;
            CharSequence charSequence;
            block8: {
                block7: {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append(this.O);
                    ((StringBuilder)charSequence).append((String)object);
                    ((StringBuilder)charSequence).append(URLEncoder.encode(string));
                    string2 = w2.v(((StringBuilder)charSequence).toString(), ME.M(this.s), 3);
                    if (ME.ee(string2)) break block7;
                    charSequence = string2;
                    if (string2.contains(\u0636\u0634\ufec1\u0631.\u062c\u063a\u0643\u0627(short, 1389, 2, 2440))) break block8;
                }
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append((String)object);
                ((StringBuilder)charSequence).append(URLEncoder.encode(string));
                charSequence = this.refTry(((StringBuilder)charSequence).toString());
            }
            object = Am.yq((String)charSequence);
            string2 = new JSONArray();
            charSequence = new JSONObject();
            object = ((hN)object).cS(\ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(short, 1391, 22, 1612));
            for (int i2 = 0; i2 < ((AbstractCollection)object).size(); ++i2) {
                Object object2 = (hN)((AbstractList)object).get(i2);
                Object object3 = ((hN)object2).cS(\u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(short, 1413, 28, 1754)).tF();
                String string3 = ((hN)object3).Fo();
                if (!string3.contains(string)) continue;
                String string4 = ((hN)object2).cS(\ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(short, 1441, 36, 452)).tF().Fo();
                object2 = this.getPic(((hN)object2).cS(\ufeab\u0632\u062f\u0640.\u062f\u0627\ufe95\u0631(short, 1477, 23, 2469)).yq(\ufeaf\u062b\ufed5\ufec1.\u062e\ufeab\ufee9\u0628(short, 1500, 8, 3000)));
                if (!((Matcher)(object3 = this.g1.matcher(((iK)object3).N(\ufeb9\u0627\ufea5\ufe9d.\u062a\ufef1\u062d\u0641(short, 1508, 4, 1145))))).find()) continue;
                String string5 = ((Matcher)object3).group(1);
                object3 = new JSONObject();
                object3.put(\ufeb5\ufe8e\ufead\u0632.\ufe8f\ufef1\u0648\ufe95(short, 1512, 6, 536), (Object)string5);
                object3.put(\u062a\u0635\ufeb1\u0642.\u0637\u0636\u062a\ufedd(short, 1518, 8, 2350), (Object)string3);
                object3.put(\ufe95\u0627\ufe8e\u0644.\u062d\u0636\ufea9\u0640(short, 1526, 7, 1794), object2);
                object3.put(\ufeb9\u0627\ufea5\ufe9d.\u062a\ufef1\u062d\u0641(short, 1533, 11, 949), (Object)string4);
                string2.put(object3);
            }
            charSequence.put(\ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644(short, 1544, 4, 1668), string2);
            return charSequence.toString();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    private static long[] $d2j$hex$8cf49daf$decode_J(String src) {
        byte[] d = WoGG.$d2j$hex$8cf49daf$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$8cf49daf$decode_I(String src) {
        byte[] d = WoGG.$d2j$hex$8cf49daf$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$8cf49daf$decode_S(String src) {
        byte[] d = WoGG.$d2j$hex$8cf49daf$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$8cf49daf$decode_B(String src) {
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

