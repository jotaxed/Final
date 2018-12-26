package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

public class FieldWithSortOrder implements SafeParcelable {
    public static final c CREATOR = new c();
    final int CK;
    final String QY;
    final boolean Sk;

    FieldWithSortOrder(int versionCode, String fieldName, boolean isSortAscending) {
        this.CK = versionCode;
        this.QY = fieldName;
        this.Sk = isSortAscending;
    }

    public FieldWithSortOrder(String fieldName, boolean isSortAscending) {
        this(1, fieldName, isSortAscending);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        Locale locale = Locale.US;
        String str = "FieldWithSortOrder[%s %s]";
        Object[] objArr = new Object[2];
        objArr[0] = this.QY;
        objArr[1] = this.Sk ? "ASC" : "DESC";
        return String.format(locale, str, objArr);
    }

    public void writeToParcel(Parcel out, int flags) {
        c.a(this, out, flags);
    }
}
