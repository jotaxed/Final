package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.mg;

public class DataSource implements SafeParcelable {
    public static final Creator<DataSource> CREATOR = new g();
    public static final String EXTRA_DATA_SOURCE = "vnd.google.fitness.data_source";
    public static final int TYPE_DERIVED = 1;
    public static final int TYPE_RAW = 0;
    private final int CK;
    private final int Gt;
    private final DataType TM;
    private final Device Ul;
    private final a Um;
    private final String Un;
    private final boolean Uo;
    private final String Up;
    private final String mName;

    public static final class Builder {
        private int Gt = -1;
        private DataType TM;
        private Device Ul;
        private a Um;
        private String Un = "";
        private boolean Uo = false;
        private String mName;

        public DataSource build() {
            boolean z = true;
            jx.a(this.TM != null, "Must set data type");
            if (this.Gt < 0) {
                z = false;
            }
            jx.a(z, "Must set data source type");
            return new DataSource();
        }

        public Builder setAppPackageName(Context appContext) {
            return setAppPackageName(appContext.getPackageName());
        }

        public Builder setAppPackageName(String packageName) {
            this.Um = new a(packageName, null, null);
            return this;
        }

        public Builder setDataType(DataType dataType) {
            this.TM = dataType;
            return this;
        }

        public Builder setDevice(Device device) {
            this.Ul = device;
            return this;
        }

        public Builder setName(String name) {
            this.mName = name;
            return this;
        }

        public Builder setObfuscated(boolean isObfuscated) {
            this.Uo = isObfuscated;
            return this;
        }

        public Builder setStreamName(String streamName) {
            jx.b(streamName != null, (Object) "Must specify a valid stream name");
            this.Un = streamName;
            return this;
        }

        public Builder setType(int type) {
            this.Gt = type;
            return this;
        }
    }

    DataSource(int versionCode, DataType dataType, String name, int type, Device device, a application, String streamName, boolean isObfuscated) {
        this.CK = versionCode;
        this.TM = dataType;
        this.Gt = type;
        this.mName = name;
        this.Ul = device;
        this.Um = application;
        this.Un = streamName;
        this.Uo = isObfuscated;
        this.Up = jy();
    }

    private DataSource(Builder builder) {
        this.CK = 3;
        this.TM = builder.TM;
        this.Gt = builder.Gt;
        this.mName = builder.mName;
        this.Ul = builder.Ul;
        this.Um = builder.Um;
        this.Un = builder.Un;
        this.Uo = builder.Uo;
        this.Up = jy();
    }

    private boolean a(DataSource dataSource) {
        return this.Up.equals(dataSource.Up);
    }

    public static DataSource extract(Intent intent) {
        return intent == null ? null : (DataSource) c.a(intent, EXTRA_DATA_SOURCE, CREATOR);
    }

    private String getTypeString() {
        switch (this.Gt) {
            case 0:
                return "raw";
            case 1:
                return "derived";
            default:
                throw new IllegalArgumentException("invalid type value");
        }
    }

    private String jy() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getTypeString());
        stringBuilder.append(":").append(this.TM.getName());
        if (this.Um != null) {
            stringBuilder.append(":").append(this.Um.getPackageName());
        }
        if (this.Ul != null) {
            stringBuilder.append(":").append(this.Ul.getStreamIdentifier());
        }
        if (this.Un != null) {
            stringBuilder.append(":").append(this.Un);
        }
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataSource) && a((DataSource) that));
    }

    public String getAppPackageName() {
        return this.Um == null ? null : this.Um.getPackageName();
    }

    public DataType getDataType() {
        return this.TM;
    }

    public Device getDevice() {
        return this.Ul;
    }

    public String getName() {
        return this.mName;
    }

    public String getStreamIdentifier() {
        return this.Up;
    }

    public String getStreamName() {
        return this.Un;
    }

    public int getType() {
        return this.Gt;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return this.Up.hashCode();
    }

    public DataSource jA() {
        return new DataSource(3, this.TM, this.mName, this.Gt, this.Ul == null ? null : this.Ul.jE(), this.Um == null ? null : this.Um.jl(), mg.bw(this.Un), this.Uo);
    }

    public a jx() {
        return this.Um;
    }

    public boolean jz() {
        return this.Uo;
    }

    public String toDebugString() {
        StringBuilder append = new StringBuilder().append(this.Gt == 0 ? "r" : "d").append(":").append(this.TM.jB());
        String str = this.Um == null ? "" : this.Um.equals(a.TT) ? ":gms" : ":" + this.Um.getPackageName();
        return append.append(str).append(this.Ul != null ? ":" + this.Ul.getModel() + ":" + this.Ul.getUid() : "").append(this.Un != null ? ":" + this.Un : "").toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DataSource{");
        stringBuilder.append(getTypeString());
        if (this.mName != null) {
            stringBuilder.append(":").append(this.mName);
        }
        if (this.Um != null) {
            stringBuilder.append(":").append(this.Um);
        }
        if (this.Ul != null) {
            stringBuilder.append(":").append(this.Ul);
        }
        if (this.Un != null) {
            stringBuilder.append(":").append(this.Un);
        }
        stringBuilder.append(":").append(this.TM);
        return stringBuilder.append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        g.a(mg.c(this), parcel, flags);
    }
}
