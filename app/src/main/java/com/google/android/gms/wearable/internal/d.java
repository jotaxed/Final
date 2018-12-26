package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.BaseImplementation.a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.wearable.Wearable;

abstract class d<R extends Result> extends a<R, ba> {
    public d(GoogleApiClient googleApiClient) {
        super(Wearable.DQ, googleApiClient);
    }
}
