package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ld;
import com.google.android.gms.internal.lf;
import java.io.IOException;

class a {
    private static a aqa;
    private static Object xO = new Object();
    private volatile long apW;
    private volatile long apX;
    private volatile long apY;
    private a apZ;
    private volatile boolean mClosed;
    private final Context mContext;
    private final ld wb;
    private final Thread wu;
    private volatile Info xQ;

    public interface a {
        Info pd();
    }

    private a(Context context) {
        this(context, null, lf.if());
    }

    a(Context context, a aVar, ld ldVar) {
        this.apW = 900000;
        this.apX = 30000;
        this.mClosed = false;
        this.apZ = new a(this) {
            final /* synthetic */ a aqb;

            {
                this.aqb = r1;
            }

            public Info pd() {
                Info info = null;
                try {
                    info = AdvertisingIdClient.getAdvertisingIdInfo(this.aqb.mContext);
                } catch (IllegalStateException e) {
                    bh.W("IllegalStateException getting Advertising Id Info");
                } catch (GooglePlayServicesRepairableException e2) {
                    bh.W("GooglePlayServicesRepairableException getting Advertising Id Info");
                } catch (IOException e3) {
                    bh.W("IOException getting Ad Id Info");
                } catch (GooglePlayServicesNotAvailableException e4) {
                    bh.W("GooglePlayServicesNotAvailableException getting Advertising Id Info");
                } catch (Exception e5) {
                    bh.W("Unknown exception. Could not get the Advertising Id Info.");
                }
                return info;
            }
        };
        this.wb = ldVar;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        if (aVar != null) {
            this.apZ = aVar;
        }
        this.wu = new Thread(new Runnable(this) {
            final /* synthetic */ a aqb;

            {
                this.aqb = r1;
            }

            public void run() {
                this.aqb.pb();
            }
        });
    }

    static a W(Context context) {
        if (aqa == null) {
            synchronized (xO) {
                if (aqa == null) {
                    aqa = new a(context);
                    aqa.start();
                }
            }
        }
        return aqa;
    }

    private void pb() {
        Process.setThreadPriority(10);
        while (!this.mClosed) {
            try {
                this.xQ = this.apZ.pd();
                Thread.sleep(this.apW);
            } catch (InterruptedException e) {
                bh.U("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    private void pc() {
        if (this.wb.currentTimeMillis() - this.apY >= this.apX) {
            interrupt();
            this.apY = this.wb.currentTimeMillis();
        }
    }

    void interrupt() {
        this.wu.interrupt();
    }

    public boolean isLimitAdTrackingEnabled() {
        pc();
        return this.xQ == null ? true : this.xQ.isLimitAdTrackingEnabled();
    }

    public String pa() {
        pc();
        return this.xQ == null ? null : this.xQ.getId();
    }

    void start() {
        this.wu.start();
    }
}
