/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.slf4j.impl.StaticLoggerBinder
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.QE;
import com.github.catvod.spider.merge.TO;
import com.github.catvod.spider.merge.bs;
import com.github.catvod.spider.merge.hj_0;
import com.github.catvod.spider.merge.io;
import com.github.catvod.spider.merge.mu;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.zh;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.impl.StaticLoggerBinder;

public final class kH {
    static final TO N;
    static final hj_0 SN;
    private static String i;
    static boolean tF;
    static volatile int yq;
    private static final String[] zH;

    static {
        SN = new hj_0();
        N = new TO();
        String string = null;
        try {
            String string2;
            string = string2 = System.getProperty("slf4j.detectLoggerNameMismatch");
        }
        catch (SecurityException securityException) {
            // empty catch block
        }
        boolean bl = string == null ? false : string.equalsIgnoreCase("true");
        tF = bl;
        zH = new String[]{"1.6", "1.7"};
        i = "org/slf4j/impl/StaticLoggerBinder.class";
    }

    private kH() {
    }

    private static void Gc(Set<URL> object) {
        if (object != null) {
            int n2 = object.size();
            boolean bl = true;
            if (n2 <= 1) {
                bl = false;
            }
            if (bl) {
                object = oi_0.yq("Actual binding is of type [");
                ((StringBuilder)object).append(StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr());
                ((StringBuilder)object).append("]");
                bs.SN(((StringBuilder)object).toString());
            }
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static final void KJ() {
        Object object;
        String string;
        try {
            string = StaticLoggerBinder.REQUESTED_API_VERSION;
            object = zH;
            int n2 = ((String[])object).length;
            boolean bl = false;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!string.startsWith(object[i2])) continue;
                bl = true;
            }
            if (bl) return;
        }
        catch (Throwable throwable) {
            bs.N("Unexpected problem occured during version sanity check", throwable);
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
        {
            object = new StringBuilder();
            ((StringBuilder)object).append("The requested version ");
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append(" by your slf4j binding is not compatible with ");
            ((StringBuilder)object).append(Arrays.asList(zH).toString());
            bs.SN(((StringBuilder)object).toString());
            bs.SN("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
            return;
        }
    }

    private static void M(Set<URL> object) {
        int n2 = object.size();
        boolean bl = true;
        if (n2 <= 1) {
            bl = false;
        }
        if (bl) {
            bs.SN("Class path contains multiple SLF4J bindings.");
            Iterator<URL> iterator = object.iterator();
            while (iterator.hasNext()) {
                object = iterator.next();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Found binding in [");
                stringBuilder.append(object);
                stringBuilder.append("]");
                bs.SN(stringBuilder.toString());
            }
            bs.SN("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static zh N() {
        int n2;
        if (yq == 0) {
            synchronized (kH.class) {
                if (yq == 0) {
                    yq = 1;
                    kH.yq();
                    if (yq == 3) {
                        kH.KJ();
                    }
                }
            }
        }
        if ((n2 = yq) == 1) {
            return SN;
        }
        if (n2 == 2) {
            throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
        }
        if (n2 == 3) {
            return StaticLoggerBinder.getSingleton().getLoggerFactory();
        }
        if (n2 == 4) {
            return N;
        }
        throw new IllegalStateException("Unreachable code");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static Set<URL> SN() {
        LinkedHashSet<URL> linkedHashSet = new LinkedHashSet<URL>();
        try {
            Enumeration<URL> enumeration = kH.class.getClassLoader();
            enumeration = enumeration == null ? ClassLoader.getSystemResources(i) : ((ClassLoader)((Object)enumeration)).getResources(i);
            while (enumeration.hasMoreElements()) {
                linkedHashSet.add(enumeration.nextElement());
            }
            return linkedHashSet;
        }
        catch (IOException iOException) {
            bs.N("Error getting resources from path", iOException);
        }
        return linkedHashSet;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean i() {
        String string = null;
        try {
            String string2;
            string = string2 = System.getProperty("java.vendor.url");
        }
        catch (SecurityException securityException) {}
        if (string != null) return string.toLowerCase().contains("android");
        return false;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void t0() {
        int n2;
        int n3;
        LinkedBlockingQueue<io> linkedBlockingQueue;
        Object object = SN;
        synchronized (object) {
            ((hj_0)object).zH();
            for (Object object2 : (ArrayList)((hj_0)object).tF()) {
                ((QE)object2).i(kH.zH(((QE)object2).getName()));
            }
            // MONITOREXIT @DISABLED, blocks:[0, 2] lbl10 : MonitorExitStatement: MONITOREXIT : var2
            linkedBlockingQueue = SN.N();
            n3 = linkedBlockingQueue.size();
            object = new ArrayList(128);
            n2 = 0;
            {
                catch (Throwable throwable) {}
                {
                    throw throwable;
                }
            }
        }
        while (true) {
            Object object2;
            if (linkedBlockingQueue.drainTo((Collection<io>)object, 128) == 0) {
                SN.SN();
                return;
            }
            object2 = ((ArrayList)object).iterator();
            while (object2.hasNext()) {
                Object object3;
                io io2 = (io)object2.next();
                if (io2 != null) {
                    object3 = io2.yq();
                    String string = ((QE)object3).getName();
                    if (((QE)object3).tF()) throw new IllegalStateException("Delegate logger cannot be null at this state.");
                    if (!((QE)object3).N()) {
                        if (((QE)object3).SN()) {
                            ((QE)object3).zH(io2);
                        } else {
                            bs.SN(string);
                        }
                    }
                }
                if (n2 == 0) {
                    if (io2.yq().SN()) {
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append("A number (");
                        ((StringBuilder)object3).append(n3);
                        ((StringBuilder)object3).append(") of logging calls during the initialization phase have been intercepted and are");
                        bs.SN(((StringBuilder)object3).toString());
                        bs.SN("now being replayed. These are subject to the filtering rules of the underlying logging system.");
                        bs.SN("See also http://www.slf4j.org/codes.html#replay");
                    } else if (!io2.yq().N()) {
                        bs.SN("The following set of substitute loggers may have been accessed");
                        bs.SN("during the initialization phase. Logging calls during this");
                        bs.SN("phase were not honored. However, subsequent logging calls to these");
                        bs.SN("loggers will work as normally expected.");
                        bs.SN("See also http://www.slf4j.org/codes.html#substituteLogger");
                    }
                }
                ++n2;
            }
            ((ArrayList)object).clear();
        }
    }

    public static mu tF(Class<?> clazz) {
        Object object = clazz.getName();
        mu mu2 = kH.N().yq((String)object);
        if (tF && (object = bs.yq()) != null && ((Class)object).isAssignableFrom(clazz) ^ true) {
            bs.SN(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", mu2.getName(), ((Class)object).getName()));
            bs.SN("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
        }
        return mu2;
    }

    /*
     * Exception decompiling
     */
    private static final void yq() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 1[TRYBLOCK] [8 : 39->64)] java.lang.Throwable
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

    public static mu zH(String string) {
        return kH.N().yq(string);
    }
}

