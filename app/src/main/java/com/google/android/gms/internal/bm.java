package com.google.android.gms.internal;

import android.text.TextUtils;

@ey
public final class bm {
    private String pd;
    private String pe;
    private String pf;
    private String pg;

    public bm() {
        this.pd = null;
        this.pe = null;
        this.pf = null;
        this.pg = null;
        this.pd = "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html";
        this.pe = null;
        this.pf = null;
        this.pg = null;
    }

    public bm(String str, String str2, String str3, String str4) {
        this.pd = null;
        this.pe = null;
        this.pf = null;
        this.pg = null;
        if (TextUtils.isEmpty(str)) {
            this.pd = "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html";
        } else {
            this.pd = str;
        }
        this.pe = str2;
        this.pf = str3;
        this.pg = str4;
    }

    public String bu() {
        return this.pd;
    }

    public String bv() {
        return this.pe;
    }

    public String bw() {
        return this.pf;
    }

    public String bx() {
        return this.pg;
    }
}
