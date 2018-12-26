package com.google.android.gms.deviceconnection.features;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.internal.jv;

public final class a extends d implements DeviceFeature {
    public a(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public String getFeatureName() {
        return getString("feature_name");
    }

    public long getLastConnectionTimestampMillis() {
        return getLong("last_connection_timestamp");
    }

    public String toString() {
        return jv.h(this).a("FeatureName", getFeatureName()).a("Timestamp", Long.valueOf(getLastConnectionTimestampMillis())).toString();
    }
}
