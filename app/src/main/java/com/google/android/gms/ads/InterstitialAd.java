package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.bi;

public final class InterstitialAd {
    private final bi lm;

    public InterstitialAd(Context context) {
        this.lm = new bi(context);
    }

    public AdListener getAdListener() {
        return this.lm.getAdListener();
    }

    public String getAdUnitId() {
        return this.lm.getAdUnitId();
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.lm.getInAppPurchaseListener();
    }

    public String getMediationAdapterClassName() {
        return this.lm.getMediationAdapterClassName();
    }

    public boolean isLoaded() {
        return this.lm.isLoaded();
    }

    public void loadAd(AdRequest adRequest) {
        this.lm.a(adRequest.Y());
    }

    public void setAdListener(AdListener adListener) {
        this.lm.setAdListener(adListener);
    }

    public void setAdUnitId(String adUnitId) {
        this.lm.setAdUnitId(adUnitId);
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        this.lm.setInAppPurchaseListener(inAppPurchaseListener);
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String publicKey) {
        this.lm.setPlayStorePurchaseParams(playStorePurchaseListener, publicKey);
    }

    public void show() {
        this.lm.show();
    }
}
