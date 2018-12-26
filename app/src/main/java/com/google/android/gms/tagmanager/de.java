package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d;
import java.util.Map;

class de extends aj {
    private static final String ID = a.TIME.toString();

    public de() {
        super(ID, new String[0]);
    }

    public d.a B(Map<String, d.a> map) {
        return di.u(Long.valueOf(System.currentTimeMillis()));
    }

    public boolean pe() {
        return false;
    }
}
