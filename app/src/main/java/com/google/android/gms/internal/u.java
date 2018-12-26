package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ViewSwitcher;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@ey
public class u extends com.google.android.gms.internal.bd.a implements cb, ce, cg, cs, ds, dv, ej, com.google.android.gms.internal.ez.a, com.google.android.gms.internal.fc.a, gc, t, w {
    private final cy lA;
    private final b lB;
    private final ab lC;
    private final ae lD;
    private boolean lE;
    private final ComponentCallbacks lF;
    private av lz;

    @ey
    private static final class a extends ViewSwitcher {
        private final gl lJ;

        public a(Context context) {
            super(context);
            this.lJ = new gl(context);
        }

        public boolean onInterceptTouchEvent(MotionEvent event) {
            this.lJ.c(event);
            return false;
        }
    }

    @ey
    static class b {
        public final a lK;
        public final String lL;
        public final Context lM;
        public final k lN;
        public final gs lO;
        public bc lP;
        public gf lQ;
        public gf lR;
        public ay lS;
        public fy lT;
        public com.google.android.gms.internal.fy.a lU;
        public fz lV;
        public bf lW;
        public er lX;
        public en lY;
        public by lZ;
        public bz ma;
        public br mb;
        public List<String> mc;
        public ek md;
        public gd me = null;
        public View mf = null;
        public int mg = 0;
        public boolean mh = false;
        public boolean mi = false;
        private HashSet<fz> mj = null;

        public b(Context context, ay ayVar, String str, gs gsVar) {
            if (ayVar.oq) {
                this.lK = null;
            } else {
                this.lK = new a(context);
                this.lK.setMinimumWidth(ayVar.widthPixels);
                this.lK.setMinimumHeight(ayVar.heightPixels);
                this.lK.setVisibility(4);
            }
            this.lS = ayVar;
            this.lL = str;
            this.lM = context;
            this.lO = gsVar;
            this.lN = new k(new x(this));
        }

        public void a(HashSet<fz> hashSet) {
            this.mj = hashSet;
        }

        public HashSet<fz> ay() {
            return this.mj;
        }
    }

    public u(Context context, ay ayVar, String str, cy cyVar, gs gsVar) {
        this(new b(context, ayVar, str, gsVar), cyVar, null);
    }

    u(b bVar, cy cyVar, ab abVar) {
        this.lF = new ComponentCallbacks(this) {
            final /* synthetic */ u lG;

            {
                this.lG = r1;
            }

            public void onConfigurationChanged(Configuration newConfig) {
                if (this.lG.lB != null && this.lG.lB.lT != null && this.lG.lB.lT.se != null) {
                    this.lG.lB.lT.se.cb();
                }
            }

            public void onLowMemory() {
            }
        };
        this.lB = bVar;
        this.lA = cyVar;
        if (abVar == null) {
            abVar = new ab(this);
        }
        this.lC = abVar;
        this.lD = new ae();
        gi.q(this.lB.lM);
        ga.a(this.lB.lM, this.lB.lO);
        ad();
    }

    private com.google.android.gms.internal.fh.a a(av avVar, Bundle bundle) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo = this.lB.lM.getApplicationInfo();
        try {
            packageInfo = this.lB.lM.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        Bundle bundle2 = null;
        if (!(this.lB.lS.oq || this.lB.lK.getParent() == null)) {
            int[] iArr = new int[2];
            this.lB.lK.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            DisplayMetrics displayMetrics = this.lB.lM.getResources().getDisplayMetrics();
            int width = this.lB.lK.getWidth();
            int height = this.lB.lK.getHeight();
            int i3 = 0;
            if (this.lB.lK.isShown() && i + width > 0 && i2 + height > 0 && i <= displayMetrics.widthPixels && i2 <= displayMetrics.heightPixels) {
                i3 = 1;
            }
            bundle2 = new Bundle(5);
            bundle2.putInt("x", i);
            bundle2.putInt("y", i2);
            bundle2.putInt("width", width);
            bundle2.putInt("height", height);
            bundle2.putInt("visible", i3);
        }
        String df = ga.df();
        this.lB.lV = new fz(df, this.lB.lL);
        this.lB.lV.e(avVar);
        return new com.google.android.gms.internal.fh.a(bundle2, avVar, this.lB.lS, this.lB.lL, applicationInfo, packageInfo, df, ga.vY, this.lB.lO, ga.a(this.lB.lM, this, df), this.lB.mc, bundle, ga.dl());
    }

