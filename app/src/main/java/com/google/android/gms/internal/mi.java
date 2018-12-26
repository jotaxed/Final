package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.j;
import com.google.android.gms.fitness.result.DataTypeResult;
import com.google.android.gms.internal.lu.c;

public class mi implements ConfigApi {

    private static class a extends com.google.android.gms.internal.ly.a {
        private final b<DataTypeResult> Ea;

        private a(b<DataTypeResult> bVar) {
            this.Ea = bVar;
        }

        public void a(DataTypeResult dataTypeResult) {
            this.Ea.b(dataTypeResult);
        }
    }

    public PendingResult<DataTypeResult> createCustomDataType(GoogleApiClient client, final DataTypeCreateRequest request) {
        return client.b(new com.google.android.gms.internal.lu.a<DataTypeResult>(this, client) {
            final /* synthetic */ mi Vc;

            protected void a(lu luVar) throws RemoteException {
                luVar.jM().a(request, new a(this), luVar.getContext().getPackageName());
            }

            protected /* synthetic */ Result c(Status status) {
                return w(status);
            }

            protected DataTypeResult w(Status status) {
                return DataTypeResult.E(status);
            }
        });
    }

    public PendingResult<Status> disableFit(GoogleApiClient client) {
        return client.b(new c(this, client) {
            final /* synthetic */ mi Vc;

            protected void a(lu luVar) throws RemoteException {
                luVar.jM().a(new lu.b(this), luVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<DataTypeResult> readDataType(GoogleApiClient client, String dataTypeName) {
        final j jVar = new j(dataTypeName);
        return client.a(new com.google.android.gms.internal.lu.a<DataTypeResult>(this, client) {
            final /* synthetic */ mi Vc;

            protected void a(lu luVar) throws RemoteException {
                luVar.jM().a(jVar, new a(this), luVar.getContext().getPackageName());
            }

            protected /* synthetic */ Result c(Status status) {
                return w(status);
            }

            protected DataTypeResult w(Status status) {
                return DataTypeResult.E(status);
            }
        });
    }
}
