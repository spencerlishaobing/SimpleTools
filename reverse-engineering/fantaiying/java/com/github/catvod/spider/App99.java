/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.github.catvod.crawler.Spider
 *  okhttp3.Call
 *  okhttp3.MediaType
 *  okhttp3.OkHttpClient
 *  okhttp3.OkHttpClient$Builder
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
import com.github.catvod.spider.\u062d\u062e\ufe8e\u0645;
import com.github.catvod.spider.\u0631\ufea1\u0638\u0627;
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
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.Inflater;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.Call;
import okhttp3.MediaType;
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
public class App99
extends Spider {
    private static final short[] short = App99.$d2j$hex$1356fd7f$decode_S("230923093f0932098b0a9a0a9a0aa40a8b0a870a8f0a0d071c071c070707090715079e018f018d0185018f0189018b01a40ab30aaf0aaa0aa20a880ab30aab0aa40aa30ab40aa807bf07a307a607ae079907a307ad07a407ab07be07bf07b807af07d203c103d603d703cd03cb03ca03850598059c0594058205850590059c058105c40cc50cc40cc90ccf0cb10ab00ab60aba0ab10ab00ae40ae40a78047d0468047d0491038a038e0380038b03ef02e902ff02e802ee02f502f102ff02f4022a0c360c3b0c230c3f0c280ce707fb07f607ee07f207e5076506690662066306f408fb08f708ff089c0aca0a830a9c0aca0a830a9c0aca0a830a9c0aca0a830a9c0aca0aa506be06b706db06c406c306c006e70be70bfb0bf60bde03c303c703cf03d903de03cb03c703da03470a5d0a530a5a0adb01da01db01d601d0012607370737072c0722073e076a0579056e056f05750573057205a601b701ae019801b101a201b501b401ae01a801a9011f0458043b023e022b023e02cc08ce08db08ca08c808c008dd08d608dc08ce09df09cc09cd09db09cc09e109df09ce09d70976066a0667067f06630674069503960687021c090009b3016e097f09660959096a097d097c096609600961091d025902e703fc03f803f603fd03210b3c0b380b300b260b210b340b380b250b04020502040209020f028f07c107d007d0078f07d307d907d307d407c507cd07e907ce07c907d407580858085f086508f905e805fb05fa05ec05fa05aa0aa80abd0aac0aae0aa60abb0aa00aac0aba0a73096f0962097a09660971093c0930093b093a09fb02fb02fb02fa02a002ac02a702a602eb0cf00ce90ce90cf00bf40be20b49024d025b0227024b024a024b022702580243024b025b023d02580269026c026c02610266026f0244065e0642062006350635063806340620063c06aa018d01950182018f018a018701c30180018a0193018b0186019101970186019b019701c3018f0186018d01840197018b01e00ae10ae70af60afd0af40af00aa40ae20ae50aed0ae80ae10ae00ace0ccf0cdd0cb60ca30caf04be04be04a204a704ad04af04ba04a704a104a004e104a404bd04a104a004f504ee04ad04a604af04bc04bd04ab04ba04f304bb04ba04a804e304f604f20be30be50be70bdd0be10bed0bf70bec0bf60b770466046004620464046804720469047304780a690a6f0a6d0a4b0a670a7d0a660a7c0a99019c0189019c019201930192019f01990100051d05190511050705000515051905040551074a074e0740074b073d0cb201b601a001c50ac10ad70aab0ac70ac60ac70aab0ad40acf0ac70ad70ab10ad40ae50ae00ae00aed0aea0ae30a5a037c036a037d0322034e0368036a0361037b03e204fb04f004cb04e604f104f904f504e604ff04e70426053f0534050f0520053905330594058d058605bd058c0583058f05870541055805530568055e0553056a036703d405db05d705df058e0793078e0796079f074f0856085c0822072e07370724073307820395039d03910382039b038303eb05ea05f105e0057f0663066e067606500669067d0660066206a009bc09b109a909b609a209bf09bd0951084d08400858087e08540853084d0883029f0292028a02860281029f024b0a330a4b0a330a4b0a330ad204dd04d104d904b803a103aa039103a003af03a303ab03b304ae04b304ab04a204c101dd01d001c801d401c301ef04e304e804e90473742387a308840721065906ba0ba20bcd0b43032f0779072e072f0779074a072f0779074a072f0779074a072f0779077e037e037e0311011401010114011b061e060406030693098e099f099709890942045504430445045c044404100315031103150308038301920194019601ad08b108b30baa0ba70b56074b075d075c074b077b074007cd03d003d403dc03d605cc05fc05de05cb05da05d805d005cd05c6058a01d301ca01c1018a01d601c001c401d701c601cd01d401d101cb01cc019d018c018a0188018e0182019801830199019c0a870a9c0a890a840ab904e004ae04ab04b104b604e004f80499049f04ee04e004b204a304a504a704e004f8046b05650537052605200522052405280532052905330565057d0576056b0565052b052e052a052e05330565057d05750576056b05650533052805330526052b0565057d0577053a05c10acc0ac50ad00aea0adb0ad40ad80ad00a8d0794079f07a4079807940795078f079e0795078f0793088a088108ba0881088c0897088008860891088a08970845085c0857086c085208500847085c084108460b5f0b540b6f0b510b420b550b510ba304ba04b1048a04ac04b004b404a7048e0297029c02a7028a029d02950299028a0293028b0276056f0564055f0570056905630545095c0957096c095d0952095e095609cb05d205d905e205d405d90540054d05e309ba09f409f109eb09ec09ba09a209c309c509e509530546054505a307100200021c0202021c020202350829083f0c660c7f0c740c3f0c740c750c640c710c790c7c0ccb0bce0bdb0bce0b1b091409180910090b0816080b0813081a08f908e008ea08fc0bf00be90bfa0bed0b9f08880880088c089f0886089e08f201f301e801f90122033e033a03290303051005070503052e042c043b0420043d04500a5d0a460a510a570a400a5b0a460aa801a401a501bf01ae01a501bf01f003fe03e703e003f00312011d011001020102018d0894089f08a4088b0897089a088208a4089d0889089408960855064c0647067c0653064f0642065a067c06560651064f06f105f405ee05e9053a0138012d013c013e0136012b0130013c012a0193069e0697068206b806890686068a06820671047c04750460045a046c0461047a0b770ba101ae01a201aa01f85659925476105cad7f2b83aa57296a97701d553d0332033f032d032d03ad05a205a705bf05ae05b905b805c2089b08da08d508d808ca08ca089b088308e208e40895089b08df08d008d508cd08dc08cb08ca089b088308c208c408c408ea0bf60b01021002160214027a0350045504510455044804580341034c03000cdc01c101d701d601c101f101ca01fd06e006e406ec063f06250615063706220633063106390624062f069b0cc20cdb0cd00c9b0cc70cd10cd50cc60cd70cdc0cec02e902f302f402390c600c2e0c2b0c310c360c600c780c190c1f0c3f0c6703760376036a036f036503670372036f036903680329036c037503690368032e0329033503320398099c0993090e092d0925092b092c091209230936092a090a054405550555050a0550055605400557056c054b0543054a057c0b6d0b6d0b760b780b640b9e088d089a089b08810887088608a608890885088d08660375036203630379037f037e035f090d095b095c095d0957095d09570958090e095a090b0956095a095c090a09d305dc05d005d8056f077e077c0774077e0778077a077d086a08760873087b0851086a0872087d087a086d088201950189018c018401b301890187018e01810194019501920185011d0a060a020a0c0a070af702f702eb02e602e909fd090f082d0838082b082e082e0823086d0877086c08720862086a0815082b082c0826082d083508310862080c0816086208730872086c0872087908620815082b082c0874087608790862083a08740876086b0862080308320832082e08270815082708200809082b0836086d087708710875086c087108740862086a0809080a0816080f080e086e0862082e082b0829082708620805082708210829082d086b08620801082a0830082d082f0827086d087308700870086c0872086c08740870087b087b086c087b0877086208110823082408230830082b086d087708710875086c08710874089d01800184018c0186019c019d01410867087108660839085508730871087a0860085f027d027d027b026e026a02800cac0cad0cb70ca60cad0cb70cee0c970cba0cb30ca60c1a05150510051c0517050d0526050d05000509051c053b0b340b3e0b280b350b330b3e0b92058e0583059b0587059005c00ccd0cc90ccc0ccd0cda0cfd04ec04ff04fe04e804740973096d09950bb30ba50bb20bed0b810ba70ba50bae0bb40b6008d90bd40bdd0bc80b2f0a2a0a250a260a2a0a200a3e0a0505460518055e05130562087e0873086b08470860087e0860077107620763077507450762077c0777032a022702630772076b07770770076e075d024c02550269024e025002c50a9c0ace0adf0acc0acd0adb0a9c0a840a8f0a920a9c0acb0acc0ad20a9c0a840a9c0a62043d04a508d902800299029202d902850293029702840295029e0257074a075c075d074a077a0741075b054a054c054e05f20aee0ade0adb0adf0adb0ac60a2c0435043e040504320433042e04290405043704350434042e0432042a0c360c2b0c2d0c8d078c079a078a07a00ab90ab20abe0abf0aa20aa50abb0ab90ab80aa20abe0a470b420b580b5f0bf805e905ef05ed05eb05e705fd05e605fc05050c5c0c120c170c0d0c0a0c5c0c440c250c230c520c5c0c0e0c1f0c190c1b0c5c0c440c13081d084f085e0858085a085c0850084a0851084b081d0805080e084208");
    private String B;
    private Map<String, Object> F5;
    private int G;
    private Map<String, String> G4;
    private String Gc;
    private String KJ;
    private String M;
    private String N;
    private String SN;
    private OkHttpClient W;
    private Map<String, String> dT;
    private String i;
    private String q;
    private String t0;
    private String tF;
    private JSONArray v3;
    private String yq;
    private String zH;

    /*
     * Enabled aggressive block sorting
     */
    public App99() {
        int n = \ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9();
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
                    n2 = Integer.parseInt(\ufeb9\u0627\ufea5\ufe9d.\u0648\u0647\u0628\u062b("OCQR"));
                    System.out.println(n2);
                    return;
                }
                case 239: 
            }
            break;
        }
    }

    /*
     * Recovered potentially malformed switches.  Disable with '--allowmalformedswitch false'
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean B() {
        boolean bl;
        int n;
        String string;
        String string2;
        boolean bl2;
        block59: {
            bl2 = true;
            string2 = \ufeb5\ufe8e\ufead\u0632.\ufe8f\ufef1\u0648\ufe95(App99.\u0628\ufea5\u062a\ufec5(), 0, 4, 2390);
            string = App99.\u0640\ufec1\ufea9\u0637((Object)this);
            n = 1616;
            block46: while (true) {
                switch (n ^= 0x661) {
                    default: {
                        continue block46;
                    }
                    case 49: {
                        if (string != null) {
                            n = 1709;
                            continue block46;
                        }
                    }
                    case 14: {
                        n = 1678;
                        continue block46;
                    }
                    case 204: {
                        boolean bl3 = \ufeed\ufebd\u0635\ufedd.\u0637\ufe8e\ufee1\ufebd(string);
                        n = 1740;
                        block47: while (true) {
                            bl = bl2;
                            switch (n ^= 0x6DD) {
                                default: {
                                    continue block47;
                                }
                                case 17: {
                                    if (!bl3) {
                                        n = 1833;
                                        continue block47;
                                    }
                                }
                                case 54: {
                                    n = 1802;
                                    continue block47;
                                }
                                case 471: {
                                    break block46;
                                }
                                case 500: 
                            }
                            break;
                        }
                        return bl;
                    }
                    case 239: 
                }
                break;
            }
            CharSequence charSequence = App99.\ufeaf\ufe95\u0628\ufec9((Object)this);
            Object object = App99.\ufed5\u062b\u0643\u0634((Object)this);
            string = new JSONObject();
            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(string, \ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(App99.\u0628\ufea5\u062a\ufec5(), 4, 7, 2794), App99.\ufead\ufeab\u062a\u0636((Object)this));
            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(string, \ufecd\u0642\u062e\ufe9d.\u0637\ufee9\u0635\u0630(App99.\u0628\ufea5\u062a\ufec5(), 11, 6, 1900), App99.\u0637\ufee1\u062e\ufea1((Object)this));
            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(string, \u0630\ufebd\u0634\ufec9.\u0639\ufe8f\u064a\ufebd(App99.\u0628\ufea5\u062a\ufec5(), 17, 7, 494), App99.\u062d\ufeed\ufead\u0641((Object)this));
            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(string, \u062f\ufead\ufeaf\u062d.\ufec9\u0630\ufed9\ufeb1(App99.\u0628\ufea5\u062a\ufec5(), 24, 11, 2758), App99.\ufeed\u0636\ufead\u0642((Object)this));
            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(string, \ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(App99.\u0628\ufea5\u062a\ufec5(), 35, 14, 1994), App99.\ufe8e\u0640\ufec1\u064a((Object)this));
            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(string, string2, App99.\ufe8f\u0638\ufec1\u0644((Object)this));
            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(string, \ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(App99.\u0628\ufea5\u062a\ufec5(), 49, 7, 932), App99.\u0634\ufeaf\u0633\u062c((Object)this));
            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(string, \ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(App99.\u0628\ufea5\u062a\ufec5(), 56, 9, 1521), object);
            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(string, \u062f\ufead\ufeaf\u062d.\ufec9\u0630\ufed9\ufeb1(App99.\u0628\ufea5\u062a\ufec5(), 65, 5, 3242), charSequence);
            string = App99.\ufe9d\ufec9\ufeed\ufedd((Object)this, \ufeaf\u0633\u0648\ufee9.\ufeb5\u0634\u0640\ufea1(string));
            object = App99.\ufe95\u0638\ufeb5\ufed9((Object)this, charSequence, object, string);
            charSequence = new StringBuilder();
            \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(charSequence, App99.\u0645\ufec1\ufed5\u0634((Object)this));
            \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(charSequence, App99.\ufea9\u0636\ufed9\ufed5((Object)this));
            string = App99.\u062c\ufeb9\u0637\u0644((Object)this, App99.\ufed5\u0627\ufe95\ufea5((Object)this, \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(charSequence), string, object));
            object = \u062d\u062e\ufe8e\u0645.\ufead\ufea5\ufec1\u0637();
            charSequence = new StringBuilder();
            \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(charSequence, \u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(App99.\u0628\ufea5\u062a\ufec5(), 70, 8, 2773));
            \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(charSequence, string);
            \ufee1\u0639\u063a\u0645.\ufef1\u062c\u0638\u062f(object, \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(charSequence));
            n = 1864;
            block48: while (true) {
                switch (n ^= 0x759) {
                    default: {
                        continue block48;
                    }
                    case 17: {
                        if (string != null) {
                            n = 48736;
                            continue block48;
                        }
                    }
                    case 47483: {
                        n = 48705;
                        continue block48;
                    }
                    case 47417: {
                        bl = \ufeed\ufebd\u0635\ufedd.\u0637\ufe8e\ufee1\ufebd(string);
                        n = 48767;
                        break block48;
                    }
                    case 47384: {
                        return false;
                    }
                }
                break;
            }
            block49: while (true) {
                switch (n ^= 0xBE90) {
                    default: {
                        continue block49;
                    }
                    case 239: {
                        if (bl) {
                            n = 48860;
                            continue block49;
                        }
                    }
                    case 14: {
                        n = 48829;
                        continue block49;
                    }
                    case 76: {
                        n = 48891;
                        break block49;
                    }
                    case 45: {
                        object = new JSONObject(string);
                        string = \u0638\ufead\u062e\ufee1.\ufeb1\ufe99\ufe8f\u062a(object, \ufebd\u0640\u0648\u062b.\ufea5\u0639\u0631\ufe95(App99.\u0628\ufea5\u062a\ufec5(), 78, 4, 1052));
                        n = 49666;
                        break block59;
                    }
                }
                break;
            }
            block50: while (true) {
                switch (n ^= 0xBF0C) {
                    default: {
                        continue block50;
                    }
                    case 22: {
                        return false;
                    }
                    case 503: {
                        n = 48922;
                        continue block50;
                    }
                }
                break;
            }
        }
        block51: while (true) {
            bl = bl2;
            switch (n ^= 0xC213) {
                default: {
                    continue block51;
                }
                case 17: {
                    if (string != null) {
                        n = 49759;
                        continue block51;
                    }
                }
                case 50: {
                    n = 49728;
                    continue block51;
                }
                case 76: {
                    this.KJ = \ufed9\ufe9d\ufeed\ufeb5.\ufe95\ufeaf\u0641\ufe99(string, \ufee9\u0631\ufeb5\u0628.\u0636\ufeab\u0634\u0633(App99.\u0628\ufea5\u062a\ufec5(), 82, 5, 997), \ufed9\ufe9d\ufeed\ufeb5.\ufe95\ufeaf\u0641\ufe99(string, \ufed9\ufe9d\ufeed\ufeb5.\u0638\ufec1\u063a\u0644(App99.\u0628\ufea5\u062a\ufec5(), 87, 9, 666), App99.\u0640\ufec1\ufea9\u0637((Object)this)));
                    this.q = \ufed9\ufe9d\ufeed\ufeb5.\ufe95\ufeaf\u0641\ufe99(string, string2, App99.\ufe8f\u0638\ufec1\u0644((Object)this));
                    string2 = \u0638\ufead\u062e\ufee1.\ufeb1\ufe99\ufe8f\u062a(string, \u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(App99.\u0628\ufea5\u062a\ufec5(), 96, 6, 3162));
                    n = 49790;
                    break block51;
                }
                case 83: {
                    return bl;
                }
            }
            break;
        }
        block52: while (true) {
            bl = bl2;
            switch (n ^= 0xC28F) {
                default: {
                    continue block52;
                }
                case 241: {
                    if (string2 != null) {
                        n = 49883;
                        continue block52;
                    }
                }
                case 18: {
                    n = 49852;
                    continue block52;
                }
                case 84: {
                    try {
                        App99.\u0644\u0630\u0637\u062b((Object)this, string2);
                        return bl2;
                    }
                    catch (Exception exception) {
                        \ufed9\ufe8e\u062d\ufead.\u062b\ufe8e\u062d\u0645(exception);
                        return false;
                    }
                }
                case 51: 
            }
            break;
        }
        return bl;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private void F5(JSONObject jSONObject) {
        \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(App99.\ufe8f\ufead\ufecd\ufea1((Object)this), \ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(App99.\u0628\ufea5\u062a\ufec5(), 102, 6, 1943), jSONObject);
        Iterator iterator = \u062b\ufec1\ufeb1\u062d.\u062d\ufec5\ufed9\u0634(jSONObject);
        block28: while (true) {
            boolean bl = \ufe8e\u0627\ufecd\u062a.\u062f\u0638\ufe8e\ufe99(iterator);
            int n = 1616;
            block29: while (true) {
                switch (n ^= 0x661) {
                    default: {
                        continue block29;
                    }
                    case 49: {
                        if (bl) {
                            n = 1709;
                            continue block29;
                        }
                    }
                    case 14: {
                        n = 1678;
                        continue block29;
                    }
                    case 204: {
                        void var4_10;
                        JSONObject jSONObject2 = \u0638\ufead\u062e\ufee1.\ufeb1\ufe99\ufe8f\u062a(jSONObject, (String)\ufea1\u0645\u062b\u0634.\ufe95\ufeaf\ufeb9\ufea1(iterator));
                        n = 1740;
                        block30: while (true) {
                            switch (n ^= 0x6DD) {
                                case 471: {
                                    continue block28;
                                }
                                default: {
                                    continue block30;
                                }
                                case 17: {
                                    if (jSONObject2 != null) {
                                        n = 1833;
                                        continue block30;
                                    }
                                }
                                case 54: {
                                    n = 1802;
                                    continue block30;
                                }
                                case 500: 
                            }
                            break;
                        }
                        String string = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
                        String string2 = \ufe99\u062e\u0642\u0644.\u062d\ufead\u0644\ufec5(\ufed9\ufe9d\ufeed\ufeb5.\ufe95\ufeaf\u0641\ufe99(jSONObject2, \ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644(App99.\u0628\ufea5\u062a\ufec5(), 108, 4, 1542), string));
                        string = \ufe99\u062e\u0642\u0644.\u062d\ufead\u0644\ufec5(\ufed9\ufe9d\ufeed\ufeb5.\ufe95\ufeaf\u0641\ufe99(jSONObject2, \u062d\u062e\ufe8e\u0645.\u062d\ufeab\u0642\u0647(App99.\u0628\ufea5\u062a\ufec5(), 112, 4, 2202), string));
                        bl = \ufeed\ufebd\u0635\ufedd.\u0637\ufe8e\ufee1\ufebd(string2);
                        n = 1864;
                        block31: while (true) {
                            switch (n ^= 0x759) {
                                case 47384: {
                                    continue block28;
                                }
                                default: {
                                    continue block31;
                                }
                                case 17: {
                                    if (!bl) {
                                        n = 48736;
                                        continue block31;
                                    }
                                }
                                case 47483: {
                                    n = 48705;
                                    continue block31;
                                }
                                case 47417: 
                            }
                            break;
                        }
                        HashMap hashMap = App99.\u0633\u062d\u0646\ufeb5((Object)this);
                        bl = \ufeed\ufebd\u0635\ufedd.\u0637\ufe8e\ufee1\ufebd(string);
                        n = 48767;
                        block32: while (true) {
                            String string3 = string;
                            switch (n ^= 0xBE90) {
                                default: {
                                    continue block32;
                                }
                                case 239: {
                                    if (bl) {
                                        n = 48860;
                                        continue block32;
                                    }
                                }
                                case 14: {
                                    n = 48829;
                                    continue block32;
                                }
                                case 76: {
                                    String string4 = string2;
                                    break block32;
                                }
                                case 45: 
                            }
                            break;
                        }
                        \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, string2, var4_10);
                        n = 48891;
                        block33: while (true) {
                            switch (n ^= 0xBF0C) {
                                case 22: {
                                    continue block28;
                                }
                                default: {
                                    continue block33;
                                }
                                case 503: 
                            }
                            n = 48922;
                        }
                    }
                    case 239: 
                }
                break;
            }
            break;
        }
    }

    /*
     * Exception decompiling
     */
    private Map<String, String> G(String var1_1, String var2_2, String var3_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [14[CASE]], but top level block is 2[TRYBLOCK]
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
    private boolean G4() {
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

    private String Gc() {
        String string = "\u06e3\u06e2\u06e5";
        String string2 = null;
        byte[] byArray = null;
        SecureRandom secureRandom = null;
        block6: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    secureRandom = new SecureRandom();
                    string = "\u06e5\u06e5\u06e5";
                    continue block6;
                }
                case 1750630: {
                    byArray = new byte[16];
                    string = "\u06e5\u06e7";
                    continue block6;
                }
                case 1752487: {
                    string2 = \ufee1\u0639\u063a\u0645.\u0637\u0638\ufed5\ufe99(byArray, 2);
                    string = "\u06e0\u06e6";
                    continue block6;
                }
                case 1752645: {
                    \ufe99\u062e\u0642\u0644.\u0647\u0640\ufed9\u0643(secureRandom, byArray);
                    string = "\u06e5\u06e0\u06e2";
                    continue block6;
                }
                case 56326: 
            }
            break;
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private JSONObject KJ(String object) {
        Object object2 = \u0641\u0631\ufeed\u0643.\ufedd\u0631\ufebd\u062d(App99.\ufe8f\ufead\ufecd\ufea1((Object)this), \u0646\ufecd\ufead\u0647.\u0640\u062e\ufed5\ufeaf(App99.\u0628\ufea5\u062a\ufec5(), 286, 6, 2307));
        boolean bl = object2 instanceof JSONObject;
        int n = 1616;
        block24: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block24;
                }
                case 49: {
                    if (bl) {
                        n = 1709;
                        continue block24;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block24;
                }
                case 204: {
                    JSONObject jSONObject = (JSONObject)object2;
                    Iterator iterator = \u062b\ufec1\ufeb1\u062d.\u062d\ufec5\ufed9\u0634(jSONObject);
                    block25: while (true) {
                        bl = \ufe8e\u0627\ufecd\u062a.\u062f\u0638\ufe8e\ufe99(iterator);
                        n = 1740;
                        block26: while (true) {
                            switch (n ^= 0x6DD) {
                                default: {
                                    continue block26;
                                }
                                case 17: {
                                    if (bl) {
                                        n = 1833;
                                        continue block26;
                                    }
                                }
                                case 54: {
                                    n = 1802;
                                    continue block26;
                                }
                                case 500: {
                                    object2 = \u0638\ufead\u062e\ufee1.\ufeb1\ufe99\ufe8f\u062a(jSONObject, (String)\ufea1\u0645\u062b\u0634.\ufe95\ufeaf\ufeb9\ufea1(iterator));
                                    n = 1864;
                                    block27: while (true) {
                                        switch (n ^= 0x759) {
                                            case 47384: {
                                                continue block25;
                                            }
                                            default: {
                                                continue block27;
                                            }
                                            case 17: {
                                                if (object2 != null) {
                                                    n = 48736;
                                                    continue block27;
                                                }
                                            }
                                            case 47483: {
                                                n = 48705;
                                                continue block27;
                                            }
                                            case 47417: 
                                        }
                                        break;
                                    }
                                    bl = \u0636\u0634\ufec1\u0631.\u0646\u062a\ufeab\ufef1(\ufe99\u062e\u0642\u0644.\u062d\ufead\u0644\ufec5(\ufed9\ufe9d\ufeed\ufeb5.\ufe95\ufeaf\u0641\ufe99(object2, \ufeb9\u0627\ufea5\ufe9d.\u062a\ufef1\u062d\u0641(App99.\u0628\ufea5\u062a\ufec5(), 292, 4, 2399), \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640())), \ufe99\u062e\u0642\u0644.\u062d\ufead\u0644\ufec5(object));
                                    n = 48767;
                                    block28: while (true) {
                                        switch (n ^= 0xBE90) {
                                            case 45: {
                                                continue block25;
                                            }
                                            default: {
                                                continue block28;
                                            }
                                            case 239: {
                                                if (bl) {
                                                    n = 48860;
                                                    continue block28;
                                                }
                                            }
                                            case 14: {
                                                n = 48829;
                                                continue block28;
                                            }
                                            case 76: 
                                        }
                                        break;
                                    }
                                    object = \u062d\u062e\ufe8e\u0645.\ufead\ufea5\ufec1\u0637();
                                    StringBuilder stringBuilder = new StringBuilder();
                                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, \u062a\ufee1\ufe8e\ufeb9.\ufec5\ufecd\ufea9\ufea5(App99.\u0628\ufea5\u062a\ufec5(), 296, 8, 707));
                                    \u062d\ufeb9\ufeab\ufef1.\ufe9d\u0637\u0627\ufeb9(stringBuilder, object2);
                                    \ufee1\u0639\u063a\u0645.\ufef1\u062c\u0638\u062f(object, \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(stringBuilder));
                                    return object2;
                                }
                                case 471: 
                            }
                            break;
                        }
                        break;
                    }
                    return new JSONObject();
                }
                case 239: 
            }
            break;
        }
        return new JSONObject();
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private String M(JSONObject object, String ... stringArray) {
        void var1_3;
        String string;
        void var2_5;
        int n = ((void)var2_5).length;
        int n2 = 0;
        block22: while (true) {
            string = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
            int n3 = 1616;
            block23: while (true) {
                switch (n3 ^= 0x661) {
                    default: {
                        continue block23;
                    }
                    case 49: {
                        if (n2 < n) {
                            n3 = 1709;
                            continue block23;
                        }
                    }
                    case 14: {
                        n3 = 1678;
                        continue block23;
                    }
                    case 204: {
                        string = \ufed9\ufe9d\ufeed\ufeb5.\ufe95\ufeaf\u0641\ufe99(object, var2_5[n2], string);
                        boolean bl = \ufeed\ufebd\u0635\ufedd.\u0637\ufe8e\ufee1\ufebd(string);
                        n3 = 1740;
                        block24: while (true) {
                            switch (n3 ^= 0x6DD) {
                                default: {
                                    continue block24;
                                }
                                case 17: {
                                    if (!bl) {
                                        n3 = 1833;
                                        continue block24;
                                    }
                                }
                                case 54: {
                                    n3 = 1802;
                                    continue block24;
                                }
                                case 500: {
                                    bl = \u0636\u0634\ufec1\u0631.\u0646\u062a\ufeab\ufef1(\u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(App99.\u0628\ufea5\u062a\ufec5(), 304, 4, 3205), string);
                                    n3 = 1864;
                                    block25: while (true) {
                                        switch (n3 ^= 0x759) {
                                            default: {
                                                continue block25;
                                            }
                                            case 17: {
                                                if (!bl) {
                                                    n3 = 48736;
                                                    continue block25;
                                                }
                                            }
                                            case 47483: {
                                                n3 = 48705;
                                                continue block25;
                                            }
                                            case 47417: {
                                                String string2 = string;
                                                return var1_3;
                                            }
                                            case 47384: 
                                        }
                                        break;
                                    }
                                    break block24;
                                }
                                case 471: 
                            }
                            break;
                        }
                        int n4 = n2 + 1;
                        n3 = 48767;
                        block26: while (true) {
                            n2 = n4;
                            switch (n3 ^= 0xBE90) {
                                case 14: {
                                    continue block22;
                                }
                                default: {
                                    continue block26;
                                }
                                case 239: 
                            }
                            n3 = 48798;
                        }
                    }
                    case 239: 
                }
                break;
            }
            break;
        }
        String string3 = string;
        return var1_3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String N(String object, String object2) {
        object = \ufec1\u0636\u062d\u0638.\u0636\ufe99\u0628\ufe8f(object, 2);
        int n = ((Object)object).length;
        int n2 = 1616;
        block10: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n >= 16) {
                        n2 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block10;
                }
                case 204: {
                    byte[] byArray = \u062a\ufee1\ufe8e\ufeb9.\ufec1\u062d\ufeed\u0627(object, 0, 16);
                    object = \u062a\ufee1\ufe8e\ufeb9.\ufec1\u062d\ufeed\u0627(object, 16, ((Object)object).length);
                    object2 = new SecretKeySpec(App99.\ufeb1\ufee9\ufe95\u0639((Object)this, object2), \u0631\u0640\ufec1\ufee9.\ufe95\ufeed\u062c\ufec1(App99.\u0628\ufea5\u062a\ufec5(), 308, 3, 2993));
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(byArray);
                    Cipher cipher = \u0633\u064a\u0644\u0637.\u0638\ufec9\ufebd\u0645(\ufe95\u0627\ufe8e\u0644.\u062d\u0636\ufea9\u0640(App99.\u0628\ufea5\u062a\ufec5(), 311, 20, 520));
                    \ufea5\ufea9\u0633\ufed5.\u0648\u062d\u0643\ufeb1(cipher, 2, object2, ivParameterSpec);
                    object2 = \u0632\ufead\u062f\u0628.\u062b\u0638\ufeb9\ufeaf(cipher, object);
                    try {
                        return App99.\u062c\u0627\u0646\ufe8f((Object)this, object2);
                    }
                    catch (Exception exception) {
                        try {
                            return new String((byte[])object2, \u062d\ufeb9\ufeab\ufef1.\ufe8f\ufe99\u0645\u0627());
                        }
                        catch (Exception exception2) {
                            return new String((byte[])object2, \u0646\ufecd\ufead\u0647.\u0640\u062e\ufed5\ufeaf(App99.\u0628\ufea5\u062a\ufec5(), 331, 10, 1549));
                        }
                    }
                }
                case 239: 
            }
            break;
        }
        throw new Exception(\ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(App99.\u0628\ufea5\u062a\ufec5(), 341, 25, 483));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String SN(String string) {
        int n = 1616;
        block10: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (string == null) {
                        n = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block10;
                }
                case 204: {
                    return \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
                }
                case 239: 
            }
            break;
        }
        String string2 = \ufe99\u062e\u0642\u0644.\u062d\ufead\u0644\ufec5(string);
        try {
            return App99.\ufeaf\ufed5\u062d\u0638((Object)this, string2, App99.\ufe8f\u0638\ufec1\u0644((Object)this));
        }
        catch (Exception exception) {
            try {
                return App99.\ufeaf\ufed5\u062d\u0638((Object)this, string2, null);
            }
            catch (Exception exception2) {
                throw new Exception(\ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(App99.\u0628\ufea5\u062a\ufec5(), 366, 14, 2692), exception2);
            }
        }
    }

    /*
     * Recovered potentially malformed switches.  Disable with '--allowmalformedswitch false'
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String W(byte[] var1_1) {
        var5_3 = new Inflater();
        \u062d\ufeb9\ufeab\ufef1.\u0633\ufeb1\ufebd\u0646(var5_3, var1_1 /* !! */ );
        var1_1 /* !! */  = (byte[])new ByteArrayOutputStream(var1_1 /* !! */ .length);
        var6_4 = new byte[1024];
        block39: while (true) {
            try {
                var4_7 = \u062b\ufec1\ufeb1\u062d.\u0627\u062d\u0639\ufec9(var5_3);
                var2_5 = 1616;
            }
            catch (Throwable var1_2) {
                block50: {
                    break block50;
lbl66:
                    // 1 sources

                    block43: while (true) {
                        switch (var2_5 ^= 48784) {
                            default: {
                                continue block43;
                            }
                            case 14: {
                                break block43;
                            }
                            case 239: {
                                var2_5 = 48798;
                                continue block43;
                            }
                        }
                        break;
                    }
lbl75:
                    // 2 sources

                    \u0630\ufebd\u0634\ufec9.\u0637\u0635\u062c\ufec9(var5_3);
                    return \ufe8e\u0627\ufecd\u062a.\u062a\u0645\ufea9\u0637(var1_1 /* !! */ , \u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(App99.\u0628\ufea5\u062a\ufec5(), 380, 5, 3227));
lbl77:
                    // 1 sources

                    block44: while (true) {
                        switch (var2_5 ^= 48908) {
                            case 22: {
                                continue block39;
                            }
                            default: {
                                continue block44;
                            }
                            case 503: 
                        }
                        var2_5 = 48922;
                    }
                }
                \u0630\ufebd\u0634\ufec9.\u0637\u0635\u062c\ufec9(var5_3);
                var2_5 = 49666;
                block45: while (true) {
                    switch (var2_5 ^= 49683) {
                        default: {
                            continue block45;
                        }
                        case 17: {
                            var2_5 = 49697;
                            continue block45;
                        }
                        case 50: 
                    }
                    break;
                }
                var2_5 = 49790;
                block46: while (true) {
                    switch (var2_5 ^= 49807) {
                        default: {
                            continue block46;
                        }
                        case 241: {
                            var2_5 = 49821;
                            continue block46;
                        }
                        case 18: 
                    }
                    break;
                }
                throw var1_2;
            }
            block40: while (true) {
                switch (var2_5 ^= 1633) {
                    default: {
                        continue block40;
                    }
                    case 49: {
                        if (!var4_7) {
                            var2_5 = 1709;
                            continue block40;
                        }
                    }
                    case 14: {
                        var2_5 = 1678;
                        continue block40;
                    }
                    case 204: {
                        var3_6 = \ufeab\u0632\u062f\u0640.\u0637\u0646\u062c\ufead(var5_3, var6_4);
                        var2_5 = 1740;
                        break block40;
                    }
                    case 239: {
                        ** GOTO lbl75
                    }
                }
                break;
            }
            block41: while (true) {
                switch (var2_5 ^= 1757) {
                    default: {
                        continue block41;
                    }
                    case 17: {
                        if (var3_6 == 0) {
                            var2_5 = 1833;
                            continue block41;
                        }
                    }
                    case 54: {
                        var2_5 = 1802;
                        continue block41;
                    }
                    case 500: {
                        var4_7 = \u0630\ufebd\u0634\ufec9.\ufea1\u0641\u0630\ufef1(var5_3);
                        var2_5 = 1864;
                        break block41;
                    }
                    case 471: {
                        ** GOTO lbl-1000
                    }
                }
                break;
            }
            block42: while (true) {
                switch (var2_5 ^= 1881) {
                    default: {
                        continue block42;
                    }
                    case 17: {
                        if (var4_7) {
                            var2_5 = 48736;
                            continue block42;
                        }
                    }
                    case 47483: {
                        var2_5 = 48705;
                        continue block42;
                    }
                    case 47417: {
                        var2_5 = 48767;
                        ** GOTO lbl66
                    }
                    case 47384: lbl-1000:
                    // 2 sources

                    {
                        \u062b\u064a\ufecd\u0642.\u064a\u062b\u0639\ufee9(var1_1 /* !! */ , var6_4, 0, var3_6);
                        var2_5 = 48891;
                        ** GOTO lbl77
                    }
                }
                break;
            }
            break;
        }
    }

    private String dT() {
        return \u0630\ufebd\u0634\ufec9.\ufea9\u062f\u0648\u062d(\ufe99\u062c\u0643\ufec1.\ufedd\u0641\u062b\ufea9());
    }

    /*
     * Exception decompiling
     */
    private String ee(String var1_1, String var2_4, Map<String, String> var3_6) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 10[TRYBLOCK] [11 : 618->626)] java.lang.Exception
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
    private int i(JSONObject var1_1) {
        var4_2 = 0;
        var2_3 = 1616;
        block56: while (true) {
            switch (var2_3 ^= 1633) {
                default: {
                    continue block56;
                }
lbl7:
                // 2 sources

                case 14: {
                    var2_3 = 1678;
                    continue block56;
                }
                case 49: {
                    if (var1_1 != null) ** GOTO lbl7
                    var2_3 = 1709;
                    continue block56;
                }
                case 204: {
                    var2_3 = 1;
lbl16:
                    // 4 sources

                    return var2_3;
                }
                case 239: 
            }
            break;
        }
        var8_4 = \ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(App99.\u0628\ufea5\u062a\ufec5(), 416, 10, 2946);
        var9_7 = \u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(App99.\u0628\ufea5\u062a\ufec5(), 426, 9, 1031);
        var10_8 = \u0633\u064a\u0644\u0637.\ufec9\ufeed\ufeb5\u0640(App99.\u0628\ufea5\u062a\ufec5(), 435, 9, 2568);
        var7_9 = new String[]{var8_4, var9_7, var10_8};
        var3_10 = 0;
        block59: while (true) {
            var2_3 = 1740;
            block60: while (true) {
                switch (var2_3 ^= 1757) {
                    default: {
                        continue block60;
                    }
                    case 17: {
                        if (var3_10 < 3) {
                            var2_3 = 1833;
                            continue block60;
                        }
                    }
                    case 54: {
                        var2_3 = 1802;
                        continue block60;
                    }
                    case 500: {
                        var8_4 = var7_9[var3_10];
                        var6_12 = \ufeb9\u0643\ufed9\ufed5.\u0636\u0647\ufee9\ufeed(var1_1, var8_4);
                        var2_3 = 1864;
                        block61: while (true) {
                            switch (var2_3 ^= 1881) {
                                default: {
                                    continue block61;
                                }
                                case 17: {
                                    if (var6_12) {
                                        var2_3 = 48736;
                                        continue block61;
                                    }
                                }
                                case 47483: {
                                    var2_3 = 48705;
                                    continue block61;
                                }
                                case 47417: {
                                    var2_3 = \u062f\ufead\ufeaf\u062d.\ufeed\u062d\u0637\u0641(\ufeab\u0632\u062f\u0640.\ufeab\u0632\ufec5\u0645(var1_1, var8_4));
                                    ** GOTO lbl16
                                }
                                case 47384: 
                            }
                            break;
                        }
lbl57:
                        // 2 sources

                        while (true) {
                            var5_11 = var3_10 + 1;
                            var2_3 = 48767;
                            block63: while (true) {
                                var3_10 = var5_11;
                                switch (var2_3 ^= 48784) {
                                    case 14: {
                                        continue block59;
                                    }
                                    default: {
                                        continue block63;
                                    }
                                    case 239: 
                                }
                                var2_3 = 48798;
                            }
                            break;
                        }
                    }
                    case 471: 
                }
                break;
            }
            break;
        }
        var1_1 = \u0638\ufead\u062e\ufee1.\ufeb1\ufe99\ufe8f\u062a(var1_1, \u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(App99.\u0628\ufea5\u062a\ufec5(), 444, 4, 509));
        var2_3 = 48891;
        block64: while (true) {
            var3_10 = var4_2;
            switch (var2_3 ^= 48908) {
                default: {
                    continue block64;
                }
lbl78:
                // 2 sources

                case 22: {
                    var2_3 = 48953;
                    continue block64;
                }
                case 503: {
                    if (var1_1 == null) ** GOTO lbl78
                    var2_3 = 49635;
                    continue block64;
                }
                case 32495: {
                    block66: while (true) {
                        var2_3 = 49666;
                        block67: while (true) {
                            switch (var2_3 ^= 49683) {
                                default: {
                                    continue block67;
                                }
                                case 17: {
                                    if (var3_10 < 3) {
                                        var2_3 = 49759;
                                        continue block67;
                                    }
                                }
                                case 50: {
                                    var2_3 = 49728;
                                    continue block67;
                                }
                                case 76: {
                                    var8_4 = var7_9[var3_10];
                                    var6_12 = \ufeb9\u0643\ufed9\ufed5.\u0636\u0647\ufee9\ufeed(var1_1, var8_4);
                                    var2_3 = 49790;
                                    block68: while (true) {
                                        switch (var2_3 ^= 49807) {
                                            default: {
                                                continue block68;
                                            }
lbl107:
                                            // 2 sources

                                            case 18: {
                                                var2_3 = 49852;
                                                continue block68;
                                            }
                                            case 241: {
                                                if (!var6_12) ** GOTO lbl107
                                                var2_3 = 49883;
                                                continue block68;
                                            }
                                            case 84: {
                                                var2_3 = \u062f\ufead\ufeaf\u062d.\ufeed\u062d\u0637\u0641(\ufeab\u0632\u062f\u0640.\ufeab\u0632\ufec5\u0645(var1_1, var8_4));
                                                ** GOTO lbl16
                                            }
                                            case 51: 
                                        }
                                        break;
                                    }
lbl119:
                                    // 2 sources

                                    while (true) {
                                        var4_2 = var3_10 + 1;
                                        var2_3 = 49914;
                                        block71: while (true) {
                                            var3_10 = var4_2;
                                            switch (var2_3 ^= 49931) {
                                                case 1711: {
                                                    continue block66;
                                                }
                                                default: {
                                                    continue block71;
                                                }
                                                case 497: 
                                            }
                                            var2_3 = 50596;
                                        }
                                        break;
                                    }
                                }
                                case 83: 
                            }
                            break;
                        }
                        break;
                    }
                }
                case 53: 
            }
            break;
        }
        var2_3 = 1;
        ** while (true)
        catch (Exception var8_5) {
            var2_3 = 50689;
            block72: while (true) {
                switch (var2_3 ^= 50706) {
                    case 50: {
                        ** continue;
                    }
                    default: {
                        continue block72;
                    }
                    case 19: 
                }
                var2_3 = 50720;
            }
        }
        catch (Exception var8_6) {
            var2_3 = 50813;
            block73: while (true) {
                switch (var2_3 ^= 50830) {
                    case 18: {
                        ** continue;
                    }
                    default: {
                        continue block73;
                    }
                    case 243: 
                }
                var2_3 = 50844;
            }
        }
    }

    /*
     * Exception decompiling
     */
    private String q(String var1_1, JSONObject var2_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [8[CASE]], but top level block is 1[TRYBLOCK]
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
    private byte[] t0(String var1_1) {
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
    private String tF(String object) {
        try {
            byte[] byArray = App99.\ufeb1\ufee9\ufe95\u0639((Object)this, null);
            Object object2 = new SecretKeySpec(byArray, \u0646\ufecd\ufead\u0647.\u0640\u062e\ufed5\ufeaf(App99.\u0628\ufea5\u062a\ufec5(), 468, 3, 499));
            byArray = new byte[16];
            Object object3 = new SecureRandom();
            \ufe99\u062e\u0642\u0644.\u0647\u0640\ufed9\u0643(object3, byArray);
            object3 = new IvParameterSpec(byArray);
            Cipher cipher = \u0633\u064a\u0644\u0637.\u0638\ufec9\ufebd\u0645(\u0633\u064a\u0644\u0637.\ufec9\ufeed\ufeb5\u0640(App99.\u0628\ufea5\u062a\ufec5(), 471, 20, 2692));
            \ufea5\ufea9\u0633\ufed5.\u0648\u062d\u0643\ufeb1(cipher, 1, object2, object3);
            object2 = \u0632\ufead\u062f\u0628.\u062b\u0638\ufeb9\ufeaf(cipher, \u0631\u0640\ufec1\ufee9.\ufea1\ufef1\u0630\u063a(object, \u062d\ufeb9\ufeab\ufef1.\ufe8f\ufe99\u0645\u0627()));
            object = new byte[((Object)object2).length + 16];
            \ufeb9\u0627\ufea5\ufe9d.\u0634\ufeb5\u0641\u062b(byArray, 0, object, 0, 16);
            \ufeb9\u0627\ufea5\ufe9d.\u0634\ufeb5\u0641\u062b(object2, 0, object, 16, ((Object)object2).length);
            return \ufee1\u0639\u063a\u0645.\u0637\u0638\ufed5\ufe99(object, 2);
        }
        catch (Exception exception) {
            \ufed9\ufe8e\u062d\ufead.\u062b\ufe8e\u062d\u0645(exception);
            return \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
        }
    }

    /*
     * Exception decompiling
     */
    private String v(String var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 8[TRYBLOCK] [8 : 421->430)] java.lang.Exception
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
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private JSONArray v3(JSONArray var1_1) {
        var3_2 = 0;
        var8_3 = new JSONArray();
        block39: while (true) {
            block52: {
                block54: {
                    block55: {
                        block53: {
                            var4_5 = \u0644\ufe8f\u0628\u062a.\ufee9\ufe8e\ufe99\u0631(var1_1);
                            var2_4 = 1616;
                            block40: while (true) {
                                switch (var2_4 ^= 1633) {
                                    default: {
                                        continue block40;
                                    }
                                    case 49: {
                                        if (var3_2 < var4_5) {
                                            var2_4 = 1709;
                                            continue block40;
                                        }
                                    }
                                    case 14: {
                                        var2_4 = 1678;
                                        continue block40;
                                    }
                                    case 204: {
                                        var10_11 = \u0632\ufead\u062f\u0628.\ufead\u062b\ufeb1\u0644(var1_1, var3_2);
                                        var2_4 = 1740;
                                        block41: while (true) {
                                            switch (var2_4 ^= 1757) {
                                                default: {
                                                    continue block41;
                                                }
                                                case 17: {
                                                    if (var10_11 != null) {
                                                        var2_4 = 1833;
                                                        continue block41;
                                                    }
                                                }
                                                case 54: {
                                                    var2_4 = 1802;
                                                    continue block41;
                                                }
                                                case 500: {
                                                    var6_7 = \ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644(App99.\u0628\ufea5\u062a\ufec5(), 501, 11, 1172);
                                                    var11_12 = \u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(App99.\u0628\ufea5\u062a\ufec5(), 512, 7, 1360);
                                                    var9_10 = \u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(App99.\u0628\ufea5\u062a\ufec5(), 519, 8, 1506);
                                                    var12_13 = \u062d\ufeb9\ufeab\ufef1.\ufeed\u0638\u0635\ufed5(App99.\u0628\ufea5\u062a\ufec5(), 527, 6, 1335);
                                                    var7_9 = new JSONObject();
                                                    \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(var7_9, var12_13, App99.\u0627\u0648\ufecd\ufee9((Object)this, var10_11, new String[]{\ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(App99.\u0628\ufea5\u062a\ufec5(), 533, 2, 771), var12_13}));
                                                    var12_13 = App99.\u0627\u0648\ufecd\ufee9((Object)this, var10_11, new String[]{\ufe8f\ufe8e\ufeb5\u0641.\u062f\u0627\u0640\ufee1(App99.\u0628\ufea5\u062a\ufec5(), 535, 4, 1466), var9_10, \u0632\ufead\u062f\u0628.\u0645\u062a\u0637\u0635(App99.\u0628\ufea5\u062a\ufec5(), 539, 5, 2042)});
                                                    var5_6 = \u0635\u0631\u0645\u0628.\ufead\ufee9\u0643\u0632(var12_13);
                                                    var2_4 = 1864;
                                                    break block40;
                                                }
                                                case 471: 
                                            }
                                            break;
                                        }
                                        break block52;
                                    }
                                    case 239: {
                                        return var8_3;
                                    }
                                }
                                break;
                            }
                            block42: while (true) {
                                switch (var2_4 ^= 1881) {
                                    default: {
                                        continue block42;
                                    }
                                    case 17: {
                                        if (var5_6) {
                                            var2_4 = 48736;
                                            continue block42;
                                        }
                                    }
                                    case 47483: {
                                        var2_4 = 48705;
                                        continue block42;
                                    }
                                    case 47417: {
                                        var7_9 = null;
                                        var2_4 = 48767;
                                        break block53;
                                    }
                                    case 47384: {
                                        \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(var7_9, var9_10, var12_13);
                                        \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(var7_9, var11_12, App99.\u0627\u0648\ufecd\ufee9((Object)this, var10_11, new String[]{\ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(App99.\u0628\ufea5\u062a\ufec5(), 544, 3, 2111), var11_12, \ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(App99.\u0628\ufea5\u062a\ufec5(), 547, 5, 1857)}));
                                        \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(var7_9, var6_7, App99.\u0627\u0648\ufecd\ufee9((Object)this, var10_11, new String[]{\ufe95\u0627\ufe8e\u0644.\u062d\u0636\ufea9\u0640(App99.\u0628\ufea5\u062a\ufec5(), 552, 7, 1008), var6_7, \ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(App99.\u0628\ufea5\u062a\ufec5(), 559, 4, 1413)}));
                                        var2_4 = 48891;
                                        break block54;
                                    }
                                }
                                break;
                            }
                            catch (Exception var6_8) {
                                var6_7 = var7_9;
                                break block55;
                            }
                        }
                        block43: while (true) {
                            var6_7 = var7_9;
                            switch (var2_4 ^= 48784) {
                                default: {
                                    continue block43;
                                }
                                case 14: {
                                    break block43;
                                }
                                case 239: {
                                    var2_4 = 48798;
                                    continue block43;
                                }
                            }
                            break;
                        }
                    }
lbl88:
                    // 2 sources

                    while (true) {
                        var2_4 = 49666;
                        block45: while (true) {
                            switch (var2_4 ^= 49683) {
                                default: {
                                    continue block45;
                                }
                                case 17: {
                                    if (var6_7 != null) {
                                        var2_4 = 49759;
                                        continue block45;
                                    }
                                }
                                case 50: {
                                    var2_4 = 49728;
                                    continue block45;
                                }
                                case 76: {
                                    \u0630\ufebd\u0634\ufec9.\u0645\ufead\u0635\u0634(var8_3, var6_7);
                                }
                                case 83: 
                            }
                            break;
                        }
                        break block52;
                        break;
                    }
                }
                block46: while (true) {
                    var6_7 = var7_9;
                    switch (var2_4 ^= 48908) {
                        case 22: {
                            ** continue;
                        }
                        default: {
                            continue block46;
                        }
                        case 503: 
                    }
                    var2_4 = 48922;
                }
            }
            var4_5 = var3_2 + 1;
            var2_4 = 49790;
            block47: while (true) {
                var3_2 = var4_5;
                switch (var2_4 ^= 49807) {
                    case 18: {
                        continue block39;
                    }
                    default: {
                        continue block47;
                    }
                    case 241: 
                }
                var2_4 = 49821;
            }
            break;
        }
    }

    /*
     * Exception decompiling
     */
    private String[] yq(JSONObject var1_1) {
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
    private JSONArray zH(JSONObject jSONObject) {
        int n;
        JSONObject jSONObject2;
        int n2;
        String string = \ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(App99.\u0628\ufea5\u062a\ufec5(), 655, 4, 373);
        String string2 = \ufea5\u062d\ufebd\u0633.\ufea5\ufeb1\u0643\ufe8f(App99.\u0628\ufea5\u062a\ufec5(), 659, 4, 1655);
        String string3 = \u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(App99.\u0628\ufea5\u062a\ufec5(), 663, 5, 2554);
        String string4 = \ufebd\u0640\u0648\u062b.\ufea5\u0639\u0631\ufe95(App99.\u0628\ufea5\u062a\ufec5(), 668, 6, 1072);
        int n3 = 0;
        block38: while (true) {
            n2 = 1616;
            block39: while (true) {
                switch (n2 ^= 0x661) {
                    default: {
                        continue block39;
                    }
                    case 49: {
                        if (n3 < 4) {
                            n2 = 1709;
                            continue block39;
                        }
                    }
                    case 14: {
                        n2 = 1678;
                        continue block39;
                    }
                    case 204: {
                        jSONObject2 = \u0630\ufebd\u0634\ufec9.\u0642\u0627\u0645\u0643(jSONObject, (new String[]{string, string2, string3, string4})[n3]);
                        n2 = 1740;
                        block40: while (true) {
                            switch (n2 ^= 0x6DD) {
                                default: {
                                    continue block40;
                                }
                                case 17: {
                                    if (jSONObject2 != null) {
                                        n2 = 1833;
                                        continue block40;
                                    }
                                }
                                case 54: {
                                    n2 = 1802;
                                    continue block40;
                                }
                                case 500: {
                                    return jSONObject2;
                                }
                                case 471: 
                            }
                            break;
                        }
                        n = n3 + 1;
                        n2 = 1864;
                        block41: while (true) {
                            n3 = n;
                            switch (n2 ^= 0x759) {
                                case 47483: {
                                    continue block38;
                                }
                                default: {
                                    continue block41;
                                }
                                case 17: 
                            }
                            n2 = 48674;
                        }
                    }
                    case 239: 
                }
                break;
            }
            break;
        }
        jSONObject2 = \u0638\ufead\u062e\ufee1.\ufeb1\ufe99\ufe8f\u062a(jSONObject, string);
        n2 = 48767;
        block42: while (true) {
            switch (n2 ^= 0xBE90) {
                default: {
                    continue block42;
                }
                case 239: {
                    if (jSONObject2 != null) {
                        n2 = 48860;
                        continue block42;
                    }
                }
                case 14: {
                    n2 = 48829;
                    continue block42;
                }
                case 76: {
                    n3 = 0;
                    block43: while (true) {
                        n2 = 48891;
                        block44: while (true) {
                            switch (n2 ^= 0xBF0C) {
                                default: {
                                    continue block44;
                                }
                                case 503: {
                                    if (n3 < 3) {
                                        n2 = 49635;
                                        continue block44;
                                    }
                                }
                                case 22: {
                                    n2 = 48953;
                                    continue block44;
                                }
                                case 32495: {
                                    jSONObject = \u0630\ufebd\u0634\ufec9.\u0642\u0627\u0645\u0643(jSONObject2, (new String[]{string2, string3, string})[n3]);
                                    n2 = 49666;
                                    block45: while (true) {
                                        switch (n2 ^= 0xC213) {
                                            default: {
                                                continue block45;
                                            }
                                            case 17: {
                                                if (jSONObject != null) {
                                                    n2 = 49759;
                                                    continue block45;
                                                }
                                            }
                                            case 50: {
                                                n2 = 49728;
                                                continue block45;
                                            }
                                            case 76: {
                                                return jSONObject;
                                            }
                                            case 83: 
                                        }
                                        break;
                                    }
                                    n = n3 + 1;
                                    n2 = 49790;
                                    block46: while (true) {
                                        n3 = n;
                                        switch (n2 ^= 0xC28F) {
                                            case 18: {
                                                continue block43;
                                            }
                                            default: {
                                                continue block46;
                                            }
                                            case 241: 
                                        }
                                        n2 = 49821;
                                    }
                                }
                                case 53: 
                            }
                            break;
                        }
                        break;
                    }
                    return new JSONArray();
                }
                case 45: 
            }
            break;
        }
        return new JSONArray();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String \u0627\u062c\ufea9\u0646(Object object) {
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
    public static String \u0627\u0648\ufecd\ufee9(Object object, Object object2, Object object3) {
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
                    return ((App99)((Object)object)).M((JSONObject)object2, (String[])object3);
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
    public static short[] \u0628\ufea5\u062a\ufec5() {
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
    public static String \u0628\ufea9\u0633\u0640(Object object, Object object2) {
        int n = \ufebd\u0640\u0648\u062b.\u0633\u0637\u0632\ufeab();
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
                    return ((App99)((Object)object)).v((String)object2);
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
    public static String \u062c\u0627\u0646\ufe8f(Object object, Object object2) {
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
                    return ((App99)((Object)object)).W((byte[])object2);
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
    public static String \u062c\ufeb9\u0637\u0644(Object object, Object object2) {
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
                    return ((App99)((Object)object)).SN((String)object2);
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
    public static String \u062d\ufeed\ufead\u0641(Object object) {
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
                    return ((App99)((Object)object)).t0;
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
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public static String[] \u062e\u0635\u0632\u0646(Object object, Object object2) {
        void var0_2;
        Object var1_5;
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
                    String[] stringArray = ((App99)((Object)object)).yq(var1_5);
                    return var0_2;
                }
                case 239: 
            }
            break;
        }
        var1_5 = null;
        n2 = 1740;
        block11: while (true) {
            Object var0_4 = var1_5;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return var0_2;
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
    public static String \u062e\ufed5\ufec9\u0635(Object object) {
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
                    return ((App99)((Object)object)).B;
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
    public static Request.Builder \u062f\ufed5\u062b\ufebd(Object object, Object object2) {
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
    public static JSONArray \u0630\u063a\ufea1\u0638(Object object, Object object2) {
        int n = \ufe8e\ufeb9\u0647\u0642.\ufe99\u062b\ufea1\u0647();
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
                    return ((App99)((Object)object)).zH((JSONObject)object2);
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
    public static int \u0631\u062e\u0635\u0640(Object object) {
        int n = \ufeed\ufebd\u0635\ufedd.\ufe8e\u0628\u0638\u0631();
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
                    return ((App99)((Object)object)).G;
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
    public static HashMap \u0633\u062d\u0646\ufeb5(Object map) {
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
                    return ((App99)((Object)map)).dT;
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
    public static String \u0634\ufeaf\u0633\u062c(Object object) {
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
                    return ((App99)((Object)object)).tF;
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
    public static OkHttpClient \u0636\u0631\ufeed\u0639(Object object) {
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
                    return ((App99)((Object)object)).W;
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
    public static OkHttpClient.Builder \u0636\ufeed\u0640\u0639(Object object, long l, Object object2) {
        int n = \u0630\ufebd\u0634\ufec9.\u062f\ufe8f\u0630\ufed5();
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
                    return ((OkHttpClient.Builder)object).readTimeout(l, (TimeUnit)((Object)object2));
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
    public static String \u0637\ufee1\u062e\ufea1(Object object) {
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
                    return ((App99)((Object)object)).N;
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
    public static Request.Builder \u0639\ufef1\ufe99\ufee9(Object object, Object object2) {
        int n = \u0640\u0633\ufea5\u0631.\ufe8f\ufed9\ufec5\ufe9d();
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
    public static HashMap \u063a\ufe8f\ufecd\u0630(Object map) {
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
                    return ((App99)((Object)map)).G4;
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
    public static Call \u0640\u0628\u0630\u062b(Object object, Object object2) {
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
    public static ResponseBody \u0640\u0645\ufec1\u0644(Object object) {
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
    public static Request \u0640\u0646\u0638\u062f(Object object) {
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
    public static Request.Builder \u0640\ufeb1\ufec9\u0636(Object object, Object object2, Object object3) {
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
    public static String \u0640\ufec1\ufea9\u0637(Object object) {
        int n = \u0640\u0633\ufea5\u0631.\ufe8f\ufed9\ufec5\ufe9d();
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
                    return ((App99)((Object)object)).KJ;
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
    public static JSONObject \u0641\ufec5\ufeb9\ufed5(Object object, Object object2) {
        int n = \ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633();
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
                    return ((App99)((Object)object)).KJ((String)object2);
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
    public static void \u0642\ufeaf\u0644\ufec9(Object object) {
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
                    ((Response)object).close();
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
    public static void \u0644\u0630\u0637\u062b(Object object, Object object2) {
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
                    ((App99)((Object)object)).F5((JSONObject)object2);
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
    public static String \u0645\ufec1\ufed5\u0634(Object object) {
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
                    return ((App99)((Object)object)).yq;
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
    public static boolean \u064a\u0646\u0644\u0643(Object object) {
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
    public static Response \ufe8e\u0635\u0648\u0647(Object object) {
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
    public static String \ufe8e\u0640\ufec1\u064a(Object object) {
        int n = \ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646();
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
                    return ((App99)((Object)object)).M;
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
    public static String \ufe8f\u0638\ufec1\u0644(Object object) {
        int n = \ufea1\u0645\u062b\u0634.\ufec1\u0634\ufecd\u0643();
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
                    return ((App99)((Object)object)).q;
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
    public static HashMap \ufe8f\ufead\ufecd\ufea1(Object map) {
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
                    return ((App99)((Object)map)).F5;
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
    public static Map \ufe95\u0638\ufeb5\ufed9(Object object, Object object2, Object object3, Object object4) {
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
                    return ((App99)((Object)object)).G((String)object2, (String)object3, (String)object4);
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
    public static JSONArray \ufe9d\u0642\ufe95\ufeed(Object object, Object object2) {
        int n = \ufeb5\ufe8e\ufead\u0632.\ufe95\u0647\u062d\u0631();
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
                    return ((App99)((Object)object)).v3((JSONArray)object2);
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
    public static String \ufe9d\ufec9\ufeed\ufedd(Object object, Object object2) {
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
                    return ((App99)((Object)object)).tF((String)object2);
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
    public static OkHttpClient.Builder \ufea1\u0630\u0628\u0636(Object object, long l, Object object2) {
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
                    return ((OkHttpClient.Builder)object).connectTimeout(l, (TimeUnit)((Object)object2));
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
    public static JSONArray \ufea5\u062b\u0636\ufeb5(Object object) {
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
                    return ((App99)((Object)object)).v3;
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
    public static int \ufea5\u062b\u0647\ufec1(Object object, Object object2) {
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
                    return ((App99)((Object)object)).i((JSONObject)object2);
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
    public static MediaType \ufea5\u064a\ufe8e\ufe95(Object object) {
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
                    return MediaType.parse((String)((String)object));
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
    public static String \ufea9\u0636\ufed9\ufed5(Object object) {
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
                    return ((App99)((Object)object)).SN;
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
    public static String \ufeab\ufeed\u0632\u062d(Object object) {
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
                    return ((App99)((Object)object)).zH;
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
    public static String \ufead\ufeab\u062a\u0636(Object object) {
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
                    return ((App99)((Object)object)).i;
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
    public static String \ufead\ufee1\u062e\u0636(Object object, Object object2, Object object3) {
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
                    return ((App99)((Object)object)).q((String)object2, (JSONObject)object3);
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
    public static String \ufeaf\ufe95\u0628\ufec9(Object object) {
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
                    return ((App99)((Object)object)).Gc();
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
    public static String \ufeaf\ufed5\u062d\u0638(Object object, Object object2, Object object3) {
        int n = \ufeaf\u062b\ufed5\ufec1.\ufeb9\ufee1\ufe8e\u064a();
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
                    return ((App99)((Object)object)).N((String)object2, (String)object3);
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
    public static byte[] \ufeb1\ufee9\ufe95\u0639(Object object, Object object2) {
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
                    return ((App99)((Object)object)).t0((String)object2);
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
    public static boolean \ufec9\u0644\ufead\ufeb1(Object object) {
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
                    return ((App99)((Object)object)).B();
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
    public static String \ufed5\u0627\ufe95\ufea5(Object object, Object object2, Object object3, Object object4) {
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
                    return ((App99)((Object)object)).ee((String)object2, (String)object3, (Map)object4);
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
    public static String \ufed5\u062b\u0643\u0634(Object object) {
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
                    return ((App99)((Object)object)).dT();
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
    public static OkHttpClient \ufed5\u0640\u063a\u064a(Object object) {
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
                    return ((OkHttpClient.Builder)object).build();
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
    public static boolean \ufedd\ufebd\u0627\u0636(Object object) {
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
                    return ((App99)((Object)object)).G4();
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
    public static RequestBody \ufee1\ufed9\u0648\u0628(Object object, Object object2) {
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
                    return RequestBody.create((MediaType)((MediaType)object), (String)((String)object2));
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
    public static String \ufeed\u0636\ufead\u0642(Object object) {
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
                    return ((App99)((Object)object)).Gc;
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
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String categoryContent(String string, String string2, boolean bl, HashMap<String, String> object) {
        object = \ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(App99.\u0628\ufea5\u062a\ufec5(), 674, 5, 892);
        String string3 = \u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(App99.\u0628\ufea5\u062a\ufec5(), 679, 4, 499);
        App99.\ufec9\u0644\ufead\ufeb1((Object)this);
        JSONObject jSONObject = new JSONObject();
        \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(jSONObject, \ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(App99.\u0628\ufea5\u062a\ufec5(), 683, 2, 2246), \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640());
        \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(jSONObject, string3, string2);
        \u062a\ufee1\ufe8e\ufeb9.\u0641\ufeb5\u062a\ufec1(jSONObject, object, 21);
        \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(jSONObject, \ufea9\ufe8f\u0647\ufead.\ufea9\u0643\ufedd\ufeed(App99.\u0628\ufea5\u062a\ufec5(), 685, 3, 3011), string);
        \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(jSONObject, \ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(App99.\u0628\ufea5\u062a\ufec5(), 688, 7, 1849), \u0646\ufecd\ufead\u0647.\u0640\u062e\ufed5\ufeaf(App99.\u0628\ufea5\u062a\ufec5(), 695, 4, 953));
        \u062a\ufee1\ufe8e\ufeb9.\u0641\ufeb5\u062a\ufec1(jSONObject, \ufeb9\u0627\ufea5\ufe9d.\u062a\ufef1\u062d\u0641(App99.\u0628\ufea5\u062a\ufec5(), 699, 10, 1471), 1);
        string = App99.\ufead\ufee1\u062e\u0636((Object)this, \u0645\u0641\u0630\u062d.\u0642\u062a\u0630\ufebd(App99.\u0628\ufea5\u062a\ufec5(), 709, 11, 421), jSONObject);
        int n = 1616;
        block16: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block16;
                }
                case 49: {
                    if (string != null) {
                        n = 1709;
                        continue block16;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block16;
                }
                case 204: {
                    bl = \ufeed\ufebd\u0635\ufedd.\u0637\ufe8e\ufee1\ufebd(string);
                    n = 1740;
                    break block16;
                }
                case 239: {
                    return \u062b\ufec1\ufeb1\u062d.\ufe99\ufeb5\ufead\u0637(\u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(App99.\u0628\ufea5\u062a\ufec5(), 738, 18, 1218), string2, \ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(App99.\u0628\ufea5\u062a\ufec5(), 756, 36, 1351));
                }
            }
            break;
        }
        block17: while (true) {
            switch (n ^= 0x6DD) {
                default: {
                    continue block17;
                }
                case 17: {
                    if (!bl) {
                        n = 1833;
                        continue block17;
                    }
                }
                case 54: {
                    n = 1802;
                    continue block17;
                }
                case 500: {
                    try {
                        jSONObject = new JSONObject(string);
                        int n2 = App99.\ufea5\u062b\u0647\ufec1((Object)this, jSONObject);
                        n = \u062f\ufead\ufeaf\u062d.\ufeed\u062d\u0637\u0641(string2);
                        jSONObject = App99.\ufe9d\u0642\ufe95\ufeed((Object)this, App99.\u0630\u063a\ufea1\u0638((Object)this, jSONObject));
                        string = new JSONObject();
                        \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(string, \ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(App99.\u0628\ufea5\u062a\ufec5(), 720, 4, 440), jSONObject);
                        \u062a\ufee1\ufe8e\ufeb9.\u0641\ufeb5\u062a\ufec1(string, string3, n);
                        \u062a\ufee1\ufe8e\ufeb9.\u0641\ufeb5\u062a\ufec1(string, \ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(App99.\u0628\ufea5\u062a\ufec5(), 724, 9, 493), n2);
                        \u062a\ufee1\ufe8e\ufeb9.\u0641\ufeb5\u062a\ufec1(string, object, 21);
                        \u062a\ufee1\ufe8e\ufeb9.\u0641\ufeb5\u062a\ufec1(string, \ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(App99.\u0628\ufea5\u062a\ufec5(), 733, 5, 2792), n2 * 21);
                        return \ufeaf\u0633\u0648\ufee9.\ufeb5\u0634\u0640\ufea1(string);
                    }
                    catch (Exception exception) {
                        \ufed9\ufe8e\u062d\ufead.\u062b\ufe8e\u062d\u0645(exception);
                    }
                }
                case 471: 
            }
            break;
        }
        return \u062b\ufec1\ufeb1\u062d.\ufe99\ufeb5\ufead\u0637(\u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(App99.\u0628\ufea5\u062a\ufec5(), 738, 18, 1218), string2, \ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(App99.\u0628\ufea5\u062a\ufec5(), 756, 36, 1351));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String detailContent(List<String> object) {
        boolean bl;
        Object object2;
        String string = \ufeb5\ufe8e\ufead\u0632.\ufe8f\ufef1\u0648\ufe95(App99.\u0628\ufea5\u062a\ufec5(), 792, 9, 2741);
        String string2 = \u0636\u0634\ufec1\u0631.\u062c\u063a\u0643\u0627(App99.\u0628\ufea5\u062a\ufec5(), 801, 11, 2043);
        String string3 = \u062d\u062e\ufe8e\u0645.\u062d\ufeab\u0642\u0647(App99.\u0628\ufea5\u062a\ufec5(), 812, 12, 2277);
        String string4 = \u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(App99.\u0628\ufea5\u062a\ufec5(), 824, 9, 2099);
        String string5 = \ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(App99.\u0628\ufea5\u062a\ufec5(), 833, 8, 2864);
        String string6 = \ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(App99.\u0628\ufea5\u062a\ufec5(), 841, 8, 1237);
        String string7 = \ufe99\u062c\u0643\ufec1.\u0648\u0634\u063a\ufeb1(App99.\u0628\ufea5\u062a\ufec5(), 849, 11, 760);
        String string8 = \ufeaf\u0633\u0648\ufee9.\u062e\u0645\u0644\u0648(App99.\u0628\ufea5\u062a\ufec5(), 860, 7, 1280);
        String string9 = \ufee9\u0631\ufeb5\u0628.\u0636\ufeab\u0634\u0633(App99.\u0628\ufea5\u062a\ufec5(), 867, 8, 2355);
        String string10 = \u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(App99.\u0628\ufea5\u062a\ufec5(), 875, 6, 1469);
        String string11 = \ufeb9\ufec9\u0648\u062d.\ufee9\u0637\ufef1\u0644(App99.\u0628\ufea5\u062a\ufec5(), 881, 2, 1321);
        JSONArray jSONArray = \ufe8f\ufe8e\ufeb5\u0641.\u062f\u0627\u0640\ufee1(App99.\u0628\ufea5\u062a\ufec5(), 883, 11, 2456);
        int n = 1616;
        block40: while (true) {
            object2 = jSONArray;
            switch (n ^= 0x661) {
                default: {
                    continue block40;
                }
                case 49: {
                    if (object != null) {
                        n = 1709;
                        continue block40;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block40;
                }
                case 204: {
                    bl = \ufeab\u0632\u062f\u0640.\u063a\ufea5\ufe99\ufeb1(object);
                    n = 1740;
                    break block40;
                }
                case 239: {
                    return object2;
                }
            }
            break;
        }
        block41: while (true) {
            switch (n ^= 0x6DD) {
                default: {
                    continue block41;
                }
                case 17: {
                    if (bl) {
                        n = 1833;
                        continue block41;
                    }
                }
                case 54: {
                    n = 1802;
                    continue block41;
                }
                case 500: {
                    n = 1864;
                    block42: while (true) {
                        object2 = jSONArray;
                        switch (n ^= 0x759) {
                            default: {
                                continue block42;
                            }
                            case 17: {
                                n = 48674;
                                continue block42;
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
        try {
            App99.\ufec9\u0644\ufead\ufeb1((Object)this);
            object2 = new JSONObject();
            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(object2, string11, \u0646\ufecd\ufead\u0647.\u0643\ufe8e\u0644\ufe95(object, 0));
            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(object2, \ufe99\u062c\u0643\ufec1.\u0648\u0634\u063a\ufeb1(App99.\u0628\ufea5\u062a\ufec5(), 894, 3, 1334), \ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(App99.\u0628\ufea5\u062a\ufec5(), 897, 1, 1938));
            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(object2, \ufeb9\u0643\ufed9\ufed5.\u0628\u062f\ufea1\u0642(App99.\u0628\ufea5\u062a\ufec5(), 898, 1, 614), \ufee9\u0631\ufeb5\u0628.\u0636\ufeab\u0634\u0633(App99.\u0628\ufea5\u062a\ufec5(), 899, 5, 562));
            \u062a\ufee1\ufe8e\ufeb9.\u0641\ufeb5\u062a\ufec1(object2, \ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(App99.\u0628\ufea5\u062a\ufec5(), 904, 2, 2117), 1);
            object = App99.\ufead\ufee1\u062e\u0636((Object)this, \u0630\ufebd\u0634\ufec9.\u0639\ufe8f\u064a\ufebd(App99.\u0628\ufea5\u062a\ufec5(), 906, 11, 3088), object2);
            n = 48767;
        }
        catch (Exception exception) {
            \ufed9\ufe8e\u062d\ufead.\u062b\ufe8e\u062d\u0645(exception);
            return jSONArray;
        }
        block43: while (true) {
            object2 = jSONArray;
            switch (n ^= 0xBE90) {
                default: {
                    continue block43;
                }
                case 239: {
                    if (object != null) {
                        n = 48860;
                        continue block43;
                    }
                }
                case 14: {
                    n = 48829;
                    continue block43;
                }
                case 76: {
                    JSONObject jSONObject;
                    bl = \ufeed\ufebd\u0635\ufedd.\u0637\ufe8e\ufee1\ufebd(object);
                    n = 48891;
                    block44: while (true) {
                        object2 = jSONArray;
                        switch (n ^= 0xBF0C) {
                            default: {
                                continue block44;
                            }
                            case 503: {
                                if (!bl) {
                                    n = 49635;
                                    continue block44;
                                }
                            }
                            case 22: {
                                n = 48953;
                                continue block44;
                            }
                            case 32495: {
                                object2 = new JSONObject((String)object);
                                jSONObject = \u0638\ufead\u062e\ufee1.\ufeb1\ufe99\ufe8f\u062a(object2, \ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(App99.\u0628\ufea5\u062a\ufec5(), 917, 4, 2991));
                                n = 49666;
                                break block44;
                            }
                            case 53: {
                                return object2;
                            }
                        }
                        break;
                    }
                    block45: while (true) {
                        object2 = jSONArray;
                        switch (n ^= 0xC213) {
                            default: {
                                continue block45;
                            }
                            case 17: {
                                if (jSONObject == null) {
                                    n = 49759;
                                    continue block45;
                                }
                            }
                            case 50: {
                                n = 49728;
                                continue block45;
                            }
                            case 83: {
                                object = new JSONObject();
                                \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(object, string10, App99.\u0627\u0648\ufecd\ufee9((Object)this, jSONObject, new String[]{string11, string10}));
                                \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(object, string9, App99.\u0627\u0648\ufecd\ufee9((Object)this, jSONObject, new String[]{\u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(App99.\u0628\ufea5\u062a\ufec5(), 921, 4, 2421), string9, \ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(App99.\u0628\ufea5\u062a\ufec5(), 925, 5, 2175)}));
                                \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(object, string8, App99.\u0627\u0648\ufecd\ufee9((Object)this, jSONObject, new String[]{\ufea9\ufe8f\u0647\ufead.\ufea9\u0643\ufedd\ufeed(App99.\u0628\ufea5\u062a\ufec5(), 930, 3, 2185), string8, \ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(App99.\u0628\ufea5\u062a\ufec5(), 933, 5, 2975)}));
                                \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(object, string7, App99.\u0627\u0648\ufecd\ufee9((Object)this, jSONObject, new String[]{\u0635\u0631\u0645\u0628.\u0646\u0627\u062a\u062d(App99.\u0628\ufea5\u062a\ufec5(), 938, 7, 2285), string7, \ufeb5\ufe8e\ufead\u0632.\ufe8f\ufef1\u0648\ufe95(App99.\u0628\ufea5\u062a\ufec5(), 945, 4, 412)}));
                                \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(object, string6, App99.\u0627\u0648\ufecd\ufee9((Object)this, jSONObject, new String[]{\ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(App99.\u0628\ufea5\u062a\ufec5(), 949, 4, 859), string6}));
                                \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(object, string5, App99.\u0627\u0648\ufecd\ufee9((Object)this, jSONObject, new String[]{\ufeb9\u0643\ufed9\ufed5.\u0628\u062f\ufea1\u0642(App99.\u0628\ufea5\u062a\ufec5(), 953, 4, 1378), string5}));
                                \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(object, string4, App99.\u0627\u0648\ufecd\ufee9((Object)this, jSONObject, new String[]{\u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(App99.\u0628\ufea5\u062a\ufec5(), 957, 5, 1103), string4}));
                                \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(object, string3, App99.\u0627\u0648\ufecd\ufee9((Object)this, jSONObject, new String[]{\u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(App99.\u0628\ufea5\u062a\ufec5(), 962, 8, 2612), string3}));
                                \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(object, string2, App99.\u0627\u0648\ufecd\ufee9((Object)this, jSONObject, new String[]{\u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(App99.\u0628\ufea5\u062a\ufec5(), 970, 7, 459), string2, \ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644(App99.\u0628\ufea5\u062a\ufec5(), 977, 5, 914)}));
                                \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(object, string, App99.\u0627\u0648\ufecd\ufee9((Object)this, jSONObject, new String[]{\u0646\ufecd\ufead\u0647.\u0640\u062e\ufed5\ufeaf(App99.\u0628\ufea5\u062a\ufec5(), 982, 5, 369), string}));
                                object2 = App99.\u062e\u0635\u0632\u0646((Object)this, jSONObject);
                                \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(object, \u0646\ufecd\ufead\u0647.\u0640\u062e\ufed5\ufeaf(App99.\u0628\ufea5\u062a\ufec5(), 987, 13, 2299), object2[0]);
                                \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(object, \ufed9\ufe9d\ufeed\ufeb5.\u0638\ufec1\u063a\u0644(App99.\u0628\ufea5\u062a\ufec5(), 1000, 12, 1571), object2[1]);
                                object2 = new JSONArray();
                                \u0630\ufebd\u0634\ufec9.\u0645\ufead\u0635\u0634(object2, object);
                                object = new JSONObject();
                                \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(object, \u0631\ufea1\u0638\u0627.\u0645\u062f\u062d\ufeaf(App99.\u0628\ufea5\u062a\ufec5(), 1012, 4, 1437), object2);
                                object2 = \ufeaf\u0633\u0648\ufee9.\ufeb5\u0634\u0640\ufea1(object);
                            }
                            case 76: 
                        }
                        break;
                    }
                }
                case 45: 
            }
            break;
        }
        return object2;
    }

    /*
     * Recovered potentially malformed switches.  Disable with '--allowmalformedswitch false'
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String homeContent(boolean var1_1) {
        block93: {
            try {
                var7_2 = new JSONObject();
                var8_3 = new JSONArray();
                var6_4 = \u0641\u0631\ufeed\u0643.\ufedd\u0631\ufebd\u062d(App99.\ufe8f\ufead\ufecd\ufea1((Object)this), \ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(App99.\u0628\ufea5\u062a\ufec5(), 1016, 10, 345));
                var1_1 = var6_4 instanceof JSONArray;
                var2_6 = 1616;
            }
            catch (Exception var6_5) {
                \ufed9\ufe8e\u062d\ufead.\u062b\ufe8e\u062d\u0645(var6_5);
                return \ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(App99.\u0628\ufea5\u062a\ufec5(), 1070, 25, 2233);
            }
            block72: while (true) {
                switch (var2_6 ^= 1633) {
                    default: {
                        continue block72;
                    }
                    case 49: {
                        if (var1_1) {
                            var2_6 = 1709;
                            continue block72;
                        }
                    }
                    case 14: {
                        var2_6 = 1678;
                        continue block72;
                    }
                    case 204: {
                        var6_4 = (JSONArray)var6_4;
                        break block72;
                    }
                    case 239: {
                        var6_4 = null;
                    }
                }
                break;
            }
            var4_7 = 0;
            var10_8 = \ufea1\u0645\u062b\u0634.\u0638\ufec9\u0630\ufe95(App99.\u0628\ufea5\u062a\ufec5(), 1026, 9, 1767);
            var9_9 = \ufeb9\u0643\ufed9\ufed5.\u0628\u062f\ufea1\u0642(App99.\u0628\ufea5\u062a\ufec5(), 1035, 7, 1029);
            var2_6 = 1740;
            block73: while (true) {
                switch (var2_6 ^= 1757) {
                    default: {
                        continue block73;
                    }
                    case 17: {
                        if (var6_4 != null) {
                            var2_6 = 1833;
                            continue block73;
                        }
                    }
                    case 54: {
                        var2_6 = 1802;
                        continue block73;
                    }
                    case 500: {
                        var5_10 = \u0644\ufe8f\u0628\u062a.\ufee9\ufe8e\ufe99\u0631(var6_4);
                        var2_6 = 1864;
                        break block73;
                    }
                    case 471: {
                        ** GOTO lbl-1000
                    }
                }
                break;
            }
            block74: while (true) {
                var3_11 = var4_7;
                switch (var2_6 ^= 1881) {
                    default: {
                        continue block74;
                    }
                    case 17: {
                        if (var5_10 == 0) {
                            var2_6 = 48736;
                            continue block74;
                        }
                    }
                    case 47483: {
                        var2_6 = 48705;
                        continue block74;
                    }
                    case 47417: {
                        var2_6 = 48767;
                        break block74;
                    }
                    case 47384: {
                        break block93;
                    }
                }
                break;
            }
            block75: while (true) {
                switch (var2_6 ^= 48784) {
                    default: {
                        continue block75;
                    }
                    case 14: lbl-1000:
                    // 2 sources

                    {
                        var11_12 = \ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(App99.\u0628\ufea5\u062a\ufec5(), 1048, 2, 1183);
                        var13_14 = \ufebd\u0640\u0648\u062b.\ufea5\u0639\u0631\ufe95(App99.\u0628\ufea5\u062a\ufec5(), 1050, 2, 865);
                        var12_16 = \ufeab\u0632\u062f\u0640.\u062f\u0627\ufe95\u0631(App99.\u0628\ufea5\u062a\ufec5(), 1052, 2, 337);
                        var6_4 = \u062b\ufec1\ufeb1\u062d.\u0637\u0647\u0635\u0630(App99.\u0628\ufea5\u062a\ufec5(), 1054, 2, 1282);
                        var14_18 = \u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(App99.\u0628\ufea5\u062a\ufec5(), 1056, 2, 1914);
                        var3_11 = 0;
                        break block75;
                    }
                    case 239: {
                        var2_6 = 48798;
                        continue block75;
                    }
                }
                break;
            }
lbl79:
            // 2 sources

            while (true) {
                var2_6 = 50813;
                block77: while (true) {
                    switch (var2_6 ^= 50830) {
                        default: {
                            continue block77;
                        }
                        case 243: {
                            if (var3_11 < 5) {
                                var2_6 = 51557;
                                continue block77;
                            }
                        }
                        case 18: {
                            var2_6 = 50875;
                            continue block77;
                        }
                        case 4075: {
                            var15_19 = new JSONObject();
                            var4_7 = var3_11 + 1;
                            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(var15_19, var9_9, \u0644\ufe8f\u0628\u062a.\ufeaf\u062b\ufed5\ufec1(var4_7));
                            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(var15_19, var10_8, (new String[]{var11_12, var13_14, var12_16, var6_4, var14_18})[var3_11]);
                            \u0630\ufebd\u0634\ufec9.\u0645\ufead\u0635\u0634(var8_3, var15_19);
                            var2_6 = 51588;
                        }
                        case 53: {
                            break block77;
                        }
                    }
                    break;
                }
                ** GOTO lbl-1000
                break;
            }
        }
        block78: while (true) {
            block94: {
                var4_7 = \u0644\ufe8f\u0628\u062a.\ufee9\ufe8e\ufe99\u0631(var6_4);
                var2_6 = 48891;
                block79: while (true) {
                    switch (var2_6 ^= 48908) {
                        default: {
                            continue block79;
                        }
                        case 503: {
                            if (var3_11 < var4_7) {
                                var2_6 = 49635;
                                continue block79;
                            }
                        }
                        case 22: {
                            var2_6 = 48953;
                            continue block79;
                        }
                        case 32495: {
                            var12_17 = \u0632\ufead\u062f\u0628.\ufead\u062b\ufeb1\u0644(var6_4, var3_11);
                            var2_6 = 49666;
                            break block79;
                        }
                        case 53: lbl-1000:
                        // 2 sources

                        {
                            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(var7_2, \u0633\u064a\u0644\u0637.\ufec9\ufeed\ufeb5\u0640(App99.\u0628\ufea5\u062a\ufec5(), 1058, 5, 862), var8_3);
                            var6_4 = \u062f\ufead\ufeaf\u062d.\ufec9\u0630\ufed9\ufeb1(App99.\u0628\ufea5\u062a\ufec5(), 1063, 7, 1483);
                            var8_3 = new JSONObject();
                            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(var7_2, var6_4, var8_3);
                            return \ufeaf\u0633\u0648\ufee9.\ufeb5\u0634\u0640\ufea1(var7_2);
                        }
                    }
                    break;
                }
                block80: while (true) {
                    switch (var2_6 ^= 49683) {
                        default: {
                            continue block80;
                        }
                        case 17: {
                            if (var12_17 != null) {
                                var2_6 = 49759;
                                continue block80;
                            }
                        }
                        case 50: {
                            var2_6 = 49728;
                            continue block80;
                        }
                        case 76: {
                            var11_13 = App99.\u0627\u0648\ufecd\ufee9((Object)this, var12_17, new String[]{\u0636\u0634\ufec1\u0631.\u062c\u063a\u0643\u0627(App99.\u0628\ufea5\u062a\ufec5(), 1042, 2, 2835), var9_9});
                            var13_15 = App99.\u0627\u0648\ufecd\ufee9((Object)this, var12_17, new String[]{\ufea1\u0645\u062b\u0634.\u0638\ufec9\u0630\ufe95(App99.\u0628\ufea5\u062a\ufec5(), 1044, 4, 463), var10_8});
                            var1_1 = \ufeed\ufebd\u0635\ufedd.\u0637\ufe8e\ufee1\ufebd(var11_13);
                            var2_6 = 49790;
                            break block80;
                        }
                        case 83: {
                            break block94;
                        }
                    }
                    break;
                }
                block81: while (true) {
                    switch (var2_6 ^= 49807) {
                        default: {
                            continue block81;
                        }
                        case 241: {
                            if (!var1_1) {
                                var2_6 = 49883;
                                continue block81;
                            }
                        }
                        case 18: {
                            var2_6 = 49852;
                            continue block81;
                        }
                        case 84: {
                            var1_1 = \ufeed\ufebd\u0635\ufedd.\u0637\ufe8e\ufee1\ufebd(var13_15);
                            var2_6 = 49914;
                            block82: while (true) {
                                switch (var2_6 ^= 49931) {
                                    default: {
                                        continue block82;
                                    }
                                    case 497: {
                                        if (!var1_1) {
                                            var2_6 = 50658;
                                            continue block82;
                                        }
                                    }
                                    case 1711: {
                                        var2_6 = 50627;
                                        continue block82;
                                    }
                                    case 1769: {
                                        var12_17 = new JSONObject();
                                        \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(var12_17, var9_9, var11_13);
                                        \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(var12_17, var10_8, var13_15);
                                        \u0630\ufebd\u0634\ufec9.\u0645\ufead\u0635\u0634(var8_3, var12_17);
                                        break block81;
                                    }
                                    case 1736: 
                                }
                                break;
                            }
                        }
                        case 51: 
                    }
                    break;
                }
            }
            var4_7 = var3_11 + 1;
            var2_6 = 50689;
            block83: while (true) {
                var3_11 = var4_7;
                switch (var2_6 ^= 50706) {
                    case 50: {
                        continue block78;
                    }
                    default: {
                        continue block83;
                    }
                    case 19: 
                }
                var2_6 = 50720;
            }
            break;
        }
        block84: while (true) {
            switch (var2_6 ^= 51605) {
                default: {
                    continue block84;
                }
                case 17: {
                    var2_6 = 51619;
                    continue block84;
                }
                case 54: 
            }
            break;
        }
        var3_11 = var4_7;
        ** while (true)
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String homeVideoContent() {
        void var3_5;
        block20: {
            boolean bl;
            App99.\ufec9\u0644\ufead\ufeb1((Object)this);
            JSONObject jSONObject = new JSONObject();
            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(jSONObject, \ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(App99.\u0628\ufea5\u062a\ufec5(), 1095, 2, 2945), \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640());
            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(jSONObject, \u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(App99.\u0628\ufea5\u062a\ufec5(), 1097, 4, 625), \u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(App99.\u0628\ufea5\u062a\ufec5(), 1101, 1, 843));
            \u062a\ufee1\ufe8e\ufeb9.\u0641\ufeb5\u062a\ufec1(jSONObject, \u0633\u064a\u0644\u0637.\ufec9\ufeed\ufeb5\u0640(App99.\u0628\ufea5\u062a\ufec5(), 1102, 5, 1084), 12);
            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(jSONObject, \ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(App99.\u0628\ufea5\u062a\ufec5(), 1107, 3, 808), \ufe99\u062c\u0643\ufec1.\u0648\u0634\u063a\ufeb1(App99.\u0628\ufea5\u062a\ufec5(), 1110, 1, 3120));
            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(jSONObject, \ufeb5\ufe8e\ufead\u0632.\ufe8f\ufef1\u0648\ufe95(App99.\u0628\ufea5\u062a\ufec5(), 1111, 7, 435), \u062d\ufeb9\ufeab\ufef1.\ufeed\u0638\u0635\ufed5(App99.\u0628\ufea5\u062a\ufec5(), 1118, 4, 1673));
            \u062a\ufee1\ufe8e\ufeb9.\u0641\ufeb5\u062a\ufec1(jSONObject, \u0641\ufeb5\ufeb1\ufee1.\u0639\u0630\ufeaf\ufe95(App99.\u0628\ufea5\u062a\ufec5(), 1122, 10, 1622), 1);
            String string = App99.\ufead\ufee1\u062e\u0636((Object)this, \ufecd\u0642\u062e\ufe9d.\u0637\ufee9\u0635\u0630(App99.\u0628\ufea5\u062a\ufec5(), 1132, 11, 3252), jSONObject);
            int n = 1616;
            block16: while (true) {
                switch (n ^= 0x661) {
                    default: {
                        continue block16;
                    }
                    case 49: {
                        if (string != null) {
                            n = 1709;
                            continue block16;
                        }
                    }
                    case 14: {
                        n = 1678;
                        continue block16;
                    }
                    case 204: {
                        bl = \ufeed\ufebd\u0635\ufedd.\u0637\ufe8e\ufee1\ufebd(string);
                        n = 1740;
                        break block16;
                    }
                    case 239: {
                        break block20;
                    }
                }
                break;
            }
            block17: while (true) {
                switch (n ^= 0x6DD) {
                    default: {
                        continue block17;
                    }
                    case 17: {
                        if (!bl) {
                            n = 1833;
                            continue block17;
                        }
                    }
                    case 54: {
                        n = 1802;
                        continue block17;
                    }
                    case 500: {
                        try {
                            JSONObject jSONObject2 = new JSONObject(string);
                            jSONObject2 = App99.\ufe9d\u0642\ufe95\ufeed((Object)this, App99.\u0630\u063a\ufea1\u0638((Object)this, jSONObject2));
                            JSONObject jSONObject3 = new JSONObject();
                            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(jSONObject3, \ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(App99.\u0628\ufea5\u062a\ufec5(), 1143, 4, 640), jSONObject2);
                            String string2 = \ufeaf\u0633\u0648\ufee9.\ufeb5\u0634\u0640\ufea1(jSONObject3);
                            return var3_5;
                        }
                        catch (Exception exception) {
                            \ufed9\ufe8e\u062d\ufead.\u062b\ufe8e\u062d\u0645(exception);
                        }
                    }
                    case 471: 
                }
                break;
            }
        }
        String string = \ufebd\u0640\u0648\u062b.\ufea5\u0639\u0631\ufe95(App99.\u0628\ufea5\u062a\ufec5(), 1147, 11, 3138);
        return var3_5;
    }

    /*
     * Exception decompiling
     */
    public void init(Context var1_1, String var2_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [8[CASE]], but top level block is 1[TRYBLOCK]
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

    public boolean isVideoFormat(String string) {
        return false;
    }

    public boolean manualVideoCheck() {
        return true;
    }

    /*
     * Exception decompiling
     */
    public String playerContent(String var1_1, String var2_6, List<String> var3_7) {
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

    public String searchContent(String string, boolean bl) {
        String string2 = "\u06e7\u06e7\u06e5";
        String string3 = null;
        short[] sArray = null;
        String string4 = null;
        block5: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string2)) {
                default: {
                    string4 = \ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(sArray, 1555, 1, 2196);
                    string2 = "\u06e7\u06e7\u06e6";
                    continue block5;
                }
                case 1754630: {
                    string3 = \ufea9\ufe8f\u0647\ufead.\u0634\u0643\u0638\u0630((Object)this, string, bl, string4);
                    string2 = "\u06e5\u06e4\u06e3";
                    continue block5;
                }
                case 1754629: {
                    sArray = App99.\u0628\ufea5\u062a\ufec5();
                    string2 = "\u06e5\u06df\u06e4";
                    continue block5;
                }
                case 1752612: 
            }
            break;
        }
        return string3;
    }

    /*
     * Exception decompiling
     */
    public String searchContent(String var1_1, boolean var2_3, String var3_4) {
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

    private static long[] $d2j$hex$1356fd7f$decode_J(String src) {
        byte[] d = App99.$d2j$hex$1356fd7f$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$1356fd7f$decode_I(String src) {
        byte[] d = App99.$d2j$hex$1356fd7f$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$1356fd7f$decode_S(String src) {
        byte[] d = App99.$d2j$hex$1356fd7f$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$1356fd7f$decode_B(String src) {
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

