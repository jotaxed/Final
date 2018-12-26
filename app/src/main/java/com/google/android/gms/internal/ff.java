package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

@ey
public abstract class ff extends gf {
    private final fh qh;
    private final com.google.android.gms.internal.fe.a tI;

    @ey
    public static final class a extends ff {
        private final Context mContext;

        public a(Context context, fh fhVar, com.google.android.gms.internal.fe.a aVar) {
            super(fhVar, aVar);
            this.mContext = context;
        }

        public void cJ() {
        }

        public fl cK() {
            Bundle bN = ga.bN();
            return fq.a(this.mContext, new bm(bN.getString("gads:sdk_core_location"), bN.getString("gads:sdk_core_experiment_id"), bN.getString("gads:block_autoclicks_experiment_id"), bN.getString("gads:spam_app_context:experiment_id")), new co(), new fx());
        }
    }

    @ey
    public static final class b extends ff implements ConnectionCallbacks, OnConnectionFailedListener {
        private final Object mH = new Object();
        private final com.google.android.gms.internal.fe.a tI;
        private final fg tJ;

        public b(Context context, fh fhVar, com.google.android.gms.internal.fe.a aVar) {
            super(fhVar, aVar);
            this.tI = aVar;
            this.tJ = new fg(context, this, this, fhVar.lO.wU);
            this.tJ.connect();
        }

        public void cJ() {
            synchronized (this.mH) {
                if (this.tJ.isConnected() || this.tJ.isConnecting()) {
                    this.tJ.disconnect();
                }
            }
        }

        public fl cK() {
            fl cL;
            synchronized (this.mH) {
                try {
                    cL = this.tJ.cL();
                } catch (IllegalStateException e) {
                    cL = null;
                    return cL;
                } catch (DeadObjectException e2) {
                    cL = null;
                    return cL;
                }
            }
            return cL;
        }

        public void onConnected(Bundle connectionHint) {
            start();
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.tI.a(new fj(0));
        }

        public void onConnectionSuspended(int cause) {
            gr.S("Disconnected from remote ad request service.");
        }
    }

    public ff(fh fhVar, com.google.android.gms.internal.fe.a aVar) {
        this.qh = fhVar;
        this.tI = aVar;
    }

    private static fj a(fl flVar, fh fhVar) {
        fj fjVar = null;
        try {
            fjVar = flVar.b(fhVar);
        } catch (Throwable e) {
            gr.d("Could not fetch ad response from ad request service.", e);
        } catch (Throwable e2) {
            gr.d("Could not fetch ad response from ad request service due to an Exception.", e2);
        } catch (Throwable e22) {
            gr.d("Could not fetch ad response from ad request service due to an Exception.", e22);
        } catch (Throwable e222) {
            ga.e(e222);
        }
        return fjVar;
    }

    public abstract void cJ();

    public abstract fl cK();

    public final void cx() {
        try {
            fj fjVar;
            fl cK = cK();
            if (cK == null) {
                fjVar = new fj(0);
            } else {
                fjVar = a(cK, this.qh);
                if (fjVar == null) {
                    fjVar = new fj(0);
                }
            }
            cJ();
            this.tI.a(fjVar);
        } catch (Throwable th) {
            cJ();
        }
    }

    public final void onStop() {
        cJ();
    }
}
