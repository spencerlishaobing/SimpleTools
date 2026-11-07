/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.github.catvod.crawler.Spider
 *  com.google.gson.Gson
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  okhttp3.Request
 *  okhttp3.Request$Builder
 *  okhttp3.Response
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.content.Context;
import com.github.catvod.crawler.Spider;
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
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeaf\u062b\ufed5\ufec1;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\ufec9\u0648\u062d;
import com.github.catvod.parser.\ufec1\u0636\u062d\u0638;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.merge.Bo;
import com.github.catvod.spider.merge.Jz;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.lm;
import com.github.catvod.spider.merge.pq;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0641\u0631\ufeed\u0643;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufebd\u0640\u0648\u062b;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.merge.\ufee9\ufee1\u0627\u0641;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\u0636\u0634\ufec1\u0631;
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
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class JPJ
extends Spider {
    private static final short[] short = JPJ.$d2j$hex$7f03e36e$decode_S("fc0ae00ae00ae40ae70aae0abb0abb0af10ae20aa10aa70aa10aa20aba0aad0aa30aa40aec0ae30aba0af70afb0af90ad607f007e607f107ae07c207e407e607ed07f7077304510444045704520452045f0411040b0410040e041e0416047204570450044b04460405041e047f0450045a044c04510457045a041e04070405041e0468040c040f04070408047f041e047c044b04570452045a0411046e046f040d047f0410040f0407040e0409040e040b0410040e0406040c040f040f0406040e04070405041e044904480417041e047f044e044e0452045b0469045b045c04750457044a0411040b040d04090410040d0408041e041604750476046a047304720412041e045204570455045b041e0479045b045d045504510417041e0468045b044c044d0457045104500411040a0410040e041e047d0456044c04510453045b04110407040f0410040e0410040a040a0409040c0410040f040f040a041e04730451045c04570452045b041e046d045f0458045f044c04570411040b040d04090410040d040804050449045b045c045f0450045504110456040b0458045f045d045b04050449045b045c045f045004550411040f0410040e04050450045b044a046a0447044e045b04040470047b046a04690471046c0475046104690477047804770405045f044e044e0468045b044c044d0457045104500404040a040f04080405044e045f045d0455045f0459045b0470045f0453045b0404045d0451045304100454044e040d041004460459040d04e304d404d704d404c304d404c3044e061a06110606061c0682060b090e09af06af06670a670a670a740b670b700b740baa0202031e031a030903fe04e5042a092f093b093e092b093e098d09c309d209cb098d09c109d009d709cf09c0098d09ce09cb09d109d6099d09c409c109c309d609c709fd09d209cb09c6099f098709d1098409c309d009c709c3099f098709d1098409db09c709c309d0099f098709d1098409d609db09d209c7099f0992098409d109cd09d009d6099f098709d1098409d209c309c509c7099f098709d1098409c109c309d609c709c509cd09d009db09fd09cb09c6099f09060948095909400906094d0950097d0948094e090609450940095a095d0916094a0948095d094c094e0946095b095009760940094d0914090c095a090f09590948094e094c0914090c095a09c00a8e0a9f0a860ac00a990a860a8b0a8a0a800ac00a8b0a8a0a9b0a8e0a860a830a990add0ad00a860a8b0ad20a5f4a7f710963be81130516031b02920c7f057a05e30ae30a5b7d1f57597daa810b5a3851bb6cbe793885db79245836757204590448045a045004550444046c086a088d05c305d205cb058d05d105ce05cb05c605c7058d05ce05cb05d105d6059d05d205cd05d105fd05cb05c6059f059a059a0598098409840980098309ca09df09df0994099e098309de0991099c09990994099e098309de0993099f099d09df098209950983099f099c0986099509cf099e0991099d099509cd098309870982099409830996099509990985099a099f09c209c50983098709de0993099309d6098409890980099509cd09a409a809a409f601d901c401c001d201c5019f049a048f049a04f509540b280934093409300933097a096f096f09260921092e097109720973096e099c0cd20cc30cda0c9c0cc50c810c9c0cc00cd60cc70cc70cda0cdd0cd40cc00c9c0cc10cd60cc00cdc0cc60cc10cd00cd60cf70cdc0cde0cd20cda0cdd0cf00cdc0cdd0cd50cda0cd40c660b620b680b4b0b600b620b6e0b660b610bcd05d105d105d505d6059f058a058a05300c2c0c2c0c280c620c770c770c1f0c410c070c4a0c480b060b170b0e0b480b110b550b480b140b020b060b150b040b0f0b480b110b0e0b030b020b080b310b550b580b0c0b020b1e0b5a0b420b140b410b040b060b130b020b000b080b150b1e0b380b0e0b030b5a0b5f0b5f0b410b170b060b000b020b5a0b420b140b410b170b060b000b020b340b0e0b1d0b020b5a0b550b570bba01");
    private String SN;
    private String yq = \u0631\u0640\ufec1\ufee9.\ufe95\ufeed\u062c\ufec1(JPJ.\ufe95\u062d\ufee9\ufeaf(), 0, 24, 2708);

    /*
     * Enabled aggressive block sorting
     */
    public JPJ() {
        int n = \ufed9\ufe9d\ufeed\ufeb5.\ufedd\ufeaf\ufec9\u0646();
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
                    String string = \ufe9d\ufeab\u062e\u0640.\ufea1\ufecd\u0646\u0648("tdWvrg9vSwuHf");
                    System.out.println(string);
                    return;
                }
                case 239: 
            }
            break;
        }
    }

    private Map<String, String> yq() {
        String string = "\u06e0\u06e8\u06e5";
        HashMap hashMap = null;
        String string2 = null;
        String string3 = null;
        short[] sArray = null;
        block12: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    sArray = JPJ.\ufe95\u062d\ufee9\ufeaf();
                    string = "\u06e6\u06e7\u06df";
                    continue block12;
                }
                case 1753662: {
                    string2 = \u0635\u0631\u0645\u0628.\u0646\u0627\u062a\u062d(sArray, 24, 10, 1923);
                    string = "\u06e4\u06e6\u06e5";
                    continue block12;
                }
                case 1750783: {
                    string3 = \ufebd\u0640\u0648\u062b.\ufea5\u0639\u0631\ufe95(sArray, 34, 247, 1086);
                    string = "\u06e5\u06e8\u06e5";
                    continue block12;
                }
                case 1747933: {
                    hashMap = new HashMap();
                    string = "\u06e8\u06e7\u06e8";
                    continue block12;
                }
                case 1752738: {
                    \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, string2, string3);
                    string = "\u06e2\u06e3\u06e6";
                    continue block12;
                }
                case 1751715: {
                    sArray = JPJ.\ufe95\u062d\ufee9\ufeaf();
                    string = "\u06e3\u06e7\u06e3";
                    continue block12;
                }
                case 1747718: {
                    sArray = JPJ.\ufe95\u062d\ufee9\ufeaf();
                    string = "\u06e4\u06e5\u06e5";
                    continue block12;
                }
                case 1751684: {
                    string3 = \u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(sArray, 281, 7, 1201);
                    string = "\u06e1\u06e3\u06e7";
                    continue block12;
                }
                case 1749701: {
                    string2 = JPJ.\u0644\u0636\ufed9\ufe99((Object)this);
                    string = "\u06e0\u06e1\u06e7";
                    continue block12;
                }
                case 1748741: {
                    \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, string3, string2);
                    string = "\u06e3\u06e1\u06e1";
                    continue block12;
                }
                case 1750595: 
            }
            break;
        }
        return hashMap;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Request \u062a\u0646\ufec1\ufedd(Object object) {
        int n = \u0630\ufebd\u0634\ufec9.\u062f\ufe8f\u0630\ufed5();
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
    public static Request.Builder \u062b\u0633\u0640\u0647(Object object) {
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
                    return ((Request.Builder)object).head();
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
    public static JsonArray \u062c\ufec9\ufeb5\u0640(Object object, Object object2) {
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
                    return ((JsonObject)object).getAsJsonArray((String)object2);
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
    public static Request.Builder \u062e\u062f\u0648\u062c(Object object, Object object2) {
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
    public static JsonElement \u0633\u0630\u0637\u0631(Object object, Object object2) {
        int n = \u0638\ufead\u062e\ufee1.\ufeab\u062a\u062d\u063a();
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
                    return ((JsonObject)object).get((String)object2);
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
    public static JsonElement \u0636\ufecd\ufeaf\u062c(Object object, int n) {
        int n2 = \ufec1\u0636\u062d\u0638.\u0643\u0638\u062a\ufec5();
        int n3 = 1616;
        block10: while (true) {
            switch (n3 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n2 < 0) {
                        n3 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n3 = 1678;
                    continue block10;
                }
                case 204: {
                    return ((JsonArray)object).get(n);
                }
                case 239: 
            }
            break;
        }
        Object var4_4 = null;
        n = 1740;
        block11: while (true) {
            object = var4_4;
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
    public static String \u0639\ufe8e\u0641\u0644(Object object) {
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
                    return ((JsonElement)object).getAsString();
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
    public static int \u0640\u0633\u062d\ufeb1(Object object) {
        int n = \u0641\u0631\ufeed\u0643.\ufeb5\ufe8f\u0630\u0647();
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
    public static JsonObject \u0640\ufeed\ufeb1\u0645(Object object, Object object2) {
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
                    return ((JsonObject)object).getAsJsonObject((String)object2);
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
    public static String \u0644\u0636\ufed9\ufe99(Object object) {
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
                    return ((JPJ)((Object)object)).yq;
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
    public static JsonObject \u0648\ufec9\ufef1\u062a(Object object) {
        int n = \u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a();
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
                    return ((JsonElement)object).getAsJsonObject();
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
    public static short[] \ufe95\u062d\ufee9\ufeaf() {
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
    public static Map \ufe95\ufef1\ufe9d\ufebd(Object map) {
        int n = \ufee9\ufee1\u0627\u0641.\u0641\u0638\ufeb1\ufeb5();
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
                    return ((JPJ)((Object)map)).yq();
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
    public static String \ufe9d\ufea5\u0634\ufeaf(Object object) {
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
                    return ((JPJ)((Object)object)).SN;
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
    public static Object \ufedd\u0646\ufeaf\ufe8e(Object object, Object object2, Object object3) {
        int n = \ufee1\u0639\u063a\u0645.\ufee1\u0628\u062f\u0632();
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
    public static Response \ufef1\u0645\u0639\ufead(Object object) {
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
                    return Bo.i((Request)object);
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
    public String categoryContent(String var1_1, String var2_2, boolean var3_3, HashMap<String, String> var4_4) {
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
    public String homeContent(boolean bl) {
        ArrayList arrayList = new ArrayList();
        List list = \u0645\u0641\u0630\u062d.\ufe9d\u0636\u064a\u0648(new String[]{\ufecd\u0642\u062e\ufe9d.\u0637\ufee9\u0635\u0630(JPJ.\ufe95\u062d\ufee9\ufeaf(), 463, 1, 1314), \ufeaf\u062b\ufed5\ufec1.\u062e\ufeab\ufee9\u0628(JPJ.\ufe95\u062d\ufee9\ufeaf(), 464, 1, 804), \u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(JPJ.\ufe95\u062d\ufee9\ufeaf(), 465, 1, 552), \ufe8e\ufeb9\u0647\u0642.\ufee1\u062f\ufedd\u0643(JPJ.\ufe95\u062d\ufee9\ufeaf(), 466, 1, 3238), \ufe95\u0627\ufe8e\u0644.\u062d\u0636\ufea9\u0640(JPJ.\ufe95\u062d\ufee9\ufeaf(), 467, 2, 1354), \ufebd\u0640\u0648\u062b.\ufea5\u0639\u0631\ufe95(JPJ.\ufe95\u062d\ufee9\ufeaf(), 469, 2, 2778)});
        List list2 = \u0645\u0641\u0630\u062d.\ufe9d\u0636\u064a\u0648(new String[]{\u0641\ufeb5\ufeb1\ufee1.\u0639\u0630\ufeaf\ufe95(JPJ.\ufe95\u062d\ufee9\ufeaf(), 471, 2, 2158), \ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(JPJ.\ufe95\u062d\ufee9\ufeaf(), 473, 3, 2156), \ufeaf\u062b\ufed5\ufec1.\u062e\ufeab\ufee9\u0628(JPJ.\ufe95\u062d\ufee9\ufeaf(), 476, 2, 912), \u062d\u062e\ufe8e\u0645.\u062d\ufeab\u0642\u0647(JPJ.\ufe95\u062d\ufee9\ufeaf(), 478, 2, 1858), \ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(JPJ.\ufe95\u062d\ufee9\ufeaf(), 480, 3, 1905), \ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(JPJ.\ufe95\u062d\ufee9\ufeaf(), 483, 7, 1084)});
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
        return \u062a\u0635\ufeb1\u0642.\ufed5\u0630\u0647\ufec9(arrayList, new JSONObject(\ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(JPJ.\ufe95\u062d\ufee9\ufeaf(), 490, 2, 2071)));
    }

    /*
     * Enabled aggressive block sorting
     */
    public String homeVideoContent() {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = \ufec1\u0636\u062d\u0638.\u062a\ufee1\ufe8e\ufecd(\ufe8e\u0627\ufecd\u062a.\u0640\u0647\u062c\u062d(\ufea9\ufec5\u0647\u0641.\ufec9\u0630\u063a\ufea1(\ufebd\u0640\u0648\u062b.\u0646\ufed5\u0630\ufec9(\ufec1\u0636\u062d\u0638.\u062f\u0627\u062b\u0628(new StringBuilder(), JPJ.\u0644\u0636\ufed9\ufe99((Object)this), \ufe99\u062c\u0643\ufec1.\u0648\u0634\u063a\ufeb1(JPJ.\ufe95\u062d\ufee9\ufeaf(), 492, 25, 1442)), JPJ.\ufe95\ufef1\ufe9d\ufebd((Object)this)))));
        block10: while (true) {
            boolean bl = \ufe8e\u0627\ufecd\u062a.\u062f\u0638\ufe8e\ufe99(iterator);
            int n = 1616;
            block11: while (true) {
                switch (n ^= 0x661) {
                    default: {
                        continue block11;
                    }
                    case 49: {
                        if (bl) {
                            n = 1709;
                            continue block11;
                        }
                    }
                    case 14: {
                        n = 1678;
                        continue block11;
                    }
                    case 204: {
                        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList, \u0641\ufeb5\ufeb1\ufee1.\ufedd\u0631\ufea9\ufec5((lm)\ufea1\u0645\u062b\u0634.\ufe95\ufeaf\ufeb9\ufea1(iterator), JPJ.\ufe9d\ufea5\u0634\ufeaf((Object)this)));
                        n = 1740;
                        block12: while (true) {
                            switch (n ^= 0x6DD) {
                                case 54: {
                                    continue block10;
                                }
                                default: {
                                    continue block12;
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
        return \ufe99\u062e\u0642\u0644.\ufea1\u062e\ufecd\ufeab(arrayList);
    }

    /*
     * Recovered potentially malformed switches.  Disable with '--allowmalformedswitch false'
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void init(Context var1_1, String var2_2) {
        var2_2 = JPJ.\u0648\ufec9\ufef1\u062a(JPJ.\u0636\ufecd\ufeaf\u062c(JPJ.\u062c\ufec9\ufeb5\u0640((JsonObject)JPJ.\ufedd\u0646\ufeaf\ufe8e(new Gson(), \ufebd\u0640\u0648\u062b.\u0646\ufed5\u0630\ufec9(\ufeaf\u0633\u0648\ufee9.\u062e\u0645\u0644\u0648(JPJ.\ufe95\u062d\ufee9\ufeaf(), 517, 63, 2544), null), JsonObject.class), \u0636\u0634\ufec1\u0631.\u062c\u063a\u0643\u0627(JPJ.\ufe95\u062d\ufee9\ufeaf(), 580, 6, 439)), 0));
        var1_1 /* !! */  = \ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(JPJ.\ufe95\u062d\ufee9\ufeaf(), 586, 4, 1275);
        var2_2 = JPJ.\u0639\ufe8e\u0641\u0644(JPJ.\u0633\u0630\u0637\u0631(var2_2, var1_1 /* !! */ ));
        var10_3 = \ufea5\u062d\ufebd\u0633.\ufea5\ufeb1\u0643\ufe8f(JPJ.\ufe95\u062d\ufee9\ufeaf(), 590, 1, 2519);
        var9_4 = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
        var10_3 = \ufea5\u062d\ufebd\u0633.\u0645\ufec1\ufed5\u062c(var2_2, var10_3, var9_4);
        var2_2 = \ufeaf\u062b\ufed5\ufec1.\u062e\ufeab\ufee9\u0628(JPJ.\ufe95\u062d\ufee9\ufeaf(), 591, 1, 2936);
        var10_3 = \ufeb5\ufe8e\ufead\u0632.\u0640\ufec5\ufedd\u0634(var10_3, var2_2);
        var6_5 = var10_3.length;
        var4_6 = 0;
        block98: while (true) {
            block132: {
                block134: {
                    block133: {
                        block131: {
                            var3_7 = 1616;
                            block99: while (true) {
                                switch (var3_7 ^= 1633) {
                                    default: {
                                        continue block99;
                                    }
                                    case 49: {
                                        if (var4_6 < var6_5) {
                                            var3_7 = 1709;
                                            continue block99;
                                        }
                                    }
                                    case 14: {
                                        var3_7 = 1678;
                                        continue block99;
                                    }
                                    case 204: {
                                        var11_10 /* !! */  = var10_3[var4_6];
                                        this.yq = \ufe9d\ufeab\u062e\u0640.\ufec1\ufebd\u0643\u0641(\ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(JPJ.\ufe95\u062d\ufee9\ufeaf(), 592, 15, 2368), var11_10 /* !! */ );
                                        var11_10 /* !! */  = new StringBuilder();
                                        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var11_10 /* !! */ , JPJ.\u0644\u0636\ufed9\ufe99((Object)this));
                                        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var11_10 /* !! */ , \u0635\u0631\u0645\u0628.\u0646\u0627\u062a\u062d(JPJ.\ufe95\u062d\ufee9\ufeaf(), 607, 37, 3251));
                                        var11_10 /* !! */  = \ufebd\u0640\u0648\u062b.\u0646\ufed5\u0630\ufec9(\ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(var11_10 /* !! */ ), null);
                                        var8_9 = \ufeed\ufebd\u0635\ufedd.\u0637\ufe8e\ufee1\ufebd(var11_10 /* !! */ );
                                        var3_7 = 1740;
                                        block100: while (true) {
                                            switch (var3_7 ^= 1757) {
                                                default: {
                                                    continue block100;
                                                }
                                                case 17: {
                                                    if (!var8_9) {
                                                        var3_7 = 1833;
                                                        continue block100;
                                                    }
                                                }
                                                case 54: {
                                                    var3_7 = 1802;
                                                    continue block100;
                                                }
                                                case 500: {
                                                    var10_3 = \ufeb5\ufe8e\ufead\u0632.\u0640\ufec5\ufedd\u0634(JPJ.\u0639\ufe8e\u0641\u0644(JPJ.\u0633\u0630\u0637\u0631(JPJ.\u0640\ufeed\ufeb1\u0645((JsonObject)\ufe99\u062e\u0642\u0644.\u0644\u0645\ufeaf\u0627(var11_10 /* !! */ , JsonObject.class), var1_1 /* !! */ ), \ufe8e\ufeb9\u0647\u0642.\ufee1\u062f\ufedd\u0643(JPJ.\ufe95\u062d\ufee9\ufeaf(), 644, 9, 2831))), var2_2);
                                                    var7_11 = var10_3.length;
                                                    var4_6 = 0;
                                                    var1_1 /* !! */  = null;
lbl51:
                                                    // 2 sources

                                                    while (true) {
                                                        var3_7 = 1864;
                                                        block102: while (true) {
                                                            switch (var3_7 ^= 1881) {
                                                                default: {
                                                                    continue block102;
                                                                }
                                                                case 17: {
                                                                    if (var4_6 < var7_11) {
                                                                        var3_7 = 48736;
                                                                        continue block102;
                                                                    }
                                                                }
                                                                case 47483: {
                                                                    var3_7 = 48705;
                                                                    continue block102;
                                                                }
                                                                case 47417: {
                                                                    var2_2 = \ufe99\u062e\u0642\u0644.\u062d\ufead\u0644\ufec5(var10_3[var4_6]);
                                                                    var8_9 = \ufeed\ufebd\u0635\ufedd.\u0637\ufe8e\ufee1\ufebd(var2_2);
                                                                    var3_7 = 48767;
                                                                    block103: while (true) {
                                                                        switch (var3_7 ^= 48784) {
                                                                            default: {
                                                                                continue block103;
                                                                            }
                                                                            case 239: {
                                                                                if (var8_9) {
                                                                                    var3_7 = 48860;
                                                                                    continue block103;
                                                                                }
                                                                            }
                                                                            case 14: {
                                                                                var3_7 = 48829;
                                                                                continue block103;
                                                                            }
                                                                            case 76: {
                                                                                var3_7 = 48891;
                                                                                block104: while (true) {
                                                                                    var2_2 = var1_1 /* !! */ ;
                                                                                    switch (var3_7 ^= 48908) {
                                                                                        default: {
                                                                                            continue block104;
                                                                                        }
                                                                                        case 22: {
                                                                                            break block99;
                                                                                        }
                                                                                        case 503: 
                                                                                    }
                                                                                    var3_7 = 48922;
                                                                                }
                                                                            }
                                                                            case 45: 
                                                                        }
                                                                        break;
                                                                    }
                                                                    var3_7 = 49666;
                                                                    block105: while (true) {
                                                                        switch (var3_7 ^= 49683) {
                                                                            default: {
                                                                                continue block105;
                                                                            }
                                                                            case 17: {
                                                                                if (var1_1 /* !! */  == null) {
                                                                                    var3_7 = 49759;
                                                                                    continue block105;
                                                                                }
                                                                            }
                                                                            case 50: {
                                                                                var3_7 = 49728;
                                                                                continue block105;
                                                                            }
                                                                            case 76: {
                                                                                var1_1 /* !! */  = var2_2;
                                                                                break block105;
                                                                            }
                                                                            case 83: 
                                                                        }
                                                                        break;
                                                                    }
                                                                    var12_12 = \u0645\u0641\u0630\u062d.\u0642\u062a\u0630\ufebd(JPJ.\ufe95\u062d\ufee9\ufeaf(), 653, 8, 1445);
                                                                    var11_10 /* !! */  = \ufea9\u0643\u062d\u063a.\ufea1\u0633\ufe8e\u0627(JPJ.\ufe95\u062d\ufee9\ufeaf(), 661, 7, 3160);
                                                                    var5_8 = 0;
lbl111:
                                                                    // 2 sources

                                                                    while (true) {
                                                                        var3_7 = 49790;
                                                                        block107: while (true) {
                                                                            switch (var3_7 ^= 49807) {
                                                                                default: {
                                                                                    continue block107;
                                                                                }
                                                                                case 241: {
                                                                                    if (var5_8 < 2) {
                                                                                        var3_7 = 49883;
                                                                                        continue block107;
                                                                                    }
                                                                                }
                                                                                case 18: {
                                                                                    var3_7 = 49852;
                                                                                    continue block107;
                                                                                }
                                                                                case 84: {
                                                                                    var13_13 = (new String[]{var12_12, var11_10 /* !! */ })[var5_8];
                                                                                    var15_16 = new Request.Builder();
                                                                                    var14_15 = new StringBuilder();
                                                                                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var14_15, var13_13);
                                                                                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var14_15, var2_2);
                                                                                    var6_5 = JPJ.\u0640\u0633\u062d\ufeb1(JPJ.\ufef1\u0645\u0639\ufead(JPJ.\u062a\u0646\ufec1\ufedd(JPJ.\u062b\u0633\u0640\u0647(JPJ.\u062e\u062f\u0648\u062c(var15_16, \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(var14_15))))));
                                                                                    var3_7 = 49914;
                                                                                    break block131;
                                                                                }
                                                                                case 51: {
                                                                                    var5_8 = 0;
                                                                                    break block107;
                                                                                }
                                                                            }
                                                                            break;
                                                                        }
                                                                        ** GOTO lbl-1000
                                                                        break;
                                                                    }
                                                                }
                                                                case 47384: {
                                                                    var3_7 = 52735;
                                                                    block108: while (true) {
                                                                        switch (var3_7 ^= 52752) {
                                                                            default: {
                                                                                continue block108;
                                                                            }
                                                                            case 1007: {
                                                                                if (var1_1 /* !! */  == null) {
                                                                                    var3_7 = 53479;
                                                                                    continue block108;
                                                                                }
                                                                            }
                                                                            case 14: {
                                                                                var3_7 = 52797;
                                                                                continue block108;
                                                                            }
                                                                            case 7927: {
                                                                                var3_7 = 53510;
                                                                                block109: while (true) {
                                                                                    switch (var3_7 ^= 53527) {
                                                                                        default: {
                                                                                            continue block109;
                                                                                        }
                                                                                        case 17: {
                                                                                            var3_7 = 53541;
                                                                                            continue block109;
                                                                                        }
                                                                                        case 50: 
                                                                                    }
                                                                                    break;
                                                                                }
                                                                                var1_1 /* !! */  = var9_4;
                                                                                break block102;
                                                                            }
                                                                            case 45: 
                                                                        }
                                                                        break;
                                                                    }
                                                                    break block102;
                                                                }
                                                            }
                                                            break;
                                                        }
                                                        ** GOTO lbl269
                                                        break;
                                                    }
                                                }
                                                case 471: {
                                                    var5_8 = var4_6 + 1;
                                                    var3_7 = 53758;
                                                    break block100;
                                                }
                                            }
                                            break;
                                        }
                                        break block132;
                                        catch (IOException var13_14) {
                                            var3_7 = 54533;
                                            while (true) {
                                                switch (var3_7 ^= 54550) {
                                                    case 50: {
                                                        ** GOTO lbl-1000
                                                    }
                                                    default: {
                                                        break;
                                                    }
                                                    case 19: {
                                                        var3_7 = 54564;
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    case 239: {
                                        return;
                                    }
                                }
                                break;
                            }
lbl187:
                            // 2 sources

                            while (true) {
                                var3_7 = 52611;
                                block112: while (true) {
                                    switch (var3_7 ^= 52628) {
                                        default: {
                                            continue block112;
                                        }
                                        case 23: {
                                            var3_7 = 52642;
                                            continue block112;
                                        }
                                        case 54: 
                                    }
                                    break;
                                }
                                ++var4_6;
                                var1_1 /* !! */  = var2_2;
                                ** continue;
                                break;
                            }
                        }
                        block113: while (true) {
                            switch (var3_7 ^= 49931) {
                                default: {
                                    continue block113;
                                }
                                case 497: {
                                    if (var6_5 >= 200) {
                                        var3_7 = 50658;
                                        continue block113;
                                    }
                                }
                                case 1711: {
                                    var3_7 = 50627;
                                    continue block113;
                                }
                                case 1769: {
                                    var3_7 = 50689;
                                    break block113;
                                }
                                case 1736: {
                                    ** GOTO lbl-1000
                                }
                            }
                            break;
                        }
                        block114: while (true) {
                            switch (var3_7 ^= 50706) {
                                default: {
                                    continue block114;
                                }
                                case 19: {
                                    if (var6_5 < 405) {
                                        var3_7 = 50782;
                                        continue block114;
                                    }
                                }
                                case 50: {
                                    var3_7 = 50751;
                                    continue block114;
                                }
                                case 76: {
                                    var6_5 = 1;
                                    var3_7 = 50813;
                                    break block114;
                                }
                                case 45: lbl-1000:
                                // 3 sources

                                {
                                    var6_5 = var5_8 + 1;
                                    var3_7 = 51588;
                                    break block133;
                                }
                            }
                            break;
                        }
                        block115: while (true) {
                            var5_8 = var6_5;
                            switch (var3_7 ^= 50830) {
                                default: {
                                    continue block115;
                                }
                                case 18: lbl-1000:
                                // 2 sources

                                {
                                    var3_7 = 51712;
                                    break block115;
                                }
                                case 243: {
                                    var3_7 = 50844;
                                    continue block115;
                                }
                            }
                            break;
                        }
                        block116: while (true) {
                            switch (var3_7 ^= 51729) {
                                default: {
                                    continue block116;
                                }
                                case 17: {
                                    if (var5_8 != 0) {
                                        var3_7 = 51805;
                                        continue block116;
                                    }
                                }
                                case 14: {
                                    var3_7 = 51774;
                                    continue block116;
                                }
                                case 76: {
                                    var3_7 = 51836;
                                    block117: while (true) {
                                        var1_1 /* !! */  = var2_2;
                                        switch (var3_7 ^= 51853) {
                                            default: {
                                                continue block117;
                                            }
                                            case 241: {
                                                var3_7 = 52518;
                                                continue block117;
                                            }
                                            case 1963: 
                                        }
                                        break;
                                    }
lbl269:
                                    // 2 sources

                                    this.SN = var1_1 /* !! */ ;
                                    var3_7 = 53634;
                                    break block134;
                                }
                                case 47: {
                                    var2_2 = var1_1 /* !! */ ;
                                    break block116;
                                }
                            }
                            break;
                        }
                        ** continue;
                    }
                    block118: while (true) {
                        var5_8 = var6_5;
                        switch (var3_7 ^= 51605) {
                            case 54: {
                                ** continue;
                            }
                            default: {
                                continue block118;
                            }
                            case 17: 
                        }
                        var3_7 = 51619;
                    }
                }
                block119: while (true) {
                    switch (var3_7 ^= 53651) {
                        default: {
                            continue block119;
                        }
                        case 17: {
                            var3_7 = 53665;
                            continue block119;
                        }
                        case 50: 
                    }
                    break;
                }
                return;
            }
            block120: while (true) {
                var4_6 = var5_8;
                switch (var3_7 ^= 53775) {
                    case 1703: {
                        continue block98;
                    }
                    default: {
                        continue block120;
                    }
                    case 1009: 
                }
                var3_7 = 54440;
            }
            break;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public String playerContent(String object, String object2, List<String> list) {
        \u062b\ufec1\ufeb1\u062d.\ufef1\ufeb1\ufe95\u0628();
        \ufea9\ufec5\u0647\u0641.\u0636\u0633\u0645\ufe9d(true);
        boolean bl = \ufea9\ufec5\u0647\u0641.\ufef1\ufedd\u062c\ufea5(object2, \u062d\u062e\ufe8e\u0645.\u062d\ufeab\u0642\u0647(JPJ.\ufe95\u062d\ufee9\ufeaf(), 668, 4, 3186));
        int n = 1616;
        block6: while (true) {
            object = object2;
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
                    object = \ufeab\u062d\u063a\ufea9.\u0645\u0646\u0637\ufeb9(object2);
                    break block6;
                }
                case 239: 
            }
            break;
        }
        object2 = new Tq();
        \u0646\ufecd\ufead\u0647.\u0637\ufee9\u062c\ufe95(object2, object);
        \ufe95\u0627\ufe8e\u0644.\u0630\ufed5\u0647\ufee1(object2, JPJ.\ufe95\ufef1\ufe9d\ufebd((Object)this));
        return \ufeed\ufebd\u0635\ufedd.\ufec1\ufef1\u0632\ufe8e(object2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public String searchContent(String object, String object2) {
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, JPJ.\u0644\u0636\ufed9\ufe99((Object)this));
        object = \u062b\u064a\ufecd\u0642.\ufec9\ufead\ufea9\ufe8f(object);
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, \ufea1\u0645\u062b\u0634.\ufee9\ufee1\ufecd\ufedd(\ufecd\u0642\u062e\ufe9d.\u0637\ufee9\u0635\u0630(JPJ.\ufe95\u062d\ufee9\ufeaf(), 672, 64, 2919), new Object[]{object, object2}));
        object2 = \ufec1\u0636\u062d\u0638.\u062a\ufee1\ufe8e\ufecd(\u062f\ufead\ufeaf\u062d.\ufecd\u0645\ufe9d\ufeab((pq)\ufe99\u062e\u0642\u0644.\u0644\u0645\ufeaf\u0627(\ufebd\u0640\u0648\u062b.\u0646\ufed5\u0630\ufec9(\ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(stringBuilder), JPJ.\ufe95\ufef1\ufe9d\ufebd((Object)this)), pq.class)));
        block20: while (true) {
            boolean bl = \ufe8e\u0627\ufecd\u062a.\u062f\u0638\ufe8e\ufe99(object2);
            int n = 1616;
            block21: while (true) {
                switch (n ^= 0x661) {
                    default: {
                        continue block21;
                    }
                    case 49: {
                        if (bl) {
                            n = 1709;
                            continue block21;
                        }
                    }
                    case 14: {
                        n = 1678;
                        continue block21;
                    }
                    case 204: {
                        object = (pq)\ufea1\u0645\u062b\u0634.\ufe95\ufeaf\ufeb9\ufea1(object2);
                        bl = \u0635\u0631\u0645\u0628.\ufead\ufee9\u0643\u0632(\ufe9d\ufeab\u062e\u0640.\ufea1\ufe99\u0635\u0641(object));
                        n = 1740;
                        block22: while (true) {
                            switch (n ^= 0x6DD) {
                                default: {
                                    continue block22;
                                }
                                case 17: {
                                    if (bl) {
                                        n = 1833;
                                        continue block22;
                                    }
                                }
                                case 54: {
                                    n = 1802;
                                    continue block22;
                                }
                                case 500: {
                                    n = 1864;
                                    block23: while (true) {
                                        switch (n ^= 0x759) {
                                            case 47483: {
                                                continue block20;
                                            }
                                            default: {
                                                continue block23;
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
                        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList, \ufea9\ufe8f\u0647\ufead.\u0646\ufed5\u062a\ufe8f(object, JPJ.\ufe9d\ufea5\u0634\ufeaf((Object)this)));
                        n = 48767;
                        block24: while (true) {
                            switch (n ^= 0xBE90) {
                                case 14: {
                                    continue block20;
                                }
                                default: {
                                    continue block24;
                                }
                                case 239: 
                            }
                            n = 48798;
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
        String string2 = "\u06e6\u06e0\u06e3";
        String string3 = null;
        String string4 = null;
        short[] sArray = null;
        block5: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string2)) {
                default: {
                    string3 = \u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(sArray, 736, 1, 395);
                    string2 = "\u06df\u06e2\u06e8";
                    continue block5;
                }
                case 1753449: {
                    sArray = JPJ.\ufe95\u062d\ufee9\ufeaf();
                    string2 = "\u06e4\u06e1\u06e8";
                    continue block5;
                }
                case 1746789: {
                    string4 = \u0630\ufebd\u0634\ufec9.\u062f\ufee1\u0642\ufe8f((Object)this, string, string3);
                    string2 = "\u06e1\u06e8\u06e7";
                    continue block5;
                }
                case 1748896: 
            }
            break;
        }
        return string4;
    }

    public String searchContent(String string, boolean bl, String string2) {
        return \u0630\ufebd\u0634\ufec9.\u062f\ufee1\u0642\ufe8f((Object)this, string, string2);
    }

    private static long[] $d2j$hex$7f03e36e$decode_J(String src) {
        byte[] d = JPJ.$d2j$hex$7f03e36e$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$7f03e36e$decode_I(String src) {
        byte[] d = JPJ.$d2j$hex$7f03e36e$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$7f03e36e$decode_S(String src) {
        byte[] d = JPJ.$d2j$hex$7f03e36e$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$7f03e36e$decode_B(String src) {
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

