package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;
import java.util.Map;

abstract class dg extends aj {
    public dg(String str, String... strArr) {
        super(str, strArr);
    }

    public a B(Map<String, a> map) {
        D(map);
        return di.rb();
    }

    public abstract void D(Map<String, a> map);

    public boolean pe() {
        return false;
    }
}
