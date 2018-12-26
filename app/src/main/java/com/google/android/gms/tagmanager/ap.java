package com.google.android.gms.tagmanager;

import android.text.TextUtils;

class ap {
    private final long Bv;
    private final long Bw;
    private String By;
    private final long arw;

    ap(long j, long j2, long j3) {
        this.Bv = j;
        this.Bw = j2;
        this.arw = j3;
    }

    void ak(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.By = str;
        }
    }

    long fb() {
        return this.Bv;
    }

    long pK() {
        return this.arw;
    }

    String pL() {
        return this.By;
    }
}
