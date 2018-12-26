package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

public final class MilestoneRef extends d implements Milestone {
    MilestoneRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    private long mP() {
        return getLong("initial_value");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return MilestoneEntity.a(this, obj);
    }

    public Milestone freeze() {
        return new MilestoneEntity(this);
    }

    public byte[] getCompletionRewardData() {
        return getByteArray("completion_reward_data");
    }

    public long getCurrentProgress() {
        switch (getState()) {
            case 2:
                return getLong("current_value") - mP();
            case 3:
            case 4:
                return getTargetProgress();
            default:
                return 0;
        }
    }

    public String getEventId() {
        return getString("external_event_id");
    }

    public String getMilestoneId() {
        return getString("external_milestone_id");
    }

    public int getState() {
        return getInteger("milestone_state");
    }

    public long getTargetProgress() {
        return getLong("target_value");
    }

    public int hashCode() {
        return MilestoneEntity.a(this);
    }

    public String toString() {
        return MilestoneEntity.b(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((MilestoneEntity) freeze()).writeToParcel(dest, flags);
    }
}
