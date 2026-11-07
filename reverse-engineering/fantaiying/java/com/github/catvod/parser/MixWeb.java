/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  org.json.JSONObject
 */
package com.github.catvod.parser;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.json.JSONObject;

public class MixWeb {
    static HashMap<String, ArrayList<String>> SN;
    public static HashMap<String, ArrayList<String>> yq;

    static {
        yq = new HashMap();
        SN = null;
    }

    public static Object[] loadHtml(String object, String charSequence) {
        String string;
        block6: {
            string = new String(Base64.decode((String)charSequence, (int)10), "UTF-8");
            charSequence = new StringBuilder();
            if (!yq.containsKey(object)) break block6;
            object = yq.get(object);
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
     * Exception decompiling
     */
    public static JSONObject parse(LinkedHashMap<String, HashMap<String, String>> var0, String var1_2, String var2_4, String var3_5) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 11[UNCONDITIONALDOLOOP]
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
}

