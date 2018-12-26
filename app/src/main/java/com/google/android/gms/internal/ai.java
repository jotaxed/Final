package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.ah.a;
import java.util.concurrent.Future;

@ey
public class ai {
    protected ah a(Context context, gs gsVar, final gj<ah> gjVar) {
        final ah ajVar = new aj(context, gsVar);
        ajVar.a(new a(this) {
            final /* synthetic */ ai nj;

            public void aR() {
                gjVar.a(ajVar);
            }
        });
        return ajVar;
    }

    public Future<ah> a(Context context, gs gsVar, String str) {
        final Future gjVar = new gj();
        final Context context2 = context;
        final gs gsVar2 = gsVar;
        final String str2 = str;
        gq.wR.post(new Runnable(this) {
            final /* synthetic */ ai nj;

            public void run() {
                this.nj.a(context2, gsVar2, gjVar).f(str2);
            }
        });
        return gjVar;
    }
}
