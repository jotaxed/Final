package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.a;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;

public final class kc {
    public static final Api<NoOptions> API = new Api(DR, DQ, new Scope[0]);
    public static final c<kg> DQ = new c();
    private static final b<kg, NoOptions> DR = new b<kg, NoOptions>() {
        public /* synthetic */ a a(Context context, Looper looper, jg jgVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return c(context, looper, jgVar, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public kg c(Context context, Looper looper, jg jgVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new kg(context, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };
    public static final kd Nu = new ke();
}
