/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.s1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.util.Properties;

final class Jw {
    static Class SN;
    private static boolean yq;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static {
        boolean bl;
        try {
            bl = System.getProperty("xml.stream.debug") != null;
        }
        catch (Exception exception) {
            return;
        }
        yq = bl;
    }

    /*
     * Unable to fully structure code
     */
    static Object N() {
        block21: {
            block18: {
                block19: {
                    block17: {
                        var1 = Jw.class;
                        var3_4 = new StringBuffer();
                        var0_6 = var2_5 = Jw.SN;
                        if (var2_5 != null) break block17;
                        Jw.yq();
                        Jw.SN = Jw.class;
                        var0_6 = Jw.class;
                    }
                    try {
                        var3_4.append(var0_6.getName());
                        var3_4.append("$ClassLoaderFinderConcrete");
                        var0_6 = ((yq)Class.forName(var3_4.toString()).newInstance()).yq();
                        break block18;
                    }
                    catch (Exception var0_7) {
                        throw new s1(var0_7.toString(), var0_7);
                    }
                    catch (ClassNotFoundException var0_8) {
                        var0_6 = var2_5 = Jw.SN;
                        if (var2_5 != null) break block19;
                    }
                    catch (LinkageError var0_9) {
                        var0_6 = var2_5 = Jw.SN;
                        if (var2_5 != null) break block19;
                    }
                    Jw.yq();
                    Jw.SN = Jw.class;
                    var0_6 = var1;
                }
                var0_6 = var0_6.getClassLoader();
            }
            try {
                var1 = System.getProperty("javax.xml.stream.XMLInputFactory");
                if (var1 == null) break block21;
            }
            catch (SecurityException var1_3) {
                ** continue;
            }
            var2_5 = new StringBuffer();
            var2_5.append("found system property");
            var2_5.append((String)var1);
            Jw.SN(var2_5.toString());
            var0_6 = var1 = Jw.tF((String)var1, (ClassLoader)var0_6);
            ** GOTO lbl123
        }
lbl51:
        // 2 sources

        while (true) {
            block23: {
                block24: {
                    block25: {
                        block22: {
                            var2_5 = System.getProperty("java.home");
                            var1 = new StringBuffer();
                            var1.append((String)var2_5);
                            var2_5 = File.separator;
                            var1.append((String)var2_5);
                            var1.append("lib");
                            var1.append((String)var2_5);
                            var1.append("jaxp.properties");
                            var2_5 = var1.toString();
                            var1 = new File((String)var2_5);
                            if (!var1.exists()) break block22;
                            var3_4 = new Properties();
                            var2_5 = new FileInputStream((File)var1);
                            var3_4.load((InputStream)var2_5);
                            var2_5 = var3_4.getProperty("javax.xml.stream.XMLInputFactory");
                            if (var2_5 == null) break block22;
                            try {
                                if (var2_5.length() <= 0) break block22;
                                var1 = new StringBuffer();
                                var1.append("found java.home property ");
                                var1.append((String)var2_5);
                                Jw.SN(var1.toString());
                                var0_6 = var1 = Jw.tF((String)var2_5, (ClassLoader)var0_6);
                                break block23;
                            }
                            catch (Exception var1_1) {
                                if (!Jw.yq) break block22;
                                var1_1.printStackTrace();
                            }
                        }
                        if (var0_6 != null) ** GOTO lbl92
                        var1 = ClassLoader.getSystemResourceAsStream("META-INF/services/javax.xml.stream.XMLInputFactory");
                        break block25;
lbl92:
                        // 1 sources

                        var1 = var0_6.getResourceAsStream("META-INF/services/javax.xml.stream.XMLInputFactory");
                    }
                    if (var1 == null) break block24;
                    var2_5 = new StringBuffer();
                    var2_5.append("found ");
                    var2_5.append("META-INF/services/javax.xml.stream.XMLInputFactory");
                    Jw.SN(var2_5.toString());
                    var3_4 = new InputStreamReader((InputStream)var1, "UTF-8");
                    var2_5 = new BufferedReader((Reader)var3_4);
                    var1 = var2_5.readLine();
                    var2_5.close();
                    if (var1 == null) break block24;
                    try {
                        if ("".equals(var1)) break block24;
                        var2_5 = new StringBuffer();
                        var2_5.append("loaded from services: ");
                        var2_5.append((String)var1);
                        Jw.SN(var2_5.toString());
                        var0_6 = var1 = Jw.tF((String)var1, (ClassLoader)var0_6);
                        break block23;
                    }
                    catch (Exception var1_2) {
                        if (!Jw.yq) break block24;
                        var1_2.printStackTrace();
                    }
                }
                Jw.SN("loaded from fallback value: com.bea.xml.stream.MXParserFactory");
                var0_6 = Jw.tF("com.bea.xml.stream.MXParserFactory", (ClassLoader)var0_6);
            }
            return var0_6;
        }
    }

    private static void SN(String string) {
        if (yq) {
            PrintStream printStream = System.err;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("STREAM: ");
            stringBuffer.append(string);
            printStream.println(stringBuffer.toString());
        }
    }

    /*
     * Unable to fully structure code
     */
    private static Object tF(String var0, ClassLoader var1_1) {
        if (var1_1 != null) ** GOTO lbl5
        try {
            block3: {
                var1_1 = Class.forName(var0);
                break block3;
lbl5:
                // 1 sources

                var1_1 = var1_1.loadClass(var0);
            }
            var1_1 = var1_1.newInstance();
            return var1_1;
        }
        catch (Exception var1_2) {
            var2_3 = new StringBuffer();
            var2_3.append("Provider ");
            var2_3.append(var0);
            var2_3.append(" could not be instantiated: ");
            var2_3.append(var1_2);
            throw new s1(var2_3.toString(), var1_2);
        }
        catch (ClassNotFoundException var2_4) {
            var1_1 = new StringBuffer();
            var1_1.append("Provider ");
            var1_1.append(var0);
            var1_1.append(" not found");
            throw new s1(var1_1.toString(), var2_4);
        }
    }

    static /* synthetic */ Class yq() {
        return Jw.class;
    }

    private static abstract class yq {
        private yq() {
        }

        abstract ClassLoader yq();
    }
}