    private gu a(v vVar) {
        if (this.lB.lS.oq) {
            gu a = gu.a(this.lB.lM, this.lB.lS, false, false, this.lB.lN, this.lB.lO);
            a.dD().a(this, null, this, this, true, this, this, vVar);
            return a;
        }
        gu guVar;
        View nextView = this.lB.lK.getNextView();
        if (nextView instanceof gu) {
            guVar = (gu) nextView;
            guVar.a(this.lB.lM, this.lB.lS);
        } else {
            if (nextView != null) {
                this.lB.lK.removeView(nextView);
            }
            guVar = gu.a(this.lB.lM, this.lB.lS, false, false, this.lB.lN, this.lB.lO);
            if (this.lB.lS.or == null) {
                c(guVar);
            }
        }
        guVar.dD().a(this, this, this, this, false, this, vVar);
        return guVar;
    }

    private void a(int i) {
        gr.W("Failed to load ad: " + i);
        if (this.lB.lP != null) {
            try {
                this.lB.lP.onAdFailedToLoad(i);
            } catch (Throwable e) {
                gr.d("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
    }

    private void ad() {
        if (VERSION.SDK_INT >= 14 && this.lB != null && this.lB.lM != null) {
            this.lB.lM.registerComponentCallbacks(this.lF);
        }
    }

    private void ae() {
        if (VERSION.SDK_INT >= 14 && this.lB != null && this.lB.lM != null) {
            this.lB.lM.unregisterComponentCallbacks(this.lF);
        }
    }

    private void ao() {
        gr.U("Ad closing.");
        if (this.lB.lP != null) {
            try {
                this.lB.lP.onAdClosed();
            } catch (Throwable e) {
                gr.d("Could not call AdListener.onAdClosed().", e);
            }
        }
    }

    private void ap() {
        gr.U("Ad leaving application.");
        if (this.lB.lP != null) {
            try {
                this.lB.lP.onAdLeftApplication();
            } catch (Throwable e) {
                gr.d("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
    }

    private void aq() {
        gr.U("Ad opening.");
        if (this.lB.lP != null) {
            try {
                this.lB.lP.onAdOpened();
            } catch (Throwable e) {
                gr.d("Could not call AdListener.onAdOpened().", e);
            }
        }
    }

    private void ar() {
        gr.U("Ad finished loading.");
        if (this.lB.lP != null) {
            try {
                this.lB.lP.onAdLoaded();
            } catch (Throwable e) {
                gr.d("Could not call AdListener.onAdLoaded().", e);
            }
        }
    }

    private void as() {
        try {
            if ((this.lB.lT.vI instanceof bt) && this.lB.lZ != null) {
                this.lB.lZ.a((bt) this.lB.lT.vI);
            }
        } catch (Throwable e) {
            gr.d("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", e);
        }
    }

    private void at() {
        try {
            if ((this.lB.lT.vI instanceof bu) && this.lB.ma != null) {
                this.lB.ma.a((bu) this.lB.lT.vI);
            }
        } catch (Throwable e) {
            gr.d("Could not call OnContentAdLoadedListener.onContentAdLoaded().", e);
        }
    }

    private void ax() {
        if (this.lB.lT != null) {
            if (this.lB.mg == 0) {
                this.lB.lT.se.destroy();
            }
            this.lB.lT = null;
            this.lB.mi = false;
        }
    }

    private boolean b(fy fyVar) {
        View view;
        if (fyVar.tW) {
            try {
                view = (View) e.f(fyVar.qQ.getView());
                View nextView = this.lB.lK.getNextView();
                if (nextView != null) {
                    this.lB.lK.removeView(nextView);
                }
                try {
                    c(view);
                } catch (Throwable th) {
                    gr.d("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            } catch (Throwable th2) {
                gr.d("Could not get View from mediation adapter.", th2);
                return false;
            }
        } else if (fyVar.vF != null) {
            fyVar.se.a(fyVar.vF);
            this.lB.lK.removeAllViews();
            this.lB.lK.setMinimumWidth(fyVar.vF.widthPixels);
            this.lB.lK.setMinimumHeight(fyVar.vF.heightPixels);
            c(fyVar.se);
        }
        if (this.lB.lK.getChildCount() > 1) {
            this.lB.lK.showNext();
        }
        if (this.lB.lT != null) {
            view = this.lB.lK.getNextView();
            if (view instanceof gu) {
                ((gu) view).a(this.lB.lM, this.lB.lS);
            } else if (view != null) {
                this.lB.lK.removeView(view);
            }
            if (this.lB.lT.qQ != null) {
                try {
                    this.lB.lT.qQ.destroy();
                } catch (RemoteException e) {
                    gr.W("Could not destroy previous mediation adapter.");
                }
            }
        }
        this.lB.lK.setVisibility(0);
        return true;
    }

    private void c(View view) {
        this.lB.lK.addView(view, new LayoutParams(-2, -2));
    }

    private void e(boolean z) {
        if (this.lB.lT == null) {
            gr.W("Ad state was null when trying to ping impression URLs.");
            return;
        }
        gr.S("Pinging Impression URLs.");
        this.lB.lV.cW();
        if (this.lB.lT.qx != null) {
            gi.a(this.lB.lM, this.lB.lO.wS, this.lB.lT.qx);
        }
        if (!(this.lB.lT.vE == null || this.lB.lT.vE.qx == null)) {
            cw.a(this.lB.lM, this.lB.lO.wS, this.lB.lT, this.lB.lL, z, this.lB.lT.vE.qx);
        }
        if (this.lB.lT.qP != null && this.lB.lT.qP.qs != null) {
            cw.a(this.lB.lM, this.lB.lO.wS, this.lB.lT, this.lB.lL, z, this.lB.lT.qP.qs);
        }
    }

    Bundle a(an anVar) {
        if (anVar == null) {
            return null;
        }
        String aT;
        if (anVar.be()) {
            anVar.wakeup();
        }
        ak bc = anVar.bc();
        if (bc != null) {
            aT = bc.aT();
            gr.S("In AdManger: loadAd, " + bc.toString());
        } else {
            aT = null;
        }
        if (aT == null) {
            return null;
        }
        Bundle bundle = new Bundle(1);
        bundle.putString("fingerprint", aT);
        bundle.putInt("v", 1);
        return bundle;
    }

    public void a(ay ayVar) {
        jx.aU("setAdSize must be called on the main UI thread.");
        this.lB.lS = ayVar;
        if (this.lB.lT != null && this.lB.mg == 0) {
            this.lB.lT.se.a(ayVar);
        }
        if (this.lB.lK.getChildCount() > 1) {
            this.lB.lK.removeView(this.lB.lK.getNextView());
        }
        this.lB.lK.setMinimumWidth(ayVar.widthPixels);
        this.lB.lK.setMinimumHeight(ayVar.heightPixels);
        this.lB.lK.requestLayout();
    }

    public void a(bc bcVar) {
        jx.aU("setAdListener must be called on the main UI thread.");
        this.lB.lP = bcVar;
    }

    public void a(bf bfVar) {
        jx.aU("setAppEventListener must be called on the main UI thread.");
        this.lB.lW = bfVar;
    }

    public void a(br brVar) {
        jx.aU("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.lB.mb = brVar;
    }

    public void a(en enVar) {
        jx.aU("setInAppPurchaseListener must be called on the main UI thread.");
        this.lB.lY = enVar;
    }

    public void a(er erVar, String str) {
        jx.aU("setPlayStorePurchaseParams must be called on the main UI thread.");
        this.lB.md = new ek(str);
        this.lB.lX = erVar;
        if (!ga.dj() && erVar != null) {
            new ec(this.lB.lM, this.lB.lX, this.lB.md).start();
        }
    }

    public void a(com.google.android.gms.internal.fy.a aVar) {
        gu guVar;
        String str = null;
        this.lB.lQ = null;
        this.lB.lU = aVar;
        a(null);
        if (aVar.vK.ug) {
            guVar = null;
        } else {
            final v vVar = new v();
            guVar = a(vVar);
            vVar.a(new com.google.android.gms.internal.v.b(aVar, guVar));
            guVar.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ u lG;

                public boolean onTouch(View v, MotionEvent event) {
                    vVar.av();
                    return false;
                }
            });
            guVar.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ u lG;

                public void onClick(View v) {
                    vVar.av();
                }
            });
        }
        if (aVar.lS != null) {
            this.lB.lS = aVar.lS;
        }
        if (aVar.errorCode != -2) {
            a(new fy(aVar, guVar, null, null, null, null, null));
            return;
        }
        if (!aVar.vK.tW && aVar.vK.uf) {
            if (aVar.vK.sg != null) {
                str = Uri.parse(aVar.vK.sg).buildUpon().query(null).build().toString();
            }
            bq boVar = new bo(this, str, aVar.vK.tU);
            try {
                if (this.lB.mb != null) {
                    this.lB.mg = 1;
                    this.lB.mb.a(boVar);
                    return;
                }
            } catch (Throwable e) {
                gr.d("Could not call the onCustomRenderedAdLoadedListener.", e);
            }
        }
        this.lB.mg = 0;
        this.lB.lR = fc.a(this.lB.lM, this, aVar, guVar, this.lA, this);
    }

    public void a(fy fyVar) {
        this.lB.lR = null;
        boolean z = fyVar.vI != null;
        if (!(fyVar.errorCode == -2 || fyVar.errorCode == 3)) {
            ga.b(this.lB.ay());
        }
        if (fyVar.errorCode != -1) {
            if (a(fyVar, z)) {
                gr.S("Ad refresh scheduled.");
            }
            if (!(fyVar.errorCode != 3 || fyVar.vE == null || fyVar.vE.qy == null)) {
                gr.S("Pinging no fill URLs.");
                cw.a(this.lB.lM, this.lB.lO.wS, fyVar, this.lB.lL, false, fyVar.vE.qy);
            }
            if (fyVar.errorCode != -2) {
                a(fyVar.errorCode);
                return;
            }
            int i;
            int i2;
            if (!(this.lB.lS.oq || z || this.lB.mg != 0)) {
                if (!b(fyVar)) {
                    a(0);
                    return;
                } else if (this.lB.lK != null) {
                    this.lB.lK.lJ.Q(fyVar.ub);
                }
            }
            if (!(this.lB.lT == null || this.lB.lT.qS == null)) {
                this.lB.lT.qS.a(null);
            }
            if (fyVar.qS != null) {
                fyVar.qS.a((cs) this);
            }
            this.lD.d(this.lB.lT);
            this.lB.lT = fyVar;
            this.lB.lV.j(fyVar.vG);
            this.lB.lV.k(fyVar.vH);
            this.lB.lV.v(this.lB.lS.oq);
            this.lB.lV.w(fyVar.tW);
            if (!(this.lB.lS.oq || z || this.lB.mg != 0)) {
                e(false);
            }
            if (this.lB.me == null) {
                this.lB.me = new gd(this.lB.lL);
            }
            if (fyVar.vE != null) {
                i = fyVar.vE.qB;
                i2 = fyVar.vE.qC;
            } else {
                i2 = 0;
                i = 0;
            }
            this.lB.me.d(i, i2);
            if (this.lB.mg == 0) {
                if (!(this.lB.lS.oq || fyVar.se == null || (!fyVar.se.dD().dN() && fyVar.vD == null))) {
                    af a = this.lD.a(this.lB.lS, this.lB.lT);
                    if (fyVar.se.dD().dN() && a != null) {
                        a.a(new aa(fyVar.se));
                    }
                }
                if (this.lB.lT.se != null) {
                    this.lB.lT.se.cb();
                    this.lB.lT.se.dD().dO();
                }
                if (z) {
                    com.google.android.gms.internal.bv.a aVar = fyVar.vI;
                    if ((aVar instanceof bu) && this.lB.ma != null) {
                        at();
                    } else if (!(aVar instanceof bt) || this.lB.lZ == null) {
                        gr.W("No matching listener for retrieved native ad template.");
                        a(0);
                        return;
                    } else {
                        as();
                    }
                }
                ar();
            } else if (this.lB.mf != null && fyVar.vD != null) {
                this.lD.a(this.lB.lM, this.lB.lS, this.lB.lT, this.lB.mf, this.lB.lO);
            }
        }
    }

    public void a(String str, ArrayList<String> arrayList) {
        em edVar = new ed(str, arrayList, this.lB.lM, this.lB.lO.wS);
        if (this.lB.lY == null) {
            gr.W("InAppPurchaseListener is not set. Try to launch default purchase flow.");
            if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.lB.lM) != 0) {
                gr.W("Google Play Service unavailable, cannot launch default purchase flow.");
                return;
            } else if (this.lB.lX == null) {
                gr.W("PlayStorePurchaseListener is not set.");
                return;
            } else if (this.lB.md == null) {
                gr.W("PlayStorePurchaseVerifier is not initialized.");
                return;
            } else if (this.lB.mh) {
                gr.W("An in-app purchase request is already in progress, abort");
                return;
            } else {
                this.lB.mh = true;
                try {
                    if (this.lB.lX.isValidPurchase(str)) {
                        ee.a(this.lB.lM, this.lB.lO.wV, new ea(this.lB.lM, this.lB.md, edVar, this));
                        return;
                    } else {
                        this.lB.mh = false;
                        return;
                    }
                } catch (RemoteException e) {
                    gr.W("Could not start In-App purchase.");
                    this.lB.mh = false;
                    return;
                }
            }
        }
        try {
            this.lB.lY.a(edVar);
        } catch (RemoteException e2) {
            gr.W("Could not start In-App purchase.");
        }
    }

    public void a(String str, boolean z, int i, final Intent intent, ef efVar) {
        try {
            if (this.lB.lX != null) {
                this.lB.lX.a(new eg(this.lB.lM, str, z, i, intent, efVar));
            }
        } catch (RemoteException e) {
            gr.W("Fail to invoke PlayStorePurchaseListener.");
        }
        gq.wR.postDelayed(new Runnable(this) {
            final /* synthetic */ u lG;

            public void run() {
                if (!(ei.d(intent) != 0 || this.lG.lB.lT == null || this.lG.lB.lT.se == null || this.lG.lB.lT.se.dC() == null)) {
                    this.lG.lB.lT.se.dC().close();
                }
                this.lG.lB.mh = false;
            }
        }, 500);
    }

    public void a(HashSet<fz> hashSet) {
        this.lB.a(hashSet);
    }

    public void a(List<String> list) {
        jx.aU("setNativeTemplates must be called on the main UI thread.");
        this.lB.mc = list;
    }

    public boolean a(av avVar) {
        jx.aU("loadAd must be called on the main UI thread.");
        if (this.lB.lQ != null || this.lB.lR != null) {
            if (this.lz != null) {
                gr.W("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
            }
            this.lz = avVar;
            return false;
        } else if (this.lB.lS.oq && this.lB.lT != null) {
            gr.W("An interstitial is already loading. Aborting.");
            return false;
        } else if (!au()) {
            return false;
        } else {
            gr.U("Starting ad request.");
            if (!avVar.og) {
                gr.U("Use AdRequest.Builder.addTestDevice(\"" + gq.v(this.lB.lM) + "\") to get test ads on this device.");
            }
            Bundle a = a(ga.dc().l(this.lB.lM));
            this.lC.cancel();
            this.lB.mg = 0;
            com.google.android.gms.internal.fh.a a2 = a(avVar, a);
            this.lB.lQ = ez.a(this.lB.lM, a2, this.lB.lN, this);
            return true;
        }
    }

    boolean a(fy fyVar, boolean z) {
        av avVar;
        int i = 0;
        if (this.lz != null) {
            avVar = this.lz;
            this.lz = null;
        } else {
            avVar = fyVar.tL;
            if (avVar.extras != null) {
                i = avVar.extras.getBoolean("_noRefresh", false);
            }
        }
        i |= z;
        if (this.lB.lS.oq) {
            if (this.lB.mg == 0) {
                gi.a(fyVar.se);
            }
        } else if (i == 0 && this.lB.mg == 0) {
            if (fyVar.qA > 0) {
                this.lC.a(avVar, fyVar.qA);
            } else if (fyVar.vE != null && fyVar.vE.qA > 0) {
                this.lC.a(avVar, fyVar.vE.qA);
            } else if (!fyVar.tW && fyVar.errorCode == 2) {
                this.lC.c(avVar);
            }
        }
        return this.lC.aD();
    }

    public d ab() {
        jx.aU("getAdFrame must be called on the main UI thread.");
        return e.k(this.lB.lK);
    }

    public ay ac() {
        jx.aU("getAdSize must be called on the main UI thread.");
        return this.lB.lS;
    }

    public void af() {
        ap();
    }

    public void ag() {
        this.lD.d(this.lB.lT);
        if (this.lB.lS.oq) {
            ax();
        }
        this.lE = false;
        ao();
        this.lB.lV.cY();
    }

    public void ah() {
        if (this.lB.lS.oq) {
            e(false);
        }
        this.lE = true;
        aq();
    }

    public void ai() {
        onAdClicked();
    }

    public void aj() {
        ag();
    }

    public void ak() {
        af();
    }

    public void al() {
        ah();
    }

    public void am() {
        if (this.lB.lT != null) {
            gr.W("Mediation adapter " + this.lB.lT.qR + " refreshed, but mediation adapters should never refresh.");
        }
        e(true);
        ar();
    }

    public void an() {
        jx.aU("recordManualImpression must be called on the main UI thread.");
        if (this.lB.lT == null) {
            gr.W("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        gr.S("Pinging manual tracking URLs.");
        if (this.lB.lT.tY != null) {
            gi.a(this.lB.lM, this.lB.lO.wS, this.lB.lT.tY);
        }
    }

    public boolean au() {
        boolean z = true;
        if (!gi.a(this.lB.lM.getPackageManager(), this.lB.lM.getPackageName(), "android.permission.INTERNET")) {
            if (!this.lB.lS.oq) {
                gq.a(this.lB.lK, this.lB.lS, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            }
            z = false;
        }
        if (!gi.p(this.lB.lM)) {
            if (!this.lB.lS.oq) {
                gq.a(this.lB.lK, this.lB.lS, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            }
            z = false;
        }
        if (!(z || this.lB.lS.oq)) {
            this.lB.lK.setVisibility(0);
        }
        return z;
    }

    public void av() {
        if (this.lB.lT == null) {
            gr.W("Ad state was null when trying to ping click URLs.");
            return;
        }
        gr.S("Pinging click URLs.");
        this.lB.lV.cX();
        if (this.lB.lT.qw != null) {
            gi.a(this.lB.lM, this.lB.lO.wS, this.lB.lT.qw);
        }
        if (this.lB.lT.vE != null && this.lB.lT.vE.qw != null) {
            cw.a(this.lB.lM, this.lB.lO.wS, this.lB.lT, this.lB.lL, false, this.lB.lT.vE.qw);
        }
    }

    public void aw() {
        e(false);
    }

    public void b(View view) {
        this.lB.mf = view;
        a(new fy(this.lB.lU, null, null, null, null, null, null));
    }

    public void b(av avVar) {
        ViewParent parent = this.lB.lK.getParent();
        if ((parent instanceof View) && ((View) parent).isShown() && gi.dt() && !this.lE) {
            a(avVar);
            return;
        }
        gr.U("Ad is not visible. Not refreshing ad.");
        this.lC.c(avVar);
    }

    public void d(boolean z) {
        this.lB.mi = z;
    }

    public void destroy() {
        jx.aU("destroy must be called on the main UI thread.");
        ae();
        this.lB.lP = null;
        this.lB.lW = null;
        this.lB.lX = null;
        this.lB.lY = null;
        this.lB.mb = null;
        this.lC.cancel();
        this.lD.stop();
        stopLoading();
        if (this.lB.lK != null) {
            this.lB.lK.removeAllViews();
        }
        if (!(this.lB.lT == null || this.lB.lT.se == null)) {
            this.lB.lT.se.destroy();
        }
        if (this.lB.lT != null && this.lB.lT.qQ != null) {
            try {
                this.lB.lT.qQ.destroy();
            } catch (RemoteException e) {
                gr.W("Could not destroy mediation adapter.");
            }
        }
    }

    public String getMediationAdapterClassName() {
        return this.lB.lT != null ? this.lB.lT.qR : null;
    }

    public boolean isReady() {
        jx.aU("isLoaded must be called on the main UI thread.");
        return this.lB.lQ == null && this.lB.lR == null && this.lB.lT != null;
    }

    public void onAdClicked() {
        av();
    }

    public void onAppEvent(String name, String info) {
        if (this.lB.lW != null) {
            try {
                this.lB.lW.onAppEvent(name, info);
            } catch (Throwable e) {
                gr.d("Could not call the AppEventListener.", e);
            }
        }
    }

    public void pause() {
        jx.aU("pause must be called on the main UI thread.");
        if (this.lB.lT != null && this.lB.mg == 0) {
            gi.a(this.lB.lT.se);
        }
        if (!(this.lB.lT == null || this.lB.lT.qQ == null)) {
            try {
                this.lB.lT.qQ.pause();
            } catch (RemoteException e) {
                gr.W("Could not pause mediation adapter.");
            }
        }
        this.lD.pause();
        this.lC.pause();
    }

    public void resume() {
        jx.aU("resume must be called on the main UI thread.");
        if (this.lB.lT != null && this.lB.mg == 0) {
            gi.b(this.lB.lT.se);
        }
        if (!(this.lB.lT == null || this.lB.lT.qQ == null)) {
            try {
                this.lB.lT.qQ.resume();
            } catch (RemoteException e) {
                gr.W("Could not resume mediation adapter.");
            }
        }
        this.lC.resume();
        this.lD.resume();
    }

    public void showInterstitial() {
        jx.aU("showInterstitial must be called on the main UI thread.");
        if (!this.lB.lS.oq) {
            gr.W("Cannot call showInterstitial on a banner ad.");
        } else if (this.lB.lT == null) {
            gr.W("The interstitial has not loaded.");
        } else if (this.lB.mg == 1) {
        } else {
            if (this.lB.lT.se.dH()) {
                gr.W("The interstitial is already showing.");
                return;
            }
            this.lB.lT.se.z(true);
            if (this.lB.lT.se.dD().dN() || this.lB.lT.vD != null) {
                af a = this.lD.a(this.lB.lS, this.lB.lT);
                if (this.lB.lT.se.dD().dN() && a != null) {
                    a.a(new aa(this.lB.lT.se));
                }
            }
            if (this.lB.lT.tW) {
                try {
                    this.lB.lT.qQ.showInterstitial();
                    return;
                } catch (Throwable e) {
                    gr.d("Could not show interstitial.", e);
                    ax();
                    return;
                }
            }
            y yVar = new y(this.lB.mi, false);
            if (this.lB.lM instanceof Activity) {
                Window window = ((Activity) this.lB.lM).getWindow();
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                window.getDecorView().getGlobalVisibleRect(rect);
                window.getDecorView().getWindowVisibleDisplayFrame(rect2);
                if (!(rect.bottom == 0 || rect2.bottom == 0)) {
                    yVar = new y(this.lB.mi, rect.top == rect2.top);
                }
            }
            dp.a(this.lB.lM, new dr(this, this, this, this.lB.lT.se, this.lB.lT.orientation, this.lB.lO, this.lB.lT.ub, yVar));
        }
    }

    public void stopLoading() {
        jx.aU("stopLoading must be called on the main UI thread.");
        if (this.lB.lT != null && this.lB.mg == 0) {
            this.lB.lT.se.stopLoading();
            this.lB.lT = null;
        }
        if (this.lB.lQ != null) {
            this.lB.lQ.cancel();
        }
        if (this.lB.lR != null) {
            this.lB.lR.cancel();
        }
    }
}
