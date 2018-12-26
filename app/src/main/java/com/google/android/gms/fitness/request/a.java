package com.google.android.gms.fitness.request;

import android.os.RemoteException;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.internal.jx;
import java.util.HashMap;
import java.util.Map;

public class a extends com.google.android.gms.fitness.request.l.a {
    private final BleScanCallback VC;

    public static class a {
        private static final a VD = new a();
        private final Map<BleScanCallback, a> VE = new HashMap();

        private a() {
        }

        public static a jP() {
            return VD;
        }

        public a a(BleScanCallback bleScanCallback) {
            a aVar;
            synchronized (this.VE) {
                aVar = (a) this.VE.get(bleScanCallback);
                if (aVar == null) {
                    aVar = new a(bleScanCallback);
                    this.VE.put(bleScanCallback, aVar);
                }
            }
            return aVar;
        }

        public a b(BleScanCallback bleScanCallback) {
            a aVar;
            synchronized (this.VE) {
                aVar = (a) this.VE.get(bleScanCallback);
                if (aVar != null) {
                } else {
                    aVar = new a(bleScanCallback);
                }
            }
            return aVar;
        }
    }

    private a(BleScanCallback bleScanCallback) {
        this.VC = (BleScanCallback) jx.i(bleScanCallback);
    }

    public void onDeviceFound(BleDevice device) throws RemoteException {
        this.VC.onDeviceFound(device);
    }

    public void onScanStopped() throws RemoteException {
        this.VC.onScanStopped();
    }
}
