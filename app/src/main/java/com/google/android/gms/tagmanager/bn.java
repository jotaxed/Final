package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

class bn {
    bn() {
    }

    public bm pO() {
        return pg() < 8 ? new av() : new aw();
    }

    int pg() {
        return VERSION.SDK_INT;
    }
}
