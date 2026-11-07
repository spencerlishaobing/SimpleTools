/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.wg;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class CC {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void N(Path object, byte[] byArray) {
        if (byArray == null) return;
        if (byArray.length == 0) {
            return;
        }
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            if (byArray[0] == 0) {
                return;
            }
            object = Files.getFileAttributeView((Path)object, DosFileAttributeView.class, LinkOption.NOFOLLOW_LINKS);
            object.setReadOnly(wg.tF(byArray[0], 0));
            object.setHidden(wg.tF(byArray[0], 1));
            object.setSystem(wg.tF(byArray[0], 2));
            object.setArchive(wg.tF(byArray[0], 5));
            return;
        }
        if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
            if (!System.getProperty("os.name").toLowerCase().contains("nux")) return;
        }
        if (byArray[2] == 0 && byArray[3] == 0) {
            return;
        }
        try {
            HashSet<PosixFilePermission> hashSet = new HashSet<PosixFilePermission>();
            CC.yq(byArray[3], 0, hashSet, PosixFilePermission.OWNER_READ);
            CC.yq(byArray[2], 7, hashSet, PosixFilePermission.OWNER_WRITE);
            CC.yq(byArray[2], 6, hashSet, PosixFilePermission.OWNER_EXECUTE);
            CC.yq(byArray[2], 5, hashSet, PosixFilePermission.GROUP_READ);
            CC.yq(byArray[2], 4, hashSet, PosixFilePermission.GROUP_WRITE);
            CC.yq(byArray[2], 3, hashSet, PosixFilePermission.GROUP_EXECUTE);
            CC.yq(byArray[2], 2, hashSet, PosixFilePermission.OTHERS_READ);
            CC.yq(byArray[2], 1, hashSet, PosixFilePermission.OTHERS_WRITE);
            CC.yq(byArray[2], 0, hashSet, PosixFilePermission.OTHERS_EXECUTE);
            Files.setPosixFilePermissions((Path)object, hashSet);
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public static File[] SN(File objectArray) {
        String string = objectArray.getName();
        int n = string.lastIndexOf(".");
        if (n != -1) {
            string = string.substring(0, n);
        }
        objectArray = objectArray.getParentFile().listFiles(new FilenameFilter(string){
            final String yq;
            {
                this.yq = string;
            }

            @Override
            public final boolean accept(File comparable, String string) {
                comparable = new StringBuilder();
                ((StringBuilder)comparable).append(this.yq);
                ((StringBuilder)comparable).append(".");
                return string.startsWith(((StringBuilder)comparable).toString());
            }
        });
        if (objectArray == null) {
            return new File[0];
        }
        Arrays.sort(objectArray);
        return objectArray;
    }

    private static void yq(byte by2, int n, Set<PosixFilePermission> set, PosixFilePermission posixFilePermission) {
        if (wg.tF(by2, n)) {
            set.add(posixFilePermission);
        }
    }
}

