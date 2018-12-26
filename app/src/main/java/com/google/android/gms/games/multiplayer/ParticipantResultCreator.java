package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ParticipantResultCreator implements Creator<ParticipantResult> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(ParticipantResult participantResult, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, participantResult.getParticipantId(), false);
        b.c(parcel, 1000, participantResult.getVersionCode());
        b.c(parcel, 2, participantResult.getResult());
        b.c(parcel, 3, participantResult.getPlacing());
        b.H(parcel, H);
    }

    public ParticipantResult createFromParcel(Parcel parcel) {
        int i = 0;
        int G = a.G(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    str = a.o(parcel, F);
                    break;
                case 2:
                    i2 = a.g(parcel, F);
                    break;
                case 3:
                    i = a.g(parcel, F);
                    break;
                case 1000:
                    i3 = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ParticipantResult(i3, str, i2, i);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public ParticipantResult[] newArray(int size) {
        return new ParticipantResult[size];
    }
}
