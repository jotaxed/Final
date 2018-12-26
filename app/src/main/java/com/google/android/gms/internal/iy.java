package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;

public abstract class iy<T> {
    private static a KO = null;
    private static final Object mH = new Object();
    protected final String KP;
    protected final T KQ;
    private T KR = null;

    private interface a {
    }

    private static class b implements a {
        private final ContentResolver mContentResolver;

        public b(ContentResolver contentResolver) {
            this.mContentResolver = contentResolver;
        }
    }

    protected iy(String str, T t) {
        this.KP = str;
        this.KQ = t;
    }

    public static void H(Context context) {
        synchronized (mH) {
            if (KO == null) {
                KO = new b(context.getContentResolver());
            }
        }
    }

    public static iy<Integer> a(String str, Integer num) {
        return new iy<Integer>(str, num) {
        };
    }

    public static iy<Boolean> h(String str, boolean z) {
        return new iy<Boolean>(str, Boolean.valueOf(z)) {
        };
    }

    public static iy<String> l(String str, String str2) {
        return new iy<String>(str, str2) {
        };
    }

    public String getKey() {
        return this.KP;
    }
}
