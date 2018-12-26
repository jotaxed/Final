package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

abstract class kf<R extends Result> extends com.google.android.gms.common.api.BaseImplementation.a<R, kg> {

    static abstract class a extends kf<Status> {
        public a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status b(Status status) {
            return status;
        }

        public /* synthetic */ Result c(Status status) {
            return b(status);
        }
    }

    public kf(GoogleApiClient googleApiClient) {
        super(kc.DQ, googleApiClient);
    }
}
