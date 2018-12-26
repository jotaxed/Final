package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.ak;
import com.google.android.gms.drive.internal.w;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.qv;
import com.google.android.gms.internal.qw;

public class DriveId implements SafeParcelable {
    public static final Creator<DriveId> CREATOR = new c();
    final int CK;
    final String Ot;
    final long Ou;
    final long Ov;
    private volatile String Ow;

    DriveId(int versionCode, String resourceId, long sqlId, long databaseInstanceId) {
        boolean z = false;
        this.Ow = null;
        this.CK = versionCode;
        this.Ot = resourceId;
        jx.L(!"".equals(resourceId));
        if (!(resourceId == null && sqlId == -1)) {
            z = true;
        }
        jx.L(z);
        this.Ou = sqlId;
        this.Ov = databaseInstanceId;
    }

    public DriveId(String resourceId, long sqlId, long databaseInstanceId) {
        this(1, resourceId, sqlId, databaseInstanceId);
    }

    public static DriveId bi(String str) {
        jx.i(str);
        return new DriveId(str, -1, -1);
    }

    public static DriveId decodeFromString(String s) {
        jx.b(s.startsWith("DriveId:"), "Invalid DriveId: " + s);
        return f(Base64.decode(s.substring("DriveId:".length()), 10));
    }

    static DriveId f(byte[] bArr) {
        try {
            ak g = ak.g(bArr);
            return new DriveId(g.versionCode, "".equals(g.QG) ? null : g.QG, g.QH, g.QI);
        } catch (qv e) {
            throw new IllegalArgumentException();
        }
    }

    public int describeContents() {
        return 0;
    }

    public final String encodeToString() {
        if (this.Ow == null) {
            this.Ow = "DriveId:" + Base64.encodeToString(iu(), 10);
        }
        return this.Ow;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DriveId)) {
            return false;
        }
        DriveId driveId = (DriveId) obj;
        if (driveId.Ov == this.Ov) {
            return (driveId.Ou == -1 && this.Ou == -1) ? driveId.Ot.equals(this.Ot) : driveId.Ou == this.Ou;
        } else {
            w.o("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
            return false;
        }
    }

    public String getResourceId() {
        return this.Ot;
    }

    public int hashCode() {
        return this.Ou == -1 ? this.Ot.hashCode() : (String.valueOf(this.Ov) + String.valueOf(this.Ou)).hashCode();
    }

    final byte[] iu() {
        qw akVar = new ak();
        akVar.versionCode = this.CK;
        akVar.QG = this.Ot == null ? "" : this.Ot;
        akVar.QH = this.Ou;
        akVar.QI = this.Ov;
        return qw.f(akVar);
    }

    public String toString() {
        return encodeToString();
    }

    public void writeToParcel(Parcel out, int flags) {
        c.a(this, out, flags);
    }
}
