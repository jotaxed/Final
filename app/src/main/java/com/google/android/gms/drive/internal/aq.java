package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;

public class aq implements Creator<OnEventResponse> {
    static void a(OnEventResponse onEventResponse, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, onEventResponse.CK);
        b.c(parcel, 2, onEventResponse.Pm);
        b.a(parcel, 3, onEventResponse.QO, i, false);
        b.a(parcel, 5, onEventResponse.QP, i, false);
        b.H(parcel, H);
    }

    public OnEventResponse av(Parcel parcel) {
        CompletionEvent completionEvent = null;
        int i = 0;
        int G = a.G(parcel);
        ChangeEvent changeEvent = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            ChangeEvent changeEvent2;
            int i3;
            CompletionEvent completionEvent2;
            int F = a.F(parcel);
            CompletionEvent completionEvent3;
            switch (a.aH(F)) {
                case 1:
                    completionEvent3 = completionEvent;
                    changeEvent2 = changeEvent;
                    i3 = i;
                    i = a.g(parcel, F);
                    completionEvent2 = completionEvent3;
                    break;
                case 2:
                    i = i2;
                    ChangeEvent changeEvent3 = changeEvent;
                    i3 = a.g(parcel, F);
                    completionEvent2 = completionEvent;
                    changeEvent2 = changeEvent3;
                    break;
                case 3:
                    i3 = i;
                    i = i2;
                    completionEvent3 = completionEvent;
                    changeEvent2 = (ChangeEvent) a.a(parcel, F, ChangeEvent.CREATOR);
                    completionEvent2 = completionEvent3;
                    break;
                case 5:
                    completionEvent2 = (CompletionEvent) a.a(parcel, F, CompletionEvent.CREATOR);
                    changeEvent2 = changeEvent;
                    i3 = i;
                    i = i2;
                    break;
                default:
                    a.b(parcel, F);
                    completionEvent2 = completionEvent;
                    changeEvent2 = changeEvent;
                    i3 = i;
                    i = i2;
                    break;
            }
            i2 = i;
            i = i3;
            changeEvent = changeEvent2;
            completionEvent = completionEvent2;
        }
        if (parcel.dataPosition() == G) {
            return new OnEventResponse(i2, i, changeEvent, completionEvent);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public OnEventResponse[] bK(int i) {
        return new OnEventResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return av(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bK(x0);
    }
}
