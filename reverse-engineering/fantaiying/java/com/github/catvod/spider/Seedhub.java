/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.github.catvod.crawler.SpiderDebug
 */
package com.github.catvod.spider;

import android.content.Context;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\u0645\u0641\u0630\u062d;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeab\u0632\u062f\u0640;
import com.github.catvod.parser.\ufeaf\u062b\ufed5\ufec1;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\ufec9\u0648\u062d;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.merge.oX;
import com.github.catvod.spider.merge.wg;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0641\u0631\ufeed\u0643;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee9\u0631\ufeb5\u0628;
import com.github.catvod.spider.merge.\ufee9\ufee1\u0627\u0641;
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufe99\u062c\u0643\ufec1;
import com.github.catvod.spider.\ufea5\u062d\ufebd\u0633;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import com.github.catvod.spider.\ufeaf\u0633\u0648\ufee9;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import com.github.catvod.spider.\ufeb5\ufe8e\ufead\u0632;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.HashMap;
import java.util.List;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class Seedhub
extends Pan {
    private static final short[] short = Seedhub.$d2j$hex$19ba351c$decode_S("f909e509e509e109e209ab09be09be09e209f409f409f509f909e409f309bf09e109e309fe09be09500342037503760375036203750362032d03b6021b0a3d0a2b0a3c0a630a0f0a290a2b0a200a3a0a2105160515051605010516050105340c280c2c0c3f0cc50bd60bc10bc50b5b06400621032c0325033003c201010124043d0436040d043c0433043f043704470c5e0c550c6e0c430c540c5c0c500c430c5a0c420c4b0a570a570a530a500a190a0c0a0c0a4a0a4e0a440a130a140a0d0a500a4c0a440a4c0a560a400a470a4d0a0d0a400a4c0a4e0a0c0a550a110a0c0a570a4b0a560a4e0a410a0c0a510a460a570a5a0a530a460a7c0a460a5b0a400a4f0a560a470a460a7c0a440a4a0a450a0c0a460a5b0a570a0c0a420a560a570a4c0a0c0a520a0c0a1a0a160a0c0a400a510a4c0a530a0c0a5b0a5a0a0c0a420a4a0a0c0a570a0c0a130a0c0a1c0a420a530a530a4a0a470a1e0a120a110a110a050a560a510a4f0a1e0a4b0a570a570a530a500a190a0c0a0c0a4c0a500a500a170a4f0a4a0a550a4a0a460a540a0d0a4e0a4c0a490a4a0a0d0a400a4c0a4e0a0c0a570a4b0a470a7c0a450a4a0a4f0a460a0c0a110a130a110a160a0c0a130a140a0c0a110a1b0a0c0a420a150a410a470a410a110a110a400a400a170a410a130a410a450a400a140a410a100a100a100a450a460a400a160a470a130a110a140a410a1a0a160a120a0d0a490a530a440a4b0a4a0a5b0af908e308f408f70819080408190801080808c906b808b508bc08a908bf08e308f001e501e301f701ab014e084c08590848084a0842085f08440848085e08020808085e08020808085e080208400842085b08440848085e08020812085d084c084a084808100808085e080b0842085f08490848085f08100808085e08920390038503940396039e038303980394038203de03d4038203de039c039e038703980394038203de03ce038103900396039403cc03d4038203d7039e038303950394038303cc03d4038203740b760b630b720b700b780b650b7e0b720b640b380b320b640b380b7a0b780b610b7e0b720b640b380b280b670b760b700b720b2a0b320b640b07020a0215024d0200020c021502060211024e0200020c020d02170202020a020d0206021102430207020a0215024d0200020c021502060211025f091e0957095309590990088908c50889088c086b8ece76740b520b5b0b580b500b510b460b2a073905810a8c0a930acb0a860a8a0a8b0a910a800a8b0a910adc0cd10cce0c960cdb0cd70cce0cdd0cca0c950cdb0cd70cd60ccc0cd90cd10cd60cdd0cca0c980cd10cd50cdf0cf405e102ec02f302ab02e602ea02f302e002f702a802e602ea02eb02f102e402ec02eb02e002f702a502f002e902a502e902ec0294577c639348bc69e67b16509d59ec79565d1d50840b9b5c9158759f4e623a082308280813083c0825082f0837042e0425041e043804240420043304980781078a07b1078f078d079a0781079c074a0a530a580a630a580a550a4e0a590a5f0a480a530a4e0a390920092b0910092e093d092a092e09780875087c086908530862086d0861086908f903e003eb03d003ec03e003e103fb03ea03e103fb0326062b0634066c0621062d062c06360627062c06360662062c06230634066c062c06230634066f062e062b062c0629063106620626062b0634066c062c06230634066f062b06360627062f066206230606040b0414044c0401040d040c04160407040c041604420417040e044c04120403040c044f040e040b040c040904110442040e040b0442040304bf03b203ad03f503b803b403b503af03be03b503af03fb03ae03b703f503a803be03be03bf03a803fb03b703b2031508150815083f0b3a0b2f0b3a0b760b370b320b350b300be602ea02e102e0020107010701076652155a68033c5d327690539e78800acb08d708d708d308d00899088c088c08ca08ce08c408930894088d08d008cc08c408cc08d608c008c708cd088d08c008cc08ce088c08d50891088c08d708cb08d608ce08c1088c08d108c608d708da08d308c608fc08c608db08c008cf08d608c708c608fc08c408ca08c5088c08c608db08d7088c08c208d608d708cc088c08d2088c089a0896088c08c008d108cc08d3088c08db08da088c08c208ca088c08d7088c0893088c089c08c208d308d308ca08c7089e089208910891088508d608d108cf089e08cb08d708d708d308d00899088c088c08d00892088d08ca08ce08c208c408c608cb08d608c1088d08c008c0088c08ca08ce08c208c408c608d0088c0891089308910897088c08920892088c08930895088c08c708c5089008c508c1089708c7089408930893089a0890089b089008c7089008c2089a089608c008c608c508950895089a089b08c0089b089a089108930893088d08c908d308c408f67d2e550f500f50c057c057f7019e098209820986098509cc09d909d9099f099b099109c609c109d80985099909910999098309950992099809d809950999099b09d9098009c409d90982099e0983099b099409d9098409930982098f0986099309a90993098e0995099a09830992099309a90991099f099009d90993098e098209d9099709830982099909d9098709d909cf09c309d9099509840999098609d9098e098f09d90997099f09d9098209d909c609d909c9099709860986099f099209cb09c709c409c409d009830984099a09cb099e098209820986098509cc09d909d9098509c709d8099f099b099709910993099e0983099409d80995099509d9099f099b099709910993098509d909c409c609c409c009d909c609c209d909c609c109d9099709ce09c209c4099209cf09c609c609c609c509ce09c20997099509c609940994099009c209c3099009c309c309920993099409c509c209c2099709cf099309d8099c0986099109e703f103ce49866a1e4b56682e0441065d065d0659065a06130606060606400644064e0619061e0607065a0646064e0646065c064a064d06470607064a064606440606065f061b0606065d0641065c0644064b0606065b064c065d06500659064c0676064c0651064a0645065c064d064c0676064e0640064f0606064c0651065d06060648065c065d06460606065806060610061c0606064a065b064606590606065106500606064806400606065d06060619060606160648065906590640064d06140618061b061b060f065c065b064506140641065d065d0659065a061306060606065a06180607064006440648064e064c0641065c064b0607064a064a0606064006440648064e064c065a0606061b0619061b061d06060618061806060619061e0606061c064d061a064d061d061a064c061c061f061906190611061d061d061c061f064b0618064c064b064a061c0648064f06110648061a061b064f064f064b061f060706590647064e06f19502926490a374ed9f2a7bfa095a09460946094209410908091d091d095b095f095509020905091c0941095d0955095d094709510956095c091c0951095d095f091d09440900091d0946095a0947095f0950091d094009570946094b09420957096d0957094a0951095e094709560957096d0955095b0954091d0957094a0946091d095309470946095d091d0943091d090b0907091d09510940095d0942091d094a094b091d0953095b091d0946091d0902091d090d095309420942095b0956090f090309000900091409470940095e090f095a09460946094209410908091d091d09410903091c095b095f095309550957095a09470950091c09510951091d095b095f0953095509570941091d0900090209000906091d09030903091d09020904091d090109030956090a09540954090209050901095709060906095609040904090b090109540950095009510954095009570904090b095609020953090509020901091c09580942095509c806cd06d706d0066a0473047804430475047804420b470b400b450b710b5d0b5a0b4f0b5c0b5a0b74061d080c080308320804080908ae01a201a301be01b901ed01a901ac01b901ac01ed01f001ed01ef01e501e301e701f201e401ef01590a4e0a5d0a0f0a5f0a4e0a410a630a460a410a440a0f0a120a0f0a0d0a070a010a050a100a060a0d0a8204300429042204190436042a0427043f041904330434042a04c902d002db02e002cf02d302de02c602e002d902cd02d002d2025f095f095f091758f78f6c93986143741387cd53b46fc605cb03c803a9039b03cb03c8039b03a703cb03cb038f03bb03cb03a403b1039203cb03a403b1039203cb03b2038b038d030706cf768b5c0002875a269ed6068c500f6d260c2b0c340c6c0c210c2d0c340c270c300c6f0c210c2d0c2c0c360c230c2b0c2c0c270c300c620c260c2b0c340c6c0c210c2d0c340c270c300c37032a0337032f0326030a0b4b0b020b060b0c0bd202d302c2026c0875083908750870085784f27c41095b094c094f097c065a0653065006580659064e0625032303c30c51020d02070251020d0241094c0953090b0946094a09530940095709080946094a094b09510944094c094b0940095709050941094c0953090b0946094a095309400957098c0791078c0794079d074a090b09420946094c0994079507840793018a01c6018a018f011d8db87517050d051a051905210407040e040d04050404041304");
    private CacheData Dr;
    private String O = \ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(short, 0, 20, 2449);
    private CacheData Zm;
    private String b;
    private CacheData g;
    private String g1 = "";
    private String n = "";
    private String s = "";
    private String un = "";

    /*
     * Enabled aggressive block sorting
     */
    public Seedhub() {
        int n = \ufeaf\u0633\u0648\ufee9.\u0641\u062b\u062d\ufeed();
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
                    Float f = Float.valueOf(\u0646\ufecd\ufead\u0647.\ufe8f\ufed9\ufeaf\u0639("0ANzl9uZgD0h"));
                    System.out.println(f);
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
    private String B(String string, String string2, String string3) {
        boolean bl = string.equals(this.g1);
        int n = 1616;
        block18: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block18;
                }
                case 49: {
                    if (!bl) {
                        n = 1709;
                        continue block18;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block18;
                }
                case 204: {
                    this.g1 = string;
                    this.un = string;
                    return string;
                }
                case 239: 
            }
            break;
        }
        bl = string2.equals(this.s);
        n = 1740;
        block19: while (true) {
            switch (n ^= 0x6DD) {
                default: {
                    continue block19;
                }
                case 17: {
                    if (!bl) {
                        n = 1833;
                        continue block19;
                    }
                }
                case 54: {
                    n = 1802;
                    continue block19;
                }
                case 500: {
                    this.s = string2;
                    this.un = string2;
                    return string2;
                }
                case 471: 
            }
            break;
        }
        bl = string3.equals(this.n);
        n = 1864;
        block20: while (true) {
            switch (n ^= 0x759) {
                default: {
                    continue block20;
                }
                case 17: {
                    if (!bl) {
                        n = 48736;
                        continue block20;
                    }
                }
                case 47483: {
                    n = 48705;
                    continue block20;
                }
                case 47417: {
                    this.n = string3;
                    this.un = string3;
                    return string3;
                }
                case 47384: 
            }
            break;
        }
        return "";
    }

    private String G(String string) {
        String string2 = "\u06e6\u06e4";
        StringBuilder stringBuilder = null;
        short[] sArray = null;
        String string3 = null;
        int n = 0;
        String string4 = string;
        string = string2;
        block12: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    string3 = \ufea9\u0643\u062d\u063a.\ufea1\u0633\ufe8e\u0627(sArray, 20, 9, 784);
                    string = "\u06e2\u06e3\u06e1";
                    continue block12;
                }
                case 1746877: {
                    stringBuilder.append(string3);
                    string = "\u06e1\u06e2\u06e3";
                    continue block12;
                }
                case 1748706: {
                    string4 = stringBuilder.toString();
                    string = "\u06e1\u06e8\u06e8";
                    continue block12;
                }
                case 1749696: {
                    stringBuilder = oX.yq(string4, string3);
                    string = "\u06e0\u06e0\u06e7";
                    continue block12;
                }
                case 1748800: {
                    string3 = \ufeb9\ufec9\u0648\u062d.\ufee9\u0637\ufef1\u0644(sArray, 29, 1, 665);
                    string = "\u06e2\u06df\u06e4";
                    continue block12;
                }
                case 1754384: {
                    string3 = string4.substring(0, n);
                    string = "\u06df\u06e5\u06e3";
                    continue block12;
                }
                case 1747687: {
                    string4 = this.O;
                    string = "\u06e6\u06e1\u06e2";
                    continue block12;
                }
                case 1753479: {
                    sArray = short;
                    string = "\u06e1\u06e5\u06e4";
                    continue block12;
                }
                case 1749575: {
                    n = string4.lastIndexOf(string3);
                    string = "\u06e7\u06df\u06e8";
                    continue block12;
                }
                case 56510: {
                    sArray = short;
                    string = "\u06e6\u06e0\u06e6";
                    continue block12;
                }
                case 0x1AAFA1: 
            }
            break;
        }
        return string4;
    }

    private HashMap<String, String> q() {
        String string = "\u06df\u06e7\u06e1";
        HashMap<String, String> hashMap = null;
        short[] sArray = null;
        String string2 = null;
        String string3 = null;
        block11: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    sArray = short;
                    string = "\u06e5\u06e8\u06e0";
                    continue block11;
                }
                case 1746937: {
                    hashMap = new HashMap<String, String>();
                    string = "\u06e8\u06e4\u06e1";
                    continue block11;
                }
                case 1752733: {
                    string3 = \u062d\ufeb9\ufeab\ufef1.\ufeed\u0638\u0635\ufed5(sArray, 40, 7, 1395);
                    string = "\u06e3\u06e7\u06e4";
                    continue block11;
                }
                case 1750787: {
                    string2 = this.O;
                    string = "\u06e6\u06e1\u06e6";
                    continue block11;
                }
                case 1750784: {
                    hashMap.put(string3, string2);
                    string = "\u06e5\u06e0\u06e6";
                    continue block11;
                }
                case 1750753: {
                    string2 = \ufeb9\ufec9\u0648\u062d.\ufee9\u0637\ufef1\u0644(sArray, 30, 10, 2638);
                    string = "\u06e2\u06e3\u06e7";
                    continue block11;
                }
                case 1749702: {
                    hashMap.put(string2, string3);
                    string = "\u06e3\u06e7\u06e7";
                    continue block11;
                }
                case 1747719: {
                    sArray = short;
                    string = "\u06e3\u06e6\u06e4";
                    continue block11;
                }
                case 1755493: {
                    string3 = wg.N();
                    string = "\u06e0\u06e1\u06e8";
                    continue block11;
                }
                case 1752491: 
            }
            break;
        }
        return hashMap;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u062a\u0648\u0632\ufe8e(Object object, Object object2) {
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
                    return ((Seedhub)((Object)object)).G((String)object2);
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
    public static String \u062a\ufe8e\ufec5\ufecd(Object object) {
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
                    return ((CacheData)object).getPg();
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
    public static void \u062b\u063a\u062a\ufeb5(Object object, Object object2) {
        int n = \ufeaf\u062b\ufed5\ufec1.\ufeb9\ufee1\ufe8e\u064a();
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
                    ((CacheData)object).setTypeOnly((String)object2);
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
    public static void \u062b\ufead\ufe8e\u063a(Object object, Object object2) {
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
                    ((CacheData)object).setBy((String)object2);
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
    public static String \u062e\ufee9\u062b\u0641(Object object) {
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
                    return ((CacheData)object).getTypeOnly();
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
    public static String \u062f\ufea9\u0635\u0646(Object object) {
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
                    return ((Seedhub)((Object)object)).O;
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
    public static CacheData \u0630\ufe8f\ufec9\u0637(Object object) {
        int n = \u062a\ufee1\ufe8e\ufeb9.\u062e\ufeb9\u0644\ufedd();
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
                    return ((Seedhub)((Object)object)).g;
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
    public static String \u0631\ufec1\u062b\u0636(Object object) {
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
                    return ((CacheData)object).getId();
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
    public static void \u0642\u0634\ufed9\ufed5(Object var0, Object var1_1) {
        var3_2 = \u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634();
        var2_3 = 1616;
        block16: while (true) {
            switch (var2_3 ^= 1633) {
                default: {
                    continue block16;
                }
lbl7:
                // 2 sources

                case 14: {
                    var2_3 = 1678;
                    continue block16;
                }
                case 49: {
                    if (var3_2 > 0) ** GOTO lbl7
                    var2_3 = 1709;
                    continue block16;
                }
                case 204: {
                    ((CacheData)var0).setId((String)var1_1);
lbl16:
                    // 2 sources

                    while (true) {
                        var3_2 = \ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5();
                        var2_3 = 1740;
                        block19: while (true) {
                            switch (var2_3 ^= 1757) {
                                default: {
                                    continue block19;
                                }
                                case 17: {
                                    if (var3_2 <= 0) {
                                        var2_3 = 1833;
                                        continue block19;
                                    }
                                }
                                case 54: {
                                    var2_3 = 1802;
                                    continue block19;
                                }
                                case 500: {
                                    var0 = Float.valueOf(\u0641\u0631\ufeed\u0643.\u062b\ufed9\ufeb1\u0632("Ka1ZdpnlI2VFJ0K8MZ0"));
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
        var2_3 = 1864;
        block20: while (true) {
            switch (var2_3 ^= 1881) {
                case 47483: {
                    ** continue;
                }
                default: {
                    continue block20;
                }
                case 17: 
            }
            var2_3 = 48674;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0642\u0646\u0627\u0633(Object object) {
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
                    return ((CacheData)object).getBy();
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
    public static CacheData \u0645\u062e\ufea5\u062c(Object object) {
        int n = \u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead();
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
                    return ((Seedhub)((Object)object)).Dr;
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
    public static String \u064a\ufecd\u063a\u062f(Object object) {
        int n = \ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635();
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
                    return ((CacheData)object).getData();
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
    public static void \ufe8e\u0643\ufeaf\u0631(Object var0, Object var1_1) {
        var3_2 = \ufea5\u062d\ufebd\u0633.\u0645\ufe95\u0647\ufec1();
        var2_3 = 1616;
        block16: while (true) {
            switch (var2_3 ^= 1633) {
                default: {
                    continue block16;
                }
lbl7:
                // 2 sources

                case 14: {
                    var2_3 = 1678;
                    continue block16;
                }
                case 49: {
                    if (var3_2 > 0) ** GOTO lbl7
                    var2_3 = 1709;
                    continue block16;
                }
                case 204: {
                    ((CacheData)var0).setPg((String)var1_1);
lbl16:
                    // 2 sources

                    while (true) {
                        var3_2 = \ufecd\u0642\u062e\ufe9d.\u0634\u063a\u0628\ufeb9();
                        var2_3 = 1740;
                        block19: while (true) {
                            switch (var2_3 ^= 1757) {
                                default: {
                                    continue block19;
                                }
                                case 17: {
                                    if (var3_2 <= 0) {
                                        var2_3 = 1833;
                                        continue block19;
                                    }
                                }
                                case 54: {
                                    var2_3 = 1802;
                                    continue block19;
                                }
                                case 500: {
                                    var0 = Float.decode((String)\ufea9\ufe8f\u0647\ufead.\u062a\ufee9\u0628\ufec5("aVoneYtVRNWN8zjiX7"));
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
        var2_3 = 1864;
        block20: while (true) {
            switch (var2_3 ^= 1881) {
                case 47483: {
                    ** continue;
                }
                default: {
                    continue block20;
                }
                case 17: 
            }
            var2_3 = 48674;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \ufe8f\ufeab\u0642\u0627(Object object, Object object2, Object object3, Object object4) {
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
                    return ((Seedhub)((Object)object)).B((String)object2, (String)object3, (String)object4);
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
    public static short[] \ufe95\ufe99\u062a\ufea5() {
        int n = \ufeaf\u0633\u0648\ufee9.\u0641\u062b\u062d\ufeed();
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
     * Enabled aggressive block sorting
     */
    public static HashMap \ufe99\u063a\u0631\u062a(Object hashMap) {
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
                    return ((Seedhub)((Object)hashMap)).q();
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
    public static String \ufe9d\ufee1\ufeb1\u0632(Object object) {
        int n = \ufed9\ufe9d\ufeed\ufeb5.\ufedd\ufeaf\ufec9\u0646();
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
                    return ((Seedhub)((Object)object)).b;
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
    public static void \ufeab\u0644\ufe95\ufec5(Object var0) {
        var3_1 = \ufeb5\ufe8e\ufead\u0632.\ufe95\u0647\u062d\u0631();
        var2_2 = 1616;
        block16: while (true) {
            switch (var2_2 ^= 1633) {
                default: {
                    continue block16;
                }
lbl7:
                // 2 sources

                case 14: {
                    var2_2 = 1678;
                    continue block16;
                }
                case 49: {
                    if (var3_1 > 0) ** GOTO lbl7
                    var2_2 = 1709;
                    continue block16;
                }
                case 204: {
                    SpiderDebug.log((Throwable)((Throwable)var0));
lbl16:
                    // 2 sources

                    while (true) {
                        var3_1 = \ufeb9\ufec9\u0648\u062d.\u063a\u064a\ufed9\ufe8f();
                        var2_2 = 1740;
                        block19: while (true) {
                            switch (var2_2 ^= 1757) {
                                default: {
                                    continue block19;
                                }
                                case 17: {
                                    if (var3_1 <= 0) {
                                        var2_2 = 1833;
                                        continue block19;
                                    }
                                }
                                case 54: {
                                    var2_2 = 1802;
                                    continue block19;
                                }
                                case 500: {
                                    var1_3 = Float.parseFloat(\ufee9\ufee1\u0627\u0641.\u0644\ufef1\u0643\u0631("WJYUYoz3V0HJvePRLu5vM"));
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
        var2_2 = 1864;
        block20: while (true) {
            switch (var2_2 ^= 1881) {
                case 47483: {
                    ** continue;
                }
                default: {
                    continue block20;
                }
                case 17: 
            }
            var2_2 = 48674;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \ufeb9\u0633\u064a\u062a(Object object) {
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
                    return ((Seedhub)((Object)object)).un;
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
    public static CacheData \ufecd\ufea5\u0637\u0635(Object object) {
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
                    return ((Seedhub)((Object)object)).Zm;
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
    public static void \ufeed\ufea5\u0634\ufecd(Object object, Object object2) {
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
                    ((CacheData)object).setData((String)object2);
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
     * Exception decompiling
     */
    public String categoryContent(String var1_1, String var2_3, boolean var3_5, HashMap<String, String> var4_6) {
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
    @Override
    public String detailContent(List<String> var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [28[CASE]], but top level block is 30[SWITCH]
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
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [39[CASE]], but top level block is 7[TRYBLOCK]
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
    @Override
    public void init(Context context, String string) {
        block7: {
            int n;
            try {
                this.b = string;
                n = 1616;
            }
            catch (Exception exception) {
                InitOrigin.show("");
                break block7;
            }
            block6: while (true) {
                switch (n ^= 0x661) {
                    default: {
                        continue block6;
                    }
                    case 14: {
                        break block6;
                    }
                    case 49: {
                        n = 1647;
                        continue block6;
                    }
                }
                break;
            }
        }
        super.init(context, \ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(short, 1629, 2, 862));
    }

    /*
     * Exception decompiling
     */
    public String searchContent(String var1_1, boolean var2_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [25[CASE]], but top level block is 5[TRYBLOCK]
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

    private static long[] $d2j$hex$19ba351c$decode_J(String src) {
        byte[] d = Seedhub.$d2j$hex$19ba351c$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$19ba351c$decode_I(String src) {
        byte[] d = Seedhub.$d2j$hex$19ba351c$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$19ba351c$decode_S(String src) {
        byte[] d = Seedhub.$d2j$hex$19ba351c$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$19ba351c$decode_B(String src) {
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

    private class CacheData {
        private String N;
        private String SN;
        private String tF;
        private String yq;
        private String zH;

        /*
         * Enabled aggressive block sorting
         */
        CacheData() {
            int n = \ufe99\u062c\u0643\ufec1.\ufec5\ufee9\ufe8e\ufea1();
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
                        Integer n3 = Integer.decode(\ufe95\u0627\ufe8e\u0644.\u0648\ufea5\ufeb1\ufec5("de4xcmtEGomVKQB"));
                        System.out.println(n3);
                        return;
                    }
                    case 239: 
                }
                break;
            }
        }

        public String getBy() {
            return this.tF;
        }

        public String getData() {
            return this.SN;
        }

        public String getId() {
            return this.yq;
        }

        public String getPg() {
            return this.N;
        }

        public String getTypeOnly() {
            return this.zH;
        }

        /*
         * Enabled aggressive block sorting
         */
        public void setBy(String string) {
            this.tF = string;
            int n = \u0631\ufea1\u0638\u0627.\u0627\u0648\ufecd\ufee9();
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
                        long l = Long.parseLong(\ufeaf\u0633\u0648\ufee9.\u0637\u0644\u0643\ufeab("VOtbQV6u8aT2bBwTgAtDone75cZ1K"));
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
        public void setData(String string) {
            this.SN = string;
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
                        double d = Double.parseDouble(\u062a\u0635\ufeb1\u0642.\ufebd\u0635\u0628\ufee1("11DXkLr"));
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
        public void setId(String object) {
            this.yq = object;
            int n = \ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635();
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
                        object = Float.valueOf(\ufea5\u062d\ufebd\u0633.\ufecd\ufe99\u0634\ufec9("SbhHgPewoOyN3g"));
                        System.out.println(object);
                        return;
                    }
                    case 239: 
                }
                break;
            }
        }

        public void setPg(String string) {
            this.N = string;
        }

        public void setTypeOnly(String string) {
            this.zH = string;
        }
    }
}

