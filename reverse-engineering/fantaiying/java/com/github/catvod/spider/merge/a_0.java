/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.Nr;
import com.github.catvod.spider.merge.Oh;
import com.github.catvod.spider.merge.U7;
import com.github.catvod.spider.merge.Va;
import com.github.catvod.spider.merge.co_0;
import com.github.catvod.spider.merge.il_1;
import com.github.catvod.spider.merge.k6;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Pattern;

/*
 * Renamed from com.github.catvod.spider.merge.a
 */
public final class a_0
implements Map.Entry<String, String>,
Cloneable {
    private static final Pattern Gc;
    private static final Pattern i;
    private static final Pattern t0;
    private static final String[] tF;
    private static final Pattern zH;
    k6 N;
    private String SN;
    private String yq;

    static {
        tF = new String[]{"allowfullscreen", "async", "autofocus", "checked", "compact", "declare", "default", "defer", "disabled", "formnovalidate", "hidden", "inert", "ismap", "itemscope", "multiple", "muted", "nohref", "noresize", "noshade", "novalidate", "nowrap", "open", "readonly", "required", "reversed", "seamless", "selected", "sortable", "truespeed", "typemustmatch"};
        zH = Pattern.compile("[a-zA-Z_:][-a-zA-Z0-9_:.]*");
        i = Pattern.compile("[^-a-zA-Z0-9_:.]");
        t0 = Pattern.compile("[^\\x00-\\x1f\\x7f-\\x9f \"'/=]+");
        Gc = Pattern.compile("[\\x00-\\x1f\\x7f-\\x9f \"'/=]");
    }

    public a_0(String string, String string2, k6 k62) {
        co_0.Gc(string);
        string = string.trim();
        co_0.i(string);
        this.yq = string;
        this.SN = string2;
        this.N = k62;
    }

    public static String SN(String string, int n2) {
        Pattern pattern;
        String string2 = null;
        String string3 = null;
        if (n2 == 2 && !(pattern = zH).matcher(string).matches()) {
            string2 = i.matcher(string).replaceAll("");
            string = string3;
            if (pattern.matcher(string2).matches()) {
                string = string2;
            }
            return string;
        }
        if (n2 == 1 && !(pattern = t0).matcher(string).matches()) {
            string3 = Gc.matcher(string).replaceAll("");
            string = string2;
            if (pattern.matcher(string3).matches()) {
                string = string3;
            }
            return string;
        }
        return string;
    }

    static void tF(String string, String string2, Appendable appendable, Va.yq yq2) {
        boolean bl;
        block4: {
            block5: {
                boolean bl2;
                int n2;
                block6: {
                    appendable.append(string);
                    n2 = yq2.Gc();
                    bl = bl2 = false;
                    if (n2 != 1) break block4;
                    if (string2 == null) break block5;
                    if (string2.isEmpty()) break block6;
                    bl = bl2;
                    if (!string2.equalsIgnoreCase(string)) break block4;
                }
                n2 = Arrays.binarySearch(tF, U7.M(string)) >= 0 ? 1 : 0;
                bl = bl2;
                if (n2 == 0) break block4;
            }
            bl = true;
        }
        if (!bl) {
            appendable.append("=\"");
            il_1.tF(appendable, k6.M(string2), yq2, true, false, false, false);
            appendable.append('\"');
        }
    }

    public final String N() {
        return k6.M(this.SN);
    }

    public final Object clone() {
        try {
            a_0 a_02 = (a_0)super.clone();
            return a_02;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    @Override
    public final boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return true;
        }
        if (object != null && a_0.class == object.getClass()) {
            object = (a_0)object;
            String string = this.yq;
            if (string != null ? !string.equals(((a_0)object).yq) : ((a_0)object).yq != null) {
                return false;
            }
            string = this.SN;
            object = ((a_0)object).SN;
            if (string != null) {
                bl = string.equals(object);
            } else if (object != null) {
                bl = false;
            }
            return bl;
        }
        return false;
    }

    @Override
    public final Object getKey() {
        return this.yq;
    }

    @Override
    public final int hashCode() {
        String string = this.yq;
        int n2 = 0;
        int n3 = string != null ? string.hashCode() : 0;
        string = this.SN;
        if (string != null) {
            n2 = string.hashCode();
        }
        return n3 * 31 + n2;
    }

    @Override
    public final Object setValue(Object object) {
        String string = (String)object;
        String string2 = this.SN;
        k6 k62 = this.N;
        object = string2;
        if (k62 != null) {
            int n2 = k62.v3(this.yq);
            object = string2;
            if (n2 != -1) {
                object = this.N.B(this.yq);
                this.N.N[n2] = string;
            }
        }
        this.SN = string;
        return k6.M(object);
    }

    public final String toString() {
        StringBuilder stringBuilder;
        block3: {
            String string;
            String string2;
            Cloneable cloneable;
            stringBuilder = Nr.SN();
            try {
                cloneable = new Va("");
                cloneable = ((Va)cloneable).D();
                string2 = this.yq;
                string = this.SN;
                string2 = a_0.SN(string2, ((Va.yq)cloneable).Gc());
                if (string2 == null) break block3;
            }
            catch (IOException iOException) {
                throw new Oh(iOException);
            }
            a_0.tF(string2, string, stringBuilder, (Va.yq)cloneable);
        }
        return Nr.Gc(stringBuilder);
    }

    public final String yq() {
        return this.yq;
    }
}

