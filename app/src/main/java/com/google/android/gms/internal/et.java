package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;

@ey
public final class et extends g<ep> {
    private static final et td = new et();

    private static final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    private et() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    private static boolean c(Activity activity) throws a {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
        }
        throw new a("InAppPurchaseManager requires the useClientJar flag in intent extras.");
    }

    public static eo e(Activity activity) {
        try {
            if (!c(activity)) {
                return td.f(activity);
            }
            gr.S("Using AdOverlay from the client jar.");
            return new ee(activity);
        } catch (a e) {
            gr.W(e.getMessage());
            return null;
        }
    }

    private eo f(Activity activity) {
        try {
            return com.google.android.gms.internal.eo.a.w(((ep) L(activity)).c(e.k(activity)));
        } catch (Throwable e) {
            gr.d("Could not create remote InAppPurchaseManager.", e);
            return null;
        } catch (Throwable e2) {
            gr.d("Could not create remote InAppPurchaseManager.", e2);
            return null;
        }
    }

    protected ep A(IBinder iBinder) {
        return com.google.android.gms.internal.ep.a.x(iBinder);
    }

    protected /* synthetic */ Object d(IBinder iBinder) {
        return A(iBinder);
    }
}
