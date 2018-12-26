package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.jx;

public final class d<L> {
    private final a Kt;
    private volatile L mListener;

    public interface b<L> {
        void c(L l);

        void gG();
    }

    private final class a extends Handler {
        final /* synthetic */ d Ku;

        public a(d dVar, Looper looper) {
            this.Ku = dVar;
            super(looper);
        }

        public void handleMessage(Message msg) {
            boolean z = true;
            if (msg.what != 1) {
                z = false;
            }
            jx.L(z);
            this.Ku.b((b) msg.obj);
        }
    }

    d(Looper looper, L l) {
        this.Kt = new a(this, looper);
        this.mListener = jx.b((Object) l, (Object) "Listener must not be null");
    }

    public void a(b<? super L> bVar) {
        jx.b((Object) bVar, (Object) "Notifier must not be null");
        this.Kt.sendMessage(this.Kt.obtainMessage(1, bVar));
    }

    void b(b<? super L> bVar) {
        Object obj = this.mListener;
        if (obj == null) {
            bVar.gG();
            return;
        }
        try {
            bVar.c(obj);
        } catch (Throwable e) {
            Log.w("ListenerHolder", "Notifying listener failed", e);
            bVar.gG();
        }
    }

    public void clear() {
        this.mListener = null;
    }
}
