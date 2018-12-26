package com.google.android.gms.internal;

import android.content.Context;
import android.util.Log;

public final class jp {
    private final String Nq;

    public jp(String str) {
        this.Nq = (String) jx.i(str);
    }

    public void a(Context context, String str, String str2, Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < stackTrace.length && i < 2) {
            stringBuilder.append(stackTrace[i].toString());
            stringBuilder.append("\n");
            i++;
        }
        oo ooVar = new oo(context, 10);
        ooVar.a("GMS_WTF", null, "GMS_WTF", stringBuilder.toString());
        ooVar.send();
        if (aF(7)) {
            Log.e(str, str2, th);
            Log.wtf(str, str2, th);
        }
    }

    public void a(String str, String str2, Throwable th) {
        if (aF(4)) {
            Log.i(str, str2, th);
        }
    }

    public boolean aF(int i) {
        return Log.isLoggable(this.Nq, i);
    }

    public void b(String str, String str2, Throwable th) {
        if (aF(5)) {
            Log.w(str, str2, th);
        }
    }

    public void c(String str, String str2, Throwable th) {
        if (aF(6)) {
            Log.e(str, str2, th);
        }
    }

    public void m(String str, String str2) {
        if (aF(3)) {
            Log.d(str, str2);
        }
    }

    public void n(String str, String str2) {
        if (aF(2)) {
            Log.v(str, str2);
        }
    }

    public void o(String str, String str2) {
        if (aF(5)) {
            Log.w(str, str2);
        }
    }

    public void p(String str, String str2) {
        if (aF(6)) {
            Log.e(str, str2);
        }
    }
}
