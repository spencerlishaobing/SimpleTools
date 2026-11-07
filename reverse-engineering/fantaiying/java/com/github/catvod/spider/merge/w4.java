/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.DialogInterface$OnShowListener
 *  android.graphics.Color
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.StateListDrawable
 *  android.text.TextUtils$TruncateAt
 *  android.util.Base64
 *  android.util.DisplayMetrics
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnFocusChangeListener
 *  android.view.View$OnKeyListener
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager$LayoutParams
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.HorizontalScrollView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.ProgressBar
 *  android.widget.ScrollView
 *  android.widget.TextView
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonParser
 *  okhttp3.Response
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.github.catvod.spider.merge;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.github.catvod.spider.DexNative;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.Pan;
import com.github.catvod.spider.ProxyOrigin;
import com.github.catvod.spider.merge.A5;
import com.github.catvod.spider.merge.Bo;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.PE;
import com.github.catvod.spider.merge.Qf;
import com.github.catvod.spider.merge.Qp;
import com.github.catvod.spider.merge.SE;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.W;
import com.github.catvod.spider.merge.Zc;
import com.github.catvod.spider.merge.af_0;
import com.github.catvod.spider.merge.fm_0;
import com.github.catvod.spider.merge.hu;
import com.github.catvod.spider.merge.kY;
import com.github.catvod.spider.merge.lW;
import com.github.catvod.spider.merge.oX;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.p7;
import com.github.catvod.spider.merge.qv;
import com.github.catvod.spider.merge.sn_0;
import com.github.catvod.spider.merge.uA;
import com.github.catvod.spider.merge.w2;
import com.github.catvod.spider.merge.yj_0;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URLEncoder;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilderFactory;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

public final class w4 {
    private static AtomicBoolean Gd;
    public static String W = "";
    public static String ee = "";
    private static String g9 = "";
    public static String v = "";
    private static AtomicBoolean xa;
    List<String> B;
    private List<Zc> F5;
    private AlertDialog G;
    private LinearLayout G4;
    private String Gc = "";
    List<String> KJ;
    private final Pattern M;
    private String N = "";
    private String SN = "";
    private LinearLayout dT;
    private volatile boolean i = false;
    List<String> q;
    private Button t0 = null;
    private Pattern tF;
    private LinkedHashMap<String, List<Zc>> v3;
    private String[] yq = new String[]{"<", ">", "&", "\u0000", "\b"};
    private Pattern zH;

    static {
        xa = new AtomicBoolean(false);
        Gd = new AtomicBoolean(false);
        Pattern.compile("\"danum\":(\\d+)");
        Arrays.asList("16733525", "16755200", "16776960", "13434880", "65535", "327680", "10092543", "10066329", "16763904", "12632256", "15790320", "65407", "16711680", "255", "65280", "16776947");
        new Random();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setIgnoringElementContentWhitespace(true);
        documentBuilderFactory.setCoalescing(true);
    }

