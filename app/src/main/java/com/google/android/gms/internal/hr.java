package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hd.a;
import com.google.android.gms.plus.PlusShare;
import java.util.List;
import java.util.zip.CRC32;

public class hr implements SafeParcelable {
    public static final hs CREATOR = new hs();
    final int CK;
    final hf Dw;
    final long Dx;
    final int Dy;
    final hd Dz;
    public final String pc;

    hr(int i, hf hfVar, long j, int i2, String str, hd hdVar) {
        this.CK = i;
        this.Dw = hfVar;
        this.Dx = j;
        this.Dy = i2;
        this.pc = str;
        this.Dz = hdVar;
    }

    public hr(hf hfVar, long j, int i) {
        this(1, hfVar, j, i, null, null);
    }

    public hr(hf hfVar, long j, int i, String str, hd hdVar) {
        this(1, hfVar, j, i, str, hdVar);
    }

    public hr(String str, Intent intent, String str2, Uri uri, String str3, List<AppIndexingLink> list) {
        this(1, a(str, intent), System.currentTimeMillis(), 0, null, a(intent, str2, uri, str3, list).fD());
    }

    public static a a(Intent intent, String str, Uri uri, String str2, List<AppIndexingLink> list) {
        a aVar = new a();
        aVar.a(av(str));
        if (uri != null) {
            aVar.a(f(uri));
        }
        if (list != null) {
            aVar.a(b(list));
        }
        String action = intent.getAction();
        if (action != null) {
            aVar.a(i("intent_action", action));
        }
        action = intent.getDataString();
        if (action != null) {
            aVar.a(i("intent_data", action));
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            aVar.a(i("intent_activity", component.getClassName()));
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            action = extras.getString("intent_extra_data_key");
            if (action != null) {
                aVar.a(i("intent_extra_data", action));
            }
        }
        return aVar.ar(str2).F(true);
    }

    public static hf a(String str, Intent intent) {
        return h(str, g(intent));
    }

    private static hh av(String str) {
        return new hh(str, new hp.a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE).Q(1).H(true).au("name").fG(), "text1");
    }

    private static hh b(List<AppIndexingLink> list) {
        qw aVar = new mv.a();
        mv.a.a[] aVarArr = new mv.a.a[list.size()];
        for (int i = 0; i < aVarArr.length; i++) {
            aVarArr[i] = new mv.a.a();
            AppIndexingLink appIndexingLink = (AppIndexingLink) list.get(i);
            aVarArr[i].afw = appIndexingLink.appIndexingUrl.toString();
            aVarArr[i].viewId = appIndexingLink.viewId;
            if (appIndexingLink.webUrl != null) {
                aVarArr[i].afx = appIndexingLink.webUrl.toString();
            }
        }
        aVar.afu = aVarArr;
        return new hh(qw.f(aVar), new hp.a("outlinks").G(true).au(".private:outLinks").at("blob").fG());
    }

    private static hh f(Uri uri) {
        return new hh(uri.toString(), new hp.a("web_url").Q(4).G(true).au(PlusShare.KEY_CALL_TO_ACTION_URL).fG());
    }

    private static String g(Intent intent) {
        String toUri = intent.toUri(1);
        CRC32 crc32 = new CRC32();
        try {
            crc32.update(toUri.getBytes("UTF-8"));
            return Long.toHexString(crc32.getValue());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    private static hf h(String str, String str2) {
        return new hf(str, "", str2);
    }

    private static hh i(String str, String str2) {
        return new hh(str2, new hp.a(str).G(true).fG(), str);
    }

    public int describeContents() {
        hs hsVar = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d]", new Object[]{this.Dw, Long.valueOf(this.Dx), Integer.valueOf(this.Dy)});
    }

    public void writeToParcel(Parcel dest, int flags) {
        hs hsVar = CREATOR;
        hs.a(this, dest, flags);
    }
}
