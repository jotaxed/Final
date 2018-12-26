package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.webkit.WebView;

@ey
public class fb implements Runnable {
    private final int li;
    private final int lj;
    protected final gu mo;
    private final Handler tr;
    private final long ts;
    private long tt;
    private com.google.android.gms.internal.gv.a tu;
    protected boolean tv;
    protected boolean tw;

    protected final class a extends AsyncTask<Void, Void, Boolean> {
        private final WebView tx;
        private Bitmap ty;
        final /* synthetic */ fb tz;

        public a(fb fbVar, WebView webView) {
            this.tz = fbVar;
            this.tx = webView;
        }

        protected void a(Boolean bool) {
            fb.c(this.tz);
            if (bool.booleanValue() || this.tz.cH() || this.tz.tt <= 0) {
                this.tz.tw = bool.booleanValue();
                this.tz.tu.a(this.tz.mo);
            } else if (this.tz.tt > 0) {
                if (gr.v(2)) {
                    gr.S("Ad not detected, scheduling another run.");
                }
                this.tz.tr.postDelayed(this.tz, this.tz.ts);
            }
        }

        protected synchronized Boolean b(Void... voidArr) {
            Boolean valueOf;
            int width = this.ty.getWidth();
            int height = this.ty.getHeight();
            if (width == 0 || height == 0) {
                valueOf = Boolean.valueOf(false);
            } else {
                int i = 0;
                for (int i2 = 0; i2 < width; i2 += 10) {
                    for (int i3 = 0; i3 < height; i3 += 10) {
                        if (this.ty.getPixel(i2, i3) != 0) {
                            i++;
                        }
                    }
                }
                valueOf = Boolean.valueOf(((double) i) / (((double) (width * height)) / 100.0d) > 0.1d);
            }
            return valueOf;
        }

        protected /* synthetic */ Object doInBackground(Object[] x0) {
            return b((Void[]) x0);
        }

        protected /* synthetic */ void onPostExecute(Object x0) {
            a((Boolean) x0);
        }

        protected synchronized void onPreExecute() {
            this.ty = Bitmap.createBitmap(this.tz.li, this.tz.lj, Config.ARGB_8888);
            this.tx.setVisibility(0);
            this.tx.measure(MeasureSpec.makeMeasureSpec(this.tz.li, 0), MeasureSpec.makeMeasureSpec(this.tz.lj, 0));
            this.tx.layout(0, 0, this.tz.li, this.tz.lj);
            this.tx.draw(new Canvas(this.ty));
            this.tx.invalidate();
        }
    }

    public fb(com.google.android.gms.internal.gv.a aVar, gu guVar, int i, int i2) {
        this(aVar, guVar, i, i2, 200, 50);
    }

    public fb(com.google.android.gms.internal.gv.a aVar, gu guVar, int i, int i2, long j, long j2) {
        this.ts = j;
        this.tt = j2;
        this.tr = new Handler(Looper.getMainLooper());
        this.mo = guVar;
        this.tu = aVar;
        this.tv = false;
        this.tw = false;
        this.lj = i2;
        this.li = i;
    }

    static /* synthetic */ long c(fb fbVar) {
        long j = fbVar.tt - 1;
        fbVar.tt = j;
        return j;
    }

    public void a(fj fjVar, gz gzVar) {
        this.mo.setWebViewClient(gzVar);
        this.mo.loadDataWithBaseURL(TextUtils.isEmpty(fjVar.sg) ? null : gi.L(fjVar.sg), fjVar.tU, "text/html", "UTF-8", null);
    }

    public void b(fj fjVar) {
        a(fjVar, new gz(this, this.mo, fjVar.ud));
    }

    public void cF() {
        this.tr.postDelayed(this, this.ts);
    }

    public synchronized void cG() {
        this.tv = true;
    }

    public synchronized boolean cH() {
        return this.tv;
    }

    public boolean cI() {
        return this.tw;
    }

    public void run() {
        if (this.mo == null || cH()) {
            this.tu.a(this.mo);
        } else {
            new a(this, this.mo).execute(new Void[0]);
        }
    }
}
