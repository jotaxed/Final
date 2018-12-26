package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.Contents;

public class al implements Creator<OnContentsResponse> {
    static void a(OnContentsResponse onContentsResponse, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, onContentsResponse.CK);
        b.a(parcel, 2, onContentsResponse.PW, i, false);
        b.a(parcel, 3, onContentsResponse.QJ);
        b.H(parcel, H);
    }

    public OnContentsResponse aq(Parcel parcel) {
        boolean z = false;
        int G = a.G(parcel);
        Contents contents = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            Contents contents2;
            int g;
            boolean z2;
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    boolean z3 = z;
                    contents2 = contents;
                    g = a.g(parcel, F);
                    z2 = z3;
                    break;
                case 2:
                    g = i;
                    Contents contents3 = (Contents) a.a(parcel, F, Contents.CREATOR);
                    z2 = z;
                    contents2 = contents3;
                    break;
                case 3:
                    z2 = a.c(parcel, F);
                    contents2 = contents;
                    g = i;
                    break;
                default:
                    a.b(parcel, F);
                    z2 = z;
                    contents2 = contents;
                    g = i;
                    break;
            }
            i = g;
            contents = contents2;
            z = z2;
        }
        if (parcel.dataPosition() == G) {
            return new OnContentsResponse(i, contents, z);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public OnContentsResponse[] bF(int i) {
        return new OnContentsResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aq(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bF(x0);
    }
}
