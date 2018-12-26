package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.internal.cz.a;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

@ey
public final class dc extends a {
    private final MediationAdapter qV;

    public dc(MediationAdapter mediationAdapter) {
        this.qV = mediationAdapter;
    }

    private Bundle a(String str, int i, String str2) throws RemoteException {
        gr.W("Server parameters: " + str);
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    bundle2.putString(str3, jSONObject.getString(str3));
                }
                bundle = bundle2;
            }
            if (this.qV instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                bundle.putInt("tagForChildDirectedTreatment", i);
            }
            return bundle;
        } catch (Throwable th) {
            gr.d("Could not get Server Parameters Bundle.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void a(d dVar, av avVar, String str, da daVar) throws RemoteException {
        a(dVar, avVar, str, null, daVar);
    }

    public void a(d dVar, av avVar, String str, String str2, da daVar) throws RemoteException {
        if (this.qV instanceof MediationInterstitialAdapter) {
            gr.S("Requesting interstitial ad from adapter.");
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.qV;
                mediationInterstitialAdapter.requestInterstitialAd((Context) e.f(dVar), new dd(daVar), a(str, avVar.oh, str2), new db(new Date(avVar.od), avVar.oe, avVar.of != null ? new HashSet(avVar.of) : null, avVar.ol, avVar.og, avVar.oh), avVar.on != null ? avVar.on.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
            } catch (Throwable th) {
                gr.d("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            gr.W("MediationAdapter is not a MediationInterstitialAdapter: " + this.qV.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void a(d dVar, ay ayVar, av avVar, String str, da daVar) throws RemoteException {
        a(dVar, ayVar, avVar, str, null, daVar);
    }

    public void a(d dVar, ay ayVar, av avVar, String str, String str2, da daVar) throws RemoteException {
        Bundle bundle = null;
        if (this.qV instanceof MediationBannerAdapter) {
            gr.S("Requesting banner ad from adapter.");
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.qV;
                db dbVar = new db(new Date(avVar.od), avVar.oe, avVar.of != null ? new HashSet(avVar.of) : null, avVar.ol, avVar.og, avVar.oh);
                if (avVar.on != null) {
                    bundle = avVar.on.getBundle(mediationBannerAdapter.getClass().getName());
                }
                mediationBannerAdapter.requestBannerAd((Context) e.f(dVar), new dd(daVar), a(str, avVar.oh, str2), com.google.android.gms.ads.a.a(ayVar.width, ayVar.height, ayVar.op), dbVar, bundle);
            } catch (Throwable th) {
                gr.d("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            gr.W("MediationAdapter is not a MediationBannerAdapter: " + this.qV.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void destroy() throws RemoteException {
        try {
            this.qV.onDestroy();
        } catch (Throwable th) {
            gr.d("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public d getView() throws RemoteException {
        if (this.qV instanceof MediationBannerAdapter) {
            try {
                return e.k(((MediationBannerAdapter) this.qV).getBannerView());
            } catch (Throwable th) {
                gr.d("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            gr.W("MediationAdapter is not a MediationBannerAdapter: " + this.qV.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void pause() throws RemoteException {
        try {
            this.qV.onPause();
        } catch (Throwable th) {
            gr.d("Could not pause adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void resume() throws RemoteException {
        try {
            this.qV.onResume();
        } catch (Throwable th) {
            gr.d("Could not resume adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void showInterstitial() throws RemoteException {
        if (this.qV instanceof MediationInterstitialAdapter) {
            gr.S("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.qV).showInterstitial();
            } catch (Throwable th) {
                gr.d("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            gr.W("MediationAdapter is not a MediationInterstitialAdapter: " + this.qV.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }
}