    public w4(String string, String string2) {
        this.tF = Pattern.compile("(\\d+)");
        this.zH = Pattern.compile("E(\\d+)");
        this.M = Pattern.compile("(\u7279\u522b|\u60ca\u559c|\u7eb3\u51c9)?\u4f01\u5212|\u5408\u4f19\u4eba\u624b\u8bb0|\u8d85\u524d(\u8425\u4e1a|vlog)?|\u901f\u89c8|vlog|reaction|\u7eaf\u4eab|\u4e50\u5b50|\u52a0\u66f4(\u7248|\u7bc7)?|\u62a2\u5148(\u770b|\u7248|\u96c6|\u7bc7)?|\u62a2\u9c9c|\u9884\u544a|\u82b1\u7d6e(\u72ec\u5bb6)?|\u7279\u8f91|\u5f69\u86cb|\u4e13\u8bbf|\u5e55\u540e(\u6545\u4e8b|\u82b1\u7d6e|\u72ec\u5bb6)?|\u76f4\u64ad(\u966a\u770b|\u56de\u987e)?|\u672a\u64ad(\u7247\u6bb5)?|\u884d\u751f|\u756a\u5916|\u8d4f\u6790|\u4f1a\u5458(\u4e13\u4eab|\u52a0\u957f|\u5c0a\u4eab|\u4e13\u5c5e|\u7248)?|\u7247\u82b1|\u7cbe\u534e|\u770b\u70b9|\u901f\u770b|\u89e3\u8bfb|\u5f71\u8bc4|\u89e3\u8bf4|\u5410\u69fd|\u76d8\u70b9|\u62cd\u6444\u82b1\u7d6e|\u5236\u4f5c\u82b1\u7d6e|\u5e55\u540e\u82b1\u7d6e|\u672a\u64ad\u82b1\u7d6e|\u72ec\u5bb6\u82b1\u7d6e|\u82b1\u7d6e\u7279\u8f91|\u5148\u5bfc\u9884\u544a|\u7ec8\u6781\u9884\u544a|\u6b63\u5f0f\u9884\u544a|\u5b98\u65b9\u9884\u544a|\u5f69\u86cb\u7247\u6bb5|\u5220\u51cf\u7247\u6bb5|\u672a\u64ad\u7247\u6bb5|\u756a\u5916\u5f69\u86cb|\u7cbe\u5f69\u7247\u6bb5|\u7cbe\u5f69\u770b\u70b9|\u7cbe\u5f69\u56de\u987e|\u7cbe\u5f69\u96c6\u9526|\u770b\u70b9\u89e3\u6790|\u770b\u70b9\u9884\u544a|NG\u955c\u5934|NG\u82b1\u7d6e|\u756a\u5916\u7bc7|\u756a\u5916\u7279\u8f91|\u5236\u4f5c\u7279\u8f91|\u62cd\u6444\u7279\u8f91|\u5e55\u540e\u7279\u8f91|\u5bfc\u6f14\u7279\u8f91|\u6f14\u5458\u7279\u8f91|\u7247\u5c3e\u66f2|\u63d2\u66f2|\u9ad8\u5149\u56de\u987e|\u80cc\u666f\u97f3\u4e50|OST|\u97f3\u4e50MV|\u6b4c\u66f2MV|\u524d\u5b63\u56de\u987e|\u5267\u60c5\u56de\u987e|\u5f80\u671f\u56de\u987e|\u5185\u5bb9\u603b\u7ed3|\u5267\u60c5\u76d8\u70b9|\u7cbe\u9009\u5408\u96c6|\u526a\u8f91\u5408\u96c6|\u6df7\u526a\u89c6\u9891|\u72ec\u5bb6\u4e13\u8bbf|\u6f14\u5458\u8bbf\u8c08|\u5bfc\u6f14\u8bbf\u8c08|\u4e3b\u521b\u8bbf\u8c08|\u5a92\u4f53\u91c7\u8bbf|\u53d1\u5e03\u4f1a\u91c7\u8bbf|\u91c7\u8bbf|\u966a\u770b(\u8bb0)?|\u8bd5\u770b\u7248|\u77ed\u5267|\u7cbe\u7f16|Plus|\u72ec\u5bb6\u7248|\u7279\u522b\u7248|\u77ed\u7247|\u53d1\u5e03\u4f1a|\u89e3\u5fe7\u5c40|\u8d70\u5fc3\u5c40|\u706b\u9505\u5c40|\u5dc5\u5cf0\u65f6\u523b|\u575e\u91cc\u90fd\u77e5\u9053|\u798f\u6301\u76ee\u6807\u575e\u6c11|\u89c2\u5bdf\u5ba4|\u4e0a\u73ed\u90a3\u70b9\u4e8b\u513f|\u5468top|\u8d5b\u6bb5|\u76f4\u62cd|REACTION|VLOG|\u5168\u7eaa\u5f55|\u5f00\u64ad|\u5148\u5bfc|\u603b\u5ba3|\u5c55\u6f14|\u96c6\u9526|\u65c5\u884c\u65e5\u8bb0|\u7cbe\u5f69\u5206\u4eab|\u5267\u60c5\u63ed\u79d8", 2);
        this.KJ = new ArrayList<String>(Arrays.asList("http://127.0.0.1:10001/danmuku?act=search&name="));
        this.q = new ArrayList<String>(Arrays.asList("http://127.0.0.1:10001/danmuku?url="));
        this.B = new ArrayList<String>(Arrays.asList("https://dmku.hls.one/?ac=dm&url="));
        this.F5 = new ArrayList<Zc>();
        this.v3 = new LinkedHashMap();
        this.Gc = string;
        this.SN = string2;
    }

    public static /* synthetic */ void B(w4 w42, EditText editText, EditText editText2, Activity activity, LinearLayout.LayoutParams layoutParams) {
        w42.Nl(editText, editText2, activity, layoutParams);
    }

    public static /* synthetic */ void Gc(w4 w42, String object, String object2, Activity activity, LinearLayout.LayoutParams layoutParams) {
        Objects.requireNonNull(w42);
        try {
            object2 = w42.v3((String)object, (String)object2);
            object = new yj_0(w42, (List)object2, activity, layoutParams);
            activity.runOnUiThread((Runnable)object);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            activity.runOnUiThread((Runnable)new W((Object)w42, activity, (Object)layoutParams, 3));
        }
    }

    private static String Gd(String string) {
        String string2;
        String string3 = string2 = uA.zH;
        if (string2.startsWith("8J+")) {
            string3 = new String(Base64.decode((String)string2, (int)0));
        }
        return string.replace("4K", "").replace("4k", "").replace("1080", "").replace("2160", "").replace("\uff08\u81fb\u5f69\uff09", "").replace("(\u81fb\u5f69)", "").replace("\uff08\u771f\u5f69\uff09", "").replace("\u7ca4\u8bed\u7248", "").replace("\u3010\u7ca4\u8bed\u7248\u3011", "").replace("\u3010\u56fd\u8bed\u7248\u3011", "").replace("[\u7ca4\u8bed\u7248]", "").replace("[\u56fd\u8bed\u7248]", "").replace("\u7ca4\u8bed", "").replace("\u56fd\u8bed", "").replace("\u56fd\u8bed\u7248", "").replaceAll("[a-zA-Z]26\\d", "").replaceAll("[a-zA-Z][a-zA-Z]4", "").replaceAll("19\\d\\d", "").replaceAll("20\\d\\d", "").replaceAll("\\d+-\\d+", "").replaceAll("\u7b2c\\d+\u5b63", "").replaceAll("[\\[][^\\]]*[\\]]", "").replace(string3, "").trim();
    }

