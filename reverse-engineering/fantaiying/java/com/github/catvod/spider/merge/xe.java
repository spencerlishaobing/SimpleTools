/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.K1;
import com.github.catvod.spider.merge.Pu;
import com.github.catvod.spider.merge.gP;
import com.github.catvod.spider.merge.jM;
import com.github.catvod.spider.merge.rP;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPOutputStream;

public final class xe
implements Closeable {
    private boolean Gc;
    private List<String> KJ;
    private boolean M;
    private InputStream N;
    private String SN;
    private final Map<String, String> i;
    private int q = 1;
    private int t0;
    private long tF;
    private Pu yq;
    private final Map<String, String> zH = new HashMap<String, String>(this){
        final xe yq;
        {
            this.yq = xe2;
        }

        @Override
        public final Object put(Object object, Object object2) {
            String string = (String)object;
            String string2 = (String)object2;
            object2 = this.yq.i;
            object = string == null ? string : string.toLowerCase();
            ((HashMap)object2).put(object, string2);
            return super.put(string, string2);
        }
    };

    protected xe(Pu pu, String string, InputStream inputStream, long l) {
        this.i = new HashMap<String, String>();
        this.yq = pu;
        this.SN = string;
        boolean bl = false;
        if (inputStream == null) {
            this.N = new ByteArrayInputStream(new byte[0]);
            this.tF = 0L;
        } else {
            this.N = inputStream;
            this.tF = l;
        }
        if (this.tF < 0L) {
            bl = true;
        }
        this.Gc = bl;
        this.M = true;
        this.KJ = new ArrayList<String>(10);
    }

    private void B(OutputStream outputStream, long l) {
        if (this.v3()) {
            block5: {
                Object var4_4 = null;
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                    outputStream = gZIPOutputStream;
                }
                catch (Exception exception) {
                    InputStream inputStream = this.N;
                    outputStream = var4_4;
                    if (inputStream == null) break block5;
                    inputStream.close();
                    outputStream = var4_4;
                }
            }
            if (outputStream != null) {
                this.q(outputStream, -1L);
                ((GZIPOutputStream)outputStream).finish();
            }
        } else {
            this.q(outputStream, l);
        }
    }

    public static xe Gc(Pu pu, String string, InputStream inputStream, long l) {
        return new xe(pu, string, inputStream, l);
    }

    public static xe i(Pu pu, String string, InputStream inputStream) {
        return new xe(pu, string, inputStream, -1L);
    }

    private void q(OutputStream outputStream, long l) {
        byte[] byArray = new byte[(int)16384L];
        boolean bl = l == -1L;
        while (true) {
            int n2;
            block4: {
                long l2;
                if (l <= 0L && !bl || (n2 = this.N.read(byArray, 0, (int)(l2 = bl ? 16384L : Math.min(l, 16384L)))) <= 0) {
                    return;
                }
                try {
                    outputStream.write(byArray, 0, n2);
                }
                catch (Exception exception) {
                    if (this.N == null) break block4;
                    this.N.close();
                }
            }
            if (bl) continue;
            l -= (long)n2;
        }
    }

    public static xe t0(Pu pu, String object) {
        gP gP2;
        gP gP3;
        block5: {
            gP gP4 = new gP("text/plain");
            if (object == null) {
                return xe.Gc(pu, "text/plain", new ByteArrayInputStream(new byte[0]), 0L);
            }
            gP3 = gP4;
            gP2 = gP4;
            if (Charset.forName(gP4.N()).newEncoder().canEncode((CharSequence)object)) break block5;
            gP2 = gP4;
            gP3 = gP4.tF();
        }
        gP2 = gP3;
        try {
            object = ((String)object).getBytes(gP3.N());
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            jM.KJ.log(Level.SEVERE, "encoding problem, responding nothing", unsupportedEncodingException);
            object = new byte[0];
            gP3 = gP2;
        }
        return xe.Gc(pu, gP3.yq(), new ByteArrayInputStream((byte[])object), ((Object)object).length);
    }

    public final xe F5() {
        this.q = 3;
        return this;
    }

    protected final long G(PrintWriter printWriter, long l) {
        CharSequence charSequence = this.tF("content-length");
        if (charSequence != null) {
            try {
                long l2;
                l = l2 = Long.parseLong((String)charSequence);
            }
            catch (NumberFormatException numberFormatException) {
                Logger logger = jM.KJ;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("content-length was no number ");
                stringBuilder.append((String)charSequence);
                logger.severe(stringBuilder.toString());
            }
        } else {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Content-Length: ");
            ((StringBuilder)charSequence).append(l);
            ((StringBuilder)charSequence).append("\r\n");
            printWriter.print(((StringBuilder)charSequence).toString());
        }
        return l;
    }

    public final void G4(boolean bl) {
        this.M = bl;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void KJ(OutputStream var1_1) {
        var6_3 = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        var6_3.setTimeZone(TimeZone.getTimeZone("GMT"));
        if (this.yq == null) ** GOTO lbl62
        var8_16 = new Iterator<Map.Entry<K, V>>(this.SN);
        var9_15 = new OutputStreamWriter((OutputStream)var1_1, var8_16.N());
        var10_14 = new BufferedWriter(var9_15);
        var7_13 = new PrintWriter(var10_14, false);
        var7_13.append("HTTP/1.1 ").append(((K1)this.yq).yq()).append(" \r\n");
        var8_16 = this.SN;
        if (var8_16 != null) {
            this.M(var7_13, "Content-Type", (String)var8_16);
        }
        if (this.tF("date") == null) {
            var8_16 = new Iterator<Map.Entry<K, V>>();
            this.M(var7_13, "Date", var6_3.format((Date)var8_16));
        }
        for (Map.Entry<K, V> var6_5 : ((HashMap)this.zH).entrySet()) {
            this.M(var7_13, (String)var6_5.getKey(), (String)var6_5.getValue());
        }
        var6_6 = this.KJ.iterator();
        while (var6_6.hasNext()) {
            this.M(var7_13, "Set-Cookie", (String)var6_6.next());
        }
        if (this.tF("connection") == null) {
            if (this.M) {
                var6_7 = "keep-alive";
            } else {
                var6_8 = "close";
            }
            this.M(var7_13, "Connection", (String)var6_9);
        }
        if (this.tF("content-length") != null) {
            this.q = 3;
        }
        if (this.v3()) {
            this.M(var7_13, "Content-Encoding", "gzip");
            this.Gc = true;
        }
        var2_17 = this.N != null ? this.tF : 0L;
        if (this.t0 != 5 && this.Gc) {
            this.M(var7_13, "Transfer-Encoding", "chunked");
            var4_18 = var2_17;
        } else {
            var4_18 = var2_17;
            if (!this.v3()) {
                var4_18 = this.G(var7_13, var2_17);
            }
        }
        var7_13.append("\r\n");
        var7_13.flush();
        if (this.t0 == 5 || !this.Gc) ** GOTO lbl57
        var6_11 = new rP((OutputStream)var1_1);
        this.B(var6_11, -1L);
        try {
            var6_11.yq();
        }
        catch (Exception var6_12) {
            try {
                block18: {
                    if (this.N != null) {
                        this.N.close();
                    }
                    break block18;
lbl57:
                    // 1 sources

                    this.B((OutputStream)var1_1, var4_18);
                }
                var1_1.flush();
                jM.zH(this.N);
                return;
lbl62:
                // 1 sources

                var1_1 = new Error("sendResponse(): Status can't be null.");
                throw var1_1;
            }
            catch (IOException var1_2) {
                jM.KJ.log(Level.SEVERE, "Could not send response to the client", var1_2);
            }
        }
    }

    protected final void M(PrintWriter printWriter, String string, String string2) {
        printWriter.append(string).append(": ").append(string2).append("\r\n");
    }

    public final void N(String string, String string2) {
        (this.zH).put(string, string2);
    }

    public final void SN(String string) {
        ((ArrayList)this.KJ).add(string);
    }

    @Override
    public final void close() {
        InputStream inputStream = this.N;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public final void dT(int n2) {
        this.t0 = n2;
    }

    public final String tF(String string) {
        return (String)((HashMap)this.i).get(string.toLowerCase());
    }

    public final boolean v3() {
        boolean bl;
        int n2;
        block4: {
            block5: {
                block6: {
                    n2 = this.q;
                    bl = false;
                    boolean bl2 = false;
                    if (n2 != 1) break block4;
                    String string = this.SN;
                    bl = bl2;
                    if (string == null) break block5;
                    if (string.toLowerCase().contains("text/")) break block6;
                    bl = bl2;
                    if (!this.SN.toLowerCase().contains("/json")) break block5;
                }
                bl = true;
            }
            return bl;
        }
        if (n2 == 2) {
            bl = true;
        }
        return bl;
    }

    public final boolean zH() {
        return "close".equals(this.tF("connection"));
    }
}

