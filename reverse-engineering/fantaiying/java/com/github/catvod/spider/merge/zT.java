/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class zT {
    private String N;
    private int SN;
    private Mac yq;

    public zT(String object) {
        this.N = object;
        try {
            this.yq = object = Mac.getInstance((String)object);
            this.SN = ((Mac)object).getMacLength();
            return;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException(noSuchAlgorithmException);
        }
    }

    public final int N() {
        return this.SN;
    }

    public final byte[] SN(byte[] byArray) {
        return this.yq.doFinal(byArray);
    }

    public final void tF(byte[] byArray) {
        try {
            Mac mac = this.yq;
            SecretKeySpec secretKeySpec = new SecretKeySpec(byArray, this.N);
            mac.init(secretKeySpec);
            return;
        }
        catch (InvalidKeyException invalidKeyException) {
            throw new RuntimeException(invalidKeyException);
        }
    }

    public final byte[] yq() {
        return this.yq.doFinal();
    }

    public final void zH(byte[] byArray, int n2, int n3) {
        try {
            this.yq.update(byArray, n2, n3);
            return;
        }
        catch (IllegalStateException illegalStateException) {
            throw new RuntimeException(illegalStateException);
        }
    }
}

