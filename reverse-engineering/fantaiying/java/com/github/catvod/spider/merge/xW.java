/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.A7;
import com.github.catvod.spider.merge.AF;
import com.github.catvod.spider.merge.Bp;
import com.github.catvod.spider.merge.Db;
import com.github.catvod.spider.merge.Eo;
import com.github.catvod.spider.merge.FN;
import com.github.catvod.spider.merge.GL;
import com.github.catvod.spider.merge.Go;
import com.github.catvod.spider.merge.LL;
import com.github.catvod.spider.merge.MA;
import com.github.catvod.spider.merge.NO;
import com.github.catvod.spider.merge.OT;
import com.github.catvod.spider.merge.Q;
import com.github.catvod.spider.merge.QS;
import com.github.catvod.spider.merge.RR;
import com.github.catvod.spider.merge.T4;
import com.github.catvod.spider.merge.Uo;
import com.github.catvod.spider.merge.XX;
import com.github.catvod.spider.merge.Ya;
import com.github.catvod.spider.merge.Yk;
import com.github.catvod.spider.merge.aA;
import com.github.catvod.spider.merge.cl;
import com.github.catvod.spider.merge.co;
import com.github.catvod.spider.merge.eV;
import com.github.catvod.spider.merge.eY;
import com.github.catvod.spider.merge.em;
import com.github.catvod.spider.merge.fM;
import com.github.catvod.spider.merge.gU;
import com.github.catvod.spider.merge.gt_0;
import com.github.catvod.spider.merge.h0_0;
import com.github.catvod.spider.merge.hf;
import com.github.catvod.spider.merge.jc_1;
import com.github.catvod.spider.merge.kH;
import com.github.catvod.spider.merge.m0;
import com.github.catvod.spider.merge.mu;
import com.github.catvod.spider.merge.og;
import com.github.catvod.spider.merge.op;
import com.github.catvod.spider.merge.pe_1;
import com.github.catvod.spider.merge.py_1;
import com.github.catvod.spider.merge.qJ;
import com.github.catvod.spider.merge.qb_0;
import com.github.catvod.spider.merge.rs_1;
import com.github.catvod.spider.merge.so_0;
import com.github.catvod.spider.merge.uc_0;
import com.github.catvod.spider.merge.wV;
import com.github.catvod.spider.merge.wf;
import java.util.HashMap;
import java.util.Map;

public final class xW {
    private static Map<String, fM> N;
    private static Map<String, co> SN;
    private static mu tF;
    private static Map<String, og> yq;

    static {
        Object object;
        int n2;
        yq = new HashMap<String, og>();
        SN = new HashMap<String, co>();
        N = new HashMap<String, fM>();
        tF = kH.tF(xW.class);
        int n3 = 0;
        for (n2 = 0; n2 < 14; ++n2) {
            object = (new Class[]{gt_0.class, GL.class, Q.class, h0_0.class, QS.class, T4.class, op.class, Uo.class, hf.class, wV.class, so_0.class, RR.class, Bp.class, pe_1.class})[n2];
            try {
                object = (og)((Class)object).newInstance();
                ((HashMap)yq).put(object.name(), (og)object);
                continue;
            }
            catch (Exception exception) {
                tF.yq(rs_1.dT(exception), exception);
            }
        }
        for (n2 = 0; n2 < 17; ++n2) {
            object = (new Class[]{jc_1.class, qb_0.class, wf.class, qJ.class, py_1.class, cl.class, FN.class, Ya.class, gU.class, Yk.class, AF.class, em.class, XX.class, m0.class, Db.class, NO.class, uc_0.class})[n2];
            try {
                object = (fM)((Class)object).newInstance();
                ((HashMap)N).put(object.name(), (fM)object);
                continue;
            }
            catch (Exception exception) {
                tF.yq(rs_1.dT(exception), exception);
            }
        }
        for (n2 = n3; n2 < 6; ++n2) {
            object = (new Class[]{OT.class, A7.class, aA.class, eV.class, Eo.class, Go.class})[n2];
            try {
                object = (co)((Class)object).newInstance();
                ((HashMap)SN).put(object.name(), (co)object);
                continue;
            }
            catch (Exception exception) {
                tF.yq(rs_1.dT(exception), exception);
            }
        }
    }

    public static og N(String string) {
        og og2 = (og)((HashMap)yq).get(string);
        if (og2 != null) {
            return og2;
        }
        throw new MA(eY.yq("not support axis: ", string));
    }

    public static co SN(String string) {
        co co2 = (co)((HashMap)SN).get(string);
        if (co2 != null) {
            return co2;
        }
        throw new LL(eY.yq("not support nodeTest: ", string));
    }

    public static fM yq(String string) {
        fM fM2 = (fM)((HashMap)N).get(string);
        if (fM2 != null) {
            return fM2;
        }
        throw new LL(eY.yq("not support function: ", string));
    }
}

