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
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\u0645\u0641\u0630\u062d;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufe9d\u0631\ufe8f\u064a;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.parser.\ufec1\u0636\u062d\u0638;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.merge.Jz;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.kb_0;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufebd\u0640\u0648\u062b;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\u0636\u0634\ufec1\u0631;
import com.github.catvod.spider.\u0640\u0633\ufea5\u0631;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufe8e\ufeb9\u0647\u0642;
import com.github.catvod.spider.\ufe99\u062c\u0643\ufec1;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import com.github.catvod.spider.\ufeaf\u0633\u0648\ufee9;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import com.github.catvod.spider.\ufeb5\ufe8e\ufead\u0632;
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
public class Bttwoo
extends Spider {
    private static final short[] short = Bttwoo.$d2j$hex$afa0b5e0$decode_S("780a640a640a600a630a2a0a3f0a3f0a670a670a670a3e0a720a640a640a670a7f0a3e0a7c0a790a760a750a3f0a480992069e06910693068a0695069906ce06cc06ce06c8068f0699069f068e0699068806970699068506df0cdc0ccd0cc20c960ccf0cc30cc20cd80ccd0cc50cc20cdf0c840cfa0ce50cfc0c850c6806520661067b066c066f062306340679066506680670065406c309d909ce09cd09ec06e806e206ab06ea06e706ef06e006e606f106a806e606ea06f306e006f706180b1d0b080b1d0b510b0f0b0e0b1f0b01010c0114015403530351035903370c340c250c2a0c6a0c300c210c3c0c300c690c360c2d0c230c2c0c300cf005f205e705f6054605450554055b051b05410550054d0541051805410550054d054105180558054005410550055105a201af01b0019d01a201a701b201a701eb01b001a901a201eb01af01a2019b01d703d503c003d10306060b061406390601060e060306110611065f06050610060b0606064206050610060b0606064f0601060d060e0611064f06510642060506030612064f0650064206160607061a0616064f061a0611063f06420606060b0614063d50d564527a2357ad478266c502bb099009a809a709aa09b809b809f609bf09ae09b309bf09e609b309b809eb09bf09ae09b309bf09e609bf09ae09b309bf09e609b809ae09a809a409a509af09aa09b909b209eb09a709ae09aa09af09a209a509ac09e609b909ae09a709aa09b309ae09af0996098d0b820b950bb80b8a0b870bde0b8d0b820b950b810b820b910bbe0b420c170c5e0c5b0c4e0c5b0c7d037b036d037a03640361036603630332032f03200326032203370321032f032403e702ea02f502d802f002f702fa02ef02e602de02a302e202d802eb02f102e602e502a902be02f302ef02e202fa02de028d0a8e0a9f0a900aa50a860ad30a8d0a960a910a890aa30a3a03200337033403070824082b082e0824082c086908370835082208310822082908330845024c02430249024102480268025d0244025e024202490248026e02410244024e02460271020502030207021202010271025e0207020a02050271024902060204020a02030207021202710204026a076d0571057c05640548056f057105b702ab02a602be029802ae02a30249094f0959094e095009550952095709548016530e0bf802f702f202ea02fb02ec02a102fd02f202ff02ed02ed02f702f802e702a302af02b802ee02ff02f902fb02a30254731059eb0ce40ce10cf90ce80cff0cb20cee0ce10cec0cfe0cfe0ce40ceb0cf40cb00cbf0cab0cfd0cec0cea0ce80cb00cbe724d8eec555b0b540b510b490b580b4f0b020b5e0b510b5c0b4e0b4e0b540b5b0b440b000b0e0b1b0b4d0b5c0b5a0b580b000b6b50e86dac06a106be069306ab06a406a906bb06bb06e206f506fc06b006a406f206af06ba06a106ac06e506ab06a706a406bb06e506f0069506e806ac06a106be069306ac06a906bc06a906e506be06a706ac06e506a106ac0695066b0c6c0c6e0c660c6f0475046804790449046e0470044b06570657065306990a9f0383038e039603ba039d038303580b440b490b510b070bad03b103bc03a4038203b403b9038e0688069e0689069706920695069006e906f606fb06fa06f006b006ef06f306fe06e606a006ef06a206ba06ec06b906e906a206ba06ec06b906ee06a206ae06af06a706af06b906ec06a206ba06ec06b906eb06a206ba06ec06b906f406a206ba06ec06530a560a430a560a0007040710071d071807050708072e07040703071d070207770770076e07d303c503c103d203c303c8039f03d1039d03950b980b870bdf0b960b830b9e0b840b810bdf0b830b940b9d0b900b850b980b870b940b130305030103120303030803");
    private String yq = \ufeab\u062d\u063a\ufea9.\u062f\u0642\ufebd\u064a(Bttwoo.\ufed5\u0642\ufecd\ufe8e(), 0, 23, 2576);

    /*
     * Enabled aggressive block sorting
     */
    public Bttwoo() {
        int n = \ufec1\u0636\u062d\u0638.\u0643\u0638\u062a\ufec5();
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
                    Long l = Long.valueOf(\ufeb9\u0643\ufed9\ufed5.\u0647\ufeab\ufe99\u0639("rWhlzs7lSnu8WzAmlYsZ0"));
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
     */
    public static String encodePlayKey(String object) {
        Object object2;
        Object object3 = \u0633\u064a\u0644\u0637.\ufec9\ufeed\ufeb5\u0640(Bttwoo.\ufed5\u0642\ufecd\ufe8e(), 23, 1, 2424);
        boolean bl = \u062b\ufec1\ufeb1\u062d.\ufea9\u0628\u0637\ufe95(object3, object);
        int n = 1616;
        block26: while (true) {
            object2 = object3;
            switch (n2 ^= 0x661) {
                default: {
                    continue block26;
                }
                case 49: {
                    int n2;
                    if (!bl) {
                        n2 = 1709;
                        continue block26;
                    }
                }
                case 14: {
                    int n2 = 1678;
                    continue block26;
                }
                case 204: {
                    bl = \ufeed\ufebd\u0635\ufedd.\u0637\ufe8e\ufee1\ufebd(object);
                    int n3 = 1740;
                    block27: while (true) {
                        switch (n4 ^= 0x6DD) {
                            default: {
                                continue block27;
                            }
                            case 17: {
                                int n4;
                                if (bl) {
                                    n4 = 1833;
                                    continue block27;
                                }
                            }
                            case 54: {
                                int n4 = 1802;
                                continue block27;
                            }
                            case 500: {
                                int n5 = 1864;
                                block28: while (true) {
                                    object2 = object3;
                                    switch (n7 ^= 0x759) {
                                        default: {
                                            continue block28;
                                        }
                                        case 17: {
                                            int n7 = 48674;
                                            continue block28;
                                        }
                                        case 47483: 
                                    }
                                    break;
                                }
                                return object2;
                            }
                            case 471: 
                        }
                        break;
                    }
                    object2 = \u062d\ufeb9\ufeab\ufef1.\ufe8f\ufe99\u0645\u0627();
                    object2 = \u0631\u0640\ufec1\ufee9.\ufea1\ufef1\u0630\u063a(\u0635\u0631\u0645\u0628.\u0646\u0627\u062a\u062d(Bttwoo.\ufed5\u0642\ufecd\ufe8e(), 24, 20, 1788), object2);
                    object = \u0631\u0640\ufec1\ufee9.\ufea1\ufef1\u0630\u063a(object, \u062d\ufeb9\ufeab\ufef1.\ufe8f\ufe99\u0645\u0627());
                    object3 = new byte[((Object)object).length];
                    int n8 = 0;
                    block29: while (true) {
                        int n9 = ((Object)object).length;
                        Object object4 = 48767;
                        block30: while (true) {
                            switch (object4 ^= 0xBE90) {
                                default: {
                                    continue block30;
                                }
                                case 239: {
                                    if (n8 < n9) {
                                        object4 = 48860;
                                        continue block30;
                                    }
                                }
                                case 14: {
                                    object4 = 48829;
                                    continue block30;
                                }
                                case 76: {
                                    n9 = ((Object)object2).length;
                                    object4 = object[n8];
                                    object3[n8] = (byte)(object2[n8 % n9] ^ object4);
                                    n9 = n8 + 1;
                                    object4 = 48891;
                                    block31: while (true) {
                                        n8 = n9;
                                        switch (object4 ^= 0xBF0C) {
                                            case 22: {
                                                continue block29;
                                            }
                                            default: {
                                                continue block31;
                                            }
                                            case 503: 
                                        }
                                        object4 = 48922;
                                    }
                                }
                                case 45: 
                            }
                            break;
                        }
                        break;
                    }
                    return \u0635\u0631\u0645\u0628.\u0632\u062d\u0636\u0645(\u0635\u0631\u0645\u0628.\u0632\u062d\u0636\u0645(\ufee1\u0639\u063a\u0645.\u0637\u0638\ufed5\ufe99(object3, 0), '+', '-'), '/', '_');
                }
                case 239: 
            }
            break;
        }
        return object2;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     * Exception decompiling
     */
    private List yq(kb_0 var1_1, String var2_3) {
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
    public static void \u0628\ufe8e\u062a\u0638(Object var0) {
        var2_1 = \ufeb5\ufe8e\ufead\u0632.\ufe95\u0647\u062d\u0631();
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
                    if (var2_1 > 0) ** GOTO lbl7
                    var1_2 = 1709;
                    continue block16;
                }
                case 204: {
                    SpiderDebug.log((Throwable)((Throwable)var0));
lbl16:
                    // 2 sources

                    while (true) {
                        var2_1 = \u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634();
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
                                    var3_3 = Long.parseLong(\ufeab\u0632\u062f\u0640.\ufeb5\u0630\u0648\ufe8f("Udty8uLiW2EhiNSGp3QaNvKRSi9W"));
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
    public static List \ufe95\ufed5\u0638\ufeaf(Object object, Object object2, Object object3) {
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
                    return ((Bttwoo)((Object)object)).yq((kb_0)object2, (String)object3);
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
    public static short[] \ufed5\u0642\ufecd\ufe8e() {
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
    public static String \ufee1\u0639\u0633\u062a(Object object) {
        int n = \u0636\u0634\ufec1\u0631.\u0648\ufedd\ufeb5\ufed9();
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
                    return ((Bttwoo)((Object)object)).yq;
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
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String categoryContent(String object, String object2, boolean bl, HashMap<String, String> serializable) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, Bttwoo.\ufee1\u0639\u0633\u062a((Object)this));
            \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, object);
            \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, object2);
            object2 = \u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(\u0635\u0631\u0645\u0628.\u0631\u063a\u0645\u0641(\u0645\u0641\u0630\u062d.\ufead\u062b\u0647\u0642(\ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(stringBuilder), \u0640\u0633\ufea5\u0631.\u0628\ufea1\u0643\ufee9())), \ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(Bttwoo.\ufed5\u0642\ufecd\ufe8e(), 149, 16, 454));
            object = new Tq();
            \ufe9d\ufeab\u062e\u0640.\ufead\ufe8e\u064a\ufeb5(object, Bttwoo.\ufe95\ufed5\u0638\ufeaf((Object)this, object2, \ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(Bttwoo.\ufed5\u0642\ufecd\ufe8e(), 165, 4, 948)));
            return \ufeed\ufebd\u0635\ufedd.\ufec1\ufef1\u0632\ufe8e(object);
        }
        catch (Exception exception) {
            Bttwoo.\u0628\ufe8e\u062a\u0638(exception);
            return \ufeed\ufebd\u0635\ufedd.\ufec1\ufef1\u0632\ufe8e(new Tq());
        }
    }

    /*
     * Exception decompiling
     */
    public String detailContent(List<String> var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [12[TRYBLOCK]], but top level block is 126[UNCONDITIONALDOLOOP]
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
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String homeContent(boolean bl) {
        try {
            Object object = \u0635\u0631\u0645\u0628.\u0631\u063a\u0645\u0641(\u0645\u0641\u0630\u062d.\ufead\u062b\u0647\u0642(Bttwoo.\ufee1\u0639\u0633\u062a((Object)this), \u0640\u0633\ufea5\u0631.\u0628\ufea1\u0643\ufee9()));
            Object object2 = new ArrayList();
            Object object3 = new Jz(\ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(Bttwoo.\ufed5\u0642\ufecd\ufe8e(), 429, 23, 670), \ufecd\u0642\u062e\ufe9d.\u0637\ufee9\u0635\u0630(Bttwoo.\ufed5\u0642\ufecd\ufe8e(), 452, 2, 1633));
            \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(object2, object3);
            object3 = new Jz(\ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(Bttwoo.\ufed5\u0642\ufecd\ufe8e(), 454, 23, 3213), \ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(Bttwoo.\ufed5\u0642\ufecd\ufe8e(), 477, 3, 1931));
            \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(object2, object3);
            object3 = new Jz(\u0641\ufeb5\ufeb1\ufee1.\u0639\u0630\ufeaf\ufe95(Bttwoo.\ufed5\u0642\ufecd\ufe8e(), 480, 23, 2877), \u0633\u064a\u0644\u0637.\ufec9\ufeed\ufeb5\u0640(Bttwoo.\ufed5\u0642\ufecd\ufe8e(), 503, 2, 707));
            \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(object2, object3);
            object3 = \u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(object, \ufe8e\ufeb9\u0647\u0642.\ufee1\u062f\ufedd\u0643(Bttwoo.\ufed5\u0642\ufecd\ufe8e(), 505, 44, 1736));
            object = new Tq();
            \ufe9d\ufeab\u062e\u0640.\u0648\u062d\u0643\ufeb1(object, object2);
            \ufe9d\ufeab\u062e\u0640.\ufead\ufe8e\u064a\ufeb5(object, Bttwoo.\ufe95\ufed5\u0638\ufeaf((Object)this, object3, \u0631\u0640\ufec1\ufee9.\ufe95\ufeed\u062c\ufec1(Bttwoo.\ufed5\u0642\ufecd\ufe8e(), 549, 4, 3075)));
            return \ufeed\ufebd\u0635\ufedd.\ufec1\ufef1\u0632\ufe8e(object);
        }
        catch (Exception exception) {
            Bttwoo.\u0628\ufe8e\u062a\u0638(exception);
            return \ufeed\ufebd\u0635\ufedd.\ufec1\ufef1\u0632\ufe8e(new Tq());
        }
    }

    /*
     * Recovered potentially malformed switches.  Disable with '--allowmalformedswitch false'
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void init(Context object, String string) {
        boolean bl = \u0635\u0631\u0645\u0628.\u064a\u062c\ufeed\u062e(string);
        int n = 1616;
        block20: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block20;
                }
                case 49: {
                    if (!bl) {
                        n = 1709;
                        continue block20;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block20;
                }
                case 204: {
                    object = new JSONObject(string);
                    object = \ufeab\u0632\u062f\u0640.\ufed9\ufeab\u0643\u0633(object, \u0636\u0634\ufec1\u0631.\u062c\u063a\u0643\u0627(Bttwoo.\ufed5\u0642\ufecd\ufe8e(), 553, 7, 1052));
                    bl = \u0632\ufead\u062f\u0628.\u0638\ufea5\ufec1\ufe8f(object, \ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(Bttwoo.\ufed5\u0642\ufecd\ufe8e(), 560, 4, 1571));
                    n = 1740;
                    break block20;
                }
                case 239: {
                    return;
                }
            }
            break;
        }
        block21: while (true) {
            switch (n ^= 0x6DD) {
                default: {
                    continue block21;
                }
                case 17: {
                    if (bl) {
                        n = 1833;
                        continue block21;
                    }
                }
                case 54: {
                    n = 1802;
                    continue block21;
                }
                case 500: {
                    try {
                        this.yq = object;
                        n = 1864;
                    }
                    catch (Exception exception) {
                        Bttwoo.\u0628\ufe8e\u062a\u0638(exception);
                        return;
                    }
                    block22: while (true) {
                        switch (n ^= 0x759) {
                            default: {
                                continue block22;
                            }
                            case 17: {
                                n = 48674;
                                continue block22;
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

    /*
     * Exception decompiling
     */
    public String playerContent(String var1_1, String var2_3, List<String> var3_4) {
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
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String searchContent(String object, boolean bl) {
        try {
            Object object2 = new StringBuilder();
            \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(object2, Bttwoo.\ufee1\u0639\u0633\u062a((Object)this));
            \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(object2, \ufea1\u0645\u062b\u0634.\u0638\ufec9\u0630\ufe95(Bttwoo.\ufed5\u0642\ufecd\ufe8e(), 653, 9, 928));
            \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(object2, object);
            object = \u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(\u0635\u0631\u0645\u0628.\u0631\u063a\u0645\u0641(\u0645\u0641\u0630\u062d.\ufead\u062b\u0647\u0642(\ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(object2), \u0640\u0633\ufea5\u0631.\u0628\ufea1\u0643\ufee9())), \ufebd\u0640\u0648\u062b.\ufea5\u0639\u0631\ufe95(Bttwoo.\ufed5\u0642\ufecd\ufe8e(), 662, 18, 3057));
            object2 = new Tq();
            \ufe9d\ufeab\u062e\u0640.\ufead\ufe8e\u064a\ufeb5(object2, Bttwoo.\ufe95\ufed5\u0638\ufeaf((Object)this, object, \u062d\ufeb9\ufeab\ufef1.\ufeed\u0638\u0635\ufed5(Bttwoo.\ufed5\u0642\ufecd\ufe8e(), 680, 6, 864)));
            return \ufeed\ufebd\u0635\ufedd.\ufec1\ufef1\u0632\ufe8e(object2);
        }
        catch (Exception exception) {
            Bttwoo.\u0628\ufe8e\u062a\u0638(exception);
            return \ufeed\ufebd\u0635\ufedd.\ufec1\ufef1\u0632\ufe8e(new Tq());
        }
    }

    private static long[] $d2j$hex$afa0b5e0$decode_J(String src) {
        byte[] d = Bttwoo.$d2j$hex$afa0b5e0$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$afa0b5e0$decode_I(String src) {
        byte[] d = Bttwoo.$d2j$hex$afa0b5e0$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$afa0b5e0$decode_S(String src) {
        byte[] d = Bttwoo.$d2j$hex$afa0b5e0$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$afa0b5e0$decode_B(String src) {
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

