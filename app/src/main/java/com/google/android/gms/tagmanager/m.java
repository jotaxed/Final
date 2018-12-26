package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d;
import java.util.Map;

class m extends aj {
    private static final String ID = a.CONSTANT.toString();
    private static final String VALUE = b.VALUE.toString();

    public m() {
        super(ID, VALUE);
    }

    public static String ph() {
        return ID;
    }

    public static String pi() {
        return VALUE;
    }

    public d.a B(Map<String, d.a> map) {
        return (d.a) map.get(VALUE);
    }

    public boolean pe() {
        return true;
    }
}
