package com.google.android.gms.internal;

import android.support.v4.view.MotionEventCompat;
import java.security.MessageDigest;

public class ar extends ao {
    private MessageDigest nZ;

    byte[] a(String[] strArr) {
        byte[] bArr = new byte[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = e(aq.o(strArr[i]));
        }
        return bArr;
    }

    byte e(int i) {
        return (byte) ((((i & MotionEventCompat.ACTION_MASK) ^ ((MotionEventCompat.ACTION_POINTER_INDEX_MASK & i) >> 8)) ^ ((16711680 & i) >> 16)) ^ ((-16777216 & i) >> 24));
    }

    public byte[] l(String str) {
        byte[] a = a(str.split(" "));
        this.nZ = bf();
        synchronized (this.mH) {
            if (this.nZ == null) {
                a = new byte[0];
            } else {
                this.nZ.reset();
                this.nZ.update(a);
                Object digest = this.nZ.digest();
                int i = 4;
                if (digest.length <= 4) {
                    i = digest.length;
                }
                a = new byte[i];
                System.arraycopy(digest, 0, a, 0, a.length);
            }
        }
        return a;
    }
}
