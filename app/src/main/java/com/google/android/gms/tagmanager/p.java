package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d;
import java.util.Map;

class p extends aj {
    private static final String ID = a.CONTAINER_VERSION.toString();
    private final String TU;

    public p(String str) {
        super(ID, new String[0]);
        this.TU = str;
    }

    public d.a B(Map<String, d.a> map) {
        return this.TU == null ? di.rb() : di.u(this.TU);
    }

    public boolean pe() {
        return true;
    }
}
