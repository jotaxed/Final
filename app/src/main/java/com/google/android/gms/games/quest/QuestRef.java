package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;
import java.util.List;

public final class QuestRef extends d implements Quest {
    private final int Ya;
    private final Game adq;

    QuestRef(DataHolder holder, int dataRow, int numChildren) {
        super(holder, dataRow);
        this.adq = new GameRef(holder, dataRow);
        this.Ya = numChildren;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return QuestEntity.a(this, obj);
    }

    public Quest freeze() {
        return new QuestEntity(this);
    }

    public long getAcceptedTimestamp() {
        return getLong("accepted_ts");
    }

    public Uri getBannerImageUri() {
        return aR("quest_banner_image_uri");
    }

    public String getBannerImageUrl() {
        return getString("quest_banner_image_url");
    }

    public Milestone getCurrentMilestone() {
        return (Milestone) mQ().get(0);
    }

    public String getDescription() {
        return getString("quest_description");
    }

    public void getDescription(CharArrayBuffer dataOut) {
        a("quest_description", dataOut);
    }

    public long getEndTimestamp() {
        return getLong("quest_end_ts");
    }

    public Game getGame() {
        return this.adq;
    }

    public Uri getIconImageUri() {
        return aR("quest_icon_image_uri");
    }

    public String getIconImageUrl() {
        return getString("quest_icon_image_url");
    }

    public long getLastUpdatedTimestamp() {
        return getLong("quest_last_updated_ts");
    }

    public String getName() {
        return getString("quest_name");
    }

    public void getName(CharArrayBuffer dataOut) {
        a("quest_name", dataOut);
    }

    public String getQuestId() {
        return getString("external_quest_id");
    }

    public long getStartTimestamp() {
        return getLong("quest_start_ts");
    }

    public int getState() {
        return getInteger("quest_state");
    }

    public int getType() {
        return getInteger("quest_type");
    }

    public int hashCode() {
        return QuestEntity.a(this);
    }

    public boolean isEndingSoon() {
        return mR() <= System.currentTimeMillis() + 1800000;
    }

    public List<Milestone> mQ() {
        List arrayList = new ArrayList(this.Ya);
        for (int i = 0; i < this.Ya; i++) {
            arrayList.add(new MilestoneRef(this.JG, this.KZ + i));
        }
        return arrayList;
    }

    public long mR() {
        return getLong("notification_ts");
    }

    public String toString() {
        return QuestEntity.b(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((QuestEntity) freeze()).writeToParcel(dest, flags);
    }
}
