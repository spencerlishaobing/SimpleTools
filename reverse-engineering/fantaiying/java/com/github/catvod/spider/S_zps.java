/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.content.Context;
import com.github.catvod.parser.\u062b\u064a\ufecd\u0642;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\ufec9\u0648\u062d;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.merge.Bo;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.Jz;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufea5\ufea9\u0633\ufed5;
import com.github.catvod.spider.merge.\ufebd\u0640\u0648\u062b;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0636\u0634\ufec1\u0631;
import com.github.catvod.spider.\u0640\u0633\ufea5\u0631;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufe8e\u0627\ufecd\u062a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class S_zps
extends Pan {
    private static HashMap<String, User> n;
    private static final short[] short;
    private String O = \ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(short, 0, 22, 3057);
    private String g1 = \u0646\ufecd\ufead\u0647.\u0640\u062e\ufed5\ufeaf(short, 22, 15, 741);
    private final HashMap<String, String> s = new HashMap<String, String>(){
        private static final short[] short = new short[]{1417, 1421, 1433, 1418, 1427, 21094, 31080, 983, 980, 988, 977, 960, 21752, 21752, 2452, 2434, 20032, 27912, 1681, 1692, 1689, 1673, 1669, 1694, -28613, 29948};
        {
            ((AbstractMap)this).put(\u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(short, 0, 5, 1528), \ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(short, 5, 2, 2910));
            ((AbstractMap)this).put(\ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(short, 7, 5, 949), \u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(short, 12, 2, 743));
            ((AbstractMap)this).put(\ufebd\u0640\u0648\u062b.\ufea5\u0639\u0631\ufe95(short, 14, 2, 2529), \u0646\ufecd\ufead\u0647.\u0640\u062e\ufed5\ufeaf(short, 16, 2, 344));
            ((AbstractMap)this).put(\u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(short, 18, 6, 1776), \ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(short, 24, 2, 1540));
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
                        String string = \u062a\u0635\ufeb1\u0642.\ufebd\u0635\u0628\ufee1("0DuQ950");
                        System.out.println(string);
                        return;
                    }
                    case 239: 
                }
                break;
            }
        }
    };

    static {
        short = S_zps.$d2j$hex$080e0d0e$decode_S("990b850b850b810b820bcb0bde0bde0b820b9e0bdf0bc30bc40bc30bc10bc20bc40bdf0b890b880b8b0bde0b840295028c02ca02960280028402970286028d02da028e029202d802a50206085f0808080e0818080f0813081c08100818085f0847085f0858080e085f0851085f080d081c080e080e080a0812080f0819085f0847085f0858080e085f080008c00ad10ac80a8e0ac00ad40ad50ac90a8e0acd0ace0ac60ac80acf0ac605e105e505f605e105f605a405a20ab90abd0ab30ab80af50bf40bef0bfe0b2102260238027f080504190419041d041e04570442044204040400040a045d045a0443041e0402040a04020418040e040904030443040e040204000442041b045f04420419040504180400040f0442041f040804190414041d0408043204080415040e04010418040904080432040a0404040b04420408041504190442040c0418041904020442041c0442045404580442040e041f0402041d0442041504140442040c0404044204190442045d04420452040c041d041d040404090450045c045f045f044b0418041f04010450040504190419041d041e0457044204420402041e041e045904010404041b04040408041a044304000402040704040443040e0402040004420419040504090432040b0404040104080442045f045d045f04580442045d045a0442045f04550442040c045b040f0409040f045f045f040e040e0459040f045d040f040b040e045a040f045e045e045e040b0408040e04580409045d045f045a040f04540458045c04430407041d040a04a607d0d3bfd4c06c7c65c36dbd74347df06fce767c65e0f42945c36eed68f06fce7601040c0416040b041a042a040d041304210c3d0c3d0c390ce703f103f503e603f703fc03d503e403fd03e205e105e905e705e005900bc30cd70cd60cca0ccd0cd00ccb0cd80cc30cd60ccb0ccd0ccc0ce205e705f205e705a001a801bf01aa01a801a9019201af01b4019201b901b401bd01a801340135012e013f01d90cde0cc00c8308df088308c705cb05cd05c405cf05de053771af63917aba60b66fd106c706290b350b350b310b320b7b0b6e0b6e0b280b2c0b260b710b760b6f0b320b2e0b260b2e0b340b220b250b2f0b6f0b220b2e0b2c0b6e0b370b730b6e0b350b290b340b2c0b230b6e0b330b240b350b380b310b240b1e0b240b390b220b2d0b340b250b240b1e0b260b280b270b6e0b240b390b350b6e0b200b340b350b2e0b6e0b300b6e0b780b740b6e0b220b330b2e0b310b6e0b390b380b6e0b200b280b6e0b350b6e0b710b6e0b7e0b200b310b310b280b250b7c0b700b730b730b670b340b330b2d0b7c0b290b350b350b310b320b7b0b6e0b6e0b320b700b6f0b280b2c0b200b260b240b290b340b230b6f0b220b220b6e0b280b2c0b200b260b240b320b6e0b730b710b730b770b6e0b710b740b6e0b710b790b6e0b730b750b750b750b730b200b720b720b250b750b770b270b250b700b200b240b240b250b250b250b200b770b720b200b270b750b790b720b720b740b730b740b6f0b310b2f0b260b39093d0929093a092309cc08d008d008d408d7089e088b088b08cd08c908c308940893088a08d708cb08c308cb08d108c708c008ca088a08c708cb08c9088b08d20896088b08d008cc08d108c908c6088b08d608c108d008dd08d408c108fb08c108dc08c708c808d108c008c108fb08c308cd08c2088b08c108dc08d0088b08c508d108d008cb088b08d5088b089d0891088b08c708d608cb08d4088b08dc08dd088b08c508cd088b08d0088b0894088b089b08c508d408d408cd08c00899089508960896088208d108d608c8089908cc08d008d008d408d7089e088b088b08d70895088a08cd08c908c508c308c108cc08d108c6088a08c708c7088b08cd08c908c508c308c108d7088b0896089408960892088b08940891088b0894089c088b089508c208c108c108c70891089408c6089208c00891089c089d08c108940890089c08c108c508c708900894089108c0089208c608c5089d089c089c08c508c7088a08d408ca08c30883038e038b039b0397038c0361027d027d0279027a02330226022602600264026e0239023e0227027a0266026e0266027c026a026d02670227026a026602640226027f023b0226027d0261027c0264026b0226027b026c027d02700279026c0256026c0271026a0265027c026d026c0256026e0260026f0226026c0271027d02260268027c027d02660226027802260230023c0226026a027b026602790226027102700226026802600226027d02260239022602360268027902790260026d02340238023b023b022f027c027b026502340261027d027d0279027a023302260226027a02380227026002640268026e026c0261027c026b0227026a026a0226026002640268026e026c027a0226023b0239023b023f02260239023c0226023902310226023c026d026802380230023f02380238023d023f023b023d02390239026d026c023a026a02380230026b023e023d023e026d023e023d0239026d026f0268023d022702790267026e0233073007380735072407be08a208a208a608a508ec08f908f908bf08bb08b108e608e108f808a508b908b108b908a308b508b208b808f808b508b908bb08f908a008e408f908a208be08a308bb08b408f908a408b308a208af08a608b3088908b308ae08b508ba08a308b208b3088908b108bf08b008f908b308ae08a208f908b708a308a208b908f908a708f908ef08e308f908b508a408b908a608f908ae08af08f908b708bf08f908a208f908e608f908e908b708a608a608bf08b208eb08e708e408e408f008a308a408ba08eb08be08a208a208a608a508ec08f908f908a508e708f808bf08bb08b708b108b308be08a308b408f808b508b508f908bf08bb08b708b108b308a508f908e408e608e408e008f908e608e308f908e608ee08f908b308e208b408e508e008e408e208b208b208e508b408e608e508ee08e208ee08b508e008b008e008ef08e708e308b208e208e508e108b008b308b708e508e008f808a608b808b1084b065e04");
    }

    /*
     * Enabled aggressive block sorting
     */
    public S_zps() {
        int n = \u0633\u064a\u0644\u0637.\ufec1\u062e\u0643\ufedd();
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
                    double d = Double.parseDouble(\ufed9\ufe8e\u062d\ufead.\u0647\u0642\u0627\u0641("xwasn4b"));
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
    private void q() {
        CharSequence charSequence = n.get(this.O).getName();
        Object object = n.get(this.O).getKey();
        object = String.format(\u0631\ufea1\u0638\u0627.\u0645\u062f\u062d\ufeaf(short, 37, 33, 2173), charSequence, object);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(this.O);
        ((StringBuilder)charSequence).append(\ufe95\u0627\ufe8e\u0644.\u062d\u0636\ufea9\u0640(short, 70, 14, 2721));
        object = new JSONObject(Bo.M(((StringBuilder)charSequence).toString(), (String)object));
        User user = n.get(this.O);
        charSequence = oi_0.yq(\u062a\u0635\ufeb1\u0642.\u0637\u0636\u062a\ufedd(short, 84, 7, 1412));
        ((StringBuilder)charSequence).append(object.getString(\ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(short, 91, 5, 2774)));
        user.setToken(((StringBuilder)charSequence).toString());
        int n = \u0636\u0634\ufec1\u0631.\u0648\ufedd\ufeb5\ufed9();
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
                    object = Long.valueOf(\ufeab\u0632\u062f\u0640.\ufeb5\u0630\u0648\ufe8f("uApHDYRTwgwqxIFitkglPn4mR"));
                    System.out.println(object);
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
    public static HashMap \u062b\u062c\ufebd\ufec9(Object hashMap) {
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
                    return ((S_zps)((Object)hashMap)).s;
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
    public static HashMap \u0630\ufeb9\ufe99\u0642() {
        int n = \u062b\u064a\ufecd\u0642.\ufea9\ufec5\ufec1\ufec9();
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
                    return S_zps.n;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            HashMap<String, User> hashMap = var3_3;
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
    public static String \ufe99\u0637\u062f\ufee1(Object object) {
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
                    return ((User)object).getToken();
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
    public static short[] \ufea1\u0638\u062a\u0639() {
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
    public static String \ufead\u0632\u0646\u0641(Object object) {
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
                    return ((S_zps)((Object)object)).g1;
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
    public static String \ufee1\u0644\ufe95\u0627(Object object) {
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
                    return ((S_zps)((Object)object)).O;
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
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 22[UNCONDITIONALDOLOOP]
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

    public String homeContent(boolean bl) {
        String string = "\u06e1\u06e1\u06e0";
        ArrayList<Jz> arrayList = null;
        ArrayList<Ef> arrayList2 = null;
        String string2 = null;
        JSONObject jSONObject = null;
        Jz jz = null;
        short[] sArray = null;
        String string3 = null;
        block12: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    string3 = \ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(sArray, 287, 1, 1943);
                    string = "\u06df\u06e1\u06e7";
                    continue block12;
                }
                case 1753419: {
                    jz = new Jz(string3, string2);
                    string = "\u06e5\u06e0\u06e7";
                    continue block12;
                }
                case 1752492: {
                    arrayList.add(jz);
                    string = "\u06e4\u06e6\u06e4";
                    continue block12;
                }
                case 1751714: {
                    jSONObject = new JSONObject();
                    string = "\u06e0\u06e8\u06df";
                    continue block12;
                }
                case 1748672: {
                    arrayList2 = new ArrayList<Ef>();
                    string = "\u06e0\u06df\u06e3";
                    continue block12;
                }
                case 1748736: {
                    sArray = short;
                    string = "\u06df\u06e8\u06e4";
                    continue block12;
                }
                case 1747927: {
                    string3 = Tq.Nl((List<Jz>)arrayList, arrayList2, jSONObject);
                    string = "\u06e7\u06e6\u06e3";
                    continue block12;
                }
                case 1747652: {
                    arrayList = new ArrayList<Jz>();
                    string = "\u06e1\u06e3\u06e2";
                    continue block12;
                }
                case 1753668: {
                    string2 = \ufeb9\ufec9\u0648\u062d.\ufee9\u0637\ufef1\u0644(sArray, 288, 16, 3052);
                    string = "\u06e6\u06df\u06e4";
                    continue block12;
                }
                case 1746757: {
                    sArray = short;
                    string = "\u06e6\u06e7\u06e5";
                    continue block12;
                }
                case 1754596: 
            }
            break;
        }
        return string3;
    }

    /*
     * Exception decompiling
     */
    @Override
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
    public String searchContent(String var1_1, boolean var2_3) {
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

    private static long[] $d2j$hex$080e0d0e$decode_J(String src) {
        byte[] d = S_zps.$d2j$hex$080e0d0e$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$080e0d0e$decode_I(String src) {
        byte[] d = S_zps.$d2j$hex$080e0d0e$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$080e0d0e$decode_S(String src) {
        byte[] d = S_zps.$d2j$hex$080e0d0e$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$080e0d0e$decode_B(String src) {
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

    private class User {
        private String N;
        private String SN;
        private String yq;

        /*
         * WARNING - void declaration
         * Enabled aggressive block sorting
         */
        public User(S_zps object, String string, String string2) {
            void var3_4;
            void var2_3;
            this.yq = var2_3;
            this.SN = var3_4;
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
                        Integer n3 = Integer.decode(\u062f\ufead\ufeaf\u062d.\u062d\u062f\u063a\u062a("lfJ"));
                        System.out.println(n3);
                        return;
                    }
                    case 239: 
                }
                break;
            }
        }

        public String getKey() {
            return this.SN;
        }

        public String getName() {
            return this.yq;
        }

        public String getToken() {
            return this.N;
        }

        public void setToken(String string) {
            this.N = string;
        }
    }
}

