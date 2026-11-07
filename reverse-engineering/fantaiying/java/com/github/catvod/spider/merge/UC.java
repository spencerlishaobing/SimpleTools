/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.b9;
import com.github.catvod.spider.merge.gs;
import com.github.catvod.spider.merge.jM;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public final class UC
implements b9 {
    private final List<gs> yq;

    public UC() {
        File file = new File(System.getProperty("java.io.tmpdir"));
        if (!file.exists()) {
            file.mkdirs();
        }
        this.yq = new ArrayList<gs>();
    }

    @Override
    public final void clear() {
        for (gs gs2 : this.yq) {
            try {
                gs2.yq();
            }
            catch (Exception exception) {
                jM.KJ.log(Level.WARNING, "could not delete file ", exception);
            }
        }
        ((ArrayList)this.yq).clear();
    }
}

