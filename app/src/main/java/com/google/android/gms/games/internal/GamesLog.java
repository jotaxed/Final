package com.google.android.gms.games.internal;

import com.google.android.gms.internal.jp;

public final class GamesLog {
    private static final jp Qp = new jp("Games");

    private GamesLog() {
    }

    public static void a(String str, String str2, Throwable th) {
        Qp.a(str, str2, th);
    }

    public static void b(String str, String str2, Throwable th) {
        Qp.b(str, str2, th);
    }

    public static void c(String str, String str2, Throwable th) {
        Qp.c(str, str2, th);
    }

    public static void n(String str, String str2) {
        Qp.n(str, str2);
    }

    public static void o(String str, String str2) {
        Qp.o(str, str2);
    }

    public static void p(String str, String str2) {
        Qp.p(str, str2);
    }
}
