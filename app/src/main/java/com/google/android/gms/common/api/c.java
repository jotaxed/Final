package com.google.android.gms.common.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jm;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.kc;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class c implements GoogleApiClient {
    private final Looper JF;
    private final Condition JR = this.zO.newCondition();
    private final jm JS;
    private final int JT;
    final Queue<d<?>> JU = new LinkedList();
    private ConnectionResult JV;
    private int JW;
    private volatile int JX = 4;
    private volatile boolean JY;
    private boolean JZ = false;
    private final b Jy = new b(this) {
        final /* synthetic */ c Kn;

        {
            this.Kn = r1;
        }

        public void b(d<?> dVar) {
            this.Kn.Kk.remove(dVar);
        }
    };
    private int Ka;
    private long Kb = 120000;
    private long Kc = 5000;
    final Handler Kd;
    BroadcastReceiver Ke;
    private final Bundle Kf = new Bundle();
    private final Map<com.google.android.gms.common.api.Api.c<?>, com.google.android.gms.common.api.Api.a> Kg = new HashMap();
    private final List<String> Kh;
    private boolean Ki;
    private final Set<d<?>> Kj = Collections.newSetFromMap(new WeakHashMap());
    final Set<d<?>> Kk = Collections.newSetFromMap(new ConcurrentHashMap());
    private final ConnectionCallbacks Kl = new ConnectionCallbacks(this) {
        final /* synthetic */ c Kn;

        {
            this.Kn = r1;
        }

        public void onConnected(Bundle connectionHint) {
            this.Kn.zO.lock();
            try {
                if (this.Kn.JX == 1) {
                    if (connectionHint != null) {
                        this.Kn.Kf.putAll(connectionHint);
                    }
                    this.Kn.gJ();
                }
                this.Kn.zO.unlock();
            } catch (Throwable th) {
                this.Kn.zO.unlock();
            }
        }

        public void onConnectionSuspended(int cause) {
            this.Kn.zO.lock();
            switch (cause) {
                case 1:
                    if (!this.Kn.gL()) {
                        this.Kn.JY = true;
                        this.Kn.Ke = new a(this.Kn);
                        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
                        intentFilter.addDataScheme("package");
                        this.Kn.mContext.registerReceiver(this.Kn.Ke, intentFilter);
                        this.Kn.Kd.sendMessageDelayed(this.Kn.Kd.obtainMessage(1), this.Kn.Kb);
                        this.Kn.Kd.sendMessageDelayed(this.Kn.Kd.obtainMessage(2), this.Kn.Kc);
                        this.Kn.al(cause);
                        break;
                    }
                    this.Kn.zO.unlock();
                    return;
                case 2:
                    try {
                        this.Kn.al(cause);
                        this.Kn.connect();
                        break;
                    } catch (Throwable th) {
                        this.Kn.zO.unlock();
                    }
            }
            this.Kn.zO.unlock();
        }
    };
    private final com.google.android.gms.internal.jm.b Km = new com.google.android.gms.internal.jm.b(this) {
        final /* synthetic */ c Kn;

        {
            this.Kn = r1;
        }

        public Bundle fX() {
            return null;
        }

        public boolean gN() {
            return this.Kn.Ki;
        }

        public boolean isConnected() {
            return this.Kn.isConnected();
        }
    };
    private final Context mContext;
    private final Lock zO = new ReentrantLock();

    interface d<A extends com.google.android.gms.common.api.Api.a> {
        void a(b bVar);

        void b(A a) throws DeadObjectException;

        void cancel();

        int gF();

        com.google.android.gms.common.api.Api.c<A> gz();

        void l(Status status);
    }

    interface b {
        void b(d<?> dVar);
    }

    private static class a extends BroadcastReceiver {
        private WeakReference<c> Ks;

        a(c cVar) {
            this.Ks = new WeakReference(cVar);
        }

        public void onReceive(Context context, Intent intent) {
            Uri data = intent.getData();
            String str = null;
            if (data != null) {
                str = data.getSchemeSpecificPart();
            }
            if (str != null && str.equals(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE)) {
                c cVar = (c) this.Ks.get();
                if (cVar != null && !cVar.isConnected() && !cVar.isConnecting() && cVar.gL()) {
                    cVar.connect();
                }
            }
        }
    }

    private class c extends Handler {
        final /* synthetic */ c Kn;

        c(c cVar, Looper looper) {
            this.Kn = cVar;
            super(looper);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    this.Kn.gM();
                    return;
                case 2:
                    this.Kn.resume();
                    return;
                default:
                    Log.w("GoogleApiClientImpl", "Unknown message id: " + msg.what);
                    return;
            }
        }
    }

    public c(Context context, Looper looper, jg jgVar, Map<Api<?>, ApiOptions> map, Set<ConnectionCallbacks> set, Set<OnConnectionFailedListener> set2, int i) {
        this.mContext = context;
        this.JS = new jm(context, looper, this.Km);
        this.JF = looper;
        this.Kd = new c(this, looper);
        this.JT = i;
        for (ConnectionCallbacks registerConnectionCallbacks : set) {
            this.JS.registerConnectionCallbacks(registerConnectionCallbacks);
        }
        for (OnConnectionFailedListener registerConnectionFailedListener : set2) {
            this.JS.registerConnectionFailedListener(registerConnectionFailedListener);
        }
        for (Api api : map.keySet()) {
            final com.google.android.gms.common.api.Api.b gx = api.gx();
            Object obj = map.get(api);
            this.Kg.put(api.gz(), a(gx, obj, context, looper, jgVar, this.Kl, new OnConnectionFailedListener(this) {
                final /* synthetic */ c Kn;

                public void onConnectionFailed(ConnectionResult result) {
                    this.Kn.zO.lock();
                    try {
                        if (this.Kn.JV == null || gx.getPriority() < this.Kn.JW) {
                            this.Kn.JV = result;
                            this.Kn.JW = gx.getPriority();
                        }
                        this.Kn.gJ();
                    } finally {
                        this.Kn.zO.unlock();
                    }
                }
            }));
        }
        this.Kh = Collections.unmodifiableList(jgVar.ho());
    }

    private static <C extends com.google.android.gms.common.api.Api.a, O> C a(com.google.android.gms.common.api.Api.b<C, O> bVar, Object obj, Context context, Looper looper, jg jgVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return bVar.a(context, looper, jgVar, obj, connectionCallbacks, onConnectionFailedListener);
    }

    private void a(final GoogleApiClient googleApiClient, final f fVar, final boolean z) {
        kc.Nu.c(googleApiClient).setResultCallback(new ResultCallback<Status>(this) {
            final /* synthetic */ c Kn;

            public void j(Status status) {
                if (status.isSuccess() && this.Kn.isConnected()) {
                    this.Kn.reconnect();
                }
                fVar.b((Result) status);
                if (z) {
                    googleApiClient.disconnect();
                }
            }

            public /* synthetic */ void onResult(Result x0) {
                j((Status) x0);
            }
        });
    }

    private <A extends com.google.android.gms.common.api.Api.a> void a(d<A> dVar) throws DeadObjectException {
        this.zO.lock();
        try {
            jx.b(dVar.gz() != null, (Object) "This task can not be executed or enqueued (it's probably a Batch or malformed)");
            this.Kk.add(dVar);
            dVar.a(this.Jy);
            if (gL()) {
                dVar.l(new Status(8));
                return;
            }
            dVar.b(a(dVar.gz()));
            this.zO.unlock();
        } finally {
            this.zO.unlock();
        }
    }

    private void al(int i) {
        this.zO.lock();
        try {
            if (this.JX != 3) {
                if (i == -1) {
                    Iterator it;
                    d dVar;
                    if (isConnecting()) {
                        it = this.JU.iterator();
                        while (it.hasNext()) {
                            dVar = (d) it.next();
                            if (dVar.gF() != 1) {
                                dVar.cancel();
                                it.remove();
                            }
                        }
                    } else {
                        this.JU.clear();
                    }
                    for (d dVar2 : this.Kk) {
                        dVar2.cancel();
                    }
                    this.Kk.clear();
                    for (d clear : this.Kj) {
                        clear.clear();
                    }
                    this.Kj.clear();
                    if (this.JV == null && !this.JU.isEmpty()) {
                        this.JZ = true;
                        return;
                    }
                }
                boolean isConnecting = isConnecting();
                boolean isConnected = isConnected();
                this.JX = 3;
                if (isConnecting) {
                    if (i == -1) {
                        this.JV = null;
                    }
                    this.JR.signalAll();
                }
                this.Ki = false;
                for (com.google.android.gms.common.api.Api.a aVar : this.Kg.values()) {
                    if (aVar.isConnected()) {
                        aVar.disconnect();
                    }
                }
                this.Ki = true;
                this.JX = 4;
                if (isConnected) {
                    if (i != -1) {
                        this.JS.aE(i);
                    }
                    this.Ki = false;
                }
            }
            this.zO.unlock();
        } finally {
            this.zO.unlock();
        }
    }

    private void gJ() {
        this.Ka--;
        if (this.Ka != 0) {
            return;
        }
        if (this.JV != null) {
            this.JZ = false;
            al(3);
            if (!(gL() && GooglePlayServicesUtil.e(this.mContext, this.JV.getErrorCode()))) {
                gM();
                this.JS.b(this.JV);
            }
            this.Ki = false;
            return;
        }
        this.JX = 2;
        gM();
        this.JR.signalAll();
        gK();
        if (this.JZ) {
            this.JZ = false;
            al(-1);
            return;
        }
        this.JS.f(this.Kf.isEmpty() ? null : this.Kf);
    }

    private void gK() {
        this.zO.lock();
        try {
            boolean z = isConnected() || gL();
            jx.a(z, "GoogleApiClient is not connected yet.");
            while (!this.JU.isEmpty()) {
                a((d) this.JU.remove());
            }
            this.zO.unlock();
        } catch (Throwable e) {
            Log.w("GoogleApiClientImpl", "Service died while flushing queue", e);
        } catch (Throwable th) {
            this.zO.unlock();
        }
    }

    private void gM() {
        this.zO.lock();
        try {
            if (this.JY) {
                this.JY = false;
                this.Kd.removeMessages(2);
                this.Kd.removeMessages(1);
                this.mContext.unregisterReceiver(this.Ke);
                this.zO.unlock();
            }
        } finally {
            this.zO.unlock();
        }
    }

    private void resume() {
        this.zO.lock();
        try {
            if (gL()) {
                connect();
            }
            this.zO.unlock();
        } catch (Throwable th) {
            this.zO.unlock();
        }
    }

    public <C extends com.google.android.gms.common.api.Api.a> C a(com.google.android.gms.common.api.Api.c<C> cVar) {
        Object obj = (com.google.android.gms.common.api.Api.a) this.Kg.get(cVar);
        jx.b(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public <A extends com.google.android.gms.common.api.Api.a, R extends Result, T extends com.google.android.gms.common.api.BaseImplementation.a<R, A>> T a(T t) {
        this.zO.lock();
        try {
            if (isConnected()) {
                b((com.google.android.gms.common.api.BaseImplementation.a) t);
            } else {
                this.JU.add(t);
            }
            this.zO.unlock();
            return t;
        } catch (Throwable th) {
            this.zO.unlock();
        }
    }

    public boolean a(Scope scope) {
        return this.Kh.contains(scope.gO());
    }

    public <A extends com.google.android.gms.common.api.Api.a, T extends com.google.android.gms.common.api.BaseImplementation.a<? extends Result, A>> T b(T t) {
        boolean z = isConnected() || gL();
        jx.a(z, "GoogleApiClient is not connected yet.");
        gK();
        try {
            a((d) t);
        } catch (DeadObjectException e) {
            al(1);
        }
        return t;
    }

    public ConnectionResult blockingConnect() {
        ConnectionResult connectionResult;
        jx.a(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.zO.lock();
        try {
            connect();
            while (isConnecting()) {
                this.JR.await();
            }
            if (isConnected()) {
                connectionResult = ConnectionResult.Iu;
            } else if (this.JV != null) {
                connectionResult = this.JV;
                this.zO.unlock();
            } else {
                connectionResult = new ConnectionResult(13, null);
                this.zO.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, null);
        } finally {
            this.zO.unlock();
        }
        return connectionResult;
    }

    public ConnectionResult blockingConnect(long timeout, TimeUnit unit) {
        ConnectionResult connectionResult;
        jx.a(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.zO.lock();
        try {
            connect();
            long toNanos = unit.toNanos(timeout);
            while (isConnecting()) {
                toNanos = this.JR.awaitNanos(toNanos);
                if (toNanos <= 0) {
                    connectionResult = new ConnectionResult(14, null);
                    break;
                }
            }
            if (isConnected()) {
                connectionResult = ConnectionResult.Iu;
                this.zO.unlock();
            } else if (this.JV != null) {
                connectionResult = this.JV;
                this.zO.unlock();
            } else {
                connectionResult = new ConnectionResult(13, null);
                this.zO.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, null);
        } finally {
            this.zO.unlock();
        }
        return connectionResult;
    }

    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        jx.a(isConnected(), "GoogleApiClient is not connected yet.");
        final f fVar = new f(this.JF);
        if (this.Kg.containsKey(kc.DQ)) {
            a(this, fVar, false);
        } else {
            final AtomicReference atomicReference = new AtomicReference();
            ConnectionCallbacks anonymousClass5 = new ConnectionCallbacks(this) {
                final /* synthetic */ c Kn;

                public void onConnected(Bundle connectionHint) {
                    this.Kn.a((GoogleApiClient) atomicReference.get(), fVar, true);
                }

                public void onConnectionSuspended(int cause) {
                }
            };
            GoogleApiClient build = new Builder(this.mContext).addApi(kc.API).addConnectionCallbacks(anonymousClass5).addOnConnectionFailedListener(new OnConnectionFailedListener(this) {
                final /* synthetic */ c Kn;

                public void onConnectionFailed(ConnectionResult result) {
                    fVar.b(new Status(8));
                }
            }).setHandler(this.Kd).build();
            atomicReference.set(build);
            build.connect();
        }
        return fVar;
    }

    public void connect() {
        this.zO.lock();
        try {
            this.JZ = false;
            if (isConnected() || isConnecting()) {
                this.zO.unlock();
                return;
            }
            this.Ki = true;
            this.JV = null;
            this.JX = 1;
            this.Kf.clear();
            this.Ka = this.Kg.size();
            for (com.google.android.gms.common.api.Api.a connect : this.Kg.values()) {
                connect.connect();
            }
            this.zO.unlock();
        } catch (Throwable th) {
            this.zO.unlock();
        }
    }

    public <L> d<L> d(L l) {
        jx.b((Object) l, (Object) "Listener must not be null");
        this.zO.lock();
        try {
            d<L> dVar = new d(this.JF, l);
            this.Kj.add(dVar);
            return dVar;
        } finally {
            this.zO.unlock();
        }
    }

    public void disconnect() {
        gM();
        al(-1);
    }

    boolean gL() {
        return this.JY;
    }

    public Looper getLooper() {
        return this.JF;
    }

    public boolean isConnected() {
        return this.JX == 2;
    }

    public boolean isConnecting() {
        return this.JX == 1;
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.JS.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.JS.isConnectionFailedListenerRegistered(listener);
    }

    public void reconnect() {
        disconnect();
        connect();
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.JS.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.JS.registerConnectionFailedListener(listener);
    }

    public void stopAutoManage(FragmentActivity lifecycleActivity) {
        jx.a(this.JT >= 0, "Called stopAutoManage but automatic lifecycle management is not enabled.");
        g.a(lifecycleActivity).ao(this.JT);
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.JS.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.JS.unregisterConnectionFailedListener(listener);
    }
}
