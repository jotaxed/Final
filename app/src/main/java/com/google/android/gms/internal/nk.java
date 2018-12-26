package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;

public class nk extends nc {
    private final nj agX;
    private final mz agY;
    private final ie agZ;

    private final class a extends b<com.google.android.gms.location.c.a> {
        private final int Iv;
        private final String[] aha;
        final /* synthetic */ nk ahb;

        public a(nk nkVar, com.google.android.gms.location.c.a aVar, int i, String[] strArr) {
            this.ahb = nkVar;
            super(nkVar, aVar);
            this.Iv = LocationStatusCodes.eC(i);
            this.aha = strArr;
        }

        protected void a(com.google.android.gms.location.c.a aVar) {
            if (aVar != null) {
                aVar.a(this.Iv, this.aha);
            }
        }

        protected /* synthetic */ void g(Object obj) {
            a((com.google.android.gms.location.c.a) obj);
        }

        protected void hx() {
        }
    }

    private static final class b extends com.google.android.gms.internal.nh.a {
        private com.google.android.gms.location.c.a ahc;
        private com.google.android.gms.location.c.b ahd;
        private nk ahe;

        public b(com.google.android.gms.location.c.a aVar, nk nkVar) {
            this.ahc = aVar;
            this.ahd = null;
            this.ahe = nkVar;
        }

        public b(com.google.android.gms.location.c.b bVar, nk nkVar) {
            this.ahd = bVar;
            this.ahc = null;
            this.ahe = nkVar;
        }

        public void a(int i, PendingIntent pendingIntent) {
            if (this.ahe == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
                return;
            }
            nk nkVar = this.ahe;
            nk nkVar2 = this.ahe;
            nkVar2.getClass();
            nkVar.a(new c(nkVar2, 1, this.ahd, i, pendingIntent));
            this.ahe = null;
            this.ahc = null;
            this.ahd = null;
        }

        public void a(int i, String[] strArr) throws RemoteException {
            if (this.ahe == null) {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
                return;
            }
            nk nkVar = this.ahe;
            nk nkVar2 = this.ahe;
            nkVar2.getClass();
            nkVar.a(new a(nkVar2, this.ahc, i, strArr));
            this.ahe = null;
            this.ahc = null;
            this.ahd = null;
        }

        public void b(int i, String[] strArr) {
            if (this.ahe == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
                return;
            }
            nk nkVar = this.ahe;
            nk nkVar2 = this.ahe;
            nkVar2.getClass();
            nkVar.a(new c(nkVar2, 2, this.ahd, i, strArr));
            this.ahe = null;
            this.ahc = null;
            this.ahd = null;
        }
    }

    private final class c extends b<com.google.android.gms.location.c.b> {
        private final int Iv;
        private final String[] aha;
        final /* synthetic */ nk ahb;
        private final int ahf;
        private final PendingIntent mPendingIntent;

        public c(nk nkVar, int i, com.google.android.gms.location.c.b bVar, int i2, PendingIntent pendingIntent) {
            boolean z = true;
            this.ahb = nkVar;
            super(nkVar, bVar);
            if (i != 1) {
                z = false;
            }
            je.K(z);
            this.ahf = i;
            this.Iv = LocationStatusCodes.eC(i2);
            this.mPendingIntent = pendingIntent;
            this.aha = null;
        }

        public c(nk nkVar, int i, com.google.android.gms.location.c.b bVar, int i2, String[] strArr) {
            this.ahb = nkVar;
            super(nkVar, bVar);
            je.K(i == 2);
            this.ahf = i;
            this.Iv = LocationStatusCodes.eC(i2);
            this.aha = strArr;
            this.mPendingIntent = null;
        }

        protected void a(com.google.android.gms.location.c.b bVar) {
            if (bVar != null) {
                switch (this.ahf) {
                    case 1:
                        bVar.a(this.Iv, this.mPendingIntent);
                        return;
                    case 2:
                        bVar.b(this.Iv, this.aha);
                        return;
                    default:
                        Log.wtf("LocationClientImpl", "Unsupported action: " + this.ahf);
                        return;
                }
            }
        }

