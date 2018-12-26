package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebSettings;

@ey
public final class go {
    public static void a(Context context, WebSettings webSettings) {
        gm.a(context, webSettings);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
    }

    public static String getDefaultUserAgent(Context context) {
        return WebSettings.getDefaultUserAgent(context);
    }
}
