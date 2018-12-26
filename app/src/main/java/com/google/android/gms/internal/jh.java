package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

public class jh implements OnClickListener {
    private final Fragment Mx;
    private final int My;
    private final Intent mIntent;
    private final Activity nB;

    public jh(Activity activity, Intent intent, int i) {
        this.nB = activity;
        this.Mx = null;
        this.mIntent = intent;
        this.My = i;
    }

    public jh(Fragment fragment, Intent intent, int i) {
        this.nB = null;
        this.Mx = fragment;
        this.mIntent = intent;
        this.My = i;
    }

    public void onClick(DialogInterface dialog, int which) {
        try {
            if (this.mIntent != null && this.Mx != null) {
                this.Mx.startActivityForResult(this.mIntent, this.My);
            } else if (this.mIntent != null) {
                this.nB.startActivityForResult(this.mIntent, this.My);
            }
            dialog.dismiss();
        } catch (ActivityNotFoundException e) {
            Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
        }
    }
}
