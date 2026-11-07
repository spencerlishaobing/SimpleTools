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
import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u062b\u064a\ufecd\u0642;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\u0638\ufead\u062e\ufee1;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
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
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.merge.Jr;
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
import com.github.catvod.spider.merge.\ufed9\ufe9d\ufeed\ufeb5;
import com.github.catvod.spider.merge.\ufee1\u0639\u063a\u0645;
import com.github.catvod.spider.merge.\ufee9\ufee1\u0627\u0641;
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
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class Appgz
extends Spider {
    private static String i;
    private static final short[] short;
    private static final Pattern tF;
    private static String zH;
    private String N;
    private String SN;
    private String yq = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();

    static {
        String string;
        short = Appgz.$d2j$hex$35517ff9$decode_S("88058d05e305fe05ea05b205fe05a9059205fe058905ee05fc05f8058e05f8056d0369036903630344034703690362036103640361036e03620347034b03510348034b034903670319035703100362036103710365036603610361037303630361034d0361035703470347036a034303610347036503610361034f03670361034503160348036b03520377036c03490311035a0371034d034a037403740311034f035a0342036503140371034403660345036a0367036e0358035503420358034c03440316036703520366036703580349034d03580346036d0353036d0362031603620350036a0348035003430374034f0355036103510359035703610366035003500349036b03450354037503620362034203780357037903530379037503110357036e035203160314031803780376034d0370034d0363036d03630359031403520379031803560344034c03490366034e0342036d0375034a031003180316036403750316037a030b030f034f037803620344037703750313030f03420311036703100364036e03130365031903570375036c0372037303570343036b037a037403130357034a030f0343036303690311035603530363034d03130347034a03120372031503730351034b03610319037903100363036103570365036103610371036b036203470361036a0368030b03140363035803760310030f035a036203760343036c0349036203630368035603730361036e034d0310034c03170368034503540359034203740348030f034a031203500310037903110353037403780352034f03140361036c0357036103410363037403750345035103440362034a03770349036c0373034f0319034c036e0357036403680366035903510318035a037803190310030b0347036e035803410317034303150365035103430377037603190366034d034c03760378035203180376034803460362035a0343037a034f0311034e03780345036e03440378036603740317035403710312035903410348030f034f03440354034403430358030b03560372036d03730367036a034403110354030f0315034b0315034203640344031903570361035603790344036903640342034c036d03610347030b03570349036b036b037a0315036b034303440361034b036503610311034303630341034b0365036e0314036e03450358034b0366031503540368037003720352037203160378036f0379030f037803680346034b03510378035803650348036d0351034d036e034203620319037503130314035303410374036a034e036c03770369036803630318036903780359035303160371034d035a035a0313031003740354035a0363034a0355036f0351036b037203720359030b0366036d036d0314037403440357036a03620361036a0371037a03660370034a035303670363030b03720351034303670315037503560376036d0349036d03700348034e03570345030f0342037803650345034803730348036b031803160359036a036b030f0347030f03750349036b0352036f0318031703480313034103650355031503470343036a0351036203590347037403510313036203620362034f03680312034d0344031303500352030f0377030b03480375036d0377036203530363037103710363034803460348037403690352034403640349034e036b03490316034c03720358035203440362034e034e0310036f0348034a034703120343035703550351036b0315035a035a037503190350030f036e030b03730319035803170363034b0318035703750369031503130364036b034d0318034a0375036a0365031803770361036703170377036c034a030f034f0363036f037703650348030b034903430316036e03690357037403440361034b03650361034a031003780318034e03480358031603610378035303470363037903720351034c0311034b034c0342035103540376034d036c0318030b03190315036b037a036b03170370034e036c03770367030f03690346034a0371037503590313035003700367034f03730341037a0317034603440351035503670318034203510318034f035903460315030b0344035a034a0365030f034f037403780343036203590373030b0316037803720371036a03610370030f031503430349035903110342036c0313036e03480375034803530341036f0376035903150315036d03680378034e0370034a0344034303740378031003660341036c0349030b035903420378037a03690346036903710312037003140352034203110319034d03760351031103460345036d0342036303780348035a030b036c0311035203670318034f034103540315034c0379036b0346035003450318034b03180313037a0361031d031d0378047c04720453047804740405047204760466044404720466047c0457040604710464047004770474046404600474047404010472047b0474047104760477045c0464047e0477045204640471046004780400041e041a044c040d0446046504460462045e04510404041a04670464046604030401046d04070400040c047004600442044d0473046d047304700400047d0459047404030400047804440447044d045b046504460405047f0444045a04660467045a045f04660471044c04000464045d044204430467047a04590454047104030461044204670464047d047e0478046c0407047a0474046f04030466045b046404500460047f04460476045d046104700473047c0467040c04440460045e0442044704460406041a0478046304600478044d045f044604430403047f04660403047a0450041a045f044004560459044c047f047204610452046304580471045d047704000400047004540453046d04460471040504660464046c0463045f041a0464046d046d0446044d04670403045004420467040004700407045e047904000407044c0474047404710401044c0464047c0471047404640474047704dd0afb0aed0afa0aa50ac90aef0aed0ae60afc0a540a500a530a4f0a4f0a4b0a140a080a150a0a0a090a150a0b0a40097309640965097f09790978093b063f0639063a06390639063b067e094f094d0945094f0949094b0960094f0943094b09550659065b06180644060506570655060e060f060406070603060506180647060706530652060406010607060f060f0657061806410650060f06050606065006550600065406500604060606040600060606020606060706a8039b038c03af05b205ac05b205a805b205ac05660977096e092a09710962097509fb07f707fc07fd07f004ed0487048704870486042307140717071407030714070307e70afb0afb0aff0afc0ab50aa00aa00aee0aff0ae60aa10ae80ae50ae50af80ae80aff0abc0ae10aa10aec0ae00ae20ab803a403a403a003a303ea03ff03ff03b103a003b903fe03b703ba03ba03a703b703a003e303be03fe03b303bf03bd03ff039103a003a003ff038203b503a303bf03a503a203b303b503ff038603a503a203bc039403b503a403b103b903bc03ff03a303b803bf03a7039f03be03b503fc01040705070807090733070d071c071c070b07160733070d07020708071e07030705070807330705070807130a120a1f0a1e0a240a1a0a0b0a0b0a1c0a010a240a0f0a140a100a1e0a150a250924092909280912092c093d093d092a0937091209230928093a0912092609280934090b070a07070706073c07020713071307040719073c071607170707070a0707072f052e0523052205180526053705370520053d051805320534052205350518052e0523054b074a07470746077c07420753075307440759077c074707460755074a07400746077c074a074707b6050a084d08490856080a084c084b08410840085d080b084808160850081d0831082e08210c2f0c330cae03af03bd03d603c3038d0789079f073507310727075b073707360737075b0724073f0737072707430724071507100710071d071a071307b008ab08af08a108aa089b08ad08a008f908e808b008ab08af08a108aa08f908d90285029d029a029b029002aa0281028c0285029002c802c402d9028702900284028002900286028102aa029e0290028c02c802f408b908a808a8088708b108bc08e508e908f408ac08b108b508bd08e5088c05cb05c505d905d3059d05e406e806b406b806aa06b806aa06b806aa06aa06ac06a806a706a506a506a506bb06a306ba06a306aa06b906bf06be06be06be06f106b206fa069706ef06bd06ef06fc06ac06bc06f40bef0beb0be50bee0b120909090d090309080939090f0902095601ea03f203f503f403ff03c503ee03e303ea03ff031903040300030803f60c300bd602040a050a0e0a1b0a070a1e0a180a460a030a0f0a5a0a520a5b0a5b0a98038003870386038d03b703850387038c038d038403e401ea01f601fc01ad08ba08ae08aa08ba08ac08ab088008b408ba08a60865047f0471047804770462046304640473047c066d066d06420674067906030506053d0514050705100511050b050d050c05c804cb04c304f804cc04c204de04f801f301e101c901fd01f301ef01b30cab0cac0cad0ca60c9c0cb70cba0cb30ca60c50045c04570456043502290229022d022e026702720272023c022d02340273023a02370237022a023a022d026e02330273023e023202300272021c022d022d0272021c0228022902350238023302290234023e023c0229023402320233027202190238022b0234023e02380272022e0234023a02330208022d02690c750c750c710c720c3b0c2e0c2e0c600c710c680c2f0c660c6b0c6b0c760c660c710c320c6f0c2f0c620c6e0c6c0c2e0c400c710c710c2e0c400c740c750c690c640c6f0c750c680c620c600c750c680c6e0c6f0c2e0c450c640c770c680c620c640c2e0c720c680c660c6f0c480c6f0c240c3f0c3b0c350c3e0cc802cb02ca02cd02cc02cf02ce02c102c002c302c202c502c402c702c602d902d802db02da02dd02dc02df02de02d102d002d302e802eb02ea02ed02ec02ef02ee02e102e002e302e202e502e402e702e602f902f802fb02fa02fd02fc02ff02fe02f102f002f302b902b802bb02ba02bd02bc02bf02be02b102b002fd0ad80ad40ad60ae60afd0af40a840a9d05cf059f059a05ca059805cd059805c905cf0598059d059b059d059c05c105c005cb05cb05ca059b058f059c059f059c059d059a05cb05cd059f059c059a059d059c05c805c105c105980598059805c005c805cf05c805df02de02cc02a702b2025d08e8012d022c02210220021a0224023502350222023f021a0224022b02210237022a022c0221021a022c022102f102fe02f402e202ff02f902f402cf02f902f402020b9306960683069606600a6e0a720a780acd09da09cc09cf09d009d109cc09da09e009d409da09c609190932013c0120019d068206e00bf10be20be30bf50b2e0529053705380826083208a8954d756497bc8e6d50120c130c1e0c1f0c250c1b0c0a0c0a0c1d0c000c250c140c1f0c0d0c250c110c1f0c030c910890089d089c08a6089808890889089e088308a6088d08960892089c089708fc02fd02f002f102cb02f502e402e402f302ee02cb02e102e702f102e602cb02fd02f002c10cc00ccd0ccc0cf60cc80cd90cd90cce0cd30cf60ccd0ccc0cdf0cc00cca0ccc0cf60cc00ccd0c6f03640364036f036b0369036a035407fd08ec04f704fe048e04bd08bc08ae08c508d0082a012a012a012a012a012a012a012a012a012a012a012a012a012a012a012a012a012a012a012a012a012a012a012a01bf0abe0ab30ab20a880ab60aa70aa70ab00aad0a880aa20aa30ab30abe0ab30a4b05db0cc20cc90cf20cdd0cc40cce0ce905f005fb05c005f605fb05930b960b8c0b8b0bbd03a403af039403a503aa03a603ae03450759075d074e078c049f0488048c04930a8e0a830a830af5074202410274064b06fc09ff09f206a106a106ca01d802de02c902080719071f071d072b07110702071d073804240439043f0441087a084c08410827023602300232021e0703070e0700031c031c0318031b0352034703470309031803010346030f03020302031f030f0318035b03060346030b030703050347032903180318034703210306030c030d031003240301031b031c034703010306030c030d031003240301031b031c0303091a0911092a09070910091809140907091e090609e90bf00bfb0bc00bec0bfc0bed0bf00bfa0bc903cc03c803cc03d10374056f05740561056c05700170017001be05bb05a105a605a408bd08b6088d08b308b108a608bd08a0088d0994099f09a4099a0989099e099a09b504ac04a7049c04ba04a604a204b10487029e029502ae02810298029202940a8d0a860abd0a8c0a830a8f0a870adf01ce01dd01ce01c2013d0421042c04340403091a0911092a0911091c0907091009160901091a090709be02a702ac029702a102ac02e40aff0afb0af50afe0acf0af90af40a900592059f05940591059805a205890594059005980567067c06780676067d06ff0ae30ae30ae70ae40aad0ab80ab80af60ae70afe0ab90af00afd0afd0ae00af00ae70aa40af90ab90af40af80afa0ab80ad60ae70ae70ab80ade0af90af30af20aef0ac70afb0af60aee0ab80ae70afb0af60aee0ade0af90af10af80a290230023b021602310239023002ae02a402a402e108f808f308c808f408fb08f608e408e4080062cf7277086e0865085e08730864086c08600873086a0872087c0265026e0255027e0263027e0266026f02e20bfb0bf00bcb0bf70bfb0bfa0be00bf10bfa0be00b5154328e2307360721072e079e0b9d0b9a0b840bb70b8b0b840b870b9d0b8c0bb70b810b8c0b410a2f0936093d0906093d09060930093d09390425042504210422046b047e047e043004210438047f0436043b043b0426043604210462043f047f0432043e043c047e041004210421047e040304340422043e0424042304320434047e040704240423043d047e04220439043e042604dc03c103dc03c403cd03a709a609ae09a609940491049304540c580c500cf209f209a209a509ac0976064b0656064e064706180602064d074c0744074c070c075c072c071d070e071d07110746075c07e84944795663c562a80b0b09020c1b0c100c2b0c040c180c150c0d0c2b0c120c060c1b0c190c520a4b0a400a7b0a540a480a450a5d0a7b0a510a560a480a5906000617735359000618060006130600060e0600061773e48f4554000618060006100600060e0600068a540969000618060006160600060e060006de785884000618060006110600065f06eb0be60bef0bfa0bc00bf10bfe0bf20bfa0b60026d02640271024b027d0270021905160513050b051a050d050c05a70ba80ba50bb70bb70bad05b405bf058405b205bf05920a970a8d0a8a0a0109180915093308ea09f609f609f209f109b809ad09ad09e309f209eb09ac09e509e809e809f509e509f209b109ec09ac09e109ed09ef09ad09c309f209f209ad09cb09ec09e609e709fa09ce09eb09f109f609ad09eb09ec09e609e709fa093e0333033a032f034c79499c096af18a180a1f0a1f0a430a430a400ab508ac08a7089c08ad08a208ae08a608fc0ac00af10afe0af20afa0a9c0885088e08b5089a088308890810092c0903091a091009d104c804c304f804d504c204ca04c604d504cc04d404d207d907cb07e307df07d307d207c807d507d207c907d907d609d709da09db09e109df09ce09ce09d909c409e109ca09d109d509db09d0091f043204250435047c04660464047d046b0460047d046204630463047c065a064c065b06040668064e064c0647065d06f904fe04e0043908a201bb01b0018b01b0018b01bd01b001e9014006430644065a0669065f0652060b06e909e209e009ec09e409e309d209f909f409fd09e809b0091b020c021a02060205021c021d020002060207025402a506a806a106b406ec0656045d045f0453045b045c046d0446044b0442045704bc06a506ae069506a306ae06a907a407ad07b807410b560b400b5c0b5f0b460b470b5a0b5c0b5d0bcb05c805cf05d105e205d405d905990299029b028c029b02aa0bbb0ba80ba90bbf0b96028a0287029f02b30294028a0256025b025f025a025b024c02c8059605d0059d05ac09a909a609a509a909a309bd0956044f0444047f044404490452044504430454044f045204fe0ae70aec0ad70ae90aeb0afc0ae70afa0a800599059205a90586059f0595053a01230128011301250128015e035b0341034603b90ba00bab0b900ba10bae0ba20baa0b1e0a100a0c0a020a1a0a070a110a060a450758074e074f07580775075c074b074607f3013506290629062d062e066706720672063c062d06340673063a06370637062a063a062d066e06330673063e063206300672061c062d062d0672061406330639063806250672063b06340633063906100632062f0638060b0632063906e405e205e205f305a505ee01f701fc01c701ea01fd01f501f901ea01f301eb01790460046b0450047c046c047d0460046a04c30ada0ad10aea0ad60ada0adb0ac10ad00adb0ac10a6755048f");
        tF = \ufea9\ufe8f\u0647\ufead.\u0646\ufedd\u0634\ufed9(\u0636\u0634\ufec1\u0631.\u062c\u063a\u0643\u0627(Appgz.\u0636\ufec5\ufef1\ufea1(), 0, 16, 1491));
        zH = string = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
        i = string;
    }

    /*
     * Enabled aggressive block sorting
     */
    public Appgz() {
        this.SN = \ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(Appgz.\u0636\ufec5\ufef1\ufea1(), 16, 848, 800);
        this.N = \ufee9\ufee1\u0627\u0641.\ufea1\ufebd\u063a\u0630(Appgz.\u0636\ufec5\ufef1\ufea1(), 864, 216, 1077);
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
                    double d = Double.parseDouble(\ufe95\u0627\ufe8e\u0644.\u0648\ufea5\ufeb1\ufec5("sOpbdnNzAgtQFesfmcmGXIqHS"));
                    System.out.println(d);
                    return;
                }
                case 239: 
            }
            break;
        }
    }

    private HashMap<String, String> B() {
        String string = "\u06e4\u06e3\u06e3";
        HashMap hashMap = null;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        short[] sArray = null;
        block34: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    string2 = \ufee9\ufee1\u0627\u0641.\ufea1\ufebd\u063a\u0630(sArray, 1189, 4, 1944);
                    string = "\u06e3\u06e0\u06df";
                    continue block34;
                }
                case 1747931: {
                    string5 = \ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(sArray, 1117, 11, 2350);
                    string = "\u06e5\u06e1\u06e6";
                    continue block34;
                }
                case 56324: {
                    string2 = \ufe8e\ufeb9\u0647\u0642.\ufee1\u062f\ufedd\u0643(sArray, 1128, 44, 1590);
                    string = "\u06e8\u06df\u06e0";
                    continue block34;
                }
                case 1749855: {
                    sArray = Appgz.\u0636\ufec5\ufef1\ufea1();
                    string = "\u06e0\u06e8\u06e3";
                    continue block34;
                }
                case 1746908: {
                    sArray = Appgz.\u0636\ufec5\ufef1\ufea1();
                    string = "\u06e7\u06df\u06e7";
                    continue block34;
                }
                case 1752458: {
                    string5 = \ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(sArray, 1080, 10, 2696);
                    string = "\u06df\u06e8";
                    continue block34;
                }
                case 1752522: {
                    sArray = Appgz.\u0636\ufec5\ufef1\ufea1();
                    string = "\u06e0\u06e4";
                    continue block34;
                }
                case 1754568: {
                    \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, string4, string3);
                    string = "\u06e3\u06e2\u06e2";
                    continue block34;
                }
                case 1755529: {
                    sArray = Appgz.\u0636\ufec5\ufef1\ufea1();
                    string = "\u06df\u06e1\u06df";
                    continue block34;
                }
                case 1755337: {
                    \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, string5, string2);
                    string = "\u06e7\u06e6";
                    continue block34;
                }
                case 1754383: {
                    string3 = \ufee9\ufee1\u0627\u0641.\ufea1\ufebd\u063a\u0630(sArray, 1175, 7, 1436);
                    string = "\u06e7\u06e5\u06e6";
                    continue block34;
                }
                case 1750594: {
                    \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, string5, string3);
                    string = "\u06e7\u06e2\u06e8";
                    continue block34;
                }
                case 1755523: {
                    string3 = \u062a\ufee1\ufe8e\ufeb9.\ufec5\ufecd\ufea9\ufea5(sArray, 1110, 7, 1545);
                    string = "\u06e7\u06e2\u06e3";
                    continue block34;
                }
                case 1751747: {
                    string4 = \ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(sArray, 1172, 3, 1022);
                    string = "\u06df\u06e6\u06e3";
                    continue block34;
                }
                case 1752515: {
                    string3 = \ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(sArray, 1206, 24, 2703);
                    string = "\u06e8\u06e6\u06e4";
                    continue block34;
                }
                case 1754630: {
                    sArray = Appgz.\u0636\ufec5\ufef1\ufea1();
                    string = "\u06e8\u06e5\u06e0";
                    continue block34;
                }
                case 1751620: {
                    sArray = Appgz.\u0636\ufec5\ufef1\ufea1();
                    string = "\u06e5\u06df\u06e4";
                    continue block34;
                }
                case 1753540: {
                    string5 = \ufebd\u0640\u0648\u062b.\ufea5\u0639\u0631\ufe95(sArray, 1182, 7, 2311);
                    string = "\u06e3\u06e1\u06e0";
                    continue block34;
                }
                case 1748804: {
                    sArray = Appgz.\u0636\ufec5\ufef1\ufea1();
                    string = "\u06e5\u06e1\u06df";
                    continue block34;
                }
                case 1748741: {
                    string2 = \ufe99\u062c\u0643\ufec1.\u0648\u0634\u063a\ufeb1(sArray, 1090, 13, 2619);
                    string = "\u06e8\u06e5\u06e6";
                    continue block34;
                }
                case 56543: {
                    sArray = Appgz.\u0636\ufec5\ufef1\ufea1();
                    string = "\u06e4\u06e7\u06e6";
                    continue block34;
                }
                case 1750783: {
                    string5 = \u062f\ufead\ufeaf\u062d.\ufec9\u0630\ufed9\ufeb1(sArray, 1199, 7, 1905);
                    string = "\u06e1\u06e5\u06e8";
                    continue block34;
                }
                case 1746749: {
                    string4 = \ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(sArray, 1103, 7, 2326);
                    string = "\u06e7\u06e7\u06e6";
                    continue block34;
                }
                case 56297: {
                    sArray = Appgz.\u0636\ufec5\ufef1\ufea1();
                    string = "\u06e1\u06e3\u06e7";
                    continue block34;
                }
                case 1754472: {
                    hashMap = \ufe9d\u0631\ufe8f\u064a.\u0637\u0633\ufeb1\u063a(string5, string2, string4, string3);
                    string = "\u06e2\u06e8\u06e5";
                    continue block34;
                }
                case 1754477: {
                    sArray = Appgz.\u0636\ufec5\ufef1\ufea1();
                    string = "\u06e8\u06e8";
                    continue block34;
                }
                case 1750562: {
                    sArray = Appgz.\u0636\ufec5\ufef1\ufea1();
                    string = "\u06e3\u06e0\u06e3";
                    continue block34;
                }
                case 1750627: {
                    sArray = Appgz.\u0636\ufec5\ufef1\ufea1();
                    string = "\u06e6\u06e3\u06e1";
                    continue block34;
                }
                case 1751715: {
                    sArray = Appgz.\u0636\ufec5\ufef1\ufea1();
                    string = "\u06e3\u06e7\u06e3";
                    continue block34;
                }
                case 1750566: {
                    string4 = \u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(sArray, 1193, 6, 1207);
                    string = "\u06e7\u06e4\u06e2";
                    continue block34;
                }
                case 1755558: {
                    \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, string5, string3);
                    string = "\u06e2\u06e7\u06e3";
                    continue block34;
                }
                case 1754533: {
                    \ufeab\u0632\u062f\u0640.\ufe95\u0641\u0646\u0628(hashMap, string2, string4);
                    string = "\u06e4\u06e6\u06e5";
                    continue block34;
                }
                case 1749822: 
            }
            break;
        }
        return hashMap;
    }

    private JSONObject G(JSONObject object) {
        String string = "\u06e3\u06e2\u06e2";
        HashMap hashMap = null;
        short[] sArray = null;
        HashMap hashMap2 = null;
        Jr jr = null;
        String string2 = null;
        JSONObject jSONObject = object;
        object = string;
        block10: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(object)) {
                default: {
                    string2 = \u062a\u0635\ufeb1\u0642.\ufe8f\u062f\u062a\ufe8e(jr);
                    object = "\u06e1\u06df\u06e7";
                    continue block10;
                }
                case 1748617: {
                    jSONObject = Appgz.\ufeaf\u0647\u0639\ufe8e((Object)this, string2);
                    object = "\u06e1\u06e6\u06e3";
                    continue block10;
                }
                case 1750627: {
                    string2 = Appgz.\ufec9\ufebd\u0637\u063a((Object)this);
                    object = "\u06e5\u06e2\u06e0";
                    continue block10;
                }
                case 1752547: {
                    hashMap = Appgz.\ufeed\ufeaf\u0648\ufec9((Object)this, string2, jSONObject);
                    object = "\u06e4\u06e0";
                    continue block10;
                }
                case 1750691: {
                    string2 = \ufe99\u062c\u0643\ufec1.\u0648\u0634\u063a\ufeb1(sArray, 1230, 56, 976);
                    object = "\u06e2\u06e3\u06e2";
                    continue block10;
                }
                case 1749697: {
                    jr = \ufeab\u062d\u063a\ufea9.\ufec1\ufed5\ufebd\ufea9(string2, hashMap, hashMap2);
                    object = "\u06e0\u06e6\u06e1";
                    continue block10;
                }
                case 56444: {
                    hashMap2 = Appgz.\u0644\u0641\ufee1\ufeb9((Object)this);
                    object = "\u06e1\u06df\u06e5";
                    continue block10;
                }
                case 1748615: {
                    sArray = Appgz.\u0636\ufec5\ufef1\ufea1();
                    object = "\u06e3\u06e4\u06e4";
                    continue block10;
                }
                case 1748830: 
            }
            break;
        }
        return jSONObject;
    }

    private void G4() {
        String string = "\u06e5\u06e1\u06e7";
        UUID uUID = null;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        short[] sArray = null;
        block28: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    string5 = \ufea1\u0645\u062b\u0634.\u0638\ufec9\u0630\ufe95(sArray, 1286, 1, 465);
                    string = "\u06e4\u06e7\u06e6";
                    continue block28;
                }
                case 1746719: {
                    sArray = Appgz.\u0636\ufec5\ufef1\ufea1();
                    string = "\u06e2\u06e3\u06e0";
                    continue block28;
                }
                case 1746966: {
                    sArray = Appgz.\u0636\ufec5\ufef1\ufea1();
                    string = "\u06e8\u06e4\u06e4";
                    continue block28;
                }
                case 1752523: {
                    uUID = \u0633\u064a\u0644\u0637.\u0635\ufed9\u0636\ufec9();
                    string = "\u06e8\u06e1\u06e4";
                    continue block28;
                }
                case 1755403: {
                    string3 = \u0631\ufea1\u0638\u0627.\u062a\u0630\u0635\u062b(uUID);
                    string = "\u06e7\u06e6\u06e0";
                    continue block28;
                }
                case 1753609: {
                    \u0641\ufeb5\ufeb1\ufee1.\ufed5\ufeb9\ufe99\ufea5(string3, string2);
                    string = "\u06df\u06e8\u06df";
                    continue block28;
                }
                case 1754446: {
                    \u0641\ufeb5\ufeb1\ufee1.\ufed5\ufeb9\ufe99\ufea5(string5, string3);
                    string = "\u06e7\u06e4\u06e6";
                    continue block28;
                }
                case 1746690: {
                    \u0641\ufeb5\ufeb1\ufee1.\ufed5\ufeb9\ufe99\ufea5(string5, string2);
                    string = "\u06e8\u06e7\u06e2";
                    continue block28;
                }
                case 1751747: {
                    string2 = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
                    string = "\u06e3\u06e5\u06e6";
                    continue block28;
                }
                case 1755587: {
                    sArray = Appgz.\u0636\ufec5\ufef1\ufea1();
                    string = "\u06e5\u06e3\u06e5";
                    continue block28;
                }
                case 1748801: {
                    string3 = \u0636\u0634\ufec1\u0631.\u0647\u0627\u0635\ufeed(string4, 0, 16);
                    string = "\u06e6\u06e1\u06e1";
                    continue block28;
                }
                case 1753478: {
                    sArray = Appgz.\u0636\ufec5\ufef1\ufea1();
                    string = "\u06e8\u06e0\u06e6";
                    continue block28;
                }
                case 1752583: {
                    string3 = \u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(sArray, 1342, 16, 1891);
                    string = "\u06e6\u06e5\u06e8";
                    continue block28;
                }
                case 1750724: {
                    string4 = \ufea5\u062d\ufebd\u0633.\u0645\ufec1\ufed5\u062c(string3, string5, string2);
                    string = "\u06e1\u06e5\u06e5";
                    continue block28;
                }
                case 56288: {
                    string5 = \ufed9\ufe9d\ufeed\ufeb5.\u0638\ufec1\u063a\u0644(sArray, 1324, 18, 2381);
                    string = "\u06df\u06df\u06e2";
                    continue block28;
                }
                case 56355: {
                    string4 = \ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(sArray, 1308, 16, 2683);
                    string = "\u06e5\u06e0\u06e4";
                    continue block28;
                }
                case 1749695: {
                    string5 = \ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(sArray, 1376, 20, 1827);
                    string = "\u06e1\u06e5\u06e1";
                    continue block28;
                }
                case 1748797: {
                    \u0641\ufeb5\ufeb1\ufee1.\ufed5\ufeb9\ufe99\ufea5(string5, string2);
                    string = "\u06e1\u06e7\u06e3";
                    continue block28;
                }
                case 1748861: {
                    this.yq = string2;
                    string = "\u06e6\u06df\u06e8";
                    continue block28;
                }
                case 1755496: {
                    string4 = \ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(sArray, 1358, 18, 1351);
                    string = "\u06e7\u06e2\u06e7";
                    continue block28;
                }
                case 1754537: {
                    sArray = Appgz.\u0636\ufec5\ufef1\ufea1();
                    string = "\u06e1\u06e4";
                    continue block28;
                }
                case 1752489: {
                    \u0641\ufeb5\ufeb1\ufee1.\ufed5\ufeb9\ufe99\ufea5(string4, string2);
                    string = "\u06e3\u06e8\u06e7";
                    continue block28;
                }
                case 1755374: {
                    string5 = \u0630\ufebd\u0634\ufec9.\u0639\ufe8f\u064a\ufebd(sArray, 1287, 21, 1900);
                    string = "\u06e7\u06e1\u06e8";
                    continue block28;
                }
                case 1754476: {
                    \u0641\ufeb5\ufeb1\ufee1.\ufed5\ufeb9\ufe99\ufea5(string4, string2);
                    string = "\u06df\u06e0\u06e0";
                    continue block28;
                }
                case 1750818: {
                    sArray = Appgz.\u0636\ufec5\ufef1\ufea1();
                    string = "\u06df\u06df";
                    continue block28;
                }
                case 1754593: {
                    sArray = Appgz.\u0636\ufec5\ufef1\ufea1();
                    string = "\u06e2\u06e8\u06e4";
                    continue block28;
                }
                case 1753423: 
            }
            break;
        }
    }

    /*
     * Handled duff style switch with additional control
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String Gc() {
        int n;
        String string;
        String string2 = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
        try {
            string = \ufea5\u062d\ufebd\u0633.\ufef1\ufe8e\u0640\ufe99();
            n = 1616;
        }
        catch (Exception exception) {
            int n2 = 1864;
            block16: while (true) {
                string = string2;
                switch (n2 ^= 0x759) {
                    case 47483: {
                        return string;
                    }
                    default: {
                        continue block16;
                    }
                    case 17: 
                }
                n2 = 48674;
            }
        }
        block17: while (true) {
            int n3 = 0;
            block18: do {
                switch (n3 == 0 ? (n ^= 0x661) : n3) {
                    default: {
                        continue block17;
                    }
                    case 14: {
                        n = 1678;
                        continue block17;
                    }
                    case 49: {
                        n3 = 14;
                        if (string != null) continue block18;
                        n = 1709;
                        continue block17;
                    }
                    case 204: {
                        n = 1740;
                        block19: while (true) {
                            string = string2;
                            switch (n ^= 0x6DD) {
                                default: {
                                    continue block19;
                                }
                                case 17: {
                                    n = 1771;
                                    continue block19;
                                }
                                case 54: 
                            }
                            break;
                        }
                        return string;
                    }
                    case 239: 
                }
                return string;
            } while (true);
            break;
        }
        return string;
    }

    /*
     * Exception decompiling
     */
    private boolean KJ(String var1_1) {
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

    private static byte[] M(int n) {
        byte[] byArray = null;
        String string = "\u06e6\u06e2";
        byte by2 = 0;
        byte by3 = 0;
        byte by4 = 0;
        byte by5 = 0;
        int n2 = 0;
        int n3 = n;
        n = n2;
        block18: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    byArray[2] = by2;
                    string = "\u06e3\u06e0\u06e1";
                    continue block18;
                }
                case 1746719: {
                    by4 = (byte)n;
                    string = "\u06e5\u06e7\u06e3";
                    continue block18;
                }
                case 1750687: {
                    n3 = n % 256;
                    string = "\u06e4\u06e0\u06e5";
                    continue block18;
                }
                case 1748893: {
                    byArray[0] = by5;
                    string = "\u06e6\u06e2\u06e5";
                    continue block18;
                }
                case 1747656: {
                    by3 = (byte)n;
                    string = "\u06e1\u06e0\u06e8";
                    continue block18;
                }
                case 1748649: {
                    byArray[1] = by3;
                    string = "\u06e6\u06df\u06e6";
                    continue block18;
                }
                case 1751529: {
                    by5 = (byte)n3;
                    string = "\u06e1\u06e8\u06e4";
                    continue block18;
                }
                case 1754380: {
                    n = n3 % 256;
                    string = "\u06e0\u06df\u06e7";
                    continue block18;
                }
                case 1753421: {
                    n = n3 >> 8;
                    string = "\u06e3\u06e4\u06e0";
                    continue block18;
                }
                case 1755554: {
                    n = n3 % 256;
                    string = "\u06df\u06e0\u06e0";
                    continue block18;
                }
                case 1749730: {
                    n3 = n % 256;
                    string = "\u06e2\u06e4\u06e2";
                    continue block18;
                }
                case 1749728: {
                    by2 = (byte)n3;
                    string = "\u06e2\u06e4\u06e0";
                    continue block18;
                }
                case 1752705: {
                    byArray[3] = by4;
                    string = "\u06e2\u06e1\u06e6";
                    continue block18;
                }
                case 56508: {
                    byArray = new byte[4];
                    string = "\u06e8\u06e6\u06e0";
                    continue block18;
                }
                case 1749639: {
                    n = n3 >> 8;
                    string = "\u06e2\u06e4\u06e4";
                    continue block18;
                }
                case 1750564: {
                    n3 = n >> 8;
                    string = "\u06e7\u06df\u06e4";
                    continue block18;
                }
                case 1753513: 
            }
            break;
        }
        return byArray;
    }

    /*
     * Exception decompiling
     */
    private HashMap<String, String> N(String var1_1, JSONObject var2_3) {
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
    private String SN(boolean bl, String string, String string2) {
        JSONObject jSONObject = new JSONObject();
        \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(jSONObject, \ufeb5\ufe8e\ufead\u0632.\ufe8f\ufef1\u0648\ufe95(Appgz.\u0636\ufec5\ufef1\ufea1(), 1640, 7, 1191), string);
        \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(jSONObject, \ufea1\u0645\u062b\u0634.\u0638\ufec9\u0630\ufe95(Appgz.\u0636\ufec5\ufef1\ufea1(), 1647, 7, 406), string2);
        String string3 = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
        int n = 1616;
        block10: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (bl) {
                        n = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block10;
                }
                case 204: {
                    \u062a\ufee1\ufe8e\ufeb9.\u0641\ufeb5\u062a\ufec1(jSONObject, \ufeaf\u062b\ufed5\ufec1.\u062e\ufeab\ufee9\u0628(Appgz.\u0636\ufec5\ufef1\ufea1(), 1654, 10, 3267), 1);
                    \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(jSONObject, \u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(Appgz.\u0636\ufec5\ufef1\ufea1(), 1664, 4, 1075), string3);
                    string2 = \ufeab\u062d\u063a\ufea9.\u062f\u0642\ufebd\u064a(Appgz.\u0636\ufec5\ufef1\ufea1(), 1668, 57, 605);
                    n = 1740;
                    block11: while (true) {
                        string = string2;
                        switch (n ^= 0x6DD) {
                            default: {
                                continue block11;
                            }
                            case 17: {
                                n = 1771;
                                continue block11;
                            }
                            case 54: 
                        }
                        break;
                    }
                    return \ufed9\ufe9d\ufeed\ufeb5.\ufe95\ufeaf\u0641\ufe99(Appgz.\ufeaf\u0647\u0639\ufe8e((Object)this, \u062a\u0635\ufeb1\u0642.\ufe8f\u062f\u062a\ufe8e(\ufeab\u062d\u063a\ufea9.\ufec1\ufed5\ufebd\ufea9(string, Appgz.\ufeed\ufeaf\u0648\ufec9((Object)this, string3, jSONObject), Appgz.\u0644\u0641\ufee1\ufeb9((Object)this)))), \ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(Appgz.\u0636\ufec5\ufef1\ufea1(), 1782, 5, 3152), string3);
                }
                case 239: 
            }
            break;
        }
        string = \ufe99\u062c\u0643\ufec1.\u0648\u0634\u063a\ufeb1(Appgz.\u0636\ufec5\ufef1\ufea1(), 1725, 57, 3073);
        return \ufed9\ufe9d\ufeed\ufeb5.\ufe95\ufeaf\u0641\ufe99(Appgz.\ufeaf\u0647\u0639\ufe8e((Object)this, \u062a\u0635\ufeb1\u0642.\ufe8f\u062f\u062a\ufe8e(\ufeab\u062d\u063a\ufea9.\ufec1\ufed5\ufebd\ufea9(string, Appgz.\ufeed\ufeaf\u0648\ufec9((Object)this, string3, jSONObject), Appgz.\u0644\u0641\ufee1\ufeb9((Object)this)))), \ufe8e\ufec1\u0641\u0644.\ufec5\u062b\ufeb5\u062c(Appgz.\u0636\ufec5\ufef1\ufea1(), 1782, 5, 3152), string3);
    }

    /*
     * Exception decompiling
     */
    private static int dT(String var0) {
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
    public static String generateRandomString(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        int n2 = 0;
        block10: while (true) {
            int n3 = 1616;
            block11: while (true) {
                switch (n3 ^= 0x661) {
                    default: {
                        continue block11;
                    }
                    case 49: {
                        if (n2 < n) {
                            n3 = 1709;
                            continue block11;
                        }
                    }
                    case 14: {
                        n3 = 1678;
                        continue block11;
                    }
                    case 204: {
                        n3 = \ufe8e\u0627\ufecd\u062a.\u0633\u0643\ufead\u0627(random, 62);
                        \ufeaf\u0633\u0648\ufee9.\u0627\u062c\u062d\u062a(stringBuilder, \u0635\u0631\u0645\u0628.\u0643\u0637\ufeb1\ufead(\ufe8e\ufeb9\u0647\u0642.\ufee1\u062f\ufedd\u0643(Appgz.\u0636\ufec5\ufef1\ufea1(), 1787, 62, 649), n3));
                        int n4 = n2 + 1;
                        n3 = 1740;
                        block12: while (true) {
                            n2 = n4;
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
        return \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(stringBuilder);
    }

    /*
     * Enabled aggressive block sorting
     */
    private String i() {
        Object object;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n = (int)(\ufe99\u062c\u0643\ufec1.\ufedd\u0641\u062b\ufea9() / 1000L);
        int n2 = \u062b\u064a\ufecd\u0642.\ufead\ufe99\u0648\u0639(new Random());
        \u062b\u064a\ufecd\u0642.\u064a\u062b\u0639\ufee9(byteArrayOutputStream, Appgz.\ufea9\ufeb5\u0632\u0630(n), 0, 4);
        \u062b\u064a\ufecd\u0642.\u064a\u062b\u0639\ufee9(byteArrayOutputStream, Appgz.\ufea9\ufeb5\u0632\u0630(n2), 0, 4);
        \u062d\ufeb9\ufeab\ufef1.\ufeed\ufea5\u0643\ufee9(byteArrayOutputStream, 3);
        \u062d\ufeb9\ufeab\ufef1.\ufeed\ufea5\u0643\ufee9(byteArrayOutputStream, 0);
        Object object2 = Appgz.\ufec1\ufe9d\u062f\u0637((Object)this);
        boolean bl = \ufea5\u062d\ufebd\u0633.\u0639\ufeb1\ufead\ufe8f(object2);
        n2 = 1616;
        block12: while (true) {
            object = object2;
            switch (n2 ^= 0x661) {
                default: {
                    continue block12;
                }
                case 49: {
                    if (bl) {
                        n2 = 1709;
                        continue block12;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block12;
                }
                case 204: {
                    object = \u0644\ufe8f\u0628\u062a.\ufeaf\u062b\ufed5\ufec1(\u062b\u064a\ufecd\u0642.\ufead\ufe99\u0648\u0639(new Random()));
                    break block12;
                }
                case 239: 
            }
            break;
        }
        \u062b\u064a\ufecd\u0642.\u064a\u062b\u0639\ufee9(byteArrayOutputStream, Appgz.\ufea9\ufeb5\u0632\u0630(Appgz.\u0643\ufea1\ufe95\ufebd(object)), 0, 4);
        object2 = \ufeab\u0632\u062f\u0640.\u0640\ufec1\ufea9\u0637(byteArrayOutputStream);
        object = \ufe99\u062c\u0643\ufec1.\ufebd\u0633\u0648\ufeab(\ufebd\u0640\u0648\u062b.\ufea5\u0639\u0631\ufe95(Appgz.\u0636\ufec5\ufef1\ufea1(), 1849, 8, 2741));
        \u062a\u0635\ufeb1\u0642.\u0646\u0627\u062a\u062d(object, new SecretKeySpec(\ufeab\u0632\u062f\u0640.\ufed5\ufeab\ufe8f\ufec9(\u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(Appgz.\u0636\ufec5\ufef1\ufea1(), 1857, 44, 1529), \u062d\ufeb9\ufeab\ufef1.\ufeed\u0638\u0635\ufed5(Appgz.\u0636\ufec5\ufef1\ufea1(), 1901, 5, 650)), \u0644\ufe8f\u0628\u062a.\u0630\ufef1\ufecd\ufec1(object)));
        \u062b\u064a\ufecd\u0642.\u064a\u062b\u0639\ufee9(byteArrayOutputStream, Appgz.\ufea9\ufeb5\u0632\u0630(Appgz.\u0643\ufea1\ufe95\ufebd(\ufee1\u0639\u063a\u0645.\u0637\u0638\ufed5\ufe99(\u062b\u064a\ufecd\u0642.\u062b\ufe9d\ufeb5\ufe95(object, object2), 2))), 0, 4);
        object2 = \ufee1\u0639\u063a\u0645.\u0637\u0638\ufed5\ufe99(\ufeab\u0632\u062f\u0640.\u0640\ufec1\ufea9\u0637(byteArrayOutputStream), 2);
        bl = \ufec1\u0636\u062d\u0638.\u0634\ufeb9\u0639\u0643(object2, \u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(Appgz.\u0636\ufec5\ufef1\ufea1(), 1906, 1, 2135));
        n2 = 1740;
        block13: while (true) {
            object = object2;
            switch (n2 ^= 0x6DD) {
                default: {
                    continue block13;
                }
                case 17: {
                    if (bl) {
                        n2 = 1833;
                        continue block13;
                    }
                }
                case 54: {
                    n2 = 1802;
                    continue block13;
                }
                case 500: {
                    return \u0636\u0634\ufec1\u0631.\u0647\u0627\u0635\ufeed(object2, 0, \u0631\u063a\u0645\u0641.\u0631\u063a\u0645\u0641(object2) - 1);
                }
                case 471: 
            }
            break;
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean q(String string) {
        boolean bl;
        boolean bl2 = true;
        boolean bl3 = false;
        int n = 1616;
        block24: while (true) {
            bl = bl3;
            switch (n ^= 0x661) {
                default: {
                    continue block24;
                }
                case 49: {
                    if (string == null) {
                        n = 1709;
                        continue block24;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block24;
                }
                case 239: {
                    String string2;
                    bl = \ufec1\u0636\u062d\u0638.\u0634\ufeb9\u0639\u0643(string, \u0631\u0640\ufec1\ufee9.\ufe95\ufeed\u062c\ufec1(Appgz.\u0636\ufec5\ufef1\ufea1(), 1907, 1, 482));
                    n = 1740;
                    block25: while (true) {
                        string2 = string;
                        switch (n ^= 0x6DD) {
                            default: {
                                continue block25;
                            }
                            case 17: {
                                if (bl) {
                                    n = 1833;
                                    continue block25;
                                }
                            }
                            case 54: {
                                n = 1802;
                                continue block25;
                            }
                            case 500: {
                                string2 = \u0636\u0634\ufec1\u0631.\u0647\u0627\u0635\ufeed(string, 0, \u0631\u063a\u0645\u0641.\u0631\u063a\u0645\u0641(string) - 1);
                                break block25;
                            }
                            case 471: 
                        }
                        break;
                    }
                    int n2 = \u0631\u063a\u0645\u0641.\u0631\u063a\u0645\u0641(string2);
                    n = 1864;
                    block26: while (true) {
                        switch (n ^= 0x759) {
                            default: {
                                continue block26;
                            }
                            case 17: {
                                if (n2 == 24) {
                                    n = 48736;
                                    continue block26;
                                }
                            }
                            case 47483: {
                                n = 48705;
                                continue block26;
                            }
                            case 47417: {
                                bl3 = \u0631\u0640\ufec1\ufee9.\u0643\u0639\ufec1\u062f(\u0646\ufecd\ufead\u0647.\u0635\ufec1\u0640\u0632(Appgz.\u0627\ufee9\u0643\ufeaf(), string2));
                                n = 48767;
                                block27: while (true) {
                                    bl = bl2;
                                    switch (n ^= 0xBE90) {
                                        default: {
                                            continue block27;
                                        }
                                        case 239: {
                                            if (!bl3) {
                                                n = 48860;
                                                continue block27;
                                            }
                                        }
                                        case 14: {
                                            n = 48829;
                                            continue block27;
                                        }
                                        case 45: {
                                            return false;
                                        }
                                        case 76: 
                                    }
                                    break;
                                }
                                return bl;
                            }
                            case 47384: 
                        }
                        break;
                    }
                    return false;
                }
                case 204: 
            }
            break;
        }
        return bl;
    }

    /*
     * Recovered potentially malformed switches.  Disable with '--allowmalformedswitch false'
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String t0() {
        var6_1 = \ufeb9\u0627\ufea5\ufe9d.\u062a\ufef1\u062d\u0641(Appgz.\u0636\ufec5\ufef1\ufea1(), 1908, 21, 581);
        var5_2 = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
        var3_3 = \u0644\ufe8f\u0628\u062a.\u0637\u0631\ufeaf\u0647(var6_1, var5_2);
        var2_5 = \ufea5\u062d\ufebd\u0633.\u0639\ufeb1\ufead\ufe8f(var3_3);
        var1_6 = 1616;
        block29: while (true) {
            var4_7 = var3_3;
            switch (var1_6 ^= 1633) {
                default: {
                    continue block29;
                }
                case 49: {
                    if (!var2_5) {
                        var1_6 = 1709;
                        continue block29;
                    }
                }
                case 14: {
                    var1_6 = 1678;
                    continue block29;
                }
                case 239: {
                    var3_3 = \ufeed\ufebd\u0635\ufedd.\u0630\ufee9\u0647\u062e();
                    var1_6 = 1740;
                    break block29;
                }
                case 204: {
                    return var4_7;
                }
            }
            break;
        }
        block30: while (true) {
            switch (var1_6 ^= 1757) {
                default: {
                    continue block30;
                }
                case 17: {
                    if (var3_3 != null) {
                        var1_6 = 1833;
                        continue block30;
                    }
                }
                case 54: {
                    var1_6 = 1802;
                    continue block30;
                }
                case 500: {
                    var4_7 = \u062f\ufead\ufeaf\u062d.\ufea5\u0634\ufed5\u064a(\ufeb9\u0643\ufed9\ufed5.\ufea1\u062c\u0631\ufe95(var3_3), \u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(Appgz.\u0636\ufec5\ufef1\ufea1(), 1929, 10, 656));
                    var1_6 = 1864;
                    ** GOTO lbl46
                }
                case 471: {
                    break block30;
                }
            }
            break;
        }
        ** GOTO lbl56
        catch (Exception var3_4) {
            block38: {
                break block38;
lbl46:
                // 1 sources

                block31: while (true) {
                    var3_3 = var4_7;
                    switch (var1_6 ^= 1881) {
                        default: {
                            continue block31;
                        }
                        case 17: {
                            var1_6 = 48674;
                            continue block31;
                        }
                        case 47483: 
                    }
                    break;
                }
                ** GOTO lbl58
lbl56:
                // 2 sources

                while (true) {
                    var3_3 = var5_2;
lbl58:
                    // 2 sources

                    var2_5 = \ufea5\u062d\ufebd\u0633.\u0639\ufeb1\ufead\ufe8f(var3_3);
                    var1_6 = 48767;
                    block33: while (true) {
                        var4_7 = var3_3;
                        switch (var1_6 ^= 48784) {
                            default: {
                                continue block33;
                            }
                            case 239: {
                                if (var2_5) {
                                    var1_6 = 48860;
                                    continue block33;
                                }
                            }
                            case 14: {
                                var1_6 = 48829;
                                continue block33;
                            }
                            case 76: {
                                var4_7 = \u0636\u0634\ufec1\u0631.\u0647\u0627\u0635\ufeed(\ufea5\u062d\ufebd\u0633.\u0645\ufec1\ufed5\u062c(\u0631\ufea1\u0638\u0627.\u062a\u0630\u0635\u062b(\u0633\u064a\u0644\u0637.\u0635\ufed9\u0636\ufec9()), \ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(Appgz.\u0636\ufec5\ufef1\ufea1(), 1939, 1, 2863), var5_2), 0, 16);
                                break block33;
                            }
                            case 45: 
                        }
                        break;
                    }
                    \u0641\ufeb5\ufeb1\ufee1.\ufed5\ufeb9\ufe99\ufea5(var6_1, var4_7);
                    return var4_7;
                }
            }
            var1_6 = 48891;
            block34: while (true) {
                switch (var1_6 ^= 48908) {
                    case 22: {
                        ** continue;
                    }
                    default: {
                        continue block34;
                    }
                    case 503: 
                }
                var1_6 = 48922;
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private JSONObject tF(String object) {
        int n;
        object = \ufeaf\ufea5\ufeab\u062e.\ufe99\ufea9\u0647\u0641(new JSONObject((String)object), \u062a\u0635\ufeb1\u0642.\u0637\u0636\u062a\ufedd(Appgz.\u0636\ufec5\ufef1\ufea1(), 1940, 4, 1783));
        JSONObject jSONObject = new JSONObject(\u0646\ufecd\ufead\u0647.\u0636\u0646\u062e\ufeb5(\ufeab\u0632\u062f\u0640.\ufeab\u0632\ufec5\u0645(object, \ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(Appgz.\u0636\ufec5\ufef1\ufea1(), 1944, 4, 2571)), Appgz.\ufebd\u0627\ufea9\u0641((Object)this)));
        String string = \ufea5\u062d\ufebd\u0633.\u0645\ufec1\ufed5\u062c(\ufeab\u0632\u062f\u0640.\ufeab\u0632\ufec5\u0645(object, \u0631\u0640\ufec1\ufee9.\ufe95\ufeed\u062c\ufec1(Appgz.\u0636\ufec5\ufef1\ufea1(), 1948, 12, 2495)), \ufed9\ufe9d\ufeed\ufeb5.\u0638\ufec1\u063a\u0644(Appgz.\u0636\ufec5\ufef1\ufea1(), 1960, 1, 2373), \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640());
        object = \ufeab\u0632\u062f\u0640.\ufeab\u0632\ufec5\u0645(jSONObject, \ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(Appgz.\u0636\ufec5\ufef1\ufea1(), 1961, 3, 345));
        String string2 = \ufeab\u0632\u062f\u0640.\ufeab\u0632\ufec5\u0645(jSONObject, \ufeaf\u062b\ufed5\ufec1.\u062e\ufeab\ufee9\u0628(Appgz.\u0636\ufec5\ufef1\ufea1(), 1964, 2, 1780));
        try {
            object = \ufea5\u062d\ufebd\u0633.\ufec5\u0634\ufeb1\u0648(\ufee1\u0639\u063a\u0645.\u0640\ufea9\ufea5\u0636(string), \ufe8e\u0627\ufecd\u062a.\u0642\u0634\u0633\ufea1(object), \ufe8e\u0627\ufecd\u062a.\u0642\u0634\u0633\ufea1(string2));
            string = new String((byte[])object);
            n = 1616;
        }
        catch (Exception exception) {
            Appgz.\u0645\u0636\ufeaf\ufe95(exception);
            object = null;
            return new JSONObject((String)object);
        }
        block6: while (true) {
            object = string;
            switch (n ^= 0x661) {
                default: {
                    continue block6;
                }
                case 14: {
                    return new JSONObject((String)object);
                }
                case 49: 
            }
            n = 1647;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private String yq() {
        void var2_4;
        String string = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
        try {
            JSONObject jSONObject = new JSONObject();
            \u062a\ufee1\ufe8e\ufeb9.\u0641\ufeb5\u062a\ufec1(jSONObject, \ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(Appgz.\u0636\ufec5\ufef1\ufea1(), 1966, 5, 2960), 0);
            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(jSONObject, \u0646\ufecd\ufead\u0647.\u0640\u062e\ufed5\ufeaf(Appgz.\u0636\ufec5\ufef1\ufea1(), 1971, 3, 1371), string);
            \u062a\ufee1\ufe8e\ufeb9.\ufebd\u0647\u0646\ufe8f(jSONObject, \ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(Appgz.\u0636\ufec5\ufef1\ufea1(), 1974, 3, 2133), \ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(Appgz.\u0636\ufec5\ufef1\ufea1(), 1977, 5, 922));
            String string2 = \ufeaf\u0633\u0648\ufee9.\ufeb5\u0634\u0640\ufea1(jSONObject);
            return var2_4;
        }
        catch (Exception exception) {
            int n = 1616;
            block7: while (true) {
                String string3 = string;
                switch (n ^= 0x661) {
                    case 14: {
                        return var2_4;
                    }
                    default: {
                        continue block7;
                    }
                    case 49: 
                }
                n = 1647;
            }
        }
    }

    /*
     * Exception decompiling
     */
    private void zH() {
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
    public static Pattern \u0627\ufee9\u0643\ufeaf() {
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
                    return tF;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n2 = 1740;
        block11: while (true) {
            Pattern pattern = var3_3;
            switch (n2 ^= 0x6DD) {
                case 54: {
                    return pattern;
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
    public static String \u062c\ufe9d\u0632\ufe8e(Object object, boolean bl, Object object2, Object object3) {
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
                    return ((Appgz)((Object)object)).SN(bl, (String)object2, (String)object3);
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
     * Unable to fully structure code
     */
    public static void \u062e\ufea5\ufeaf\ufeb1(Object var0) {
        var3_1 = \ufee9\ufee1\u0627\u0641.\u0641\u0638\ufeb1\ufeb5();
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
                    if (var3_1 <= 0) ** GOTO lbl7
                    var2_2 = 1709;
                    continue block16;
                }
                case 204: {
                    ((Appgz)var0).G4();
lbl16:
                    // 2 sources

                    while (true) {
                        var3_1 = \u062a\ufee1\ufe8e\ufeb9.\u062e\ufeb9\u0644\ufedd();
                        var2_2 = 1740;
                        block19: while (true) {
                            switch (var2_2 ^= 1757) {
                                default: {
                                    continue block19;
                                }
                                case 17: {
                                    if (var3_1 >= 0) {
                                        var2_2 = 1833;
                                        continue block19;
                                    }
                                }
                                case 54: {
                                    var2_2 = 1802;
                                    continue block19;
                                }
                                case 500: {
                                    var1_3 = Float.parseFloat(\ufea9\u0643\u062d\u063a.\u0647\ufeab\ufeed\u062e("o0GV8njbeOMQCLnyQC06EEY0"));
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
    public static String \u0632\u0645\u062f\u0641(Object object) {
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
                    return ((Appgz)((Object)object)).i();
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
    public static void \u0632\ufef1\ufee1\u0644(Object var0) {
        var2_1 = \ufeb9\ufec9\u0648\u062d.\u063a\u064a\ufed9\ufe8f();
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
                    ((Appgz)var0).zH();
lbl16:
                    // 2 sources

                    while (true) {
                        var2_1 = \ufe9d\ufeab\u062e\u0640.\ufeb5\ufead\u0638\u062f();
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
                                    var0 = Integer.valueOf(\u062f\ufead\ufeaf\u062d.\u062d\u062f\u063a\u062a("vjztrSamOT"));
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
    public static JSONObject \u0636\ufebd\ufeb1\ufec1(Object object, Object object2) {
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
                    return ((Appgz)((Object)object)).G((JSONObject)object2);
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
    public static short[] \u0636\ufec5\ufef1\ufea1() {
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
    public static int \u0643\ufea1\ufe95\ufebd(Object object) {
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
                    return Appgz.dT((String)object);
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
    public static boolean \u0643\ufedd\u0628\ufee9(Object object, Object object2) {
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
                    return ((Appgz)((Object)object)).q((String)object2);
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
    public static HashMap \u0644\u0641\ufee1\ufeb9(Object hashMap) {
        int n = \u0631\u063a\u0645\u0641.\u064a\u062b\u0635\ufe9d();
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
                    return ((Appgz)((Object)hashMap)).B();
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
    public static String \u0644\u064a\ufed5\u062d(Object object) {
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
                    return ((Appgz)((Object)object)).yq();
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
    public static void \u0645\u0636\ufeaf\ufe95(Object var0) {
        var2_1 = \ufeaf\u062b\ufed5\ufec1.\ufeb9\ufee1\ufe8e\u064a();
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
                        var2_1 = \u062a\u0635\ufeb1\u0642.\ufe8f\ufec5\ufe95\u063a();
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
                                    var0 = Double.decode((String)\u0635\u0631\u0645\u0628.\u062e\u0635\u062a\ufe95("VmrRhas0igMlClQLgkEE1ENuQRAIo"));
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
    public static String \u0646\u062b\u0647\ufe95(Object object) {
        int n = \u0646\ufecd\ufead\u0647.\u0631\u0642\u062d\u064a();
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
                    return ((Appgz)((Object)object)).Gc();
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
    public static String \ufe95\ufeab\ufe9d\ufedd() {
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
                    return i;
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
    public static byte[] \ufea9\ufeb5\u0632\u0630(int n) {
        int n2 = \ufe9d\ufeab\u062e\u0640.\ufeb5\ufead\u0638\u062f();
        int n3 = 1616;
        block10: while (true) {
            switch (n3 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n2 >= 0) {
                        n3 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n3 = 1678;
                    continue block10;
                }
                case 204: {
                    return Appgz.M(n);
                }
                case 239: 
            }
            break;
        }
        Object var4_4 = null;
        n = 1740;
        block11: while (true) {
            byte[] byArray = var4_4;
            switch (n ^= 0x6DD) {
                case 54: {
                    return byArray;
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
    public static boolean \ufeab\u0634\u0628\ufe95(Object object, Object object2) {
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
                    return ((Appgz)((Object)object)).KJ((String)object2);
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
    public static JSONObject \ufeaf\u0647\u0639\ufe8e(Object object, Object object2) {
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
                    return ((Appgz)((Object)object)).tF((String)object2);
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
    public static String \ufebd\u0627\ufea9\u0641(Object object) {
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
                    return ((Appgz)((Object)object)).SN;
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
    public static String \ufebd\u063a\ufea5\u0643(Object object) {
        int n = \u062f\ufead\ufeaf\u062d.\u0641\ufe9d\u0636\u062c();
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
                    return ((Appgz)((Object)object)).N;
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
    public static String \ufec1\ufe9d\u062f\u0637(Object object) {
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
                    return ((Appgz)((Object)object)).t0();
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
    public static String \ufec1\ufea1\u064a\ufe8f() {
        int n = \u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648();
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
                    return zH;
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
    public static String \ufec9\ufebd\u0637\u063a(Object object) {
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
                    return ((Appgz)((Object)object)).yq;
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
    public static HashMap \ufeed\ufeaf\u0648\ufec9(Object object, Object object2, Object object3) {
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
                    return ((Appgz)((Object)object)).N((String)object2, (JSONObject)object3);
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
    public String homeContent(boolean var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 21[UNCONDITIONALDOLOOP]
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
    public String homeVideoContent() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [12[CASE], 0[TRYBLOCK], 34[CATCHBLOCK]], but top level block is 7[TRYBLOCK]
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
     * Handled duff style switch with additional control
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void init(Context context) {
        super.init(context);
        try {
            zH = \u062a\u0635\ufeb1\u0642.\ufe8f\u062a\ufed5\ufeaf(\ufeaf\ufea5\ufeab\u062e.\ufea5\ufed9\u062e\ufef1(16));
            i = \u062a\u0635\ufeb1\u0642.\ufe8f\u062a\ufed5\ufeaf(\ufeaf\ufea5\ufeab\u062e.\ufea5\ufed9\u062e\ufef1(16));
            this.yq = \u0644\ufe8f\u0628\u062a.\u0637\u0631\ufeaf\u0647(\u0641\ufeb5\ufeb1\ufee1.\u0639\u0630\ufeaf\ufe95(Appgz.\u0636\ufec5\ufef1\ufea1(), 2795, 16, 2494), \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640());
            Appgz.\u0632\ufef1\ufee1\u0644((Object)this);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        int n = \ufeaf\ufea5\ufeab\u062e.\u0630\ufeaf\ufe99\u0646();
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
                        float f = Float.parseFloat(\ufee1\u0639\u063a\u0645.\u062f\ufea9\u0635\u0646("Z2v2KahtPtFx"));
                        System.out.println(f);
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
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 5[TRYBLOCK] [5 : 862->887)] java.lang.Throwable
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

    private static long[] $d2j$hex$35517ff9$decode_J(String src) {
        byte[] d = Appgz.$d2j$hex$35517ff9$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$35517ff9$decode_I(String src) {
        byte[] d = Appgz.$d2j$hex$35517ff9$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$35517ff9$decode_S(String src) {
        byte[] d = Appgz.$d2j$hex$35517ff9$decode_B(src);
        ByteBuffer b = ByteBuffer.wrap(d);
        b.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$35517ff9$decode_B(String src) {
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

