package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import java.util.List;

public class RealtimeDocumentSyncRequest implements SafeParcelable {
    public static final Creator<RealtimeDocumentSyncRequest> CREATOR = new f();
    final int CK;
    final List<String> OK;
    final List<String> OL;

    RealtimeDocumentSyncRequest(int versionCode, List<String> documentsToSync, List<String> documentsToDeleteCache) {
        this.CK = versionCode;
        this.OK = (List) jx.i(documentsToSync);
        this.OL = (List) jx.i(documentsToDeleteCache);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        f.a(this, dest, flags);
    }
}
