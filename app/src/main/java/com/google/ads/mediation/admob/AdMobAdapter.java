package com.google.ads.mediation.admob;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.gq;
import java.util.Date;
import java.util.Set;

public final class AdMobAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
    private AdView i;
    private InterstitialAd j;

    private static final class a extends AdListener {
        private final AdMobAdapter k;
        private final MediationBannerListener l;

        public a(AdMobAdapter adMobAdapter, MediationBannerListener mediationBannerListener) {
            this.k = adMobAdapter;
            this.l = mediationBannerListener;
        }

        public void onAdClosed() {
            this.l.onAdClosed(this.k);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.l.onAdFailedToLoad(this.k, errorCode);
        }

        public void onAdLeftApplication() {
            this.l.onAdLeftApplication(this.k);
        }

        public void onAdLoaded() {
            this.l.onAdLoaded(this.k);
        }

        public void onAdOpened() {
            this.l.onAdClicked(this.k);
            this.l.onAdOpened(this.k);
        }
    }

    private static final class b extends AdListener {
        private final AdMobAdapter k;
        private final MediationInterstitialListener m;

        public b(AdMobAdapter adMobAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.k = adMobAdapter;
            this.m = mediationInterstitialListener;
        }

        public void onAdClosed() {
            this.m.onAdClosed(this.k);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.m.onAdFailedToLoad(this.k, errorCode);
        }

        public void onAdLeftApplication() {
            this.m.onAdLeftApplication(this.k);
        }

        public void onAdLoaded() {
            this.m.onAdLoaded(this.k);
        }

        public void onAdOpened() {
            this.m.onAdOpened(this.k);
        }
    }

    static AdRequest a(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        Builder builder = new Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            builder.setLocation(location);
        }
        if (mediationAdRequest.isTesting()) {
            builder.addTestDevice(gq.v(context));
        }
        if (bundle2.getInt("tagForChildDirectedTreatment") != -1) {
            builder.tagForChildDirectedTreatment(bundle2.getInt("tagForChildDirectedTreatment") == 1);
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("gw", 1);
        bundle.putString("mad_hac", bundle2.getString("mad_hac"));
        if (!TextUtils.isEmpty(bundle2.getString("adJson"))) {
            bundle.putString("_ad", bundle2.getString("adJson"));
        }
        bundle.putBoolean("_noRefresh", true);
        builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        return builder.build();
    }

    public View getBannerView() {
        return this.i;
    }

    public void onDestroy() {
        if (this.i != null) {
            this.i.destroy();
            this.i = null;
        }
        if (this.j != null) {
            this.j = null;
        }
    }

    public void onPause() {
        if (this.i != null) {
            this.i.pause();
        }
    }

    public void onResume() {
        if (this.i != null) {
            this.i.resume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener bannerListener, Bundle serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle extras) {
        this.i = new AdView(context);
        this.i.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.i.setAdUnitId(serverParameters.getString("pubid"));
        this.i.setAdListener(new a(this, bannerListener));
        this.i.loadAd(a(context, mediationAdRequest, extras, serverParameters));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener interstitialListener, Bundle serverParameters, MediationAdRequest mediationAdRequest, Bundle extras) {
        this.j = new InterstitialAd(context);
        this.j.setAdUnitId(serverParameters.getString("pubid"));
        this.j.setAdListener(new b(this, interstitialListener));
        this.j.loadAd(a(context, mediationAdRequest, extras, serverParameters));
    }

    public void showInterstitial() {
        this.j.show();
    }
}
