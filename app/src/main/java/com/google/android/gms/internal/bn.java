package com.google.android.gms.internal;

import android.os.Bundle;

@ey
public final class bn {
    public static iy<String> ph = a("gads:sdk_core_location", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html");
    public static iy<String> pi = a("gads:sdk_core_experiment_id", (String) null);
    public static iy<Boolean> pj = c("gads:sdk_crash_report_enabled", false);
    public static iy<Boolean> pk = c("gads:sdk_crash_report_full_stacktrace", false);
    public static iy<Boolean> pl = c("gads:block_autoclicks", false);
    public static iy<String> pm = a("gads:block_autoclicks_experiment_id", (String) null);
    public static iy<Boolean> pn = c("gads:spam_app_context:enabled", false);
    public static iy<String> po = a("gads:spam_app_context:experiment_id", (String) null);
    public static iy<Boolean> pp = c("gads:enable_content_fetching", false);
    public static iy<Integer> pq = a("gads:content_length_weight", 1);
    public static iy<Integer> pr = a("gads:content_age_weight", 1);
    public static iy<Integer> ps = a("gads:min_content_len", 11);
    public static iy<Integer> pt = a("gads:fingerprint_number", 10);
    public static iy<Integer> pu = a("gads:sleep_sec", 10);
    private static final Bundle pv = new Bundle();
    private static boolean pw;

    static {
        pw = false;
        pw = true;
    }

    private static iy<Integer> a(String str, int i) {
        pv.putInt(str, i);
        return iy.a(str, Integer.valueOf(i));
    }

    private static iy<String> a(String str, String str2) {
        pv.putString(str, str2);
        return iy.l(str, str2);
    }

    public static Bundle by() {
        return pv;
    }

    private static iy<Boolean> c(String str, boolean z) {
        pv.putBoolean(str, z);
        return iy.h(str, z);
    }
}
