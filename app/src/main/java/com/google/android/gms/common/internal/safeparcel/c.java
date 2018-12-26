package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.jx;

public final class c {
    public static <T extends SafeParcelable> T a(Intent intent, String str, Creator<T> creator) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        return byteArrayExtra == null ? null : a(byteArrayExtra, creator);
    }

    public static <T extends SafeParcelable> T a(byte[] bArr, Creator<T> creator) {
        jx.i(creator);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) creator.createFromParcel(obtain);
        obtain.recycle();
        return safeParcelable;
    }

    public static <T extends SafeParcelable> void a(T t, Intent intent, String str) {
        intent.putExtra(str, a(t));
    }

    public static <T extends SafeParcelable> byte[] a(T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
