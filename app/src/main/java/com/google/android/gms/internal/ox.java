package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.jl.e;
import com.google.android.gms.internal.os.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ox extends jl<oq> {
    private final String CS;
    private final ou anm;
    private final os ann = new os();
    private boolean ano = true;
    private final Object mH = new Object();

    public ox(Context context, ou ouVar) {
        super(context, ouVar, ouVar, new String[0]);
        this.CS = context.getPackageName();
        this.anm = (ou) jx.i(ouVar);
        this.anm.a(this);
    }

    private void c(ov ovVar, or orVar) {
        this.ann.a(ovVar, orVar);
    }

    private void d(ov ovVar, or orVar) {
        try {
            or();
            ((oq) hw()).a(this.CS, ovVar, orVar);
        } catch (RemoteException e) {
            Log.e("PlayLoggerImpl", "Couldn't send log event.  Will try caching.");
            c(ovVar, orVar);
        } catch (IllegalStateException e2) {
            Log.e("PlayLoggerImpl", "Service was disconnected.  Will try caching.");
            c(ovVar, orVar);
        }
    }

    private void or() {
        je.K(!this.ano);
        if (!this.ann.isEmpty()) {
            ov ovVar = null;
            try {
                List arrayList = new ArrayList();
                Iterator it = this.ann.op().iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar.and != null) {
                        ((oq) hw()).a(this.CS, aVar.anb, qw.f(aVar.and));
                    } else {
                        ov ovVar2;
                        if (aVar.anb.equals(ovVar)) {
                            arrayList.add(aVar.anc);
                            ovVar2 = ovVar;
                        } else {
                            if (!arrayList.isEmpty()) {
                                ((oq) hw()).a(this.CS, ovVar, arrayList);
                                arrayList.clear();
                            }
                            ov ovVar3 = aVar.anb;
                            arrayList.add(aVar.anc);
                            ovVar2 = ovVar3;
                        }
                        ovVar = ovVar2;
                    }
                }
                if (!arrayList.isEmpty()) {
                    ((oq) hw()).a(this.CS, ovVar, arrayList);
                }
                this.ann.clear();
            } catch (RemoteException e) {
                Log.e("PlayLoggerImpl", "Couldn't send cached log events to AndroidLog service.  Retaining in memory cache.");
            }
        }
    }

    void U(boolean z) {
        synchronized (this.mH) {
            boolean z2 = this.ano;
            this.ano = z;
            if (z2 && !this.ano) {
                or();
            }
        }
    }

    protected void a(jt jtVar, e eVar) throws RemoteException {
        jtVar.f(eVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), new Bundle());
    }

    public void b(ov ovVar, or orVar) {
        synchronized (this.mH) {
            if (this.ano) {
                c(ovVar, orVar);
            } else {
                d(ovVar, orVar);
            }
        }
    }

    protected oq bJ(IBinder iBinder) {
        return oq.a.bI(iBinder);
    }

    protected String bK() {
        return "com.google.android.gms.playlog.service.START";
    }

    protected String bL() {
        return "com.google.android.gms.playlog.internal.IPlayLogService";
    }

    protected /* synthetic */ IInterface l(IBinder iBinder) {
        return bJ(iBinder);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void start() {
        /*
        r3 = this;
        r1 = r3.mH;
        monitor-enter(r1);
        r0 = r3.isConnecting();	 Catch:{ all -> 0x001c }
        if (r0 != 0) goto L_0x000f;
    L_0x0009:
        r0 = r3.isConnected();	 Catch:{ all -> 0x001c }
        if (r0 == 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r1);	 Catch:{ all -> 0x001c }
    L_0x0010:
        return;
    L_0x0011:
        r0 = r3.anm;	 Catch:{ all -> 0x001c }
        r2 = 1;
        r0.T(r2);	 Catch:{ all -> 0x001c }
        r3.connect();	 Catch:{ all -> 0x001c }
        monitor-exit(r1);	 Catch:{ all -> 0x001c }
        goto L_0x0010;
    L_0x001c:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001c }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ox.start():void");
    }

    public void stop() {
        synchronized (this.mH) {
            this.anm.T(false);
            disconnect();
        }
    }
}
