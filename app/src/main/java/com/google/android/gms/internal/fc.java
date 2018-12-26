package com.google.android.gms.internal;

import android.content.Context;

@ey
public final class fc {

    public interface a {
        void a(fy fyVar);
    }

    public static gf a(Context context, u uVar, com.google.android.gms.internal.fy.a aVar, gu guVar, cy cyVar, a aVar2) {
        gf fmVar;
        if (aVar.vK.ug) {
            fmVar = new fm(context, uVar, new ai(), aVar, aVar2);
        } else {
            fmVar = new fd(context, aVar, guVar, cyVar, aVar2);
        }
        fmVar.start();
        return fmVar;
    }
}
