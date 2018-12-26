package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class cy extends cx {
    private static cy atJ;
    private static final Object yT = new Object();
    private at atA;
    private volatile ar atB;
    private int atC = 1800000;
    private boolean atD = true;
    private boolean atE = false;
    private boolean atF = true;
    private au atG = new au(this) {
        final /* synthetic */ cy atK;

        {
            this.atK = r1;
        }

        public void B(boolean z) {
            this.atK.a(z, this.atK.connected);
        }
    };
    private bo atH;
    private boolean atI = false;
    private Context atz;
    private boolean connected = true;
    private Handler handler;

    private cy() {
    }

    private void ev() {
        this.atH = new bo(this);
        this.atH.z(this.atz);
    }

    private void ew() {
        this.handler = new Handler(this.atz.getMainLooper(), new Callback(this) {
            final /* synthetic */ cy atK;

            {
                this.atK = r1;
            }

            public boolean handleMessage(Message msg) {
                if (1 == msg.what && cy.yT.equals(msg.obj)) {
                    this.atK.dispatch();
                    if (this.atK.atC > 0 && !this.atK.atI) {
                        this.atK.handler.sendMessageDelayed(this.atK.handler.obtainMessage(1, cy.yT), (long) this.atK.atC);
                    }
                }
                return true;
            }
        });
        if (this.atC > 0) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(1, yT), (long) this.atC);
        }
    }

    public static cy qN() {
        if (atJ == null) {
            atJ = new cy();
        }
        return atJ;
    }

    synchronized void C(boolean z) {
        a(this.atI, z);
    }

    synchronized void a(Context context, ar arVar) {
        if (this.atz == null) {
            this.atz = context.getApplicationContext();
            if (this.atB == null) {
                this.atB = arVar;
            }
        }
    }

    synchronized void a(boolean z, boolean z2) {
        if (!(this.atI == z && this.connected == z2)) {
            if (z || !z2) {
                if (this.atC > 0) {
                    this.handler.removeMessages(1, yT);
                }
            }
            if (!z && z2 && this.atC > 0) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(1, yT), (long) this.atC);
            }
            StringBuilder append = new StringBuilder().append("PowerSaveMode ");
            String str = (z || !z2) ? "initiated." : "terminated.";
            bh.V(append.append(str).toString());
            this.atI = z;
            this.connected = z2;
        }
    }

    public synchronized void dispatch() {
        if (this.atE) {
            this.atB.b(new Runnable(this) {
                final /* synthetic */ cy atK;

                {
                    this.atK = r1;
                }

                public void run() {
                    this.atK.atA.dispatch();
                }
            });
        } else {
            bh.V("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.atD = true;
        }
    }

    synchronized void ey() {
        if (!this.atI && this.connected && this.atC > 0) {
            this.handler.removeMessages(1, yT);
            this.handler.sendMessage(this.handler.obtainMessage(1, yT));
        }
    }

    synchronized at qO() {
        if (this.atA == null) {
            if (this.atz == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.atA = new cb(this.atG, this.atz);
        }
        if (this.handler == null) {
            ew();
        }
        this.atE = true;
        if (this.atD) {
            dispatch();
            this.atD = false;
        }
        if (this.atH == null && this.atF) {
            ev();
        }
        return this.atA;
    }
}
