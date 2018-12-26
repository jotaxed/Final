package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public final class Status implements Result, SafeParcelable {
    public static final StatusCreator CREATOR = new StatusCreator();
    public static final Status KA = new Status(16);
    public static final Status Kw = new Status(0);
    public static final Status Kx = new Status(14);
    public static final Status Ky = new Status(8);
    public static final Status Kz = new Status(15);
    private final int CK;
    private final int Iv;
    private final String KB;
    private final PendingIntent mPendingIntent;

    public Status(int statusCode) {
        this(statusCode, null);
    }

    Status(int versionCode, int statusCode, String statusMessage, PendingIntent pendingIntent) {
        this.CK = versionCode;
        this.Iv = statusCode;
        this.KB = statusMessage;
        this.mPendingIntent = pendingIntent;
    }

    public Status(int statusCode, String statusMessage) {
        this(1, statusCode, statusMessage, null);
    }

    public Status(int statusCode, String statusMessage, PendingIntent pendingIntent) {
        this(1, statusCode, statusMessage, pendingIntent);
    }

    private String gt() {
        return this.KB != null ? this.KB : CommonStatusCodes.getStatusCodeString(this.Iv);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.CK == status.CK && this.Iv == status.Iv && jv.equal(this.KB, status.KB) && jv.equal(this.mPendingIntent, status.mPendingIntent);
    }

    PendingIntent gP() {
        return this.mPendingIntent;
    }

    @Deprecated
    public ConnectionResult gQ() {
        return new ConnectionResult(this.Iv, this.mPendingIntent);
    }

    public PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.Iv;
    }

    public String getStatusMessage() {
        return this.KB;
    }

    int getVersionCode() {
        return this.CK;
    }

    public boolean hasResolution() {
        return this.mPendingIntent != null;
    }

    public int hashCode() {
        return jv.hashCode(Integer.valueOf(this.CK), Integer.valueOf(this.Iv), this.KB, this.mPendingIntent);
    }

    public boolean isCanceled() {
        return this.Iv == 16;
    }

    public boolean isInterrupted() {
        return this.Iv == 14;
    }

    public boolean isSuccess() {
        return this.Iv <= 0;
    }

    public void startResolutionForResult(Activity activity, int requestCode) throws SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), requestCode, null, 0, 0, 0);
        }
    }

    public String toString() {
        return jv.h(this).a("statusCode", gt()).a("resolution", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        StatusCreator.a(this, out, flags);
    }
}
