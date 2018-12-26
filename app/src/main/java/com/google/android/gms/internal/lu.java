package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.Fitness;

public interface lu extends com.google.android.gms.common.api.Api.a {

    public static abstract class a<R extends Result> extends com.google.android.gms.common.api.BaseImplementation.a<R, lu> {
        public a(GoogleApiClient googleApiClient) {
            super(Fitness.DQ, googleApiClient);
        }
    }

    public static class b extends com.google.android.gms.internal.md.a {
        private final com.google.android.gms.common.api.BaseImplementation.b<Status> Ea;

        public b(com.google.android.gms.common.api.BaseImplementation.b<Status> bVar) {
            this.Ea = bVar;
        }

        public void j(Status status) {
            this.Ea.b(status);
        }
    }

    public static abstract class c extends a<Status> {
        c(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected Status b(Status status) {
            jx.L(!status.isSuccess());
            return status;
        }

        protected /* synthetic */ Result c(Status status) {
            return b(status);
        }
    }

    Context getContext();

    lz jM() throws DeadObjectException;
}
