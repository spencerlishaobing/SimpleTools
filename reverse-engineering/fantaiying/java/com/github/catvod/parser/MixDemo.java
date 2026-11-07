/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.github.catvod.parser;

import android.util.Base64;
import com.github.catvod.parser.JsonParallel;
import java.io.ByteArrayInputStream;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class MixDemo {
    private static HashMap<String, ArrayList<String>> SN;
    private static final HashMap<String, ArrayList<String>> yq;

    static {
        yq = new HashMap();
        SN = null;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void SN(LinkedHashMap<String, HashMap<String, String>> linkedHashMap) {
        SN = new HashMap();
        Iterator<String> iterator = linkedHashMap.keySet().iterator();
        block2: while (iterator.hasNext()) {
            String string = iterator.next();
            HashMap<String, String> hashMap = linkedHashMap.get(string);
            Object object = hashMap.get("type");
            if (!((String)object).equals("1") && !((String)object).equals("0")) continue;
            try {
                object = new JSONObject(hashMap.get("ext"));
                JSONArray jSONArray = object.getJSONArray("flag");
                int n = 0;
                while (true) {
                    void var2_8;
                    if (n >= jSONArray.length()) continue block2;
                    String string2 = jSONArray.getString(n);
                    Object object2 = object = SN.get(string2);
                    if (object == null) {
                        ArrayList arrayList = new ArrayList();
                        SN.put(string2, arrayList);
                    }
                    var2_8.add(string);
                    ++n;
                }
            }
            catch (Exception exception) {
                continue;
            }
            break;
        }
        return;
    }

    public static Object[] loadHtml(String object, String charSequence) {
        String string;
        block6: {
            string = new String(Base64.decode((String)charSequence, (int)10), "UTF-8");
            charSequence = new StringBuilder();
            HashMap<String, ArrayList<String>> hashMap = yq;
            if (!hashMap.containsKey(object)) break block6;
            object = hashMap.get(object);
            int n = 0;
            while (true) {
                if (n >= ((ArrayList)object).size()) break;
                ((StringBuilder)charSequence).append("\"");
                ((StringBuilder)charSequence).append((String)((ArrayList)object).get(n));
                ((StringBuilder)charSequence).append("\"");
                if (n < ((ArrayList)object).size() - 1) {
                    ((StringBuilder)charSequence).append(",");
                }
                ++n;
                continue;
                break;
            }
        }
        try {
            object = new ByteArrayInputStream("\n<!doctype html>\n<html>\n<head>\n<title>\u89e3\u6790</title>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n<meta http-equiv=\"X-UA-Compatible\" content=\"IE=EmulateIE10\" />\n<meta name=\"renderer\" content=\"webkit|ie-comp|ie-stand\">\n<meta name=\"viewport\" content=\"width=device-width\">\n</head>\n<body>\n<script>\nvar apiArray=[#jxs#];\nvar urlPs=\"#url#\";\nvar iframeHtml=\"\";\nfor(var i=0;i<apiArray.length;i++){\nvar URL=apiArray[i]+urlPs;\niframeHtml=iframeHtml+\"<iframe sandbox='allow-scripts allow-same-origin allow-forms' frameborder='0' allowfullscreen='true' webkitallowfullscreen='true' mozallowfullscreen='true' src=\"+URL+\"></iframe>\";\n}\ndocument.write(iframeHtml);\n</script>\n</body>\n</html>".replace("#url#", string).replace("#jxs#", ((StringBuilder)charSequence).toString()).toString().getBytes("UTF-8"));
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
        return new Object[]{200, "text/html; charset=\"UTF-8\"", object};
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static JSONObject parse(LinkedHashMap<String, HashMap<String, String>> jSONObject, String serializable, String string, String string2) {
        try {
            if (SN == null) {
                MixDemo.SN((LinkedHashMap<String, HashMap<String, String>>)jSONObject);
            }
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
            serializable = new ArrayList();
            Object object = SN.get(string);
            if (object != null && !((ArrayList)object).isEmpty()) {
                for (int i2 = 0; i2 < ((ArrayList)object).size(); ++i2) {
                    String string3 = ((ArrayList)object).get(i2);
                    HashMap hashMap = (HashMap)jSONObject.get(string3);
                    String string4 = (String)hashMap.get("type");
                    if (string4.equals("1")) {
                        ((AbstractMap)linkedHashMap).put(string3, MixDemo.yq((String)hashMap.get("url"), (String)hashMap.get("ext")));
                        continue;
                    }
                    if (!string4.equals("0")) continue;
                    ((ArrayList)serializable).add((String)hashMap.get("url"));
                }
            } else {
                for (String string5 : jSONObject.keySet()) {
                    HashMap hashMap = (HashMap)jSONObject.get(string5);
                    object = (String)hashMap.get("type");
                    if (((String)object).equals("1")) {
                        ((AbstractMap)linkedHashMap).put(string5, MixDemo.yq((String)hashMap.get("url"), (String)hashMap.get("ext")));
                        continue;
                    }
                    if (!((String)object).equals("0")) continue;
                    ((ArrayList)serializable).add((String)hashMap.get("url"));
                }
            }
            if (!((ArrayList)serializable).isEmpty()) {
                yq.put(string, (ArrayList<String>)serializable);
            }
            if ((jSONObject = JsonParallel.parse(linkedHashMap, string2)).has("url")) {
                return jSONObject;
            }
            if (((ArrayList)serializable).isEmpty()) return new JSONObject();
            jSONObject = new JSONObject();
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("proxy://do=parseMix&flag=");
            ((StringBuilder)serializable).append(string);
            ((StringBuilder)serializable).append("&url=");
            ((StringBuilder)serializable).append(Base64.encodeToString((byte[])string2.getBytes(), (int)10));
            jSONObject.put("url", (Object)((StringBuilder)serializable).toString());
            jSONObject.put("parse", 1);
            return jSONObject;
        }
        catch (Exception exception) {
            return new JSONObject();
        }
    }

    private static String yq(String string, String string2) {
        if (string2.trim().isEmpty()) {
            return string;
        }
        int n = string.indexOf("?");
        if (n == -1) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string.substring(0, ++n));
        stringBuilder.append("cat_ext=");
        stringBuilder.append(Base64.encodeToString((byte[])string2.getBytes(), (int)10));
        stringBuilder.append("&");
        stringBuilder.append(string.substring(n));
        return stringBuilder.toString();
    }
}

