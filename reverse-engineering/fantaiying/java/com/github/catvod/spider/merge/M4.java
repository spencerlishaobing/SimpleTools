/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 */
package com.github.catvod.spider.merge;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.Zj;
import com.github.catvod.spider.merge.mt_0;
import com.github.catvod.spider.merge.sy_0;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.URLConnection;
import java.nio.charset.Charset;

public final class M4 {
    public static void N(File object) {
        Object object2;
        Object object3;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(0x10000000);
        intent.addFlags(1);
        if (Build.VERSION.SDK_INT < 24) {
            object3 = Uri.fromFile((File)object);
        } else {
            object2 = InitOrigin.context();
            object3 = new StringBuilder();
            ((StringBuilder)object3).append(InitOrigin.context().getPackageName());
            ((StringBuilder)object3).append(".provider");
            object3 = Zj.yq((Context)object2, ((StringBuilder)object3).toString(), (File)object);
        }
        object2 = URLConnection.guessContentTypeFromName(((File)object).getName());
        object = object2;
        if (TextUtils.isEmpty((CharSequence)object2)) {
            object = "*/*";
        }
        intent.setDataAndType((Uri)object3, (String)object);
        InitOrigin.context().startActivity(intent);
    }

    public static File SN(String string) {
        return new File(InitOrigin.context().getFilesDir(), string);
    }

    public static void i(File file, String object) {
        object = ((String)object).getBytes();
        Object object2 = new FileOutputStream(file);
        ((FileOutputStream)object2).write((byte[])object);
        ((OutputStream)object2).flush();
        ((FileOutputStream)object2).close();
        try {
            object = Runtime.getRuntime();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("chmod 777 ");
            ((StringBuilder)object2).append(file);
            ((Runtime)object).exec(((StringBuilder)object2).toString()).waitFor();
        }
        catch (Exception exception) {
            try {
                exception.printStackTrace();
            }
            catch (Exception exception2) {
                exception2.printStackTrace();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String tF(File object) {
        String string = "";
        try {
            Object object2 = new FileInputStream((File)object);
            Object object3 = new InputStreamReader((InputStream)object2);
            object = new BufferedReader((Reader)object3);
            object3 = new StringBuilder();
            while (true) {
                if ((object2 = ((BufferedReader)object).readLine()) == null) {
                    ((BufferedReader)object).close();
                    return ME.s(((StringBuilder)object3).toString());
                }
                ((StringBuilder)object3).append((String)object2);
                ((StringBuilder)object3).append("\n");
            }
        }
        catch (Exception exception) {
            return string;
        }
    }

    public static File yq(String string) {
        return new File(InitOrigin.context().getCacheDir(), string);
    }

    public static void zH(File file, File file2) {
        try {
            sy_0 sy_02 = new sy_0(file);
            sy_02.i(Charset.forName("GBK"));
            if (!sy_02.tF()) {
                System.out.println("\u65e0\u6548\u7684ZIP\u6587\u4ef6");
                return;
            }
            sy_02.yq(file2.getAbsolutePath());
        }
        catch (mt_0 mt_02) {
            mt_02.printStackTrace();
        }
    }
}

