package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public final class AppContentTupleEntity implements SafeParcelable, AppContentTuple {
    public static final AppContentTupleEntityCreator CREATOR = new AppContentTupleEntityCreator();
    private final int CK;
    private final String mName;
    private final String mValue;

    AppContentTupleEntity(int versionCode, String name, String value) {
        this.CK = versionCode;
        this.mName = name;
        this.mValue = value;
    }

    public AppContentTupleEntity(AppContentTuple tuple) {
        this.CK = 1;
        this.mName = tuple.getName();
        this.mValue = tuple.getValue();
    }

    static int a(AppContentTuple appContentTuple) {
        return jv.hashCode(appContentTuple.getName(), appContentTuple.getValue());
    }

    static boolean a(AppContentTuple appContentTuple, Object obj) {
        if (!(obj instanceof AppContentTuple)) {
            return false;
        }
        if (appContentTuple == obj) {
            return true;
        }
        AppContentTuple appContentTuple2 = (AppContentTuple) obj;
        return jv.equal(appContentTuple2.getName(), appContentTuple.getName()) && jv.equal(appContentTuple2.getValue(), appContentTuple.getValue());
    }

    static String b(AppContentTuple appContentTuple) {
        return jv.h(appContentTuple).a("Name", appContentTuple.getName()).a("Value", appContentTuple.getValue()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return ld();
    }

    public String getName() {
        return this.mName;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public AppContentTuple ld() {
        return this;
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        AppContentTupleEntityCreator.a(this, out, flags);
    }
}
