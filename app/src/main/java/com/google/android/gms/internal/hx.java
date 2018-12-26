package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.hu.a;
import com.google.android.gms.internal.jl.e;

public class hx extends jl<hu> {
    public hx(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
    }

    protected hu G(IBinder iBinder) {
        return a.E(iBinder);
    }

    protected void a(jt jtVar, e eVar) throws RemoteException {
        jtVar.b(eVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName());
    }

    protected String bK() {
        return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
    }

    protected String bL() {
        return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
    }

    public hu fH() throws DeadObjectException {
        return (hu) hw();
    }

    protected /* synthetic */ IInterface l(IBinder iBinder) {
        return G(iBinder);
    }
}
