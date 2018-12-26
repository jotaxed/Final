package com.google.android.gms.internal;

import java.util.Map;
import java.util.concurrent.Future;

@ey
public final class fs {
    private final Object mH = new Object();
    gu mo;
    private String uE;
    private gj<fu> uF = new gj();
    public final cd uG = new cd(this) {
        final /* synthetic */ fs uI;

        {
            this.uI = r1;
        }

        public void a(gu guVar, Map<String, String> map) {
            synchronized (this.uI.mH) {
                if (this.uI.uF.isDone()) {
                    return;
                }
                fu fuVar = new fu(1, map);
                gr.W("Invalid " + fuVar.getType() + " request error: " + fuVar.cT());
                this.uI.uF.a(fuVar);
            }
        }
    };
    public final cd uH = new cd(this) {
        final /* synthetic */ fs uI;

        {
            this.uI = r1;
        }

        public void a(gu guVar, Map<String, String> map) {
            synchronized (this.uI.mH) {
                if (this.uI.uF.isDone()) {
                    return;
                }
                fu fuVar = new fu(-2, map);
                String url = fuVar.getUrl();
                if (url == null) {
                    gr.W("URL missing in loadAdUrl GMSG.");
                    return;
                }
                if (url.contains("%40mediation_adapters%40")) {
                    String replaceAll = url.replaceAll("%40mediation_adapters%40", ge.a(guVar.getContext(), (String) map.get("check_adapters"), this.uI.uE));
                    fuVar.setUrl(replaceAll);
                    gr.V("Ad request URL modified to " + replaceAll);
                }
                this.uI.uF.a(fuVar);
            }
        }
    };

    public fs(String str) {
        this.uE = str;
    }

    public void b(gu guVar) {
        jx.aU("setAdWebView must be called on the main thread.");
        this.mo = guVar;
    }

    public Future<fu> cR() {
        return this.uF;
    }

    public void cS() {
        jx.aU("destroyAdWebView must be called on the main thread.");
        if (this.mo != null) {
            this.mo.destroy();
            this.mo = null;
        }
    }
}
