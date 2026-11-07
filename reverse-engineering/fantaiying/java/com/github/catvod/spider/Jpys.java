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
import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\u0645\u0641\u0630\u062d;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.parser.\ufeb9\ufec9\u0648\u062d;
import com.github.catvod.parser.\ufec1\u0636\u062d\u0638;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0641\u0631\ufeed\u0643;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufea5\ufea9\u0633\ufed5;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufebd\u0640\u0648\u062b;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.merge.\ufee9\ufee1\u0627\u0641;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\ufe8e\ufeb9\u0647\u0642;
import com.github.catvod.spider.\ufe99\u062c\u0643\ufec1;
import com.github.catvod.spider.\ufea5\u062d\ufebd\u0633;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import com.github.catvod.spider.\ufeaf\u0633\u0648\ufee9;
import com.github.catvod.spider.\ufeb5\ufe8e\ufead\u0632;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class Jpys
extends Spider {
    private static final short[] short = Jpys.$d2j$hex$7236c2cd$decode_S("a801b401b401b001b301fa01ef01ef01b701b701b701ee01a701a801b701f901ba01b701b001f501ee01a301af01ad01e908f208fb0897088b082a0931096058e0997907650761077207100a030a140a100afe0bed0bfa0bfe0ba20b100a460a570a510a530a780a430a5b0a0b0a740426042b042204370463046f0445051a050605020511055e05cc0581058f059305d70589058805d205da05d205df05d805d30588058b058f05dc058805dc0588058f05de05df058f0589058c058b058805d805d3058b05de05d205d205d30588058905cc059e05d70576026c0262026b028e04b403b503a603b903b303b503b903b4030e034003510348030e034c0356030c034c034e035703480344030e0340034f034e034f0358034c034e03540352030e0357034803450344034e030e034d034803520355031e03550358035103440310031c0304035203070351034003460344036f0354034c031c0304035203070340035303440340031c0304035203070358034403400353031c03040352038b078b0796079607d703d203c703d2030a070f0715071207d80ac10aca0aed0ac20acf0add0add0a6f5a9a503f0b3f441f7f3f0bdc6b6b893f0b7e59dc6b350b2879dc6b04031d03160322031b03110342055b0550057a05550559055105490550055b0569055a054d054c055605500551053d0824082f0802082f08f702b902a802b102f702b502af02f502b502b702ae02b102bd02f702b902b602b702b602a102b502b702ad02ab02f702ae02b102bc02bd02b702f702bc02bd02ac02b902b102b402e702b102bc02e502490444041d04d20a9f0a910a8d0ac90a970a960acc0ac40acc0ac10ac60acd0a960a950a910ac20a960ac20a960a910ac00ac10a910a970a920a950a960ac60acd0a950ac00acc0acc0acd0a960a970ad20a800ac90a3e0724072a0723070207020a020a1f0a1f0a9a0b9f0b8a0b9f0b8c0195019e01b4019b0197019f01840393039b039b03c505dc05d705e105d605de05d205c105d805c005de0cc70ccc0cf80cc10ccb0c2c0535053e051b0528053f053b05900989098209bf09830987099409610372033b0c270c360c2f0c240c030c2c0c210c330c330c0a06130618063d061f06080613060e06a30ca10ca10c5e0547054c056c0541055a054d054b055c0547055a05b303aa03a1038703a903b003b703a70326083f08340813083f083e08240835083e082408da03cf03d603cc03d003db03da03f303d603cc03cb0343065f0642064206017405734159d808d708db08d308d305d405d9050509df018406ee75ea72ae585d085d085d08e305a370e75ae0011770e48c4557e8048156026bb2097672f08efe06f006ec06a806f606f706ad06a506ad06a006a706ac06f706f406f006a306f706a306f706f006a106a006f006f606f306f406f706a706ac06f406a106ad06ad06ac06f706f606b306e106a806b503af03a103a803a001c706c606d506ca06c006c606ca06c706b00bfe0bef0bf60bb00bf20be80bb20bf20bf00be90bf60bfa0bb00bfe0bf10bf00bf10be60bf20bf00bea0bec0bb00bf70bf00bf20bfa0bb00bf70bf00beb0bcc0bfa0bfe0bed0bfc0bf70b1a081f080a081f0865027c02770250027f02720260026002225bd751720a7245527e720a916a2688720a3358916a780a6578916a4f0c560c5d0c690c500c5a0c06021f0214023e0211021d021502fa0be30be80bda0be90bfe0bff0be50be30be20b2c0b350b3e0b130b3e0b80079a07ae078f079c07830789078f07a3078e0736022a022a022e022d0264027102710229022902290270023902360229026702240229022e026b0270023d023102330279047e0460046d0b4f0b5a0b490b4c0b4c0b410b0f0b150b0e0b100b000b080b780b110b110b1b0b000b6c0b490b4e0b550b580b000b410b410b520b430b480b160b140b090b000b610b500b500b4c0b450b770b450b420b6b0b490b540b0f0b150b130b170b0e0b130b160b000b080b6b0b680b740b6d0b6c0b0c0b000b4c0b490b4b0b450b000b670b450b430b4b0b4f0b090b000b630b480b520b4f0b4d0b450b0f0b110b140b180b0e0b100b0e0b100b0e0b100b000b730b410b460b410b520b490b0f0b150b130b170b0e0b130b160b9909bf09a909be09e1098d09ab09a909a209b80932077a077d0770072907910bb80af60ae70afe0ab80afa0ae00aba0afa0af80ae10afe0af20ab80af60af90af80af90aee0afa0af80ae20ae40ab80ae10aa50ab80ae10afe0af30af20af80ab80af20ae70afe0ae40af80af30af20ab80ae20ae50afb0aa80af40afb0afe0af20af90ae30ac30aee0ae70af20aaa0aa40ab10afe0af30aaa0aec08e308e608ea08e108fb08db08f608ff08ea08b208bc08a908e608eb08b2086f0322032c03300374032a032b037103790371037c037b0370032b0328032c037f032b037f032b032c037d037c032c032a032f0328032b037b03700328037d037103710370032b032a036f033d037403e601fc01f201fb0179048a018b01980187018d018b0187018a013c043c04210421044e0b4b0b5e0b4b0ba704a204b804bf04430a430a430a430ad705ea05f105ff05f105f605e80cdf0cdc0cdf0cc80cdf0cc80ca102b002a302a202b402ed0b96048a0487049f04b30494048a041b0c160c120c170c160c010c99079c07930790079c07960788073707790768077107370775076f073507750777076e0771077d07370779077607770776076107750777076d076b0737076e0771077c077d07770737076b077d0779076a077b0770075a0761074f0777076a077c07270773077d0761076f0777076a077c0725077a012c013d013b01390112012901310161016d017a012c013d013b0139010f0135012601390161016401ad09a309bf09b109a909b409a209fb09e501b301a201a401a6018d01b601ae01fe01f201e501b301a201a401a6019001aa01b901a601fe01fb01e501a801a601ba01fe01a001a101fb01f301fb01f601f101fa01a101a201a601f501a101f501a101a601f701f601a601a001a501a201a101f101fa01a201f701fb01fb01fa01a101a001e501b701fe01f106eb06e506ec068d05c503c403d703c803c203c403c803c503940a910a840a910a4b045c044a044c0455044d04320b370b2d0b2a0b2a073307380712073d0731073907c905d005db05fc05d305de05cc05cc051354e65e4305434a63714305a065178743050257a06549055477a065840a9d0a960aa20a9b0a910aa003b903b2039f03b203490750075b076d075a0752075e074d0754074c07");
    private String SN;
    private String yq = \ufed9\ufe9d\ufeed\ufeb5.\u0638\ufec1\u063a\u0644(Jpys.\ufe95\u0633\ufec1\ufea9(), 0, 24, 448);

    /*
     * Enabled aggressive block sorting
     */
    public Jpys() {
        this.SN = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
        int n = \ufeb9\u0643\ufed9\ufed5.\ufeed\u0631\u0648\ufea5();
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
                    Integer n3 = Integer.valueOf(\ufee9\ufee1\u0627\u0641.\u0644\ufef1\u0643\u0631("V2rNzPsqu"));
                    System.out.println(n3);
                    return;
                }
                case 239: 
            }
            break;
        }
    }

    public static String getUUID() {
        return \u0631\ufea1\u0638\u0627.\u062a\u0630\u0635\u062b(\u0633\u064a\u0644\u0637.\u0635\ufed9\u0636\ufec9());
    }

    /*
     * Exception decompiling
     */
    public static String sha1(String var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [14[CASE]], but top level block is 2[TRYBLOCK]
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

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0630\u064a\ufead\u0639(Object object) {
        int n = \ufe8e\ufec1\u0641\u0644.\u062c\u0642\ufe9d\ufef1();
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
                    return ((Jpys)((Object)object)).yq;
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
    public static void \u0642\u0643\ufea9\u0648(Object object) {
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
    public static short[] \ufe95\u0633\ufec1\ufea9() {
        int n = \u0645\u0641\u0630\u062d.\ufee1\ufec5\ufea9\u064a();
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
    public static String \ufedd\ufecd\u0644\u062a(Object object) {
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
                    return ((Jpys)((Object)object)).SN;
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

    /*
     * Exception decompiling
     */
    public String homeContent(boolean var1_1) {
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
    public void init(Context object, String string) {
        String string2;
        super.init(object, string2);
        boolean bl = \ufea5\u062d\ufebd\u0633.\u0639\ufeb1\ufead\ufe8f(string2);
        int n = 1616;
        block18: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block18;
                }
                case 49: {
                    if (!bl) {
                        n = 1709;
                        continue block18;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block18;
                }
                case 204: {
                    this.yq = string2;
                    break block18;
                }
                case 239: 
            }
            break;
        }
        String string3 = \ufeab\u0632\u062f\u0640.\u062f\u0627\ufe95\u0631(Jpys.\ufe95\u0633\ufec1\ufea9(), 633, 10, 2026);
        this.SN = string2 = \ufea9\ufe8f\u0647\ufead.\ufeab\u0641\ufeb5\ufeb9(string3, \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640());
        bl = \ufea5\u062d\ufebd\u0633.\u0639\ufeb1\ufead\ufe8f(string2);
        n = 1740;
        block19: while (true) {
            switch (n ^= 0x6DD) {
                default: {
                    continue block19;
                }
                case 17: {
                    if (bl) {
                        n = 1833;
                        continue block19;
                    }
                }
                case 54: {
                    n = 1802;
                    continue block19;
                }
                case 500: {
                    this.SN = string2 = \ufec1\u0636\u062d\u0638.\u0633\u0643\u0630\ufebd();
                    \ufecd\u0642\u062e\ufe9d.\ufee9\u062c\u0643\ufedd(string3, string2);
                    break block19;
                }
                case 471: 
            }
            break;
        }
        int n2 = \ufeb5\ufe8e\ufead\u0632.\ufe95\u0647\u062d\u0631();
        n = 1864;
        block20: while (true) {
            switch (n ^= 0x759) {
                default: {
                    continue block20;
                }
                case 17: {
                    if (n2 >= 0) {
                        n = 48736;
                        continue block20;
                    }
                }
                case 47483: {
                    n = 48705;
                    continue block20;
                }
                case 47417: {
                    Integer n3 = Integer.valueOf(\ufe99\u062e\u0642\u0644.\ufeed\u0628\ufeb1\u0639("HQU2n9hMX"));
                    System.out.println(n3);
                    return;
                }
                case 47384: 
            }
            break;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String playerContent(String string, String string2, List<String> object) {
        JSONObject jSONObject;
        object = \u0631\ufea1\u0638\u0627.\u0645\u062f\u062d\ufeaf(Jpys.\ufe95\u0633\ufec1\ufea9(), 643, 24, 606);
        String string3 = \u062d\ufeb9\ufeab\ufef1.\ufeed\u0638\u0635\ufed5(Jpys.\ufe95\u0633\ufec1\ufea9(), 667, 3, 1036);
        String string4 = \ufea9\ufe8f\u0647\ufead.\ufea9\u0643\ufedd\ufeed(Jpys.\ufe95\u0633\ufec1\ufea9(), 670, 102, 2848);
        String string5 = \ufeab\u062d\u063a\ufea9.\u062f\u0642\ufebd\u064a(Jpys.\ufe95\u0633\ufec1\ufea9(), 772, 10, 2508);
        String string6 = \u062a\u0635\ufeb1\u0642.\u0637\u0636\u062a\ufedd(Jpys.\ufe95\u0633\ufec1\ufea9(), 782, 5, 1812);
        string = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
        \u062b\ufec1\ufeb1\u062d.\ufef1\ufeb1\ufe95\u0628();
        \ufea9\ufec5\u0647\u0641.\u0636\u0633\u0645\ufe9d(true);
        try {
            jSONObject = \ufeb5\ufe8e\ufead\u0632.\u0640\ufec5\ufedd\u0634(string2, \u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(Jpys.\ufe95\u0633\ufec1\ufea9(), 787, 1, 3025));
        }
        catch (Exception exception) {
            Jpys.\u0642\u0643\ufea9\u0648(exception);
            return string;
        }
        string2 = jSONObject[0];
        String string7 = jSONObject[1];
        jSONObject = new StringBuilder();
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(jSONObject, Jpys.\u0630\u064a\ufead\u0639((Object)this));
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(jSONObject, \u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(Jpys.\ufe95\u0633\ufec1\ufea9(), 788, 61, 2711));
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(jSONObject, string2);
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(jSONObject, string6);
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(jSONObject, string7);
        Object object2 = \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(jSONObject);
        jSONObject = \u0630\ufebd\u0634\ufec9.\ufea9\u062f\u0648\u062d(\ufe99\u062c\u0643\ufec1.\ufedd\u0641\u062b\ufea9());
        StringBuilder stringBuilder = new StringBuilder();
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, \ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644(Jpys.\ufe95\u0633\ufec1\ufea9(), 849, 16, 2191));
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, string2);
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, string6);
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, string7);
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, \ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(Jpys.\ufe95\u0633\ufec1\ufea9(), 865, 40, 841));
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, jSONObject);
        string2 = \ufebd\u0640\u0648\u062b.\u0642\ufec1\u0648\u0640(\ufeb9\ufec9\u0648\u062d.\u062f\ufe99\u0645\u062d(\ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(stringBuilder)));
        HashMap hashMap = new HashMap();
        \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, string5, string4);
        \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, \u0631\ufea1\u0638\u0627.\u0645\u062f\u062d\ufeaf(Jpys.\ufe95\u0633\ufec1\ufea9(), 905, 4, 405), string2);
        \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, \u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(Jpys.\ufe95\u0633\ufec1\ufea9(), 909, 1, 1069), jSONObject);
        \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, \ufea9\u0643\u062d\u063a.\ufea1\u0633\ufe8e\u0627(Jpys.\ufe95\u0633\ufec1\ufea9(), 910, 8, 494), Jpys.\ufedd\ufecd\u0644\u062a((Object)this));
        string2 = \ufebd\u0640\u0648\u062b.\u0646\ufed5\u0630\ufec9(object2, hashMap);
        jSONObject = \u062d\u062e\ufe8e\u0645.\ufead\ufea5\ufec1\u0637();
        StringBuilder stringBuilder2 = new StringBuilder();
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder2, \u0645\u0641\u0630\u062d.\u0642\u062a\u0630\ufebd(Jpys.\ufe95\u0633\ufec1\ufea9(), 918, 4, 1112));
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder2, string2);
        \ufee1\u0639\u063a\u0645.\ufef1\u062c\u0638\u062f(jSONObject, \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(stringBuilder2));
        JSONObject jSONObject2 = new JSONObject(string2);
        string2 = new JSONObject();
        String string8 = \ufeab\u0632\u062f\u0640.\ufeab\u0632\ufec5\u0645(\ufeaf\u0633\u0648\ufee9.\u062e\u062f\u0644\u0645(\ufee9\ufee1\u0627\u0641.\ufead\ufeb1\u0627\u0641(\ufeaf\ufea5\ufeab\u062e.\ufe99\ufea9\u0647\u0641(jSONObject2, \ufe8e\ufeb9\u0647\u0642.\ufee1\u062f\ufedd\u0643(Jpys.\ufe95\u0633\ufec1\ufea9(), 922, 4, 2858)), \ufebd\u0640\u0648\u062b.\ufea5\u0639\u0631\ufe95(Jpys.\ufe95\u0633\ufec1\ufea9(), 926, 4, 1227)), 0), string3);
        object2 = \u062d\u062e\ufe8e\u0645.\ufead\ufea5\ufec1\u0637();
        jSONObject = new StringBuilder();
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(jSONObject, \ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(Jpys.\ufe95\u0633\ufec1\ufea9(), 930, 4, 2608));
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(jSONObject, string8);
        \ufee1\u0639\u063a\u0645.\ufef1\u062c\u0638\u062f(object2, \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(jSONObject));
        jSONObject = new JSONObject();
        \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(jSONObject, string5, string4);
        \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(jSONObject, \ufeab\u062d\u063a\ufea9.\u062f\u0642\ufebd\u064a(Jpys.\ufe95\u0633\ufec1\ufea9(), 934, 6, 1432), object);
        \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(jSONObject, \ufeb9\ufec9\u0648\u062d.\ufee9\u0637\ufef1\u0644(Jpys.\ufe95\u0633\ufec1\ufea9(), 940, 7, 3258), object);
        \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(string2, string3, string8);
        \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(string2, \ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644(Jpys.\ufe95\u0633\ufec1\ufea9(), 947, 5, 721), \ufeab\u0632\u062f\u0640.\u062f\u0627\ufe95\u0631(Jpys.\ufe95\u0633\ufec1\ufea9(), 952, 1, 3037));
        \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(string2, \ufeb9\u0643\ufed9\ufed5.\u0628\u062f\ufea1\u0642(Jpys.\ufe95\u0633\ufec1\ufea9(), 953, 7, 1254), string);
        \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(string2, \ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(Jpys.\ufe95\u0633\ufec1\ufea9(), 960, 6, 3187), \ufeaf\u0633\u0648\ufee9.\ufeb5\u0634\u0640\ufea1(jSONObject));
        \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(string2, \ufebd\u0640\u0648\u062b.\ufea5\u0639\u0631\ufe95(Jpys.\ufe95\u0633\ufec1\ufea9(), 966, 7, 2045), \ufea9\ufe8f\u0647\ufead.\ufec1\u0631\u062a\u062e(string8));
        return string2 = \ufeaf\u0633\u0648\ufee9.\ufeb5\u0634\u0640\ufea1(string2);
    }

    /*
     * Exception decompiling
     */
    public String searchContent(String var1_1, boolean var2_2) {
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

    private static long[] $d2j$hex$7236c2cd$decode_J(String src) {
        byte[] d = Jpys.$d2j$hex$7236c2cd$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$7236c2cd$decode_I(String src) {
        byte[] d = Jpys.$d2j$hex$7236c2cd$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$7236c2cd$decode_S(String src) {
        byte[] d = Jpys.$d2j$hex$7236c2cd$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$7236c2cd$decode_B(String src) {
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

