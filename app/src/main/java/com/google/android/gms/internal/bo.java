package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.internal.bq.a;

@ey
public final class bo extends a {
    private final w px;
    private final String py;
    private final String pz;

    public bo(w wVar, String str, String str2) {
        this.px = wVar;
        this.py = str;
        this.pz = str2;
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.px.b((View) e.f(dVar));
        }
    }

    public void av() {
        this.px.av();
    }

    public void aw() {
        this.px.aw();
    }

    public String bA() {
        return this.pz;
    }

    public String bz() {
        return this.py;
    }
}
