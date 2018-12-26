package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.k;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.o;
import com.google.android.gms.fitness.request.q;
import com.google.android.gms.fitness.result.DataSourcesResult;

public class mm implements SensorsApi {

    private static abstract class a<R extends Result> extends com.google.android.gms.common.api.BaseImplementation.a<R, lu> {
        public a(GoogleApiClient googleApiClient) {
            super(Fitness.DQ, googleApiClient);
        }
    }

    private interface b {
        void jO();
    }

    private static class c extends com.google.android.gms.internal.lx.a {
        private final com.google.android.gms.common.api.BaseImplementation.b<DataSourcesResult> Ea;

        private c(com.google.android.gms.common.api.BaseImplementation.b<DataSourcesResult> bVar) {
            this.Ea = bVar;
        }

        public void a(DataSourcesResult dataSourcesResult) {
            this.Ea.b(dataSourcesResult);
        }
    }

    private static class d extends com.google.android.gms.internal.md.a {
        private final com.google.android.gms.common.api.BaseImplementation.b<Status> Ea;
        private final b Vu;

        private d(com.google.android.gms.common.api.BaseImplementation.b<Status> bVar, b bVar2) {
            this.Ea = bVar;
            this.Vu = bVar2;
        }

        public void j(Status status) {
            if (this.Vu != null && status.isSuccess()) {
                this.Vu.jO();
            }
            this.Ea.b(status);
        }
    }

    private PendingResult<Status> a(GoogleApiClient googleApiClient, final o oVar) {
        return googleApiClient.a(new a<Status>(this, googleApiClient) {
            final /* synthetic */ mm Vp;

            protected void a(lu luVar) throws RemoteException {
                luVar.jM().a(oVar, new com.google.android.gms.internal.lu.b(this), luVar.getContext().getPackageName());
            }

            protected Status b(Status status) {
                return status;
            }

            protected /* synthetic */ Result c(Status status) {
                return b(status);
            }
        });
    }

    private PendingResult<Status> a(GoogleApiClient googleApiClient, final q qVar, final b bVar) {
        return googleApiClient.b(new a<Status>(this, googleApiClient) {
            final /* synthetic */ mm Vp;

            protected void a(lu luVar) throws RemoteException {
                luVar.jM().a(qVar, new d(this, bVar), luVar.getContext().getPackageName());
            }

            protected Status b(Status status) {
                return status;
            }

            protected /* synthetic */ Result c(Status status) {
                return b(status);
            }
        });
    }

    public PendingResult<Status> add(GoogleApiClient client, SensorRequest request, PendingIntent intent) {
        return a(client, new o(request, null, intent));
    }

    public PendingResult<Status> add(GoogleApiClient client, SensorRequest request, OnDataPointListener listener) {
        return a(client, new o(request, com.google.android.gms.fitness.data.l.a.jG().a(listener), null));
    }

    public PendingResult<DataSourcesResult> findDataSources(GoogleApiClient client, final DataSourcesRequest request) {
        return client.a(new a<DataSourcesResult>(this, client) {
            final /* synthetic */ mm Vp;

            protected void a(lu luVar) throws RemoteException {
                luVar.jM().a(request, new c(this), luVar.getContext().getPackageName());
            }

            protected /* synthetic */ Result c(Status status) {
                return z(status);
            }

            protected DataSourcesResult z(Status status) {
                return DataSourcesResult.D(status);
            }
        });
    }

    public PendingResult<Status> remove(GoogleApiClient client, PendingIntent pendingIntent) {
        return a(client, new q(null, pendingIntent), null);
    }

    public PendingResult<Status> remove(GoogleApiClient client, final OnDataPointListener listener) {
        k b = com.google.android.gms.fitness.data.l.a.jG().b(listener);
        return b == null ? new me(Status.Kw) : a(client, new q(b, null), new b(this) {
            final /* synthetic */ mm Vp;

            public void jO() {
                com.google.android.gms.fitness.data.l.a.jG().c(listener);
            }
        });
    }
}
