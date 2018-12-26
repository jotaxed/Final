package com.google.android.gms.internal;

import android.content.Intent;

@ey
public class ek {
    private final String oK;

    public ek(String str) {
        this.oK = str;
    }

    public boolean a(String str, int i, Intent intent) {
        if (str == null || intent == null) {
            return false;
        }
        String e = ei.e(intent);
        String f = ei.f(intent);
        if (e == null || f == null) {
            return false;
        }
        if (!str.equals(ei.D(e))) {
            gr.W("Developer payload not match.");
            return false;
        } else if (this.oK == null || el.b(this.oK, e, f)) {
            return true;
        } else {
            gr.W("Fail to verify signature.");
            return false;
        }
    }

    public String cC() {
        return gi.dx();
    }
}
