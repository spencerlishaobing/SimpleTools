/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  com.google.gson.Gson
 */
package com.github.catvod.spider.merge;

import android.content.Context;
import android.util.Log;
import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\u0638\ufead\u062e\ufee1;
import com.github.catvod.parser.\u0645\u0641\u0630\u062d;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufe9d\u0631\ufe8f\u064a;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.merge.TO;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.y7;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufebd\u0640\u0648\u062b;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.merge.\ufee9\ufee1\u0627\u0641;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\u0640\u0633\ufea5\u0631;
import com.github.catvod.spider.\ufe8e\u0627\ufecd\u062a;
import com.github.catvod.spider.\ufe8e\ufeb9\u0647\u0642;
import com.github.catvod.spider.\ufea5\u062d\ufebd\u0633;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import com.github.catvod.spider.\ufeaf\u0633\u0648\ufee9;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import com.github.catvod.spider.\ufeb5\ufe8e\ufead\u0632;
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import com.google.gson.Gson;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class YU
extends Pan {
    private static Object Dr;
    private static Object E1;
    private static Method Fz;
    private static Class<?> H;
    private static ClassLoader U;
    private static Method Zm;
    private static HashMap<String, Object> b;
    private static Class<?> g;
    private static Class<?> k;
    private static Object m;
    private static final short[] short;
    private static Method tO;
    private StringBuilder O = new StringBuilder();
    private boolean g1 = true;
    private String n = "";
    private Object s;
    private y7 un;

    static {
        short = YU.$d2j$hex$cc3f89d4$decode_S("bb01b801a101ac01ad01ba01b801b1019701a401a701af01e601bc01b001bc01a608bc08bd08b908bc08bd088808a508a5088508a608ae08f851ec85f308e9080b0c280c310c3c0c3d0c2a0c080c210c2102000201020a02f801e301fa01fa019b01bd01ba01aa012204240423043304e90cce0cc30cdc0cca0cf301f401f901e601f001eb02cf02d6028702c6033a06630622062d0620063206320663067b0661061a061c066d06610663062d0628063206350663067b0661061a061c063c062e094d09ce056505ee01ee01d601d401c501d001c501c501c301d801d301c401c501d401ee01ee01190614061d0608061e06e406c606cd06dc06c506cc06fd06d006d906cc06320b320b0b0b040b010b080b320b320b2e067706680673067506740660066d065e066c066e06650674066d06640672062e06390467046e047f0c7f0c530c450c540c410c540c540c520c7f0c7f0c3e073e0705070807020715073e073e077402690274027202b804b804840486048b048b04b804b8047e0274027e027f047d04760467047e0477046104680c680c440c520c430c5e0c430c520c5a0c680c680c352b590c2a0c290c4d0c120c58662e5bd95e048348555c81430c590c1a58c785ea0ac30ace0ad20ad50ad40a9b60ed5d8b539f87b309b3098b09890998098d09980998099e0985098e09990998098909b309b3090a0c070c0d0c1a0ccc0ac90ad30ad40a1d0a1d0a210a230a2e0a2e0a1d0a1d0adb0bd20b550756075a075807550769074b07560741074007e00ce70ce10c6c066e0673066406650659066e066e0673066e06d506340117010e0103010201150137011e01aa03aa039603940399039903aa03aa03d109d409ce09c909a301a3019b01990188019d01880188018e0195019e01890188019901a301a301a4868f7f870ac40ac60ad30ac20ac00ac80ad50ade0ae40ac80ac90ad30ac20ac90ad30a8b0a870ad30ace0ac30a9a0af806f406a406b306e906540958091e09110914090c091d090a094509d702da02d002c7021904140414041704ab09a909bc09ad09af09a709ba09b1098b09a709a609bc09ad09a609bc09c003c303c303cd03c203030808085a0817081e08ff08f408a608f808e808eb08cb08e208bd08eb08e208a608c809ca09df09ce09cc09c409d909d209e809c409c509df09ce09c509df098b09a956935791098b09ba0ce30cad0ca80cb20cb50ce30cfb0ce10c9a0c9c0cbc0c848eaf77a702e302e202f402f302f502e802fe02db0cda0ccc0ccb0ccd0cd00cc60cfc24d9039d039c038a038d038b0396038003d9037558e961d007d107c707c007c607db07cd079407b6588c598e079407ac0bb50bbf0ba406a106bb06bc06558f7e76760332033303220337033f033a0315033903380322033303380322037a0376033f03320325036b03ac09ac0994099609870992098709870981099a099109860987099609ac09ac096f066f06530651065c065c066f066f06c905c805d905cc05c405c105ee05c205c305d905c805c305d90568012901350106017c014205040531052005080504050b059b03de03f703ed038f03dc03f7036e0c3a0c3f0c390c220c700c650c650c8309ca09c609c009c909c209d3099d090c0274020c0274020c027402f209eb09e009db09f409e809e509fd09db09e209f609eb09e909e109f809f309c809e709fb09f609ee09c809e209e509fb090c0a710a480a420a520ae704b304b604b004ab04ab0ae20aee0ae80ae10aea0afb0a3f07b201ca01c00cc50cc30cd80ce50ce00ce60cfd0caf0cba0cba0c070b0b0b0d0b040b0f0b1e0bd906f006ea068806db06f0068307b607a7078f0783078c073e03220311036b038f0988099609ca0bd809cc09d109d309cd09b104ad04a004b804b204aa05aa05aa0583038203930386038e038b03a403880389039303820389039303c703e55cdf5ddd03c703a507fc07b207b707ad07aa07fc07e407fe0785078307a307c40bc60bd70bed0bc20bce0bc60b5d055f054e0574055b0557055f051a05ee8ae45300051a053c083e082f0815083a0836083e087b085957635661087b08f905fa059e05c1058385a87ca009e809ef09ed09e509c309ef09ee09f409e509ee09f409ac09a009e609e909ec09f409e509f209bd090207050707070f072907050704071e070f0704071e07fd0b670592057304e801ef01ed01e501c301ef01ee01f401e501ee01f401a001825eb85fba01a00130066906280627062a0638063806690671066b061006160667066b0669062706220638063f06690671066b06100616063606c00ac50adf0ad80aef8bc472cc078407830781078907ba078507880789078307af07830782079807890782079807300a370a350a3d0a0e0a310a3c0a3d0a370a1b0a370a360a2c0a3d0a360a2c0a75077607760778077707fb0cf00ca20cef0ce60c34073f076d07330723072007000729077607200729076d07bf07b807ba07b2078107be07b307b207b8079407b807b907a307b207b907a307f707d558ef59ed07f707d1078807c607c307d907de07880790078a07f107f707d7079c0380038003840359095f096b026b026b026b026b0276020502060262023d0277680155f6502b8d76026b026b026b026b026b02d871316fd98ab2580c071607ed05e405e505ec05e605e20533053f053d057e0538053905230535053e057e0531053e05340522053f05390534057e0524052605b00bb40ba60bac0b56095a0958091b0953095a095b09520958095c091b0954095b09510947095a095c0951091b09410943091b09740945094509ff069006a106a106cd0bc10bc30b800bcd0bc60bcf0bdf0bdb0bc10b800bde0bd70bda0bc60bc10bc00b800bfe0bd70bda0bc60bc10bc00b870985099409a9098e099309940981098e0983098509fd2fd8084f8b2e5ba80881088c0890089708960866537347780c7a0c6b0c520c700c7b0c6a0c730c7a0c7d0c6a0c760c730c6b0c760c710c6c0c0e0104010e0136053a0538057b0536053d053405240520053a057b0525052c0521053d053a053b057b0505052c051a0537053f05300536052105c806ca06c706c706ea06df06df06d90678057905ce07c107c407cd079d059f09e003c903eb039c03922cb70b6b50f25ac40bc70ba30bfc0bb661c05c87690859ad02a202ae02a602b980d8505d037e0367036a036b037c039058854c200320032003b00a930a8a0a870a860a910a622e4709d08ab15a340917090e09030902091509f952ec46776bf85b5d0947098a098d098a099709e92fcc088508820885089808556d3964ef84c47dfc6a735a910391039103910391038c03ff03fc039803c7038d69fb540c51d18c2058bc618c0391039103910391039103a826c401b701b401d0018f01c56bb3564453998ed558c18cde01c401520c480c6d0c520c5f0c5e0c540c7d0c540c490c560c5a0c4f0cc00bda0bff0bc00bcd0bcc0bc60bef0bc60bdb0bc40bc80bdd0b890bab549155930b890b080a040a0b0a100a040a090a330a0c0a010a000a0a0a260a0d0a000a060a0e0a16021a0215020e021a0217022d0212021f021e021402380213021e02180210025b02795d435c41025b026a027502780279027302d608d608ee08ec08fd08e808fd08fd08fb08e008eb08fc08fd08ec08d608d608e906ec06f606f106e306e306df06dd06d006d006e306e30616080a0807081f08030814082508090808081208030808081208645a6a71b247fa64705470542795e071dd501485e55b107c4a56517451741c501c50a166e00ce70cf90cef0bf30bf30bf70b570c570c590c560c05080e085c081108180816071d074f0711070107020722070b07540702070b074f07640a750a660a670a710ade06d306d706d206d306c4066508790874086c087008670856087a087b08610870087b086108350817572d562f083508c60c9f0ccd0cdc0ccf0cce0cd80c9f0c870c9d0c8d0c910c9d0c9f0cc80ccf0cd10c9f0c870c9d0c9f0c9f0cc00cff09fa09e009e709b387987e900bc30bd50bd10bc20bd30bd80bf30bdf0bde0bc40bd50bde0bc40b9c0b900bdb0bd50bc90b8d0b2504290478047c0460046a04620434040f0119011d010e011f0114013f0113011201080119011201080159015a015a0154015b01e60ced0cbf0cf20cfb0c730978092a0974096409670947096e09310967096e092a09ef0af90afd0aee0aff0af40adf0af30af20ae80af90af20ae80abc0a9e55a454a60abc0afd03a403ea03ef03f503f203a403bc03a603dd03db03fb03ed87c67ece0b9d0b8b0b8f0b9c0b8d0b860bad0b810b800b9a0b8b0b800b9a0bc20bce0b850b8b0b970bd30b2b092709760972096e0964096c093a09d908d50885089208c808ae01b801bc01af01be01b5019e01b201b301a901b801b301a90103091509110902091309180933091f091e09040915091e0904095009725648574a095009ff08a608e808ed08f708f008a608be08a408df08d908f908");
        b = new HashMap();
        Zm = null;
        Dr = null;
        g = null;
        H = null;
        U = null;
        Fz = null;
        E1 = null;
        tO = null;
        m = null;
        k = null;
    }

    /*
     * Enabled aggressive block sorting
     */
    public YU() {
        int n = \u0640\u0633\ufea5\u0631.\ufe8f\ufed9\ufec5\ufe9d();
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
                    Double d = Double.decode((String)\u062d\ufeb9\ufeab\ufef1.\ufea5\ufec9\ufe8f\ufeab("bnn5TCUSrh7wGSlruTLaTl"));
                    System.out.println(d);
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
    private Object B(String var1_1, Object ... var2_3) {
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
     * Recovered potentially malformed switches.  Disable with '--allowmalformedswitch false'
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void F5() {
        block33: {
            var4_1 = this.O;
            var1_2 = 1616;
            block26: while (true) {
                switch (var1_2 ^= 1633) {
                    default: {
                        continue block26;
                    }
                    case 49: {
                        if (var4_1 != null) {
                            var1_2 = 1709;
                            continue block26;
                        }
                    }
                    case 14: {
                        var1_2 = 1678;
                        continue block26;
                    }
                    case 204: {
                        var3_3 = this.g1;
                        var1_2 = 1740;
                        break block26;
                    }
                    case 239: {
                        break block33;
                    }
                }
                break;
            }
            block27: while (true) {
                switch (var1_2 ^= 1757) {
                    default: {
                        continue block27;
                    }
                    case 17: {
                        if (var3_3) {
                            var1_2 = 1833;
                            continue block27;
                        }
                    }
                    case 54: {
                        var1_2 = 1802;
                        continue block27;
                    }
                    case 500: {
                        try {
                            TO.M(TO.Gc(\ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(YU.short, 0, 16, 456)), this.O.toString());
                            var1_2 = 1864;
                            ** GOTO lbl47
                        }
                        catch (Exception var5_4) {
                            var4_1 = oi_0.yq(\ufea9\u0643\u062d\u063a.\ufea1\u0633\ufe8e\u0627(YU.short, 16, 16, 2249));
                            var4_1.append(var5_4.getMessage());
                            var4_1 = var4_1.toString();
                            Log.e((String)\ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(YU.short, 32, 8, 3160), (String)var4_1);
                        }
                        break block27;
lbl47:
                        // 1 sources

                        block28: while (true) {
                            switch (var1_2 ^= 1881) {
                                default: {
                                    continue block28;
                                }
                                case 17: {
                                    var1_2 = 48674;
                                    continue block28;
                                }
                                case 47483: 
                            }
                            break;
                        }
                    }
                    case 471: 
                }
                break;
            }
        }
        var2_5 = \u0631\u0640\ufec1\ufee9.\ufe95\ufed5\u0643\u0628();
        var1_2 = 48767;
        block29: while (true) {
            switch (var1_2 ^= 48784) {
                default: {
                    continue block29;
                }
                case 239: {
                    if (var2_5 >= 0) {
                        var1_2 = 48860;
                        continue block29;
                    }
                }
                case 14: {
                    var1_2 = 48829;
                    continue block29;
                }
                case 76: {
                    var4_1 = Long.valueOf(\ufea9\u0643\u062d\u063a.\u0647\ufeab\ufeed\u062e("c0KyeuXqrqXms1yrW8JiYNlto5qP"));
                    System.out.println(var4_1);
                    return;
                }
                case 45: 
            }
            break;
        }
    }

    /*
     * Exception decompiling
     */
    private String G(String var1_1) {
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
    private String G4(String var1_1) {
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

    private Object dT(Object object, Method method, Method method2, String string, String string2) {
        String string3 = \ufea9\u0643\u062d\u063a.\ufea1\u0633\ufe8e\u0627(short, 100, 16, 433);
        try {
            Object object2 = method2.invoke(method.invoke(object, \u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(short, 116, 5, 1645)), \u0632\ufead\u062f\u0628.\u0645\u062a\u0637\u0635(short, 121, 10, 1705), new Object[]{string});
            Object object3 = \ufee9\ufee1\u0627\u0641.\ufea1\ufebd\u063a\u0630(short, 131, 8, 2925);
            CharSequence charSequence = new StringBuilder();
            charSequence.append(\u0630\ufebd\u0634\ufec9.\u0639\ufe8f\u064a\ufebd(short, 139, 17, 1537));
            charSequence.append(string);
            charSequence.append(\u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(short, 156, 3, 1047));
            charSequence = charSequence.toString();
            method2.invoke(object2, \ufe95\u0627\ufe8e\u0644.\u062d\u0636\ufea9\u0640(short, 159, 11, 3104), new Object[]{object3, charSequence});
            object3 = method2.invoke(object2, string3, new Object[]{\u0631\ufea1\u0638\u0627.\u0645\u062f\u062d\ufeaf(short, 170, 8, 1889)});
            charSequence = \ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(short, 178, 4, 529);
            method2.invoke(method2.invoke(Dr, string3, new Object[]{charSequence}), \u0632\ufead\u062f\u0628.\u0645\u062a\u0637\u0635(short, 182, 8, 1255), new Object[]{string2, object3});
            method2.invoke(method2.invoke(method.invoke(object, \u062a\u0635\ufeb1\u0642.\u0637\u0636\u062a\ufedd(short, 190, 3, 525)), string3, new Object[]{\ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(short, 193, 7, 1042)}), \ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(short, 200, 11, 3127), new Object[]{string, object2});
            return object2;
        }
        catch (Exception exception) {
            object = oi_0.yq(\ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(short, 211, 14, 3193));
            ((StringBuilder)object).append(exception.getMessage());
            this.q(((StringBuilder)object).toString());
            exception.printStackTrace();
            throw new RuntimeException(\u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(short, 225, 12, 2746), exception);
        }
    }

    /*
     * Exception decompiling
     */
    public static Object[] proxy(Map<String, String> var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 6[TRYBLOCK] [6 : 917->977)] java.lang.Exception
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

    private void q(String string) {
        String string2 = "\u06e2\u06e5\u06e3";
        StringBuilder stringBuilder = null;
        String string3 = null;
        short[] sArray = null;
        block10: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string2)) {
                default: {
                    stringBuilder.append(string);
                    string2 = "\u06e7\u06e3\u06e4";
                    continue block10;
                }
                case 1753515: {
                    Log.d(string3, (String)string);
                    string2 = "\u06df\u06e0\u06e2";
                    continue block10;
                }
                case 1754504: {
                    sArray = short;
                    string2 = "\u06e6\u06e8\u06e5";
                    continue block10;
                }
                case 1754623: {
                    string3 = \u0645\u0641\u0630\u062d.\u0642\u062a\u0630\ufebd(sArray, 295, 8, 359);
                    string2 = "\u06e6\u06e2\u06e7";
                    continue block10;
                }
                case 1747746: {
                    stringBuilder.append(string3);
                    string2 = "\u06e1\u06e3\u06e6";
                    continue block10;
                }
                case 1753699: {
                    string3 = \u0635\u0631\u0645\u0628.\u0646\u0627\u062a\u062d(sArray, 294, 1, 1759);
                    string2 = "\u06e0\u06e2\u06e4";
                    continue block10;
                }
                case 1749760: {
                    stringBuilder = this.O;
                    string2 = "\u06e6\u06e1\u06e6";
                    continue block10;
                }
                case 1748740: {
                    sArray = short;
                    string2 = "\u06e7\u06e7\u06df";
                    continue block10;
                }
                case 1746721: 
            }
            break;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static HashMap \u0628\ufe99\u0643\ufec1() {
        int n = \ufe99\u062e\u0642\u0644.\ufe99\ufec9\ufec5\u0646();
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
                    return b;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            HashMap<String, Object> hashMap = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return hashMap;
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
    public static Method \u0628\ufeaf\ufebd\u0648() {
        int n = \ufed9\ufe9d\ufeed\ufeb5.\ufedd\ufeaf\ufec9\u0646();
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
                    return Fz;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            Method method = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return method;
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
    public static Class \u0632\ufed5\ufeaf\ufead() {
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
                    return k;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            Class<?> clazz = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return clazz;
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
    public static Class \u0638\ufea9\ufed5\ufe95() {
        int n = \u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648();
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
                    return g;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            Class<?> clazz = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return clazz;
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
    public static Object \u0641\u0642\u0648\u0640(Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
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
                    return ((YU)((Object)object)).dT(object2, (Method)object3, (Method)object4, (String)object5, (String)object6);
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
    public static short[] \u0641\ufec1\u062b\u062f() {
        int n = \ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9();
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
    public static Object \u0642\u0627\ufead\ufec5() {
        int n = \u062b\ufec1\ufeb1\u062d.\ufe8f\ufe9d\u0628\ufe99();
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
                    return Dr;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            Object var2_2 = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return var2_2;
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
    public static void \u0648\u0637\u0631\u0634(Object object, Object object2) {
        int n = \u0631\u063a\u0645\u0641.\u064a\u062b\u0635\ufe9d();
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
                    ((YU)((Object)object)).q((String)object2);
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
    public static String \ufe8e\u062f\u0631\ufeb5(Object object, Object object2) {
        int n = \ufe99\u062e\u0642\u0644.\ufe99\ufec9\ufec5\u0646();
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
                    return ((YU)((Object)object)).G4((String)object2);
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
    public static String \ufe9d\ufea5\u0635\u0641(Object object) {
        int n = \ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643();
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
                    return ((YU)((Object)object)).n;
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
    public static Object \ufea9\u0639\u062e\u062b(Object object) {
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
                    return ((YU)((Object)object)).s;
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
    public static Method \ufead\u0639\ufef1\u062a() {
        int n = \ufe8e\u0627\ufecd\u062a.\ufe99\ufead\ufeb5\ufe95();
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
                    return tO;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            Method method = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return method;
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
    public static ClassLoader \ufead\ufeb1\u0644\ufedd() {
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
                    return U;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            ClassLoader classLoader = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return classLoader;
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
    public static void \ufeb1\u062d\u0637\u0639(Object var0) {
        var2_1 = \ufeaf\u0633\u0648\ufee9.\u0641\u062b\u062d\ufeed();
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
                    if (var2_1 <= 0) ** GOTO lbl7
                    var1_2 = 1709;
                    continue block16;
                }
                case 204: {
                    ((YU)var0).F5();
lbl16:
                    // 2 sources

                    while (true) {
                        var2_1 = \ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633();
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
                                    var0 = Integer.decode(\ufeb9\u0627\ufea5\ufe9d.\u0648\u0647\u0628\u062b("vlaiP6qh8JCmY6s0E"));
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
    public static Class \ufeb5\u0637\u0639\u0628() {
        int n = \ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635();
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
                    return H;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            Class<?> clazz = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return clazz;
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
    public static Object \ufeb5\ufe99\u0635\ufead(Object object, Object object2, Object object3) {
        int n = \ufecd\u0642\u062e\ufe9d.\u0634\u063a\u0628\ufeb9();
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
                    return ((YU)((Object)object)).B((String)object2, (Object[])object3);
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
    public static Method \ufed5\u062b\u0644\u062d() {
        int n = \ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643();
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
                    return Zm;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            Method method = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return method;
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
    public static Object \ufedd\ufec9\u0632\u0638() {
        int n = \ufecd\u0642\u062e\ufe9d.\u0634\u063a\u0628\ufeb9();
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
                    return E1;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            Object var2_2 = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return var2_2;
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
    public static Object \ufee1\ufe95\ufe8f\ufed5(Object object, Object object2, Object object3) {
        int n = \ufeab\u062d\u063a\ufea9.\ufebd\ufe8f\u0635\u0647();
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
                    return ((Gson)object).fromJson((String)object2, (Class)object3);
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
    public static String \ufee9\u0627\u0644\u0646(Object object, Object object2) {
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
                    return ((YU)((Object)object)).G((String)object2);
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
    public static Object \ufeed\u0632\ufef1\u0647() {
        int n = \ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9();
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
                    return m;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            Object var2_2 = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return var2_2;
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
    public static y7 \ufef1\u0643\u0627\u064a(Object object) {
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
                    return ((YU)((Object)object)).un;
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
    public String categoryContent(String var1_1, String var2_3, boolean var3_4, HashMap<String, String> var4_5) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 48[UNCONDITIONALDOLOOP]
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
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void destroy() {
        int n;
        block16: {
            this.q(\ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644(short, 446, 10, 647));
            Object object = this.s;
            n = 1616;
            block13: while (true) {
                switch (n ^= 0x661) {
                    default: {
                        continue block13;
                    }
                    case 49: {
                        if (object != null) {
                            n = 1709;
                            continue block13;
                        }
                    }
                    case 14: {
                        n = 1678;
                        continue block13;
                    }
                    case 204: {
                        try {
                            this.B(\ufee9\u0631\ufeb5\u0628.\u0636\ufeab\u0634\u0633(short, 456, 7, 3263), new Object[0]);
                            this.q(\ufe95\u0627\ufe8e\u0644.\u062d\u0636\ufea9\u0640(short, 463, 12, 1017));
                            n = 1740;
                            break block16;
                        }
                        catch (Exception exception) {
                            object = oi_0.yq(\ufeb5\ufe8e\ufead\u0632.\ufe8f\ufef1\u0648\ufe95(short, 475, 12, 1972));
                            ((StringBuilder)object).append(exception.getMessage());
                            this.q(((StringBuilder)object).toString());
                            return;
                        }
                    }
                    case 239: 
                }
                break;
            }
            return;
        }
        block14: while (true) {
            switch (n ^= 0x6DD) {
                default: {
                    continue block14;
                }
                case 17: {
                    n = 1771;
                    continue block14;
                }
                case 54: 
            }
            break;
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String getName() {
        Object object = this.s;
        int n = 1616;
        block16: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block16;
                }
                case 49: {
                    if (object != null) {
                        n = 1709;
                        continue block16;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block16;
                }
                case 204: {
                    object = this.B(\u062d\u062e\ufe8e\u0645.\u062d\ufeab\u0642\u0647(short, 719, 7, 2979), new Object[0]);
                    n = 1740;
                    break block16;
                }
                case 239: {
                    return \ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(short, 750, 4, 1450);
                }
            }
            break;
        }
        block17: while (true) {
            switch (n ^= 0x6DD) {
                default: {
                    continue block17;
                }
                case 17: {
                    if (object != null) {
                        n = 1833;
                        continue block17;
                    }
                }
                case 54: {
                    n = 1802;
                    continue block17;
                }
                case 500: {
                    try {
                        object = object.toString();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(\ufe95\u0627\ufe8e\u0644.\u062d\u0636\ufea9\u0640(short, 726, 12, 1338));
                        stringBuilder.append((String)object);
                        this.q(stringBuilder.toString());
                        return object;
                    }
                    catch (Exception exception) {
                        object = oi_0.yq(\ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(short, 738, 12, 2139));
                        ((StringBuilder)object).append(exception.getMessage());
                        this.q(((StringBuilder)object).toString());
                    }
                }
                case 471: 
            }
            break;
        }
        return \ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(short, 750, 4, 1450);
    }

    /*
     * Exception decompiling
     */
    public String homeContent(boolean var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 2[TRYBLOCK] [4 : 314->363)] java.lang.Throwable
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
    public String homeVideoContent() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [16[CASE]], but top level block is 2[TRYBLOCK]
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
     * Exception decompiling
     */
    @Override
    public void init(Context var1_1, String var2_5) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 12[TRYBLOCK] [25, 24, 26 : 1190->1237)] java.lang.Exception
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
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isVideoFormat(String object) {
        boolean bl;
        int n;
        Object object2;
        boolean bl2 = false;
        try {
            object2 = this.s;
            n = 1616;
        }
        catch (Exception exception) {
            object = oi_0.yq(\ufeab\u0632\u062f\u0640.\u062f\u0627\ufe95\u0631(short, 1247, 18, 2985));
            ((StringBuilder)object).append(exception.getMessage());
            this.q(((StringBuilder)object).toString());
            return bl2;
        }
        block16: while (true) {
            bl = bl2;
            switch (n ^= 0x661) {
                default: {
                    continue block16;
                }
                case 49: {
                    if (object2 != null) {
                        n = 1709;
                        continue block16;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block16;
                }
                case 204: {
                    object = this.B(\u062d\u062e\ufe8e\u0645.\u062d\ufeab\u0642\u0647(short, 1234, 13, 3131), object);
                    n = 1740;
                    break block16;
                }
                case 239: {
                    return bl;
                }
            }
            break;
        }
        block17: while (true) {
            bl = bl2;
            switch (n ^= 0x6DD) {
                default: {
                    continue block17;
                }
                case 17: {
                    if (object != null) {
                        n = 1833;
                        continue block17;
                    }
                }
                case 54: {
                    n = 1802;
                    continue block17;
                }
                case 500: {
                    return Boolean.parseBoolean(object.toString());
                }
                case 471: 
            }
            break;
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean manualVideoCheck() {
        boolean bl;
        int n;
        Object object;
        boolean bl2 = false;
        try {
            object = this.s;
            n = 1616;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = oi_0.yq(\ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(short, 1281, 21, 635));
            stringBuilder.append(exception.getMessage());
            this.q(stringBuilder.toString());
            return bl2;
        }
        block16: while (true) {
            bl = bl2;
            switch (n ^= 0x661) {
                default: {
                    continue block16;
                }
                case 49: {
                    if (object != null) {
                        n = 1709;
                        continue block16;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block16;
                }
                case 204: {
                    object = this.B(\ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(short, 1265, 16, 2661), new Object[0]);
                    n = 1740;
                    break block16;
                }
                case 239: {
                    return bl;
                }
            }
            break;
        }
        block17: while (true) {
            bl = bl2;
            switch (n ^= 0x6DD) {
                default: {
                    continue block17;
                }
                case 17: {
                    if (object != null) {
                        n = 1833;
                        continue block17;
                    }
                }
                case 54: {
                    n = 1802;
                    continue block17;
                }
                case 500: {
                    return Boolean.parseBoolean(object.toString());
                }
                case 471: 
            }
            break;
        }
        return bl;
    }

    /*
     * Exception decompiling
     */
    @Override
    public String playerContent(String var1_1, String var2_4, List<String> var3_5) {
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
    public String searchContent(String var1_1, boolean var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [16[CASE]], but top level block is 2[TRYBLOCK]
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
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String searchContent(String object, boolean bl, String charSequence) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(\ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(short, 1545, 22, 3054));
        stringBuilder.append((String)object);
        stringBuilder.append(\u0633\u064a\u0644\u0637.\ufec9\ufeed\ufeb5\u0640(short, 1567, 8, 2311));
        stringBuilder.append(bl);
        stringBuilder.append(\ufea5\u062d\ufebd\u0633.\ufea5\ufeb1\u0643\ufe8f(short, 1575, 5, 2293));
        stringBuilder.append((String)charSequence);
        this.q(stringBuilder.toString());
        object = this.B(\u0630\ufebd\u0634\ufec9.\u0639\ufe8f\u064a\ufebd(short, 1580, 13, 477), object, bl, charSequence);
        int n = 1616;
        block9: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block9;
                }
                case 49: {
                    if (object != null) {
                        n = 1709;
                        continue block9;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block9;
                }
                case 204: {
                    try {
                        return this.G(object.toString());
                    }
                    catch (Exception exception) {
                        charSequence = oi_0.yq(\u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(short, 1593, 18, 2416));
                        ((StringBuilder)charSequence).append(exception.getMessage());
                        this.q(((StringBuilder)charSequence).toString());
                        return \ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(short, 1611, 12, 2180);
                    }
                }
                case 239: 
            }
            break;
        }
        return \ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(short, 1611, 12, 2180);
    }

    private static long[] $d2j$hex$cc3f89d4$decode_J(String src) {
        byte[] d = YU.$d2j$hex$cc3f89d4$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$cc3f89d4$decode_I(String src) {
        byte[] d = YU.$d2j$hex$cc3f89d4$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$cc3f89d4$decode_S(String src) {
        byte[] d = YU.$d2j$hex$cc3f89d4$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$cc3f89d4$decode_B(String src) {
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

