/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.K1;
import com.github.catvod.spider.merge.Mm;
import com.github.catvod.spider.merge.VG;
import com.github.catvod.spider.merge.b9;
import com.github.catvod.spider.merge.jM;
import com.github.catvod.spider.merge.oi_0;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;

public final class sx
implements VG {
    private String B;
    private String G;
    private int Gc;
    private Map<String, String> KJ;
    private Map<String, List<String>> M;
    private final OutputStream N;
    private final b9 SN;
    private int i;
    private Mm q;
    private String t0;
    private final BufferedInputStream tF;
    private final jM yq;
    private int zH;

    public sx(jM object, b9 b92, InputStream inputStream, OutputStream outputStream, InetAddress inetAddress) {
        this.yq = object;
        this.SN = b92;
        this.tF = new BufferedInputStream(inputStream, 8192);
        this.N = outputStream;
        object = !inetAddress.isLoopbackAddress() && !inetAddress.isAnyLocalAddress() ? inetAddress.getHostAddress().toString() : "127.0.0.1";
        this.B = object;
        this.KJ = new HashMap<String, String>();
    }

    private int t0(byte[] byArray, int n2) {
        int n3;
        int n4 = 0;
        while ((n3 = n4 + 1) < n2) {
            int n5;
            if (byArray[n4] == 13 && byArray[n3] == 10 && (n5 = n4 + 3) < n2 && byArray[n4 + 2] == 13 && byArray[n5] == 10) {
                return n4 + 4;
            }
            if (byArray[n4] == 10 && byArray[n3] == 10) {
                return n4 + 2;
            }
            n4 = n3;
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void tF(BufferedReader object, Map<String, String> object2, Map<String, List<String>> object3, Map<String, String> map) {
        Object object4 = K1.tF;
        try {
            String string = ((BufferedReader)object).readLine();
            if (string == null) {
                return;
            }
            Object object5 = new StringTokenizer(string);
            if (!((StringTokenizer)object5).hasMoreTokens()) {
                object = new jM.yq((K1)object4, "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
                throw object;
            }
            object2.put("method", ((StringTokenizer)object5).nextToken());
            if (!((StringTokenizer)object5).hasMoreTokens()) {
                object = new jM.yq((K1)object4, "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
                throw object;
            }
            object4 = ((StringTokenizer)object5).nextToken();
            int n2 = ((String)object4).indexOf(63);
            if (n2 >= 0) {
                this.zH(((String)object4).substring(n2 + 1), (Map<String, List<String>>)object3);
                object3 = jM.yq(((String)object4).substring(0, n2));
            } else {
                object3 = jM.yq((String)object4);
            }
            if (((StringTokenizer)object5).hasMoreTokens()) {
                this.G = ((StringTokenizer)object5).nextToken();
            } else {
                this.G = "HTTP/1.1";
                jM.KJ.log(Level.FINE, "no protocol version specified, strange. Assuming HTTP/1.1.");
            }
            while ((object5 = ((BufferedReader)object).readLine()) != null && !((String)object5).trim().isEmpty()) {
                n2 = ((String)object5).indexOf(58);
                if (n2 < 0) continue;
                map.put(((String)object5).substring(0, n2).trim().toLowerCase(Locale.US), ((String)object5).substring(n2 + 1).trim());
            }
            object2.put("uri", object3);
            return;
        }
        catch (IOException iOException) {
            object2 = oi_0.yq("SERVER INTERNAL ERROR: IOException: ");
            ((StringBuilder)object2).append(iOException.getMessage());
            jM.yq yq2 = new jM.yq(((StringBuilder)object2).toString(), iOException);
            throw yq2;
        }
    }

    private void zH(String string, Map<String, List<String>> map) {
        if (string == null) {
            return;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(string, "&");
        while (stringTokenizer.hasMoreTokens()) {
            List<String> list;
            String string2;
            string = stringTokenizer.nextToken();
            int n2 = string.indexOf(61);
            if (n2 >= 0) {
                string2 = jM.yq(string.substring(0, n2)).trim();
                string = jM.yq(string.substring(n2 + 1));
            } else {
                string2 = jM.yq(string).trim();
                string = "";
            }
            List<String> list2 = list = map.get(string2);
            if (list == null) {
                list2 = new ArrayList<String>();
                map.put(string2, list2);
            }
            list2.add(string);
        }
    }

    @Override
    public final Map<String, String> N() {
        return this.KJ;
    }

    @Override
    public final String SN() {
        return this.t0;
    }

    @Override
    public final Map<String, List<String>> getParameters() {
        return this.M;
    }

    /*
     * Exception decompiling
     */
    public final void i() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 22[TRYBLOCK] [135, 134, 133, 132, 131, 130 : 763->768)] java.lang.Throwable
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

    @Override
    public final int yq() {
        return this.Gc;
    }
}

