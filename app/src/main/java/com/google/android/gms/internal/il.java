package com.google.android.gms.internal;

import android.text.TextUtils;
import java.io.IOException;

public abstract class il {
    protected final is He;
    private final String Hf;
    private iu Hg;

    protected il(String str, String str2, String str3) {
        in.aF(str);
        this.Hf = str;
        this.He = new is(str2);
        if (!TextUtils.isEmpty(str3)) {
            this.He.aK(str3);
        }
    }

    public final void a(iu iuVar) {
        this.Hg = iuVar;
        if (this.Hg == null) {
            fV();
        }
    }

    protected final void a(String str, long j, String str2) throws IOException {
        this.He.a("Sending text message: %s to: %s", str, str2);
        this.Hg.a(this.Hf, str, j, str2);
    }

    public void aD(String str) {
    }

    public void b(long j, int i) {
    }

    protected final long fU() {
        return this.Hg.fS();
    }

    public void fV() {
    }

    public final String getNamespace() {
        return this.Hf;
    }
}