    private void H(Button button) {
        String string;
        if (Pan.Nl.tF()) {
            button.setText((CharSequence)"\u5f39\u5e55\u670d\u52a1\u5df2\u542f\u7528");
            string = "#2196F3";
        } else {
            button.setText((CharSequence)"\u5f39\u5e55\u670d\u52a1\u5df2\u7981\u7528");
            string = "#E27C74";
        }
        this.n(button, string, "#1565C0");
    }

    public static /* synthetic */ void KJ(w4 w42, Button button) {
        w42.g(button);
    }

    public static /* synthetic */ void M(w4 w42, Activity activity, EditText editText) {
        if (w42.G.getWindow() != null) {
            double d;
            double d2;
            w42 = w42.G.getWindow();
            WindowManager.LayoutParams layoutParams = w42.getAttributes();
            Rect rect = new Rect();
            w42.getDecorView().getWindowVisibleDisplayFrame(rect);
            int n2 = rect.width();
            rect.height();
            if (activity.getResources().getConfiguration().orientation == 2) {
                d2 = n2;
                d = 0.6;
            } else {
                d2 = n2;
                d = 0.9;
            }
            Double.isNaN(d2);
            layoutParams.width = (int)(d2 * d);
            layoutParams.height = -2;
            w42.setAttributes(layoutParams);
            editText.requestFocus();
        }
    }

