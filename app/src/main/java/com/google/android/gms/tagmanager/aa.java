package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d;
import java.util.Map;

class aa extends aj {
    private static final String ID = a.DEVICE_NAME.toString();

    public aa() {
        super(ID, new String[0]);
    }

    public d.a B(Map<String, d.a> map) {
        String str = Build.MANUFACTURER;
        Object obj = Build.MODEL;
        if (!(obj.startsWith(str) || str.equals(FitnessActivities.UNKNOWN))) {
            obj = str + " " + obj;
        }
        return di.u(obj);
    }

    public boolean pe() {
        return true;
    }
}
