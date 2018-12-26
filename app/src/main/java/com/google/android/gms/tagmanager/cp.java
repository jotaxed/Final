package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.c.j;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class cp implements e {
    private String aqI;
    private final String aqm;
    private bg<j> asC;
    private r asD;
    private final ScheduledExecutorService asF;
    private final a asG;
    private ScheduledFuture<?> asH;
    private boolean mClosed;
    private final Context mContext;

    interface b {
        ScheduledExecutorService qh();
    }

    interface a {
        co a(r rVar);
    }

    public cp(Context context, String str, r rVar) {
        this(context, str, rVar, null, null);
    }

    cp(Context context, String str, r rVar, b bVar, a aVar) {
        this.asD = rVar;
        this.mContext = context;
        this.aqm = str;
        if (bVar == null) {
            bVar = new b(this) {
                final /* synthetic */ cp asI;

                {
                    this.asI = r1;
                }

                public ScheduledExecutorService qh() {
                    return Executors.newSingleThreadScheduledExecutor();
                }
            };
        }
        this.asF = bVar.qh();
        if (aVar == null) {
            this.asG = new a(this) {
                final /* synthetic */ cp asI;

                {
                    this.asI = r1;
                }

                public co a(r rVar) {
                    return new co(this.asI.mContext, this.asI.aqm, rVar);
                }
            };
        } else {
            this.asG = aVar;
        }
    }

    private co cM(String str) {
        co a = this.asG.a(this.asD);
        a.a(this.asC);
        a.cw(this.aqI);
        a.cL(str);
        return a;
    }

    private synchronized void qg() {
        if (this.mClosed) {
            throw new IllegalStateException("called method after closed");
        }
    }

    public synchronized void a(bg<j> bgVar) {
        qg();
        this.asC = bgVar;
    }

    public synchronized void cw(String str) {
        qg();
        this.aqI = str;
    }

    public synchronized void e(long j, String str) {
        bh.V("loadAfterDelay: containerId=" + this.aqm + " delay=" + j);
        qg();
        if (this.asC == null) {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
        if (this.asH != null) {
            this.asH.cancel(false);
        }
        this.asH = this.asF.schedule(cM(str), j, TimeUnit.MILLISECONDS);
    }

    public synchronized void release() {
        qg();
        if (this.asH != null) {
            this.asH.cancel(false);
        }
        this.asF.shutdown();
        this.mClosed = true;
    }
}
