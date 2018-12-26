package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.dynamic.e;

@ey
public final class ea implements SafeParcelable {
    public static final dz CREATOR = new dz();
    public final ek md;
    public final Context sA;
    public final ej sB;
    public final em sz;
    public final int versionCode;

    ea(int i, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4) {
        this.versionCode = i;
        this.md = (ek) e.f(a.ap(iBinder));
        this.sz = (em) e.f(a.ap(iBinder2));
        this.sA = (Context) e.f(a.ap(iBinder3));
        this.sB = (ej) e.f(a.ap(iBinder4));
    }

    public ea(Context context, ek ekVar, em emVar, ej ejVar) {
        this.versionCode = 2;
        this.sA = context;
        this.md = ekVar;
        this.sz = emVar;
        this.sB = ejVar;
    }

    public static void a(Intent intent, ea eaVar) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", eaVar);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", bundle);
    }

    public static ea c(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            bundleExtra.setClassLoader(ea.class.getClassLoader());
            return (ea) bundleExtra.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
        } catch (Exception e) {
            return null;
        }
    }

    IBinder ct() {
        return e.k(this.sB).asBinder();
    }

    IBinder cu() {
        return e.k(this.md).asBinder();
    }

    IBinder cv() {
        return e.k(this.sz).asBinder();
    }

    IBinder cw() {
        return e.k(this.sA).asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        dz.a(this, out, flags);
    }
}
