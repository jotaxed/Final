package com.google.android.gms.internal;

import java.io.IOException;

public final class qz {
    public static final int[] azj = new int[0];
    public static final long[] azk = new long[0];
    public static final float[] azl = new float[0];
    public static final double[] azm = new double[0];
    public static final boolean[] azn = new boolean[0];
    public static final String[] azo = new String[0];
    public static final byte[][] azp = new byte[0][];
    public static final byte[] azq = new byte[0];

    public static final int b(qo qoVar, int i) throws IOException {
        int i2 = 1;
        int position = qoVar.getPosition();
        qoVar.gQ(i);
        while (qoVar.rz() == i) {
            qoVar.gQ(i);
            i2++;
        }
        qoVar.gU(position);
        return i2;
    }

    static int hk(int i) {
        return i & 7;
    }

    public static int hl(int i) {
        return i >>> 3;
    }

    static int y(int i, int i2) {
        return (i << 3) | i2;
    }
}
