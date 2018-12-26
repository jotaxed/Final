package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.internal.qd.a;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public class qi extends g<qd> {
    private static qi awH;

    protected qi() {
        super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
    }

    public static qa a(Activity activity, c cVar, WalletFragmentOptions walletFragmentOptions, qb qbVar) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (isGooglePlayServicesAvailable != 0) {
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
        try {
            return ((qd) rg().L(activity)).a(e.k(activity), cVar, walletFragmentOptions, qbVar);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    private static qi rg() {
        if (awH == null) {
            awH = new qi();
        }
        return awH;
    }

    protected qd bW(IBinder iBinder) {
        return a.bS(iBinder);
    }

    protected /* synthetic */ Object d(IBinder iBinder) {
        return bW(iBinder);
    }
}
