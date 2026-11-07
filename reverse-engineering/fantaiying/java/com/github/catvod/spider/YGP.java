/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.github.catvod.crawler.Spider
 *  com.github.catvod.crawler.SpiderDebug
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.content.Context;
import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufec1\u0636\u062d\u0638;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.merge.Am;
import com.github.catvod.spider.merge.V;
import com.github.catvod.spider.merge.hN;
import com.github.catvod.spider.merge.iK;
import com.github.catvod.spider.merge.kb_0;
import com.github.catvod.spider.merge.uA;
import com.github.catvod.spider.merge.w2;
import com.github.catvod.spider.merge.z2_0;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0641\u0631\ufeed\u0643;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufe8e\u0627\ufecd\u062a;
import com.github.catvod.spider.\ufeb5\ufe8e\ufead\u0632;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class YGP
extends Spider {
    private static final short[] short = YGP.$d2j$hex$84991227$decode_S("e909ea09fb09f40951044d044d0449044a040304160416044e044e044e0417040f0451044c04560417045a04560454041604cb044c0212024c025d025b025902110252025d024a021c025d0218084608180809080f080d084508060809081e084808090846080b081d081a081a080d0806081c08416be9609e65d05548671367618e647133797c600653bd01b001af01f701b001b701b701bc01ab01f401eb01ba01b601b501f401b401b801b001b701f901bd01b001af01f701b401b601af01b501b001aa01ad01f901e701f901ac01b501f901b501b001f901e701f901b8017d076707700773073f0b220b3f0b270b2e0b6e086a086008e608e708f608230a3f0a3f0a3b0a87019e019501ae01980195011f0406040d0436040704080404040c040b091209190922090d0914091e09190900090b0930091d090a0902090e091d0904091c09ef01fe01f801fa01db0aca0acc0ace0ac80ac40ade0ac50adf0a360c330c370c330c2e0c51054a05510544054905bc05b905a305a4056b016b016b01630775076f072c076307680766072107630775076f072c0766077307640764076f07210775076d076807720775072c07630775076f07e309ff09ff09fb09f809b109a409a409fc09fc09fc09a509bd09e309fe09e409a509e809e409e609a409ff629d61f99c3750e105ec05f305ab05e805ea05f305ec05e005a805f105ec05f105e905e005a805e105e005f105e405ec05e905a505f505990794078b07d30794079307930798078f07d0078a078f079c078d078d0798078f07ac08a108be08e608a508a708be08a108ad08e508bc08a108bc08a408ad08e508a508b808a108ab08e808f608e808a908e808f608a108a508af08220723073207ac03b003b003b403f207ab07b407f707f507ec07f307ff07b707f407fb07f707ff07850988099709cf098c098e09970988098409cc099509880995098d098409cc09850984099509800988098d09c1098009ae0bb40ba30ba00bac09a009ba09a109bb09bd09b6097d0b7f0b660b790b750b640b690b600b750b2404e85700630ef33c0c3a0c3f0c3d0c2f4200639947b36f89f6bb09cf09e409b809ba0920440f6501f5330a350a300a320a7c58de6a0457a66579fa4b054d0548054a053f054b05858ea57b3f054a0557075a0745071d075a075d075d07560741071e074407410752074307430756074107130752071d07500746074107410756075d074707af9a61569b0296028902dc028b029e029d0288028d029e028f028f029a028d02d2029e0293029302df028b028d02df028b029b02df029e02e005f805fd05e705e005b905f605f605e705b905e005f005e005fd05e005f805f105d601ec0a7a6718647c99b255dc018f018f018f0162077b0770074b077d07700764047d0476044d047c0473047f0477043b092209290912093d0924092e099402990290028502bf028e0281028d028502fc04e504ee04d504f304ef04eb04f8046b047204790442047c046f0478047c046e0277027c0247026a027d02750279026a0273026b02b003a903a2039903a703a503b203a903b403a509bc09b7098c09b709ba09a109b609b009a709bc09a1098b0492049904a2049e04920493048904980493048904110708070307380717070b0706071e0738070107150708070a07990b800b8b0bb00b9f0b830b8e0b960bb00b9a0b9d0b830b4b0c4e0c540c530ca103a203b303bc0320073c073c0738073b077207670767073f073f073f0766077e0720073d07270766072b07270725076707780275027c026902530265026802810983099a09800985099f099809c30972087f08760863085908680867086b0863081660e177229dec51dc05d305de05cc05cc050c05030506051e050f0518051905c204cf04d0048804cb04c904d004ca04cf04d504d204860498048604d304ca048604ca04cf04860498048604c704d606cc06db06d80696068b0696068e068706cd07c907c307ff01fe01ef01390c250c250c210cca04d304d804e304d504d8049a0383038803b30382038d03810389039f0986098d09b609990980098a098b0b920b990ba20b8f0b980b900b9c0b8f0b960b8e0bc50cc00cda0cdd0c5a09460946094209410908091d091d094509450945091c0904095a0947095d091c0951095d095f091d09b206fb06e406e806fa06b006ec06fd06e406ab06e006e206e906e806b006e906e206fa06e306e106e206ec06e906a006e906ec06f906ec06ab06ff06ec06e306e906b0066409360936092b0926097f096a0b460c570c440c450c530c020b1e0b130b0b0b270b000b1e0ba601a101bf01740376036f036c036b037503f908fa08eb08e408f103ed03ed03e903ea03a303b603b603ee03ee03ee03b703af03f103ec03f603b703fa03f603f403b603c70693069d0681068f0697068a069c06c5069d05cd05d205de05cc058605c805de05da05c905d805d305d603db03c4039c03df03dd03c403de03db03c103c60392038c039203c703de039203de03db0392038c039203d303320a280a3f0a3c0a9c0581059c0584058d05240220022a02c70bc60bd70b7804640464046004460b5f0b540b6f0b590b540bb408ad08a6089d08ac08a308af08a7088e0997099c09a709880991099b096e0277027c0247026a027d02750279026a0273026b02800485049f049804230b2b0b3a0b260b210b2a0b360c340c250c3f0a190a0f0a180a470a2b0a0d0a0f0a040a1e0a7005520547055405510551055c051205080513050d051d0515056a0554055305590552054a054e051d05730569051d050c050d0513050d0506051d056a0572056a050b05090514051d057c054d054d05510558056a0558055f05760554054905120508050e050a0513050e050b051d0515057605750569057005710511051d0551055405560558051d057a0558055e055605520514051d057e0555054f05520550055805120505050b0513050d05130509050f0509050d0513050c05040505051d056e055c055b055c054f055405120508050e050a0513050e050b05f20bd00bd00bd60bc30bc70b060417040a0406045d041a0406041f041e045e041304020402041e041b041104130406041b041d041c045d040a041a0406041f041e0459040a041f041e045e041304020402041e041b041104130406041b041d041c045d040a041f041e04490403044f0442045c044b045e041b041f041304150417045d04130404041b0414045e041b041f041304150417045d0405041704100402045e041b041f041304150417045d04130402041c0415045e0458045d045804490403044f0442045c044a045e041304020402041e041b041104130406041b041d041c045d0401041b0415041c04170416045f0417040a0411041a0413041c0415041704490404044f0410044104490403044f0442045c044b049305b105b105b705a205a605ff059e05b305bc05b505a705b305b505b7051701050140012e01230141011701050156011c0150015d0143015401");
    private JSONObject yq;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String SN(Pattern object, String string) {
        Matcher matcher;
        if (object == null) {
            return string;
        }
        try {
            matcher = ((Pattern)object).matcher(string);
            object = string;
        }
        catch (Exception exception) {
            SpiderDebug.log((Throwable)exception);
            return string;
        }
        if (!matcher.find()) return object;
        return matcher.group(1).trim();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean isNumeric(String string) {
        boolean bl;
        boolean bl2 = bl = false;
        if (string == null) return bl2;
        if (string.length() == 0) {
            return bl;
        }
        int n = 0;
        while (n < string.length()) {
            bl2 = bl;
            if (!Character.isDigit(string.charAt(n))) return bl2;
            ++n;
        }
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static short[] \u0636\u0645\u0638\u0642() {
        if (\ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644() <= 0) return null;
        return short;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static HashMap \u063a\ufebd\ufeb5\ufea5(Object hashMap) {
        if (\u062b\ufec1\ufeb1\u062d.\ufe8f\ufe9d\u0628\ufe99() > 0) return null;
        return ((YGP)((Object)hashMap)).yq();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject \ufec1\ufe8f\u0638\u064a(Object object) {
        if (\ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643() < 0) return null;
        return ((YGP)((Object)object)).yq;
    }

    public static void \ufee9\u0634\u0643\u064a(Object object) {
        if (\u0641\u0631\ufeed\u0643.\ufeb5\ufe8f\u0630\u0647() > 0) {
            SpiderDebug.log((Throwable)((Throwable)object));
        }
    }

    /*
     * Exception decompiling
     */
    public String categoryContent(String var1_1, String var2_3, boolean var3_4, HashMap<String, String> var4_5) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 3[TRYBLOCK] [4 : 184->287)] java.lang.Exception
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
    public String detailContent(List<String> var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 13[UNCONDITIONALDOLOOP]
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
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void init(Context context) {
        super.init(context);
        try {
            context = new JSONObject("{\"movlist/\":[{\"key\":\"1\",\"name\":\"\u7c7b\u578b\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u559c\u5267\",\"v\":\"\u559c\u5267\"},{\"n\":\"\u7231\u60c5\",\"v\":\"\u7231\u60c5\"},{\"n\":\"\u6050\u6016\",\"v\":\"\u6050\u6016\"},{\"n\":\"\u52a8\u4f5c\",\"v\":\"\u52a8\u4f5c\"},{\"n\":\"\u79d1\u5e7b\",\"v\":\"\u79d1\u5e7b\"},{\"n\":\"\u5267\u60c5\",\"v\":\"\u5267\u60c5\"},{\"n\":\"\u6218\u4e89\",\"v\":\"\u6218\u4e89\"},{\"n\":\"\u72af\u7f6a\",\"v\":\"\u72af\u7f6a\"},{\"n\":\"\u707e\u96be\",\"v\":\"\u707e\u96be\"},{\"n\":\"\u5947\u5e7b\",\"v\":\"\u5947\u5e7b\"},{\"n\":\"\u60ac\u7591\",\"v\":\"\u60ac\u7591\"},{\"n\":\"\u60ca\u609a\",\"v\":\"\u60ca\u609a\"},{\"n\":\"\u5192\u9669\",\"v\":\"\u5192\u9669\"}]},{\"key\":\"0\",\"name\":\"\u5730\u533a\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u5927\u9646\",\"v\":\"\u5927\u9646\"},{\"n\":\"\u9999\u6e2f\",\"v\":\"\u9999\u6e2f\"},{\"n\":\"\u53f0\u6e7e\",\"v\":\"\u53f0\u6e7e\"},{\"n\":\"\u7f8e\u56fd\",\"v\":\"\u7f8e\u56fd\"},{\"n\":\"\u6cd5\u56fd\",\"v\":\"\u6cd5\u56fd\"},{\"n\":\"\u82f1\u56fd\",\"v\":\"\u82f1\u56fd\"},{\"n\":\"\u65e5\u672c\",\"v\":\"\u65e5\u672c\"},{\"n\":\"\u97e9\u56fd\",\"v\":\"\u97e9\u56fd\"},{\"n\":\"\u5fb7\u56fd\",\"v\":\"\u5fb7\u56fd\"},{\"n\":\"\u6cf0\u56fd\",\"v\":\"\u6cf0\u56fd\"},{\"n\":\"\u5370\u5ea6\",\"v\":\"\u5370\u5ea6\"},{\"n\":\"\u5176\u4ed6\",\"v\":\"\u5176\u4ed6\"}]},{\"key\":\"2\",\"name\":\"\u5e74\u4efd\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"2026\",\"v\":\"2026\"},{\"n\":\"2025\",\"v\":\"2025\"},{\"n\":\"2024\",\"v\":\"2024\"},{\"n\":\"2023\",\"v\":\"2023\"},{\"n\":\"2022\",\"v\":\"2022\"},{\"n\":\"2021\",\"v\":\"2021\"},{\"n\":\"2020\",\"v\":\"2020\"},{\"n\":\"2019\",\"v\":\"2019\"},{\"n\":\"2018\",\"v\":\"2018\"},{\"n\":\"2017\",\"v\":\"2017\"},{\"n\":\"2016\",\"v\":\"2016\"},{\"n\":\"2015\",\"v\":\"2015\"},{\"n\":\"2014\",\"v\":\"2014\"},{\"n\":\"2013\",\"v\":\"2013\"},{\"n\":\"2012\",\"v\":\"2012\"},{\"n\":\"2011\",\"v\":\"2011\"},{\"n\":\"2010\",\"v\":\"2010\"},{\"n\":\"2009\",\"v\":\"2009\"},{\"n\":\"2008\",\"v\":\"2008\"},{\"n\":\"2007\",\"v\":\"2007\"},{\"n\":\"2006\",\"v\":\"2006\"},{\"n\":\"2005\",\"v\":\"2005\"},{\"n\":\"2004\",\"v\":\"2004\"},{\"n\":\"2003\",\"v\":\"2003\"},{\"n\":\"2002\",\"v\":\"2002\"},{\"n\":\"2001\",\"v\":\"2001\"},{\"n\":\"2000\",\"v\":\"2000\"},{\"n\":\"1999\",\"v\":\"1999\"},{\"n\":\"1998\",\"v\":\"1998\"},{\"n\":\"1980\",\"v\":\"1980\"}]},{\"key\":\"3\",\"name\":\"\u6392\u5e8f\",\"value\":[{\"n\":\"\u5168\u90e8\",\"v\":\"\"},{\"n\":\"\u6700\u8fd1\u66f4\u65b0\",\"v\":\"\"},{\"n\":\"\u4e0a\u6620\u65f6\u95f4\",\"v\":\"pubtime\"}]}]}");
            this.yq = context;
            return;
        }
        catch (JSONException jSONException) {
            SpiderDebug.log((Throwable)jSONException);
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String playerContent(String charSequence, String string, List<String> list) {
        uA.dT(false);
        try {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(\ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(short, 762, 21, 2354));
            ((StringBuilder)charSequence).append(\ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(short, 783, 34, 1677));
            ((StringBuilder)charSequence).append(Math.random());
            ((StringBuilder)charSequence).append(\ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(short, 817, 6, 2370));
            ((StringBuilder)charSequence).append(string.split(\u0633\u064a\u0644\u0637.\ufec9\ufeed\ufeb5\u0640(short, 823, 1, 2885))[2]);
            charSequence = ((StringBuilder)charSequence).toString();
            string = new JSONArray(w2.W((String)charSequence, this.yq()));
            string = string.getJSONObject(0);
            charSequence = new JSONObject();
            charSequence.put(\u0633\u064a\u0644\u0637.\ufec9\ufeed\ufeb5\u0640(short, 824, 5, 3126), 0);
            charSequence.put(\ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(short, 829, 7, 2930), (Object)"");
            charSequence.put(\u062f\ufead\ufeaf\u062d.\ufec9\u0630\ufed9\ufeb1(short, 836, 3, 467), (Object)string.getString(\u0635\u0631\u0645\u0628.\u0646\u0627\u062a\u062d(short, 839, 6, 793)));
            return charSequence.toString();
        }
        catch (Exception exception) {
            SpiderDebug.log((Throwable)exception);
            return "";
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String searchContent(String string, boolean bl) {
        String string2 = \ufeab\u0632\u062f\u0640.\u062f\u0627\ufe95\u0631(short, 845, 4, 2186);
        String string3 = \ufea9\u0643\u062d\u063a.\ufea1\u0633\ufe8e\u0627(short, 849, 21, 921);
        try {
            JSONObject jSONObject = new JSONObject();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append(\ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(short, 870, 9, 1784));
            stringBuilder.append(URLEncoder.encode(string));
            stringBuilder.append(\ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(short, 879, 12, 1467));
            kb_0 kb_02 = Am.yq(w2.W(stringBuilder.toString(), this.yq())).cS(\ufeb5\ufe8e\ufead\u0632.\ufe8f\ufef1\u0648\ufe95(short, 891, 23, 946));
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < ((AbstractCollection)kb_02).size(); ++i2) {
                StringBuilder stringBuilder2;
                Object object = (hN)((AbstractList)kb_02).get(i2);
                String string4 = ((iK)object).N(\u062b\ufec1\ufeb1\u062d.\u0637\u0647\u0635\u0630(short, 914, 4, 2650));
                String string5 = z2_0.yq(string2, (hN)object).N(\ufecd\u0642\u062e\ufe9d.\u0637\ufee9\u0635\u0630(short, 918, 5, 1512));
                string = z2_0.yq(\ufee9\u0631\ufeb5\u0628.\u0636\ufeab\u0634\u0633(short, 923, 3, 589), (hN)object).N(\u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(short, 926, 3, 2996));
                if (!string.contains(\ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(short, 929, 4, 1040))) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(string3);
                    stringBuilder2.append(string);
                    string = stringBuilder2.toString();
                }
                object = ((hN)object).cS(string2).zH().Fo();
                stringBuilder2 = new JSONObject();
                stringBuilder2.put(\u0641\ufeb5\ufeb1\ufee1.\u0639\u0630\ufeaf\ufe95(short, 933, 6, 2864), string4);
                stringBuilder2.put(\u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(short, 939, 8, 2242), string5);
                stringBuilder2.put(\ufeab\u062d\u063a\ufea9.\u062f\u0642\ufebd\u064a(short, 947, 7, 2552), string);
                stringBuilder2.put(\ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(short, 954, 11, 536), object);
                jSONArray.put((Object)stringBuilder2);
            }
            jSONObject.put(\ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(short, 965, 4, 1260), (Object)jSONArray);
            return jSONObject.toString();
        }
        catch (Exception exception) {
            SpiderDebug.log((Throwable)exception);
            return "";
        }
    }

    protected final HashMap<String, String> yq() {
        HashMap hashMap = V.tF(\ufeab\u0632\u062f\u0640.\u062f\u0627\ufe95\u0631(short, 969, 6, 2894), \ufea9\ufe8f\u0647\ufead.\ufea9\u0643\ufedd\ufeed(short, 975, 3, 3185), \u062d\ufeb9\ufeab\ufef1.\ufeed\u0638\u0635\ufed5(short, 978, 10, 2666), \ufeab\u062d\u063a\ufea9.\u062f\u0642\ufebd\u064a(short, 988, 110, 1341));
        hashMap.put(\ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(short, 1098, 6, 2995), \u0646\ufecd\ufead\u0647.\u0640\u062e\ufed5\ufeaf(short, 1104, 135, 1138));
        hashMap.put(\ufeb5\ufe8e\ufead\u0632.\ufe8f\ufef1\u0648\ufe95(short, 1239, 15, 1490), \u0635\u0631\u0645\u0628.\u0646\u0627\u062a\u062d(short, 1254, 14, 365));
        return hashMap;
    }

    private static long[] $d2j$hex$84991227$decode_J(String src) {
        byte[] d = YGP.$d2j$hex$84991227$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$84991227$decode_I(String src) {
        byte[] d = YGP.$d2j$hex$84991227$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$84991227$decode_S(String src) {
        byte[] d = YGP.$d2j$hex$84991227$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$84991227$decode_B(String src) {
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

