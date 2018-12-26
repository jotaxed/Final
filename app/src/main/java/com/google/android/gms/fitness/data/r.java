package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class r implements Creator<q> {
    static void a(q qVar, Parcel parcel, int i) {
        int H = b.H(parcel);
        b.a(parcel, 1, qVar.getSession(), i, false);
        b.c(parcel, 1000, qVar.CK);
        b.a(parcel, 2, qVar.jH(), i, false);
        b.H(parcel, H);
    }

    public q bD(Parcel parcel) {
        DataSet dataSet = null;
        int G = a.G(parcel);
        int i = 0;
        Session session = null;
        while (parcel.dataPosition() < G) {
            int i2;
            DataSet dataSet2;
            Session session2;
            int F = a.F(parcel);
            switch (a.aH(F)) {
                case 1:
                    i2 = i;
                    Session session3 = (Session) a.a(parcel, F, Session.CREATOR);
                    dataSet2 = dataSet;
                    session2 = session3;
                    break;
                case 2:
                    dataSet2 = (DataSet) a.a(parcel, F, DataSet.CREATOR);
                    session2 = session;
                    i2 = i;
                    break;
                case 1000:
                    DataSet dataSet3 = dataSet;
                    session2 = session;
                    i2 = a.g(parcel, F);
                    dataSet2 = dataSet3;
                    break;
                default:
                    a.b(parcel, F);
                    dataSet2 = dataSet;
                    session2 = session;
                    i2 = i;
                    break;
            }
            i = i2;
            session = session2;
            dataSet = dataSet2;
        }
        if (parcel.dataPosition() == G) {
            return new q(i, session, dataSet);
        }
        throw new a.a("Overread allowed size end=" + G, parcel);
    }

    public q[] cX(int i) {
        return new q[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bD(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cX(x0);
    }
}
