package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@ey
public class gx extends gv {
    public gx(gu guVar, boolean z) {
        super(guVar, z);
    }

    protected WebResourceResponse d(Context context, String str, String str2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
        WebResourceResponse webResourceResponse = true;
        try {
            gi.a(context, str, true, httpURLConnection, true);
            httpURLConnection.addRequestProperty("Cache-Control", "max-stale=3600");
            httpURLConnection.connect();
            webResourceResponse = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(gi.a(new InputStreamReader(httpURLConnection.getInputStream())).getBytes("UTF-8")));
            return webResourceResponse;
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String url) {
        try {
            if (!"mraid.js".equalsIgnoreCase(new File(url).getName())) {
                return super.shouldInterceptRequest(webView, url);
            }
            if (webView instanceof gu) {
                gu guVar = (gu) webView;
                guVar.dD().cg();
                if (guVar.ac().oq) {
                    gr.V("shouldInterceptRequest(https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js)");
                    return d(guVar.getContext(), this.mo.dG().wS, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js");
                } else if (guVar.dH()) {
                    gr.V("shouldInterceptRequest(https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js)");
                    return d(guVar.getContext(), this.mo.dG().wS, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js");
                } else {
                    gr.V("shouldInterceptRequest(https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js)");
                    return d(guVar.getContext(), this.mo.dG().wS, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js");
                }
            }
            gr.W("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return super.shouldInterceptRequest(webView, url);
        } catch (IOException e) {
            gr.W("Could not fetch MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, url);
        }
    }
}
