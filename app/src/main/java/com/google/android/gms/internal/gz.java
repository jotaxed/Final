package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URI;
import java.net.URISyntaxException;

@ey
public class gz extends WebViewClient {
    private final gu mo;
    private final String xr;
    private boolean xs = false;
    private final fb xt;

    public gz(fb fbVar, gu guVar, String str) {
        this.xr = Z(str);
        this.mo = guVar;
        this.xt = fbVar;
    }

    private String Z(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (str.endsWith("/")) {
                    str = str.substring(0, str.length() - 1);
                }
            } catch (IndexOutOfBoundsException e) {
                gr.T(e.getMessage());
            }
        }
        return str;
    }

    protected boolean Y(String str) {
        Object Z = Z(str);
        if (TextUtils.isEmpty(Z)) {
            return false;
        }
        try {
            URI uri = new URI(Z);
            if ("passback".equals(uri.getScheme())) {
                gr.S("Passback received");
                this.xt.cG();
                return true;
            } else if (TextUtils.isEmpty(this.xr)) {
                return false;
            } else {
                URI uri2 = new URI(this.xr);
                String host = uri2.getHost();
                String host2 = uri.getHost();
                String path = uri2.getPath();
                String path2 = uri.getPath();
                if (!jv.equal(host, host2) || !jv.equal(path, path2)) {
                    return false;
                }
                gr.S("Passback received");
                this.xt.cG();
                return true;
            }
        } catch (URISyntaxException e) {
            gr.T(e.getMessage());
            return false;
        }
    }

    public void onLoadResource(WebView view, String url) {
        gr.S("JavascriptAdWebViewClient::onLoadResource: " + url);
        if (!Y(url)) {
            this.mo.dD().onLoadResource(this.mo, url);
        }
    }

    public void onPageFinished(WebView view, String url) {
        gr.S("JavascriptAdWebViewClient::onPageFinished: " + url);
        if (!this.xs) {
            this.xt.cF();
            this.xs = true;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        gr.S("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + url);
        if (!Y(url)) {
            return this.mo.dD().shouldOverrideUrlLoading(this.mo, url);
        }
        gr.S("shouldOverrideUrlLoading: received passback url");
        return true;
    }
}
