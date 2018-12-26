package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchase;

@ey
public class ev implements InAppPurchase {
    private final em sP;

    public ev(em emVar) {
        this.sP = emVar;
    }

    public String getProductId() {
        try {
            return this.sP.getProductId();
        } catch (Throwable e) {
            gr.d("Could not forward getProductId to InAppPurchase", e);
            return null;
        }
    }

    public void recordPlayBillingResolution(int billingResponseCode) {
        try {
            this.sP.recordPlayBillingResolution(billingResponseCode);
        } catch (Throwable e) {
            gr.d("Could not forward recordPlayBillingResolution to InAppPurchase", e);
        }
    }

    public void recordResolution(int resolution) {
        try {
            this.sP.recordResolution(resolution);
        } catch (Throwable e) {
            gr.d("Could not forward recordResolution to InAppPurchase", e);
        }
    }
}
