package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;

public class OnEventResponse implements SafeParcelable {
    public static final Creator<OnEventResponse> CREATOR = new aq();
    final int CK;
    final int Pm;
    final ChangeEvent QO;
    final CompletionEvent QP;

    OnEventResponse(int versionCode, int eventType, ChangeEvent changeEvent, CompletionEvent completionEvent) {
        this.CK = versionCode;
        this.Pm = eventType;
        this.QO = changeEvent;
        this.QP = completionEvent;
    }

    public int describeContents() {
        return 0;
    }

    public DriveEvent iQ() {
        switch (this.Pm) {
            case 1:
                return this.QO;
            case 2:
                return this.QP;
            default:
                throw new IllegalStateException("Unexpected event type " + this.Pm);
        }
    }

    public void writeToParcel(Parcel dest, int flags) {
        aq.a(this, dest, flags);
    }
}
