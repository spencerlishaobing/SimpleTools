/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  com.github.catvod.crawler.Spider
 *  com.github.catvod.crawler.SpiderDebug
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;
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
import com.github.catvod.parser.\ufec1\u0636\u062d\u0638;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.Jz;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.Zm;
import com.github.catvod.spider.merge.hN;
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
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class Nmyswv
extends Spider {
    public static JSONObject N;
    private static String SN;
    private static final short[] short;
    private String yq = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();

    static {
        short = Nmyswv.$d2j$hex$8fc3e890$decode_S("170c0b0c0b0c0f0c0c0c450c500c500c090c160c0f0c510c080c080c180c050c510c1c0c110c450c4a0c4d0c4f0c4f0c500cfb07dd07cb07dc078307ef07c907cb07c007da07510a5e0a530a410a410aba09a609a209b109be04ad04ba04be04f504ee04f104ec04e104e80bae0ba90ba30ba20bbf0be90bb70baf0bb70bf80baa0bfa0bb10ba80ba30bea0bab0bae0bb40bb30bea0bae0ba30bea0be20bb40bea0bb70ba00bea0be20bb40bea0ba80bb50ba30ba20bb50bea0bea0ba50bbe0bea0be20bb40bea0ba40bab0ba60bb40bb40bea0bea0bbe0ba20ba60bb50bea0be20bb40bea0bab0ba20bb30bb30ba20bb50bea0bea0ba60bb50ba20ba60bea0be20bb40bea0bab0ba60ba90ba00bea0be90baf0bb30baa0bab0b14080d084f0813080408120808081b0804083e080d0808081208150841085f0841080d080808600b210b3f0b210b650b680b770b210b3f0b210b680b6c0b660baf08ae08bf08d2027908630874087708850b980b850b9d0b940bff0bbe0ba00bbe0bfa0bf70be80bbe0ba00bbe0bed0bee0bff0bf00bb00bed0bdc0bf10bea0bea0bf10bf30bbe0ba00bbe0bed0bee0bff0bf00b020a1b0a100a2b0a1d0a100a200b390b320b090b380b370b3b0b330bab0ab20ab90a820aad0ab40abe0afb08e208e908d208ff08e808e008ec08ff08e608fe084a0c130c0c0c560c4b0c560c4e0c470c020c1c0c020c430c49045f0459044e0453045504540414044a045b045d045f04170452045e041a0404041a045b041a0404041a04530457045d04640265027402ad03be03b803a503af03a003a903e203a803a903b803ad03a503a003e103af03a303a203ec03f203ec03bc03a4fae201f401f201e501f801fe01ff01bf01e101f001f601f401bc01f301f501b101af01b101f501f801e701bf01f501f401e201f201ce01f801e501f401fc01ab01ff01e501f901bc01f201f901f801fd01f501b901a201b801b101af01b101f0014d0a5b0a5d0a4a0a570a510a500a100a4e0a5f0a590a5b0a130a5c0a5a0a1e0a000a1e0a5a0a570a480a100a5a0a5b0a4d0a5d0a610a570a4a0a5b0a530a040a500a4a0a560a130a5d0a560a570a520a5a0a160a0b0a170a1e0a000a1e0a5f0ab809cc09f409eb09a409ed09b90997038103870390038d038b038a03ca039403850383038103c90386038003c403da03c40380038d039203ca038003810397038703bb038d03900381038903de038a0390038c03c90387038c038d0388038003cc03d003cd03c403da03c4038503f803ee03e803ff03e203e403e503a503fb03ea03ec03ee03a603e903ef03ab03b503ab03ef03e203fd03a503ef03ee03f803e803d403e203ff03ee03e603b103e503ff03e303a603e803e303e203e703ef03a303b903a203ab03b503ab03ed03e403e503ff03e509e809f709af09ef09f409ec09cd09e809f209f50964077807620765077407720764073a070f0502051d05450502050f058f03930389038e039f039903b2039d0391039903d1031103080344035a03440308030d0344035a0344030503c30a130909091e091d09a609f809be09f309f772a78152083e043e043e041e07b577f15d9b080679f585545e54043275b489730aaf5a2c67960b920b007f8a5abe05b305ac05f405bd05b605b505b805bb05b6058a05b305b9059605b305a905ae0543085a081608080816085a085f08f305b205ac05b205f605fb05e405b205ac05b205fb05ff05f505c602c302d602c3028f02d102d002c1029d098c029602810282022507380725073d073407e102a002be02a002e402e902f602a002be02a002f302f002e102ee02ae02f302c202ef02f402f402ef02ed02a002be02a002f302f002e102ee02c102df02c1023f0a260a2d0a640a390a250a280a300a640a200a2d0a640a150a2d0a620a640a3a0a3b0a2a0a640a610a150a2d0a620a600a640a270a3c0a240a640a150a2d0a620afb0ce20ce90ca00cfd0ce10cec0cf40ca00ce40ce90ca00cd10ce90ca60ca00cfe0cff0cee0ca00cd10ce90ca60ca00ce30cf80ce00ca00ca50cd10ce90ca60ca40cc70bcb0bc90bf50bdf0bd80bc60b970b8d0b820b840b800b950b830b8d0b910b8b04f3048b04f3048b04f3040306fa0a820abf08fc08a208e408a9084b056c053a023a02650265023a021d0aa008ff08ff08ff08a008700549063606490636064906d40962012401230129012801350163013d0125013d017201200170013b012201290160013e0128012c013f012e0125016b013a0129017001cf01d601e101d301de018701de01db01ce01db01e501d601d301c901ce01e7019a0184019a01d601d3014b0b4f0b450bb901bc01a901bc01f001ae01af01be018f09bf0aa50ab20ab10a6607650774077b073b07660741077c076107bf07fe07e007fe07ba07b707a807fe07e007fe07ad07ae07bf07b007f007a807b107ba078107ac07bb07b307bf07ac07b507ad07");
        SN = \ufe95\u0627\ufe8e\u0644.\u062d\u0636\ufea9\u0640(Nmyswv.\u0634\u0635\u062e\u062a(), 0, 25, 3199);
    }

    /*
     * Enabled aggressive block sorting
     */
    public Nmyswv() {
        int n = \ufeab\u0632\u062f\u0640.\u062e\u0636\ufe8e\u063a();
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
                    n2 = Integer.parseInt(\u062d\u062e\ufe8e\u0645.\u0631\u063a\u0647\ufead("vH7U8ucn2qtla5"));
                    System.out.println(n2);
                    return;
                }
                case 239: 
            }
            break;
        }
    }

    private HashMap<String, String> SN() {
        String string = "\u06e8\u06e5\u06e6";
        String string2 = null;
        short[] sArray = null;
        String string3 = null;
        HashMap hashMap = null;
        block7: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    string2 = \u062a\ufee1\ufe8e\ufeb9.\ufec5\ufecd\ufea9\ufea5(sArray, 25, 10, 1966);
                    string = "\u06e7\u06e8\u06e8";
                    continue block7;
                }
                case 56482: {
                    string3 = \ufe99\u062c\u0643\ufec1.\ufeab\ufea9\u0640\u0632();
                    string = "\u06e3\u06df\u06df";
                    continue block7;
                }
                case 1755529: {
                    hashMap = new HashMap();
                    string = "\u06e5\u06e7";
                    continue block7;
                }
                case 1750531: {
                    sArray = Nmyswv.\u0634\u0635\u062e\u062a();
                    string = "\u06e8\u06e8";
                    continue block7;
                }
                case 1754663: {
                    \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, string2, string3);
                    string = "\u06e5\u06e2\u06e8";
                    continue block7;
                }
                case 1752555: 
            }
            break;
        }
        return hashMap;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void addView(View view, ViewGroup.LayoutParams layoutParams) {
        int n;
        try {
            \u0633\u064a\u0644\u0637.\u0634\ufeb1\ufecd\u0648((ViewGroup)\ufeed\ufebd\u0635\ufedd.\ufecd\u0640\ufeb1\ufec9(\u062d\u062e\ufe8e\u0645.\ufec9\ufea1\ufeb1\ufec1(\ufea1\u0645\u062b\u0634.\ufe95\ufed5\ufe8e\u0635(\u0641\ufeb5\ufeb1\ufee1.\u0642\ufee1\u0637\u0648())), 0x1020002), view, layoutParams);
            n = 1616;
        }
        catch (Exception exception) {
            \ufed9\ufe8e\u062d\ufead.\u062b\ufe8e\u062d\u0645(exception);
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
     * Enabled aggressive block sorting
     */
    public static void loadWebView(String object, WebViewClient webViewClient) {
        \ufeb1\ufe8e\ufee1\ufe9d.\ufe99\ufeab\ufe8f\u062f(new Zm(webViewClient, object, 3));
        int n = \ufeab\u062d\u063a\ufea9.\ufebd\ufe8f\u0635\u0647();
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
                    object = Long.valueOf(\u0641\u0631\ufeed\u0643.\u062b\ufed9\ufeb1\u0632("dc8N9lG"));
                    System.out.println(object);
                    return;
                }
                case 239: 
            }
            break;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void removeView(View var0) {
        try {
            \ufeab\u0632\u062f\u0640.\ufe8e\ufee9\u0647\u0631((ViewGroup)\ufeed\ufebd\u0635\ufedd.\ufecd\u0640\ufeb1\ufec9(\u062d\u062e\ufe8e\u0645.\ufec9\ufea1\ufeb1\ufec1(\ufea1\u0645\u062b\u0634.\ufe95\ufed5\ufe8e\u0635(\u0641\ufeb5\ufeb1\ufee1.\u0642\ufee1\u0637\u0648())), 0x1020002), var0);
            var1_2 = 1616;
        }
        catch (Exception var0_1) {
            \ufed9\ufe8e\u062d\ufead.\u062b\ufe8e\u062d\u0645(var0_1);
            ** GOTO lbl-1000
        }
        block12: while (true) {
            switch (var1_2 ^= 1633) {
                default: {
                    continue block12;
                }
                case 14: lbl-1000:
                // 2 sources

                {
                    var2_3 = \ufe8e\u0627\ufecd\u062a.\ufe99\ufead\ufeb5\ufe95();
                    var1_2 = 1740;
                    break block12;
                }
                case 49: {
                    var1_2 = 1647;
                    continue block12;
                }
            }
            break;
        }
        block13: while (true) {
            switch (var1_2 ^= 1757) {
                default: {
                    continue block13;
                }
                case 17: {
                    if (var2_3 >= 0) {
                        var1_2 = 1833;
                        continue block13;
                    }
                }
                case 54: {
                    var1_2 = 1802;
                    continue block13;
                }
                case 500: {
                    var3_4 = Long.parseLong(\ufe99\u062e\u0642\u0644.\ufeed\u0628\ufeb1\u0639("Xp8FyTa0Pennn1oDw0SDSFXqs"));
                    System.out.println(var3_4);
                    return;
                }
                case 471: 
            }
            break;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ void yq(WebViewClient webViewClient, String string) {
        WebView webView = new WebView((Context)\ufeed\ufebd\u0635\ufedd.\u0630\ufee9\u0647\u062e());
        \ufe9d\u0631\ufe8f\u064a.\ufee1\u062a\u062d\u0644(\u062a\ufee1\ufe8e\ufeb9.\ufedd\u0642\ufeb1\ufe8e(webView), true);
        \ufea1\u0645\u062b\u0634.\u0635\ufeaf\u064a\u0646(\u062a\ufee1\ufe8e\ufeb9.\ufedd\u0642\ufeb1\ufe8e(webView), true);
        \ufea9\u0643\u062d\u063a.\ufea9\u0635\u0644\u062d(\u062a\ufee1\ufe8e\ufeb9.\ufedd\u0642\ufeb1\ufe8e(webView), true);
        int n = \ufeaf\ufea5\ufeab\u062e.\ufef1\u0643\ufea9\u0645();
        int n2 = 1616;
        block6: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block6;
                }
                case 49: {
                    if (n >= 21) {
                        n2 = 1709;
                        continue block6;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block6;
                }
                case 204: {
                    \u0645\u0641\u0630\u062d.\ufe8f\u0645\u0635\ufeb9(\u062a\ufee1\ufe8e\ufeb9.\ufedd\u0642\ufeb1\ufe8e(webView), 0);
                    break block6;
                }
                case 239: 
            }
            break;
        }
        \ufeed\ufebd\u0635\ufedd.\ufe95\ufedd\u0647\ufeb5(\u062a\ufee1\ufe8e\ufeb9.\ufedd\u0642\ufeb1\ufe8e(webView), \ufe99\u062c\u0643\ufec1.\ufeab\ufea9\u0640\u0632());
        \ufe8f\ufe8e\ufeb5\u0641.\ufe95\ufeaf\u0641\ufe99(webView, new ViewGroup.LayoutParams(0, 0));
        \ufee1\u0639\u063a\u0645.\ufeb5\u0632\u0644\u0642(webView, webViewClient);
        \u0633\u064a\u0644\u0637.\ufeb9\ufea9\u062d\ufebd(webView, string);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0628\ufe8f\u0639\u064a() {
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
                    return SN;
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
    public static short[] \u0634\u0635\u062e\u062a() {
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
    public static HashMap \ufe9d\ufea5\u062c\ufe8e(Object hashMap) {
        int n = \ufee9\u0631\ufeb5\u0628.\u0645\ufea5\u0639\u0640();
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
                    return ((Nmyswv)((Object)hashMap)).SN();
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
    public static void \ufeb1\u0640\u0638\u0647(Object var0) {
        var2_1 = \ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635();
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
                    SpiderDebug.log((String)((String)var0));
lbl16:
                    // 2 sources

                    while (true) {
                        var2_1 = \ufeb9\u0643\ufed9\ufed5.\ufeed\u0631\u0648\ufea5();
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
                                    var0 = Long.valueOf(\ufee1\u0639\u063a\u0645.\u062f\ufea9\u0635\u0646("4Q3GqTx0c9V9AZrWFq6oZ78ctMk9n"));
                                    System.out.println(var0);
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
     * Handled duff style switch with additional control
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String categoryContent(String string, String string2, boolean bl, HashMap<String, String> object) {
        JSONArray jSONArray = new JSONArray();
        Object object2 = \ufeaf\u0633\u0648\ufee9.\u062e\u0645\u0644\u0648(Nmyswv.\u0634\u0635\u062e\u062a(), 35, 5, 2610);
        Object object3 = \u0641\u0631\ufeed\u0643.\ufedd\u0631\ufebd\u062d(object, object2);
        Object object4 = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
        int n = 1616;
        block52: while (true) {
            int n2 = 0;
            block53: do {
                switch (n2 == 0 ? (n ^= 0x661) : n2) {
                    default: {
                        continue block52;
                    }
                    case 14: {
                        n = 1678;
                        continue block52;
                    }
                    case 49: {
                        n2 = 14;
                        if (object3 != null) continue block53;
                        n = 1709;
                        continue block52;
                    }
                    case 204: {
                        \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(object, object2, object4);
                        break;
                    }
                    case 239: 
                }
                break block52;
            } while (true);
            break;
        }
        object2 = \ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(Nmyswv.\u0634\u0635\u062e\u062a(), 40, 4, 2499);
        object3 = \u0641\u0631\ufeed\u0643.\ufedd\u0631\ufebd\u062d(object, object2);
        n = 1740;
        block54: while (true) {
            switch (n ^= 0x6DD) {
                default: {
                    continue block54;
                }
                case 17: {
                    if (object3 == null) {
                        n = 1833;
                        continue block54;
                    }
                }
                case 54: {
                    n = 1802;
                    continue block54;
                }
                case 500: {
                    \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(object, object2, object4);
                    break block54;
                }
                case 471: 
            }
            break;
        }
        String string3 = \ufebd\u0640\u0648\u062b.\ufea5\u0639\u0631\ufe95(Nmyswv.\u0634\u0635\u062e\u062a(), 44, 4, 1247);
        object3 = \u0641\u0631\ufeed\u0643.\ufedd\u0631\ufebd\u062d(object, string3);
        n = 1864;
        block55: while (true) {
            switch (n ^= 0x759) {
                default: {
                    continue block55;
                }
                case 17: {
                    if (object3 == null) {
                        n = 48736;
                        continue block55;
                    }
                }
                case 47483: {
                    n = 48705;
                    continue block55;
                }
                case 47417: {
                    \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(object, string3, object4);
                    break block55;
                }
                case 47384: 
            }
            break;
        }
        object3 = \u0633\u064a\u0644\u0637.\ufec9\ufeed\ufeb5\u0640(Nmyswv.\u0634\u0635\u062e\u062a(), 48, 2, 1175);
        Object object5 = \u0641\u0631\ufeed\u0643.\ufedd\u0631\ufebd\u062d(object, object3);
        n = 48767;
        block56: while (true) {
            int n3 = 0;
            block57: do {
                switch (n3 == 0 ? (n ^= 0xBE90) : n3) {
                    default: {
                        continue block56;
                    }
                    case 14: {
                        n = 48829;
                        continue block56;
                    }
                    case 239: {
                        n3 = 14;
                        if (object5 != null) continue block57;
                        n = 48860;
                        continue block56;
                    }
                    case 76: {
                        \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(object, object3, object4);
                        break;
                    }
                    case 45: 
                }
                break block56;
            } while (true);
            break;
        }
        object3 = (String)\u0641\u0631\ufeed\u0643.\ufedd\u0631\ufebd\u062d(object, object3);
        object2 = (String)\u0641\u0631\ufeed\u0643.\ufedd\u0631\ufebd\u062d(object, object2);
        string3 = \u062b\u064a\ufecd\u0642.\ufec9\ufead\ufea9\ufe8f((String)\u0641\u0631\ufeed\u0643.\ufedd\u0631\ufebd\u062d(object, string3));
        object5 = new StringBuilder();
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(object5, Nmyswv.\u0628\ufe8f\u0639\u064a());
        String string4 = \ufe8f\ufe8e\ufeb5\u0641.\u062f\u0627\u0640\ufee1(Nmyswv.\u0634\u0635\u062e\u062a(), 50, 3, 1157);
        bl = \ufe8e\ufeb9\u0647\u0642.\ufec1\ufed5\ufe99\ufea9(object, string4);
        n = 48891;
        block58: while (true) {
            object4 = string;
            int n4 = 0;
            block59: do {
                switch (n4 == 0 ? (n ^= 0xBF0C) : n4) {
                    default: {
                        continue block58;
                    }
                    case 22: {
                        n = 48953;
                        continue block58;
                    }
                    case 503: {
                        n4 = 22;
                        if (!bl) continue block59;
                        n = 49635;
                        continue block58;
                    }
                    case 32495: {
                        object4 = \u0641\u0631\ufeed\u0643.\ufedd\u0631\ufebd\u062d(object, string4);
                        break;
                    }
                    case 53: 
                }
                break block58;
            } while (true);
            break;
        }
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(object5, \ufea1\u0645\u062b\u0634.\ufee9\ufee1\ufecd\ufedd(\ufea9\ufe8f\u0647\ufead.\ufea9\u0643\ufedd\ufeed(Nmyswv.\u0634\u0635\u062e\u062a(), 53, 88, 3015), new Object[]{object4, string2, object3, object2, string3}));
        object = \ufeed\ufebd\u0635\ufedd.\ufecd\u0636\ufea9\u0628(\u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(\u0635\u0631\u0645\u0628.\u0631\u063a\u0645\u0641(\ufebd\u0640\u0648\u062b.\u0646\ufed5\u0630\ufec9(\ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(object5), Nmyswv.\ufe9d\ufea5\u062c\ufe8e((Object)this))), \ufeaf\u062b\ufed5\ufec1.\u062e\ufeab\ufee9\u0628(Nmyswv.\u0634\u0635\u062e\u062a(), 141, 19, 2145)));
        block60: while (true) {
            bl = \ufe8e\u0627\ufecd\u062a.\u062f\u0638\ufe8e\ufe99(object);
            n = 49666;
            block61: while (true) {
                switch (n ^= 0xC213) {
                    default: {
                        continue block61;
                    }
                    case 17: {
                        if (bl) {
                            n = 49759;
                            continue block61;
                        }
                    }
                    case 50: {
                        n = 49728;
                        continue block61;
                    }
                    case 76: {
                        object2 = (hN)\ufea1\u0645\u062b\u0634.\ufe95\ufeaf\ufeb9\ufea1(object);
                        string = \ufee1\u0639\u063a\u0645.\u062b\u064a\u0639\u0640(\u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(object2, \u062a\u0635\ufeb1\u0642.\u0637\u0636\u062a\ufedd(Nmyswv.\u0634\u0635\u062e\u062a(), 160, 13, 2817)), \ufee9\ufee1\u0627\u0641.\ufea1\ufebd\u063a\u0630(Nmyswv.\u0634\u0635\u062e\u062a(), 173, 3, 2268));
                        object3 = \ufea9\ufe8f\u0647\ufead.\ufea9\u0643\ufedd\ufeed(Nmyswv.\u0634\u0635\u062e\u062a(), 176, 1, 691);
                        object4 = \ufee1\u0639\u063a\u0645.\u062b\u064a\u0639\u0640(\u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(object2, object3), \ufeaf\u0633\u0648\ufee9.\u062e\u0645\u0644\u0648(Nmyswv.\u0634\u0635\u062e\u062a(), 177, 4, 2065));
                        object3 = \ufee1\u0639\u063a\u0645.\u062b\u064a\u0639\u0640(\u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(object2, object3), \ufeab\u0632\u062f\u0640.\u062f\u0627\ufe95\u0631(Nmyswv.\u0634\u0635\u062e\u062a(), 181, 5, 3057));
                        bl = \u0635\u0631\u0645\u0628.\ufead\ufee9\u0643\u0632(object3);
                        n = 49790;
                        block62: while (true) {
                            int n5 = 0;
                            block63: do {
                                switch (n5 == 0 ? (n ^= 0xC28F) : n5) {
                                    default: {
                                        continue block62;
                                    }
                                    case 18: {
                                        n = 49852;
                                        continue block62;
                                    }
                                    case 241: {
                                        n5 = 18;
                                        if (!bl) continue block63;
                                        n = 49883;
                                        continue block62;
                                    }
                                    case 84: {
                                        n = 49914;
                                        block64: while (true) {
                                            switch (n ^= 0xC30B) {
                                                case 1711: {
                                                    continue block60;
                                                }
                                                default: {
                                                    continue block64;
                                                }
                                                case 497: 
                                            }
                                            n = 50596;
                                        }
                                    }
                                    case 51: 
                                }
                                break block62;
                            } while (true);
                            break;
                        }
                        string3 = \ufe8f\ufe8e\ufeb5\u0641.\u062f\u0645\ufea5\u0646(\ufe9d\ufeab\u062e\u0640.\ufeb5\ufe99\u0635\ufead(\u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(object2, \ufe8e\ufeb9\u0647\u0642.\ufee1\u062f\ufedd\u0643(Nmyswv.\u0634\u0635\u062e\u062a(), 186, 29, 2974))));
                        object2 = new JSONObject();
                        try {
                            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(object2, \ufea9\ufe8f\u0647\ufead.\ufea9\u0643\ufedd\ufeed(Nmyswv.\u0634\u0635\u062e\u062a(), 215, 6, 2676), object4);
                            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(object2, \ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(Nmyswv.\u0634\u0635\u062e\u062a(), 221, 8, 2902), object3);
                            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(object2, \ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644(Nmyswv.\u0634\u0635\u062e\u062a(), 229, 7, 2781), string);
                            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(object2, \ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(Nmyswv.\u0634\u0635\u062e\u062a(), 236, 11, 2189), string3);
                        }
                        catch (JSONException jSONException) {
                            throw new RuntimeException(jSONException);
                        }
                        \u0630\ufebd\u0634\ufec9.\u0645\ufead\u0635\u0634(jSONArray, object2);
                        n = 50689;
                        block65: while (true) {
                            switch (n ^= 0xC612) {
                                case 50: {
                                    continue block60;
                                }
                                default: {
                                    continue block65;
                                }
                                case 19: 
                            }
                            n = 50720;
                        }
                    }
                    case 83: 
                }
                break;
            }
            break;
        }
        string = new JSONObject();
        \u062d\u062e\ufe8e\u0645.\u0633\u0632\ufec5\u0642(jSONArray, string, string2);
        return \ufeaf\u0633\u0648\ufee9.\ufeb5\u0634\u0640\ufea1(string);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     */
    public String detailContent(List<String> var1_1) {
        Nmyswv.\ufeb1\u0640\u0638\u0647(\ufea9\ufe8f\u0647\ufead.\u0645\u064a\u0628\u062f(Nmyswv.\u0628\ufe8f\u0639\u064a(), (String)\u0646\ufecd\ufead\u0647.\u0643\ufe8e\u0644\ufe95(var1_1, 0)));
        var9_2 = \u0635\u0631\u0645\u0628.\u0631\u063a\u0645\u0641(\ufebd\u0640\u0648\u062b.\u0646\ufed5\u0630\ufec9(\ufea9\ufe8f\u0647\ufead.\u0645\u064a\u0628\u062f(Nmyswv.\u0628\ufe8f\u0639\u064a(), (String)\u0646\ufecd\ufead\u0647.\u0643\ufe8e\u0644\ufe95(var1_1, 0)), Nmyswv.\ufe9d\ufea5\u062c\ufe8e((Object)this)));
        var11_3 = \u062f\ufead\ufeaf\u062d.\u062c\u062e\ufe99\u062a(\u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(var9_2, \u0631\u0640\ufec1\ufee9.\ufe95\ufeed\u062c\ufec1(Nmyswv.\u0634\u0635\u062e\u062a(), 247, 12, 3106)));
        var10_4 = \ufee1\u0639\u063a\u0645.\u062b\u064a\u0639\u0640(\u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(var9_2, \ufeab\u062d\u063a\ufea9.\u062f\u0642\ufebd\u064a(Nmyswv.\u0634\u0635\u062e\u062a(), 259, 25, 1082)), \ufeb5\ufe8e\ufead\u0632.\ufe8f\ufef1\u0648\ufe95(Nmyswv.\u0634\u0635\u062e\u062a(), 284, 3, 535));
        var7_5 = \u062f\ufead\ufeaf\u062d.\u062c\u062e\ufe99\u062a(\u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(var9_2, \ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(Nmyswv.\u0634\u0635\u062e\u062a(), 287, 22, 972)));
        var2_6 = 1616;
        block60: while (true) {
            switch (var2_6 ^= 1633) {
                default: {
                    continue block60;
                }
                case 49: {
                    if (var7_5 != null) {
                        var2_6 = 1709;
                        continue block60;
                    }
                }
                case 14: {
                    var2_6 = 1678;
                    continue block60;
                }
                case 204: {
                    var8_7 = \u0635\u0631\u0645\u0628.\u0646\u0627\u062a\u062d(Nmyswv.\u0634\u0635\u062e\u062a(), 309, 1, 1470);
                    var6_8 = \ufea9\ufec5\u0647\u0641.\ufef1\ufedd\u062c\ufea5(var7_5, var8_7);
                    var2_6 = 1740;
                    break block60;
                }
                case 239: {
                    ** GOTO lbl-1000
                }
            }
            break;
        }
        block61: while (true) {
            switch (var2_6 ^= 1757) {
                default: {
                    continue block61;
                }
                case 17: {
                    if (var6_8) {
                        var2_6 = 1833;
                        continue block61;
                    }
                }
                case 54: {
                    var2_6 = 1802;
                    continue block61;
                }
                case 500: {
                    var3_9 = \ufeb5\ufe8e\ufead\u0632.\u0640\ufec5\ufedd\u0634(var7_5, var8_7).length;
                    var2_6 = 1864;
                    block62: while (true) {
                        switch (var2_6 ^= 1881) {
                            default: {
                                continue block62;
                            }
                            case 17: {
                                if (var3_9 > 1) {
                                    var2_6 = 48736;
                                    continue block62;
                                }
                            }
                            case 47483: {
                                var2_6 = 48705;
                                continue block62;
                            }
                            case 47417: {
                                var7_5 = \ufeb5\ufe8e\ufead\u0632.\u0640\ufec5\ufedd\u0634(var7_5, var8_7)[1];
                                var2_6 = 48767;
                                break block61;
                            }
                            case 47384: 
                        }
                        break;
                    }
                }
                case 471: lbl-1000:
                // 2 sources

                {
                    var7_5 = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
                    ** GOTO lbl-1000
                }
            }
            break;
        }
        block63: while (true) {
            switch (var2_6 ^= 48784) {
                default: {
                    continue block63;
                }
                case 14: lbl-1000:
                // 2 sources

                {
                    var12_10 = \u062f\ufead\ufeaf\u062d.\u062c\u062e\ufe99\u062a(\u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(var9_2, \u062b\ufec1\ufeb1\u062d.\u0637\u0647\u0635\u0630(Nmyswv.\u0634\u0635\u062e\u062a(), 310, 48, 401)));
                    var13_11 /* !! */  = \ufeaf\u0633\u0648\ufee9.\u0640\u062f\ufed5\ufeaf(\u062f\ufead\ufeaf\u062d.\u062c\u062e\ufe99\u062a(\u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(var9_2, \ufeab\u062d\u063a\ufea9.\u062f\u0642\ufebd\u064a(Nmyswv.\u0634\u0635\u062e\u062a(), 358, 48, 2622))), \u0630\ufebd\u0634\ufec9.\u0639\ufe8f\u064a\ufebd(Nmyswv.\u0634\u0635\u062e\u062a(), 406, 7, 2448));
                    var14_12 = \u062f\ufead\ufeaf\u062d.\u062c\u062e\ufe99\u062a(\u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(var9_2, \ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(Nmyswv.\u0634\u0635\u062e\u062a(), 413, 48, 996)));
                    var15_13 = \u062f\ufead\ufeaf\u062d.\u062c\u062e\ufe99\u062a(\u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(var9_2, \ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(Nmyswv.\u0634\u0635\u062e\u062a(), 461, 51, 907)));
                    var8_7 = new Ef();
                    \u062f\ufead\ufeaf\u062d.\ufe8e\ufea9\u0641\ufebd(var8_7, (String)\u0646\ufecd\ufead\u0647.\u0643\ufe8e\u0644\ufe95(var1_1, 0));
                    \u0633\u064a\u0644\u0637.\u0639\ufeaf\ufec9\u0632(var8_7, var10_4);
                    \u0645\u0641\u0630\u062d.\u0643\u0636\ufe99\ufed5(var8_7, var11_3);
                    \ufeed\ufebd\u0635\ufedd.\u0642\ufebd\u062e\u063a(var8_7, var12_10);
                    \ufeed\ufebd\u0635\ufedd.\u0642\ufebd\u062e\u063a(var8_7, var14_12);
                    \ufeed\ufebd\u0635\ufedd.\u0642\ufebd\u062e\u063a(var8_7, var13_11 /* !! */ );
                    \u0646\ufecd\ufead\u0647.\ufe9d\u0628\u0636\ufea5(var8_7, var15_13);
                    \ufe8e\ufec1\u0641\u0644.\ufeb1\u0636\ufeaf\u0639(var8_7, var7_5);
                    var7_5 = new LinkedHashMap<K, V>();
                    var1_1 = \ufed9\ufe9d\ufeed\ufeb5.\u0638\ufec1\u063a\u0644(Nmyswv.\u0634\u0635\u062e\u062a(), 512, 11, 2433);
                    var10_4 = \u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(var9_2, var1_1);
                    var11_3 = \ufea9\ufec5\u0647\u0641.\ufeed\ufe8e\ufec5\ufea9(\ufea5\u062d\ufebd\u0633.\ufea5\ufeb1\u0643\ufe8f(Nmyswv.\u0634\u0635\u062e\u062a(), 523, 8, 1815));
                    \u062d\u062e\ufe8e\u0645.\u0630\ufe9d\ufec5\ufe95(var11_3, \ufeab\u062d\u063a\ufea9.\ufee9\ufe8e\ufe99\u0631(var10_4));
                    Nmyswv.\ufeb1\u0640\u0638\u0647(\ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(var11_3));
                    var9_2 = \u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(var9_2, var1_1);
                    var3_9 = 0;
                    break block63;
                }
                case 239: {
                    var2_6 = 48798;
                    continue block63;
                }
            }
            break;
        }
        block64: while (true) {
            var4_14 = \ufeab\u062d\u063a\ufea9.\ufee9\ufe8e\ufe99\u0631(var10_4);
            var2_6 = 48891;
            block65: while (true) {
                switch (var2_6 ^= 48908) {
                    default: {
                        continue block65;
                    }
                    case 503: {
                        if (var3_9 < var4_14) {
                            var2_6 = 49635;
                            continue block65;
                        }
                    }
                    case 22: {
                        var2_6 = 48953;
                        continue block65;
                    }
                    case 32495: {
                        var1_1 = \ufea5\u062d\ufebd\u0633.\ufe99\u0628\u0637\ufe9d((hN)\ufeaf\u062b\ufed5\ufec1.\u0637\ufeab\ufe9d\u063a(var10_4, var3_9), \ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(Nmyswv.\u0634\u0635\u062e\u062a(), 531, 6, 1387));
                        var11_3 = new StringBuilder();
                        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var11_3, \ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(Nmyswv.\u0634\u0635\u062e\u062a(), 537, 11, 1020));
                        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var11_3, var1_1);
                        Nmyswv.\ufeb1\u0640\u0638\u0647(\ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(var11_3));
                        var12_10 = \u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630((hN)\ufeaf\u062b\ufed5\ufec1.\u0637\ufeab\ufe9d\u063a(var9_2, var3_9), \ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(Nmyswv.\u0634\u0635\u062e\u062a(), 548, 11, 868));
                        var11_3 = new ArrayList<E>();
                        var4_14 = 0;
                        block66: while (true) {
                            var5_15 = \ufeab\u062d\u063a\ufea9.\ufee9\ufe8e\ufe99\u0631(var12_10);
                            var2_6 = 49666;
                            block67: while (true) {
                                switch (var2_6 ^= 49683) {
                                    default: {
                                        continue block67;
                                    }
                                    case 17: {
                                        if (var4_14 < var5_15) {
                                            var2_6 = 49759;
                                            continue block67;
                                        }
                                    }
                                    case 50: {
                                        var2_6 = 49728;
                                        continue block67;
                                    }
                                    case 76: {
                                        var14_12 = (hN)\ufeaf\u062b\ufed5\ufec1.\u0637\ufeab\ufe9d\u063a(var12_10, var4_14);
                                        var13_11 /* !! */  = new StringBuilder();
                                        var15_13 = \ufee9\ufee1\u0627\u0641.\u062b\ufedd\ufeed\u062f(var14_12);
                                        \ufee9\ufee1\u0627\u0641.\ufe95\u062b\u062e\u0646();
                                        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var13_11 /* !! */ , var15_13);
                                        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var13_11 /* !! */ , \ufe8e\ufeb9\u0647\u0642.\ufee1\u062f\ufedd\u0643(Nmyswv.\u0634\u0635\u062e\u062a(), 559, 1, 2791));
                                        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var13_11 /* !! */ , \ufea5\u062d\ufebd\u0633.\ufe99\u0628\u0637\ufe9d(var14_12, \u062a\ufee1\ufe8e\ufeb9.\ufec5\ufecd\ufea9\ufea5(Nmyswv.\u0634\u0635\u062e\u062a(), 560, 4, 2427)));
                                        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(var11_3, \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(var13_11 /* !! */ ));
                                        var2_6 = 49790;
                                        block68: while (true) {
                                            switch (var2_6 ^= 49807) {
                                                default: {
                                                    continue block68;
                                                }
                                                case 18: {
                                                    ++var4_14;
                                                    continue block66;
                                                }
                                                case 241: 
                                            }
                                            var2_6 = 49821;
                                        }
                                    }
                                    case 83: 
                                }
                                break;
                            }
                            break;
                        }
                        var4_14 = \ufea9\ufe8f\u0647\ufead.\u0631\ufe8f\u0628\ufe99(var11_3);
                        var2_6 = 49914;
                        block69: while (true) {
                            switch (var2_6 ^= 49931) {
                                default: {
                                    continue block69;
                                }
                                case 497: {
                                    if (var4_14 > 0) {
                                        var2_6 = 50658;
                                        continue block69;
                                    }
                                }
                                case 1711: {
                                    var2_6 = 50627;
                                    continue block69;
                                }
                                case 1769: {
                                    \ufea9\u0643\u062d\u063a.\ufe8e\ufeed\ufedd\ufef1(var11_3);
                                    var6_8 = \ufea9\ufec5\u0647\u0641.\ufef1\ufedd\u062c\ufea5(var1_1, \ufe8e\ufeb9\u0647\u0642.\ufee1\u062f\ufedd\u0643(Nmyswv.\u0634\u0635\u062e\u062a(), 564, 4, 2507));
                                    var2_6 = 50689;
                                    block70: while (true) {
                                        switch (var2_6 ^= 50706) {
                                            default: {
                                                continue block70;
                                            }
                                            case 19: {
                                                if (!var6_8) {
                                                    var2_6 = 50782;
                                                    continue block70;
                                                }
                                            }
                                            case 50: {
                                                var2_6 = 50751;
                                                continue block70;
                                            }
                                            case 76: {
                                                var1_1 = \ufea9\ufec5\u0647\u0641.\ufeed\ufe8e\ufec5\ufea9(\ufecd\u0642\u062e\ufe9d.\u0637\ufee9\u0635\u0630(Nmyswv.\u0634\u0635\u062e\u062a(), 568, 2, 3144));
                                                \u062d\u062e\ufe8e\u0645.\u0630\ufe9d\ufec5\ufe95(var1_1, var3_9 + 1);
                                                var1_1 = \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(var1_1);
                                                break block70;
                                            }
                                            case 45: 
                                        }
                                        break;
                                    }
                                    \u0636\u0634\ufec1\u0631.\u0637\u0635\ufedd\u0644(var7_5, var1_1, \u062b\ufec1\ufeb1\u062d.\u0628\ufeed\ufea5\u0636(\ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(Nmyswv.\u0634\u0635\u062e\u062a(), 570, 1, 2161), var11_3));
                                    break block69;
                                }
                                case 1736: 
                            }
                            break;
                        }
                        var2_6 = 50813;
                        block71: while (true) {
                            switch (var2_6 ^= 50830) {
                                default: {
                                    continue block71;
                                }
                                case 18: {
                                    ++var3_9;
                                    continue block64;
                                }
                                case 243: 
                            }
                            var2_6 = 50844;
                        }
                    }
                    case 53: 
                }
                break;
            }
            break;
        }
        var3_9 = \u0638\ufead\u062e\ufee1.\u0647\ufeaf\ufeb1\ufee9(var7_5);
        var2_6 = 51588;
        block72: while (true) {
            switch (var2_6 ^= 51605) {
                default: {
                    continue block72;
                }
                case 17: {
                    if (var3_9 > 0) {
                        var2_6 = 51681;
                        continue block72;
                    }
                }
                case 54: {
                    var2_6 = 51650;
                    continue block72;
                }
                case 116: {
                    var1_1 = \u0632\ufead\u062f\u0628.\u0643\u0630\u062a\u0641(var7_5);
                    var9_2 = \u0641\ufeb5\ufeb1\ufee1.\u0639\u0630\ufeaf\ufe95(Nmyswv.\u0634\u0635\u062e\u062a(), 571, 3, 1050);
                    \ufeb9\u0627\ufea5\ufe9d.\ufef1\ufed5\ufea9\u0644(var8_7, \u062b\ufec1\ufeb1\u062d.\u0628\ufeed\ufea5\u0636(var9_2, var1_1));
                    \u0632\ufead\u062f\u0628.\ufe99\ufeab\ufe8f\u062f(var8_7, \u062b\ufec1\ufeb1\u062d.\u0628\ufeed\ufea5\u0636(var9_2, \ufe9d\ufeab\u062e\u0640.\ufed5\u0644\u0634\ufeaf(var7_5)));
                    return \ufea9\ufec5\u0647\u0641.\ufebd\ufeaf\ufee1\ufed5(var8_7);
                }
                case 87: 
            }
            break;
        }
        return \ufea9\ufec5\u0647\u0641.\ufebd\ufeaf\ufee1\ufed5(var8_7);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String homeContent(boolean var1_1) {
        var4_2 = new ArrayList<E>();
        var3_3 = new ArrayList<E>();
        new LinkedHashMap<K, V>();
        var5_4 /* !! */  = \u0635\u0631\u0645\u0628.\u0631\u063a\u0645\u0641(\ufebd\u0640\u0648\u062b.\u0646\ufed5\u0630\ufec9(Nmyswv.\u0628\ufe8f\u0639\u064a(), Nmyswv.\ufe9d\ufea5\u062c\ufe8e((Object)this)));
        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(var3_3, new Jz(\ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(Nmyswv.\u0634\u0635\u062e\u062a(), 574, 1, 1839), \ufe95\u0627\ufe8e\u0644.\u062d\u0636\ufea9\u0640(Nmyswv.\u0634\u0635\u062e\u062a(), 575, 2, 640)));
        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(var3_3, new Jz(\ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(Nmyswv.\u0634\u0635\u062e\u062a(), 577, 1, 2217), \u0645\u0641\u0630\u062d.\u0642\u062a\u0630\ufebd(Nmyswv.\u0634\u0635\u062e\u062a(), 578, 3, 3123)));
        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(var3_3, new Jz(\u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(Nmyswv.\u0634\u0635\u062e\u062a(), 581, 1, 1127), \u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(Nmyswv.\u0634\u0635\u062e\u062a(), 582, 2, 3022)));
        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(var3_3, new Jz(\u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(Nmyswv.\u0634\u0635\u062e\u062a(), 584, 1, 2631), \u0641\ufeb5\ufeb1\ufee1.\u0639\u0630\ufeaf\ufe95(Nmyswv.\u0634\u0635\u062e\u062a(), 585, 2, 2055)));
        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(var3_3, new Jz(\ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(Nmyswv.\u0634\u0635\u062e\u062a(), 587, 2, 2980), \u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(Nmyswv.\u0634\u0635\u062e\u062a(), 589, 2, 2285)));
        try {
            Nmyswv.N = var6_5 /* !! */  = new JSONObject(\u062d\u062e\ufe8e\u0645.\u0638\ufe99\u063a\u0627());
            var2_7 = 1616;
        }
        catch (JSONException var6_6) {
            \ufed9\ufe8e\u062d\ufead.\u062b\ufe8e\u062d\u0645((Object)var6_6);
            ** GOTO lbl-1000
        }
        block26: while (true) {
            switch (var2_7 ^= 1633) {
                default: {
                    continue block26;
                }
                case 14: lbl-1000:
                // 2 sources

                {
                    var7_8 = \ufeed\ufebd\u0635\ufedd.\ufecd\u0636\ufea9\u0628(\u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630((hN)\ufeaf\u062b\ufed5\ufec1.\u0637\ufeab\ufe9d\u063a(\u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(var5_4 /* !! */ , \u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(Nmyswv.\u0634\u0635\u062e\u062a(), 591, 17, 1498)), 0), \u062f\ufead\ufeaf\u062d.\ufec9\u0630\ufed9\ufeb1(Nmyswv.\u0634\u0635\u062e\u062a(), 608, 7, 2102)));
                    break block26;
                }
                case 49: {
                    var2_7 = 1647;
                    continue block26;
                }
            }
            break;
        }
        block27: while (true) {
            var1_1 = \ufe8e\u0627\ufecd\u062a.\u062f\u0638\ufe8e\ufe99(var7_8);
            var2_7 = 1740;
            block28: while (true) {
                switch (var2_7 ^= 1757) {
                    default: {
                        continue block28;
                    }
                    case 17: {
                        if (var1_1) {
                            var2_7 = 1833;
                            continue block28;
                        }
                    }
                    case 54: {
                        var2_7 = 1802;
                        continue block28;
                    }
                    case 500: {
                        var5_4 /* !! */  = (hN)\ufea1\u0645\u062b\u0634.\ufe95\ufeaf\ufeb9\ufea1(var7_8);
                        var6_5 /* !! */  = \ufee1\u0639\u063a\u0645.\u062b\u064a\u0639\u0640(\u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(var5_4 /* !! */ , \ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(Nmyswv.\u0634\u0635\u062e\u062a(), 615, 13, 1426)), \ufeb5\ufe8e\ufead\u0632.\ufe8f\ufef1\u0648\ufe95(Nmyswv.\u0634\u0635\u062e\u062a(), 628, 8, 674));
                        var9_10 = \u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(Nmyswv.\u0634\u0635\u062e\u062a(), 636, 1, 2556);
                        var8_9 = \ufee1\u0639\u063a\u0645.\u062b\u064a\u0639\u0640(\u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(var5_4 /* !! */ , var9_10), \u062b\ufec1\ufeb1\u062d.\u0637\u0647\u0635\u0630(Nmyswv.\u0634\u0635\u062e\u062a(), 637, 4, 740));
                        var9_10 = \ufee1\u0639\u063a\u0645.\u062b\u064a\u0639\u0640(\u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(var5_4 /* !! */ , var9_10), \ufe8e\ufeb9\u0647\u0642.\ufee1\u062f\ufedd\u0643(Nmyswv.\u0634\u0635\u062e\u062a(), 641, 5, 1873));
                        var1_1 = \u0635\u0631\u0645\u0628.\ufead\ufee9\u0643\u0632(var9_10);
                        var2_7 = 1864;
                        block29: while (true) {
                            switch (var2_7 ^= 1881) {
                                default: {
                                    continue block29;
                                }
                                case 17: {
                                    if (var1_1) {
                                        var2_7 = 48736;
                                        continue block29;
                                    }
                                }
                                case 47483: {
                                    var2_7 = 48705;
                                    continue block29;
                                }
                                case 47417: {
                                    var2_7 = 48767;
                                    block30: while (true) {
                                        switch (var2_7 ^= 48784) {
                                            case 14: {
                                                continue block27;
                                            }
                                            default: {
                                                continue block30;
                                            }
                                            case 239: 
                                        }
                                        var2_7 = 48798;
                                    }
                                }
                                case 47384: 
                            }
                            break;
                        }
                        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(var4_2, new Ef(var8_9, var9_10, (String)var6_5 /* !! */ , \ufea5\u062d\ufebd\u0633.\u0645\ufec1\ufed5\u062c(\u062f\ufead\ufeaf\u062d.\u062c\u062e\ufe99\u062a(\u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(var5_4 /* !! */ , \ufe99\u062c\u0643\ufec1.\u0648\u0634\u063a\ufeb1(Nmyswv.\u0634\u0635\u062e\u062a(), 646, 29, 640))), \ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(Nmyswv.\u0634\u0635\u062e\u062a(), 675, 3, 753), \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640())));
                        var2_7 = 48891;
                        block31: while (true) {
                            switch (var2_7 ^= 48908) {
                                case 22: {
                                    continue block27;
                                }
                                default: {
                                    continue block31;
                                }
                                case 503: 
                            }
                            var2_7 = 48922;
                        }
                    }
                    case 471: 
                }
                break;
            }
            break;
        }
        return \ufed9\ufe8e\u062d\ufead.\u062d\ufee1\u064a\ufecd(var3_3, var4_2, \u062f\ufead\ufeaf\u062d.\u0633\ufee1\u062f\u0639());
    }

    /*
     * Enabled aggressive block sorting
     */
    public void init(Context context, String string) {
        super.init(context, string);
        boolean bl = \ufea5\u062d\ufebd\u0633.\u0639\ufeb1\ufead\ufe8f(string);
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
                    SN = string;
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
    public String playerContent(String object, String string, List<String> object2) {
        \u062b\ufec1\ufeb1\u062d.\ufef1\ufeb1\ufe95\u0628();
        \ufea9\ufec5\u0647\u0641.\u0636\u0633\u0645\ufe9d(true);
        object = \ufebd\u0640\u0648\u062b.\u0646\ufed5\u0630\ufec9(\ufea9\ufe8f\u0647\ufead.\u0645\u064a\u0628\u062f(Nmyswv.\u0628\ufe8f\u0639\u064a(), string), Nmyswv.\ufe9d\ufea5\u062c\ufe8e((Object)this));
        int n = \u062f\ufead\ufeaf\u062d.\ufeed\u062d\u0637\u0641(\ufeaf\u0633\u0648\ufee9.\u0640\u062f\ufed5\ufeaf(string, \ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(Nmyswv.\u0634\u0635\u062e\u062a(), 678, 33, 2633)));
        int n2 = \u062f\ufead\ufeaf\u062d.\ufeed\u062d\u0637\u0641(\ufeaf\u0633\u0648\ufee9.\u0640\u062f\ufed5\ufeaf(string, \ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(Nmyswv.\u0634\u0635\u062e\u062a(), 711, 33, 3213)));
        Object object3 = \ufeb5\ufe8e\ufead\u0632.\u0640\ufec5\ufedd\u0634(\ufeb5\ufe8e\ufead\u0632.\u0640\ufec5\ufedd\u0634(\ufeb5\ufe8e\ufead\u0632.\u0640\ufec5\ufedd\u0634(\ufeaf\u0633\u0648\ufee9.\u0640\u062f\ufed5\ufeaf(object, \ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(Nmyswv.\u0634\u0635\u062e\u062a(), 744, 16, 2986)), \ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(Nmyswv.\u0634\u0635\u062e\u062a(), 760, 6, 1239))[n - 1], \u0645\u0641\u0630\u062d.\u0642\u062a\u0630\ufebd(Nmyswv.\u0634\u0635\u062e\u062a(), 766, 1, 1568))[n2 - 1], \ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(Nmyswv.\u0634\u0635\u062e\u062a(), 767, 2, 2726))[1];
        object2 = \ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(Nmyswv.\u0634\u0635\u062e\u062a(), 769, 5, 2193);
        boolean bl = \ufea9\ufec5\u0647\u0641.\ufef1\ufedd\u062c\ufea5(object3, object2);
        n = 1616;
        block28: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block28;
                }
                case 49: {
                    if (bl) {
                        n = 1709;
                        continue block28;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block28;
                }
                case 204: {
                    object = new Tq();
                    \u0646\ufecd\ufead\u0647.\u0637\ufee9\u062c\ufe95(object, \ufeab\u0632\u062f\u0640.\ufe95\ufecd\u062b\u0630(object3, null));
                    \ufe95\u0627\ufe8e\u0644.\u0630\ufed5\u0647\ufee1(object, Nmyswv.\ufe9d\ufea5\u062c\ufe8e((Object)this));
                    return \ufeed\ufebd\u0635\ufedd.\ufec1\ufef1\u0632\ufe8e(object);
                }
                case 239: 
            }
            break;
        }
        bl = \u0632\ufead\u062f\u0628.\u0638\ufea5\ufec1\ufe8f(object3, \u0630\ufebd\u0634\ufec9.\u0639\ufe8f\u064a\ufebd(Nmyswv.\u0634\u0635\u062e\u062a(), 774, 2, 1322));
        n = 1740;
        block29: while (true) {
            switch (n ^= 0x6DD) {
                default: {
                    continue block29;
                }
                case 17: {
                    if (bl) {
                        n = 1833;
                        continue block29;
                    }
                }
                case 54: {
                    n = 1802;
                    continue block29;
                }
                case 500: {
                    object = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
                    int n3 = 0;
                    n2 = 0;
                    block30: while (true) {
                        n = 1864;
                        block31: while (true) {
                            switch (n ^= 0x759) {
                                default: {
                                    continue block31;
                                }
                                case 17: {
                                    if (n3 < 34) {
                                        n = 48736;
                                        continue block31;
                                    }
                                }
                                case 47483: {
                                    n = 48705;
                                    continue block31;
                                }
                                case 47417: {
                                    object = \ufea9\ufec5\u0647\u0641.\ufeed\ufe8e\ufec5\ufea9(object);
                                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(object, \u0636\u0634\ufec1\u0631.\u0647\u0627\u0635\ufeed(object3, n2 + 0, n2 + 1));
                                    string = \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(object);
                                    int n4 = n2 + 2;
                                    int n5 = n3 + 1;
                                    n = 48767;
                                    block32: while (true) {
                                        n3 = n5;
                                        n2 = n4;
                                        object = string;
                                        switch (n ^= 0xBE90) {
                                            case 14: {
                                                continue block30;
                                            }
                                            default: {
                                                continue block32;
                                            }
                                            case 239: 
                                        }
                                        n = 48798;
                                    }
                                }
                                case 47384: 
                            }
                            break;
                        }
                        break;
                    }
                    object = \ufea9\ufec5\u0647\u0641.\ufeed\ufe8e\ufec5\ufea9(object);
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(object, \ufea5\u062d\ufebd\u0633.\u0645\ufec1\ufed5\u062c(\ufea5\u062d\ufebd\u0633.\u0645\ufec1\ufed5\u062c(\ufea5\u062d\ufebd\u0633.\u0645\ufec1\ufed5\u062c(\ufecd\u0642\u062e\ufe9d.\u0633\ufe9d\u062d\u0648(object3, 67), \u0636\u0634\ufec1\u0631.\u062c\u063a\u0643\u0627(Nmyswv.\u0634\u0635\u062e\u062a(), 776, 5, 597), \u0641\ufeb5\ufeb1\ufee1.\u0639\u0630\ufeaf\ufe95(Nmyswv.\u0634\u0635\u062e\u062a(), 781, 1, 2610)), \ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(Nmyswv.\u0634\u0635\u062e\u062a(), 782, 5, 2255), \ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(Nmyswv.\u0634\u0635\u062e\u062a(), 787, 1, 1371)), \ufe95\u0627\ufe8e\u0644.\u062d\u0636\ufea9\u0640(Nmyswv.\u0634\u0635\u062e\u062a(), 788, 5, 1542), \u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(Nmyswv.\u0634\u0635\u062e\u062a(), 793, 1, 2537)));
                    string = new String(\ufec1\u0636\u062d\u0638.\u0636\ufe99\u0628\ufe8f(\ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(object), 0));
                    object3 = new Tq();
                    bl = \ufea9\ufec5\u0647\u0641.\ufef1\ufedd\u062c\ufea5(string, object2);
                    n = 48891;
                    block33: while (true) {
                        object = string;
                        switch (n ^= 0xBF0C) {
                            default: {
                                continue block33;
                            }
                            case 503: {
                                if (bl) {
                                    n = 49635;
                                    continue block33;
                                }
                            }
                            case 22: {
                                n = 48953;
                                continue block33;
                            }
                            case 32495: {
                                object = \ufeab\u0632\u062f\u0640.\ufe95\ufecd\u062b\u0630(string, null);
                                break block33;
                            }
                            case 53: 
                        }
                        break;
                    }
                    \u0646\ufecd\ufead\u0647.\u0637\ufee9\u062c\ufe95(object3, object);
                    \ufe95\u0627\ufe8e\u0644.\u0630\ufed5\u0647\ufee1(object3, Nmyswv.\ufe9d\ufea5\u062c\ufe8e((Object)this));
                    return \ufeed\ufebd\u0635\ufedd.\ufec1\ufef1\u0632\ufe8e(object3);
                }
                case 471: 
            }
            break;
        }
        object = new Tq();
        \u0646\ufecd\ufead\u0647.\u0637\ufee9\u062c\ufe95(object, \ufea9\ufe8f\u0647\ufead.\u0645\u064a\u0628\u062f(Nmyswv.\u0628\ufe8f\u0639\u064a(), string));
        \ufea9\u0643\u062d\u063a.\u0636\ufea5\u0630\ufeb5(object, 1);
        \ufe95\u0627\ufe8e\u0644.\u0630\ufed5\u0647\ufee1(object, Nmyswv.\ufe9d\ufea5\u062c\ufe8e((Object)this));
        return \ufeed\ufebd\u0635\ufedd.\ufec1\ufef1\u0632\ufe8e(object);
    }

    /*
     * Enabled aggressive block sorting
     */
    public String searchContent(String string, boolean bl) {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = \ufeed\ufebd\u0635\ufedd.\ufecd\u0636\ufea9\u0628(\u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(\u0635\u0631\u0645\u0628.\u0631\u063a\u0645\u0641(\ufebd\u0640\u0648\u062b.\u0646\ufed5\u0630\ufec9(\ufea9\ufe8f\u0647\ufead.\u0645\u064a\u0628\u062f(\ufea9\ufe8f\u0647\ufead.\u0645\u064a\u0628\u062f(Nmyswv.\u0628\ufe8f\u0639\u064a(), \u062d\ufeb9\ufeab\ufef1.\ufeed\u0638\u0635\ufed5(Nmyswv.\u0634\u0635\u062e\u062a(), 794, 27, 333)), string), Nmyswv.\ufe9d\ufea5\u062c\ufe8e((Object)this))), \u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(Nmyswv.\u0634\u0635\u062e\u062a(), 821, 21, 442)));
        block20: while (true) {
            bl = \ufe8e\u0627\ufecd\u062a.\u062f\u0638\ufe8e\ufe99(iterator);
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
                        hN hN2 = (hN)\ufea1\u0645\u062b\u0634.\ufe95\ufeaf\ufeb9\ufea1(iterator);
                        \u0641\ufeb5\ufeb1\ufee1.\ufedd\u0630\u0636\u0647(hN2);
                        string = \ufea5\u062d\ufebd\u0633.\ufe99\u0628\u0637\ufe9d(\ufeb5\ufe8e\ufead\u0632.\ufef1\ufeab\u062c\u0640(\u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(Nmyswv.\u0634\u0635\u062e\u062a(), 842, 3, 2850), hN2), \ufeb5\ufe8e\ufead\u0632.\ufe8f\ufef1\u0648\ufe95(Nmyswv.\u0634\u0635\u062e\u062a(), 845, 8, 477));
                        String string2 = \ufea5\u062d\ufebd\u0633.\ufe99\u0628\u0637\ufe9d(\ufeb5\ufe8e\ufead\u0632.\ufef1\ufeab\u062c\u0640(\ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(Nmyswv.\u0634\u0635\u062e\u062a(), 853, 1, 2542), hN2), \ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(Nmyswv.\u0634\u0635\u062e\u062a(), 854, 4, 2775));
                        String string3 = \ufee9\ufee1\u0627\u0641.\u062b\ufedd\ufeed\u062f(\ufeb5\ufe8e\ufead\u0632.\ufef1\ufeab\u062c\u0640(\u0630\ufebd\u0634\ufec9.\u0639\ufe8f\u064a\ufebd(Nmyswv.\u0634\u0635\u062e\u062a(), 858, 9, 1813), hN2));
                        bl = \u0635\u0631\u0645\u0628.\ufead\ufee9\u0643\u0632(string3);
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
                        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList, new Ef(string2, string3, string, \u062f\ufead\ufeaf\u062d.\u062c\u062e\ufe99\u062a(\u0633\u064a\u0644\u0637.\u0636\ufead\u062c\u0630(hN2, \ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(Nmyswv.\u0634\u0635\u062e\u062a(), 867, 26, 2014)))));
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

    private static long[] $d2j$hex$8fc3e890$decode_J(String src) {
        byte[] d = Nmyswv.$d2j$hex$8fc3e890$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$8fc3e890$decode_I(String src) {
        byte[] d = Nmyswv.$d2j$hex$8fc3e890$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$8fc3e890$decode_S(String src) {
        byte[] d = Nmyswv.$d2j$hex$8fc3e890$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$8fc3e890$decode_B(String src) {
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

