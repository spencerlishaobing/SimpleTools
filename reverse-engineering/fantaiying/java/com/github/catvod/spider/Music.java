/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.text.Editable
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.TextView
 *  com.github.catvod.crawler.Spider
 *  com.github.catvod.crawler.SpiderDebug
 *  com.google.gson.Gson
 *  com.google.gson.annotations.SerializedName
 *  okhttp3.Headers
 *  okhttp3.Response
 *  okhttp3.ResponseBody
 */
package com.github.catvod.spider;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\u0638\ufead\u062e\ufee1;
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
import com.github.catvod.spider.merge.FY;
import com.github.catvod.spider.merge.Jb;
import com.github.catvod.spider.merge.Jz;
import com.github.catvod.spider.merge.KJ;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.VH;
import com.github.catvod.spider.merge.Va;
import com.github.catvod.spider.merge.g1;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.sv;
import com.github.catvod.spider.merge.to_0;
import com.github.catvod.spider.merge.w2;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
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
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.merge.\ufee9\ufee1\u0627\u0641;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\u0636\u0634\ufec1\u0631;
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
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class Music
extends Spider {
    private static Sjyy Gc;
    private static boolean KJ;
    private static String M;
    private static final short[] short;
    private String N;
    private String SN;
    private AlertDialog i;
    private final SecureRandom t0;
    private boolean tF;
    private String yq = \u062d\ufeb9\ufeab\ufef1.\ufeed\u0638\u0635\ufed5(Music.\u0632\u062c\u0630\ufed9(), 0, 19, 1284);
    private boolean zH;

    static {
        short = Music.$d2j$hex$3cd974bd$decode_S("6c057005700574053e052b052b057305730573052a0530056705300530052a0567056b0569058301c601df018301dc01c001cd01d5018201dc01c401dc018e0bb90bba0bb90bae0bb90bae0b24083408350821081808330828082c082208290881089c08840888088708b6088a0881088c088a0882089d0290028f02d702950292028a02900297029e029c028b02a602950290028a028d02d902c702d9028c029502d902c702d90295029002a608ab08b408ec08b108ab08ac08a508a708b0089d08ae08ab08b108b608e208fc08e208b708ae08e208fc08e208ae08ab08ca09c709d8098009d809c709ca09cb09c109f109c209c709dd09da098e0990098e09db09c2098e0990098e09c209c70939037e037b037e03790370037c036203480371037b033703290337037b037e033809240929093109240921093b093c093b097d0b3d0b320b3e0b360b730b320bab05169c2e42c8559958855e645f1a79317ae4736972f967950cb54267751360c29a470204080f081d089b0281029602950296088d089708920888088f080002600279027b020002900b940b9e0b5b035a034b0377056b056b056f056c052505300530057605720578052f05280531056c057005780570056a057c057b05710531057c0570057205300569052d0530056b0577056a0572057d0530056d057a056b0566056f057a0540057a0567057c0573056a057b057a05400578057605790530057a0567056b0530057e056a056b05700530056e05300526052a0530057c056d0570056f0530056705660530057e05760530056b0530052f05300520057e056f056f0576057b0522052e052d052d0539056a056d057305220577056b056b056f056c052505300530056c052e053105760572057e0578057a0577056a057d0531057c057c053005760572057e0578057a056c0530052d052f052d05290530052f052c0530052f052e0530052605260526052e0579057c057a057e057e057d0526057d052d0529052f0527052d057d052a052d052c057b05290526052e057a052c0529052e05290579052a05310572057b05310575056f05780515033303250332036d030103270325032e03340318073a072f073c073907390734077a0760077b07650775077d0702073c073b0731073a072207260775071b0701077507640765077b0765076e07750702071a070207630761077c077507140725072507390730070207300737071e073c0721077a076007660762077b076607630775077d071e071d070107180719077907750739073c073e07300775071207300736073e073a077c07750716073d0727073a07380730077a076d0763077b0765077b0761076707610765077b0764076c076d077507060734073307340727073c077a076007660762077b0766076307d203fe03fe03fa03f803f4031001120112011401010105012b073a0727072b07700737072b073207330773073e072f072f07330736073c073e072b073607300731077007270737072b0732073307740727073207330773073e072f072f07330736073c073e072b07360730073107700727073207330764072e0762076f07710766077307360732073e0738073a0770073e072907360739077307360732073e0738073a07700728073a073d072f077307360732073e0738073a0770073e072f0731073807730775077007750764072e0762076f077107670773073e072f072f07330736073c073e072b0736073007310770072c073607380731073a073b0772073a0727073c0737073e07310738073a076407290762073d076c0764072e0762076f07710768078d04ba04b904ba04ad04ba04ad041e0c0f0c0f0c130c160c1c0c1e0c0b0c160c100c110c500c100c1c0c0b0c520c0c0c0b0c0d0c1a0c1e0c120cc703ca03c303d603c901d501cc01cd01780669067406780623066406780661066006d707d407d407da07d507c2079d079f07820795079407d20789078207d007840783079d0798079907cb078e079e079d07d007a00798079e0784078e07cb07990794079d078807d0079907880795079907cb0786079a07d007ca07cd07c607cd07880783078e07820789078807b807bf07a407ae07820780079d0782078307880783079907c50786079a07c407d607e707cd07cd07cd07cd07cd07cd079b078c079f07cd07950785079f07cd07d007cd07830788079a07cd07b507a007a107a507990799079d07bf0788079c07980788079e079907c507c407d607e707cd07cd07cd07cd07cd07cd07950785079f07c30782079d0788078307c507ca07aa07a807b907ca07c107cd078c079d078407b8079f078107c107cd0799079f0798078807c407d607e707cd07cd07cd07cd07cd07cd07950785079f07c3079e07880783078907c507c407d607e707cd07cd07cd07cd079007e707cd07cd07d107c2079e078e079f0784079d079907d307e707d107c2078f07820789079407d307e707d107c2078507990780078107d307e707f908e808f508f9081c0200025b075a07480723073607da05ed018006870699069c069d06b2068706880684068c06d4068a069a069b068f06b6069d06860682068c068706b406eb02fc02f102e802f8022301320120012001100132012301270130013b0132016901730130012001210135010c0127013c01380136013d0173013d013c012701730135013c0126013d0137015f084f084e085a086308480853085708590852089c0b810b990b950b9a0bab0b970b9c0b910b970b9f0b3e063f06d404c204d3048a04c404c804c804cc04ce04c2046c056a0546055f054c054c05eb8e8f8a795400613e786f543290d18e7f0b7d0bc471927bd05af28427f48554ca4440692a73376f09760850566e70604e790a0a160a0c0a4b0c570c4d0c010c120c010c84547763497a4b07276c74614407276c66538e0b920b920b960b950bdc0bc90bc90b8f0b8b0b810bd60bd10bc80b950b890b810b890b930b850b820b880bc80b850b890b8b0bc90b900bd40bc90b920b8e0b930b8b0b840bc90b940b830b920b9f0b960b830bb90b830b9e0b850b8a0b930b820b830bb90b810b8f0b800bc90b830b9e0b920bc90b870b930b920b890bc90b970bc90bdf0bd30bc90b850b940b890b960bc90b9e0b9f0bc90b870b8f0bc90b920bc90bd60bc90bd90b870b960b960b8f0b820bdb0bd70bd40bd40bc00b930b940b8a0bdb0b8e0b920b920b960b950bdc0bc90bc90b950bd70bc80b8f0b8b0b870b810b830b8e0b930b840bc80b850b850bc90b8f0b8b0b870b810b830b950bc90bd40bd60bd40bd00bc90bd60bd50bc90bd60bd70bc90bdf0bdf0bdf0bd70b800b850b830b870b870b840bdf0b840bd40bd00bd60bde0bd40b840bd30bd40bd50b820bd00bdf0bd70b830bd50bd00bd70bd00b800bd30bc80b8b0b820bc80b8c0b960b810bac07b007aa07e607f507e6071a045c0440045904580432609a6b0083f65d8f68b1715e87fc04a004bc04fc04c308df08df08db08d808910884088408c208c608cc089b089c088508d808c408cc08c408de08c808cf08c5088508c808c408c6088408dd0899088408df08c308de08c608c9088408d908ce08df08d208db08ce08f408ce08d308c808c708de08cf08ce08f408cc08c208cd088408ce08d308df088408ca08de08df08c4088408da08840892089e088408c808d908c408db088408d308d2088408ca08c2088408df0884089b0884089408ca08db08db08c208cf0896089a08990899088d08de08d908c7089608c308df08df08db08d808910884088408d8089a088508c208c608ca08cc08ce08c308de08c9088508c808c8088408c208c608ca08cc08ce08d808840899089b0899089d0884089b089d08840899089a0884089308cf0893089f08cf089a089c089a089f08cf089e0892089d08c9089f08ca08cd089b08cf089d0899089208c9089c08990893089d089f089b08ce089d08cf088508c608cf088508c108db08ce08cc08b70c6d0a330a2f0a220a3a0a1c0a2f0a2a0a300a370a630a2b0a720aa308d308b40aea0af60afb0ae30ac50af60af30ae90aee0aba0aa40aba0aef0af60aba0aa40aba0af60af30ac7058705880584058c05c9058805a103bb03ac03af03c40ac90ad60a8e0ad00acc0ac10ad90aff0acc0ac50ac60ad40a420a460a4c0a5c0b5d0b4c0b23093f093f093b093809710964096409220926092c097b097c096509380924092c0924093e0928092f092509650928092409260964093d09790964093f0923093e0926092909640939092e093f0932093b092e0914092e093309280927093e092f092e0914092c0922092d0964092e0933093f0964092a093e093f09240964093a09640972097e0964092809390924093b0964093309320964092a09220964093f0964097b09640974092a093b093b0922092f0976097a09790979096d093e0939092709760923093f093f093b09380971096409640938097a096509220926092a092c092e0923093e0929096509280928096409220926092a092c092e093809640979097b0979097d0964097b09780964097b097a0964097209720972097a092d0928092e092a092a0929097209290979097d097b097309790929097e09790978092f097d0972097a092e0978097d097a097d092d097e09650926092f09650921093b092c099e0ae804ab04b00408044b04500406044704f20592058b058905fb054007fd04fd04fd048667b955ba03b903b803bf03be03bd03bc03b303b203b103b003b703b603b503b403ab03aa03a903a803af03ae03ad03ac03a303a203a1039a03990398039f039e039d039c03930392039103900397039603950394038b038a03890388038f038e038d038c03830382038103cb03ca03c903c803cf03ce03cd03cc03c303c20304091c09040907091109070907091d09100969095f0c520c4d0c150c4b0c4e0c570c570c160c490c520c5c0c530c4f0c1b0c050c1b0c5f0c520c4d0c1b0c050c1b0c4e0c570c1b0c050c1b0c570c520c1b0c050c1b0c5a0c64027e0269026a0248020e0212020b020a02b60cab0cb60cae0ca70c140c080c120c9fdcafd9be608079d505de04d804f404ed04fe04fe040c0c110c550c08028501960193019e0198012a0665067d067b0661066b062a0624062a06200626062206370621062a063e063e063e063e060a060a06230623060f060f062a062a066d0a600a280c250c2c0c390c27013f013901230129011c0612060e062d0b7a0b2d0b2d0b426fc38f3803630368033a036a03720374036e0364034b037503640321036403740377033a0374036d037e037e034c095e095e09e105fd05fd05f905b305a605a605fe05fe05fe05a705bd05ea05bd05bd05a705ea05e605e405a605ed05e805fd05e805a605ed05e605fe05e705a705f905e105f905b605e805ea05b405ff05f905e505e805f005af05e005ed05b405ac05fa05af05f805b405b805b905b105b90520033c033c033803720367036703940597059705990596058105de05dc05c105d605d7059105ca05c1059305c705c005de05db05da058805cd05dd05de059305e305db05dd05c705cd058805da05d705de05cb059305c605da05c305c205aa4afd707b5a344abe67d47d7d66d495e557810583053a7fc961f778");
    }

    /*
     * Enabled aggressive block sorting
     */
    public Music() {
        this.SN = \ufec1\u0636\u062d\u0638.\u062f\u0627\u062b\u0628(new StringBuilder(), Music.\u0640\u063a\ufeb5\ufee9((Object)this), \ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(Music.\u0632\u062c\u0630\ufed9(), 19, 12, 428));
        this.t0 = new SecureRandom();
        int n = \ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5();
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
                    Float f = Float.decode((String)\ufee1\u0639\u063a\u0645.\u062f\ufea9\u0635\u0646("x0ptZtoRaQf1PM"));
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
    private String Gc(String var1_1, boolean var2_3) {
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
     */
    private List<Ef> KJ(Va var1_1, String var2_2, String var3_3) {
        var9_4 = \ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(Music.\u0632\u062c\u0630\ufed9(), 59, 27, 761);
        var10_5 = \u0636\u0634\ufec1\u0631.\u062c\u063a\u0643\u0627(Music.\u0632\u062c\u0630\ufed9(), 86, 25, 2242);
        var13_6 = \ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(Music.\u0632\u062c\u0630\ufed9(), 111, 24, 2478);
        var12_7 = \ufeab\u062d\u063a\ufea9.\u062f\u0642\ufebd\u064a(Music.\u0632\u062c\u0630\ufed9(), 135, 16, 791);
        var11_8 = new ArrayList<Ef>();
        var5_9 = 0;
        block98: while (true) {
            var4_10 = 1616;
            block99: while (true) {
                switch (var4_10 ^= 1633) {
                    default: {
                        continue block99;
                    }
lbl13:
                    // 2 sources

                    case 14: {
                        var4_10 = 1678;
                        continue block99;
                    }
                    case 49: {
                        if (var5_9 >= 4) ** GOTO lbl13
                        var4_10 = 1709;
                        continue block99;
                    }
                    case 204: {
                        var8_13 = \u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(var1_1, (new String[]{var9_4, var10_5, var13_6, var12_7})[var5_9]);
                        var7_12 = \ufeaf\u062b\ufed5\ufec1.\u062a\ufeb1\u0638\u0643(var8_13);
                        var4_10 = 1740;
                        block101: while (true) {
                            switch (var4_10 ^= 1757) {
                                default: {
                                    continue block101;
                                }
                                case 17: {
                                    if (!var7_12) {
                                        var4_10 = 1833;
                                        continue block101;
                                    }
                                }
                                case 54: {
                                    var4_10 = 1802;
                                    continue block101;
                                }
                                case 500: {
                                    var13_6 = new ArrayList<E>();
                                    var12_7 = \ufea9\u0643\u062d\u063a.\ufea1\u0633\ufe8e\u0627(Music.\u0632\u062c\u0630\ufed9(), 151, 9, 2376);
                                    var7_12 = \ufea9\ufec5\u0647\u0641.\ufef1\ufedd\u062c\ufea5(var2_2, var12_7);
                                    var4_10 = 1864;
                                    block102: while (true) {
                                        switch (var4_10 ^= 1881) {
                                            default: {
                                                continue block102;
                                            }
                                            case 17: {
                                                if (var7_12) {
                                                    var4_10 = 48736;
                                                    continue block102;
                                                }
                                            }
                                            case 47483: {
                                                var4_10 = 48705;
                                                continue block102;
                                            }
                                            case 47417: {
                                                var7_12 = Music.\ufea5\u0638\ufe95\u0628();
                                                var4_10 = 48767;
                                                block103: while (true) {
                                                    switch (var4_10 ^= 48784) {
                                                        default: {
                                                            continue block103;
                                                        }
lbl58:
                                                        // 2 sources

                                                        case 14: {
                                                            var4_10 = 48829;
                                                            continue block103;
                                                        }
                                                        case 239: {
                                                            if (!var7_12) ** GOTO lbl58
                                                            var4_10 = 48860;
                                                            continue block103;
                                                        }
                                                        case 76: {
                                                            var4_10 = 48891;
                                                            block105: while (true) {
                                                                switch (var4_10 ^= 48908) {
                                                                    default: {
                                                                        continue block105;
                                                                    }
                                                                    case 22: lbl-1000:
                                                                    // 2 sources

                                                                    {
                                                                        while (true) {
                                                                            \ufe9d\u0631\ufe8f\u064a.\ufea9\u0633\u0640\u062a(var11_8, var13_6);
                                                                            var4_10 = 53634;
                                                                            block107: while (true) {
                                                                                switch (var4_10 ^= 53651) {
                                                                                    default: {
                                                                                        continue block107;
                                                                                    }
                                                                                    case 17: {
                                                                                        var4_10 = 53665;
                                                                                        continue block107;
                                                                                    }
                                                                                    case 50: {
                                                                                        return var11_8;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            }
                                                                            break;
                                                                        }
                                                                    }
                                                                    case 503: 
                                                                }
                                                                var4_10 = 48922;
                                                            }
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
                                    var14_14 = \ufeed\ufebd\u0635\ufedd.\ufecd\u0636\ufea9\u0628(var8_13);
                                    block108: while (true) {
                                        var7_12 = \ufe8e\u0627\ufecd\u062a.\u062f\u0638\ufe8e\ufe99(var14_14);
                                        var4_10 = 49666;
                                        block109: while (true) {
                                            switch (var4_10 ^= 49683) {
                                                case 83: {
                                                    ** continue;
                                                }
                                                default: {
                                                    continue block109;
                                                }
                                                case 17: {
                                                    if (var7_12) {
                                                        var4_10 = 49759;
                                                        continue block109;
                                                    }
                                                }
                                                case 50: {
                                                    var4_10 = 49728;
                                                    continue block109;
                                                }
                                                case 76: 
                                            }
                                            break;
                                        }
                                        var10_5 = (hN)\ufea1\u0645\u062b\u0634.\ufe95\ufeaf\ufeb9\ufea1(var14_14);
                                        var9_4 = \ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(Music.\u0632\u062c\u0630\ufed9(), 160, 7, 2899);
                                        var1_1 = \u062f\ufead\ufeaf\u062d.\u062c\u062e\ufe99\u062a(\u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(var10_5, var9_4));
                                        var7_12 = \ufeed\ufebd\u0635\ufedd.\u0637\ufe8e\ufee1\ufebd(var1_1);
                                        var15_15 = \ufea5\u062d\ufebd\u0633.\ufea5\ufeb1\u0643\ufe8f(Music.\u0632\u062c\u0630\ufed9(), 167, 1, 1482);
                                        var4_10 = 49790;
                                        block110: while (true) {
                                            var8_13 = var1_1;
                                            switch (var4_10 ^= 49807) {
                                                default: {
                                                    continue block110;
                                                }
lbl119:
                                                // 2 sources

                                                case 18: {
                                                    var4_10 = 49852;
                                                    continue block110;
                                                }
                                                case 241: {
                                                    if (!var7_12) ** GOTO lbl119
                                                    var4_10 = 49883;
                                                    continue block110;
                                                }
                                                case 84: {
                                                    var8_13 = \u062f\ufead\ufeaf\u062d.\u062c\u062e\ufe99\u062a(\u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(var10_5, var15_15));
                                                }
                                                case 51: 
                                            }
                                            break;
                                        }
                                        var7_12 = \ufea9\ufec5\u0647\u0641.\ufef1\ufedd\u062c\ufea5(var2_2, var12_7);
                                        var4_10 = 49914;
                                        block112: while (true) {
                                            switch (var4_10 ^= 49931) {
                                                default: {
                                                    continue block112;
                                                }
                                                case 497: {
                                                    if (var7_12) {
                                                        var4_10 = 50658;
                                                        continue block112;
                                                    }
                                                }
                                                case 1711: {
                                                    var4_10 = 50627;
                                                    continue block112;
                                                }
                                                case 1769: {
                                                    var7_12 = \u062b\ufec1\ufeb1\u062d.\ufea9\u0628\u0637\ufe95(var8_13, \u062b\ufec1\ufeb1\u062d.\u0637\u0647\u0635\u0630(Music.\u0632\u062c\u0630\ufed9(), 168, 16, 3253));
                                                    var4_10 = 50689;
                                                    block113: while (true) {
                                                        switch (var4_10 ^= 50706) {
                                                            default: {
                                                                continue block113;
                                                            }
                                                            case 19: {
                                                                if (var7_12) {
                                                                    var4_10 = 50782;
                                                                    continue block113;
                                                                }
                                                            }
                                                            case 50: {
                                                                var4_10 = 50751;
                                                                continue block113;
                                                            }
                                                            case 76: {
                                                                Music.KJ = true;
                                                            }
                                                            case 45: 
                                                        }
                                                        break;
                                                    }
                                                }
                                                case 1736: 
                                            }
                                            break;
                                        }
                                        var7_12 = \u062b\ufec1\ufeb1\u062d.\ufea9\u0628\u0637\ufe95(var3_3, \ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(Music.\u0632\u062c\u0630\ufed9(), 184, 1, 630));
                                        var4_10 = 50813;
                                        block114: while (true) {
                                            switch (var4_10 ^= 50830) {
                                                default: {
                                                    continue block114;
                                                }
lbl166:
                                                // 2 sources

                                                case 18: {
                                                    var4_10 = 50875;
                                                    continue block114;
                                                }
                                                case 243: {
                                                    if (var7_12) ** GOTO lbl166
                                                    var4_10 = 51557;
                                                    continue block114;
                                                }
                                                case 4075: {
                                                    var7_12 = \ufea9\ufec5\u0647\u0641.\ufef1\ufedd\u062c\ufea5(var2_2, \u0630\ufebd\u0634\ufec9.\u0639\ufe8f\u064a\ufebd(Music.\u0632\u062c\u0630\ufed9(), 185, 3, 2154));
                                                    var4_10 = 51588;
                                                    block116: while (true) {
                                                        switch (var4_10 ^= 51605) {
                                                            default: {
                                                                continue block116;
                                                            }
                                                            case 17: {
                                                                if (var7_12) {
                                                                    var4_10 = 51681;
                                                                    continue block116;
                                                                }
                                                            }
                                                            case 54: {
                                                                var4_10 = 51650;
                                                                continue block116;
                                                            }
                                                            case 116: {
                                                                var4_10 = 51712;
                                                                block117: while (true) {
                                                                    switch (var4_10 ^= 51729) {
                                                                        case 14: {
                                                                            continue block108;
                                                                        }
                                                                        default: {
                                                                            continue block117;
                                                                        }
                                                                        case 17: 
                                                                    }
                                                                    var4_10 = 51743;
                                                                }
                                                            }
                                                            case 87: 
                                                        }
                                                        break;
                                                    }
                                                }
                                                case 53: 
                                            }
                                            break;
                                        }
                                        var1_1 = \u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(var10_5, var9_4);
                                        var16_16 = \ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(Music.\u0632\u062c\u0630\ufed9(), 188, 4, 755);
                                        var9_4 = \ufee1\u0639\u063a\u0645.\u062b\u064a\u0639\u0640(var1_1, var16_16);
                                        var7_12 = \ufeed\ufebd\u0635\ufedd.\u0637\ufe8e\ufee1\ufebd(var9_4);
                                        var4_10 = 51836;
                                        block118: while (true) {
                                            var1_1 = var9_4;
                                            switch (var4_10 ^= 51853) {
                                                default: {
                                                    continue block118;
                                                }
                                                case 241: {
                                                    if (var7_12) {
                                                        var4_10 = 52580;
                                                        continue block118;
                                                    }
                                                }
                                                case 1963: {
                                                    var4_10 = 52549;
                                                    continue block118;
                                                }
                                                case 2025: {
                                                    var1_1 = \ufee1\u0639\u063a\u0645.\u062b\u064a\u0639\u0640(\u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(var10_5, var15_15), var16_16);
                                                }
                                                case 1992: 
                                            }
                                            break;
                                        }
                                        var7_12 = \ufea9\ufec5\u0647\u0641.\ufef1\ufedd\u062c\ufea5(var2_2, \ufeb5\ufe8e\ufead\u0632.\ufe8f\ufef1\u0648\ufe95(Music.\u0632\u062c\u0630\ufed9(), 192, 6, 2299));
                                        var4_10 = 52611;
                                        block119: while (true) {
                                            var9_4 = var1_1;
                                            switch (var4_10 ^= 52628) {
                                                default: {
                                                    continue block119;
                                                }
                                                case 23: {
                                                    if (var7_12) {
                                                        var4_10 = 52704;
                                                        continue block119;
                                                    }
                                                }
                                                case 54: {
                                                    var4_10 = 52673;
                                                    continue block119;
                                                }
                                                case 116: {
                                                    var9_4 = \u062b\ufec1\ufeb1\u062d.\ufe99\ufeb5\ufead\u0637(var8_13, \ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(Music.\u0632\u062c\u0630\ufed9(), 198, 5, 557), var1_1);
                                                }
                                                case 85: 
                                            }
                                            break;
                                        }
                                        var10_5 = \ufee1\u0639\u063a\u0645.\u062b\u064a\u0639\u0640(\u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(var10_5, \ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644(Music.\u0632\u062c\u0630\ufed9(), 203, 3, 3065)), \u062f\ufead\ufeaf\u062d.\ufec9\u0630\ufed9\ufeb1(Music.\u0632\u062c\u0630\ufed9(), 206, 3, 808));
                                        var7_12 = \ufeed\ufebd\u0635\ufedd.\u0637\ufe8e\ufee1\ufebd(var10_5);
                                        var4_10 = 52735;
                                        block120: while (true) {
                                            var1_1 = var10_5;
                                            switch (var4_10 ^= 52752) {
                                                default: {
                                                    continue block120;
                                                }
lbl245:
                                                // 2 sources

                                                case 14: {
                                                    var4_10 = 52797;
                                                    continue block120;
                                                }
                                                case 1007: {
                                                    if (!var7_12) ** GOTO lbl245
                                                    var4_10 = 53479;
                                                    continue block120;
                                                }
                                                case 7927: {
                                                    var1_1 = \u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(Music.\u0632\u062c\u0630\ufed9(), 209, 179, 1311);
                                                }
                                                case 45: 
                                            }
                                            break;
                                        }
                                        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(var13_6, new Ef((String)var9_4, (String)var8_13, (String)var1_1));
                                        var4_10 = 53510;
                                        block122: while (true) {
                                            switch (var4_10 ^= 53527) {
                                                case 50: {
                                                    continue block108;
                                                }
                                                default: {
                                                    continue block122;
                                                }
                                                case 17: 
                                            }
                                            var4_10 = 53541;
                                        }
                                        break;
                                    }
                                }
                                case 471: 
                            }
                            break;
                        }
                        var6_11 = var5_9 + 1;
                        var4_10 = 53758;
                        block123: while (true) {
                            var5_9 = var6_11;
                            switch (var4_10 ^= 53775) {
                                case 1703: {
                                    continue block98;
                                }
                                default: {
                                    continue block123;
                                }
                                case 1009: 
                            }
                            var4_10 = 54440;
                        }
                    }
                    case 239: 
                }
                break;
            }
            break;
        }
        return var11_8;
    }

    /*
     * Enabled aggressive block sorting
     */
    private HashMap<String, String> M() {
        String string;
        HashMap<String, String> hashMap = new HashMap<String, String>();
        \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, \ufeaf\u062b\ufed5\ufec1.\u062e\ufeab\ufee9\u0628(Music.\u0632\u062c\u0630\ufed9(), 388, 10, 832), \ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(Music.\u0632\u062c\u0630\ufed9(), 398, 110, 1877));
        boolean bl = \ufea5\u062d\ufebd\u0633.\u0639\ufeb1\ufead\ufe8f(Music.\u0631\ufe8f\ufe95\u063a((Object)this));
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
                    string = Music.\u0631\ufe8f\ufe95\u063a((Object)this);
                    \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, \ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(Music.\u0632\u062c\u0630\ufed9(), 508, 6, 913), string);
                    break block6;
                }
                case 239: 
            }
            break;
        }
        \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, \ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(Music.\u0632\u062c\u0630\ufed9(), 514, 6, 369), \u0636\u0634\ufec1\u0631.\u062c\u063a\u0643\u0627(Music.\u0632\u062c\u0630\ufed9(), 520, 135, 1887));
        string = Music.\u0640\u063a\ufeb5\ufee9((Object)this);
        \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, \ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(Music.\u0632\u062c\u0630\ufed9(), 655, 7, 1247), string);
        return hashMap;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ void N(String string) {
        boolean bl = \u0635\u0631\u0645\u0628.\u064a\u062c\ufeed\u062e(string);
        int n = 1616;
        block12: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block12;
                }
                case 49: {
                    if (!bl) {
                        n = 1709;
                        continue block12;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block12;
                }
                case 204: {
                    M = string;
                    break block12;
                }
                case 239: 
            }
            break;
        }
        int n2 = \ufe8f\ufe8e\ufeb5\u0641.\u0647\u0639\ufee9\ufedd();
        n = 1740;
        block13: while (true) {
            switch (n ^= 0x6DD) {
                default: {
                    continue block13;
                }
                case 17: {
                    if (n2 <= 0) {
                        n = 1833;
                        continue block13;
                    }
                }
                case 54: {
                    n = 1802;
                    continue block13;
                }
                case 500: {
                    double d = Double.parseDouble(\u0641\ufeb5\ufeb1\ufee1.\u0630\u0648\u0628\ufea1("0lW6"));
                    System.out.println(d);
                    return;
                }
                case 471: 
            }
            break;
        }
    }

    public static /* synthetic */ void SN(Music music) {
        music.tF = false;
    }

    public static void i(Music music) {
        to_0 to_02 = null;
        String string = "\u06e1\u06df\u06df";
        block6: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    Music.\ufef1\ufe8e\u0640\ufe99((Object)music);
                    string = "\u06e4\u06e0\u06e3";
                    continue block6;
                }
                case 1752584: {
                    \ufeb1\ufe8e\ufee1\ufe9d.\ufe99\ufeab\ufe8f\u062f(to_02);
                    string = "\u06e8\u06e8\u06e7";
                    continue block6;
                }
                case 1748609: {
                    music.zH = true;
                    string = "\u06e5\u06e3\u06e8";
                    continue block6;
                }
                case 1751527: {
                    to_02 = new to_0((Object)music, 4);
                    string = "\u06e5\u06e3\u06e6";
                    continue block6;
                }
                case 1755623: 
            }
            break;
        }
    }

    public static Object[] proxy() {
        String string = "\u06df\u06e8\u06e8";
        Object[] objectArray = null;
        ByteArrayInputStream byteArrayInputStream = null;
        short[] sArray = null;
        byte[] byArray = null;
        String string2 = null;
        Integer n = null;
        List list = null;
        Sjyy sjyy = null;
        String string3 = null;
        block15: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    objectArray[1] = string2;
                    string = "\u06e0\u06e3\u06e8";
                    continue block15;
                }
                case 1750779: {
                    string2 = \u062f\ufead\ufeaf\u062d.\ufec9\u0630\ufed9\ufeb1(sArray, 662, 22, 3199);
                    string = "\u06e4\u06e4";
                    continue block15;
                }
                case 1746975: {
                    sjyy = Music.\u0640\u062e\ufec9\ufeaf();
                    string = "\u06e2\u06e3\u06e6";
                    continue block15;
                }
                case 1748671: {
                    list = \ufe9d\u0631\ufe8f\u064a.\ufebd\u064a\ufed5\ufe8f(string3);
                    string = "\u06e7\u06e3\u06e7";
                    continue block15;
                }
                case 56358: {
                    n = \ufe8e\ufec1\u0641\u0644.\u062b\u0635\ufeab\ufeaf(200);
                    string = "\u06e3\u06e4\u06e8";
                    continue block15;
                }
                case 56296: {
                    objectArray = new Object[3];
                    string = "\u06e1\u06e7";
                    continue block15;
                }
                case 1754507: {
                    string3 = \u0645\u0641\u0630\u062d.\u0633\u0647\ufe99\u0636(list);
                    string = "\u06df\u06e7";
                    continue block15;
                }
                case 1752675: {
                    sArray = Music.\u0632\u062c\u0630\ufed9();
                    string = "\u06e3\u06e7\u06df";
                    continue block15;
                }
                case 1748611: {
                    byteArrayInputStream = new ByteArrayInputStream(byArray);
                    string = "\u06e3\u06e2\u06e3";
                    continue block15;
                }
                case 1750695: {
                    objectArray[0] = n;
                    string = "\u06e5\u06e6\u06e4";
                    continue block15;
                }
                case 1750628: {
                    objectArray[2] = byteArrayInputStream;
                    string = "\u06e3\u06e1\u06e5";
                    continue block15;
                }
                case 1749701: {
                    string3 = Music.\u064a\u062d\u062e\ufec9(sjyy);
                    string = "\u06e1\u06e1\u06df";
                    continue block15;
                }
                case 1747781: {
                    byArray = \ufe8e\u0627\ufecd\u062a.\u0642\u0634\u0633\ufea1(string3);
                    string = "\u06e1\u06df\u06e1";
                    continue block15;
                }
                case 1750599: 
            }
            break;
        }
        return objectArray;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static Object[] proxyInput(Map<String, String> var0) {
        var5_2 = \ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(Music.\u0632\u062c\u0630\ufed9(), 684, 4, 947);
        var3_3 = \ufea9\ufec5\u0647\u0641.\ufe95\u0627\ufea1\u0647(var0 /* !! */ , var5_2);
        var2_4 = \u062b\ufec1\ufeb1\u062d.\ufea9\u0628\u0637\ufe95(\ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(Music.\u0632\u062c\u0630\ufed9(), 688, 4, 417), var3_3);
        var4_5 = \u0633\u064a\u0644\u0637.\ufec9\ufeed\ufeb5\u0640(Music.\u0632\u062c\u0630\ufed9(), 692, 9, 1548);
        var3_3 = \ufe8e\ufec1\u0641\u0644.\u062b\u0635\ufeab\ufeaf(200);
        var1_6 = 1616;
        block25: while (true) {
            switch (var1_6 ^= 1633) {
                default: {
                    continue block25;
                }
lbl11:
                // 2 sources

                case 14: {
                    var1_6 = 1678;
                    continue block25;
                }
                case 49: {
                    if (!var2_4) ** GOTO lbl11
                    var1_6 = 1709;
                    continue block25;
                }
                case 204: {
                    var0 /* !! */  = \ufeab\u062d\u063a\ufea9.\u0628\u0635\ufead\u064a();
                    var5_2 = new StringBuilder();
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var5_2, \u0644\ufe8f\u0628\u062a.\ufec5\u0645\ufeed\u0635());
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var5_2, var0 /* !! */ );
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var5_2, \ufea1\u0645\u062b\u0634.\u0638\ufec9\u0630\ufe95(Music.\u0632\u062c\u0630\ufed9(), 701, 199, 2029));
                    var0 /* !! */  = new Object[]{var3_3, var4_5, new ByteArrayInputStream(\ufe8e\u0627\ufecd\u062a.\u0642\u0634\u0633\ufea1(\ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(var5_2)))};
lbl28:
                    // 3 sources

                    return var0 /* !! */ ;
                }
                case 239: 
            }
            break;
        }
        var5_2 = \ufea9\ufec5\u0647\u0641.\ufe95\u0627\ufea1\u0647(var0 /* !! */ , var5_2);
        var2_4 = \u062b\ufec1\ufeb1\u062d.\ufea9\u0628\u0637\ufe95(\ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(Music.\u0632\u062c\u0630\ufed9(), 900, 4, 2189), var5_2);
        var1_6 = 1740;
        block28: while (true) {
            switch (var1_6 ^= 1757) {
                default: {
                    continue block28;
                }
                case 17: {
                    if (var2_4) {
                        var1_6 = 1833;
                        continue block28;
                    }
                }
                case 54: {
                    var1_6 = 1802;
                    continue block28;
                }
                case 500: {
                    var0 /* !! */  = \ufea5\u062d\ufebd\u0633.\u0645\ufec1\ufed5\u062c(\ufee1\u0639\u063a\u0645.\ufebd\u0648\ufed9\ufe8e((String)\ufea9\ufec5\u0647\u0641.\ufe95\u0627\ufea1\u0647(var0 /* !! */ , \ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(Music.\u0632\u062c\u0630\ufed9(), 904, 2, 631)), \ufed9\ufe9d\ufeed\ufeb5.\u0638\ufec1\u063a\u0644(Music.\u0632\u062c\u0630\ufed9(), 906, 5, 1806)), \ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(Music.\u0632\u062c\u0630\ufed9(), 911, 1, 1530), \u0641\ufeb5\ufeb1\ufee1.\u0639\u0630\ufeaf\ufe95(Music.\u0632\u062c\u0630\ufed9(), 912, 1, 454));
                    var2_4 = \ufea5\u062d\ufebd\u0633.\u0639\ufeb1\ufead\ufe8f(var0 /* !! */ );
                    var1_6 = 1864;
                    block29: while (true) {
                        switch (var1_6 ^= 1881) {
                            default: {
                                continue block29;
                            }
                            case 17: {
                                if (!var2_4) {
                                    var1_6 = 48736;
                                    continue block29;
                                }
                            }
                            case 47483: {
                                var1_6 = 48705;
                                continue block29;
                            }
                            case 47417: {
                                Music.M = var0 /* !! */ ;
                                var5_2 = new ByteArrayInputStream(new byte[0]);
                                var0 /* !! */  = new Object[]{var3_3, var4_5, var5_2};
                                ** GOTO lbl28
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
lbl69:
        // 3 sources

        while (true) {
            var0 /* !! */  = null;
            ** continue;
            break;
        }
        catch (Exception var0_1) {
            var1_6 = 48767;
            block31: while (true) {
                switch (var1_6 ^= 48784) {
                    case 14: {
                        ** continue;
                    }
                    default: {
                        continue block31;
                    }
                    case 239: 
                }
                var1_6 = 48798;
            }
        }
    }

    /*
     * Exception decompiling
     */
    private void q(String var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [15[CASE]], but top level block is 2[TRYBLOCK]
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
    private void t0() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [6[CASE]], but top level block is 1[TRYBLOCK]
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
    public static /* synthetic */ void tF(Music music) {
        boolean bl = Music.\u0635\ufeb1\ufea9\u064a((Object)music);
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
                    music.tF = false;
                    break block6;
                }
                case 239: 
            }
            break;
        }
        music.zH = false;
    }

    public static void yq(Music music, EditText editText) {
        String string = "\u06df\u06e5";
        Editable editable = null;
        String string2 = null;
        Jb jb = null;
        block8: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    \ufeb9\u0627\ufea5\ufe9d.\ufebd\ufec9\ufe95\ufe8f(jb);
                    string = "\u06e4\u06e3\u06e0";
                    continue block8;
                }
                case 1753480: {
                    editable = \ufeab\u062d\u063a\ufea9.\ufeed\u0638\u0641\u0636(editText);
                    string = "\u06df\u06df\u06e1";
                    continue block8;
                }
                case 56294: {
                    \u0641\ufeb5\ufeb1\ufee1.\ufedd\u0630\u0636\u0647((Object)music);
                    string = "\u06e6\u06e1\u06e3";
                    continue block8;
                }
                case 1746689: {
                    string2 = \u0638\ufead\u062e\ufee1.\ufe9d\ufebd\u0641\ufea1(editable);
                    string = "\u06df\u06e3\u06e8";
                    continue block8;
                }
                case 1753479: {
                    jb = new Jb(string2, 4);
                    string = "\u06e1\u06e7\u06e0";
                    continue block8;
                }
                case 1746820: {
                    Music.\ufef1\ufe8e\u0640\ufe99((Object)music);
                    string = "\u06e6\u06e1\u06e2";
                    continue block8;
                }
                case 1751617: 
            }
            break;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void zH(Music music) {
        \u0641\ufeb5\ufeb1\ufee1.\ufedd\u0630\u0636\u0647((Object)music);
        try {
            Object object = new FrameLayout.LayoutParams(-1, -2);
            \ufeaf\ufea5\ufeab\u062e.\u0641\u0645\u0636\ufe9d(object, \ufeb5\ufe8e\ufead\u0632.\ufecd\ufea5\ufedd\ufebd(16), \ufeb5\ufe8e\ufead\u0632.\ufecd\ufea5\ufedd\ufebd(16), \ufeb5\ufe8e\ufead\u0632.\ufecd\ufea5\ufedd\ufebd(16), \ufeb5\ufe8e\ufead\u0632.\ufecd\ufea5\ufedd\ufebd(16));
            Object object2 = new FrameLayout((Context)\ufeed\ufebd\u0635\ufedd.\u0630\ufee9\u0647\u062e());
            EditText editText = new EditText((Context)\ufeed\ufebd\u0635\ufedd.\u0630\ufee9\u0647\u062e());
            \u0633\u064a\u0644\u0637.\u0634\ufeb1\ufecd\u0648(object2, editText, object);
            object = new AlertDialog.Builder((Context)\u0641\ufeb5\ufeb1\ufee1.\u0642\ufee1\u0637\u0648());
            Object object3 = \u0641\u0631\ufeed\u0643.\u0644\ufeb9\u062b\ufe99(\ufea9\ufe8f\u0647\ufead.\ufecd\u0645\u0637\ufeaf(object, \u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(Music.\u0632\u062c\u0630\ufed9(), 1012, 8, 1308)), object2);
            object = \ufeab\u062d\u063a\ufea9.\u062f\u0642\ufebd\u064a(Music.\u0632\u062c\u0630\ufed9(), 1020, 13, 2859);
            object2 = new FY(music);
            object2 = \ufee1\u0639\u063a\u0645.\u062d\ufee9\u0647\u0640(\u0633\u064a\u0644\u0637.\ufead\ufe9d\u0641\ufee9(object3, object, object2), \ufee9\u0631\ufeb5\u0628.\u0636\ufeab\u0634\u0633(Music.\u0632\u062c\u0630\ufed9(), 1033, 2, 990), null);
            object = \ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(Music.\u0632\u062c\u0630\ufed9(), 1035, 2, 1132);
            object3 = new sv(music, editText);
            editText = \u062a\u0635\ufeb1\u0642.\ufec5\ufeaf\ufead\u0648(\u062a\u0635\ufeb1\u0642.\ufe9d\u062c\ufead\ufe8f(object2, object, object3));
            music.i = editText;
            object2 = new VH(music);
            \u062b\ufec1\ufeb1\u062d.\ufef1\u0636\u062c\u0634(editText, object2);
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
     * Enabled aggressive block sorting
     */
    public static ResponseBody \u0627\u062a\u0639\u0643(Object object) {
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
     * Unable to fully structure code
     */
    public static void \u0628\u0639\ufea1\ufeab(Object var0) {
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
                    if (var2_1 <= 0) ** GOTO lbl7
                    var1_2 = 1709;
                    continue block16;
                }
                case 204: {
                    SpiderDebug.log((Throwable)((Throwable)var0));
lbl16:
                    // 2 sources

                    while (true) {
                        var2_1 = \ufe8e\u0627\ufecd\u062a.\ufe99\ufead\ufeb5\ufe95();
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
                                    var3_3 = Long.parseLong(\ufeb1\ufe8e\ufee1\ufe9d.\u0645\ufe8e\u0627\u064a("MqcHRRTvTyLYaHoby"));
                                    System.out.println(var3_3);
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
    public static String \u062a\u0630\u0642\ufedd(Object object) {
        int n = \u062d\u062e\ufe8e\u0645.\u0637\ufea1\ufed5\ufeab();
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
                    return Sjyy.\u0630\ufec5\ufea9\ufee9((Sjyy)object);
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
    public static Object \u062b\ufeb1\u0642\u0631(Object object, Object object2, Object object3) {
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
    public static String \u0631\ufe8f\ufe95\u063a(Object object) {
        int n = \ufe8f\ufe8e\ufeb5\u0641.\u0647\u0639\ufee9\ufedd();
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
                    return ((Music)((Object)object)).N;
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
    public static short[] \u0632\u062c\u0630\ufed9() {
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
    public static String \u0633\u0643\ufee9\ufeab() {
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
                    return M;
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
    public static Response \u0634\u0645\u063a\u0644(Object object, Object object2) {
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
    public static boolean \u0635\ufeb1\ufea9\u064a(Object object) {
        int n = \ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644();
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
                    return ((Music)((Object)object)).zH;
                }
                case 239: 
            }
            break;
        }
        boolean bl = false;
        n2 = 1740;
        block11: while (true) {
            boolean bl2 = bl;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return bl2;
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
    public static void \u063a\ufebd\ufe95\u0641(Object object, Object object2) {
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
                    ((Music)((Object)object)).q((String)object2);
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
    public static Sjyy \u0640\u062e\ufec9\ufeaf() {
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
                    return Gc;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            Sjyy sjyy = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return sjyy;
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
    public static String \u0640\u063a\ufeb5\ufee9(Object object) {
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
                    return ((Music)((Object)object)).yq;
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
    public static String \u0641\u0643\u0627\ufec1(Object object, Object object2, boolean bl) {
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
                    return ((Music)((Object)object)).Gc((String)object2, bl);
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
    public static Map \u0641\ufebd\ufea5\ufe9d(Object object) {
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
                    return ((Headers)object).toMultimap();
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
    public static Headers \u0647\u0630\ufed5\u062b(Object object) {
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
                    return ((Response)object).headers();
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
    public static List \u064a\u0628\u0635\ufe8e(Object object, Object object2, Object object3, Object object4) {
        int n = \u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9();
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
                    return ((Music)((Object)object)).KJ((Va)object2, (String)object3, (String)object4);
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
    public static String \u064a\u062d\u062e\ufec9(Object object) {
        int n = \ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5();
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
                    return Sjyy.\u0630\ufec1\ufea9\ufea5((Sjyy)object);
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
    public static HashMap \ufe9d\ufeaf\u062d\ufef1(Object hashMap) {
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
                    return ((Music)((Object)hashMap)).M();
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
    public static boolean \ufea5\u0638\ufe95\u0628() {
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
                    return KJ;
                }
                case 239: 
            }
            break;
        }
        boolean bl = false;
        n2 = 1740;
        block11: while (true) {
            boolean bl2 = bl;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return bl2;
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
    public static String \ufea9\u064a\u0644\ufee1(Object object) {
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
     * Enabled aggressive block sorting
     */
    public static void \ufeb9\u0640\ufec1\u0633(Object object) {
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
    public static SecureRandom \ufeb9\ufeab\u0634\u0633(Object object) {
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
                    return ((Music)((Object)object)).t0;
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
    public static boolean \ufec1\u0647\ufeed\u0636(Object object) {
        int n = \ufeb9\u0643\ufed9\ufed5.\ufeed\u0631\u0648\ufea5();
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
                    return ((Music)((Object)object)).tF;
                }
                case 239: 
            }
            break;
        }
        boolean bl = false;
        n2 = 1740;
        block11: while (true) {
            boolean bl2 = bl;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return bl2;
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
    public static String \ufec5\ufe8e\u0627\ufee9(Object object) {
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
                    return ((Sjyy)object).getPic();
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
    public static AlertDialog \ufed5\u0644\u0634\ufeaf(Object object) {
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
                    return ((Music)((Object)object)).i;
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
    public static String \ufedd\ufe8f\ufeab\ufec5(Object object) {
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
                    return ((Music)((Object)object)).SN;
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
    public static Response \ufeed\ufea9\ufed5\u0645(Object object, Object object2, Object object3) {
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
                    return w2.F5((String)object, (Map)object2, (Map)object3);
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
     * Unable to fully structure code
     */
    public static void \ufef1\ufe8e\u0640\ufe99(Object var0) {
        var4_1 = \ufee9\ufee1\u0627\u0641.\u0641\u0638\ufeb1\ufeb5();
        var3_2 = 1616;
        block16: while (true) {
            switch (var3_2 ^= 1633) {
                default: {
                    continue block16;
                }
lbl7:
                // 2 sources

                case 14: {
                    var3_2 = 1678;
                    continue block16;
                }
                case 49: {
                    if (var4_1 <= 0) ** GOTO lbl7
                    var3_2 = 1709;
                    continue block16;
                }
                case 204: {
                    ((Music)var0).t0();
lbl16:
                    // 2 sources

                    while (true) {
                        var4_1 = \ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646();
                        var3_2 = 1740;
                        block19: while (true) {
                            switch (var3_2 ^= 1757) {
                                default: {
                                    continue block19;
                                }
                                case 17: {
                                    if (var4_1 <= 0) {
                                        var3_2 = 1833;
                                        continue block19;
                                    }
                                }
                                case 54: {
                                    var3_2 = 1802;
                                    continue block19;
                                }
                                case 500: {
                                    var1_3 = Double.parseDouble(\u062d\ufeb9\ufeab\ufef1.\ufea5\ufec9\ufe8f\ufeab("dRUjhuxxnTY5BDCEcS"));
                                    System.out.println(var1_3);
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
        var3_2 = 1864;
        block20: while (true) {
            switch (var3_2 ^= 1881) {
                case 47483: {
                    ** continue;
                }
                default: {
                    continue block20;
                }
                case 17: 
            }
            var3_2 = 48674;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public String categoryContent(String object, String object2, boolean bl, HashMap<String, String> arrayList) {
        bl = \u062b\ufec1\ufeb1\u062d.\ufea9\u0628\u0637\ufe95(\ufee9\ufee1\u0627\u0641.\ufea1\ufebd\u063a\u0630(Music.\u0632\u062c\u0630\ufed9(), 1037, 3, 2681), object);
        int n = 1616;
        block40: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block40;
                }
                case 49: {
                    if (bl) {
                        n = 1709;
                        continue block40;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block40;
                }
                case 204: {
                    object2 = new ArrayList();
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(object2, new Ef(\u062d\u062e\ufe8e\u0645.\u062d\ufeab\u0642\u0647(Music.\u0632\u062c\u0630\ufed9(), 1040, 6, 3128), \u0631\ufea1\u0638\u0627.\u0645\u062f\u062d\ufeaf(Music.\u0632\u062c\u0630\ufed9(), 1046, 9, 1899), \ufebd\u0640\u0648\u062b.\ufea5\u0639\u0631\ufe95(Music.\u0632\u062c\u0630\ufed9(), 1055, 179, 3046), \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640(), true));
                    object = new Tq();
                    \ufe9d\ufeab\u062e\u0640.\ufead\ufe8e\u064a\ufeb5(object, object2);
                    \u0631\u063a\u0645\u0641.\u0646\u0641\u0632\u062e(object, 1, 1, 1, 1);
                    return \ufeed\ufebd\u0635\ufedd.\ufec1\ufef1\u0632\ufe8e(object);
                }
                case 239: 
            }
            break;
        }
        bl = \u0632\ufead\u062f\u0628.\u0638\ufea5\ufec1\ufe8f(object, \ufeaf\u062b\ufed5\ufec1.\u062e\ufeab\ufee9\u0628(Music.\u0632\u062c\u0630\ufed9(), 1234, 6, 2015));
        arrayList = \ufed9\ufe9d\ufeed\ufeb5.\u0638\ufec1\u063a\u0644(Music.\u0632\u062c\u0630\ufed9(), 1240, 5, 1076);
        n = 1740;
        block41: while (true) {
            switch (n ^= 0x6DD) {
                default: {
                    continue block41;
                }
                case 17: {
                    if (bl) {
                        n = 1833;
                        continue block41;
                    }
                }
                case 54: {
                    n = 1802;
                    continue block41;
                }
                case 500: {
                    int n2 = \u062f\ufead\ufeaf\u062d.\ufeed\u062d\u0637\u0641(object2);
                    n = 1864;
                    block42: while (true) {
                        switch (n ^= 0x759) {
                            default: {
                                continue block42;
                            }
                            case 17: {
                                if (n2 > 1) {
                                    n = 48736;
                                    continue block42;
                                }
                            }
                            case 47483: {
                                n = 48705;
                                continue block42;
                            }
                            case 47417: {
                                return \ufe99\u062e\u0642\u0644.\ufea1\u062e\ufecd\ufeab(new ArrayList());
                            }
                            case 47384: 
                        }
                        break;
                    }
                    this.tF = true;
                    M = object2 = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
                    \ufeb1\ufe8e\ufee1\ufe9d.\ufe99\ufeab\ufe8f\u062f(new g1((Object)this, 2));
                    block43: while (true) {
                        bl = \ufea5\u062d\ufebd\u0633.\u0639\ufeb1\ufead\ufe8f(Music.\u0633\u0643\ufee9\ufeab());
                        n = 48767;
                        block44: while (true) {
                            switch (n ^= 0xBE90) {
                                default: {
                                    continue block44;
                                }
                                case 239: {
                                    if (bl) {
                                        n = 48860;
                                        continue block44;
                                    }
                                }
                                case 14: {
                                    n = 48829;
                                    continue block44;
                                }
                                case 76: {
                                    bl = Music.\ufec1\u0647\ufeed\u0636((Object)this);
                                    n = 48891;
                                    block45: while (true) {
                                        switch (n ^= 0xBF0C) {
                                            default: {
                                                continue block45;
                                            }
                                            case 503: {
                                                if (bl) {
                                                    n = 49635;
                                                    continue block45;
                                                }
                                            }
                                            case 22: {
                                                n = 48953;
                                                continue block45;
                                            }
                                            case 32495: {
                                                \ufed9\ufe9d\ufeed\ufeb5.\ufef1\ufec5\ufec1\u0635(500L);
                                                n = 49666;
                                                block46: while (true) {
                                                    switch (n ^= 0xC213) {
                                                        case 50: {
                                                            continue block43;
                                                        }
                                                        default: {
                                                            continue block46;
                                                        }
                                                        case 17: 
                                                    }
                                                    n = 49697;
                                                }
                                            }
                                            case 53: 
                                        }
                                        break;
                                    }
                                    break block43;
                                }
                                case 45: 
                            }
                            break;
                        }
                        break;
                    }
                    bl = \ufea5\u062d\ufebd\u0633.\u0639\ufeb1\ufead\ufe8f(Music.\u0633\u0643\ufee9\ufeab());
                    n = 49790;
                    block47: while (true) {
                        switch (n ^= 0xC28F) {
                            default: {
                                continue block47;
                            }
                            case 241: {
                                if (bl) {
                                    n = 49883;
                                    continue block47;
                                }
                            }
                            case 18: {
                                n = 49852;
                                continue block47;
                            }
                            case 84: {
                                \ufe8e\ufeb9\u0647\u0642.\u0648\u0636\ufea9\u0630(\ufeaf\u062b\ufed5\ufec1.\u062e\ufeab\ufee9\u0628(Music.\u0632\u062c\u0630\ufed9(), 1245, 7, 3219));
                                return \ufe99\u062e\u0642\u0644.\ufea1\u062e\ufecd\ufeab(new ArrayList());
                            }
                            case 51: 
                        }
                        break;
                    }
                    Music.\ufef1\ufe8e\u0640\ufe99((Object)this);
                    object = Music.\u0633\u0643\ufee9\ufeab();
                    M = object2;
                    object2 = \u062b\ufec1\ufeb1\u062d.\ufe99\ufeb5\ufead\u0637(\u062b\ufec1\ufeb1\u062d.\u0637\u0647\u0635\u0630(Music.\u0632\u062c\u0630\ufed9(), 1252, 4, 1235), object, arrayList);
                    arrayList = new ArrayList();
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList, new Ef((String)object2, (String)object, \u062d\ufeb9\ufeab\ufef1.\ufeed\u0638\u0635\ufed5(Music.\u0632\u062c\u0630\ufed9(), 1256, 180, 2219)));
                    return \ufe99\u062e\u0642\u0644.\ufea1\u062e\ufecd\ufeab(arrayList);
                }
                case 471: 
            }
            break;
        }
        StringBuilder stringBuilder = new StringBuilder();
        \ufe8e\ufeb9\u0647\u0642.\ufef1\ufeab\ufebd\u0640(stringBuilder, Music.\u0640\u063a\ufeb5\ufee9((Object)this), object, \u062d\u062e\ufe8e\u0645.\u062d\ufeab\u0642\u0647(Music.\u0632\u062c\u0630\ufed9(), 1436, 1, 3224), object2);
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, arrayList);
        return \ufe99\u062e\u0642\u0644.\ufea1\u062e\ufecd\ufeab(Music.\u064a\u0628\u0635\ufe8e((Object)this, \ufea9\ufe8f\u0647\ufead.\ufea5\ufe8f\ufec5\ufec1(Music.\u0641\u0643\u0627\ufec1((Object)this, \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(stringBuilder), true)), object, object2));
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
     * Enabled aggressive block sorting
     */
    public String generateSessionId() {
        StringBuilder stringBuilder = new StringBuilder(26);
        int n = 0;
        block10: while (true) {
            int n2 = 1616;
            block11: while (true) {
                switch (n2 ^= 0x661) {
                    default: {
                        continue block11;
                    }
                    case 49: {
                        if (n < 26) {
                            n2 = 1709;
                            continue block11;
                        }
                    }
                    case 14: {
                        n2 = 1678;
                        continue block11;
                    }
                    case 204: {
                        n2 = \ufe8e\u0627\ufecd\u062a.\u0633\u0643\ufead\u0627(Music.\ufeb9\ufeab\u0634\u0633((Object)this), 62);
                        \ufeaf\u0633\u0648\ufee9.\u0627\u062c\u062d\u062a(stringBuilder, \u0635\u0631\u0645\u0628.\u0643\u0637\ufeb1\ufead(\ufeb5\ufe8e\ufead\u0632.\ufe8f\ufef1\u0648\ufe95(Music.\u0632\u062c\u0630\ufed9(), 1701, 62, 1019), n2));
                        int n3 = n + 1;
                        n2 = 1740;
                        block12: while (true) {
                            n = n3;
                            switch (n2 ^= 0x6DD) {
                                case 54: {
                                    continue block10;
                                }
                                default: {
                                    continue block12;
                                }
                                case 17: 
                            }
                            n2 = 1771;
                        }
                    }
                    case 239: 
                }
                break;
            }
            break;
        }
        StringBuilder stringBuilder2 = \ufea9\ufec5\u0647\u0641.\ufeed\ufe8e\ufec5\ufea9(\u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(Music.\u0632\u062c\u0630\ufed9(), 1763, 10, 2388));
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder2, \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(stringBuilder));
        return \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(stringBuilder2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public String homeContent(boolean bl) {
        String string;
        ArrayList arrayList = new ArrayList();
        Va va2 = \ufea9\ufe8f\u0647\ufead.\ufea5\ufe8f\ufec5\ufec1(Music.\u0641\u0643\u0627\ufec1((Object)this, Music.\u0640\u063a\ufeb5\ufee9((Object)this), true));
        Iterator iterator = \ufeed\ufebd\u0635\ufedd.\ufecd\u0636\ufea9\u0628(\u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(va2, \u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(Music.\u0632\u062c\u0630\ufed9(), 1773, 34, 3131)));
        int n = 0;
        block20: while (true) {
            bl = \ufe8e\u0627\ufecd\u062a.\u062f\u0638\ufe8e\ufe99(iterator);
            string = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
            int n2 = 1616;
            block21: while (true) {
                switch (n2 ^= 0x661) {
                    default: {
                        continue block21;
                    }
                    case 49: {
                        if (bl) {
                            n2 = 1709;
                            continue block21;
                        }
                    }
                    case 14: {
                        n2 = 1678;
                        continue block21;
                    }
                    case 204: {
                        hN hN2 = (hN)\ufea1\u0645\u062b\u0634.\ufe95\ufeaf\ufeb9\ufea1(iterator);
                        n2 = 1740;
                        block22: while (true) {
                            switch (n2 ^= 0x6DD) {
                                default: {
                                    continue block22;
                                }
                                case 17: {
                                    if (n == 0) {
                                        n2 = 1833;
                                        continue block22;
                                    }
                                }
                                case 54: {
                                    n2 = 1802;
                                    continue block22;
                                }
                                case 500: {
                                    n2 = 1864;
                                    block23: while (true) {
                                        switch (n2 ^= 0x759) {
                                            default: {
                                                continue block23;
                                            }
                                            case 17: {
                                                n2 = 48674;
                                                continue block23;
                                            }
                                            case 47483: 
                                        }
                                        break;
                                    }
                                    ++n;
                                    continue block20;
                                }
                                case 471: 
                            }
                            break;
                        }
                        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList, new Jz(\ufea5\u062d\ufebd\u0633.\u0645\ufec1\ufed5\u062c(\ufea5\u062d\ufebd\u0633.\ufe99\u0628\u0637\ufe9d(hN2, \u0636\u0634\ufec1\u0631.\u062c\u063a\u0643\u0627(Music.\u0632\u062c\u0630\ufed9(), 1807, 4, 524)), \u0630\ufebd\u0634\ufec9.\u0639\ufe8f\u064a\ufebd(Music.\u0632\u062c\u0630\ufed9(), 1811, 5, 614), string), \ufea5\u062d\ufebd\u0633.\ufe99\u0628\u0637\ufe9d(hN2, \u0630\ufebd\u0634\ufec9.\u0639\ufe8f\u064a\ufebd(Music.\u0632\u062c\u0630\ufed9(), 1816, 5, 3266))));
                        n2 = 48767;
                        block24: while (true) {
                            switch (n2 ^= 0xBE90) {
                                case 14: {
                                    continue block20;
                                }
                                default: {
                                    continue block24;
                                }
                                case 239: 
                            }
                            n2 = 48798;
                        }
                    }
                    case 239: 
                }
                break;
            }
            break;
        }
        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList, new Jz(\ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(Music.\u0632\u062c\u0630\ufed9(), 1821, 3, 3175), \u062d\ufeb9\ufeab\ufef1.\ufeed\u0638\u0635\ufed5(Music.\u0632\u062c\u0630\ufed9(), 1824, 4, 1186)));
        return \u0641\ufeb5\ufeb1\ufee1.\u0641\u0642\u0639\u0643(arrayList, Music.\u064a\u0628\u0635\ufe8e((Object)this, va2, string, \u0631\ufea1\u0638\u0627.\u0645\u062f\u062d\ufeaf(Music.\u0632\u062c\u0630\ufed9(), 1828, 1, 1508)));
    }

    /*
     * Exception decompiling
     */
    public void init(Context var1_1, String var2_2) {
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
    public String playerContent(String var1_1, String var2_2, List<String> var3_4) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [18[CASE]], but top level block is 2[TRYBLOCK]
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
    public void showInputQRCode() {
        try {
            Object object = new StringBuilder();
            \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(object, \ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(Music.\u0632\u062c\u0630\ufed9(), 1970, 7, 840));
            \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(object, \ufeab\u062d\u063a\ufea9.\u0628\u0635\ufead\u064a());
            \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(object, \u0641\ufeb5\ufeb1\ufee1.\u0639\u0630\ufeaf\ufe95(Music.\u0632\u062c\u0630\ufed9(), 1977, 40, 1454));
            object = \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(object);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(\ufeb5\ufe8e\ufead\u0632.\ufecd\ufea5\ufedd\ufebd(200), \ufeb5\ufe8e\ufead\u0632.\ufecd\ufea5\ufedd\ufebd(200));
            ImageView imageView = new ImageView((Context)\ufeed\ufebd\u0635\ufedd.\u0630\ufee9\u0647\u062e());
            \ufed9\ufe8e\u062d\ufead.\ufeb9\ufed9\u062b\u0631(imageView, \ufea5\ufea9\u0633\ufed5.\ufe95\u064a\ufeb5\u0647());
            \ufea5\u062d\ufebd\u0633.\u0646\u0648\u062a\u0645(imageView, \ufea1\u0645\u062b\u0634.\ufe99\u062e\u0641\u062c(object, 200, 2));
            object = new FrameLayout((Context)\ufeed\ufebd\u0635\ufedd.\u0630\ufee9\u0647\u062e());
            layoutParams.gravity = 17;
            \u0633\u064a\u0644\u0637.\u0634\ufeb1\ufecd\u0648(object, imageView, layoutParams);
            layoutParams = new FrameLayout.LayoutParams(\ufeb5\ufe8e\ufead\u0632.\ufecd\ufea5\ufedd\ufebd(500), \ufeb5\ufe8e\ufead\u0632.\ufecd\ufea5\ufedd\ufebd(50));
            layoutParams.topMargin = \ufeb5\ufe8e\ufead\u0632.\ufecd\ufea5\ufedd\ufebd(240);
            layoutParams.gravity = 1;
            imageView = new TextView((Context)\ufeed\ufebd\u0635\ufedd.\u0630\ufee9\u0647\u062e());
            \u0641\ufeb5\ufeb1\ufee1.\u0627\u0639\ufeb9\u062c(imageView, \u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(Music.\u0632\u062c\u0630\ufed9(), 2017, 14, 1493));
            \ufecd\u0642\u062e\ufe9d.\ufeb9\ufeb5\u0630\ufe95(imageView, -1);
            \ufe95\u0627\ufe8e\u0644.\u0632\ufea9\ufe95\ufee1(imageView, 17);
            \u0633\u064a\u0644\u0637.\u0634\ufeb1\ufecd\u0648(object, imageView, layoutParams);
            imageView = new AlertDialog.Builder((Context)\u0641\ufeb5\ufeb1\ufee1.\u0642\ufee1\u0637\u0648());
            object = \u062a\u0635\ufeb1\u0642.\ufec5\ufeaf\ufead\u0648(\u0641\u0631\ufeed\u0643.\u0644\ufeb9\u062b\ufe99(imageView, object));
            this.i = object;
            imageView = \ufecd\u0642\u062e\ufe9d.\ufe8f\ufeb5\u062d\u0640(object);
            object = new ColorDrawable(0);
            \ufea5\ufea9\u0633\ufed5.\ufecd\ufec1\u0631\ufe8f(imageView, object);
            imageView = Music.\ufed5\u0644\u0634\ufeaf((Object)this);
            object = new KJ((Object)this, 2);
            \u062b\ufec1\ufeb1\u062d.\ufef1\u0636\u062c\u0634(imageView, object);
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

    private static long[] $d2j$hex$3cd974bd$decode_J(String src) {
        byte[] d = Music.$d2j$hex$3cd974bd$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$3cd974bd$decode_I(String src) {
        byte[] d = Music.$d2j$hex$3cd974bd$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$3cd974bd$decode_S(String src) {
        byte[] d = Music.$d2j$hex$3cd974bd$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$3cd974bd$decode_B(String src) {
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

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    private class Sjyy {
        private static final short[] short = new short[]{2025, 2037, 2037, 2033, 2034, 1979, 1966, 1966, 2024, 2028, 2022, 1969, 1974, 1967, 2034, 2030, 2022, 2030, 2036, 2018, 2021, 2031, 1967, 2018, 2030, 2028, 1966, 2039, 1971, 1966, 2037, 2025, 2036, 2028, 2019, 1966, 2035, 2020, 2037, 2040, 2033, 2020, 2014, 2020, 2041, 2018, 2029, 2036, 2021, 2020, 2014, 2022, 2024, 2023, 1966, 2020, 2041, 2037, 1966, 2016, 2036, 2037, 2030, 1966, 2032, 1966, 1976, 1972, 1966, 2018, 2035, 2030, 2033, 1966, 2041, 2040, 1966, 2016, 2024, 1966, 2037, 1966, 1969, 1966, 1982, 2016, 2033, 2033, 2024, 2021, 1980, 1968, 1971, 1971, 1959, 2036, 2035, 2029, 1980, 2025, 2037, 2037, 2033, 2034, 1979, 1966, 1966, 2024, 2028, 2022, 1967, 2023, 2029, 2028, 2033, 1970, 1967, 2033, 2035, 2030, 1966, 2024, 2028, 2016, 2022, 2020, 1966, 1971, 1969, 1971, 1973, 1969, 1974, 1969, 1977, 1966, 1971, 1969, 1971, 1973, 1969, 1974, 1969, 1977, 1971, 1971, 1971, 1968, 1972, 1971, 2014, 1973, 1976, 1972, 1967, 2038, 2020, 2019, 2033};
        @SerializedName(value="title")
        private String N;
        @SerializedName(value="pic")
        private String SN;
        @SerializedName(value="lrc")
        private String tF;
        @SerializedName(value="url")
        private String yq;

        /*
         * Enabled aggressive block sorting
         */
        public static String \u0630\ufec1\ufea9\ufea5(Object object) {
            int n = \u0630\ufebd\u0634\ufec9.\u062f\ufe8f\u0630\ufed5();
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
                        return ((Sjyy)object).tF;
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
        public static String \u0630\ufec5\ufea9\ufee9(Object object) {
            int n = \ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5();
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
                        return ((Sjyy)object).yq;
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
        public static String \ufe99\u0630\u0627\ufec9(Object object) {
            int n = \ufe8e\u0627\ufecd\u062a.\ufe99\ufead\ufeb5\ufe95();
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
                        return ((Sjyy)object).N;
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
        public static short[] \ufea1\u0637\ufed5\ufeab() {
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
        public static String \ufed9\u0648\u0636\u0632(Object object) {
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
                        return ((Sjyy)object).SN;
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

        public String getLrc() {
            return Sjyy.\u0630\ufec1\ufea9\ufea5(this);
        }

        /*
         * Enabled aggressive block sorting
         */
        public String getPic() {
            boolean bl = \u0635\u0631\u0645\u0628.\u064a\u062c\ufeed\u062e(Sjyy.\ufed9\u0648\u0636\u0632(this));
            int n = 1616;
            block10: while (true) {
                switch (n ^= 0x661) {
                    default: {
                        continue block10;
                    }
                    case 49: {
                        if (!bl) {
                            n = 1709;
                            continue block10;
                        }
                    }
                    case 14: {
                        n = 1678;
                        continue block10;
                    }
                    case 204: {
                        String string;
                        String string2 = Sjyy.\ufed9\u0648\u0636\u0632(this);
                        n = 1740;
                        block11: while (true) {
                            string = string2;
                            switch (n ^= 0x6DD) {
                                default: {
                                    continue block11;
                                }
                                case 17: {
                                    n = 1771;
                                    continue block11;
                                }
                                case 54: 
                            }
                            break;
                        }
                        return string;
                    }
                    case 239: 
                }
                break;
            }
            return \u0645\u0641\u0630\u062d.\u0642\u062a\u0630\ufebd(Sjyy.\ufea1\u0637\ufed5\ufeab(), 0, 159, 1921);
        }

        public String getTitle() {
            return Sjyy.\ufe99\u0630\u0627\ufec9(this);
        }

        public String getUrl() {
            return Sjyy.\u0630\ufec5\ufea9\ufee9(this);
        }
    }
}

