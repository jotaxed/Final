package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d;
import java.util.Map;

class z extends aj {
    private static final String ID = a.DEVICE_ID.toString();
    private final Context mContext;

    public z(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public d.a B(Map<String, d.a> map) {
        String Y = Y(this.mContext);
        return Y == null ? di.rb() : di.u(Y);
    }

    protected String Y(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    public boolean pe() {
        return true;
    }
}
