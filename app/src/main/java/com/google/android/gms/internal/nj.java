package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import java.util.HashMap;

public class nj {
    private final np<ni> Ee;
    private ContentProviderClient agS = null;
    private boolean agT = false;
    private HashMap<LocationListener, b> agU = new HashMap();
    private final Context mContext;

    private static class a extends Handler {
        private final LocationListener agV;

        public a(LocationListener locationListener) {
            this.agV = locationListener;
        }

        public a(LocationListener locationListener, Looper looper) {
            super(looper);
            this.agV = locationListener;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    this.agV.onLocationChanged(new Location((Location) msg.obj));
                    return;
                default:
                    Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
                    return;
            }
        }
    }

    private static class b extends com.google.android.gms.location.b.a {
        private Handler agW;

        b(LocationListener locationListener, Looper looper) {
            this.agW = looper == null ? new a(locationListener) : new a(locationListener, looper);
        }

        public void onLocationChanged(Location location) {
            if (this.agW == null) {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = location;
            this.agW.sendMessage(obtain);
        }

        public void release() {
            this.agW = null;
        }
    }

    public nj(Context context, np<ni> npVar) {
        this.mContext = context;
        this.Ee = npVar;
    }

    private b a(LocationListener locationListener, Looper looper) {
        b bVar;
        if (looper == null) {
            jx.b(Looper.myLooper(), (Object) "Can't create handler inside thread that has not called Looper.prepare()");
        }
        synchronized (this.agU) {
            bVar = (b) this.agU.get(locationListener);
            if (bVar == null) {
                bVar = new b(locationListener, looper);
            }
            this.agU.put(locationListener, bVar);
        }
        return bVar;
    }

    public void S(boolean z) throws RemoteException {
        this.Ee.dS();
        ((ni) this.Ee.hw()).S(z);
        this.agT = z;
    }

    public void a(LocationListener locationListener) throws RemoteException {
        this.Ee.dS();
        jx.b((Object) locationListener, (Object) "Invalid null listener");
        synchronized (this.agU) {
            com.google.android.gms.location.b bVar = (b) this.agU.remove(locationListener);
            if (this.agS != null && this.agU.isEmpty()) {
                this.agS.release();
                this.agS = null;
            }
            if (bVar != null) {
                bVar.release();
                ((ni) this.Ee.hw()).a(bVar);
            }
        }
    }

    public void a(LocationRequest locationRequest, LocationListener locationListener, Looper looper) throws RemoteException {
        this.Ee.dS();
        ((ni) this.Ee.hw()).a(locationRequest, a(locationListener, looper));
    }

    public void b(Location location) throws RemoteException {
        this.Ee.dS();
        ((ni) this.Ee.hw()).b(location);
    }

    public void b(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
        this.Ee.dS();
        ((ni) this.Ee.hw()).a(locationRequest, pendingIntent);
    }

    public void c(PendingIntent pendingIntent) throws RemoteException {
        this.Ee.dS();
        ((ni) this.Ee.hw()).b(pendingIntent);
    }

    public Location nl() {
        this.Ee.dS();
        try {
            return ((ni) this.Ee.hw()).bZ(this.mContext.getPackageName());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void nm() {
        if (this.agT) {
            try {
                S(false);
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public void removeAllListeners() {
        try {
            synchronized (this.agU) {
                for (com.google.android.gms.location.b bVar : this.agU.values()) {
                    if (bVar != null) {
                        ((ni) this.Ee.hw()).a(bVar);
                    }
                }
                this.agU.clear();
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
