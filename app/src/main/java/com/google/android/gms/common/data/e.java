package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class e<T extends SafeParcelable> extends DataBuffer<T> {
    private static final String[] Lb = new String[]{"data"};
    private final Creator<T> Lc;

    public e(DataHolder dataHolder, Creator<T> creator) {
        super(dataHolder);
        this.Lc = creator;
    }

    public T at(int i) {
        byte[] f = this.JG.f("data", i, this.JG.au(i));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(f, 0, f.length);
        obtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) this.Lc.createFromParcel(obtain);
        obtain.recycle();
        return safeParcelable;
    }

    public /* synthetic */ Object get(int x0) {
        return at(x0);
    }
}
