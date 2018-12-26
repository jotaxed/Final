package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.bc.a;

@ey
public final class at extends a {
    private final AdListener ob;

    public at(AdListener adListener) {
        this.ob = adListener;
    }

    public void onAdClosed() {
        this.ob.onAdClosed();
    }

    public void onAdFailedToLoad(int errorCode) {
        this.ob.onAdFailedToLoad(errorCode);
    }

    public void onAdLeftApplication() {
        this.ob.onAdLeftApplication();
    }

    public void onAdLoaded() {
        this.ob.onAdLoaded();
    }

    public void onAdOpened() {
        this.ob.onAdOpened();
    }
}
