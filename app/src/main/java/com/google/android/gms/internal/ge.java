package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import java.math.BigInteger;
import java.util.Locale;

@ey
public final class ge {
    private static final Object ut = new Object();
    private static String wt;

    public static String a(Context context, String str, String str2) {
        String str3;
        synchronized (ut) {
            if (wt == null && !TextUtils.isEmpty(str)) {
                b(context, str, str2);
            }
            str3 = wt;
        }
        return str3;
    }

    private static void b(Context context, String str, String str2) {
        try {
            ClassLoader classLoader = context.createPackageContext(str2, 3).getClassLoader();
            Class cls = Class.forName("com.google.ads.mediation.MediationAdapter", false, classLoader);
            BigInteger bigInteger = new BigInteger(new byte[1]);
            String[] split = str.split(",");
            BigInteger bigInteger2 = bigInteger;
            for (int i = 0; i < split.length; i++) {
                if (gi.a(classLoader, cls, split[i])) {
                    bigInteger2 = bigInteger2.setBit(i);
                }
            }
            wt = String.format(Locale.US, "%X", new Object[]{bigInteger2});
        } catch (Throwable th) {
            wt = "err";
        }
    }

    public static String dr() {
        String str;
        synchronized (ut) {
            str = wt;
        }
        return str;
    }
}
