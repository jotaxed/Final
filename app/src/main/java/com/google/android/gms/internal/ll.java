package com.google.android.gms.internal;

import android.os.Build.VERSION;

public final class ll {
    private static boolean aW(int i) {
        return VERSION.SDK_INT >= i;
    }

    public static boolean ig() {
        return aW(11);
    }

    public static boolean ih() {
        return aW(12);
    }

    public static boolean ii() {
        return aW(13);
    }

    public static boolean ij() {
        return aW(14);
    }

    public static boolean ik() {
        return aW(16);
    }

    public static boolean il() {
        return aW(17);
    }

    public static boolean im() {
        return aW(19);
    }

    @Deprecated
    public static boolean in() {
        return io();
    }

    public static boolean io() {
        return aW(21);
    }
}
