/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.app.Application
 *  android.content.ClipData
 *  android.content.ClipboardManager
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.Intent
 *  android.content.SharedPreferences$Editor
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.graphics.Color
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnFocusChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.widget.ArrayAdapter
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.ListAdapter
 *  android.widget.TextView
 *  com.github.catvod.crawler.Spider
 *  com.github.catvod.crawler.SpiderDebug
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.github.catvod.spider;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
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
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.parser.\ufeb9\ufec9\u0648\u062d;
import com.github.catvod.parser.\ufec1\u0636\u062d\u0638;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.Cloud_ali;
import com.github.catvod.spider.Cloud_baidu;
import com.github.catvod.spider.Cloud_quark;
import com.github.catvod.spider.Cloud_uc;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.N;
import com.github.catvod.spider.Pan$4;
import com.github.catvod.spider.ProxyOrigin;
import com.github.catvod.spider.merge.Bu;
import com.github.catvod.spider.merge.Dr;
import com.github.catvod.spider.merge.E1;
import com.github.catvod.spider.merge.Ef;
import com.github.catvod.spider.merge.Gt;
import com.github.catvod.spider.merge.K0;
import com.github.catvod.spider.merge.M4;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.Rw;
import com.github.catvod.spider.merge.St;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.bH;
import com.github.catvod.spider.merge.dT;
import com.github.catvod.spider.merge.ej;
import com.github.catvod.spider.merge.fj;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.k_0;
import com.github.catvod.spider.merge.m_0;
import com.github.catvod.spider.merge.my_0;
import com.github.catvod.spider.merge.nA;
import com.github.catvod.spider.merge.oX;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.pg_0;
import com.github.catvod.spider.merge.sn_1;
import com.github.catvod.spider.merge.uA;
import com.github.catvod.spider.merge.x3;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.zh_0;
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
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class Pan
extends Spider {
    public static String Gd;
    public static Gt Nl;
    public static AlertDialog OW;
    public static boolean ee;
    public static String g9;
    private static final short[] short;
    public static boolean v;
    public static long xa;
    private Boolean B;
    protected Boolean F5;
    private Boolean G;
    private Boolean G4;
    public final List<String> Gc;
    public final List<String> KJ;
    public final List<String> M;
    public Cloud_uc N;
    public Cloud_ali SN;
    protected Boolean W;
    protected Boolean dT;
    public final List<String> i;
    private Boolean q;
    public final List<String> t0;
    public Cloud_baidu tF;
    protected Boolean v3;
    public Cloud_quark yq = new Cloud_quark();
    public final List<String> zH;

    static {
        short = Pan.$d2j$hex$9a1fc47e$decode_S("226c0c5932063508350835086c0823082e082b083b0837082c08260830082b08340827086c0821082d082f081308130813084a08050808080d08140805080a084a0807080b080908160300031b03040317035c03070311035c0311031c039a0a8b0a840ac40a880a8b0a830a8e0a9f0ac40a890a850a870abe05af05a005e005bf05bb05af05bc05a505e005ad05a005d30ad00ad10a4d0c5b0c400c5f0c4c0c070c5c0c4a0c070c4a0c470cae03f603e1031a060b060406440608060b0603060e061f064406090605060706480a4e0a070a100a3a053a053a0563052c052105240534053805230529053f0524053b05280563052e05220520050a0a0a0a0a0a530a1c0a110a140a0d0a1c0a130a530a1e0a120a100a370c7b0c6c0c730762076d072d07720776076207710768072d0760076d07ac03f003e703300b3c0b3a0b330b380b290b1f424242650c6069cb7a647fe55813571757840c5172e880687c3e86a70bdd45097d228eec6c6d58737f480448774962e6636a03104dc475ef862164815f430cc952c952c90bcc7665458073ee6d450ab959eb7c099426946f958f5b27028471897454685d5983938393c40a66857b6db761580af67c91837372616e09538b01d586d786aa06a206ad06a806a806ac06aa06aa06a206a8069e55177e3957ba07a607ab07b3078707a507ae07af07e505f105cc05fa05e105fe05ed05d705fd05fb05ed05db05fc05e905fc05ed05330c3e0c3b0c0d0c270c210c370c010c260c330c260c370c44024202790253025502430275025202470252024302420b540b680b420b440b520b640b430b560b430b520bf703f303e703f403ed03d903f303f503e303d503f203e703f203e303bc03ad03be03bf03a903600367037903cc08d208c6084b0b5c0b5c0b630b5d0b490bce03df03c203ce039503d203ce03d703d6033c053f053f0531053e0529057605740569057e057f053905620569053b0553054505200572057f05760563053b056f0568057605730572052005ae6607953b05210526052d052605630568056505690562056305530554054f05450569056b057605690568056305680572052e057605730575056e05530574056a052f053d050c052605260526052605260526057b05260563056a057505630526056f05600526052e057605730575056e0552057f057605630526053b053b053b0526052105350521052f0526057d050c0526052605260526052605260526052605670576056f05530574056a0526053b05260521056e057205720576053c05290529050a0709070907070708071f07400742075f07480749070f0754075f070d0752075107590754074507160744074907400755070d0759075e074007450744071607986431970d07170710071b07100755075e0753075f075407550765076207790773075f075d0740075f075e0755075e07440718074007450743075807650742075c0719070b073a071007100710071007100710074d07100755075c0743075507100759075607100718074007450743075807640749074007550710070d070d070d071007170702071707190710074b073a0710071007100710071007100710071007510740075907650742075c0710070d071007170758074407440740070a071f071f070207010701070f070007170748074a0757074007410707075c075707050749074d0759074a0753071e074c07410748075d0705075107560748074d074c071e079064399705071f071807130718075d0756075b0757075c075d076d076a0771077b07570755074807570756075d0756074c07100748074d074b0750076d074a0754071107030732071807180718071807180718074507180718075d0754074b075d07180751075e071807100748074d074b0750076c07410748075d07180705070507050718071f070c071f071107180743073207180718071807180718071807180718075907480751076d074a0754071807050718071f0750074c074c0748070207170717077006730673067d06720665063a06380625063206330675062e06250677067b06780679066c063e0633063a062f067706230624063a063f063e066c06e2654b9677066d066a0661066a062f062406290625062e062f061f06180603060906250627063a06250624062f0624063e0662063a063f06390622061f06380626066306710640066a066a066a066a066a066a066a0637062f06260639062f066a0623062c066a0662063a063f06390622061e0633063a062f066a067706770677066a066d067f066d0663066a06310640066a066a066a066a066a066a066a066a062b063a0623061f06380626066a0677066a066d0622063e063e063a06700665066506bb09b809b809b609b909ae09f109f309ee09f909f809be09e509ee09bc09e009ed09e809a709f509f809f109e409bc09e809ef09f109f409f509a709296a8099bc09a609a109aa09a109e409ef09e209ee09e509e409d409d309c809c209ee09ec09f109ee09ef09e409ef09f509a909f109f409f209e909d409f309ed09a809ba098b09a109a109a109a109a109a109a109fc09e409ed09f209e409a109e809e709a109a909f109f409f209e909d509f809f109e409a109bc09bc09bc09a109a609b709a609a809a109fa098b09a109a109a109a109a109a109a109a109e009f109e809d409f309ed09a109bc09a109a609e909f509f509f109bb09ae09ae09a008a308a308ad08a208b508ea08e808f508e208e308a508fe08f508a708f808f308f608f308bc08ee08e308ea08ff08a708f308f408ea08ef08ee08bc08326b9b98a708bd08ba08b108ba08ff08f408f908f508fe08ff08cf08c808d308d908f508f708ea08f508f408ff08f408ee08b208ea08ef08e908f208cf08e808f608b308a1089008ba08ba08ba08ba08ba08ba08e70890089008ba08ba08ba08ba08ba08ba08ec08fb08e808ba08e208f208e808ba08a708ba08f408ff08ed08ba08c208d708d608d208ee08ee08ea08c808ff08eb08ef08ff08e908ee08b208b308a1089008ba08ba08ba08ba08ba08ba08e208f208e808b408f508ea08ff08f408b208bd08dd08df08ce08bd08b608ba08fb08ea08f308cf08e808f608b608ba08ee08e808ef08ff08b308a1089008ba08ba08ba08ba08ba08ba08e208f208e808b408f508f408e808ff08fb08fe08e308e908ee08fb08ee08ff08f908f208fb08f408fd08ff08ba08a708ba08fc08ef08f408f908ee08f308f508f408ba08b208b308ba08e1089008ba08ba08ba08ba08ba08ba08ba08ba08f308fc08ba08b208e208f208e808b408e808ff08fb08fe08e308c908ee08fb08ee08ff08ba08a708a708a708ba08c208d708d608d208ee08ee08ea08c808ff08eb08ef08ff08e908ee08b408de08d508d408df08b308ba08e1089008ba08ba08ba08ba08ba08ba08ba08ba08ba08ba08f308fc08ba08b208e208f208e808b408e908ee08fb08ee08ef08e908ba08a708a708a708ba08a808aa08aa08b308ba08e1089008ba08ba08ba08ba08ba08ba08ba08ba08ba08ba08ba08ba08f908f508f408e908f508f608ff08b408f608f508fd08b208bd086d83d8648a6a055abd08b308a1089008ba08ba08ba08ba08ba08ba08ba08ba08ba08ba08e708ba08ff08f608e908ff08ba08e1089008ba08ba08ba08ba08ba08ba08ba08ba08ba08ba08ba08ba08f908f508f408e908f508f608ff08b408f608f508fd08b208bd086d83d864ab51bf85bd08b308a1089008ba08ba08ba08ba08ba08ba08ba08ba08ba08ba08e7089008ba08ba08ba08ba08ba08ba08ba08ba08e7089008ba08ba08ba08ba08ba08ba08e708a1089008ba08ba08ba08ba08ba08ba08e208f208e808b408e908ff08f408fe08b208b308a1089008ba08ba08ba08ba08e7089008ba08ba08a608b508e908f908e808f308ea08ee08a4089008a608b508f808f508fe08e308a40890089008a608b508f208ee08f708f608a408f5505176050318038a663a954a0369264a0310659783a3632485f905da20f9054656e270b605ab05396089938755f2064d55e973bd06a00632638290435136026c64eb823d557d54d0488d90c296c5498d6aa760f55190549709e809df09e209f609f709ec09090b1d0b1c0b070b340b7c0b030b00047f04af06bb06ba06a10699098f09477bce72a97af9895b5618508467995a2a58a3738d5af305f751f070f54bf0053756038abd545451c461fa78328429580073f1053b6aae7e12511c7a07080a08c26e937fbd564d5fc474ea5dbc632977b54efd6d80018d017d6be87f735f735f41094c09eb677e73c5930277d705da05d856df77da4c9f51eb74ee4f9255cc6b854ecd6dc1fea558ab73c1fe82578257c1fea29765734b4703640ff74c5e4c5e0ff76b51657a0ff76c9eab7a30513e7a54f7175e175e54f71047586454f7379ef07a405e4e7524f86048286b24f86751675124f847918075385338537bfa1f5c11777bfa3f4a77697bfa1893df77675d675d24f46044286724f440524e7924f4479d8079bb7c32757860655dc104d504e804de04c504da04c904f304d904df04c904ff04d804cd04d804c904e55791729449ba04b704b2048404ae04a804be048804af04ba04af04be04db02dd02e602cc02ca02dc02ea02cd02d802cd02dc02d50cc30cff0cd50cd30cc50cf30cd40cc10cd40cc50c180c1c0c080c1b0c020c360c1c0c1a0c0c0c3a0c1d0c080c1d0c0c0c9e5099719c4a4292a057ce03df03df03fc506050548cea5265827e5ede7c5775e36ec388176bb65ccf603e0b340b310b340b72047e04780471047a046b04a77efd54846a420642064206a77efd546d481b895208520852087d460b8752088e03820384038d0386039703d90373046f046f046b0468042104ee7ab450d001cc01cc01c801cb01820197019701d101d501df0188018f019601cb01d701df01d701cd01db01dc01d6019601db01d701d5019701ce018a019701cc01d001cd01d501da019701ca01dd01cc01c101c801dd01e701dd01c001db01d401cd01dc01dd01e701df01d101de019701dd01c001cc019701d901cd01cc01d7019701c901970181018d019701db01ca01d701c8019701c001c1019701d901d1019701cc019701880197018701d901c801c801d101dc01850189018a018a019e01cd01ca01d4018501d001cc01cc01c801cb01820197019701d701cb01cb018c01d401d101ce01d101dd01cf019601d501d701d201d1019601db01d701d5019701cc01d001dc01e701de01d101d401dd0197018a0188018a018d01970188018f0197018a0180019701d9018e01da01dc01da018a018a01db01db018c01da018801da01de01db018f01da018b018b018b01de01dd01db018d01dc0188018a018f01da0181018d0189019601d201c801df01cf47fa5dd306c206cd06fc06d006cc06d106d7063b0427043a043c040e4346604af32e55207e4af3095a095a4af3299aee7eac03acfc77527752ee48a66b955c9b77ac916b75740374037403b60cb002de07ca07d707d507cb07680a740a790a610a6b0ad05dcc05c905cf05d405735c7d77954ddd6e0f540f54e79d2079317b6b51fb4d8d8cee8c1097f06512496488fc5a6e562d0b2d0b2d0bfb0ce20ce90cd20ce40ce90ce104e104e104cc0bd50bde0be50bd40bdb0bd70bdf0b94048d048604bd04900487048f0483049004890491049e058a05b70581059a0585059605ac05860580059605a00587059205870596051b011f010b011801010135011f0119010f0139011e010b011e010f01e30bf50bc90be30be50bf30bc50be20bf70be20bf30baf06a206a7069106bb06bd06ab069d06ba06af06ba06ab06890a8f0ab40a9e0a980a8e0ab80a9f0a8a0a9f0a8e0a040c150c1a0c270c1b0c010c060c170c110c270c1b0c060c000c0905180517052a0516050b050d053c0539053f0524050f052705f706d406dc06d206d5060a0b060b040b470b180b1c0b080b1b0b020b470b0b0b1b0b060b1e0b1a0b0c0b1b0b940a980a9a0ad90a8f0a820a990a9b0a920a9e0ad90a930a980a800a990a9b0a980a960a930a870a850a980a810a9e0a930a920a850a87058b058905ca05860585058d0580059105ca058a058105900580058d0597058f0582038e038c03cf03940382038c038e03830388038d038403cf038d03880395038403e403e903e003a303e403e303f903e803ff03e303e803f903a303e903e203fa03e303e103e203ec03e903a303e003ec03e303ec03ea03e803ff03a303fd03e103f803fe0327022b0229026a021102070209022b0226022d0228022102ff0bf30bf10bb20bec0bf50bf70bff0bf00bf30be90bf80bb20bec0bf50bf70bec0bfd0bf70ba10aad0aaf0aec0ab10abb0aac0aad0aae0aad0aa50abb0aec0a860a910aa60aad0ab50aac0aae0aad0aa30aa60a616be09c9866727c4c6b186e565e895f4e79f2524e795771a3527a87849c646e1952a579de6e8d537f54216aa401b801b801bc01f601e301e3015f025c025c0252025d024a02150217020a021d021c025a0201020a0258020c020b0215021002110243020602160215025802010217020c0213020002214a7670f05abf4a35675f7df6665f957e051d0531053105350537053b057e0548677e050a05310535053b053005");
        Gd = \ufed9\ufe9d\ufeed\ufeb5.\u0638\ufec1\u063a\u0644(short, 0, 3, 1539);
    }

    public Pan() {
        this.SN = new Cloud_ali();
        this.N = new Cloud_uc();
        this.tF = new Cloud_baidu();
        this.zH = Arrays.asList(\ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(short, 3, 19, 2114), \u0631\ufea1\u0638\u0627.\u0645\u062f\u062d\ufeaf(short, 22, 14, 2148), \u062d\ufeb9\ufeab\ufef1.\ufeed\u0638\u0635\ufed5(short, 36, 11, 882), \u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(short, 47, 13, 2794), \ufea5\u062d\ufebd\u0633.\ufea5\ufeb1\u0643\ufe8f(short, 60, 12, 1486), \u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(short, 72, 3, 2786));
        this.i = Arrays.asList(\ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644(short, 75, 11, 3113), \u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(short, 86, 3, 987));
        this.t0 = Arrays.asList(\ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(short, 89, 13, 1642), \ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(short, 102, 4, 2602));
        this.Gc = Arrays.asList(\u062d\u062e\ufe8e\u0645.\u062d\ufeab\u0642\u0647(short, 106, 19, 1357), \u062d\u062e\ufe8e\u0645.\u062d\ufeab\u0642\u0647(short, 125, 14, 2685), \u0631\u0640\ufec1\ufee9.\ufe95\ufeed\u062c\ufec1(short, 139, 3, 3158));
        this.M = Arrays.asList(\u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(short, 142, 12, 1795), \u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(short, 154, 3, 989));
        this.KJ = Arrays.asList(\ufed9\ufe9d\ufeed\ufeb5.\u0638\ufec1\u063a\u0644(short, 157, 6, 2909));
    }

    private Drawable Gc() {
        int n = Color.argb((int)255, (int)226, (int)124, (int)116);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(n);
        gradientDrawable.setCornerRadius(10.0f);
        gradientDrawable.setStroke(1, n);
        return gradientDrawable;
    }

    /*
     * Exception decompiling
     */
    private Boolean KJ(String var1_1) {
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

    private Drawable M() {
        int n = Color.argb((int)200, (int)0, (int)120, (int)215);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(n);
        gradientDrawable.setCornerRadius(10.0f);
        gradientDrawable.setStroke(1, n);
        return gradientDrawable;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ void N(Pan pan, Button button, String string, boolean bl) {
        Objects.requireNonNull(pan);
        pan = bl ? pan.M() : (!string.contains(\ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(short, 239, 3, 2156)) ? pan.Gc() : pan.t0());
        button.setBackground((Drawable)pan);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ void SN(Pan object, View view) {
        void var0_2;
        block5: {
            block6: {
                void var1_6;
                Objects.requireNonNull(object);
                int n = (Integer)var1_6.getTag();
                if (n == 0) break block6;
                if (n != 1) {
                    if (n != 2) {
                        if (n != 3) {
                            return;
                        }
                        if (object.G == false) return;
                        pg_0 pg_02 = pg_0.SN;
                        break block5;
                    } else {
                        if (object.G4 == false) return;
                        ej ej2 = ej.SN;
                    }
                    break block5;
                } else {
                    if (object.B == false) return;
                    my_0 my_02 = my_0.SN;
                }
                break block5;
            }
            if (object.q == false) return;
            x3 x32 = x3.SN;
        }
        InitOrigin.execute((Runnable)var0_2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static DialogInterface.OnDismissListener dismissInputQRCode() {
        block4: {
            AlertDialog alertDialog;
            try {
                alertDialog = OW;
                if (alertDialog == null) break block4;
            }
            catch (Exception exception) {
                return null;
            }
            alertDialog.dismiss();
        }
        return null;
    }

    public static File getPlayModeFilesDir() {
        return M4.SN(\ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(short, 242, 8, 1994));
    }

    /*
     * Unable to fully structure code
     */
    public static /* synthetic */ void i(Pan var0, Button var1_1, View var2_2, boolean var3_3) {
        block5: {
            block6: {
                block8: {
                    block7: {
                        Objects.requireNonNull(var0);
                        var4_4 = (Integer)var2_2.getTag();
                        var2_2 = InitOrigin.context();
                        InitOrigin.context();
                        var2_2 = var2_2.getSharedPreferences(\u0633\u064a\u0644\u0637.\ufec9\ufeed\ufeb5\u0640(Pan.short, 250, 16, 1416), 0);
                        if (var3_3) {
                            var0 = var0.M();
lbl10:
                            // 3 sources

                            while (true) {
                                var1_1.setBackground((Drawable)var0);
lbl12:
                                // 2 sources

                                return;
                            }
                        }
                        if (var4_4 == 0) break block5;
                        if (var4_4 == 1) break block6;
                        if (var4_4 == 2) break block7;
                        ** while (var4_4 != 3)
lbl18:
                        // 1 sources

                        if (!var2_2.getBoolean(\u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(Pan.short, 266, 12, 3154), false)) break block8;
lbl19:
                        // 4 sources

                        while (true) {
                            var0 = var0.t0();
                            ** GOTO lbl10
                            break;
                        }
                    }
                    if (var2_2.getBoolean(\ufed9\ufe9d\ufeed\ufeb5.\u0638\ufec1\u063a\u0644(Pan.short, 278, 11, 550), false)) ** GOTO lbl19
                }
lbl25:
                // 3 sources

                while (true) {
                    var0 = var0.Gc();
                    ** continue;
                    break;
                }
            }
            if (!var2_2.getBoolean(\u0635\u0631\u0645\u0628.\u0646\u0627\u062a\u062d(Pan.short, 289, 11, 2871), false)) ** GOTO lbl25
            ** GOTO lbl19
        }
        if (var2_2.getBoolean(\ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(Pan.short, 300, 14, 902), false)) ** break;
        ** while (true)
        ** while (true)
    }

    public static JSONObject msg(String string) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(\ufe8f\ufe8e\ufeb5\u0641.\u062f\u0627\u0640\ufee1(short, 314, 5, 972), 0);
        jSONObject.put(\ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(short, 319, 3, 789), (Object)"");
        jSONObject.put(\ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(short, 322, 3, 2209), (Object)string);
        jSONObject.put(\u062a\u0635\ufeb1\u0642.\u0637\u0636\u062a\ufedd(short, 325, 6, 2862), (Object)string);
        return jSONObject;
    }

    public static Object[] proxyInput() {
        String string = ProxyOrigin.getInternalIP();
        String string2 = \ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(short, 331, 9, 954);
        StringBuilder stringBuilder = zh_0.N("<!DOCTYPE html>\n<html lang=\"zh-cmn-Hans\">\n\n<head>\n  <meta charset=\"UTF-8\">\n  <meta name=\"viewport\" content=\"width=device-width,initial-scale=1,user-scalable=0,viewport-fit=cover\">\n  <style>\n    body {\n      display: flex;\n      flex-direction: column;\n      align-items: center;\n      justify-content: center;\n      min-height: 100vh;\n      margin: 0;\n      font-family: Arial, sans-serif;\n    }\n\n    .container {\n      width: 90%;\n      max-width: 500px;\n      display: flex;\n      flex-direction: column;\n      align-items: center;\n    }\n\n    .title {\n      font-size: 1.2em;\n      margin-bottom: 30px;\n      text-align: center;\n    }\n\n    .title span {\n      color: red;\n      font-weight: bold;\n    }\n\n    .input-wrapper {\n      width: 100%;\n      margin-bottom: 15px;\n    }\n\n    .input-wrapper textarea {\n      width: 100%;\n      height: 100px;\n      box-sizing: border-box;\n      padding: 10px;\n      font-size: 1em;\n      resize: none;\n    }\n\n    .select-container {\n      width: 100%;\n      margin-bottom: 15px;\n    }\n\n    .select-container select {\n      width: 100%;\n      height: 42px;\n      box-sizing: border-box;\n      padding: 0 10px;\n      font-size: 1em;\n      text-align: center;\n      text-align-last: center; /* For modern browsers */\n    }\n\n    .button {\n      width: 100%;\n      height: 42px;\n      box-sizing: border-box;\n      font-size: 1em;\n      margin-bottom: 10px;\n      cursor: pointer;\n    }\n\n    .button.push {\n      background-color: #4CAF50;\n      color: white;\n      border: none;\n    }\n\n    .button.clear {\n      background-color: #f44336;\n      color: white;\n      border: none;\n    }\n\n    .image-wrapper {\n      width: 100%;\n      display: flex;\n      justify-content: center;\n      margin-bottom: 15px;\n    }\n\n    .image-wrapper img {\n      width: 20%;\n    }\n  </style>\n</head>\n\n<body>\n  <div class=\"container\">\n    <div class=\"image-wrapper\">\n      <img src=\"https://img07.sogoucdn.com/v2/thumb/retype_exclude_gif/ext/auto/q/95/crop/xy/ai/t/0/?appid=122&url=https://s1.imagehub.cc/images/2026/03/01/02825385af7950edd9bcc89687373210.md.png\" alt=\"\u56fe\u7247\">\n    </div>\n    <div class=\"input-wrapper\">\n      <textarea id=\"push_url\"\n        placeholder=\"\u8bf7\u8f93\u5165\u4f60\u9700\u8981\u63a8\u9001\u7684\n\u5938\u514b Cookie\n\u767e\u5ea6 Cookie\n\u963f\u91cc 32\u4f4dToken\n\u54d4\u54e9 Cookie\n\"></textarea>\n    </div>\n    <div class=\"select-container\">\n      <select id=\"push_type\">\n        <option value=\"2\">\u5938\u514bCookie</option>\n        <option value=\"3\">\u767e\u5ea6Cookie</option>\n        <option value=\"5\">\u963f\u91ccToken</option>\n        <option value=\"6\">\u54d4\u54e9Cookie</option>\n      </select>\n    </div>\n    <button class=\"button push\" onclick=\"push()\">\u63a8\u9001</button>\n    <button class=\"button clear\" onclick=\"clearInput()\">\u6e05\u9664</button>\n  </div>\n\n  <script>\n    function clearInput() {\n      document.getElementById('push_url').value = '';\n    }\n\n    function push() {\n      var pushUrl = encodeURIComponent(document.getElementById('push_url').value);\n      var pushType = document.getElementById('push_type').value;\n      var apiUrl = '';\n\n      if (pushType === '1') {\n        apiUrl = 'http://", string, \u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(short, 340, 127, 1286), string, \u0631\ufea1\u0638\u0627.\u0645\u062f\u062d\ufeaf(short, 467, 130, 1840));
        k_0.t0(stringBuilder, string, \u062a\ufee1\ufe8e\ufeb9.\ufec5\ufecd\ufea9\ufea5(short, 597, 131, 1848), string, \ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(short, 728, 128, 1610));
        stringBuilder.append(string);
        stringBuilder.append(\ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(short, 856, 128, 2433));
        stringBuilder.append(string);
        stringBuilder.append(\u0633\u064a\u0644\u0637.\ufec9\ufeed\ufeb5\u0640(short, 984, 454, 2202));
        return new Object[]{200, string2, new ByteArrayInputStream(stringBuilder.toString().getBytes())};
    }

    public static void showPanSourceSortDialog(Activity activity) {
        String string = \u0631\u0640\ufec1\ufee9.\ufe95\ufeed\u062c\ufec1(short, 1438, 11, 874);
        String string2 = \ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(short, 1449, 11, 1497);
        String string3 = \u0631\u0640\ufec1\ufee9.\ufe95\ufeed\u062c\ufec1(short, 1460, 8, 1746);
        String string4 = \u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(short, 1468, 4, 534);
        String string5 = \ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(short, 1472, 10, 1757);
        CharSequence[] charSequenceArray = new String[]{string, string2, string3, string4, string5};
        string3 = \u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(short, 1482, 7, 2467);
        string5 = \u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(short, 1489, 7, 2888);
        string4 = \ufee9\ufee1\u0627\u0641.\ufea1\ufebd\u063a\u0630(short, 1496, 2, 1076);
        string = \u0632\ufead\u062f\u0628.\u0645\u062a\u0637\u0635(short, 1498, 4, 1774);
        string2 = \ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(short, 1502, 2, 2508);
        activity = new AlertDialog.Builder((Context)activity);
        activity.setTitle((CharSequence)\ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(short, 1504, 8, 1046));
        activity.setItems(charSequenceArray, new DialogInterface.OnClickListener(new String[]{string3, string5, string4, string, string2}, (String[])charSequenceArray){
            private static final short[] short = new short[]{547, 562, 573, 524, 544, 572, 550, 545, 560, 566, 524, 544, 572, 545, 551, 1300, 1387, 1372, 1377, 1397, 1396, 1391, 2997, 2985, 2996, 2994, 1733, 1740, 1754, 26522, 23175, 24452, 26136, 1064, 1074, 1064, 845, 877, 3292, 3272, 3273, 3282, 2255, 2224, 1233, 1254, 1264, 1254, 1271, -28136, 30431, 22456, -27462, 28797, 25855, 23253, 29147, 20594, 24385, 29775, 24579, 19346, 26842, 24938, -27942, 18966, 26974, 25460, 1256, 1278};
            final String[] SN;
            final String[] yq;
            {
                this.yq = stringArray;
                this.SN = stringArray2;
            }

            /*
             * Enabled aggressive block sorting
             */
            public void onClick(DialogInterface object, int n) {
                object = InitOrigin.context();
                InitOrigin.context();
                String[] stringArray = object.getSharedPreferences(\ufee9\u0631\ufeb5\u0628.\u0636\ufeab\u0634\u0633(short, 0, 15, 595), 0);
                SharedPreferences.Editor editor = stringArray.edit();
                String string = \ufe99\u062c\u0643\ufec1.\u0648\u0634\u063a\ufeb1(short, 15, 7, 1312);
                ArrayList<String> arrayList = \ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(short, 22, 4, 3014);
                if (n == 4) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(stringArray.getString((String)((Object)arrayList), string));
                    ((StringBuilder)object).append(\ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(short, 26, 3, 1721));
                    object = ((StringBuilder)object).toString();
                } else {
                    object = this.yq[n];
                }
                editor.putString((String)((Object)arrayList), (String)object);
                editor.apply();
                object = new StringBuilder();
                ((StringBuilder)object).append(\u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(short, 29, 7, 1032));
                ((StringBuilder)object).append(this.SN[n]);
                InitOrigin.show(((StringBuilder)object).toString());
                String string2 = \ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644(short, 36, 2, 785);
                object = n == 4 ? stringArray.getString((String)((Object)arrayList), string) : this.yq[n];
                stringArray = ((String)object).split(string2);
                arrayList = new ArrayList();
                int n2 = Math.min(stringArray.length, 2);
                n = 0;
                while (true) {
                    block18: {
                        block17: {
                            object = \u0641\ufeb5\ufeb1\ufee1.\u0639\u0630\ufeaf\ufe95(short, 38, 4, 3229);
                            string = \ufeaf\u0633\u0648\ufee9.\u062e\u0645\u0644\u0648(short, 42, 2, 2299);
                            if (n >= n2) break;
                            if (string.equalsIgnoreCase(stringArray[n])) break block17;
                            string = stringArray[n];
                            if (!\ufeaf\u0633\u0648\ufee9.\u062e\u0645\u0644\u0648(short, 44, 5, 1155).equalsIgnoreCase(string)) break block18;
                        }
                        arrayList.add(\ufea5\u062d\ufebd\u0633.\ufea5\ufeb1\u0643\ufe8f(short, 49, 3, 1063));
                    }
                    if (((String)object).equalsIgnoreCase(stringArray[n])) {
                        arrayList.add(\u0633\u064a\u0644\u0637.\ufec9\ufeed\ufeb5\u0640(short, 52, 3, 645));
                    }
                    ++n;
                }
                j_0.v().C((List<String>)arrayList);
                arrayList = new ArrayList<String>();
                n2 = Math.min(stringArray.length, 2);
                for (n = 0; n < n2; ++n) {
                    if (string.equalsIgnoreCase(stringArray[n])) {
                        arrayList.add(\ufeb9\u0643\ufed9\ufed5.\u0628\u062f\ufea1\u0642(short, 55, 3, 1005));
                    }
                    if (!((String)object).equalsIgnoreCase(stringArray[n])) continue;
                    arrayList.add(\u0630\ufebd\u0634\ufec9.\u0639\ufe8f\u064a\ufebd(short, 58, 3, 1657));
                }
                N0.Zm().Fo(arrayList);
                arrayList = new ArrayList();
                n2 = Math.min(stringArray.length, 2);
                n = 0;
                while (true) {
                    if (n >= n2) {
                        i3.s().Fo(arrayList);
                        return;
                    }
                    boolean bl = string.equalsIgnoreCase(stringArray[n]);
                    String string3 = \ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(short, 61, 4, 1162);
                    String string4 = \u0632\ufead\u062f\u0628.\u0645\u062a\u0637\u0635(short, 65, 3, 1294);
                    if (bl) {
                        if (stringArray.length == 3 && n == 0 || stringArray.length == 2 && stringArray[1].equals(\ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(short, 68, 2, 1181))) {
                            arrayList.add(string4);
                        } else {
                            arrayList.add(string3);
                        }
                    }
                    if (((String)object).equalsIgnoreCase(stringArray[n])) {
                        if (stringArray.length == 3 && n == 1) {
                            arrayList.add(string3);
                        } else {
                            arrayList.add(string4);
                        }
                    }
                    ++n;
                }
            }
        });
        activity.create().show();
    }

    private Drawable t0() {
        int n = Color.argb((int)255, (int)4, (int)204, (int)148);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(n);
        gradientDrawable.setCornerRadius(10.0f);
        gradientDrawable.setStroke(1, n);
        return gradientDrawable;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public static void tF(Pan pan, Activity object) {
        void var6_15;
        Objects.requireNonNull(pan);
        boolean bl = ME.ee(N0.Zm().F5) && ME.ee(N0.Zm().ee);
        pan.q = bl;
        pan.B = ME.ee(i3.s().Gc);
        bl = ME.ee(j_0.v().zH) && ME.ee(j_0.v().Gc.t0());
        pan.G = bl;
        bl = ME.ee(xu_0.xa().W.N()) && ME.ee(xu_0.xa().F5);
        pan.G4 = bl;
        pan.setUseState();
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)object);
        LinearLayout linearLayout = new LinearLayout((Context)object);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(16, 16, 16, 16);
        TextView textView = new TextView((Context)object);
        textView.setText((CharSequence)\ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(short, 1512, 18, 1496));
        textView.setTextSize(20.0f);
        textView.setTypeface(null, 1);
        textView.setGravity(17);
        linearLayout.addView((View)textView);
        StringBuilder stringBuilder = oi_0.yq(\ufe8f\ufe8e\ufeb5\u0641.\u062f\u0627\u0640\ufee1(short, 1530, 6, 2090));
        bl = pan.q;
        String string = \u062a\u0635\ufeb1\u0642.\u0637\u0636\u062a\ufedd(short, 1536, 3, 2536);
        String string2 = \u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(short, 1539, 3, 703);
        CharSequence charSequence = bl ? string : string2;
        stringBuilder.append((String)charSequence);
        String string3 = stringBuilder.toString();
        StringBuilder stringBuilder2 = oi_0.yq(\u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(short, 1542, 6, 429));
        charSequence = pan.B != false ? string : string2;
        stringBuilder2.append((String)charSequence);
        String string4 = stringBuilder2.toString();
        StringBuilder stringBuilder3 = oi_0.yq(\ufeb9\u0627\ufea5\ufe9d.\u062a\ufef1\u062d\u0641(short, 1548, 6, 2412));
        charSequence = pan.G4 != false ? string : string2;
        stringBuilder3.append((String)charSequence);
        String string5 = stringBuilder3.toString();
        charSequence = oi_0.yq(\u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(short, 1554, 6, 1530));
        if (!pan.G.booleanValue()) {
            String string6 = string2;
        }
        ((StringBuilder)charSequence).append((String)var6_15);
        String string7 = ((StringBuilder)charSequence).toString();
        bl = pan.dT;
        String string8 = \u0636\u0634\ufec1\u0631.\u062c\u063a\u0643\u0627(short, 1560, 3, 759);
        charSequence = \u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(short, 1563, 3, 451);
        if (bl) {
            String string9 = string8;
        } else {
            CharSequence charSequence2 = charSequence;
        }
        if (pan.F5.booleanValue()) {
            String string10 = string8;
        } else {
            CharSequence charSequence3 = charSequence;
        }
        if (pan.W.booleanValue()) {
            String string11 = string8;
        } else {
            CharSequence charSequence4 = charSequence;
        }
        if (!pan.v3.booleanValue()) {
            CharSequence charSequence5 = charSequence;
        }
        int n = 0;
        while (true) {
            void var6_17;
            void var10_29;
            void var9_26;
            void var8_12;
            if (n >= 4) {
                pan = builder.setView((View)linearLayout);
                Bu bu = Bu.yq;
                pan.setNegativeButton(\ufea5\u062d\ufebd\u0633.\ufea5\ufeb1\u0643\ufe8f(short, 1566, 2, 1604), bu);
                builder.create().show();
                return;
            }
            String string12 = (new String[]{string3, string4, string5, string7})[n];
            String string13 = (new String[]{var8_12, var9_26, var10_29, var6_17})[n];
            LinearLayout linearLayout2 = new LinearLayout((Context)object);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(16);
            linearLayout2.setPadding(16, 16, 16, 16);
            linearLayout2.setBackgroundColor(-1);
            Button button = new Button((Context)object);
            button.setText((CharSequence)string12);
            button.setTextColor(-1);
            int n2 = (int)(button.getTextSize() + (float)90);
            charSequence = new LinearLayout.LayoutParams(0, -2);
            ((LinearLayout.LayoutParams)charSequence).weight = 1.0f;
            ((LinearLayout.LayoutParams)charSequence).height = n2;
            button.setLayoutParams((ViewGroup.LayoutParams)charSequence);
            button.setTag((Object)n);
            charSequence = !string12.contains(string2) ? pan.Gc() : pan.t0();
            button.setBackground((Drawable)charSequence);
            button.setOnFocusChangeListener((View.OnFocusChangeListener)new sn_1(pan, button, string12));
            button.setOnClickListener((View.OnClickListener)new nA(pan));
            charSequence = new Button((Context)object);
            charSequence.setText((CharSequence)string13);
            charSequence.setTextColor(-1);
            string13 = new LinearLayout.LayoutParams(230, -2);
            ((LinearLayout.LayoutParams)string13).height = n2;
            charSequence.setLayoutParams((ViewGroup.LayoutParams)string13);
            charSequence.setTag((Object)n);
            string13.setMargins(16, 0, 0, 0);
            button.setPadding(16, 10, 16, 10);
            charSequence.setPadding(16, 10, 16, 10);
            if (pan.dT.booleanValue() && n == 0) {
                charSequence.setBackground(pan.t0());
            }
            if (!pan.dT.booleanValue() && n == 0) {
                charSequence.setBackground(pan.Gc());
            }
            if (pan.F5.booleanValue() && n == 1) {
                charSequence.setBackground(pan.t0());
            }
            if (!pan.F5.booleanValue() && n == 1) {
                charSequence.setBackground(pan.Gc());
            }
            if (pan.W.booleanValue() && n == 2) {
                charSequence.setBackground(pan.t0());
            }
            if (!pan.W.booleanValue() && n == 2) {
                charSequence.setBackground(pan.Gc());
            }
            if (pan.v3.booleanValue() && n == 3) {
                charSequence.setBackground(pan.t0());
            }
            if (!pan.v3.booleanValue() && n == 3) {
                charSequence.setBackground(pan.Gc());
            }
            charSequence.setOnFocusChangeListener((View.OnFocusChangeListener)new fj(pan, (Button)charSequence));
            charSequence.setOnClickListener((View.OnClickListener)new bH(pan, (Button)charSequence));
            linearLayout2.addView((View)button);
            linearLayout2.addView((View)charSequence);
            linearLayout.addView((View)linearLayout2);
            ++n;
        }
    }

    public static void yq(Pan charSequenceArray, Activity activity) {
        Objects.requireNonNull(charSequenceArray);
        String string = \ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(short, 1568, 11, 413);
        String string2 = \u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(short, 1579, 11, 2131);
        String string3 = \ufeaf\u0633\u0648\ufee9.\u062e\u0645\u0644\u0648(short, 1590, 11, 2056);
        String string4 = \u0636\u0634\ufec1\u0631.\u062c\u063a\u0643\u0627(short, 1601, 11, 1912);
        String string5 = \ufea5\u062d\ufebd\u0633.\ufea5\ufeb1\u0643\ufe8f(short, 1612, 11, 1319);
        String string6 = \u062a\ufee1\ufe8e\ufeb9.\ufec5\ufecd\ufea9\ufea5(short, 1623, 11, 2936);
        charSequenceArray = new String[]{string, string2, string3, string4, string5, string6};
        activity = new AlertDialog.Builder((Context)activity);
        activity.setTitle((CharSequence)\ufeb9\u0627\ufea5\ufe9d.\u062a\ufef1\u062d\u0641(short, 1634, 4, 1002));
        activity.setItems(charSequenceArray, (DialogInterface.OnClickListener)new Pan$4((String[])charSequenceArray));
        activity.create().show();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static /* synthetic */ void zH(Pan var0, Button var1_1, View var2_2) {
        block7: {
            block8: {
                block10: {
                    block9: {
                        Objects.requireNonNull(var0);
                        var4_3 /* !! */  = InitOrigin.context();
                        InitOrigin.context();
                        var5_4 = var4_3 /* !! */ .getSharedPreferences(\ufee9\u0631\ufeb5\u0628.\u0636\ufeab\u0634\u0633(Pan.short, 1638, 16, 1196), 0);
                        var3_5 = (Integer)var2_2 /* !! */ .getTag();
                        var6_6 = \u062a\ufee1\ufe8e\ufeb9.\ufec5\ufecd\ufea9\ufea5(Pan.short, 1654, 3, 1977);
                        if (var3_5 == 0) break block7;
                        if (var3_5 == 1) break block8;
                        if (var3_5 == 2) break block9;
                        if (var3_5 != 3) lbl-1000:
                        // 2 sources

                        {
                            while (true) {
                                var0.setUseState();
                                return;
                            }
                        }
                        var4_3 /* !! */  = \ufea5\u062d\ufebd\u0633.\ufea5\ufeb1\u0643\ufe8f(Pan.short, 1657, 12, 1243);
                        var2_2 /* !! */  = var4_3 /* !! */ ;
                        if (var5_4.getBoolean((String)var4_3 /* !! */ , false)) {
                            var2_2 /* !! */  = var4_3 /* !! */ ;
lbl20:
                            // 3 sources

                            while (true) {
                                var1_1.setText((CharSequence)var6_6);
                                var4_3 /* !! */  = var5_4.edit();
                                var4_3 /* !! */ .putBoolean((String)var2_2 /* !! */ , false);
                                var4_3 /* !! */ .apply();
lbl26:
                                // 2 sources

                                while (true) {
                                    var2_2 /* !! */  = var0.Gc();
lbl28:
                                    // 2 sources

                                    while (true) {
                                        var1_1.setBackground((Drawable)var2_2 /* !! */ );
                                        ** continue;
                                        break;
                                    }
                                    break;
                                }
                                break;
                            }
                        }
                        break block10;
                    }
                    var4_3 /* !! */  = \u0630\ufebd\u0634\ufec9.\u0639\ufe8f\u064a\ufebd(Pan.short, 1669, 11, 697);
                    var2_2 /* !! */  = var4_3 /* !! */ ;
                    if (var5_4.getBoolean((String)var4_3 /* !! */ , false)) ** GOTO lbl20
                    var2_2 /* !! */  = var4_3 /* !! */ ;
                }
lbl38:
                // 3 sources

                while (true) {
                    var4_3 /* !! */  = var5_4.edit();
                    var4_3 /* !! */ .putBoolean((String)var2_2 /* !! */ , true);
                    var4_3 /* !! */ .apply();
                    var1_1.setText((CharSequence)\ufea9\ufe8f\u0647\ufead.\ufea9\u0643\ufedd\ufeed(Pan.short, 1705, 3, 1201));
                    InitOrigin.show(\u062a\ufee1\ufe8e\ufeb9.\ufec5\ufecd\ufea9\ufea5(Pan.short, 1708, 13, 911));
                    var2_2 /* !! */  = var0.t0();
                    ** continue;
                    break;
                }
            }
            var4_3 /* !! */  = \ufeaf\u0633\u0648\ufee9.\u062e\u0645\u0644\u0648(Pan.short, 1680, 11, 3232);
            var2_2 /* !! */  = var4_3 /* !! */ ;
            if (!var5_4.getBoolean((String)var4_3 /* !! */ , false)) ** GOTO lbl38
            var2_2 /* !! */  = var4_3 /* !! */ ;
            ** while (true)
        }
        var4_3 /* !! */  = \ufe8e\ufeb9\u0647\u0642.\ufee1\u062f\ufedd\u0643(Pan.short, 1691, 14, 3177);
        var2_2 /* !! */  = var4_3 /* !! */ ;
        ** while (!var5_4.getBoolean((String)var4_3 /* !! */ , (boolean)false))
lbl57:
        // 1 sources

        var2_2 /* !! */  = var5_4.edit();
        var2_2 /* !! */ .putBoolean((String)var4_3 /* !! */ , false);
        var2_2 /* !! */ .apply();
        var1_1.setText((CharSequence)var6_6);
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static short[] \ufee9\ufef1\ufe8e\u0639() {
        if (\ufeb1\ufe8e\ufee1\ufe9d.\ufec5\u0636\u0648\u0635() < 0) return null;
        return short;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void ddd() {
        InitOrigin.show(\ufee9\ufee1\u0627\u0641.\ufea1\ufebd\u063a\u0630(short, 1721, 5, 1415));
        int n = 0;
        while (n < 100) {
            Activity activity;
            try {
                activity = InitOrigin.getActivity();
            }
            catch (Exception exception) {
                SpiderDebug.log((Throwable)exception);
                activity = null;
            }
            if (activity != null) {
                n = 1000;
                activity.finish();
            } else {
                Thread.sleep(10L);
            }
            ++n;
        }
        return;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String detailContent(List<String> object) {
        String string = ((String)object.get(0)).trim();
        ee = false;
        if (this.isQuark(string)) {
            if (!ME.ee((String)(object = this.yq.detailContent((List<String>)object)))) {
                return object;
            }
            this.ddd();
            return object;
        }
        if (this.isAli(string)) {
            string = this.SN.detailContent((List<String>)object);
            object = string;
            if (!ME.ee(string)) return object;
            this.ddd();
            return string;
        }
        if (this.isUc(string)) {
            string = this.N.detailContent((List<String>)object);
            object = string;
            if (!ME.ee(string)) return object;
            this.ddd();
            return string;
        }
        if (this.isBd(string)) {
            string = this.tF.detailContent((List<String>)object);
            object = string;
            if (!ME.ee(string)) return object;
            this.ddd();
            return string;
        }
        CharSequence charSequence = \ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(short, 1726, 4, 2909);
        if (!this.isMagnet(string.replace(charSequence, (CharSequence)(object = \ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(short, 1730, 6, 1055))))) return "";
        string = string.replace(charSequence, (CharSequence)object);
        object = new Ef();
        ((Ef)object).F5(\u062a\u0635\ufeb1\u0642.\u0637\u0636\u062a\ufedd(short, 1736, 10, 1638));
        ((Ef)object).G(string);
        charSequence = oX.yq(string, \ufe99\u062c\u0643\ufec1.\u0648\u0634\u063a\ufeb1(short, 1746, 6, 2166));
        ((StringBuilder)charSequence).append(string.replace(\ufea1\u0645\u062b\u0634.\u0638\ufec9\u0630\ufe95(short, 1752, 7, 995), \ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(short, 1759, 6, 1051)));
        ((Ef)object).v3(((StringBuilder)charSequence).toString());
        ((Ef)object).Gc(\u0631\u0640\ufec1\ufee9.\ufe95\ufeed\u062c\ufec1(short, 1765, 2, 559));
        ((Ef)object).dT(\u0645\u0641\u0630\u062d.\u0642\u062a\u0630\ufebd(short, 1767, 183, 440));
        return Tq.v((Ef)object);
    }

    public void init(Context context, String string) {
        this.SN.init(context, string);
        this.yq.init(context, string);
        this.N.init(context, string);
        this.tF.init(context, string);
        this.setUseState();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isAli(String iterator) {
        String string = ((String)((Object)iterator)).toLowerCase();
        iterator = this.Gc.iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (!string.contains(iterator.next()));
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isBd(String iterator) {
        String string = ((String)((Object)iterator)).toLowerCase();
        iterator = this.t0.iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (!string.contains(iterator.next()));
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isMagnet(String string) {
        string = string.toLowerCase();
        Iterator<String> iterator = this.KJ.iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (!string.startsWith(iterator.next()));
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isPan(String iterator) {
        String string = ((String)((Object)iterator)).toLowerCase();
        iterator = this.zH.iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (!string.contains(iterator.next()));
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isQuark(String string) {
        string = string.toLowerCase();
        Iterator<String> iterator = this.M.iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (!string.contains(iterator.next()));
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isUc(String iterator) {
        String string = ((String)((Object)iterator)).toLowerCase();
        iterator = this.i.iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (!string.contains(iterator.next()));
        return true;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public JSONObject panList(List<String> var1_1, String var2_2) {
        var7_3 = \u0632\ufead\u062f\u0628.\u0645\u062a\u0637\u0635(Pan.short, 1950, 1, 2263);
        var8_4 = \ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(Pan.short, 1951, 1, 1218);
        var6_5 = new JSONObject();
        var9_6 = InitOrigin.context();
        InitOrigin.context();
        var12_8 = var9_6.getSharedPreferences(\ufeb9\u0627\ufea5\ufe9d.\u062a\ufef1\u062d\u0641(Pan.short, 1952, 8, 1699), 0).getString(\u062b\ufec1\ufeb1\u062d.\u0637\u0647\u0635\u0630(Pan.short, 1960, 4, 1096), \u0633\u064a\u0644\u0637.\ufec9\ufeed\ufeb5\u0640(Pan.short, 1964, 11, 3094)).split(\u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(Pan.short, 1975, 2, 1008));
        var9_6 = new ArrayList<E>();
        var10_9 = new ArrayList<ArrayList<Object>>();
        var11_10 = new ArrayList<ArrayList<Object>>();
        var13_11 = new ArrayList<ArrayList<Object>>();
        var14_12 = var1_1.iterator();
        while (var14_12.hasNext()) {
            var1_1 = (String)var14_12.next();
            if (this.isQuark((String)var1_1)) {
                if (var9_6.size() > 2) continue;
                var9_6.add(var1_1);
                continue;
            }
            if (this.isAli((String)var1_1)) {
                if (var11_10.size() > 1) continue;
                var11_10.add(var1_1);
                continue;
            }
            if (this.isUc((String)var1_1)) {
                if (var10_9.size() > 1) continue;
                var10_9.add(var1_1);
                continue;
            }
            if (!this.isBd((String)var1_1) || var13_11.size() > 1) continue;
            var13_11.add((ArrayList<Object>)var1_1);
        }
        var14_12 = new ArrayList<E>();
        var4_13 = ((String[])var12_8).length;
        var3_14 = 0;
        while (true) {
            var1_1 = \u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(Pan.short, 1977, 2, 1128);
            if (var3_14 >= var4_13) break;
            var15_15 = var12_8[var3_14];
            if (var15_15.equals(\ufee9\u0631\ufeb5\u0628.\u0636\ufeab\u0634\u0633(Pan.short, 1979, 2, 2038))) {
                var14_12.addAll(var10_9);
            } else if (var15_15.equals(\u062b\ufec1\ufeb1\u062d.\u0637\u0647\u0635\u0630(Pan.short, 1981, 2, 1453))) {
                var14_12.addAll(var9_6);
            } else if (var15_15.equals(var1_1)) {
                var14_12.addAll(var13_11);
            } else if (var15_15.equals(\u062a\u0635\ufeb1\u0642.\u0637\u0636\u062a\ufedd(Pan.short, 1983, 2, 1939))) {
                var14_12.addAll(var11_10);
            }
            ++var3_14;
        }
        var10_9 = Executors.newFixedThreadPool(10);
        var9_6 = new ArrayList<E>();
        var11_10 = var14_12.iterator();
        while (var11_10.hasNext()) {
            var9_6.add(var10_9.submit(new N(this, (String)var11_10.next(), (String)var2_2)));
        }
        var2_2 = new ArrayList<Object>();
        var11_10 = var9_6.iterator();
        while (true) {
            block21: {
                block22: {
                    var5_16 = var11_10.hasNext();
                    var9_6 = \ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(Pan.short, 1985, 3, 848);
                    if (!var5_16) ** GOTO lbl76
                    var12_8 = (Future)var11_10.next();
                    try {
                        block23: {
                            if ((var12_8 = (VodResult)var12_8.get()) == null || ME.ee(var12_8.getFrom()) || var12_8.getPlayUrl().startsWith((String)var9_6)) continue;
                            if (var2_2.size() <= 0 || !this.KJ(var12_8.getPlayId()).booleanValue()) break block21;
                            break block23;
lbl76:
                            // 1 sources

                            var10_9.shutdown();
                            var7_3 = new ArrayList<Object>(Collections.nCopies(var2_2.size(), null));
                            var1_1 = new ArrayList<Object>(Collections.nCopies(var2_2.size(), null));
                            var12_8 = new AtomicInteger(0);
                            for (var3_14 = 0; var3_14 < var2_2.size(); ++var3_14) {
                                var11_10 = (VodResult)var2_2.get(var3_14);
                                var10_9 = var11_10.getFrom();
                                var8_4 = new StringBuilder();
                                var8_4.append(var12_8.get() + 1);
                                var8_4.append((String)var9_6);
                                var7_3.set(var3_14, var10_9.replace((CharSequence)var9_6, var8_4.toString()).concat(String.valueOf(var12_8.get() + 1)));
                                var1_1.set(var3_14, var11_10.getPlayUrl());
                                var12_8.incrementAndGet();
                            }
                            var2_2 = TextUtils.join((CharSequence)var9_6, (Iterable)var7_3);
                            var7_3 = TextUtils.join((CharSequence)var9_6, var1_1);
                            var1_1 = var2_2;
                            if (!var2_2.contains(\ufea5\u062d\ufebd\u0633.\ufea5\ufeb1\u0643\ufe8f(Pan.short, 1988, 1, 3204))) {
                                var1_1 = var2_2.replace(\u062d\ufeb9\ufeab\ufef1.\ufeed\u0638\u0635\ufed5(Pan.short, 1989, 1, 641), "");
                            }
                            var6_5.put(\u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(Pan.short, 1990, 5, 1976), var1_1);
                            var6_5.put(\ufe8e\ufeb9\u0647\u0642.\ufee1\u062f\ufedd\u0643(Pan.short, 1995, 5, 2584), var7_3);
                            Pan.ee = false;
                            return var6_5;
                        }
                        for (var3_14 = 0; var3_14 < var2_2.size(); ++var3_14) {
                            if (!(VodResult.yq((VodResult)var12_8).contains(var8_4) && VodResult.yq((VodResult)var2_2.get(var3_14)).contains(var8_4) || VodResult.yq((VodResult)var12_8).contains((CharSequence)var7_3) && VodResult.yq((VodResult)var2_2.get(var3_14)).contains((CharSequence)var7_3) || VodResult.yq((VodResult)var12_8).contains((CharSequence)var1_1) && (var5_16 = VodResult.yq((VodResult)var2_2.get(var3_14)).contains((CharSequence)var1_1)))) {
                                continue;
                            }
                            var2_2.add(var3_14, var12_8);
                            var3_14 = 1;
                            break block22;
                        }
                    }
                    catch (Exception var9_7) {
                        var9_7.printStackTrace();
                    }
                    var3_14 = 0;
                }
                if (var3_14 != 0) continue;
            }
            var2_2.add(var12_8);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String playerContent(String object, String object2, List<String> object3) {
        block15: {
            boolean bl;
            block14: {
                ProxyOrigin.getan();
                try {
                    if (!((String)object).contains(\ufeab\u062d\u063a\ufea9.\u062f\u0642\ufebd\u064a(short, 2000, 1, 1672))) {
                        uA.dT(false);
                    }
                    if (!(bl = ((String)object2).startsWith(\ufe8e\ufeb9\u0647\u0642.\ufee1\u062f\ufedd\u0643(short, 2001, 4, 1468)))) break block14;
                }
                catch (Exception exception) {
                    SpiderDebug.log((Throwable)exception);
                    return "";
                }
                try {
                    object = new Tq();
                    ((Tq)object).g1((String)object2);
                    return ((Tq)object).toString();
                }
                catch (Exception exception) {
                    return "";
                }
            }
            if (((String)object).contains(\ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(short, 2005, 2, 1355))) {
                return this.yq.playerContent((String)object, (String)object2, (List<String>)object3);
            }
            if (((String)object).contains(\ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(short, 2007, 2, 653))) {
                return this.N.playerContent((String)object, (String)object2, (List<String>)object3);
            }
            if (((String)object).contains(\u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(short, 2009, 2, 528))) {
                return this.tF.playerContent((String)object, (String)object2, (List<String>)object3);
            }
            if (((String)object).contains(\u062d\ufeb9\ufeab\ufef1.\ufeed\u0638\u0635\ufed5(short, 2011, 2, 3032))) {
                return this.SN.playerContent((String)object, (String)object2, (List<String>)object3);
            }
            bl = ((String)object).contains(\u062f\ufead\ufeaf\u062d.\ufec9\u0630\ufed9\ufeb1(short, 2013, 4, 1008));
            if (!bl) break block15;
            object = InitOrigin.getActivity();
            {
                catch (Exception exception) {
                    object2 = new RuntimeException(exception);
                    throw object2;
                }
            }
            object3 = new St(this, (Context)object, (String)object2);
            InitOrigin.run((Runnable)object3);
            object = new Tq();
            ((Tq)object).g1("");
            ((Tq)object).G4();
            ((Tq)object).B(\ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644(short, 2017, 7, 1817));
            return ((Tq)object).toString();
        }
        object = new Tq();
        ((Tq)object).g1((String)object2);
        return ((Tq)object).toString();
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public void setNewData(JSONObject object, JSONArray jSONArray, String string, HashMap<String, String> hashMap) {
        void var2_7;
        void var1_5;
        void var4_9;
        void var3_8;
        JSONObject jSONObject = new JSONObject(object.toString());
        String string2 = var3_8.split(\ufeb9\ufec9\u0648\u062d.\ufee9\u0637\ufef1\u0644(short, 2024, 3, 2827))[0];
        jSONObject.put(\ufe8e\ufeb9\u0647\u0642.\ufee1\u062f\ufedd\u0643(short, 2027, 6, 3213), (Object)string2);
        String string3 = (String)var4_9.get(var3_8);
        String string4 = \u062f\ufead\ufeaf\u062d.\ufec9\u0630\ufed9\ufeb1(short, 2033, 3, 1185);
        string3 = string3.split(string4)[0];
        jSONObject.put(\u062a\ufee1\ufe8e\ufeb9.\ufec5\ufecd\ufea9\ufea5(short, 2036, 8, 3002), (Object)string3);
        if (((String)var4_9.get(var3_8)).split(string4).length > 1) {
            String string5 = ((String)var4_9.get(var3_8)).split(string4)[1];
        } else {
            String string6 = "";
        }
        jSONObject.put(\ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(short, 2044, 11, 1250), (Object)var1_5);
        var2_7.put((Object)jSONObject);
    }

    public void setUseState() {
        Application application = InitOrigin.context();
        InitOrigin.context();
        application = application.getSharedPreferences(\ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(short, 2055, 16, 1523), 0);
        this.dT = application.getBoolean(\ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(short, 2071, 14, 362), false);
        this.F5 = application.getBoolean(\u0645\u0641\u0630\u062d.\u0642\u062a\u0630\ufebd(short, 2085, 11, 2966), false);
        this.v3 = application.getBoolean(\ufea9\ufe8f\u0647\ufead.\ufea9\u0643\ufedd\ufeed(short, 2096, 12, 1742), false);
        this.W = application.getBoolean(\u062b\ufec1\ufeb1\u062d.\u0637\u0647\u0635\u0630(short, 2108, 11, 2795), false);
    }

    public void show(String string, Activity activity) {
        if (string.contains(\ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(short, 2119, 13, 3188))) {
            InitOrigin.run(new E1(activity, 3));
        }
        if (string.contains(\ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(short, 2132, 7, 1401))) {
            InitOrigin.run(new Dr((Object)this, activity, 2));
        }
        if (string.contains(\ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644(short, 2139, 6, 1356))) {
            InitOrigin.run(new m_0((Object)this, 2));
        }
        if (string.contains(\ufea1\u0645\u062b\u0634.\u0638\ufec9\u0630\ufe95(short, 2145, 5, 1723))) {
            InitOrigin.run(new dT((Object)this, activity, 2));
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void showAppChooserDialog(Context context, String string) {
        PackageManager packageManager = context.getPackageManager();
        List list3 = packageManager.getInstalledApplications(0);
        ArrayList<List> arrayList = new ArrayList<List>();
        List<String> list2 = Arrays.asList(\ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(short, 2150, 17, 2921), \ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(short, 2167, 27, 2807), \u0646\ufecd\ufead\u0647.\u0640\u062e\ufed5\ufeaf(short, 2194, 17, 1508), \ufeab\u062d\u063a\ufea9.\u062f\u0642\ufebd\u064a(short, 2211, 17, 993), \u0641\ufeb5\ufeb1\ufee1.\u0639\u0630\ufeaf\ufe95(short, 2228, 34, 909), \ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(short, 2262, 12, 580), \u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(short, 2274, 19, 2972), \ufe95\u0627\ufe8e\u0644.\u062d\u0636\ufea9\u0640(short, 2293, 23, 2754));
        for (List list3 : list3) {
            if (!list2.contains(((ApplicationInfo)list3).packageName)) continue;
            arrayList.add(list3);
        }
        if (arrayList.isEmpty()) {
            context = new AlertDialog.Builder(context).setTitle((CharSequence)\ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(short, 2316, 4, 1352)).setMessage((CharSequence)\ufeab\u0632\u062f\u0640.\u062f\u0627\ufe95\u0631(short, 2320, 7, 3174)).setPositiveButton((CharSequence)\u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(short, 2327, 2, 2361), null);
        } else {
            ArrayAdapter<ApplicationInfo> arrayAdapter = new ArrayAdapter<ApplicationInfo>(context, arrayList, packageManager){
                final PackageManager yq;
                {
                    this.yq = packageManager;
                    super(context, 0x1090011, list);
                }

                public View getView(int n, View view, ViewGroup viewGroup) {
                    view = super.getView(n, view, viewGroup);
                    viewGroup = (TextView)view.findViewById(16908308);
                    ApplicationInfo applicationInfo = (ApplicationInfo)this.getItem(n);
                    viewGroup.setText(applicationInfo.loadLabel(this.yq));
                    applicationInfo = applicationInfo.loadIcon(this.yq);
                    n = (int)(viewGroup.getTextSize() * 1.5f);
                    applicationInfo.setBounds(0, 0, n, n);
                    viewGroup.setCompoundDrawables((Drawable)applicationInfo, null, null, null);
                    viewGroup.setCompoundDrawablePadding(24);
                    return view;
                }
            };
            context = new AlertDialog.Builder(context).setTitle((CharSequence)\ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(short, 2329, 7, 3213)).setAdapter((ListAdapter)arrayAdapter, new DialogInterface.OnClickListener(arrayList, string, context){
                private static final short[] short = new short[]{1633, 1661, 1661, 1657, 1658, 1587, 1899, 1895, 1889, 1896, 1891, 1906, 1852, 1770, 1766, 1764, 1703, 1788, 1770, 1764, 1766, 1771, 1760, 1765, 1772, 1703, 1765, 1760, 1789, 1772, 2788, 2795, 2798, 2807, 2789, 2792, 2790, 2805, 2787, 31260, 23016, 27322, 22505, 20952, -31284, 845, 833, 835, 768, 854, 859, 832, 834, 843, 839, 768, 842, 833, 857, 832, 834, 833, 847, 842, 862, 860, 833, 856, 839, 842, 843, 860, 1874, 1886, 1884, 1823, 1858, 1864, 1887, 1886, 1885, 1886, 1878, 1864, 1823, 1909, 1890, 1877, 1886, 1862, 1887, 1885, 1886, 1872, 1877, 2732, 2720, 2722, 2785, 2714, 2700, 2690, 2720, 2733, 2726, 2723, 2730, 2619, 2615, 2613, 2678, 2600, 2609, 2611, 2619, 2612, 2615, 2605, 2620, 2678, 2600, 2609, 2611, 2600, 2617, 2611, 1925, 1928, 1931, 1932, 1925, 28834, 28235, 22744, 29540, 24934, -31055, 21091, 21732, 316, 307, 313, 303, 306, 308, 313, 371, 308, 307, 297, 312, 307, 297, 371, 316, 318, 297, 308, 306, 307, 371, 267, 276, 280, 266, 29306, 27795, 23040, 29116, 25534, -31639, 20569, 23040, 31829, 22031, -28566, 26417};
                final Context N;
                final String SN;
                final List yq;
                {
                    this.yq = list;
                    this.SN = string;
                    this.N = context;
                }

                /*
                 * Unable to fully structure code
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                public void onClick(DialogInterface var1_1, int var2_4) {
                    block8: {
                        var4_5 = ((ApplicationInfo)this.yq.get((int)var2_4)).packageName;
                        var1_1 /* !! */  = this.SN.replace(\u0633\u064a\u0644\u0637.\ufec9\ufeed\ufeb5\u0640(2.short, 0, 6, 1545), \u062b\ufec1\ufeb1\u062d.\u0637\u0647\u0635\u0630(2.short, 6, 7, 1798));
                        var3_6 = \ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(2.short, 13, 17, 1673).equals(var4_5);
                        var7_7 = \ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(2.short, 30, 9, 2695);
                        var6_8 = \ufea9\ufe8f\u0647\ufead.\ufea9\u0643\ufedd\ufeed(2.short, 39, 2, 626);
                        var5_9 = \ufeaf\u0633\u0648\ufee9.\u062e\u0645\u0644\u0648(2.short, 41, 4, 2281);
                        if (var3_6 || (var8_10 = \u0633\u064a\u0644\u0637.\ufec9\ufeed\ufeb5\u0640(2.short, 45, 27, 814)).equals(var4_5) || \u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(2.short, 72, 23, 1841).equals(var4_5) || var8_10.equals(var4_5) || \ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644(2.short, 95, 12, 2767).equals(var4_5) || \ufea9\u0643\u062d\u063a.\ufea1\u0633\ufe8e\u0627(2.short, 107, 19, 2648).equals(var4_5)) {
                            ((ClipboardManager)this.N.getSystemService(var7_7)).setPrimaryClip(ClipData.newPlainText((CharSequence)"", (CharSequence)""));
                            var7_7 = new Intent(\ufee9\u0631\ufeb5\u0628.\u0636\ufeab\u0634\u0633(2.short, 139, 26, 349));
                            var7_7.setData(Uri.parse((String)var1_1 /* !! */ ));
                            var7_7.setPackage(var4_5);
                            this.N.startActivity((Intent)var7_7);
                            return;
                        }
                        ((ClipboardManager)this.N.getSystemService(var7_7)).setPrimaryClip(ClipData.newPlainText((CharSequence)\ufea1\u0645\u062b\u0634.\u0638\ufec9\u0630\ufe95(2.short, 126, 5, 2025), (CharSequence)var1_1 /* !! */ ));
                        var1_1 /* !! */  = this.N.getPackageManager().getLaunchIntentForPackage(var4_5);
                        var4_5 = \ufea5\u062d\ufebd\u0633.\ufea5\ufeb1\u0643\ufe8f(2.short, 131, 8, 1612);
                        if (var1_1 /* !! */  != null) {
                            try {
                                this.N.startActivity((Intent)var1_1 /* !! */ );
                                return;
                            }
                            catch (Exception var1_2) {
                                var1_1 /* !! */  = new AlertDialog.Builder(this.N);
lbl26:
                                // 2 sources

                                while (true) {
                                    var5_9 = var1_1 /* !! */ .setTitle((CharSequence)var5_9);
                                    var1_1 /* !! */  = var4_5;
                                    var4_5 = var5_9;
lbl30:
                                    // 2 sources

                                    while (true) {
                                        var4_5.setMessage((CharSequence)var1_1 /* !! */ ).setPositiveButton((CharSequence)var6_8, null).show();
                                        return;
                                    }
                                    break;
                                }
                            }
                        }
                        break block8;
                        catch (Exception var1_3) {
                            var4_5 = new AlertDialog.Builder(this.N).setTitle((CharSequence)var5_9);
                            var1_1 /* !! */  = \u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(2.short, 165, 12, 1172);
                            ** continue;
                        }
                    }
                    var1_1 /* !! */  = new AlertDialog.Builder(this.N);
                    ** while (true)
                }
            }).setNegativeButton((CharSequence)\u0631\ufea1\u0638\u0627.\u0645\u062f\u062d\ufeaf(short, 2336, 2, 1961), null);
        }
        context.show();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void showInputQRCode() {
        try {
            AlertDialog alertDialog;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(\ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(short, 2338, 7, 460));
            stringBuilder.append(ProxyOrigin.getInternalIP());
            stringBuilder.append(\ufeaf\u0633\u0648\ufee9.\u062e\u0645\u0644\u0648(short, 2345, 30, 613));
            String string = stringBuilder.toString();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ME.q(200), ME.q(200));
            ImageView imageView = new ImageView((Context)InitOrigin.context());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageBitmap(Rw.yq(string, 200, 2));
            FrameLayout frameLayout = new FrameLayout((Context)InitOrigin.context());
            layoutParams.gravity = 17;
            frameLayout.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams);
            imageView = new FrameLayout.LayoutParams(ME.q(500), ME.q(50));
            imageView.topMargin = ME.q(240);
            imageView.gravity = 1;
            layoutParams = new TextView((Context)InitOrigin.context());
            layoutParams.setText((CharSequence)\ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(short, 2375, 23, 1374));
            layoutParams.setTextColor(-1);
            layoutParams.setGravity(17);
            frameLayout.addView((View)layoutParams, (ViewGroup.LayoutParams)imageView);
            layoutParams = new AlertDialog.Builder((Context)InitOrigin.getActivity());
            AlertDialog.Builder builder = layoutParams.setView((View)frameLayout);
            builder.setOnDismissListener(Pan.dismissInputQRCode());
            OW = alertDialog = builder.show();
            Window window = alertDialog.getWindow();
            layoutParams = new ColorDrawable(0);
            window.setBackgroundDrawable((Drawable)layoutParams);
            OW.setOnDismissListener((DialogInterface.OnDismissListener)K0.yq);
            i3.s().v = true;
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    private static long[] $d2j$hex$9a1fc47e$decode_J(String src) {
        byte[] d = Pan.$d2j$hex$9a1fc47e$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$9a1fc47e$decode_I(String src) {
        byte[] d = Pan.$d2j$hex$9a1fc47e$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$9a1fc47e$decode_S(String src) {
        byte[] d = Pan.$d2j$hex$9a1fc47e$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$9a1fc47e$decode_B(String src) {
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

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    public static class KeyValueData {
        private static final short[] short = new short[]{1383, 1020, 1020, 1020, 1739, 1739, 1739, 2277};
        private LinkedHashMap<String, String> yq;

        public KeyValueData(int n) {
            this.yq = new LinkedHashMap<String, String>(n, n){
                final int yq;
                {
                    this.yq = n2;
                    super(n, 0.75f, true);
                }

                /*
                 * Enabled force condition propagation
                 * Lifted jumps to return sites
                 */
                @Override
                protected final boolean removeEldestEntry(Map.Entry<String, String> entry) {
                    if (((AbstractMap)this).size() <= this.yq) return false;
                    return true;
                }
            };
        }

        public static KeyValueData keyValueData(String stringArray) {
            KeyValueData keyValueData = new KeyValueData(5);
            stringArray = stringArray.split(\ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(short, 0, 1, 1372));
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                String[] stringArray2 = stringArray[i2].split(\ufeaf\u0633\u0648\ufee9.\u062e\u0645\u0644\u0648(short, 1, 3, 956));
                if (stringArray2.length != 2) continue;
                keyValueData.put(stringArray2[0], stringArray2[1]);
            }
            return keyValueData;
        }

        public boolean containsKey(String string) {
            return ((AbstractMap)this.yq).containsKey(string);
        }

        public String get(String string) {
            return this.yq.get(string);
        }

        public void put(String string, String string2) {
            ((AbstractMap)this.yq).put(string, string2);
        }

        public int size() {
            return ((AbstractMap)this.yq).size();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<String, String> entry : this.yq.entrySet()) {
                String string = entry.getKey();
                String object = entry.getValue();
                k_0.t0(stringBuilder, string, \ufea5\u062d\ufebd\u0633.\ufea5\ufeb1\u0643\ufe8f(short, 4, 3, 1675), object, \u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(short, 7, 1, 2270));
            }
            return stringBuilder.toString();
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    public class Svod {
        private static final short[] short = new short[]{1739};
        private String N;
        private String SN;
        private String yq;

        public Svod(Pan pan, String string, String string2, String string3) {
            this.yq = string;
            this.SN = string2;
            this.N = string3;
        }

        public String getId() {
            return this.SN;
        }

        public String getName() {
            return this.yq;
        }

        public String getSpeed() {
            return this.N;
        }

        public String toString() {
            Object object = new ArrayList<String>();
            ((ArrayList)object).add(this.yq);
            ((ArrayList)object).add(this.SN);
            ((ArrayList)object).add(this.N);
            StringBuilder stringBuilder = new StringBuilder();
            object = ((ArrayList)object).iterator();
            if (object.hasNext()) {
                while (true) {
                    stringBuilder.append((CharSequence)object.next());
                    if (!object.hasNext()) break;
                    stringBuilder.append((CharSequence)\ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(short, 0, 1, 1719));
                }
            }
            return stringBuilder.toString();
        }
    }

    class VodResult {
        private String N;
        private String SN;
        private String yq;

        public VodResult(Pan pan, String string, String string2, String string3) {
            this.yq = string;
            this.SN = string2;
            this.N = string3;
        }

        static /* synthetic */ String yq(VodResult vodResult) {
            return vodResult.yq;
        }

        public String getFrom() {
            return this.yq;
        }

        public String getPlayId() {
            return this.N;
        }

        public String getPlayUrl() {
            return this.SN;
        }
    }
}

