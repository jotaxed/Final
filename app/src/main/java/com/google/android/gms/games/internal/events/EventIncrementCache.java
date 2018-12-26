package com.google.android.gms.games.internal.events;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class EventIncrementCache {
    final Object ack = new Object();
    private Handler acl;
    private boolean acm;
    private HashMap<String, AtomicInteger> acn;
    private int aco;

    public EventIncrementCache(Looper looper, int flushIntervalMillis) {
        this.acl = new Handler(looper);
        this.acn = new HashMap();
        this.aco = flushIntervalMillis;
    }

    private void lX() {
        synchronized (this.ack) {
            this.acm = false;
            flush();
        }
    }

    public void flush() {
        synchronized (this.ack) {
            for (Entry entry : this.acn.entrySet()) {
                r((String) entry.getKey(), ((AtomicInteger) entry.getValue()).get());
            }
            this.acn.clear();
        }
    }

    protected abstract void r(String str, int i);

    public void y(String str, int i) {
        synchronized (this.ack) {
            if (!this.acm) {
                this.acm = true;
                this.acl.postDelayed(new Runnable(this) {
                    final /* synthetic */ EventIncrementCache acp;

                    {
                        this.acp = r1;
                    }

                    public void run() {
                        this.acp.lX();
                    }
                }, (long) this.aco);
            }
            AtomicInteger atomicInteger = (AtomicInteger) this.acn.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                this.acn.put(str, atomicInteger);
            }
            atomicInteger.addAndGet(i);
        }
    }
}
