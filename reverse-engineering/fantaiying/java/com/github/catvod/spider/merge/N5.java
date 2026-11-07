/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.app.Application
 *  android.content.Context
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.os.SystemClock
 *  android.view.View$OnClickListener
 *  android.widget.Button
 */
package com.github.catvod.spider.merge;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.merge.TV;
import com.github.catvod.spider.merge.lj_0;
import com.github.catvod.spider.merge.p7;
import com.github.catvod.spider.merge.qv;
import com.github.catvod.spider.merge.yx_0;

public final class N5 {
    private static Integer N;
    private static boolean SN;
    private static AlertDialog yq;

    private static void Gc() {
        Activity activity = InitOrigin.getActivity();
        if (N5.t0()) {
            try {
                Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("package:");
                stringBuilder.append(activity.getPackageName());
                intent.setData(Uri.parse((String)stringBuilder.toString()));
                activity.startActivity(intent);
            }
            catch (Exception exception) {
                try {
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("package:");
                    stringBuilder.append(activity.getPackageName());
                    intent.setData(Uri.parse((String)stringBuilder.toString()));
                    activity.startActivity(intent);
                }
                catch (Exception exception2) {
                    InitOrigin.show("\u8bf7\u624b\u52a8\u5728\u8bbe\u7f6e\u4e2d\u5f00\u542f\u5b58\u50a8\u6743\u9650");
                }
            }
        } else {
            int n2 = Build.VERSION.SDK_INT;
            if (n2 >= 33) {
                activity.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1024);
            } else if (n2 >= 23) {
                activity.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1024);
            }
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void M() {
        try {
            void var0_3;
            AlertDialog alertDialog;
            AlertDialog.Builder builder = new AlertDialog.Builder((Context)InitOrigin.getActivity());
            AlertDialog.Builder builder2 = builder.setTitle((CharSequence)"\u90e8\u5206\u529f\u80fd\u9700\u8981\u6388\u6743");
            if (N5.t0()) {
                String string = "\u5f53\u524d\u5e94\u7528\u9700\u8981\u300c\u6240\u6709\u6587\u4ef6\u7ba1\u7406\u6743\u9650\u300d\u624d\u80fd\u6b63\u5e38\u4f7f\u7528\u5b58\u50a8\u529f\u80fd\u3002\n\n\u70b9\u51fb\u6388\u6743\u540e\uff0c\u8bf7\u5728\u8bbe\u7f6e\u9875\u9762\u4e2d\u624b\u52a8\u5f00\u542f\u300c\u5141\u8bb8\u7ba1\u7406\u6240\u6709\u6587\u4ef6\u300d\u5f00\u5173\u3002";
            } else {
                String string = "\u9700\u8981\u5b58\u50a8\u6743\u9650\u6765\u8bfb\u53d6\u548c\u5199\u5165\u6587\u4ef6\uff0c\u8bf7\u70b9\u51fb\u6388\u6743\u5e76\u5141\u8bb8\u3002";
            }
            yq = alertDialog = builder2.setMessage((CharSequence)var0_3).setNegativeButton(0x1040000, (DialogInterface.OnClickListener)TV.yq).setPositiveButton((CharSequence)"\u5f00\u59cb\u6388\u6743", null).create();
            alertDialog.show();
            Button button = yq.getButton(-1);
            if (button != null) {
                button.setOnClickListener((View.OnClickListener)yx_0.yq);
            }
            yq.setOnDismissListener((DialogInterface.OnDismissListener)qv.N);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public static /* synthetic */ void N() {
        try {
            N5.Gc();
            return;
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static /* synthetic */ void SN() {
        SN = false;
    }

    /*
     * Unable to fully structure code
     */
    public static boolean i() {
        block9: {
            var0 = true;
            if (p7.SN("storage_state") > 1) ** GOTO lbl32
            if (p7.SN("storage_state") != 0) ** GOTO lbl31
            if (N5.zH()) ** GOTO lbl22
            N5.SN = true;
            InitOrigin.run(lj_0.yq);
            while (N5.SN && !N5.zH()) {
                SystemClock.sleep((long)500L);
            }
            try {
                var1_1 = N5.yq;
                if (var1_1 == null) break block9;
            }
            catch (Exception var1_3) {
                ** continue;
            }
            var1_1.dismiss();
        }
lbl19:
        // 2 sources

        while (true) {
            block10: {
                try {
                    block11: {
                        if (!N5.zH()) break block11;
lbl22:
                        // 2 sources

                        p7.i("storage_state", 2);
                        break block10;
                    }
                    p7.i("storage_state", 1);
                    InitOrigin.show("\u672a\u6388\u6743\uff01(\u4e0b\u8f7d\u5b89\u88c5APP\u53d7\u9650)");
                }
                catch (Exception var1_2) {
                    p7.i("storage_state", 1);
                    System.out.println(var1_2);
                }
lbl31:
                // 3 sources

                var0 = false;
            }
            return var0;
        }
    }

    private static boolean t0() {
        int n2;
        boolean bl;
        block7: {
            Integer n3 = N;
            bl = false;
            if (n3 != null) {
                n2 = n3;
            } else {
                block6: {
                    n3 = InitOrigin.context();
                    if (n3 == null) break block6;
                    try {
                        N = n3 = Integer.valueOf(n3.getPackageManager().getPackageInfo((String)n3.getPackageName(), (int)0).applicationInfo.targetSdkVersion);
                        n2 = n3;
                        break block7;
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
                n2 = Build.VERSION.SDK_INT;
            }
        }
        if (n2 >= 37) {
            bl = true;
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void tF() {
        SN = false;
        try {
            AlertDialog alertDialog = yq;
            if (alertDialog == null) return;
            alertDialog.dismiss();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public static /* synthetic */ void yq() {
        try {
            N5.M();
            return;
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    private static boolean zH() {
        boolean bl;
        Application application = InitOrigin.context();
        if (N5.t0() && Build.VERSION.SDK_INT >= 30) {
            return Environment.isExternalStorageManager();
        }
        int n2 = Build.VERSION.SDK_INT;
        boolean bl2 = bl = true;
        if (n2 >= 23) {
            bl2 = application.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0 && application.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0 ? bl : false;
        }
        return bl2;
    }
}

