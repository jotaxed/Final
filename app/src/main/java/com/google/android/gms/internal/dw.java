package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;

@ey
public final class dw extends g<dy> {
    private static final dw sy = new dw();

    private static final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    private dw() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public static dx b(Activity activity) {
        try {
            if (!c(activity)) {
                return sy.d(activity);
            }
            gr.S("Using AdOverlay from the client jar.");
            return new dp(activity);
        } catch (a e) {
            gr.W(e.getMessage());
            return null;
        }
    }

    private static boolean c(Activity activity) throws a {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        throw new a("Ad overlay requires the useClientJar flag in intent extras.");
    }

    private dx d(Activity activity) {
        try {
            return com.google.android.gms.internal.dx.a.r(((dy) L(activity)).b(e.k(activity)));
        } catch (Throwable e) {
            gr.d("Could not create remote AdOverlay.", e);
            return null;
        } catch (Throwable e2) {
            gr.d("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    protected /* synthetic */ Object d(IBinder iBinder) {
        return q(iBinder);
    }

    protected dy q(IBinder iBinder) {
        return com.google.android.gms.internal.dy.a.s(iBinder);
    }
}
