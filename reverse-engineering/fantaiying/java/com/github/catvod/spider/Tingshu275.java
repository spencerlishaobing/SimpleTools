/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.github.catvod.crawler.Spider
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.content.Context;
import com.github.catvod.crawler.Spider;
import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u062b\u064a\ufecd\u0642;
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
import com.github.catvod.spider.merge.Jz;
import com.github.catvod.spider.merge.Tq;
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
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\u0636\u0634\ufec1\u0631;
import com.github.catvod.spider.\u0640\u0633\ufea5\u0631;
import com.github.catvod.spider.\ufe8e\ufeb9\u0647\u0642;
import com.github.catvod.spider.\ufe99\u062c\u0643\ufec1;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class Tingshu275
extends Spider {
    private static final short[] short = Tingshu275.$d2j$hex$0d3ecc9e$decode_S("9406880688068c068f06c606d306d3069d068c068c06d206cf06ca06c9068806950692069b06d2069f0693069106c801ee01f801ef01b001dc01fa01f801f301e901b804850482048b04bf0484048504a60485048904c304dd04c204d404c204d404cc04c4048104c2048504de04db04d904c2048f0483048104c50488048a049f048e04a2048f045d0c5f0c4a0c5b0c590c510c4c0c470c720c570c4d0c4a0c010c4d0c570c440c5b0c030c0f0c0e0c180c4e0c5f0c590c5b0c030c1b0c4d0c180c5d0c5f0c4a0c5b0c590c510c4c0c470c770c5a0c030c1b0c4d0c2105240531052405610a640a7e0a790af80af50a6909640964096009420966096a096c096e093c073107310735070a0737072a0732073b0792039f039f039b03b1039e03930398039f03820339033403340330036403390334033403300312033f0366030508000815080008450a480a480a4c0a630a460a530a460ac101cc01cc01c801f701ca01d701cf01c601bc0ab10ab10ab50a970ab30abf0ab90abb0a69056b057e056f056d0565057805730544056b0567056f050e07030703070707280709071f070f07ca0cc70cc70cc30ce90cc60ccb0cc00cc70cda0c5f0554055d054c05480559054e0503054f05550546055905010505050505050505051a054c055d055b05590501050d051a054f0553054e05480501055d054f055f051a055e05530553055705750558050105cc08c908d308d408c401d901c401dc01d5010a05c305c805c105d005d405c505d205e905c405560656065606bb040277089514031403140325043509ff02d50349094809e701e7012b0228025e045c04e902ec02d508d1089b089608af76505b6c5c505bb5964a58488c8d6610532c6dc8512a902150835cff5ea169c8690e4d774c0e4d1d51aa4ca4600a775c6497912f7e8559379be57f85707087906bd66b0a6b5a6b896f68518859fc599744946a766aac6bd501d3014a0c560c560c520c180c0d0c0d0c130c130c150c0c0c150c100c0c0c130c130c100c0c0c100c110c160c180c1a0c120c1b0c120c0d0c410c4d0c4c0c440c4b0c450c0d0c560c4b0c4c0c450c410c4a0c4b0c4c0c430c100c120c100c170c0c0c560c5a0c560ce20cc20ce20cc20ce20cc20cc906f806f806cf06ed06fc06cb06e006e906f806fc06ed06fa06dd06fa06e406ba06b806ba06bb06b706fc06e106e506ed06db06fc06e906e506f806b506410212020e0203025a02410204020f02060217021302020215022e0203025a0278073f073a073a0717072a070e073f072c073f072e073b072a076307b407f007fd07fd07f907db07f607af07910590058105d701f101e701f001af01c301e501e701ec01f601cf07ca07d007d707c607cd078c0792078d079b078d079a0783078b07ef07ca07cd07d607db079807e207cd07c707d107cc07ca07c7078307920791078a078307e607db07cc07f307cf07c207da07c607d107ef07ca07c1078c0791078d079b078d0797071f055c0559054305440555055e051f05510540054005580551055905540551055f051f055105400540056305550551054205530558050f054305550551054205530558050d052f0a2a0a3f0a2a0a590b540b540b500b7f0b5a0b4f0b5a0be90ae40a72097f097f097b0959097d09710977097509f40cf90cf90cfd0cc20cff0ce20cfa0cf30cfb05f605f605f205d805f705fa05f105f605eb05ea04");
    private String yq = \u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(Tingshu275.\u064a\ufeab\u0641\u062f(), 0, 23, 1788);

    /*
     * Enabled aggressive block sorting
     */
    public Tingshu275() {
        int n = \u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648();
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
                    long l = Long.parseLong(\u0633\u064a\u0644\u0637.\ufebd\u062e\ufef1\u064a("KYkOilDgXiE13I2Dp"));
                    System.out.println(l);
                    return;
                }
                case 239: 
            }
            break;
        }
    }

    private Map<String, String> yq() {
        String string = "\u06e2\u06e2\u06e2";
        String string2 = null;
        String string3 = null;
        HashMap hashMap = null;
        short[] sArray = null;
        block8: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    sArray = Tingshu275.\u064a\ufeab\u0641\u062f();
                    string = "\u06df\u06e2\u06e8";
                    continue block8;
                }
                case 1748891: {
                    sArray = Tingshu275.\u064a\ufeab\u0641\u062f();
                    string = "\u06e0\u06e7\u06e0";
                    continue block8;
                }
                case 1747897: {
                    string2 = \ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(sArray, 23, 10, 413);
                    string = "\u06e3\u06df\u06e6";
                    continue block8;
                }
                case 1750750: {
                    \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, string2, string3);
                    string = "\u06e4\u06e3\u06e5";
                    continue block8;
                }
                case 1749666: {
                    hashMap = new HashMap();
                    string = "\u06e1\u06e8\u06e2";
                    continue block8;
                }
                case 1746789: {
                    string3 = \u0646\ufecd\ufead\u0647.\u0640\u062e\ufed5\ufeaf(sArray, 33, 29, 1260);
                    string = "\u06e3\u06e6\u06e1";
                    continue block8;
                }
                case 1751622: 
            }
            break;
        }
        return hashMap;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Map \u062f\ufedd\ufea5\ufea1(Object map) {
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
                    return ((Tingshu275)((Object)map)).yq();
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
    public static String \u0632\ufef1\u0636\ufedd(Object object) {
        int n = \u0633\u064a\u0644\u0637.\ufec1\u062e\u0643\ufedd();
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
                    return ((Tingshu275)((Object)object)).yq;
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
    public static short[] \u064a\ufeab\u0641\u062f() {
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
     * Unable to fully structure code
     * Enabled aggressive block sorting
     */
    public String categoryContent(String var1_1, String var2_2, boolean var3_3, HashMap<String, String> var4_4) {
        var9_5 = new HashMap<K, V>();
        var5_6 = 1616;
        block42: while (true) {
            switch (var5_6 ^= 1633) {
                default: {
                    continue block42;
                }
                case 49: {
                    if (var4_4 != null) {
                        var5_6 = 1709;
                        continue block42;
                    }
                }
                case 14: {
                    var5_6 = 1678;
                    continue block42;
                }
                case 204: {
                    var6_7 = \u0640\u0633\ufea5\u0631.\u0641\u062a\ufeb5\u0634(var4_4);
                    var5_6 = 1740;
                    block43: while (true) {
                        switch (var5_6 ^= 1757) {
                            default: {
                                continue block43;
                            }
                            case 17: {
                                if (var6_7 > 0) {
                                    var5_6 = 1833;
                                    continue block43;
                                }
                            }
                            case 54: {
                                var5_6 = 1802;
                                continue block43;
                            }
                            case 500: {
                                \ufe99\u062c\u0643\ufec1.\u062d\ufeb1\ufec9\u0642(var9_5, var4_4);
                            }
                            case 471: 
                        }
                        break;
                    }
                    break block42;
                }
                case 239: 
            }
            break;
        }
        var10_8 = \u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(Tingshu275.\u064a\ufeab\u0641\u062f(), 62, 6, 1259);
        var4_4 = \u0641\u0631\ufeed\u0643.\ufedd\u0631\ufebd\u062d(var9_5, var10_8);
        var5_6 = 1864;
        block44: while (true) {
            switch (var5_6 ^= 1881) {
                default: {
                    continue block44;
                }
                case 17: {
                    if (var4_4 == null) {
                        var5_6 = 48736;
                        continue block44;
                    }
                }
                case 47483: {
                    var5_6 = 48705;
                    continue block44;
                }
                case 47417: {
                    var5_6 = 48767;
                    break block44;
                }
                case 47384: {
                    var4_4 = (String)\u0641\u0631\ufeed\u0643.\ufedd\u0631\ufebd\u062d(var9_5, var10_8);
                    ** GOTO lbl-1000
                }
            }
            break;
        }
        block45: while (true) {
            var4_4 = var1_1 /* !! */ ;
            switch (var5_6 ^= 48784) {
                default: {
                    continue block45;
                }
                case 14: lbl-1000:
                // 2 sources

                {
                    var1_1 /* !! */  = new StringBuilder();
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var1_1 /* !! */ , Tingshu275.\u0632\ufef1\u0636\ufedd((Object)this));
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var1_1 /* !! */ , \ufea1\u0645\u062b\u0634.\ufee9\ufee1\ufecd\ufedd(\ufeb9\u0643\ufed9\ufed5.\u0628\u062f\ufea1\u0642(Tingshu275.\u064a\ufeab\u0641\u062f(), 68, 42, 3134), new Object[]{var2_2, var4_4}));
                    var4_4 = \ufebd\u0640\u0648\u062b.\u0646\ufed5\u0630\ufec9(\ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(var1_1 /* !! */ ), Tingshu275.\u062f\ufedd\ufea5\ufea1((Object)this));
                    var7_9 = \u062f\ufead\ufeaf\u062d.\ufeed\u062d\u0637\u0641(var2_2);
                    var1_1 /* !! */  = new ArrayList<E>();
                    var2_2 = \ufee9\ufee1\u0627\u0641.\ufead\ufeb1\u0627\u0641(\ufeaf\ufea5\ufeab\u062e.\ufe99\ufea9\u0647\u0641(new JSONObject((String)var4_4), \ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(Tingshu275.\u064a\ufeab\u0641\u062f(), 110, 4, 1349)), \ufeaf\u0633\u0648\ufee9.\u062e\u0645\u0644\u0648(Tingshu275.\u064a\ufeab\u0641\u062f(), 114, 4, 2573));
                    var6_7 = 0;
                    break block45;
                }
                case 239: {
                    var5_6 = 48798;
                    continue block45;
                }
            }
            break;
        }
        block46: while (true) {
            var8_10 = \u0644\ufe8f\u0628\u062a.\ufee9\ufe8e\ufe99\u0631(var2_2);
            var5_6 = 48891;
            block47: while (true) {
                switch (var5_6 ^= 48908) {
                    default: {
                        continue block47;
                    }
                    case 503: {
                        if (var6_7 < var8_10) {
                            var5_6 = 49635;
                            continue block47;
                        }
                    }
                    case 22: {
                        var5_6 = 48953;
                        continue block47;
                    }
                    case 32495: {
                        var4_4 = \ufeaf\u0633\u0648\ufee9.\u062e\u062f\u0644\u0645(var2_2, var6_7);
                        var9_5 = \ufeab\u0632\u062f\u0640.\ufeab\u0632\ufec5\u0645(var4_4, \u062a\ufee1\ufe8e\ufeb9.\ufec5\ufecd\ufea9\ufea5(Tingshu275.\u064a\ufeab\u0641\u062f(), 118, 2, 2705));
                        var10_8 = \ufeab\u0632\u062f\u0640.\ufeab\u0632\ufec5\u0645(var4_4, \u0630\ufebd\u0634\ufec9.\u0639\ufe8f\u064a\ufebd(Tingshu275.\u064a\ufeab\u0641\u062f(), 120, 9, 2315));
                        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(var1_1 /* !! */ , new Ef((String)var9_5, \ufeab\u0632\u062f\u0640.\ufeab\u0632\ufec5\u0645(var4_4, \ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(Tingshu275.\u064a\ufeab\u0641\u062f(), 129, 9, 1886)), var10_8, \ufeab\u0632\u062f\u0640.\ufeab\u0632\ufec5\u0645(var4_4, \u0646\ufecd\ufead\u0647.\u0640\u062e\ufed5\ufeaf(Tingshu275.\u064a\ufeab\u0641\u062f(), 138, 10, 1008))));
                        var8_10 = var6_7 + 1;
                        var5_6 = 49666;
                        block48: while (true) {
                            var6_7 = var8_10;
                            switch (var5_6 ^= 49683) {
                                case 50: {
                                    continue block46;
                                }
                                default: {
                                    continue block48;
                                }
                                case 17: 
                            }
                            var5_6 = 49697;
                        }
                    }
                    case 53: 
                }
                break;
            }
            break;
        }
        var6_7 = \ufea9\ufe8f\u0647\ufead.\u0631\ufe8f\u0628\ufe99(var1_1 /* !! */ );
        var5_6 = 49790;
        block49: while (true) {
            switch (var5_6 ^= 49807) {
                default: {
                    continue block49;
                }
                case 241: {
                    if (var6_7 < 10) {
                        var5_6 = 49883;
                        continue block49;
                    }
                }
                case 18: {
                    var5_6 = 49852;
                    continue block49;
                }
                case 84: {
                    var5_6 = 49914;
                    block50: while (true) {
                        switch (var5_6 ^= 49931) {
                            default: {
                                continue block50;
                            }
                            case 497: {
                                var5_6 = 50596;
                                continue block50;
                            }
                            case 1711: 
                        }
                        break;
                    }
                    var5_6 = var7_9;
                    break block49;
                }
                case 51: {
                    var5_6 = var7_9 + 1;
                }
            }
            break;
        }
        var2_2 = new Tq();
        \ufe9d\ufeab\u062e\u0640.\ufead\ufe8e\u064a\ufeb5(var2_2, var1_1 /* !! */ );
        \u0631\u063a\u0645\u0641.\u0646\u0641\u0632\u062e(var2_2, var7_9, var5_6, 10, 0);
        return \ufeed\ufebd\u0635\ufedd.\ufec1\ufef1\u0632\ufe8e(var2_2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public String detailContent(List<String> object) {
        int n;
        int n2 = 0;
        String string = (String)\u0646\ufecd\ufead\u0647.\u0643\ufe8e\u0644\ufe95(object, 0);
        object = new StringBuilder();
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(object, Tingshu275.\u0632\ufef1\u0636\ufedd((Object)this));
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(object, \ufeaf\u0633\u0648\ufee9.\u062e\u0645\u0644\u0648(Tingshu275.\u064a\ufeab\u0641\u062f(), 148, 12, 859));
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(object, string);
        object = new JSONObject(\ufebd\u0640\u0648\u062b.\u0646\ufed5\u0630\ufec9(\ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(object), Tingshu275.\u062f\ufedd\ufea5\ufea1((Object)this)));
        Object object2 = \ufee9\ufee1\u0627\u0641.\ufea1\ufebd\u063a\u0630(Tingshu275.\u064a\ufeab\u0641\u062f(), 160, 4, 2145);
        JSONObject jSONObject = \ufeaf\ufea5\ufeab\u062e.\ufe99\ufea9\u0647\u0641(\ufeaf\ufea5\ufeab\u062e.\ufe99\ufea9\u0647\u0641(object, object2), \ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(Tingshu275.\u064a\ufeab\u0641\u062f(), 164, 8, 2599));
        object = new Ef();
        \u062f\ufead\ufeaf\u062d.\ufe8e\ufea9\u0641\ufebd(object, string);
        \u0645\u0641\u0630\u062d.\u0643\u0636\ufe99\ufed5(object, \ufeab\u0632\u062f\u0640.\ufed9\ufeab\u0643\u0633(jSONObject, \u0635\u0631\u0645\u0628.\u0646\u0627\u062a\u062d(Tingshu275.\u064a\ufeab\u0641\u062f(), 172, 9, 419)));
        \u0633\u064a\u0644\u0637.\u0639\ufeaf\ufec9\u0632(object, \ufeab\u0632\u062f\u0640.\ufed9\ufeab\u0643\u0633(jSONObject, \ufeab\u062d\u063a\ufea9.\u062f\u0642\ufebd\u064a(Tingshu275.\u064a\ufeab\u0641\u062f(), 181, 9, 2782)));
        \u0644\ufe8f\u0628\u062a.\ufed9\ufead\ufef1\ufea5(object, \ufeab\u0632\u062f\u0640.\ufed9\ufeab\u0643\u0633(jSONObject, \ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(Tingshu275.\u064a\ufeab\u0641\u062f(), 190, 12, 1290)));
        \ufe8e\ufec1\u0641\u0644.\ufeb1\u0636\ufeaf\u0639(object, \ufeab\u0632\u062f\u0640.\ufed9\ufeab\u0643\u0633(jSONObject, \u0632\ufead\u062f\u0628.\u0645\u062a\u0637\u0635(Tingshu275.\u064a\ufeab\u0641\u062f(), 202, 8, 1900)));
        Object object3 = \ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(Tingshu275.\u064a\ufeab\u0641\u062f(), 210, 10, 3240);
        \ufeed\ufebd\u0635\ufedd.\u0630\u0641\u0635\u0637(object, \ufeab\u0632\u062f\u0640.\ufed9\ufeab\u0643\u0633(jSONObject, object3));
        \ufeed\ufebd\u0635\ufedd.\u0642\ufebd\u062e\u063a(object, \ufeab\u0632\u062f\u0640.\ufed9\ufeab\u0643\u0633(jSONObject, object3));
        object3 = new StringBuilder();
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(object3, Tingshu275.\u0632\ufef1\u0636\ufedd((Object)this));
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(object3, \ufea9\ufe8f\u0647\ufead.\ufea9\u0643\ufedd\ufeed(Tingshu275.\u064a\ufeab\u0641\u062f(), 220, 41, 1340));
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(object3, string);
        JSONArray jSONArray = \ufee9\ufee1\u0627\u0641.\ufead\ufeb1\u0627\u0641(\ufeaf\ufea5\ufeab\u062e.\ufe99\ufea9\u0647\u0641(new JSONObject(\ufebd\u0640\u0648\u062b.\u0646\ufed5\u0630\ufec9(\ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(object3), Tingshu275.\u062f\ufedd\ufea5\ufea1((Object)this))), object2), \ufea9\ufe8f\u0647\ufead.\ufea9\u0643\ufedd\ufeed(Tingshu275.\u064a\ufeab\u0641\u062f(), 261, 4, 2208));
        object3 = new ArrayList();
        object2 = new LinkedHashMap();
        block22: while (true) {
            int n3 = \u0644\ufe8f\u0628\u062a.\ufee9\ufe8e\ufe99\u0631(jSONArray);
            n = 1616;
            block23: while (true) {
                switch (n ^= 0x661) {
                    default: {
                        continue block23;
                    }
                    case 49: {
                        if (n2 < n3) {
                            n = 1709;
                            continue block23;
                        }
                    }
                    case 14: {
                        n = 1678;
                        continue block23;
                    }
                    case 204: {
                        JSONObject jSONObject2 = \ufeaf\u0633\u0648\ufee9.\u062e\u062f\u0644\u0645(jSONArray, n2);
                        StringBuilder stringBuilder = new StringBuilder();
                        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, \ufeab\u0632\u062f\u0640.\ufeab\u0632\ufec5\u0645(jSONObject2, \ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(Tingshu275.\u064a\ufeab\u0641\u062f(), 265, 5, 432)));
                        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, \ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(Tingshu275.\u064a\ufeab\u0641\u062f(), 270, 1, 1326));
                        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, \ufeab\u0632\u062f\u0640.\ufeab\u0632\ufec5\u0645(jSONObject2, \ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(Tingshu275.\u064a\ufeab\u0641\u062f(), 271, 9, 1440)));
                        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, \u0630\ufebd\u0634\ufec9.\u0639\ufe8f\u064a\ufebd(Tingshu275.\u064a\ufeab\u0641\u062f(), 280, 3, 1578));
                        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, string);
                        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(object3, \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(stringBuilder));
                        n3 = n2 + 1;
                        n = 1740;
                        block24: while (true) {
                            n2 = n3;
                            switch (n ^= 0x6DD) {
                                case 54: {
                                    continue block22;
                                }
                                default: {
                                    continue block24;
                                }
                                case 17: 
                            }
                            n = 1771;
                        }
                    }
                    case 239: 
                }
                break;
            }
            break;
        }
        n2 = \ufea9\ufe8f\u0647\ufead.\u0631\ufe8f\u0628\ufe99(object3);
        n = 1864;
        block25: while (true) {
            switch (n ^= 0x759) {
                default: {
                    continue block25;
                }
                case 17: {
                    if (n2 > 0) {
                        n = 48736;
                        continue block25;
                    }
                }
                case 47483: {
                    n = 48705;
                    continue block25;
                }
                case 47417: {
                    string = \u062b\ufec1\ufeb1\u062d.\u0628\ufeed\ufea5\u0636(\ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644(Tingshu275.\u064a\ufeab\u0641\u062f(), 283, 1, 1176), object3);
                    \u0636\u0634\ufec1\u0631.\u0637\u0635\ufedd\u0644(object2, \ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(Tingshu275.\u064a\ufeab\u0641\u062f(), 284, 2, 502), string);
                    break block25;
                }
                case 47384: 
            }
            break;
        }
        n2 = \u0638\ufead\u062e\ufee1.\u0647\ufeaf\ufeb1\ufee9(object2);
        n = 48767;
        block26: while (true) {
            switch (n ^= 0xBE90) {
                default: {
                    continue block26;
                }
                case 239: {
                    if (n2 > 0) {
                        n = 48860;
                        continue block26;
                    }
                }
                case 14: {
                    n = 48829;
                    continue block26;
                }
                case 76: {
                    object3 = \u0632\ufead\u062f\u0628.\u0643\u0630\u062a\u0641(object2);
                    string = \ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(Tingshu275.\u064a\ufeab\u0641\u062f(), 286, 3, 816);
                    \ufeb9\u0627\ufea5\ufe9d.\ufef1\ufed5\ufea9\u0644(object, \u062b\ufec1\ufeb1\u062d.\u0628\ufeed\ufea5\u0636(string, object3));
                    \u0632\ufead\u062f\u0628.\ufe99\ufeab\ufe8f\u062f(object, \u062b\ufec1\ufeb1\u062d.\u0628\ufeed\ufea5\u0636(string, \ufe9d\ufeab\u062e\u0640.\ufed5\u0644\u0634\ufeaf(object2)));
                    return \ufea9\ufec5\u0647\u0641.\ufebd\ufeaf\ufee1\ufed5(object);
                }
                case 45: 
            }
            break;
        }
        return \ufea9\ufec5\u0647\u0641.\ufebd\ufeaf\ufee1\ufed5(object);
    }

    /*
     * Enabled aggressive block sorting
     */
    public String homeContent(boolean bl) {
        ArrayList arrayList = new ArrayList();
        List list = \u0645\u0641\u0630\u062d.\ufe9d\u0636\u064a\u0648(new String[]{\u062f\ufead\ufeaf\u062d.\ufec9\u0630\ufed9\ufeb1(Tingshu275.\u064a\ufeab\u0641\u062f(), 289, 1, 1043), \u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(Tingshu275.\u064a\ufeab\u0641\u062f(), 290, 1, 2306), \ufe99\u062c\u0643\ufec1.\u0648\u0634\u063a\ufeb1(Tingshu275.\u064a\ufeab\u0641\u062f(), 291, 1, 711), \u0630\ufebd\u0634\ufec9.\u0639\ufe8f\u064a\ufebd(Tingshu275.\u064a\ufeab\u0641\u062f(), 292, 1, 1004), \ufea9\ufe8f\u0647\ufead.\ufea9\u0643\ufedd\ufeed(Tingshu275.\u064a\ufeab\u0641\u062f(), 293, 2, 2424), \ufe8f\ufe8e\ufeb5\u0641.\u062f\u0627\u0640\ufee1(Tingshu275.\u064a\ufeab\u0641\u062f(), 295, 2, 470), \ufea9\u0643\u062d\u063a.\ufea1\u0633\ufe8e\u0627(Tingshu275.\u064a\ufeab\u0641\u062f(), 297, 2, 538), \ufee9\ufee1\u0627\u0641.\ufea1\ufebd\u063a\u0630(Tingshu275.\u064a\ufeab\u0641\u062f(), 299, 2, 1135), \u0632\ufead\u062f\u0628.\u0645\u062a\u0637\u0635(Tingshu275.\u064a\ufeab\u0641\u062f(), 301, 2, 728), \u062d\ufeb9\ufeab\ufef1.\ufeed\u0638\u0635\ufed5(Tingshu275.\u064a\ufeab\u0641\u062f(), 303, 2, 2276), \ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(Tingshu275.\u064a\ufeab\u0641\u062f(), 305, 2, 2223)});
        List list2 = \u0645\u0641\u0630\u062d.\ufe9d\u0636\u064a\u0648(new String[]{\u062a\ufee1\ufe8e\ufeb9.\ufec5\ufecd\ufea9\ufea5(Tingshu275.\u064a\ufeab\u0641\u062f(), 307, 4, 1323), \u062b\ufec1\ufeb1\u062d.\u0637\u0647\u0635\u0630(Tingshu275.\u064a\ufeab\u0641\u062f(), 311, 4, 1608), \ufeb5\ufe8e\ufead\u0632.\ufe8f\ufef1\u0648\ufe95(Tingshu275.\u064a\ufeab\u0641\u062f(), 315, 4, 2235), \ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(Tingshu275.\u064a\ufeab\u0641\u062f(), 319, 4, 3001), \u062a\ufee1\ufe8e\ufeb9.\ufec5\ufecd\ufea9\ufea5(Tingshu275.\u064a\ufeab\u0641\u062f(), 323, 4, 686), \ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(Tingshu275.\u064a\ufeab\u0641\u062f(), 327, 4, 780), \u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(Tingshu275.\u064a\ufeab\u0641\u062f(), 331, 4, 2046), \ufee9\u0631\ufeb5\u0628.\u0636\ufeab\u0634\u0633(Tingshu275.\u064a\ufeab\u0641\u062f(), 335, 4, 2810), \u0636\u0634\ufec1\u0631.\u062c\u063a\u0643\u0627(Tingshu275.\u064a\ufeab\u0641\u062f(), 339, 4, 3008), \u062a\ufee1\ufe8e\ufeb9.\ufec5\ufecd\ufea9\ufea5(Tingshu275.\u064a\ufeab\u0641\u062f(), 343, 4, 2574), \ufecd\u0642\u062e\ufe9d.\u0637\ufee9\u0635\u0630(Tingshu275.\u064a\ufeab\u0641\u062f(), 347, 4, 2739)});
        int n = 0;
        block10: while (true) {
            int n2 = \u062f\ufead\ufeaf\u062d.\u0648\ufe99\ufef1\ufe8e(list);
            int n3 = 1616;
            block11: while (true) {
                switch (n3 ^= 0x661) {
                    default: {
                        continue block11;
                    }
                    case 49: {
                        if (n < n2) {
                            n3 = 1709;
                            continue block11;
                        }
                    }
                    case 14: {
                        n3 = 1678;
                        continue block11;
                    }
                    case 204: {
                        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList, new Jz((String)\u0646\ufecd\ufead\u0647.\u0643\ufe8e\u0644\ufe95(list, n), (String)\u0646\ufecd\ufead\u0647.\u0643\ufe8e\u0644\ufe95(list2, n)));
                        n3 = 1740;
                        block12: while (true) {
                            switch (n3 ^= 0x6DD) {
                                default: {
                                    continue block12;
                                }
                                case 17: {
                                    n3 = 1771;
                                    continue block12;
                                }
                                case 54: 
                            }
                            break;
                        }
                        ++n;
                        continue block10;
                    }
                    case 239: 
                }
                break;
            }
            break;
        }
        return \u062a\u0635\ufeb1\u0642.\ufed5\u0630\u0647\ufec9(arrayList, new JSONObject(\ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(Tingshu275.\u064a\ufeab\u0641\u062f(), 351, 2, 430)));
    }

    public void init(Context object) {
        object = "\u06e3\u06e8\u06e6";
        String string = null;
        String string2 = null;
        Map map = null;
        short[] sArray = null;
        block7: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(object)) {
                default: {
                    string2 = \ufea5\u062d\ufebd\u0633.\ufea5\ufeb1\u0643\ufe8f(sArray, 353, 51, 3106);
                    object = "\u06e8\u06e2\u06e6";
                    continue block7;
                }
                case 1755343: {
                    sArray = Tingshu275.\u064a\ufeab\u0641\u062f();
                    object = "\u06e3\u06e8\u06e0";
                    continue block7;
                }
                case 1755436: {
                    string = \ufebd\u0640\u0648\u062b.\u0646\ufed5\u0630\ufec9(string2, map);
                    object = "\u06e5\u06e5\u06e3";
                    continue block7;
                }
                case 1752643: {
                    this.yq = string;
                    object = "\u06e1\u06e5\u06e6";
                    continue block7;
                }
                case 1750817: {
                    map = Tingshu275.\u062f\ufedd\ufea5\ufea1((Object)this);
                    object = "\u06e8\u06df\u06e6";
                    continue block7;
                }
                case 1748802: 
            }
            break;
        }
    }

    public String playerContent(String string, String object, List<String> object2) {
        Object var14_4 = null;
        object2 = null;
        String string2 = null;
        String string3 = null;
        StringBuilder stringBuilder = null;
        String string4 = null;
        String string5 = null;
        Map map = null;
        JSONObject jSONObject = null;
        Tq tq = null;
        HashMap hashMap = null;
        string = "\u06e5\u06e2\u06e1";
        String string6 = object;
        object = var14_4;
        block21: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    string4 = Tingshu275.\u0632\ufef1\u0636\ufedd((Object)this);
                    object = Tingshu275.\u064a\ufeab\u0641\u062f();
                    string = "\u06e4\u06e0\u06e8";
                    continue block21;
                }
                case 1748889: {
                    return \ufeed\ufebd\u0635\ufedd.\ufec1\ufef1\u0632\ufe8e(tq);
                }
                case 1753662: {
                    string2 = \ufeb5\ufe8e\ufead\u0632.\u0640\ufec5\ufedd\u0634(string6, object2)[1];
                    string = "\u06e7\u06e2\u06e4";
                    continue block21;
                }
                case 1749854: {
                    jSONObject = new JSONObject(\ufebd\u0640\u0648\u062b.\u0646\ufed5\u0630\ufec9(object2, map));
                    string = "\u06e8\u06e2\u06df";
                    continue block21;
                }
                case 1750718: {
                    object = Tingshu275.\u064a\ufeab\u0641\u062f();
                    string3 = \ufee9\ufee1\u0627\u0641.\ufea1\ufebd\u063a\u0630((short[])object, 482, 10, 386);
                    string = "\u06e1\u06e3\u06e5";
                    continue block21;
                }
                case 1749791: {
                    string6 = \u0631\u0640\ufec1\ufee9.\ufe95\ufeed\u062c\ufec1((short[])object, 479, 3, 1506);
                    string4 = \ufeab\u0632\u062f\u0640.\ufeab\u0632\ufec5\u0645(jSONObject, string6);
                    string = "\u06e7\u06e1\u06e5";
                    continue block21;
                }
                case 1746780: {
                    object2 = \u0630\ufebd\u0634\ufec9.\ufea9\u062f\u0648\u062d(\ufe99\u062c\u0643\ufec1.\ufedd\u0641\u062b\ufea9());
                    string = "\u06df\u06e0\u06e1";
                    continue block21;
                }
                case 1753547: {
                    \ufe8e\ufeb9\u0647\u0642.\ufef1\ufeab\ufebd\u0640(stringBuilder, string4, string5, object2, \ufe95\u0627\ufe8e\u0644.\u062d\u0636\ufea9\u0640((short[])object, 441, 16, 615));
                    string = "\u06e4\u06df\u06e7";
                    continue block21;
                }
                case 1754443: {
                    \u0645\u0641\u0630\u062d.\u063a\u0647\u0638\ufea1(tq, string4, false);
                    hashMap = new HashMap();
                    string = "\u06e3\u06e5\u06e0";
                    continue block21;
                }
                case 1754473: {
                    string6 = \ufeb5\ufe8e\ufead\u0632.\u0640\ufec5\ufedd\u0634(string6, object2)[0];
                    string = "\u06df\u06e2\u06df";
                    continue block21;
                }
                case 1751532: {
                    string5 = \ufed9\ufe9d\ufeed\ufeb5.\u0638\ufec1\u063a\u0644((short[])object, 410, 31, 1672);
                    object = Tingshu275.\u064a\ufeab\u0641\u062f();
                    string = "\u06e6\u06e3\u06e8";
                    continue block21;
                }
                case 1751500: {
                    object = Tingshu275.\u064a\ufeab\u0641\u062f();
                    string4 = \ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644((short[])object, 457, 14, 1886);
                    string = "\u06e0\u06e1\u06e4";
                    continue block21;
                }
                case 1747715: {
                    object = Tingshu275.\u064a\ufeab\u0641\u062f();
                    string5 = \ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf((short[])object, 471, 8, 1938);
                    string = "\u06e7\u06e8\u06e2";
                    continue block21;
                }
                case 1748739: {
                    object = Tingshu275.\u064a\ufeab\u0641\u062f();
                    string5 = \ufeb9\ufec9\u0648\u062d.\ufee9\u0637\ufef1\u0644((short[])object, 492, 50, 1955);
                    string = "\u06e5\u06e0";
                    continue block21;
                }
                case 1746720: {
                    string3 = \ufe8e\ufec1\u0641\u0644.\ufec5\ufeab\u0646\u064a(object2);
                    stringBuilder = new StringBuilder();
                    string = "\u06e2\u06e4";
                    continue block21;
                }
                case 1754657: {
                    \ufe8e\ufeb9\u0647\u0642.\ufef1\ufeab\ufebd\u0640(stringBuilder, string6, string4, string3, string5);
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, string2);
                    string = "\u06e7\u06e1\u06e1";
                    continue block21;
                }
                case 56475: {
                    \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, string3, string5);
                    \ufe95\u0627\ufe8e\u0644.\u0630\ufed5\u0647\ufee1(tq, hashMap);
                    string = "\u06e1\u06e8\u06e0";
                    continue block21;
                }
                case 1754439: {
                    object2 = \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(stringBuilder);
                    map = Tingshu275.\u062f\ufedd\ufea5\ufea1((Object)this);
                    string = "\u06e2\u06e8\u06e4";
                    continue block21;
                }
                case 1752548: {
                    object = Tingshu275.\u064a\ufeab\u0641\u062f();
                    object2 = \u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b((short[])object, 404, 6, 3262);
                    string = "\u06e6\u06e7\u06df";
                    continue block21;
                }
                case 1755429: 
            }
            tq = new Tq();
            object = Tingshu275.\u064a\ufeab\u0641\u062f();
            string = "\u06e2\u06e6\u06e3";
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public String searchContent(String string, String arrayList) {
        arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, Tingshu275.\u0632\ufef1\u0636\ufedd((Object)this));
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, \ufeb9\u0627\ufea5\ufe9d.\u062a\ufef1\u062d\u0641(Tingshu275.\u064a\ufeab\u0641\u062f(), 542, 35, 1328));
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, \u062b\u064a\ufecd\u0642.\ufec9\ufead\ufea9\ufe8f(string));
        stringBuilder = \ufee9\ufee1\u0627\u0641.\ufead\ufeb1\u0627\u0641(\ufeaf\ufea5\ufeab\u062e.\ufe99\ufea9\u0647\u0641(new JSONObject(\ufebd\u0640\u0648\u062b.\u0646\ufed5\u0630\ufec9(\ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(stringBuilder), Tingshu275.\u062f\ufedd\ufea5\ufea1((Object)this))), \ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(Tingshu275.\u064a\ufeab\u0641\u062f(), 577, 4, 2635)), \ufeaf\u062b\ufed5\ufec1.\u062e\ufeab\ufee9\u0628(Tingshu275.\u064a\ufeab\u0641\u062f(), 581, 8, 2875));
        int n = 0;
        block10: while (true) {
            int n2 = \u0644\ufe8f\u0628\u062a.\ufee9\ufe8e\ufe99\u0631(stringBuilder);
            int n3 = 1616;
            block11: while (true) {
                switch (n3 ^= 0x661) {
                    default: {
                        continue block11;
                    }
                    case 49: {
                        if (n < n2) {
                            n3 = 1709;
                            continue block11;
                        }
                    }
                    case 14: {
                        n3 = 1678;
                        continue block11;
                    }
                    case 204: {
                        string = \ufeaf\u0633\u0648\ufee9.\u062e\u062f\u0644\u0645(stringBuilder, n);
                        String string2 = \ufeab\u0632\u062f\u0640.\ufeab\u0632\ufec5\u0645(string, \ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(Tingshu275.\u064a\ufeab\u0641\u062f(), 589, 2, 2688));
                        String string3 = \ufeab\u0632\u062f\u0640.\ufeab\u0632\ufec5\u0645(string, \ufe95\u0627\ufe8e\u0644.\u062d\u0636\ufea9\u0640(Tingshu275.\u064a\ufeab\u0641\u062f(), 591, 9, 2320));
                        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList, new Ef(string2, \ufeab\u0632\u062f\u0640.\ufeab\u0632\ufec5\u0645(string, \u062d\u062e\ufe8e\u0645.\u062d\ufeab\u0642\u0647(Tingshu275.\u064a\ufeab\u0641\u062f(), 600, 9, 3222)), string3, \ufeab\u0632\u062f\u0640.\ufeab\u0632\ufec5\u0645(string, \ufeb5\ufe8e\ufead\u0632.\ufe8f\ufef1\u0648\ufe95(Tingshu275.\u064a\ufeab\u0641\u062f(), 609, 10, 1433))));
                        n2 = n + 1;
                        n3 = 1740;
                        block12: while (true) {
                            n = n2;
                            switch (n3 ^= 0x6DD) {
                                case 54: {
                                    continue block10;
                                }
                                default: {
                                    continue block12;
                                }
                                case 17: 
                            }
                            n3 = 1771;
                        }
                    }
                    case 239: 
                }
                break;
            }
            break;
        }
        return \ufe99\u062e\u0642\u0644.\ufea1\u062e\ufecd\ufeab(arrayList);
    }

    public String searchContent(String string, boolean bl) {
        String string2 = "\u06e8\u06e0\u06e4";
        String string3 = null;
        short[] sArray = null;
        String string4 = null;
        block5: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string2)) {
                default: {
                    return string4;
                }
                case 1753416: {
                    string3 = \u0633\u064a\u0644\u0637.\ufec9\ufeed\ufeb5\u0640(sArray, 619, 1, 1243);
                    string2 = "\u06e2\u06e1\u06e4";
                    continue block5;
                }
                case 1755372: {
                    sArray = Tingshu275.\u064a\ufeab\u0641\u062f();
                    string2 = "\u06e6\u06df\u06e1";
                    continue block5;
                }
                case 1749637: 
            }
            string4 = \u0635\u0631\u0645\u0628.\u0635\u0643\u0641\u0628((Object)this, string, string3);
            string2 = "\u06e0\u06e6\u06e1";
        }
    }

    public String searchContent(String string, boolean bl, String string2) {
        return \u0635\u0631\u0645\u0628.\u0635\u0643\u0641\u0628((Object)this, string, string2);
    }

    private static long[] $d2j$hex$0d3ecc9e$decode_J(String src) {
        byte[] d = Tingshu275.$d2j$hex$0d3ecc9e$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$0d3ecc9e$decode_I(String src) {
        byte[] d = Tingshu275.$d2j$hex$0d3ecc9e$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$0d3ecc9e$decode_S(String src) {
        byte[] d = Tingshu275.$d2j$hex$0d3ecc9e$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$0d3ecc9e$decode_B(String src) {
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

