package com.google.android.gms.internal;

import android.content.Context;
import android.view.MotionEvent;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@ey
class x implements g, Runnable {
    private b lB;
    private final List<Object[]> mp = new Vector();
    private final AtomicReference<g> mq = new AtomicReference();
    CountDownLatch mr = new CountDownLatch(1);

    public x(b bVar) {
        this.lB = bVar;
        if (gq.dB()) {
            gh.a(this);
        } else {
            run();
        }
    }

    private void aB() {
        if (!this.mp.isEmpty()) {
            for (Object[] objArr : this.mp) {
                if (objArr.length == 1) {
                    ((g) this.mq.get()).a((MotionEvent) objArr[0]);
                } else if (objArr.length == 3) {
                    ((g) this.mq.get()).a(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            }
        }
    }

    private Context i(Context context) {
        if (!aC()) {
            return context;
        }
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }

    public String a(Context context) {
        if (aA()) {
            g gVar = (g) this.mq.get();
            if (gVar != null) {
                aB();
                return gVar.a(i(context));
            }
        }
        return "";
    }

    public String a(Context context, String str) {
        if (aA()) {
            g gVar = (g) this.mq.get();
            if (gVar != null) {
                aB();
                return gVar.a(i(context), str);
            }
        }
        return "";
    }

    public void a(int i, int i2, int i3) {
        g gVar = (g) this.mq.get();
        if (gVar != null) {
            aB();
            gVar.a(i, i2, i3);
            return;
        }
        this.mp.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public void a(MotionEvent motionEvent) {
        g gVar = (g) this.mq.get();
        if (gVar != null) {
            aB();
            gVar.a(motionEvent);
            return;
        }
        this.mp.add(new Object[]{motionEvent});
    }

    protected void a(g gVar) {
        this.mq.set(gVar);
    }

    protected boolean aA() {
        try {
            this.mr.await();
            return true;
        } catch (Throwable e) {
            gr.d("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    protected boolean aC() {
        return ga.bN().getBoolean("gads:spam_app_context:enabled", false);
    }

    public void run() {
        try {
            a(j.a(this.lB.lO.wS, i(this.lB.lM)));
        } finally {
            this.mr.countDown();
            this.lB = null;
        }
    }
}
