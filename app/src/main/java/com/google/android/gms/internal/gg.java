package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

@ey
public final class gg {
    public static void a(Context context, boolean z) {
        Editor edit = n(context).edit();
        edit.putBoolean("use_https", z);
        edit.commit();
    }

    private static SharedPreferences n(Context context) {
        return context.getSharedPreferences("admob", 0);
    }

    public static boolean o(Context context) {
        return n(context).getBoolean("use_https", true);
    }
}
