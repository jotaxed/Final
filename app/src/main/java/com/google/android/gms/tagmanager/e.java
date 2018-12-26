package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d;
import java.util.Map;

class e extends aj {
    private static final String ID = a.ADWORDS_CLICK_REFERRER.toString();
    private static final String aqd = b.COMPONENT.toString();
    private static final String aqe = b.CONVERSION_ID.toString();
    private final Context lM;

    public e(Context context) {
        super(ID, aqe);
        this.lM = context;
    }

    public d.a B(Map<String, d.a> map) {
        d.a aVar = (d.a) map.get(aqe);
        if (aVar == null) {
            return di.rb();
        }
        String j = di.j(aVar);
        aVar = (d.a) map.get(aqd);
        String f = ay.f(this.lM, j, aVar != null ? di.j(aVar) : null);
        return f != null ? di.u(f) : di.rb();
    }

    public boolean pe() {
        return true;
    }
}
