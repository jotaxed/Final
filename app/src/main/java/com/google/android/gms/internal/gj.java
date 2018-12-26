package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@ey
public class gj<T> implements Future<T> {
    private final Object mH = new Object();
    private boolean qj = false;
    private T wF = null;
    private boolean wG = false;

    public void a(T t) {
        synchronized (this.mH) {
            if (this.wG) {
                throw new IllegalStateException("Provided CallbackFuture with multiple values.");
            }
            this.wG = true;
            this.wF = t;
            this.mH.notifyAll();
        }
    }

    public boolean cancel(boolean mayInterruptIfRunning) {
        if (!mayInterruptIfRunning) {
            return false;
        }
        synchronized (this.mH) {
            if (this.wG) {
                return false;
            }
            this.qj = true;
            this.wG = true;
            this.mH.notifyAll();
            return true;
        }
    }

    public T get() {
        T t;
        synchronized (this.mH) {
            if (!this.wG) {
                try {
                    this.mH.wait();
                } catch (InterruptedException e) {
                }
            }
            if (this.qj) {
                throw new CancellationException("CallbackFuture was cancelled.");
            }
            t = this.wF;
        }
        return t;
    }

    public T get(long timeout, TimeUnit unit) throws TimeoutException {
        T t;
        synchronized (this.mH) {
            if (!this.wG) {
                try {
                    long toMillis = unit.toMillis(timeout);
                    if (toMillis != 0) {
                        this.mH.wait(toMillis);
                    }
                } catch (InterruptedException e) {
                }
            }
            if (!this.wG) {
                throw new TimeoutException("CallbackFuture timed out.");
            } else if (this.qj) {
                throw new CancellationException("CallbackFuture was cancelled.");
            } else {
                t = this.wF;
            }
        }
        return t;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.mH) {
            z = this.qj;
        }
        return z;
    }

    public boolean isDone() {
        boolean z;
        synchronized (this.mH) {
            z = this.wG;
        }
        return z;
    }
}
