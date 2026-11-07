/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.os.Build
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  com.github.catvod.crawler.SpiderDebug
 *  com.github.catvod.spider.HideUtils
 *  org.json.JSONObject
 */
package com.github.catvod.spider.merge;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.parser.\u062a\ufee1\ufe8e\ufeb9;
import com.github.catvod.parser.\u0631\u063a\u0645\u0641;
import com.github.catvod.parser.\u0631\u0640\ufec1\ufee9;
import com.github.catvod.parser.\u0633\u064a\u0644\u0637;
import com.github.catvod.parser.\u0638\ufead\u062e\ufee1;
import com.github.catvod.parser.\u0645\u0641\u0630\u062d;
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
import com.github.catvod.spider.HideUtils;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.merge.eY;
import com.github.catvod.spider.merge.k_0;
import com.github.catvod.spider.merge.n_0;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.s_0;
import com.github.catvod.spider.merge.uA;
import com.github.catvod.spider.merge.un;
import com.github.catvod.spider.merge.\u062a\u0635\ufeb1\u0642;
import com.github.catvod.spider.merge.\u062b\ufec1\ufeb1\u062d;
import com.github.catvod.spider.merge.\u062d\ufeb9\ufeab\ufef1;
import com.github.catvod.spider.merge.\u0641\u0631\ufeed\u0643;
import com.github.catvod.spider.merge.\u0644\ufe8f\u0628\u062a;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufea1\u0645\u062b\u0634;
import com.github.catvod.spider.merge.\ufea5\ufea9\u0633\ufed5;
import com.github.catvod.spider.merge.\ufeab\u062d\u063a\ufea9;
import com.github.catvod.spider.merge.\ufebd\u0640\u0648\u062b;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
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
import com.github.catvod.spider.\ufea5\u062d\ufebd\u0633;
import com.github.catvod.spider.\ufea9\ufec5\u0647\u0641;
import com.github.catvod.spider.\ufeaf\u0633\u0648\ufee9;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import com.github.catvod.spider.\ufeb5\ufe8e\ufead\u0632;
import com.github.catvod.spider.\ufeb9\u0627\ufea5\ufe9d;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class ME {
    public static final List<String> N;
    public static final String SN;
    private static boolean i;
    private static final short[] short;
    public static final Pattern tF;
    public static String yq;
    public static final List<String> zH;

    static {
        short = ME.$d2j$hex$8fa4341b$decode_S("190a3b0a2e0a3d0a380a380a350a7b0a610a7a0a640a740a7c0a030a3d0a3a0a300a3b0a230a270a740a1a0a000a740a650a640a7a0a640a6f0a740a030a3d0a3a0a620a600a6f0a740a2c0a620a600a7d0a740a150a240a240a380a310a030a310a360a1f0a3d0a200a7b0a610a670a630a7a0a670a620a740a7c0a1f0a1c0a000a190a180a780a740a380a3d0a3f0a310a740a130a310a370a3f0a3b0a7d0a740a170a3c0a260a3b0a390a310a7b0a650a600a640a7a0a640a7a0a640a7a0a640a740a070a350a320a350a260a3d0a7b0a610a670a630a7a0a670a620a0101230136012501200120012d016301790162017c016c0164010001250122013901340177016c010d01220128013e012301250128016c017d017e0177016c013e055c056b05770572057a0531054d0555054f052f0530052c052f052f052f052f052d0530052e052e052f0525053e056905680537053e055f056e056e0572057b0549057b057c05550577056a0531052b052d05290530052d0528053e053605550556054a055305520532053e057205770575057b053e0559057b057d057505710537053e0548057b056c056d0577057105700531052a0530052e053e055d0576056c05710573057b0531052705290530052e0530052a05280527052c053005270526053e05530571057c05770572057b053e054d057f0578057f056c05770531052b052d05290530052d0528059c058105c505b605b005ad050b0711070a07a30ca90cb30c070110010f01f10aeb0af70aa605bb05ac055e09590990018d01ce01570957095509520c580c550c570ce70abe0aeb0ad005c105d40554095c095c09d60cca0cca0cce0c960c960c810c9f0cd60cca0cca0cce0c970c900c970cc50c8f0c8c0c920cc30c810ce20c900c960cd30c8d0ccb0c860cc20cd30cce0c8a0cc20cdf0cc80cd70cc20cd30cd10cc80cc20cc90cd30cc80cc20cd80cd20cc80cc20cd30cd50cc80cc20cc90cdb0cdc0cd30cc20ccc0cd30cc80cdc0c970ce20c810c900c940cc20cd60cca0cca0cce0c960c960c810c9f0cd60cca0cca0cce0c970c900c970cc50c8f0c8c0c920cc30ce20c900c960cd30c8d0ccb0c860cc20cd30cce0c8a0cc20cdf0cc80cd70cc20cd30cd10cc80cc20cc90cd30cc80cc20cd80cd20cc80cc20cd30cd50cc80cc20cc90cdb0cdc0cd30cc20ccc0cd30cc80cdc0c970cc20cd60cca0cca0cce0c960c960c810c9f0cd60cca0cca0cce0c970c900c970cc50c8f0c8c0c920cc30c810c910cd30c8d0ccb0c860ce20c810cce0cca0c830cd30c8d0ccb0c860c900c940cc20cd60cca0cca0cce0c960c960c810c9f0cd60cca0cca0cce0c970c900c970c940c810cda0cdb0cd80cdf0ccb0cd20cca0ce20c900cd70cc60cd70cd90ccb0cdf0ce20c900cdd0cd10cd30c910c900c940cc20cd60cca0cca0cce0c960c960c810c9f0cd60cca0cca0cce0c970c900c970c940c810cdd0cda0cd00c930cca0cd10ccd0ce50ce00ce20c810ce30c940cc20cd60cca0cca0cce0c960c960c810c9f0cd60cca0cca0cce0c970c900c970c940c810c910cd10cdc0cd40c910cca0cd10ccd0ce50ce00ce20c810ce30c940cc20cd60cca0cca0cce0c900c940c810c910cce0cd20cdf0cc70cdb0ccc0c910cd30c8d0ccb0c860cce0cd20cdf0cc70ce20c900cce0cd60cce0ce20c810ccb0ccc0cd20c830c900c940cc20cd60cca0cca0cce0c900c940c810c910cce0cd20cdf0cc70cdb0ccc0c910c900c940c810ce50cce0cee0ce30cd20cdf0cc70ce20c900cce0cd60cce0ce20c810ccb0ccc0cd20c830c900c940cc20cd60cca0cca0cce0c900c940c810c910cce0cd20cdf0cc70cd20cd70ccd0cca0c910cd30c8d0ccb0c860c910ce20c810cc80cd70cda0c830c900c940cc20cd60cca0cca0cce0c900c940c810ce20c900cce0cd60cce0ce20c810cca0cc70cce0cdb0c830cd30c8d0ccb0c860c980c900c940cc20cd60cca0cca0cce0c900c940c810c910cda0cd10cc90cd00cd20cd10cdf0cda0c900cdf0ccd0cce0cc60ce20c810c900c940cc20cd60cca0cca0cce0c900c940c810c910cdf0cce0cd70c910ccb0cce0ce10cdf0cce0cd70c900cce0cd60cce0ce20c810c900c940cc20cd60cca0cca0cce0ccd0c900c940c810ce20c900c880c880cc70cd50ce20c900cdd0cd00c900c940cc20cd60cca0cca0cce0c960c960c810c9f0cd60cca0cca0cce0c970c900c970c940c810cd00cdb0cca0cdb0cdf0ccd0cdb0ce20c900cdd0cd10cd30c910cd80cd70cd20cdb0c910c900c940cc20cd60cca0cca0cce0ccd0c900c940c810ce20c900cd60ccb0cd10ccd0cd60cdf0cd00ce20c900cdd0cd10cd30c900c940cc20c900c940ce20c900c960cd30c8d0ccb0c860cc20cd30cce0c8a0cc20cdf0cc80cd70cc20cd30cd10cc80cc20cc90cd30cc80cc20cd80cd20cc80cc20cd30cd50cc80cc20cc90cdb0cdc0cd30cc20ccc0cd30cc80cdc0c970c900c940c820198018301fc01e101a201360136013401a604ac04a104a304ce049704c204d405c205d50532072807240776047d04700461046a0463046704390c6203540c52055005ed0afb0af20afb0afd0aea0a9e0acb0acc0ad20a9e0af80aec0af10af30a9e0afd0ad10ad00ad80ad70ad90a9e0ae90af60afb0aec0afb0a9e0aca0ac70ace0adb0a9e0a830a9e0ae1088e089308850884089308e10883089808e108b508a808ac08a408e1088508840892088208e1088d0888088c0888089508e108f008e802ea02e702e802d902ee02f802fe02e702ff02eb04ec04f204a304f604ea04ea04ee048d01c901d001c60b8b0b9b0b9b0b3a0a7c0a600a790a780a0f060e060806190612061b061f0625090309150902095d093109170915091e0904099a0abc0aaa0abd0ae20a8e0aa80aaa0aa10abb0a470c650c700c630c660c660c6b0c250c3f0c240c3a0c2a0c220c470c6b0c690c630c640c7e0c650c790c620c310c2a0c430c640c7e0c6f0c660c2a0c470c6b0c690c2a0c450c590c2a0c520c2a0c3b0c3a0c550c3b0c3f0c550c3d0c230c2a0c4b0c7a0c7a0c660c6f0c5d0c6f0c680c410c630c7e0c250c3f0c390c3d0c240c390c3c0c2a0c220c410c420c5e0c470c460c260c2a0c660c630c610c6f0c2a0c4d0c6f0c690c610c650c230c2a0c490c620c780c650c670c6f0c250c3b0c3e0c320c240c3a0c240c3a0c240c3a0c2a0c590c6b0c6c0c6b0c780c630c250c3f0c390c3d0c240c390c3c0c6e0a4c0a590a4a0a4f0a4f0a420a0c0a160a0d0a130a030a0b0a7b0a120a120a180a030a6f0a4a0a4d0a560a5b0a030a420a420a510a400a4b0a150a170a0a0a030a620a530a530a4f0a460a740a460a410a680a4a0a570a0c0a160a100a140a0d0a100a150a030a0b0a680a6b0a770a6e0a6f0a0f0a030a4f0a4a0a480a460a030a640a460a400a480a4c0a0a0a030a600a4b0a510a4c0a4e0a460a0c0a120a170a1b0a0d0a130a0d0a130a0d0a130a030a700a420a450a420a510a4a0a0c0a160a100a140a0d0a100a150af208c508c608c508d208c508d20830051c051c0518051a051605f507f707d007d707f707d6078f07e50be907570550054e05c106c106d701cb01cb01cf01cc018501d907c507c507c107db0cc30cdb0ccb0cdb0c9c0cd10cdd0cdf0c9e05c60599059905c6058b0587058505e503f303e903f703e903b203ff03f303f10357085e0815085808540856083407350724072f0735076e0723072f072d0700060a0619061b0643060e0602060006000b1c0b1b0b060b5d0b100b1c0b1e0bc905cb05ce05dd05c6058605cb05c60588058305860583058805830586058305c405890585058705c906ca06c406cd06ce06c506cc068506c806c406c606f109f109f509f709af09e209ee09ec098d098b099d098a09d50999099f099d0996098c097c085a084c085b08040868084e084c0847085d080c021b0218021b020c021b020c02410c760c750c760c610c760c610c270c270c270c7e0c3d0c370c240c260c7e0c330c3f0c3d0cfc0ae10afc0ae90ae60aa60ae50aef0afc0afe0a3f071d0708071b071e071e0713075d0747075c074207390b320b370b320b390b320b370b320b190c050c050c010c020c4b0c5e0c5e0c060c060c060c5f0c130c180c1d0c180c130c180c1d0c180c5f0c120c1e0c1c0c5e0c0306210634062706220622062f0661067b0660067e066e06660616067f067f0675066e060206270620063b0636066e062f062f063c062d06260678067a0667066e060f063e063e0622062b0619062b062c06050627063a0661067b067d06790660067d0678066e066606050606061a060306020662066e062206270625062b066e0609062b062d062506210667066e060d0626063c06210623062b0661067f067a06760660067e0660067e0660067e066e061d062f0628062f063c06270661067b067d06790660067d0678062d0a200a240a210a200a370a5d0c410c410c450c0e0905090c091f09080613060b06de0649045e045c04e803a10a8506fb02c20acd0ad80ac50ada0ac90af30ad80ac50ac20acb0af30ac10ac80a990ade0bdb0bd20b870786079407ff07ea07760a7d0a610a350a760a200a47055105e703e2034e0a410a22092b09150314031203770565056505e701e701f501730a720a600a0b0a1e0af004f9048804ac08");
        yq = \u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(short, 0, 111, 2644);
        SN = k_0.i(oi_0.yq(\u062a\u0635\ufeb1\u0642.\u0637\u0636\u062a\ufedd(short, 111, 32, 332)), Build.MODEL, \ufeaf\u0633\u0648\ufee9.\u062e\u0645\u0644\u0648(short, 143, 119, 1310));
        N = Arrays.asList(\ufea9\u0643\u062d\u063a.\ufea1\u0633\ufe8e\u0627(short, 262, 3, 1521), \u0632\ufead\u062f\u0628.\u0645\u062a\u0637\u0635(short, 265, 3, 1499), \ufeb9\u0627\ufea5\ufe9d.\u062a\ufef1\u062d\u0641(short, 268, 3, 1916), \u062a\u0635\ufeb1\u0642.\u0637\u0636\u062a\ufedd(short, 271, 3, 3269), \u062a\ufee1\ufe8e\ufeb9.\ufec5\ufecd\ufea9\ufea5(short, 274, 3, 358), \ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(short, 277, 3, 2712), \ufe8e\ufeb9\u0647\u0642.\ufee1\u062f\ufedd\u0643(short, 280, 3, 1483), \ufeb9\u0643\ufed9\ufed5.\u0628\u062f\ufea1\u0642(short, 283, 2, 2346), \ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(short, 285, 3, 509), \u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(short, 288, 3, 2358), \ufeb5\ufe8e\ufead\u0632.\ufe8f\ufef1\u0648\ufe95(short, 291, 4, 3124), \ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(short, 295, 3, 2698), \u0645\u0641\u0630\u062d.\u0642\u062a\u0630\ufebd(short, 298, 3, 1457), \u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(short, 301, 3, 2363));
        tF = Pattern.compile(\ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(short, 304, 590, 3262));
        zH = Arrays.asList(\ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(short, 894, 3, 501), \ufee9\u0631\ufeb5\u0628.\u0636\ufeab\u0634\u0633(short, 897, 3, 401), \ufee9\ufee1\u0627\u0641.\ufea1\ufebd\u063a\u0630(short, 900, 3, 343), \ufee9\u0631\ufeb5\u0628.\u0636\ufeab\u0634\u0633(short, 903, 4, 1216), \ufe99\u062e\u0642\u0644.\ufec1\u0644\u0645\ufec9(short, 907, 3, 1187), \ufea9\u0643\u062d\u063a.\ufea1\u0633\ufe8e\u0627(short, 910, 3, 1443), \ufe8f\ufe8e\ufeb5\u0641.\u062f\u0627\u0640\ufee1(short, 913, 3, 1861));
        i = false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String B(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return "";
        }
        if (uA.yq) {
            return HideUtils.encrypt((String)string);
        }
        try {
            return (String)InitOrigin.i.getDeclaredMethod(\u0632\ufead\u062f\u0628.\u0645\u062a\u0637\u0635(short, 916, 7, 1043), String.class).invoke(null, string);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static String F5(String object, String object2) {
        object = Pattern.compile((String)object2).matcher((CharSequence)object);
        object2 = new ArrayList();
        while (((Matcher)object).find()) {
            ((ArrayList)object2).add(((Matcher)object).group(1));
        }
        return object2.toString().replace(\ufea9\u0643\u062d\u063a.\ufea1\u0633\ufe8e\u0627(short, 923, 1, 3170), "").replace(\ufea9\ufe8f\u0647\ufead.\ufea9\u0643\ufedd\ufeed(short, 924, 1, 831), "");
    }

    /*
     * Enabled aggressive block sorting
     */
    public static boolean G(JSONObject jSONObject, String string, String string2) {
        String string3;
        boolean bl = false;
        String[] stringArray = \ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(ME.\ufeb5\ufef1\ufea9\ufe8f(), 925, 1, 3186);
        boolean bl2 = \ufea9\ufec5\u0647\u0641.\ufef1\ufedd\u062c\ufea5(string2, stringArray);
        int n2 = 1616;
        block28: while (true) {
            string3 = string2;
            switch (n2 ^= 0x661) {
                default: {
                    continue block28;
                }
                case 49: {
                    if (bl2) {
                        n2 = 1709;
                        continue block28;
                    }
                }
                case 14: {
                    n2 = 1678;
                    continue block28;
                }
                case 204: {
                    stringArray = \ufeb5\ufe8e\ufead\u0632.\u0640\ufec5\ufedd\u0634(string2, stringArray);
                    int n3 = 0;
                    block29: while (true) {
                        int n4 = stringArray.length;
                        n2 = 1740;
                        block30: while (true) {
                            string3 = string2;
                            switch (n2 ^= 0x6DD) {
                                default: {
                                    continue block30;
                                }
                                case 17: {
                                    if (n3 < n4) {
                                        n2 = 1833;
                                        continue block30;
                                    }
                                }
                                case 54: {
                                    n2 = 1802;
                                    continue block30;
                                }
                                case 500: {
                                    string3 = stringArray[n3];
                                    bl2 = \ufea9\ufec5\u0647\u0641.\ufef1\ufedd\u062c\ufea5(\ufeab\u0632\u062f\u0640.\ufeab\u0632\ufec5\u0645(jSONObject, string), string3);
                                    n2 = 1864;
                                    block31: while (true) {
                                        switch (n2 ^= 0x759) {
                                            default: {
                                                continue block31;
                                            }
                                            case 17: {
                                                if (bl2) {
                                                    n2 = 48736;
                                                    continue block31;
                                                }
                                            }
                                            case 47483: {
                                                n2 = 48705;
                                                continue block31;
                                            }
                                            case 47417: {
                                                return true;
                                            }
                                            case 47384: 
                                        }
                                        break;
                                    }
                                    n4 = n3 + 1;
                                    n2 = 48767;
                                    block32: while (true) {
                                        n3 = n4;
                                        string2 = string3;
                                        switch (n2 ^= 0xBE90) {
                                            case 14: {
                                                continue block29;
                                            }
                                            default: {
                                                continue block32;
                                            }
                                            case 239: 
                                        }
                                        n2 = 48798;
                                    }
                                }
                                case 471: 
                            }
                            break;
                        }
                        break;
                    }
                    break block28;
                }
                case 239: 
            }
            break;
        }
        boolean bl3 = \ufea9\ufec5\u0647\u0641.\ufef1\ufedd\u062c\ufea5(\ufeab\u0632\u062f\u0640.\ufeab\u0632\ufec5\u0645(jSONObject, string), string3);
        n2 = 48891;
        block33: while (true) {
            bl2 = bl;
            switch (n2 ^= 0xBF0C) {
                case 53: {
                    return bl2;
                }
                default: {
                    continue block33;
                }
                case 503: {
                    if (bl3) {
                        n2 = 49635;
                        continue block33;
                    }
                }
                case 22: {
                    n2 = 48953;
                    continue block33;
                }
                case 32495: 
            }
            break;
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String G4(int n2) {
        try {
            SQLiteDatabase sQLiteDatabase = SQLiteDatabase.openDatabase((String)InitOrigin.context().getDatabasePath(\ufeb9\u0627\ufea5\ufe9d.\u062a\ufef1\u062d\u0641(short, 926, 2, 1318)).getAbsolutePath(), null, (int)1);
            CharSequence charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(\u062d\ufeb9\ufeab\ufef1.\ufeed\u0638\u0635\ufed5(short, 928, 36, 2750));
            ((StringBuilder)charSequence).append(n2);
            ((StringBuilder)charSequence).append(\ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(short, 964, 27, 2241));
            Cursor cursor = sQLiteDatabase.rawQuery(((StringBuilder)charSequence).toString(), null);
            charSequence = cursor.moveToFirst() ? cursor.getString(0) : "";
            cursor.close();
            sQLiteDatabase.close();
            return charSequence;
        }
        catch (Exception exception) {
            SpiderDebug.log((Throwable)exception);
            return "";
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int[] Gc(int[] nArray) {
        if (uA.yq) {
            return HideUtils.calcResult((int[])nArray);
        }
        try {
            return (int[])InitOrigin.i.getDeclaredMethod(\u0641\ufeb5\ufeb1\ufee1.\u0639\u0630\ufeaf\ufe95(short, 991, 10, 651), int[].class).invoke(null, new Object[]{nArray});
        }
        catch (Exception exception) {
            exception.printStackTrace();
            if (i) return null;
            i = true;
            new Handler(Looper.getMainLooper()).post((Runnable)new s_0(exception, 2));
            return null;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean Gd(String string) {
        if (string.contains(\ufea1\u0645\u062b\u0634.\u0638\ufec9\u0630\ufe95(short, 1001, 8, 1182))) return false;
        if (string.contains(\ufe95\u0627\ufe8e\u0644.\u062d\u0636\ufea9\u0640(short, 1009, 3, 419))) return false;
        if (string.contains(\ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(short, 1012, 4, 3048))) return false;
        if (!string.contains(\u0644\ufe8f\u0628\u062a.\u0636\u063a\u0638\u0630(short, 1016, 5, 2580))) return tF.matcher(string).find();
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String KJ(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return "";
        }
        if (uA.yq) {
            return HideUtils.decrypt((String)string);
        }
        try {
            return (String)InitOrigin.i.getDeclaredMethod(\ufeaf\u0633\u0648\ufee9.\u062e\u0645\u0644\u0648(short, 1021, 7, 1643), String.class).invoke(null, string);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            if (i) return "";
            i = true;
            new Handler(Looper.getMainLooper()).post((Runnable)new un(exception, 3));
            return "";
        }
    }

    public static HashMap<String, String> M(String string) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put(\u0631\u063a\u0645\u0641.\ufebd\u0640\u0648\u062b(short, 1028, 10, 2416), string);
        return hashMap;
    }

    public static HashMap<String, String> N(String string, String string2, int n2) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        String string3 = \ufeab\u062d\u063a\ufea9.\u062f\u0642\ufebd\u064a(short, 1038, 10, 2767);
        if (n2 == 1) {
            hashMap.put(string3, \ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(short, 1048, 117, 3082));
        }
        if (n2 == 2) {
            hashMap.put(string3, \ufebd\u0640\u0648\u062b.\ufea5\u0639\u0631\ufe95(short, 1165, 102, 2595));
        }
        if (n2 == 3) {
            hashMap.put(string3, yq);
        }
        if (!ME.ee(string)) {
            hashMap.put(\ufeb9\ufec9\u0648\u062d.\ufee9\u0637\ufef1\u0644(short, 1267, 7, 2208), string);
        }
        if (!ME.ee(string2)) {
            hashMap.put(\u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(short, 1274, 6, 1395), string2);
        }
        return hashMap;
    }

    public static JSONObject Nl(String string, String string2) {
        return ME.OW(string, new JSONObject(string2));
    }

    /*
     * Enabled aggressive block sorting
     */
    public static HashMap<String, String> O(String string) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        if (!(string = string.trim().replaceAll(\u0636\u0634\ufec1\u0631.\u062c\u063a\u0643\u0627(short, 1280, 7, 1963), "").trim()).isEmpty()) {
            String[] stringArray = string.split(\u0635\u0631\u0645\u0628.\u0646\u0627\u062a\u062d(short, 1287, 1, 3017));
            int n2 = stringArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                string = stringArray[i2].trim();
                int n3 = string.indexOf(\ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(short, 1288, 1, 2004));
                if (n3 <= 0) continue;
                hashMap.put(string.substring(0, n3).trim(), string.substring(n3 + 1).trim());
            }
        }
        return hashMap;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static JSONObject OW(String string, JSONObject object) {
        Object object2;
        String string2;
        String string3;
        block8: {
            String string4;
            block9: {
                String string5;
                block7: {
                    int n2;
                    string3 = \u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(short, 1289, 3, 1314);
                    string2 = object.getString(string3);
                    if (string2.startsWith(\u0631\u0640\ufec1\ufee9.\ufe95\ufeed\u062c\ufec1(short, 1292, 2, 1774))) {
                        string2 = eY.yq(\ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(short, 1294, 6, 447), string2);
                    }
                    if (!string2.startsWith(\ufeb9\u0627\ufea5\ufe9d.\u062a\ufef1\u062d\u0641(short, 1300, 4, 1969))) {
                        return null;
                    }
                    if (string2.equals(string)) {
                        object2 = Arrays.asList(\ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(short, 1304, 9, 3250), \ufea1\u0645\u062b\u0634.\u0638\ufec9\u0630\ufe95(short, 1313, 8, 1512), \ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(short, 1321, 9, 924), \ufea9\ufe8f\u0647\ufead.\ufea9\u0643\ufedd\ufeed(short, 1330, 6, 2107), \ufec1\u0636\u062d\u0638.\u0642\u0639\u0630\ufe9d(short, 1336, 9, 1856), \ufe95\u0627\ufe8e\u0644.\u062d\u0636\ufea9\u0640(short, 1345, 8, 1645), \ufea5\u062d\ufebd\u0633.\ufea5\ufeb1\u0643\ufe8f(short, 1353, 8, 2931), \ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(short, 1361, 8, 1448), \ufea1\u0645\u062b\u0634.\u0638\ufec9\u0630\ufe95(short, 1369, 12, 1514), \ufeab\u0632\u062f\u0640.\u062f\u0627\ufe95\u0631(short, 1381, 11, 1707), \ufebd\u0640\u0648\u062b.\ufea5\u0639\u0631\ufe95(short, 1392, 8, 2433)).iterator();
                        while (object2.hasNext()) {
                            if (!string2.contains((String)object2.next())) continue;
                            return null;
                        }
                        n2 = 0;
                        if (n2 != 0) return null;
                        if (!ME.Gd(string2)) {
                            return null;
                        }
                    }
                    object2 = new JSONObject();
                    string5 = object.optString(\u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(short, 1400, 10, 2552), "");
                    n2 = string5.trim().length();
                    string4 = \ufea5\ufea9\u0633\ufed5.\ufec1\ufe8f\u064a\u0648(short, 1410, 10, 2089);
                    if (n2 > 0) {
                        object2.put(string4, (Object)string5);
                    }
                    object = object.optString(\u0633\u064a\u0644\u0637.\ufec9\ufeed\ufeb5\u0640(short, 1420, 7, 638), "");
                    n2 = ((String)object).trim().length();
                    string5 = \u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(short, 1427, 7, 3091);
                    if (n2 > 0) {
                        object2.put(string5, object);
                    }
                    if (string.contains(\u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(short, 1434, 12, 3152)) || string2.contains(\ufe9d\u0631\ufe8f\u064a.\ufeb5\u0633\ufea5\ufecd(short, 1446, 10, 2696))) break block7;
                    if (!string.contains(\ufea9\ufec5\u0647\u0641.\ufe8f\ufee9\u062a\ufeb5(short, 1467, 8, 2907))) break block8;
                    object2.put(string5, (Object)\u0631\u0640\ufec1\ufee9.\ufe95\ufeed\u062c\ufec1(short, 1475, 25, 3185));
                    string = \u062d\u062e\ufe8e\u0645.\u062d\ufeab\u0642\u0647(short, 1500, 102, 1614);
                    break block9;
                }
                object2.put(string5, (Object)"");
                string = \ufecd\u0642\u062e\ufe9d.\u0637\ufee9\u0635\u0630(short, 1456, 11, 1906);
            }
            object2.put(string4, (Object)string);
        }
        string = new JSONObject();
        string.put(\u0645\u0641\u0630\u062d.\u0642\u062a\u0630\ufebd(short, 1602, 6, 2629), object2);
        string.put(string3, (Object)string2);
        return string;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static HashMap<String, String> SN(String hashMap) {
        if (!((String)((Object)hashMap)).startsWith(\ufeab\u062d\u063a\ufea9.\u062f\u0642\ufebd\u064a(short, 1608, 4, 3125))) return ME.N("", hashMap, 1);
        return ME.N(hashMap, null, 1);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String W(int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        int n3 = 0;
        while (n3 < n2) {
            String string;
            int n4 = random.nextInt(2);
            String string2 = \ufee1\u0639\u063a\u0645.\ufe8f\u0635\u062e\ufee1(short, 1612, 4, 2413);
            if (string2.equalsIgnoreCase(string = n4 % 2 == 0 ? string2 : \u0633\u064a\u0644\u0637.\ufec9\ufeed\ufeb5\u0640(short, 1616, 3, 1638))) {
                n4 = random.nextInt(2) % 2 == 0 ? 65 : 97;
                stringBuilder.append((char)(n4 + random.nextInt(26)));
            } else {
                stringBuilder.append(random.nextInt(10));
            }
            ++n3;
        }
        return stringBuilder.toString();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String b(String string) {
        if (string == null) {
            return "";
        }
        try {
            return URLEncoder.encode(string).replace(\ufeb9\u0643\ufed9\ufed5.\u0628\u062f\ufea1\u0642(short, 1619, 1, 1781), \u062a\ufee1\ufe8e\ufeb9.\ufec5\ufecd\ufea9\ufea5(short, 1620, 3, 1132));
        }
        catch (Exception exception) {
            return "";
        }
    }

    public static String dT(String string) {
        return string.substring(string.lastIndexOf(\u0641\u0631\ufeed\u0643.\u062f\u0631\ufea5\u0647(short, 1623, 1, 966)) + 1);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean ee(String string) {
        if (string == null) return true;
        if (!string.isEmpty()) return false;
        return true;
    }

    public static String g1(String string) {
        String string2 = \ufeed\ufebd\u0635\ufedd.\u062f\ufe9d\u0642\u062d(short, 1624, 1, 2703);
        String string3 = string;
        if (string.contains(string2)) {
            string3 = string.substring(0, string.lastIndexOf(string2));
        }
        return string3;
    }

    public static boolean g9(String string) {
        return N.contains(ME.dT(string).toLowerCase());
    }

    public static HashMap<String, String> i(String stringArray) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        String[] stringArray2 = stringArray.split(\ufeab\u062d\u063a\ufea9.\u062f\u0642\ufebd\u064a(short, 1625, 1, 1699));
        int n2 = stringArray2.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            stringArray = stringArray2[i2].split(\ufecd\u0642\u062e\ufe9d.\u0637\ufee9\u0635\u0630(short, 1626, 1, 710), 2);
            if (stringArray.length != 2) continue;
            hashMap.put(stringArray[0], stringArray[1]);
        }
        return hashMap;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String n(String string) {
        if (uA.yq) {
            return HideUtils.tingMd5((String)string);
        }
        try {
            return (String)InitOrigin.i.getDeclaredMethod(\ufeb1\ufe8e\ufee1\ufe9d.\ufeed\u0640\ufecd\ufeaf(short, 1627, 15, 2732), String.class).invoke(null, string);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            if (i) return "";
            i = true;
            new Handler(Looper.getMainLooper()).post((Runnable)new n_0(exception, 7));
            return "";
        }
    }

    public static int q(int n2) {
        return (int)TypedValue.applyDimension((int)1, (float)n2, (DisplayMetrics)InitOrigin.context().getResources().getDisplayMetrics());
    }

    public static String s(String string) {
        String string2 = string;
        if (string != null) {
            string2 = string;
            if (string.length() > 1) {
                string2 = string.substring(0, string.length() - 1);
            }
        }
        return string2;
    }

    public static String t0(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = byArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            String string = Integer.toHexString(byArray[i2] & 0xFF);
            if (string.length() == 1) {
                stringBuilder.append('0');
            }
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    public static String tF(String string) {
        return ME.zH(string);
    }

    public static byte[] un(byte[] byArray) {
        String string = \ufea5\u062d\ufebd\u0633.\ufea5\ufeb1\u0643\ufe8f(short, 1642, 3, 2969);
        Charset charset = Charset.forName(string);
        byte[] byArray2 = byArray;
        if (Arrays.equals(byArray, new String(byArray, charset).getBytes(charset))) {
            byArray2 = new String(byArray, Charset.forName(string)).getBytes(\ufeaf\u062b\ufed5\ufec1.\u062e\ufeab\ufee9\u0628(short, 1645, 5, 2002));
        }
        return byArray2;
    }

    public static byte[] v(String string) {
        int n2 = string.length();
        byte[] byArray = new byte[n2 / 2];
        for (int i2 = 0; i2 < n2; i2 += 2) {
            byArray[i2 / 2] = (byte)((Character.digit(string.charAt(i2), 16) << 4) + Character.digit(string.charAt(i2 + 1), 16));
        }
        return byArray;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String v3(double d) {
        if (d <= 0.0) {
            return "";
        }
        String string = \ufea9\u0643\u062d\u063a.\ufea1\u0633\ufe8e\u0627(short, 1650, 6, 2643);
        if (d > 1.099511627776E12) {
            return String.format(Locale.getDefault(), string, d /= 1.099511627776E12, \u0635\u0631\u0645\u0628.\u0646\u0627\u062a\u062d(short, 1656, 2, 1299));
        }
        if (d > 1.073741824E9) {
            return String.format(Locale.getDefault(), string, d /= 1.073741824E9, \u0632\ufead\u062f\u0628.\u0645\u062a\u0637\u0635(short, 1658, 2, 928));
        }
        if (!(d > 1048576.0)) return String.format(Locale.getDefault(), string, d /= 1024.0, \ufecd\u0642\u062e\ufe9d.\u0637\ufee9\u0635\u0630(short, 1662, 2, 2409));
        return String.format(Locale.getDefault(), string, d /= 1048576.0, \ufeb9\ufec9\u0648\u062d.\ufee9\u0637\ufef1\u0644(short, 1660, 2, 2563));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean xa(String string) {
        if (string.contains(\ufe8e\u0627\ufecd\u062a.\u0641\ufea1\ufea9\ufecd(short, 1664, 3, 870))) return true;
        if (string.contains(\u0635\u0631\u0645\u0628.\u0646\u0627\u062a\u062d(short, 1667, 3, 1302))) return true;
        if (!string.contains(\u0640\u0633\ufea5\u0631.\ufeb1\u0632\u062f\ufe8f(short, 1670, 3, 404))) return false;
        return true;
    }

    public static HashMap<String, String> yq() {
        return ME.N("", "", 1);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String zH(String object) {
        Object object2 = \u062b\ufec1\ufeb1\u062d.\u0637\u0647\u0635\u0630(short, 1673, 5, 2598);
        try {
            object2 = MessageDigest.getInstance(\u0631\ufea1\u0638\u0627.\u0645\u062f\u062d\ufeaf(short, 1678, 3, 1213)).digest(((String)object).getBytes((String)object2));
            object = new BigInteger(1, (byte[])object2);
            object2 = new StringBuilder(((BigInteger)object).toString(16));
            while (true) {
                if (((StringBuilder)object2).length() >= 32) {
                    return ((StringBuilder)object2).toString().toLowerCase();
                }
                ((StringBuilder)object2).insert(0, \ufed9\ufe8e\u062d\ufead.\u062f\ufef1\u0636\u0644(short, 1681, 1, 2204));
            }
        }
        catch (Exception exception) {
            return "";
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static short[] \ufeb5\ufef1\ufea9\ufe8f() {
        if (\u0644\ufe8f\u0628\u062a.\u0647\ufebd\u0627\u0631() <= 0) return null;
        return short;
    }

    private static long[] $d2j$hex$8fa4341b$decode_J(String src) {
        byte[] d = ME.$d2j$hex$8fa4341b$decode_B(src);
        ByteBuffer b2 = ByteBuffer.wrap(d);
        b2.order(ByteOrder.LITTLE_ENDIAN);
        LongBuffer s2 = b2.asLongBuffer();
        long[] data = new long[d.length / 8];
        s2.get(data);
        return data;
    }

    private static int[] $d2j$hex$8fa4341b$decode_I(String src) {
        byte[] d = ME.$d2j$hex$8fa4341b$decode_B(src);
        ByteBuffer b2 = ByteBuffer.wrap(d);
        b2.order(ByteOrder.LITTLE_ENDIAN);
        IntBuffer s2 = b2.asIntBuffer();
        int[] data = new int[d.length / 4];
        s2.get(data);
        return data;
    }

    private static short[] $d2j$hex$8fa4341b$decode_S(String src) {
        byte[] d = ME.$d2j$hex$8fa4341b$decode_B(src);
        ByteBuffer b2 = ByteBuffer.wrap(d);
        b2.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer s2 = b2.asShortBuffer();
        short[] data = new short[d.length / 2];
        s2.get(data);
        return data;
    }

    private static byte[] $d2j$hex$8fa4341b$decode_B(String src) {
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

