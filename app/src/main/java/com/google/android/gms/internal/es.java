package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.en.a;

@ey
public final class es extends a {
    private final InAppPurchaseListener oM;

    public es(InAppPurchaseListener inAppPurchaseListener) {
        this.oM = inAppPurchaseListener;
    }

    public void a(em emVar) {
        this.oM.onInAppPurchaseRequested(new ev(emVar));
    }
}
