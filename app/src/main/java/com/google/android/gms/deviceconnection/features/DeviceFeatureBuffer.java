package com.google.android.gms.deviceconnection.features;

import com.google.android.gms.common.data.DataBuffer;

public class DeviceFeatureBuffer extends DataBuffer<DeviceFeature> {
    public DeviceFeature get(int position) {
        return new a(this.JG, position);
    }
}
