package com.google.android.gms.internal;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.HashMap;
import java.util.Map;

@ey
public class gv extends WebViewClient {
    private final Object mH;
    protected final gu mo;
    private cb pP;
    private cg qa;
    private ce qc;
    private v qd;
    private a tu;
    private final HashMap<String, cd> xe;
    private t xf;
    private ds xg;
    private boolean xh;
    private boolean xi;
    private dv xj;
    private final dl xk;

    public interface a {
        void a(gu guVar);
    }

    public gv(gu guVar, boolean z) {
        this(guVar, z, new dl(guVar, guVar.getContext(), new bl(guVar.getContext())));
    }

    gv(gu guVar, boolean z, dl dlVar) {
        this.xe = new HashMap();
        this.mH = new Object();
        this.xh = false;
        this.mo = guVar;
        this.xi = z;
        this.xk = dlVar;
    }

    private static boolean d(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    private void e(Uri uri) {
        String path = uri.getPath();
        cd cdVar = (cd) this.xe.get(path);
        if (cdVar != null) {
            Map c = gi.c(uri);
            if (gr.v(2)) {
                gr.V("Received GMSG: " + path);
                for (String path2 : c.keySet()) {
                    gr.V("  " + path2 + ": " + ((String) c.get(path2)));
                }
            }
            cdVar.a(this.mo, c);
            return;
        }
        gr.V("No GMSG handler found for GMSG: " + uri);
    }

    public final void A(boolean z) {
        this.xh = z;
    }

    public final void a(do doVar) {
        ds dsVar = null;
        boolean dH = this.mo.dH();
        t tVar = (!dH || this.mo.ac().oq) ? this.xf : null;
        if (!dH) {
            dsVar = this.xg;
        }
        a(new dr(doVar, tVar, dsVar, this.xj, this.mo.dG()));
    }

    protected void a(dr drVar) {
        dp.a(this.mo.getContext(), drVar);
    }

    public final void a(a aVar) {
        this.tu = aVar;
    }

    public void a(t tVar, ds dsVar, cb cbVar, dv dvVar, boolean z, ce ceVar, cg cgVar, v vVar) {
        a(tVar, dsVar, cbVar, dvVar, z, ceVar, vVar);
        a("/setInterstitialProperties", new cf(cgVar));
        this.qa = cgVar;
    }

    public void a(t tVar, ds dsVar, cb cbVar, dv dvVar, boolean z, ce ceVar, v vVar) {
        if (vVar == null) {
            vVar = new v(false);
        }
        a("/appEvent", new ca(cbVar));
        a("/canOpenURLs", cc.pR);
        a("/canOpenIntents", cc.pS);
        a("/click", cc.pT);
        a("/close", cc.pU);
        a("/customClose", cc.pV);
        a("/httpTrack", cc.pW);
        a("/log", cc.pX);
        a("/open", new ci(ceVar, vVar));
        a("/touch", cc.pY);
        a("/video", cc.pZ);
        a("/mraid", new ch());
        this.xf = tVar;
        this.xg = dsVar;
        this.pP = cbVar;
        this.qc = ceVar;
        this.xj = dvVar;
        this.qd = vVar;
        A(z);
    }

    public final void a(String str, cd cdVar) {
        this.xe.put(str, cdVar);
    }

    public final void a(boolean z, int i) {
        t tVar = (!this.mo.dH() || this.mo.ac().oq) ? this.xf : null;
        a(new dr(tVar, this.xg, this.xj, this.mo, z, i, this.mo.dG()));
    }

    public final void a(boolean z, int i, String str) {
        ds dsVar = null;
        boolean dH = this.mo.dH();
        t tVar = (!dH || this.mo.ac().oq) ? this.xf : null;
        if (!dH) {
            dsVar = this.xg;
        }
        a(new dr(tVar, dsVar, this.pP, this.xj, this.mo, z, i, str, this.mo.dG(), this.qc));
    }

    public final void a(boolean z, int i, String str, String str2) {
        boolean dH = this.mo.dH();
        t tVar = (!dH || this.mo.ac().oq) ? this.xf : null;
        a(new dr(tVar, dH ? null : this.xg, this.pP, this.xj, this.mo, z, i, str, str2, this.mo.dG(), this.qc));
    }

    public final void cg() {
        synchronized (this.mH) {
            this.xh = false;
            this.xi = true;
            final dp dC = this.mo.dC();
            if (dC != null) {
                if (gq.dB()) {
                    dC.cg();
                } else {
                    gq.wR.post(new Runnable(this) {
                        final /* synthetic */ gv xm;

                        public void run() {
                            dC.cg();
                        }
                    });
                }
            }
        }
    }

    public v dM() {
        return this.qd;
    }

    public boolean dN() {
        boolean z;
        synchronized (this.mH) {
            z = this.xi;
        }
        return z;
    }

    public void dO() {
        if (dN()) {
            this.xk.bY();
        }
    }

    public final void onLoadResource(WebView webView, String url) {
        gr.V("Loading resource: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            e(parse);
        }
    }

    public final void onPageFinished(WebView webView, String url) {
        if (this.tu != null) {
            this.tu.a(this.mo);
            this.tu = null;
        }
    }

    public final void reset() {
        synchronized (this.mH) {
            this.xe.clear();
            this.xf = null;
            this.xg = null;
            this.tu = null;
            this.pP = null;
            this.xh = false;
            this.xi = false;
            this.qc = null;
            this.xj = null;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String url) {
        gr.V("AdWebView shouldOverrideUrlLoading: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            e(parse);
        } else if (this.xh && webView == this.mo && d(parse)) {
            return super.shouldOverrideUrlLoading(webView, url);
        } else {
            if (this.mo.willNotDraw()) {
                gr.W("AdWebView unable to handle URL: " + url);
            } else {
                Uri uri;
                try {
                    k dF = this.mo.dF();
                    if (dF != null && dF.b(parse)) {
                        parse = dF.a(parse, this.mo.getContext());
                    }
                    uri = parse;
                } catch (l e) {
                    gr.W("Unable to append parameter to URL: " + url);
                    uri = parse;
                }
                if (this.qd == null || this.qd.az()) {
                    a(new do("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
                } else {
                    this.qd.d(url);
                }
            }
        }
        return true;
    }
}
