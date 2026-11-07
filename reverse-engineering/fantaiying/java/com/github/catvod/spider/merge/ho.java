/*
 * Decompiled with CFR 0.152.
 */
package com.github.catvod.spider.merge;

import com.github.catvod.spider.merge.cp;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;

public final class ho {
    private final CharBuffer N;
    private final ByteBuffer SN;
    private final IntBuffer tF;
    private final int yq;

    ho(int n2, ByteBuffer byteBuffer, CharBuffer charBuffer, IntBuffer intBuffer) {
        this.yq = n2;
        this.SN = byteBuffer;
        this.N = charBuffer;
        this.tF = intBuffer;
    }

    final char[] N() {
        return this.N.array();
    }

    final byte[] SN() {
        return this.SN.array();
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final int i() {
        void var2_3;
        int n2 = cp.SN(this.yq);
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) throw new UnsupportedOperationException("Not reached");
                IntBuffer intBuffer = this.tF;
                return var2_3.position();
            }
            CharBuffer charBuffer = this.N;
            return var2_3.position();
        }
        ByteBuffer byteBuffer = this.SN;
        return var2_3.position();
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final int t0() {
        void var2_3;
        int n2 = cp.SN(this.yq);
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) throw new UnsupportedOperationException("Not reached");
                IntBuffer intBuffer = this.tF;
                return var2_3.remaining();
            }
            CharBuffer charBuffer = this.N;
            return var2_3.remaining();
        }
        ByteBuffer byteBuffer = this.SN;
        return var2_3.remaining();
    }

    final int tF() {
        return this.yq;
    }

    final int yq() {
        int n2 = cp.SN(this.yq);
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 == 2) {
                    return this.tF.arrayOffset();
                }
                throw new UnsupportedOperationException("Not reached");
            }
            return this.N.arrayOffset();
        }
        return this.SN.arrayOffset();
    }

    final int[] zH() {
        return this.tF.array();
    }

    public static final class yq {
        private CharBuffer N;
        private ByteBuffer SN;
        private IntBuffer tF;
        private int yq = 1;
        private int zH;

        yq(int n2) {
            this.SN = ByteBuffer.allocate(n2);
            this.N = null;
            this.tF = null;
            this.zH = -1;
        }

        private void N(CharBuffer buffer) {
            int n2;
            int n3;
            char[] cArray = ((CharBuffer)buffer).array();
            int n4 = ((CharBuffer)buffer).arrayOffset();
            int n5 = buffer.position() + n4;
            int n7 = ((CharBuffer)buffer).arrayOffset();
            int n8 = buffer.limit();
            int[] nArray = this.tF.array();
            n4 = this.tF.arrayOffset();
            n4 = this.tF.position() + n4;
            while (true) {
                char c;
                block10: {
                    block9: {
                        block8: {
                            block5: {
                                block7: {
                                    block6: {
                                        n3 = -1;
                                        if (n5 >= n8 + n7) break;
                                        c = cArray[n5];
                                        n2 = n5 + 1;
                                        if (this.zH == -1) break block5;
                                        if (!Character.isLowSurrogate(c)) break block6;
                                        nArray[n4] = Character.toCodePoint((char)this.zH, c);
                                        break block7;
                                    }
                                    nArray[n4] = this.zH;
                                    ++n4;
                                    if (Character.isHighSurrogate(c)) break block8;
                                    nArray[n4] = 0xFFFF & c;
                                }
                                ++n4;
                                n5 = n3;
                                break block9;
                            }
                            if (!Character.isHighSurrogate(c)) break block10;
                        }
                        n5 = c & 0xFFFF;
                    }
                    this.zH = n5;
                    n5 = n2;
                    continue;
                }
                nArray[n4] = c & 0xFFFF;
                ++n4;
                n5 = n2;
            }
            n3 = this.zH;
            n2 = n4;
            if (n3 != -1) {
                nArray[n4] = n3 & 0xFFFF;
                n2 = n4 + 1;
            }
            ((CharBuffer)buffer).position(n5 - ((CharBuffer)buffer).arrayOffset());
            buffer = this.tF;
            ((IntBuffer)buffer).position(n2 - ((IntBuffer)buffer).arrayOffset());
        }

        private void SN(CharBuffer charBuffer) {
            Object object = charBuffer.array();
            int n2 = charBuffer.arrayOffset();
            int n3 = charBuffer.position() + n2;
            int n4 = charBuffer.arrayOffset();
            int n5 = charBuffer.limit();
            char[] cArray = this.N.array();
            n2 = this.N.arrayOffset();
            n2 = this.N.position() + n2;
            while (n3 < n5 + n4) {
                char c = object[n3];
                if (!Character.isHighSurrogate(c)) {
                    cArray[n2] = c;
                    ++n3;
                    ++n2;
                    continue;
                }
                charBuffer.position(n3 - charBuffer.arrayOffset());
                object = this.N;
                ((CharBuffer)object).position(n2 - ((CharBuffer)object).arrayOffset());
                n2 = charBuffer.remaining();
                this.N.flip();
                object = IntBuffer.allocate(Math.max(this.N.remaining() + n2, this.N.capacity() / 2));
                while (this.N.hasRemaining()) {
                    ((IntBuffer)object).put(this.N.get() & 0xFFFF);
                }
                this.yq = 3;
                this.N = null;
                this.tF = object;
                this.N(charBuffer);
                return;
            }
            charBuffer.position(n3 - charBuffer.arrayOffset());
            charBuffer = this.N;
            charBuffer.position(n2 - charBuffer.arrayOffset());
        }

        private static int zH(int n2) {
            return (int)Math.pow(2.0, 32 - Integer.numberOfLeadingZeros(n2 - 1));
        }

        public final ho tF() {
            int n2 = cp.SN(this.yq);
            if (n2 != 0) {
                if (n2 != 1) {
                    if (n2 == 2) {
                        this.tF.flip();
                    }
                } else {
                    this.N.flip();
                }
            } else {
                this.SN.flip();
            }
            return new ho(this.yq, this.SN, this.N, this.tF);
        }

        public final void yq(CharBuffer object) {
            Object object2;
            int n2 = ((Buffer)object).remaining();
            int n3 = cp.SN(this.yq);
            if (n3 != 0) {
                if (n3 != 1) {
                    if (n3 == 2 && this.tF.remaining() < n2) {
                        object2 = IntBuffer.allocate(com.github.catvod.spider.merge.ho$yq.zH(this.tF.capacity() + n2));
                        this.tF.flip();
                        ((IntBuffer)object2).put(this.tF);
                        this.tF = object2;
                    }
                } else if (this.N.remaining() < n2) {
                    object2 = CharBuffer.allocate(com.github.catvod.spider.merge.ho$yq.zH(this.N.capacity() + n2));
                    this.N.flip();
                    ((CharBuffer)object2).put(this.N);
                    this.N = object2;
                }
            } else if (this.SN.remaining() < n2) {
                object2 = ByteBuffer.allocate(com.github.catvod.spider.merge.ho$yq.zH(this.SN.capacity() + n2));
                this.SN.flip();
                ((ByteBuffer)object2).put(this.SN);
                this.SN = object2;
            }
            if (((CharBuffer)object).hasArray()) {
                block19: {
                    n2 = cp.SN(this.yq);
                    if (n2 != 0) {
                        if (n2 != 1) {
                            if (n2 == 2) {
                                this.N((CharBuffer)object);
                            }
                        } else {
                            this.SN((CharBuffer)object);
                        }
                    } else {
                        char[] cArray = ((CharBuffer)object).array();
                        n2 = ((CharBuffer)object).arrayOffset();
                        n3 = ((Buffer)object).position() + n2;
                        int n4 = ((CharBuffer)object).arrayOffset();
                        int n5 = ((Buffer)object).limit();
                        object2 = this.SN.array();
                        n2 = this.SN.arrayOffset();
                        n2 = this.SN.position() + n2;
                        while (n3 < n5 + n4) {
                            char c = cArray[n3];
                            if (c <= '\u00ff') {
                                object2[n2] = (byte)(c & 0xFF);
                                ++n3;
                                ++n2;
                                continue;
                            }
                            ((CharBuffer)object).position(n3 - ((CharBuffer)object).arrayOffset());
                            object2 = this.SN;
                            ((ByteBuffer)object2).position(n2 - ((ByteBuffer)object2).arrayOffset());
                            if (!Character.isHighSurrogate(c)) {
                                n2 = ((Buffer)object).remaining();
                                this.SN.flip();
                                object2 = CharBuffer.allocate(Math.max(this.SN.remaining() + n2, this.SN.capacity() / 2));
                                while (this.SN.hasRemaining()) {
                                    ((CharBuffer)object2).put((char)(this.SN.get() & 0xFF));
                                }
                                this.yq = 2;
                                this.SN = null;
                                this.N = object2;
                                this.SN((CharBuffer)object);
                            } else {
                                n2 = ((Buffer)object).remaining();
                                this.SN.flip();
                                object2 = IntBuffer.allocate(Math.max(this.SN.remaining() + n2, this.SN.capacity() / 4));
                                while (this.SN.hasRemaining()) {
                                    ((IntBuffer)object2).put(this.SN.get() & 0xFF);
                                }
                                this.yq = 3;
                                this.SN = null;
                                this.tF = object2;
                                this.N((CharBuffer)object);
                            }
                            break block19;
                        }
                        ((CharBuffer)object).position(n3 - ((CharBuffer)object).arrayOffset());
                        object = this.SN;
                        ((ByteBuffer)object).position(n2 - ((ByteBuffer)object).arrayOffset());
                    }
                }
                return;
            }
            object = new UnsupportedOperationException("TODO");
            throw object;
        }
    }
}

