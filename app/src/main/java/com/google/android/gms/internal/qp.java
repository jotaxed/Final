package com.google.android.gms.internal;

import android.support.v4.view.MotionEventCompat;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class qp {
    private final int ayV;
    private final byte[] buffer;
    private int position;

    public static class a extends IOException {
        a(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private qp(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.position = i;
        this.ayV = i + i2;
    }

    public static int D(long j) {
        return G(j);
    }

    public static int E(long j) {
        return G(I(j));
    }

    public static int G(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    public static long I(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public static int X(boolean z) {
        return 1;
    }

    public static int b(int i, double d) {
        return hc(i) + f(d);
    }

    public static int b(int i, qw qwVar) {
        return (hc(i) * 2) + d(qwVar);
    }

    public static int b(int i, byte[] bArr) {
        return hc(i) + s(bArr);
    }

    public static qp b(byte[] bArr, int i, int i2) {
        return new qp(bArr, i, i2);
    }

    public static int c(int i, float f) {
        return hc(i) + e(f);
    }

    public static int c(int i, qw qwVar) {
        return hc(i) + e(qwVar);
    }

    public static int c(int i, boolean z) {
        return hc(i) + X(z);
    }

    public static int d(int i, long j) {
        return hc(i) + D(j);
    }

    public static int d(qw qwVar) {
        return qwVar.rZ();
    }

    public static int dk(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + he(bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int e(float f) {
        return 4;
    }

    public static int e(int i, long j) {
        return hc(i) + E(j);
    }

    public static int e(qw qwVar) {
        int rZ = qwVar.rZ();
        return rZ + he(rZ);
    }

    public static int f(double d) {
        return 8;
    }

    public static int gZ(int i) {
        return i >= 0 ? he(i) : 10;
    }

    public static int ha(int i) {
        return he(hg(i));
    }

    public static int hc(int i) {
        return he(qz.y(i, 0));
    }

    public static int he(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int hg(int i) {
        return (i << 1) ^ (i >> 31);
    }

    public static int j(int i, String str) {
        return hc(i) + dk(str);
    }

    public static qp q(byte[] bArr) {
        return b(bArr, 0, bArr.length);
    }

    public static int s(byte[] bArr) {
        return he(bArr.length) + bArr.length;
    }

    public static int v(int i, int i2) {
        return hc(i) + gZ(i2);
    }

    public static int w(int i, int i2) {
        return hc(i) + ha(i2);
    }

    public void B(long j) throws IOException {
        F(j);
    }

    public void C(long j) throws IOException {
        F(I(j));
    }

    public void F(long j) throws IOException {
        while ((-128 & j) != 0) {
            hb((((int) j) & 127) | 128);
            j >>>= 7;
        }
        hb((int) j);
    }

    public void H(long j) throws IOException {
        hb(((int) j) & MotionEventCompat.ACTION_MASK);
        hb(((int) (j >> 8)) & MotionEventCompat.ACTION_MASK);
        hb(((int) (j >> 16)) & MotionEventCompat.ACTION_MASK);
        hb(((int) (j >> 24)) & MotionEventCompat.ACTION_MASK);
        hb(((int) (j >> 32)) & MotionEventCompat.ACTION_MASK);
        hb(((int) (j >> 40)) & MotionEventCompat.ACTION_MASK);
        hb(((int) (j >> 48)) & MotionEventCompat.ACTION_MASK);
        hb(((int) (j >> 56)) & MotionEventCompat.ACTION_MASK);
    }

    public void W(boolean z) throws IOException {
        hb(z ? 1 : 0);
    }

    public void a(int i, double d) throws IOException {
        x(i, 1);
        e(d);
    }

    public void a(int i, qw qwVar) throws IOException {
        x(i, 2);
        c(qwVar);
    }

    public void a(int i, byte[] bArr) throws IOException {
        x(i, 2);
        r(bArr);
    }

    public void b(byte b) throws IOException {
        if (this.position == this.ayV) {
            throw new a(this.position, this.ayV);
        }
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    public void b(int i, float f) throws IOException {
        x(i, 5);
        d(f);
    }

    public void b(int i, long j) throws IOException {
        x(i, 0);
        B(j);
    }

    public void b(int i, String str) throws IOException {
        x(i, 2);
        dj(str);
    }

    public void b(int i, boolean z) throws IOException {
        x(i, 0);
        W(z);
    }

    public void b(qw qwVar) throws IOException {
        qwVar.a(this);
    }

    public void c(int i, long j) throws IOException {
        x(i, 0);
        C(j);
    }

    public void c(qw qwVar) throws IOException {
        hd(qwVar.rY());
        qwVar.a(this);
    }

    public void c(byte[] bArr, int i, int i2) throws IOException {
        if (this.ayV - this.position >= i2) {
            System.arraycopy(bArr, i, this.buffer, this.position, i2);
            this.position += i2;
            return;
        }
        throw new a(this.position, this.ayV);
    }

    public void d(float f) throws IOException {
        hf(Float.floatToIntBits(f));
    }

    public void dj(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        hd(bytes.length);
        t(bytes);
    }

    public void e(double d) throws IOException {
        H(Double.doubleToLongBits(d));
    }

    public void gX(int i) throws IOException {
        if (i >= 0) {
            hd(i);
        } else {
            F((long) i);
        }
    }

    public void gY(int i) throws IOException {
        hd(hg(i));
    }

    public void hb(int i) throws IOException {
        b((byte) i);
    }

    public void hd(int i) throws IOException {
        while ((i & -128) != 0) {
            hb((i & 127) | 128);
            i >>>= 7;
        }
        hb(i);
    }

    public void hf(int i) throws IOException {
        hb(i & MotionEventCompat.ACTION_MASK);
        hb((i >> 8) & MotionEventCompat.ACTION_MASK);
        hb((i >> 16) & MotionEventCompat.ACTION_MASK);
        hb((i >> 24) & MotionEventCompat.ACTION_MASK);
    }

    public void r(byte[] bArr) throws IOException {
        hd(bArr.length);
        t(bArr);
    }

    public int rO() {
        return this.ayV - this.position;
    }

    public void rP() {
        if (rO() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void t(int i, int i2) throws IOException {
        x(i, 0);
        gX(i2);
    }

    public void t(byte[] bArr) throws IOException {
        c(bArr, 0, bArr.length);
    }

    public void u(int i, int i2) throws IOException {
        x(i, 0);
        gY(i2);
    }

    public void x(int i, int i2) throws IOException {
        hd(qz.y(i, i2));
    }
}
