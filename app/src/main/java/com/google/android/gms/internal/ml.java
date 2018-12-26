package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.af;
import com.google.android.gms.fitness.request.aj;
import com.google.android.gms.fitness.request.m;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;
import com.google.android.gms.internal.lu.c;

public class ml implements RecordingApi {

    private static class a extends com.google.android.gms.internal.ma.a {
        private final b<ListSubscriptionsResult> Ea;

        private a(b<ListSubscriptionsResult> bVar) {
            this.Ea = bVar;
        }

        public void a(ListSubscriptionsResult listSubscriptionsResult) {
            this.Ea.b(listSubscriptionsResult);
        }
    }

    private PendingResult<ListSubscriptionsResult> a(GoogleApiClient googleApiClient, final m mVar) {
        return googleApiClient.a(new com.google.android.gms.internal.lu.a<ListSubscriptionsResult>(this, googleApiClient) {
            final /* synthetic */ ml Vl;

            protected void a(lu luVar) throws RemoteException {
                luVar.jM().a(mVar, new a(this), luVar.getContext().getPackageName());
            }

            protected /* synthetic */ Result c(Status status) {
                return y(status);
            }

            protected ListSubscriptionsResult y(Status status) {
                return ListSubscriptionsResult.F(status);
            }
        });
    }

    public PendingResult<Status> a(GoogleApiClient googleApiClient, final af afVar) {
        return googleApiClient.a(new c(this, googleApiClient) {
            final /* synthetic */ ml Vl;

            protected void a(lu luVar) throws RemoteException {
                luVar.jM().a(afVar, new lu.b(this), luVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<Status> a(GoogleApiClient googleApiClient, final aj ajVar) {
        return googleApiClient.b(new c(this, googleApiClient) {
            final /* synthetic */ ml Vl;

            protected void a(lu luVar) throws RemoteException {
                luVar.jM().a(ajVar, new lu.b(this), luVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient client) {
        return a(client, new com.google.android.gms.fitness.request.m.a().ka());
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient client, DataType dataType) {
        return a(client, new com.google.android.gms.fitness.request.m.a().c(dataType).ka());
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, DataSource dataSource) {
        return a(client, new com.google.android.gms.fitness.request.af.a().b(new com.google.android.gms.fitness.data.Subscription.a().b(dataSource).jK()).kp());
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, DataType dataType) {
        return a(client, new com.google.android.gms.fitness.request.af.a().b(new com.google.android.gms.fitness.data.Subscription.a().b(dataType).jK()).kp());
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, DataSource dataSource) {
        return a(client, new com.google.android.gms.fitness.request.aj.a().d(dataSource).kq());
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, DataType dataType) {
        return a(client, new com.google.android.gms.fitness.request.aj.a().d(dataType).kq());
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, Subscription subscription) {
        return subscription.getDataType() == null ? unsubscribe(client, subscription.getDataSource()) : unsubscribe(client, subscription.getDataType());
    }
}
