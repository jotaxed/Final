package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Locale;

public final class in {
    public static <T> boolean a(T t, T t2) {
        return (t == null && t2 == null) || !(t == null || t2 == null || !t.equals(t2));
    }

    public static void aF(String str) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Namespace cannot be null or empty");
        } else if (str.length() > 128) {
            throw new IllegalArgumentException("Invalid namespace length");
        } else if (!str.startsWith("urn:x-cast:")) {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\"");
        } else if (str.length() == "urn:x-cast:".length()) {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\" and have non-empty suffix");
        }
    }

    public static String aG(String str) {
        return "urn:x-cast:" + str;
    }

    public static long b(double d) {
        return (long) (1000.0d * d);
    }

    public static String b(Locale locale) {
        StringBuilder stringBuilder = new StringBuilder(20);
        stringBuilder.append(locale.getLanguage());
        Object country = locale.getCountry();
        if (!TextUtils.isEmpty(country)) {
            stringBuilder.append('-').append(country);
        }
        country = locale.getVariant();
        if (!TextUtils.isEmpty(country)) {
            stringBuilder.append('-').append(country);
        }
        return stringBuilder.toString();
    }

    public static double o(long j) {
        return ((double) j) / 1000.0d;
    }
}
