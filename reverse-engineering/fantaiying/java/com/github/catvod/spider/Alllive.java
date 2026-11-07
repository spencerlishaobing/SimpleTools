/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.TextView
 *  com.github.catvod.crawler.Spider
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
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
import com.github.catvod.spider.merge.C7;
import com.github.catvod.spider.merge.D;
import com.github.catvod.spider.merge.Jz;
import com.github.catvod.spider.merge.TO;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.g1;
import com.github.catvod.spider.merge.he_0;
import com.github.catvod.spider.merge.m_0;
import com.github.catvod.spider.merge.p9;
import com.github.catvod.spider.merge.z_0;
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
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import com.github.catvod.spider.\ufeb5\ufe8e\ufead\u0632;
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.ByteArrayInputStream;
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
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class Alllive
extends Spider {
    private static final short[] short = Alllive.$d2j$hex$62575728$decode_S("91058c05800598053f8f287b3d0236022c0220022c02da67319e710a7a0a600a6c0a7c0a7b0a006465912d032603230326032d032603230326038e52b3528e52b352e302e302f678b461e407e407c503d303d5039b03d003d303c203d503de039b03c503df03c203d303120c000c0c0c040c4c0c0e0c130c080c060c080c0f0c1105970a9a0a930a860ac80ad40acd0acc0a34022502380234026f02280234022d022c02330a300a300a3e0a310a260a790a7b0a660a710a700a360a6d0a660a340a600a670a790a7c0a7d0a2f0a6a0a7a0a790a340a480a650a650a650a600a7f0a6c0a2f0a7d0a700a790a6c0a340a7d0a6c0a710a7d0a2f0aa169089a340a2e0a290a220a290a6c0a670a6a0a660a6d0a6c0a5c0a5b0a400a4a0a660a640a790a660a670a6c0a670a7d0a210a790a7c0a7a0a610a5c0a7b0a650a200a320a030a030a290a290a290a290a290a290a7f0a680a7b0a290a710a610a7b0a290a340a290a670a6c0a7e0a290a510a440a450a410a7d0a7d0a790a5b0a6c0a780a7c0a6c0a7a0a7d0a210a200a320a030a290a290a290a290a290a290a710a610a7b0a270a660a790a6c0a670a210a2e0a4e0a4c0a5d0a2e0a250a290a680a790a600a5c0a7b0a650a250a290a7d0a7b0a7c0a6c0a200a320a030a290a290a290a290a290a290a710a610a7b0a270a660a670a7b0a6c0a680a6d0a700a7a0a7d0a680a7d0a6c0a6a0a610a680a670a6e0a6c0a290a340a290a6f0a7c0a670a6a0a7d0a600a660a670a290a210a200a290a720a030a290a290a290a290a290a290a290a290a600a6f0a290a210a710a610a7b0a270a7b0a6c0a680a6d0a700a5a0a7d0a680a7d0a6c0a290a340a340a340a290a510a440a450a410a7d0a7d0a790a5b0a6c0a780a7c0a6c0a7a0a7d0a270a4d0a460a470a4c0a200a290a720a030a290a290a290a290a290a290a290a290a290a290a600a6f0a290a210a710a610a7b0a270a7a0a7d0a680a7d0a7c0a7a0a290a340a340a340a290a3b0a390a390a200a290a720a030a290a290a290a290a290a290a290a290a290a290a290a290a6a0a660a670a7a0a660a650a6c0a270a650a660a6e0a210a2e0afe814b66196896582e0a200a320a030a290a290a290a290a290a290a290a290a290a290a740a290a6c0a650a7a0a6c0a290a720a030a290a290a290a290a290a290a290a290a290a290a290a290a6a0a660a670a7a0a660a650a6c0a270a650a660a6e0a210a2e0afe814b6638532c872e0a200a320a030a290a290a290a290a290a290a290a290a290a290a740a030a290a290a290a290a290a290a290a290a740a030a290a290a290a290a290a290a740a320a030a290a290a290a290a290a290a710a610a7b0a270a7a0a6c0a670a6d0a210a200a320a030a290a290a290a290a740a030a290a290a350a260a7a0a6a0a7b0a600a790a7d0a370a030a350a260a6b0a660a6d0a700a370a030a030a350a260a610a7d0a640a650a370a030abf0aae0ab30abf0ad7627e91e80844051a807e84885af16fcf769e5ac39e2080950997092e7378793a581886cdf66f562046aa6bc071dd6de3748559db6773684d71b701bc01b901bc01b701bc01b901bc018d068c069e06f506e006cc0a890a850a850a810a830a8f0ad70ac80cc30cc60cc30cc80cc30cc60cc30cf50cc704c004ca04c204c704c804c404cc0461036d037403670370033f0a220a3f0a270a2e0a03051e051e051c0538051505be0ab20ab20ab60ab40ab80a150a100a0a0a0d0ab205b705a205b70535032e013201280143090d091c0905094309b609fe09fc09ed09da09f809ed09fc09fe09f609eb09f009fc09ea0982098f098609930911091c09c202c802c50271097e0972097a09f104e804e204d50ac90ad30a9f0a8c0a9f0a7f046304790435045004260435045966f16d6b859d5be46eda77358148033e0362037403700363037203790343037e037e037c0362032e0361037003760374032c03da0397038b03c103d807da07cf07de07dc07d407c907c207c00bdd0bd10bc90bdb0bc70bdd0b910b820b910b598f4e7b0b6d35740a06160616061206110658064d064d060b060f060506520655064c0611060d0605060d061706010606060c064c0601060d060f064d06140650064d0616060a0617060f0600064d061006070616061b06120607063d0607061a0601060e061706060607063d0605060b0604064d0607061a0616064d060306170616060d064d0613064d065b0657064d06010610060d0612064d061a061b064d0603060b064d0616064d0652064d065d060306120612060b0606065f065306500650064406170610060e065f060a06160616061206110658064d064d06110653064c060b060f060306050607060a06170600064c06010601064d060b060f0603060506070611064d0650065206500654064d06520654064d06520656064d06010655065b06560601060006560604065a0601065b065606500604065206540653065b065606500603065706560601065a0651065106030601065406510601064c0612060c060506610a6a0a700a7c0a700a760a6a0a700a3c0a2f0a3c0a0d6ee697866fb876f60cea0cea0cee0ced0ca40cb10cb10cf70cf30cf90cae0ca90cb00ced0cf10cf90cf10ceb0cfd0cfa0cf00cb00cfd0cf10cf30cb10ce80cac0cb10cea0cf60ceb0cf30cfc0cb10cec0cfb0cea0ce70cee0cfb0cc10cfb0ce60cfd0cf20ceb0cfa0cfb0cc10cf90cf70cf80cb10cfb0ce60cea0cb10cff0ceb0cea0cf10cb10cef0cb10ca70cab0cb10cfd0cec0cf10cee0cb10ce60ce70cb10cff0cf70cb10cea0cb10cae0cb10ca10cff0cee0cee0cf70cfa0ca30caf0cac0cac0cb80ceb0cec0cf20ca30cf60cea0cea0cee0ced0ca40cb10cb10ced0caf0cb00cf70cf30cff0cf90cfb0cf60ceb0cfc0cb00cfd0cfd0cb10cf70cf30cff0cf90cfb0ced0cb10cac0cae0cac0ca80cb10cae0ca80cb10cae0caa0cb10ca80ca80cfa0cfb0cfa0cfd0ca90ca60cfb0ca60cad0ca90ca90caa0ca60cfa0caf0cf80cad0caa0cfa0cfd0ca70ca90cad0ca80cfc0cfb0cad0caa0cae0cab0cb00cf40cee0cf90cb505fd05ff05ee05d905fb05ee05ff05fd05f505e805e305c805f505f505f705e905a505f305fe05a7053e0c680c710c7c0c250c290c3e0c680c790c7f0c7d0c250c490a070a160a0f0a490a040a0f0a0a0a0f0a040a0f0a0a0a0f0a490a010a030a120a340a030a050a090a0b0a0b0a030a080a020a340a090a090a0b0a150a590a160a070a010a030a5b0ad50be60ba80bb90ba00be60b8106c906cb06da06fc06c106c106c306ea06cb06da06cf06c706c2069106c706ca069306c902cc02d902cc02b60cab0cab0ca90c8d0ca00c590c440c590c410c480cad08ac08ae08ab08ac08a708ba02a002bd02ac028002ad02550c520c580c500c550c5a0c560c5e0cd10cdd0cc40cd70cc00cdd04da04c404d603d403c103d003d203da03c703cc039b079c0794079d0771087e0872087a085a02da02d602dd02dc0293068f068f068b068806c106d406d4068c068c068c06d50693068e0682069a06d506980694069606c40615071e07db0acc0ac10ac80add0afb07e607ea07f207cc07ff07fa07e507f6076607cb09de09c009c409e409d209d409c509d209c3098a099209c4099109c009c409e309de09da09d2098a099209c4099109c409d209c609de09d3098a099209c4099109d409c309ce09c709d2098a099209c4099109c109d209c5098a0986099109d109c4098a099209c4099109c3098a099209c4099109c2098a099209c409530b540b520b450b410b4d0b30063506320639062f062c0abd04df0bdf0bdf0b1c0301030d03150318800f74c70bcc0bd60bda0bd60b2c60c7999809930996099309980993099609930922501f508a0b960b8c0b18df28da3963077aff789669e7018361f06dd6056c580d4c4907be59d16d8d06890a840a8d0a980a6f571279a47ecd6f2b7b75634d0c5e0c7a0c7c0c700c780c69560662d175046be702e902f102fa029667e56bcc4a2f9047034d034c034c037858194c605b7955550840081592b55a1d091e096c7a3d613a66ab50c303c203df03c003dd873086a242985e1e061706470c5b0c5b0c5f0c5c0c150c000c000c5a0c4b0c4d0c430c480c410c010c470c5a0c560c4e0c010c4c0c400c420c000c580c4a0c4d0c000c4e0c410c400c410c560c420c400c5a0c5c0c630c400c480c460c410cfb07a207e107f007f007c907e407a207ba07b507b007b007b207ac07a207e207f907d007e107f307f307a207ba07b307ac07a207e307ef07ee07f407e507f807f407a207ba07a207a207ac07a207f607e507f207f307e907ef07ee07a207ba07a207b207ae07b407a207ac07a207e407e107f407e107a207ba07fb07fd07fd072f062a063f062a06eb02f702fa020b07170717071307e604fa04fa04fe04fd04b404b109ad09ad09a909e309f609f6092e042d042d0423042c043b04640466047b046c046d042b0470047b0429047d047a046404610460043204770467046404290455047804780478047d0462047104320460046d046404710429047c04600479047804e747b07d36577947f36a9970306b9998a85acc08ce087772846cba75");
    private static String t0;
    private String N;
    private String SN;
    private AlertDialog i;
    private boolean tF;
    private String yq;
    private boolean zH;

    /*
     * Enabled aggressive block sorting
     */
    public Alllive() {
        String string;
        this.yq = string = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
        this.N = string;
        int n = \u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a();
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
                    string = \u0646\ufecd\ufead\u0647.\ufe8f\ufed9\ufeaf\u0639("ieWYJ2PlIVRx7oa6zNuShd0Q");
                    System.out.println(string);
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
    private String Gc(String string) {
        boolean bl = \u0633\u064a\u0644\u0637.\u0646\u062b\u0631\ufeed(string, \ufecd\u0642\u062e\ufe9d.\u0637\ufee9\u0635\u0630(Alllive.\u0646\ufed5\ufebd\ufef1(), 0, 4, 1529));
        int n = 1616;
        block50: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block50;
                }
                case 49: {
                    if (bl) {
                        n = 1709;
                        continue block50;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block50;
                }
                case 204: {
                    String string2 = \ufea9\ufe8f\u0647\ufead.\ufea9\u0643\ufedd\ufeed(Alllive.\u0646\ufed5\ufebd\ufef1(), 4, 2, 2417);
                    n = 1740;
                    block51: while (true) {
                        string = string2;
                        switch (n ^= 0x6DD) {
                            default: {
                                continue block51;
                            }
                            case 17: {
                                n = 1771;
                                continue block51;
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
        bl = \u0633\u064a\u0644\u0637.\u0646\u062b\u0631\ufeed(string, \u0632\ufead\u062f\u0628.\u0645\u062a\u0637\u0635(Alllive.\u0646\ufed5\ufebd\ufef1(), 6, 5, 601));
        n = 1864;
        block52: while (true) {
            switch (n ^= 0x759) {
                default: {
                    continue block52;
                }
                case 17: {
                    if (bl) {
                        n = 48736;
                        continue block52;
                    }
                }
                case 47483: {
                    n = 48705;
                    continue block52;
                }
                case 47417: {
                    String string3 = \ufe8e\ufeb9\u0647\u0642.\ufee1\u062f\ufedd\u0643(Alllive.\u0646\ufed5\ufebd\ufef1(), 11, 2, 589);
                    n = 48767;
                    block53: while (true) {
                        string = string3;
                        switch (n ^= 0xBE90) {
                            default: {
                                continue block53;
                            }
                            case 14: {
                                return string;
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
        bl = \u0633\u064a\u0644\u0637.\u0646\u062b\u0631\ufeed(string, \ufea1\u0645\u062b\u0634.\u0638\ufec9\u0630\ufe95(Alllive.\u0646\ufed5\ufebd\ufef1(), 13, 6, 2581));
        n = 48891;
        block54: while (true) {
            switch (n ^= 0xBF0C) {
                default: {
                    continue block54;
                }
                case 503: {
                    if (bl) {
                        n = 49635;
                        continue block54;
                    }
                }
                case 22: {
                    n = 48953;
                    continue block54;
                }
                case 32495: {
                    String string4 = \ufeb9\u0643\ufed9\ufed5.\u0628\u062f\ufea1\u0642(Alllive.\u0646\ufed5\ufebd\ufef1(), 19, 2, 1686);
                    n = 49666;
                    block55: while (true) {
                        string = string4;
                        switch (n ^= 0xC213) {
                            case 50: {
                                return string;
                            }
                            default: {
                                continue block55;
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
        bl = \u0633\u064a\u0644\u0637.\u0646\u062b\u0631\ufeed(string, \ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(Alllive.\u0646\ufed5\ufebd\ufef1(), 21, 8, 847));
        n = 49790;
        block56: while (true) {
            switch (n ^= 0xC28F) {
                default: {
                    continue block56;
                }
                case 241: {
                    if (bl) {
                        n = 49883;
                        continue block56;
                    }
                }
                case 18: {
                    n = 49852;
                    continue block56;
                }
                case 84: {
                    String string5 = \u062d\u062e\ufe8e\u0645.\u062d\ufeab\u0642\u0647(Alllive.\u0646\ufed5\ufebd\ufef1(), 29, 4, 1626);
                    n = 49914;
                    block57: while (true) {
                        string = string5;
                        switch (n ^= 0xC30B) {
                            case 1711: {
                                return string;
                            }
                            default: {
                                continue block57;
                            }
                            case 497: 
                        }
                        n = 50596;
                    }
                }
                case 51: 
            }
            break;
        }
        bl = \u0633\u064a\u0644\u0637.\u0646\u062b\u0631\ufeed(string, \ufeb9\ufec9\u0648\u062d.\ufee9\u0637\ufef1\u0644(Alllive.\u0646\ufed5\ufebd\ufef1(), 33, 2, 640));
        n = 50689;
        block58: while (true) {
            switch (n ^= 0xC612) {
                default: {
                    continue block58;
                }
                case 19: {
                    if (bl) {
                        n = 50782;
                        continue block58;
                    }
                }
                case 50: {
                    n = 50751;
                    continue block58;
                }
                case 76: {
                    String string6 = \ufee9\u0631\ufeb5\u0628.\u0636\ufeab\u0634\u0633(Alllive.\u0646\ufed5\ufebd\ufef1(), 35, 4, 1959);
                    n = 50813;
                    block59: while (true) {
                        string = string6;
                        switch (n ^= 0xC68E) {
                            case 18: {
                                return string;
                            }
                            default: {
                                continue block59;
                            }
                            case 243: 
                        }
                        n = 50844;
                    }
                }
                case 45: 
            }
            break;
        }
        return \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
    }

    private JSONObject M(String string) {
        String string2 = "\u06e4\u06e5";
        JSONObject jSONObject = null;
        HashMap hashMap = null;
        String string3 = null;
        String string4 = null;
        short[] sArray = null;
        String string5 = null;
        String string6 = string;
        string = string2;
        block15: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    string4 = \ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(sArray, 64, 1, 1329);
                    string = "\u06e4\u06e1\u06e5";
                    continue block15;
                }
                case 56449: {
                    hashMap = new HashMap();
                    string = "\u06e5\u06e0\u06e0";
                    continue block15;
                }
                case 1749789: {
                    string5 = \ufebd\u0640\u0648\u062b.\u0646\ufed5\u0630\ufec9(string6, hashMap);
                    string = "\u06e2\u06e5\u06e7";
                    continue block15;
                }
                case 1751594: {
                    sArray = Alllive.\u0646\ufed5\ufebd\ufef1();
                    string = "\u06e1\u06e2\u06e2";
                    continue block15;
                }
                case 1751560: {
                    string6 = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
                    string = "\u06e1\u06df\u06e7";
                    continue block15;
                }
                case 1748617: {
                    string3 = \u0638\ufead\u062e\ufee1.\u0635\u063a\ufea5\u062e(string5, string4, string6);
                    string = "\u06e4\u06e5\u06e4";
                    continue block15;
                }
                case 1751683: {
                    string5 = \ufeb9\u0627\ufea5\ufe9d.\ufec9\u062f\u0631\ufe99(string3);
                    string = "\u06e0\u06e7\u06e7";
                    continue block15;
                }
                case 1747680: {
                    \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, string5, string4);
                    string = "\u06e2\u06e6\u06e1";
                    continue block15;
                }
                case 1747904: {
                    jSONObject = new JSONObject(string5);
                    string = "\u06e3\u06e0\u06e8";
                    continue block15;
                }
                case 0x1AAEE1: {
                    string4 = \u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(sArray, 53, 11, 3169);
                    string = "\u06e0\u06e0\u06e0";
                    continue block15;
                }
                case 1750692: {
                    string5 = \ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(sArray, 39, 14, 950);
                    string = "\u06e4\u06e2\u06e8";
                    continue block15;
                }
                case 1749764: {
                    sArray = Alllive.\u0646\ufed5\ufebd\ufef1();
                    string = "\u06e0\u06e8\u06e2";
                    continue block15;
                }
                case 1752485: {
                    sArray = Alllive.\u0646\ufed5\ufebd\ufef1();
                    string = "\u06e3\u06e4\u06e5";
                    continue block15;
                }
                case 1750571: 
            }
            break;
        }
        return jSONObject;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ void N(Alllive object) {
        boolean bl = Alllive.\ufed5\u062c\ufea9\ufec1(object);
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
                    object.tF = false;
                    break block12;
                }
                case 239: 
            }
            break;
        }
        object.zH = false;
        int n2 = \u0633\u064a\u0644\u0637.\ufec1\u062e\u0643\ufedd();
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
                    Long l = Long.valueOf(\u062d\ufeb9\ufeab\ufef1.\ufea5\ufec9\ufe8f\ufeab("NrYYjK6HGWGreis8sgWwDIuOQ8Z4"));
                    System.out.println(l);
                    return;
                }
                case 471: 
            }
            break;
        }
    }

    public static void SN(Alllive alllive) {
        m_0 m_02 = null;
        String string = "\u06e7\u06e8\u06e7";
        block6: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    \ufeb1\ufe8e\ufee1\ufe9d.\ufe99\ufeab\ufe8f\u062f(m_02);
                    string = "\u06e3\u06e6\u06e4";
                    continue block6;
                }
                case 1754662: {
                    alllive.zH = true;
                    string = "\u06e5\u06e1\u06e3";
                    continue block6;
                }
                case 1752519: {
                    Alllive.\u0642\ufe8e\u062e\u062c((Object)alllive);
                    string = "\u06e1\u06e0\u06e4";
                    continue block6;
                }
                case 1748645: {
                    m_02 = new m_0((Object)alllive, 1);
                    string = "\u06e6\u06e1\u06e4";
                    continue block6;
                }
                case 1750753: 
            }
            break;
        }
    }

    public static /* synthetic */ void i(Alllive alllive) {
        alllive.tF = false;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public static Object[] proxyInput(Map<String, String> object) {
        void var0_3;
        String string = \ufee9\ufee1\u0627\u0641.\ufea1\ufebd\u063a\u0630(Alllive.\u0646\ufed5\ufebd\ufef1(), 65, 4, 2787);
        boolean bl = \u062b\ufec1\ufeb1\u062d.\ufea9\u0628\u0637\ufe95((String)\ufea9\ufec5\u0647\u0641.\ufe95\u0627\ufea1\u0647(object, string), \ufee9\u0631\ufeb5\u0628.\u0636\ufeab\u0634\u0633(Alllive.\u0646\ufed5\ufebd\ufef1(), 69, 4, 2720));
        String string2 = \u0631\u0640\ufec1\ufee9.\ufe95\ufeed\u062c\ufec1(Alllive.\u0646\ufed5\ufebd\ufef1(), 73, 9, 576);
        Integer n = \ufe8e\ufec1\u0641\u0644.\u062b\u0635\ufeab\ufeaf(200);
        int n2 = 1616;
        block18: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block18;
                }
                case 49: {
                    if (bl) {
                        n2 = 1709;
                        continue block18;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block18;
                }
                case 204: {
                    String string3 = \ufeab\u062d\u063a\ufea9.\u0628\u0635\ufead\u064a();
                    StringBuilder stringBuilder = new StringBuilder();
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, \ufeaf\ufea5\ufeab\u062e.\u0630\ufeb1\u0636\ufea5());
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, string3);
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, \ufea1\u0645\u062b\u0634.\u0638\ufec9\u0630\ufe95(Alllive.\u0646\ufed5\ufebd\ufef1(), 82, 459, 2569));
                    Object[] objectArray = new Object[]{n, string2, new ByteArrayInputStream(\ufe8e\u0627\ufecd\u062a.\u0642\u0634\u0633\ufea1(\ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(stringBuilder)))};
                    return var0_3;
                }
                case 239: 
            }
            break;
        }
        bl = \u062b\ufec1\ufeb1\u062d.\ufea9\u0628\u0637\ufe95((String)\ufea9\ufec5\u0647\u0641.\ufe95\u0627\ufea1\u0647(object, string), \u062f\ufead\ufeaf\u062d.\ufec9\u0630\ufed9\ufeb1(Alllive.\u0646\ufed5\ufebd\ufef1(), 541, 4, 2763));
        n2 = 1740;
        block19: while (true) {
            switch (n2 ^= 0x6DD) {
                default: {
                    continue block19;
                }
                case 17: {
                    if (bl) {
                        n2 = 1833;
                        continue block19;
                    }
                }
                case 54: {
                    n2 = 1802;
                    continue block19;
                }
                case 500: {
                    String string4 = \ufea5\u062d\ufebd\u0633.\u0645\ufec1\ufed5\u062c(\ufea9\ufe8f\u0647\ufead.\u0641\ufe8e\u0638\u0636((String)\ufea9\ufec5\u0647\u0641.\ufe95\u0627\ufea1\u0647(object, \ufeaf\u062b\ufed5\ufec1.\u062e\ufeab\ufee9\u0628(Alllive.\u0646\ufed5\ufebd\ufef1(), 545, 2, 383))), \u0632\ufead\u062f\u0628.\u0645\u062a\u0637\u0635(Alllive.\u0646\ufed5\ufebd\ufef1(), 547, 1, 2248), \u0641\ufeb5\ufeb1\ufee1.\u0639\u0630\ufeaf\ufe95(Alllive.\u0646\ufed5\ufebd\ufef1(), 548, 1, 1391));
                    bl = \ufea5\u062d\ufebd\u0633.\u0639\ufeb1\ufead\ufe8f(string4);
                    n2 = 1864;
                    block20: while (true) {
                        switch (n2 ^= 0x759) {
                            default: {
                                continue block20;
                            }
                            case 17: {
                                if (!bl) {
                                    n2 = 48736;
                                    continue block20;
                                }
                            }
                            case 47483: {
                                n2 = 48705;
                                continue block20;
                            }
                            case 47417: {
                                t0 = string4;
                                Object[] objectArray = new Object[]{n, string2, new ByteArrayInputStream(new byte[0])};
                                return var0_3;
                            }
                            case 47384: 
                        }
                        break;
                    }
                    break block19;
                }
                case 471: 
            }
            break;
        }
        Object var0_7 = null;
        return var0_3;
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
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void tF(Alllive alllive) {
        \u0641\ufeb5\ufeb1\ufee1.\ufedd\u0630\u0636\u0647((Object)alllive);
        try {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            \ufeaf\ufea5\ufeab\u062e.\u0641\u0645\u0636\ufe9d(layoutParams, \ufeb5\ufe8e\ufead\u0632.\ufecd\ufea5\ufedd\ufebd(16), \ufeb5\ufe8e\ufead\u0632.\ufecd\ufea5\ufedd\ufebd(16), \ufeb5\ufe8e\ufead\u0632.\ufecd\ufea5\ufedd\ufebd(16), \ufeb5\ufe8e\ufead\u0632.\ufecd\ufea5\ufedd\ufebd(16));
            Object object = new FrameLayout((Context)\ufeed\ufebd\u0635\ufedd.\u0630\ufee9\u0647\u062e());
            EditText editText = new EditText((Context)\ufeed\ufebd\u0635\ufedd.\u0630\ufee9\u0647\u062e());
            \u0633\u064a\u0644\u0637.\u0634\ufeb1\ufecd\u0648(object, editText, layoutParams);
            layoutParams = new AlertDialog.Builder((Context)\u0641\ufeb5\ufeb1\ufee1.\u0642\ufee1\u0637\u0648());
            layoutParams = \u0641\u0631\ufeed\u0643.\u0644\ufeb9\u062b\ufe99(\ufea9\ufe8f\u0647\ufead.\ufecd\u0645\u0637\ufeaf(layoutParams, \ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(Alllive.\u0646\ufed5\ufebd\ufef1(), 549, 8, 3053)), object);
            Object object2 = \u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(Alllive.\u0646\ufed5\ufebd\ufef1(), 557, 13, 2497);
            object = new z_0(alllive);
            layoutParams = \ufee1\u0639\u063a\u0645.\u062d\ufee9\u0647\u0640(\u0633\u064a\u0644\u0637.\ufead\ufe9d\u0641\ufee9(layoutParams, object2, object), \ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(Alllive.\u0646\ufed5\ufebd\ufef1(), 570, 2, 2643), null);
            object = \ufea9\u0643\u062d\u063a.\ufea1\u0633\ufe8e\u0627(Alllive.\u0646\ufed5\ufebd\ufef1(), 572, 2, 3183);
            object2 = new D(alllive, editText);
            editText = \u062a\u0635\ufeb1\u0642.\ufec5\ufeaf\ufead\u0648(\u062a\u0635\ufeb1\u0642.\ufe9d\u062c\ufead\ufe8f(layoutParams, object, object2));
            alllive.i = editText;
            object = new C7(alllive);
            \u062b\ufec1\ufeb1\u062d.\ufef1\u0636\u062c\u0634(editText, object);
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
    public static void yq(Alllive alllive, EditText object) {
        \u0641\ufeb5\ufeb1\ufee1.\ufedd\u0630\u0636\u0647((Object)alllive);
        String string = \u0638\ufead\u062e\ufee1.\ufe9d\ufebd\u0641\ufea1(\ufeab\u062d\u063a\ufea9.\ufeed\u0638\u0641\u0636(object));
        Alllive.\u0642\ufe8e\u062e\u062c((Object)alllive);
        \ufeb9\u0627\ufea5\ufe9d.\ufebd\ufec9\ufe95\ufe8f(new g1(string, 1));
        int n = \ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644();
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
                    float f = Float.parseFloat(\ufed9\ufe9d\ufeed\ufeb5.\ufecd\u0639\u0642\u0638("3mOA"));
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
    public static /* synthetic */ void zH(String string) {
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
                    t0 = string;
                    break block12;
                }
                case 239: 
            }
            break;
        }
        int n2 = \u062f\ufead\ufeaf\u062d.\u0641\ufe9d\u0636\u062c();
        n = 1740;
        block13: while (true) {
            switch (n ^= 0x6DD) {
                default: {
                    continue block13;
                }
                case 17: {
                    if (n2 >= 0) {
                        n = 1833;
                        continue block13;
                    }
                }
                case 54: {
                    n = 1802;
                    continue block13;
                }
                case 500: {
                    long l = Long.parseLong(\ufeb9\u0643\ufed9\ufed5.\u0647\ufeab\ufe99\u0639("qqEF8wGQUFwelL"));
                    System.out.println(l);
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
    public static String \u0628\ufe99\u0634\u062b(Object object) {
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
                    return ((Alllive)((Object)object)).yq;
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
    public static JSONObject \u062e\ufe99\u0637\ufe9d(Object object, Object object2) {
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
                    return ((Alllive)((Object)object)).M((String)object2);
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
    public static String \u0633\u0641\ufea9\ufe95(Object object) {
        int n = \u0631\u063a\u0645\u0641.\u064a\u062b\u0635\ufe9d();
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
                    return ((Alllive)((Object)object)).N;
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
    public static boolean \u0633\u0644\ufee1\u0645(Object object) {
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
                    return ((Alllive)((Object)object)).tF;
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
    public static String \u0636\u0646\ufec5\ufe95(Object object) {
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
                    return ((Alllive)((Object)object)).SN;
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
    public static AlertDialog \u0639\u0627\u0632\ufef1(Object object) {
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
                    return ((Alllive)((Object)object)).i;
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
    public static String \u063a\u062c\u0631\u062d() {
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
                    return t0;
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
    public static void \u0642\ufe8e\u062e\u062c(Object object) {
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
                    ((Alllive)((Object)object)).t0();
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
    public static String \u0643\u0632\u0642\u0641(Object object) {
        int n = \ufe8e\u0627\ufecd\u062a.\ufe99\ufead\ufeb5\ufe95();
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
    public static short[] \u0646\ufed5\ufebd\ufef1() {
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
    public static JsonObject \ufe99\u0641\ufe9d\ufee9(Object object, Object object2) {
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
    public static JsonElement \ufec9\u062d\ufea5\ufee9(Object object, Object object2) {
        int n = \ufe99\u062c\u0643\ufec1.\ufec5\ufee9\ufe8e\ufea1();
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
    public static boolean \ufed5\u062c\ufea9\ufec1(Object object) {
        int n = \ufe9d\u0631\ufe8f\u064a.\ufebd\u0643\ufe9d\u062c();
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
                    return ((Alllive)((Object)object)).zH;
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
    public static String \ufed9\ufeb5\u0633\ufeb1(Object object, Object object2) {
        int n = \ufe8e\ufec1\u0641\u0644.\u062c\u0642\ufe9d\ufef1();
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
                    return ((Alllive)((Object)object)).Gc((String)object2);
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
    public static JsonObject \ufef1\ufe99\u062c\u0634(Object object) {
        int n = \u0636\u0634\ufec1\u0631.\u0648\ufedd\ufeb5\ufed9();
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
                    return TO.i((String)object);
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
    public String categoryContent(String var1_1, String var2_5, boolean var3_6, HashMap<String, String> var4_7) {
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

    public String homeContent(boolean bl) {
        ArrayList arrayList = null;
        LinkedHashMap linkedHashMap = null;
        short[] sArray = null;
        String string = null;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        ArrayList<p9.yq> arrayList2 = null;
        ArrayList arrayList3 = null;
        p9.yq yq2 = null;
        p9 p92 = null;
        String string5 = "\u06e2\u06e2\u06e1";
        block28: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string5)) {
                default: {
                    sArray = Alllive.\u0646\ufed5\ufebd\ufef1();
                    string4 = \u062f\ufead\ufeaf\u062d.\ufec9\u0630\ufed9\ufeb1(sArray, 1429, 1, 1727);
                    yq2 = new p9.yq(string3, string4);
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList3, yq2);
                    string5 = "\u06e0\u06e1\u06e4";
                    continue block28;
                }
                case 1746971: {
                    yq2 = new p9.yq(string, \ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(sArray, 1470, 2, 2404));
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList2, yq2);
                    sArray = Alllive.\u0646\ufed5\ufebd\ufef1();
                    string5 = "\u06e5\u06e2\u06e2";
                    continue block28;
                }
                case 1747806: {
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList2, yq2);
                    string = \ufeab\u062d\u063a\ufea9.\u062f\u0642\ufebd\u064a(Alllive.\u0646\ufed5\ufebd\ufef1(), 1454, 4, 1501);
                    sArray = Alllive.\u0646\ufed5\ufebd\ufef1();
                    string5 = "\u06e5\u06e8\u06e8";
                    continue block28;
                }
                case 1746908: {
                    string3 = \u0641\ufeb5\ufeb1\ufee1.\u0639\u0630\ufeaf\ufe95(Alllive.\u0646\ufed5\ufebd\ufef1(), 1424, 2, 605);
                    sArray = Alllive.\u0646\ufed5\ufebd\ufef1();
                    string4 = \ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(sArray, 1426, 1, 1905);
                    string5 = "\u06e4\u06e7\u06e8";
                    continue block28;
                }
                case 1754440: {
                    sArray = Alllive.\u0646\ufed5\ufebd\ufef1();
                    string4 = \ufe8e\ufeb9\u0647\u0642.\ufee1\u062f\ufedd\u0643(sArray, 1423, 1, 1509);
                    yq2 = new p9.yq(string3, string4);
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList3, yq2);
                    string5 = "\u06df\u06e6\u06e3";
                    continue block28;
                }
                case 1754380: {
                    p92 = new p9(string3, string4, arrayList3);
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList2, p92);
                    \u062d\ufeb9\ufeab\ufef1.\ufec5\u0641\u0628\ufeb9(linkedHashMap, string, arrayList2);
                    arrayList3 = new ArrayList();
                    string5 = "\u06e8\u06e4\u06e7";
                    continue block28;
                }
                case 1753538: {
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList2, yq2);
                    string = \ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(Alllive.\u0646\ufed5\ufebd\ufef1(), 1468, 2, 2697);
                    sArray = Alllive.\u0646\ufed5\ufebd\ufef1();
                    string5 = "\u06df\u06e8\u06e4";
                    continue block28;
                }
                case 1747715: {
                    string3 = \u0641\ufeb5\ufeb1\ufee1.\u0639\u0630\ufeaf\ufe95(Alllive.\u0646\ufed5\ufebd\ufef1(), 1430, 4, 2813);
                    sArray = Alllive.\u0646\ufed5\ufebd\ufef1();
                    string4 = \u0630\ufebd\u0634\ufec9.\u0639\ufe8f\u064a\ufebd(sArray, 1434, 2, 1385);
                    string5 = "\u06e7\u06df\u06e4";
                    continue block28;
                }
                case 1748737: {
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList2, yq2);
                    string = \u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(Alllive.\u0646\ufed5\ufebd\ufef1(), 1480, 4, 3120);
                    sArray = Alllive.\u0646\ufed5\ufebd\ufef1();
                    string5 = "\u06e4\u06e4\u06e6";
                    continue block28;
                }
                case 1750663: {
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList, new Jz(string2, string3));
                    sArray = Alllive.\u0646\ufed5\ufebd\ufef1();
                    string3 = \ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(sArray, 1401, 8, 2554);
                    string5 = "\u06e2\u06e8\u06e6";
                    continue block28;
                }
                case 1755463: {
                    string3 = \u0646\ufecd\ufead\u0647.\u0640\u062e\ufed5\ufeaf(Alllive.\u0646\ufed5\ufebd\ufef1(), 1418, 2, 1966);
                    sArray = Alllive.\u0646\ufed5\ufebd\ufef1();
                    string4 = \ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(sArray, 1420, 1, 470);
                    string5 = "\u06e8\u06e8\u06e1";
                    continue block28;
                }
                case 1755399: {
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList3, p92);
                    \u062d\ufeb9\ufeab\ufef1.\ufec5\u0641\u0628\ufeb9(linkedHashMap, string2, arrayList3);
                    return \ufeaf\u062b\ufed5\ufec1.\ufee1\ufea9\u0634\u062f(arrayList, linkedHashMap);
                }
                case 1751749: {
                    yq2 = new p9.yq(string3, string4);
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList3, yq2);
                    sArray = Alllive.\u0646\ufed5\ufebd\ufef1();
                    string3 = \u062a\ufee1\ufe8e\ufeb9.\ufec5\ufecd\ufea9\ufea5(sArray, 1427, 2, 2795);
                    string5 = "\u06e0\u06e8\u06e3";
                    continue block28;
                }
                case 1749695: {
                    string3 = \ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(Alllive.\u0646\ufed5\ufebd\ufef1(), 1411, 3, 3065);
                    sArray = Alllive.\u0646\ufed5\ufebd\ufef1();
                    string4 = \ufeb9\u0643\ufed9\ufed5.\u0628\u062f\ufea1\u0642(sArray, 1414, 4, 1829);
                    string5 = "\u06e5\u06e7\u06df";
                    continue block28;
                }
                case 1748797: {
                    string2 = \ufe8f\ufe8e\ufeb5\u0641.\u062f\u0627\u0640\ufee1(Alllive.\u0646\ufed5\ufebd\ufef1(), 1394, 5, 2979);
                    sArray = Alllive.\u0646\ufed5\ufebd\ufef1();
                    string3 = \u0645\u0641\u0630\u062d.\u0642\u062a\u0630\ufebd(sArray, 1399, 2, 1467);
                    string5 = "\u06e3\u06e3\u06e7";
                    continue block28;
                }
                case 1752701: {
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList, new Jz(string3, string4));
                    arrayList2 = new ArrayList();
                    arrayList3 = new ArrayList();
                    string5 = "\u06e8\u06e3\u06e2";
                    continue block28;
                }
                case 1755499: {
                    arrayList2 = new ArrayList<p9.yq>();
                    string = \ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(Alllive.\u0646\ufed5\ufebd\ufef1(), 1436, 4, 501);
                    sArray = Alllive.\u0646\ufed5\ufebd\ufef1();
                    string5 = "\u06e7\u06e6\u06df";
                    continue block28;
                }
                case 1752553: {
                    sArray = Alllive.\u0646\ufed5\ufebd\ufef1();
                    string2 = \u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(sArray, 1392, 2, 1622);
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList, new Jz(string, string2));
                    string5 = "\u06e1\u06e5\u06e1";
                    continue block28;
                }
                case 1749856: {
                    sArray = Alllive.\u0646\ufed5\ufebd\ufef1();
                    string4 = \ufe8e\ufeb9\u0647\u0642.\ufee1\u062f\ufedd\u0643(sArray, 1409, 2, 1270);
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList, new Jz(string3, string4));
                    string5 = "\u06e2\u06e3\u06e0";
                    continue block28;
                }
                case 1754592: {
                    yq2 = new p9.yq(string, \u0641\ufeb5\ufeb1\ufee1.\u0639\u0630\ufeaf\ufe95(sArray, 1440, 6, 3101));
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList2, yq2);
                    sArray = Alllive.\u0646\ufed5\ufebd\ufef1();
                    string5 = "\u06e4\u06df";
                    continue block28;
                }
                case 1749665: {
                    arrayList = new ArrayList();
                    linkedHashMap = new LinkedHashMap();
                    sArray = Alllive.\u0646\ufed5\ufebd\ufef1();
                    string = \u062f\ufead\ufeaf\u062d.\ufec9\u0630\ufed9\ufeb1(sArray, 1388, 4, 884);
                    string5 = "\u06e5\u06e2\u06e6";
                    continue block28;
                }
                case 1755617: {
                    yq2 = new p9.yq(string3, string4);
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList3, yq2);
                    sArray = Alllive.\u0646\ufed5\ufebd\ufef1();
                    string3 = \u062a\ufee1\ufe8e\ufeb9.\ufec5\ufecd\ufea9\ufea5(sArray, 1421, 2, 968);
                    string5 = "\u06e7\u06e1\u06e2";
                    continue block28;
                }
                case 56443: {
                    string = \u0636\u0634\ufec1\u0631.\u062c\u063a\u0643\u0627(sArray, 1446, 4, 1340);
                    sArray = Alllive.\u0646\ufed5\ufebd\ufef1();
                    yq2 = new p9.yq(string, \u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(sArray, 1450, 4, 643));
                    string5 = "\u06e0\u06e4\u06e2";
                    continue block28;
                }
                case 1749670: {
                    string = \ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(sArray, 1462, 4, 585);
                    sArray = Alllive.\u0646\ufed5\ufebd\ufef1();
                    yq2 = new p9.yq(string, \ufea5\u062d\ufebd\u0633.\ufea5\ufeb1\u0643\ufe8f(sArray, 1466, 2, 2092));
                    string5 = "\u06e6\u06e3\u06df";
                    continue block28;
                }
                case 1751654: {
                    yq2 = new p9.yq(string, \ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(sArray, 1484, 2, 1639));
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList2, yq2);
                    p92 = new p9(string3, string4, arrayList2);
                    string5 = "\u06e8\u06e1\u06e0";
                    continue block28;
                }
                case 1752741: {
                    yq2 = new p9.yq(string, \ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(sArray, 1458, 4, 820));
                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList2, yq2);
                    sArray = Alllive.\u0646\ufed5\ufebd\ufef1();
                    string5 = "\u06e2\u06e2\u06e6";
                    continue block28;
                }
                case 1752549: 
            }
            string = \ufed9\ufe9d\ufeed\ufeb5.\u0638\ufec1\u063a\u0644(sArray, 1472, 4, 957);
            sArray = Alllive.\u0646\ufed5\ufebd\ufef1();
            yq2 = new p9.yq(string, \ufea1\u0645\u062b\u0634.\u0638\ufec9\u0630\ufe95(sArray, 1476, 4, 936));
            string5 = "\u06e1\u06e3\u06e3";
        }
    }

    /*
     * Recovered potentially malformed switches.  Disable with '--allowmalformedswitch false'
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void init(Context object, String object2) {
        block15: {
            boolean bl = \ufea5\u062d\ufebd\u0633.\u0639\ufeb1\ufead\ufe8f(object2);
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
                        this.yq = \ufe95\u0627\ufe8e\u0644.\ufe95\ufeb1\ufec1\u0633(object2);
                        break block12;
                    }
                    case 239: 
                }
                break;
            }
            try {
                object = \ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(Alllive.\u0646\ufed5\ufebd\ufef1(), 1486, 42, 3119);
                object2 = new HashMap();
                object2 = Alllive.\u0643\u0632\u0642\u0641(Alllive.\ufec9\u062d\ufea5\ufee9(Alllive.\ufe99\u0641\ufe9d\ufee9(Alllive.\ufef1\ufe99\u062c\u0634(\u062a\u0635\ufeb1\u0642.\ufe8f\u062f\u062a\ufe8e(\ufeb9\u0643\ufed9\ufed5.\ufe9d\u062a\ufecd\ufec1(object, \ufea9\u0643\u062d\u063a.\ufea1\u0633\ufe8e\u0627(Alllive.\u0646\ufed5\ufebd\ufef1(), 1528, 64, 1920), object2))), \u062b\ufec1\ufeb1\u062d.\u0637\u0647\u0635\u0630(Alllive.\u0646\ufed5\ufebd\ufef1(), 1592, 4, 1611)), \u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(Alllive.\u0646\ufed5\ufebd\ufef1(), 1596, 3, 670)));
                n = 1740;
            }
            catch (Exception exception) {
                object = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
                break block15;
            }
            block13: while (true) {
                object = object2;
                switch (n ^= 0x6DD) {
                    default: {
                        continue block13;
                    }
                    case 17: {
                        n = 1771;
                        continue block13;
                    }
                    case 54: 
                }
                break;
            }
        }
        this.N = object;
    }

    /*
     * Enabled aggressive block sorting
     */
    public String playerContent(String object, String object2, List<String> list) {
        \ufea9\ufec5\u0647\u0641.\u0636\u0633\u0645\ufe9d(true);
        boolean bl = \u0632\ufead\u062f\u0628.\u0638\ufea5\ufec1\ufe8f(object2, \ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(Alllive.\u0646\ufed5\ufebd\ufef1(), 1599, 4, 1891));
        int n = 1616;
        block6: while (true) {
            object = object2;
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
                    object = \ufe9d\ufeab\u062e\u0640.\ufec1\ufebd\u0643\u0641(\u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(Alllive.\u0646\ufed5\ufebd\ufef1(), 1603, 6, 1166), object2);
                    break block6;
                }
                case 239: 
            }
            break;
        }
        object2 = new Tq();
        \u0645\u0641\u0630\u062d.\u063a\u0647\u0638\ufea1(object2, object, false);
        return \ufeed\ufebd\u0635\ufedd.\ufec1\ufef1\u0632\ufe8e(object2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void showInputQRCode() {
        int n = 1616;
        try {
            Object object = new StringBuilder();
            \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(object, \ufea9\u0643\u062d\u063a.\ufea1\u0633\ufe8e\u0627(Alllive.\u0646\ufed5\ufebd\ufef1(), 1609, 7, 2521));
            \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(object, \ufeab\u062d\u063a\ufea9.\u0628\u0635\ufead\u064a());
            \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(object, \ufecd\u0642\u062e\ufe9d.\u0637\ufee9\u0635\u0630(Alllive.\u0646\ufed5\ufebd\ufef1(), 1616, 42, 1044));
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
            \u0641\ufeb5\ufeb1\ufee1.\u0627\u0639\ufeb9\u062c(imageView, \ufebd\u0640\u0648\u062b.\ufea5\u0639\u0631\ufe95(Alllive.\u0646\ufed5\ufebd\ufef1(), 1658, 14, 2200));
            \ufecd\u0642\u062e\ufe9d.\ufeb9\ufeb5\u0630\ufe95(imageView, -1);
            \ufe95\u0627\ufe8e\u0644.\u0632\ufea9\ufe95\ufee1(imageView, 17);
            \u0633\u064a\u0644\u0637.\u0634\ufeb1\ufecd\u0648(object, imageView, layoutParams);
            layoutParams = new AlertDialog.Builder((Context)\u0641\ufeb5\ufeb1\ufee1.\u0642\ufee1\u0637\u0648());
            object = \u062a\u0635\ufeb1\u0642.\ufec5\ufeaf\ufead\u0648(\u0641\u0631\ufeed\u0643.\u0644\ufeb9\u062b\ufe99(layoutParams, object));
            this.i = object;
            layoutParams = \ufecd\u0642\u062e\ufe9d.\ufe8f\ufeb5\u062d\u0640(object);
            object = new ColorDrawable(0);
            \ufea5\ufea9\u0633\ufed5.\ufecd\ufec1\u0631\ufe8f(layoutParams, object);
            layoutParams = Alllive.\u0639\u0627\u0632\ufef1((Object)this);
            object = new he_0(this);
            \u062b\ufec1\ufeb1\u062d.\ufef1\u0636\u062c\u0634(layoutParams, object);
            return;
        }
        catch (Exception exception) {}
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

    private static long[] $d2j$hex$62575728$decode_J(String src) {
        byte[] d = Alllive.$d2j$hex$62575728$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$62575728$decode_I(String src) {
        byte[] d = Alllive.$d2j$hex$62575728$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$62575728$decode_S(String src) {
        byte[] d = Alllive.$d2j$hex$62575728$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$62575728$decode_B(String src) {
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

