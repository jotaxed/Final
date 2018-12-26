package com.google.android.gms.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class an extends Thread {
    private final Object mH;
    private boolean mStarted = false;
    private boolean nC = false;
    private boolean nD = false;
    private final am nE;
    private final al nF;
    private final ex nG;
    private final int nH;
    private final int nI;
    private final int nJ;
    private final int np;
    private final int nr;

    @ey
    class a {
        final /* synthetic */ an nL;
        final int nQ;
        final int nR;

        a(an anVar, int i, int i2) {
            this.nL = anVar;
            this.nQ = i;
            this.nR = i2;
        }
    }

    public an(am amVar, al alVar, Bundle bundle, ex exVar) {
        this.nE = amVar;
        this.nF = alVar;
        this.nG = exVar;
        this.mH = new Object();
        this.np = bundle.getInt(bn.pq.getKey());
        this.nI = bundle.getInt(bn.pr.getKey());
        this.nr = bundle.getInt(bn.ps.getKey());
        this.nJ = bundle.getInt(bn.pt.getKey());
        this.nH = bundle.getInt(bn.pu.getKey(), 10);
        setName("ContentFetchTask");
    }

    private void a(Activity activity) {
        if (activity != null) {
            View view = null;
            if (!(activity.getWindow() == null || activity.getWindow().getDecorView() == null)) {
                view = activity.getWindow().getDecorView().findViewById(16908290);
            }
            if (view != null) {
                g(view);
            }
        }
    }

    private boolean a(final WebView webView, final ak akVar) {
        if (!ll.im()) {
            return false;
        }
        akVar.aW();
        webView.post(new Runnable(this) {
            final /* synthetic */ an nL;
            ValueCallback<String> nM = new ValueCallback<String>(this) {
                final /* synthetic */ AnonymousClass2 nP;

                {
                    this.nP = r1;
                }

                public void k(String str) {
                    this.nP.nL.a(akVar, webView, str);
                }

                public /* synthetic */ void onReceiveValue(Object x0) {
                    k((String) x0);
                }
            };

            public void run() {
                if (webView.getSettings().getJavaScriptEnabled()) {
                    webView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.nM);
                }
            }
        });
        return true;
    }

    private boolean bb() {
        try {
            Context context = this.nE.getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (activityManager == null || keyguardManager == null || powerManager == null) {
                return false;
            }
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode() && powerManager.isScreenOn()) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    a a(View view, ak akVar) {
        int i = 0;
        if (view == null) {
            return new a(this, 0, 0);
        }
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            akVar.i(((TextView) view).getText().toString());
            return new a(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof gu)) {
            akVar.aW();
            return a((WebView) view, akVar) ? new a(this, 0, 1) : new a(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new a(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = 0;
            int i3 = 0;
            while (i < viewGroup.getChildCount()) {
                a a = a(viewGroup.getChildAt(i), akVar);
                i3 += a.nQ;
                i2 += a.nR;
                i++;
            }
            return new a(this, i3, i2);
        }
    }

    void a(ak akVar, WebView webView, String str) {
        akVar.aV();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (TextUtils.isEmpty(webView.getTitle())) {
                    akVar.h(optString);
                } else {
                    akVar.h(webView.getTitle() + "\n" + optString);
                }
            }
            if (akVar.aS()) {
                this.nF.b(akVar);
            }
        } catch (JSONException e) {
            gr.S("Json string may be malformed.");
        } catch (Throwable th) {
            gr.a("Failed to get webview content.", th);
            this.nG.b(th);
        }
    }

    public void ba() {
        synchronized (this.mH) {
            if (this.mStarted) {
                gr.S("Content hash thread already started, quiting...");
                return;
            }
            this.mStarted = true;
            start();
        }
    }

    public ak bc() {
        return this.nF.aZ();
    }

    public void bd() {
        synchronized (this.mH) {
            this.nC = true;
            gr.S("ContentFetchThread: paused, mPause = " + this.nC);
        }
    }

    public boolean be() {
        return this.nC;
    }

    boolean g(final View view) {
        if (view == null) {
            return false;
        }
        view.post(new Runnable(this) {
            final /* synthetic */ an nL;

            public void run() {
                this.nL.h(view);
            }
        });
        return true;
    }

    void h(View view) {
        try {
            ak akVar = new ak(this.np, this.nI, this.nr, this.nJ);
            a a = a(view, akVar);
            akVar.aX();
            if (a.nQ != 0 || a.nR != 0) {
                if (a.nR != 0 || akVar.aY() != 0) {
                    if (a.nR != 0 || !this.nF.a(akVar)) {
                        this.nF.c(akVar);
                    }
                }
            }
        } catch (Throwable e) {
            gr.b("Exception in fetchContentOnUIThread", e);
            this.nG.b(e);
        }
    }

    public void run() {
        while (!this.nD) {
            try {
                if (bb()) {
                    Activity activity = this.nE.getActivity();
                    if (activity == null) {
                        gr.S("ContentFetchThread: no activity");
                    } else {
                        a(activity);
                    }
                } else {
                    gr.S("ContentFetchTask: sleeping");
                    bd();
                }
                Thread.sleep((long) (this.nH * 1000));
            } catch (Throwable th) {
                gr.b("Error in ContentFetchTask", th);
                this.nG.b(th);
            }
            synchronized (this.mH) {
                while (this.nC) {
                    try {
                        gr.S("ContentFetchTask: waiting");
                        this.mH.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

    public void wakeup() {
        synchronized (this.mH) {
            this.nC = false;
            this.mH.notifyAll();
            gr.S("ContentFetchThread: wakeup");
        }
    }
}
