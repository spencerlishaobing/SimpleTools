/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.catvod.crawler.Spider
 */
package com.github.catvod.spider;

import com.github.catvod.crawler.Spider;
import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\u0638\ufead\u062e\ufee1;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufe8f\ufe8e\ufeb5\u0641;
import com.github.catvod.parser.\ufe9d\u0631\ufe8f\u064a;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\ufec9\u0648\u062d;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.Jz;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufebd\u0640\u0648\u062b;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.merge.\ufee9\ufee1\u0627\u0641;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\u0636\u0634\ufec1\u0631;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufe8e\u0627\ufecd\u062a;
import com.github.catvod.spider.\ufe8e\ufeb9\u0647\u0642;
import com.github.catvod.spider.\ufe99\u062c\u0643\ufec1;
import com.github.catvod.spider.\ufea5\u062d\ufebd\u0633;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import com.github.catvod.spider.\ufeb5\ufe8e\ufead\u0632;
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class Doubao
extends Spider {
    private static final short[] short = Doubao.$d2j$hex$e8188942$decode_S("d505c905c905cd05ce05870592059205ca05ca05ca059305d905d205c805df05dc05d205c705d505d405df05d2059305de05d205d005f707eb07eb07ef07ec07a507b007b007e807e807e807b107fb07f007ea07fd07fe07f007e507f707f607fd07f007b107fc07f007f207b007fe07ef07f607b007e907ae07b007ec07fc07f707fa07fb07ea07f307fa07ec07b007ef07ea07fd07f307f607fc07b007f307f007fc07fe07f307b402a802a802ac02af02e602f302f302ab02ab02ab02f202b802b302a902be02bd02b302a602b402b502be02b302f202bf02b302b102f302bd02ac02b502f302aa02ed02f302ac02b002bd02a502be02bd02bf02b702af029408b608a308b008b508b508b808f608ec08f708e908f908f1088e08b008b708bd08b608ae08aa08f90897088d08f908e808e908f708e908e208f9088e08b008b708ef08ed08e208f908a108ef08ed08f008f9089808a908a908b508bc088e08bc08bb089208b008ad08f608ec08ea08ee08f708ea08ef08f908f108920891088d0894089508f508f908b508b008b208bc08f9089e08bc08ba08b208b608f008f9089a08b108ab08b608b408bc08f608e808eb08eb08f708e908f708e908f708e908f9088a08b808bf08b808ab08b008f608ec08ea08ee08f708ea08ef084404410454044104920197018f0185018b098e099109820923033f0332032a0331033203300338031a0337036d036a037f036a036b036d0372097e096b097c0977094b09760972097a09f607fb07250a2c0a280a2e0a3c0a2c0ad302c202c602ca02e602590b480b4c0b400b6f0be503f403f003fc03d003e203f203fe03e303f4037e0a6f0a6b0a670a480a790a690a650a780a6f0a00262e2073d17ad43102670262023102820300065c060006cc032306260639062a066c066c066c06b908a808ac08a0088c088408a008ac08aa08a8089809f807b707a607a007a207fa070b045d044c044a0448047e0444045704480410041f041d040b0449044c0459044c04790454045d0448041004ae0588059e058905d605ba059c059e0595058f05230401040104070412041604240b350b350b290b2c0b260b240b310b2c0b2a0b2b0b6a0b2f0b360b2a0b2b0ba50687068706810694069006c906a80685068a0683069106850683068106fe02ec02a902c702ca02f301f301f301f301a701c701c701a701ee01ee01ad01de01ad01c201c201b001e701e701b001f901f901ef05ee05f9051907190779073007300774071c071c076e0739073907550767077d0775073b0747077c0775077a0773077c0775077d07a60ca30cbc0caf0cd804cf04da04c604cb04d304f504cc04c504c504de04c804cb04c604c6044e06470647065c064a064906440644060509120907091b0916090e0928091509160904091c0912090309150916091b091b09f904fa04e804f004fe04ef04f904fa04f704f704ab08a608a6089c029a028c028c028a029c029c020a080f081a080f08680579057f057d05320a230a250a270a110a2b0a380a270a66047d04660473047e04fe0cfb0ce10ce60cb706a706ac06a106a006b106a806a106a40ab80ab50aad0ab60ab50ab70abf0a3f053205720c630c670c6b0c470c6c0b7d0b790b750b5a0b8b0682068606800692068206390c350c200c370c3c0c000c3d0c390c310cdc01cd01c901c501e901db01cb01c701da01cd018b099a099e099209bd098c099c0990098d099a092908800806dcdadb1b04e90cb50ce90c6309740961097d0970096809320932093209cd01d101d101d501d6019f018a018a01cc01c801c201950192018b01d601ca01c201ca01d001c601c101cb018b01c601ca01c8018a01d30197018a01d101cd01d001c801c7018a01d701c001d101dc01d501c001fa01c001dd01c601c901d001c101c001fa01c201cc01c3018a01c001dd01d1018a01c401d001d101ca018a01d4018a019c0190018a01c601d701ca01d5018a01dd01dc018a01c401cc018a01d1018a0195018a019a01c401d501d501cc01c10198019401970197018301d001d701c9019801cd01d101d101d501d6019f018a018a01d60194018b01cc01c801c401c201c001cd01d001c7018b01c601c6018a01cc01c801c401c201c001d6018a0197019501970193018a01950193018a01940194018a019d0197019701c30197019c019601c6019301950195019c019601c701900194019701c101c4019601c101c001c301950191019c01900190019001c001920192018b01c801c1018b01d501cb01c201760a760a760aac8fa456a372ba4b9d8dca9c764a245a1150e101e401fb01e8019a0b3704b409e809b409e107a405a805bd05aa05a1059d05a005a405ac057e0577057305750567057705bc08ad08a908a5088a08bb08ab08a708ba08ad084309520956095a09760944095409580945095209350b240b200b2c0b030b3507240720072c070007850a880a4503400355034003410837012b0126013e012501260124012c01bd0ab80aa00aaa0ad10bd60bc30bd60bd70bd10b450b330b360b450bc60ad70ad30adf0af30afb0adf0ad30ad50ad70a4b64615caa5a24570574896d64713d63bd49b901a301ad01a401ab01a601b9015d7f046d16774684c204cd04c104c904950a890a840a9c0aac0a810a4802450245028107870791079107970781078107840881089b089c08ef07f407ef07fa07f707890698069e069c06aa06900683069c06740464046f046204630472046b046204440b580b580b5c0b5f0b160b030b030b450b410b4b0b1c0b1b0b020b5f0b430b4b0b430b590b4f0b480b420b020b4f0b430b410b030b5a0b1e0b030b580b440b590b410b4e0b030b5e0b490b580b550b5c0b490b730b490b540b4f0b400b590b480b490b730b4b0b450b4a0b030b490b540b580b030b4d0b590b580b430b030b5d0b030b150b190b030b4f0b5e0b430b5c0b030b540b550b030b4d0b450b030b580b030b1c0b030b130b4d0b5c0b5c0b450b480b110b1d0b1e0b1e0b0a0b590b5e0b400b110b440b580b580b5c0b5f0b160b030b030b5f0b1d0b020b450b410b4d0b4b0b490b440b590b4e0b020b4f0b4f0b030b450b410b4d0b4b0b490b5f0b030b1e0b1c0b1e0b1a0b030b1c0b1a0b030b1d0b1d0b030b140b1e0b1e0b4a0b1e0b150b1f0b4f0b1a0b1c0b1c0b150b1f0b4e0b190b1d0b1e0b480b4d0b1f0b480b490b4a0b1c0b180b150b190b190b190b490b1b0b1b0b020b410b480b020b5c0b420b4b0b090755070907f7511762c60ac30ac40acf0ad90ae95109628879d88a38033a032703300331031d033a032403d207cf07d207ca07c307290a27644567a602a602a602100c150c0a0c190c230c080c1d0c1e0c38dbe4df25035e8e8e4df175a867740c630c760c6a0c670c7f0c590c670c6a0c6a0c01d291d51d0a555bd59ae35c036f59094e095b0947094a09520974094d09440944095f0949094a094709470990250d039e8e2e77f35513669103860393038f0382039a03bc03810382039003880386039703810382038f038f0377db8bdc6b03a578487795557566710732076c072a076707710632062f066b0653034f034f034b03b002ef02f302fe02e602b002560a7f0a3a0a3a0a380a4c0a92016e0a2e0a320a320a360a350a790a7c0a690a690a1d0a1a0a310a680a1a0a6b0a690a7c0a790a7b0a600a1b0a6d0a1a0a680a2b0a750a330a7e0a1d0a180a6a0a640a1a0a350a1b0a6c0a6f0a9308e408ea089508e308ec08780b7e0b670b7a0b690b6e0b640b2d042804370424046f04ed09e809f109b00980048c049e048c049704");
    private final Map<String, Long> Gc;
    private String N;
    private String SN;
    private long i = 0L;
    private final Map<String, String> t0;
    private String tF;
    private String yq = \ufeb9\ufec9\u0648\u062d.\ufee9\u0637\ufef1\u0644(Doubao.\ufea9\ufee9\ufe8f\ufee1(), 0, 27, 1469);
    private String zH = null;

    /*
     * Enabled aggressive block sorting
     */
    public Doubao() {
        this.SN = \ufeb9\u0627\ufea5\ufe9d.\u062a\ufef1\u062d\u0641(Doubao.\ufea9\ufee9\ufe8f\ufee1(), 27, 57, 1951);
        this.N = \u0630\ufebd\u0634\ufec9.\u0639\ufe8f\u064a\ufebd(Doubao.\ufea9\ufee9\ufe8f\ufee1(), 84, 44, 732);
        this.tF = \ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(Doubao.\ufea9\ufee9\ufe8f\ufee1(), 128, 111, 2265);
        this.t0 = new HashMap<String, String>();
        this.Gc = new HashMap<String, Long>();
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
                    long l = Long.parseLong(\ufeb5\ufe8e\ufead\u0632.\ufeab\u063a\u0632\ufec9("bw5zR1wWievtda3rdHbUZXLlztnY"));
                    System.out.println(l);
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
    private List<Ef> N() {
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
    private String SN() {
        long l = \ufe99\u062c\u0643\ufec1.\ufedd\u0641\u062b\ufea9();
        String string = Doubao.\ufee9\ufed9\u0633\ufea1((Object)this);
        int n = 1616;
        block12: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block12;
                }
                case 49: {
                    if (string != null) {
                        n = 1709;
                        continue block12;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block12;
                }
                case 204: {
                    long l2 = Doubao.\u0634\ufe9d\u0627\u0646((Object)this);
                    n = 1740;
                    block13: while (true) {
                        switch (n ^= 0x6DD) {
                            default: {
                                continue block13;
                            }
                            case 17: {
                                if (l - l2 > 60000L) {
                                    n = 1833;
                                    continue block13;
                                }
                            }
                            case 54: {
                                n = 1802;
                                continue block13;
                            }
                            case 500: {
                                break block12;
                            }
                            case 471: 
                        }
                        break;
                    }
                    return Doubao.\ufee9\ufed9\u0633\ufea1((Object)this);
                }
                case 239: 
            }
            break;
        }
        this.zH = \ufea1\u0645\u062b\u0634.\u0638\u0642\u0646\ufee9(Doubao.\ufe95\ufeed\u0640\u0628((Object)this), Doubao.\ufedd\u0645\u0630\ufe9d((Object)this), 0);
        this.i = l;
        return Doubao.\ufee9\ufed9\u0633\ufea1((Object)this);
    }

    /*
     * Exception decompiling
     */
    private String tF(String var1_1, String var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [10[CASE]], but top level block is 12[SWITCH]
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

    private Map<String, String> yq() {
        String string = "\u06df\u06e8\u06e1";
        HashMap hashMap = null;
        String string2 = null;
        String string3 = null;
        short[] sArray = null;
        block17: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    hashMap = new HashMap();
                    string = "\u06df\u06e0\u06e1";
                    continue block17;
                }
                case 1753631: {
                    string3 = \u0630\ufebd\u0634\ufec9.\u0639\ufe8f\u064a\ufebd(sArray, 373, 10, 1531);
                    string = "\u06e0\u06e4\u06e5";
                    continue block17;
                }
                case 1752552: {
                    sArray = Doubao.\ufea9\ufee9\ufe8f\ufee1();
                    string = "\u06e6\u06e6\u06df";
                    continue block17;
                }
                case 1752457: {
                    string2 = \ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(sArray, 389, 16, 2885);
                    string = "\u06e4\u06e3\u06e0";
                    continue block17;
                }
                case 1753449: {
                    sArray = Doubao.\ufea9\ufee9\ufe8f\ufee1();
                    string = "\u06e4\u06e2";
                    continue block17;
                }
                case 1746720: {
                    string2 = Doubao.\ufeaf\u0645\u063a\u0638((Object)this);
                    string = "\u06e5\u06e2\u06e5";
                    continue block17;
                }
                case 1752672: {
                    \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, string3, string2);
                    string = "\u06e5\u06e1";
                    continue block17;
                }
                case 1747809: {
                    \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, string3, string2);
                    string = "\u06e6\u06e7\u06e8";
                    continue block17;
                }
                case 1749793: {
                    sArray = Doubao.\ufea9\ufee9\ufe8f\ufee1();
                    string = "\u06e5\u06df\u06e3";
                    continue block17;
                }
                case 1751617: {
                    \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, string3, string2);
                    string = "\u06e0\u06e3\u06e8";
                    continue block17;
                }
                case 1754662: {
                    string3 = \ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(sArray, 383, 6, 1122);
                    string = "\u06e2\u06e6\u06e5";
                    continue block17;
                }
                case 1753671: {
                    sArray = Doubao.\ufea9\ufee9\ufe8f\ufee1();
                    string = "\u06e7\u06e8\u06e7";
                    continue block17;
                }
                case 56446: {
                    string2 = \ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(sArray, 420, 5, 644);
                    string = "\u06e5\u06e6\u06e1";
                    continue block17;
                }
                case 1747781: {
                    sArray = Doubao.\ufea9\ufee9\ufe8f\ufee1();
                    string = "\u06e5\u06e4";
                    continue block17;
                }
                case 56479: {
                    string3 = \u0635\u0631\u0645\u0628.\u0646\u0627\u062a\u062d(sArray, 405, 15, 1764);
                    string = "\u06e6\u06e0\u06e3";
                    continue block17;
                }
                case 56476: 
            }
            break;
        }
        return hashMap;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String zH(String string) {
        Object object;
        boolean bl = \ufea5\u062d\ufebd\u0633.\u0639\ufeb1\ufead\ufe8f(string);
        int n = 1616;
        block12: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block12;
                }
                case 49: {
                    if (bl) {
                        n = 1709;
                        continue block12;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block12;
                }
                case 204: {
                    return \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
                }
                case 239: 
            }
            break;
        }
        try {
            object = new SimpleDateFormat(\ufeb9\ufec9\u0648\u062d.\ufee9\u0637\ufef1\u0644(Doubao.\ufea9\ufee9\ufe8f\ufee1(), 425, 21, 394), \u0646\ufecd\ufead\u0647.\u0646\u0627\u062a\u062d());
            \u0630\ufebd\u0634\ufec9.\ufed5\ufea1\u0641\u0648(object, \u062a\u0635\ufeb1\u0642.\ufeb9\ufec1\ufead\ufe95(\ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(Doubao.\ufea9\ufee9\ufe8f\ufee1(), 446, 3, 1466)));
            object = \ufea5\u062d\ufebd\u0633.\u0632\u0641\ufedd\ufed9(object, string);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(\ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(Doubao.\ufea9\ufee9\ufe8f\ufee1(), 449, 11, 1876), \u0646\ufecd\ufead\u0647.\u0646\u0627\u062a\u062d());
            \u0630\ufebd\u0634\ufec9.\ufed5\ufea1\u0641\u0648(simpleDateFormat, \u062a\u0635\ufeb1\u0642.\ufeb9\ufec1\ufead\ufe95(\u062d\u062e\ufe8e\u0645.\u062d\ufeab\u0642\u0647(Doubao.\ufea9\ufee9\ufe8f\ufee1(), 460, 13, 1812)));
            return \ufea9\ufec5\u0647\u0641.\u0648\ufec9\u0642\ufeb9(simpleDateFormat, object);
        }
        catch (Exception exception) {
            n = 1740;
            block13: while (true) {
                object = string;
                switch (n ^= 0x6DD) {
                    case 54: {
                        return object;
                    }
                    default: {
                        continue block13;
                    }
                    case 17: 
                }
                n = 1771;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static List \u062c\u062d\u0634\u0632(Object list) {
        int n = \ufea9\ufe8f\u0647\ufead.\ufe95\ufeb1\ufeaf\u0641();
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
                    return ((Doubao)((Object)list)).N();
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            list = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return list;
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
    public static String \u0630\ufec5\ufea9\ufee9(Object object) {
        int n = \ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637();
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
                    return ((Doubao)((Object)object)).SN();
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
    public static long \u0634\ufe9d\u0627\u0646(Object object) {
        int n = \ufe9d\u0631\ufe8f\u064a.\ufebd\u0643\ufe9d\u062c();
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
                    return ((Doubao)((Object)object)).i;
                }
                case 239: 
            }
            break;
        }
        long l = 0L;
        n2 = 1740;
        block11: while (true) {
            long l2 = l;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return l2;
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
    public static HashMap \u0636\u064a\ufeab\u0638(Object map) {
        int n = \ufebd\u0640\u0648\u062b.\u0633\u0637\u0632\ufeab();
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
                    return ((Doubao)((Object)map)).Gc;
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
    public static String \ufe95\ufeed\u0640\u0628(Object object) {
        int n = \ufeb9\ufec9\u0648\u062d.\u063a\u064a\ufed9\ufe8f();
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
                    return ((Doubao)((Object)object)).SN;
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
    public static Ef \ufea9\u064a\ufeb5\ufee9(Object object) {
        int n = \u062d\ufeb9\ufeab\ufef1.\ufe8e\u0645\u0632\u0628();
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
                    return ((VodWithStatus)object).yq;
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
    public static short[] \ufea9\ufee9\ufe8f\ufee1() {
        int n = \ufe9d\ufeab\u062e\u0640.\ufeb5\ufead\u0638\u062f();
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
     * Enabled aggressive block sorting
     */
    public static String \ufeaf\u0645\u063a\u0638(Object object) {
        int n = \ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632();
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
                    return ((Doubao)((Object)object)).tF;
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
    public static HashMap \ufeb5\ufec5\ufee9\u0643(Object map) {
        int n = \ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646();
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
                    return ((Doubao)((Object)map)).t0;
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
    public static String \ufec1\u0644\ufeb9\ufead(Object object, Object object2, Object object3) {
        int n = \ufee9\ufee1\u0627\u0641.\u0641\u0638\ufeb1\ufeb5();
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
                    return ((Doubao)((Object)object)).tF((String)object2, (String)object3);
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
    public static String \ufec1\ufe99\u0647\u062e(Object object, Object object2) {
        int n = \ufeed\ufebd\u0635\ufedd.\ufe8e\u0628\u0638\u0631();
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
                    return ((Doubao)((Object)object)).zH((String)object2);
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
    public static String \ufed5\ufead\u0642\ufea9(Object object) {
        int n = \ufe8e\ufeb9\u0647\u0642.\ufe99\u062b\ufea1\u0647();
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
                    return ((Doubao)((Object)object)).N;
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
    public static Map \ufedd\u0645\u0630\ufe9d(Object map) {
        int n = \u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634();
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
                    return ((Doubao)((Object)map)).yq();
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
    public static String \ufee9\ufed9\u0633\ufea1(Object object) {
        int n = \ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635();
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
                    return ((Doubao)((Object)object)).zH;
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
    public static String \ufeed\ufeaf\u0641\u0628(Object object) {
        int n = \ufee9\ufee1\u0627\u0641.\u0641\u0638\ufeb1\ufeb5();
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
                    return ((Doubao)((Object)object)).yq;
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
     * Exception decompiling
     */
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
        String string = "\u06df\u06e7\u06e4";
        List list = null;
        ArrayList arrayList = null;
        Jz jz = null;
        String string2 = null;
        String string3 = null;
        short[] sArray = null;
        block29: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList, jz);
                    string = "\u06e3\u06e5\u06e0";
                    continue block29;
                }
                case 1747679: {
                    string2 = \ufeab\u062d\u063a\ufea9.\u062f\u0642\ufebd\u064a(sArray, 1229, 7, 2621);
                    string = "\u06e1\u06e1\u06e8";
                    continue block29;
                }
                case 1755338: {
                    sArray = Doubao.\ufea9\ufee9\ufe8f\ufee1();
                    string = "\u06e6\u06e5\u06e8";
                    continue block29;
                }
                case 1748680: {
                    jz = new Jz(string3, string2);
                    string = "\u06df\u06df\u06e7";
                    continue block29;
                }
                case 1755528: {
                    sArray = Doubao.\ufea9\ufee9\ufe8f\ufee1();
                    string = "\u06e7\u06e8";
                    continue block29;
                }
                case 1753609: {
                    string2 = \ufe8e\ufeb9\u0647\u0642.\ufee1\u062f\ufedd\u0643(sArray, 1274, 7, 843);
                    string = "\u06e4\u06e0";
                    continue block29;
                }
                case 1754569: {
                    list = Doubao.\u062c\u062d\u0634\u0632((Object)this);
                    string = "\u06e8\u06e2\u06e5";
                    continue block29;
                }
                case 1749826: {
                    string3 = \u0636\u0634\ufec1\u0631.\u062c\u063a\u0643\u0627(sArray, 1219, 10, 3078);
                    string = "\u06e7\u06e6\u06e8";
                    continue block29;
                }
                case 1752579: {
                    sArray = Doubao.\ufea9\ufee9\ufe8f\ufee1();
                    string = "\u06e8\u06e4\u06e6";
                    continue block29;
                }
                case 1747905: {
                    sArray = Doubao.\ufea9\ufee9\ufe8f\ufee1();
                    string = "\u06e3\u06e3\u06e7";
                    continue block29;
                }
                case 1746695: {
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList, jz);
                    string = "\u06e8\u06e5\u06e5";
                    continue block29;
                }
                case 1750663: {
                    string2 = \u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(sArray, 1251, 6, 813);
                    string = "\u06e2\u06e2\u06e5";
                    continue block29;
                }
                case 1748740: {
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList, jz);
                    string = "\u06e7\u06e5\u06e7";
                    continue block29;
                }
                case 56545: {
                    string3 = \ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(sArray, 1236, 15, 2347);
                    string = "\u06e0\u06e7\u06e8";
                    continue block29;
                }
                case 1750718: {
                    sArray = Doubao.\ufea9\ufee9\ufe8f\ufee1();
                    string = "\u06e2\u06e7\u06e7";
                    continue block29;
                }
                case 1746815: {
                    string2 = \ufea9\u0643\u062d\u063a.\ufea1\u0633\ufe8e\u0627(sArray, 1212, 7, 773);
                    string = "\u06e4\u06e4\u06e1";
                    continue block29;
                }
                case 1746940: {
                    arrayList = new ArrayList();
                    string = "\u06e5\u06e3\u06e1";
                    continue block29;
                }
                case 1755498: {
                    string3 = \u0631\ufea1\u0638\u0627.\u0645\u062f\u062d\ufeaf(sArray, 1204, 8, 3196);
                    string = "\u06e3\u06e6\u06e8";
                    continue block29;
                }
                case 1751531: {
                    string3 = \ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(sArray, 1257, 17, 995);
                    string = "\u06e8\u06df\u06e1";
                    continue block29;
                }
                case 1755435: {
                    string3 = \u0641\ufeb5\ufeb1\ufee1.\u0641\u0642\u0639\u0643(arrayList, list);
                    string = "\u06e3\u06e4\u06e4";
                    continue block29;
                }
                case 1754601: {
                    sArray = Doubao.\ufea9\ufee9\ufe8f\ufee1();
                    string = "\u06e0\u06e0\u06df";
                    continue block29;
                }
                case 1754413: {
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList, jz);
                    string = "\u06e5\u06e2\u06e4";
                    continue block29;
                }
                case 1751649: {
                    jz = new Jz(string3, string2);
                    string = "\u06e3\u06e8\u06e4";
                    continue block29;
                }
                case 56444: {
                    jz = new Jz(string3, string2);
                    string = "\u06e1\u06e3\u06e6";
                    continue block29;
                }
                case 1752551: {
                    sArray = Doubao.\ufea9\ufee9\ufe8f\ufee1();
                    string = "\u06e4\u06e0\u06e7";
                    continue block29;
                }
                case 1750757: {
                    sArray = Doubao.\ufea9\ufee9\ufe8f\ufee1();
                    string = "\u06df\u06e3\u06e3";
                    continue block29;
                }
                case 1749669: {
                    jz = new Jz(string3, string2);
                    string = "\u06e7\u06e0\u06e6";
                    continue block29;
                }
                case 1750691: 
            }
            break;
        }
        return string3;
    }

    /*
     * Exception decompiling
     */
    public boolean isVideoFormat(String var1_1) {
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

    public boolean manualVideoCheck() {
        return false;
    }

    /*
     * Exception decompiling
     */
    public String playerContent(String var1_1, String var2_3, List<String> var3_4) {
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

    private static long[] $d2j$hex$e8188942$decode_J(String src) {
        byte[] d = Doubao.$d2j$hex$e8188942$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$e8188942$decode_I(String src) {
        byte[] d = Doubao.$d2j$hex$e8188942$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$e8188942$decode_S(String src) {
        byte[] d = Doubao.$d2j$hex$e8188942$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$e8188942$decode_B(String src) {
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

    private static class VodWithStatus {
        String N;
        int SN;
        Ef yq;

        /*
         * Enabled aggressive block sorting
         */
        VodWithStatus(Ef object, int n, String string) {
            this.yq = object;
            this.SN = n;
            this.N = string;
            int n2 = \ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9();
            n = 1616;
            block6: while (true) {
                switch (n ^= 0x661) {
                    default: {
                        continue block6;
                    }
                    case 49: {
                        if (n2 >= 0) {
                            n = 1709;
                            continue block6;
                        }
                    }
                    case 14: {
                        n = 1678;
                        continue block6;
                    }
                    case 204: {
                        object = Long.decode(\ufea1\u0645\u062b\u0634.\u062f\ufead\ufee9\u0631("rLkdv1ZJ8StKEnpw6AFXiH"));
                        System.out.println(object);
                        return;
                    }
                    case 239: 
                }
                break;
            }
        }
    }
}

