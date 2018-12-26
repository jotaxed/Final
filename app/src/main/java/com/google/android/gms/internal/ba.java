package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.bf.a;

@ey
public final class ba extends a {
    private final AppEventListener os;

    public ba(AppEventListener appEventListener) {
        this.os = appEventListener;
    }

    public void onAppEvent(String name, String info) {
        this.os.onAppEvent(name, info);
    }
}
