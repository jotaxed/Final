package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

@ey
public final class df<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final da qW;

    public df(da daVar) {
        this.qW = daVar;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        gr.S("Adapter called onClick.");
        if (gq.dB()) {
            try {
                this.qW.onAdClicked();
                return;
            } catch (Throwable e) {
                gr.d("Could not call onAdClicked.", e);
                return;
            }
        }
        gr.W("onClick must be called on the main UI thread.");
        gq.wR.post(new Runnable(this) {
            final /* synthetic */ df qZ;

            {
                this.qZ = r1;
            }

            public void run() {
                try {
                    this.qZ.qW.onAdClicked();
                } catch (Throwable e) {
                    gr.d("Could not call onAdClicked.", e);
                }
            }
        });
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        gr.S("Adapter called onDismissScreen.");
        if (gq.dB()) {
            try {
                this.qW.onAdClosed();
                return;
            } catch (Throwable e) {
                gr.d("Could not call onAdClosed.", e);
                return;
            }
        }
        gr.W("onDismissScreen must be called on the main UI thread.");
        gq.wR.post(new Runnable(this) {
            final /* synthetic */ df qZ;

            {
                this.qZ = r1;
            }

            public void run() {
                try {
                    this.qZ.qW.onAdClosed();
                } catch (Throwable e) {
                    gr.d("Could not call onAdClosed.", e);
                }
            }
        });
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        gr.S("Adapter called onDismissScreen.");
        if (gq.dB()) {
            try {
                this.qW.onAdClosed();
                return;
            } catch (Throwable e) {
                gr.d("Could not call onAdClosed.", e);
                return;
            }
        }
        gr.W("onDismissScreen must be called on the main UI thread.");
        gq.wR.post(new Runnable(this) {
            final /* synthetic */ df qZ;

            {
                this.qZ = r1;
            }

            public void run() {
                try {
                    this.qZ.qW.onAdClosed();
                } catch (Throwable e) {
                    gr.d("Could not call onAdClosed.", e);
                }
            }
        });
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, final ErrorCode errorCode) {
        gr.S("Adapter called onFailedToReceiveAd with error. " + errorCode);
        if (gq.dB()) {
            try {
                this.qW.onAdFailedToLoad(dg.a(errorCode));
                return;
            } catch (Throwable e) {
                gr.d("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        gr.W("onFailedToReceiveAd must be called on the main UI thread.");
        gq.wR.post(new Runnable(this) {
            final /* synthetic */ df qZ;

            public void run() {
                try {
                    this.qZ.qW.onAdFailedToLoad(dg.a(errorCode));
                } catch (Throwable e) {
                    gr.d("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, final ErrorCode errorCode) {
        gr.S("Adapter called onFailedToReceiveAd with error " + errorCode + ".");
        if (gq.dB()) {
            try {
                this.qW.onAdFailedToLoad(dg.a(errorCode));
                return;
            } catch (Throwable e) {
                gr.d("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        gr.W("onFailedToReceiveAd must be called on the main UI thread.");
        gq.wR.post(new Runnable(this) {
            final /* synthetic */ df qZ;

            public void run() {
                try {
                    this.qZ.qW.onAdFailedToLoad(dg.a(errorCode));
                } catch (Throwable e) {
                    gr.d("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        gr.S("Adapter called onLeaveApplication.");
        if (gq.dB()) {
            try {
                this.qW.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                gr.d("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        gr.W("onLeaveApplication must be called on the main UI thread.");
        gq.wR.post(new Runnable(this) {
            final /* synthetic */ df qZ;

            {
                this.qZ = r1;
            }

            public void run() {
                try {
                    this.qZ.qW.onAdLeftApplication();
                } catch (Throwable e) {
                    gr.d("Could not call onAdLeftApplication.", e);
                }
            }
        });
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        gr.S("Adapter called onLeaveApplication.");
        if (gq.dB()) {
            try {
                this.qW.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                gr.d("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        gr.W("onLeaveApplication must be called on the main UI thread.");
        gq.wR.post(new Runnable(this) {
            final /* synthetic */ df qZ;

            {
                this.qZ = r1;
            }

            public void run() {
                try {
                    this.qZ.qW.onAdLeftApplication();
                } catch (Throwable e) {
                    gr.d("Could not call onAdLeftApplication.", e);
                }
            }
        });
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        gr.S("Adapter called onPresentScreen.");
        if (gq.dB()) {
            try {
                this.qW.onAdOpened();
                return;
            } catch (Throwable e) {
                gr.d("Could not call onAdOpened.", e);
                return;
            }
        }
        gr.W("onPresentScreen must be called on the main UI thread.");
        gq.wR.post(new Runnable(this) {
            final /* synthetic */ df qZ;

            {
                this.qZ = r1;
            }

            public void run() {
                try {
                    this.qZ.qW.onAdOpened();
                } catch (Throwable e) {
                    gr.d("Could not call onAdOpened.", e);
                }
            }
        });
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        gr.S("Adapter called onPresentScreen.");
        if (gq.dB()) {
            try {
                this.qW.onAdOpened();
                return;
            } catch (Throwable e) {
                gr.d("Could not call onAdOpened.", e);
                return;
            }
        }
        gr.W("onPresentScreen must be called on the main UI thread.");
        gq.wR.post(new Runnable(this) {
            final /* synthetic */ df qZ;

            {
                this.qZ = r1;
            }

            public void run() {
                try {
                    this.qZ.qW.onAdOpened();
                } catch (Throwable e) {
                    gr.d("Could not call onAdOpened.", e);
                }
            }
        });
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        gr.S("Adapter called onReceivedAd.");
        if (gq.dB()) {
            try {
                this.qW.onAdLoaded();
                return;
            } catch (Throwable e) {
                gr.d("Could not call onAdLoaded.", e);
                return;
            }
        }
        gr.W("onReceivedAd must be called on the main UI thread.");
        gq.wR.post(new Runnable(this) {
            final /* synthetic */ df qZ;

            {
                this.qZ = r1;
            }

            public void run() {
                try {
                    this.qZ.qW.onAdLoaded();
                } catch (Throwable e) {
                    gr.d("Could not call onAdLoaded.", e);
                }
            }
        });
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        gr.S("Adapter called onReceivedAd.");
        if (gq.dB()) {
            try {
                this.qW.onAdLoaded();
                return;
            } catch (Throwable e) {
                gr.d("Could not call onAdLoaded.", e);
                return;
            }
        }
        gr.W("onReceivedAd must be called on the main UI thread.");
        gq.wR.post(new Runnable(this) {
            final /* synthetic */ df qZ;

            {
                this.qZ = r1;
            }

            public void run() {
                try {
                    this.qZ.qW.onAdLoaded();
                } catch (Throwable e) {
                    gr.d("Could not call onAdLoaded.", e);
                }
            }
        });
    }
}
