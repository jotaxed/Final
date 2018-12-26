package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d;
import java.util.Map;

class h extends aj {
    private static final String ID = a.APP_VERSION.toString();
    private final Context mContext;

    public h(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public d.a B(Map<String, d.a> map) {
        try {
            return di.u(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
        } catch (NameNotFoundException e) {
            bh.T("Package name " + this.mContext.getPackageName() + " not found. " + e.getMessage());
            return di.rb();
        }
    }

    public boolean pe() {
        return true;
    }
}
