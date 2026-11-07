/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.xmlpull.v1.XmlPullParser
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.H0;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;

public final class jo {
    static final Class tF;
    protected Hashtable N = new Hashtable();
    protected String SN;
    protected Vector yq;

    static {
        new jo();
        tF = jo.class;
    }

    protected jo() {
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static jo yq() {
        Vector vector;
        String string;
        String string2;
        int n2;
        Object object;
        Object object2 = tF;
        try {
            object2 = ((Class)object2).getResourceAsStream("/META-INF/services/org.xmlpull.v1.XmlPullParserFactory");
            if (object2 == null) {
                object2 = new H0("resource not found: /META-INF/services/org.xmlpull.v1.XmlPullParserFactory make sure that parser implementing XmlPull API is available");
                throw object2;
            }
            object = new StringBuffer();
            while (true) {
                if ((n2 = ((InputStream)object2).read()) < 0) {
                    ((InputStream)object2).close();
                    string2 = ((StringBuffer)object).toString();
                    object2 = new StringBuffer();
                    ((StringBuffer)object2).append("resource /META-INF/services/org.xmlpull.v1.XmlPullParserFactory that contained '");
                    ((StringBuffer)object2).append(string2);
                    ((StringBuffer)object2).append("'");
                    string = ((StringBuffer)object2).toString();
                    vector = new Vector();
                    new Vector();
                    object2 = null;
                    n2 = 0;
                    break;
                }
                if (n2 <= 32) continue;
                char c = (char)n2;
                ((StringBuffer)object).append(c);
            }
        }
        catch (Exception exception) {
            H0 h0 = new H0(exception);
            throw h0;
        }
        while (true) {
            Object var7_13;
            String string3;
            int n3;
            int n4;
            block22: {
                if (n2 >= string2.length()) {
                    object = object2;
                    if (object2 == null) {
                        object = new jo();
                    }
                    ((jo)object).yq = vector;
                    ((jo)object).SN = string;
                    return object;
                }
                n3 = n4 = string2.indexOf(44, n2);
                if (n4 == -1) {
                    n3 = string2.length();
                }
                string3 = string2.substring(n2, n3);
                object = Class.forName(string3);
                var7_13 = ((Class)object).newInstance();
                break block22;
                {
                    catch (Exception exception) {}
                }
                catch (Exception exception) {
                    object = null;
                    var7_13 = null;
                }
            }
            Object object3 = object2;
            if (object != null) {
                boolean bl = var7_13 instanceof XmlPullParser;
                n4 = 1;
                if (bl) {
                    vector.addElement((Class<?>)object);
                    n2 = 1;
                } else {
                    n2 = 0;
                }
                if (var7_13 instanceof jo) {
                    object = object2;
                    n2 = n4;
                    if (object2 == null) {
                        object = var7_13;
                        n2 = n4;
                    }
                } else {
                    object = object2;
                }
                if (n2 == 0) {
                    object2 = new StringBuffer();
                    ((StringBuffer)object2).append("incompatible class: ");
                    ((StringBuffer)object2).append(string3);
                    throw new H0(((StringBuffer)object2).toString());
                }
                object3 = object;
            }
            n2 = n3 + 1;
            object2 = object3;
        }
    }

    public final void N() {
        this.N.put("http://xmlpull.org/v1/doc/features.html#process-namespaces", new Boolean(true));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final XmlPullParser SN() {
        Serializable serializable = this.yq;
        if (serializable == null) {
            serializable = new StringBuffer();
            ((StringBuffer)serializable).append("Factory initialization was incomplete - has not tried ");
            ((StringBuffer)serializable).append(this.SN);
            serializable = new H0(((StringBuffer)serializable).toString());
            throw serializable;
        }
        if (((Vector)serializable).size() == 0) {
            serializable = new StringBuffer();
            ((StringBuffer)serializable).append("No valid parser classes found in ");
            ((StringBuffer)serializable).append(this.SN);
            throw new H0(((StringBuffer)serializable).toString());
        }
        serializable = new StringBuffer();
        int n2 = 0;
        while (true) {
            CharSequence charSequence;
            Serializable serializable2;
            if (n2 >= this.yq.size()) {
                serializable2 = new StringBuffer();
                ((StringBuffer)serializable2).append("could not create parser: ");
                ((StringBuffer)serializable2).append(serializable);
                throw new H0(((StringBuffer)serializable2).toString());
            }
            serializable2 = (Class)this.yq.elementAt(n2);
            try {
                XmlPullParser xmlPullParser = (XmlPullParser)((Class)serializable2).newInstance();
                Enumeration enumeration = this.N.keys();
                while (true) {
                    if (!enumeration.hasMoreElements()) {
                        return xmlPullParser;
                    }
                    charSequence = (String)enumeration.nextElement();
                    Boolean bl = (Boolean)this.N.get(charSequence);
                    if (bl == null || !bl.booleanValue()) continue;
                    xmlPullParser.setFeature((String)charSequence, true);
                }
            }
            catch (Exception exception) {
                charSequence = new StringBuffer();
                ((StringBuffer)charSequence).append(((Class)serializable2).getName());
                ((StringBuffer)charSequence).append(": ");
                ((StringBuffer)charSequence).append(((Object)exception).toString());
                ((StringBuffer)charSequence).append("; ");
                ((StringBuffer)serializable).append(((StringBuffer)charSequence).toString());
                ++n2;
                continue;
            }
            break;
        }
    }
}

