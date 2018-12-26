package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract class ji implements SafeParcelable {
    private static ClassLoader MA = null;
    private static Integer MB = null;
    private static final Object Mz = new Object();
    private boolean MC = false;

    private static boolean a(Class<?> cls) {
        boolean z = false;
        try {
            z = SafeParcelable.NULL.equals(cls.getField("NULL").get(null));
        } catch (NoSuchFieldException e) {
        } catch (IllegalAccessException e2) {
        }
        return z;
    }

    protected static boolean aW(String str) {
        ClassLoader hs = hs();
        if (hs == null) {
            return true;
        }
        try {
            return a(hs.loadClass(str));
        } catch (Exception e) {
            return false;
        }
    }

    protected static ClassLoader hs() {
        ClassLoader classLoader;
        synchronized (Mz) {
            classLoader = MA;
        }
        return classLoader;
    }

    protected static Integer ht() {
        Integer num;
        synchronized (Mz) {
            num = MB;
        }
        return num;
    }

    protected boolean hu() {
        return this.MC;
    }
}
