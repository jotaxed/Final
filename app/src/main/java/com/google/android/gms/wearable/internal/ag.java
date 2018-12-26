package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

abstract class ag<T> {
    private final HashMap<T, bb> agU = new HashMap();

    private static class a<T> extends a<Status> {
        private WeakReference<Map<T, bb>> axP;
        private WeakReference<T> axQ;

        a(Map<T, bb> map, T t, com.google.android.gms.common.api.BaseImplementation.b<Status> bVar) {
            super(bVar);
            this.axP = new WeakReference(map);
            this.axQ = new WeakReference(t);
        }

        public void a(Status status) {
            Map map = (Map) this.axP.get();
            Object obj = this.axQ.get();
            if (!(status.getStatus().isSuccess() || map == null || obj == null)) {
                synchronized (map) {
                    bb bbVar = (bb) map.remove(obj);
                    if (bbVar != null) {
                        bbVar.clear();
                    }
                }
            }
            A(status);
        }
    }

    static final class b extends ag<DataListener> {
        b() {
        }

        bb a(DataListener dataListener, IntentFilter[] intentFilterArr) {
            return bb.b(dataListener, intentFilterArr);
        }
    }

    static final class c extends ag<MessageListener> {
        c() {
        }

        bb a(MessageListener messageListener, IntentFilter[] intentFilterArr) {
            return bb.b(messageListener, intentFilterArr);
        }
    }

    static final class d extends ag<NodeListener> {
        d() {
        }

        bb a(NodeListener nodeListener, IntentFilter[] intentFilterArr) {
            return bb.a(nodeListener);
        }
    }

    private static class e<T> extends a<Status> {
        private WeakReference<Map<T, bb>> axP;
        private WeakReference<T> axQ;

        e(Map<T, bb> map, T t, com.google.android.gms.common.api.BaseImplementation.b<Status> bVar) {
            super(bVar);
            this.axP = new WeakReference(map);
            this.axQ = new WeakReference(t);
        }

        public void a(Status status) {
            Map map = (Map) this.axP.get();
            Object obj = this.axQ.get();
            if (!(status.getStatus().getStatusCode() != 4002 || map == null || obj == null)) {
                synchronized (map) {
                    bb bbVar = (bb) map.remove(obj);
                    if (bbVar != null) {
                        bbVar.clear();
                    }
                }
            }
            A(status);
        }
    }

    ag() {
    }

    abstract bb a(T t, IntentFilter[] intentFilterArr);

    public void a(ba baVar, com.google.android.gms.common.api.BaseImplementation.b<Status> bVar, T t) throws RemoteException {
        synchronized (this.agU) {
            bb bbVar = (bb) this.agU.remove(t);
            if (bbVar == null) {
                bVar.b(new Status(4002));
                return;
            }
            bbVar.clear();
            ((af) baVar.hw()).a(new e(this.agU, t, bVar), new ar(bbVar));
        }
    }

    public void a(ba baVar, com.google.android.gms.common.api.BaseImplementation.b<Status> bVar, T t, IntentFilter[] intentFilterArr) throws RemoteException {
        bb a = a(t, intentFilterArr);
        synchronized (this.agU) {
            if (this.agU.get(t) != null) {
                bVar.b(new Status(4001));
                return;
            }
            this.agU.put(t, a);
            try {
                ((af) baVar.hw()).a(new a(this.agU, t, bVar), new b(a));
            } catch (RemoteException e) {
                this.agU.remove(t);
                throw e;
            }
        }
    }

    public void b(ba baVar) {
        synchronized (this.agU) {
            ad hVar = new h();
            for (Entry entry : this.agU.entrySet()) {
                bb bbVar = (bb) entry.getValue();
                if (bbVar != null) {
                    bbVar.clear();
                    if (baVar.isConnected()) {
                        try {
                            ((af) baVar.hw()).a(hVar, new ar(bbVar));
                            if (Log.isLoggable("WearableClient", 2)) {
                                Log.d("WearableClient", "disconnect: removed: " + entry.getKey() + "/" + bbVar);
                            }
                        } catch (RemoteException e) {
                            Log.w("WearableClient", "disconnect: Didn't remove: " + entry.getKey() + "/" + bbVar);
                        }
                    } else {
                        continue;
                    }
                }
            }
            this.agU.clear();
        }
    }

    public void ca(IBinder iBinder) {
        synchronized (this.agU) {
            af bZ = com.google.android.gms.wearable.internal.af.a.bZ(iBinder);
            ad hVar = new h();
            for (Entry entry : this.agU.entrySet()) {
                bb bbVar = (bb) entry.getValue();
                try {
                    bZ.a(hVar, new b(bbVar));
                    if (Log.isLoggable("WearableClient", 2)) {
                        Log.d("WearableClient", "onPostInitHandler: added: " + entry.getKey() + "/" + bbVar);
                    }
                } catch (RemoteException e) {
                    Log.d("WearableClient", "onPostInitHandler: Didn't add: " + entry.getKey() + "/" + bbVar);
                }
            }
        }
    }
}
