package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.FileUploadPreferences;

public final class FileUploadPreferencesImpl implements SafeParcelable, FileUploadPreferences {
    public static final Creator<FileUploadPreferencesImpl> CREATOR = new ab();
    final int CK;
    int QA;
    boolean QB;
    int Qz;

    FileUploadPreferencesImpl(int versionCode, int networkTypePreference, int batteryUsagePreference, boolean allowRoaming) {
        this.CK = versionCode;
        this.Qz = networkTypePreference;
        this.QA = batteryUsagePreference;
        this.QB = allowRoaming;
    }

    public static boolean by(int i) {
        switch (i) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    public static boolean bz(int i) {
        switch (i) {
            case 256:
            case FileUploadPreferences.BATTERY_USAGE_CHARGING_ONLY /*257*/:
                return true;
            default:
                return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getBatteryUsagePreference() {
        return !bz(this.QA) ? 0 : this.QA;
    }

    public int getNetworkTypePreference() {
        return !by(this.Qz) ? 0 : this.Qz;
    }

    public boolean isRoamingAllowed() {
        return this.QB;
    }

    public void setBatteryUsagePreference(int batteryUsagePreference) {
        if (bz(batteryUsagePreference)) {
            this.QA = batteryUsagePreference;
            return;
        }
        throw new IllegalArgumentException("Invalid battery usage preference value.");
    }

    public void setNetworkTypePreference(int networkTypePreference) {
        if (by(networkTypePreference)) {
            this.Qz = networkTypePreference;
            return;
        }
        throw new IllegalArgumentException("Invalid data connection preference value.");
    }

    public void setRoamingAllowed(boolean allowRoaming) {
        this.QB = allowRoaming;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        ab.a(this, parcel, flags);
    }
}
