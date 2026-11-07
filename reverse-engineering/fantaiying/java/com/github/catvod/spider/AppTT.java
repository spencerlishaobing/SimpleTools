/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.github.catvod.crawler.Spider
 *  com.github.catvod.crawler.SpiderDebug
 *  okhttp3.Call
 *  okhttp3.MediaType
 *  okhttp3.MultipartBody
 *  okhttp3.MultipartBody$Builder
 *  okhttp3.OkHttpClient
 *  okhttp3.Request
 *  okhttp3.Request$Builder
 *  okhttp3.RequestBody
 *  okhttp3.Response
 *  okhttp3.ResponseBody
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.content.Context;
import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
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
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\u0641\u0631\ufeed\u0643;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufebd\u0640\u0648\u062b;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.merge.\ufee9\ufee1\u0627\u0641;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\u0636\u0634\ufec1\u0631;
import com.github.catvod.spider.\ufe8e\u0627\ufecd\u062a;
import com.github.catvod.spider.\ufe8e\ufeb9\u0647\u0642;
import com.github.catvod.spider.\ufe99\u062c\u0643\ufec1;
import com.github.catvod.spider.\ufea5\u062d\ufebd\u0633;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import com.github.catvod.spider.\ufeaf\u0633\u0648\ufee9;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class AppTT
extends Spider {
    private static final short[] short = AppTT.$d2j$hex$9c8b1947$decode_S("e209e609e509f909f909fd09a009e209e609ea09e209a209e709e809ec09fe09e209e309e109f709f40960067b0664064b0660066d0664067106350a2b0a1e0a370a2e0a250a100736072007370768070407220720072b0731076d046a047404d306d606c306d606060b200b360b210b7e0b120b340b360b3d0b270bf703ec03f503f503bc04b904b604b504b904b304ad04b50ae50af20ab20ae00aec0ae60ab00af10af00aba0ab70afb0ae60aeb0aeb0ab00ae80ab10ab00af20ae10afb0af20af10ae10aed0ae10ab60af50ab40ae10ab50ae50ab70af10af20aee0ad309ca09c109fa09d709c009c809c409d709ce09d609ca01d301d801e301d201dd01d101d90196018f018401bf01890184012604230439043e041b010a010c010e01dc0ad90add0ad90ac40aaa06b306b8068306ac06b506bf06e50cff0cf10cf80ce70bfa0bfe0bf60be00be70bf20bfe0be30b50015301fe02f302fa02ef02d502e302ee02f604af04ea04f604b104b604b404bc04f604ad04a004a904bc048604aa04bc04b804ab04ba04b10458075d0748075d0772086b0860085b0874086d0867085b0870086c08710869086608f90ae80aee0aec0aea0ae60afc0ae70afd0ac201d901c201d701da0156034f0344037f034403490352034503430354034f035203be0ba70bac0b970ba90bab0bbc0ba70bba0b2e0437043c0407042a043d04350439042a0433042b04830b9a0b910baa0b940b870b900b940bec07f507fe07c507e307ff07fb07e8075a0743074807730742074d0741074907940a8d0a860abd0a810a8d0a8c0a960a870a8c0a960a130a0a0a010a3a0a0c0a010a810b980b930ba80b870b9e0b940b2306390637063e065b0c460c420c4a0c5c0c5b0c4e0c420c5f0c9106c8068d069106d606d106d306db069106c806d106da06e106da06db06ca06df06d706d206cd069502900285029002d4039e038603c90359049008d108c2088d08ae0bac0bfb0bff0be50bfe0bb10b8e0bc301a401a101c101a201d401c101c801fa019a0183018801b3019c0185018f01b30198018401990181018e017f0c660c6d0c560c790c650c680c700c560c650c600c7a0c7d0c0c0806080b080d08ce01df01cc01cd01db01e101cb01cc01d201cd010c060b06150654094f0956095609c907ce07d007cf079702980294029c02ad08890a080711071a0721070e0712071f070707210718070c0711071307d407d407d407060b1f0b140b2f0b000b1c0b110b090b2f0b050b020b1c0b4f0b4a0b500b570b36033b03320327031d032b032603210c2c0c250c300c0a0c3b0c340c380c300c6a0970097e09770906011b011f0117010101060113011f01020116064f060a0616064d06400649065c0616064d065606490666064d06400649065c065206570642065706a404a104bb04bc0414081b081608040804082003390332030903240333033b03370324033d0325037007690762075907680767076b07630744065d0656066d065b065606bb0aa20aa90a920abd0aa40aae0a0d031703190310033a05270523052b053d053a052f0523053e059c0ac50a800a9c0ac70aca0ac30ad60a9c0ac70ad90aec0ac50adc0ad70a18041d0408041d0422022f02260233020902200239023202c20adb0ad00a14020d0206023d0212020b0201023d0216020a0217020f0200023707320728072f07d80a860ac00a8d0aa706b606a506a406b2066c0970097d09650949096e097009b70ab00aae0a3c01390136013501390133012d01c402dd02d602ed02c002d702df02d302c002d902c102cf0ad60add0ae60ad00add0a590a400a4b0a700a410a4e0a420a4a0a6c0c690c730c740c56044f0444047f04500449044304b307a907a707ae07d905c405c005c805de05d905cc05c005dd057a087408680866087e086308750848081108540848080f0808080a0802084808140802080608150804080f08d607d307c607d307290c300c3b0c000c2f0c360c3c0c000c2b0c370c2a0c320c3d0c");
    private JSONObject N;
    private String SN = \ufeaf\u0633\u0648\ufee9.\u062e\u0645\u0644\u0648(AppTT.\ufeab\u0647\ufeaf\ufe8e(), 0, 21, 2445);
    private String tF = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
    private String yq;

    /*
     * Enabled aggressive block sorting
     */
    public AppTT() {
        int n = \ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632();
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
                    Long l = Long.valueOf(\ufe8f\ufe8e\ufeb5\u0641.\ufed5\u0644\ufea9\u0635("22sNtbQHvc"));
                    System.out.println(l);
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
    private String N(String var1_1, Map<String, String> var2_3) {
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
    private JSONObject SN(String object, String string, JSONObject object2) {
        int n;
        boolean bl;
        String string2;
        block65: {
            string2 = \ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(AppTT.\ufeab\u0647\ufeaf\ufe8e(), 45, 3, 1048);
            String string3 = \ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(AppTT.\ufeab\u0647\ufeaf\ufe8e(), 48, 4, 1719);
            bl = \ufeb9\u0643\ufed9\ufed5.\u0636\u0647\ufee9\ufeed(object2, object);
            n = 1616;
            block51: while (true) {
                switch (n ^= 0x661) {
                    default: {
                        continue block51;
                    }
                    case 49: {
                        if (bl) {
                            n = 1709;
                            continue block51;
                        }
                    }
                    case 14: {
                        n = 1678;
                        continue block51;
                    }
                    case 204: {
                        StringBuilder stringBuilder = new StringBuilder();
                        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, \ufeab\u0632\u062f\u0640.\ufed9\ufeab\u0643\u0633(\u0638\ufead\u062e\ufee1.\ufeb1\ufe99\ufe8f\u062a(object2, object), string2));
                        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, string);
                        string = \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(stringBuilder);
                        object = new LinkedHashMap();
                        String string4 = AppTT.\u0645\u062a\ufead\ufeed((Object)this);
                        \u0636\u0634\ufec1\u0631.\u0637\u0635\ufedd\u0644(object, \u0635\u0631\u0645\u0628.\u0646\u0627\u062a\u062d(AppTT.\ufeab\u0647\ufeaf\ufe8e(), 52, 10, 2899), string4);
                        object = \ufebd\u0640\u0648\u062b.\u0646\ufed5\u0630\ufec9(string, object);
                        string = new JSONObject((String)object);
                        bl = \ufeb9\u0643\ufed9\ufed5.\u0636\u0647\ufee9\ufeed(string, string3);
                        n = 1740;
                        break block51;
                    }
                    case 239: {
                        return new JSONObject();
                    }
                }
                break;
            }
            block52: while (true) {
                object = string;
                switch (n ^= 0x6DD) {
                    default: {
                        continue block52;
                    }
                    case 17: {
                        if (bl) {
                            n = 1833;
                            continue block52;
                        }
                    }
                    case 54: {
                        n = 1802;
                        continue block52;
                    }
                    case 500: {
                        bl = \ufeaf\u062b\ufed5\ufec1.\ufef1\ufee1\ufedd\u062e(string, string3) instanceof JSONObject;
                        n = 1864;
                        break block52;
                    }
                    case 471: {
                        break block65;
                    }
                }
                break;
            }
            block53: while (true) {
                object = string;
                switch (n ^= 0x759) {
                    default: {
                        continue block53;
                    }
                    case 17: {
                        if (bl) {
                            n = 48736;
                            continue block53;
                        }
                    }
                    case 47483: {
                        n = 48705;
                        continue block53;
                    }
                    case 47417: {
                        object = \ufeaf\ufea5\ufeab\u062e.\ufe99\ufea9\u0647\u0641(string, string3);
                    }
                    case 47384: 
                }
                break;
            }
        }
        n = 48767;
        block54: while (true) {
            switch (n ^= 0xBE90) {
                default: {
                    continue block54;
                }
                case 239: {
                    if (object != null) {
                        n = 48860;
                        continue block54;
                    }
                }
                case 14: {
                    n = 48829;
                    continue block54;
                }
                case 76: {
                    int n2 = \u062b\ufec1\ufeb1\u062d.\ufeb9\u0631\ufed9\ufed5(object);
                    n = 48891;
                    block55: while (true) {
                        switch (n ^= 0xBF0C) {
                            default: {
                                continue block55;
                            }
                            case 503: {
                                if (n2 > 0) {
                                    n = 49635;
                                    continue block55;
                                }
                            }
                            case 22: {
                                n = 48953;
                                continue block55;
                            }
                            case 32495: {
                                string = \ufeab\u0632\u062f\u0640.\ufed9\ufeab\u0643\u0633(object, string2);
                                bl = \ufea5\u062d\ufebd\u0633.\u0639\ufeb1\ufead\ufe8f(string);
                                n = 49666;
                                break block55;
                            }
                            case 53: {
                                return new JSONObject();
                            }
                        }
                        break;
                    }
                    block56: while (true) {
                        switch (n ^= 0xC213) {
                            default: {
                                continue block56;
                            }
                            case 17: {
                                if (!bl) {
                                    n = 49759;
                                    continue block56;
                                }
                            }
                            case 50: {
                                n = 49728;
                                continue block56;
                            }
                            case 76: {
                                bl = \u062b\ufec1\ufeb1\u062d.\ufea9\u0628\u0637\ufe95(string, \ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(AppTT.\ufeab\u0647\ufeaf\ufe8e(), 62, 4, 921));
                                n = 49790;
                                block57: while (true) {
                                    switch (n ^= 0xC28F) {
                                        default: {
                                            continue block57;
                                        }
                                        case 241: {
                                            if (!bl) {
                                                n = 49883;
                                                continue block57;
                                            }
                                        }
                                        case 18: {
                                            n = 49852;
                                            continue block57;
                                        }
                                        case 84: {
                                            try {
                                                \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(object, \ufeaf\u0633\u0648\ufee9.\u062e\u0645\u0644\u0648(AppTT.\ufeab\u0647\ufeaf\ufe8e(), 66, 7, 1240), \ufea9\ufe8f\u0647\ufead.\ufec1\u0631\u062a\u062e(string));
                                                return object;
                                            }
                                            catch (Exception exception) {
                                                AppTT.\u0630\u0646\ufeb9\u0638(exception);
                                                return new JSONObject();
                                            }
                                        }
                                        case 51: 
                                    }
                                    break;
                                }
                            }
                            case 83: 
                        }
                        break;
                    }
                }
                case 45: 
            }
            break;
        }
        return new JSONObject();
    }

    private String yq(String string) {
        String string2 = "\u06e8\u06e7\u06e5";
        short[] sArray = null;
        StringBuilder stringBuilder = null;
        String string3 = null;
        String string4 = string;
        string = string2;
        block9: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    sArray = AppTT.\ufeab\u0647\ufeaf\ufe8e();
                    string = "\u06e5\u06e4\u06e0";
                    continue block9;
                }
                case 1747867: {
                    string3 = \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(stringBuilder);
                    string = "\u06e8\u06df\u06e4";
                    continue block9;
                }
                case 56387: {
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, string4);
                    string = "\u06e0\u06e6\u06e1";
                    continue block9;
                }
                case 1755341: {
                    string4 = \ufe99\u062c\u0643\ufec1.\u0644\ufec5\u062e\u0631(string3);
                    string = "\u06df\u06e5\u06e4";
                    continue block9;
                }
                case 1755523: {
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, string3);
                    string = "\u06e2\u06e5";
                    continue block9;
                }
                case 1752609: {
                    string3 = \u062d\u062e\ufe8e\u0645.\u062d\ufeab\u0642\u0647(sArray, 73, 38, 2690);
                    string = "\u06e8\u06e5\u06e0";
                    continue block9;
                }
                case 1755590: {
                    stringBuilder = new StringBuilder();
                    string = "\u06df\u06e8\u06e4";
                    continue block9;
                }
                case 1746878: 
            }
            break;
        }
        return string4;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Response \u0627\u0643\u062d\ufeab(Object object) {
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
                    return ((Call)object).execute();
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
    public static String \u062d\ufee9\ufea9\u062a(Object object) {
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
                    return ((AppTT)((Object)object)).tF;
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
    public static MultipartBody.Builder \u062e\ufe99\u0635\u0647(Object object, Object object2) {
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
                    return ((MultipartBody.Builder)object).setType((MediaType)object2);
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
    public static String \u062f\ufec9\u0639\u062c(Object object) {
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
    public static void \u0630\u0646\ufeb9\u0638(Object object) {
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
    public static boolean \u0632\u0647\ufecd\ufe8f(Object object) {
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
                    return ((Response)object).isSuccessful();
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
    public static MediaType \u0633\ufec1\ufec5\u062e() {
        int n = \ufe9d\u0631\ufe8f\u064a.\ufebd\u0643\ufe9d\u062c();
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
                    return MultipartBody.FORM;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            MediaType mediaType = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return mediaType;
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
    public static Request.Builder \u0635\u0646\ufee1\u064a(Object object, Object object2, Object object3) {
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
                    return ((Request.Builder)object).addHeader((String)object2, (String)object3);
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
    public static String \u0637\ufead\ufeaf\ufee1(Object object, Object object2) {
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
                    return ((AppTT)((Object)object)).yq((String)object2);
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
    public static Call \u0640\u064a\u062b\u0646(Object object, Object object2) {
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
                    return ((OkHttpClient)object).newCall((Request)object2);
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
    public static JSONObject \u0642\u0634\ufed9\ufed5(Object object, Object object2, Object object3, Object object4) {
        int n = \u0644\ufe8f\u0628\u062a.\u0647\ufebd\u0627\u0631();
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
                    return ((AppTT)((Object)object)).SN((String)object2, (String)object3, (JSONObject)object4);
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
    public static Request.Builder \u0644\ufecd\u062d\ufeb9(Object object, Object object2) {
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
                    return ((Request.Builder)object).post((RequestBody)object2);
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
    public static String \u0645\u062a\ufead\ufeed(Object object) {
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
                    return ((AppTT)((Object)object)).SN;
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
    public static Request.Builder \ufe8f\u062d\u0643\ufed9(Object object, Object object2) {
        int n = \ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646();
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
                    return ((Request.Builder)object).url((String)object2);
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
    public static ResponseBody \ufe95\ufee1\u062e\u062c(Object object) {
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
    public static MultipartBody.Builder \ufe99\ufec9\ufe95\u0647(Object object, Object object2, Object object3) {
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
                    return ((MultipartBody.Builder)object).addFormDataPart((String)object2, (String)object3);
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
    public static String \ufea1\ufec9\u0639\u0641(Object object, Object object2, Object object3) {
        int n = \u062d\u062e\ufe8e\u0645.\u0637\ufea1\ufed5\ufeab();
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
                    return ((AppTT)((Object)object)).N((String)object2, (Map)object3);
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
    public static MultipartBody \ufeab\u0633\ufea5\ufec9(Object object) {
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
                    return ((MultipartBody.Builder)object).build();
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
    public static short[] \ufeab\u0647\ufeaf\ufe8e() {
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
    public static JSONObject \ufead\ufed9\u062c\u0634(Object object) {
        int n = \u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634();
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
                    return ((AppTT)((Object)object)).N;
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
    public static Request \ufec5\u0642\u0628\ufe8f(Object object) {
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
                    return ((Request.Builder)object).build();
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
    public static String \ufecd\u0642\ufed9\u0630(Object object) {
        int n = \ufe8e\ufec1\u0641\u0644.\u062c\u0642\ufe9d\ufef1();
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
                    return ((AppTT)((Object)object)).yq;
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
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 2[TRYBLOCK] [2 : 738->894)] java.lang.Exception
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
     * Could not resolve type clashes
     */
    public String homeContent(boolean var1_1) {
        var8_2 = \u0632\ufead\u062f\u0628.\u0645\u062a\u0637\u0635(AppTT.\ufeab\u0647\ufeaf\ufe8e(), 461, 7, 834);
        var5_3 = \ufed9\ufe9d\ufeed\ufeb5.\u0638\ufec1\u063a\u0644(AppTT.\ufeab\u0647\ufeaf\ufe8e(), 468, 9, 3157);
        var6_5 = new JSONObject();
        var7_6 = new JSONArray();
        var11_7 = \u0630\ufebd\u0634\ufec9.\ufea9\u062f\u0648\u062d(\ufe99\u062c\u0643\ufec1.\ufedd\u0641\u062b\ufea9() / 1000L);
        var10_8 /* !! */  = AppTT.\u0637\ufead\ufeaf\ufee1((Object)this, var11_7);
        var9_9 = new LinkedHashMap();
        \u0636\u0634\ufec1\u0631.\u0637\u0635\ufedd\u0644(var9_9, \u0645\u0641\u0630\u062d.\u0642\u062a\u0630\ufebd(AppTT.\ufeab\u0647\ufeaf\ufe8e(), 477, 4, 2329), var10_8 /* !! */ );
        \u0636\u0634\ufec1\u0631.\u0637\u0635\ufedd\u0644(var9_9, \u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(AppTT.\ufeab\u0647\ufeaf\ufe8e(), 481, 9, 370), var11_7);
        var10_8 /* !! */  = new StringBuilder();
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var10_8 /* !! */ , AppTT.\ufecd\u0642\ufed9\u0630((Object)this));
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var10_8 /* !! */ , \ufea1\u0645\u062b\u0634.\u0638\ufec9\u0630\ufe95(AppTT.\ufeab\u0647\ufeaf\ufe8e(), 490, 17, 1593));
        var9_9 = AppTT.\ufea1\ufec9\u0639\u0641((Object)this, \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(var10_8 /* !! */ ), var9_9);
        var10_8 /* !! */  = new JSONObject((String)var9_9);
        var10_8 /* !! */  = \ufee9\ufee1\u0627\u0641.\ufead\ufeb1\u0627\u0641(\ufeaf\ufea5\ufeab\u062e.\ufe99\ufea9\u0647\u0641(var10_8 /* !! */ , \ufed9\ufe9d\ufeed\ufeb5.\u0638\ufec1\u063a\u0644(AppTT.\ufeab\u0647\ufeaf\ufe8e(), 507, 4, 1590)), \u0630\ufebd\u0634\ufec9.\u0639\ufe8f\u064a\ufebd(AppTT.\ufeab\u0647\ufeaf\ufe8e(), 511, 4, 1224));
        var3_10 = 0;
        block15: while (true) {
            var4_12 = \u0644\ufe8f\u0628\u062a.\ufee9\ufe8e\ufe99\u0631(var10_8 /* !! */ );
            var2_11 = 1616;
            block16: while (true) {
                switch (var2_11 ^= 1633) {
                    default: {
                        continue block16;
                    }
lbl30:
                    // 2 sources

                    case 14: {
                        var2_11 = 1678;
                        continue block16;
                    }
                    case 49: {
                        if (var3_10 >= var4_12) ** GOTO lbl30
                        var2_11 = 1709;
                        continue block16;
                    }
                    case 204: {
                        var11_7 = \ufeaf\u0633\u0648\ufee9.\u062e\u062f\u0644\u0645(var10_8 /* !! */ , var3_10);
                        var9_9 = \ufeab\u0632\u062f\u0640.\ufed9\ufeab\u0643\u0633(var11_7, var5_3);
                        var11_7 = \u0644\ufe8f\u0628\u062a.\ufeaf\u062b\ufed5\ufec1(\ufeb1\ufe8e\ufee1\ufe9d.\u062c\ufeb5\ufea5\u063a(var11_7, var8_2));
                        var12_13 = new JSONObject();
                        \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(var12_13, var5_3, var9_9);
                        \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(var12_13, var8_2, var11_7);
                        \u0630\ufebd\u0634\ufec9.\u0645\ufead\u0635\u0634(var7_6, var12_13);
                        var2_11 = 1740;
                        block18: while (true) {
                            switch (var2_11 ^= 1757) {
                                default: {
                                    continue block18;
                                }
                                case 17: {
                                    var2_11 = 1771;
                                    continue block18;
                                }
                                case 54: 
                            }
                            break;
                        }
                        ++var3_10;
                        continue block15;
                    }
                    case 239: 
                }
                break;
            }
            break;
        }
        try {
            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(var6_5, \ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(AppTT.\ufeab\u0647\ufeaf\ufe8e(), 515, 5, 2167), var7_6);
            var5_3 = \ufeaf\u0633\u0648\ufee9.\ufeb5\u0634\u0640\ufea1(var6_5);
lbl65:
            // 2 sources

            return var5_3;
        }
        catch (Exception var5_4) {
            AppTT.\u0630\u0646\ufeb9\u0638(var5_4);
            var5_3 = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
            ** continue;
        }
    }

    /*
     * Exception decompiling
     */
    public String homeVideoContent() {
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
    public void init(Context context, String string) {
        int n;
        super.init(context, string);
        try {
            this.yq = \ufe95\u0627\ufe8e\u0644.\ufe95\ufeb1\ufec1\u0633(string);
            n = 1616;
        }
        catch (Exception exception) {
            AppTT.\u0630\u0646\ufeb9\u0638(exception);
            return;
        }
        block6: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block6;
                }
                case 14: {
                    return;
                }
                case 49: 
            }
            n = 1647;
        }
    }

    /*
     * Exception decompiling
     */
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
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 7[TRYBLOCK] [7 : 818->837)] java.lang.Exception
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

    private static long[] $d2j$hex$9c8b1947$decode_J(String src) {
        byte[] d = AppTT.$d2j$hex$9c8b1947$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$9c8b1947$decode_I(String src) {
        byte[] d = AppTT.$d2j$hex$9c8b1947$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$9c8b1947$decode_S(String src) {
        byte[] d = AppTT.$d2j$hex$9c8b1947$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$9c8b1947$decode_B(String src) {
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

