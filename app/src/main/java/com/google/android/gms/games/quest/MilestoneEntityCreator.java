package com.google.android.gms.games.quest;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class MilestoneEntityCreator implements Creator<MilestoneEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(MilestoneEntity milestoneEntity, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, milestoneEntity.getMilestoneId(), false);
        b.c(parcel, 1000, milestoneEntity.getVersionCode());
        b.a(parcel, 2, milestoneEntity.getCurrentProgress());
        b.a(parcel, 3, milestoneEntity.getTargetProgress());
        b.a(parcel, 4, milestoneEntity.getCompletionRewardData(), false);
        b.c(parcel, 5, milestoneEntity.getState());
        b.a(parcel, 6, milestoneEntity.getEventId(), false);
        b.H(parcel, H);
    }

    public MilestoneEntity createFromParcel(Parcel parcel) {
        long j = 0;
        int i = 0;
        String str = null;
        int G = a.G(parcel);
        byte[] bArr = null;
        long j2 = 0;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    str2 = a.o(parcel, F);
                    break;
                case 2:
                    j2 = a.i(parcel, F);
                    break;
                case 3:
                    j = a.i(parcel, F);
                    break;
                case 4:
                    bArr = a.r(parcel, F);
                    break;
                case 5:
                    i = a.g(parcel, F);
                    break;
                case 6:
                    str = a.o(parcel, F);
                    break;
                case 1000:
                    i2 = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new MilestoneEntity(i2, str2, j2, j, bArr, i, str);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public MilestoneEntity[] newArray(int size) {
        return new MilestoneEntity[size];
    }
}
