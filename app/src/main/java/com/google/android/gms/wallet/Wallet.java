package com.google.android.gms.wallet;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.pv;
import com.google.android.gms.internal.qg;
import com.google.android.gms.internal.qh;
import com.google.android.gms.internal.qj;
import com.google.android.gms.internal.qk;
import com.google.android.gms.wallet.wobs.r;
import java.util.Locale;

public final class Wallet {
    public static final Api<WalletOptions> API = new Api(DR, DQ, new Scope[0]);
    private static final c<qh> DQ = new c();
    private static final com.google.android.gms.common.api.Api.b<qh, WalletOptions> DR = new com.google.android.gms.common.api.Api.b<qh, WalletOptions>() {
        public qh a(Context context, Looper looper, jg jgVar, WalletOptions walletOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            jx.b(context instanceof Activity, (Object) "An Activity must be used for Wallet APIs");
            Activity activity = (Activity) context;
            if (walletOptions == null) {
                walletOptions = new WalletOptions();
            }
            return new qh(activity, looper, connectionCallbacks, onConnectionFailedListener, walletOptions.environment, jgVar.getAccountName(), walletOptions.theme);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };
    public static final Payments Payments = new qg();
    public static final r avT = new qk();
    public static final pv avU = new qj();

    public static abstract class a<R extends Result> extends com.google.android.gms.common.api.BaseImplementation.a<R, qh> {
        public a(GoogleApiClient googleApiClient) {
            super(Wallet.DQ, googleApiClient);
        }
    }

    public static abstract class b extends a<Status> {
        public b(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected Status b(Status status) {
            return status;
        }

        protected /* synthetic */ Result c(Status status) {
            return b(status);
        }
    }

    public static final class WalletOptions implements HasOptions {
        public final int environment;
        public final int theme;

        public static final class Builder {
            private int avV = 0;
            private int mTheme = 0;

            public WalletOptions build() {
                return new WalletOptions();
            }

            public Builder setEnvironment(int environment) {
                if (environment == 0 || environment == 2 || environment == 1) {
                    this.avV = environment;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", new Object[]{Integer.valueOf(environment)}));
            }

            public Builder setTheme(int theme) {
                if (theme == 0 || theme == 1) {
                    this.mTheme = theme;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", new Object[]{Integer.valueOf(theme)}));
            }
        }

        private WalletOptions() {
            this(new Builder());
        }

        private WalletOptions(Builder builder) {
            this.environment = builder.avV;
            this.theme = builder.mTheme;
        }
    }

    private Wallet() {
    }

    @Deprecated
    public static void changeMaskedWallet(GoogleApiClient googleApiClient, String googleTransactionId, String merchantTransactionId, int requestCode) {
        Payments.changeMaskedWallet(googleApiClient, googleTransactionId, merchantTransactionId, requestCode);
    }

    @Deprecated
    public static void checkForPreAuthorization(GoogleApiClient googleApiClient, int requestCode) {
        Payments.checkForPreAuthorization(googleApiClient, requestCode);
    }

    @Deprecated
    public static void loadFullWallet(GoogleApiClient googleApiClient, FullWalletRequest request, int requestCode) {
        Payments.loadFullWallet(googleApiClient, request, requestCode);
    }

    @Deprecated
    public static void loadMaskedWallet(GoogleApiClient googleApiClient, MaskedWalletRequest request, int requestCode) {
        Payments.loadMaskedWallet(googleApiClient, request, requestCode);
    }

    @Deprecated
    public static void notifyTransactionStatus(GoogleApiClient googleApiClient, NotifyTransactionStatusRequest request) {
        Payments.notifyTransactionStatus(googleApiClient, request);
    }
}
