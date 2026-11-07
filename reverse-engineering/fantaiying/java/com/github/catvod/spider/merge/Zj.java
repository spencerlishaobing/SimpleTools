/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentProvider
 *  android.content.Context
 *  android.content.res.XmlResourceParser
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.Environment
 *  android.text.TextUtils
 */
package com.github.catvod.spider.merge;

import android.content.ContentProvider;
import android.content.Context;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.github.catvod.spider.merge.H0;
import com.github.catvod.spider.merge.eY;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class Zj
extends ContentProvider {
    private static final HashMap<String, yq> yq = new HashMap();

    private static yq SN(Context object, String object2) {
        SN sN = new SN((String)object2);
        Object object3 = object.getPackageManager().resolveContentProvider((String)object2, 128);
        if (object3 != null) {
            XmlResourceParser xmlResourceParser = object3.loadXmlMetaData(object.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
            if (xmlResourceParser != null) {
                int n2;
                while ((n2 = xmlResourceParser.next()) != 1) {
                    if (n2 != 2) continue;
                    object3 = xmlResourceParser.getName();
                    object2 = null;
                    String string = xmlResourceParser.getAttributeValue(null, "name");
                    String string2 = xmlResourceParser.getAttributeValue(null, "path");
                    if ("cache-path".equals(object3)) {
                        object2 = object.getCacheDir();
                    } else if ("external-path".equals(object3)) {
                        object2 = Environment.getExternalStorageDirectory();
                    }
                    if (object2 == null) continue;
                    for (n2 = 0; n2 < 1; ++n2) {
                        String string3 = (new String[]{string2})[n2];
                        object3 = object2;
                        if (string3 != null) {
                            object3 = new File((File)object2, string3);
                        }
                        object2 = object3;
                    }
                    sN.SN(string, (File)object2);
                }
                return sN;
            }
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        object = new IllegalArgumentException(eY.yq("Couldn't find meta-data for provider with authority ", (String)object2));
        throw object;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Uri yq(Context context, String object, File file) {
        HashMap<String, yq> hashMap = yq;
        synchronized (hashMap) {
            yq yq2;
            block7: {
                yq yq3;
                yq2 = yq3 = hashMap.get(object);
                if (yq3 == null) {
                    void var0_3;
                    try {
                        yq2 = Zj.SN(context, (String)object);
                        hashMap.put((String)object, yq2);
                        break block7;
                    }
                    catch (H0 h0) {
                    }
                    catch (IOException iOException) {
                        // empty catch block
                    }
                    object = new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", (Throwable)var0_3);
                    throw object;
                }
            }
            return yq2.yq(file);
        }
    }

    static final class SN
    implements yq {
        private final HashMap<String, File> SN = new HashMap();
        private final String yq;

        SN(String string) {
            this.yq = string;
        }

        final void SN(String charSequence, File file) {
            if (!TextUtils.isEmpty((CharSequence)charSequence)) {
                try {
                    File file2 = file.getCanonicalFile();
                    this.SN.put((String)charSequence, file2);
                }
                catch (IOException iOException) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append("Failed to resolve canonical path for ");
                    ((StringBuilder)charSequence).append(file);
                    throw new IllegalArgumentException(((StringBuilder)charSequence).toString(), iOException);
                }
                return;
            }
            throw new IllegalArgumentException("Name must not be empty");
        }

        @Override
        public final Uri yq(File object) {
            String string;
            try {
                string = ((File)object).getCanonicalPath();
                object = null;
            }
            catch (IOException iOException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to resolve canonical path for ");
                stringBuilder.append(object);
                object = new IllegalArgumentException(stringBuilder.toString());
                throw object;
            }
            for (Map.Entry<String, File> entry : this.SN.entrySet()) {
                String string2 = entry.getValue().getPath();
                if (!string.startsWith(string2) || object != null && string2.length() <= ((File)object.getValue()).getPath().length()) continue;
                object = entry;
            }
            if (object != null) {
                Map.Entry<String, File> entry;
                entry = ((File)object.getValue()).getPath();
                boolean bl = ((String)((Object)entry)).endsWith("/");
                int n2 = ((String)((Object)entry)).length();
                if (!bl) {
                    ++n2;
                }
                string = string.substring(n2);
                entry = new StringBuilder();
                ((StringBuilder)((Object)entry)).append(Uri.encode((String)((String)object.getKey())));
                ((StringBuilder)((Object)entry)).append('/');
                ((StringBuilder)((Object)entry)).append(Uri.encode((String)string, (String)"/"));
                object = ((StringBuilder)((Object)entry)).toString();
                return new Uri.Builder().scheme("content").authority(this.yq).encodedPath((String)object).build();
            }
            throw new IllegalArgumentException(eY.yq("Failed to find configured root that contains ", string));
        }
    }

    static interface yq {
        public Uri yq(File var1);
    }
}

