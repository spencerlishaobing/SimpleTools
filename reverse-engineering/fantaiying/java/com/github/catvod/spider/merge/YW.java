/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.U7;
import com.github.catvod.spider.merge.co_0;
import com.github.catvod.spider.merge.l4;
import java.util.HashMap;
import java.util.Map;

public final class YW
implements Cloneable {
    private static final String[] B;
    private static final String[] F5;
    private static final String[] G;
    private static final String[] G4;
    private static final Map<String, YW> KJ;
    private static final String[] dT;
    private static final String[] q;
    private boolean Gc = false;
    private boolean M = false;
    private boolean N = true;
    private String SN;
    private boolean i = false;
    private boolean t0 = false;
    private boolean tF = true;
    private String yq;
    private boolean zH = false;

    static {
        int n2;
        KJ = new HashMap<String, YW>();
        q = new String[]{"object", "base", "font", "tt", "i", "b", "u", "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", "a", "img", "br", "wbr", "map", "q", "sub", "sup", "bdo", "iframe", "embed", "span", "input", "select", "textarea", "label", "button", "optgroup", "option", "legend", "datalist", "keygen", "output", "progress", "meter", "area", "param", "source", "track", "summary", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track", "data", "bdi", "s", "strike", "nobr"};
        B = new String[]{"meta", "link", "base", "frame", "img", "br", "wbr", "embed", "hr", "input", "keygen", "col", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track"};
        G = new String[]{"title", "a", "p", "h1", "h2", "h3", "h4", "h5", "h6", "pre", "address", "li", "th", "td", "script", "style", "ins", "del", "s"};
        G4 = new String[]{"pre", "plaintext", "title", "textarea"};
        dT = new String[]{"button", "fieldset", "input", "keygen", "object", "output", "select", "textarea"};
        F5 = new String[]{"input", "keygen", "object", "select", "textarea"};
        int n3 = 0;
        for (n2 = 0; n2 < 69; ++n2) {
            YW object = new YW((new String[]{"html", "head", "body", "frameset", "script", "noscript", "style", "meta", "link", "title", "frame", "noframes", "section", "nav", "aside", "hgroup", "header", "footer", "p", "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", "pre", "div", "blockquote", "hr", "address", "figure", "figcaption", "form", "fieldset", "ins", "del", "dl", "dt", "dd", "li", "table", "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", "video", "audio", "canvas", "details", "menu", "plaintext", "template", "article", "main", "svg", "math", "center", "template", "dir", "applet", "marquee", "listing"})[n2]);
            ((HashMap)KJ).put(object.yq, object);
        }
        String[] stringArray = q;
        int n4 = stringArray.length;
        for (n2 = 0; n2 < n4; ++n2) {
            YW yW = new YW(stringArray[n2]);
            yW.N = false;
            yW.tF = false;
            ((HashMap)KJ).put(yW.yq, yW);
        }
        for (String string : B) {
            YW yW = (YW)((HashMap)KJ).get(string);
            co_0.Gc(yW);
            yW.zH = true;
        }
        for (String string : G) {
            YW yW = (YW)((HashMap)KJ).get(string);
            co_0.Gc(yW);
            yW.tF = false;
        }
        for (String string : G4) {
            YW yW = (YW)((HashMap)KJ).get(string);
            co_0.Gc(yW);
            yW.t0 = true;
        }
        for (String string : dT) {
            YW yW = (YW)((HashMap)KJ).get(string);
            co_0.Gc(yW);
            yW.Gc = true;
        }
        String[] stringArray2 = F5;
        n4 = stringArray2.length;
        for (n2 = n3; n2 < n4; ++n2) {
            String string = stringArray2[n2];
            YW yW = (YW)((HashMap)KJ).get(string);
            co_0.Gc(yW);
            yW.M = true;
        }
    }

    private YW(String string) {
        this.yq = string;
        this.SN = U7.M(string);
    }

    public static YW G(String string, l4 l42) {
        co_0.Gc(string);
        Map<String, YW> map = KJ;
        Object object = (YW)((HashMap)map).get(string);
        YW yW = object;
        if (object == null) {
            string = l42.tF(string);
            co_0.i(string);
            object = U7.M(string);
            yW = (YW)((HashMap)map).get(object);
            if (yW == null) {
                yW = new YW(string);
                yW.N = false;
            } else if (l42.i() && !string.equals(object)) {
                try {
                    yW = (YW)super.clone();
                    yW.yq = string;
                }
                catch (CloneNotSupportedException cloneNotSupportedException) {
                    throw new RuntimeException(cloneNotSupportedException);
                }
            }
        }
        return yW;
    }

    public static boolean Gc(String string) {
        return ((HashMap)KJ).containsKey(string);
    }

    final YW B() {
        this.i = true;
        return this;
    }

    public final String KJ() {
        return this.SN;
    }

    public final boolean M() {
        boolean bl = this.zH || this.i;
        return bl;
    }

    public final boolean N() {
        return this.N;
    }

    public final String SN() {
        return this.yq;
    }

    protected final Object clone() {
        try {
            YW yW = (YW)super.clone();
            return yW;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    public final boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return true;
        }
        if (!(object instanceof YW)) {
            return false;
        }
        object = (YW)object;
        if (!this.yq.equals(((YW)object).yq)) {
            return false;
        }
        if (this.zH != ((YW)object).zH) {
            return false;
        }
        if (this.tF != ((YW)object).tF) {
            return false;
        }
        if (this.N != ((YW)object).N) {
            return false;
        }
        if (this.t0 != ((YW)object).t0) {
            return false;
        }
        if (this.i != ((YW)object).i) {
            return false;
        }
        if (this.Gc != ((YW)object).Gc) {
            return false;
        }
        if (this.M != ((YW)object).M) {
            bl = false;
        }
        return bl;
    }

    public final int hashCode() {
        return ((((((this.yq.hashCode() * 31 + this.N) * 31 + this.tF) * 31 + this.zH) * 31 + this.i) * 31 + this.t0) * 31 + this.Gc) * 31 + this.M;
    }

    public final boolean i() {
        return this.N ^ true;
    }

    public final boolean q() {
        return this.t0;
    }

    public final boolean t0() {
        return ((HashMap)KJ).containsKey(this.yq);
    }

    public final boolean tF() {
        return this.zH;
    }

    public final String toString() {
        return this.yq;
    }

    public final boolean yq() {
        return this.tF;
    }

    public final boolean zH() {
        return this.Gc;
    }
}

