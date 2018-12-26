package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.fl.a;
import com.google.android.gms.internal.jl.e;

@ey
public class fg extends jl<fl> {
    final int qg;

    public fg(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, int i) {
        super(context, context.getMainLooper(), connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.qg = i;
    }

    protected fl B(IBinder iBinder) {
        return a.C(iBinder);
    }

    protected void a(jt jtVar, e eVar) throws RemoteException {
        jtVar.g(eVar, this.qg, getContext().getPackageName(), new Bundle());
    }

    protected String bK() {
        return "com.google.android.gms.ads.service.START";
    }

    protected String bL() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public fl cL() throws DeadObjectException {
        return (fl) super.hw();
    }

    protected /* synthetic */ IInterface l(IBinder iBinder) {
        return B(iBinder);
    }
}
