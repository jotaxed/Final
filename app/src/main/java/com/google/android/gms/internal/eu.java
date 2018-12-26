package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.ads.purchase.InAppPurchaseResult;

@ey
public class eu implements InAppPurchaseResult {
    private final eq te;

    public eu(eq eqVar) {
        this.te = eqVar;
    }

    public void finishPurchase() {
        try {
            this.te.finishPurchase();
        } catch (Throwable e) {
            gr.d("Could not forward finishPurchase to InAppPurchaseResult", e);
        }
    }

    public String getProductId() {
        try {
            return this.te.getProductId();
        } catch (Throwable e) {
            gr.d("Could not forward getProductId to InAppPurchaseResult", e);
            return null;
        }
    }

    public Intent getPurchaseData() {
        try {
            return this.te.getPurchaseData();
        } catch (Throwable e) {
            gr.d("Could not forward getPurchaseData to InAppPurchaseResult", e);
            return null;
        }
    }

    public int getResultCode() {
        try {
            return this.te.getResultCode();
        } catch (Throwable e) {
            gr.d("Could not forward getPurchaseData to InAppPurchaseResult", e);
            return 0;
        }
    }

    public boolean isVerified() {
        try {
            return this.te.isVerified();
        } catch (Throwable e) {
            gr.d("Could not forward isVerified to InAppPurchaseResult", e);
            return false;
        }
    }
}
