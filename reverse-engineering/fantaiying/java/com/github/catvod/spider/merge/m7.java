/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.hE;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public interface m7
extends ExecutorService {
    public <T> hE<T> submit(Callable<T> var1);
}

