package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet.b;

public class qg implements Payments {
    public void changeMaskedWallet(GoogleApiClient googleApiClient, String googleTransactionId, String merchantTransactionId, int requestCode) {
        final String str = googleTransactionId;
        final String str2 = merchantTransactionId;
        final int i = requestCode;
        googleApiClient.a(new b(this, googleApiClient) {
            final /* synthetic */ qg awA;

            protected void a(qh qhVar) {
                qhVar.d(str, str2, i);
                b(Status.Kw);
            }
        });
    }

    public void checkForPreAuthorization(GoogleApiClient googleApiClient, final int requestCode) {
        googleApiClient.a(new b(this, googleApiClient) {
            final /* synthetic */ qg awA;

            protected void a(qh qhVar) {
                qhVar.gk(requestCode);
                b(Status.Kw);
            }
        });
    }

    public void loadFullWallet(GoogleApiClient googleApiClient, final FullWalletRequest request, final int requestCode) {
        googleApiClient.a(new b(this, googleApiClient) {
            final /* synthetic */ qg awA;

            protected void a(qh qhVar) {
                qhVar.a(request, requestCode);
                b(Status.Kw);
            }
        });
    }

    public void loadMaskedWallet(GoogleApiClient googleApiClient, final MaskedWalletRequest request, final int requestCode) {
        googleApiClient.a(new b(this, googleApiClient) {
            final /* synthetic */ qg awA;

            protected void a(qh qhVar) {
                qhVar.a(request, requestCode);
                b(Status.Kw);
            }
        });
    }

    public void notifyTransactionStatus(GoogleApiClient googleApiClient, final NotifyTransactionStatusRequest request) {
        googleApiClient.a(new b(this, googleApiClient) {
            final /* synthetic */ qg awA;

            protected void a(qh qhVar) {
                qhVar.a(request);
                b(Status.Kw);
            }
        });
    }
}
