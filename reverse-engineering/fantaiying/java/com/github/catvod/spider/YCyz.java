/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  com.github.catvod.crawler.Spider
 *  com.github.catvod.crawler.SpiderDebug
 *  okhttp3.Response
 *  okhttp3.ResponseBody
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.annotation.TargetApi;
import android.content.Context;
import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\u0645\u0641\u0630\u062d;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufe8f\ufe8e\ufeb5\u0641;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
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
import com.github.catvod.spider.merge.Jz;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.kb_0;
import com.github.catvod.spider.merge.w2;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0641\u0631\ufeed\u0643;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufea5\ufea9\u0633\ufed5;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufebd\u0640\u0648\u062b;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.merge.\ufee9\ufee1\u0627\u0641;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
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
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class YCyz
extends Spider {
    private static final short[] short = YCyz.$d2j$hex$f50aa0ed$decode_S("0b03170317031303100359034c034c0315034d031b030f03530352034d03060316034d03000300034c03700428047e046a0436043704280463047304280465046504d701cb01cb01cf01cc01850190019001c901d001db019101c701d3018f018e019101d201da019001510b620b6d0b640b660b64067f067206630675063b0636062b06360627050b050a05100501050a051005490530051d0514050105f801e701ea01eb01e101a101e301fe01ba017602910ab70aa10ab60ae90a850aa30aa10aaa0ab00a5b0379036c037f037a037a037703390323033803260336033e035b03770375037f0378036203790365037e032d0336035f037803620373037a0336035b037703750336035903450336034e03360327032603490327032303490321033f0336035703660366037a0373034103730374035d037f036203390323032503210338032503200336033e035d035e0342035b035a033a0336037a037f037d03730336035103730375037d0379033f03360355037e03640379037b0373033903270322032e033803260338032603380326033603450377037003770364037f033903230325032103380325032003910796078807f207f107f907f407e5078004910491048d04880482048004950488048e048f04ce0497048f048504cf048004910491048d048404cf048c04910484048604b404b304ad04c20cc30cd10cba0caf0c740b2a0b340b3d0b74056e0573056205e50cbf0cb80c47019402880288028c020c021d0200020c02570208021402190211021602a9039303a003ba03ad03ae03e203f503a003bc03a50395036d06770660066306a703a303a9039503aa03af03ba03af03e303bd03bc03ad0393038409810994098109cd099309920983090d0600061f0632060a06050608061a061a0654060a0608061b060d064406000607060f060606340649065706490601065d06670b6a0b750b580b600b6f0b620b700b700b3e0b600b620b710b670b2e0b6e0b660b770b620b5e0b230b3d0b230b700b730b620b6d0bbf02b202bb02ae02bf05e105a705ea05980489048904950490049a0498048d04900496049704d6048f0497049d04d70498048904890495049c04d704940489049c049e048c048b04950408092e0938092f0970091c093a093809330929099308b108a408b708b208b208bf08f108eb08f008ee08fe08f6088608ef08ef08e508fe089208b708b008ab08a608fe08bf08bf08ac08bd08b608e808ea08f708fe089f08ae08ae08b208bb088908bb08bc089508b708aa08f108eb08ed08e908f008ed08e808fe08f608950896088a0893089208f208fe08b208b708b508bb08fe089908bb08bd08b508b108f708fe089d08b608ac08b108b308bb08f108ef08ea08e608f008ee08f008ee08f008ee08fe088d08bf08b808bf08ac08b708f108eb08ed08e908f008ed08e808180b250b3e0b300b3e0b390b9601960196019601960139032f033e036703290325032503210323032f03070ba707b307ae07b807b907ae07a1078c0984098a09dc081c03d2078e07d207650cf701ee01bc01b101b801ad01f501a203aa03a403f603ec0af50ab20aa10ab60ab20aee0aa80ab20aa10ab60ab20aae0af50aaa0ab60ab20aa10aee0aa80aaa0ab60ab20aa10aae0af50abc0aa10ab70ab60aa10aee0aa80abc0aa10ab70ab60aa10aae0a4a090d091e0909090d09510917090d091e0909090d0911094a09150909090d091e0951091709150909090d091e0911094a0903091e09080909091e095109170903091e09080909091e091109b7016e02d10adc0adc0afe09e409f709e009e409f8098d05ca05d905ce05ca059605d005ca05d905ce05ca05d605dd04df04c304c704d404db042d0572056e056a0579053605700572056e056a0579057605a405ef04e204e204a104a301ba01f301ee01f801f901ee01a101ac01210c660c750c620c660c3a0c690620063d062b062a063d0672067f06890bc40bc90bd60bfb0bc30bcc0bc10bd30bd30b9d0bd80bcc0b8d0bcd0bcf0bd60bc90bc50bd30b8d0bc70bd20bc90bc40b8d0b980bfd0b800bc40bc90bd60b8e0bcd0bcf0bd60bc90bc50b8d0bc30bc10bd20bc40b690b640b7b0b560b6e0b610b6c0b7e0b7e0b300b640b630b6b0b620b200b610b640b7e0b790b500b2d0b690b640b7b0b230b640b630b6b0b620b200b640b790b680b600b19051a050b0504054405030504050c050505470506050b0508050f050605b25c5a68930a67036d7b1c56e846c76796796652d003dd03c203ef03d703d803d503c703c7038903d003d103c703d703e9031e0413040c042104190416041b040904090447040a0416041b04030457041604130409040e0427045a041b042104120408041f041c045004470412040e041704270497048d049a04990493051b8b5958720b59731d59a6076a799985385e310523052d4bfd53275c46934d512c9e0d5a10026102460240024f0246025502400248024b0254026f67b05a275b50062106090600060f060b0614062792a9578b07fa07d707df07d307d007cf07c6732f5ea603d703e503fe03fd03e203a7622555810af00ad40adf0ade0ad70ad80ac50ad10ac25e51798903f803c203d703d603df03c103d103f5797385650c3b0c7d0c300c570c3a0cd30c8d0ccb0c860c530a540a4a0a150a6a099f0288029b02c902990280028d02c902d402b9049f0489049e04c104ad048b04890482049804b204900485049604930493049e04d004ca04d104cf04df04d704b2049e049c04960491048b0490048c049704c404df04b60491048b049a049304df04b2049e049c04df04b004ac04df04a704df04ce04cf04a004ce04ca04a004c804d604df04be048f048f0493049a04a8049a049d04b40496048b04d004ca04cc04c804d104cc04c904df04d704b404b704ab04b204b304d304df049304960494049a04df04b8049a049c0494049004d604df04bc0497048d04900492049a04d004ce04cb04c704d104cf04d104cf04d104cf04df04ac049e0499049e048d049604d004ca04cc04c804d104cc04c904b108a108b008ab08b208b608800497048404d60482049f049b049304200add0ab004b504b204b904af04e304a804e1045505000514054e05c30b950b8c0b810bd80b46094309560943093203520a520a520a0b0a470a410a400a110a0b0a460a460af001fd01f901fc01fd01ea018d0891089c088408a8088f0891088f038a03850386038a0380039e03ce06df06cc06cd06db06bc04bb04a504cf0a8c0ad20a940ad90abe06f906fe06a506e506ac06ad06ae06a906bd06a406bc062d0576057d052f057f05210567052a0534057105610562052f054b0551056b056805340561057b05660577052f05df078c078b079507c407c7059c059705c505a105bb0581058205de058c05810588059d05c5059505cb058d05c005f10af50aee0aea0ae40aef0a4501450145015e0216021e0215025e02c70a120606065e0a4d0a5a0a410a4e0a510a6b0a470a4c0a4d0a0b014c014b0110015001190118011b011c0108011101090153010901140116010901120116011e011901130153011e0112011001e40ba30ba40bff0bbf0bf60bf70bf40bf30be70bfe0be60bbc0bf30bf90bf30bff0bf30bfb0be80bf70bf60bbc0bfc0bf70be60b26033d0321037f0333033e033b03210335037f0324037f0362036203620362030301180104015a011a0116011b011e01010116015a0118015a0147014701470147015a0102010401ff06b406e306eb06f904b204e304e3049b0b910bc60bc10bda0b940b960b870b940b820b830bd90b910b960b940b920b820b920b930b9e0b830b980b850b810bd90b940b980b9a0be008ea08bd08ba08a108ff08e908ef08ff08e808e708a208ee08e508f808ff08ff08e908ef08a208ef08e308e10898049204c504c204d9049004950480049504da0496048d04800491048404980481048704970490049a04da0497049b049904e404ee04b904be04a504ee04ec04e504a604ee04ec04e504e104e604ef04fb04a604eb04e704e5046e066406330634062f06610661062f06670674066706700672066a066d0676066d062c06640663066106670677066e0674062c0661066d066f06530659060e060906120659065e065c065a064a065306490611065c06500652069f019501c201c501de0194019601900198019c01900197019d01de019c01950195019f019a019d019601dd019401de018301de0180018701920187019a019001dd0190019c019e016a03760376037203710338032d032d037203330334032f036a036703700363032f0371036b0365036c032f03740363032c036b0360037b03760367036b036f0365032c0361036d036f032d036d03600368032d039f0b830b830b870bcd0bd80bd80b9b0b910bc00bc00bda0b900b920b940b9c0b980b940b930b990bd90b950b8e0b830b920b900b920b940b9c0b980bda0b9e0bc60bcf0b990bd90b940b980b9a0bd80b980b950b9d0bd80ba20cbe0cbe0cba0cf00ce50ce50ca60cac0cfb0cfc0ce70ca90cae0ca40ce70cb90ca50ca60cbc0caf0ce40cad0cab0cbf0cbe0ca20ca70cab0cbe0ca20ce40ca90ca50ca70ce50ca50ca80ca00ce50c06081a081a081e085408410841080d08140814081708400816080008430843081a0859085b080f0840080b081b08400801081c08090841080c0807080a0807081d080b080f081c080d08060840081e0806081e08510819080a085308c20ac30ad10aba0aaf0a160616061606bc0aa50aae0a950ab80aaf0aa70aab0ab80aa10ab90ace01d701dc01e701c801d101db01b60aaf0aa40a9f0aae0aa10aad0aa50afc01e501ee01d501e301ee01070a270a9506ed069506ed069506ed06610664067e067906820286029002ec02860280028102ec029302880280029002f4029302a202a702a702aa02ad02a402ab0baf0bb90b");
    private static String t0 = "";
    private String N;
    private String SN;
    private JSONObject i;
    private String tF;
    private final Random yq = new Random();
    private String zH;

    /*
     * Enabled aggressive block sorting
     */
    public YCyz() {
        this.SN = \ufea9\u0643\u062d\u063a.\ufea1\u0633\ufe8e\u0627(YCyz.\u0641\u062d\u0632\ufecd(), 0, 21, 867);
        this.N = \ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(YCyz.\u0641\u062d\u0632\ufecd(), 21, 12, 1030);
        this.tF = \u062a\ufee1\ufe8e\ufeb9.\ufec5\ufecd\ufea9\ufea5(YCyz.\u0641\u062d\u0632\ufecd(), 33, 20, 447);
        this.zH = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
        int n = \u062d\ufeb9\ufeab\ufef1.\ufe8e\u0645\u0632\u0628();
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
                    float f = Float.parseFloat(\u062a\ufee1\ufe8e\ufeb9.\u0634\u0643\u0633\u0640("cxtYjhtgR"));
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
    private String N(String var1_1) {
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
    public static Object[] proxyM3u8(Map<String, String> var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 17[TRYBLOCK] [19 : 1402->1411)] java.lang.Exception
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
     * Ignored method signature, as it can't be verified against descriptor
     * Exception decompiling
     */
    private List tF(kb_0 var1_1) {
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
    public static Object[] vod(Map<String, String> objectArray) {
        boolean bl = \u062b\ufec1\ufeb1\u062d.\ufea9\u0628\u0637\ufe95((String)\ufea9\ufec5\u0647\u0641.\ufe95\u0627\ufea1\u0647(objectArray, \u0641\ufeb5\ufeb1\ufee1.\u0639\u0630\ufeaf\ufe95(YCyz.\u0641\u062d\u0632\ufecd(), 373, 4, 715)), \u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(YCyz.\u0641\u062d\u0632\ufecd(), 377, 4, 1490));
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
                    objectArray = new Object[]{\ufe8e\ufec1\u0641\u0644.\u062b\u0635\ufeab\ufeaf(200), \ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(YCyz.\u0641\u062d\u0632\ufecd(), 381, 29, 1273), new ByteArrayInputStream(\ufe8e\u0627\ufecd\u062a.\u0642\u0634\u0633\ufea1(YCyz.\u063a\u0638\u0628\ufeb5()))};
                    return objectArray;
                }
                case 239: 
            }
            break;
        }
        return null;
    }

    private HashMap<String, String> zH() {
        String string = "\u06e5\u06e8\u06e8";
        HashMap hashMap = null;
        String string2 = null;
        String string3 = null;
        short[] sArray = null;
        block12: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, string2, string3);
                    string = "\u06e2\u06e0\u06e1";
                    continue block12;
                }
                case 56448: {
                    string3 = \ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644(sArray, 522, 6, 2903);
                    string = "\u06e8\u06e7\u06e2";
                    continue block12;
                }
                case 56451: {
                    sArray = YCyz.\u0641\u062d\u0632\ufecd();
                    string = "\u06e4\u06e4";
                    continue block12;
                }
                case 1749603: {
                    string2 = YCyz.\ufe8f\ufea1\u0631\ufead((Object)this);
                    string = "\u06e4\u06e7";
                    continue block12;
                }
                case 1755587: {
                    \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, string3, string2);
                    string = "\u06e8\u06df\u06e1";
                    continue block12;
                }
                case 1751526: {
                    string3 = \u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(sArray, 420, 102, 2270);
                    string = "\u06e5\u06e3\u06e8";
                    continue block12;
                }
                case 1749639: {
                    sArray = YCyz.\u0641\u062d\u0632\ufecd();
                    string = "\u06e7\u06e5\u06e5";
                    continue block12;
                }
                case 1754567: {
                    string2 = \ufea9\ufe8f\u0647\ufead.\ufea9\u0643\ufedd\ufeed(sArray, 410, 10, 2397);
                    string = "\u06e6\u06e2\u06e1";
                    continue block12;
                }
                case 1752741: {
                    hashMap = new HashMap();
                    string = "\u06e2\u06e1\u06e6";
                    continue block12;
                }
                case 1753509: {
                    sArray = YCyz.\u0641\u062d\u0632\ufecd();
                    string = "\u06e4\u06e0\u06e2";
                    continue block12;
                }
                case 1755338: 
            }
            break;
        }
        return hashMap;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u062b\u0635\ufeab\ufeaf(Object object, Object object2) {
        int n = \u0646\ufecd\ufead\u0647.\u0631\u0642\u062d\u064a();
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
                    return ((Response)object).header((String)object2);
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
    public static List \u062c\u062f\ufea5\ufeb1(Object object, Object object2) {
        int n = \ufeaf\u0633\u0648\ufee9.\u0641\u062b\u062d\ufeed();
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
                    return ((YCyz)((Object)object)).tF((kb_0)object2);
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
    public static InputStream \u062c\ufe9d\u0632\ufeab(Object object) {
        int n = \ufea9\ufe8f\u0647\ufead.\ufe95\ufeb1\ufeaf\u0641();
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
                    return ((ResponseBody)object).byteStream();
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
    public static Response \u062d\u063a\u062b\u062c(Object object, Object object2, Object object3, int n) {
        int n2 = \ufecd\u0642\u062e\ufe9d.\u0634\u063a\u0628\ufeb9();
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
    public static String \u062e\u062a\u062d\ufeed(Object object) {
        int n = \ufeaf\u062b\ufed5\ufec1.\ufeb9\ufee1\ufe8e\u064a();
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
                    return ((YCyz)((Object)object)).tF;
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
    public static HashMap \u062e\ufea9\ufe99\u063a(Object hashMap) {
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
                    return ((YCyz)((Object)hashMap)).zH();
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            hashMap = var3_3;
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
    public static void \u0630\u0635\ufea9\u0641(Object object) {
        int n = \ufe8f\ufe8e\ufeb5\u0641.\u0647\u0639\ufee9\ufedd();
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
    public static Random \u0633\ufee1\ufea5\ufea9(Object object) {
        int n = \ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643();
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
                    return ((YCyz)((Object)object)).yq;
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
    public static String \u0639\ufec5\ufeab\ufe95(Object object) {
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
                    return ((YCyz)((Object)object)).zH;
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
    public static void \u0639\ufec5\ufecd\u0642(Object object) {
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
    public static String \u063a\u0638\u0628\ufeb5() {
        int n = \ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640();
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
                    return t0;
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
    public static Response \u063a\u0642\u0641\ufee9(Object object, Object object2) {
        int n = \ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633();
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
    public static ResponseBody \u063a\ufe9d\ufed9\u0646(Object object) {
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
    public static short[] \u0641\u062d\u0632\ufecd() {
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
    public static String \u0641\ufee9\u0635\ufe9d(Object object) {
        int n = \ufea5\u062d\ufebd\u0633.\u0645\ufe95\u0647\ufec1();
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
                    return ((YCyz)((Object)object)).SN();
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
    public static Response \u0645\u0636\ufeed\u0644(Object object, Object object2, int n) {
        int n2 = \u0633\u064a\u0644\u0637.\ufec1\u062e\u0643\ufedd();
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
                    return w2.M((String)object, (Map)object2, n);
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
    public static String \u0645\ufec9\u062c\u0630(Object object) {
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
                    return ((YCyz)((Object)object)).SN;
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
    public static String \ufe8f\ufea1\u0631\ufead(Object object) {
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
                    return ((YCyz)((Object)object)).N;
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
    public static String \ufe95\ufecd\u062b\u0630(Object object, Object object2) {
        int n = \ufeab\u062d\u063a\ufea9.\ufebd\ufe8f\u0635\u0647();
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
                    return ((YCyz)((Object)object)).N((String)object2);
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
    public static JSONObject \ufead\u0632\ufeaf\ufeab(Object object) {
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
                    return ((YCyz)((Object)object)).i;
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
    public static int \ufed5\u0638\ufe99\ufed9(Object object) {
        int n = \ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640();
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
                    return ((Response)object).code();
                }
                case 239: 
            }
            break;
        }
        n = 0;
        n2 = 1740;
        block11: while (true) {
            int n3 = n2 ^ 0x6DD;
            n2 = n;
            switch (n3) {
                case 54: {
                    return n2;
                }
                default: {
                    n2 = n3;
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
    public static String \ufeed\u0630\ufecd\u0632(Object object, Object object2, Object object3) {
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
                    return ((YCyz)((Object)object)).yq((String)object2, (String)object3);
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
    protected final String SN() {
        this.zH = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
        String string = \ufec1\u0636\u062d\u0638.\u062f\u0627\u062b\u0628(new StringBuilder(), YCyz.\u0645\ufec9\u062c\u0630((Object)this), \ufe8f\ufe8e\ufeb5\u0641.\u062f\u0627\u0640\ufee1(YCyz.\u0641\u062d\u0632\ufecd(), 528, 5, 492));
        HashMap hashMap = new HashMap();
        \u062d\ufeb9\ufeab\ufef1.\ufebd\u0637\u0640\ufec5(string, YCyz.\u062e\ufea9\ufe99\u063a((Object)this), hashMap);
        string = \u0635\u0631\u0645\u0628.\u0646\u0627\u062a\u062d(YCyz.\u0641\u062d\u0632\ufecd(), 533, 10, 842);
        boolean bl = \ufe8e\ufeb9\u0647\u0642.\ufec1\ufed5\ufe99\ufea9(hashMap, string);
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
                    this.zH = \ufeb5\ufe8e\ufead\u0632.\u0640\ufec5\ufedd\u0634((String)\u0646\ufecd\ufead\u0647.\u0643\ufe8e\u0644\ufe95((List)\u0641\u0631\ufeed\u0643.\ufedd\u0631\ufebd\u062d(hashMap, string), 0), \u062b\ufec1\ufeb1\u062d.\u0637\u0647\u0635\u0630(YCyz.\u0641\u062d\u0632\ufecd(), 543, 1, 2876))[0];
                    return YCyz.\u0639\ufec5\ufeab\ufe95((Object)this);
                }
                case 239: 
            }
            break;
        }
        return YCyz.\u0639\ufec5\ufeab\ufe95((Object)this);
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
    public String detailContent(List<String> var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 35[TRYBLOCK] [72 : 2949->2953)] java.lang.Throwable
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
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String homeContent(boolean bl) {
        try {
            new JSONObject();
            Object object = new ArrayList();
            Object object2 = new Jz(\u062f\ufead\ufeaf\u062d.\ufec9\u0630\ufed9\ufeb1(YCyz.\u0641\u062d\u0632\ufecd(), 874, 1, 2882), \u062a\ufee1\ufe8e\ufeb9.\ufec5\ufecd\ufea9\ufea5(YCyz.\u0641\u062d\u0632\ufecd(), 875, 2, 1644));
            \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(object, object2);
            object2 = new Jz(\u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(YCyz.\u0641\u062d\u0632\ufecd(), 877, 1, 1943), \u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(YCyz.\u0641\u062d\u0632\ufecd(), 878, 3, 3167));
            \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(object, object2);
            object2 = new Jz(\ufebd\u0640\u0648\u062b.\ufea5\u0639\u0631\ufe95(YCyz.\u0641\u062d\u0632\ufecd(), 881, 6, 1280), \ufed9\ufe9d\ufeed\ufeb5.\u0638\ufec1\u063a\u0644(YCyz.\u0641\u062d\u0632\ufecd(), 887, 3, 2154));
            \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(object, object2);
            object2 = new Jz(\ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(YCyz.\u0641\u062d\u0632\ufecd(), 890, 11, 545), \u0646\ufecd\ufead\u0647.\u0640\u062e\ufed5\ufeaf(YCyz.\u0641\u062d\u0632\ufecd(), 901, 3, 2368));
            \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(object, object2);
            object2 = new Jz(\u0635\u0631\u0645\u0628.\u0646\u0627\u062a\u062d(YCyz.\u0641\u062d\u0632\ufecd(), 904, 7, 1633), \ufee9\ufee1\u0627\u0641.\ufea1\ufebd\u063a\u0630(YCyz.\u0641\u062d\u0632\ufecd(), 911, 2, 1486));
            \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(object, object2);
            object2 = new Jz(\ufeb9\u0627\ufea5\ufe9d.\u062a\ufef1\u062d\u0641(YCyz.\u0641\u062d\u0632\ufecd(), 913, 7, 1978), \ufea1\u0645\u062b\u0634.\u0638\ufec9\u0630\ufe95(YCyz.\u0641\u062d\u0632\ufecd(), 920, 2, 3144));
            \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(object, object2);
            object2 = new Jz(\ufeab\u0632\u062f\u0640.\u062f\u0627\ufe95\u0631(YCyz.\u0641\u062d\u0632\ufecd(), 922, 6, 919), \ufeb9\u0643\ufed9\ufed5.\u0628\u062f\ufea1\u0642(YCyz.\u0641\u062d\u0632\ufecd(), 928, 2, 1858));
            \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(object, object2);
            object2 = new Jz(\ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(YCyz.\u0641\u062d\u0632\ufecd(), 930, 9, 2736), \ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(YCyz.\u0641\u062d\u0632\ufecd(), 939, 2, 3178));
            \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(object, object2);
            object2 = new Jz(\u0631\ufea1\u0638\u0627.\u0645\u062f\u062d\ufeaf(YCyz.\u0641\u062d\u0632\ufecd(), 941, 8, 952), \ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(YCyz.\u0641\u062d\u0632\ufecd(), 949, 2, 1801));
            \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(object, object2);
            YCyz.\u0641\ufee9\u0635\ufe9d((Object)this);
            object2 = new Tq();
            \ufe9d\ufeab\u062e\u0640.\u0648\u062d\u0643\ufeb1(object2, object);
            \u0630\ufebd\u0634\ufec9.\ufeab\ufee9\u0641\ufed5(object2, YCyz.\ufead\u0632\ufeaf\ufeab((Object)this));
            return \ufeed\ufebd\u0635\ufedd.\ufec1\ufef1\u0632\ufe8e(object2);
        }
        catch (Exception exception) {
            YCyz.\u0639\ufec5\ufecd\u0642(exception);
            return \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void init(Context context) {
        super.init(context);
        try {
            context = new JSONObject(\ufea9\ufec5\u0647\u0641.\ufed5\u0631\u064a\u0639());
            this.i = context;
            return;
        }
        catch (JSONException jSONException) {
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
    @TargetApi(value=19)
    public String playerContent(String var1_1, String var2_6, List<String> var3_8) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 59[TRYBLOCK] [81 : 5850->5864)] java.lang.Exception
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
    public String searchContent(String var1_1, boolean var2_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 4[TRYBLOCK] [4 : 642->659)] java.lang.Exception
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
    protected final String yq(String var1_1, String var2_3) {
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

    private static long[] $d2j$hex$f50aa0ed$decode_J(String src) {
        byte[] d = YCyz.$d2j$hex$f50aa0ed$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$f50aa0ed$decode_I(String src) {
        byte[] d = YCyz.$d2j$hex$f50aa0ed$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$f50aa0ed$decode_S(String src) {
        byte[] d = YCyz.$d2j$hex$f50aa0ed$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$f50aa0ed$decode_B(String src) {
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

