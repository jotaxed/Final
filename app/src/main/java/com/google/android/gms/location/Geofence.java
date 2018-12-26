package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.internal.nn;

public interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1;

    public static final class Builder {
        private String Zt = null;
        private int agd = 0;
        private long age = Long.MIN_VALUE;
        private short agf = (short) -1;
        private double agg;
        private double agh;
        private float agi;
        private int agj = 0;
        private int agk = -1;

        public Geofence build() {
            if (this.Zt == null) {
                throw new IllegalArgumentException("Request ID not set.");
            } else if (this.agd == 0) {
                throw new IllegalArgumentException("Transitions types not set.");
            } else if ((this.agd & 4) != 0 && this.agk < 0) {
                throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
            } else if (this.age == Long.MIN_VALUE) {
                throw new IllegalArgumentException("Expiration not set.");
            } else if (this.agf == (short) -1) {
                throw new IllegalArgumentException("Geofence region not set.");
            } else if (this.agj >= 0) {
                return new nn(this.Zt, this.agd, (short) 1, this.agg, this.agh, this.agi, this.age, this.agj, this.agk);
            } else {
                throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
            }
        }

        public Builder setCircularRegion(double latitude, double longitude, float radius) {
            this.agf = (short) 1;
            this.agg = latitude;
            this.agh = longitude;
            this.agi = radius;
            return this;
        }

        public Builder setExpirationDuration(long durationMillis) {
            if (durationMillis < 0) {
                this.age = -1;
            } else {
                this.age = SystemClock.elapsedRealtime() + durationMillis;
            }
            return this;
        }

        public Builder setLoiteringDelay(int loiteringDelayMs) {
            this.agk = loiteringDelayMs;
            return this;
        }

        public Builder setNotificationResponsiveness(int notificationResponsivenessMs) {
            this.agj = notificationResponsivenessMs;
            return this;
        }

        public Builder setRequestId(String requestId) {
            this.Zt = requestId;
            return this;
        }

        public Builder setTransitionTypes(int transitionTypes) {
            this.agd = transitionTypes;
            return this;
        }
    }

    String getRequestId();
}
