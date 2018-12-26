package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ParcelableEvent implements SafeParcelable {
    public static final Creator<ParcelableEvent> CREATOR = new b();
    final int CK;
    final String SJ;
    final String SM;
    final List<String> SQ;
    final boolean SR;
    final String SS;
    final TextInsertedDetails ST;
    final TextDeletedDetails SU;
    final ValuesAddedDetails SV;
    final ValuesRemovedDetails SW;
    final ValuesSetDetails SX;
    final ValueChangedDetails SY;
    final ReferenceShiftedDetails SZ;
    final ObjectChangedDetails Ta;
    final String vZ;

    ParcelableEvent(int versionCode, String sessionId, String userId, List<String> compoundOperationNames, boolean isLocal, String objectId, String objectType, TextInsertedDetails textInsertedDetails, TextDeletedDetails textDeletedDetails, ValuesAddedDetails valuesAddedDetails, ValuesRemovedDetails valuesRemovedDetails, ValuesSetDetails valuesSetDetails, ValueChangedDetails valueChangedDetails, ReferenceShiftedDetails referenceShiftedDetails, ObjectChangedDetails objectChangedDetails) {
        this.CK = versionCode;
        this.vZ = sessionId;
        this.SJ = userId;
        this.SQ = compoundOperationNames;
        this.SR = isLocal;
        this.SM = objectId;
        this.SS = objectType;
        this.ST = textInsertedDetails;
        this.SU = textDeletedDetails;
        this.SV = valuesAddedDetails;
        this.SW = valuesRemovedDetails;
        this.SX = valuesSetDetails;
        this.SY = valueChangedDetails;
        this.SZ = referenceShiftedDetails;
        this.Ta = objectChangedDetails;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        b.a(this, dest, flags);
    }
}
