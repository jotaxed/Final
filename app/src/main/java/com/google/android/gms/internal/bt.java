package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.internal.bw.a;

@ey
public class bt extends a implements bv.a {
    private final Object mH = new Object();
    private final String pB;
    private final Drawable pC;
    private final String pD;
    private final Drawable pE;
    private final String pF;
    private final double pG;
    private final String pH;
    private final String pI;
    private bv pJ;

    public bt(String str, Drawable drawable, String str2, Drawable drawable2, String str3, double d, String str4, String str5) {
        this.pB = str;
        this.pC = drawable;
        this.pD = str2;
        this.pE = drawable2;
        this.pF = str3;
        this.pG = d;
        this.pH = str4;
        this.pI = str5;
    }

    public void a(bv bvVar) {
        synchronized (this.mH) {
            this.pJ = bvVar;
        }
    }

    public void aw() {
        synchronized (this.mH) {
            if (this.pJ == null) {
                gr.T("Attempt to record impression before app install ad initialized.");
                return;
            }
            this.pJ.aw();
        }
    }

    public String bB() {
        return this.pB;
    }

    public d bC() {
        return e.k(this.pC);
    }

    public d bD() {
        return e.k(this.pE);
    }

    public String bE() {
        return this.pF;
    }

    public double bF() {
        return this.pG;
    }

    public String bG() {
        return this.pH;
    }

    public String bH() {
        return this.pI;
    }

    public String getBody() {
        return this.pD;
    }

    public void j(int i) {
        synchronized (this.mH) {
            if (this.pJ == null) {
                gr.T("Attempt to perform click before app install ad initialized.");
                return;
            }
            this.pJ.b("2", i);
        }
    }
}
