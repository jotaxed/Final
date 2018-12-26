package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.mw;

public final class Address {
    public static final Api<AddressOptions> API = new Api(DR, DQ, new Scope[0]);
    static final c<mw> DQ = new c();
    private static final b<mw, AddressOptions> DR = new b<mw, AddressOptions>() {
        public mw a(Context context, Looper looper, jg jgVar, AddressOptions addressOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            jx.b(context instanceof Activity, (Object) "An Activity must be used for Address APIs");
            if (addressOptions == null) {
                addressOptions = new AddressOptions();
            }
            return new mw((Activity) context, looper, connectionCallbacks, onConnectionFailedListener, jgVar.getAccountName(), addressOptions.theme);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };

    private static abstract class a extends com.google.android.gms.common.api.BaseImplementation.a<Status, mw> {
        public a(GoogleApiClient googleApiClient) {
            super(Address.DQ, googleApiClient);
        }

        public Status b(Status status) {
            return status;
        }

        public /* synthetic */ Result c(Status status) {
            return b(status);
        }
    }

    public static final class AddressOptions implements HasOptions {
        public final int theme;

        public AddressOptions() {
            this.theme = 0;
        }

        public AddressOptions(int theme) {
            this.theme = theme;
        }
    }

    public static void requestUserAddress(GoogleApiClient googleApiClient, final UserAddressRequest request, final int requestCode) {
        googleApiClient.a(new a(googleApiClient) {
            protected void a(mw mwVar) throws RemoteException {
                mwVar.a(request, requestCode);
                b(Status.Kw);
            }
        });
    }
}
