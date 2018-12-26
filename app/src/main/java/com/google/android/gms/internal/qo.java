package com.google.android.gms.internal;

import android.support.v4.view.MotionEventCompat;
import java.io.IOException;

public final class qo {
    private int ayM;
    private int ayN;
    private int ayO;
    private int ayP;
    private int ayQ;
    private int ayR = Integer.MAX_VALUE;
    private int ayS;
    private int ayT = 64;
    private int ayU = 67108864;
    private final byte[] buffer;

    private qo(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.ayM = i;
        this.ayN = i + i2;
        this.ayP = i;
    }

    public static long A(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public static qo a(byte[] bArr, int i, int i2) {
        return new qo(bArr, i, i2);
    }

    public static int gR(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static qo p(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    private void rK() {
        this.ayN += this.ayO;
        int i = this.ayN;
        if (i > this.ayR) {
            this.ayO = i - this.ayR;
            this.ayN -= this.ayO;
            return;
        }
        this.ayO = 0;
    }

    public void a(qw qwVar) throws IOException {
        int rG = rG();
        if (this.ayS >= this.ayT) {
            throw qv.rX();
        }
        rG = gS(rG);
        this.ayS++;
        qwVar.b(this);
        gP(0);
        this.ayS--;
        gT(rG);
    }

    public void a(qw qwVar, int i) throws IOException {
        if (this.ayS >= this.ayT) {
            throw qv.rX();
        }
        this.ayS++;
        qwVar.b(this);
        gP(qz.y(i, 4));
        this.ayS--;
    }

    public void gP(int i) throws qv {
        if (this.ayQ != i) {
            throw qv.rV();
        }
    }

    public boolean gQ(int i) throws IOException {
        switch (qz.hk(i)) {
            case 0:
                rC();
                return true;
            case 1:
                rJ();
                return true;
            case 2:
                gW(rG());
                return true;
            case 3:
                rA();
                gP(qz.y(qz.hl(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                rI();
                return true;
            default:
                throw qv.rW();
        }
    }

    public int gS(int i) throws qv {
        if (i < 0) {
            throw qv.rS();
        }
        int i2 = this.ayP + i;
        int i3 = this.ayR;
        if (i2 > i3) {
            throw qv.rR();
        }
        this.ayR = i2;
        rK();
        return i3;
    }

    public void gT(int i) {
        this.ayR = i;
        rK();
    }

    public void gU(int i) {
        if (i > this.ayP - this.ayM) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.ayP - this.ayM));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.ayP = this.ayM + i;
        }
    }

    public byte[] gV(int i) throws IOException {
        if (i < 0) {
            throw qv.rS();
        } else if (this.ayP + i > this.ayR) {
            gW(this.ayR - this.ayP);
            throw qv.rR();
        } else if (i <= this.ayN - this.ayP) {
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.ayP, obj, 0, i);
            this.ayP += i;
            return obj;
        } else {
            throw qv.rR();
        }
    }

    public void gW(int i) throws IOException {
        if (i < 0) {
            throw qv.rS();
        } else if (this.ayP + i > this.ayR) {
            gW(this.ayR - this.ayP);
            throw qv.rR();
        } else if (i <= this.ayN - this.ayP) {
            this.ayP += i;
        } else {
            throw qv.rR();
        }
    }

    public int getPosition() {
        return this.ayP - this.ayM;
    }

    public void rA() throws IOException {
        int rz;
        do {
            rz = rz();
            if (rz == 0) {
                return;
            }
        } while (gQ(rz));
    }

    public long rB() throws IOException {
        return rH();
    }

    public int rC() throws IOException {
        return rG();
    }

    public boolean rD() throws IOException {
        return rG() != 0;
    }

    public int rE() throws IOException {
        return gR(rG());
    }

    public long rF() throws IOException {
        return A(rH());
    }

    public int rG() throws IOException {
        byte rN = rN();
        if (rN >= (byte) 0) {
            return rN;
        }
        int i = rN & 127;
        byte rN2 = rN();
        if (rN2 >= (byte) 0) {
            return i | (rN2 << 7);
        }
        i |= (rN2 & 127) << 7;
        rN2 = rN();
        if (rN2 >= (byte) 0) {
            return i | (rN2 << 14);
        }
        i |= (rN2 & 127) << 14;
        rN2 = rN();
        if (rN2 >= (byte) 0) {
            return i | (rN2 << 21);
        }
        i |= (rN2 & 127) << 21;
        rN2 = rN();
        i |= rN2 << 28;
        if (rN2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (rN() >= (byte) 0) {
                return i;
            }
        }
        throw qv.rT();
    }

    public long rH() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte rN = rN();
            j |= ((long) (rN & 127)) << i;
            if ((rN & 128) == 0) {
                return j;
            }
        }
        throw qv.rT();
    }

    public int rI() throws IOException {
        return (((rN() & MotionEventCompat.ACTION_MASK) | ((rN() & MotionEventCompat.ACTION_MASK) << 8)) | ((rN() & MotionEventCompat.ACTION_MASK) << 16)) | ((rN() & MotionEventCompat.ACTION_MASK) << 24);
    }

    public long rJ() throws IOException {
        byte rN = rN();
        byte rN2 = rN();
        return ((((((((((long) rN2) & 255) << 8) | (((long) rN) & 255)) | ((((long) rN()) & 255) << 16)) | ((((long) rN()) & 255) << 24)) | ((((long) rN()) & 255) << 32)) | ((((long) rN()) & 255) << 40)) | ((((long) rN()) & 255) << 48)) | ((((long) rN()) & 255) << 56);
    }

    public int rL() {
        if (this.ayR == Integer.MAX_VALUE) {
            return -1;
        }
        return this.ayR - this.ayP;
    }

    public boolean rM() {
        return this.ayP == this.ayN;
    }

    public byte rN() throws IOException {
        if (this.ayP == this.ayN) {
            throw qv.rR();
        }
        byte[] bArr = this.buffer;
        int i = this.ayP;
        this.ayP = i + 1;
        return bArr[i];
    }

    public byte[] readBytes() throws IOException {
        int rG = rG();
        if (rG > this.ayN - this.ayP || rG <= 0) {
            return gV(rG);
        }
        Object obj = new byte[rG];
        System.arraycopy(this.buffer, this.ayP, obj, 0, rG);
        this.ayP = rG + this.ayP;
        return obj;
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(rJ());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(rI());
    }

    public String readString() throws IOException {
        int rG = rG();
        if (rG > this.ayN - this.ayP || rG <= 0) {
            return new String(gV(rG), "UTF-8");
        }
        String str = new String(this.buffer, this.ayP, rG, "UTF-8");
        this.ayP = rG + this.ayP;
        return str;
    }

    public int rz() throws IOException {
        if (rM()) {
            this.ayQ = 0;
            return 0;
        }
        this.ayQ = rG();
        if (this.ayQ != 0) {
            return this.ayQ;
        }
        throw qv.rU();
    }

    public byte[] s(int i, int i2) {
        if (i2 == 0) {
            return qz.azq;
        }
        Object obj = new byte[i2];
        System.arraycopy(this.buffer, this.ayM + i, obj, 0, i2);
        return obj;
    }
}
