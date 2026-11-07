/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.github.catvod.crawler.Spider
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.content.Context;
import com.github.catvod.crawler.Spider;
import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\u0645\u0641\u0630\u062d;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufe8f\ufe8e\ufeb5\u0641;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufe9d\u0631\ufe8f\u064a;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeaf\u062b\ufed5\ufec1;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.parser.\ufeb9\ufec9\u0648\u062d;
import com.github.catvod.parser.\ufec1\u0636\u062d\u0638;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.Jz;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\u0641\u0631\ufeed\u0643;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufebd\u0640\u0648\u062b;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.merge.\ufee9\ufee1\u0627\u0641;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\u0636\u0634\ufec1\u0631;
import com.github.catvod.spider.\ufe8e\u0627\ufecd\u062a;
import com.github.catvod.spider.\ufe99\u062c\u0643\ufec1;
import com.github.catvod.spider.\ufea5\u062d\ufebd\u0633;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import com.github.catvod.spider.\ufeaf\u0633\u0648\ufee9;
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
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class Kanqiu
extends Spider {
    private static final short[] short = Kanqiu.$d2j$hex$51448d4a$decode_S("7f086308630867082d083808380860086008600839082f082f087c087608790866087e08620839086208640872095409420955090a0966094009420949095309e908cb08de08cd08c808c808c5088b0891088a08940884088c08f308cd08ca08c008cb08d308d7088408ea08f0088408950894088a0894089f088408f308cd08ca08920890089f088408dc08920890088d088408e508d408d408c808c108f308c108c608ef08cd08d0088b089108970893088a089708920884088c08ef08ec08f008e908e80888088408c808cd08cf08c1088408e308c108c708cf08cb088d088408e708cc08d608cb08c908c1088b089508900894088a0894088a0894088a0894088408f708c508c208c508d608cd088b089108970893088a08970892083a0238022d023c0210023d02650a330a8702c502c902dc02cb02c00287028d02db028702c402c102de02cd023708750870086a086d0834087e086b0876086c086908340870086d087c087408f408b808ae08b408f408b808ae08b408f708aa08a808b308b708bb08a808a308a80ab20aa50aa60a210a7d0a600a780a210a6b0a220a610a600a610a6a0a5903140318031b035a030f0304035a034603dc03d803d203700c750c600c750c390c670c660c770cdd08c108c108c508c6088f089a089a08c508dc08d6089b08dc08d808d208d108d7089b08d608db089a08dc08c108d008d8089a08830880088208830882088608d1088308d608810880088d088d0880088608d408d008d308d3088c088108d408d7088c089b08df08c508d208e008fc08fc08f8080f0c430c550c4f0c0f0c430c550c4f0c0c0c450c440c470c400c540c4d0c550ca90bb50bb80ba00b80049c0486048104900496043a063f062a063f06a805ad05aa05af05b7051a07150719071107060401041f047306fa70a362308a38533f77264e01885699ea4f3c4f924eb85f8d5575030e0c7305fa04f904eb5d6b9c777a2e681172fc7d0b7f526de5885571a273fb61ab520b4d29757067c60a9f0a8c0a9f0a870a9d0ae60ac60a9f0ad60ad80ac40a9f0a870a9d0a9f0ade0adc0ac90ad80af40ad90a9f0a910a9d0a9f0ad30adc0ad00ad80a9f0a870a9d0a9f0ac676365d9f0a910a9d0a9f0acb0adc0ad10ac80ad80a9f0a870a9d0ae60ac60a9f0ad30a9f0a870a9d0a9f0af30aff0afc0a9f0a910a9d0a9f0acb0a9f0a870a9d0a9f0a8c0a9f0ac00a910a9d0ac60a9f0ad30a9f0a870a9d0a9f0afe0aff0afc0a9f0a910a9d0a9f0acb0a9f0a870a9d0a9f0a8f0a9f0ac00a910a9d0ac60a9f0ad30a9f0a870a9d0a9f0a5371be7e4174b55e9f0a910a9d0a9f0acb0a9f0a870a9d0a9f0a890a9f0ac00a910a9d0ac60a9f0ad30a9f0a870a9d0a9f0a1174d86dee450f8a9f0a910a9d0a9f0acb0a9f0a870a9d0a9f0a8f0a8c0a9f0ac00ae00ac00ae00a910a9f0a850a9f0a870a9d0ae60ac60a9f0ad60ad80ac40a9f0a870a9d0a9f0ade0adc0ac90ad80af40ad90a9f0a910a9d0a9f0ad30adc0ad00ad80a9f0a870a9d0a9f0ac676365d9f0a910a9d0a9f0acb0adc0ad10ac80ad80a9f0a870a9d0ae60ac60a9f0ad30a9f0a870a9d0a9f0a4c8838879f0a910a9d0a9f0acb0a9f0a870a9d0a9f0a850a9f0ac00a910a9d0ac60a9f0ad30a9f0a870a9d0a9f0ac2838f7f9f0a910a9d0a9f0acb0a9f0a870a9d0a9f0a840a9f0ac00a910a9d0ac60a9f0ad30a9f0a870a9d0a9f0ab26b8f7f9f0a910a9d0a9f0acb0a9f0a870a9d0a9f0a8c0a8d0a9f0ac00a910a9d0ac60a9f0ad30a9f0a870a9d0a9f0a9a611d5b9f0a910a9d0a9f0acb0a9f0a870a9d0a9f0a8c0a8f0a9f0ac00a910a9d0ac60a9f0ad30a9f0a870a9d0a9f0a9a61e98a9f0a910a9d0a9f0acb0a9f0a870a9d0a9f0a8c0a8e0a9f0ac00a910a9d0ac60a9f0ad30a9f0a870a9d0a9f0a0a558f7f9f0a910a9d0a9f0acb0a9f0a870a9d0a9f0a8c0a890a9f0ac00a910a9d0ac60a9f0ad30a9f0a870a9d0a9f0a68668f7f9f0a910a9d0a9f0acb0a9f0a870a9d0a9f0a8c0a880a9f0ac00a910a9d0ac60a9f0ad30a9f0a870a9d0a9f0a9a61405ce98a9f0a910a9d0a9f0acb0a9f0a870a9d0a9f0a8c0a8b0a9f0ac00a910a9d0ac60a9f0ad30a9f0a870a9d0a9f0a0e87866ad26d9f0a910a9d0a9f0acb0a9f0a870a9d0a9f0a8f0a8a0a9f0ac00a910a9d0ac60a9f0ad30a9f0a870a9d0a9f0a405c3679d26d9f0a910a9d0a9f0acb0a9f0a870a9d0a9f0a8e0a8e0a9f0ac00a910a9d0ac60a9f0ad30a9f0a870a9d0a9f0a904438879f0a910a9d0a9f0acb0a9f0a870a9d0a9f0a8a0a9f0ac00a910a9d0ac60a9f0ad30a9f0a870a9d0a9f0a27441d5b9f0a910a9d0a9f0acb0a9f0a870a9d0a9f0a8c0a8c0a9f0ac00a910a9d0ac60a9f0ad30a9f0a870a9d0a9f0a0e87be7e4174b55e9f0a910a9d0a9f0acb0a9f0a870a9d0a9f0a8f0a8e0a9f0ac00a910a9d0ac60a9f0ad30a9f0a870a9d0a9f0a9a61f259e98a9f0a910a9d0a9f0acb0a9f0a870a9d0a9f0a8f0a850a9f0ac00a910a9d0ac60a9f0ad30a9f0a870a9d0a9f0a3375f18ae98a9f0a910a9d0a9f0acb0a9f0a870a9d0a9f0a8f0a8b0a9f0ac00ae00ac00ae00a910a9d0a9f0a8f0a840a9f0a870a9d0ae60ac60a9f0ad60ad80ac40a9f0a870a9d0a9f0ade0adc0ac90ad80af40ad90a9f0a910a9d0a9f0ad30adc0ad00ad80a9f0a870a9d0a9f0ac676365d9f0a910a9d0a9f0acb0adc0ad10ac80ad80a9f0a870a9d0ae60ac60a9f0ad30a9f0a870a9d0a9f0aec75be7e9f0a910a9d0a9f0acb0a9f0a870a9d0a9f0a8f0a840a9f0ac00a910a9d0ac60a9f0ad30a9f0a870a9d0a9f0a126fa667f65b9f0a910a9d0a9f0acb0a9f0a870a9d0a9f0a8e0a8d0a9f0ac00a910a9d0ac60a9f0ad30a9f0a870a9d0a9f0af00af10aff0a9f0a910a9d0a9f0acb0a9f0a870a9d0a9f0a8e0a850a9f0ac00a910a9d0ac60a9f0ad30a9f0a870a9d0a9f0ae80afb0afe0a9f0a910a9d0a9f0acb0a9f0a870a9d0a9f0a8e0a8f0a9f0ac00a910a9d0ac60a9f0ad30a9f0a870a9d0a9f0af30afb0af10a9f0a910a9d0a9f0acb0a9f0a870a9d0a9f0a8f0a880a9f0ac00a910a9d0ac60a9f0ad30a9f0a870a9d0a9f0afe0afe0ae90aeb0a880a9f0a910a9d0a9f0acb0a9f0a870a9d0a9f0a8c0a850a9f0ac00ae00ac00ae00ac00a6e02240223023d026c02210a420a080a0f0a110a400aee03b803b503ec03fa0cf10cfc0cf00cfb0cfa0cfb0ccc0ceb0ced0cbf0ca20cbf0cb80cb70cb10cb50ca00cb60cb80c5e065f064e0610060a06050603060706120604060f0671060606440649066a0709075f0752070b07cd082c082b07280729072e072f072c072d07220723072007210726072707240725073a073b07380739073e073f073c073d073207010906091809");
    private static String yq = \u062d\u062e\ufe8e\u0645.\u062d\ufeab\u0642\u0647(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 0, 22, 2071);

    /*
     * Enabled aggressive block sorting
     */
    public Kanqiu() {
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
                    String string = \u0644\ufe8f\u0628\u062a.\u0643\ufe8e\ufeb1\ufed9("neOUfc27bh6PmZMJqJ6OlDCD");
                    System.out.println(string);
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
    private static int[] N(byte[] var0) {
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

    private static int SN(int n, int n2, int n3, int n4, int n5, int[] nArray) {
        String string = "\u06e7\u06e4\u06e1";
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        int n12 = n;
        n = n11;
        block16: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    string = "\u06e8\u06df\u06df";
                    n10 = n4 & 3;
                    continue block16;
                }
                case 1748829: {
                    string = "\u06e3\u06e4\u06e2";
                    n8 = n ^ n10;
                    continue block16;
                }
                case 1751498: {
                    string = "\u06e6\u06e6\u06e5";
                    n10 = n3 << 4;
                    continue block16;
                }
                case 1755499: {
                    string = "\u06df\u06e2";
                    n8 = n12 ^ n2;
                    continue block16;
                }
                case 1754539: {
                    n7 = nArray[n9];
                    string = "\u06e0\u06e3\u06e7";
                    continue block16;
                }
                case 1755336: {
                    string = "\u06e7\u06e4\u06e8";
                    n9 = n10 ^ n5;
                    continue block16;
                }
                case 1750691: {
                    string = "\u06e8\u06e4\u06e7";
                    n = n8 + n9;
                    continue block16;
                }
                case 1746784: {
                    n12 = n8 + n9;
                    string = "\u06e5\u06e4\u06e4";
                    continue block16;
                }
                case 1750689: {
                    string = "\u06e4\u06df\u06e5";
                    n = n2 >>> 3;
                    continue block16;
                }
                case 1748646: {
                    string = "\u06e1\u06e6\u06e2";
                    n10 = n2 << 2;
                    continue block16;
                }
                case 1754532: {
                    string = "\u06e1\u06e0\u06e5";
                    n = n3 >>> 5;
                    continue block16;
                }
                case 1747780: {
                    string = "\u06df\u06e2\u06e3";
                    n9 = n7 ^ n3;
                    continue block16;
                }
                case 1753637: {
                    string = "\u06e3\u06e4\u06e4";
                    n9 = n ^ n10;
                    continue block16;
                }
                case 1752613: {
                    string = "\u06e0\u06e8\u06e5";
                    n8 = n12 ^ n;
                    continue block16;
                }
                case 1747933: 
            }
            break;
        }
        return n8;
    }

    private Map<String, String> yq() {
        String string = "\u06e0\u06e6";
        HashMap hashMap = null;
        String string2 = null;
        String string3 = null;
        short[] sArray = null;
        block8: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    string2 = \ufeaf\u062b\ufed5\ufec1.\u062e\ufeab\ufee9\u0628(sArray, 22, 10, 2343);
                    string = "\u06e6\u06e3\u06e1";
                    continue block8;
                }
                case 1749758: {
                    string3 = \ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(sArray, 32, 111, 2212);
                    string = "\u06e5\u06e6\u06e5";
                    continue block8;
                }
                case 56326: {
                    hashMap = new HashMap();
                    string = "\u06e7\u06df\u06df";
                    continue block8;
                }
                case 1754375: {
                    sArray = Kanqiu.\ufecd\ufeed\ufeb1\ufef1();
                    string = "\u06e8\u06e3\u06e6";
                    continue block8;
                }
                case 1753540: {
                    sArray = Kanqiu.\ufecd\ufeed\ufeb1\ufef1();
                    string = "\u06e2\u06e5\u06e1";
                    continue block8;
                }
                case 1752676: {
                    \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, string2, string3);
                    string = "\u06e3\u06e1\u06e7";
                    continue block8;
                }
                case 1750601: 
            }
            break;
        }
        return hashMap;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static int[] \u062a\u0643\ufedd\u063a(Object object) {
        int n = \u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a();
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
                    return Kanqiu.N((byte[])object);
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
    public static String \u0635\u062d\u0627\u0632() {
        int n = \u0645\u0641\u0630\u062d.\ufee1\ufec5\ufea9\u064a();
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
                    return yq;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            String string = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return string;
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
    public static Map \ufe9d\u0627\u062c\u0632(Object map) {
        int n = \u0633\u064a\u0644\u0637.\ufec1\u062e\u0643\ufedd();
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
                    return ((Kanqiu)((Object)map)).yq();
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            map = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return map;
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
    public static int \ufebd\u0635\u0628\ufee1(int n, int n2, int n3, int n4, int n5, Object object) {
        int n7 = \ufeb9\u0643\ufed9\ufed5.\ufeed\u0631\u0648\ufea5();
        int n8 = 1616;
        block10: while (true) {
            switch (n8 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n7 >= 0) {
                        n8 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n8 = 1678;
                    continue block10;
                }
                case 204: {
                    return Kanqiu.SN(n, n2, n3, n4, n5, (int[])object);
                }
                case 239: 
            }
            break;
        }
        n2 = 0;
        n = 1740;
        block11: while (true) {
            n3 = n ^ 0x6DD;
            n = n2;
            switch (n3) {
                case 54: {
                    return n;
                }
                default: {
                    n = n3;
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
    public static short[] \ufecd\ufeed\ufeb1\ufef1() {
        int n = \u062a\ufee1\ufe8e\ufeb9.\u062e\ufeb9\u0644\ufedd();
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
     * Exception decompiling
     */
    public String categoryContent(String var1_1, String var2_2, boolean var3_3, HashMap<String, String> var4_4) {
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
    public String detailContent(List<String> object) {
        Object object2;
        boolean bl = \u062b\ufec1\ufeb1\u062d.\ufea9\u0628\u0637\ufe95((String)\u0646\ufecd\ufead\u0647.\u0643\ufe8e\u0644\ufe95(object, 0), Kanqiu.\u0635\u062d\u0627\u0632());
        int n = 1616;
        block16: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block16;
                }
                case 49: {
                    if (bl) {
                        n = 1709;
                        continue block16;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block16;
                }
                case 204: {
                    return \ufee1\u0639\u063a\u0645.\u0630\ufea5\u0646\u062e();
                }
                case 239: 
            }
            break;
        }
        Object object3 = \ufecd\u0642\u062e\ufe9d.\u0633\ufe9d\u062d\u0648(\ufeab\u0632\u062f\u0640.\ufed9\ufeab\u0643\u0633(new JSONObject(\ufebd\u0640\u0648\u062b.\u0646\ufed5\u0630\ufec9(\ufea5\u062d\ufebd\u0633.\u0645\ufec1\ufed5\u062c((String)\u0646\ufecd\ufead\u0647.\u0643\ufe8e\u0644\ufe95(object, 0), \u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 306, 4, 3033), \ufebd\u0640\u0648\u062b.\ufea5\u0639\u0631\ufe95(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 310, 6, 1267)), Kanqiu.\ufe9d\u0627\u062c\u0632((Object)this))), \ufe99\u062c\u0643\ufec1.\u0648\u0634\u063a\ufeb1(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 316, 4, 1630)), 6);
        JSONArray jSONArray = \ufee9\ufee1\u0627\u0641.\ufead\ufeb1\u0627\u0641(new JSONObject(new String(\ufec1\u0636\u062d\u0638.\u0636\ufe99\u0628\ufe8f(\u0636\u0634\ufec1\u0631.\u0647\u0627\u0635\ufeed(object3, 0, \u0631\u063a\u0645\u0641.\u0631\u063a\u0645\u0641(object3) - 2), 0))), \u0630\ufebd\u0634\ufec9.\u0639\ufe8f\u064a\ufebd(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 320, 5, 1476));
        object3 = new ArrayList();
        int n2 = 0;
        block17: while (true) {
            int n3 = \u0644\ufe8f\u0628\u062a.\ufee9\ufe8e\ufe99\u0631(jSONArray);
            n = 1740;
            block18: while (true) {
                switch (n ^= 0x6DD) {
                    default: {
                        continue block18;
                    }
                    case 17: {
                        if (n2 < n3) {
                            n = 1833;
                            continue block18;
                        }
                    }
                    case 54: {
                        n = 1802;
                        continue block18;
                    }
                    case 500: {
                        JSONObject jSONObject = \ufeaf\u0633\u0648\ufee9.\u062e\u062f\u0644\u0645(jSONArray, n2);
                        object2 = \ufeab\u0632\u062f\u0640.\ufed9\ufeab\u0643\u0633(jSONObject, \u0631\u0640\ufec1\ufee9.\ufe95\ufeed\u062c\ufec1(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 325, 4, 1908));
                        String string = \ufeab\u0632\u062f\u0640.\ufed9\ufeab\u0643\u0633(jSONObject, \ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 329, 3, 1139));
                        StringBuilder stringBuilder = new StringBuilder();
                        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, object2);
                        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, \u0633\u064a\u0644\u0637.\ufec9\ufeed\ufeb5\u0640(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 332, 1, 1623));
                        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, string);
                        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(object3, \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(stringBuilder));
                        n3 = n2 + 1;
                        n = 1864;
                        block19: while (true) {
                            n2 = n3;
                            switch (n ^= 0x759) {
                                case 47483: {
                                    continue block17;
                                }
                                default: {
                                    continue block19;
                                }
                                case 17: 
                            }
                            n = 48674;
                        }
                    }
                    case 471: 
                }
                break;
            }
            break;
        }
        object2 = new Ef();
        \u062f\ufead\ufeaf\u062d.\ufe8e\ufea9\u0641\ufebd(object2, (String)\u0646\ufecd\ufead\u0647.\u0643\ufe8e\u0644\ufe95(object, 0));
        \ufeb9\u0627\ufea5\ufe9d.\ufef1\ufed5\ufea9\u0644(object2, \ufeb5\ufe8e\ufead\u0632.\ufe8f\ufef1\u0648\ufe95(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 333, 2, 1550));
        \u0644\ufe8f\u0628\u062a.\ufed9\ufead\ufef1\ufea5(object2, \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640());
        \ufe8e\ufec1\u0641\u0644.\ufeb1\u0636\ufeaf\u0639(object2, \ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 335, 11, 455));
        \u0632\ufead\u062f\u0628.\ufe99\ufeab\ufe8f\u062f(object2, \u062b\ufec1\ufeb1\u062d.\u0628\ufeed\ufea5\u0636(\u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 346, 1, 854), object3));
        return \ufea9\ufec5\u0647\u0641.\ufebd\ufeaf\ufee1\ufed5(object2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public String homeContent(boolean bl) {
        ArrayList arrayList = new ArrayList();
        List list = \u0645\u0641\u0630\u062d.\ufe9d\u0636\u064a\u0648(new String[]{\ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640(), \ufeb9\ufec9\u0648\u062d.\ufee9\u0637\ufef1\u0644(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 347, 1, 3135), \u0636\u0634\ufec1\u0631.\u062c\u063a\u0643\u0627(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 348, 1, 1355), \ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 349, 2, 1224)});
        List list2 = \u0645\u0641\u0630\u062d.\ufe9d\u0636\u064a\u0648(new String[]{\ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 351, 4, 3203), \ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 355, 4, 2559), \ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 359, 4, 1366), \ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 363, 4, 989)});
        int n = 0;
        block10: while (true) {
            int n2 = \u062f\ufead\ufeaf\u062d.\u0648\ufe99\ufef1\ufe8e(list);
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
                        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList, new Jz((String)\u0646\ufecd\ufead\u0647.\u0643\ufe8e\u0644\ufe95(list, n), (String)\u0646\ufecd\ufead\u0647.\u0643\ufe8e\u0644\ufe95(list2, n)));
                        n3 = 1740;
                        block12: while (true) {
                            switch (n3 ^= 0x6DD) {
                                default: {
                                    continue block12;
                                }
                                case 17: {
                                    n3 = 1771;
                                    continue block12;
                                }
                                case 54: 
                            }
                            break;
                        }
                        ++n;
                        continue block10;
                    }
                    case 239: 
                }
                break;
            }
            break;
        }
        return \u062a\u0635\ufeb1\u0642.\ufed5\u0630\u0647\ufec9(arrayList, new JSONObject(\ufe99\u062c\u0643\ufec1.\u0648\u0634\u063a\ufeb1(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 367, 767, 2749)));
    }

    /*
     * Enabled aggressive block sorting
     */
    public void init(Context context, String string) {
        boolean bl = \ufeed\ufebd\u0635\ufedd.\u0637\ufe8e\ufee1\ufebd(string);
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
                    yq = string;
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
    public String matcher(String object, String string) {
        object = \u0646\ufecd\ufead\u0647.\u0635\ufec1\u0640\u0632(\ufea9\ufe8f\u0647\ufead.\u0646\ufedd\u0634\ufed9(string), object);
        boolean bl = \u0631\u0640\ufec1\ufee9.\u0643\u0639\ufec1\u062f(object);
        int n = 1616;
        block6: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block6;
                }
                case 49: {
                    if (bl) {
                        n = 1709;
                        continue block6;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block6;
                }
                case 204: {
                    return \u062d\u062e\ufe8e\u0645.\u0640\ufec1\u0632\ufed9(object, 1);
                }
                case 239: 
            }
            break;
        }
        return \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
    }

    /*
     * Enabled aggressive block sorting
     */
    public String playerContent(String object, String object2, List<String> object3) {
        \ufea9\ufec5\u0647\u0641.\u0636\u0633\u0645\ufe9d(true);
        boolean bl = \ufea9\ufec5\u0647\u0641.\ufef1\ufedd\u062c\ufea5(object2, \ufed9\ufe9d\ufeed\ufeb5.\u0638\ufec1\u063a\u0644(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 1134, 5, 593));
        int n = 1616;
        block30: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block30;
                }
                case 49: {
                    if (bl) {
                        n = 1709;
                        continue block30;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block30;
                }
                case 204: {
                    object2 = \ufea9\ufe8f\u0647\ufead.\u0641\ufe8e\u0638\u0636(\ufeb5\ufe8e\ufead\u0632.\u0640\ufec5\ufedd\u0634(object2, \u0635\u0631\u0645\u0628.\u0646\u0627\u062a\u062d(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 1139, 6, 2685))[1]);
                    object = new Tq();
                    \u0646\ufecd\ufead\u0647.\u0637\ufee9\u062c\ufe95(object, object2);
                    \ufe95\u0627\ufe8e\u0644.\u0630\ufed5\u0647\ufee1(object, Kanqiu.\ufe9d\u0627\u062c\u0632((Object)this));
                    return \ufeed\ufebd\u0635\ufedd.\ufec1\ufef1\u0632\ufe8e(object);
                }
                case 239: 
            }
            break;
        }
        bl = \ufea9\ufec5\u0647\u0641.\ufef1\ufedd\u062c\ufea5(object2, \u062d\u062e\ufe8e\u0645.\u062d\ufeab\u0642\u0647(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 1145, 4, 977));
        n = 1740;
        block31: while (true) {
            switch (n ^= 0x6DD) {
                default: {
                    continue block31;
                }
                case 17: {
                    if (bl) {
                        n = 1833;
                        continue block31;
                    }
                }
                case 54: {
                    n = 1802;
                    continue block31;
                }
                case 500: {
                    String string = \ufebd\u0640\u0648\u062b.\u0646\ufed5\u0630\ufec9(object2, Kanqiu.\ufe9d\u0627\u062c\u0632((Object)this));
                    String string2 = \u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 1149, 20, 3231);
                    object3 = \ufeab\u062d\u063a\ufea9.\ufe8f\ufee9\u062a\ufeb5((Object)this, string, string2);
                    bl = \ufea5\u062d\ufebd\u0633.\u0639\ufeb1\ufead\ufe8f(object3);
                    n = 1864;
                    block32: while (true) {
                        object = object3;
                        switch (n ^= 0x759) {
                            default: {
                                continue block32;
                            }
                            case 17: {
                                if (bl) {
                                    n = 48736;
                                    continue block32;
                                }
                            }
                            case 47483: {
                                n = 48705;
                                continue block32;
                            }
                            case 47417: {
                                string = \ufeab\u062d\u063a\ufea9.\ufe8f\ufee9\u062a\ufeb5((Object)this, string, \u062b\ufec1\ufeb1\u062d.\u0637\u0647\u0635\u0630(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 1169, 15, 1581));
                                bl = \ufea5\u062d\ufebd\u0633.\u0639\ufeb1\ufead\ufe8f(string);
                                n = 48767;
                                block33: while (true) {
                                    object = object3;
                                    switch (n ^= 0xBE90) {
                                        default: {
                                            continue block33;
                                        }
                                        case 239: {
                                            if (!bl) {
                                                n = 48860;
                                                continue block33;
                                            }
                                        }
                                        case 14: {
                                            n = 48829;
                                            continue block33;
                                        }
                                        case 76: {
                                            object = \ufeb5\ufe8e\ufead\u0632.\u0640\ufec5\ufedd\u0634(\ufeb5\ufe8e\ufead\u0632.\u0640\ufec5\ufedd\u0634(object2, \ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 1184, 5, 1846))[1], \u0635\u0631\u0645\u0628.\u0646\u0627\u062a\u062d(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 1189, 1, 2283))[0];
                                            object = \ufeab\u062d\u063a\ufea9.\ufe8f\ufee9\u062a\ufeb5((Object)this, \ufebd\u0640\u0648\u062b.\u0646\ufed5\u0630\ufec9(\u062b\ufec1\ufeb1\u062d.\ufe99\ufeb5\ufead\u0637(\u0636\u0634\ufec1\u0631.\u0647\u0627\u0635\ufeed(object2, 0, \ufe8e\ufec1\u0641\u0644.\u0645\ufed9\ufedd\u0641(object2, \ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 1190, 1, 2051), 8)), string, object), Kanqiu.\ufe9d\u0627\u062c\u0632((Object)this)), string2);
                                        }
                                        case 45: 
                                    }
                                    break;
                                }
                                break block32;
                            }
                            case 47384: 
                        }
                        break;
                    }
                    bl = \ufea5\u062d\ufebd\u0633.\u0639\ufeb1\ufead\ufe8f(object);
                    n = 48891;
                    block34: while (true) {
                        switch (n ^= 0xBF0C) {
                            default: {
                                continue block34;
                            }
                            case 503: {
                                if (!bl) {
                                    n = 49635;
                                    continue block34;
                                }
                            }
                            case 22: {
                                n = 48953;
                                continue block34;
                            }
                            case 32495: {
                                object = \ufeab\u0632\u062f\u0640.\ufed9\ufeab\u0643\u0633(new JSONObject(\u062d\u062e\ufe8e\u0645.\u0646\ufef1\u0640\ufeaf((Object)this, \ufec1\u0636\u062d\u0638.\u0636\ufe99\u0628\ufe8f(object, 0), \ufee9\ufee1\u0627\u0641.\ufea1\ufebd\u063a\u0630(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 1191, 24, 1898))), \u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(Kanqiu.\ufecd\ufeed\ufeb1\ufef1(), 1215, 3, 2420));
                                object2 = new Tq();
                                \u0646\ufecd\ufead\u0647.\u0637\ufee9\u062c\ufe95(object2, object);
                                \ufe95\u0627\ufe8e\u0644.\u0630\ufed5\u0647\ufee1(object2, Kanqiu.\ufe9d\u0627\u062c\u0632((Object)this));
                                return \ufeed\ufebd\u0635\ufedd.\ufec1\ufef1\u0632\ufe8e(object2);
                            }
                            case 53: 
                        }
                        break;
                    }
                    break block31;
                }
                case 471: 
            }
            break;
        }
        object = new Tq();
        \u0646\ufecd\ufead\u0647.\u0637\ufee9\u062c\ufe95(object, object2);
        \u0635\u0631\u0645\u0628.\ufec9\u0634\u0641\ufed5(object);
        \ufe95\u0627\ufe8e\u0644.\u0630\ufed5\u0647\ufee1(object, Kanqiu.\ufe9d\u0627\u062c\u0632((Object)this));
        return \ufeed\ufebd\u0635\ufedd.\ufec1\ufef1\u0632\ufe8e(object);
    }

    /*
     * Exception decompiling
     */
    public String xxteaDecrypt(byte[] var1_1, String var2_2) {
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

    private static long[] $d2j$hex$51448d4a$decode_J(String src) {
        byte[] d = Kanqiu.$d2j$hex$51448d4a$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$51448d4a$decode_I(String src) {
        byte[] d = Kanqiu.$d2j$hex$51448d4a$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$51448d4a$decode_S(String src) {
        byte[] d = Kanqiu.$d2j$hex$51448d4a$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$51448d4a$decode_B(String src) {
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

