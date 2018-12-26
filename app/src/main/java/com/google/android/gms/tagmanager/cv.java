package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d;
import java.util.Map;

class cv extends aj {
    private static final String ID = a.SDK_VERSION.toString();

    public cv() {
        super(ID, new String[0]);
    }

    public d.a B(Map<String, d.a> map) {
        return di.u(Integer.valueOf(VERSION.SDK_INT));
    }

    public boolean pe() {
        return true;
    }
}
