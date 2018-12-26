package com.google.android.gms.fitness.data;

import android.os.RemoteException;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.internal.jx;
import java.util.HashMap;
import java.util.Map;

public class l extends com.google.android.gms.fitness.data.k.a {
    private final OnDataPointListener UF;

    public static class a {
        private static final a UG = new a();
        private final Map<OnDataPointListener, l> UH = new HashMap();

        private a() {
        }

        public static a jG() {
            return UG;
        }

        public l a(OnDataPointListener onDataPointListener) {
            l lVar;
            synchronized (this.UH) {
                lVar = (l) this.UH.get(onDataPointListener);
                if (lVar == null) {
                    lVar = new l(onDataPointListener);
                    this.UH.put(onDataPointListener, lVar);
                }
            }
            return lVar;
        }

        public l b(OnDataPointListener onDataPointListener) {
            l lVar;
            synchronized (this.UH) {
                lVar = (l) this.UH.get(onDataPointListener);
            }
            return lVar;
        }

        public l c(OnDataPointListener onDataPointListener) {
            l lVar;
            synchronized (this.UH) {
                lVar = (l) this.UH.remove(onDataPointListener);
                if (lVar != null) {
                } else {
                    lVar = new l(onDataPointListener);
                }
            }
            return lVar;
        }
    }

    private l(OnDataPointListener onDataPointListener) {
        this.UF = (OnDataPointListener) jx.i(onDataPointListener);
    }

    public void c(DataPoint dataPoint) throws RemoteException {
        this.UF.onDataPoint(dataPoint);
    }
}
