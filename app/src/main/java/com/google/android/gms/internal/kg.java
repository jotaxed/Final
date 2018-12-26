package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.jl.e;
import com.google.android.gms.internal.ki.a;

public class kg extends jl<ki> {
    public kg(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String... strArr) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
    }

    protected ki T(IBinder iBinder) {
        return a.V(iBinder);
    }

    protected void a(jt jtVar, e eVar) throws RemoteException {
        jtVar.j(eVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName());
    }

    public String bK() {
        return "com.google.android.gms.common.service.START";
    }

    protected String bL() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }

    protected /* synthetic */ IInterface l(IBinder iBinder) {
        return T(iBinder);
    }
}
