package com.google.android.gms.internal;

import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;

@ey
public class v {
    private a mk;
    private boolean ml;
    private boolean mm;

    public interface a {
        void e(String str);
    }

    @ey
    public static class b implements a {
        private final com.google.android.gms.internal.fy.a mn;
        private final gu mo;

        public b(com.google.android.gms.internal.fy.a aVar, gu guVar) {
            this.mn = aVar;
            this.mo = guVar;
        }

        public void e(String str) {
            gr.S("An auto-clicking creative is blocked");
            Builder builder = new Builder();
            builder.scheme("https");
            builder.path("//pagead2.googlesyndication.com/pagead/gen_204");
            builder.appendQueryParameter("id", "gmob-apps-blocked-navigation");
            if (!TextUtils.isEmpty(str)) {
                builder.appendQueryParameter("navigationURL", str);
            }
            if (!(this.mn == null || this.mn.vK == null || TextUtils.isEmpty(this.mn.vK.ub))) {
                builder.appendQueryParameter("debugDialog", this.mn.vK.ub);
            }
            gi.c(this.mo.getContext(), this.mo.dG().wS, builder.toString());
        }
    }

    public v() {
        boolean z = false;
        Bundle bN = ga.bN();
        if (bN != null && bN.getBoolean("gads:block_autoclicks", false)) {
            z = true;
        }
        this.mm = z;
    }

    public v(boolean z) {
        this.mm = z;
    }

    public void a(a aVar) {
        this.mk = aVar;
    }

    public void av() {
        this.ml = true;
    }

    public boolean az() {
        return !this.mm || this.ml;
    }

    public void d(String str) {
        gr.S("Action was blocked because no click was detected.");
        if (this.mk != null) {
            this.mk.e(str);
        }
    }
}
