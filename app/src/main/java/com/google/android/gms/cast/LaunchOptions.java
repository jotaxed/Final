package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.in;
import com.google.android.gms.internal.jv;
import java.util.Locale;

public class LaunchOptions implements SafeParcelable {
    public static final Creator<LaunchOptions> CREATOR = new c();
    private final int CK;
    private boolean FQ;
    private String FR;

    public static final class Builder {
        private LaunchOptions FS = new LaunchOptions();

        public LaunchOptions build() {
            return this.FS;
        }

        public Builder setLocale(Locale locale) {
            this.FS.setLanguage(in.b(locale));
            return this;
        }

        public Builder setRelaunchIfRunning(boolean relaunchIfRunning) {
            this.FS.setRelaunchIfRunning(relaunchIfRunning);
            return this;
        }
    }

    public LaunchOptions() {
        this(1, false, in.b(Locale.getDefault()));
    }

    LaunchOptions(int versionCode, boolean relaunchIfRunning, String language) {
        this.CK = versionCode;
        this.FQ = relaunchIfRunning;
        this.FR = language;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LaunchOptions)) {
            return false;
        }
        LaunchOptions launchOptions = (LaunchOptions) obj;
        return this.FQ == launchOptions.FQ && in.a(this.FR, launchOptions.FR);
    }

    public String getLanguage() {
        return this.FR;
    }

    public boolean getRelaunchIfRunning() {
        return this.FQ;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(Boolean.valueOf(this.FQ), this.FR);
    }

    public void setLanguage(String language) {
        this.FR = language;
    }

    public void setRelaunchIfRunning(boolean relaunchIfRunning) {
        this.FQ = relaunchIfRunning;
    }

    public String toString() {
        return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", new Object[]{Boolean.valueOf(this.FQ), this.FR});
    }

    public void writeToParcel(Parcel out, int flags) {
        c.a(this, out, flags);
    }
}
