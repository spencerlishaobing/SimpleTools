/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.github.catvod.crawler.SpiderDebug
 *  okhttp3.Response
 *  okhttp3.ResponseBody
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.content.Context;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u062b\u064a\ufecd\u0642;
import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufe9d\u0631\ufe8f\u064a;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\ufec9\u0648\u062d;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.merge.w2;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufebd\u0640\u0648\u062b;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\u0636\u0634\ufec1\u0631;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufe8e\u0627\ufecd\u062a;
import com.github.catvod.spider.\ufe8e\ufeb9\u0647\u0642;
import com.github.catvod.spider.\ufe99\u062c\u0643\ufec1;
import com.github.catvod.spider.\ufeaf\u0633\u0648\ufee9;
import com.github.catvod.spider.\ufeb5\ufe8e\ufead\u0632;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class Libvio
extends Pan {
    private static final short[] short = Libvio.$d2j$hex$3b0c28e1$decode_S("ff0ae30ae30ae70ae40aad0ab80ab80ae00ae00ae00ab90afb0afe0af50ae10afe0af80ab90afe0af80ab80a3204690464046d04780432043504410479043604340433047504690470047104b403e803f303f403ec03b403b303c703c803b003b203b503f303ef03f603f703340128012b013101220117012801300167012501280123013e016701340129012e0137013701220133017a01520c550cf701ed01e301180615061a061a06c106da06d306bf06a006a706a406c307d607d4079e0751066e06560621066406730673066e0673063b062106960981099209c009df0bc20bfa0bfc097709ef67a45b00964d87246c087ac3614485e45abc08bc08800887088d08bc0893088c08940818031f0337092d092309bb07bb07870780078a07bb0794078b079307d9079b04a504b104b004ab049b049001c501e901e901ed01ef01e301990a8f0a9e0ac70a890a850a850a810a830a8f0a3a013a01060101010b013a011301000117010c0103010c0100010101b901bc01b7019601be01eb09f909fe09fd09ca09fd09e909ed09fd09eb09ec09b809fd09ea09ea09f709ea09a209b809010c030c030c050c100c140c6a0c140c050c180c140c4f0c080c140c0d0c0c0c4c0c010c100c100c0c0c090c030c010c140c090c0f0c0e0c4f0c180c080c140c0d0c0c0c4b0c180c0d0c0c0c4c0c010c100c100c0c0c090c030c010c140c090c0f0c0e0c4f0c180c0d0c0c0c5b0c110c5d0c500c4e0c590c4c0c090c0d0c010c070c050c4f0c010c160c090c060c4c0c090c0d0c010c070c050c4f0c170c050c020c100c4c0c090c0d0c010c070c050c4f0c010c100c0e0c070c4c0c4a0c4f0c4a0c5b0c110c5d0c500c4e0c580c4c0c010c100c100c0c0c090c030c010c140c090c0f0c0e0c4f0c130c090c070c0e0c050c040c4d0c050c180c030c080c010c0e0c070c050c5b0c160c5d0c020c530c5b0c110c5d0c500c4e0c570c6a0c010c030c030c050c100c140c4d0c0c0c010c0e0c070c150c010c070c050c6a0c1a0c080c4d0c230c2e0c4c0c1a0c080c5b0c110c5d0c500c4e0c590c4c0c050c0e0c5b0c110c5d0c500c4e0c580c6a0c100c120c090c0f0c120c090c140c190c6a0c150c5d0c500c4c0c400c090c6a0c130c050c030c4d0c030c080c4d0c150c010c6a0c420c2e0c0f0c140c5d0c210c5f0c220c120c010c0e0c040c420c5b0c160c5d0c420c590c590c420c4c0c400c420c270c0f0c0f0c070c0c0c050c400c230c080c120c0f0c0d0c050c420c5b0c160c5d0c420c510c550c510c420c4c0c400c420c230c080c120c0f0c0d0c090c150c0d0c420c5b0c160c5d0c420c510c550c510c420c6a0c130c050c030c4d0c030c080c4d0c150c010c4d0c0d0c0f0c020c090c0c0c050c6a0c5f0c500c6a0c130c050c030c4d0c030c080c4d0c150c010c4d0c100c0c0c010c140c060c0f0c120c0d0c6a0c420c370c090c0e0c040c0f0c170c130c420c6a0c130c050c030c4d0c060c050c140c030c080c4d0c040c050c130c140c6a0c040c0f0c030c150c0d0c050c0e0c140c6a0c130c050c030c4d0c060c050c140c030c080c4d0c0d0c0f0c040c050c6a0c0e0c010c160c090c070c010c140c050c6a0c130c050c030c4d0c060c050c140c030c080c4d0c130c090c140c050c6a0c0e0c0f0c0e0c050c6a0c130c050c030c4d0c060c050c140c030c080c4d0c150c130c050c120c6a0c5f0c510c6a0c150c100c070c120c010c040c050c4d0c090c0e0c130c050c030c150c120c050c4d0c120c050c110c150c050c130c140c130c6a0c510c6a0c150c130c050c120c4d0c010c070c050c0e0c140c6a0c2d0c0f0c1a0c090c0c0c0c0c010c4f0c550c4e0c500c400c480c370c090c0e0c040c0f0c170c130c400c2e0c340c400c510c500c4e0c500c5b0c400c370c090c0e0c560c540c5b0c400c180c560c540c490c400c210c100c100c0c0c050c370c050c020c2b0c090c140c4f0c550c530c570c4e0c530c560c400c480c2b0c280c340c2d0c2c0c4c0c400c0c0c090c0b0c050c400c270c050c030c0b0c0f0c490c400c230c080c120c0f0c0d0c050c4f0c510c550c510c4e0c500c4e0c500c4e0c500c400c330c010c060c010c120c090c4f0c550c530c570c4e0c530c560cea09c4098909ea09d809d606e106e206e106f606e106f60660094c094c0948094a0946094701db0bc00bc70bdf0b870b310a770a6b0a720a730abe0ca70ce50cb80cbf0cbe0ca20ce60cbb0caa0cac0cae0c940c940ca20cbf0cae0ca60ceb0ca70ca20c68027202650266022f07110313030403190306031503ae5be59f136fbb64cc6182511a634163338a3675617d2e6454571b0c160c090c510c0c0c0b0c0a0c160c520c090c100c1b0c130c160c0c0c0b0c200c200c1d0c100c070c76046b0476046e046704230b260b330b260b6a0b280b350b2e0b200b2e0b290b260b2b0b8c04cd04c3049d0484048e04c00499048804950499048e0897089c08a70891089c08080211021a02210210021f0213021b02e002f902f202c902e602ff02f502e001f901f201c901e401f301fb01f701e401fd01e5018a019b019d019f017c086d086b0869086f086308790862087808610b640b600b640b790b23053805230536053b05370a320a280a2f0a1c0511050e0556050b050c050d05110555051b05170516050c051d0516050c05270527050c0510050d0515051a05580519055805110515051f059f0a9a0a8f0a9a0ad60a940a890a920a9c0a920a950a9a0a970ad10cdc0cc30c9b0cc60cc10cc00cdc0c980cd60cda0cdb0cc10cd00cdb0cc10cea0cea0cd10cd00cc10cd40cdc0cd90c950cdd0c840c4a02490258025702170254025c024d025802140250024d025c025402cf773f5caef49c0be80be70b9f0b9d0be952e356c3faf10585058a05f205f0051958904877f9450631063e06460644065a641e67b4fd8602f202fd0285028702a1468e6780f7b208c608c908b108b308515db969b7f98506f106fe068606840628052b053a05350575053f053e052f053a053205370576053805340535052f053e0535052f05c001d901d201e901df01d201110a080a030a380a090a060a0a0a020a93038a038103ba0395038c038603a904a404ad04b8048204b304bc04b004b804d508cc08c708fc08da08c608c208d108680b710b7a0b410b7f0b6c0b7b0b7f0b45035c0357036c03410356035e03520341035803400394058d058605bd058305810596058d0590058b0892089908a208990894088f0898089e08890892088f0802071b0710072b0717071b071a07000711071a0700072e0823083c0864083a0826082b0833082608230839083e0867083a082b0824082f082608270b2a0b350b6d0b330b220b2d0b260b2f0b6e0b2b0b260b220b270bae04b204a804af04be04b8049304bc04b004b8041801220111010b011c011f012401575824509a0480049704940483079507b5756d5d200b4307654d138c82069e069e069a066e057e056f0574056d0569053a032d033e036c033c0320032d03350329033e0313032d032d032d032d03130314030a03cd07d907c407c607d807ee06f206ff06e706ed060306030603068b0792079907a2078d0791079c078407a20788078f0791077e0667066c065706780664066906710657066e067a06670665064c07490753075407c302210538057a052705200521053d0579053c05310535053005310526050b050b05390531053a052105740538053d0574053505a703bd03aa03a9034b7d0f571f57be9376727b55e263ee915b6cf278dd09d009d909cc09f609c009cd09590654065d064806720643064c0640064806470748074d075507440753075207f204fd04f004e204e204e102f802ba02e702e002e102fd02b902e202fb02f002f802fd02e702e002fb07f607e907b107ec07eb07ea07f607b207e907f007fb07f307f607ec07eb07c007c007fd07f007e707dc0ac10adc0ac40acd0a720c770c620c770c3b0c790c640c7f0c710c7f0c780c770c7a0cc00781078f07d107c807c2078c07d507c407d907d5078d0594059f05a40592059f05c003d903d203e903d803d703db03d3037d0364036f0354037b0362036803fa0ae30ae80ad30afe0ae90ae10aed0afe0ae70aff0a8702820298029f021208080815080408340813080d082701380135017e01280135017f012101390121016e01240123013d016c0165047a0477043c0463047f046a0461043c046504610421043d0463047b0463042c04660461047f042e048c0293029e02d5028e028302ce02d4028a0292028a02c5028f0288029602c702d006d506de06ff06d706b903b903ba037d0a7a0a640ad65c2d4a0555bd05ad05bc05a705be05ba05410956094509170947095b0956094e09520945096809970283029e029c029c08c2088408c908160621062206210636062106360669096c09630960096c09660978095608740861087208770877087a0834082e0835082b083b08330843082a082a0820083b085708720875086e0863083b087a087a086908780873082d082f0832083b085a086b086b0877087e084c087e087908500872086f0834082e0828082c08350828082d083b083308500853084f085608570837083b087708720870087e083b085c087e0878087008740832083b08580873086908740876087e0834082a082f08230835082b0835082b0835082b083b0848087a087d087a086908720834082e0828082c08350828082d0872095409420955090a0966094009420949095309a10abc0af80a370637062e062e06de06dc06dd06dd06e209f209ef091a0a140a0f0a0f0ac407c807d3072f0b2c0b660b660ba905b405e105e805e90559085e0840085f0816080c080b0804080208060805080b0868066506780c370c3a0c630c250c220c2f0c03054b054c054105180531063206230634063f06c809cb09da09cd09c609f2098609890986098009840991098709890979097d093d0950045d044804cb08dc08cf089d08cb08d408d9089d0880089d089f0895089308970894089f08fb07fc07e207fd07b407ae07ac07a607a007a407a707ac072207bd0cb00c960ca70cac0cbe0cf80c2f0a3e0a2d0a2c0a3a0a0a0a2d0a330a7d0a650add04cc04df04de04c804f804df04c1048f0497048f04850483048704920484048f0480099a099709d109c909d109db09dd09d909cc09da09d109fa08a308f408f308ed08a308bb08a308a408f208a308ad08a308f208e808e508a308bb08a308a408f208a308fc088f0b880b820b830b9e0bc80b960b8e0b960bc90b870b8c0b870b9e0bc90b950b930b810b810b830b950b920bd90b8b0b8f0b820bdb0bd70bc00b910b820bdb0b320678067d0679067d066006290625062406320660067d067906710667066006750679066406290655064e06550640064d067704720468046f04c5058e058f059e058b0583058605c50559045404620b240b380b210b200bc002cf02c302cb02110a080a020a56054f0544057f054905440544075d0756076d075c0753075f075707eb08f208f908c208ed08f408fe0872036b0360035b03760361036903650376036f037703");
    private String Dr;
    private String O = \ufea1\u0645\u062b\u0634.\u0638\ufec9\u0630\ufe95(Libvio.\ufee9\u064a\ufec5\u0627(), 0, 22, 2711);
    private String Zm;
    private String b;
    private JSONObject g1;
    private Pattern n;
    private Pattern s = \ufea9\ufe8f\u0647\ufead.\u0646\ufedd\u0634\ufed9(\ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(Libvio.\ufee9\u064a\ufec5\u0627(), 22, 16, 1053));
    private String un;

    /*
     * Enabled aggressive block sorting
     */
    public Libvio() {
        this.n = \ufea9\ufe8f\u0647\ufead.\u0646\ufedd\u0634\ufed9(\u0641\ufeb5\ufeb1\ufee1.\u0639\u0630\ufeaf\ufe95(Libvio.\ufee9\u064a\ufec5\u0627(), 38, 16, 923));
        this.un = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
        int n = \u062b\u064a\ufecd\u0642.\ufea9\ufec5\ufec1\ufec9();
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
                    n2 = Integer.parseInt(\ufeab\u0632\u062f\u0640.\ufeb5\u0630\u0648\ufe8f("nBS0qkEcjRVlTChes2UTDoj74GY"));
                    System.out.println(n2);
                    return;
                }
                case 239: 
            }
            break;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String B(Pattern object, String string) {
        boolean bl;
        String string2;
        int n = 1616;
        block15: while (true) {
            string2 = string;
            switch (n ^= 0x661) {
                default: {
                    continue block15;
                }
                case 49: {
                    if (object == null) {
                        n = 1709;
                        continue block15;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block15;
                }
                case 239: {
                    object = \u0646\ufecd\ufead\u0647.\u0635\ufec1\u0640\u0632(object, string);
                    bl = \u0631\u0640\ufec1\ufee9.\u0643\u0639\ufec1\u062f(object);
                    n = 1740;
                    break block15;
                }
                case 204: {
                    return string2;
                }
            }
            break;
        }
        block16: while (true) {
            string2 = string;
            switch (n ^= 0x6DD) {
                default: {
                    continue block16;
                }
                case 17: {
                    if (bl) {
                        n = 1833;
                        continue block16;
                    }
                }
                case 54: {
                    n = 1802;
                    continue block16;
                }
                case 500: {
                    return \ufe99\u062e\u0642\u0644.\u062d\ufead\u0644\ufec5(\u062d\u062e\ufe8e\u0645.\u0640\ufec1\u0632\ufed9(object, 1));
                }
                case 471: 
            }
            break;
        }
        return string2;
        catch (Exception exception) {
            Libvio.\u062b\u0648\ufe99\ufebd(exception);
            return string;
        }
    }

    /*
     * Exception decompiling
     */
    private String F5(String var1_1) {
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
    private String G(String string, String string2) {
        int n;
        StringBuilder stringBuilder = new StringBuilder();
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, \ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(Libvio.\ufee9\u064a\ufec5\u0627(), 107, 4, 2528));
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, string2);
        int n2 = \ufe9d\ufeab\u062e\u0640.\u0627\ufea5\u062e\ufea9(string, \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(stringBuilder));
        int n3 = 1616;
        block42: while (true) {
            n = n2;
            switch (n3 ^= 0x661) {
                default: {
                    continue block42;
                }
                case 49: {
                    if (n2 < 0) {
                        n3 = 1709;
                        continue block42;
                    }
                }
                case 14: {
                    n3 = 1678;
                    continue block42;
                }
                case 204: {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder2, string2);
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder2, \ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(Libvio.\ufee9\u064a\ufec5\u0627(), 111, 2, 3071));
                    n = \ufe9d\ufeab\u062e\u0640.\u0627\ufea5\u062e\ufea9(string, \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(stringBuilder2));
                    break block42;
                }
                case 239: 
            }
            break;
        }
        n3 = 1740;
        block43: while (true) {
            n2 = n;
            switch (n3 ^= 0x6DD) {
                default: {
                    continue block43;
                }
                case 17: {
                    if (n < 0) {
                        n3 = 1833;
                        continue block43;
                    }
                }
                case 54: {
                    n3 = 1802;
                    continue block43;
                }
                case 500: {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder3, string2);
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder3, \u0630\ufebd\u0634\ufec9.\u0639\ufe8f\u064a\ufebd(Libvio.\ufee9\u064a\ufec5\u0627(), 113, 1, 3015));
                    n2 = \ufe9d\ufeab\u062e\u0640.\u0627\ufea5\u062e\ufea9(string, \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(stringBuilder3));
                    break block43;
                }
                case 471: 
            }
            break;
        }
        string2 = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
        n3 = 1864;
        block44: while (true) {
            switch (n3 ^= 0x759) {
                default: {
                    continue block44;
                }
                case 17: {
                    if (n2 < 0) {
                        n3 = 48736;
                        continue block44;
                    }
                }
                case 47483: {
                    n3 = 48705;
                    continue block44;
                }
                case 47417: {
                    return string2;
                }
                case 47384: 
            }
            break;
        }
        String string3 = \ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(Libvio.\ufee9\u064a\ufec5\u0627(), 114, 1, 2526);
        n = \ufe8e\ufec1\u0641\u0644.\u0645\ufed9\ufedd\u0641(string, string3, n2);
        String string4 = \u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(Libvio.\ufee9\u064a\ufec5\u0627(), 115, 1, 2384);
        n3 = 48767;
        block45: while (true) {
            switch (n3 ^= 0xBE90) {
                default: {
                    continue block45;
                }
                case 239: {
                    if (n < 0) {
                        n3 = 48860;
                        continue block45;
                    }
                }
                case 14: {
                    n3 = 48829;
                    continue block45;
                }
                case 76: {
                    n = \ufe8e\ufec1\u0641\u0644.\u0645\ufed9\ufedd\u0641(string, string4, n2);
                    break block45;
                }
                case 45: 
            }
            break;
        }
        n3 = 48891;
        block46: while (true) {
            switch (n3 ^= 0xBF0C) {
                default: {
                    continue block46;
                }
                case 503: {
                    if (n < 0) {
                        n3 = 49635;
                        continue block46;
                    }
                }
                case 22: {
                    n3 = 48953;
                    continue block46;
                }
                case 32495: {
                    return string2;
                }
                case 53: 
            }
            break;
        }
        int n4 = n + 1;
        n2 = \ufe8e\ufec1\u0641\u0644.\u0645\ufed9\ufedd\u0641(string, string3, n4);
        n3 = 49666;
        block47: while (true) {
            n = n2;
            switch (n3 ^= 0xC213) {
                default: {
                    continue block47;
                }
                case 17: {
                    if (n2 < 0) {
                        n3 = 49759;
                        continue block47;
                    }
                }
                case 50: {
                    n3 = 49728;
                    continue block47;
                }
                case 76: {
                    n = \ufe8e\ufec1\u0641\u0644.\u0645\ufed9\ufedd\u0641(string, string4, n4);
                    break block47;
                }
                case 83: 
            }
            break;
        }
        n3 = 49790;
        block48: while (true) {
            switch (n3 ^= 0xC28F) {
                default: {
                    continue block48;
                }
                case 241: {
                    if (n < 0) {
                        n3 = 49883;
                        continue block48;
                    }
                }
                case 18: {
                    n3 = 49852;
                    continue block48;
                }
                case 84: {
                    return string2;
                }
                case 51: 
            }
            break;
        }
        return \u0636\u0634\ufec1\u0631.\u0647\u0627\u0635\ufeed(string, n4, n);
    }

    /*
     * Exception decompiling
     */
    private String dT(String var1_1) {
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
    private String q(String string) {
        boolean bl = \ufeed\ufebd\u0635\ufedd.\u0637\ufe8e\ufee1\ufebd(string);
        int n = 1616;
        block38: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block38;
                }
                case 49: {
                    if (bl) {
                        n = 1709;
                        continue block38;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block38;
                }
                case 204: {
                    return \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
                }
                case 239: 
            }
            break;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = 0;
        block39: while (true) {
            int n3 = \u0631\u063a\u0645\u0641.\u0631\u063a\u0645\u0641(string);
            n = 1740;
            block40: while (true) {
                switch (n ^= 0x6DD) {
                    default: {
                        continue block40;
                    }
                    case 17: {
                        if (n2 < n3) {
                            n = 1833;
                            continue block40;
                        }
                    }
                    case 54: {
                        n = 1802;
                        continue block40;
                    }
                    case 500: {
                        char c = \u0635\u0631\u0645\u0628.\u0643\u0637\ufeb1\ufead(string, n2);
                        n = 1864;
                        block41: while (true) {
                            switch (n ^= 0x759) {
                                default: {
                                    continue block41;
                                }
                                case 17: {
                                    if (c == '\\') {
                                        n = 48736;
                                        continue block41;
                                    }
                                }
                                case 47483: {
                                    n = 48705;
                                    continue block41;
                                }
                                case 47417: {
                                    n3 = n2 + 1;
                                    int n4 = \u0631\u063a\u0645\u0641.\u0631\u063a\u0645\u0641(string);
                                    n = 48767;
                                    block42: while (true) {
                                        switch (n ^= 0xBE90) {
                                            default: {
                                                continue block42;
                                            }
                                            case 239: {
                                                if (n3 < n4) {
                                                    n = 48860;
                                                    continue block42;
                                                }
                                            }
                                            case 14: {
                                                n = 48829;
                                                continue block42;
                                            }
                                            case 76: {
                                                n3 = \u0635\u0631\u0645\u0628.\u0643\u0637\ufeb1\ufead(string, n3);
                                                n = 48891;
                                                block43: while (true) {
                                                    switch (n ^= 0xBF0C) {
                                                        default: {
                                                            continue block43;
                                                        }
                                                        case 503: {
                                                            if (n3 == 117) {
                                                                n = 49635;
                                                                continue block43;
                                                            }
                                                        }
                                                        case 22: {
                                                            n = 48953;
                                                            continue block43;
                                                        }
                                                        case 32495: {
                                                            n3 = n2 + 6;
                                                            \ufeaf\u0633\u0648\ufee9.\u0627\u062c\u062d\u062a(stringBuilder, (char)\ufe95\u0627\ufe8e\u0644.\ufe8f\ufeb1\u0648\ufec1(\u0636\u0634\ufec1\u0631.\u0647\u0627\u0635\ufeed(string, n2 + 2, n3), 16));
                                                            n = 49666;
                                                            block44: while (true) {
                                                                switch (n ^= 0xC213) {
                                                                    default: {
                                                                        continue block44;
                                                                    }
                                                                    case 17: {
                                                                        n = 49697;
                                                                        continue block44;
                                                                    }
                                                                    case 50: 
                                                                }
                                                                break;
                                                            }
                                                            n2 = n3;
                                                            continue block39;
                                                        }
                                                        case 53: 
                                                    }
                                                    break;
                                                }
                                            }
                                            case 45: 
                                        }
                                        break;
                                    }
                                    break block41;
                                }
                                case 47384: 
                            }
                            break;
                        }
                        \ufeaf\u0633\u0648\ufee9.\u0627\u062c\u062d\u062a(stringBuilder, c);
                        n3 = n2 + 1;
                        n = 49790;
                        block45: while (true) {
                            n2 = n3;
                            switch (n ^= 0xC28F) {
                                case 18: {
                                    continue block39;
                                }
                                default: {
                                    continue block45;
                                }
                                case 241: 
                            }
                            n = 49821;
                        }
                    }
                    case 471: 
                }
                break;
            }
            break;
        }
        return \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(stringBuilder);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0627\ufef1\u062e\ufeb5(Object object) {
        int n = \ufeb9\ufec9\u0648\u062d.\u063a\u064a\ufed9\ufe8f();
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
                    return ((ResponseBody)object).string();
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
     * Unable to fully structure code
     */
    public static void \u062b\u0648\ufe99\ufebd(Object var0) {
        var2_1 = \ufeb9\ufec9\u0648\u062d.\u063a\u064a\ufed9\ufe8f();
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
                    SpiderDebug.log((Throwable)((Throwable)var0));
lbl16:
                    // 2 sources

                    while (true) {
                        var2_1 = \u062a\ufee1\ufe8e\ufeb9.\u062e\ufeb9\u0644\ufedd();
                        var1_2 = 1740;
                        block19: while (true) {
                            switch (var1_2 ^= 1757) {
                                default: {
                                    continue block19;
                                }
                                case 17: {
                                    if (var2_1 >= 0) {
                                        var1_2 = 1833;
                                        continue block19;
                                    }
                                }
                                case 54: {
                                    var1_2 = 1802;
                                    continue block19;
                                }
                                case 500: {
                                    var1_2 = Integer.parseInt(\u0646\ufecd\ufead\u0647.\ufe8f\ufed9\ufeaf\u0639("12"));
                                    System.out.println(var1_2);
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
    public static String \u062e\u063a\ufeb5\u0634(Object object, Object object2) {
        int n = \u0646\ufecd\ufead\u0647.\u0631\u0642\u062d\u064a();
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
                    return Libvio.B((Pattern)object, (String)object2);
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
    public static ResponseBody \u062f\ufe8f\u0630\ufed5(Object object) {
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
                    return ((Response)object).body();
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
    public static Response \u0631\ufea5\u0646\u0630(Object object, Object object2, Object object3, int n) {
        int n2 = \u0636\u0634\ufec1\u0631.\u0648\ufedd\ufeb5\ufed9();
        int n3 = 1616;
        block10: while (true) {
            switch (n3 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n2 > 0) {
                        n3 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n3 = 1678;
                    continue block10;
                }
                case 204: {
                    return w2.v3((String)object, (Map)object2, (Map)object3, n);
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
    public static String \u0632\ufea9\ufe99\ufe9d(Object object) {
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
                    return ((Libvio)((Object)object)).O;
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
    public static String \u0633\u062d\u0630\ufe99(Object object, Object object2) {
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
                    return ((Libvio)((Object)object)).dT((String)object2);
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
    public static String \u0633\ufeb5\u0628\u0646(Object object, Object object2, Object object3) {
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
                    return ((Libvio)((Object)object)).G((String)object2, (String)object3);
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
    public static String \u0634\ufe8f\ufedd\u0636(Object object) {
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
                    return ((Libvio)((Object)object)).un;
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
    public static String \u0638\u062f\ufeaf\ufe8f(Object object) {
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
                    return ((Libvio)((Object)object)).Dr;
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
    public static Pattern \u063a\ufea5\u0633\u0643(Object object) {
        int n = \u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648();
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
                    return ((Libvio)((Object)object)).n;
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
    public static void \u0644\u0628\u0647\ufef1(Object object) {
        int n = \ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5();
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
                    SpiderDebug.log((String)((String)object));
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
    public static Response \ufea1\ufeb1\u0630\u0632(Object object, Object object2) {
        int n = \u0631\u0640\ufec1\ufee9.\ufe95\ufed5\u0643\u0628();
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
                    return w2.Gc((String)object, (Map)object2);
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
    public static String \ufea5\ufed9\u0639\u0646(Object object) {
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
                    return ((Libvio)((Object)object)).Zm;
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
    public static void \ufeb9\ufead\u064a\u0636(Object object) {
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
                    ((Response)object).close();
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
    public static Pattern \ufec5\ufecd\ufead\ufeaf(Object object) {
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
                    return ((Libvio)((Object)object)).s;
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
    public static String \ufed5\ufeab\u064a\ufebd(Object object, Object object2) {
        int n = \ufe99\u062c\u0643\ufec1.\ufec5\ufee9\ufe8e\ufea1();
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
                    return ((Libvio)((Object)object)).q((String)object2);
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
    public static HashMap \ufee1\u062d\u0644\ufeb1(Object object, Object object2) {
        int n = \ufebd\u0640\u0648\u062b.\u0633\u0637\u0632\ufeab();
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
                    return ((Libvio)((Object)object)).G4((String)object2);
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
    public static short[] \ufee9\u064a\ufec5\u0627() {
        int n = \u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead();
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
    public static JSONObject \ufee9\ufeb1\u0645\u0635(Object object) {
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
                    return ((Libvio)((Object)object)).g1;
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
    public static String \ufeed\ufebd\u0633\u062b(Object object) {
        int n = \ufeb5\ufe8e\ufead\u0632.\ufe95\u0647\u062d\u0631();
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
                    return ((Libvio)((Object)object)).b;
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
    public static String \ufef1\u0630\ufea9\u062a(Object object, Object object2) {
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
                    return ((Libvio)((Object)object)).F5((String)object2);
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
     * Exception decompiling
     */
    protected final HashMap<String, String> G4(String var1_1) {
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
    public String categoryContent(String var1_1, String var2_3, boolean var3_4, HashMap<String, String> var4_5) {
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
    @Override
    public String detailContent(List<String> var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 16[TRYBLOCK] [16 : 2109->2171)] java.lang.Exception
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
     * Exception decompiling
     */
    @Override
    public void init(Context var1_1, String var2_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [13[CASE]], but top level block is 2[TRYBLOCK]
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

    /*
     * Exception decompiling
     */
    public String searchContent(String var1_1, boolean var2_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 6[TRYBLOCK] [6 : 780->800)] java.lang.Exception
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

    private static long[] $d2j$hex$3b0c28e1$decode_J(String src) {
        byte[] d = Libvio.$d2j$hex$3b0c28e1$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$3b0c28e1$decode_I(String src) {
        byte[] d = Libvio.$d2j$hex$3b0c28e1$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$3b0c28e1$decode_S(String src) {
        byte[] d = Libvio.$d2j$hex$3b0c28e1$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$3b0c28e1$decode_B(String src) {
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

