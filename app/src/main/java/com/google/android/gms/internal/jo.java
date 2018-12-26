package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class jo {
    private static final Uri No = Uri.parse("http://plus.google.com/");
    private static final Uri Np = No.buildUpon().appendPath("circles").appendPath("find").build();

    public static Intent aY(String str) {
        Uri fromParts = Uri.fromParts("package", str, null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(fromParts);
        return intent;
    }

    private static Uri aZ(String str) {
        return Uri.parse("market://details").buildUpon().appendQueryParameter("id", str).build();
    }

    public static Intent ba(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(aZ(str));
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
        intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        return intent;
    }

    public static Intent hE() {
        Intent intent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        intent.setPackage("com.google.android.wearable.app");
        return intent;
    }
}
