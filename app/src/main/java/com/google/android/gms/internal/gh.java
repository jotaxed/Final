package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@ey
public final class gh {
    private static final ThreadFactory ww = new ThreadFactory() {
        private final AtomicInteger wA = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AdWorker #" + this.wA.getAndIncrement());
        }
    };
    private static final ExecutorService wx = Executors.newFixedThreadPool(10, ww);

    public static Future<Void> a(final Runnable runnable) {
        return submit(new Callable<Void>() {
            public /* synthetic */ Object call() throws Exception {
                return ds();
            }

            public Void ds() {
                runnable.run();
                return null;
            }
        });
    }

    public static <T> Future<T> submit(final Callable<T> callable) {
        try {
            return wx.submit(new Callable<T>() {
                public T call() throws Exception {
                    try {
                        Process.setThreadPriority(10);
                        return callable.call();
                    } catch (Throwable e) {
                        ga.e(e);
                        return null;
                    }
                }
            });
        } catch (Throwable e) {
            gr.d("Thread execution is rejected.", e);
            return new gk(null);
        }
    }
}
