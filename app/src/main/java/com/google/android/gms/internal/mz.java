package com.google.android.gms.internal;

import android.content.Context;

public class mz {
    private final String DZ;
    private final np<ni> Ee;
    private final String JK;
    private na agz = null;
    private final Context mContext;

    private mz(Context context, String str, String str2, np<ni> npVar) {
        this.mContext = context;
        this.DZ = str;
        this.Ee = npVar;
        this.JK = str2;
    }

    public static mz a(Context context, String str, String str2, np<ni> npVar) {
        return new mz(context, str, str2, npVar);
    }
}
