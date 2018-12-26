package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.oy;
import com.google.android.gms.internal.oz;
import com.google.android.gms.internal.pa;
import com.google.android.gms.internal.pb;
import com.google.android.gms.internal.pc;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.e;
import com.google.android.gms.plus.internal.h;
import java.util.HashSet;
import java.util.Set;

public final class Plus {
    public static final Api<PlusOptions> API = new Api(DR, DQ, new Scope[0]);
    public static final Account AccountApi = new oy();
    public static final c<e> DQ = new c();
    static final b<e, PlusOptions> DR = new b<e, PlusOptions>() {
        public e a(Context context, Looper looper, jg jgVar, PlusOptions plusOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (plusOptions == null) {
                plusOptions = new PlusOptions();
            }
            return new e(context, looper, connectionCallbacks, onConnectionFailedListener, new h(jgVar.hm(), jgVar.hp(), (String[]) plusOptions.ans.toArray(new String[0]), new String[0], context.getPackageName(), context.getPackageName(), null, new PlusCommonExtras()));
        }

        public int getPriority() {
            return 2;
        }
    };
    public static final Moments MomentsApi = new pb();
    public static final People PeopleApi = new pc();
    public static final Scope SCOPE_PLUS_LOGIN = new Scope(Scopes.PLUS_LOGIN);
    public static final Scope SCOPE_PLUS_PROFILE = new Scope(Scopes.PLUS_ME);
    public static final b anp = new pa();
    public static final a anq = new oz();

    public static abstract class a<R extends Result> extends com.google.android.gms.common.api.BaseImplementation.a<R, e> {
        public a(GoogleApiClient googleApiClient) {
            super(Plus.DQ, googleApiClient);
        }
    }

    public static final class PlusOptions implements Optional {
        final String anr;
        final Set<String> ans;

        public static final class Builder {
            String anr;
            final Set<String> ans = new HashSet();

            public Builder addActivityTypes(String... activityTypes) {
                jx.b((Object) activityTypes, (Object) "activityTypes may not be null.");
                for (Object add : activityTypes) {
                    this.ans.add(add);
                }
                return this;
            }

            public PlusOptions build() {
                return new PlusOptions();
            }

            public Builder setServerClientId(String clientId) {
                this.anr = clientId;
                return this;
            }
        }

        private PlusOptions() {
            this.anr = null;
            this.ans = new HashSet();
        }

        private PlusOptions(Builder builder) {
            this.anr = builder.anr;
            this.ans = builder.ans;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    private Plus() {
    }

    public static e a(GoogleApiClient googleApiClient, c<e> cVar) {
        boolean z = true;
        jx.b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        jx.a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        e eVar = (e) googleApiClient.a((c) cVar);
        if (eVar == null) {
            z = false;
        }
        jx.a(z, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        return eVar;
    }
}
