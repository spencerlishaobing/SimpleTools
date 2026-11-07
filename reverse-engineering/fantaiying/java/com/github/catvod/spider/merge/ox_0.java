/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.oi_0;
import java.io.RandomAccessFile;
import java.util.zip.ZipException;

/*
 * Renamed from com.github.catvod.spider.merge.ox
 */
final class ox_0 {
    static yq yq(RandomAccessFile object) {
        long l = ((RandomAccessFile)object).length() - 22L;
        long l2 = 0L;
        if (l >= 0L) {
            long l5 = l - 65536L;
            if (l5 < 0L) {
                l5 = l2;
            }
            int n2 = Integer.reverseBytes(101010256);
            do {
                ((RandomAccessFile)object).seek(l);
                if (((RandomAccessFile)object).readInt() != n2) continue;
                ((RandomAccessFile)object).skipBytes(2);
                ((RandomAccessFile)object).skipBytes(2);
                ((RandomAccessFile)object).skipBytes(2);
                ((RandomAccessFile)object).skipBytes(2);
                yq yq2 = new yq();
                yq2.SN = (long)Integer.reverseBytes(((RandomAccessFile)object).readInt()) & 0xFFFFFFFFL;
                yq2.yq = (long)Integer.reverseBytes(((RandomAccessFile)object).readInt()) & 0xFFFFFFFFL;
                return yq2;
            } while (--l >= l5);
            throw new ZipException("End Of Central Directory signature not found");
        }
        StringBuilder stringBuilder = oi_0.yq("File too short to be a zip file: ");
        stringBuilder.append(((RandomAccessFile)object).length());
        object = new ZipException(stringBuilder.toString());
        throw object;
    }

    static final class yq {
        long SN;
        long yq;

        yq() {
        }
    }
}

