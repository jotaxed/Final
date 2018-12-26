package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.google.android.gms.internal.ah.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public final class af implements OnGlobalLayoutListener, OnScrollChangedListener {
    private final Object mH;
    private final WeakReference<fy> mK;
    private WeakReference<ViewTreeObserver> mL;
    private final WeakReference<View> mM;
    private final ad mN;
    private final Context mO;
    private final ah mP;
    private boolean mQ;
    private final WindowManager mR;
    private final PowerManager mS;
    private final KeyguardManager mT;
    private ag mU;
    private boolean mV;
    private final BlockingQueue<Runnable> mW;
    private long mX;
    private boolean mY;
    private boolean mZ;
    private boolean my;
    private BroadcastReceiver na;
    private final HashSet<ac> nb;

    public af(Context context, ay ayVar, fy fyVar, View view, gs gsVar) {
        this(ayVar, fyVar, gsVar, view, new aj(context, gsVar));
    }

    public af(ay ayVar, fy fyVar, gs gsVar, final View view, ah ahVar) {
        this.mH = new Object();
        this.my = false;
        this.mV = false;
        this.mW = new ArrayBlockingQueue(2);
        this.mX = Long.MIN_VALUE;
        this.nb = new HashSet();
        this.mK = new WeakReference(fyVar);
        this.mM = new WeakReference(view);
        this.mL = new WeakReference(null);
        this.mY = true;
        this.mN = new ad(UUID.randomUUID().toString(), gsVar, ayVar.op, fyVar.vD);
        this.mP = ahVar;
        this.mR = (WindowManager) view.getContext().getSystemService("window");
        this.mS = (PowerManager) view.getContext().getApplicationContext().getSystemService("power");
        this.mT = (KeyguardManager) view.getContext().getSystemService("keyguard");
        this.mO = view.getContext().getApplicationContext();
        a(ahVar);
        this.mP.a(new a(this) {
            final /* synthetic */ af nd;

            public void aR() {
                this.nd.mQ = true;
                this.nd.d(view);
                this.nd.aI();
            }
        });
        b(this.mP);
        try {
            final JSONObject e = e(view);
            this.mW.add(new Runnable(this) {
                final /* synthetic */ af nd;

                public void run() {
                    this.nd.a(e);
                }
            });
        } catch (Throwable th) {
        }
        this.mW.add(new Runnable(this) {
            final /* synthetic */ af nd;

            {
                this.nd = r1;
            }

            public void run() {
                this.nd.g(false);
            }
        });
        gr.S("Tracking ad unit: " + this.mN.aH());
    }

    protected int a(int i, DisplayMetrics displayMetrics) {
        return (int) (((float) i) / displayMetrics.density);
    }

    protected void a(View view, Map<String, String> map) {
        g(false);
    }

    public void a(ac acVar) {
        this.nb.add(acVar);
    }

    public void a(ag agVar) {
        synchronized (this.mH) {
            this.mU = agVar;
        }
    }

    protected void a(ah ahVar) {
        ahVar.f("https://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.html");
    }

    protected void a(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONArray.put(jSONObject);
            jSONObject2.put("units", jSONArray);
            this.mP.a("AFMA_updateActiveView", jSONObject2);
        } catch (Throwable th) {
            gr.b("Skipping active view message.", th);
        }
    }

    protected boolean a(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        boolean z = !TextUtils.isEmpty(str) && str.equals(this.mN.aH());
        return z;
    }

    protected void aI() {
        synchronized (this.mH) {
            if (this.na != null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.na = new BroadcastReceiver(this) {
                final /* synthetic */ af nd;

                {
                    this.nd = r1;
                }

                public void onReceive(Context context, Intent intent) {
                    this.nd.g(false);
                }
            };
            this.mO.registerReceiver(this.na, intentFilter);
        }
    }

    protected void aJ() {
        synchronized (this.mH) {
            if (this.na != null) {
                this.mO.unregisterReceiver(this.na);
                this.na = null;
            }
        }
    }

    public void aK() {
        synchronized (this.mH) {
            if (this.mY) {
                this.mZ = true;
                try {
                    a(aQ());
                } catch (Throwable e) {
                    gr.b("JSON Failure while processing active view data.", e);
                }
                gr.S("Untracking ad unit: " + this.mN.aH());
            }
        }
    }

    protected void aL() {
        if (this.mU != null) {
            this.mU.a(this);
        }
    }

    public boolean aM() {
        boolean z;
        synchronized (this.mH) {
            z = this.mY;
        }
        return z;
    }

    protected void aN() {
        View view = (View) this.mM.get();
        if (view != null) {
            ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.mL.get();
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2 != viewTreeObserver) {
                this.mL = new WeakReference(viewTreeObserver2);
                viewTreeObserver2.addOnScrollChangedListener(this);
                viewTreeObserver2.addOnGlobalLayoutListener(this);
            }
        }
    }

    protected void aO() {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.mL.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }

    protected JSONObject aP() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("afmaVersion", this.mN.aF()).put("activeViewJSON", this.mN.aG()).put("timestamp", ga.dc().dd().elapsedRealtime()).put("adFormat", this.mN.aE()).put("hashCode", this.mN.aH());
        return jSONObject;
    }

    protected JSONObject aQ() throws JSONException {
        JSONObject aP = aP();
        aP.put("doneReasonCode", "u");
        return aP;
    }

    protected void b(ah ahVar) {
        ahVar.a("/updateActiveView", new cd(this) {
            final /* synthetic */ af nd;

            {
                this.nd = r1;
            }

            public void a(gu guVar, Map<String, String> map) {
                if (this.nd.a((Map) map)) {
                    this.nd.a((View) guVar, (Map) map);
                }
            }
        });
        ahVar.a("/untrackActiveViewUnit", new cd(this) {
            final /* synthetic */ af nd;

            {
                this.nd = r1;
            }

            public void a(gu guVar, Map<String, String> map) {
                if (this.nd.a((Map) map)) {
                    gr.S("Received request to untrack: " + this.nd.mN.aH());
                    this.nd.destroy();
                }
            }
        });
        ahVar.a("/visibilityChanged", new cd(this) {
            final /* synthetic */ af nd;

            {
                this.nd = r1;
            }

            public void a(gu guVar, Map<String, String> map) {
                if (this.nd.a((Map) map) && map.containsKey("isVisible")) {
                    boolean z = "1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible"));
                    this.nd.f(Boolean.valueOf(z).booleanValue());
                }
            }
        });
        ahVar.a("/viewabilityChanged", cc.pQ);
    }

    protected void d(View view) {
        Object arrayList = new ArrayList();
        this.mW.drainTo(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    protected void destroy() {
        synchronized (this.mH) {
            aO();
            aJ();
            this.mY = false;
            try {
                this.mP.destroy();
            } catch (Throwable th) {
            }
            aL();
        }
    }

    protected JSONObject e(View view) throws JSONException {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr);
        view.getLocationInWindow(iArr2);
        JSONObject aP = aP();
        DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        rect2.right = this.mR.getDefaultDisplay().getWidth();
        rect2.bottom = this.mR.getDefaultDisplay().getHeight();
        Rect rect3 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect3, null);
        Rect rect4 = new Rect();
        boolean localVisibleRect = view.getLocalVisibleRect(rect4);
        Rect rect5 = new Rect();
        view.getHitRect(rect5);
        aP.put("viewBox", new JSONObject().put("top", a(rect2.top, displayMetrics)).put("bottom", a(rect2.bottom, displayMetrics)).put("left", a(rect2.left, displayMetrics)).put("right", a(rect2.right, displayMetrics))).put("adBox", new JSONObject().put("top", a(rect.top, displayMetrics)).put("bottom", a(rect.bottom, displayMetrics)).put("left", a(rect.left, displayMetrics)).put("right", a(rect.right, displayMetrics))).put("globalVisibleBox", new JSONObject().put("top", a(rect3.top, displayMetrics)).put("bottom", a(rect3.bottom, displayMetrics)).put("left", a(rect3.left, displayMetrics)).put("right", a(rect3.right, displayMetrics))).put("globalVisibleBoxVisible", globalVisibleRect).put("localVisibleBox", new JSONObject().put("top", a(rect4.top, displayMetrics)).put("bottom", a(rect4.bottom, displayMetrics)).put("left", a(rect4.left, displayMetrics)).put("right", a(rect4.right, displayMetrics))).put("localVisibleBoxVisible", localVisibleRect).put("hitBox", new JSONObject().put("top", a(rect5.top, displayMetrics)).put("bottom", a(rect5.bottom, displayMetrics)).put("left", a(rect5.left, displayMetrics)).put("right", a(rect5.right, displayMetrics))).put("windowVisibility", view.getWindowVisibility()).put("screenDensity", (double) displayMetrics.density).put("isVisible", f(view)).put("isStopped", this.mV).put("isPaused", this.my);
        if (ll.im()) {
            aP.put("isAttachedToWindow", view.isAttachedToWindow());
        }
        return aP;
    }

    protected void f(boolean z) {
        Iterator it = this.nb.iterator();
        while (it.hasNext()) {
            ((ac) it.next()).a(this, z);
        }
    }

    protected boolean f(View view) {
        return view.getVisibility() == 0 && view.isShown() && this.mS.isScreenOn() && !this.mT.inKeyguardRestrictedInputMode();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void g(boolean r9) {
        /*
        r8 = this;
        r2 = r8.mH;
        monitor-enter(r2);
        r0 = r8.mQ;	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r0 = r8.mY;	 Catch:{ all -> 0x0026 }
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r2);	 Catch:{ all -> 0x0026 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = com.google.android.gms.internal.ga.dc();	 Catch:{ all -> 0x0026 }
        r0 = r0.dd();	 Catch:{ all -> 0x0026 }
        r0 = r0.elapsedRealtime();	 Catch:{ all -> 0x0026 }
        if (r9 == 0) goto L_0x0029;
    L_0x001b:
        r4 = r8.mX;	 Catch:{ all -> 0x0026 }
        r6 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r4 = r4 + r6;
        r3 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r3 <= 0) goto L_0x0029;
    L_0x0024:
        monitor-exit(r2);	 Catch:{ all -> 0x0026 }
        goto L_0x000c;
    L_0x0026:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0026 }
        throw r0;
    L_0x0029:
        r8.mX = r0;	 Catch:{ all -> 0x0026 }
        r0 = r8.mK;	 Catch:{ all -> 0x0026 }
        r0 = r0.get();	 Catch:{ all -> 0x0026 }
        r0 = (com.google.android.gms.internal.fy) r0;	 Catch:{ all -> 0x0026 }
        r1 = r8.mM;	 Catch:{ all -> 0x0026 }
        r1 = r1.get();	 Catch:{ all -> 0x0026 }
        r1 = (android.view.View) r1;	 Catch:{ all -> 0x0026 }
        if (r1 == 0) goto L_0x003f;
    L_0x003d:
        if (r0 != 0) goto L_0x0047;
    L_0x003f:
        r0 = 1;
    L_0x0040:
        if (r0 == 0) goto L_0x0049;
    L_0x0042:
        r8.aK();	 Catch:{ all -> 0x0026 }
        monitor-exit(r2);	 Catch:{ all -> 0x0026 }
        goto L_0x000c;
    L_0x0047:
        r0 = 0;
        goto L_0x0040;
    L_0x0049:
        r0 = r8.e(r1);	 Catch:{ JSONException -> 0x0058 }
        r8.a(r0);	 Catch:{ JSONException -> 0x0058 }
    L_0x0050:
        r8.aN();	 Catch:{ all -> 0x0026 }
        r8.aL();	 Catch:{ all -> 0x0026 }
        monitor-exit(r2);	 Catch:{ all -> 0x0026 }
        goto L_0x000c;
    L_0x0058:
        r0 = move-exception;
        r1 = "Active view update failed.";
        com.google.android.gms.internal.gr.a(r1, r0);	 Catch:{ all -> 0x0026 }
        goto L_0x0050;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.af.g(boolean):void");
    }

    public void onGlobalLayout() {
        g(false);
    }

    public void onScrollChanged() {
        g(true);
    }

    public void pause() {
        synchronized (this.mH) {
            this.my = true;
            g(false);
            this.mP.pause();
        }
    }

    public void resume() {
        synchronized (this.mH) {
            this.mP.resume();
            this.my = false;
            g(false);
        }
    }

    public void stop() {
        synchronized (this.mH) {
            this.mV = true;
            g(false);
            this.mP.pause();
        }
    }
}
