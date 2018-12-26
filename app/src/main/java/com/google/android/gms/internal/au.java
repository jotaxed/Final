package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.internal.bd.a;

@ey
public final class au extends g<be> {
    private static final au oc = new au();

    private au() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public static bd a(Context context, ay ayVar, String str, cx cxVar) {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            bd b = oc.b(context, ayVar, str, cxVar);
            if (b != null) {
                return b;
            }
        }
        gr.S("Using AdManager from the client jar.");
        return new u(context, ayVar, str, cxVar, new gs(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, true));
    }

    private bd b(Context context, ay ayVar, String str, cx cxVar) {
        try {
            return a.f(((be) L(context)).a(e.k(context), ayVar, str, cxVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE));
        } catch (Throwable e) {
            gr.d("Could not create remote AdManager.", e);
            return null;
        } catch (Throwable e2) {
            gr.d("Could not create remote AdManager.", e2);
            return null;
        }
    }

    protected be c(IBinder iBinder) {
        return be.a.g(iBinder);
    }

    protected /* synthetic */ Object d(IBinder iBinder) {
        return c(iBinder);
    }
}
