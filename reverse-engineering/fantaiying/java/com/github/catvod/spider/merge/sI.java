/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  com.github.catvod.crawler.SpiderDebug
 */
package com.github.catvod.spider.merge;

import android.os.Looper;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.merge.Jb;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.N0;
import com.github.catvod.spider.merge.i3;
import com.github.catvod.spider.merge.r2;
import com.github.catvod.spider.merge.xu_0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class sI {
    public static boolean yq;

    private static boolean N(i3 i32, xu_0 xu_02, N0 n0) {
        boolean bl = ME.ee(i32.Gc) && ME.ee(xu_02.W.N()) && ME.ee(n0.F5);
        return bl;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean SN() {
        AtomicReference<Object> atomicReference;
        boolean bl;
        block13: {
            void var7_11;
            boolean bl2;
            block14: {
                AtomicBoolean atomicBoolean;
                xu_0 xu_02;
                N0 n0;
                i3 i32;
                boolean bl3;
                boolean bl4;
                block15: {
                    boolean bl5 = yq;
                    bl2 = true;
                    bl = true;
                    bl4 = true;
                    bl3 = true;
                    if (bl5) {
                        return bl4;
                    }
                    i32 = i3.s();
                    n0 = N0.Zm();
                    xu_02 = xu_0.xa();
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        SpiderDebug.log((String)"ScanLoginUtil.awaitScanLogin run on main thread, can not wait for scan login");
                        return false;
                    }
                    atomicBoolean = new AtomicBoolean(false);
                    atomicReference = new AtomicReference<Object>(null);
                    try {
                        r2 r22 = new r2(atomicBoolean, atomicReference, i32, xu_02, n0);
                        InitOrigin.run(r22);
                    }
                    catch (Exception exception) {
                        SpiderDebug.log((Throwable)exception);
                    }
                    break block15;
                    return false;
                }
                long l = System.currentTimeMillis();
                while (true) {
                    block12: {
                        if (System.currentTimeMillis() >= l + 30000L) break;
                        bl4 = sI.N(i32, xu_02, n0);
                        if (bl4) break block12;
                        try {
                            yq = true;
                            break block13;
                        }
                        catch (Exception exception) {
                            bl = bl3;
                            break block14;
                        }
                    }
                    if (atomicBoolean.get()) break;
                    Thread.sleep(300L);
                    continue;
                    break;
                }
                bl = false;
                break block13;
                catch (Exception exception) {
                    bl = false;
                }
            }
            SpiderDebug.log((Throwable)var7_11);
            break block13;
            catch (InterruptedException interruptedException) {
                block16: {
                    bl = false;
                    break block16;
                    catch (InterruptedException interruptedException2) {
                        bl = bl2;
                    }
                }
                Thread.currentThread().interrupt();
            }
        }
        InitOrigin.run(new Jb(atomicReference, 5));
        return bl;
    }

    public static /* synthetic */ void yq(i3 i32, xu_0 xu_02, N0 n0, AtomicBoolean atomicBoolean) {
        if (sI.N(i32, xu_02, n0)) {
            atomicBoolean.set(true);
        }
    }
}

