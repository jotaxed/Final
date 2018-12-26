package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.nb;
import com.google.android.gms.internal.nk;

public class ActivityRecognition {
    public static final Api<NoOptions> API = new Api(DR, DQ, new Scope[0]);
    public static ActivityRecognitionApi ActivityRecognitionApi = new nb();
    public static final String CLIENT_NAME = "activity_recognition";
    private static final c<nk> DQ = new c();
    private static final b<nk, NoOptions> DR = new b<nk, NoOptions>() {
        public /* synthetic */ com.google.android.gms.common.api.Api.a a(Context context, Looper looper, jg jgVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return e(context, looper, jgVar, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public nk e(Context context, Looper looper, jg jgVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new nk(context, looper, context.getPackageName(), connectionCallbacks, onConnectionFailedListener, ActivityRecognition.CLIENT_NAME);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };

    public static abstract class a<R extends Result> extends com.google.android.gms.common.api.BaseImplementation.a<R, nk> {
        public a(GoogleApiClient googleApiClient) {
            super(ActivityRecognition.DQ, googleApiClient);
        }
    }

    private ActivityRecognition() {
    }
}
