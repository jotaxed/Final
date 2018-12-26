package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.List;

public class b implements Creator<ParcelableEvent> {
    static void a(ParcelableEvent parcelableEvent, Parcel parcel, int i) {
        int H = com.google.android.gms.common.internal.safeparcel.b.H(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, parcelableEvent.CK);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, parcelableEvent.vZ, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, parcelableEvent.SJ, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 4, parcelableEvent.SQ, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, parcelableEvent.SR);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, parcelableEvent.SM, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 7, parcelableEvent.SS, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 8, parcelableEvent.ST, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 9, parcelableEvent.SU, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 10, parcelableEvent.SV, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 11, parcelableEvent.SW, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 12, parcelableEvent.SX, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 13, parcelableEvent.SY, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 14, parcelableEvent.SZ, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 15, parcelableEvent.Ta, i, false);
        com.google.android.gms.common.internal.safeparcel.b.H(parcel, H);
    }

    public ParcelableEvent bh(Parcel parcel) {
        int G = a.G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        TextInsertedDetails textInsertedDetails = null;
        TextDeletedDetails textDeletedDetails = null;
        ValuesAddedDetails valuesAddedDetails = null;
        ValuesRemovedDetails valuesRemovedDetails = null;
        ValuesSetDetails valuesSetDetails = null;
        ValueChangedDetails valueChangedDetails = null;
        ReferenceShiftedDetails referenceShiftedDetails = null;
        ObjectChangedDetails objectChangedDetails = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i = a.g(parcel, F);
                    break;
                case 2:
                    str = a.o(parcel, F);
                    break;
                case 3:
                    str2 = a.o(parcel, F);
                    break;
                case 4:
                    list = a.C(parcel, F);
                    break;
                case 5:
                    z = a.c(parcel, F);
                    break;
                case 6:
                    str3 = a.o(parcel, F);
                    break;
                case 7:
                    str4 = a.o(parcel, F);
                    break;
                case 8:
                    textInsertedDetails = (TextInsertedDetails) a.a(parcel, F, TextInsertedDetails.CREATOR);
                    break;
                case 9:
                    textDeletedDetails = (TextDeletedDetails) a.a(parcel, F, TextDeletedDetails.CREATOR);
                    break;
                case 10:
                    valuesAddedDetails = (ValuesAddedDetails) a.a(parcel, F, ValuesAddedDetails.CREATOR);
                    break;
                case 11:
                    valuesRemovedDetails = (ValuesRemovedDetails) a.a(parcel, F, ValuesRemovedDetails.CREATOR);
                    break;
                case 12:
                    valuesSetDetails = (ValuesSetDetails) a.a(parcel, F, ValuesSetDetails.CREATOR);
                    break;
                case 13:
                    valueChangedDetails = (ValueChangedDetails) a.a(parcel, F, ValueChangedDetails.CREATOR);
                    break;
                case 14:
                    referenceShiftedDetails = (ReferenceShiftedDetails) a.a(parcel, F, ReferenceShiftedDetails.CREATOR);
                    break;
                case 15:
                    objectChangedDetails = (ObjectChangedDetails) a.a(parcel, F, ObjectChangedDetails.CREATOR);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ParcelableEvent(i, str, str2, list, z, str3, str4, textInsertedDetails, textDeletedDetails, valuesAddedDetails, valuesRemovedDetails, valuesSetDetails, valueChangedDetails, referenceShiftedDetails, objectChangedDetails);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bh(x0);
    }

    public ParcelableEvent[] cx(int i) {
        return new ParcelableEvent[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cx(x0);
    }
}
