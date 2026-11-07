/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.catvod.crawler.Spider
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import com.github.catvod.crawler.Spider;
import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\u0638\ufead\u062e\ufee1;
import com.github.catvod.parser.\u0645\u0641\u0630\u062d;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufe9d\u0631\ufe8f\u064a;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.parser.\ufec1\u0636\u062d\u0638;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\u0641\u0631\ufeed\u0643;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufebd\u0640\u0648\u062b;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.merge.\ufee9\ufee1\u0627\u0641;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0636\u0634\ufec1\u0631;
import com.github.catvod.spider.\ufe8e\u0627\ufecd\u062a;
import com.github.catvod.spider.\ufe8e\ufeb9\u0647\u0642;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class DouDou
extends Spider {
    private static final short[] short = DouDou.$d2j$hex$1a2c7867$decode_S("a303200a3c0a210a270a6c0b4b0b570b500bcc0bd80bc50bce0bc50b840bce0bc50bdf0bc80bcb0bc40b840bc90bc50bc70ba2028e028f028f0284028202950288028e028f02a2068c068c069906c406a806850680069f068c065c026b0268026b027c026b027c02730a6f0a6f0a6b0a680a210a340a340a680a7e0a690a6d0a720a780a7e0a6c0a7e0a780a730a7a0a6f0a350a780a740a760a340a6c0a630a290a7d0a220a790a2b0a2d0a780a2a0a7f0a7e0a2a0a780a780a7d0a780a7a0a340a230a2f0a340a6b0a7a0a7c0a7e0a360a7d0a690a7a0a760a7e0a350a730a6f0a760a770a2c010a011c010b01540138011e011c0117010d017b0459044c045f045a045a045704190403041804060416041e0461045f045804520459044104450416047804620416040004180407040d041604610479046104000402041f0416047704460446045a0453046104530454047d045f044204190403040504010418040504000416041e047d047e0462047b047a041a0416045a045f045d04530416047104530455045d0459041f04160475045e04440459045b045304190403040504180406041804040401040e04030418040704020405041604650457045004570444045f04190403040504010418040504000416047b045f045504440459047b0453044504450453045804510453044404190401041804060418040f041804030406040704160478045304420462044f0446045304190461047f0470047f0416047b045f0458045f046604440459045104440457045b04730458044004190461045f0458045204590441044504160461045f04580452045904410445046104530455045e0457044204c002d302c402c002ec05f005ed05eb05a1032d073007210729073707dc0ac70ac00ad80af00ac70ac00adb0a490c4b0c620c550c520c490c78096b096409610955096609630979097e0955097e097c090f070d077d067a0661064a06720674067c067406d106c206cd06c806fc06cf06ca06d006d706fc06ce06cc06d506ca06c606aa0ba70bae0bbb0b1b0b5e0b520b480b530b490b000b0f0b0d0ba20cf70cf00ce50cf60cf00cb90cc60a970a950ac20ac20a970a930ac60ac70ac00ac20acf0ac60a920a940ac40ac40ac60ac20a950a930ac60a970ac60ac20ac40a920a940ac40acf0ac70ac00a7b063d0620063106390627066b06350624063d063f0631062d0669065a02460246024202410208021d021d02540240025d0256025d021c0256025d024702500253025c021c0251025d025f021d02530242025b021d02440200021d0241024702500258025702510246026d0251025d025e025e025702510246025b025d025c021d02f902ab02be02b802ac02e2029f6b56511d0401040104050406044f045a045a04130407041a0411041a045b0411041a040004170414041b045b0416041a0418045a04140405041c045a04030447045a0418041a0403041c0410045a040704100416041a041804180410041b0411044a04140405041c041e0410040c044804450414041604410441041404100445044404430441044c04450411041704470447044504410416041004450414044504410447041104170447044c0444044304530406041a0407040104480481038303aa038703900394039903aa0381039c0398039003aa039d039a038103900386038103a207a007b907a607aa079007bd07aa07ae07a3079007bb07a607a207aa079007a707a007bb07aa07bc07bb07c809d409d409d009d3099a098f098f09c609d209cf09c409cf098e09c409cf09d509c209c109ce098e09c309cf09cd098f09c109d009c9098f09d60992098f09d409d6098f09d209c509c309cf09cd09cd09c509ce09c4099f09c109d009c909cb09c509d9099d099009c109c30994099409c109c509900991099609940999099009c409c2099209920990099409c309c5099009c109900994099209c409c20992099909910996098609d309cf09d209d4099d09c805ce05d905d105de05d805cf05e405d805d405d705d705de05d805cf05d205d405d505e405d205cf05de05d605c80528073f0739073507370737073f0734073e07c05040917f0938092b093c0938096409f001ec01ec01e801eb01a201b701b701fe01ea01f701fc01f701b601fc01f701ed01fa01f901f601b601fb01f701f501b701f901e801f101b701ee01aa01b701f501f701ee01f101fd01b701f001f701ec01c701ff01f901f101f901a701f901e801f101f301fd01e101a501a801f901fb01ac01ac01f901fd01a801a901ae01ac01a101a801fc01fa01aa01aa01a801ac01fb01fd01a801f901a801ac01aa01fc01fa01aa01a101a901ae01be01eb01f701ea01ec01a501d703ca03d703cf03c603da03c603cb03d303c603c303d903de03a90bac0bcb05d205d805620963097e0961096d096009c208d008e708e408e708f008e708f008bf08ea08f608f608f208f108b808ad08ad08e308f208eb08ac08e608ed08f708e008e308ec08ac08e108ed08ef08ad08c208d708f108e708f008af08c308e508e708ec08f608bf08cf08ed08f808eb08ee08ee08e308ad08b708ac08b208a208aa08d508eb08ec08e608ed08f508f108a208cc08d608a208b308b208ac08b208b908a208d508eb08ec08b408b608b908a208fa08b408b608ab08a208c308f208f208ee08e708d508e708e008c908eb08f608ad08b708b108b508ac08b108b408a208aa08c908ca08d608cf08ce08ae08a208ee08eb08e908e708a208c508e708e108e908ed08ab08a208c108ea08f008ed08ef08e708ad08b308b308b208ac08b208ac08b208ac08b208a208d108e308e408e308f008eb08ad08b708b108b508ac08b108b408e58e27573bfa5506460653064e0649064006cc06db06d606cf06df06270639062f062b063806290622067006690669066906f20bf20bf20b290c300c3b0c000c360c3b0c23023a0231020a023b02340238023002cb04d204d904e204cd04d404de0414070d0706073d07100707070f0703071007090711075703460340034203440348035203490353030601030119011e019a0b970b9e0b8b0bb10b800b8f0b830b8b0b5c08510858084d08770841084c087a027d0266024d02750273027b0273020f714f65d774935e160214023d020a020d0216028075c0610a57ab93b806a306a406bc069406a306a406bf06df759f61ce7b4887a401a601bf01a001ac01af71eb5bc17f9394670765075f79ac853177639c100103010c0109013d010e010b01110116013d010f010d0114010b0107019c77d85d356bfc51c304d004df04da04ee04dd04d804c204c504ee04c504c704c8743b889a536168a852690775077507710772073b072e072e07670773076e0765076e072f0765076e077407630760076f072f0762076e076c072e076007710768072e07770733072e077207740763076b076407620775075e0762076e076d076d0764076207750768076e076f072e077207740763076b076407620775075e077307640760076d075e07750768076c0764075e0769076e0775076407720775072e076807750764076c0772073e076007710768076a07640778073c0731076007620735073507600764073107300737073507380731076507630733073307310735076207640731076007310735073307650763073307380730073707b703b103a603ae03a103a703b0039b03a703ab03a803a803a103a703b003ad03ab03aa039b03ad03b003a103a903b703a207af07a607b3074503580345035d035403f209ee09e309fb09ee09eb09f109f609210724071f0206020c026c0c6d0c700c6f0c630c6e0c570b450b720b710b720b650b720b650b2a0b7f0b630b630b670b640b2d0b380b380b760b670b7e0b390b730b780b620b750b760b790b390b740b780b7a0b380b570b420b640b720b650b3a0b560b700b720b790b630b2a0b5a0b780b6d0b7e0b7b0b7b0b760b380b220b390b270b370b3f0b400b7e0b790b730b780b600b640b370b590b430b370b260b270b390b270b2c0b370b400b7e0b790b210b230b2c0b370b6f0b210b230b3e0b370b560b670b670b7b0b720b400b720b750b5c0b7e0b630b380b220b240b200b390b240b210b370b3f0b5c0b5f0b430b5a0b5b0b3b0b370b7b0b7e0b7c0b720b370b500b720b740b7c0b780b3e0b370b540b7f0b650b780b7a0b720b380b260b260b270b390b270b390b270b390b270b370b440b760b710b760b650b7e0b380b220b240b200b390b240b210b3607250730072d072a072307af04b804b504ac04bc049b0182018901b20183018c018001880146055f0554056f05400559055305cb02d202d902e202cf02d802d002dc02cf02d602ce02ab07a407a907bb07bb07c609c909cc09d409c509d209d309b009b509af09a809");

    /*
     * Enabled aggressive block sorting
     */
    public DouDou() {
        int n = \ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640();
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
                    Long l = Long.decode(\ufeaf\ufea5\ufeab\u062e.\u0633\ufecd\ufeb1\u062c("ghnS9qO3EM0roCabpMyomx0c0e"));
                    System.out.println(l);
                    return;
                }
                case 239: 
            }
            break;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String SN(HashMap<String, String> object) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            Iterator iterator = \ufeb1\ufe8e\ufee1\ufe9d.\u062e\u0644\u062a\u0628(\u0631\ufea1\u0638\u0627.\ufeab\u0643\u0645\ufee1(object));
            block25: while (true) {
                String string;
                boolean bl = \ufe8e\u0627\ufecd\u062a.\u062f\u0638\ufe8e\ufe99(iterator);
                String string2 = \ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(DouDou.\u0634\ufeb1\u0636\u0630(), 0, 1, 911);
                int n = 1616;
                block26: while (true) {
                    switch (n ^= 0x661) {
                        default: {
                            continue block26;
                        }
                        case 49: {
                            if (bl) {
                                n = 1709;
                                continue block26;
                            }
                        }
                        case 14: {
                            n = 1678;
                            continue block26;
                        }
                        case 204: {
                            string = (String)\ufea1\u0645\u062b\u0634.\ufe95\ufeaf\ufeb9\ufea1(iterator);
                            bl = \u062b\ufec1\ufeb1\u062d.\ufea9\u0628\u0637\ufe95(string, \ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(DouDou.\u0634\ufeb1\u0636\u0630(), 1, 4, 2643));
                            n = 1740;
                            break block26;
                        }
                        case 239: {
                            return \ufea9\ufe8f\u0647\ufead.\ufed5\u0636\u064a\ufeab(stringBuilder, 0, \ufebd\u0640\u0648\u062b.\ufebd\u062d\u0633\ufeaf(stringBuilder, string2));
                        }
                    }
                    break;
                }
                block27: while (true) {
                    switch (n ^= 0x6DD) {
                        default: {
                            continue block27;
                        }
                        case 17: {
                            if (bl) {
                                n = 1833;
                                continue block27;
                            }
                        }
                        case 54: {
                            n = 1802;
                            continue block27;
                        }
                        case 500: {
                            n = 1864;
                            block28: while (true) {
                                switch (n ^= 0x759) {
                                    case 47483: {
                                        continue block25;
                                    }
                                    default: {
                                        continue block28;
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
                \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, (String)\u0641\u0631\ufeed\u0643.\ufedd\u0631\ufebd\u062d(object, string));
                \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, string2);
                n = 48767;
                block29: while (true) {
                    switch (n ^= 0xBE90) {
                        case 14: {
                            continue block25;
                        }
                        default: {
                            continue block29;
                        }
                        case 239: 
                    }
                    n = 48798;
                }
                break;
            }
        }
        catch (Exception exception) {
            \ufed9\ufe8e\u062d\ufead.\u062b\ufe8e\u062d\u0645(exception);
            return \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
        }
    }

    private Map<String, String> yq() {
        String string = "\u06df\u06e5\u06e3";
        HashMap hashMap = null;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        short[] sArray = null;
        block21: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    string3 = \ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644(sArray, 125, 184, 1078);
                    string = "\u06e0\u06e4\u06e0";
                    continue block21;
                }
                case 1746907: {
                    sArray = DouDou.\u0634\ufeb1\u0636\u0630();
                    string = "\u06e2\u06e1\u06e4";
                    continue block21;
                }
                case 1747839: {
                    string2 = \ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(sArray, 9, 16, 2986);
                    string = "\u06df\u06e6\u06e2";
                    continue block21;
                }
                case 1747804: {
                    \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, string4, string3);
                    string = "\u06df\u06e1\u06e1";
                    continue block21;
                }
                case 1746877: {
                    sArray = DouDou.\u0634\ufeb1\u0636\u0630();
                    string = "\u06e0\u06e1\u06e1";
                    continue block21;
                }
                case 1754441: {
                    sArray = DouDou.\u0634\ufeb1\u0636\u0630();
                    string = "\u06e1\u06e2\u06e4";
                    continue block21;
                }
                case 1751529: {
                    sArray = DouDou.\u0634\ufeb1\u0636\u0630();
                    string = "\u06e5\u06e1\u06e1";
                    continue block21;
                }
                case 1751497: {
                    string4 = \ufeb9\u0643\ufed9\ufed5.\u0628\u062f\ufea1\u0642(sArray, 115, 10, 377);
                    string = "\u06e6\u06e1\u06e8";
                    continue block21;
                }
                case 1752462: {
                    sArray = DouDou.\u0634\ufeb1\u0636\u0630();
                    string = "\u06e0\u06e5\u06e4";
                    continue block21;
                }
                case 1753485: {
                    sArray = DouDou.\u0634\ufeb1\u0636\u0630();
                    string = "\u06e0\u06e7\u06e1";
                    continue block21;
                }
                case 1748707: {
                    string5 = \u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(sArray, 45, 7, 526);
                    string = "\u06e4\u06e0\u06e5";
                    continue block21;
                }
                case 1752707: {
                    \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, string5, string2);
                    string = "\u06e8\u06e5\u06e0";
                    continue block21;
                }
                case 1755523: {
                    sArray = DouDou.\u0634\ufeb1\u0636\u0630();
                    string = "\u06e4\u06df\u06e4";
                    continue block21;
                }
                case 1747712: {
                    string5 = \u0645\u0641\u0630\u062d.\u0642\u062a\u0630\ufebd(sArray, 5, 4, 2852);
                    string = "\u06e5\u06df\u06e8";
                    continue block21;
                }
                case 56570: {
                    sArray = DouDou.\u0634\ufeb1\u0636\u0630();
                    string = "\u06e8\u06e1\u06e0";
                    continue block21;
                }
                case 1746752: {
                    hashMap = \ufe9d\u0631\ufe8f\u064a.\u0637\u0633\ufeb1\u063a(string5, string2, string4, string3);
                    string = "\u06e7\u06e1\u06e3";
                    continue block21;
                }
                case 1755399: {
                    string3 = \ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(sArray, 35, 10, 1769);
                    string = "\u06df\u06e1\u06e2";
                    continue block21;
                }
                case 1749637: {
                    string4 = \ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(sArray, 25, 10, 737);
                    string = "\u06e8\u06e2";
                    continue block21;
                }
                case 1752517: {
                    string2 = \ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(sArray, 52, 63, 2587);
                    string = "\u06e5\u06e7\u06e5";
                    continue block21;
                }
                case 1746751: 
            }
            break;
        }
        return hashMap;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static short[] \u0634\ufeb1\u0636\u0630() {
        int n = \ufeab\u0632\u062f\u0640.\u062e\u0636\ufe8e\u063a();
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
    public static Map \u0646\ufe95\ufea1\ufec5(Object map) {
        int n = \u0633\u064a\u0644\u0637.\ufec1\u062e\u0643\ufedd();
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
                    return ((DouDou)((Object)map)).yq();
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
    public static String \u064a\u0646\u062c\u0641(Object object, Object object2) {
        int n = \u0638\ufead\u062e\ufee1.\ufeab\u062a\u062d\u063a();
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
                    return ((DouDou)((Object)object)).SN((HashMap)object2);
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
    public String categoryContent(String var1_1, String var2_4, boolean var3_6, HashMap<String, String> var4_7) {
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
     * Could not resolve type clashes
     */
    public String homeContent(boolean var1_1) {
        var8_2 = \ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(DouDou.\u0634\ufeb1\u0636\u0630(), 1108, 9, 3054);
        var7_3 = \ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(DouDou.\u0634\ufeb1\u0636\u0630(), 1117, 7, 2088);
        var5_4 /* !! */  = new JSONObject();
        var5_4 /* !! */  = \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(\u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(var5_4 /* !! */ , var7_3, \u062d\u062e\ufe8e\u0645.\u062d\ufeab\u0642\u0647(DouDou.\u0634\ufeb1\u0636\u0630(), 1124, 8, 530)), var8_2, \ufeab\u0632\u062f\u0640.\u062f\u0627\ufe95\u0631(DouDou.\u0634\ufeb1\u0636\u0630(), 1132, 4, 482));
        var6_6 = new JSONObject();
        var6_6 = \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(\u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(var6_6, var7_3, \ufea5\u062d\ufebd\u0633.\ufea5\ufeb1\u0643\ufe8f(DouDou.\u0634\ufeb1\u0636\u0630(), 1136, 6, 610)), var8_2, \ufea5\u062d\ufebd\u0633.\ufea5\ufeb1\u0643\ufe8f(DouDou.\u0634\ufeb1\u0636\u0630(), 1142, 4, 1389));
        var9_7 = new JSONObject();
        var9_7 = \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(\u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(var9_7, var7_3, \ufea9\u0643\u062d\u063a.\ufea1\u0633\ufe8e\u0627(DouDou.\u0634\ufeb1\u0636\u0630(), 1146, 8, 1739)), var8_2, \u0645\u0641\u0630\u062d.\u0642\u062a\u0630\ufebd(DouDou.\u0634\ufeb1\u0636\u0630(), 1154, 4, 1330));
        var10_8 /* !! */  = new JSONObject();
        var10_8 /* !! */  = \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(\u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(var10_8 /* !! */ , var7_3, \u062f\ufead\ufeaf\u062d.\ufec9\u0630\ufed9\ufeb1(DouDou.\u0634\ufeb1\u0636\u0630(), 1158, 5, 457)), var8_2, \ufeb9\u0627\ufea5\ufe9d.\u062a\ufef1\u062d\u0641(DouDou.\u0634\ufeb1\u0636\u0630(), 1163, 4, 1178));
        var11_9 /* !! */  = new JSONObject();
        var11_9 /* !! */  = \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(\u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(var11_9 /* !! */ , var7_3, \ufea5\u062d\ufebd\u0633.\ufea5\ufeb1\u0643\ufe8f(DouDou.\u0634\ufeb1\u0636\u0630(), 1167, 2, 1811)), var8_2, \ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(DouDou.\u0634\ufeb1\u0636\u0630(), 1169, 4, 3178));
        var12_10 = new JSONObject();
        var12_10 = \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(\u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(var12_10, var7_3, \ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(DouDou.\u0634\ufeb1\u0636\u0630(), 1173, 15, 354)), var8_2, \ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(DouDou.\u0634\ufeb1\u0636\u0630(), 1188, 4, 681));
        var13_11 = new JSONObject();
        var8_2 = \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(\u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(var13_11, var7_3, \u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(DouDou.\u0634\ufeb1\u0636\u0630(), 1192, 12, 1201)), var8_2, \u0631\u0640\ufec1\ufee9.\ufe95\ufeed\u062c\ufec1(DouDou.\u0634\ufeb1\u0636\u0630(), 1204, 5, 509));
        var7_3 = new JSONArray();
        var5_4 /* !! */  = \u0630\ufebd\u0634\ufec9.\u0645\ufead\u0635\u0634(\u0630\ufebd\u0634\ufec9.\u0645\ufead\u0635\u0634(\u0630\ufebd\u0634\ufec9.\u0645\ufead\u0635\u0634(\u0630\ufebd\u0634\ufec9.\u0645\ufead\u0635\u0634(\u0630\ufebd\u0634\ufec9.\u0645\ufead\u0635\u0634(\u0630\ufebd\u0634\ufec9.\u0645\ufead\u0635\u0634(\u0630\ufebd\u0634\ufec9.\u0645\ufead\u0635\u0634(var7_3, var5_4 /* !! */ ), var6_6), var9_7), var10_8 /* !! */ ), var11_9 /* !! */ ), var12_10), var8_2);
        var7_3 = \ufec1\u0636\u062d\u0638.\u0636\ufeab\u0644\ufed9();
        var6_6 = new JSONObject(var7_3);
        var8_2 = \ufeb9\u0643\ufed9\ufed5.\u0628\u062f\ufea1\u0642(DouDou.\u0634\ufeb1\u0636\u0630(), 1209, 121, 1793);
        var7_3 = new JSONObject(\u0645\u0641\u0630\u062d.\ufead\u062b\u0647\u0642(var8_2, DouDou.\u0646\ufe95\ufea1\ufec5((Object)this)));
        var9_7 = \ufee9\ufee1\u0627\u0641.\ufead\ufeb1\u0627\u0641(var7_3, \u0633\u064a\u0644\u0637.\ufec9\ufeed\ufeb5\u0640(DouDou.\u0634\ufeb1\u0636\u0630(), 1330, 24, 964));
        var7_3 = new JSONArray();
        var3_12 = 0;
        block36: while (true) {
            var4_14 = \u0644\ufe8f\u0628\u062a.\ufee9\ufe8e\ufe99\u0631(var9_7);
            var2_13 = 1616;
            block37: while (true) {
                switch (var2_13 ^= 1633) {
                    default: {
                        continue block37;
                    }
lbl35:
                    // 2 sources

                    case 14: {
                        var2_13 = 1678;
                        continue block37;
                    }
                    case 49: {
                        if (var3_12 >= var4_14) ** GOTO lbl35
                        var2_13 = 1709;
                        continue block37;
                    }
                    case 204: {
                        var11_9 /* !! */  = \ufeaf\u0633\u0648\ufee9.\u062e\u062f\u0644\u0645(var9_7, var3_12);
                        var10_8 /* !! */  = \ufeab\u0632\u062f\u0640.\ufed9\ufeab\u0643\u0633(var11_9 /* !! */ , \u062f\ufead\ufeaf\u062d.\ufec9\u0630\ufed9\ufeb1(DouDou.\u0634\ufeb1\u0636\u0630(), 1354, 4, 2006));
                        var8_2 = \ufeab\u0632\u062f\u0640.\ufeab\u0632\ufec5\u0645(var11_9 /* !! */ , \ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(DouDou.\u0634\ufeb1\u0636\u0630(), 1358, 5, 817));
                        var1_1 = \u062b\ufec1\ufeb1\u062d.\ufea9\u0628\u0637\ufe95(\ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644(DouDou.\u0634\ufeb1\u0636\u0630(), 1363, 8, 2434), var10_8 /* !! */ );
                        var2_13 = 1740;
                        block39: while (true) {
                            switch (var2_13 ^= 1757) {
                                default: {
                                    continue block39;
                                }
                                case 17: {
                                    if (!var1_1) {
                                        var2_13 = 1833;
                                        continue block39;
                                    }
                                }
                                case 54: {
                                    var2_13 = 1802;
                                    continue block39;
                                }
                                case 500: {
                                    var1_1 = \u062b\ufec1\ufeb1\u062d.\ufea9\u0628\u0637\ufe95(\ufeb5\ufe8e\ufead\u0632.\ufe8f\ufef1\u0648\ufe95(DouDou.\u0634\ufeb1\u0636\u0630(), 1371, 2, 1856), var10_8 /* !! */ );
                                    var2_13 = 1864;
                                    block40: while (true) {
                                        switch (var2_13 ^= 1881) {
                                            default: {
                                                continue block40;
                                            }
                                            case 17: {
                                                if (!var1_1) {
                                                    var2_13 = 48736;
                                                    continue block40;
                                                }
                                            }
                                            case 47483: {
                                                var2_13 = 48705;
                                                continue block40;
                                            }
                                            case 47417: {
                                                var1_1 = \ufea5\u062d\ufebd\u0633.\u0639\ufeb1\ufead\ufe8f(var8_2);
                                                var2_13 = 48767;
                                                block41: while (true) {
                                                    switch (var2_13 ^= 48784) {
                                                        default: {
                                                            continue block41;
                                                        }
lbl83:
                                                        // 2 sources

                                                        case 14: {
                                                            var2_13 = 48829;
                                                            continue block41;
                                                        }
                                                        case 239: {
                                                            if (var1_1) ** GOTO lbl83
                                                            var2_13 = 48860;
                                                            continue block41;
                                                        }
                                                        case 76: {
                                                            var10_8 /* !! */  = new StringBuilder();
                                                            \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var10_8 /* !! */ , \ufeab\u0632\u062f\u0640.\ufeab\u0632\ufec5\u0645(\ufeaf\ufea5\ufeab\u062e.\ufe99\ufea9\u0647\u0641(var11_9 /* !! */ , \ufe8e\ufeb9\u0647\u0642.\ufee1\u062f\ufedd\u0643(DouDou.\u0634\ufeb1\u0636\u0630(), 1373, 3, 623)), \u0632\ufead\u062f\u0628.\u0645\u062a\u0637\u0635(DouDou.\u0634\ufeb1\u0636\u0630(), 1376, 6, 3074)));
                                                            \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var10_8 /* !! */ , \u062a\ufee1\ufe8e\ufeb9.\ufec5\ufecd\ufea9\ufea5(DouDou.\u0634\ufeb1\u0636\u0630(), 1382, 155, 2839));
                                                            var10_8 /* !! */  = \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(var10_8 /* !! */ );
                                                            var11_9 /* !! */  = \ufeab\u0632\u062f\u0640.\ufeab\u0632\ufec5\u0645(\ufeaf\ufea5\ufeab\u062e.\ufe99\ufea9\u0647\u0641(var11_9 /* !! */ , \u062a\ufee1\ufe8e\ufeb9.\ufec5\ufecd\ufea9\ufea5(DouDou.\u0634\ufeb1\u0636\u0630(), 1537, 6, 1860)), \u062a\u0635\ufeb1\u0642.\u0637\u0636\u062a\ufedd(DouDou.\u0634\ufeb1\u0636\u0630(), 1543, 5, 1241));
                                                            var12_10 = new JSONObject();
                                                            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(var12_10, \ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(DouDou.\u0634\ufeb1\u0636\u0630(), 1548, 8, 493), var8_2);
                                                            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(var12_10, \u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(DouDou.\u0634\ufeb1\u0636\u0630(), 1556, 7, 1328), var10_8 /* !! */ );
                                                            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(var12_10, \ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(DouDou.\u0634\ufeb1\u0636\u0630(), 1563, 11, 701), var11_9 /* !! */ );
                                                            \u0630\ufebd\u0634\ufec9.\u0645\ufead\u0635\u0634(var7_3, var12_10);
                                                        }
                                                        case 45: 
                                                    }
                                                    break;
                                                }
                                            }
                                            case 47384: 
                                        }
                                        break;
                                    }
                                }
                                case 471: 
                            }
                            break;
                        }
                        var2_13 = 48891;
                        block43: while (true) {
                            switch (var2_13 ^= 48908) {
                                default: {
                                    continue block43;
                                }
                                case 22: {
                                    ++var3_12;
                                    continue block36;
                                }
                                case 503: 
                            }
                            var2_13 = 48922;
                        }
                    }
                    case 239: 
                }
                break;
            }
            break;
        }
        try {
            var8_2 = new JSONObject();
            var5_4 /* !! */  = \ufeaf\u0633\u0648\ufee9.\ufeb5\u0634\u0640\ufea1(\u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(\u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(\u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(var8_2, \ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(DouDou.\u0634\ufeb1\u0636\u0630(), 1574, 5, 1992), var5_4 /* !! */ ), \u0636\u0634\ufec1\u0631.\u062c\u063a\u0643\u0627(DouDou.\u0634\ufeb1\u0636\u0630(), 1579, 7, 2464), var6_6), \ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(DouDou.\u0634\ufeb1\u0636\u0630(), 1586, 4, 2524), var7_3));
lbl126:
            // 2 sources

            return var5_4 /* !! */ ;
        }
        catch (Exception var5_5) {
            \ufed9\ufe8e\u062d\ufead.\u062b\ufe8e\u062d\u0645(var5_5);
            var5_4 /* !! */  = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
            ** continue;
        }
    }

    private static long[] $d2j$hex$1a2c7867$decode_J(String src) {
        byte[] d = DouDou.$d2j$hex$1a2c7867$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$1a2c7867$decode_I(String src) {
        byte[] d = DouDou.$d2j$hex$1a2c7867$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$1a2c7867$decode_S(String src) {
        byte[] d = DouDou.$d2j$hex$1a2c7867$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$1a2c7867$decode_B(String src) {
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

