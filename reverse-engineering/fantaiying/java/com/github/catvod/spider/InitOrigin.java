/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  android.widget.Toast
 *  com.github.catvod.crawler.SpiderDebug
 */
package com.github.catvod.spider;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.parser.\u062f\ufead\ufeaf\u062d;
import com.github.catvod.parser.\u0638\ufead\u062e\ufee1;
import com.github.catvod.parser.\ufea9\ufe8f\u0647\ufead;
import com.github.catvod.parser.\ufeaf\ufea5\ufeab\u062e;
import com.github.catvod.parser.\ufeb9\u0643\ufed9\ufed5;
import com.github.catvod.parser.\ufec1\u0636\u062d\u0638;
import com.github.catvod.parser.\ufeed\ufebd\u0635\ufedd;
import com.github.catvod.spider.merge.to_0;
import com.github.catvod.spider.merge.\u0646\ufecd\ufead\u0647;
import com.github.catvod.spider.merge.\ufe9d\ufeab\u062e\u0640;
import com.github.catvod.spider.merge.\ufed9\ufe8e\u062d\ufead;
import com.github.catvod.spider.\u0632\ufead\u062f\u0628;
import com.github.catvod.spider.\u0635\u0631\u0645\u0628;
import com.github.catvod.spider.\ufe8e\ufeb9\u0647\u0642;
import com.github.catvod.spider.\ufe99\u062c\u0643\ufec1;
import com.github.catvod.spider.\ufeb1\ufe8e\ufee1\ufe9d;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class InitOrigin {
    public static Class<?> i;
    private static final short[] short;
    private static Runnable tF;
    public static boolean zH;
    private Application N;
    private final Handler SN = new Handler(Looper.getMainLooper());
    private final ExecutorService yq = Executors.newFixedThreadPool(5);

    static {
        short = new short[]{1924, 1931, 1921, 1943, 1930, 1932, 1921, 1995, 1924, 1941, 1941, 1995, 1956, 1926, 1937, 1932, 1939, 1932, 1937, 1948, 1969, 1933, 1943, 1920, 1924, 1921, 1689, 1679, 1672, 1672, 1695, 1684, 1678, 1723, 1674, 1674, 1686, 1683, 1689, 1691, 1678, 1683, 1685, 1684, 1929, 1926, 1932, 1946, 1927, 1921, 1932, 1990, 1929, 1944, 1944, 1990, 1961, 1931, 1948, 1921, 1950, 1921, 1948, 1937, 1980, 1920, 1946, 1933, 1929, 1932, 409, 399, 392, 392, 415, 404, 398, 443, 409, 398, 403, 396, 403, 398, 387, 430, 402, 392, 415, 411, 414, 892, 848, 882, 869, 888, 871, 888, 869, 888, 884, 866, 1793, 1808, 1796, 1794, 1812, 1813, 2987, 2985, 3006, 2979, 3004, 2979, 3006, 2995, 2320, 2320, 2345, 2309, 2310, -30977, 23695, 18780, 30009, -32386, 18934, 32532, 21941, -30616, 25861, 21898, -2028, 2019, 2019, 2010, 2038, 2037};
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Application context() {
        if (InitOrigin.get().N != null) return InitOrigin.get().N;
        try {
            Application application = (Application)Class.forName(\ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(short, 0, 26, 2021)).getMethod(\ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(short, 26, 18, 1786), new Class[0]).invoke(null, new Object[0]);
            if (application == null) return InitOrigin.get().N;
            InitOrigin.init((Context)application);
        }
        finally {
            return InitOrigin.get().N;
        }
    }

    public static void execute(Runnable runnable) {
        InitOrigin.get().yq.execute(runnable);
    }

    public static InitOrigin get() {
        return Loader.yq;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Activity getActivity() {
        Class<?> clazz;
        AnnotatedElement annotatedElement = Class.forName(\ufeaf\ufea5\ufeab\u062e.\u0641\u062f\u0637\u0630(short, 44, 26, 2024));
        Object object = ((Class)annotatedElement).getMethod(\ufe99\u062c\u0643\ufec1.\u0648\u0634\u063a\ufeb1(short, 70, 21, 506), new Class[0]).invoke(null, new Object[0]);
        annotatedElement = ((Class)annotatedElement).getDeclaredField(\u0638\ufead\u062e\ufee1.\ufe95\ufed9\ufebd\ufeb9(short, 91, 11, 785));
        ((AccessibleObject)annotatedElement).setAccessible(true);
        Iterator iterator = ((Map)((Field)annotatedElement).get(object)).values().iterator();
        do {
            if (!iterator.hasNext()) return null;
            object = iterator.next();
            clazz = object.getClass();
            annotatedElement = clazz.getDeclaredField(\u0646\ufecd\ufead\u0647.\u0640\u062e\ufed5\ufeaf(short, 102, 6, 1905));
            ((AccessibleObject)annotatedElement).setAccessible(true);
        } while (((Field)annotatedElement).getBoolean(object));
        annotatedElement = clazz.getDeclaredField(\ufeb9\u0643\ufed9\ufed5.\u0628\u062f\ufea1\u0642(short, 108, 8, 3018));
        ((AccessibleObject)annotatedElement).setAccessible(true);
        object = (Activity)((Field)annotatedElement).get(object);
        SpiderDebug.log((String)object.getComponentName().getClassName());
        return object;
    }

    public static String getSpStr(String string, String string2) {
        Application application = InitOrigin.context();
        InitOrigin.context();
        return application.getSharedPreferences(\ufe9d\ufeab\u062e\u0640.\ufec9\u0636\ufeed\u064a(short, 116, 5, 2422), 0).getString(string, string2);
    }

    /*
     * Exception decompiling
     */
    public static void init(Context var0) {
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

    public static void run(Runnable runnable) {
        InitOrigin.get().SN.post(runnable);
    }

    public static void run(Runnable runnable, int n) {
        InitOrigin.get().SN.postDelayed(runnable, (long)n);
    }

    public static void setClass(Class<?> clazz) {
        i = clazz;
    }

    public static void setSpStr(String string, String string2) {
        Application application = InitOrigin.context();
        InitOrigin.context();
        application = application.getSharedPreferences(\ufe8e\ufeb9\u0647\u0642.\ufee1\u062f\ufedd\u0643(short, 133, 5, 1925), 0).edit();
        application.putString(string, string2);
        application.apply();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void show(String string) {
        \ufea9\ufe8f\u0647\ufead.\ufe8f\ufee1\ufe99\u0631();
        boolean bl = \ufeed\ufebd\u0635\ufedd.\u0647\ufea1\ufed5\u0645();
        int n = 1616;
        block12: while (true) {
            switch (n ^= 0x661) {
                default: {
                    continue block12;
                }
                case 49: {
                    if (!bl) {
                        n = 1709;
                        continue block12;
                    }
                }
                case 14: {
                    n = 1678;
                    continue block12;
                }
                case 204: {
                    \u0635\u0631\u0645\u0628.\ufe8e\u064a\ufee9\ufe99(InitOrigin.\ufee9\ufee1\ufecd\ufedd(\ufea9\ufe8f\u0647\ufead.\ufe8f\ufee1\ufe99\u0631()), new to_0(string, 3));
                    break block12;
                }
                case 239: 
            }
            break;
        }
        \ufea9\ufe8f\u0647\ufead.\ufe8f\ufee1\ufe99\u0631();
        bl = \ufeed\ufebd\u0635\ufedd.\u0647\ufea1\ufed5\u0645();
        n = 1740;
        block13: while (true) {
            switch (n ^= 0x6DD) {
                default: {
                    continue block13;
                }
                case 17: {
                    if (bl) {
                        n = 1833;
                        continue block13;
                    }
                }
                case 54: {
                    n = 1802;
                    continue block13;
                }
                case 500: {
                    \ufea9\ufe8f\u0647\ufead.\ufe8f\ufee1\ufe99\u0631();
                    tF = new Runnable(string){
                        final String yq;
                        {
                            this.yq = string;
                        }

                        @Override
                        public void run() {
                            if (zH) {
                                Toast toast = Toast.makeText((Context)InitOrigin.context(), (CharSequence)this.yq, (int)1);
                                toast.setGravity(80, 0, 10);
                                toast.show();
                                InitOrigin.run(this, 7000);
                            }
                        }
                    };
                    \ufea9\ufe8f\u0647\ufead.\ufe8f\ufee1\ufe99\u0631();
                    \ufeb1\ufe8e\ufee1\ufe9d.\ufe99\ufeab\ufe8f\u062f(InitOrigin.\ufead\u0638\u062e\ufed5());
                    return;
                }
                case 471: 
            }
            break;
        }
    }

    public static void stopShowingToast() {
        InitOrigin.get().SN.removeCallbacks(tF);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static short[] \u0634\u0636\u0635\ufeab() {
        if (\u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648() > 0) return null;
        return short;
    }

    public static void \u0636\u0630\u0634\ufebd(Object object) {
        if (\u062f\ufead\ufeaf\u062d.\u0641\ufe9d\u0636\u062c() < 0) {
            SpiderDebug.log((String)((String)object));
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Runnable \ufead\u0638\u062e\ufed5() {
        if (\u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648() > 0) return null;
        return tF;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Application \ufeb1\u0631\ufed5\u0628(Object object) {
        if (\ufed9\ufe8e\u062d\ufead.\ufe8e\ufec1\u0641\u0644() < 0) return null;
        return ((InitOrigin)object).N;
    }

    public static void \ufed9\ufeaf\u0643\ufedd(Object object) {
        if (\ufec1\u0636\u062d\u0638.\u0643\u0638\u062a\ufec5() < 0) {
            SpiderDebug.log((Throwable)((Throwable)object));
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Handler \ufee9\ufee1\ufecd\ufedd(Object object) {
        if (\u0632\ufead\u062f\u0628.\u064a\u062d\ufea1\u0648() > 0) return null;
        return ((InitOrigin)object).SN;
    }

    private static class Loader {
        static volatile InitOrigin yq = new InitOrigin();

        private Loader() {
        }
    }
}

