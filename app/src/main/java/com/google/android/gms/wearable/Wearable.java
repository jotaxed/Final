package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.jg;
import com.google.android.gms.wearable.internal.ah;
import com.google.android.gms.wearable.internal.ak;
import com.google.android.gms.wearable.internal.ay;
import com.google.android.gms.wearable.internal.ba;
import com.google.android.gms.wearable.internal.e;
import com.google.android.gms.wearable.internal.f;

public class Wearable {
    public static final Api<WearableOptions> API = new Api(DR, DQ, new Scope[0]);
    public static final c<ba> DQ = new c();
    private static final b<ba, WearableOptions> DR = new b<ba, WearableOptions>() {
        public ba a(Context context, Looper looper, jg jgVar, WearableOptions wearableOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (wearableOptions == null) {
                WearableOptions wearableOptions2 = new WearableOptions(new Builder());
            }
            return new ba(context, looper, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };
    public static final DataApi DataApi = new f();
    public static final MessageApi MessageApi = new ah();
    public static final NodeApi NodeApi = new ak();
    public static final b axl = new e();
    public static final f axm = new ay();

    public static final class WearableOptions implements Optional {

        public static class Builder {
            public WearableOptions build() {
                return new WearableOptions();
            }
        }

        private WearableOptions(Builder builder) {
        }
    }

    private Wearable() {
    }
}
