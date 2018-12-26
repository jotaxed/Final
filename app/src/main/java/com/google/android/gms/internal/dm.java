package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

@ey
public final class dm {
    public static boolean a(Context context, do doVar, dv dvVar) {
        if (doVar == null) {
            gr.W("No intent data for launcher overlay.");
            return false;
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(doVar.rH)) {
            gr.W("Open GMSG did not contain a URL.");
            return false;
        }
        if (TextUtils.isEmpty(doVar.mimeType)) {
            intent.setData(Uri.parse(doVar.rH));
        } else {
            intent.setDataAndType(Uri.parse(doVar.rH), doVar.mimeType);
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(doVar.packageName)) {
            intent.setPackage(doVar.packageName);
        }
        if (!TextUtils.isEmpty(doVar.rI)) {
            String[] split = doVar.rI.split("/", 2);
            if (split.length < 2) {
                gr.W("Could not parse component name from open GMSG: " + doVar.rI);
                return false;
            }
            intent.setClassName(split[0], split[1]);
        }
        try {
            gr.V("Launching an intent: " + intent);
            context.startActivity(intent);
            dvVar.af();
            return true;
        } catch (ActivityNotFoundException e) {
            gr.W(e.getMessage());
            return false;
        }
    }
}