    /*
     * WARNING - void declaration
     */
    public static void N(w4 w42, List list, Activity activity, LinearLayout.LayoutParams layoutParams) {
        int n2;
        Object object;
        w42.G4.removeAllViews();
        w42.F5 = list;
        w42.v3.clear();
        Object object2 = w42.F5;
        if (object2 != null) {
            ((AbstractMap)w42.v3).put("\u5168\u90e8", (List<Zc>)object2);
            for (Zc zc : w42.F5) {
                void object4;
                if (zc == null) continue;
                String string = zc.SN();
                object2 = string;
                if (string == null) {
                    object2 = "\u672a\u77e5";
                }
                Object object3 = object = w42.v3.get(object2);
                if (object == null) {
                    ArrayList arrayList = new ArrayList();
                    ((AbstractMap)w42.v3).put((String)object2, arrayList);
                }
                object4.add(zc);
            }
        }
        w42.dT.removeAllViews();
        for (String string : w42.v3.keySet()) {
            object = new Button(w42.dT.getContext());
            List<Zc> list2 = w42.v3.get(string);
            StringBuilder stringBuilder = oX.yq(string, "(");
            stringBuilder.append(list2.size());
            stringBuilder.append(")");
            object.setText((CharSequence)stringBuilder.toString());
            object.setTextColor(-1);
            object.setAllCaps(false);
            object.setTextSize(12.0f);
            w42.un((Button)object, "#2196F3", "#1565C0");
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, ME.q(36));
            layoutParams2.rightMargin = ME.q(6);
            object.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
            object.setOnClickListener((View.OnClickListener)new fm_0(w42, string, (Button)object));
            object.setOnFocusChangeListener((View.OnFocusChangeListener)new hu(w42, string, (Button)object));
            w42.dT.addView((View)object);
        }
        w42.Zm(w42.F5);
        if (list != null && list.size() > 0) {
            n2 = list.size();
            list = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)list);
            int n3 = ((DisplayMetrics)list).heightPixels;
            int n4 = ME.q(60);
            int n5 = ME.q(16);
            double d = n3;
            Double.isNaN(d);
            Double.isNaN(d);
            Double.isNaN(d);
            n3 = (int)(d * 0.7);
            n2 = Math.min(Math.max(n4 * n2 + n5, ME.q(100)), n3);
        } else {
            n2 = ME.q(100);
        }
        layoutParams.height = n2;
        w42.G4.requestLayout();
        list = w42.G.getWindow().getAttributes();
        ((WindowManager.LayoutParams)list).height = ME.q(180) + n2;
        w42.G.getWindow().setAttributes((WindowManager.LayoutParams)list);
    }

    private void Nl(EditText editText, EditText object, Activity activity, LinearLayout.LayoutParams layoutParams) {
        String string = editText.getText().toString();
        object = object.getText().toString();
        if (ME.ee(string)) {
            return;
        }
        this.v3.clear();
        this.F5 = new ArrayList<Zc>();
        ((InputMethodManager)activity.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
        this.G4.removeAllViews();
        this.G4.setVisibility(0);
        editText = new ProgressBar((Context)activity);
        editText.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -2, 1.0f));
        this.G4.addView((View)editText);
        new Thread(new Qp(this, string, (String)object, activity, layoutParams)).start();
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String O(Response object) {
        int n2;
        if (object == null) return "";
        if (object.body() == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(object.body().byteStream(), "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        object = new char[1024];
        while ((n2 = bufferedReader.read((char[])object)) != -1) {
            stringBuilder.append((char[])object, 0, n2);
        }
        object = stringBuilder.toString();
        bufferedReader.close();
        return object;
        catch (Throwable throwable) {
            try {
                bufferedReader.close();
                throw throwable;
            }
            catch (Throwable throwable2) {
                try {
                    throwable.addSuppressed(throwable2);
                    throw throwable;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
        return "";
    }

    private void OW(String charSequence, String string) {
        W = ((String)charSequence).replace("|", "-");
        charSequence = oi_0.yq("http://127.0.0.1:9978/action?do=refresh&type=danmaku&path=");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ProxyOrigin.getOwnProxyUrl());
        stringBuilder.append("proxy?do=danmu&act=push&url=");
        stringBuilder.append(URLEncoder.encode(string));
        ((StringBuilder)charSequence).append(URLEncoder.encode(stringBuilder.toString()));
        Bo.tF(((StringBuilder)charSequence).toString());
    }

    public static /* synthetic */ void SN(w4 w42, String string, Button button, boolean bl) {
        Objects.requireNonNull(w42);
        if (bl) {
            w42.s(string, button);
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String W(String charSequence) {
        try {
            boolean bl;
            Object object = new HashMap();
            ((HashMap)object).put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36");
            HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("top", "5");
            hashMap.put("right", "1");
            hashMap.put("left", "6");
            hashMap.put("bottom", "4");
            ArrayList<String> arrayList = new ArrayList<String>();
            charSequence = this.ee((String)charSequence, this.B, "data");
            if (ME.ee((String)charSequence)) {
                return null;
            }
            Iterator iterator = JsonParser.parseString((String)charSequence).getAsJsonObject().getAsJsonArray("danmuku").iterator();
            int n2 = 0;
            while (bl = iterator.hasNext()) {
                object = ((JsonElement)iterator.next()).getAsJsonArray();
                int n3 = object.get(0).getAsInt();
                charSequence = object.get(4).getAsString();
                int n4 = n2;
                if (!((String)charSequence).contains("danmuku")) {
                    n4 = n2;
                    if (!((String)charSequence).contains("danum")) {
                        if (((String)charSequence).contains("4K\u52a8\u6f2bAPP\u4e0b\u8f7d\u5730\u5740\uff1a123dm.xyz")) {
                            n4 = n2;
                        } else {
                            void var7_11;
                            n4 = n2 + 1;
                            String[] stringArray = this.yq;
                            for (n2 = 0; n2 < stringArray.length; charSequence = ((String)charSequence).replace(stringArray[n2], ""), ++n2) {
                            }
                            String string = object.get(1).getAsString();
                            CharSequence charSequence2 = object.get(2).getAsString();
                            object = object.size() > 7 ? object.get(7).getAsString() : "24px";
                            if (((String)hashMap.get(string)).isEmpty()) {
                                String string2 = "6";
                            } else {
                                String string3 = (String)hashMap.get(string);
                            }
                            String string4 = ((String)charSequence2).replace("#", "");
                            Objects.requireNonNull(string4);
                            charSequence2 = string4;
                            if (string4.length() < 6) {
                                charSequence2 = new StringBuilder(6);
                                ((StringBuilder)charSequence2).append(string4);
                                for (n2 = string4.length(); n2 < 6; ++n2) {
                                    ((StringBuilder)charSequence2).append('F');
                                }
                                charSequence2 = ((StringBuilder)charSequence2).toString();
                            }
                            arrayList.add(String.format("<d p=\"%d,%s,%s,%d\">%s</d>", n3, var7_11, ((String)object).toLowerCase().replace("px", ""), Integer.parseInt((String)charSequence2, 16), charSequence));
                        }
                    }
                }
                n2 = n4;
            }
            if (n2 == 0) {
                return null;
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><i><chatserver>chat.bilibili.com</chatserver><chatid>52175602</chatid><mission>0</mission><maxlimit>1000</maxlimit><state>0</state><real_name>0</real_name><source>k-v</source>");
            object = new StringBuilder();
            Iterator iterator2 = arrayList.iterator();
            if (iterator2.hasNext()) {
                while (true) {
                    ((StringBuilder)object).append((CharSequence)iterator2.next());
                    if (!iterator2.hasNext()) break;
                    ((StringBuilder)object).append((CharSequence)"");
                }
            }
            ((StringBuilder)charSequence).append(((StringBuilder)object).toString());
            ((StringBuilder)charSequence).append("</i>");
            return ((StringBuilder)charSequence).toString();
        }
        catch (Exception exception) {
            InitOrigin.show("\u5f39\u5e55\u5904\u7406\u5f02\u5e38");
            return null;
        }
    }

    private void Zm(List<Zc> linearLayout) {
        Object object = linearLayout;
        if (linearLayout == null) {
            object = new ArrayList();
        }
        if ((linearLayout = this.G4) == null) {
            return;
        }
        linearLayout = linearLayout.getContext();
        this.G4.removeAllViews();
        if (object.isEmpty()) {
            linearLayout = new TextView((Context)linearLayout);
            linearLayout.setText((CharSequence)"\u672a\u627e\u5230\u5339\u914d\u7684\u5f39\u5e55");
            linearLayout.setTextColor(-7829368);
            linearLayout.setGravity(17);
            this.G4.addView((View)linearLayout);
            return;
        }
        object = object.iterator();
        while (object.hasNext()) {
            Zc zc = (Zc)object.next();
            LinearLayout linearLayout2 = new LinearLayout((Context)linearLayout);
            linearLayout2.setOrientation(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            linearLayout2.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            layoutParams = new Button((Context)linearLayout);
            layoutParams.setText((CharSequence)zc.yq());
            layoutParams.setTextSize(13.0f);
            layoutParams.setAllCaps(false);
            layoutParams.setSingleLine(true);
            layoutParams.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            layoutParams.setMarqueeRepeatLimit(-1);
            layoutParams.setFocusableInTouchMode(true);
            layoutParams.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, ME.q(45)));
            layoutParams.setOnClickListener((View.OnClickListener)new af_0(this, zc));
            linearLayout2.addView((View)layoutParams);
            this.G4.addView((View)linearLayout2);
        }
    }

    private void g(Button button) {
        if (Pan.Nl.tF()) {
            p7.i("goDanMuServer", "\u5173\u95ed");
            InitOrigin.execute(A5.yq);
            Pan.Nl.Gc(false);
            this.H(button);
        } else {
            p7.i("goDanMuServer", "\u9ed8\u8ba4");
            if (Tq.ee != null) {
                InitOrigin.execute(Qf.yq);
            }
            Pan.Nl.Gc(true);
            this.H(button);
            DexNative.danmuStart(true);
        }
    }

    private Response g9(String string, boolean bl) {
        block5: {
            Response response;
            block4: {
                response = w2.M(string, ME.yq(), 15);
                if (response.code() != 200) break block4;
                return response;
            }
            if (response.code() == 200 || !bl) break block5;
            try {
                response.close();
                Thread.sleep(2000L);
                response = this.g9(string, false);
                return response;
            }
            catch (Exception exception) {
                Thread.sleep(2000L);
                if (!bl) break block5;
                return this.g9(string, false);
            }
        }
        return null;
    }

    public static /* synthetic */ void i(w4 w42, String string, Button button) {
        w42.s(string, button);
    }

    private void n(Button button, String string, String string2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float)ME.q(4));
        int n2 = button.hasFocus() ? Color.parseColor((String)string2) : Color.parseColor((String)string);
        gradientDrawable.setColor(n2);
        button.setBackground((Drawable)gradientDrawable);
        button.setOnFocusChangeListener(new View.OnFocusChangeListener(this, button, string, string2){
            final String N;
            final String SN;
            final w4 tF;
            final Button yq;
            {
                this.tF = w42;
                this.yq = button;
                this.SN = string;
                this.N = string2;
            }

            public final void onFocusChange(View view, boolean bl) {
                this.tF.n(this.yq, this.SN, this.N);
            }
        });
    }

    public static /* synthetic */ void q() {
        xa.set(false);
    }

    private void s(String string, Button button) {
        Button button2 = this.t0;
        if (button2 != null) {
            this.un(button2, "#2196F3", "#1565C0");
        }
        this.un(button, "#1565C0", "#0D47A1");
        this.t0 = button;
        this.Zm(this.v3.get(string));
    }

    public static /* synthetic */ void t0(w4 w42, Zc zc) {
        Objects.requireNonNull(w42);
        try {
            w42.OW(zc.yq(), zc.N());
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    /*
     * Exception decompiling
     */
    public static void tF(w4 var0, boolean var1_1, Pipe.SinkChannel var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 7[TRYBLOCK] [13 : 150->160)] java.lang.Throwable
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

    private void un(Button button, String string, String string2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor((String)string2));
        gradientDrawable.setCornerRadius((float)ME.q(4));
        stateListDrawable.addState(new int[]{16842908}, (Drawable)gradientDrawable);
        string2 = new GradientDrawable();
        string2.setColor(Color.parseColor((String)string));
        string2.setCornerRadius((float)ME.q(4));
        stateListDrawable.addState(new int[0], (Drawable)string2);
        button.setBackground((Drawable)stateListDrawable);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private String v(String string) {
        boolean bl = string.contains("S0");
        String string2 = "";
        if (!bl && !string.contains("s0")) {
            Matcher matcher = this.tF.matcher(string);
            string = string2;
            if (!matcher.find()) return string;
            string = string2 = matcher.group(1);
            if (string2.length() <= 0) return string;
            string = string2;
            if (string2.charAt(0) != '0') return string;
            return string2.replace("0", "");
        }
        Matcher matcher = this.zH.matcher(string);
        string = string2;
        if (!matcher.find()) return string;
        string = string2 = matcher.group(1);
        if (string2.length() <= 0) return string;
        string = string2;
        if (string2.charAt(0) != '0') return string;
        return string2.replace("0", "");
    }

    private List<Zc> v3(String string, String object) {
        ArrayList<Zc> arrayList;
        block10: {
            int n2;
            JSONArray jSONArray;
            Object object2;
            block9: {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(URLEncoder.encode(string));
                ((StringBuilder)object2).append("&regSrc=");
                ((StringBuilder)object2).append((String)object);
                object = this.ee(((StringBuilder)object2).toString(), this.KJ, "search");
                if (!ME.ee((String)object)) break block9;
                return null;
            }
            try {
                arrayList = new ArrayList<Zc>();
                if (!object.contains(string)) break block10;
                jSONArray = new JSONArray((String)object);
                n2 = 0;
            }
            catch (Exception exception) {
                System.out.println(exception);
                return null;
            }
            while (true) {
                String string2;
                block12: {
                    block11: {
                        if (n2 >= jSONArray.length()) break;
                        string = jSONArray.getJSONObject(n2);
                        object2 = string.getString("name");
                        string2 = string.getString("url");
                        string = "\u5176\u5b83";
                        object = ((String)object2).split("\\|");
                        if (((String[])object).length <= 1) break block11;
                        string = object[0];
                        object = ((String)object2).substring(string.length() + 1);
                        break block12;
                    }
                    object = object2;
                }
                if (!this.M.matcher((CharSequence)object2).find()) {
                    object2 = new Zc();
                    ((Zc)object2).zH(string);
                    ((Zc)object2).tF((String)object);
                    ((Zc)object2).i(string2);
                    arrayList.add((Zc)object2);
                }
                ++n2;
                continue;
                break;
            }
        }
        return arrayList;
    }

    private static String xa(String string) {
        String string2;
        String string3 = string2 = uA.zH;
        if (string2.startsWith("8J+")) {
            string3 = new String(Base64.decode((String)string2, (int)0));
        }
        return string.replace("4K", "").replace(string3, "").replace("\u6b63\u5728\u64ad\u653e\uff1a", "").replace("4k", "").replace("1080", "").replace("2160", "").replace("120FPS", "").replace("60FPS", "").replace("120fps", "").replace("60fps", "").replaceAll("[a-zA-Z]26\\d", "").replaceAll("[a-zA-Z][a-zA-Z]4", "").replaceAll("19\\d\\d", "").replaceAll("20\\d\\d", "").replace("5.1", "").replace("2.0", "").replace("7.1", "").replace("10BIT", "").replace("10bit", "").replace("H.265", "").replace("h.265", "").replaceAll("\\d+-\\d+", "").replaceAll("\u7b2c\\d+\u5b63", "").replaceAll("[\\[][^\\]]*[\\]]", "");
    }

    public static /* synthetic */ void yq(w4 w42, Activity activity, LinearLayout.LayoutParams layoutParams) {
        w42.G4.removeAllViews();
        activity = new TextView((Context)activity);
        activity.setText((CharSequence)"\u641c\u7d22\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5");
        activity.setGravity(17);
        w42.G4.addView((View)activity);
        layoutParams.height = ME.q(100);
        w42.G4.requestLayout();
    }

    public static /* synthetic */ tF zH(w4 object, String charSequence, String string) {
        Objects.requireNonNull(object);
        if (string.startsWith("http")) {
            charSequence = oi_0.yq((String)charSequence);
            string = URLEncoder.encode(string);
        } else {
            charSequence = oi_0.yq((String)charSequence);
        }
        ((StringBuilder)charSequence).append(string);
        object = ((w4)object).g9(((StringBuilder)charSequence).toString(), true);
        object = object != null && object.isSuccessful() && object.code() == 200 ? new tF((Response)object) : null;
        return object;
    }

    public final Object[] Dr() {
        Object[] objectArray;
        System.gc();
        if (this.i) {
            objectArray = null;
        } else {
            this.i = true;
            Object object = Pipe.open();
            objectArray = ((Pipe)object).sink();
            object = ((Pipe)object).source();
            new Thread(new lW(this, (Pipe.SinkChannel)objectArray)).start();
            objectArray = new Object[]{200, "text/xml; charset=utf-8", Channels.newInputStream((ReadableByteChannel)object)};
        }
        return objectArray;
    }

    /*
     * WARNING - combined exceptions agressively - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object F5() {
        String string = "";
        if (Gd.get()) {
            if (Gd.get()) return null;
            return this.F5();
        }
        Gd.set(true);
        try {
            Object object;
            Object object2;
            Object object3;
            block20: {
                block19: {
                    block17: {
                        block18: {
                            v = "";
                            object3 = new JSONObject();
                            int n2 = 0;
                            while (true) {
                                object2 = object3;
                                if (n2 >= 10) break;
                                object2 = InitOrigin.getActivity().getComponentName().getClassName();
                                if (!(((String)object2).contains("VideoActivity") || ((String)object2).contains("github.tvbox.osc.ui.activity.DetailActivity") || ((String)object2).contains("PlayActivity"))) {
                                    return null;
                                }
                                object = Bo.B("http://127.0.0.1:9978/media", null);
                                object2 = object3;
                                if (!((String)object).isEmpty()) {
                                    object2 = object3 = new JSONObject((String)object);
                                    if (object3.has("title")) {
                                        object2 = object3;
                                        if (object3.getString("title").length() > 0) {
                                            object2 = object3;
                                            break;
                                        }
                                    }
                                }
                                Thread.sleep(500L);
                                ++n2;
                                object3 = object2;
                            }
                            object3 = object2.optString("artist");
                            ee = object3;
                            if (!ME.ee((String)object3)) break block17;
                            object3 = object2.getString("title");
                            if (!((String)object3).contains(" ")) break block18;
                            object3 = ((String)object3).split(" ");
                            ee = object3[1];
                            object3 = object3[0];
                            break block19;
                        }
                        object3 = w4.Gd((String)object3);
                        break block20;
                    }
                    object3 = object2.getString("title");
                }
                object3 = w4.Gd((String)object3);
            }
            object2 = ee;
            if (ME.zH.contains(ME.dT((String)object2).toLowerCase())) {
                return null;
            }
            if (g9.equals(object3) && !ME.ee("")) {
                object3 = string;
            }
            string = this.v(w4.xa(ee));
            object2 = new ArrayList();
            boolean bl = this.Gc.contains("v.qq.com");
            if (!(bl || this.Gc.contains("www.mgtv.com") || this.Gc.contains("www.iqiyi.com") || this.Gc.contains("v.youku.com") || this.SN.equals("push"))) {
                object2 = this.v3((String)object3, string);
            } else {
                object = new Zc();
                ((Zc)object).i(this.Gc);
                ((ArrayList)object2).add(object);
            }
            if (!object2.isEmpty()) {
                object = ((Zc)object2.get(0)).N();
                if (!this.SN.equals("push")) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append((String)object3);
                    stringBuilder.append("-");
                    stringBuilder.append(string);
                    W = stringBuilder.toString();
                }
                string = this.ee((String)object, this.q, "data");
                object3 = string;
                if (ME.ee(string)) {
                    object3 = this.W((String)object);
                }
                if (!ME.ee((String)object3)) {
                    v = object3;
                    return object3;
                }
            }
            if (!object2.isEmpty()) return null;
            InitOrigin.show("\u81ea\u52a8\u5339\u914d\u4e0d\u5230\u5f39\u5e55\uff08\u8bf7\u624b\u52a8\u641c\u7d22\uff09");
            return null;
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
        return null;
    }

    public final void b(String string, String string2) {
        Activity activity = InitOrigin.getActivity();
        LinearLayout linearLayout = new LinearLayout((Context)activity);
        linearLayout.setOrientation(1);
        int n2 = ME.q(16);
        linearLayout.setPadding(n2, n2, n2, n2);
        LinearLayout linearLayout2 = new LinearLayout((Context)activity);
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
        linearLayout2.setWeightSum(2.0f);
        EditText editText = new EditText((Context)activity);
        editText.setHint((CharSequence)"\u89c6\u9891\u540d\u79f0");
        editText.setText((CharSequence)string);
        g9 = string;
        editText.setTextSize(14.0f);
        editText.setGravity(17);
        string = new LinearLayout.LayoutParams(0, ME.q(40));
        ((LinearLayout.LayoutParams)string).weight = 1.5f;
        editText.setLayoutParams((ViewGroup.LayoutParams)string);
        linearLayout2.addView((View)editText);
        string = new EditText((Context)activity);
        string.setHint((CharSequence)"\u96c6\u6570");
        string.setText((CharSequence)string2);
        string.setTextSize(14.0f);
        string.setGravity(17);
        string2 = new LinearLayout.LayoutParams(0, ME.q(40));
        ((LinearLayout.LayoutParams)string2).weight = 0.5f;
        ((LinearLayout.LayoutParams)string2).leftMargin = ME.q(8);
        string.setLayoutParams((ViewGroup.LayoutParams)string2);
        linearLayout2.addView((View)string);
        linearLayout.addView((View)linearLayout2);
        LinearLayout linearLayout3 = new LinearLayout((Context)activity);
        linearLayout3.setOrientation(0);
        linearLayout3.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
        linearLayout3.setWeightSum(2.0f);
        string2 = new Button((Context)activity);
        string2.setText((CharSequence)"\u641c\u7d22\u5f39\u5e55");
        string2.setTextColor(-1);
        string2.setFocusable(true);
        this.un((Button)string2, "#2196F3", "#1565C0");
        linearLayout2 = new LinearLayout.LayoutParams(0, ME.q(40));
        linearLayout2.weight = 1.0f;
        linearLayout2.rightMargin = ME.q(4);
        linearLayout3.addView((View)string2, (ViewGroup.LayoutParams)linearLayout2);
        linearLayout2 = new Button((Context)activity);
        linearLayout2.setTextColor(-1);
        linearLayout2.setFocusable(true);
        this.H((Button)linearLayout2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, ME.q(40));
        layoutParams.weight = 1.0f;
        layoutParams.leftMargin = ME.q(4);
        linearLayout3.addView((View)linearLayout2, (ViewGroup.LayoutParams)layoutParams);
        layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = ME.q(8);
        linearLayout.addView((View)linearLayout3, (ViewGroup.LayoutParams)layoutParams);
        linearLayout3 = new HorizontalScrollView((Context)activity);
        layoutParams = new LinearLayout((Context)activity);
        this.dT = layoutParams;
        layoutParams.setOrientation(0);
        linearLayout3.addView((View)this.dT);
        layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = ME.q(8);
        linearLayout.addView((View)linearLayout3, (ViewGroup.LayoutParams)layoutParams);
        linearLayout3 = new ScrollView((Context)activity);
        linearLayout3.setFillViewport(true);
        layoutParams = new LinearLayout((Context)activity);
        this.G4 = layoutParams;
        layoutParams.setOrientation(1);
        this.G4.setGravity(48);
        linearLayout3.addView((View)this.G4);
        layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.topMargin = ME.q(8);
        layoutParams.weight = 1.0f;
        linearLayout.addView((View)linearLayout3, (ViewGroup.LayoutParams)layoutParams);
        linearLayout3.setFillViewport(true);
        linearLayout3.setPadding(0, 0, 0, ME.q(20));
        this.G4.setPadding(0, 0, 0, ME.q(10));
        linearLayout = new AlertDialog.Builder((Context)activity).setView((View)linearLayout).create();
        this.G = linearLayout;
        linearLayout.setOnShowListener((DialogInterface.OnShowListener)new sn_0(this, activity, editText));
        string2.setOnClickListener((View.OnClickListener)new SE(this, editText, (EditText)string, activity, layoutParams));
        string2.setOnKeyListener(new View.OnKeyListener(this, editText, (EditText)string, activity, layoutParams){
            final Activity N;
            final EditText SN;
            final LinearLayout.LayoutParams tF;
            final EditText yq;
            final w4 zH;
            {
                this.zH = w42;
                this.yq = editText;
                this.SN = editText2;
                this.N = activity;
                this.tF = layoutParams;
            }

            public final boolean onKey(View view, int n2, KeyEvent keyEvent) {
                if ((n2 == 23 || n2 == 66) && keyEvent.getAction() == 1) {
                    this.zH.Nl(this.yq, this.SN, this.N, this.tF);
                    return true;
                }
                return false;
            }
        });
        linearLayout2.setOnClickListener((View.OnClickListener)new PE(this, (Button)linearLayout2));
        linearLayout2.setOnKeyListener(new View.OnKeyListener(this, (Button)linearLayout2){
            final w4 SN;
            final Button yq;
            {
                this.SN = w42;
                this.yq = button;
            }

            public final boolean onKey(View view, int n2, KeyEvent keyEvent) {
                if ((n2 == 23 || n2 == 66) && keyEvent.getAction() == 1) {
                    this.SN.g(this.yq);
                    return true;
                }
                return false;
            }
        });
        this.G.setOnDismissListener((DialogInterface.OnDismissListener)qv.SN);
        this.G.show();
    }

    /*
     * WARNING - void declaration
     */
    public final String ee(String object3, List<String> list, String string) {
        void var2_10;
        if (var2_10.size() == 0) {
            return null;
        }
        ExecutorService executorService = Executors.newFixedThreadPool(var2_10.size());
        ExecutorCompletionService executorCompletionService = new ExecutorCompletionService(executorService);
        ArrayList arrayList = new ArrayList();
        Object object = var2_10.iterator();
        while (object.hasNext()) {
            arrayList.add(executorCompletionService.submit(new kY(this, (String)object.next(), (String)object3)));
        }
        for (int i2 = 0; i2 < var2_10.size(); ++i2) {
            Response response;
            block8: {
                void var3_11;
                tF tF2 = (tF)executorCompletionService.take().get();
                if (tF2 == null) continue;
                response = tF2.yq();
                if (!var3_11.equals("data")) break block8;
                object = w4.O(response);
                if (!((String)object).contains("<i>") || ((String)object).length() <= 300) continue;
                for (Future future : arrayList) {
                    if (future.isDone() || future.isCancelled()) continue;
                    future.cancel(true);
                }
                return object;
            }
            try {
                String string2 = w4.O(response);
                return string2;
            }
            catch (Exception exception) {
                PrintStream printStream = System.out;
                object = new StringBuilder();
                ((StringBuilder)object).append("Execution-Error retrieving task result-");
                ((StringBuilder)object).append(exception);
                printStream.println(((StringBuilder)object).toString());
            }
        }
        executorService.shutdown();
        return null;
    }

    public final void g1() {
        block2: {
            Object object;
            Object object2;
            block6: {
                block5: {
                    block3: {
                        String string;
                        block4: {
                            if (xa.get()) break block2;
                            xa.set(true);
                            object2 = new JSONObject();
                            int n2 = 0;
                            while (true) {
                                object = object2;
                                if (n2 >= 10) break;
                                object = Bo.B("http://127.0.0.1:9978/media", null);
                                if (!((String)object).isEmpty()) {
                                    object = new JSONObject((String)object);
                                    object2 = object;
                                    if (object.has("title")) break;
                                }
                                Thread.sleep(1000L);
                                ++n2;
                            }
                            if (!ME.ee((String)(object2 = object.optString("artist")))) break block3;
                            string = object.getString("title");
                            if (!string.contains(" ")) break block4;
                            object = object.getString("title").split(" ");
                            object2 = object[1];
                            object = object[0];
                            break block5;
                        }
                        object = w4.Gd(string);
                        break block6;
                    }
                    object = object.getString("title");
                }
                object = w4.Gd((String)object);
            }
            object2 = this.v(w4.xa((String)object2));
            InitOrigin.getActivity().runOnUiThread((Runnable)new W((Object)this, (String)object, object2, 2));
        }
    }

    private static final class tF {
        private Response yq;

        public tF(Response response) {
            this.yq = response;
        }

        public final Response yq() {
            return this.yq;
        }
    }
}

