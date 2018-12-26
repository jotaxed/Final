package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.drive.DriveFile;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class gu extends WebView implements DownloadListener {
    private final Object mH = new Object();
    private final WindowManager mR;
    private ay qI;
    private final gs qJ;
    private final k tl;
    private final gv wW;
    private final a wX;
    private dp wY;
    private boolean wZ;
    private boolean xa;
    private boolean xb;
    private boolean xc;

    @ey
    protected static class a extends MutableContextWrapper {
        private Context mO;
        private Activity xd;

        public a(Context context) {
            super(context);
            setBaseContext(context);
        }

        public Context dI() {
            return this.xd;
        }

        public void setBaseContext(Context base) {
            this.mO = base.getApplicationContext();
            this.xd = base instanceof Activity ? (Activity) base : null;
            super.setBaseContext(this.mO);
        }

        public void startActivity(Intent intent) {
            if (this.xd != null) {
                this.xd.startActivity(intent);
                return;
            }
            intent.setFlags(DriveFile.MODE_READ_ONLY);
            this.mO.startActivity(intent);
        }
    }

    protected gu(a aVar, ay ayVar, boolean z, boolean z2, k kVar, gs gsVar) {
        super(aVar);
        this.wX = aVar;
        this.qI = ayVar;
        this.wZ = z;
        this.tl = kVar;
        this.qJ = gsVar;
        this.mR = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        gi.a((Context) aVar, gsVar.wS, settings);
        if (VERSION.SDK_INT >= 17) {
            go.a(getContext(), settings);
        } else if (VERSION.SDK_INT >= 11) {
            gm.a(getContext(), settings);
        }
        setDownloadListener(this);
        if (VERSION.SDK_INT >= 11) {
            this.wW = new gx(this, z2);
        } else {
            this.wW = new gv(this, z2);
        }
        setWebViewClient(this.wW);
        if (VERSION.SDK_INT >= 14) {
            setWebChromeClient(new gy(this));
        } else if (VERSION.SDK_INT >= 11) {
            setWebChromeClient(new gw(this));
        }
        dJ();
    }

    public static gu a(Context context, ay ayVar, boolean z, boolean z2, k kVar, gs gsVar) {
        return new gu(new a(context), ayVar, z, z2, kVar, gsVar);
    }

    private void dJ() {
        synchronized (this.mH) {
            if (this.wZ || this.qI.oq) {
                if (VERSION.SDK_INT < 14) {
                    gr.S("Disabling hardware acceleration on an overlay.");
                    dK();
                } else {
                    gr.S("Enabling hardware acceleration on an overlay.");
                    dL();
                }
            } else if (VERSION.SDK_INT < 18) {
                gr.S("Disabling hardware acceleration on an AdView.");
                dK();
            } else {
                gr.S("Enabling hardware acceleration on an AdView.");
                dL();
            }
        }
    }

    private void dK() {
        synchronized (this.mH) {
            if (!this.xa && VERSION.SDK_INT >= 11) {
                gm.i(this);
            }
            this.xa = true;
        }
    }

    private void dL() {
        synchronized (this.mH) {
            if (this.xa && VERSION.SDK_INT >= 11) {
                gm.j(this);
            }
            this.xa = false;
        }
    }

    protected void X(String str) {
        synchronized (this.mH) {
            if (isDestroyed()) {
                gr.W("The webview is destroyed. Ignoring action.");
            } else {
                loadUrl(str);
            }
        }
    }

    public void a(Context context, ay ayVar) {
        synchronized (this.mH) {
            this.wX.setBaseContext(context);
            this.wY = null;
            this.qI = ayVar;
            this.wZ = false;
            this.xc = false;
            gi.b(this);
            loadUrl("about:blank");
            this.wW.reset();
            setOnTouchListener(null);
            setOnClickListener(null);
        }
    }

    public void a(ay ayVar) {
        synchronized (this.mH) {
            this.qI = ayVar;
            requestLayout();
        }
    }

    public void a(dp dpVar) {
        synchronized (this.mH) {
            this.wY = dpVar;
        }
    }

    public void a(String str, Map<String, ?> map) {
        try {
            b(str, gi.t((Map) map));
        } catch (JSONException e) {
            gr.W("Could not convert parameters to JSON.");
        }
    }

    public void a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:" + str + "(");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        X(stringBuilder.toString());
    }

    public ay ac() {
        ay ayVar;
        synchronized (this.mH) {
            ayVar = this.qI;
        }
        return ayVar;
    }

    public void b(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:AFMA_ReceiveMessage('");
        stringBuilder.append(str);
        stringBuilder.append("'");
        stringBuilder.append(",");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        gr.V("Dispatching AFMA event: " + stringBuilder);
        X(stringBuilder.toString());
    }

    public void cb() {
        if (dD().dN()) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Display defaultDisplay = this.mR.getDefaultDisplay();
            defaultDisplay.getMetrics(displayMetrics);
            int s = gi.s(getContext());
            float f = 160.0f / ((float) displayMetrics.densityDpi);
            int round = Math.round(((float) displayMetrics.widthPixels) * f);
            try {
                b("onScreenInfoChanged", new JSONObject().put("width", round).put("height", Math.round(((float) (displayMetrics.heightPixels - s)) * f)).put("density", (double) displayMetrics.density).put("rotation", defaultDisplay.getRotation()));
            } catch (Throwable e) {
                gr.b("Error occured while obtaining screen information.", e);
            }
        }
    }

    public void ci() {
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.qJ.wS);
        a("onshow", hashMap);
    }

    public void cj() {
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.qJ.wS);
        a("onhide", hashMap);
    }

    public dp dC() {
        dp dpVar;
        synchronized (this.mH) {
            dpVar = this.wY;
        }
        return dpVar;
    }

    public gv dD() {
        return this.wW;
    }

    public boolean dE() {
        return this.xc;
    }

    public k dF() {
        return this.tl;
    }

    public gs dG() {
        return this.qJ;
    }

    public boolean dH() {
        boolean z;
        synchronized (this.mH) {
            z = this.wZ;
        }
        return z;
    }

    public Context dI() {
        return this.wX.dI();
    }

    public void destroy() {
        synchronized (this.mH) {
            if (this.wY != null) {
                this.wY.close();
            }
            this.xb = true;
            super.destroy();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void evaluateJavascript(java.lang.String r3, android.webkit.ValueCallback<java.lang.String> r4) {
        /*
        r2 = this;
        r1 = r2.mH;
        monitor-enter(r1);
        r0 = r2.isDestroyed();	 Catch:{ all -> 0x001b }
        if (r0 == 0) goto L_0x0016;
    L_0x0009:
        r0 = "The webview is destroyed. Ignoring action.";
        com.google.android.gms.internal.gr.W(r0);	 Catch:{ all -> 0x001b }
        if (r4 == 0) goto L_0x0014;
    L_0x0010:
        r0 = 0;
        r4.onReceiveValue(r0);	 Catch:{ all -> 0x001b }
    L_0x0014:
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
    L_0x0015:
        return;
    L_0x0016:
        super.evaluateJavascript(r3, r4);	 Catch:{ all -> 0x001b }
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        goto L_0x0015;
    L_0x001b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gu.evaluateJavascript(java.lang.String, android.webkit.ValueCallback):void");
    }

    public boolean isDestroyed() {
        boolean z;
        synchronized (this.mH) {
            z = this.xb;
        }
        return z;
    }

    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long size) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(url), mimeType);
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            gr.S("Couldn't find an Activity to view url/mimetype: " + url + " / " + mimeType);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onMeasure(int r10, int r11) {
        /*
        r9 = this;
        r0 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r8 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = 8;
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r4 = r9.mH;
        monitor-enter(r4);
        r1 = r9.isInEditMode();	 Catch:{ all -> 0x00ae }
        if (r1 != 0) goto L_0x0016;
    L_0x0012:
        r1 = r9.wZ;	 Catch:{ all -> 0x00ae }
        if (r1 == 0) goto L_0x001b;
    L_0x0016:
        super.onMeasure(r10, r11);	 Catch:{ all -> 0x00ae }
        monitor-exit(r4);	 Catch:{ all -> 0x00ae }
    L_0x001a:
        return;
    L_0x001b:
        r2 = android.view.View.MeasureSpec.getMode(r10);	 Catch:{ all -> 0x00ae }
        r3 = android.view.View.MeasureSpec.getSize(r10);	 Catch:{ all -> 0x00ae }
        r5 = android.view.View.MeasureSpec.getMode(r11);	 Catch:{ all -> 0x00ae }
        r1 = android.view.View.MeasureSpec.getSize(r11);	 Catch:{ all -> 0x00ae }
        if (r2 == r6) goto L_0x002f;
    L_0x002d:
        if (r2 != r8) goto L_0x00c7;
    L_0x002f:
        r2 = r3;
    L_0x0030:
        if (r5 == r6) goto L_0x0034;
    L_0x0032:
        if (r5 != r8) goto L_0x0035;
    L_0x0034:
        r0 = r1;
    L_0x0035:
        r5 = r9.qI;	 Catch:{ all -> 0x00ae }
        r5 = r5.widthPixels;	 Catch:{ all -> 0x00ae }
        if (r5 > r2) goto L_0x0041;
    L_0x003b:
        r2 = r9.qI;	 Catch:{ all -> 0x00ae }
        r2 = r2.heightPixels;	 Catch:{ all -> 0x00ae }
        if (r2 <= r0) goto L_0x00b1;
    L_0x0041:
        r0 = r9.wX;	 Catch:{ all -> 0x00ae }
        r0 = r0.getResources();	 Catch:{ all -> 0x00ae }
        r0 = r0.getDisplayMetrics();	 Catch:{ all -> 0x00ae }
        r0 = r0.density;	 Catch:{ all -> 0x00ae }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ae }
        r2.<init>();	 Catch:{ all -> 0x00ae }
        r5 = "Not enough space to show ad. Needs ";
        r2 = r2.append(r5);	 Catch:{ all -> 0x00ae }
        r5 = r9.qI;	 Catch:{ all -> 0x00ae }
        r5 = r5.widthPixels;	 Catch:{ all -> 0x00ae }
        r5 = (float) r5;	 Catch:{ all -> 0x00ae }
        r5 = r5 / r0;
        r5 = (int) r5;	 Catch:{ all -> 0x00ae }
        r2 = r2.append(r5);	 Catch:{ all -> 0x00ae }
        r5 = "x";
        r2 = r2.append(r5);	 Catch:{ all -> 0x00ae }
        r5 = r9.qI;	 Catch:{ all -> 0x00ae }
        r5 = r5.heightPixels;	 Catch:{ all -> 0x00ae }
        r5 = (float) r5;	 Catch:{ all -> 0x00ae }
        r5 = r5 / r0;
        r5 = (int) r5;	 Catch:{ all -> 0x00ae }
        r2 = r2.append(r5);	 Catch:{ all -> 0x00ae }
        r5 = " dp, but only has ";
        r2 = r2.append(r5);	 Catch:{ all -> 0x00ae }
        r3 = (float) r3;	 Catch:{ all -> 0x00ae }
        r3 = r3 / r0;
        r3 = (int) r3;	 Catch:{ all -> 0x00ae }
        r2 = r2.append(r3);	 Catch:{ all -> 0x00ae }
        r3 = "x";
        r2 = r2.append(r3);	 Catch:{ all -> 0x00ae }
        r1 = (float) r1;	 Catch:{ all -> 0x00ae }
        r0 = r1 / r0;
        r0 = (int) r0;	 Catch:{ all -> 0x00ae }
        r0 = r2.append(r0);	 Catch:{ all -> 0x00ae }
        r1 = " dp.";
        r0 = r0.append(r1);	 Catch:{ all -> 0x00ae }
        r0 = r0.toString();	 Catch:{ all -> 0x00ae }
        com.google.android.gms.internal.gr.W(r0);	 Catch:{ all -> 0x00ae }
        r0 = r9.getVisibility();	 Catch:{ all -> 0x00ae }
        if (r0 == r7) goto L_0x00a6;
    L_0x00a2:
        r0 = 4;
        r9.setVisibility(r0);	 Catch:{ all -> 0x00ae }
    L_0x00a6:
        r0 = 0;
        r1 = 0;
        r9.setMeasuredDimension(r0, r1);	 Catch:{ all -> 0x00ae }
    L_0x00ab:
        monitor-exit(r4);	 Catch:{ all -> 0x00ae }
        goto L_0x001a;
    L_0x00ae:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x00ae }
        throw r0;
    L_0x00b1:
        r0 = r9.getVisibility();	 Catch:{ all -> 0x00ae }
        if (r0 == r7) goto L_0x00bb;
    L_0x00b7:
        r0 = 0;
        r9.setVisibility(r0);	 Catch:{ all -> 0x00ae }
    L_0x00bb:
        r0 = r9.qI;	 Catch:{ all -> 0x00ae }
        r0 = r0.widthPixels;	 Catch:{ all -> 0x00ae }
        r1 = r9.qI;	 Catch:{ all -> 0x00ae }
        r1 = r1.heightPixels;	 Catch:{ all -> 0x00ae }
        r9.setMeasuredDimension(r0, r1);	 Catch:{ all -> 0x00ae }
        goto L_0x00ab;
    L_0x00c7:
        r2 = r0;
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gu.onMeasure(int, int):void");
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.tl != null) {
            this.tl.a(event);
        }
        return super.onTouchEvent(event);
    }

    public void q(boolean z) {
        synchronized (this.mH) {
            if (this.wY != null) {
                this.wY.q(z);
            } else {
                this.xc = z;
            }
        }
    }

    public void setContext(Context context) {
        this.wX.setBaseContext(context);
    }

    public void z(boolean z) {
        synchronized (this.mH) {
            this.wZ = z;
            dJ();
        }
    }
}
