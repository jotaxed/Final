package com.google.android.gms.internal;

import android.support.v4.view.MotionEventCompat;

public class qn {
    private final byte[] ayJ = new byte[256];
    private int ayK;
    private int ayL;

    public qn(byte[] bArr) {
        int i;
        for (i = 0; i < 256; i++) {
            this.ayJ[i] = (byte) i;
        }
        i = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            i = ((i + this.ayJ[i2]) + bArr[i2 % bArr.length]) & MotionEventCompat.ACTION_MASK;
            byte b = this.ayJ[i2];
            this.ayJ[i2] = this.ayJ[i];
            this.ayJ[i] = b;
        }
        this.ayK = 0;
        this.ayL = 0;
    }

    public void o(byte[] bArr) {
        int i = this.ayK;
        int i2 = this.ayL;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & MotionEventCompat.ACTION_MASK;
            i2 = (i2 + this.ayJ[i]) & MotionEventCompat.ACTION_MASK;
            byte b = this.ayJ[i];
            this.ayJ[i] = this.ayJ[i2];
            this.ayJ[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.ayJ[(this.ayJ[i] + this.ayJ[i2]) & MotionEventCompat.ACTION_MASK]);
        }
        this.ayK = i;
        this.ayL = i2;
    }
}
