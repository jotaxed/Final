package com.google.android.gms.fitness.service;

import android.os.RemoteException;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.k;
import com.google.android.gms.internal.jx;
import java.util.List;

class b implements SensorEventDispatcher {
    private final k VW;

    b(k kVar) {
        this.VW = (k) jx.i(kVar);
    }

    public void publish(DataPoint dataPoint) throws RemoteException {
        this.VW.c(dataPoint);
    }

    public void publish(List<DataPoint> dataPoints) throws RemoteException {
        for (DataPoint publish : dataPoints) {
            publish(publish);
        }
    }
}
