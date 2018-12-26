package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.op.a;

public class ou implements ConnectionCallbacks, OnConnectionFailedListener {
    private ox amU = null;
    private final a ane;
    private boolean anf = true;

    public ou(a aVar) {
        this.ane = aVar;
    }

    public void T(boolean z) {
        this.anf = z;
    }

    public void a(ox oxVar) {
        this.amU = oxVar;
    }

    public void onConnected(Bundle connectionHint) {
        this.amU.U(false);
        if (this.anf && this.ane != null) {
            this.ane.on();
        }
        this.anf = false;
    }

    public void onConnectionFailed(ConnectionResult result) {
        this.amU.U(true);
        if (this.anf && this.ane != null) {
            if (result.hasResolution()) {
                this.ane.d(result.getResolution());
            } else {
                this.ane.oo();
            }
        }
        this.anf = false;
    }

    public void onDisconnected() {
        this.amU.U(true);
    }
}
