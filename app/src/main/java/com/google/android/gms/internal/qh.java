package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.jl.e;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.WalletConstants;

public class qh extends jl<qc> {
    private final String DZ;
    private final int avV;
    private final int mTheme;
    private final Activity nB;

    private static class a extends com.google.android.gms.internal.qf.a {
        private a() {
        }

        public void a(int i, FullWallet fullWallet, Bundle bundle) {
        }

        public void a(int i, MaskedWallet maskedWallet, Bundle bundle) {
        }

        public void a(int i, boolean z, Bundle bundle) {
        }

        public void a(Status status, py pyVar, Bundle bundle) {
        }

        public void i(int i, Bundle bundle) {
        }
    }

    final class b extends a {
        private final int My;
        final /* synthetic */ qh awG;

        public b(qh qhVar, int i) {
            this.awG = qhVar;
            super();
            this.My = i;
        }

        public void a(int i, FullWallet fullWallet, Bundle bundle) {
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.awG.nB, this.My);
                    return;
                } catch (Throwable e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            int i2;
            Intent intent = new Intent();
            if (connectionResult.isSuccess()) {
                i2 = -1;
                intent.putExtra(WalletConstants.EXTRA_FULL_WALLET, fullWallet);
            } else {
                i2 = i == 408 ? 0 : 1;
                intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
            }
            PendingIntent createPendingResult = this.awG.nB.createPendingResult(this.My, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onFullWalletLoaded");
                return;
            }
            try {
                createPendingResult.send(i2);
            } catch (Throwable e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }

        public void a(int i, MaskedWallet maskedWallet, Bundle bundle) {
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.awG.nB, this.My);
                    return;
                } catch (Throwable e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            int i2;
            Intent intent = new Intent();
            if (connectionResult.isSuccess()) {
                i2 = -1;
                intent.putExtra(WalletConstants.EXTRA_MASKED_WALLET, maskedWallet);
            } else {
                i2 = i == 408 ? 0 : 1;
                intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
            }
            PendingIntent createPendingResult = this.awG.nB.createPendingResult(this.My, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onMaskedWalletLoaded");
                return;
            }
            try {
                createPendingResult.send(i2);
            } catch (Throwable e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }

        public void a(int i, boolean z, Bundle bundle) {
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_IS_USER_PREAUTHORIZED, z);
            PendingIntent createPendingResult = this.awG.nB.createPendingResult(this.My, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onPreAuthorizationDetermined");
                return;
            }
            try {
                createPendingResult.send(-1);
            } catch (Throwable e) {
                Log.w("WalletClientImpl", "Exception setting pending result", e);
            }
        }

        public void i(int i, Bundle bundle) {
            jx.b((Object) bundle, (Object) "Bundle should not be null");
            ConnectionResult connectionResult = new ConnectionResult(i, (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT"));
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.awG.nB, this.My);
                    return;
                } catch (Throwable e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            Log.e("WalletClientImpl", "Create Wallet Objects confirmation UI will not be shown connection result: " + connectionResult);
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, WalletConstants.ERROR_CODE_UNKNOWN);
            PendingIntent createPendingResult = this.awG.nB.createPendingResult(this.My, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onWalletObjectsCreated");
                return;
            }
            try {
                createPendingResult.send(1);
            } catch (Throwable e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }
    }

    public qh(Activity activity, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, int i, String str, int i2) {
        super(activity, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.nB = activity;
        this.avV = i;
        this.DZ = str;
        this.mTheme = i2;
    }

    public static Bundle a(int i, String str, String str2, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", i);
        bundle.putString("androidPackageName", str);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(str2, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
        }
        bundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", i2);
        return bundle;
    }

    private Bundle rf() {
        return a(this.avV, this.nB.getPackageName(), this.DZ, this.mTheme);
    }

    protected void a(jt jtVar, e eVar) throws RemoteException {
        jtVar.k(eVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName());
    }

    public void a(FullWalletRequest fullWalletRequest, int i) {
        qf bVar = new b(this, i);
        try {
            ((qc) hw()).a(fullWalletRequest, rf(), bVar);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException getting full wallet", e);
            bVar.a(8, null, Bundle.EMPTY);
        }
    }

    public void a(MaskedWalletRequest maskedWalletRequest, int i) {
        Bundle rf = rf();
        qf bVar = new b(this, i);
        try {
            ((qc) hw()).a(maskedWalletRequest, rf, bVar);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException getting masked wallet", e);
            bVar.a(8, null, Bundle.EMPTY);
        }
    }

    public void a(NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        try {
            ((qc) hw()).a(notifyTransactionStatusRequest, rf());
        } catch (RemoteException e) {
        }
    }

    protected String bK() {
        return "com.google.android.gms.wallet.service.BIND";
    }

    protected String bL() {
        return "com.google.android.gms.wallet.internal.IOwService";
    }

    protected qc bV(IBinder iBinder) {
        return com.google.android.gms.internal.qc.a.bR(iBinder);
    }

    public void d(String str, String str2, int i) {
        Bundle rf = rf();
        Object bVar = new b(this, i);
        try {
            ((qc) hw()).a(str, str2, rf, bVar);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException changing masked wallet", e);
            bVar.a(8, null, Bundle.EMPTY);
        }
    }

    public void gk(int i) {
        Bundle rf = rf();
        qf bVar = new b(this, i);
        try {
            ((qc) hw()).a(rf, bVar);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", e);
            bVar.a(8, false, Bundle.EMPTY);
        }
    }

    protected /* synthetic */ IInterface l(IBinder iBinder) {
        return bV(iBinder);
    }
}
