/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.github.catvod.crawler.SpiderDebug
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.content.Context;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\u0645\u0641\u0630\u062d;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufe8f\ufe8e\ufeb5\u0641;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufe9d\u0631\ufe8f\u064a;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.Jz;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0641\u0631\ufeed\u0643;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
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
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class KkSs
extends Pan {
    private static final short[] short = KkSs.$d2j$hex$ec33bfd8$decode_S("b408a808a808ac08e608f308f308a408b508bd08b308bf08bb08b908f208ba08a908b208f30837052b052b052f056505700570056d05270536053e0530052f053e053105710539052a0531057005f703eb03eb03ef03ec03a503b003b003f903fa03f603f203fe03f003a903a903a903b103f903ea03f103b00341065d065d0659065a061306060606065d065f060706500650064d065a0650065a0607065d0646065906060667097b097b097f093509200920097809780978092109620966097e09640921096c096c09200943065f065f065b0658061106040604064606420643064f06590605065f0644065b060406d807c407c407c007c3078a079f079f07d607d507d907dd07d107df078607860786079e07d607c507de079f07bb04a704a704a304e904fc04fc04ab04ba04b204bc04be04ba04e504e504e504fd04b504a604bd04fc04ec592f5d566194075e035903530352034f03190347035f0347031803410358035303180353035203430356035e035b0318035e0353031803170251024d0254025502480645065a0602065a06450648064906430601064f0643065a0649065e060c06480645065a0602064106430648065906400649060106450658064906410601065c0645064f060c06450641064b06020640064d0656065506400643064d06480606090b091309db01c701c701c301c00189019c019c01da01de01d401830184019d01c001dc01d401dc01c601d001d701dd019d01d001dc01de019c01c50181019c01c701db01c601de01d1019c01c101d601c701ca01c301d601ec01d601cb01d001df01c601d701d601ec01d401da01d5019c01d601cb01c7019c01d201c601c701dc019c01c2019c018a0186019c01d001c101dc01c3019c01cb01ca019c01d201da019c01c7019c0183019c018c01d201c301c301da01d7018e018201810181019501c601c101df018e01db01c701c701c301c00189019c019c01c00182019d01da01de01d201d401d601db01c601d1019d01d001d0019c01da01de01d201d401d601c0019c0181018301810185019c0183018a019c0181018a019c01d001860183018101d2018a01d70184018b01d601d601d00186018001d6018a01d0018401d2018301d001810181018501d701820184018101830182018a01d1019d01de01d7019d01d901c301d401f652828ebd51104dc907c407db078307c007c207c907d807c107c8078007df07c207da078007c407c307cb07c2078d0793078d07cc0754025102440251021d0253025c025902400252025f025102420254021d024402550248024402bd09a609af09bc09ab099b09bc09a209e309e3096c037803650367037903f506e906e406fc06f606ca07ca07ca07b90166df09d87660ca6975610b7882714663787aca6956f89f4975625b644663787aab05a905a205b305aa05a305eb05b505a305a705b405a505ae05eb05af05b205a305ab05230c1c0c190c0c0c190c550c0b0c0a0c1b0c250c7502780267023f027c027e02750264027d0274023c026202740270026302720279023c027802650274027c02280a5c0a640a2b0a290a2e0a680a740a6d0a6c0afa08c908d308c408c7088b089c08c508c408d508c008c808cd08fc08fa08d508c808d508cd08c408fc084f0c550c420c410c41064c0654064b0b4e0b5b0b4e0b020b5c0b5d0b4c0bac06");
    private String[] O = new String[]{\u0631\ufea1\u0638\u0627.\u0645\u062f\u062d\ufeaf(KkSs.\u063a\u0637\u0642\u062a(), 0, 19, 2268), \ufeb9\u0643\ufed9\ufed5.\u0628\u062f\ufea1\u0642(KkSs.\u063a\u0637\u0642\u062a(), 19, 20, 1375), \u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(KkSs.\u063a\u0637\u0642\u062a(), 39, 22, 927), \ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(KkSs.\u063a\u0637\u0642\u062a(), 61, 22, 1577), \u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(KkSs.\u063a\u0637\u0642\u062a(), 83, 19, 2319), \ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(KkSs.\u063a\u0637\u0642\u062a(), 102, 18, 1579), \ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(KkSs.\u063a\u0637\u0642\u062a(), 120, 22, 1968), \ufeaf\u0633\u0648\ufee9.\u062e\u0645\u0644\u0648(KkSs.\u063a\u0637\u0642\u062a(), 142, 21, 1235)};

    /*
     * Enabled aggressive block sorting
     */
    public KkSs() {
        int n = \u062b\ufec1\ufeb1\u062d.\ufe8f\ufe9d\u0628\ufe99();
        int n2 = 1616;
        block6: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block6;
                }
                case 49: {
                    if (n >= 0) {
                        n2 = 1709;
                        continue block6;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block6;
                }
                case 204: {
                    Double d = Double.decode((String)\u062d\u062e\ufe8e\u0645.\u0631\u063a\u0647\ufead("XM"));
                    System.out.println(d);
                    return;
                }
                case 239: 
            }
            break;
        }
    }

    /*
     * Unable to fully structure code
     */
    public static void \u062c\u0639\ufee9\ufeb1(Object var0) {
        var2_1 = \ufe9d\ufeab\u062e\u0640.\ufeb5\ufead\u0638\u062f();
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
                    if (var2_1 < 0) ** GOTO lbl7
                    var1_2 = 1709;
                    continue block16;
                }
                case 204: {
                    SpiderDebug.log((String)((String)var0));
lbl16:
                    // 2 sources

                    while (true) {
                        var2_1 = \u0644\ufe8f\u0628\u062a.\u0647\ufebd\u0627\u0631();
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
                                    var0 = Double.valueOf(\u0631\u0640\ufec1\ufee9.\u0627\ufec5\u0636\ufeaf("GP4q"));
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

    /*
     * Enabled aggressive block sorting
     */
    public static short[] \u063a\u0637\u0642\u062a() {
        int n = \u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a();
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
     * Enabled aggressive block sorting
     */
    public static String \ufe8e\ufead\ufe8f\u0635(Object object) {
        int n = \ufe8e\ufeb9\u0647\u0642.\ufe99\u062b\ufea1\u0647();
        int n2 = 1616;
        block10: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n < 0) {
                        n2 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block10;
                }
                case 204: {
                    return ((WebsiteResponse)object).getResponse();
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
    public static void \ufeb5\ufe8e\ufef1\ufec9(Object object) {
        int n = \u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead();
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
                    SpiderDebug.log((Throwable)((Throwable)object));
                    return;
                }
                case 239: 
            }
            break;
        }
        n2 = 1740;
        block11: while (true) {
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return;
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
    public static String \ufed5\u062d\u0637\u0634(Object object) {
        int n = \u062d\ufeb9\ufeab\ufef1.\ufe8e\u0645\u0632\u0628();
        int n2 = 1616;
        block10: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n < 0) {
                        n2 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block10;
                }
                case 204: {
                    return ((WebsiteResponse)object).getUrl();
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
    public static String[] \ufef1\ufeb5\ufec1\u0643(Object stringArray) {
        int n = \ufeaf\u0633\u0648\ufee9.\u0641\u062b\u062d\ufeed();
        int n2 = 1616;
        block10: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n >= 0) {
                        n2 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block10;
                }
                case 204: {
                    return ((KkSs)stringArray).O;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            stringArray = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return stringArray;
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

    public String homeContent(boolean bl) {
        String string = "\u06e4\u06e6\u06e7";
        ArrayList arrayList = null;
        Jz jz = null;
        String string2 = null;
        JSONObject jSONObject = null;
        ArrayList arrayList2 = null;
        short[] sArray = null;
        String string3 = null;
        block12: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    string3 = \u062a\ufee1\ufe8e\ufeb9.\ufec5\ufecd\ufea9\ufea5(sArray, 495, 1, 392);
                    string = "\u06e2\u06df\u06df";
                    continue block12;
                }
                case 1751586: {
                    arrayList = new ArrayList();
                    string = "\u06e3\u06e2\u06e1";
                    continue block12;
                }
                case 1750626: {
                    sArray = KkSs.\u063a\u0637\u0642\u062a();
                    string = "\u06e6\u06e6\u06e8";
                    continue block12;
                }
                case 1749570: {
                    sArray = KkSs.\u063a\u0637\u0642\u062a();
                    string = "\u06e5\u06e1\u06df";
                    continue block12;
                }
                case 1748642: {
                    jSONObject = new JSONObject();
                    string = "\u06e3\u06e8\u06e6";
                    continue block12;
                }
                case 1752515: {
                    string2 = \ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(sArray, 496, 16, 1882);
                    string = "\u06e8\u06e7";
                    continue block12;
                }
                case 1750817: {
                    string3 = \ufed9\ufe8e\u062d\ufead.\u062d\ufee1\u064a\ufecd(arrayList, arrayList2, jSONObject);
                    string = "\u06e3\u06e0\u06e3";
                    continue block12;
                }
                case 1751717: {
                    arrayList2 = new ArrayList();
                    string = "\u06e4\u06e2\u06e0";
                    continue block12;
                }
                case 56575: {
                    jz = new Jz(string3, string2);
                    string = "\u06e2\u06e2\u06e5";
                    continue block12;
                }
                case 1749669: {
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList, jz);
                    string = "\u06e1\u06e0\u06e1";
                    continue block12;
                }
                case 1750566: 
            }
            break;
        }
        return string3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void init(Context context, String string) {
        try {
            super.init(context, string);
            return;
        }
        catch (Exception exception) {
            int n = 1616;
            block6: while (true) {
                switch (n ^= 0x661) {
                    case 14: {
                        return;
                    }
                    default: {
                        continue block6;
                    }
                    case 49: 
                }
                n = 1647;
            }
        }
    }

    /*
     * Exception decompiling
     */
    public void requestWebsites(String[] var1_1, List<WebsiteResponse> var2_2, String var3_3) {
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
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String searchContent(String var1_1, boolean var2_3) {
        var8_4 = new ArrayList<E>();
        var7_5 = \ufeab\u0632\u062f\u0640.\u062f\u0627\ufe95\u0631(KkSs.\u063a\u0637\u0642\u062a(), 530, 10, 3192);
        var6_6 = new ArrayList<E>();
        \ufee1\u0639\u063a\u0645.\u0646\u0645\ufef1\ufeaf((Object)this, KkSs.\ufef1\ufeb5\ufec1\u0643((Object)this), var6_6, var1_1);
        var4_7 = 0;
        block23: while (true) {
            block32: {
                block31: {
                    var5_9 = \ufea9\ufe8f\u0647\ufead.\u0631\ufe8f\u0628\ufe99(var6_6);
                    var3_8 = 1616;
                    block24: while (true) {
                        switch (var3_8 ^= 1633) {
                            default: {
                                continue block24;
                            }
                            case 49: {
                                if (var4_7 < var5_9) {
                                    var3_8 = 1709;
                                    continue block24;
                                }
                            }
                            case 14: {
                                var3_8 = 1678;
                                continue block24;
                            }
                            case 204: {
                                var1_1 = (WebsiteResponse)\u062b\ufec1\ufeb1\u062d.\ufed5\u0644\u0642\u0638(var6_6, var4_7);
                                var9_10 = \ufeed\ufebd\u0635\ufedd.\ufecd\u0636\ufea9\u0628(\u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(\u0635\u0631\u0645\u0628.\u0631\u063a\u0645\u0641(KkSs.\ufe8e\ufead\ufe8f\u0635(var1_1)), \u0635\u0631\u0645\u0628.\u0646\u0627\u062a\u062d(KkSs.\u063a\u0637\u0642\u062a(), 540, 22, 529)));
lbl24:
                                // 2 sources

                                while (true) {
                                    var2_3 = \ufe8e\u0627\ufecd\u062a.\u062f\u0638\ufe8e\ufe99(var9_10);
                                    var3_8 = 1740;
                                    break block24;
                                    break;
                                }
                            }
                            case 239: {
                                return \ufe99\u062e\u0642\u0644.\ufea1\u062e\ufecd\ufeab(var8_4);
                            }
                        }
                        break;
                    }
                    block26: while (true) {
                        switch (var3_8 ^= 1757) {
                            default: {
                                continue block26;
                            }
                            case 17: {
                                if (var2_3) {
                                    var3_8 = 1833;
                                    continue block26;
                                }
                            }
                            case 54: {
                                var3_8 = 1802;
                                continue block26;
                            }
                            case 500: {
                                try {
                                    var12_13 = (hN)\ufea1\u0645\u062b\u0634.\ufe95\ufeaf\ufeb9\ufea1(var9_10);
                                    var11_12 = \u0646\ufecd\ufead\u0647.\u0640\u062e\ufed5\ufeaf(KkSs.\u063a\u0637\u0642\u062a(), 562, 10, 2560);
                                    var10_11 = \ufea9\u0643\u062d\u063a.\ufea1\u0633\ufe8e\u0627(KkSs.\u063a\u0637\u0642\u062a(), 572, 21, 2209);
                                    \u0641\ufeb5\ufeb1\ufee1.\ufedd\u0630\u0636\u0647(var12_13);
                                    var11_12 = \ufe8e\ufeb9\u0647\u0642.\ufea1\ufead\u0646\ufedd(var11_12, \ufea5\u062d\ufebd\u0633.\ufe99\u0628\u0637\ufe9d(\ufeb5\ufe8e\ufead\u0632.\ufef1\ufeab\u062c\u0640(var10_11, var12_13), \u0632\ufead\u062f\u0628.\u0645\u062a\u0637\u0635(KkSs.\u063a\u0637\u0642\u062a(), 593, 4, 3111)), 1);
                                    var10_11 = \ufea5\u062d\ufebd\u0633.\ufe99\u0628\u0637\ufe9d(\ufeb5\ufe8e\ufead\u0632.\ufef1\ufeab\u062c\u0640(var7_5, var12_13), \ufe99\u062c\u0643\ufec1.\u0648\u0634\u063a\ufeb1(KkSs.\u063a\u0637\u0642\u062a(), 597, 3, 1568));
                                    var12_13 = \ufea5\u062d\ufebd\u0633.\ufe99\u0628\u0637\ufe9d(\ufeb5\ufe8e\ufead\u0632.\ufef1\ufeab\u062c\u0640(var7_5, var12_13), \ufe8e\ufeb9\u0647\u0642.\ufee1\u062f\ufedd\u0643(KkSs.\u063a\u0637\u0642\u062a(), 600, 8, 2863));
                                    var13_14 = new StringBuilder();
                                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var13_14, KkSs.\ufed5\u062d\u0637\u0634(var1_1));
                                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var13_14, \u0635\u0631\u0645\u0628.\u0646\u0627\u062a\u062d(KkSs.\u063a\u0637\u0642\u062a(), 608, 1, 1674));
                                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var13_14, var11_12);
                                    var14_15 = new Ef(\ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(var13_14), var10_11, (String)var12_13, \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640());
                                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(var8_4, var14_15);
                                    var3_8 = 1864;
                                    break block31;
                                }
                                catch (Exception var1_2) {
                                    KkSs.\ufeb5\ufe8e\ufef1\ufec9(var1_2);
                                    break block26;
                                }
                            }
                            case 471: 
                        }
                        break;
                    }
                    break block32;
                }
                block27: while (true) {
                    switch (var3_8 ^= 1881) {
                        case 47483: {
                            ** continue;
                        }
                        default: {
                            continue block27;
                        }
                        case 17: 
                    }
                    var3_8 = 48674;
                }
            }
            var3_8 = 48767;
            block28: while (true) {
                switch (var3_8 ^= 48784) {
                    default: {
                        continue block28;
                    }
                    case 14: {
                        ++var4_7;
                        continue block23;
                    }
                    case 239: 
                }
                var3_8 = 48798;
            }
            break;
        }
    }

    private static long[] $d2j$hex$ec33bfd8$decode_J(String src) {
        byte[] d = KkSs.$d2j$hex$ec33bfd8$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$ec33bfd8$decode_I(String src) {
        byte[] d = KkSs.$d2j$hex$ec33bfd8$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$ec33bfd8$decode_S(String src) {
        byte[] d = KkSs.$d2j$hex$ec33bfd8$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$ec33bfd8$decode_B(String src) {
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

    private static class WebsiteResponse {
        private String SN;
        private String yq;

        /*
         * Enabled aggressive block sorting
         */
        public WebsiteResponse(String string, String string2) {
            this.yq = string2;
            this.SN = string;
            int n = \ufe8f\ufe8e\ufeb5\u0641.\u0647\u0639\ufee9\ufedd();
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
                        double d = Double.parseDouble(\u0645\u0641\u0630\u062d.\ufe95\ufeed\u064a\ufe8f("Bam9ThL4rV99DpBI5HCSu5"));
                        System.out.println(d);
                        return;
                    }
                    case 239: 
                }
                break;
            }
        }

        /*
         * Enabled aggressive block sorting
         */
        public static String \u064a\u062a\ufea5\u062e(Object object) {
            int n = \u0631\u063a\u0645\u0641.\u064a\u062b\u0635\ufe9d();
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
                        return ((WebsiteResponse)object).yq;
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
        public static String \u064a\u0644\u0639\ufe99(Object object) {
            int n = \ufeed\ufebd\u0635\ufedd.\ufe8e\u0628\u0638\u0631();
            int n2 = 1616;
            block10: while (true) {
                switch (n2 ^= 0x661) {
                    default: {
                        continue block10;
                    }
                    case 49: {
                        if (n < 0) {
                            n2 = 1709;
                            continue block10;
                        }
                    }
                    case 14: {
                        n2 = 1678;
                        continue block10;
                    }
                    case 204: {
                        return ((WebsiteResponse)object).SN;
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

        public String getResponse() {
            return WebsiteResponse.\u064a\u062a\ufea5\u062e(this);
        }

        public String getUrl() {
            return WebsiteResponse.\u064a\u0644\u0639\ufe99(this);
        }
    }
}

