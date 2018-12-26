package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d;
import java.util.Map;

class ah extends aj {
    private static final String ID = a.EVENT.toString();
    private final ct aqo;

    public ah(ct ctVar) {
        super(ID, new String[0]);
        this.aqo = ctVar;
    }

    public d.a B(Map<String, d.a> map) {
        String qE = this.aqo.qE();
        return qE == null ? di.rb() : di.u(qE);
    }

    public boolean pe() {
        return false;
    }
}
