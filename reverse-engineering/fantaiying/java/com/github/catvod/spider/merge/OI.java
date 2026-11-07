/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.util.Log
 */
package com.github.catvod.spider.merge;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.github.catvod.spider.merge.Ab;
import com.github.catvod.spider.merge.eY;
import com.github.catvod.spider.merge.oi_0;
import com.github.catvod.spider.merge.ox_0;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

final class OI
implements Closeable {
    private final File N;
    private final long SN;
    private final FileLock i;
    private final RandomAccessFile tF;
    private final File yq;
    private final FileChannel zH;

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    OI(File file, File object) {
        void iOException;
        StringBuilder stringBuilder = oi_0.yq("MultiDexExtractor(");
        stringBuilder.append(file.getPath());
        stringBuilder.append(", ");
        stringBuilder.append(((File)object).getPath());
        stringBuilder.append(")");
        Log.i((String)"MultiDex", (String)stringBuilder.toString());
        this.yq = file;
        this.N = object;
        this.SN = OI.tF(file);
        file = new File((File)object, "MultiDex.lock");
        this.tF = object = new RandomAccessFile(file, "rw");
        this.zH = object = ((RandomAccessFile)object).getChannel();
        stringBuilder = new StringBuilder();
        stringBuilder.append("Blocking on lock ");
        stringBuilder.append(file.getPath());
        Log.i((String)"MultiDex", (String)stringBuilder.toString());
        this.i = ((FileChannel)object).lock();
        object = new StringBuilder();
        ((StringBuilder)object).append(file.getPath());
        ((StringBuilder)object).append(" locked");
        Log.i((String)"MultiDex", (String)((StringBuilder)object).toString());
        return;
        catch (Error error2) {
        }
        catch (RuntimeException runtimeException) {
        }
        catch (IOException iOException) {
            // empty catch block
        }
        try {
            OI.yq(this.zH);
            throw file;
        }
        catch (Error error) {
        }
        catch (RuntimeException runtimeException) {
        }
        catch (IOException iOException) {
            // empty catch block
        }
        OI.yq(this.tF);
        throw iOException;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private static void Gc(Context context, long l, long l2, List object) {
        context = context.getSharedPreferences("multidex.version", 4).edit();
        context.putLong("timestamp", l);
        context.putLong("crc", l2);
        context.putInt("dex.number", object.size() + 1);
        Iterator iterator = object.iterator();
        int n2 = 2;
        while (iterator.hasNext()) {
            object = (yq)iterator.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append("dex.crc.");
            stringBuilder.append(n2);
            context.putLong(stringBuilder.toString(), ((yq)object).yq);
            stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append("dex.time.");
            stringBuilder.append(n2);
            context.putLong(stringBuilder.toString(), ((File)object).lastModified());
            ++n2;
        }
        context.commit();
    }

    private static long N(File file) {
        long l;
        long l2 = l = file.lastModified();
        if (l == -1L) {
            l2 = l - 1L;
        }
        return l2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void SN(ZipFile closeable, ZipEntry object, File file, String object2) {
        int n2;
        closeable = ((ZipFile)closeable).getInputStream((ZipEntry)object);
        object2 = File.createTempFile(eY.yq("tmp-", (String)object2), ".zip", file.getParentFile());
        Object object3 = oi_0.yq("Extracting ");
        ((StringBuilder)object3).append(((File)object2).getPath());
        Log.i((String)"MultiDex", (String)((StringBuilder)object3).toString());
        Object object4 = new FileOutputStream((File)object2);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream((OutputStream)object4);
        object3 = new ZipOutputStream(bufferedOutputStream);
        object4 = new ZipEntry("classes.dex");
        ((ZipEntry)object4).setTime(((ZipEntry)object).getTime());
        ((ZipOutputStream)object3).putNextEntry((ZipEntry)object4);
        object = new byte[16384];
        while ((n2 = ((InputStream)closeable).read((byte[])object)) != -1) {
            ((ZipOutputStream)object3).write((byte[])object, 0, n2);
        }
        ((ZipOutputStream)object3).closeEntry();
        {
            catch (Throwable throwable) {
                ((ZipOutputStream)object3).close();
                throw throwable;
            }
        }
        try {
            ((ZipOutputStream)object3).close();
            if (((File)object2).setReadOnly()) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Renaming to ");
                ((StringBuilder)object).append(file.getPath());
                Log.i((String)"MultiDex", (String)((StringBuilder)object).toString());
                boolean bl = ((File)object2).renameTo(file);
                if (bl) {
                    return;
                }
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("Failed to rename \"");
                ((StringBuilder)object3).append(((File)object2).getAbsolutePath());
                ((StringBuilder)object3).append("\" to \"");
                ((StringBuilder)object3).append(file.getAbsolutePath());
                ((StringBuilder)object3).append("\"");
                object = new IOException(((StringBuilder)object3).toString());
                throw object;
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("Failed to mark readonly \"");
            ((StringBuilder)object3).append(((File)object2).getAbsolutePath());
            ((StringBuilder)object3).append("\" (tmp of \"");
            ((StringBuilder)object3).append(file.getAbsolutePath());
            ((StringBuilder)object3).append("\")");
            object = new IOException(((StringBuilder)object3).toString());
            throw object;
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        finally {
            OI.yq(closeable);
            ((File)object2).delete();
        }
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private List i(Context object) {
        Log.i((String)"MultiDex", (String)"loading existing secondary dex files");
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append(this.yq.getName());
        ((StringBuilder)object2).append(".classes");
        object2 = ((StringBuilder)object2).toString();
        SharedPreferences sharedPreferences = object.getSharedPreferences("multidex.version", 4);
        int n2 = sharedPreferences.getInt("dex.number", 1);
        ArrayList<Object> arrayList = new ArrayList<Object>(n2 - 1);
        object = object2;
        for (int i2 = 2; i2 <= n2; ++i2) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(i2);
            ((StringBuilder)object2).append(".zip");
            object2 = ((StringBuilder)object2).toString();
            object2 = new yq(this.N, (String)object2);
            if (((File)object2).isFile()) {
                ((yq)object2).yq = OI.tF((File)object2);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append("dex.crc.");
                stringBuilder.append(i2);
                long l = sharedPreferences.getLong(stringBuilder.toString(), -1L);
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append("dex.time.");
                stringBuilder.append(i2);
                long l2 = sharedPreferences.getLong(stringBuilder.toString(), -1L);
                long l5 = ((File)object2).lastModified();
                if (l2 == l5 && l == ((yq)object2).yq) {
                    arrayList.add(object2);
                    continue;
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("Invalid extracted dex: ");
                ((StringBuilder)object).append(object2);
                ((StringBuilder)object).append(" (key \"");
                ((StringBuilder)object).append("");
                ((StringBuilder)object).append("\"), expected modification time: ");
                ((StringBuilder)object).append(l2);
                ((StringBuilder)object).append(", modification time: ");
                ((StringBuilder)object).append(l5);
                ((StringBuilder)object).append(", expected crc: ");
                ((StringBuilder)object).append(l);
                ((StringBuilder)object).append(", file crc: ");
                ((StringBuilder)object).append(((yq)object2).yq);
                throw new IOException(((StringBuilder)object).toString());
            }
            object = oi_0.yq("Missing extracted secondary dex file '");
            ((StringBuilder)object).append(((File)object2).getPath());
            ((StringBuilder)object).append("'");
            throw new IOException(((StringBuilder)object).toString());
        }
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private List<yq> t0() {
        Serializable serializable;
        Object object4;
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append(this.yq.getName());
        ((StringBuilder)object2).append(".classes");
        Object object3 = ((StringBuilder)object2).toString();
        object2 = this.N.listFiles(new Ab());
        if (object2 == null) {
            object2 = oi_0.yq("Failed to list secondary dex dir content (");
            ((StringBuilder)object2).append(this.N.getPath());
            ((StringBuilder)object2).append(").");
            Log.w((String)"MultiDex", (String)((StringBuilder)object2).toString());
        } else {
            for (Object object4 : object2) {
                serializable = oi_0.yq("Trying to delete old file ");
                ((StringBuilder)serializable).append(((File)object4).getPath());
                ((StringBuilder)serializable).append(" of size ");
                ((StringBuilder)serializable).append(((File)object4).length());
                Log.i((String)"MultiDex", (String)((StringBuilder)serializable).toString());
                if (!((File)object4).delete()) {
                    serializable = oi_0.yq("Failed to delete old file ");
                    ((StringBuilder)serializable).append(((File)object4).getPath());
                    Log.w((String)"MultiDex", (String)((StringBuilder)serializable).toString());
                    continue;
                }
                serializable = oi_0.yq("Deleted old file ");
                ((StringBuilder)serializable).append(((File)object4).getPath());
                Log.i((String)"MultiDex", (String)((StringBuilder)serializable).toString());
            }
        }
        serializable = new ArrayList();
        object4 = new ZipFile(this.yq);
        int n2 = 2;
        object2 = "classes2.dex";
        try {
            ZipEntry zipEntry;
            while ((zipEntry = ((ZipFile)object4).getEntry((String)object2)) != null) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append(n2);
                ((StringBuilder)object2).append(".zip");
                object2 = ((StringBuilder)object2).toString();
                yq yq2 = new yq(this.N, (String)object2);
                serializable.add(yq2);
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Extraction is needed for file ");
                ((StringBuilder)object2).append(yq2);
                Log.i((String)"MultiDex", (String)((StringBuilder)object2).toString());
                int n3 = 0;
                int n4 = 0;
                while (n3 < 3 && n4 == 0) {
                    StringBuilder stringBuilder;
                    int n5;
                    int n7 = n3 + 1;
                    OI.SN((ZipFile)object4, zipEntry, yq2, (String)object3);
                    try {
                        yq2.yq = OI.tF(yq2);
                        n5 = 1;
                    }
                    catch (IOException iOException) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Failed to read crc from ");
                        stringBuilder.append(yq2.getAbsolutePath());
                        Log.w((String)"MultiDex", (String)stringBuilder.toString(), (Throwable)iOException);
                        n5 = 0;
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Extraction ");
                    object2 = n5 != 0 ? "succeeded" : "failed";
                    stringBuilder.append((String)object2);
                    stringBuilder.append(" '");
                    stringBuilder.append(yq2.getAbsolutePath());
                    stringBuilder.append("': length ");
                    stringBuilder.append(yq2.length());
                    stringBuilder.append(" - crc: ");
                    stringBuilder.append(yq2.yq);
                    Log.i((String)"MultiDex", (String)stringBuilder.toString());
                    n3 = n7;
                    n4 = n5;
                    if (n5 != 0) continue;
                    yq2.delete();
                    n3 = n7;
                    n4 = n5;
                    if (!yq2.exists()) continue;
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Failed to delete corrupted secondary dex '");
                    ((StringBuilder)object2).append(yq2.getPath());
                    ((StringBuilder)object2).append("'");
                    Log.w((String)"MultiDex", (String)((StringBuilder)object2).toString());
                    n3 = n7;
                    n4 = n5;
                }
                if (n4 != 0) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("classes");
                    ((StringBuilder)object2).append(++n2);
                    ((StringBuilder)object2).append(".dex");
                    object2 = ((StringBuilder)object2).toString();
                    continue;
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Could not create zip file ");
                ((StringBuilder)object2).append(yq2.getAbsolutePath());
                ((StringBuilder)object2).append(" for secondary dex (");
                ((StringBuilder)object2).append(n2);
                ((StringBuilder)object2).append(")");
                object3 = new IOException(((StringBuilder)object2).toString());
                throw object3;
            }
        }
        catch (Throwable throwable) {
            try {
                ((ZipFile)object4).close();
                throw throwable;
            }
            catch (IOException iOException) {
                Log.w((String)"MultiDex", (String)"Failed to close resource", (Throwable)iOException);
                throw throwable;
            }
        }
        try {
            ((ZipFile)object4).close();
            return serializable;
        }
        catch (IOException iOException) {
            Log.w((String)"MultiDex", (String)"Failed to close resource", (Throwable)iOException);
        }
        return serializable;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static long tF(File object) {
        object = new RandomAccessFile((File)object, "r");
        Object object2 = ox_0.yq((RandomAccessFile)object);
        CRC32 cRC32 = new CRC32();
        long l = ((ox_0.yq)object2).SN;
        ((RandomAccessFile)object).seek(((ox_0.yq)object2).yq);
        int n2 = (int)Math.min(16384L, l);
        object2 = new byte[16384];
        while ((n2 = ((RandomAccessFile)object).read((byte[])object2, 0, n2)) != -1) {
            cRC32.update((byte[])object2, 0, n2);
            if ((l -= (long)n2) == 0L) break;
            n2 = (int)Math.min(16384L, l);
        }
        long l2 = cRC32.getValue();
        l = l2;
        if (l2 != -1L) return l;
        return l2 - 1L;
        finally {
            ((RandomAccessFile)object).close();
        }
    }

    private static void yq(Closeable closeable) {
        try {
            closeable.close();
        }
        catch (IOException iOException) {
            Log.w((String)"MultiDex", (String)"Failed to close resource", (Throwable)iOException);
        }
    }

    @Override
    public final void close() {
        this.i.release();
        this.zH.close();
        this.tF.close();
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    final List zH(Context object, boolean bl) {
        Object object2 = oi_0.yq("MultiDexExtractor.load(");
        ((StringBuilder)object2).append(this.yq.getPath());
        ((StringBuilder)object2).append(", ");
        ((StringBuilder)object2).append(bl);
        ((StringBuilder)object2).append(", ");
        ((StringBuilder)object2).append("");
        ((StringBuilder)object2).append(")");
        Log.i((String)"MultiDex", (String)((StringBuilder)object2).toString());
        if (this.i.isValid()) {
            block5: {
                block6: {
                    if (!bl) {
                        object2 = this.yq;
                        long l = this.SN;
                        SharedPreferences sharedPreferences = object.getSharedPreferences("multidex.version", 4);
                        boolean bl2 = sharedPreferences.getLong("timestamp", -1L) != OI.N(object2) || sharedPreferences.getLong("crc", -1L) != l;
                        if (!bl2) {
                            try {
                                object = object2 = this.i((Context)object);
                                break block5;
                            }
                            catch (IOException iOException) {
                                Log.w((String)"MultiDex", (String)"Failed to reload existing extracted secondary dex files, falling back to fresh extraction", (Throwable)iOException);
                                break block6;
                            }
                        }
                    }
                    object2 = bl ? "Forced extraction must be performed." : "Detected that extraction must be performed.";
                    Log.i((String)"MultiDex", (String)object2);
                }
                object2 = this.t0();
                OI.Gc((Context)object, OI.N(this.yq), this.SN, object2);
                object = object2;
            }
            object2 = oi_0.yq("load found ");
            ((StringBuilder)object2).append(object.size());
            ((StringBuilder)object2).append(" secondary dex files");
            Log.i((String)"MultiDex", (String)((StringBuilder)object2).toString());
            return object;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }

    private static final class yq
    extends File {
        public long yq = -1L;

        public yq(File file, String string) {
            super(file, string);
        }
    }
}

