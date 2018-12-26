package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d;
import java.util.Map;

class ca extends aj {
    private static final String ID = a.OS_VERSION.toString();

    public ca() {
        super(ID, new String[0]);
    }

    public d.a B(Map<String, d.a> map) {
        return di.u(VERSION.RELEASE);
    }

    public boolean pe() {
        return true;
    }
}
