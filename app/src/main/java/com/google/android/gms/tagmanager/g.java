package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d;
import java.util.Map;

class g extends aj {
    private static final String ID = a.APP_NAME.toString();
    private final Context mContext;

    public g(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public d.a B(Map<String, d.a> map) {
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            return di.u(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
        } catch (Throwable e) {
            bh.b("App name is not found.", e);
            return di.rb();
        }
    }

    public boolean pe() {
        return true;
    }
}
