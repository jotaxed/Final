package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DataReadResult;
import com.google.android.gms.internal.lu.c;

public class mj implements HistoryApi {

    private static class a extends com.google.android.gms.internal.lw.a {
        private final b<DataReadResult> Ea;
        private int Vi;
        private DataReadResult Vj;

        private a(b<DataReadResult> bVar) {
            this.Vi = 0;
            this.Vj = null;
            this.Ea = bVar;
        }

        public void a(DataReadResult dataReadResult) {
            synchronized (this) {
                Log.v("Fitness", "Received batch result");
                if (this.Vj == null) {
                    this.Vj = dataReadResult;
                } else {
                    this.Vj.b(dataReadResult);
                }
                this.Vi++;
                if (this.Vi == this.Vj.kr()) {
                    this.Ea.b(this.Vj);
                }
            }
        }
    }

    public PendingResult<Status> deleteData(GoogleApiClient client, final DataDeleteRequest request) {
        return client.a(new c(this, client) {
            final /* synthetic */ mj Vf;

            protected void a(lu luVar) throws RemoteException {
                luVar.jM().a(request, new lu.b(this), luVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<Status> insertData(GoogleApiClient client, final DataSet dataSet) {
        return client.a(new c(this, client) {
            final /* synthetic */ mj Vf;

            protected void a(lu luVar) throws RemoteException {
                luVar.jM().a(new com.google.android.gms.fitness.request.e.a().b(dataSet).jU(), new lu.b(this), luVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<DataReadResult> readData(GoogleApiClient client, final DataReadRequest request) {
        return client.a(new com.google.android.gms.internal.lu.a<DataReadResult>(this, client) {
            final /* synthetic */ mj Vf;

            protected void a(lu luVar) throws RemoteException {
                luVar.jM().a(request, new a(this), luVar.getContext().getPackageName());
            }

            protected /* synthetic */ Result c(Status status) {
                return x(status);
            }

            protected DataReadResult x(Status status) {
                return DataReadResult.a(status, request);
            }
        });
    }
}
