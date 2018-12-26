package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;

public final class NotifyTransactionStatusRequest implements SafeParcelable {
    public static final Creator<NotifyTransactionStatusRequest> CREATOR = new m();
    final int CK;
    String auL;
    String avL;
    int status;

    public final class Builder {
        final /* synthetic */ NotifyTransactionStatusRequest avM;

        private Builder(NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
            this.avM = notifyTransactionStatusRequest;
        }

        public NotifyTransactionStatusRequest build() {
            boolean z = true;
            jx.b(!TextUtils.isEmpty(this.avM.auL), (Object) "googleTransactionId is required");
            if (this.avM.status < 1 || this.avM.status > 8) {
                z = false;
            }
            jx.b(z, (Object) "status is an unrecognized value");
            return this.avM;
        }

        public Builder setDetailedReason(String detailedReason) {
            this.avM.avL = detailedReason;
            return this;
        }

        public Builder setGoogleTransactionId(String googleTransactionId) {
            this.avM.auL = googleTransactionId;
            return this;
        }

        public Builder setStatus(int status) {
            this.avM.status = status;
            return this;
        }
    }

    public interface Status {
        public static final int SUCCESS = 1;

        public interface Error {
            public static final int AVS_DECLINE = 7;
            public static final int BAD_CARD = 4;
            public static final int BAD_CVC = 3;
            public static final int DECLINED = 5;
            public static final int FRAUD_DECLINE = 8;
            public static final int OTHER = 6;
            public static final int UNKNOWN = 2;
        }
    }

    NotifyTransactionStatusRequest() {
        this.CK = 1;
    }

    NotifyTransactionStatusRequest(int versionCode, String googleTransactionId, int status, String detailedReason) {
        this.CK = versionCode;
        this.auL = googleTransactionId;
        this.status = status;
        this.avL = detailedReason;
    }

    public static Builder newBuilder() {
        NotifyTransactionStatusRequest notifyTransactionStatusRequest = new NotifyTransactionStatusRequest();
        notifyTransactionStatusRequest.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getDetailedReason() {
        return this.avL;
    }

    public String getGoogleTransactionId() {
        return this.auL;
    }

    public int getStatus() {
        return this.status;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel out, int flags) {
        m.a(this, out, flags);
    }
}
