package com.google.android.gms.internal;

import android.content.Context;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@ey
public final class gp extends gf {
    private final Context mContext;
    private final String mG;
    private final String vf;
    private String wl = null;

    public gp(Context context, String str, String str2) {
        this.mContext = context;
        this.mG = str;
        this.vf = str2;
    }

    public gp(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.mG = str;
        this.vf = str2;
        this.wl = str3;
    }

    public void cx() {
        HttpURLConnection httpURLConnection;
        try {
            gr.V("Pinging URL: " + this.vf);
            httpURLConnection = (HttpURLConnection) new URL(this.vf).openConnection();
            if (this.wl == null) {
                gi.a(this.mContext, this.mG, true, httpURLConnection);
            } else {
                gi.a(this.mContext, this.mG, true, httpURLConnection, this.wl);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                gr.W("Received non-success response code " + responseCode + " from pinging URL: " + this.vf);
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e) {
            gr.W("Error while parsing ping URL: " + this.vf + ". " + e.getMessage());
        } catch (IOException e2) {
            gr.W("Error while pinging URL: " + this.vf + ". " + e2.getMessage());
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }

    public void onStop() {
    }
}
