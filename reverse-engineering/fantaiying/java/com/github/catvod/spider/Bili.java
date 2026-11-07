/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.graphics.drawable.ColorDrawable
 *  android.text.Editable
 *  android.view.Window
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  com.github.catvod.crawler.SpiderDebug
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  okhttp3.Headers
 *  okhttp3.Response
 *  okhttp3.ResponseBody
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
import com.github.catvod.parser.\ufeb9\ufec9\u0648\u062d;
import com.github.catvod.parser.\ufec1\u0636\u062d\u0638;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.merge.Bo;
import com.github.catvod.spider.merge.E;
import com.github.catvod.spider.merge.E1;
import com.github.catvod.spider.merge.Fz;
import com.github.catvod.spider.merge.Jx;
import com.github.catvod.spider.merge.Jz;
import com.github.catvod.spider.merge.KJ;
import com.github.catvod.spider.merge.L9;
import com.github.catvod.spider.merge.LP;
import com.github.catvod.spider.merge.My;
import com.github.catvod.spider.merge.TO;
import com.github.catvod.spider.merge.W;
import com.github.catvod.spider.merge.bM;
import com.github.catvod.spider.merge.c_0;
import com.github.catvod.spider.merge.dT;
import com.github.catvod.spider.merge.f0;
import com.github.catvod.spider.merge.f1_0;
import com.github.catvod.spider.merge.le_0;
import com.github.catvod.spider.merge.n_0;
import com.github.catvod.spider.merge.p9;
import com.github.catvod.spider.merge.to_0;
import com.github.catvod.spider.merge.ts_0;
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
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class Bili
extends Pan {
    private static boolean Dr = false;
    private static String E1 = "";
    private static le_0 Fz;
    private static boolean H;
    private static LP U;
    private static String Zm;
    private static String b;
    private static boolean g;
    private static final short[] short;
    private JsonObject O;
    private AlertDialog g1;
    private volatile boolean n;
    private ScheduledExecutorService s;
    private boolean un = true;

    static {
        short = Bili.$d2j$hex$75098f37$decode_S("7804640464046004b609bd09b809bd098b09a609b109b209a609b109a709bc098b09a009bb09bf09b109ba097564be60ed656255fcf86b575657c475f9959e69b05c21521c52cd68575dd46cfa59f9f91a55b8547559e53621522152e436ce48809e9e64f47e8e70a059168ff4932d9cf3545d89727507040c0409040c043a041704000403041704000416040d043a0411040a040e0400040b043d022a02290236023b026c02620268026d026c0267021e0267026d02190272021b0267026d026e0272021b026d026c021e02720219021e021e026a0272021e021b021c026e0266021c0266026802660269021d026b026a0267026f026a026f0236023102390230023c0264023d022c0230022a022d023c023a0262022c023a023e022d023c02370200023d023e0236023b022a02640200022a022a0236023b02620269026d026702190269021b0267026b0272021b02190267021b0272021a021b026a021e0272021a026b021d0219027202690269026d026e0266026602680266026b026d026b021d026a0267026c0266026a0236023102390230023c0264027f027f023d022a02290236023b02000239022f02620239026802680269026e023c026c023c0266023d023b023a026c0269026b026e026a0239026f026d02660266026b0266026c023c0269026f023d02660268026e0264023d022f0200022b0200023002390239022c023a022b0200026a026a026b026d026c026b026b026f0262026e026d026f026c026f026b0268026d026d026e0267026f02660266026f026a02690269026b0264023d02000233022c0236023b0262021c026e026a026902670219026f026a0200026e0266021a026c021d026c021e021b026f021b021a02a3555466359e690466046c047a04670461046c042604600469047a046c047f0469047a046d0426046b04690465046d047a0469042604690466047104c201cd01c701d101cc01ca01c7018d01cb01c201d101c701d401c201d101c6018d01d701c601cf01c601d301cb01cc01cd01da014e0741074b075d07400746074b07010747074e075d074b0758074e075d074a0701074d0743075a074a075b07400740075b0747075505490549054d054e050705120512055c054d05540513055f055405510554055f0554055105540513055e05520550051205450512054a0558055f05100554055305490558054f055b055c055e055805120553055c054b051b0b070b070b030b000b490b5c0b5c0b030b120b000b000b030b1c0b010b070b5d0b110b1a0b1f0b1a0b110b1a0b1f0b1a0b5d0b100b1c0b1e0b5c0b0b0b5c0b030b120b000b000b030b1c0b010b070b5e0b1f0b1c0b140b1a0b1d0b5c0b040b160b110b5c0b020b010b100b1c0b170b160b5c0b140b160b1d0b160b010b120b070b160b4c0b000b1c0b060b010b100b160b4e0b1e0b120b1a0b1d0b5e0b1e0b1a0b1d0b1a0baf0189019f018801d701bb019d019f0194018e01830ba10bb40ba70ba20ba20baf0be10bfb0be00bfe0bee0be60b990ba70ba00baa0ba10bb90bbd0bee0b800b9a0bee0bff0bfe0be00bfe0bf50bee0b990ba70ba00bf80bfa0bf50bee0bb60bf80bfa0be70bee0b8f0bbe0bbe0ba20bab0b990bab0bac0b850ba70bba0be10bfb0bfd0bf90be00bfd0bf80bee0be60b850b860b9a0b830b820be20bee0ba20ba70ba50bab0bee0b890bab0bad0ba50ba10be70bee0b8d0ba60bbc0ba10ba30bab0be10bff0bff0bf90be00bfe0be00bfe0be00bfe0bee0b9d0baf0ba80baf0bbc0ba70be10bfb0bfd0bf90be00bfd0bf80b6b075c075f075c074b075c074b073b01270127012301200169017c017c012401240124017d0131013a013f013a0131013a013f013a017d0130013c013e017c0128022d0238022d02f307f407ea0727043804350434043e043407390735073b073407280761077b0779072f077b077c072b07350738072807340761077b0779072f077b077c073a072e073d07310739070e073d072807390761077b0779072f077b077c072f073d072e0761077b0779072f077b0789059d058c0581058705df0bc40bdc0bf20bd90bd00bdf0bdf0bd40bdd0bc20b8c0b960b830b960b910bc20bd00bdc0bc10bdd0bd40be30bd00bc50bd40b8c0b960b940bc20b960bf602d002c602d1028e02e202c402c602cd02d702bb0699068c069f069a069a069706d906c306d806c606d606de06a1069f0698069206990681068506d606b806a206d606c706c606d806c606cd06d606a1069f069806c006c206cd06d6068e06c006c206df06d606b706860686069a069306a10693069406bd069f068206d906c306c506c106d806c506c006d606de06bd06be06a206bb06ba06da06d6069a069f069d069306d606b106930695069d069906df06d606b5069e06840699069b069306d906c706c706c106d806c606d806c606d806c606d606a50697069006970684069f06d906c306c506c106d806c506c0067e0a490a4a0a490a5e0a490a5e0a290c350c350c310c320c7b0c6e0c6e0c360c360c360c6f0c230c280c2d0c280c230c280c2d0c280c6f0c220c2e0c2c0c6e0c420a7f0a640a6a0a640a630a52034e034e034a0349030003150315034d034d034d031403580353035603530358035303560353031403590355035703680464046404600462046e04300337031e035f030e035b035b03460337031e0352030d030a035e033603440b410b540b410b700a730a620a6e0a650a640a5e0a6a0a640a780af108ed08ed08e908ea08a308b608b608e908f808ea08ea08e908f608eb08ed08b708fb08f008f508f008fb08f008f508f008b708fa08f608f408b608e108b608e908f808ea08ea08e908f608eb08ed08b408f508f608fe08f008f708b608ee08fc08fb08b608e808eb08fa08f608fd08fc08b608e908f608f508f508a608e808eb08fa08f608fd08fc08c608f208fc08e008a4082e077b0767077d077a076b076d0735076507690761076607250765076107660761070f0429043f04280477041b043d043f0434042e044308610874086708620862086f0821083b0820083e082e0826085908670860086a08610879087d082e0840085a082e083f083e0820083e0835082e0859086708600838083a0835082e08760838083a0827082e084f087e087e0862086b0859086b086c08450867087a0821083b083d08390820083d0838082e082608450846085a084308420822082e086208670865086b082e0849086b086d086508610827082e084d0866087c08610863086b0821083f083f08390820083e0820083e0820083e082e085d086f0868086f087c08670821083b083d08390820083d08380830040704040407041004070410040405180518051c051f055605430543051b051b051b0542050e050505000505050e0505050005050542050f05030501054305be03b203b903b803ec0cfb0cf80cec0cfb0ced0cf60cc10cea0cf10cf50cfb0cf00ccf02c802d6021c454b7fb75e8a5efb51da6f220a330a330a08686272eb69206d338d5789a15710522d528706ab06ab06af06ad06a106de7676646bf918494f73b3528e522606370637060c64667eef652461e5698491a307ab076b0768076a0760076807cb03c303c803ca03ca03ca03ae03ad03af03ae03af03cd0bcf0bce0bcc0bcc0bcc0bd307d007d207d107d607410243024702470247029e0493049a048f0498039f03810384038503206089936806790664066806330674066806710670064409580958095c095f091609030903094d095c09450902094e094509400945094e0945094009450902094f09430941090309540903095b0949094e09010945094209580949095e094a094d094f094909030942094d095a099658ab58397a049a63664d5361585c588d6217579466ba53b9f35a5ff85e3553a53c61586158a43c8e42c094de6eb474ce7ae0535685b4996d96b35e1d83327f840a8c0a810aa70aad0aa00a6806770636042a042a042e042d046404710471043f042e04370470043c043704320437043c0437043204370470043d04310433047104260471042e0432043f0427043b042c0471042e0432043f0427042b042c04320461043f04280437043a046304000a450a4f0a420a1b0abc09eb09f409a709600420042804300427042a047b047204760472047e04600420042904330434042d047b047704da07ab07b607a207c6079e078b078a0788079507dc079e0795078f07db07c4078e07920792079607dc07c907c907910791079107c8079107d507c807890794078107c907d407d607d607d707c907be07ab07aa07b50785078e0783078b078707cb078f078807950792078707880785078307c407c6079e078b078a0788079507db07c407930794078807dc078b07960783078107dc078207870795078e07dc07950785078e0783078b078707dc078b0796078207dc07d407d607d707d707c407c6079e0795078f07dc07950785078e0783078b078707aa0789078507870792078f0789078807db07c407930794078807dc078b07960783078107dc078207870795078e07dc07950785078e0783078b078707dc078b0796078207dc07d407d607d707d707c607a207a707b507ae07cb07ab07b607a207c8079e0795078207c407c60792079f0796078307db07c40795079207870792078f078507c407c6078b07830782078f078707b607940783079507830788079207870792078f0789078807a20793079407870792078f0789078807db07c407b607b207c3079507b507c407c6078b078f078807a40793078007800783079407b2078f078b078307db07c407b607b207c3079507b507c407c60796079407890780078f078a0783079507db07c407930794078807dc078b07960783078107dc078207870795078e07dc0796079407890780078f078a078307dc078f079507890780078007cb0789078807cb07820783078b07870788078207dc07d407d607d707d707c407d807ec07da07b607830794078f0789078207c607820793079407870792078f0789078807db07c407b607b207c3079507b507c407c60795079207870794079207db07c407b607b207d607b507c407d807ec07c3079507ec07c3079507ec07da07c907b607830794078f0789078207d807ec07da07c907ab07b607a207d807170a060a060a1a0a1f0a150a170a020a1f0a190a180a590a120a170a050a1e0a5d0a0e0a1b0a1a0ad406db06d106c706da06dc06d1069b06dc06db06c106d006db06c1069b06d406d606c106dc06da06db069b06e306fc06f006e206a703a503fd03b703b203bd03be03b203b803a603fd03b103ba03bf03ba03fd03a603ba03fd03ba03bd03a703b603bd03a703fd039a03bd03a703b603bd03a7039b03b203bd03b703bf03b603a1039203b003a703ba03a503ba03a703aa03020432078604c10686068a069706dc06c807b5079007950784078007950780079d079b079a07a70791078007ca07fe07c807b7079b079a07800791079a078007b7079b07990784079b079a0791079a078007d40797079b079a07800791079a078007a0078d0784079107c907d607d1078707d607db07ca07fe07c807a6079107840786079107870791079a078007950780079d079b079a07d4079d079007c907d607d1078707d607d407960795079a07900783079d07900780079c07c907d607d1078707d607d40797079b079007910797078707c907d607d1078707d607d40799079d0799079107a0078d0784079107c907d607d1078707d607d407d1078707d40787078007950786078007a3079d0780079c07a707b507a407c907d607d1078707d607ca07fe07c807b607950787079107a107a607b807ca07d1078707c807db07b607950787079107a107a607b807ca07fe07c807a70791079307990791079a078007b607950787079107d4079d079a07900791078c07a60795079a0793079107c907d607d1078707d607ca07fe07c807bd079a079d0780079d07950798079d078e07950780079d079b079a07d407860795079a0793079107c907d607d1078707d607db07ca07fe07c807db07a70791079307990791079a078007b607950787079107ca07fe07c807db07a6079107840786079107870791079a078007950780079d079b079a07ca07fe07c807db07b5079007950784078007950780079d079b079a07a70791078007ca0771097a097f097a09d30cd80cdd0cd80c9a0aa10aa60abe0a19010c0100011301010100013a0c2b0c2d0c2f0c350b240b220b200b260b2a0b300b2b0b310bd707d207d607d207cf07fe08e508fe08eb08e608030206021c021b020d085908520845085f081807e90aed0ae00a6c027202d105cd05cd05c905ca05830596059605d805c905d0059705db05d005d505d005db05d005d505d0059705da05d605d4059605c1059605ca05c905d805da05dc059605ce05db05d0059605d805cb05da059605ca05dc05d805cb05da05d1058605a408be08bb08a108a608340629063f063e0629061e0405041e040b04060418040b0404040104900281028602950280029d029b029a0202083c0b210b2c0b2d0482049504960489048404d304dd04d704d204d304d804a104d804d204a604cd04a404d804d204d104cd04a404d204d304a104cd04a604a104a104d504cd04a104a404a304d104d904a304d904d704d904d604a204d404d504d804d004d504d00489048e0486048f048304db04820493048f049504920483048504dd04930485048104920483048804bf0482048104890484049504db04bf049504950489048404dd04d604d204d804a604d604a404d804d404cd04a404a604d804a404cd04a504a404d504a104cd04a504d404a204a604cd04d604d604d204d104d904d904d704d904d404d204d404a204d504d804d304d904d50489048e0486048f048304db04c004c00482049504960489048404bf0486049004dd048604d704d704d604d1048304d3048304d904820484048504d304d604d404d104d5048604d004d204d904d904d404d904d3048304d604d0048204d904d704d104db0482049004bf049404bf048f0486048604930485049404bf04d504d504d404d204d304d404d404d004dd04d104d204d004d304d004d404d704d204d204d104d804d004d904d904d004d504d604d604d404db048204bf048c04930489048404dd04a304d104d504d604d804a604d004d504bf04d104d904a504d304a204d304a104a404d004a404a504c603da03da03de03dd03940381038103cf03de03c7038003cc03c703c203c703cc03c703c203c7038003cd03c103c3038103d6038103d903cb03cc038303c703c003da03cb03dc03c803cf03cd03cb038103dd03cb03cf03dc03cd03c6038103da03d703de03cb039103dd03cb03cf03dc03cd03c603f103da03d703de03cb039303d803c703ca03cb03c1038803c503cb03d703d903c103dc03ca039303c207de07de07da07d907900785078507cb07da07c3078407c807c307c607c307c807c307c607c3078407c907c507c7078507d2078507dd07cf07c8078707c307c407de07cf07d807cc07cb07c907cf078507dd07c807c3078507d907cf07cb07d807c907c2078507de07d307da07cf079507d907cf07cb07d807c907c207f507de07d307da07cf079707dc07c307ce07cf07c5078c07c107cf07d307dd07c507d807ce0797075d06140609061f061e060906460628086a087b087c086f087a086708610860083308740522053305350537056f053106640c780c780c7c0c7f0c360c230c230c6d0c7c0c650c220c6e0c650c600c650c6e0c650c600c650c220c6f0c630c610c230c740c230c7b0c690c6e0c210c650c620c780c690c7e0c6a0c6d0c6f0c690c230c7a0c650c690c7b0c330c6d0c650c680c310cca5153978b0c7806970697069706620cbb77918e6e0572057205760575053c0529052905670576056f05280564056f056a056f0564056f056a056f052805650569056b0529057e05290576056a0567057f0563057405290576056a0567057f05730574056a053905670570056f0562053b0576023302390234026d02e706b006af06fc06f006f306f606e706a706af06b706a006ad06fc06f506f106f506f906e706a706ae06b406b306aa06fc06f006ff03f6016d7bae06b206b206b606b506fc06e906e906a706b606af06e806a406af06aa06af06a406af06aa06af06e806a506a906ab06e906be06e906b106a306a406eb06af06a806b206a306b406a006a706a506a306e906a706b406a506ae06af06b006a306e906b406a306aa06a706b206a306a206f906a406b006af06a206fb062406210634062106cd02d002cd02d502dc02a006a806a506ef04e504e8041b7d905aad02b402a802a902710c7c0c750c600c7007499e738db501ae01b501a001ad01b301a001af01aa011962035ca075e254f70cf80cfd0cf70cff0cf96e496c285afa57b10bb40ba30ba50ba00bb50ba40b0864125a315c5d5df108f8084a6d50537c6f858fdf01d801c301db017e0a630a750a740a630a8e6f93522b53ab92b5673c97e907ad0bab0b9d59049f7e4591456d067d087e08300878087e08485ad19cf10197039603d80395039603a0513997680aaa04ab049d5604907e4a904a6c0c360b270b200b330b260b3b0b3d0b3c0bd160589099058505850581058205cb05de05de05900581059805df05930598059d059805930598059d059805df0592059e059c05de058905de05860594059305dc0598059f058505940583059705900592059405de0581059e05810584059d0590058305ce0581058205cc05c305c105300b320b6a0b200b250b2a0b290b250b2f0b310b6a0b260b2d0b280b2d0b58045404560415045904520457045204590452045704520415045a044b044b04150452045504280c2d0c3f0c240c330828082c08220829080e0602060206060604060806a10aaa0aaf0aaa0a9c0ab10aa60aa50ab10aa60ab00aab0a9c0ab70aac0aa80aa60aad0a9c0aac0ab10aaa0aa40aaa0aad0a7b07700775077007e80ae30ae60ae30ad50af80aef0aec0af80aef0af90ae20ad50afe0ae50ae10aef0ae40a87029b029b029f029f0888088b0894089908ce08c008ca08cf08ce08c508bc08c508cf08bb08d008b908c508cf08cc08d008b908cf08ce08bc08d008bb08bc08bc08c808d008bc08b908be08cc08c408be08c408ca08c408cb08bf08c908c808c508cd08c808cd08940893089b0892089e08c6089f088e08920888088f089e089808c0088e0898089c088f089e089508a2089f089c08940899088808c608a2088808880894089908c008cb08cf08c508bb08cb08b908c508c908d008b908bb08c508b908d008b808b908c808bc08d008b808c908bf08bb08d008cb08cb08cf08cc08c408c408ca08c408c908cf08c908bf08c808c508ce08c408c808940893089b0892089e08c608dd08dd089f0888088b0894089908a2089b088d08c0089b08ca08ca08cb08cc089e08ce089e08c4089f0899089808ce08cb08c908cc08c8089b08cd08cf08c408c408c908c408ce089e08cb08cd089f08c408ca08cc08c6089f088d08a2088908a20892089b089b088e0898088908a208c808c808c908cf08ce08c908c908cd08c008cc08cf08cd08ce08cd08c908ca08cf08cf08cc08c508cd08c408c408cd08c808cb08cb08c908c6089f08a20891088e0894089908c008be08cc08c808cb08c508bb08cd08c808a208cc08c408b808ce08bf08ce08bc08b908cd08b908b808dd08980892089f08c6082a055d0541025d025d0259025a0213020602060248025902400207024b024002450240024b0240024502400207024a024602440206025102060259024502480250024c025b02060259024502480250025c025b024502160248025f0240024d021402540c030c1c0c4f0c430c400c420c540c140c1d0c070c000c190c4f0c430cd403d103c403d103e50cf40cf30ced0c19061e060006d40a81049d049d0499049a04d304c604c604880499048004c7048b048004850480048b04800485048004c7048a0486048404c6049104c6049f04d804c6048d048404c604850480049a049d04c7049a048604d604860480048d04d404bd0ce60ced0cbf0ce00ceb0cee0ceb0ca40ce30ceb0ce60cbf0cbd01ea01f501a6011b09490944094d095809000950094d095909c806");
    }

    /*
     * Enabled aggressive block sorting
     */
    public Bili() {
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
                    Float f = Float.decode((String)\ufeb9\u0627\ufea5\ufe9d.\u0648\u0647\u0628\u062b("vQLcdeXAOQLhlTFHp34GM0"));
                    System.out.println(f);
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
    public static void B(Bili var0, String var1_1) {
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
    private void Dr(String string, String string2) {
        boolean bl = Bili.\ufecd\u0643\u0641\ufebd((Object)this);
        int n = 1616;
        block12: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block12;
                }
                case 49: {
                    if (bl) {
                        n = 1709;
                        continue block12;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block12;
                }
                case 239: {
                    this.n = true;
                    b = string;
                    \u0633\u064a\u0644\u0637.\u062c\ufe9d\u0632\ufeab(Bili.\ufed9\u0646\ufe9d\ufedd(), Bili.\u0648\ufeb5\ufe8e\u0646());
                    bl = \ufea5\u062d\ufebd\u0633.\u0639\ufeb1\ufead\ufe8f(string2);
                    n = 1740;
                    block13: while (true) {
                        switch (n ^= 0x6DD) {
                            default: {
                                continue block13;
                            }
                            case 17: {
                                if (!bl) {
                                    n = 1833;
                                    continue block13;
                                }
                            }
                            case 54: {
                                n = 1802;
                                continue block13;
                            }
                            case 500: {
                                \u0633\u064a\u0644\u0637.\u062c\ufe9d\u0632\ufeab(\ufeb5\ufe8e\ufead\u0632.\u0641\u062e\ufed5\u0633(\u0645\u0641\u0630\u062d.\u0642\u062a\u0630\ufebd(Bili.\u0632\u0631\u0628\ufe8f(), 4, 18, 2516)), string2);
                                break block13;
                            }
                            case 471: 
                        }
                        break;
                    }
                    \ufe8e\ufeb9\u0647\u0642.\u0648\u0636\ufea9\u0630(\ufecd\u0642\u062e\ufe9d.\u0637\ufee9\u0635\u0630(Bili.\u0632\u0631\u0628\ufe8f(), 22, 5, 2045));
                    g = true;
                    Bili.\ufea9\u0639\u062e\u062b((Object)this);
                    \ufeb9\u0627\ufea5\ufe9d.\ufebd\ufec9\ufe95\ufe8f(new Jx(this, 1));
                    return;
                }
                case 204: 
            }
            break;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ void F5(Bili bili) {
        Bili.\ufeaf\u0637\u064a\ufe8e((Object)bili);
        int n = \ufea9\ufe8f\u0647\ufead.\ufe95\ufeb1\ufeaf\u0641();
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
                    float f = Float.parseFloat(\ufea5\u062d\ufebd\u0633.\ufecd\ufe99\u0634\ufec9("panftFqKzJnCpP"));
                    System.out.println(f);
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
    private void Fz() {
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

    public static /* synthetic */ void G(Bili bili) {
        Bili.\ufef1\u0627\u0635\u062b((Object)bili);
    }

    public static void G4(Bili bili) {
        String string = "\u06df\u06e0\u06e5";
        String string2 = null;
        File file = null;
        String string3 = null;
        short[] sArray = null;
        block16: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    file = \ufeb5\ufe8e\ufead\u0632.\u0641\u062e\ufed5\u0633(string3);
                    string = "\u06df\u06e1\u06e7";
                    continue block16;
                }
                case 1750782: {
                    b = string3;
                    string = "\u06e3\u06e4\u06e5";
                    continue block16;
                }
                case 1750570: {
                    sArray = Bili.\u0632\u0631\u0628\ufe8f();
                    string = "\u06e0\u06e0\u06e7";
                    continue block16;
                }
                case 1755374: {
                    \ufe8e\ufeb9\u0647\u0642.\u0648\u0636\ufea9\u0630(string2);
                    string = "\u06e6\u06e8\u06e5";
                    continue block16;
                }
                case 1752524: {
                    file = Bili.\ufed9\u0646\ufe9d\ufedd();
                    string = "\u06e6\u06e2";
                    continue block16;
                }
                case 1753699: {
                    Bili.\ufef1\u0627\u0635\u062b((Object)bili);
                    string = "\u06e4\u06e0\u06e1";
                    continue block16;
                }
                case 1753696: {
                    string3 = \ufea1\u0645\u062b\u0634.\u0638\ufec9\u0630\ufe95(sArray, 77, 240, 607);
                    string = "\u06e3\u06e7\u06e2";
                    continue block16;
                }
                case 56508: {
                    \u0638\ufead\u062e\ufee1.\ufeaf\ufe8f\ufecd\u0632(file);
                    string = "\u06e3\u06e0\u06e7";
                    continue block16;
                }
                case 1748614: {
                    sArray = Bili.\u0632\u0631\u0628\ufe8f();
                    string = "\u06e6\u06e8\u06e2";
                    continue block16;
                }
                case 1747687: {
                    string3 = \ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(sArray, 59, 18, 1125);
                    string = "\u06df\u06e3\u06e2";
                    continue block16;
                }
                case 1746695: {
                    string2 = \ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(sArray, 317, 3, 2129);
                    string = "\u06e8\u06e0\u06e6";
                    continue block16;
                }
                case 1746724: {
                    \u0641\ufeb5\ufeb1\ufee1.\ufedd\u0630\u0636\u0647((Object)bili);
                    string = "\u06e5\u06e1\u06e8";
                    continue block16;
                }
                case 1750692: {
                    sArray = Bili.\u0632\u0631\u0628\ufe8f();
                    string = "\u06df\u06df\u06e7";
                    continue block16;
                }
                case 1746757: {
                    \u0638\ufead\u062e\ufee1.\ufeaf\ufe8f\ufecd\u0632(file);
                    string = "\u06e1\u06df\u06e4";
                    continue block16;
                }
                case 1751525: 
            }
            break;
        }
    }

    public static void Gd(Bili bili, EditText editText) {
        String string = "\u06e7\u06e0";
        E e = null;
        String string2 = null;
        Editable editable = null;
        block8: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    e = new E(bili, string2);
                    string = "\u06e3\u06e0\u06e1";
                    continue block8;
                }
                case 1751528: {
                    editable = \ufeab\u062d\u063a\ufea9.\ufeed\u0638\u0641\u0636(editText);
                    string = "\u06e0\u06e0\u06e3";
                    continue block8;
                }
                case 56537: {
                    \u0641\ufeb5\ufeb1\ufee1.\ufedd\u0630\u0636\u0647((Object)bili);
                    string = "\u06e4\u06e0\u06e4";
                    continue block8;
                }
                case 1747683: {
                    string2 = \u0638\ufead\u062e\ufee1.\ufe9d\ufebd\u0641\ufea1(editable);
                    string = "\u06e7\u06e3\u06e0";
                    continue block8;
                }
                case 1754500: {
                    Bili.\ufef1\u0627\u0635\u062b((Object)bili);
                    string = "\u06e4\u06df\u06e6";
                    continue block8;
                }
                case 1750564: {
                    \ufeb9\u0627\ufea5\ufe9d.\ufebd\ufec9\ufe95\ufe8f(e);
                    string = "\u06e1\u06e4\u06e3";
                    continue block8;
                }
                case 1748768: 
            }
            break;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     */
    private void H() {
        \u0630\ufebd\u0634\ufec9.\ufeb9\u0640\u0643\u0631();
        var6_1 = \ufee9\ufee1\u0627\u0641.\u0641\ufea1\ufeb9\u0632(\ufed9\ufe9d\ufeed\ufeb5.\ufea5\ufec9\u0642\u0639(\ufeed\ufebd\u0635\ufedd.\u0630\ufee9\u0647\u062e()), \ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(Bili.\u0632\u0631\u0628\ufe8f(), 320, 27, 1032));
        var4_2 = \ufee9\ufee1\u0627\u0641.\u0641\ufea1\ufeb9\u0632(\ufed9\ufe9d\ufeed\ufeb5.\ufea5\ufec9\u0642\u0639(\ufeed\ufebd\u0635\ufedd.\u0630\ufee9\u0647\u062e()), \u0632\ufead\u062f\u0628.\u0645\u062a\u0637\u0635(Bili.\u0632\u0631\u0628\ufe8f(), 347, 26, 419));
        var5_3 = \ufee9\ufee1\u0627\u0641.\u0641\ufea1\ufeb9\u0632(\ufed9\ufe9d\ufeed\ufeb5.\ufea5\ufec9\u0642\u0639(\ufeed\ufebd\u0635\ufedd.\u0630\ufee9\u0647\u062e()), \ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(Bili.\u0632\u0631\u0628\ufe8f(), 373, 26, 1839));
        var1_4 = 1616;
        block32: while (true) {
            switch (var1_4 ^= 1633) {
                default: {
                    continue block32;
                }
                case 49: {
                    if (var6_1) {
                        var1_4 = 1709;
                        continue block32;
                    }
                }
                case 14: {
                    var1_4 = 1678;
                    continue block32;
                }
                case 204: {
                    var1_4 = 1740;
                    break block32;
                }
                case 239: {
                    ** GOTO lbl-1000
                }
            }
            break;
        }
        block33: while (true) {
            switch (var1_4 ^= 1757) {
                default: {
                    continue block33;
                }
                case 17: {
                    if (var4_2) {
                        var1_4 = 1833;
                        continue block33;
                    }
                }
                case 54: {
                    var1_4 = 1802;
                    continue block33;
                }
                case 500: {
                    var1_4 = 1864;
                    block34: while (true) {
                        switch (var1_4 ^= 1881) {
                            default: {
                                continue block34;
                            }
                            case 17: {
                                if (var5_3) {
                                    var1_4 = 48736;
                                    continue block34;
                                }
                            }
                            case 47483: {
                                var1_4 = 48705;
                                continue block34;
                            }
                            case 47417: {
                                var3_5 = true;
                                var1_4 = 48767;
                                break block33;
                            }
                            case 47384: 
                        }
                        break;
                    }
                }
                case 471: lbl-1000:
                // 2 sources

                {
                    var2_6 = false;
                    ** GOTO lbl-1000
                }
            }
            break;
        }
        block35: while (true) {
            var2_6 = var3_5;
            switch (var1_4 ^= 48784) {
                default: {
                    continue block35;
                }
                case 14: lbl-1000:
                // 2 sources

                {
                    var1_4 = 48891;
                    break block35;
                }
                case 239: {
                    var1_4 = 48798;
                    continue block35;
                }
            }
            break;
        }
        block36: while (true) {
            switch (var1_4 ^= 48908) {
                default: {
                    continue block36;
                }
                case 503: {
                    if (var2_6) {
                        var1_4 = 49635;
                        continue block36;
                    }
                }
                case 22: {
                    var1_4 = 48953;
                    continue block36;
                }
                case 32495: {
                    \ufeb1\ufe8e\ufee1\ufe9d.\ufe99\ufeab\ufe8f\u062f(new n_0((Object)this, 5));
                    var1_4 = 49666;
                    block37: while (true) {
                        switch (var1_4 ^= 49683) {
                            default: {
                                continue block37;
                            }
                            case 17: {
                                var1_4 = 49697;
                                continue block37;
                            }
                            case 50: 
                        }
                        break;
                    }
                    return;
                }
                case 53: 
            }
            break;
        }
        \ufeb9\u0627\ufea5\ufe9d.\ufebd\ufec9\ufe95\ufe8f(new to_0((Object)this, 2));
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void Nl(Bili bili, JSONObject jSONObject) {
        ScheduledExecutorService scheduledExecutorService;
        \u0641\ufeb5\ufeb1\ufee1.\ufedd\u0630\u0636\u0647((Object)bili);
        bili.s = scheduledExecutorService = \ufeab\u062d\u063a\ufea9.\ufecd\u064a\ufec5\u0638(1);
        \ufeab\u062d\u063a\ufea9.\u062c\ufe95\ufeb5\u0643(scheduledExecutorService, new dT((Object)bili, jSONObject, 1), 1L, 1L, (Object)\ufe8e\ufeb9\u0647\u0642.\u064a\ufeb1\u0642\ufea5());
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
                    long l = Long.parseLong(\ufee9\u0631\ufeb5\u0628.\ufed9\ufeed\ufe8f\ufed5("vy"));
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
    private void O() {
        Object object = \u0632\ufead\u062f\u0628.\u0642\ufecd\ufeaf\ufec9(Bili.\u0648\ufeb5\ufe8e\u0646());
        boolean bl = \ufea5\u062d\ufebd\u0633.\u0639\ufeb1\ufead\ufe8f(object);
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
                    b = object;
                    break block12;
                }
                case 239: 
            }
            break;
        }
        object = Bili.\ufed5\u064a\u0631\u062f();
        U = object = \u0640\u0633\ufea5\u0631.\ufed9\ufea1\u0638\u062d(\ufeb9\u0627\ufea5\ufe9d.\u0631\u0647\u0639\ufebd(\ufebd\u0640\u0648\u062b.\u0646\ufed5\u0630\ufec9(\ufea9\ufe8f\u0647\ufead.\ufea9\u0643\ufedd\ufeed(Bili.\u0632\u0631\u0628\ufe8f(), 399, 44, 1341), object)));
        g = \ufeaf\ufea5\ufeab\u062e.\u0641\ufeb9\u0630\u0628(object);
        H = \u0638\ufead\u062e\ufee1.\u062b\ufe8f\u0630\u0648(Bili.\u0639\ufeb9\u0635\u0641());
        Fz = \ufea9\ufec5\u0647\u0641.\u0644\u0646\ufea5\u0642(Bili.\u0639\ufeb9\u0635\u0641());
        int n2 = \ufea5\ufea9\u0633\ufed5.\u0627\ufec9\u062b\u0638();
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
                    object = Long.valueOf(\u062b\u064a\ufecd\u0642.\u0641\ufea1\u0646\u062f("PF056tC0iDrdJ2j7zu16K"));
                    System.out.println(object);
                    return;
                }
                case 471: 
            }
            break;
        }
    }

    public static void OW(Bili bili) {
        Bili.\ufef1\u0627\u0635\u062b((Object)bili);
        \ufeb9\u0627\ufea5\ufe9d.\ufebd\ufec9\ufe95\ufe8f(new E1((Object)bili, 2));
    }

    /*
     * Enabled aggressive block sorting
     */
    private void U() {
        Object object = Bili.\ufec1\u0631\u0640\u062d((Object)this);
        int n = 1616;
        block12: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block12;
                }
                case 49: {
                    if (object != null) {
                        n = 1709;
                        continue block12;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block12;
                }
                case 204: {
                    \u062a\u0635\ufeb1\u0642.\ufec9\ufeb9\u0642\u063a(object);
                    break block12;
                }
                case 239: 
            }
            break;
        }
        \ufeb1\ufe8e\ufee1\ufe9d.\ufe99\ufeab\ufe8f\u062f(new Jx(this, 0));
        int n2 = \u062b\u064a\ufecd\u0642.\ufea9\ufec5\ufec1\ufec9();
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
                    object = Double.valueOf(\u0640\u0633\ufea5\u0631.\u0637\u0646\u062c\ufead("P1j0U5O2r8JmbMHu0ndbAlcAuz"));
                    System.out.println(object);
                    return;
                }
                case 471: 
            }
            break;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void W(Bili bili) {
        int n;
        \u0641\ufeb5\ufeb1\ufee1.\ufedd\u0630\u0636\u0647((Object)bili);
        try {
            bili.n = false;
            E1 = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
            String string = \ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(Bili.\u0632\u0631\u0628\ufe8f(), 443, 83, 2931);
            JSONObject jSONObject = new HashMap();
            \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(jSONObject, \u0641\ufeb5\ufeb1\ufee1.\u0639\u0630\ufeaf\ufe95(Bili.\u0632\u0631\u0628\ufe8f(), 526, 10, 506), \ufecd\u0642\u062e\ufe9d.\u0637\ufee9\u0635\u0630(Bili.\u0632\u0631\u0628\ufe8f(), 536, 111, 3022));
            \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(jSONObject, \ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(Bili.\u0632\u0631\u0628\ufe8f(), 647, 7, 1849), \ufe95\u0627\ufe8e\u0644.\u062d\u0636\ufea9\u0640(Bili.\u0632\u0631\u0628\ufe8f(), 654, 25, 339));
            string = \ufebd\u0640\u0648\u062b.\u0646\ufed5\u0630\ufec9(string, jSONObject);
            jSONObject = new JSONObject(string);
            string = \ufeab\u0632\u062f\u0640.\ufeab\u0632\ufec5\u0645(\ufeaf\ufea5\ufeab\u062e.\ufe99\ufea9\u0647\u0641(jSONObject, \ufeaf\u062b\ufed5\ufec1.\u062e\ufeab\ufee9\u0628(Bili.\u0632\u0631\u0628\ufe8f(), 679, 4, 588)), \ufe8f\ufe8e\ufeb5\u0641.\u062f\u0627\u0640\ufee1(Bili.\u0632\u0631\u0628\ufe8f(), 683, 3, 1926));
            W w = new W((Object)bili, string, (Object)jSONObject, 1);
            \ufeb1\ufe8e\ufee1\ufe9d.\ufe99\ufeab\ufe8f\u062f(w);
            n = 1616;
        }
        catch (Exception exception) {
            Bili.\ufec9\u0640\u0633\u0637(exception);
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
    private static String Zm(ts_0 var0) {
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
    private static Map<String, String> b() {
        HashMap hashMap = \ufe9d\u0631\ufe8f\u064a.\u0637\u0633\ufeb1\u063a(\u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(Bili.\u0632\u0631\u0628\ufe8f(), 773, 10, 675), \ufeb9\ufec9\u0648\u062d.\ufee9\u0637\ufef1\u0644(Bili.\u0632\u0631\u0628\ufe8f(), 783, 111, 1782), \u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(Bili.\u0632\u0631\u0628\ufe8f(), 894, 7, 2604), \u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(Bili.\u0632\u0631\u0628\ufe8f(), 901, 25, 3137));
        \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, \ufea5\u062d\ufebd\u0633.\ufea5\ufeb1\u0643\ufe8f(Bili.\u0632\u0631\u0628\ufe8f(), 926, 6, 2573), \ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(Bili.\u0632\u0631\u0628\ufe8f(), 932, 24, 826));
        String string = Bili.\u0648\ufeb5\ufe8e\u0646();
        int n = 1616;
        block6: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block6;
                }
                case 49: {
                    if (string != null) {
                        n = 1709;
                        continue block6;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block6;
                }
                case 204: {
                    \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, \u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(Bili.\u0632\u0631\u0628\ufe8f(), 956, 6, 1035), string);
                    return hashMap;
                }
                case 239: 
            }
            break;
        }
        return hashMap;
    }

    /*
     * Exception decompiling
     */
    public static boolean containsChinese(String var0) {
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
    public static void dT(Bili var0, JSONObject var1_3) {
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
     * Handled duff style switch with additional control
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void ee(Bili object) {
        \u0641\ufeb5\ufeb1\ufee1.\ufedd\u0630\u0636\u0647(object);
        try {
            Bili.\ufea1\ufe9d\ufeb1\u0645(object);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        int n = \ufe8f\ufe8e\ufeb5\u0641.\u0647\u0639\ufee9\ufedd();
        int n2 = 1616;
        block8: while (true) {
            int n3 = 0;
            block9: do {
                switch (n3 == 0 ? (n2 ^= 0x661) : n3) {
                    default: {
                        continue block8;
                    }
                    case 14: {
                        n2 = 1678;
                        continue block8;
                    }
                    case 49: {
                        n3 = 14;
                        if (n > 0) continue block9;
                        n2 = 1709;
                        continue block8;
                    }
                    case 204: {
                        Integer n4 = Integer.valueOf(\ufe9d\u0631\ufe8f\u064a.\u0635\u0633\ufebd\u0638("5KFpoi91m"));
                        System.out.println(n4);
                        return;
                    }
                    case 239: 
                }
                return;
            } while (true);
            break;
        }
    }

    /*
     * Handled duff style switch with additional control
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void g(String object) {
        int n;
        try {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(\ufeb5\ufe8e\ufead\u0632.\ufecd\ufea5\ufedd\ufebd(240), \ufeb5\ufe8e\ufead\u0632.\ufecd\ufea5\ufedd\ufebd(240));
            ImageView imageView = new ImageView((Context)\ufeed\ufebd\u0635\ufedd.\u0630\ufee9\u0647\u062e());
            \ufed9\ufe8e\u062d\ufead.\ufeb9\ufed9\u062b\u0631(imageView, \ufea5\ufea9\u0633\ufed5.\ufe95\u064a\ufeb5\u0647());
            \ufea5\u062d\ufebd\u0633.\u0646\u0648\u062a\u0645(imageView, \ufea1\u0645\u062b\u0634.\ufe99\u062e\u0641\u062c(object, 240, 2));
            object = new FrameLayout((Context)\ufeed\ufebd\u0635\ufedd.\u0630\ufee9\u0647\u062e());
            layoutParams.gravity = 17;
            \u0633\u064a\u0644\u0637.\u0634\ufeb1\ufecd\u0648(object, imageView, layoutParams);
            AlertDialog.Builder builder = new AlertDialog.Builder((Context)\u0641\ufeb5\ufeb1\ufee1.\u0642\ufee1\u0637\u0648());
            object = \u0641\u0631\ufeed\u0643.\u0644\ufeb9\u062b\ufe99(builder, object);
            c_0 c_02 = new c_0(this);
            object = \u0635\u0631\u0645\u0628.\ufedd\u0648\ufeb5\ufe95(object, c_02);
            KJ kJ = new KJ((Object)this, 1);
            object = \u062a\u0635\ufeb1\u0642.\ufec5\ufeaf\ufead\u0648(\u0631\u063a\u0645\u0641.\ufead\u0636\ufee9\ufea5(object, kJ));
            this.g1 = object;
            Window window = \ufecd\u0642\u062e\ufe9d.\ufe8f\ufeb5\u062d\u0640(object);
            object = new ColorDrawable(0);
            \ufea5\ufea9\u0633\ufed5.\ufecd\ufec1\u0631\ufe8f(window, object);
            \ufe8e\ufeb9\u0647\u0642.\u0648\u0636\ufea9\u0630(\ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(Bili.\u0632\u0631\u0628\ufe8f(), 1255, 13, 2659));
        }
        catch (Exception exception) {
            n = 1740;
            block12: while (true) {
                switch (n ^= 0x6DD) {
                    case 54: {
                        break block12;
                    }
                    default: {
                        continue block12;
                    }
                    case 17: {
                        n = 1771;
                        continue block12;
                    }
                }
                break;
            }
        }
        int n2 = \ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644();
        n = 1616;
        block13: while (true) {
            int n3 = 0;
            block14: do {
                switch (n3 == 0 ? (n ^= 0x661) : n3) {
                    default: {
                        continue block13;
                    }
                    case 14: {
                        n = 1678;
                        continue block13;
                    }
                    case 49: {
                        n3 = 14;
                        if (n2 > 0) continue block14;
                        n = 1709;
                        continue block13;
                    }
                    case 204: {
                        object = Integer.decode(\ufeaf\u062b\ufed5\ufec1.\ufea1\ufeaf\ufe99\ufe8e("wwhMck0wpz5OGPpSag1DF"));
                        System.out.println(object);
                        return;
                    }
                    case 239: 
                }
                return;
            } while (true);
            break;
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void g1() {
        try {
            var3_1 /* !! */  = Bili.\u0643\u0633\u064a\ufecd((Object)this);
            var1_3 = 1616;
        }
        catch (Exception var3_2) {
            var1_3 = 1864;
            block23: while (true) {
                switch (var1_3 ^= 1881) {
                    case 47483: {
                        ** continue;
                    }
                    default: {
                        continue block23;
                    }
                    case 17: 
                }
                var1_3 = 48674;
            }
        }
        block19: while (true) {
            switch (var1_3 ^= 1633) {
                default: {
                    continue block19;
                }
lbl8:
                // 2 sources

                case 14: {
                    var1_3 = 1678;
                    continue block19;
                }
                case 49: {
                    if (var3_1 /* !! */  == null) ** GOTO lbl8
                    var1_3 = 1709;
                    continue block19;
                }
                case 204: {
                    \ufed9\ufe8e\u062d\ufead.\u0633\u0643\u0630\ufebd(var3_1 /* !! */ );
                }
                case 239: 
            }
            break;
        }
lbl19:
        // 3 sources

        while (true) {
            var2_4 = \ufe8e\ufeb9\u0647\u0642.\ufe99\u062b\ufea1\u0647();
            var1_3 = 1740;
            block22: while (true) {
                switch (var1_3 ^= 1757) {
                    default: {
                        continue block22;
                    }
                    case 17: {
                        if (var2_4 >= 0) {
                            var1_3 = 1833;
                            continue block22;
                        }
                    }
                    case 54: {
                        var1_3 = 1802;
                        continue block22;
                    }
                    case 500: {
                        var3_1 /* !! */  = Integer.decode(\ufec1\u0636\u062d\u0638.\u063a\u0627\ufee9\u0637("dysyJ6PrP"));
                        System.out.println(var3_1 /* !! */ );
                    }
                    case 471: 
                }
                break;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void g9(Bili bili) {
        \u0641\ufeb5\ufeb1\ufee1.\ufedd\u0630\u0636\u0647((Object)bili);
        try {
            Object object = new FrameLayout.LayoutParams(-1, -2);
            \ufeaf\ufea5\ufeab\u062e.\u0641\u0645\u0636\ufe9d(object, \ufeb5\ufe8e\ufead\u0632.\ufecd\ufea5\ufedd\ufebd(16), \ufeb5\ufe8e\ufead\u0632.\ufecd\ufea5\ufedd\ufebd(16), \ufeb5\ufe8e\ufead\u0632.\ufecd\ufea5\ufedd\ufebd(16), \ufeb5\ufe8e\ufead\u0632.\ufecd\ufea5\ufedd\ufebd(16));
            Object object2 = new FrameLayout((Context)\ufeed\ufebd\u0635\ufedd.\u0630\ufee9\u0647\u062e());
            Object object3 = new EditText((Context)\ufeed\ufebd\u0635\ufedd.\u0630\ufee9\u0647\u062e());
            \u0633\u064a\u0644\u0637.\u0634\ufeb1\ufecd\u0648(object2, object3, object);
            object = new AlertDialog.Builder((Context)\u0641\ufeb5\ufeb1\ufee1.\u0642\ufee1\u0637\u0648());
            object = \u0641\u0631\ufeed\u0643.\u0644\ufeb9\u062b\ufe99(\ufea9\ufe8f\u0647\ufead.\ufecd\u0645\u0637\ufeaf(object, \ufe99\u062c\u0643\ufec1.\u0648\u0634\u063a\ufeb1(Bili.\u0632\u0631\u0628\ufe8f(), 1268, 11, 1732)), object2);
            object2 = \u062f\ufead\ufeaf\u062d.\ufec9\u0630\ufed9\ufeb1(Bili.\u0632\u0631\u0628\ufe8f(), 1279, 14, 1639);
            Object object4 = new bM((Object)bili, 0);
            object = \u0633\u064a\u0644\u0637.\ufead\ufe9d\u0641\ufee9(object, object2, object4);
            object4 = \ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(Bili.\u0632\u0631\u0628\ufe8f(), 1293, 4, 2016);
            object2 = new L9(bili);
            object2 = \ufee1\u0639\u063a\u0645.\u062d\ufee9\u0647\u0640(object, object4, object2);
            object = new f0(bili, (EditText)object3);
            object2 = \u062a\u0635\ufeb1\u0642.\ufec5\ufeaf\ufead\u0648(\u0635\u0631\u0645\u0628.\u0630\u0648\u062e\u0638(object2, 17039370, object));
            bili.g1 = object2;
            object3 = new Fz((Object)bili, 1);
            \u062b\ufec1\ufeb1\u062d.\ufef1\u0636\u062c\u0634(object2, object3);
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
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean isAppInstalled(Context context, String string) {
        boolean bl = false;
        try {
            \u062a\u0635\ufeb1\u0642.\u062f\u0643\u062d\ufeab(\ufed9\ufe9d\ufeed\ufeb5.\ufea5\ufec9\u0642\u0639(context), string, 0);
            return true;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return bl;
        }
    }

    private static HashMap<String, String> n() {
        String string = "\u06e7\u06e3\u06e0";
        HashMap hashMap = null;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        short[] sArray = null;
        block16: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    sArray = Bili.\u0632\u0631\u0628\ufe8f();
                    string = "\u06e5\u06e1\u06e7";
                    continue block16;
                }
                case 1747805: {
                    string3 = \u0641\ufeb5\ufeb1\ufee1.\u0639\u0630\ufeaf\ufe95(sArray, 1313, 6, 3068);
                    string = "\u06e5\u06e7\u06e5";
                    continue block16;
                }
                case 1752523: {
                    string5 = \ufe99\u062c\u0643\ufec1.\u0648\u0634\u063a\ufeb1(sArray, 1319, 5, 2016);
                    string = "\u06e6\u06e0\u06df";
                    continue block16;
                }
                case 1751561: {
                    string2 = \ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(sArray, 1308, 5, 925);
                    string = "\u06e8\u06e3\u06e4";
                    continue block16;
                }
                case 1755465: {
                    sArray = Bili.\u0632\u0631\u0628\ufe8f();
                    string = "\u06e0\u06e4\u06e1";
                    continue block16;
                }
                case 0x1AC1AC: {
                    \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, string5, string4);
                    string = "\u06e7\u06e3\u06e7";
                    continue block16;
                }
                case 1752707: {
                    hashMap = \ufe9d\u0631\ufe8f\u064a.\u0637\u0633\ufeb1\u063a(string5, string4, string2, string3);
                    string = "\u06df\u06e6\u06e0";
                    continue block16;
                }
                case 1751616: {
                    sArray = Bili.\u0632\u0631\u0628\ufe8f();
                    string = "\u06e4\u06e1\u06e6";
                    continue block16;
                }
                case 1754406: {
                    sArray = Bili.\u0632\u0631\u0628\ufe8f();
                    string = "\u06e8\u06e6\u06e5";
                    continue block16;
                }
                case 1755559: {
                    string4 = \u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(sArray, 1302, 6, 1018);
                    string = "\u06e4\u06e3\u06df";
                    continue block16;
                }
                case 1754500: {
                    sArray = Bili.\u0632\u0631\u0628\ufe8f();
                    string = "\u06e2\u06e3\u06e6";
                    continue block16;
                }
                case 1749701: {
                    string5 = \ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644(sArray, 1297, 5, 1880);
                    string = "\u06e7\u06e0\u06df";
                    continue block16;
                }
                case 1753445: {
                    sArray = Bili.\u0632\u0631\u0628\ufe8f();
                    string = "\u06e3\u06e4\u06e6";
                    continue block16;
                }
                case 1750693: {
                    string4 = \ufee9\u0631\ufeb5\u0628.\u0636\ufeab\u0634\u0633(sArray, 1324, 5, 631);
                    string = "\u06e6\u06e2\u06e8";
                    continue block16;
                }
                case 1754507: 
            }
            break;
        }
        return hashMap;
    }

    /*
     * Exception decompiling
     */
    public static Object[] proxy(Map<String, String> var0) {
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
    public static void q(Bili var0, String var1_1, JSONObject var2_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 3[TRYBLOCK] [8 : 359->364)] java.lang.Throwable
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

    private static String s(ts_0 ts_02, String string) {
        StringBuilder stringBuilder = null;
        String string2 = null;
        short[] sArray = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        String string6 = null;
        Locale locale = null;
        Object[] objectArray = null;
        String string7 = null;
        f1_0 f1_02 = null;
        String string8 = null;
        String string9 = null;
        String string10 = "\u06e7\u06e5\u06e5";
        block23: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string10)) {
                default: {
                    locale = \u0646\ufecd\ufead\u0647.\u0646\u0627\u062a\u062d();
                    objectArray = new Object[10];
                    string10 = "\u06e3\u06e7\u06e4";
                    continue block23;
                }
                case 1753694: {
                    string4 = \ufe8e\ufec1\u0641\u0644.\ufee9\u062a\u062d\u0640(ts_02);
                    sArray = Bili.\u0632\u0631\u0628\ufe8f();
                    string10 = "\u06e3\u06e1\u06e0";
                    continue block23;
                }
                case 1748798: {
                    string6 = \ufea5\u062d\ufebd\u0633.\u0645\ufec1\ufed5\u062c(string4, string5, \ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(sArray, 1951, 5, 1767));
                    string10 = "\u06df\u06e0";
                    continue block23;
                }
                case 1747900: {
                    string2 = \u0631\u0640\ufec1\ufee9.\ufe95\ufeed\u062c\ufec1(sArray, 1948, 1, 1117);
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, string2);
                    string10 = "\u06e8\u06e1\u06df";
                    continue block23;
                }
                case 1754378: {
                    string2 = \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(stringBuilder);
                    string3 = \ufea5\ufea9\u0633\ufed5.\u0639\u0648\ufed5\ufea5(ts_02);
                    string10 = "\u06e3\u06e5\u06e7";
                    continue block23;
                }
                case 1753513: {
                    string4 = \ufeaf\ufea5\ufeab\u062e.\ufea1\ufec5\ufec9\u0640(ts_02);
                    objectArray[2] = string4;
                    string10 = "\u06e3\u06e2\u06e1";
                    continue block23;
                }
                case 1752617: {
                    objectArray[6] = string7;
                    objectArray[7] = string6;
                    string10 = "\u06e7\u06e8\u06e3";
                    continue block23;
                }
                case 1752553: {
                    return \u0631\ufea1\u0638\u0627.\ufec9\u0640\u0639\u0645(locale, string9, objectArray);
                }
                case 1755500: {
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, string2);
                    sArray = Bili.\u0632\u0631\u0628\ufe8f();
                    string10 = "\u06e0\u06e7\u06e3";
                    continue block23;
                }
                case 1746882: {
                    string3 = \ufeb5\ufe8e\ufead\u0632.\u0640\ufec5\ufedd\u0634(string3, string4)[0];
                    string10 = "\u06e6\u06e8\u06e0";
                    continue block23;
                }
                case 1750594: {
                    string5 = \ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(sArray, 1950, 1, 1184);
                    sArray = Bili.\u0632\u0631\u0628\ufe8f();
                    string10 = "\u06e1\u06e5\u06e2";
                    continue block23;
                }
                case 1750626: {
                    string5 = \u0632\ufead\u062f\u0628.\u0633\ufeed\u0634\ufef1(ts_02);
                    objectArray[3] = string5;
                    string10 = "\u06e0\u06df\u06df";
                    continue block23;
                }
                case 1754658: {
                    f1_02 = \u0646\ufecd\ufead\u0647.\ufed9\ufee9\u0646\u0630(ts_02);
                    string8 = \ufea1\u0645\u062b\u0634.\u062d\u0635\ufecd\u0631(f1_02);
                    string10 = "\u06e5\u06e3\u06e5";
                    continue block23;
                }
                case 1749763: {
                    objectArray[9] = \u062f\ufead\ufeaf\u062d.\u062a\ufed9\ufeb9\u062c(f1_02);
                    string10 = "\u06e0\u06e3\u06e4";
                    continue block23;
                }
                case 1750784: {
                    objectArray[0] = string3;
                    objectArray[1] = string2;
                    string10 = "\u06e6\u06e2\u06e5";
                    continue block23;
                }
                case 1747648: {
                    objectArray[4] = \ufea5\ufea9\u0633\ufed5.\u0639\u0648\ufed5\ufea5(ts_02);
                    string10 = "\u06e8\u06e2\u06df";
                    continue block23;
                }
                case 1747777: {
                    sArray = Bili.\u0632\u0631\u0628\ufe8f();
                    string9 = \u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(sArray, 1956, 270, 2036);
                    string10 = "\u06e5\u06e2\u06e6";
                    continue block23;
                }
                case 1755398: {
                    string2 = \ufeed\ufebd\u0635\ufedd.\u0636\u0631\ufeed\u0639(ts_02);
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(stringBuilder, string2);
                    string10 = "\u06e7\u06df\u06e2";
                    continue block23;
                }
                case 1754567: {
                    stringBuilder = new StringBuilder();
                    string2 = \ufeaf\u062b\ufed5\ufec1.\ufed5\ufeb5\ufea1\u0633(ts_02);
                    string10 = "\u06e8\u06e4\u06e8";
                    continue block23;
                }
                case 1752583: {
                    objectArray[8] = string8;
                    f1_02 = \u0646\ufecd\ufead\u0647.\ufed9\ufee9\u0646\u0630(ts_02);
                    string10 = "\u06e2\u06e5\u06e6";
                    continue block23;
                }
                case 1750725: {
                    sArray = Bili.\u0632\u0631\u0628\ufe8f();
                    string4 = \ufeb5\ufe8e\ufead\u0632.\ufe8f\ufef1\u0648\ufe95(sArray, 1949, 1, 1821);
                    string10 = "\u06df\u06e5\u06e8";
                    continue block23;
                }
                case 1755429: 
            }
            objectArray[5] = string;
            string7 = \u0641\ufeb5\ufeb1\ufee1.\u0645\u0637\ufe95\ufec1(ts_02);
            string10 = "\u06e5\u06e4\u06e8";
        }
    }

    private static File un() {
        return \ufeb5\ufe8e\ufead\u0632.\u0641\u062e\ufed5\u0633(\ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(Bili.\u0632\u0631\u0628\ufe8f(), 2226, 4, 2323));
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void v(Bili object) {
        Bili.\ufea9\u0639\u062e\u062b(object);
        int n = \ufea5\u062d\ufebd\u0633.\u0645\ufe95\u0647\ufec1();
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
                    Float f = Float.decode((String)\ufeab\u062d\u063a\ufea9.\u064a\u0644\u0639\ufe99("hD7UvFpt"));
                    System.out.println(f);
                    return;
                }
                case 239: 
            }
            break;
        }
    }

    public static void v3(Bili bili) {
        String string = "\u06e4\u06e2\u06e2";
        String string2 = null;
        File file = null;
        block7: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    string2 = Bili.\u0648\ufeb5\ufe8e\u0646();
                    string = "\u06e7\u06e3\u06e1";
                    continue block7;
                }
                case 1750750: {
                    Bili.\ufea9\u0639\u062e\u062b((Object)bili);
                    string = "\u06e3\u06e2\u06e6";
                    continue block7;
                }
                case 1754407: {
                    file = Bili.\ufed9\u0646\ufe9d\ufedd();
                    string = "\u06e5\u06e3\u06e8";
                    continue block7;
                }
                case 1751588: {
                    \u0641\ufeb5\ufeb1\ufee1.\ufedd\u0630\u0636\u0647((Object)bili);
                    string = "\u06e7\u06e0\u06e0";
                    continue block7;
                }
                case 1754501: {
                    \u0633\u064a\u0644\u0637.\u062c\ufe9d\u0632\ufeab(file, string2);
                    string = "\u06e3\u06e6\u06e1";
                    continue block7;
                }
                case 1750631: 
            }
            break;
        }
    }

    public static /* synthetic */ void xa(Bili bili, String string) {
        \u0641\ufeb5\ufeb1\ufee1.\ufedd\u0630\u0636\u0647((Object)bili);
        try {
            Bili.\u062d\u0640\u0638\ufe9d((Object)bili, string);
            return;
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static ResponseBody \u0628\u0633\ufee9\u0634(Object object) {
        int n = \ufec1\u0636\u062d\u0638.\u0643\u0638\u062a\ufec5();
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
    public static List \u062a\ufee9\u062b\ufead(Object list) {
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
                    return My.yq.yq((JsonElement)list);
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
    public static boolean \u062d\u0631\u0644\u0645() {
        int n = \ufeb5\ufe8e\ufead\u0632.\ufe95\u0647\u062d\u0631();
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
                    return g;
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
    public static void \u062d\u0640\u0638\ufe9d(Object object, Object object2) {
        int n = \ufea9\ufe8f\u0647\ufead.\ufe95\ufeb1\ufeaf\u0641();
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
                    ((Bili)((Object)object)).g((String)object2);
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
    public static JsonObject \u062f\u0634\u0637\u0642(Object object) {
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
    public static JsonObject \u062f\ufed5\u062b\ufebd(Object object) {
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
                    return ((Bili)((Object)object)).O;
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
    public static int \u0631\ufec1\u0645\ufee9(Object object) {
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
                    return ((JsonArray)object).size();
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
    public static short[] \u0632\u0631\u0628\ufe8f() {
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
    public static void \u0633\u0647\ufe9d\ufeb9(Object object) {
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
                    ((Bili)((Object)object)).Fz();
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
    public static String \u0635\ufeed\u0628\ufeab() {
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
                    return E1;
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
     * Unable to fully structure code
     */
    public static void \u0639\u0647\ufebd\u0633(Object var0) {
        var2_1 = \ufeaf\u0633\u0648\ufee9.\u0641\u062b\u062d\ufeed();
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
                    if (var2_1 < 0) ** GOTO lbl7
                    var1_2 = 1709;
                    continue block16;
                }
                case 204: {
                    ((Response)var0).close();
lbl16:
                    // 2 sources

                    while (true) {
                        var2_1 = \ufe95\u0627\ufe8e\u0644.\ufeab\u0628\u0634\ufec5();
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
                                    var3_3 = Long.parseLong(\u0635\u0631\u0645\u0628.\u062e\u0635\u062a\ufe95("jCvGmG727KIE1uuEt29cAtg"));
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
    public static LP \u0639\ufeb9\u0635\u0641() {
        int n = \ufec1\u0636\u062d\u0638.\u0643\u0638\u062a\ufec5();
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
                    return U;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            LP lP = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return lP;
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
    public static String \u063a\ufee9\u0644\ufee1(Object object, Object object2) {
        int n = \u062f\ufead\ufeaf\u062d.\u0641\ufe9d\u0636\u062c();
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
                    return Bili.s((ts_0)object, (String)object2);
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
    public static JsonElement \u0640\ufe8f\u064a\u0633(Object object) {
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
                    return JsonParser.parseString((String)((String)object));
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
    public static boolean \u0641\ufe8e\u0645\u0631() {
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
                    return Dr;
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
    public static JsonElement \u0641\ufed5\u0642\u0631(Object object, Object object2) {
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
                    return ((JsonParser)object).parse((String)object2);
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
    public static AlertDialog \u0643\u0633\u064a\ufecd(Object object) {
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
                    return ((Bili)((Object)object)).g1;
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
    public static Map \u0644\ufed5\ufee1\ufea1(Object object) {
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
                    return ((Headers)object).toMultimap();
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
    public static JsonElement \u0647\ufeb1\u062f\u0641(Object object, int n) {
        int n2 = \u0644\ufe8f\u0628\u062a.\u0647\ufebd\u0627\u0631();
        int n3 = 1616;
        block10: while (true) {
            switch (n3 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n2 > 0) {
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
    public static String \u0648\ufeb5\ufe8e\u0646() {
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
                    return b;
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
    public static JsonObject \u064a\u0640\ufeb1\u0634(Object object) {
        int n = \ufea5\u062d\ufebd\u0633.\u0645\ufe95\u0647\ufec1();
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
     * Enabled aggressive block sorting
     */
    public static JsonArray \u064a\ufeaf\u063a\u0647(Object object, Object object2) {
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
    public static boolean \ufe8f\u0645\ufea9\u0633(Object object) {
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
                    return ((JsonElement)object).getAsBoolean();
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
    public static boolean \ufe9d\u0627\ufe95\ufebd(Object object) {
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
                    return ((Bili)((Object)object)).un;
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
    public static String \ufea1\u062a\ufe8e\u0627() {
        int n = \u062b\u064a\ufecd\u0642.\ufea9\ufec5\ufec1\ufec9();
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
                    return Zm;
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
    public static void \ufea1\ufe9d\ufeb1\u0645(Object object) {
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
                    ((Bili)((Object)object)).H();
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
    public static JsonElement \ufea5\u0627\ufec9\u0632(Object object) {
        int n = \ufeb9\u0643\ufed9\ufed5.\ufeed\u0631\u0648\ufea5();
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
                    return ((LP)object).t0();
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
    public static void \ufea9\u0639\u062e\u062b(Object var0) {
        var2_1 = \ufe99\u062c\u0643\ufec1.\ufec5\ufee9\ufe8e\ufea1();
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
                    ((Bili)var0).U();
lbl16:
                    // 2 sources

                    while (true) {
                        var2_1 = \ufeb9\u0627\ufea5\ufe9d.\ufed9\ufec9\ufec1\u0633();
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
                                    var0 = Integer.decode(\u0641\u0631\ufeed\u0643.\u062b\ufed9\ufeb1\u0632("SRiGYZqFq"));
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
     * Enabled aggressive block sorting
     */
    public static HashMap \ufea9\ufeaf\u0637\ufeb9() {
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
                    return Bili.n();
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            HashMap<String, String> hashMap = var3_3;
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
    public static String \ufead\u0639\ufea1\ufedd(Object object) {
        int n = \ufea5\u062d\ufebd\u0633.\u0645\ufe95\u0647\ufec1();
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
    public static void \ufeaf\u0637\u064a\ufe8e(Object object) {
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
                    ((Bili)((Object)object)).O();
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
     * Unable to fully structure code
     */
    public static void \ufeb1\u0631\ufea5\u0647(Object var0, Object var1_1, Object var2_2) {
        var4_3 = \ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637();
        var3_4 = 1616;
        block16: while (true) {
            switch (var3_4 ^= 1633) {
                default: {
                    continue block16;
                }
lbl7:
                // 2 sources

                case 14: {
                    var3_4 = 1678;
                    continue block16;
                }
                case 49: {
                    if (var4_3 >= 0) ** GOTO lbl7
                    var3_4 = 1709;
                    continue block16;
                }
                case 204: {
                    ((Bili)var0).Dr((String)var1_1, (String)var2_2);
lbl16:
                    // 2 sources

                    while (true) {
                        var4_3 = \ufebd\u0640\u0648\u062b.\u0633\u0637\u0632\ufeab();
                        var3_4 = 1740;
                        block19: while (true) {
                            switch (var3_4 ^= 1757) {
                                default: {
                                    continue block19;
                                }
                                case 17: {
                                    if (var4_3 <= 0) {
                                        var3_4 = 1833;
                                        continue block19;
                                    }
                                }
                                case 54: {
                                    var3_4 = 1802;
                                    continue block19;
                                }
                                case 500: {
                                    var5_5 = Long.parseLong(\ufe99\u062c\u0643\ufec1.\ufeab\ufec9\u062a\ufed5("Swpo8guS9fy6rL"));
                                    System.out.println(var5_5);
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
        var3_4 = 1864;
        block20: while (true) {
            switch (var3_4 ^= 1881) {
                case 47483: {
                    ** continue;
                }
                default: {
                    continue block20;
                }
                case 17: 
            }
            var3_4 = 48674;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static ScheduledExecutorService \ufec1\u0631\u0640\u062d(Object object) {
        int n = \u062b\ufec1\ufeb1\u062d.\ufe8f\ufe9d\u0628\ufe99();
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
                    return ((Bili)((Object)object)).s;
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
    public static Response \ufec1\ufea1\u064a\ufe8f(Object object, Object object2) {
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
                    return Bo.zH((String)object, (Map)object2);
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
    public static JsonElement \ufec1\ufee9\ufebd\ufeb9(Object object, Object object2) {
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
    public static void \ufec9\u0640\u0633\u0637(Object object) {
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
    public static String \ufec9\ufe8f\u0633\u0634(Object object) {
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
    public static Headers \ufec9\ufedd\u062a\u0644(Object object) {
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
                    return ((Response)object).headers();
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
    public static boolean \ufecd\u0643\u0641\ufebd(Object object) {
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
                    return ((Bili)((Object)object)).n;
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
    public static le_0 \ufed5\u062b\u0630\u0645() {
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
                    return Fz;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            le_0 le_02 = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return le_02;
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
    public static Map \ufed5\u064a\u0631\u062f() {
        int n = \ufec1\u0636\u062d\u0638.\u0643\u0638\u062a\ufec5();
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
                    return Bili.b();
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            Map<String, String> map = var3_3;
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
    public static File \ufed9\u0646\ufe9d\ufedd() {
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
                    return Bili.un();
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            File file = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return file;
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
    public static int \ufedd\u0637\u0634\u0628(Object object) {
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
                    return ((JsonElement)object).getAsInt();
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
    public static JsonElement \ufedd\u0640\ufef1\u0638(Object object) {
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
                    return ((LP)object).q();
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
    public static String \ufee1\u0647\ufedd\ufea5(Object object) {
        int n = \ufeb9\u0643\ufed9\ufed5.\ufeed\u0631\u0648\ufea5();
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
                    return Bili.Zm((ts_0)object);
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
    public static boolean \ufee1\ufeb9\ufecd\u0634(Object object, Object object2) {
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
                    return ((JsonObject)object).has((String)object2);
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
    public static boolean \ufee9\u062a\u062d\u0640() {
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
                    return H;
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
     * Unable to fully structure code
     */
    public static void \ufef1\u0627\u0635\u062b(Object var0) {
        var2_1 = \ufea9\ufec5\u0647\u0641.\u062d\u062a\u0645\u0637();
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
                    ((Bili)var0).g1();
lbl16:
                    // 2 sources

                    while (true) {
                        var2_1 = \ufeed\ufebd\u0635\ufedd.\ufe8e\u0628\u0638\u0631();
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
                                    var0 = Double.decode((String)\ufeab\u062d\u063a\ufea9.\u064a\u0644\u0639\ufe99("X4eskcJsiIPGIgqs67M2ic"));
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
     * Exception decompiling
     */
    public String action(String var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [7[CASE]], but top level block is 1[TRYBLOCK]
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
     * Unable to fully structure code
     * Enabled aggressive block sorting
     */
    public String categoryContent(String var1_1, String var2_2, boolean var3_3, HashMap<String, String> var4_4) {
        block112: {
            var6_5 = Bili.\ufec1\u0631\u0640\u062d((Object)this);
            var5_6 = 1616;
            block84: while (true) {
                switch (var5_6 ^= 1633) {
                    default: {
                        continue block84;
                    }
                    case 49: {
                        if (var6_5 != null) {
                            var5_6 = 1709;
                            continue block84;
                        }
                    }
                    case 14: {
                        var5_6 = 1678;
                        continue block84;
                    }
                    case 204: {
                        Bili.\ufea9\u0639\u062e\u062b((Object)this);
                        break block84;
                    }
                    case 239: 
                }
                break;
            }
            var3_3 = \u062b\ufec1\ufeb1\u062d.\ufea9\u0628\u0637\ufe95(var1_1, \ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(Bili.\u0632\u0631\u0628\ufe8f(), 2238, 6, 361));
            var5_6 = 1740;
            block85: while (true) {
                switch (var5_6 ^= 1757) {
                    default: {
                        continue block85;
                    }
                    case 17: {
                        if (var3_3) {
                            var5_6 = 1833;
                            continue block85;
                        }
                    }
                    case 54: {
                        var5_6 = 1802;
                        continue block85;
                    }
                    case 500: {
                        var1_1 = new JSONObject();
                        var2_2 = new JSONArray();
                        \u0630\ufebd\u0634\ufec9.\u0645\ufead\u0635\u0634(var2_2, \u0632\ufead\u062f\u0628.\u062e\u063a\ufeb5\u0634());
                        \u0630\ufebd\u0634\ufec9.\u0645\ufead\u0635\u0634(var2_2, \ufea9\u0643\u062d\u063a.\ufe9d\ufeb1\u0641\ufea1());
                        \u062a\ufee1\ufe8e\ufeb9.\u0641\ufeb5\u062a\ufec1(var1_1, \ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(Bili.\u0632\u0631\u0628\ufe8f(), 2244, 4, 3146), 1);
                        \u062a\ufee1\ufe8e\ufeb9.\u0641\ufeb5\u062a\ufec1(var1_1, \ufeaf\u062b\ufed5\ufec1.\u062e\ufeab\ufee9\u0628(Bili.\u0632\u0631\u0628\ufe8f(), 2248, 9, 2885), 1);
                        \u062a\ufee1\ufe8e\ufeb9.\u0641\ufeb5\u062a\ufec1(var1_1, \u0630\ufebd\u0634\ufec9.\u0639\ufe8f\u064a\ufebd(Bili.\u0632\u0631\u0628\ufe8f(), 2257, 5, 1979), 1);
                        \u062a\ufee1\ufe8e\ufeb9.\u0641\ufeb5\u062a\ufec1(var1_1, \ufeb9\ufec9\u0648\u062d.\ufee9\u0637\ufef1\u0644(Bili.\u0632\u0631\u0628\ufe8f(), 2262, 5, 2186), 1);
                        \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(var1_1, \u0641\ufeb5\ufeb1\ufee1.\u0639\u0630\ufeaf\ufe95(Bili.\u0632\u0631\u0628\ufe8f(), 2267, 4, 623), var2_2);
                        return \ufeaf\u0633\u0648\ufee9.\ufeb5\u0634\u0640\ufea1(var1_1);
                    }
                    case 471: 
                }
                break;
            }
            var3_3 = \ufec1\u0636\u062d\u0638.\u0634\ufeb9\u0639\u0643(var1_1, \u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(Bili.\u0632\u0631\u0628\ufe8f(), 2271, 5, 2082));
            var5_6 = 1864;
            block86: while (true) {
                switch (var5_6 ^= 1881) {
                    default: {
                        continue block86;
                    }
                    case 17: {
                        if (var3_3) {
                            var5_6 = 48736;
                            continue block86;
                        }
                    }
                    case 47483: {
                        var5_6 = 48705;
                        continue block86;
                    }
                    case 47417: {
                        \ufea9\ufec5\u0647\u0641.\u0636\u0633\u0645\ufe9d(false);
                        var4_4 = new LinkedHashMap<K, V>();
                        var1_1 = \ufeb5\ufe8e\ufead\u0632.\u0640\ufec5\ufedd\u0634(var1_1, \ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(Bili.\u0632\u0631\u0628\ufe8f(), 2276, 1, 1847))[0];
                        \u062d\ufeb9\ufeab\ufef1.\ufec5\u0641\u0628\ufeb9(var4_4, \ufeab\u0632\u062f\u0640.\u062f\u0627\ufe95\u0631(Bili.\u0632\u0631\u0628\ufe8f(), 2277, 3, 2692), var1_1);
                        \u062d\ufeb9\ufeab\ufef1.\ufec5\u0641\u0628\ufeb9(var4_4, \u0645\u0641\u0630\u062d.\u0642\u062a\u0630\ufebd(Bili.\u0632\u0631\u0628\ufe8f(), 2280, 2, 540), var2_2);
                        var1_1 = new ArrayList<E>();
                        var2_2 = \ufea9\ufec5\u0647\u0641.\ufeed\ufe8e\ufec5\ufea9(\ufeb9\u0643\ufed9\ufed5.\u0628\u062f\ufea1\u0642(Bili.\u0632\u0631\u0628\ufe8f(), 2282, 48, 1465));
                        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var2_2, \ufeb9\u0627\ufea5\ufe9d.\u0641\ufe8e\u0638\u0636(Bili.\ufed5\u062b\u0630\u0645(), var4_4));
                        var2_2 = \ufec1\u0636\u062d\u0638.\u062a\ufee1\ufe8e\ufecd(Bili.\u062a\ufee9\u062b\ufead(Bili.\ufec1\ufee9\ufebd\ufeb9(Bili.\u062f\u0634\u0637\u0642(Bili.\ufea5\u0627\ufec9\u0632(\u0640\u0633\ufea5\u0631.\ufed9\ufea1\u0638\u062d(\ufeb9\u0627\ufea5\ufe9d.\u0631\u0647\u0639\ufebd(\ufebd\u0640\u0648\u062b.\u0646\ufed5\u0630\ufec9(\ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(var2_2), Bili.\ufed5\u064a\u0631\u062f()))))), \ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(Bili.\u0632\u0631\u0628\ufe8f(), 2330, 5, 2258))));
                        block87: while (true) {
                            var3_3 = \ufe8e\u0627\ufecd\u062a.\u062f\u0638\ufe8e\ufe99(var2_2);
                            var5_6 = 48767;
                            block88: while (true) {
                                switch (var5_6 ^= 48784) {
                                    default: {
                                        continue block88;
                                    }
                                    case 239: {
                                        if (var3_3) {
                                            var5_6 = 48860;
                                            continue block88;
                                        }
                                    }
                                    case 14: {
                                        var5_6 = 48829;
                                        continue block88;
                                    }
                                    case 76: {
                                        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(var1_1, \u0631\u063a\u0645\u0641.\u0648\u0637\ufe8e\u0635((My.yq)\ufea1\u0645\u062b\u0634.\ufe95\ufeaf\ufeb9\ufea1(var2_2)));
                                        var5_6 = 48891;
                                        block89: while (true) {
                                            switch (var5_6 ^= 48908) {
                                                case 22: {
                                                    continue block87;
                                                }
                                                default: {
                                                    continue block89;
                                                }
                                                case 503: 
                                            }
                                            var5_6 = 48922;
                                        }
                                    }
                                    case 45: 
                                }
                                break;
                            }
                            break;
                        }
                        return \ufe99\u062e\u0642\u0644.\ufea1\u062e\ufecd\ufeab(var1_1);
                    }
                    case 47384: 
                }
                break;
            }
            var6_5 = \u062f\ufead\ufeaf\u062d.\ufec9\u0630\ufed9\ufeb1(Bili.\u0632\u0631\u0628\ufe8f(), 2335, 5, 1627);
            var3_3 = \ufe8e\ufeb9\u0647\u0642.\ufec1\ufed5\ufe99\ufea9(var4_4, var6_5);
            var5_6 = 49666;
            block90: while (true) {
                switch (var5_6 ^= 49683) {
                    default: {
                        continue block90;
                    }
                    case 17: {
                        if (var3_3) {
                            var5_6 = 49759;
                            continue block90;
                        }
                    }
                    case 50: {
                        var5_6 = 49728;
                        continue block90;
                    }
                    case 76: {
                        var6_5 = (String)\u0641\u0631\ufeed\u0643.\ufedd\u0631\ufebd\u062d(var4_4, var6_5);
                        var5_6 = 49790;
                        break block90;
                    }
                    case 83: {
                        var6_5 = \ufebd\u0640\u0648\u062b.\ufea5\u0639\u0631\ufe95(Bili.\u0632\u0631\u0628\ufe8f(), 2340, 9, 1130);
                        ** GOTO lbl-1000
                    }
                }
                break;
            }
            block91: while (true) {
                switch (var5_6 ^= 49807) {
                    default: {
                        continue block91;
                    }
                    case 18: lbl-1000:
                    // 2 sources

                    {
                        var7_7 = \u0645\u0641\u0630\u062d.\u0642\u062a\u0630\ufebd(Bili.\u0632\u0631\u0628\ufe8f(), 2349, 8, 756);
                        var3_3 = \ufe8e\ufeb9\u0647\u0642.\ufec1\ufed5\ufe99\ufea9(var4_4, var7_7);
                        var5_6 = 49914;
                        break block91;
                    }
                    case 241: {
                        var5_6 = 49821;
                        continue block91;
                    }
                }
                break;
            }
            block92: while (true) {
                switch (var5_6 ^= 49931) {
                    default: {
                        continue block92;
                    }
                    case 497: {
                        if (var3_3) {
                            var5_6 = 50658;
                            continue block92;
                        }
                    }
                    case 1711: {
                        var5_6 = 50627;
                        continue block92;
                    }
                    case 1769: {
                        var7_7 = (String)\u0641\u0631\ufeed\u0643.\ufedd\u0631\ufebd\u062d(var4_4, var7_7);
                        var5_6 = 50689;
                        break block92;
                    }
                    case 1736: {
                        var7_7 = \ufeb9\ufec9\u0648\u062d.\ufee9\u0637\ufef1\u0644(Bili.\u0632\u0631\u0628\ufe8f(), 2357, 1, 2098);
                        break block112;
                    }
                }
                break;
            }
            block93: while (true) {
                switch (var5_6 ^= 50706) {
                    default: {
                        continue block93;
                    }
                    case 19: {
                        var5_6 = 50720;
                        continue block93;
                    }
                    case 50: 
                }
                break;
            }
        }
        var9_8 /* !! */  = \ufeab\u0632\u062f\u0640.\u062f\u0627\ufe95\u0631(Bili.\u0632\u0631\u0628\ufe8f(), 2358, 3, 2888);
        var3_3 = \ufe8e\ufeb9\u0647\u0642.\ufec1\ufed5\ufe99\ufea9(var4_4, var9_8 /* !! */ );
        var5_6 = 50813;
        block94: while (true) {
            var8_9 = var1_1;
            switch (var5_6 ^= 50830) {
                default: {
                    continue block94;
                }
                case 243: {
                    if (var3_3) {
                        var5_6 = 51557;
                        continue block94;
                    }
                }
                case 18: {
                    var5_6 = 50875;
                    continue block94;
                }
                case 4075: {
                    var1_1 = \u0631\u063a\u0645\u0641.\u063a\ufeaf\u0628\ufe95(var1_1, \u0641\ufeb5\ufeb1\ufee1.\u0639\u0630\ufeaf\ufe95(Bili.\u0632\u0631\u0628\ufe8f(), 2361, 1, 1037));
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var1_1, (String)\u0641\u0631\ufeed\u0643.\ufedd\u0631\ufebd\u062d(var4_4, var9_8 /* !! */ ));
                    var8_9 = \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(var1_1);
                    break block94;
                }
                case 53: 
            }
            break;
        }
        var3_3 = \u062b\ufec1\ufeb1\u062d.\ufea9\u0628\u0637\ufe95(Bili.\u0648\ufeb5\ufe8e\u0646(), \ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(Bili.\u0632\u0631\u0628\ufe8f(), 2362, 240, 1248));
        var5_6 = 51588;
        block95: while (true) {
            switch (var5_6 ^= 51605) {
                default: {
                    continue block95;
                }
                case 17: {
                    if (var3_3) {
                        var5_6 = 51681;
                        continue block95;
                    }
                }
                case 54: {
                    var5_6 = 51650;
                    continue block95;
                }
                case 116: {
                    var9_8 /* !! */  = new StringBuilder();
                    var10_10 = \u062a\u0635\ufeb1\u0642.\u0637\u0636\u062a\ufedd(Bili.\u0632\u0631\u0628\ufe8f(), 2602, 79, 942);
                    var5_6 = 51712;
                    break block95;
                }
                case 87: {
                    var1_1 = new StringBuilder();
                    var4_4 = \ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(Bili.\u0632\u0631\u0628\ufe8f(), 2681, 83, 1962);
                    ** GOTO lbl-1000
                }
            }
            break;
        }
        block96: while (true) {
            var1_1 = var9_8 /* !! */ ;
            var4_4 = var10_10;
            switch (var5_6 ^= 51729) {
                default: {
                    continue block96;
                }
                case 14: lbl-1000:
                // 2 sources

                {
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var1_1, var4_4);
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var1_1, \u062b\u064a\ufecd\u0642.\ufec9\ufead\ufea9\ufe8f(var8_9));
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var1_1, \ufea9\ufe8f\u0647\ufead.\ufea9\u0643\ufedd\ufeed(Bili.\u0632\u0631\u0628\ufe8f(), 2764, 7, 1659));
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var1_1, var6_5);
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var1_1, \ufea9\ufe8f\u0647\ufead.\ufea9\u0643\ufedd\ufeed(Bili.\u0632\u0631\u0628\ufe8f(), 2771, 10, 2062));
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var1_1, var7_7);
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var1_1, \ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(Bili.\u0632\u0631\u0628\ufe8f(), 2781, 6, 1362));
                    \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var1_1, var2_2);
                    var2_2 = \ufeb9\u0627\ufea5\ufe9d.\u0631\u0647\u0639\ufebd(\ufebd\u0640\u0648\u062b.\u0646\ufed5\u0630\ufec9(\ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(var1_1), Bili.\ufed5\u064a\u0631\u062f()));
                    var1_1 = new ArrayList<E>();
                    var4_4 = \ufec1\u0636\u062d\u0638.\u062a\ufee1\ufe8e\ufecd(Bili.\u062a\ufee9\u062b\ufead(Bili.\ufedd\u0640\ufef1\u0638(\u0640\u0633\ufea5\u0631.\ufed9\ufea1\u0638\u062d(var2_2))));
                    break block96;
                }
                case 17: {
                    var5_6 = 51743;
                    continue block96;
                }
            }
            break;
        }
        block97: while (true) {
            var3_3 = \ufe8e\u0627\ufecd\u062a.\u062f\u0638\ufe8e\ufe99(var4_4);
            var5_6 = 51836;
            block98: while (true) {
                switch (var5_6 ^= 51853) {
                    default: {
                        continue block98;
                    }
                    case 241: {
                        if (var3_3) {
                            var5_6 = 52580;
                            continue block98;
                        }
                    }
                    case 1963: {
                        var5_6 = 52549;
                        continue block98;
                    }
                    case 2025: {
                        var2_2 = (My.yq)\ufea1\u0645\u062b\u0634.\ufe95\ufeaf\ufeb9\ufea1(var4_4);
                        var3_3 = \u0635\u0631\u0645\u0628.\ufead\ufee9\u0643\u0632(\ufeb9\u0643\ufed9\ufed5.\ufed5\ufed9\ufe9d\u0636(var2_2));
                        var5_6 = 52611;
                        block99: while (true) {
                            switch (var5_6 ^= 52628) {
                                default: {
                                    continue block99;
                                }
                                case 23: {
                                    if (var3_3) {
                                        var5_6 = 52704;
                                        continue block99;
                                    }
                                }
                                case 54: {
                                    var5_6 = 52673;
                                    continue block99;
                                }
                                case 116: {
                                    var5_6 = 52735;
                                    block100: while (true) {
                                        switch (var5_6 ^= 52752) {
                                            case 14: {
                                                continue block97;
                                            }
                                            default: {
                                                continue block100;
                                            }
                                            case 1007: 
                                        }
                                        var5_6 = 52766;
                                    }
                                }
                                case 85: 
                            }
                            break;
                        }
                        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(var1_1, \u0631\u063a\u0645\u0641.\u0648\u0637\ufe8e\u0635(var2_2));
                        var5_6 = 53510;
                        block101: while (true) {
                            switch (var5_6 ^= 53527) {
                                case 50: {
                                    continue block97;
                                }
                                default: {
                                    continue block101;
                                }
                                case 17: 
                            }
                            var5_6 = 53541;
                        }
                    }
                    case 1992: 
                }
                break;
            }
            break;
        }
        return \ufe99\u062e\u0642\u0644.\ufea1\u062e\ufecd\ufeab(var1_1);
    }

    /*
     * Exception decompiling
     */
    @Override
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
        Bili.\u0633\u0647\ufe9d\ufeb9((Object)this);
        Object object = Bili.\ufec1\u0631\u0640\u062d((Object)this);
        int n = 1616;
        block22: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block22;
                }
                case 49: {
                    if (object != null) {
                        n = 1709;
                        continue block22;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block22;
                }
                case 204: {
                    Bili.\ufea9\u0639\u062e\u062b((Object)this);
                    break block22;
                }
                case 239: 
            }
            break;
        }
        JsonObject jsonObject = Bili.\u062f\ufed5\u062b\ufebd((Object)this);
        object = \u0632\ufead\u062f\u0628.\u0645\u062a\u0637\u0635(Bili.\u0632\u0631\u0628\ufe8f(), 3008, 4, 711);
        bl = Bili.\ufee1\ufeb9\ufecd\u0634(jsonObject, object);
        n = 1740;
        block23: while (true) {
            switch (n ^= 0x6DD) {
                default: {
                    continue block23;
                }
                case 17: {
                    if (bl) {
                        n = 1833;
                        continue block23;
                    }
                }
                case 54: {
                    n = 1802;
                    continue block23;
                }
                case 500: {
                    return \ufebd\u0640\u0648\u062b.\u0646\ufed5\u0630\ufec9(Bili.\ufec9\ufe8f\u0633\u0634(Bili.\ufec1\ufee9\ufebd\ufeb9(Bili.\u062f\ufed5\u062b\ufebd((Object)this), object)), null);
                }
                case 471: 
            }
            break;
        }
        ArrayList arrayList = new ArrayList();
        object = new LinkedHashMap();
        String[] stringArray = \ufeb5\ufe8e\ufead\u0632.\u0640\ufec5\ufedd\u0634(Bili.\ufec9\ufe8f\u0633\u0634(Bili.\ufec1\ufee9\ufebd\ufeb9(Bili.\u062f\ufed5\u062b\ufebd((Object)this), \u062a\u0635\ufeb1\u0642.\u0637\u0636\u062a\ufedd(Bili.\u0632\u0631\u0628\ufe8f(), 3012, 4, 3077))), \ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(Bili.\u0632\u0631\u0628\ufe8f(), 3016, 1, 1875));
        int n2 = stringArray.length;
        int n3 = 0;
        block24: while (true) {
            n = 1864;
            block25: while (true) {
                switch (n ^= 0x759) {
                    default: {
                        continue block25;
                    }
                    case 17: {
                        if (n3 < n2) {
                            n = 48736;
                            continue block25;
                        }
                    }
                    case 47483: {
                        n = 48705;
                        continue block25;
                    }
                    case 47417: {
                        String string = stringArray[n3];
                        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList, new Jz(string, string));
                        ArrayList arrayList2 = new ArrayList();
                        List list = \u0645\u0641\u0630\u062d.\ufe9d\u0636\u064a\u0648(new p9.yq[]{new p9.yq(\ufee9\ufee1\u0627\u0641.\ufea1\ufebd\u063a\u0630(Bili.\u0632\u0631\u0628\ufe8f(), 3017, 2, 1741), \ufe8e\ufeb9\u0647\u0642.\ufee1\u062f\ufedd\u0643(Bili.\u0632\u0631\u0628\ufe8f(), 3019, 9, 449)), new p9.yq(\u062a\u0635\ufeb1\u0642.\u0637\u0636\u062a\ufedd(Bili.\u0632\u0631\u0628\ufe8f(), 3028, 4, 1305), \ufeb9\u0627\ufea5\ufe9d.\u062a\ufef1\u062d\u0641(Bili.\u0632\u0631\u0628\ufe8f(), 3032, 5, 3220)), new p9.yq(\u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(Bili.\u0632\u0631\u0628\ufe8f(), 3037, 4, 2553), \ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(Bili.\u0632\u0631\u0628\ufe8f(), 3041, 7, 3009)), new p9.yq(\ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(Bili.\u0632\u0631\u0628\ufe8f(), 3048, 4, 776), \ufeaf\u0633\u0648\ufee9.\u062e\u0645\u0644\u0648(Bili.\u0632\u0631\u0628\ufe8f(), 3052, 2, 2197)), new p9.yq(\ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(Bili.\u0632\u0631\u0628\ufe8f(), 3054, 4, 2634), \u0631\u0640\ufec1\ufee9.\ufe95\ufeed\u062c\ufec1(Bili.\u0632\u0631\u0628\ufe8f(), 3058, 4, 428))});
                        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList2, new p9(\ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(Bili.\u0632\u0631\u0628\ufe8f(), 3062, 5, 2577), \ufeb9\u0643\ufed9\ufed5.\u0628\u062f\ufea1\u0642(Bili.\u0632\u0631\u0628\ufe8f(), 3067, 2, 3100), list));
                        list = \u0645\u0641\u0630\u062d.\ufe9d\u0636\u064a\u0648(new p9.yq[]{new p9.yq(\ufee9\ufee1\u0627\u0641.\ufea1\ufebd\u063a\u0630(Bili.\u0632\u0631\u0628\ufe8f(), 3069, 4, 579), \u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(Bili.\u0632\u0631\u0628\ufe8f(), 3073, 1, 2009)), new p9.yq(\u0630\ufebd\u0634\ufec9.\u0639\ufe8f\u064a\ufebd(Bili.\u0632\u0631\u0628\ufe8f(), 3074, 6, 2971), \u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(Bili.\u0632\u0631\u0628\ufe8f(), 3080, 1, 1625)), new p9.yq(\u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(Bili.\u0632\u0631\u0628\ufe8f(), 3081, 7, 2126), \ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(Bili.\u0632\u0631\u0628\ufe8f(), 3088, 1, 450)), new p9.yq(\ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644(Bili.\u0632\u0631\u0628\ufe8f(), 3089, 7, 934), \ufee9\ufee1\u0627\u0641.\ufea1\ufebd\u063a\u0630(Bili.\u0632\u0631\u0628\ufe8f(), 3096, 1, 2650)), new p9.yq(\ufee9\ufee1\u0627\u0641.\ufea1\ufebd\u063a\u0630(Bili.\u0632\u0631\u0628\ufe8f(), 3097, 6, 1179), \u062d\u062e\ufe8e\u0645.\u062d\ufeab\u0642\u0647(Bili.\u0632\u0631\u0628\ufe8f(), 3103, 1, 3165))});
                        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(arrayList2, new p9(\u062b\ufec1\ufeb1\u062d.\u0637\u0647\u0635\u0630(Bili.\u0632\u0631\u0628\ufe8f(), 3104, 8, 2898), \u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(Bili.\u0632\u0631\u0628\ufe8f(), 3112, 2, 1319), list));
                        \u062d\ufeb9\ufeab\ufef1.\ufec5\u0641\u0628\ufeb9(object, string, arrayList2);
                        int n4 = n3 + 1;
                        n = 48767;
                        block26: while (true) {
                            n3 = n4;
                            switch (n ^= 0xBE90) {
                                case 14: {
                                    continue block24;
                                }
                                default: {
                                    continue block26;
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
        return \ufeaf\u062b\ufed5\ufec1.\ufee1\ufea9\u0634\u062f(arrayList, object);
    }

    /*
     * Enabled aggressive block sorting
     */
    public String homeVideoContent() {
        Object object = Bili.\ufed5\u064a\u0631\u062f();
        Object object2 = \ufeb9\u0627\ufea5\ufe9d.\u0631\u0647\u0639\ufebd(\ufebd\u0640\u0648\u062b.\u0646\ufed5\u0630\ufec9(\ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(Bili.\u0632\u0631\u0628\ufe8f(), 3114, 54, 1521), object));
        object = new ArrayList();
        object2 = \ufec1\u0636\u062d\u0638.\u062a\ufee1\ufe8e\ufecd(Bili.\u062a\ufee9\u062b\ufead(Bili.\ufea5\u0627\ufec9\u0632(\u0640\u0633\ufea5\u0631.\ufed9\ufea1\u0638\u062d(object2))));
        block10: while (true) {
            boolean bl = \ufe8e\u0627\ufecd\u062a.\u062f\u0638\ufe8e\ufe99(object2);
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
                        \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(object, \u0631\u063a\u0645\u0641.\u0648\u0637\ufe8e\u0635((My.yq)\ufea1\u0645\u062b\u0634.\ufe95\ufeaf\ufeb9\ufea1(object2)));
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
        return \ufe99\u062e\u0642\u0644.\ufea1\u062e\ufecd\ufeab(object);
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
    @Override
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
     * Enabled aggressive block sorting
     */
    public String searchContent(String string, boolean bl) {
        Object object = Bili.\ufec1\u0631\u0640\u062d((Object)this);
        int n = 1616;
        block6: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block6;
                }
                case 49: {
                    if (object != null) {
                        n = 1709;
                        continue block6;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block6;
                }
                case 204: {
                    Bili.\ufea9\u0639\u062e\u062b((Object)this);
                    break block6;
                }
                case 239: 
            }
            break;
        }
        object = new HashMap();
        return \ufeb1\ufe8e\ufee1\ufe9d.\u063a\u0637\u0641\ufea1((Object)this, string, \ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(Bili.\u0632\u0631\u0628\ufe8f(), 3660, 1, 1785), true, object);
    }

    public String searchContent(String string, boolean bl, String string2) {
        String string3 = "\u06e2\u06e8\u06df";
        HashMap hashMap = null;
        String string4 = null;
        block4: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string3)) {
                default: {
                    hashMap = new HashMap();
                    string3 = "\u06e3\u06e6\u06e7";
                    continue block4;
                }
                case 1750756: {
                    string4 = \ufeb1\ufe8e\ufee1\ufe9d.\u063a\u0637\u0641\ufea1((Object)this, string, string2, true, hashMap);
                    string3 = "\u06df\u06e4\u06e3";
                    continue block4;
                }
                case 1746846: 
            }
            break;
        }
        return string4;
    }

    private static long[] $d2j$hex$75098f37$decode_J(String src) {
        byte[] d = Bili.$d2j$hex$75098f37$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$75098f37$decode_I(String src) {
        byte[] d = Bili.$d2j$hex$75098f37$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$75098f37$decode_S(String src) {
        byte[] d = Bili.$d2j$hex$75098f37$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$75098f37$decode_B(String src) {
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

