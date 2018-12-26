package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class UserAddressRequest implements SafeParcelable {
    public static final Creator<UserAddressRequest> CREATOR = new a();
    private final int CK;
    List<CountrySpecification> afH;

    public final class Builder {
        final /* synthetic */ UserAddressRequest afI;

        private Builder(UserAddressRequest userAddressRequest) {
            this.afI = userAddressRequest;
        }

        public Builder addAllowedCountrySpecification(CountrySpecification countrySpecification) {
            if (this.afI.afH == null) {
                this.afI.afH = new ArrayList();
            }
            this.afI.afH.add(countrySpecification);
            return this;
        }

        public Builder addAllowedCountrySpecifications(Collection<CountrySpecification> countrySpecifications) {
            if (this.afI.afH == null) {
                this.afI.afH = new ArrayList();
            }
            this.afI.afH.addAll(countrySpecifications);
            return this;
        }

        public UserAddressRequest build() {
            if (this.afI.afH != null) {
                this.afI.afH = Collections.unmodifiableList(this.afI.afH);
            }
            return this.afI;
        }
    }

    UserAddressRequest() {
        this.CK = 1;
    }

    UserAddressRequest(int versionCode, List<CountrySpecification> allowedCountrySpecifications) {
        this.CK = versionCode;
        this.afH = allowedCountrySpecifications;
    }

    public static Builder newBuilder() {
        UserAddressRequest userAddressRequest = new UserAddressRequest();
        userAddressRequest.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel out, int flags) {
        a.a(this, out, flags);
    }
}
