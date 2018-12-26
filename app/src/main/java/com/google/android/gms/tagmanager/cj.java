package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d;
import java.util.Map;

class cj extends aj {
    private static final String ID = a.RESOLUTION.toString();
    private final Context mContext;

    public cj(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public d.a B(Map<String, d.a> map) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        return di.u(i + "x" + displayMetrics.heightPixels);
    }

    public boolean pe() {
        return true;
    }
}
