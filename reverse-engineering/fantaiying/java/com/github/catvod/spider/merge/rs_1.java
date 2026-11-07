/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.github.catvod.crawler.SpiderDebug
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.github.catvod.spider.merge;

import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.parser.\u062b\u064a\ufecd\u0642;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0630\ufebd\u0634\ufec9;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\u0638\ufead\u062e\ufee1;
import com.github.catvod.parser.\u0645\u0641\u0630\u062d;
import com.github.catvod.parser.\ufe8e\ufec1\u0641\u0644;
import com.github.catvod.parser.\ufe95\u0627\ufe8e\u0644;
import com.github.catvod.parser.\ufe99\u062e\u0642\u0644;
import com.github.catvod.parser.\ufe9d\u0631\ufe8f\u064a;
import com.github.catvod.parser.\ufea9\u0643\u062d\u063a;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeaf\u062b\ufed5\ufec1;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.parser.\ufec1\u0636\u062d\u0638;
import com.github.catvod.parser.\ufecd\u0642\u062e\ufe9d;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.merge.FA;
import com.github.catvod.spider.merge.HA;
import com.github.catvod.spider.merge.Uf;
import com.github.catvod.spider.merge.f_0;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.t_0;
import com.github.catvod.spider.merge.xu_0;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0641\u0631\ufeed\u0643;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufea5\ufea9\u0633\ufed5;
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
import com.github.catvod.spider.\u0641\ufeb5\ufeb1\ufee1;
import com.github.catvod.spider.\ufe8e\u0627\ufecd\u062a;
import com.github.catvod.spider.\ufe8e\ufeb9\u0647\u0642;
import com.github.catvod.spider.\ufe99\u062c\u0643\ufec1;
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
import org.json.JSONException;
import org.json.JSONObject;

