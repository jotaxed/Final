package com.google.android.gms.internal;

import android.os.SystemClock;

public final class lf implements ld {
    private static lf Of;

    public static synchronized ld if() {
        ld ldVar;
        synchronized (lf.class) {
            if (Of == null) {
                Of = new lf();
            }
            ldVar = Of;
        }
        return ldVar;
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }
}
