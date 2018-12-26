package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.jl.f;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class jn implements Callback {
    private static final Object Nd = new Object();
    private static jn Ne;
    private final HashMap<String, a> Nf = new HashMap();
    private final Handler mHandler;
    private final Context mO;

    final class a {
        private final String Ng;
        private final a Nh = new a(this);
        private final HashSet<f> Ni = new HashSet();
        private boolean Nj;
        private IBinder Nk;
        private ComponentName Nl;
        final /* synthetic */ jn Nm;
        private int mState = 2;

        public class a implements ServiceConnection {
            final /* synthetic */ a Nn;

            public a(a aVar) {
                this.Nn = aVar;
            }

            public void onServiceConnected(ComponentName component, IBinder binder) {
                synchronized (this.Nn.Nm.Nf) {
                    this.Nn.Nk = binder;
                    this.Nn.Nl = component;
                    Iterator it = this.Nn.Ni.iterator();
                    while (it.hasNext()) {
                        ((f) it.next()).onServiceConnected(component, binder);
                    }
                    this.Nn.mState = 1;
                }
            }

            public void onServiceDisconnected(ComponentName component) {
                synchronized (this.Nn.Nm.Nf) {
                    this.Nn.Nk = null;
                    this.Nn.Nl = component;
                    Iterator it = this.Nn.Ni.iterator();
                    while (it.hasNext()) {
                        ((f) it.next()).onServiceDisconnected(component);
                    }
                    this.Nn.mState = 2;
                }
            }
        }

        public a(jn jnVar, String str) {
            this.Nm = jnVar;
            this.Ng = str;
        }

        public void a(f fVar) {
            this.Ni.add(fVar);
        }

        public void b(f fVar) {
            this.Ni.remove(fVar);
        }

        public boolean c(f fVar) {
            return this.Ni.contains(fVar);
        }

        public IBinder getBinder() {
            return this.Nk;
        }

        public ComponentName getComponentName() {
            return this.Nl;
        }

        public int getState() {
            return this.mState;
        }

        public void hA() {
            this.Nj = this.Nm.mO.bindService(new Intent(this.Ng).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), this.Nh, 129);
            if (this.Nj) {
                this.mState = 3;
            } else {
                this.Nm.mO.unbindService(this.Nh);
            }
        }

        public void hB() {
            this.Nm.mO.unbindService(this.Nh);
            this.Nj = false;
            this.mState = 2;
        }

        public String hC() {
            return this.Ng;
        }

        public boolean hD() {
            return this.Ni.isEmpty();
        }

        public boolean isBound() {
            return this.Nj;
        }
    }

    private jn(Context context) {
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.mO = context.getApplicationContext();
    }

    public static jn J(Context context) {
        synchronized (Nd) {
            if (Ne == null) {
                Ne = new jn(context.getApplicationContext());
            }
        }
        return Ne;
    }

    public boolean a(String str, f fVar) {
        boolean isBound;
        synchronized (this.Nf) {
            a aVar = (a) this.Nf.get(str);
            if (aVar != null) {
                this.mHandler.removeMessages(0, aVar);
                if (!aVar.c(fVar)) {
                    aVar.a((f) fVar);
                    switch (aVar.getState()) {
                        case 1:
                            fVar.onServiceConnected(aVar.getComponentName(), aVar.getBinder());
                            break;
                        case 2:
                            aVar.hA();
                            break;
                        default:
                            break;
                    }
                }
                throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + str);
            }
            aVar = new a(this, str);
            aVar.a((f) fVar);
            aVar.hA();
            this.Nf.put(str, aVar);
            isBound = aVar.isBound();
        }
        return isBound;
    }

    public void b(String str, f fVar) {
        synchronized (this.Nf) {
            a aVar = (a) this.Nf.get(str);
            if (aVar == null) {
                throw new IllegalStateException("Nonexistent connection status for service action: " + str);
            } else if (aVar.c(fVar)) {
                aVar.b(fVar);
                if (aVar.hD()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, aVar), 5000);
                }
            } else {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + str);
            }
        }
    }

    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case 0:
                a aVar = (a) msg.obj;
                synchronized (this.Nf) {
                    if (aVar.hD()) {
                        aVar.hB();
                        this.Nf.remove(aVar.hC());
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
