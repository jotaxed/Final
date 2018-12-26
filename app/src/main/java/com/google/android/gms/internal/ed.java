package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.google.android.gms.internal.em.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@ey
public final class ed extends a {
    private Context mContext;
    private String mG;
    private String sM;
    private ArrayList<String> sN;

    public ed(String str, ArrayList<String> arrayList, Context context, String str2) {
        this.sM = str;
        this.sN = arrayList;
        this.mG = str2;
        this.mContext = context;
    }

    private void cz() {
        try {
            this.mContext.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter").getDeclaredMethod("reportWithProductId", new Class[]{Context.class, String.class, String.class, Boolean.TYPE}).invoke(null, new Object[]{this.mContext, this.sM, "", Boolean.valueOf(true)});
        } catch (ClassNotFoundException e) {
            gr.W("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (NoSuchMethodException e2) {
            gr.W("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (Throwable e3) {
            gr.d("Fail to report a conversion.", e3);
        }
    }

    protected String a(String str, HashMap<String, String> hashMap) {
        Object obj;
        Object obj2 = "";
        try {
            obj = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionName;
        } catch (Throwable e) {
            gr.d("Error to retrieve app version", e);
            obj = obj2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - ga.dh().dq();
        for (String str2 : hashMap.keySet()) {
            str = str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{str2}), String.format("$1%s$2", new Object[]{hashMap.get(str2)}));
        }
        return str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"sessionid"}), String.format("$1%s$2", new Object[]{ga.vY})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"appid"}), String.format("$1%s$2", new Object[]{r2})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"osversion"}), String.format("$1%s$2", new Object[]{String.valueOf(VERSION.SDK_INT)})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"sdkversion"}), String.format("$1%s$2", new Object[]{this.mG})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"appversion"}), String.format("$1%s$2", new Object[]{obj})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"timestamp"}), String.format("$1%s$2", new Object[]{String.valueOf(elapsedRealtime)})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"[^@]+"}), String.format("$1%s$2", new Object[]{""})).replaceAll("@@", "@");
    }

    public String getProductId() {
        return this.sM;
    }

    protected int p(int i) {
        return i == 0 ? 1 : i == 1 ? 2 : i == 4 ? 3 : 0;
    }

    public void recordPlayBillingResolution(int billingResponseCode) {
        if (billingResponseCode == 0) {
            cz();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("google_play_status", String.valueOf(billingResponseCode));
        hashMap.put("sku", this.sM);
        hashMap.put("status", String.valueOf(p(billingResponseCode)));
        Iterator it = this.sN.iterator();
        while (it.hasNext()) {
            new gp(this.mContext, this.mG, a((String) it.next(), hashMap)).start();
        }
    }

    public void recordResolution(int resolution) {
        if (resolution == 1) {
            cz();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("status", String.valueOf(resolution));
        hashMap.put("sku", this.sM);
        Iterator it = this.sN.iterator();
        while (it.hasNext()) {
            new gp(this.mContext, this.mG, a((String) it.next(), hashMap)).start();
        }
    }
}
