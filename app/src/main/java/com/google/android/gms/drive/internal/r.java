package com.google.android.gms.drive.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.DriveEventService;
import com.google.android.gms.drive.events.c;
import com.google.android.gms.drive.events.d;
import com.google.android.gms.drive.internal.ae.a;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jl.e;
import com.google.android.gms.internal.js;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.jx;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class r extends jl<ae> {
    private final String DZ;
    private final String JK;
    private final Bundle PK;
    private final boolean PL;
    private DriveId PM;
    private DriveId PN;
    final ConnectionCallbacks PO;
    final Map<DriveId, Map<c, aa>> PP = new HashMap();

    public r(Context context, Looper looper, jg jgVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String[] strArr, Bundle bundle) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.DZ = (String) jx.b(jgVar.hm(), (Object) "Must call Api.ClientBuilder.setAccountName()");
        this.JK = jgVar.hq();
        this.PO = connectionCallbacks;
        this.PK = bundle;
        Intent intent = new Intent(DriveEventService.ACTION_HANDLE_EVENT);
        intent.setPackage(context.getPackageName());
        List queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        switch (queryIntentServices.size()) {
            case 0:
                this.PL = false;
                return;
            case 1:
                ServiceInfo serviceInfo = ((ResolveInfo) queryIntentServices.get(0)).serviceInfo;
                if (serviceInfo.exported) {
                    this.PL = true;
                    return;
                }
                throw new IllegalStateException("Drive event service " + serviceInfo.name + " must be exported in AndroidManifest.xml");
            default:
                throw new IllegalStateException("AndroidManifest.xml can only define one service that handles the " + intent.getAction() + " action");
        }
    }

    protected ae W(IBinder iBinder) {
        return a.X(iBinder);
    }

    PendingResult<Status> a(GoogleApiClient googleApiClient, final DriveId driveId, final int i) {
        jx.b(d.a(i, driveId), (Object) "id");
        jx.a(isConnected(), "Client must be connected");
        if (this.PL) {
            return googleApiClient.b(new a(this, googleApiClient) {
                final /* synthetic */ r PT;

                protected void a(r rVar) throws RemoteException {
                    rVar.iG().a(new AddEventListenerRequest(driveId, i), null, null, new bg(this));
                }
            });
        }
        throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
    }

    PendingResult<Status> a(GoogleApiClient googleApiClient, DriveId driveId, int i, c cVar) {
        PendingResult<Status> jVar;
        jx.b(d.a(i, driveId), (Object) "id");
        jx.b((Object) cVar, (Object) "listener");
        jx.a(isConnected(), "Client must be connected");
        synchronized (this.PP) {
            Map map;
            aa aaVar;
            Map map2 = (Map) this.PP.get(driveId);
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                this.PP.put(driveId, hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            aa aaVar2 = (aa) map.get(cVar);
            if (aaVar2 == null) {
                aaVar = new aa(getLooper(), getContext(), i, cVar);
                map.put(cVar, aaVar);
            } else if (aaVar2.bx(i)) {
                jVar = new j(googleApiClient, Status.Kw);
            } else {
                aaVar = aaVar2;
            }
            aaVar.bw(i);
            final DriveId driveId2 = driveId;
            final int i2 = i;
            jVar = googleApiClient.b(new a(this, googleApiClient) {
                final /* synthetic */ r PT;

                protected void a(r rVar) throws RemoteException {
                    rVar.iG().a(new AddEventListenerRequest(driveId2, i2), aaVar, null, new bg(this));
                }
            });
        }
        return jVar;
    }

    protected void a(int i, IBinder iBinder, Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.PM = (DriveId) bundle.getParcelable("com.google.android.gms.drive.root_id");
            this.PN = (DriveId) bundle.getParcelable("com.google.android.gms.drive.appdata_id");
        }
        super.a(i, iBinder, bundle);
    }

    protected void a(jt jtVar, e eVar) throws RemoteException {
        String packageName = getContext().getPackageName();
        jx.i(eVar);
        jx.i(packageName);
        jx.i(hv());
        Bundle bundle = new Bundle();
        if (!packageName.equals(this.JK)) {
            bundle.putString("proxy_package_name", this.JK);
        }
        bundle.putAll(this.PK);
        jtVar.a((js) eVar, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, packageName, hv(), this.DZ, bundle);
    }

    PendingResult<Status> b(GoogleApiClient googleApiClient, final DriveId driveId, final int i) {
        jx.b(d.a(i, driveId), (Object) "id");
        jx.a(isConnected(), "Client must be connected");
        return googleApiClient.b(new a(this, googleApiClient) {
            final /* synthetic */ r PT;

            protected void a(r rVar) throws RemoteException {
                rVar.iG().a(new RemoveEventListenerRequest(driveId, i), null, null, new bg(this));
            }
        });
    }

    PendingResult<Status> b(GoogleApiClient googleApiClient, DriveId driveId, int i, c cVar) {
        PendingResult<Status> jVar;
        jx.b(d.a(i, driveId), (Object) "id");
        jx.a(isConnected(), "Client must be connected");
        jx.b((Object) cVar, (Object) "listener");
        synchronized (this.PP) {
            Map map = (Map) this.PP.get(driveId);
            if (map == null) {
                jVar = new j(googleApiClient, Status.Kw);
            } else {
                final aa aaVar = (aa) map.remove(cVar);
                if (aaVar == null) {
                    jVar = new j(googleApiClient, Status.Kw);
                } else {
                    if (map.isEmpty()) {
                        this.PP.remove(driveId);
                    }
                    final DriveId driveId2 = driveId;
                    final int i2 = i;
                    jVar = googleApiClient.b(new a(this, googleApiClient) {
                        final /* synthetic */ r PT;

                        protected void a(r rVar) throws RemoteException {
                            rVar.iG().a(new RemoveEventListenerRequest(driveId2, i2), aaVar, null, new bg(this));
                        }
                    });
                }
            }
        }
        return jVar;
    }

    protected String bK() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    protected String bL() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    PendingResult<Status> cancelPendingActions(GoogleApiClient apiClient, final List<String> pendingTags) {
        boolean z = true;
        jx.L(pendingTags != null);
        if (pendingTags.isEmpty()) {
            z = false;
        }
        jx.L(z);
        jx.a(isConnected(), "Client must be connected");
        return apiClient.b(new a(this, apiClient) {
            final /* synthetic */ r PT;

            protected void a(r rVar) throws RemoteException {
                rVar.iG().a(new CancelPendingActionsRequest(pendingTags), new bg(this));
            }
        });
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                ((ae) hw()).a(new DisconnectRequest());
            } catch (RemoteException e) {
            }
        }
        super.disconnect();
        this.PP.clear();
    }

    public ae iG() throws DeadObjectException {
        return (ae) hw();
    }

    public DriveId iH() {
        return this.PM;
    }

    public DriveId iI() {
        return this.PN;
    }

    public boolean iJ() {
        return this.PL;
    }

    protected /* synthetic */ IInterface l(IBinder iBinder) {
        return W(iBinder);
    }
}
