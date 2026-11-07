/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.ProgressDialog
 *  android.content.Context
 *  android.content.DialogInterface$OnClickListener
 *  android.net.Uri
 */
package com.github.catvod.spider.merge;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.merge.Bo;
import com.github.catvod.spider.merge.M4;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.N5;
import com.github.catvod.spider.merge.TO;
import com.github.catvod.spider.merge.Tq;
import com.github.catvod.spider.merge.bM;
import com.github.catvod.spider.merge.n_0;
import com.github.catvod.spider.merge.p7;
import com.github.catvod.spider.merge.to_0;
import com.github.catvod.spider.merge.zr;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/*
 * Renamed from com.github.catvod.spider.merge.ew
 */
public final class ew_0 {
    private boolean N;
    private volatile boolean SN = false;
    private ProgressDialog yq;

    /*
     * Exception decompiling
     */
    private void Gc(File var1_1, InputStream var2_2, double var3_6) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
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

    public static /* synthetic */ void N(ew_0 ew_02, int n2) {
        block4: {
            Objects.requireNonNull(ew_02);
            ProgressDialog progressDialog = ew_02.yq;
            if (progressDialog == null) break block4;
            try {
                if (progressDialog.isShowing()) {
                    ew_02.yq.setProgress(n2);
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public static /* synthetic */ void SN(ew_0 ew_02) {
        ew_02.SN = true;
        ew_02 = ew_02.yq;
        if (ew_02 != null) {
            ew_02.dismiss();
        }
    }

    private void t0() {
        InitOrigin.run(new to_0(this, 6));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void tF(ew_0 ew_02) {
        Objects.requireNonNull(ew_02);
        try {
            ew_02.N = false;
            ProgressDialog progressDialog = ew_02.yq;
            if (progressDialog != null && progressDialog.isShowing()) {
                ew_02.yq.dismiss();
            }
            ew_02.yq = null;
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void yq(ew_0 ew_02) {
        Objects.requireNonNull(ew_02);
        try {
            ProgressDialog progressDialog;
            ProgressDialog progressDialog2 = ew_02.yq;
            if (progressDialog2 != null && progressDialog2.isShowing()) {
                return;
            }
            ew_02.yq = progressDialog = new ProgressDialog((Context)InitOrigin.getActivity());
            progressDialog.setProgressStyle(1);
            ew_02.yq.setCancelable(false);
            ew_02.yq.setMax(100);
            ProgressDialog progressDialog3 = ew_02.yq;
            bM bM2 = new bM(ew_02, 1);
            progressDialog3.setButton(-2, (CharSequence)"\u53d6\u6d88", (DialogInterface.OnClickListener)bM2);
            if (!ew_02.N) return;
            ew_02.yq.show();
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void zH(ew_0 var0, String var1_1) {
        block28: {
            block27: {
                block26: {
                    block31: {
                        block30: {
                            block29: {
                                Objects.requireNonNull(var0);
                                InitOrigin.run(new n_0(var0, 6));
                                if (!ME.ee((String)var1_1)) break block29;
                                var1_1 = "\u4e0b\u8f7d\u5730\u5740\u4e0d\u80fd\u4e3a\u7a7a";
                                ** GOTO lbl85
                            }
                            var10_10 = Bo.tF((String)var1_1);
                            if (var10_10 == null || !var10_10.isSuccessful() || var10_10.body() == null) ** GOTO lbl76
                            var9_11 = ME.ee(p7.zH("downFile", "")) == false ? p7.tF("downFile") : TO.t0().toString();
                            var11_13 /* !! */  = new StringBuilder();
                            var11_13 /* !! */ .append("\u9ed8\u8ba4\u4fdd\u5b58\u4f4d\u7f6e-");
                            var11_13 /* !! */ .append((String)var9_11);
                            InitOrigin.show(var11_13 /* !! */ .toString());
                            var9_11 = ME.ee((String)var9_11) != false ? TO.t0() : new File((String)var9_11);
                            var11_13 /* !! */  = Uri.parse((String)var1_1).getLastPathSegment();
                            if (!ME.ee((String)var11_13 /* !! */ )) break block30;
                            var1_1 = "\u83b7\u53d6\u6587\u4ef6\u540d\u5931\u8d25";
                            ** GOTO lbl85
                        }
                        var1_1 = new File((File)var9_11, (String)var11_13 /* !! */ );
                        if ((var1_1 = TO.SN((File)var1_1)) != null) break block31;
                        var1_1 = "\u521b\u5efa\u4e0b\u8f7d\u6587\u4ef6\u5931\u8d25";
                        ** GOTO lbl85
                    }
                    var2_15 = var4_14 = Double.parseDouble(var10_10.header("Content-Length", "1024"));
                    if (var4_14 <= 0.0) {
                        var2_15 = 1024.0;
                    }
                    var10_10 = var10_10.body();
                    var0.Gc((File)var1_1, var10_10.byteStream(), var2_15);
                    var10_10.close();
                    if (!var1_1.exists() || !var1_1.isFile() || (var8_16 = var0.SN)) break block26;
                    var6_17 = true;
                    var7_18 = true;
                    try {
                        var10_10 = var1_1.getName().toLowerCase();
                        if (!var10_10.endsWith(".zip")) {
                            if (var10_10.endsWith(".apk") == false) throw null;
                            InitOrigin.show("\u4e0b\u8f7d\u5b8c\u6210");
                            M4.N((File)var1_1);
                            throw null;
                        }
                        InitOrigin.show("\u4e0b\u8f7d\u5b8c\u6210\u7b49\u5f85\u89e3\u538b\uff01\u8bf7\u52ff\u5173\u95ed");
                        M4.zH((File)var1_1, (File)var9_11);
                        InitOrigin.show("\u89e3\u538b\u5b8c\u6210");
                        throw null;
                    }
                    catch (Exception var1_2) {
                        var6_17 = var7_18;
                        ** GOTO lbl92
                    }
                    catch (IOException var1_3) {
                        ** GOTO lbl98
                    }
                }
                if (!var0.SN) break block27;
                InitOrigin.show("\u4e0b\u8f7d\u5df2\u53d6\u6d88");
                if (var1_1.exists()) {
                    var1_1.delete();
                }
                break block27;
                catch (Throwable var1_4) {
                    if (var10_10 == null) throw var1_4;
                    try {
                        var10_10.close();
                        throw var1_4;
                    }
                    catch (Throwable var9_12) {
                        try {
                            var1_4.addSuppressed(var9_12);
                            throw var1_4;
lbl76:
                            // 1 sources

                            if (var10_10 == null) {
                                var1_1 = "\u7f51\u7edc\u8bf7\u6c42\u5931\u8d25\uff0c\u8fd4\u56de\u7a7a\u54cd\u5e94";
                            } else {
                                var1_1 = new StringBuilder();
                                var1_1.append("\u8bf7\u6c42\u5931\u8d25\uff0c\u72b6\u6001\u7801\uff1a");
                                var1_1.append(var10_10.code());
                                var1_1 = var1_1.toString();
                            }
lbl85:
                            // 5 sources

                            InitOrigin.show((String)var1_1);
                            var0.t0();
                            break block27;
                        }
                        catch (Throwable var1_5) {
                            break block28;
                        }
                        catch (Exception var1_6) {
                            var6_17 = false;
                        }
lbl92:
                        // 2 sources

                        var1_7.printStackTrace();
                        if (var6_17) break block27;
                        if (ME.ee("")) ** GOTO lbl-1000
                        ** GOTO lbl-1000
                        catch (IOException var1_8) {
                            var6_17 = false;
                        }
lbl98:
                        // 2 sources

                        var1_7.printStackTrace();
                        if (!var6_17) {
                            var8_16 = ME.ee("");
                            ** if (var8_16) goto lbl-1000
                        }
                        break block27;
lbl-1000:
                        // 2 sources

                        {
                            var1_7 = "\u81ea\u52a8\u5b89\u88c5\u53ea\u652f\u6301OK\u5f71\u89c6\uff0c\u5176\u4ed6APP\u53bbTV\u6587\u4ef6\u5939\u624b\u52a8\u5b89\u88c5\uff1a";
                            ** GOTO lbl106
                        }
lbl-1000:
                        // 2 sources

                        {
                            var1_7 = "\u4e0b\u8f7d\u5b8c\u6210\uff0c\u90e8\u5206\u6536\u5c3e\u64cd\u4f5c\u5f02\u5e38\uff08\u6587\u4ef6\u5df2\u4fdd\u5b58\uff09";
                        }
lbl106:
                        // 2 sources

                        InitOrigin.show(var1_7);
                        break block27;
                        catch (NumberFormatException var1_9) {
                            InitOrigin.show("\u83b7\u53d6\u6587\u4ef6\u5927\u5c0f\u5931\u8d25\uff0c\u4e0b\u8f7d\u7ec8\u6b62");
                            var1_9.printStackTrace();
                        }
                    }
                }
            }
            var0.t0();
            var0.SN = false;
            return;
        }
        var0.t0();
        var0.SN = false;
        throw var1_5;
    }

    /*
     * Loose catch block
     */
    public final String i(String string) {
        block7: {
            if (!N5.i()) {
                return "";
            }
            if (!this.N) break block7;
            return "";
            {
                catch (Exception exception) {
                    this.t0();
                    return Tq.G("");
                }
            }
        }
        this.N = true;
        try {
            zr zr2 = new zr(this, string, 1);
            InitOrigin.execute(zr2);
            return "";
        }
        catch (Exception exception) {
            RuntimeException runtimeException = new RuntimeException(exception);
            throw runtimeException;
        }
    }
}

