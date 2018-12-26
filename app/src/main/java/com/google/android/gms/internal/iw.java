package com.google.android.gms.internal;

import android.os.SystemClock;
import org.json.JSONObject;

public final class iw {
    private static final is Hh = new is("RequestTracker");
    public static final Object Ip = new Object();
    private long Il;
    private long Im = -1;
    private long In = 0;
    private iv Io;

    public iw(long j) {
        this.Il = j;
    }

    private void gq() {
        this.Im = -1;
        this.Io = null;
        this.In = 0;
    }

    public void a(long j, iv ivVar) {
        synchronized (Ip) {
            iv ivVar2 = this.Io;
            long j2 = this.Im;
            this.Im = j;
            this.Io = ivVar;
            this.In = SystemClock.elapsedRealtime();
        }
        if (ivVar2 != null) {
            ivVar2.n(j2);
        }
    }

    public boolean b(long j, int i, JSONObject jSONObject) {
        boolean z = true;
        iv ivVar = null;
        synchronized (Ip) {
            if (this.Im == -1 || this.Im != j) {
                z = false;
            } else {
                Hh.b("request %d completed", Long.valueOf(this.Im));
                ivVar = this.Io;
                gq();
            }
        }
        if (ivVar != null) {
            ivVar.a(j, i, jSONObject);
        }
        return z;
    }

    public void clear() {
        synchronized (Ip) {
            if (this.Im != -1) {
                gq();
            }
        }
    }

    public boolean d(long j, int i) {
        return b(j, i, null);
    }

    public boolean e(long j, int i) {
        iv ivVar;
        boolean z = true;
        long j2 = 0;
        synchronized (Ip) {
            if (this.Im == -1 || j - this.In < this.Il) {
                z = false;
                ivVar = null;
            } else {
                Hh.b("request %d timed out", Long.valueOf(this.Im));
                j2 = this.Im;
                ivVar = this.Io;
                gq();
            }
        }
        if (ivVar != null) {
            ivVar.a(j2, i, null);
        }
        return z;
    }

    public boolean gr() {
        boolean z;
        synchronized (Ip) {
            z = this.Im != -1;
        }
        return z;
    }

    public boolean p(long j) {
        boolean z;
        synchronized (Ip) {
            z = this.Im != -1 && this.Im == j;
        }
        return z;
    }
}
