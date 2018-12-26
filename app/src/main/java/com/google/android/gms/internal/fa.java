package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class fa extends gf implements com.google.android.gms.internal.fe.a {
    private final Context mContext;
    private final Object mH = new Object();
    private cr qi;
    private final com.google.android.gms.internal.ez.a ti;
    private final Object tj = new Object();
    private final com.google.android.gms.internal.fh.a tk;
    private final k tl;
    private gf tm;
    private fj tn;

    @ey
    private static final class a extends Exception {
        private final int tq;

        public a(String str, int i) {
            super(str);
            this.tq = i;
        }

        public int getErrorCode() {
            return this.tq;
        }
    }

    public fa(Context context, com.google.android.gms.internal.fh.a aVar, k kVar, com.google.android.gms.internal.ez.a aVar2) {
        this.ti = aVar2;
        this.mContext = context;
        this.tk = aVar;
        this.tl = kVar;
    }

    private ay a(fh fhVar) throws a {
        if (this.tn.tZ == null) {
            throw new a("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.tn.tZ.split("x");
        if (split.length != 2) {
            throw new a("Could not parse the ad size from the ad response: " + this.tn.tZ, 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (ay ayVar : fhVar.lS.or) {
                float f = this.mContext.getResources().getDisplayMetrics().density;
                int i = ayVar.width == -1 ? (int) (((float) ayVar.widthPixels) / f) : ayVar.width;
                int i2 = ayVar.height == -2 ? (int) (((float) ayVar.heightPixels) / f) : ayVar.height;
                if (parseInt == i && parseInt2 == i2) {
                    return new ay(ayVar, fhVar.lS.or);
                }
            }
            throw new a("The ad size from the ad response was not one of the requested sizes: " + this.tn.tZ, 0);
        } catch (NumberFormatException e) {
            throw new a("Could not parse the ad size from the ad response: " + this.tn.tZ, 0);
        }
    }

    private boolean c(long j) throws a {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.mH.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            throw new a("Ad request cancelled.", -1);
        }
    }

    private void cE() throws a {
        if (this.tn.errorCode != -3) {
            if (TextUtils.isEmpty(this.tn.tU)) {
                throw new a("No fill from ad server.", 3);
            }
            ga.a(this.mContext, this.tn.tT);
            if (this.tn.tW) {
                try {
                    this.qi = new cr(this.tn.tU);
                } catch (JSONException e) {
                    throw new a("Could not parse mediation config: " + this.tn.tU, 0);
                }
            }
        }
    }

    private void e(long j) throws a {
        while (c(j)) {
            if (this.tn != null) {
                synchronized (this.tj) {
                    this.tm = null;
                }
                if (this.tn.errorCode != -2 && this.tn.errorCode != -3) {
                    throw new a("There was a problem getting an ad response. ErrorCode: " + this.tn.errorCode, this.tn.errorCode);
                }
                return;
            }
        }
        throw new a("Timed out waiting for ad response.", 2);
    }

    private void t(boolean z) {
        ga.dc().x(z);
        an l = ga.dc().l(this.mContext);
        if (l != null && !l.isAlive()) {
            gr.S("start fetching content...");
            l.ba();
        }
    }

    public void a(fj fjVar) {
        synchronized (this.mH) {
            gr.S("Received ad response.");
            this.tn = fjVar;
            this.mH.notify();
        }
    }

    public void cx() {
        long elapsedRealtime;
        ay a;
        a e;
        JSONObject jSONObject;
        final com.google.android.gms.internal.fy.a aVar;
        synchronized (this.mH) {
            gr.S("AdLoaderBackgroundTask started.");
            fh fhVar = new fh(this.tk, this.tl.C().a(this.mContext));
            int i = -2;
            long j = -1;
            try {
                elapsedRealtime = SystemClock.elapsedRealtime();
                gf a2 = fe.a(this.mContext, fhVar, this);
                synchronized (this.tj) {
                    this.tm = a2;
                    if (this.tm == null) {
                        throw new a("Could not start the ad request service.", 0);
                    }
                }
                e(elapsedRealtime);
                j = SystemClock.elapsedRealtime();
                cE();
                a = fhVar.lS.or != null ? a(fhVar) : null;
                try {
                    t(this.tn.uh);
                    elapsedRealtime = j;
                } catch (a e2) {
                    e = e2;
                    i = e.getErrorCode();
                    if (i == 3 || i == -1) {
                        gr.U(e.getMessage());
                    } else {
                        gr.W(e.getMessage());
                    }
                    if (this.tn == null) {
                        this.tn = new fj(i);
                    } else {
                        this.tn = new fj(i, this.tn.qA);
                    }
                    gq.wR.post(new Runnable(this) {
                        final /* synthetic */ fa to;

                        {
                            this.to = r1;
                        }

                        public void run() {
                            this.to.onStop();
                        }
                    });
                    elapsedRealtime = j;
                    if (!TextUtils.isEmpty(this.tn.ue)) {
                        try {
                            jSONObject = new JSONObject(this.tn.ue);
                        } catch (Throwable e3) {
                            gr.b("Error parsing the JSON for Active View.", e3);
                        }
                        aVar = new com.google.android.gms.internal.fy.a(fhVar, this.tn, this.qi, a, i, elapsedRealtime, this.tn.ua, jSONObject);
                        gq.wR.post(new Runnable(this) {
                            final /* synthetic */ fa to;

                            public void run() {
                                synchronized (this.to.mH) {
                                    this.to.ti.a(aVar);
                                }
                            }
                        });
                    }
                    jSONObject = null;
                    aVar = new com.google.android.gms.internal.fy.a(fhVar, this.tn, this.qi, a, i, elapsedRealtime, this.tn.ua, jSONObject);
                    gq.wR.post(/* anonymous class already generated */);
                }
            } catch (a e4) {
                e = e4;
                a = null;
            }
            if (TextUtils.isEmpty(this.tn.ue)) {
                jSONObject = new JSONObject(this.tn.ue);
                aVar = new com.google.android.gms.internal.fy.a(fhVar, this.tn, this.qi, a, i, elapsedRealtime, this.tn.ua, jSONObject);
                gq.wR.post(/* anonymous class already generated */);
            }
            jSONObject = null;
            aVar = new com.google.android.gms.internal.fy.a(fhVar, this.tn, this.qi, a, i, elapsedRealtime, this.tn.ua, jSONObject);
            gq.wR.post(/* anonymous class already generated */);
        }
    }

    public void onStop() {
        synchronized (this.tj) {
            if (this.tm != null) {
                this.tm.cancel();
            }
        }
    }
}
