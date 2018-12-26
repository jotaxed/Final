package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class as extends Thread implements ar {
    private static as ary;
    private final LinkedBlockingQueue<Runnable> arx = new LinkedBlockingQueue();
    private volatile at arz;
    private volatile boolean mClosed = false;
    private final Context mContext;
    private volatile boolean zK = false;

    private as(Context context) {
        super("GAThread");
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        start();
    }

    static as Z(Context context) {
        if (ary == null) {
            ary = new as(context);
        }
        return ary;
    }

    private String g(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    public void b(Runnable runnable) {
        this.arx.add(runnable);
    }

    void b(String str, long j) {
        final as asVar = this;
        final long j2 = j;
        final String str2 = str;
        b(new Runnable(this) {
            final /* synthetic */ as arC;

            public void run() {
                if (this.arC.arz == null) {
                    cy qN = cy.qN();
                    qN.a(this.arC.mContext, asVar);
                    this.arC.arz = qN.qO();
                }
                this.arC.arz.f(j2, str2);
            }
        });
    }

    public void cE(String str) {
        b(str, System.currentTimeMillis());
    }

    public void run() {
        while (!this.mClosed) {
            try {
                Runnable runnable = (Runnable) this.arx.take();
                if (!this.zK) {
                    runnable.run();
                }
            } catch (InterruptedException e) {
                bh.U(e.toString());
            } catch (Throwable th) {
                bh.T("Error on Google TagManager Thread: " + g(th));
                bh.T("Google TagManager is shutting down.");
                this.zK = true;
            }
        }
    }
}
