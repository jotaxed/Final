package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.internal.cz.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

@ey
public final class de<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends a {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> qX;
    private final NETWORK_EXTRAS qY;

    public de(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.qX = mediationAdapter;
        this.qY = network_extras;
    }

    private SERVER_PARAMETERS b(String str, int i, String str2) throws RemoteException {
        Map hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap.put(str3, jSONObject.getString(str3));
                }
            } catch (Throwable th) {
                gr.d("Could not get MediationServerParameters.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class serverParametersType = this.qX.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        MediationServerParameters mediationServerParameters = (MediationServerParameters) serverParametersType.newInstance();
        mediationServerParameters.load(hashMap);
        return mediationServerParameters;
    }

    public void a(d dVar, av avVar, String str, da daVar) throws RemoteException {
        a(dVar, avVar, str, null, daVar);
    }

    public void a(d dVar, av avVar, String str, String str2, da daVar) throws RemoteException {
        if (this.qX instanceof MediationInterstitialAdapter) {
            gr.S("Requesting interstitial ad from adapter.");
            try {
                ((MediationInterstitialAdapter) this.qX).requestInterstitialAd(new df(daVar), (Activity) e.f(dVar), b(str, avVar.oh, str2), dg.d(avVar), this.qY);
            } catch (Throwable th) {
                gr.d("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            gr.W("MediationAdapter is not a MediationInterstitialAdapter: " + this.qX.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void a(d dVar, ay ayVar, av avVar, String str, da daVar) throws RemoteException {
        a(dVar, ayVar, avVar, str, null, daVar);
    }

    public void a(d dVar, ay ayVar, av avVar, String str, String str2, da daVar) throws RemoteException {
        if (this.qX instanceof MediationBannerAdapter) {
            gr.S("Requesting banner ad from adapter.");
            try {
                ((MediationBannerAdapter) this.qX).requestBannerAd(new df(daVar), (Activity) e.f(dVar), b(str, avVar.oh, str2), dg.b(ayVar), dg.d(avVar), this.qY);
            } catch (Throwable th) {
                gr.d("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            gr.W("MediationAdapter is not a MediationBannerAdapter: " + this.qX.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void destroy() throws RemoteException {
        try {
            this.qX.destroy();
        } catch (Throwable th) {
            gr.d("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public d getView() throws RemoteException {
        if (this.qX instanceof MediationBannerAdapter) {
            try {
                return e.k(((MediationBannerAdapter) this.qX).getBannerView());
            } catch (Throwable th) {
                gr.d("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            gr.W("MediationAdapter is not a MediationBannerAdapter: " + this.qX.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void pause() throws RemoteException {
        throw new RemoteException();
    }

    public void resume() throws RemoteException {
        throw new RemoteException();
    }

    public void showInterstitial() throws RemoteException {
        if (this.qX instanceof MediationInterstitialAdapter) {
            gr.S("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.qX).showInterstitial();
            } catch (Throwable th) {
                gr.d("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            gr.W("MediationAdapter is not a MediationInterstitialAdapter: " + this.qX.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }
}
