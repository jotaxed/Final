package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@ey
public final class bg {
    public static final String DEVICE_ID_EMULATOR = gq.R("emulator");
    private final Date d;
    private final Set<String> f;
    private final Location h;
    private final String oA;
    private final SearchAdRequest oB;
    private final int oC;
    private final Set<String> oD;
    private final String ov;
    private final int ow;
    private final boolean ox;
    private final Bundle oy;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> oz;

    public static final class a {
        private Date d;
        private Location h;
        private String oA;
        private int oC = -1;
        private final HashSet<String> oE = new HashSet();
        private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> oF = new HashMap();
        private final HashSet<String> oG = new HashSet();
        private String ov;
        private int ow = -1;
        private boolean ox = false;
        private final Bundle oy = new Bundle();

        public void a(Location location) {
            this.h = location;
        }

        @Deprecated
        public void a(NetworkExtras networkExtras) {
            if (networkExtras instanceof AdMobExtras) {
                a(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
            } else {
                this.oF.put(networkExtras.getClass(), networkExtras);
            }
        }

        public void a(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.oy.putBundle(cls.getName(), bundle);
        }

        public void a(Date date) {
            this.d = date;
        }

        public void b(Class<? extends CustomEvent> cls, Bundle bundle) {
            if (this.oy.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
                this.oy.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
            }
            this.oy.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
        }

        public void h(int i) {
            this.ow = i;
        }

        public void i(boolean z) {
            this.ox = z;
        }

        public void j(boolean z) {
            this.oC = z ? 1 : 0;
        }

        public void r(String str) {
            this.oE.add(str);
        }

        public void s(String str) {
            this.oG.add(str);
        }

        public void t(String str) {
            this.ov = str;
        }

        public void u(String str) {
            this.oA = str;
        }
    }

    public bg(a aVar) {
        this(aVar, null);
    }

    public bg(a aVar, SearchAdRequest searchAdRequest) {
        this.d = aVar.d;
        this.ov = aVar.ov;
        this.ow = aVar.ow;
        this.f = Collections.unmodifiableSet(aVar.oE);
        this.h = aVar.h;
        this.ox = aVar.ox;
        this.oy = aVar.oy;
        this.oz = Collections.unmodifiableMap(aVar.oF);
        this.oA = aVar.oA;
        this.oB = searchAdRequest;
        this.oC = aVar.oC;
        this.oD = Collections.unmodifiableSet(aVar.oG);
    }

    public SearchAdRequest bi() {
        return this.oB;
    }

    public Map<Class<? extends NetworkExtras>, NetworkExtras> bj() {
        return this.oz;
    }

    public Bundle bk() {
        return this.oy;
    }

    public int bl() {
        return this.oC;
    }

    public Date getBirthday() {
        return this.d;
    }

    public String getContentUrl() {
        return this.ov;
    }

    public Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> adapterClass) {
        Bundle bundle = this.oy.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        return bundle != null ? bundle.getBundle(adapterClass.getClass().getName()) : null;
    }

    public int getGender() {
        return this.ow;
    }

    public Set<String> getKeywords() {
        return this.f;
    }

    public Location getLocation() {
        return this.h;
    }

    public boolean getManualImpressionsEnabled() {
        return this.ox;
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return (NetworkExtras) this.oz.get(networkExtrasClass);
    }

    public Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> adapterClass) {
        return this.oy.getBundle(adapterClass.getName());
    }

    public String getPublisherProvidedId() {
        return this.oA;
    }

    public boolean isTestDevice(Context context) {
        return this.oD.contains(gq.v(context));
    }
}
