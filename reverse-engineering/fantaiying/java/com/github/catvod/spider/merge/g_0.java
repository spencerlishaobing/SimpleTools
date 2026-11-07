/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.sqlite.SQLiteDatabase
 *  com.github.catvod.crawler.SpiderDebug
 *  org.json.JSONObject
 */
package com.github.catvod.spider.merge;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.Bili;
import com.github.catvod.spider.InitOrigin;
import com.github.catvod.spider.merge.ME;
import com.github.catvod.spider.merge.j_0;
import com.github.catvod.spider.merge.k9;
import com.github.catvod.spider.merge.y5;
import java.nio.channels.Pipe;
import org.json.JSONObject;

/*
 * Renamed from com.github.catvod.spider.merge.g
 */
public final class g_0
implements Runnable {
    public final Object N;
    public final Object SN;
    public final int yq;

    public /* synthetic */ g_0(Object object, Object object2, int n2) {
        this.yq = n2;
        this.SN = object;
        this.N = object2;
    }

    @Override
    public final void run() {
        switch (this.yq) {
            default: {
                break;
            }
            case 2: {
                y5.SN((y5)this.SN, (Pipe.SinkChannel)this.N);
                return;
            }
            case 1: {
                Bili.Nl((Bili)((Object)this.SN), (JSONObject)this.N);
                return;
            }
            case 0: {
                j_0.t0((j_0)this.SN, (k9)this.N);
                return;
            }
        }
        String string = (String)this.SN;
        String string2 = (String)this.N;
        String string3 = ME.yq;
        if (!(string.equals(string2) || string2.contains(".m3u") || string2.contains(".txt"))) {
            try {
                Thread.sleep(5000L);
            }
            catch (InterruptedException interruptedException) {
                throw new RuntimeException(interruptedException);
            }
            string3 = SQLiteDatabase.openDatabase((String)InitOrigin.context().getDatabasePath("tv").getAbsolutePath(), null, (int)0);
            long l = System.currentTimeMillis();
            string3.execSQL("UPDATE Config SET time = ? WHERE url = ? AND type = 1", new Object[]{l, string});
            string2 = string3.rawQuery("SELECT COUNT(*) FROM Config WHERE url = ? AND type = 1", new String[]{string});
            string2.moveToFirst();
            if (string2.getInt(0) == 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("url", string);
                contentValues.put("type", Integer.valueOf(1));
                contentValues.put("time", Long.valueOf(l));
                string3.insert("Config", null, contentValues);
            }
            string2.close();
            string3.close();
            try {
                string3 = SQLiteDatabase.openDatabase((String)InitOrigin.context().getDatabasePath("tv").getAbsolutePath(), null, (int)0);
                string3.execSQL("UPDATE Config SET time = ? WHERE url = ? AND type = 1", new Object[]{System.currentTimeMillis(), string});
                string3.close();
            }
            catch (Exception exception) {
                try {
                    SpiderDebug.log((Throwable)exception);
                }
                catch (Exception exception2) {
                    SpiderDebug.log((Throwable)exception2);
                }
            }
        }
    }
}

