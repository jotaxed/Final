package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.ah.a;
import org.json.JSONObject;

@ey
public class aj implements ah {
    private final gu mo;

    public aj(Context context, gs gsVar) {
        this.mo = gu.a(context, new ay(), false, false, null, gsVar);
    }

    private void runOnUiThread(Runnable runnable) {
        if (gq.dB()) {
            runnable.run();
        } else {
            gq.wR.post(runnable);
        }
    }

    public void a(final a aVar) {
        this.mo.dD().a(new gv.a(this) {
            final /* synthetic */ aj nn;

            public void a(gu guVar) {
                aVar.aR();
            }
        });
    }

    public void a(t tVar, ds dsVar, cb cbVar, dv dvVar, boolean z, ce ceVar) {
        this.mo.dD().a(tVar, dsVar, cbVar, dvVar, z, ceVar, new v(false));
    }

    public void a(String str, cd cdVar) {
        this.mo.dD().a(str, cdVar);
    }

    public void a(final String str, final JSONObject jSONObject) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ aj nn;

            public void run() {
                this.nn.mo.a(str, jSONObject);
            }
        });
    }

    public void destroy() {
        this.mo.destroy();
    }

    public void f(final String str) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ aj nn;

            public void run() {
                this.nn.mo.loadUrl(str);
            }
        });
    }

    public void g(String str) {
        this.mo.dD().a(str, null);
    }

    public void pause() {
        gi.a(this.mo);
    }

    public void resume() {
        gi.b(this.mo);
    }
}
