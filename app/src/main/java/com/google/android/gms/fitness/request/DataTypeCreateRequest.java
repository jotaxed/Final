package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataTypeCreateRequest implements SafeParcelable {
    public static final Creator<DataTypeCreateRequest> CREATOR = new i();
    private final int CK;
    private final List<Field> Uv;
    private final String mName;

    public static class Builder {
        private List<Field> Uv = new ArrayList();
        private String mName;

        public Builder addField(Field field) {
            if (!this.Uv.contains(field)) {
                this.Uv.add(field);
            }
            return this;
        }

        public Builder addField(String name, int format) {
            boolean z = (name == null && name.isEmpty()) ? false : true;
            jx.b(z, (Object) "Invalid name specified");
            return addField(new Field(name, format));
        }

        public DataTypeCreateRequest build() {
            boolean z = true;
            jx.a(this.mName != null, "Must set the name");
            if (this.Uv.isEmpty()) {
                z = false;
            }
            jx.a(z, "Must specify the data fields");
            return new DataTypeCreateRequest();
        }

        public Builder setName(String name) {
            this.mName = name;
            return this;
        }
    }

    DataTypeCreateRequest(int versionCode, String name, List<Field> fields) {
        this.CK = versionCode;
        this.mName = name;
        this.Uv = Collections.unmodifiableList(fields);
    }

    private DataTypeCreateRequest(Builder builder) {
        this.CK = 1;
        this.mName = builder.mName;
        this.Uv = Collections.unmodifiableList(builder.Uv);
    }

    private boolean a(DataTypeCreateRequest dataTypeCreateRequest) {
        return jv.equal(this.mName, dataTypeCreateRequest.mName) && jv.equal(this.Uv, dataTypeCreateRequest.Uv);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataTypeCreateRequest) && a((DataTypeCreateRequest) o));
    }

    public List<Field> getFields() {
        return this.Uv;
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.mName, this.Uv);
    }

    public String toString() {
        return jv.h(this).a("name", this.mName).a("fields", this.Uv).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        i.a(this, dest, flags);
    }
}
