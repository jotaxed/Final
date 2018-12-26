package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.ad;
import com.google.android.gms.fitness.request.ah;
import com.google.android.gms.fitness.result.BleDevicesResult;
import com.google.android.gms.internal.lu.c;

public class mh implements BleApi {

    private static class a extends com.google.android.gms.internal.mp.a {
        private final b<BleDevicesResult> Ea;

        private a(b<BleDevicesResult> bVar) {
            this.Ea = bVar;
        }

        public void a(BleDevicesResult bleDevicesResult) {
            this.Ea.b(bleDevicesResult);
        }
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, final BleDevice bleDevice) {
        return client.b(new c(this, client) {
            final /* synthetic */ mh UX;

            protected void a(lu luVar) throws RemoteException {
                luVar.jM().a(new com.google.android.gms.fitness.request.b(bleDevice), new lu.b(this), luVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, final String deviceAddress) {
        return client.b(new c(this, client) {
            final /* synthetic */ mh UX;

            protected void a(lu luVar) throws RemoteException {
                luVar.jM().a(new com.google.android.gms.fitness.request.b(deviceAddress), new lu.b(this), luVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient client) {
        return client.a(new com.google.android.gms.internal.lu.a<BleDevicesResult>(this, client) {
            final /* synthetic */ mh UX;

            protected void a(lu luVar) throws RemoteException {
                luVar.jM().a(new a(this), luVar.getContext().getPackageName());
            }

            protected /* synthetic */ Result c(Status status) {
                return v(status);
            }

            protected BleDevicesResult v(Status status) {
                return BleDevicesResult.C(status);
            }
        });
    }

    public PendingResult<Status> startBleScan(GoogleApiClient client, final StartBleScanRequest request) {
        return client.a(new c(this, client) {
            final /* synthetic */ mh UX;

            protected void a(lu luVar) throws RemoteException {
                luVar.jM().a(request, new lu.b(this), luVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<Status> stopBleScan(GoogleApiClient client, final BleScanCallback requestCallback) {
        return client.a(new c(this, client) {
            final /* synthetic */ mh UX;

            protected void a(lu luVar) throws RemoteException {
                md bVar = new lu.b(this);
                String packageName = luVar.getContext().getPackageName();
                luVar.jM().a(new ad(requestCallback), bVar, packageName);
            }
        });
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, BleDevice bleDevice) {
        return unclaimBleDevice(client, bleDevice.getAddress());
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, final String deviceAddress) {
        return client.b(new c(this, client) {
            final /* synthetic */ mh UX;

            protected void a(lu luVar) throws RemoteException {
                luVar.jM().a(new ah(deviceAddress), new lu.b(this), luVar.getContext().getPackageName());
            }
        });
    }
}
