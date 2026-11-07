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
import com.github.catvod.parser.\u062b\u064a\ufecd\u0642;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufe8f\ufe8e\ufeb5\u0641;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufea5\ufea9\u0633\ufed5;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufebd\u0640\u0648\u062b;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\u0636\u0634\ufec1\u0631;
import com.github.catvod.spider.\u0640\u0633\ufea5\u0631;
import com.github.catvod.spider.\ufe8e\u0627\ufecd\u062a;
import com.github.catvod.spider.\ufe8e\ufeb9\u0647\u0642;
import com.github.catvod.spider.\ufea5\u062d\ufebd\u0633;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import com.github.catvod.spider.\ufeaf\u0633\u0648\ufee9;
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class T4
extends Spider {
    private static final short[] short = T4.$d2j$hex$bbb694d3$decode_S("f406f306f906f806e506b306ed06f506ed06b206eb06f206f906b206ee06f806fc06ef06fe06f506b206ed06fc06fa06f806b206b806ee06b206ea06f906b206b806ee06b306f506e906f006f106de08c808cc08df08ce08c5082c936182a171b99c4f82de08d208d908d808640a630a690a680a750a230a7d0a650a7d0a220a7b0a680a7f0a640a6b0a740aab07a707a707a307a107ad07d308c008d708cc08c308dc08f901f401fd01e8013a036f033003270333033703270331033603270326036f0335032b0336032a03f007e507e407e007dc07dc07d807fa07cd07d907dd07cd07db07dc078508b208b108b208a508b208a5080501020108010901140142011c0104011c0143010d0106010d01140143011a0109011e0105010a01150133010f01040109010f0107015301180115011c01090151011f0109010d011e010f0104014a011a0109011e0105010a0115015101e577c1759750765a9291df80c40ae20af40ae30abc0ad00af60af40aff0ae50a67094b094b094f094d094109ed07e807f207f507b80aba0a9907980789079c079407910780031a040d049a0983098809b30982098d0981098909df0bc60bcd0bf60bca0bc50bc80bda0bda0b714e517571015e4ff07f7101d8787e5371012583926171011f524b587101734f70616504740472047004cb01da01dc01de01d801d401ce01d501cf012c0529052d0529053405100b0b0b100b050b080bfa02e302e802d302ef02e302e202f802e902e202f80209030b034f0c4e0c5f0c4a0c420c470c390434042304d504d004ca04cd04f206eb06e006db06e606e806f106f606e606e401eb01e601f401f401b809bd09a709a009260229022c023402250232021402120215020502a508a808a108b4088e08bf08b008bc08b408b245927eea4844784d71eb5ac488736a12584652ab4da86389058b059d0a9c0a8d0a980a900a950a3f0626062d0616062706280624062c0643025a0251026a0256025902540246024602ac468c7dac0983472d77ac090570a35bac09f88b4f69ac09c25a9650ac09ae47ad697b096d0969097a096b096009450967096c096d09440b5b0b750b570b420b530b510b590b440b5f0b530b450bc802ca02df02ce02cc02c402d902c202ce02d802f604ea04e704ff04d304f404ea04c609cb09c209d7091d09fa01c30cd90cc40cd50ce50cc20cdc0c4e085b085b081809870bc40b9a0bdc0b910bdb0ade0ad10ad20ade0ad40aca0a0004070419046905750578056005cb02c102cc02ca02af02be02ad02ac02ba024d060d0711071107150727023e0235020e023f0230023c023402a509a009ba09bd0951025302c601c701d601c301cb01ce01c40bd70b900a870aaa07b307b8078307bf07b007bd07af07af07d64cf677d603f94d577dd6037f7ad951d60382813563d603b850ec5ad603d44dd763990780078b07b00781078e0782078a07140411040b040c04c37be779b15c5056b49df98c7903790337030d03350339033803220337033f03380325037e0316033e032403330330037a03760371033f033803320333032e03780326033e0326037903200339033203790332033303220337033f033a0371037f030b03230b320b2f0b230b7f0b7e0b490361037b036c036f03a206af06e406e306e506e106f406e206e506a306bf06a606a70668096a0950095109400955095d095809d00add0aca0ad4020d0b140b1f0b240b180b170b1a0b080b080b5049707250067f48d1785006f97f5f5450060484b36650063e556a5f500652485166");
    private int Gc;
    private List<String> N;
    private String SN;
    private String i;
    private String t0;
    private List<String> tF;
    private String yq;
    private String zH;

    /*
     * Enabled aggressive block sorting
     */
    public T4() {
        Object object = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
        this.yq = object;
        this.SN = object;
        this.zH = object;
        this.i = \ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(T4.\ufeb9\u062a\u0648\u0630(), 0, 39, 1693);
        this.Gc = 4;
        int n = \ufebd\u0640\u0648\u062b.\u0633\u0637\u0632\ufeab();
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
                    object = Long.decode(\u0646\ufecd\ufead\u0647.\ufe8f\ufed9\ufeaf\u0639("7hXeH7ilFVkOKJf2CGJEc"));
                    System.out.println(object);
                    return;
                }
                case 239: 
            }
            break;
        }
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     * Exception decompiling
     */
    private String N(String var1_1, Boolean var2_3, HashMap var3_4) {
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
    private HashMap<String, String> SN(String var1_1) {
        var5_2 = new HashMap<String, String>();
        var4_3 = \u0646\ufecd\ufead\u0647.\ufe95\ufec1\ufeb9\ufeb1();
        \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(var5_2, \ufe8f\ufe8e\ufeb5\u0641.\u062f\u0627\u0640\ufee1(T4.\ufeb9\u062a\u0648\u0630(), 176, 10, 2705), var4_3);
        var3_4 = \u0635\u0631\u0645\u0628.\u064a\u062c\ufeed\u062e(T4.\u0627\ufecd\u062c\ufe8e((Object)this));
        var6_5 = \ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(T4.\ufeb9\u062a\u0648\u0630(), 186, 6, 2340);
        var2_6 = 1616;
        block20: while (true) {
            switch (var2_6 ^= 1633) {
                default: {
                    continue block20;
                }
lbl12:
                // 2 sources

                case 14: {
                    var2_6 = 1678;
                    continue block20;
                }
                case 49: {
                    if (var3_4) ** GOTO lbl12
                    var2_6 = 1709;
                    continue block20;
                }
                case 204: {
                    var4_3 = T4.\u0627\ufecd\u062c\ufe8e((Object)this);
lbl21:
                    // 2 sources

                    while (true) {
                        \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(var5_2, var6_5, var4_3);
                        var2_6 = 1740;
                        block23: while (true) {
                            switch (var2_6 ^= 1757) {
                                default: {
                                    continue block23;
                                }
                                case 17: {
                                    var2_6 = 1771;
                                    continue block23;
                                }
                                case 54: {
                                    return var5_2;
                                }
                            }
                            break;
                        }
                        break;
                    }
                }
                case 239: 
            }
            break;
        }
        var3_4 = \u0635\u0631\u0645\u0628.\u064a\u062c\ufeed\u062e(var1_1);
        var2_6 = 1864;
        block24: while (true) {
            switch (var2_6 ^= 1881) {
                default: {
                    continue block24;
                }
                case 17: {
                    if (!var3_4) {
                        var2_6 = 48736;
                        continue block24;
                    }
                }
                case 47483: {
                    var2_6 = 48705;
                    continue block24;
                }
                case 47417: {
                    var2_6 = 48767;
                    block25: while (true) {
                        var4_3 = var1_1;
                        switch (var2_6 ^= 48784) {
                            case 14: {
                                ** continue;
                            }
                            default: {
                                continue block25;
                            }
                            case 239: 
                        }
                        var2_6 = 48798;
                    }
                }
                {
                    ** case 47384:
                }
            }
            break;
        }
lbl61:
        // 1 sources

        return var5_2;
    }

    private HashMap<String, String> yq() {
        return T4.\u0627\ufed9\ufea9\ufea1((Object)this, \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640());
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0627\ufecd\u062c\ufe8e(Object object) {
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
                    return ((T4)((Object)object)).zH;
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
    public static HashMap \u0627\ufed9\ufea9\ufea1(Object object, Object object2) {
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
                    return ((T4)((Object)object)).SN((String)object2);
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
    public static String \u0630\ufe95\ufea1\ufebd(Object object) {
        int n = \ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637();
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
                    return ((T4)((Object)object)).yq;
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
    public static String \u0633\u0639\ufe9d\ufedd(Object object) {
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
                    return ((T4)((Object)object)).t0;
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
    public static HashMap \u0635\ufeb9\ufea5\u0641(Object hashMap) {
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
                    return ((T4)((Object)hashMap)).yq();
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
     * Unable to fully structure code
     */
    public static void \u0646\u0627\ufeb9\u063a(Object var0) {
        var2_1 = \u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a();
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
                    if (var2_1 >= 0) ** GOTO lbl7
                    var1_2 = 1709;
                    continue block16;
                }
                case 204: {
                    SpiderDebug.log((Throwable)((Throwable)var0));
lbl16:
                    // 2 sources

                    while (true) {
                        var2_1 = \ufecd\u0642\u062e\ufe9d.\u0634\u063a\u0628\ufeb9();
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
                                    var0 = \u062b\u064a\ufecd\u0642.\u0641\ufea1\u0646\u062f("6GQ");
                                    System.out.println((String)var0);
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
    public static ArrayList \u0647\ufebd\u0644\ufeb5(Object list) {
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
                    return ((T4)((Object)list)).N;
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
    public static ArrayList \u0647\ufec9\u0642\u062e(Object list) {
        int n = \ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644();
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
                    return ((T4)((Object)list)).tF;
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
    public static String \u064a\ufec9\u0647\u0633(Object object) {
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
                    return ((T4)((Object)object)).i;
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
    public static String \ufeab\u0636\u0630\u0627(Object object, Object object2, Object object3, Object object4) {
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
                    return ((T4)((Object)object)).N((String)object2, (Boolean)object3, (HashMap)object4);
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
    public static short[] \ufeb9\u062a\u0648\u0630() {
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
    public static String \ufec1\ufeab\u0630\u0638(Object object) {
        int n = \ufe9d\ufeab\u062e\u0640.\ufeb5\ufead\u0638\u062f();
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
                    return ((T4)((Object)object)).SN;
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
    public static int \ufed5\u062c\ufedd\u0642(Object object) {
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
                    return ((T4)((Object)object)).Gc;
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
     * Exception decompiling
     */
    public String categoryContent(String var1_1, String var2_3, boolean var3_4, HashMap<String, String> var4_5) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 5[TRYBLOCK] [5 : 594->708)] java.lang.Exception
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
     * Unable to fully structure code
     */
    public String detailContent(List<String> var1_1) {
        var4_3 = 0;
        var7_4 = \ufeab\u062d\u063a\ufea9.\u062f\u0642\ufebd\u064a(T4.\ufeb9\u062a\u0648\u0630(), 264, 11, 652);
        var6_5 = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
        var8_6 = new HashMap();
        \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(var8_6, \ufe8f\ufe8e\ufeb5\u0641.\u062f\u0627\u0640\ufee1(T4.\ufeb9\u062a\u0648\u0630(), 275, 2, 872), \u0636\u0634\ufec1\u0631.\u062c\u063a\u0643\u0627(T4.\ufeb9\u062a\u0648\u0630(), 277, 6, 3115));
        \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(var8_6, \u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(T4.\ufeb9\u062a\u0648\u0630(), 283, 3, 1104), (String)\u0646\ufecd\ufead\u0647.\u0643\ufe8e\u0644\ufe95(var1_1, 0));
        var8_6 = \u0644\ufe8f\u0628\u062a.\u0640\u062c\u0631\u0647(T4.\u0630\ufe95\ufea1\ufebd((Object)this), var8_6, T4.\u0635\ufeb9\ufea5\u0641((Object)this));
        var5_7 = \ufea5\u062d\ufebd\u0633.\u0639\ufeb1\ufead\ufe8f(var8_6);
        var2_8 = 1616;
        block28: while (true) {
            switch (var2_8 ^= 1633) {
                default: {
                    continue block28;
                }
lbl17:
                // 2 sources

                case 14: {
                    var2_8 = 1678;
                    continue block28;
                }
                case 49: {
                    if (!var5_7) ** GOTO lbl17
                    var2_8 = 1709;
                    continue block28;
                }
                case 204: {
                    var1_1 = var6_5;
lbl26:
                    // 3 sources

                    return var1_1;
                }
                case 239: 
            }
            break;
        }
        var1_1 = new JSONObject((String)var8_6);
        var10_9 = \u0630\ufebd\u0634\ufec9.\u0642\u0627\u0645\u0643(var1_1, \ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(T4.\ufeb9\u062a\u0648\u0630(), 286, 4, 1209));
        var2_8 = 1740;
        block31: while (true) {
            var3_10 = var4_3;
            switch (var2_8 ^= 1757) {
                default: {
                    continue block31;
                }
                case 17: {
                    if (var10_9 != null) {
                        var2_8 = 1833;
                        continue block31;
                    }
                }
                case 54: {
                    var2_8 = 1802;
                    continue block31;
                }
                {
                    ++var3_10;
                    case 500: {
                        var4_3 = \u0644\ufe8f\u0628\u062a.\ufee9\ufe8e\ufe99\u0631(var10_9);
                        var2_8 = 1864;
                        block33: while (true) {
                            switch (var2_8 ^= 1881) {
                                default: {
                                    continue block33;
                                }
                                case 17: {
                                    if (var3_10 < var4_3) {
                                        var2_8 = 48736;
                                        continue block33;
                                    }
                                }
                                case 47483: {
                                    var2_8 = 48705;
                                    continue block33;
                                }
                                case 47417: {
                                    var8_6 = \u0632\ufead\u062f\u0628.\ufead\u062b\ufeb1\u0644(var10_9, var3_10);
                                    var9_11 = \ufe99\u062e\u0642\u0644.\u062d\ufead\u0644\ufec5(\ufeab\u0632\u062f\u0640.\ufed9\ufeab\u0643\u0633(var8_6, var7_4));
                                    var12_13 = \ufe99\u062e\u0642\u0644.\u062d\ufead\u0644\ufec5(\ufeab\u0632\u062f\u0640.\ufed9\ufeab\u0643\u0633(var8_6, \ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(T4.\ufeb9\u062a\u0648\u0630(), 290, 9, 1668)));
                                    var11_12 = new StringBuilder();
                                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var11_12, var12_13);
                                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var11_12, var9_11);
                                    \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(var8_6, var7_4, \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(var11_12));
                                    var2_8 = 48767;
                                    block34: while (true) {
                                        switch (var2_8 ^= 48784) {
                                            case 14: {
                                                continue block32;
                                            }
                                            default: {
                                                continue block34;
                                            }
                                            case 239: 
                                        }
                                        var2_8 = 48798;
                                    }
                                }
                                case 47384: 
                            }
                            break;
                        }
                    }
                }
                case 471: 
            }
            break;
        }
        try {
            var1_1 = \ufeaf\u0633\u0648\ufee9.\ufeb5\u0634\u0640\ufea1(var1_1);
            ** GOTO lbl26
        }
        catch (Throwable var1_2) {
            T4.\u0646\u0627\ufeb9\u063a(var1_2);
            var1_1 = var6_5;
            ** continue;
        }
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
    public void init(Context var1_1, String var2_4) {
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
    public String playerContent(String var1_1, String var2_3, List<String> var3_4) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [22[CASE]], but top level block is 4[TRYBLOCK]
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

    public String searchContent(String string, boolean bl) {
        String string2 = "\u06e8\u06e3\u06e7";
        String string3 = null;
        String string4 = null;
        short[] sArray = null;
        block5: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string2)) {
                default: {
                    sArray = T4.\ufeb9\u062a\u0648\u0630();
                    string2 = "\u06e3\u06e3\u06e1";
                    continue block5;
                }
                case 1752733: {
                    string3 = \ufeed\ufebd\u0635\ufedd.\ufeed\ufecd\ufeab\ufec9((Object)this, string, bl, string4);
                    string2 = "\u06e7\u06e8\u06e4";
                    continue block5;
                }
                case 1750657: {
                    string4 = \ufea9\u0643\u062d\u063a.\ufea1\u0633\ufe8e\u0627(sArray, 465, 1, 1660);
                    string2 = "\u06e5\u06e8\u06e0";
                    continue block5;
                }
                case 1754659: 
            }
            break;
        }
        return string3;
    }

    /*
     * Enabled aggressive block sorting
     */
    public String searchContent(String string, boolean bl, String string2) {
        boolean bl2 = \u0632\ufead\u062f\u0628.\u0638\ufea5\ufec1\ufe8f(T4.\u064a\ufec9\u0647\u0633((Object)this), \u062f\ufead\ufeaf\u062d.\ufec9\u0630\ufed9\ufeb1(T4.\ufeb9\u062a\u0648\u0630(), 466, 4, 1893));
        int n = 1616;
        block6: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block6;
                }
                case 49: {
                    if (!bl2) {
                        n = 1709;
                        continue block6;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block6;
                }
                case 204: {
                    return \ufe95\u0627\ufe8e\u0644.\ufebd\u062a\ufef1\ufe95((Object)this, string, bl, string2);
                }
                case 239: 
            }
            break;
        }
        return \u0631\u0640\ufec1\ufee9.\ufeb1\u0631\ufeb5\u0642((Object)this, string, bl, string2);
    }

    /*
     * Exception decompiling
     */
    public String searchContentApi(String var1_1, boolean var2_3, String var3_4) {
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
    public String searchContentWeb(String var1_1, boolean var2_3, String var3_4) {
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

    private static long[] $d2j$hex$bbb694d3$decode_J(String src) {
        byte[] d = T4.$d2j$hex$bbb694d3$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$bbb694d3$decode_I(String src) {
        byte[] d = T4.$d2j$hex$bbb694d3$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$bbb694d3$decode_S(String src) {
        byte[] d = T4.$d2j$hex$bbb694d3$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$bbb694d3$decode_B(String src) {
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

