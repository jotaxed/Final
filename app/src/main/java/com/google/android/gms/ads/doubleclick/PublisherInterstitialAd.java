package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.bi;

public final class PublisherInterstitialAd {
    private final bi lm;

    public PublisherInterstitialAd(Context context) {
        this.lm = new bi(context, this);
    }

    public AdListener getAdListener() {
        return this.lm.getAdListener();
    }

    public String getAdUnitId() {
        return this.lm.getAdUnitId();
    }

    public AppEventListener getAppEventListener() {
        return this.lm.getAppEventListener();
    }

    public String getMediationAdapterClassName() {
        return this.lm.getMediationAdapterClassName();
    }

    public boolean isLoaded() {
        return this.lm.isLoaded();
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        this.lm.a(publisherAdRequest.Y());
    }

    public void setAdListener(AdListener adListener) {
        this.lm.setAdListener(adListener);
    }

    public void setAdUnitId(String adUnitId) {
        this.lm.setAdUnitId(adUnitId);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.lm.setAppEventListener(appEventListener);
    }

    public void show() {
        this.lm.show();
    }
}
