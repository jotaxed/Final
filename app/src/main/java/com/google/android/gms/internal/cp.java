package com.google.android.gms.internal;

import android.content.Context;

@ey
public final class cp {
    private final cy lA;
    private final Context mContext;
    private final Object mH = new Object();
    private final fh qh;
    private final cr qi;
    private boolean qj = false;
    private cu qk;

    public cp(Context context, fh fhVar, cy cyVar, cr crVar) {
        this.mContext = context;
        this.qh = fhVar;
        this.lA = cyVar;
        this.qi = crVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.cv a(long r18, long r20) {
        /*
        r17 = this;
        r4 = "Starting mediation.";
        com.google.android.gms.internal.gr.S(r4);
        r0 = r17;
        r4 = r0.qi;
        r4 = r4.qu;
        r13 = r4.iterator();
    L_0x000f:
        r4 = r13.hasNext();
        if (r4 == 0) goto L_0x00aa;
    L_0x0015:
        r9 = r13.next();
        r9 = (com.google.android.gms.internal.cq) r9;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Trying mediation network: ";
        r4 = r4.append(r5);
        r5 = r9.qo;
        r4 = r4.append(r5);
        r4 = r4.toString();
        com.google.android.gms.internal.gr.U(r4);
        r4 = r9.qp;
        r14 = r4.iterator();
    L_0x0039:
        r4 = r14.hasNext();
        if (r4 == 0) goto L_0x000f;
    L_0x003f:
        r6 = r14.next();
        r6 = (java.lang.String) r6;
        r0 = r17;
        r15 = r0.mH;
        monitor-enter(r15);
        r0 = r17;
        r4 = r0.qj;	 Catch:{ all -> 0x0096 }
        if (r4 == 0) goto L_0x0058;
    L_0x0050:
        r4 = new com.google.android.gms.internal.cv;	 Catch:{ all -> 0x0096 }
        r5 = -1;
        r4.<init>(r5);	 Catch:{ all -> 0x0096 }
        monitor-exit(r15);	 Catch:{ all -> 0x0096 }
    L_0x0057:
        return r4;
    L_0x0058:
        r4 = new com.google.android.gms.internal.cu;	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r5 = r0.mContext;	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r7 = r0.lA;	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r8 = r0.qi;	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r10 = r0.qh;	 Catch:{ all -> 0x0096 }
        r10 = r10.tL;	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r11 = r0.qh;	 Catch:{ all -> 0x0096 }
        r11 = r11.lS;	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r12 = r0.qh;	 Catch:{ all -> 0x0096 }
        r12 = r12.lO;	 Catch:{ all -> 0x0096 }
        r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12);	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r0.qk = r4;	 Catch:{ all -> 0x0096 }
        monitor-exit(r15);	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r4 = r0.qk;
        r0 = r18;
        r2 = r20;
        r4 = r4.b(r0, r2);
        r5 = r4.qO;
        if (r5 != 0) goto L_0x0099;
    L_0x0090:
        r5 = "Adapter succeeded.";
        com.google.android.gms.internal.gr.S(r5);
        goto L_0x0057;
    L_0x0096:
        r4 = move-exception;
        monitor-exit(r15);	 Catch:{ all -> 0x0096 }
        throw r4;
    L_0x0099:
        r5 = r4.qQ;
        if (r5 == 0) goto L_0x0039;
    L_0x009d:
        r5 = com.google.android.gms.internal.gq.wR;
        r6 = new com.google.android.gms.internal.cp$1;
        r0 = r17;
        r6.<init>(r0, r4);
        r5.post(r6);
        goto L_0x0039;
    L_0x00aa:
        r4 = new com.google.android.gms.internal.cv;
        r5 = 1;
        r4.<init>(r5);
        goto L_0x0057;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cp.a(long, long):com.google.android.gms.internal.cv");
    }

    public void cancel() {
        synchronized (this.mH) {
            this.qj = true;
            if (this.qk != null) {
                this.qk.cancel();
            }
        }
    }
}
