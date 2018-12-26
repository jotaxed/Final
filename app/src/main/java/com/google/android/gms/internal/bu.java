package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.internal.bx.a;

@ey
public class bu extends a implements bv.a {
    private final Object mH = new Object();
    private final String pB;
    private final Drawable pC;
    private final String pD;
    private final String pF;
    private bv pJ;
    private final Drawable pK;
    private final String pL;

    public bu(String str, Drawable drawable, String str2, Drawable drawable2, String str3, String str4) {
        this.pB = str;
        this.pC = drawable;
        this.pD = str2;
        this.pK = drawable2;
        this.pF = str3;
        this.pL = str4;
    }

    public void a(bv bvVar) {
        synchronized (this.mH) {
            this.pJ = bvVar;
        }
    }

    public void aw() {
        synchronized (this.mH) {
            if (this.pJ == null) {
                gr.T("Attempt to record impression before content ad initialized.");
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

    public String bE() {
        return this.pF;
    }

    public d bI() {
        return e.k(this.pK);
    }

    public String bJ() {
        return this.pL;
    }

    public String getBody() {
        return this.pD;
    }

    public void j(int i) {
        synchronized (this.mH) {
            if (this.pJ == null) {
                gr.T("Attempt to perform click before content ad initialized.");
                return;
            }
            this.pJ.b("1", i);
        }
    }
}
