package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager.StateConflictResult;
import com.google.android.gms.appstate.AppStateManager.StateDeletedResult;
import com.google.android.gms.appstate.AppStateManager.StateListResult;
import com.google.android.gms.appstate.AppStateManager.StateLoadedResult;
import com.google.android.gms.appstate.AppStateManager.StateResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public final class ib extends jl<id> {
    private final String DZ;

    private static final class a extends ia {
        private final com.google.android.gms.common.api.BaseImplementation.b<StateDeletedResult> Ea;

        public a(com.google.android.gms.common.api.BaseImplementation.b<StateDeletedResult> bVar) {
            this.Ea = (com.google.android.gms.common.api.BaseImplementation.b) jx.b((Object) bVar, (Object) "Result holder must not be null");
        }

        public void e(int i, int i2) {
            this.Ea.b(new b(new Status(i), i2));
        }
    }

    private static final class b implements StateDeletedResult {
        private final Status Eb;
        private final int Ec;

        public b(Status status, int i) {
            this.Eb = status;
            this.Ec = i;
        }

        public int getStateKey() {
            return this.Ec;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    private static final class c extends ia {
        private final com.google.android.gms.common.api.BaseImplementation.b<StateListResult> Ea;

        public c(com.google.android.gms.common.api.BaseImplementation.b<StateListResult> bVar) {
            this.Ea = (com.google.android.gms.common.api.BaseImplementation.b) jx.b((Object) bVar, (Object) "Result holder must not be null");
        }

        public void a(DataHolder dataHolder) {
            this.Ea.b(new d(dataHolder));
        }
    }

    private static final class d extends com.google.android.gms.common.api.b implements StateListResult {
        private final AppStateBuffer Ed;

        public d(DataHolder dataHolder) {
            super(dataHolder);
            this.Ed = new AppStateBuffer(dataHolder);
        }

        public AppStateBuffer getStateBuffer() {
            return this.Ed;
        }
    }

    private static final class e extends ia {
        private final com.google.android.gms.common.api.BaseImplementation.b<StateResult> Ea;

        public e(com.google.android.gms.common.api.BaseImplementation.b<StateResult> bVar) {
            this.Ea = (com.google.android.gms.common.api.BaseImplementation.b) jx.b((Object) bVar, (Object) "Result holder must not be null");
        }

        public void a(int i, DataHolder dataHolder) {
            this.Ea.b(new f(i, dataHolder));
        }
    }

    private static final class f extends com.google.android.gms.common.api.b implements StateConflictResult, StateLoadedResult, StateResult {
        private final int Ec;
        private final AppStateBuffer Ed;

        public f(int i, DataHolder dataHolder) {
            super(dataHolder);
            this.Ec = i;
            this.Ed = new AppStateBuffer(dataHolder);
        }

        private boolean fN() {
            return this.Eb.getStatusCode() == 2000;
        }

        public StateConflictResult getConflictResult() {
            return fN() ? this : null;
        }

        public StateLoadedResult getLoadedResult() {
            return fN() ? null : this;
        }

        public byte[] getLocalData() {
            return this.Ed.getCount() == 0 ? null : this.Ed.get(0).getLocalData();
        }

        public String getResolvedVersion() {
            return this.Ed.getCount() == 0 ? null : this.Ed.get(0).getConflictVersion();
        }

        public byte[] getServerData() {
            return this.Ed.getCount() == 0 ? null : this.Ed.get(0).getConflictData();
        }

        public int getStateKey() {
            return this.Ec;
        }

        public void release() {
            this.Ed.release();
        }
    }

    private static final class g extends ia {
        private final com.google.android.gms.common.api.BaseImplementation.b<Status> Ea;

        public g(com.google.android.gms.common.api.BaseImplementation.b<Status> bVar) {
            this.Ea = (com.google.android.gms.common.api.BaseImplementation.b) jx.b((Object) bVar, (Object) "Holder must not be null");
        }

        public void fK() {
            this.Ea.b(new Status(0));
        }
    }

    public ib(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, String[] strArr) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.DZ = (String) jx.i(str);
    }

    protected id H(IBinder iBinder) {
        return com.google.android.gms.internal.id.a.J(iBinder);
    }

    public void a(com.google.android.gms.common.api.BaseImplementation.b<StateListResult> bVar) {
        try {
            ((id) hw()).a(new c(bVar));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.BaseImplementation.b<StateDeletedResult> bVar, int i) {
        try {
            ((id) hw()).b(new a(bVar), i);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.BaseImplementation.b<StateResult> bVar, int i, String str, byte[] bArr) {
        try {
            ((id) hw()).a(new e(bVar), i, str, bArr);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.BaseImplementation.b<StateResult> bVar, int i, byte[] bArr) {
        if (bVar == null) {
            ic icVar = null;
        } else {
            Object eVar = new e(bVar);
        }
        try {
            ((id) hw()).a(icVar, i, bArr);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    protected void a(jt jtVar, com.google.android.gms.internal.jl.e eVar) throws RemoteException {
        jtVar.a((js) eVar, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.DZ, hv());
    }

    public void b(com.google.android.gms.common.api.BaseImplementation.b<Status> bVar) {
        try {
            ((id) hw()).b(new g(bVar));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void b(com.google.android.gms.common.api.BaseImplementation.b<StateResult> bVar, int i) {
        try {
            ((id) hw()).a(new e(bVar), i);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    protected String bK() {
        return "com.google.android.gms.appstate.service.START";
    }

    protected String bL() {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    protected void c(String... strArr) {
        boolean z = false;
        for (String equals : strArr) {
            if (equals.equals(Scopes.APP_STATE)) {
                z = true;
            }
        }
        jx.a(z, String.format("App State APIs requires %s to function.", new Object[]{Scopes.APP_STATE}));
    }

    public int fL() {
        try {
            return ((id) hw()).fL();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    public int fM() {
        try {
            return ((id) hw()).fM();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    protected /* synthetic */ IInterface l(IBinder iBinder) {
        return H(iBinder);
    }
}
