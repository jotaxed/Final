package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public abstract class jl<T extends IInterface> implements com.google.android.gms.common.api.Api.a, com.google.android.gms.internal.jm.b {
    public static final String[] MP = new String[]{"service_esmobile", "service_googleme"};
    private final Looper JF;
    private final jm JS;
    private T MJ;
    private final ArrayList<b<?>> MK;
    private f ML;
    private int MM;
    private final String[] MN;
    boolean MO;
    private final Context mContext;
    private final Object mH;
    final Handler mHandler;

    final class a extends Handler {
        final /* synthetic */ jl MQ;

        public a(jl jlVar, Looper looper) {
            this.MQ = jlVar;
            super(looper);
        }

        public void handleMessage(Message msg) {
            b bVar;
            if (msg.what == 1 && !this.MQ.isConnecting()) {
                bVar = (b) msg.obj;
                bVar.hx();
                bVar.unregister();
            } else if (msg.what == 3) {
                this.MQ.JS.b(new ConnectionResult(((Integer) msg.obj).intValue(), null));
            } else if (msg.what == 4) {
                this.MQ.a(4, null);
                this.MQ.JS.aE(((Integer) msg.obj).intValue());
                this.MQ.a(4, 1, null);
            } else if (msg.what == 2 && !this.MQ.isConnected()) {
                bVar = (b) msg.obj;
                bVar.hx();
                bVar.unregister();
            } else if (msg.what == 2 || msg.what == 1) {
                ((b) msg.obj).hy();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle this message.");
            }
        }
    }

    protected abstract class b<TListener> {
        final /* synthetic */ jl MQ;
        private boolean MR = false;
        private TListener mListener;

        public b(jl jlVar, TListener tListener) {
            this.MQ = jlVar;
            this.mListener = tListener;
        }

        protected abstract void g(TListener tListener);

        protected abstract void hx();

        public void hy() {
            synchronized (this) {
                Object obj = this.mListener;
                if (this.MR) {
                    Log.w("GmsClient", "Callback proxy " + this + " being reused. This is not safe.");
                }
            }
            if (obj != null) {
                try {
                    g(obj);
                } catch (RuntimeException e) {
                    hx();
                    throw e;
                }
            }
            hx();
            synchronized (this) {
                this.MR = true;
            }
            unregister();
        }

        public void hz() {
            synchronized (this) {
                this.mListener = null;
            }
        }

        public void unregister() {
            hz();
            synchronized (this.MQ.MK) {
                this.MQ.MK.remove(this);
            }
        }
    }

    public static final class c implements ConnectionCallbacks {
        private final GooglePlayServicesClient.ConnectionCallbacks MS;

        public c(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
            this.MS = connectionCallbacks;
        }

        public boolean equals(Object other) {
            return other instanceof c ? this.MS.equals(((c) other).MS) : this.MS.equals(other);
        }

        public void onConnected(Bundle connectionHint) {
            this.MS.onConnected(connectionHint);
        }

        public void onConnectionSuspended(int cause) {
            this.MS.onDisconnected();
        }
    }

    public abstract class d<TListener> extends b<TListener> {
        private final DataHolder JG;
        final /* synthetic */ jl MQ;

        public d(jl jlVar, TListener tListener, DataHolder dataHolder) {
            this.MQ = jlVar;
            super(jlVar, tListener);
            this.JG = dataHolder;
        }

        protected abstract void b(TListener tListener, DataHolder dataHolder);

        protected final void g(TListener tListener) {
            b(tListener, this.JG);
        }

        protected void hx() {
            if (this.JG != null) {
                this.JG.close();
            }
        }

        public /* bridge */ /* synthetic */ void hy() {
            super.hy();
        }

        public /* bridge */ /* synthetic */ void hz() {
            super.hz();
        }

        public /* bridge */ /* synthetic */ void unregister() {
            super.unregister();
        }
    }

    public static final class e extends com.google.android.gms.internal.js.a {
        private jl MT;

        public e(jl jlVar) {
            this.MT = jlVar;
        }

        public void b(int i, IBinder iBinder, Bundle bundle) {
            jx.b((Object) "onPostInitComplete can be called only once per call to getServiceFromBroker", this.MT);
            this.MT.a(i, iBinder, bundle);
            this.MT = null;
        }
    }

    public final class f implements ServiceConnection {
        final /* synthetic */ jl MQ;

        public f(jl jlVar) {
            this.MQ = jlVar;
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            this.MQ.N(binder);
        }

        public void onServiceDisconnected(ComponentName component) {
            this.MQ.mHandler.sendMessage(this.MQ.mHandler.obtainMessage(4, Integer.valueOf(1)));
        }
    }

    public static final class g implements OnConnectionFailedListener {
        private final GooglePlayServicesClient.OnConnectionFailedListener MU;

        public g(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.MU = onConnectionFailedListener;
        }

        public boolean equals(Object other) {
            return other instanceof g ? this.MU.equals(((g) other).MU) : this.MU.equals(other);
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.MU.onConnectionFailed(result);
        }
    }

    protected final class h extends b<Boolean> {
        final /* synthetic */ jl MQ;
        public final Bundle MV;
        public final IBinder MW;
        public final int statusCode;

        public h(jl jlVar, int i, IBinder iBinder, Bundle bundle) {
            this.MQ = jlVar;
            super(jlVar, Boolean.valueOf(true));
            this.statusCode = i;
            this.MW = iBinder;
            this.MV = bundle;
        }

        protected void b(Boolean bool) {
            if (bool == null) {
                this.MQ.a(1, null);
                return;
            }
            switch (this.statusCode) {
                case 0:
                    try {
                        if (this.MQ.bL().equals(this.MW.getInterfaceDescriptor())) {
                            IInterface l = this.MQ.l(this.MW);
                            if (l != null) {
                                this.MQ.a(3, l);
                                this.MQ.JS.dU();
                                return;
                            }
                        }
                    } catch (RemoteException e) {
                    }
                    jn.J(this.MQ.mContext).b(this.MQ.bK(), this.MQ.ML);
                    this.MQ.ML = null;
                    this.MQ.a(1, null);
                    this.MQ.JS.b(new ConnectionResult(8, null));
                    return;
                case 10:
                    this.MQ.a(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    PendingIntent pendingIntent = this.MV != null ? (PendingIntent) this.MV.getParcelable("pendingIntent") : null;
                    if (this.MQ.ML != null) {
                        jn.J(this.MQ.mContext).b(this.MQ.bK(), this.MQ.ML);
                        this.MQ.ML = null;
                    }
                    this.MQ.a(1, null);
                    this.MQ.JS.b(new ConnectionResult(this.statusCode, pendingIntent));
                    return;
            }
        }

        protected /* synthetic */ void g(Object obj) {
            b((Boolean) obj);
        }

        protected void hx() {
        }
    }

    protected jl(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String... strArr) {
        this.mH = new Object();
        this.MK = new ArrayList();
        this.MM = 1;
        this.MO = false;
        this.mContext = (Context) jx.i(context);
        this.JF = (Looper) jx.b((Object) looper, (Object) "Looper must not be null");
        this.JS = new jm(context, looper, this);
        this.mHandler = new a(this, looper);
        c(strArr);
        this.MN = strArr;
        registerConnectionCallbacks((ConnectionCallbacks) jx.i(connectionCallbacks));
        registerConnectionFailedListener((OnConnectionFailedListener) jx.i(onConnectionFailedListener));
    }

    @Deprecated
    protected jl(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, String... strArr) {
        this(context, context.getMainLooper(), new c(connectionCallbacks), new g(onConnectionFailedListener), strArr);
    }

    private void a(int i, T t) {
        boolean z = true;
        if ((i == 3) != (t != null)) {
            z = false;
        }
        jx.L(z);
        synchronized (this.mH) {
            this.MM = i;
            this.MJ = t;
        }
    }

    private boolean a(int i, int i2, T t) {
        boolean z;
        synchronized (this.mH) {
            if (this.MM != i) {
                z = false;
            } else {
                a(i2, (IInterface) t);
                z = true;
            }
        }
        return z;
    }

    protected final void N(IBinder iBinder) {
        try {
            a(com.google.android.gms.internal.jt.a.Q(iBinder), new e(this));
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            aD(1);
        } catch (Throwable e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    protected void a(int i, IBinder iBinder, Bundle bundle) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, new h(this, i, iBinder, bundle)));
    }

    @Deprecated
    public final void a(b<?> bVar) {
        synchronized (this.MK) {
            this.MK.add(bVar);
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, bVar));
    }

    protected abstract void a(jt jtVar, e eVar) throws RemoteException;

    public void aD(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Integer.valueOf(i)));
    }

    protected abstract String bK();

    protected abstract String bL();

    protected void c(String... strArr) {
    }

    public void connect() {
        this.MO = true;
        a(2, null);
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            a(1, null);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(isGooglePlayServicesAvailable)));
            return;
        }
        if (this.ML != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + bK());
            jn.J(this.mContext).b(bK(), this.ML);
        }
        this.ML = new f(this);
        if (!jn.J(this.mContext).a(bK(), this.ML)) {
            Log.e("GmsClient", "unable to connect to service: " + bK());
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(9)));
        }
    }

    protected final void dS() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void disconnect() {
        this.MO = false;
        synchronized (this.MK) {
            int size = this.MK.size();
            for (int i = 0; i < size; i++) {
                ((b) this.MK.get(i)).hz();
            }
            this.MK.clear();
        }
        a(1, null);
        if (this.ML != null) {
            jn.J(this.mContext).b(bK(), this.ML);
            this.ML = null;
        }
    }

    public Bundle fX() {
        return null;
    }

    public boolean gN() {
        return this.MO;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.JF;
    }

    public final String[] hv() {
        return this.MN;
    }

    public final T hw() throws DeadObjectException {
        T t;
        synchronized (this.mH) {
            if (this.MM == 4) {
                throw new DeadObjectException();
            }
            dS();
            jx.a(this.MJ != null, "Client is connected but service is null");
            t = this.MJ;
        }
        return t;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.mH) {
            z = this.MM == 3;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.mH) {
            z = this.MM == 2;
        }
        return z;
    }

    @Deprecated
    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks listener) {
        return this.JS.isConnectionCallbacksRegistered(new c(listener));
    }

    @Deprecated
    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        return this.JS.isConnectionFailedListenerRegistered(listener);
    }

    protected abstract T l(IBinder iBinder);

    @Deprecated
    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.JS.registerConnectionCallbacks(new c(listener));
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.JS.registerConnectionCallbacks(listener);
    }

    @Deprecated
    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.JS.registerConnectionFailedListener(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.JS.registerConnectionFailedListener(listener);
    }

    @Deprecated
    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.JS.unregisterConnectionCallbacks(new c(listener));
    }

    @Deprecated
    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.JS.unregisterConnectionFailedListener(listener);
    }
}
