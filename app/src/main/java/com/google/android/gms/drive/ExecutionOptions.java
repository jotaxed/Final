package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.r;
import com.google.android.gms.internal.jv;

public final class ExecutionOptions {
    public static final int CONFLICT_STRATEGY_KEEP_REMOTE = 1;
    public static final int CONFLICT_STRATEGY_OVERWRITE_REMOTE = 0;
    public static final int MAX_TRACKING_TAG_STRING_LENGTH = 65536;
    private final int OA;
    private final String Oy;
    private final boolean Oz;

    public static final class Builder {
        private int OA = 0;
        private String Oy;
        private boolean Oz;

        public ExecutionOptions build() {
            if (this.OA != 1 || this.Oz) {
                return new ExecutionOptions(this.Oy, this.Oz, this.OA);
            }
            throw new IllegalStateException("Cannot use CONFLICT_STRATEGY_KEEP_REMOTE without requesting completion notifications");
        }

        public Builder setConflictStrategy(int strategy) {
            if (ExecutionOptions.bb(strategy)) {
                this.OA = strategy;
                return this;
            }
            throw new IllegalArgumentException("Unrecognized value for conflict strategy: " + strategy);
        }

        public Builder setNotifyOnCompletion(boolean notify) {
            this.Oz = notify;
            return this;
        }

        public Builder setTrackingTag(String trackingTag) {
            if (ExecutionOptions.bj(trackingTag)) {
                this.Oy = trackingTag;
                return this;
            }
            throw new IllegalArgumentException(String.format("trackingTag must not be null nor empty, and the length must be <= the maximum length (%s)", new Object[]{Integer.valueOf(65536)}));
        }
    }

    public ExecutionOptions(String trackingTag, boolean notifyOnCompletion, int conflictStrategy) {
        this.Oy = trackingTag;
        this.Oz = notifyOnCompletion;
        this.OA = conflictStrategy;
    }

    public static void a(GoogleApiClient googleApiClient, ExecutionOptions executionOptions) {
        r rVar = (r) googleApiClient.a(Drive.DQ);
        if (executionOptions.iw() && !rVar.iJ()) {
            throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to be notified on completion");
        }
    }

    public static boolean ba(int i) {
        switch (i) {
            case 1:
                return true;
            default:
                return false;
        }
    }

    public static boolean bb(int i) {
        switch (i) {
            case 0:
            case 1:
                return true;
            default:
                return false;
        }
    }

    public static boolean bj(String str) {
        return (str == null || str.isEmpty() || str.length() > 65536) ? false : true;
    }

    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        if (o == this) {
            return true;
        }
        ExecutionOptions executionOptions = (ExecutionOptions) o;
        return jv.equal(this.Oy, executionOptions.Oy) && this.OA == executionOptions.OA && this.Oz == executionOptions.Oz;
    }

    public int hashCode() {
        return jv.hashCode(this.Oy, Integer.valueOf(this.OA), Boolean.valueOf(this.Oz));
    }

    public String iv() {
        return this.Oy;
    }

    public boolean iw() {
        return this.Oz;
    }

    public int ix() {
        return this.OA;
    }
}
