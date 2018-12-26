package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.plus.PlusOneDummyView;
import com.google.android.gms.plus.internal.c.a;

public final class g extends com.google.android.gms.dynamic.g<c> {
    private static final g anP = new g();

    private g() {
        super("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl");
    }

    public static View a(Context context, int i, int i2, String str, int i3) {
        if (str != null) {
            return (View) e.f(((c) anP.L(context)).a(e.k(context), i, i2, str, i3));
        }
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            return new PlusOneDummyView(context, i);
        }
    }

    protected c bO(IBinder iBinder) {
        return a.bL(iBinder);
    }

    protected /* synthetic */ Object d(IBinder iBinder) {
        return bO(iBinder);
    }
}
