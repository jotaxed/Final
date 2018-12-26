package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public final class MilestoneEntity implements SafeParcelable, Milestone {
    public static final MilestoneEntityCreator CREATOR = new MilestoneEntityCreator();
    private final int CK;
    private final String Ye;
    private final String Zn;
    private final long aeH;
    private final long aeI;
    private final byte[] aeJ;
    private final int mState;

    MilestoneEntity(int versionCode, String milestoneId, long currentProgress, long targetProgress, byte[] completionBlob, int state, String eventId) {
        this.CK = versionCode;
        this.Zn = milestoneId;
        this.aeH = currentProgress;
        this.aeI = targetProgress;
        this.aeJ = completionBlob;
        this.mState = state;
        this.Ye = eventId;
    }

    public MilestoneEntity(Milestone milestone) {
        this.CK = 4;
        this.Zn = milestone.getMilestoneId();
        this.aeH = milestone.getCurrentProgress();
        this.aeI = milestone.getTargetProgress();
        this.mState = milestone.getState();
        this.Ye = milestone.getEventId();
        Object completionRewardData = milestone.getCompletionRewardData();
        if (completionRewardData == null) {
            this.aeJ = null;
            return;
        }
        this.aeJ = new byte[completionRewardData.length];
        System.arraycopy(completionRewardData, 0, this.aeJ, 0, completionRewardData.length);
    }

    static int a(Milestone milestone) {
        return jv.hashCode(milestone.getMilestoneId(), Long.valueOf(milestone.getCurrentProgress()), Long.valueOf(milestone.getTargetProgress()), Integer.valueOf(milestone.getState()), milestone.getEventId());
    }

    static boolean a(Milestone milestone, Object obj) {
        if (!(obj instanceof Milestone)) {
            return false;
        }
        if (milestone == obj) {
            return true;
        }
        Milestone milestone2 = (Milestone) obj;
        return jv.equal(milestone2.getMilestoneId(), milestone.getMilestoneId()) && jv.equal(Long.valueOf(milestone2.getCurrentProgress()), Long.valueOf(milestone.getCurrentProgress())) && jv.equal(Long.valueOf(milestone2.getTargetProgress()), Long.valueOf(milestone.getTargetProgress())) && jv.equal(Integer.valueOf(milestone2.getState()), Integer.valueOf(milestone.getState())) && jv.equal(milestone2.getEventId(), milestone.getEventId());
    }

    static String b(Milestone milestone) {
        return jv.h(milestone).a("MilestoneId", milestone.getMilestoneId()).a("CurrentProgress", Long.valueOf(milestone.getCurrentProgress())).a("TargetProgress", Long.valueOf(milestone.getTargetProgress())).a("State", Integer.valueOf(milestone.getState())).a("CompletionRewardData", milestone.getCompletionRewardData()).a("EventId", milestone.getEventId()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public Milestone freeze() {
        return this;
    }

    public byte[] getCompletionRewardData() {
        return this.aeJ;
    }

    public long getCurrentProgress() {
        return this.aeH;
    }

    public String getEventId() {
        return this.Ye;
    }

    public String getMilestoneId() {
        return this.Zn;
    }

    public int getState() {
        return this.mState;
    }

    public long getTargetProgress() {
        return this.aeI;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        MilestoneEntityCreator.a(this, out, flags);
    }
}
