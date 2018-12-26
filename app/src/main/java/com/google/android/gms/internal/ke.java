package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public final class ke implements kd {

    private static class a extends kb {
        private final b<Status> Ea;

        public a(b<Status> bVar) {
            this.Ea = bVar;
        }

        public void aI(int i) throws RemoteException {
            this.Ea.b(new Status(i));
        }
    }

    public PendingResult<Status> c(GoogleApiClient googleApiClient) {
        return new a(this, googleApiClient) {
            final /* synthetic */ ke Nv;

            protected void a(kg kgVar) throws RemoteException {
                ((ki) kgVar.hw()).a(new a(this));
            }
        }.gE();
    }
}
