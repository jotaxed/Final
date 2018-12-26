package com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.internal.eo;
import com.google.android.gms.internal.et;
import com.google.android.gms.internal.gr;

public final class InAppPurchaseActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.purchase.InAppPurchaseActivity";
    public static final String SIMPLE_CLASS_NAME = "InAppPurchaseActivity";
    private eo xz;

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            if (this.xz != null) {
                this.xz.onActivityResult(requestCode, resultCode, data);
            }
        } catch (Throwable e) {
            gr.d("Could not forward onActivityResult to in-app purchase manager:", e);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.xz = et.e(this);
        if (this.xz == null) {
            gr.W("Could not create in-app purchase manager.");
            finish();
            return;
        }
        try {
            this.xz.onCreate();
        } catch (Throwable e) {
            gr.d("Could not forward onCreate to in-app purchase manager:", e);
            finish();
        }
    }

    protected void onDestroy() {
        try {
            if (this.xz != null) {
                this.xz.onDestroy();
            }
        } catch (Throwable e) {
            gr.d("Could not forward onDestroy to in-app purchase manager:", e);
        }
        super.onDestroy();
    }
}
