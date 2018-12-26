package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import java.util.Locale;

@ey
public final class fv {
    public final boolean vA;
    public final boolean vB;
    public final int vC;
    public final int vg;
    public final boolean vh;
    public final boolean vi;
    public final String vj;
    public final String vk;
    public final boolean vl;
    public final boolean vm;
    public final boolean vn;
    public final String vo;
    public final String vp;
    public final int vq;
    public final int vr;
    public final int vs;
    public final int vt;
    public final int vu;
    public final int vv;
    public final float vw;
    public final int vx;
    public final int vy;
    public final double vz;

    public fv(Context context) {
        boolean z = true;
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Locale locale = Locale.getDefault();
        PackageManager packageManager = context.getPackageManager();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.vg = audioManager.getMode();
        this.vh = a(packageManager, "geo:0,0?q=donuts") != null;
        this.vi = a(packageManager, "http://www.google.com") != null;
        this.vj = telephonyManager.getNetworkOperator();
        this.vk = locale.getCountry();
        this.vl = gq.dA();
        this.vm = audioManager.isMusicActive();
        this.vn = audioManager.isSpeakerphoneOn();
        this.vo = locale.getLanguage();
        this.vp = a(packageManager);
        this.vq = audioManager.getStreamVolume(3);
        this.vr = a(context, connectivityManager, packageManager);
        this.vs = telephonyManager.getNetworkType();
        this.vt = telephonyManager.getPhoneType();
        this.vu = audioManager.getRingerMode();
        this.vv = audioManager.getStreamVolume(2);
        this.vw = displayMetrics.density;
        this.vx = displayMetrics.widthPixels;
        this.vy = displayMetrics.heightPixels;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            this.vz = (double) (((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
            if (!(intExtra == 2 || intExtra == 5)) {
                z = false;
            }
            this.vA = z;
        } else {
            this.vz = -1.0d;
            this.vA = false;
        }
        if (VERSION.SDK_INT >= 16) {
            this.vB = connectivityManager.isActiveNetworkMetered();
            if (connectivityManager.getActiveNetworkInfo() != null) {
                this.vC = connectivityManager.getActiveNetworkInfo().getDetailedState().ordinal();
                return;
            } else {
                this.vC = -1;
                return;
            }
        }
        this.vB = false;
        this.vC = -1;
    }

    private static int a(Context context, ConnectivityManager connectivityManager, PackageManager packageManager) {
        if (!gi.a(packageManager, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
            return -2;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null ? activeNetworkInfo.getType() : -1;
    }

    private static ResolveInfo a(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }

    private static String a(PackageManager packageManager) {
        String str = null;
        ResolveInfo a = a(packageManager, "market://details?id=com.google.android.gms.ads");
        if (a != null) {
            ActivityInfo activityInfo = a.activityInfo;
            if (activityInfo != null) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(activityInfo.packageName, 0);
                    if (packageInfo != null) {
                        str = packageInfo.versionCode + "." + activityInfo.packageName;
                    }
                } catch (NameNotFoundException e) {
                }
            }
        }
        return str;
    }
}
