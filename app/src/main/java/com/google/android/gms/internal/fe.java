package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.ff.b;

@ey
public final class fe {

    public interface a {
        void a(fj fjVar);
    }

    public static gf a(Context context, fh fhVar, a aVar) {
        return fhVar.lO.wV ? b(context, fhVar, aVar) : c(context, fhVar, aVar);
    }

    private static gf b(Context context, fh fhVar, a aVar) {
        gr.S("Fetching ad response from local ad request service.");
        gf aVar2 = new com.google.android.gms.internal.ff.a(context, fhVar, aVar);
        aVar2.start();
        return aVar2;
    }

    private static gf c(Context context, fh fhVar, a aVar) {
        gr.S("Fetching ad response from remote ad request service.");
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            return new b(context, fhVar, aVar);
        }
        gr.W("Failed to connect to remote ad request service.");
        return null;
    }
}
