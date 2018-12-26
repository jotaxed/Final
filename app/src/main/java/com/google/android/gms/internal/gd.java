package com.google.android.gms.internal;

import android.os.Bundle;

@ey
public class gd {
    private final Object mH;
    private final ga vL;
    private final String vO;
    private int wr;
    private int ws;

    gd(ga gaVar, String str) {
        this.mH = new Object();
        this.vL = gaVar;
        this.vO = str;
    }

    public gd(String str) {
        this(ga.dc(), str);
    }

    public void d(int i, int i2) {
        synchronized (this.mH) {
            this.wr = i;
            this.ws = i2;
            this.vL.a(this.vO, this);
        }
    }

    public Bundle toBundle() {
        Bundle bundle;
        synchronized (this.mH) {
            bundle = new Bundle();
            bundle.putInt("pmnli", this.wr);
            bundle.putInt("pmnll", this.ws);
        }
        return bundle;
    }
}
