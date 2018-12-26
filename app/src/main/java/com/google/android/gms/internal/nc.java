package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.jl.e;
import com.google.android.gms.internal.ni.a;

public class nc extends jl<ni> {
    protected final np<ni> Ee = new np<ni>(this) {
        final /* synthetic */ nc agE;

        {
            this.agE = r1;
        }

        public void dS() {
            this.agE.dS();
        }

        public /* synthetic */ IInterface hw() throws DeadObjectException {
            return nh();
        }

        public ni nh() throws DeadObjectException {
            return (ni) this.agE.hw();
        }
    };
    private final String agD;

    public nc(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.agD = str;
    }

    protected void a(jt jtVar, e eVar) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.agD);
        jtVar.e(eVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), bundle);
    }

    protected ni aM(IBinder iBinder) {
        return a.aO(iBinder);
    }

    protected String bK() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected String bL() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    protected /* synthetic */ IInterface l(IBinder iBinder) {
        return aM(iBinder);
    }
}
