package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ey
public class ec extends gf implements ServiceConnection {
    private Context mContext;
    private final Object mH = new Object();
    private boolean sD = false;
    private er sE;
    private eb sF;
    private eh sG;
    private List<ef> sH = null;
    private ek sI;

    public ec(Context context, er erVar, ek ekVar) {
        this.mContext = context;
        this.sE = erVar;
        this.sI = ekVar;
        this.sF = new eb(context);
        this.sG = eh.j(this.mContext);
        this.sH = this.sG.d(10);
    }

    private void a(final ef efVar, String str, String str2) {
        final Intent intent = new Intent();
        intent.putExtra("RESPONSE_CODE", 0);
        intent.putExtra("INAPP_PURCHASE_DATA", str);
        intent.putExtra("INAPP_DATA_SIGNATURE", str2);
        gq.wR.post(new Runnable(this) {
            final /* synthetic */ ec sL;

            public void run() {
                try {
                    if (this.sL.sI.a(efVar.sU, -1, intent)) {
                        this.sL.sE.a(new eg(this.sL.mContext, efVar.sV, true, -1, intent, efVar));
                    } else {
                        this.sL.sE.a(new eg(this.sL.mContext, efVar.sV, false, -1, intent, efVar));
                    }
                } catch (RemoteException e) {
                    gr.W("Fail to verify and dispatch pending transaction");
                }
            }
        });
    }

    private void b(long j) {
        do {
            if (!c(j)) {
                gr.W("Timeout waiting for pending transaction to be processed.");
            }
        } while (!this.sD);
    }

    private boolean c(long j) {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.mH.wait(elapsedRealtime);
        } catch (InterruptedException e) {
            gr.W("waitWithTimeout_lock interrupted");
        }
        return true;
    }

    private void cy() {
        if (!this.sH.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (ef efVar : this.sH) {
                hashMap.put(efVar.sV, efVar);
            }
            String str = null;
            while (true) {
                Bundle d = this.sF.d(this.mContext.getPackageName(), str);
                if (d == null || ei.b(d) != 0) {
                    break;
                }
                ArrayList stringArrayList = d.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList stringArrayList2 = d.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList stringArrayList3 = d.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                String string = d.getString("INAPP_CONTINUATION_TOKEN");
                for (int i = 0; i < stringArrayList.size(); i++) {
                    if (hashMap.containsKey(stringArrayList.get(i))) {
                        str = (String) stringArrayList.get(i);
                        String str2 = (String) stringArrayList2.get(i);
                        String str3 = (String) stringArrayList3.get(i);
                        ef efVar2 = (ef) hashMap.get(str);
                        if (efVar2.sU.equals(ei.D(str2))) {
                            a(efVar2, str2, str3);
                            hashMap.remove(str);
                        }
                    }
                }
                if (string == null || hashMap.isEmpty()) {
                    break;
                }
                str = string;
            }
            for (String str4 : hashMap.keySet()) {
                this.sG.a((ef) hashMap.get(str4));
            }
        }
    }

    public void cx() {
        synchronized (this.mH) {
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
            this.mContext.bindService(intent, this, 1);
            b(SystemClock.elapsedRealtime());
            this.mContext.unbindService(this);
            this.sF.destroy();
        }
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        synchronized (this.mH) {
            this.sF.t(service);
            cy();
            this.sD = true;
            this.mH.notify();
        }
    }

    public void onServiceDisconnected(ComponentName name) {
        gr.U("In-app billing service disconnected.");
        this.sF.destroy();
    }

    public void onStop() {
        synchronized (this.mH) {
            this.mContext.unbindService(this);
            this.sF.destroy();
        }
    }
}
