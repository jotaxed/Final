package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.nn;
import java.util.ArrayList;
import java.util.List;

public class GeofencingRequest implements SafeParcelable {
    public static final Creator<GeofencingRequest> CREATOR = new a();
    public static final int INITIAL_TRIGGER_DWELL = 4;
    public static final int INITIAL_TRIGGER_ENTER = 1;
    public static final int INITIAL_TRIGGER_EXIT = 2;
    private final int CK;
    private final List<nn> ago;
    private final int agp;

    public static final class Builder {
        private final List<nn> ago = new ArrayList();
        private int agp = 5;

        public static int ew(int i) {
            return i & 7;
        }

        public Builder addGeofence(Geofence geofence) {
            jx.b((Object) geofence, (Object) "geofence can't be null.");
            jx.b(geofence instanceof nn, (Object) "Geofence must be created using Geofence.Builder.");
            this.ago.add((nn) geofence);
            return this;
        }

        public Builder addGeofences(List<Geofence> geofences) {
            if (!(geofences == null || geofences.isEmpty())) {
                for (Geofence geofence : geofences) {
                    if (geofence != null) {
                        addGeofence(geofence);
                    }
                }
            }
            return this;
        }

        public GeofencingRequest build() {
            jx.b(!this.ago.isEmpty(), (Object) "No geofence has been added to this request.");
            return new GeofencingRequest(this.ago, this.agp);
        }

        public Builder setInitialTrigger(int initialTrigger) {
            this.agp = ew(initialTrigger);
            return this;
        }
    }

    GeofencingRequest(int version, List<nn> geofences, int initialTrigger) {
        this.CK = version;
        this.ago = geofences;
        this.agp = initialTrigger;
    }

    private GeofencingRequest(List<nn> geofences, int initialTrigger) {
        this(1, (List) geofences, initialTrigger);
    }

    public int describeContents() {
        return 0;
    }

    public List<Geofence> getGeofences() {
        List<Geofence> arrayList = new ArrayList();
        arrayList.addAll(this.ago);
        return arrayList;
    }

    public int getInitialTrigger() {
        return this.agp;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public List<nn> ng() {
        return this.ago;
    }

    public void writeToParcel(Parcel dest, int flags) {
        a.a(this, dest, flags);
    }
}
