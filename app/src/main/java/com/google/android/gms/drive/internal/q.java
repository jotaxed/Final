package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;

abstract class q<R extends Result> extends com.google.android.gms.common.api.BaseImplementation.a<R, r> {

    static abstract class a extends q<Status> {
        a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected Status b(Status status) {
            return status;
        }

        protected /* synthetic */ Result c(Status status) {
            return b(status);
        }
    }

    public q(GoogleApiClient googleApiClient) {
        super(Drive.DQ, googleApiClient);
    }
}
