/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.github.catvod.crawler.Spider
 *  com.github.catvod.crawler.SpiderDebug
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.content.Context;
import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufe8f\ufe8e\ufeb5\u0641;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufe9d\u0631\ufe8f\u064a;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.parser.\ufec1\u0636\u062d\u0638;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.Jz;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0641\u0631\ufeed\u0643;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufebd\u0640\u0648\u062b;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.merge.\ufee9\ufee1\u0627\u0641;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0640\u0633\ufea5\u0631;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufe99\u062c\u0643\ufec1;
import com.github.catvod.spider.\ufea5\u062d\ufebd\u0633;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import com.github.catvod.spider.\ufeaf\u0633\u0648\ufee9;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import com.github.catvod.spider.\ufeb5\ufe8e\ufead\u0632;
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class LiveGz
extends Spider {
    private static final short[] short = LiveGz.$d2j$hex$347e0772$decode_S("77066b066b066f066c062506300630067e066f0676063106720670067a062c067b0665067a0631067c0670067206df0bdb0bd60b7c0a700a650a720a790a4e0a780a750a390c3a0c370c370c040c2f0c220c2b0c3e0c7e0b810b860b840b8c0bbe02b102bd02b502790c2f0c2a0c790c3c012301390123013e01230124012d01180a1b0a130a1b0ad103d603c303c503c7037c056f057c0577056d0546057705780574057c054e0a540b580b4d0b5a0b510b660b4d0b500b540b5c0bee0bee0b8e0bc70bc70b830beb0beb0b990bce0bce0bfa6fd0578b85f008c90bd90bd50bc80bdf0bf87da16f21452c0b1a5e6458b38ec80383037768a551cf057a0ab907e007a407b007a307af07a707e007f807e007f207e007ee07e007aa07ad07b607e007f807e007c70ac90ac70a910a840a820ac70adf0ac70a54035a03540302030f030603130354034c03540305075a07b10bbb0bb40bbd0bbf0bab0bb30baf0bba0bc20bc20bcc0bc20bdb0b840bd40b3107330731073107310730073107380731073107310732073107330731073607bf07f707ea07bf07fc07f907e607f507bf07e307e007ff07e207e407e307af07e007f107e207f107fd07f507e407f507e207ad07fb07f507e907b505930585059205cd05a105870585058e0594055c0958095b094709470943091c0900091d09020901091d090309670868086d0861086a087008290872086108760877086d086b086a083f0522053c052205380522053c050a0a1b0a080a1b0a170a1f0a0e0a1f0a080a09070c0719070c07c005f205de05d905cc05d905d805de057908c2059b05db05d805d505d505e605cd05c005c905dc059b0583059b0528062606280667066b067e0669066206550663066e0628063006280637033903370378037c03710337032f0337039901c60117041d0412041b0419040d04150409041c04640464046a0464047d042204720477097509770977097709760977097e097709770977097409770975097709700931057905640531057205770568057b0531057a057b056a057f057705720521056e057f056c057f0573057b056a057b056c05230575057b056705ca06ec06fa06ed06b206de06f806fa06f106eb0698099c099f09830983098709d809c409d909c609c509d909c70910011f011a0116011d0107015e0105011601010100011a011c011d01b808a508bb08a508bf08a508bb08ec07fd07ee07fd07f107f907e807f907ee07c401c101d401c101e001d201fe01f901ec01f901f801fe01e905ec05f305e005da05e905ec05eb05e005bd04b204be04b60499083f0b610b270b6a0bf9079d89955092748b4dac8bfb9a474c914c3f4d155c2056c701c701c701af01b301ae01b301ae01de7a9e6eab08b608a808ac08b608ab08ba03b603b503080415040804150409042c899c704a0357034a03570348036a778778ef05e805f605f903e803fb03fa03ec039d0c52044e0443045b04770450044e04");
    private String yq = \u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(LiveGz.\ufea9\u062b\u0645\ufead(), 0, 23, 1567);

    /*
     * Enabled aggressive block sorting
     */
    public LiveGz() {
        int n = \ufee9\ufee1\u0627\u0641.\u0641\u0638\ufeb1\ufeb5();
        int n2 = 1616;
        block6: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block6;
                }
                case 49: {
                    if (n <= 0) {
                        n2 = 1709;
                        continue block6;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block6;
                }
                case 204: {
                    Float f = Float.decode((String)\ufeb1\ufe8e\ufee1\ufe9d.\u0645\ufe8e\u0627\u064a("UTPt2xDpHiaSTR1vI3LH"));
                    System.out.println(f);
                    return;
                }
                case 239: 
            }
            break;
        }
    }

    /*
     * Exception decompiling
     */
    private Ef SN(JSONObject var1_1, int var2_2) {
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
     * Exception decompiling
     */
    private List<Ef> yq(String var1_1) {
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
     * Enabled aggressive block sorting
     */
    public static String \u063a\u0640\u062e\u0641(Object object) {
        int n = \u0631\u0640\ufec1\ufee9.\ufe95\ufed5\u0643\u0628();
        int n2 = 1616;
        block10: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n <= 0) {
                        n2 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block10;
                }
                case 204: {
                    return ((LiveGz)((Object)object)).yq;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            object = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return object;
                }
                default: {
                    continue block11;
                }
                case 17: 
            }
            n2 = 1771;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Ef \u0643\ufee9\ufec5\u0632(Object object, Object object2, int n) {
        int n2 = \ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9();
        int n3 = 1616;
        block10: while (true) {
            switch (n3 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n2 <= 0) {
                        n3 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n3 = 1678;
                    continue block10;
                }
                case 204: {
                    return ((LiveGz)((Object)object)).SN((JSONObject)object2, n);
                }
                case 239: 
            }
            break;
        }
        object2 = null;
        n = 1740;
        block11: while (true) {
            object = object2;
            switch (n ^= 0x6DD) {
                case 54: {
                    return object;
                }
                default: {
                    continue block11;
                }
                case 17: 
            }
            n = 1771;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static List \ufea5\ufec1\ufee9\u0642(Object object, Object object2) {
        int n = \ufe9d\u0631\ufe8f\u064a.\ufebd\u0643\ufe9d\u062c();
        int n2 = 1616;
        block10: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n > 0) {
                        n2 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block10;
                }
                case 204: {
                    return ((LiveGz)((Object)object)).yq((String)object2);
                }
                case 239: 
            }
            break;
        }
        object2 = null;
        n2 = 1740;
        block11: while (true) {
            object = object2;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return object;
                }
                default: {
                    continue block11;
                }
                case 17: 
            }
            n2 = 1771;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static short[] \ufea9\u062b\u0645\ufead() {
        int n = \ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632();
        int n2 = 1616;
        block10: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n > 0) {
                        n2 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block10;
                }
                case 204: {
                    return short;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            short[] sArray = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return sArray;
                }
                default: {
                    continue block11;
                }
                case 17: 
            }
            n2 = 1771;
        }
    }

    /*
     * Unable to fully structure code
     */
    public static void \ufed5\u062b\u0643\ufea9(Object var0) {
        var2_1 = \ufea5\u062d\ufebd\u0633.\u0645\ufe95\u0647\ufec1();
        var1_2 = 1616;
        block16: while (true) {
            switch (var1_2 ^= 1633) {
                default: {
                    continue block16;
                }
lbl7:
                // 2 sources

                case 14: {
                    var1_2 = 1678;
                    continue block16;
                }
                case 49: {
                    if (var2_1 >= 0) ** GOTO lbl7
                    var1_2 = 1709;
                    continue block16;
                }
                case 204: {
                    SpiderDebug.log((Throwable)((Throwable)var0));
lbl16:
                    // 2 sources

                    while (true) {
                        var2_1 = \ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635();
                        var1_2 = 1740;
                        block19: while (true) {
                            switch (var1_2 ^= 1757) {
                                default: {
                                    continue block19;
                                }
                                case 17: {
                                    if (var2_1 <= 0) {
                                        var1_2 = 1833;
                                        continue block19;
                                    }
                                }
                                case 54: {
                                    var1_2 = 1802;
                                    continue block19;
                                }
                                case 500: {
                                    var0 = Float.decode((String)\ufeb9\u0643\ufed9\ufed5.\u0647\ufeab\ufe99\u0639("lg"));
                                    System.out.println(var0);
                                }
                                case 471: 
                            }
                            break;
                        }
                        return;
                    }
                }
                case 239: 
            }
            break;
        }
        var1_2 = 1864;
        block20: while (true) {
            switch (var1_2 ^= 1881) {
                case 47483: {
                    ** continue;
                }
                default: {
                    continue block20;
                }
                case 17: 
            }
            var1_2 = 48674;
        }
    }

    public String categoryContent(String string, String string2, boolean bl, HashMap<String, String> object) {
        object = null;
        String string3 = "\u06e7\u06e6\u06e6";
        string2 = string;
        string = string3;
        block4: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    string2 = \ufe99\u062e\u0642\u0644.\ufea1\u062e\ufecd\ufeab(object);
                    string = "\u06e6\u06df\u06e5";
                    continue block4;
                }
                case 1754599: {
                    object = LiveGz.\ufea5\ufec1\ufee9\u0642((Object)this, string2);
                    string = "\u06e4\u06e0\u06e4";
                    continue block4;
                }
                case 1753420: 
            }
            break;
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public String detailContent(List<String> object) {
        String[] stringArray = \ufeb5\ufe8e\ufead\u0632.\u0640\ufec5\ufedd\u0634((String)\u0646\ufecd\ufead\u0647.\u0643\ufe8e\u0644\ufe95(object, 0), \ufea9\u0643\u062d\u063a.\ufea1\u0633\ufe8e\u0627(LiveGz.\ufea9\u062b\u0645\ufead(), 294, 1, 2132));
        Object object2 = \ufea9\ufec5\u0647\u0641.\ufeed\ufe8e\ufec5\ufea9(\ufebd\u0640\u0648\u062b.\ufea5\u0639\u0631\ufe95(LiveGz.\ufea9\u062b\u0645\ufead(), 295, 14, 1465));
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(object2, stringArray[2]);
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(object2, \u062b\ufec1\ufeb1\u062d.\u0637\u0647\u0635\u0630(LiveGz.\ufea9\u062b\u0645\ufead(), 309, 14, 1546));
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(object2, stringArray[1]);
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(object2, \ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(LiveGz.\ufea9\u062b\u0645\ufead(), 323, 9, 789));
        ArrayList arrayList = \ufec1\u0636\u062d\u0638.\u062f\u0627\u062b\u0628(object2, stringArray[0], \ufeb5\ufe8e\ufead\u0632.\ufe8f\ufef1\u0648\ufe95(LiveGz.\ufea9\u062b\u0645\ufead(), 332, 2, 443));
        object2 = \ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(LiveGz.\ufea9\u062b\u0645\ufead(), 334, 16, 1116);
        String string = \ufe99\u062c\u0643\ufec1.\u0648\u0634\u063a\ufeb1(LiveGz.\ufea9\u062b\u0645\ufead(), 350, 16, 2375);
        String string2 = \u0644\ufe8f\u0628\u062a.\u0647\u062e\u062f\u0631(arrayList, object2, string, 0);
        String string3 = \ufec1\u0636\u062d\u0638.\u062f\u0627\u062b\u0628(new StringBuilder(), LiveGz.\u063a\u0640\u062e\u0641((Object)this), \u062d\ufeb9\ufeab\ufef1.\ufeed\u0638\u0635\ufed5(LiveGz.\ufea9\u062b\u0645\ufead(), 366, 29, 1310));
        arrayList = \ufe9d\u0631\ufe8f\u064a.\u0637\u0633\ufeb1\u063a(\u062d\u062e\ufe8e\u0645.\u062d\ufeab\u0642\u0647(LiveGz.\ufea9\u062b\u0645\ufead(), 395, 10, 1695), \u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(LiveGz.\ufea9\u062b\u0645\ufead(), 405, 13, 2551), \u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(LiveGz.\ufea9\u062b\u0645\ufead(), 418, 14, 371), \ufeb9\u0627\ufea5\ufe9d.\u062a\ufef1\u062d\u0641(LiveGz.\ufea9\u062b\u0645\ufead(), 432, 7, 2187));
        HashMap hashMap = new HashMap();
        \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, \ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(LiveGz.\ufea9\u062b\u0645\ufead(), 439, 9, 1948), string2);
        JSONObject jSONObject = new JSONObject(\ufea9\ufe8f\u0647\ufead.\ufeaf\ufead\ufe8e\u0640(\ufeab\u0632\u062f\u0640.\ufeab\u0632\ufec5\u0645(new JSONObject(\u062a\u0635\ufeb1\u0642.\ufe8f\u062f\u062a\ufe8e(\ufeab\u062d\u063a\ufea9.\ufec1\ufed5\ufebd\ufea9(string3, hashMap, arrayList))), \ufeab\u0632\u062f\u0640.\u062f\u0627\ufe95\u0631(LiveGz.\ufea9\u062b\u0645\ufead(), 448, 4, 416)), object2, string));
        Ef ef = LiveGz.\u0643\ufee9\ufec5\u0632((Object)this, jSONObject, \u0632\ufead\u062f\u0628.\u0642\u062b\ufea9\ufecd(jSONObject, \u0646\ufecd\ufead\u0647.\u0640\u062e\ufed5\ufeaf(LiveGz.\ufea9\u062b\u0645\ufead(), 452, 8, 397)));
        arrayList = new ArrayList();
        object2 = new ArrayList();
        string3 = \u0630\ufebd\u0634\ufec9.\u0642\u0627\u0645\u0643(jSONObject, \u062d\u062e\ufe8e\u0645.\u062d\ufeab\u0642\u0647(LiveGz.\ufea9\u062b\u0645\ufead(), 460, 9, 1413));
        int n = 0;
        block10: while (true) {
            int n2 = \u0644\ufe8f\u0628\u062a.\ufee9\ufe8e\ufe99\u0631(string3);
            int n3 = 1616;
            block11: while (true) {
                switch (n3 ^= 0x661) {
                    default: {
                        continue block11;
                    }
                    case 49: {
                        if (n < n2) {
                            n3 = 1709;
                            continue block11;
                        }
                    }
                    case 14: {
                        n3 = 1678;
                        continue block11;
                    }
                    case 204: {
                        string2 = \u0632\ufead\u062f\u0628.\ufead\u062b\ufeb1\u0644(string3, n);
                        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList, \ufeab\u0632\u062f\u0640.\ufed9\ufeab\u0643\u0633(string2, \ufe95\u0627\ufe8e\u0644.\u062d\u0636\ufea9\u0640(LiveGz.\ufea9\u062b\u0645\ufead(), 469, 4, 1235)));
                        ArrayList arrayList2 = new ArrayList();
                        StringBuilder stringBuilder = new StringBuilder();
                        n2 = n + 1;
                        \u062d\u062e\ufe8e\u0645.\u0630\ufe9d\ufec5\ufe95(stringBuilder, n2);
                        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, \ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(LiveGz.\ufea9\u062b\u0645\ufead(), 473, 1, 2237));
                        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, \ufeab\u0632\u062f\u0640.\ufeab\u0632\ufec5\u0645(string2, \u0630\ufebd\u0634\ufec9.\u0639\ufe8f\u064a\ufebd(LiveGz.\ufea9\u062b\u0645\ufead(), 474, 4, 2898)));
                        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList2, \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(stringBuilder));
                        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(object2, \u062b\ufec1\ufeb1\u062d.\u0628\ufeed\ufea5\u0636(\ufea1\u0645\u062b\u0634.\u0638\ufec9\u0630\ufe95(LiveGz.\ufea9\u062b\u0645\ufead(), 478, 1, 2010), arrayList2));
                        n3 = 1740;
                        block12: while (true) {
                            n = n2;
                            switch (n3 ^= 0x6DD) {
                                case 54: {
                                    continue block10;
                                }
                                default: {
                                    continue block12;
                                }
                                case 17: 
                            }
                            n3 = 1771;
                        }
                    }
                    case 239: 
                }
                break;
            }
            break;
        }
        \u0644\ufe8f\u0628\u062a.\ufed9\ufead\ufef1\ufea5(ef, \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640());
        \ufe8e\ufec1\u0641\u0644.\ufeb1\u0636\ufeaf\u0639(ef, \u0646\ufecd\ufead\u0647.\u0640\u062e\ufed5\ufeaf(LiveGz.\ufea9\u062b\u0645\ufead(), 479, 11, 618));
        String string4 = \ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(LiveGz.\ufea9\u062b\u0645\ufead(), 490, 3, 483);
        \ufeb9\u0627\ufea5\ufe9d.\ufef1\ufed5\ufea9\u0644(ef, \u062b\ufec1\ufeb1\u062d.\u0628\ufeed\ufea5\u0636(string4, arrayList));
        \u0632\ufead\u062f\u0628.\ufe99\ufeab\ufe8f\u062f(ef, \u062b\ufec1\ufeb1\u062d.\u0628\ufeed\ufea5\u0636(string4, object2));
        return \ufea9\ufec5\u0647\u0641.\ufebd\ufeaf\ufee1\ufed5(ef);
    }

    public String homeContent(boolean bl) {
        String string = "\u06e4\u06e8\u06e3";
        ArrayList arrayList = null;
        String string2 = null;
        List list = null;
        String string3 = null;
        Jz jz = null;
        String string4 = null;
        short[] sArray = null;
        block29: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList, jz);
                    string = "\u06df\u06e8\u06e7";
                    continue block29;
                }
                case 56386: {
                    string4 = \ufe95\u0627\ufe8e\u0644.\u062d\u0636\ufea9\u0640(sArray, 498, 2, 2611);
                    string = "\u06e8\u06e3\u06e6";
                    continue block29;
                }
                case 1747929: {
                    jz = new Jz(string4, string3);
                    string = "\u06e2\u06df\u06e1";
                    continue block29;
                }
                case 1746974: {
                    sArray = LiveGz.\ufea9\u062b\u0645\ufead();
                    string = "\u06df\u06e0\u06e4";
                    continue block29;
                }
                case 1749790: {
                    sArray = LiveGz.\ufea9\u062b\u0645\ufead();
                    string = "\u06e7\u06e0\u06e5";
                    continue block29;
                }
                case 1751775: {
                    arrayList = new ArrayList();
                    string = "\u06e8\u06e7\u06e5";
                    continue block29;
                }
                case 1753482: {
                    sArray = LiveGz.\ufea9\u062b\u0645\ufead();
                    string = "\u06df\u06e7\u06e3";
                    continue block29;
                }
                case 1755467: {
                    jz = new Jz(string2, string4);
                    string = "\u06e0\u06e0";
                    continue block29;
                }
                case 1750537: {
                    sArray = LiveGz.\ufea9\u062b\u0645\ufead();
                    string = "\u06e7\u06e2\u06df";
                    continue block29;
                }
                case 56536: {
                    string3 = \ufee9\ufee1\u0627\u0641.\ufea1\ufebd\u063a\u0630(sArray, 521, 2, 3204);
                    string = "\u06e0\u06e8\u06e1";
                    continue block29;
                }
                case 56537: {
                    sArray = LiveGz.\ufea9\u062b\u0645\ufead();
                    string = "\u06e2\u06e4";
                    continue block29;
                }
                case 1749633: {
                    sArray = LiveGz.\ufea9\u062b\u0645\ufead();
                    string = "\u06e7\u06df";
                    continue block29;
                }
                case 1755590: {
                    sArray = LiveGz.\ufea9\u062b\u0645\ufead();
                    string = "\u06e2\u06e5\u06e2";
                    continue block29;
                }
                case 1749572: {
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList, jz);
                    string = "\u06e0\u06e8\u06e8";
                    continue block29;
                }
                case 1754501: {
                    string4 = \u0641\ufeb5\ufeb1\ufee1.\u0641\u0642\u0639\u0643(arrayList, list);
                    string = "\u06e0\u06e0\u06e5";
                    continue block29;
                }
                case 1746939: {
                    string3 = \u0646\ufecd\ufead\u0647.\u0640\u062e\ufed5\ufeaf(sArray, 514, 2, 1183);
                    string = "\u06df\u06e3\u06df";
                    continue block29;
                }
                case 1746811: {
                    jz = new Jz(string4, string3);
                    string = "\u06df\u06df\u06df";
                    continue block29;
                }
                case 1749759: {
                    string2 = \ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(sArray, 493, 5, 414);
                    string = "\u06e7\u06e0";
                    continue block29;
                }
                case 1746687: {
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList, jz);
                    string = "\u06e2\u06e6\u06e2";
                    continue block29;
                }
                case 1754412: {
                    string4 = \ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644(sArray, 516, 5, 890);
                    string = "\u06e2\u06e1\u06e0";
                    continue block29;
                }
                case 1755437: {
                    sArray = LiveGz.\ufea9\u062b\u0645\ufead();
                    string = "\u06e2\u06df";
                    continue block29;
                }
                case 1747682: {
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList, jz);
                    string = "\u06e3\u06df\u06e5";
                    continue block29;
                }
                case 1746723: {
                    string4 = \ufed9\ufe9d\ufeed\ufeb5.\u0638\ufec1\u063a\u0644(sArray, 500, 6, 2203);
                    string = "\u06e8\u06e2\u06e7";
                    continue block29;
                }
                case 1747936: {
                    list = LiveGz.\ufea5\ufec1\ufee9\u0642((Object)this, string2);
                    string = "\u06e7\u06e3\u06e1";
                    continue block29;
                }
                case 56381: {
                    string3 = \ufe99\u062c\u0643\ufec1.\u0648\u0634\u063a\ufeb1(sArray, 506, 3, 1012);
                    string = "\u06e3\u06e4\u06e5";
                    continue block29;
                }
                case 1750692: {
                    jz = new Jz(string4, string3);
                    string = "\u06e0\u06e0\u06e2";
                    continue block29;
                }
                case 1754468: {
                    string4 = \ufe8f\ufe8e\ufeb5\u0641.\u062f\u0627\u0640\ufee1(sArray, 509, 5, 1080);
                    string = "\u06e6\u06e1\u06e5";
                    continue block29;
                }
                case 1747685: 
            }
            break;
        }
        return string4;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void init(Context context, String string) {
        super.init(context, string);
        boolean bl = \ufea5\u062d\ufebd\u0633.\u0639\ufeb1\ufead\ufe8f(string);
        int n = 1616;
        block6: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block6;
                }
                case 49: {
                    if (!bl) {
                        n = 1709;
                        continue block6;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block6;
                }
                case 204: {
                    this.yq = string;
                    return;
                }
                case 239: 
            }
            break;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String playerContent(String string, String string2, List<String> jSONObject) {
        string = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
        \ufea9\ufec5\u0647\u0641.\u0636\u0633\u0645\ufe9d(true);
        try {
            jSONObject = new JSONObject();
            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(jSONObject, \u062f\ufead\ufeaf\u062d.\ufec9\u0630\ufed9\ufeb1(LiveGz.\ufea9\u062b\u0645\ufead(), 523, 3, 1434), string2);
            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(jSONObject, \ufea1\u0645\u062b\u0634.\u0638\ufec9\u0630\ufe95(LiveGz.\ufea9\u062b\u0645\ufead(), 526, 5, 905), \ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(LiveGz.\ufea9\u062b\u0645\ufead(), 531, 1, 3245));
            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(jSONObject, \ufecd\u0642\u062e\ufe9d.\u0637\ufee9\u0635\u0630(LiveGz.\ufea9\u062b\u0645\ufead(), 532, 7, 1058), string);
            string2 = \ufeaf\u0633\u0648\ufee9.\ufeb5\u0634\u0640\ufea1(jSONObject);
            return string2;
        }
        catch (Exception exception) {
            LiveGz.\ufed5\u062b\u0643\ufea9(exception);
            return string;
        }
    }

    public String searchContent(String string, boolean bl) {
        return \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
    }

    private static long[] $d2j$hex$347e0772$decode_J(String src) {
        byte[] d = LiveGz.$d2j$hex$347e0772$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$347e0772$decode_I(String src) {
        byte[] d = LiveGz.$d2j$hex$347e0772$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$347e0772$decode_S(String src) {
        byte[] d = LiveGz.$d2j$hex$347e0772$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$347e0772$decode_B(String src) {
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

