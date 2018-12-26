package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

@ey
public final class ck {

    public static final class a implements ConnectionCallbacks, OnConnectionFailedListener {
        private final Object mH;
        private final b qe;
        private final cl qf;

        public a(Context context, b bVar) {
            this(context, bVar, false);
        }

        a(Context context, b bVar, boolean z) {
            this.mH = new Object();
            this.qe = bVar;
            this.qf = new cl(context, this, this, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            if (!z) {
                this.qf.connect();
            }
        }

        public void onConnected(Bundle connectionHint) {
            Bundle bN;
            Bundle by = bn.by();
            synchronized (this.mH) {
                try {
                    cm bM = this.qf.bM();
                    bN = bM != null ? bM.bN() : by;
                    if (this.qf.isConnected() || this.qf.isConnecting()) {
                        this.qf.disconnect();
                    }
                } catch (Throwable e) {
                    gr.d("Error when get Gservice values", e);
                    if (this.qf.isConnected() || this.qf.isConnecting()) {
                        this.qf.disconnect();
                        bN = by;
                    }
                    bN = by;
                } catch (Throwable e2) {
                    gr.d("Error when get Gservice values", e2);
                    if (this.qf.isConnected() || this.qf.isConnecting()) {
                        this.qf.disconnect();
                        bN = by;
                    }
                    bN = by;
                } catch (Throwable th) {
                    if (this.qf.isConnected() || this.qf.isConnecting()) {
                        this.qf.disconnect();
                    }
                }
            }
            this.qe.a(bN);
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.qe.a(bn.by());
        }

        public void onConnectionSuspended(int cause) {
            gr.S("Disconnected from remote ad request service.");
        }
    }

    public interface b {
        void a(Bundle bundle);
    }

    public static void a(Context context, b bVar) {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) != 0) {
            bVar.a(bn.by());
        } else {
            a aVar = new a(context, bVar);
        }
    }
}
