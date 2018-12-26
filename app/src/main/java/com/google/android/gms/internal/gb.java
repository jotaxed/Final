package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;

@ey
public class gb {
    private final Object mH = new Object();
    private final String vZ;
    private int wm = 0;
    private long wn = -1;
    private long wo = -1;
    private int wp = 0;
    private int wq = -1;

    public gb(String str) {
        this.vZ = str;
    }

    public static boolean m(Context context) {
        int identifier = context.getResources().getIdentifier("Theme.Translucent", "style", "android");
        if (identifier == 0) {
            gr.U("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            gr.U("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (NameNotFoundException e) {
            gr.W("Fail to fetch AdActivity theme");
            gr.U("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    public Bundle b(Context context, String str) {
        Bundle bundle;
        synchronized (this.mH) {
            bundle = new Bundle();
            bundle.putString("session_id", this.vZ);
            bundle.putLong("basets", this.wo);
            bundle.putLong("currts", this.wn);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.wq);
            bundle.putInt("pclick", this.wm);
            bundle.putInt("pimp", this.wp);
            bundle.putBoolean("support_transparent_background", m(context));
        }
        return bundle;
    }

    public void b(av avVar, long j) {
        synchronized (this.mH) {
            if (this.wo == -1) {
                this.wo = j;
                this.wn = this.wo;
            } else {
                this.wn = j;
            }
            if (avVar.extras == null || avVar.extras.getInt("gw", 2) != 1) {
                this.wq++;
                return;
            }
        }
    }

    public void cW() {
        synchronized (this.mH) {
            this.wp++;
        }
    }

    public void cX() {
        synchronized (this.mH) {
            this.wm++;
        }
    }

    public long dq() {
        return this.wo;
    }
}
