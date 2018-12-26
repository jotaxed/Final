package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.jl.e;
import com.google.android.gms.internal.ok.a;

public class om extends jl<ok> {
    public om(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, (String[]) null);
    }

    protected void a(jt jtVar, e eVar) throws RemoteException {
        jtVar.a((js) eVar, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), new Bundle());
    }

    public ok bH(IBinder iBinder) {
        return a.bG(iBinder);
    }

    protected String bK() {
        return "com.google.android.gms.panorama.service.START";
    }

    protected String bL() {
        return "com.google.android.gms.panorama.internal.IPanoramaService";
    }

    public /* synthetic */ IInterface l(IBinder iBinder) {
        return bH(iBinder);
    }
}