        protected /* synthetic */ void g(Object obj) {
            a((com.google.android.gms.location.c.b) obj);
        }

        protected void hx() {
        }
    }

    public nk(Context context, Looper looper, String str, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str2) {
        this(context, looper, str, connectionCallbacks, onConnectionFailedListener, str2, null);
    }

    public nk(Context context, Looper looper, String str, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str2, String str3) {
        this(context, looper, str, connectionCallbacks, onConnectionFailedListener, str2, str3, null);
    }

    public nk(Context context, Looper looper, String str, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str2, String str3, String str4) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, str2);
        this.agX = new nj(context, this.Ee);
        this.agY = mz.a(context, str3, str4, this.Ee);
        this.agZ = ie.a(context, this.Ee);
    }

    public void S(boolean z) throws RemoteException {
        this.agX.S(z);
    }

    public void a(long j, PendingIntent pendingIntent) throws RemoteException {
        dS();
        jx.i(pendingIntent);
        jx.b(j >= 0, (Object) "detectionIntervalMillis must be >= 0");
        ((ni) hw()).a(j, true, pendingIntent);
    }

    public void a(PendingIntent pendingIntent) throws RemoteException {
        dS();
        jx.i(pendingIntent);
        ((ni) hw()).a(pendingIntent);
    }

    public void a(PendingIntent pendingIntent, com.google.android.gms.location.c.b bVar) throws RemoteException {
        nh nhVar;
        dS();
        jx.b((Object) pendingIntent, (Object) "PendingIntent must be specified.");
        jx.b((Object) bVar, (Object) "OnRemoveGeofencesResultListener not provided.");
        if (bVar == null) {
            nhVar = null;
        } else {
            Object bVar2 = new b(bVar, this);
        }
        ((ni) hw()).a(pendingIntent, nhVar, getContext().getPackageName());
    }

    public void a(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, com.google.android.gms.location.c.a aVar) throws RemoteException {
        nh nhVar;
        dS();
        jx.b((Object) geofencingRequest, (Object) "geofencingRequest can't be null.");
        jx.b((Object) pendingIntent, (Object) "PendingIntent must be specified.");
        jx.b((Object) aVar, (Object) "OnAddGeofencesResultListener not provided.");
        if (aVar == null) {
            nhVar = null;
        } else {
            Object bVar = new b(aVar, this);
        }
        ((ni) hw()).a(geofencingRequest, pendingIntent, nhVar);
    }

    public void a(LocationListener locationListener) throws RemoteException {
        this.agX.a(locationListener);
    }

    public void a(LocationRequest locationRequest, LocationListener locationListener, Looper looper) throws RemoteException {
        synchronized (this.agX) {
            this.agX.a(locationRequest, locationListener, looper);
        }
    }

    public void a(List<String> list, com.google.android.gms.location.c.b bVar) throws RemoteException {
        nh nhVar;
        dS();
        boolean z = list != null && list.size() > 0;
        jx.b(z, (Object) "geofenceRequestIds can't be null nor empty.");
        jx.b((Object) bVar, (Object) "OnRemoveGeofencesResultListener not provided.");
        String[] strArr = (String[]) list.toArray(new String[0]);
        if (bVar == null) {
            nhVar = null;
        } else {
            Object bVar2 = new b(bVar, this);
        }
        ((ni) hw()).a(strArr, nhVar, getContext().getPackageName());
    }

    public void b(Location location) throws RemoteException {
        this.agX.b(location);
    }

    public void b(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
        this.agX.b(locationRequest, pendingIntent);
    }

    public void c(PendingIntent pendingIntent) throws RemoteException {
        this.agX.c(pendingIntent);
    }

    public void disconnect() {
        synchronized (this.agX) {
            if (isConnected()) {
                try {
                    this.agX.removeAllListeners();
                    this.agX.nm();
                } catch (Throwable e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
            }
            super.disconnect();
        }
    }

    public Location nl() {
        return this.agX.nl();
    }
}