/*
 * Renamed from com.github.catvod.spider.merge.rs
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class rs_1 {
    private static final int[][] N;
    private static final int[][] SN;
    private static final short[] short;
    private static final int[][] tF;
    private static JSONObject yq;
    private static final int[][] zH;

    static {
        short = rs_1.$d2j$hex$41b006ed$decode_S("9f07980797078d07980790078007900797079e07c007cb07c8073f05380537052d05380530052005300537053e0560056b056805c9019001c401dd01d601ed01db01d601900188019001800180018001800190019e019001c401dd01d601ed01dc01d301df01d701900188019001b76fd6978a588473f101dd01dd01d901db01d70190019e019001c401dd01d601ed01c201db01d101900188019001da01c601c601c201c10188019d019d01db01df01d501820185019c01c101dd01d501dd01c701d101d601dc019c01d101dd01df019d01c40180019d01c601da01c701df01d0019d01c001d701c601cb01c201d701ed01d701ca01d101de01c701d601d701ed01d501db01d4019d01d701ca01c6019d01d301c701c601dd019d01c3019d018b0187019d01d101c001dd01c2019d01ca01cb019d01d301db019d01c6019d0182019d018d01d301c201c201db01d6018f018301800180019401c701c001de018f01da01c601c601c201c10188019d019d01c10183019c01db01df01d301d501d701da01c701d0019c01d101d1019d01db01df01d301d501d701c1019d0180018201800186019d01830183019d01820184019d01d601d4018101d401d0018601d6018501820182018b0181018a018101d6018101d3018b018701d101d701d401840184018b018a01d1018a018b018001820182019c01d801c201d50190019e019001c401dd01d601ed01c001d701df01d301c001d901c101900188019201900190019e019001d301d101c601db01dd01dc01900188019001c301c701d301c001d901f101de01d701d301dc019001cf010b03520306031f0314032f031903140352034a035203120314031403140352035c03520306031f0314032f031e0311031d03150352034a035203756d14956f556f5533031f031f031b031903150352035c03520306031f0314032f0300031903130352034a035203180304030403000303034a035f035f0319031d031703400347035e0303031f0317031f030503130314031e035e0313031f031d035f03060342035f030403180305031d0312035f030203150304030903000315032f031503080313031c030503140315032f031703190316035f031503080304035f031103050304031f035f0301035f03490345035f03130302031f0300035f03080309035f03110319035f0304035f0340035f034f03110300030003190314034d034103420342035603050302031c034d03180304030403000303034a035f035f03030341035e0319031d031103170315031803050312035e03130313035f0319031d0311031703150303035f0342034003420346035f03400344035f03400347035f03110348034403420314034903400340034003430348034403110313034003120312031603440345031603450345031403150312034303440344031103490315035e031a030003170352035c03520306031f0314032f03020315031d03110302031b03030352034a035003520352035c03520311031303040319031f031e0352034a0352033203140333031c03150311031e0352030d0303070e070b0758085c0848085b0842081a0a0c0a6603400373052a057e0567056c05570561056c052a0532052a053b053b053b053b052a0524052a057e0567056c0557056605690565056d052a0532052a050d6b6c93104a58694b0567056705630561056d052a0524052a057e0567056c055705780561056b052a0532052a0560057c057c0578057b05320527052705610565056f0538053f0526057b0567056f0567057d056b056c05660526056b056705650527057e053a0527057c0560057d0565056a0527057a056d057c05710578056d0557056d0570056b0564057d056c056d0557056f0561056e0527056d0570057c05270569057d057c05670527057905270531053d0527056b057a056705780527057005710527056905610527057c05270538052705370569057805780561056c05350539053a053a052e057d057a056405350560057c057c0578057b053205270527057b05390526056105650569056f056d0560057d056a0526056b056b0527056105650569056f056d057b0527053a0538053a053c05270539053905270538053f0527053d056c053b056c053c053b056d053d053e053805380530053c053c053d053e056a0539056d056a056b053d0569056e05300569053b053a056e056e056a053e052605780566056f052a0524052a057e0567056c0557057a056d05650569057a0563057b052a05320528052a052a0524052a0569056b057c056105670566052a0532052a057d056b054b0564056d05690566052a0575058e0bd70b830b9a0b910baa0b9c0b910bd70bcf0bd70bc40bc40bc40bc40bd70bd90bd70b830b9a0b910baa0b9b0b940b980b900bd70bcf0bd70bf065919dca9d0d79810b9a0b9e0b900b9b0bd70bd90bd70b830b9a0b910baa0b850b9c0b960bd70bcf0bd70b9d0b810b810b850b860bcf0bda0bda0b9c0b980b920bc50bc20bdb0b860b9a0b920b9a0b800b960b910b9b0bdb0b960b9a0b980bda0b830bc70bda0b810b9d0b800b980b970bda0b870b900b810b8c0b850b900baa0b900b8d0b960b990b800b910b900baa0b920b9c0b930bda0b900b8d0b810bda0b940b800b810b9a0bda0b840bda0bcc0bc00bda0b960b870b9a0b850bda0b8d0b8c0bda0b940b9c0bda0b810bda0bc50bda0bca0b940b850b850b9c0b910bc80bc40bc70bc70bd30b800b870b990bc80b9d0b810b810b850b860bcf0bda0bda0b860bc40bdb0b9c0b980b940b920b900b9d0b800b970bdb0b960b960bda0b9c0b980b940b920b900b860bda0bc70bc50bc70bc10bda0bc40bc40bda0bc50bc30bda0bc60bc40b910bcd0b930b930bc50bc20bc60b900bc10bc10b910bc30bc30bcc0bc60b930b970b970b960b930b970b900bc30bcc0b910bc50b940bc20bc50bc60bdb0b9f0b850b920bd70bd90bd70b830b9a0b910baa0b870b900b980b940b870b9e0b860bd70bcf0bd50bd70bd70bd90bd70b940b960b810b9c0b9a0b9b0bd70bcf0bd70b940b990b9c0bb60b990b900b940b9b0bd70b880b1b0500051905190573027f027d023e0277027f027f0277027c0275023e0273027f027d027d027f027e023e0272027102630275023e0243026402620279027e0277026302e201df01c401c201d701d301ce01c801c9018701c301d201d501ce01c901c0018701cb01c201c901ce01c201c901d301e101c801d501ca01c601d3018701c101c801d5018701df07ba04ee04f204e804ff04ed04ba04fc058303d503ab0cd00c9e0b920bc006da060807510705071c0717072c071a071707510749075107470747074707470751075f07510705071c0717072c071d0712071e0716075107490751079986e95c2278ab71e164fc5951075f07510705071c0717072c0703071a0710075107490751071b07070707070307000749075c075c071a071e071407430744075d0700071c0714071c070607100717071d075d0710071c071e075c07050741075c0707071b0706071e0711075c070107160707070a07030716072c0716070b0710071f070607170716072c0714071a0715075c0716070b0707075c071207060707071c075c0702075c074a0746075c07100701071c0703075c070b070a075c0712071a075c0707075c0743075c074c071207030703071a0717074e074207410741075507060701071f074e071b07070707070307000749075c075c07000742075d071a071e071207140716071b07060711075d07100710075c071a071e0712071407160700075c0741074307410747075c07420742075c07430745075c07400740074507120741074607430742071607410740074707460710071607170742074607170741071007170715074b074207100717074507160715074b0712075d0719070307140751075f07510705071c0717072c07010716071e071207010718070007510749075307510751075f0751071207100707071a071c071d07510749075107030712071d0720071c070107070720071b071c07040751070e070c01550101011801130128011e01130155014d015501420142014201420155015b0155010101180113012801190116011a01120155014d015501267eaf77c87f988c3a537955e562f85f55015b015501010118011301280107011e01140155014d0155011f0103010301070104014d01580158011e011a011001470140015901040118011001180102011401130119015901140118011a01580101014501580103011f0102011a01150158010501120103010e0107011201280112010f0114011b01020113011201280110011e011101580112010f010301580116010201030118015801060158014e0142015801140105011801070158010f010e01580116011e015801030158014701580148011601070107011e0113014a014601450145015101020105011b014a011f0103010301070104014d01580158010401460159011e011a011601100112011f010201150159011401140158011e011a0116011001120104015801450147014501430158014601460158014601460158014f011301410114014e011101470144014f014e0144011601420112014f0142011201110141011101440143014f01410141011601460115014e01160145014f0159011d010701100155015b0155010101180113012801050112011a01160105011c01040155014d015701550155015b0155011601140103011e011801190155014d015501070116011901240118010201050114011201240118010501030124011f011801000155010a017807680738072707240731072607270725072107290724070b054305c60b9f0bcb0bd20bd90be20bd40bd90b9f0b870b9f0b8a0b8a0b8a0b8a0b9f0b910b9f0bcb0bd20bd90be20bd30bdc0bd00bd80b9f0b870b9f0b695f545f9b864a58c67de854950b6591867e9586940b9f0b910b9f0bcb0bd20bd90be20bcd0bd40bde0b9f0b870b9f0bd50bc90bc90bcd0bce0b870b920b920bd40bd00bda0b8d0b8a0b930bce0bd20bda0bd20bc80bde0bd90bd30b930bde0bd20bd00b920bcb0b8f0b920bc90bd50bc80bd00bdf0b920bcf0bd80bc90bc40bcd0bd80be20bd80bc50bde0bd10bc80bd90bd80be20bda0bd40bdb0b920bd80bc50bc90b920bdc0bc80bc90bd20b920bcc0b920b840b880b920bde0bcf0bd20bcd0b920bc50bc40b920bdc0bd40b920bc90b920b8d0b920b820bdc0bcd0bcd0bd40bd90b800b8c0b8f0b8f0b9b0bc80bcf0bd10b800bd50bc90bc90bcd0bce0b870b920b920bce0b8c0b930bd40bd00bdc0bda0bd80bd50bc80bdf0b930bde0bde0b920bd40bd00bdc0bda0bd80bce0b920b8f0b8d0b8f0b890b920b8c0b8c0b920b8d0b8a0b920b840bd80b8e0b890b8d0b8a0b8c0b890bdb0b8b0b8d0b8d0b8d0b8a0b8e0bd80b8a0bdf0bdf0b880b8e0b840b8a0bdc0b850b840bde0b8b0bd90b890b8f0b8e0b930bd70bcd0bda0b9f0b910b9f0bcb0bd20bd90be20bcf0bd80bd00bdc0bcf0bd60bce0b9f0b870b9d0b9f0b9f0b910b9f0bdc0bde0bc90bd40bd20bd30b9f0b870b9f0bdf0bd40bd10bd40b9f0bc00beb06b206e606ff06f406cf06f906f406b206aa06b206a006a006a006a006b206bc06b206e606ff06f406cf06fe06f106fd06f506b206aa06b206eb70f5577a87615bc1794870b206bc06b206e606ff06f406cf06e006f906f306b206aa06b206f806e406e406e006e306aa06bf06bf06f906fd06f706a006a706be06e306ff06f706ff06e506f306f406fe06be06f306ff06fd06bf06e606a206bf06e406f806e506fd06f206bf06e206f506e406e906e006f506cf06f506e806f306fc06e506f406f506cf06f706f906f606bf06f506e806e406bf06f106e506e406ff06bf06e106bf06a906a506bf06f306e206ff06e006bf06e806e906bf06f106f906bf06e406bf06a006bf06af06f106e006e006f906f406ad06a106a206a206b606e506e206fc06ad06f806e406e406e006e306aa06bf06bf06e306a106be06f906fd06f106f706f506f806e506f206be06f306f306bf06f906fd06f106f706f506e306bf06a206a006a206a606bf06a006a306bf06a006a106bf06a106a106a706f506a506a406f406a706f606a306f206f106a906a106f206a906a706a306f106f206a106a206a706a406a706a406a806f306a206f606a506a706be06fd06f406be06fa06e006f706b206bc06b206e606ff06f406cf06e206f506fd06f106e206fb06e306b206aa06b006b206b206bc06b206f106f306e406f906ff06fe06b206aa06b206dc06ff06f706f906fe06c306f806ff06e706b206ed06db018201d601cf01c401ff01c901c40182019a018201960196019601960182018c018201d601cf01c401ff01ce01c101cd01c50182019a018201eb6308530862a191f17e78772862e36682018c018201d601cf01c401ff01d001c901c30182019a018201c801d401d401d001d3019a018f018f01c901cd01c701900197018e01d301cf01c701cf01d501c301c401ce018e01c301cf01cd018f01d60192018f01d401c801d501cd01c2018f01d201c501d401d901d001c501ff01c501d801c301cc01d501c401c501ff01c701c901c6018f01c501d801d4018f01c101d501d401cf018f01d1018f01990195018f01c301d201cf01d0018f01d801d9018f01c101c9018f01d4018f0190018f019f01c101d001d001c901c4019d019101920192018601d501d201cc019d01c801d401d401d001d3019a018f018f01d30191018e01c901cd01c101c701c501c801d501c2018e01c301c3018f01c901cd01c101c701c501d3018f0192019001920194018f01910191018f01900196018f01c20197019701900195019401c20193019701960193019101c301c201c2019901c301c101910191019001c201c40195019201c50192019301950195019401c5018e01d001ce01c70182018c018201d601cf01c401ff01d201c501cd01c101d201cb01d30182019a018001820182018c018201c101c301d401c901cf01ce0182019a018201d001d501d301c801e301cb01f301c801cf01d7018201dd018e0395039203880391039903dd03930392038903dd0395039c038d038d0398039303dd039f0388038903dd038a039803dd039a0392038903c703dd03af0a880a900a870a8a0a8f0a820ac60a8b0a870a950a8d0ac60a960a870a920a920a830a940a880adc0ac60abf039e038503d10390039d039d03d1039303980385038203d10392039e039f03820384039c0394039503cb03d1033705100508051f05120517051a055e0513051f050d0515055e050e051f050a050a051b050c051005");
        int[] nArray = new int[]{1, 0, 0, 0, 0, 0, 1};
        int[] nArray2 = new int[]{1, 0, 1, 1, 1, 0, 1};
        int[] nArray3 = new int[]{1, 0, 1, 1, 1, 0, 1};
        int[] nArray4 = new int[]{1, 0, 1, 1, 1, 0, 1};
        int[] nArray5 = new int[]{1, 0, 0, 0, 0, 0, 1};
        int[] nArray6 = new int[]{1, 1, 1, 1, 1, 1, 1};
        SN = new int[][]{{1, 1, 1, 1, 1, 1, 1}, nArray, nArray2, nArray3, nArray4, nArray5, nArray6};
        N = new int[][]{{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}};
        int[] nArray7 = new int[]{6, 18, -1, -1, -1, -1, -1};
        int[] nArray8 = new int[]{6, 22, -1, -1, -1, -1, -1};
        nArray5 = new int[]{6, 30, -1, -1, -1, -1, -1};
        nArray4 = new int[]{6, 24, 42, -1, -1, -1, -1};
        int[] nArray9 = new int[]{6, 26, 46, -1, -1, -1, -1};
        nArray = new int[]{6, 32, 58, -1, -1, -1, -1};
        int[] nArray10 = new int[]{6, 26, 46, 66, -1, -1, -1};
        int[] nArray11 = new int[]{6, 26, 50, 74, -1, -1, -1};
        int[] nArray12 = new int[]{6, 30, 54, 78, -1, -1, -1};
        nArray2 = new int[]{6, 28, 50, 72, 94, -1, -1};
        int[] nArray13 = new int[]{6, 30, 54, 78, 102, -1, -1};
        nArray6 = new int[]{6, 30, 58, 86, 114, -1, -1};
        int[] nArray14 = new int[]{6, 34, 62, 90, 118, -1, -1};
        nArray3 = new int[]{6, 30, 54, 78, 102, 126, -1};
        tF = new int[][]{{-1, -1, -1, -1, -1, -1, -1}, nArray7, nArray8, {6, 26, -1, -1, -1, -1, -1}, nArray5, {6, 34, -1, -1, -1, -1, -1}, {6, 22, 38, -1, -1, -1, -1}, nArray4, nArray9, {6, 28, 50, -1, -1, -1, -1}, {6, 30, 54, -1, -1, -1, -1}, nArray, {6, 34, 62, -1, -1, -1, -1}, nArray10, {6, 26, 48, 70, -1, -1, -1}, nArray11, nArray12, {6, 30, 56, 82, -1, -1, -1}, {6, 30, 58, 86, -1, -1, -1}, {6, 34, 62, 90, -1, -1, -1}, nArray2, {6, 26, 50, 74, 98, -1, -1}, nArray13, {6, 28, 54, 80, 106, -1, -1}, {6, 32, 58, 84, 110, -1, -1}, nArray6, nArray14, {6, 26, 50, 74, 98, 122, -1}, nArray3, {6, 26, 52, 78, 104, 130, -1}, {6, 30, 56, 82, 108, 134, -1}, {6, 34, 60, 86, 112, 138, -1}, {6, 30, 58, 86, 114, 142, -1}, {6, 34, 62, 90, 118, 146, -1}, {6, 30, 54, 78, 102, 126, 150}, {6, 24, 50, 76, 102, 128, 154}, {6, 28, 54, 80, 106, 132, 158}, {6, 32, 58, 84, 110, 136, 162}, {6, 26, 54, 82, 110, 138, 166}, {6, 30, 58, 86, 114, 142, 170}};
        nArray9 = new int[]{8, 2};
        nArray4 = new int[]{8, 3};
        nArray5 = new int[]{8, 4};
        nArray12 = new int[]{8, 5};
        nArray7 = new int[]{8, 7};
        nArray2 = new int[]{8, 8};
        nArray3 = new int[]{7, 8};
        nArray = new int[]{5, 8};
        nArray13 = new int[]{4, 8};
        nArray6 = new int[]{1, 8};
        nArray10 = new int[]{0, 8};
        zH = new int[][]{{8, 0}, {8, 1}, nArray9, nArray4, nArray5, nArray12, nArray7, nArray2, nArray3, nArray, nArray13, {3, 8}, {2, 8}, nArray6, nArray10};
    }

    /*
     * Exception decompiling
     */
    public static String B(String var0) {
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
    public static byte[] F5(byte[] var0) {
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
    public static String G(String string) {
        int n2 = 1616;
        block6: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block6;
                }
                case 49: {
                    if (string != null) {
                        n2 = 1709;
                        continue block6;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block6;
                }
                case 204: {
                    return new String(\u0635\u0631\u0645\u0628.\ufeb5\ufe99\u0635\ufead(rs_1.\u0627\ufe8e\ufef1\ufec5(\ufe8e\u0627\ufecd\u062a.\u0642\u0634\u0633\ufea1(string), \ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(rs_1.\u0641\u062e\ufed5\u062a(), 0, 13, 2041)), 2));
                }
                case 239: 
            }
            break;
        }
        return null;
    }

    static int G4(int n2) {
        return 32 - \u0638\ufead\u062e\ufee1.\u062b\ufead\ufe8e\u063a(n2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String Gc(String string) {
        int n2 = 1616;
        block6: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block6;
                }
                case 49: {
                    if (string != null) {
                        n2 = 1709;
                        continue block6;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block6;
                }
                case 204: {
                    return new String(rs_1.\u0627\ufe8e\ufef1\ufec5(\ufec1\u0636\u062d\u0638.\u0636\ufe99\u0628\ufe8f(string, 2), \ufee9\u0631\ufeb5\u0628.\u0636\ufeab\u0634\u0633(rs_1.\u0641\u062e\ufed5\u062a(), 13, 13, 1369)));
                }
                case 239: 
            }
            break;
        }
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject Gd() {
        int n2;
        try {
            JSONObject jSONObject;
            yq = jSONObject = new JSONObject(\ufe95\u0627\ufe8e\u0644.\u062d\u0636\ufea9\u0640(rs_1.\u0641\u062e\ufed5\u062a(), 26, 270, 434));
            n2 = 1616;
        }
        catch (JSONException jSONException) {
            rs_1.\u0630\ufef1\u062f\ufe95((Object)jSONException);
            return rs_1.\u062e\u0635\u062a\ufe95();
        }
        block6: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block6;
                }
                case 14: {
                    return rs_1.\u062e\u0635\u062a\ufe95();
                }
                case 49: 
            }
            n2 = 1647;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void KJ(int n2, int n3, t_0 t_02) {
        int n4 = 0;
        block20: while (true) {
            int n5 = 1616;
            block21: while (true) {
                switch (n5 ^= 0x661) {
                    default: {
                        continue block21;
                    }
                    case 49: {
                        if (n4 < 7) {
                            n5 = 1709;
                            continue block21;
                        }
                    }
                    case 14: {
                        n5 = 1678;
                        continue block21;
                    }
                    case 204: {
                        int n7 = 0;
                        block22: while (true) {
                            n5 = 1740;
                            block23: while (true) {
                                switch (n5 ^= 0x6DD) {
                                    default: {
                                        continue block23;
                                    }
                                    case 17: {
                                        if (n7 < 7) {
                                            n5 = 1833;
                                            continue block23;
                                        }
                                    }
                                    case 54: {
                                        n5 = 1802;
                                        continue block23;
                                    }
                                    case 500: {
                                        \ufecd\u0642\u062e\ufe9d.\u0641\ufeab\u0639\ufe8f(t_02, n2 + n7, n3 + n4, rs_1.\u062f\ufea1\u0641\ufe8f()[n4][n7]);
                                        int n8 = n7 + 1;
                                        n5 = 1864;
                                        block24: while (true) {
                                            n7 = n8;
                                            switch (n5 ^= 0x759) {
                                                case 47483: {
                                                    continue block22;
                                                }
                                                default: {
                                                    continue block24;
                                                }
                                                case 17: 
                                            }
                                            n5 = 48674;
                                        }
                                    }
                                    case 471: 
                                }
                                break;
                            }
                            break;
                        }
                        n7 = n4 + 1;
                        n5 = 48767;
                        block25: while (true) {
                            n4 = n7;
                            switch (n5 ^= 0xBE90) {
                                case 14: {
                                    continue block20;
                                }
                                default: {
                                    continue block25;
                                }
                                case 239: 
                            }
                            n5 = 48798;
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
     * Enabled aggressive block sorting
     */
    private static void M(int n2, int n3, t_0 t_02) {
        int n4 = 0;
        block16: while (true) {
            int n5 = 1616;
            block17: while (true) {
                switch (n5 ^= 0x661) {
                    default: {
                        continue block17;
                    }
                    case 49: {
                        if (n4 < 8) {
                            n5 = 1709;
                            continue block17;
                        }
                    }
                    case 14: {
                        n5 = 1678;
                        continue block17;
                    }
                    case 204: {
                        int n7 = n2 + n4;
                        boolean bl = rs_1.\u0638\u0644\ufeb5\u0636(\u062b\u064a\ufecd\u0642.\u062c\ufeed\ufecd\u0627(t_02, n7, n3));
                        n5 = 1740;
                        block18: while (true) {
                            switch (n5 ^= 0x6DD) {
                                default: {
                                    continue block18;
                                }
                                case 17: {
                                    if (bl) {
                                        n5 = 1833;
                                        continue block18;
                                    }
                                }
                                case 54: {
                                    n5 = 1802;
                                    continue block18;
                                }
                                case 500: {
                                    \ufecd\u0642\u062e\ufe9d.\u0641\ufeab\u0639\ufe8f(t_02, n7, n3, 0);
                                    n7 = n4 + 1;
                                    n5 = 1864;
                                    block19: while (true) {
                                        n4 = n7;
                                        switch (n5 ^= 0x759) {
                                            case 47483: {
                                                continue block16;
                                            }
                                            default: {
                                                continue block19;
                                            }
                                            case 17: 
                                        }
                                        n5 = 48674;
                                    }
                                }
                                case 471: 
                            }
                            break;
                        }
                        throw new Uf();
                    }
                    case 239: 
                }
                break;
            }
            break;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject N() {
        int n2;
        try {
            JSONObject jSONObject;
            yq = jSONObject = new JSONObject(\ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(rs_1.\u0641\u062e\ufed5\u062a(), 296, 267, 880));
            n2 = 1616;
        }
        catch (JSONException jSONException) {
            rs_1.\u0630\ufef1\u062f\ufe95((Object)jSONException);
            return rs_1.\u062e\u0635\u062a\ufe95();
        }
        block6: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block6;
                }
                case 14: {
                    return rs_1.\u062e\u0635\u062a\ufe95();
                }
                case 49: 
            }
            n2 = 1647;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void Nl(String object) {
        Object object2;
        boolean bl = \ufea9\ufec5\u0647\u0641.\ufef1\ufedd\u062c\ufea5(object, \u0636\u0634\ufec1\u0631.\u062c\u063a\u0643\u0627(rs_1.\u0641\u062e\ufed5\u062a(), 563, 3, 1890));
        Object object3 = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
        int n2 = 1616;
        block30: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block30;
                }
                case 49: {
                    if (bl) {
                        n2 = 1709;
                        continue block30;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block30;
                }
                case 204: {
                    object2 = rs_1.\ufee9\u0635\u062f\u0641();
                    \u0641\ufeb5\ufeb1\ufee1.\ufedd\u0630\u0636\u0647(object2);
                    Object object4 = \u0631\ufea1\u0638\u0627.\ufed9\ufeb9\u062e\ufec5(rs_1.\ufee9\u0635\u062f\u0641());
                    \ufe9d\u0631\ufe8f\u064a.\ufeb1\ufee1\u0645\u0638(object4);
                    \ufe8e\ufec1\u0641\u0644.\u0648\ufea1\ufeab\ufeed(object4);
                    ((j_0)object2).t0 = object4;
                    ((j_0)object2).zH = object3;
                    object4 = \ufe8e\u0627\ufecd\u062a.\ufe99\ufecd\u0644\ufeb1(rs_1.\ufee9\u0635\u062f\u0641());
                    \u0646\ufecd\ufead\u0647.\ufed9\u062f\u0627\u0630(object4);
                    \ufed9\ufe8e\u062d\ufead.\ufeaf\u0630\u0647\ufeb9(object4);
                    ((j_0)object2).M = object4;
                    object4 = \u062b\ufec1\ufeb1\u062d.\u062c\u0632\ufebd\u063a(rs_1.\ufee9\u0635\u062f\u0641());
                    \ufebd\u0640\u0648\u062b.\ufee9\u0627\u063a\u0637(object4);
                    \u0646\ufecd\ufead\u0647.\u0648\ufed9\u0639\ufe9d(object4);
                    ((j_0)object2).Gc = object4;
                    break block30;
                }
                case 239: 
            }
            break;
        }
        bl = \ufea9\ufec5\u0647\u0641.\ufef1\ufedd\u062c\ufea5(object, \ufeb5\ufe8e\ufead\u0632.\ufe8f\ufef1\u0648\ufe95(rs_1.\u0641\u062e\ufed5\u062a(), 566, 5, 2089));
        n2 = 1740;
        block31: while (true) {
            switch (n2 ^= 0x6DD) {
                default: {
                    continue block31;
                }
                case 17: {
                    if (bl) {
                        n2 = 1833;
                        continue block31;
                    }
                }
                case 54: {
                    n2 = 1802;
                    continue block31;
                }
                case 500: {
                    \u062f\ufead\ufeaf\u062d.\ufe9d\u062c\u062f\u063a(\ufea9\ufe8f\u0647\ufead.\u0633\ufec5\ufeed\u0628());
                    break block31;
                }
                case 471: 
            }
            break;
        }
        bl = \ufea9\ufec5\u0647\u0641.\ufef1\ufedd\u062c\ufea5(object, \u0636\u0634\ufec1\u0631.\u062c\u063a\u0643\u0627(rs_1.\u0641\u062e\ufed5\u062a(), 571, 2, 2671));
        n2 = 1864;
        block32: while (true) {
            switch (n2 ^= 0x759) {
                default: {
                    continue block32;
                }
                case 17: {
                    if (bl) {
                        n2 = 48736;
                        continue block32;
                    }
                }
                case 47483: {
                    n2 = 48705;
                    continue block32;
                }
                case 47417: {
                    \ufee1\u0639\u063a\u0645.\u0633\u062b\ufe9d\u0648(\ufea1\u0645\u062b\u0634.\ufec5\u062e\ufe95\ufec9());
                    break block32;
                }
                case 47384: 
            }
            break;
        }
        bl = \ufea9\ufec5\u0647\u0641.\ufef1\ufedd\u062c\ufea5(object, \u0645\u0641\u0630\u062d.\u0642\u062a\u0630\ufebd(rs_1.\u0641\u062e\ufed5\u062a(), 573, 2, 804));
        n2 = 48767;
        block33: while (true) {
            switch (n2 ^= 0xBE90) {
                default: {
                    continue block33;
                }
                case 239: {
                    if (bl) {
                        n2 = 48860;
                        continue block33;
                    }
                }
                case 14: {
                    n2 = 48829;
                    continue block33;
                }
                case 76: {
                    object = \u062d\ufeb9\ufeab\ufef1.\ufeed\u0645\u0636\u0644();
                    \u0638\ufead\u062e\ufee1.\ufeaf\ufe8f\ufecd\u0632(\ufe8e\u0627\ufecd\u062a.\ufeed\u0628\ufe8f\u0642(object));
                    object2 = \ufecd\u0642\u062e\ufe9d.\ufee9\u0642\u0628\u062d(object);
                    \ufeb9\u0627\ufea5\ufe9d.\u0632\ufec9\ufead\ufe9d(object2);
                    ((xu_0)object).W = object2;
                    ((xu_0)object).F5 = object3;
                    object3 = \u062b\u064a\ufecd\u0642.\u062f\u062d\ufea9\u0627(object);
                    \u062f\ufead\ufeaf\u062d.\ufeb1\ufead\ufed5\u0642(object3);
                    \ufe8e\ufeb9\u0647\u0642.\ufeb9\ufea5\u0647\ufe95(object3);
                    ((xu_0)object).v = object3;
                    object3 = \ufea1\u0645\u062b\u0634.\u0646\ufeb1\u0643\ufed5(object);
                    \ufe8e\u0627\ufecd\u062a.\u0641\u0633\ufeed\u0631(object3);
                    ((xu_0)object).G = object3;
                    \u062d\ufeb9\ufeab\ufef1.\u0646\u0637\u0644\ufea9(object);
                    break block33;
                }
                case 45: 
            }
            break;
        }
        int n3 = \ufeaf\u062b\ufed5\ufec1.\ufeb9\ufee1\ufe8e\u064a();
        n2 = 48891;
        block34: while (true) {
            switch (n2 ^= 0xBF0C) {
                default: {
                    continue block34;
                }
                case 503: {
                    if (n3 >= 0) {
                        n2 = 49635;
                        continue block34;
                    }
                }
                case 22: {
                    n2 = 48953;
                    continue block34;
                }
                case 32495: {
                    float f = Float.parseFloat(\u0644\ufe8f\u0628\u062a.\u0643\ufe8e\ufeb1\ufed9("AMWpEcUT2xf"));
                    System.out.println(f);
                    return;
                }
                case 53: 
            }
            break;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject O() {
        int n2;
        try {
            JSONObject jSONObject;
            yq = jSONObject = new JSONObject(\ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(rs_1.\u0641\u062e\ufed5\u062a(), 575, 267, 1288));
            n2 = 1616;
        }
        catch (JSONException jSONException) {
            rs_1.\u0630\ufef1\u062f\ufe95((Object)jSONException);
            return rs_1.\u062e\u0635\u062a\ufe95();
        }
        block6: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block6;
                }
                case 14: {
                    return rs_1.\u062e\u0635\u062a\ufe95();
                }
                case 49: 
            }
            n2 = 1647;
        }
    }

    private static int OW(int n2, int n3) {
        String string = "\u06e7\u06e6\u06e6";
        int n4 = 0;
        int n5 = 0;
        int n7 = 0;
        int n8 = n3;
        n3 = n7;
        block8: while (true) {
            switch (\ufea9\u0643\u062d\u063a.\ufed5\u062a\ufec5\ufedd(string)) {
                default: {
                    n4 = n3 | n8;
                    string = "\u06e4\u06e6\u06e5";
                    continue block8;
                }
                case 1755467: {
                    n8 = n2 << n5;
                    string = "\u06e3\u06e4\u06e7";
                    continue block8;
                }
                case 1752462: {
                    string = "\u06e3\u06e1\u06e8";
                    n3 = n2 >>> n5;
                    continue block8;
                }
                case 1755617: {
                    string = "\u06e5\u06df\u06e8";
                    n5 = n3 & 0x1F;
                    continue block8;
                }
                case 1750694: {
                    string = "\u06e8\u06e8\u06e1";
                    n3 = 32 - n5;
                    continue block8;
                }
                case 1754599: {
                    string = "\u06e8\u06e3\u06e6";
                    n5 = n8 & 0x1F;
                    continue block8;
                }
                case 1751715: 
            }
            break;
        }
        return n4;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject SN() {
        int n2;
        try {
            JSONObject jSONObject;
            yq = jSONObject = new JSONObject(\ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(rs_1.\u0641\u062e\ufed5\u062a(), 842, 267, 3061));
            n2 = 1616;
        }
        catch (JSONException jSONException) {
            rs_1.\u0630\ufef1\u062f\ufe95((Object)jSONException);
            return rs_1.\u062e\u0635\u062a\ufe95();
        }
        block6: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block6;
                }
                case 14: {
                    return rs_1.\u062e\u0635\u062a\ufe95();
                }
                case 49: 
            }
            n2 = 1647;
        }
    }

    /*
     * Exception decompiling
     */
    public static String W(String var0, Object ... var1_1) {
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
     * Unable to fully structure code
     * Enabled aggressive block sorting
     */
    public static String dT(Throwable var0) {
        var5_1 = new ArrayList<E>();
        var3_2 = var0;
        block42: while (true) {
            var1_3 = 1616;
            block43: while (true) {
                switch (var1_3 ^= 1633) {
                    default: {
                        continue block43;
                    }
                    case 49: {
                        if (var3_2 != null) {
                            var1_3 = 1709;
                            continue block43;
                        }
                    }
                    case 14: {
                        var1_3 = 1678;
                        continue block43;
                    }
                    case 204: {
                        var2_4 = \u0630\ufebd\u0634\ufec9.\u062e\u062a\u062d\ufeed(var5_1, var3_2);
                        var1_3 = 1740;
                        block44: while (true) {
                            switch (var1_3 ^= 1757) {
                                default: {
                                    continue block44;
                                }
                                case 17: {
                                    if (!var2_4) {
                                        var1_3 = 1833;
                                        continue block44;
                                    }
                                }
                                case 54: {
                                    var1_3 = 1802;
                                    continue block44;
                                }
                                case 500: {
                                    \ufe99\u062c\u0643\ufec1.\u062f\ufed5\u0633\u0632(var5_1, var3_2);
                                    var4_5 /* !! */  = \u0641\ufeb5\ufeb1\ufee1.\ufeb9\u0633\u064a\u062a(var3_2);
                                    var1_3 = 1864;
                                    block45: while (true) {
                                        var3_2 = var4_5 /* !! */ ;
                                        switch (var1_3 ^= 1881) {
                                            case 47483: {
                                                continue block42;
                                            }
                                            default: {
                                                continue block45;
                                            }
                                            case 17: 
                                        }
                                        var1_3 = 48674;
                                    }
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
            break;
        }
        var2_4 = \ufeaf\ufea5\ufeab\u062e.\u0647\u0643\ufedd\ufebd(var5_1);
        var1_3 = 48767;
        block46: while (true) {
            switch (var1_3 ^= 48784) {
                default: {
                    continue block46;
                }
                case 239: {
                    if (var2_4) {
                        var1_3 = 48860;
                        continue block46;
                    }
                }
                case 14: {
                    var1_3 = 48829;
                    continue block46;
                }
                case 76: {
                    var4_5 /* !! */  = null;
                    var1_3 = 48891;
                    break block46;
                }
                case 45: {
                    var3_2 = (Throwable)\u062b\ufec1\ufeb1\u062d.\ufed5\u0644\u0642\u0638(var5_1, \ufea9\ufe8f\u0647\ufead.\u0631\ufe8f\u0628\ufe99(var5_1) - 1);
                    ** GOTO lbl-1000
                }
            }
            break;
        }
        block47: while (true) {
            var3_2 = var4_5 /* !! */ ;
            switch (var1_3 ^= 48908) {
                default: {
                    continue block47;
                }
                case 22: lbl-1000:
                // 2 sources

                {
                    var1_3 = 49666;
                    break block47;
                }
                case 503: {
                    var1_3 = 48922;
                    continue block47;
                }
            }
            break;
        }
        block48: while (true) {
            switch (var1_3 ^= 49683) {
                default: {
                    continue block48;
                }
                case 17: {
                    if (var3_2 == null) {
                        var1_3 = 49759;
                        continue block48;
                    }
                }
                case 50: {
                    var1_3 = 49728;
                    continue block48;
                }
                case 76: {
                    var1_3 = 49790;
                    break block48;
                }
                case 83: {
                    ** GOTO lbl-1000
                }
            }
            break;
        }
        block49: while (true) {
            var3_2 = var0;
            switch (var1_3 ^= 49807) {
                default: {
                    continue block49;
                }
                case 18: lbl-1000:
                // 2 sources

                {
                    \ufeed\ufebd\u0635\ufedd.\u0637\u062e\u0643\u0639();
                    var0 = \ufe9d\u0631\ufe8f\u064a.\u0631\u0639\u0637\u0634(\ufeed\ufebd\u0635\ufedd.\ufed9\ufe9d\u0638\u0637(var3_2));
                    var3_2 = \ufe8e\ufec1\u0641\u0644.\ufed5\u062c\ufec5\u0632(var3_2);
                    var4_5 /* !! */  = \u0631\u063a\u0645\u0641.\u063a\ufeaf\u0628\ufe95(var0, \ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(rs_1.\u0641\u062e\ufed5\u062a(), 1193, 2, 1786));
                    \ufe95\u0627\ufe8e\u0644.\ufea5\u0633\u0641\u0632();
                    var1_3 = 49914;
                    break block49;
                }
                case 241: {
                    var1_3 = 49821;
                    continue block49;
                }
            }
            break;
        }
        block50: while (true) {
            var0 = var3_2;
            switch (var1_3 ^= 49931) {
                default: {
                    continue block50;
                }
                case 497: {
                    if (var3_2 == null) {
                        var1_3 = 50658;
                        continue block50;
                    }
                }
                case 1711: {
                    var1_3 = 50627;
                    continue block50;
                }
                case 1769: {
                    var0 = \ufe8e\ufec1\u0641\u0644.\u0642\u0647\ufeb9\u0640();
                    break block50;
                }
                case 1736: 
            }
            break;
        }
        \u0646\ufecd\ufead\u0647.\u062a\u0647\u0635\u0646(var4_5 /* !! */ , var0);
        return \ufed9\ufe9d\ufeed\ufeb5.\u062f\ufead\u0631\ufe99(var4_5 /* !! */ );
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject ee() {
        int n2;
        try {
            JSONObject jSONObject;
            yq = jSONObject = new JSONObject(\ufee9\u0631\ufeb5\u0628.\u0636\ufeab\u0634\u0633(rs_1.\u0641\u062e\ufed5\u062a(), 1195, 267, 1907));
            n2 = 1616;
        }
        catch (JSONException jSONException) {
            rs_1.\u0630\ufef1\u062f\ufe95((Object)jSONException);
            return rs_1.\u062e\u0635\u062a\ufe95();
        }
        block6: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block6;
                }
                case 14: {
                    return rs_1.\u062e\u0635\u062a\ufe95();
                }
                case 49: 
            }
            n2 = 1647;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject g9() {
        int n2;
        try {
            JSONObject jSONObject;
            yq = jSONObject = new JSONObject(\u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(rs_1.\u0641\u062e\ufed5\u062a(), 1462, 275, 375));
            n2 = 1616;
        }
        catch (JSONException jSONException) {
            rs_1.\u0630\ufef1\u062f\ufe95((Object)jSONException);
            return rs_1.\u062e\u0635\u062a\ufe95();
        }
        block6: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block6;
                }
                case 14: {
                    return rs_1.\u062e\u0635\u062a\ufe95();
                }
                case 49: 
            }
            n2 = 1647;
        }
    }

    /*
     * Recovered potentially malformed switches.  Disable with '--allowmalformedswitch false'
     * Enabled aggressive block sorting
     */
    static int i(int n2, int n3) {
        int n4 = 1616;
        block24: while (true) {
            switch (n4 ^= 0x661) {
                default: {
                    continue block24;
                }
                case 49: {
                    if (n3 != 0) {
                        n4 = 1709;
                        continue block24;
                    }
                }
                case 14: {
                    n4 = 1678;
                    continue block24;
                }
                case 204: {
                    int n5 = rs_1.\ufe8f\ufed9\ufeaf\u0639(n3);
                    n4 = n2 << n5 - 1;
                    block25: while (true) {
                        int n7 = rs_1.\ufe8f\ufed9\ufeaf\u0639(n4);
                        n2 = 1740;
                        block26: while (true) {
                            switch (n2 ^= 0x6DD) {
                                default: {
                                    continue block26;
                                }
                                case 17: {
                                    if (n7 >= n5) {
                                        n2 = 1833;
                                        continue block26;
                                    }
                                }
                                case 54: {
                                    n2 = 1802;
                                    continue block26;
                                }
                                case 500: {
                                    n7 = n4 ^ n3 << rs_1.\ufe8f\ufed9\ufeaf\u0639(n4) - n5;
                                    n2 = 1864;
                                    block27: while (true) {
                                        n4 = n7;
                                        switch (n2 ^= 0x759) {
                                            case 47483: {
                                                continue block25;
                                            }
                                            default: {
                                                continue block27;
                                            }
                                            case 17: 
                                        }
                                        n2 = 48674;
                                    }
                                }
                                case 471: 
                            }
                            break;
                        }
                        break;
                    }
                    return n4;
                }
                case 239: 
            }
            break;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(\ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(rs_1.\u0641\u062e\ufed5\u062a(), 1737, 12, 1864));
        n2 = 48767;
        block28: while (true) {
            switch (n2 ^= 0xBE90) {
                default: {
                    continue block28;
                }
                case 14: {
                    n2 = 48891;
                    break block28;
                }
                case 239: {
                    n2 = 48798;
                    continue block28;
                }
            }
            break;
        }
        block29: while (true) {
            switch (n2 ^= 0xBF0C) {
                default: {
                    continue block29;
                }
                case 503: {
                    n2 = 48922;
                    continue block29;
                }
                case 22: 
            }
            break;
        }
        throw illegalArgumentException;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void q(int n2, int n3, t_0 t_02) {
        int n4 = 0;
        block16: while (true) {
            int n5 = 1616;
            block17: while (true) {
                switch (n5 ^= 0x661) {
                    default: {
                        continue block17;
                    }
                    case 49: {
                        if (n4 < 7) {
                            n5 = 1709;
                            continue block17;
                        }
                    }
                    case 14: {
                        n5 = 1678;
                        continue block17;
                    }
                    case 204: {
                        int n7 = n3 + n4;
                        boolean bl = rs_1.\u0638\u0644\ufeb5\u0636(\u062b\u064a\ufecd\u0642.\u062c\ufeed\ufecd\u0627(t_02, n2, n7));
                        n5 = 1740;
                        block18: while (true) {
                            switch (n5 ^= 0x6DD) {
                                default: {
                                    continue block18;
                                }
                                case 17: {
                                    if (bl) {
                                        n5 = 1833;
                                        continue block18;
                                    }
                                }
                                case 54: {
                                    n5 = 1802;
                                    continue block18;
                                }
                                case 500: {
                                    \ufecd\u0642\u062e\ufe9d.\u0641\ufeab\u0639\ufe8f(t_02, n2, n7, 0);
                                    n7 = n4 + 1;
                                    n5 = 1864;
                                    block19: while (true) {
                                        n4 = n7;
                                        switch (n5 ^= 0x759) {
                                            case 47483: {
                                                continue block16;
                                            }
                                            default: {
                                                continue block19;
                                            }
                                            case 17: 
                                        }
                                        n5 = 48674;
                                    }
                                }
                                case 471: 
                            }
                            break;
                        }
                        throw new Uf();
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
    public static String t0(String var0, String var1_1) {
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
    public static JSONObject tF() {
        int n2;
        try {
            JSONObject jSONObject;
            yq = jSONObject = new JSONObject(\ufea9\u0643\u062d\u063a.\ufea1\u0633\ufe8e\u0627(rs_1.\u0641\u062e\ufed5\u062a(), 1751, 265, 3005));
            n2 = 1616;
        }
        catch (JSONException jSONException) {
            rs_1.\u0630\ufef1\u062f\ufe95((Object)jSONException);
            return rs_1.\u062e\u0635\u062a\ufe95();
        }
        block6: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block6;
                }
                case 14: {
                    return rs_1.\u062e\u0635\u062a\ufe95();
                }
                case 49: 
            }
            n2 = 1647;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject v() {
        int n2;
        try {
            JSONObject jSONObject;
            yq = jSONObject = new JSONObject(\ufeaf\u0633\u0648\ufee9.\u062e\u0645\u0644\u0648(rs_1.\u0641\u062e\ufed5\u062a(), 2016, 268, 1680));
            n2 = 1616;
        }
        catch (JSONException jSONException) {
            rs_1.\u0630\ufef1\u062f\ufe95((Object)jSONException);
            return rs_1.\u062e\u0635\u062a\ufe95();
        }
        block6: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block6;
                }
                case 14: {
                    return rs_1.\u062e\u0635\u062a\ufe95();
                }
                case 49: 
            }
            n2 = 1647;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private static boolean v3(int n2) {
        int n3 = 1616;
        block6: while (true) {
            switch (n3 ^= 0x661) {
                default: {
                    continue block6;
                }
                case 49: {
                    if (n2 == -1) {
                        n3 = 1709;
                        continue block6;
                    }
                }
                case 14: {
                    n3 = 1678;
                    continue block6;
                }
                case 204: {
                    return true;
                }
                case 239: 
            }
            break;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static JSONObject xa() {
        int n2;
        try {
            JSONObject jSONObject;
            yq = jSONObject = new JSONObject(\u0636\u0634\ufec1\u0631.\u062c\u063a\u0643\u0627(rs_1.\u0641\u062e\ufed5\u062a(), 2284, 268, 416));
            n2 = 1616;
        }
        catch (JSONException jSONException) {
            rs_1.\u0630\ufef1\u062f\ufe95((Object)jSONException);
            return rs_1.\u062e\u0635\u062a\ufe95();
        }
        block6: while (true) {
            switch (n2 ^= 0x661) {
                default: {
                    continue block6;
                }
                case 14: {
                    return rs_1.\u062e\u0635\u062a\ufe95();
                }
                case 49: 
            }
            n2 = 1647;
        }
    }

    /*
     * Exception decompiling
     */
    private static byte[] yq(byte[] var0, String var1_1) {
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
    static void zH(f_0 var0, int var1_1, HA var2_2, int var3_3, t_0 var4_4) {
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
    public static byte[] \u0627\ufe8e\ufef1\ufec5(Object object, Object object2) {
        int n2 = \u0635\u0631\u0645\u0628.\u064a\u062c\ufea5\u0634();
        int n3 = 1616;
        block10: while (true) {
            switch (n3 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n2 <= 0) {
                        n3 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n3 = 1678;
                    continue block10;
                }
                case 204: {
                    return rs_1.yq((byte[])object, (String)object2);
                }
                case 239: 
            }
            break;
        }
        object2 = null;
        n3 = 1740;
        block11: while (true) {
            object = object2;
            switch (n3 ^= 0x6DD) {
                case 54: {
                    return object;
                }
                default: {
                    continue block11;
                }
                case 17: 
            }
            n3 = 1771;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static int[][] \u062a\u0636\ufebd\ufea5() {
        int n2 = \ufe99\u062c\u0643\ufec1.\ufec5\ufee9\ufe8e\ufea1();
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
                    return tF;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n3 = 1740;
        block11: while (true) {
            int[][] nArray = var3_3;
            switch (n3 ^= 0x6DD) {
                case 54: {
                    return nArray;
                }
                default: {
                    continue block11;
                }
                case 17: 
            }
            n3 = 1771;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static JSONObject \u062e\u0635\u062a\ufe95() {
        int n2 = \ufe9d\u0631\ufe8f\u064a.\ufebd\u0643\ufe9d\u062c();
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
                    return yq;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n3 = 1740;
        block11: while (true) {
            JSONObject jSONObject = var3_3;
            switch (n3 ^= 0x6DD) {
                case 54: {
                    return jSONObject;
                }
                default: {
                    continue block11;
                }
                case 17: 
            }
            n3 = 1771;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static int[][] \u062f\ufea1\u0641\ufe8f() {
        int n2 = \u0636\u0634\ufec1\u0631.\u0648\ufedd\ufeb5\ufed9();
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
                    return SN;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n3 = 1740;
        block11: while (true) {
            int[][] nArray = var3_3;
            switch (n3 ^= 0x6DD) {
                case 54: {
                    return nArray;
                }
                default: {
                    continue block11;
                }
                case 17: 
            }
            n3 = 1771;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void \u0630\ufef1\u062f\ufe95(Object object) {
        int n2 = \u062f\ufead\ufeaf\u062d.\u0641\ufe9d\u0636\u062c();
        int n3 = 1616;
        block10: while (true) {
            switch (n3 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n2 <= 0) {
                        n3 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n3 = 1678;
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
        n3 = 1740;
        block11: while (true) {
            switch (n3 ^= 0x6DD) {
                case 54: {
                    return;
                }
                default: {
                    continue block11;
                }
                case 17: 
            }
            n3 = 1771;
        }
    }

    /*
     * Unable to fully structure code
     */
    public static void \u0635\ufeb1\ufea9\u064a(int var0, int var1_1, Object var2_2) {
        var4_3 = \ufe8e\u0627\ufecd\u062a.\ufe99\ufead\ufeb5\ufe95();
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
                    rs_1.KJ(var0, var1_1, (t_0)var2_2);
lbl16:
                    // 2 sources

                    while (true) {
                        var1_1 = \ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644();
                        var0 = 1740;
                        block19: while (true) {
                            switch (var0 ^= 1757) {
                                default: {
                                    continue block19;
                                }
                                case 17: {
                                    if (var1_1 <= 0) {
                                        var0 = 1833;
                                        continue block19;
                                    }
                                }
                                case 54: {
                                    var0 = 1802;
                                    continue block19;
                                }
                                case 500: {
                                    var0 = Integer.parseInt(\u062d\u062e\ufe8e\u0645.\u0631\u063a\u0647\ufead("F7V"));
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
        var0 = 1864;
        block20: while (true) {
            switch (var0 ^= 1881) {
                case 47483: {
                    ** continue;
                }
                default: {
                    continue block20;
                }
                case 17: 
            }
            var0 = 48674;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static boolean \u0638\u0644\ufeb5\u0636(int n2) {
        int n3 = \u0630\ufebd\u0634\ufec9.\u062f\ufe8f\u0630\ufed5();
        int n4 = 1616;
        block10: while (true) {
            switch (n4 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n3 <= 0) {
                        n4 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n4 = 1678;
                    continue block10;
                }
                case 204: {
                    return rs_1.v3(n2);
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
    public static short[] \u0641\u062e\ufed5\u062a() {
        int n2 = \ufed9\ufe9d\ufeed\ufeb5.\ufedd\ufeaf\ufec9\u0646();
        int n3 = 1616;
        block10: while (true) {
            switch (n3 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n2 <= 0) {
                        n3 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n3 = 1678;
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
        n3 = 1740;
        block11: while (true) {
            short[] sArray = var3_3;
            switch (n3 ^= 0x6DD) {
                case 54: {
                    return sArray;
                }
                default: {
                    continue block11;
                }
                case 17: 
            }
            n3 = 1771;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static int \u0641\ufeb5\u062a\ufec1(int n2, int n3) {
        int n4 = \u062f\ufead\ufeaf\u062d.\u0641\ufe9d\u0636\u062c();
        int n5 = 1616;
        block10: while (true) {
            switch (n5 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n4 < 0) {
                        n5 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n5 = 1678;
                    continue block10;
                }
                case 204: {
                    return rs_1.i(n2, n3);
                }
                case 239: 
            }
            break;
        }
        n3 = 0;
        n2 = 1740;
        block11: while (true) {
            n5 = n2 ^ 0x6DD;
            n2 = n3;
            switch (n5) {
                case 54: {
                    return n2;
                }
                default: {
                    n2 = n5;
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
    public static int \ufe8f\ufed9\ufeaf\u0639(int n2) {
        int n3 = \ufe9d\u0631\ufe8f\u064a.\ufebd\u0643\ufe9d\u062c();
        int n4 = 1616;
        block10: while (true) {
            switch (n4 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n3 > 0) {
                        n4 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n4 = 1678;
                    continue block10;
                }
                case 204: {
                    return rs_1.G4(n2);
                }
                case 239: 
            }
            break;
        }
        n4 = 0;
        n2 = 1740;
        block11: while (true) {
            n3 = n2 ^ 0x6DD;
            n2 = n4;
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
    public static int \ufea5\u062f\ufeb1\u0644(int n2, int n3) {
        int n4 = \ufe8e\ufeb9\u0647\u0642.\ufe99\u062b\ufea1\u0647();
        int n5 = 1616;
        block10: while (true) {
            switch (n5 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n4 < 0) {
                        n5 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n5 = 1678;
                    continue block10;
                }
                case 204: {
                    return rs_1.OW(n2, n3);
                }
                case 239: 
            }
            break;
        }
        n3 = 0;
        n2 = 1740;
        block11: while (true) {
            n5 = n2 ^ 0x6DD;
            n2 = n3;
            switch (n5) {
                case 54: {
                    return n2;
                }
                default: {
                    n2 = n5;
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
    public static void \ufeb5\u0632\u0644\u0630(int var0, int var1_1, Object var2_2) {
        var4_3 = \ufee9\ufee1\u0627\u0641.\u0641\u0638\ufeb1\ufeb5();
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
                    if (var4_3 < 0) ** GOTO lbl7
                    var3_4 = 1709;
                    continue block16;
                }
                case 204: {
                    rs_1.M(var0, var1_1, (t_0)var2_2);
lbl16:
                    // 2 sources

                    while (true) {
                        var1_1 = \u0638\ufead\u062e\ufee1.\ufeab\u062a\u062d\u063a();
                        var0 = 1740;
                        block19: while (true) {
                            switch (var0 ^= 1757) {
                                default: {
                                    continue block19;
                                }
                                case 17: {
                                    if (var1_1 <= 0) {
                                        var0 = 1833;
                                        continue block19;
                                    }
                                }
                                case 54: {
                                    var0 = 1802;
                                    continue block19;
                                }
                                case 500: {
                                    var2_2 = Integer.valueOf(\u0632\ufead\u062f\u0628.\ufe8e\ufec1\u0641\u0644("QbkCL9b"));
                                    System.out.println(var2_2);
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
        var0 = 1864;
        block20: while (true) {
            switch (var0 ^= 1881) {
                case 47483: {
                    ** continue;
                }
                default: {
                    continue block20;
                }
                case 17: 
            }
            var0 = 48674;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static int[][] \ufeb9\u062f\ufee9\u0644() {
        int n2 = \ufea9\u0643\u062d\u063a.\u0636\u0641\ufead\ufea9();
        int n3 = 1616;
        block10: while (true) {
            switch (n3 ^= 0x661) {
                default: {
                    continue block10;
                }
                case 49: {
                    if (n2 <= 0) {
                        n3 = 1709;
                        continue block10;
                    }
                }
                case 14: {
                    n3 = 1678;
                    continue block10;
                }
                case 204: {
                    return N;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n3 = 1740;
        block11: while (true) {
            int[][] nArray = var3_3;
            switch (n3 ^= 0x6DD) {
                case 54: {
                    return nArray;
                }
                default: {
                    continue block11;
                }
                case 17: 
            }
            n3 = 1771;
        }
    }

    /*
     * Unable to fully structure code
     */
    public static void \ufebd\u0628\u062a\u0645(int var0, int var1_1, Object var2_2) {
        var4_3 = \ufee9\ufee1\u0627\u0641.\u0641\u0638\ufeb1\ufeb5();
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
                    if (var4_3 < 0) ** GOTO lbl7
                    var3_4 = 1709;
                    continue block16;
                }
                case 204: {
                    rs_1.q(var0, var1_1, (t_0)var2_2);
lbl16:
                    // 2 sources

                    while (true) {
                        var1_1 = \ufeb9\u0643\ufed9\ufed5.\ufeed\u0631\u0648\ufea5();
                        var0 = 1740;
                        block19: while (true) {
                            switch (var0 ^= 1757) {
                                default: {
                                    continue block19;
                                }
                                case 17: {
                                    if (var1_1 <= 0) {
                                        var0 = 1833;
                                        continue block19;
                                    }
                                }
                                case 54: {
                                    var0 = 1802;
                                    continue block19;
                                }
                                case 500: {
                                    var2_2 = Long.decode(\ufe8e\ufec1\u0641\u0644.\ufec9\u0646\ufe8e\u0636("WKu8DtRIxon"));
                                    System.out.println(var2_2);
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
        var0 = 1864;
        block20: while (true) {
            switch (var0 ^= 1881) {
                case 47483: {
                    ** continue;
                }
                default: {
                    continue block20;
                }
                case 17: 
            }
            var0 = 48674;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static int \ufedd\u062a\u062f\u0637() {
        int n2 = \u0630\ufebd\u0634\ufec9.\u062f\ufe8f\u0630\ufed5();
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
                    return FA.yq;
                }
                case 239: 
            }
            break;
        }
        n2 = 0;
        n3 = 1740;
        block11: while (true) {
            int n4 = n3 ^ 0x6DD;
            n3 = n2;
            switch (n4) {
                case 54: {
                    return n3;
                }
                default: {
                    n3 = n4;
                    continue block11;
                }
                case 17: 
            }
            n3 = 1771;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static j_0 \ufee9\u0635\u062f\u0641() {
        int n2 = \u0644\ufe8f\u0628\u062a.\u0647\ufebd\u0627\u0631();
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
                    return j_0.SN.yq;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n3 = 1740;
        block11: while (true) {
            j_0 j_02 = var3_3;
            switch (n3 ^= 0x6DD) {
                case 54: {
                    return j_02;
                }
                default: {
                    continue block11;
                }
                case 17: 
            }
            n3 = 1771;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static int[][] \ufeed\u062d\u0638\u064a() {
        int n2 = \u0641\ufeb5\ufeb1\ufee1.\u0644\u0630\ufeb1\ufead();
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
                    return zH;
                }
                case 239: 
            }
            break;
        }
        Object var3_3 = null;
        n3 = 1740;
        block11: while (true) {
            int[][] nArray = var3_3;
            switch (n3 ^= 0x6DD) {
                case 54: {
                    return nArray;
                }
                default: {
                    continue block11;
                }
                case 17: 
            }
            n3 = 1771;
        }
    }

    private static long[] $d2j$hex$41b006ed$decode_J(String src) {
        byte[] d = rs_1.$d2j$hex$41b006ed$decode_B(src);
        ByteBuffer b2 = ByteBuffer.wrap(d);
        b2.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b2.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$41b006ed$decode_I(String src) {
        byte[] d = rs_1.$d2j$hex$41b006ed$decode_B(src);
        ByteBuffer b2 = ByteBuffer.wrap(d);
        b2.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b2.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$41b006ed$decode_S(String src) {
        byte[] d = rs_1.$d2j$hex$41b006ed$decode_B(src);
        ByteBuffer b2 = ByteBuffer.wrap(d);
        b2.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b2.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$41b006ed$decode_B(String src) {
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

