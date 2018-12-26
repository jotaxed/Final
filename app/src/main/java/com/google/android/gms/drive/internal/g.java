package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.Contents;

public class g implements Creator<CloseContentsRequest> {
    static void a(CloseContentsRequest closeContentsRequest, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, closeContentsRequest.CK);
        b.a(parcel, 2, closeContentsRequest.Pr, i, false);
        b.a(parcel, 3, closeContentsRequest.Pt, false);
        b.H(parcel, H);
    }

    public CloseContentsRequest ae(Parcel parcel) {
        Boolean bool = null;
        int G = a.G(parcel);
        int i = 0;
        Contents contents = null;
        while (parcel.dataPosition() < G) {
            Contents contents2;
            int g;
            Boolean bool2;
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    Boolean bool3 = bool;
                    contents2 = contents;
                    g = a.g(parcel, F);
                    bool2 = bool3;
                    break;
                case 2:
                    g = i;
                    Contents contents3 = (Contents) a.a(parcel, F, Contents.CREATOR);
                    bool2 = bool;
                    contents2 = contents3;
                    break;
                case 3:
                    bool2 = a.d(parcel, F);
                    contents2 = contents;
                    g = i;
                    break;
                default:
                    a.b(parcel, F);
                    bool2 = bool;
                    contents2 = contents;
                    g = i;
                    break;
            }
            i = g;
            contents = contents2;
            bool = bool2;
        }
        if (parcel.dataPosition() == G) {
            return new CloseContentsRequest(i, contents, bool);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public CloseContentsRequest[] bo(int i) {
        return new CloseContentsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ae(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bo(x0);
    }
}
