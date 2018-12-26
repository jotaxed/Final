package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.Subscription;
import java.util.List;

public class e implements Creator<ListSubscriptionsResult> {
    static void a(ListSubscriptionsResult listSubscriptionsResult, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.c(parcel, 1, listSubscriptionsResult.getSubscriptions(), false);
        b.c(parcel, 1000, listSubscriptionsResult.getVersionCode());
        b.a(parcel, 2, listSubscriptionsResult.getStatus(), i, false);
        b.H(parcel, H);
    }

    public ListSubscriptionsResult ch(Parcel parcel) {
        Status status = null;
        int G = a.G(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < G) {
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    list = a.c(parcel, F, Subscription.CREATOR);
                    break;
                case 2:
                    status = (Status) a.a(parcel, F, Status.CREATOR);
                    break;
                case 1000:
                    i = a.g(parcel, F);
                    break;
                default:
                    a.b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ListSubscriptionsResult(i, list, status);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ch(x0);
    }

    public ListSubscriptionsResult[] dC(int i) {
        return new ListSubscriptionsResult[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dC(x0);
    }
}
