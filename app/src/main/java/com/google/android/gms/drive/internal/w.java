package com.google.android.gms.drive.internal;

import android.content.Context;
import com.google.android.gms.internal.jp;

public final class w {
    private static final jp Qp = new jp("GmsDrive");

    public static void a(String str, Throwable th, String str2) {
        Qp.c(str, str2, th);
    }

    public static void e(Context context, String str, String str2) {
        Qp.a(context, str, str2, new Throwable());
    }

    public static void m(String str, String str2) {
        Qp.m(str, str2);
    }

    public static void o(String str, String str2) {
        Qp.o(str, str2);
    }

    public static void p(String str, String str2) {
        Qp.p(str, str2);
    }
}
