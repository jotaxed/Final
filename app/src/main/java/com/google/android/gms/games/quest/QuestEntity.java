package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.le;
import java.util.ArrayList;
import java.util.List;

public final class QuestEntity implements SafeParcelable, Quest {
    public static final QuestEntityCreator CREATOR = new QuestEntityCreator();
    private final int CK;
    private final int Gt;
    private final String UO;
    private final long XH;
    private final GameEntity acs;
    private final String aeK;
    private final long aeL;
    private final Uri aeM;
    private final String aeN;
    private final long aeO;
    private final Uri aeP;
    private final String aeQ;
    private final long aeR;
    private final long aeS;
    private final ArrayList<MilestoneEntity> aeT;
    private final String mName;
    private final int mState;

    QuestEntity(int versionCode, GameEntity game, String questId, long acceptedTimestamp, Uri bannerImageUri, String bannerImageUrl, String description, long endTimestamp, long lastUpdatedTimestamp, Uri iconImageUri, String iconImageUrl, String name, long notifyTimestamp, long startTimestamp, int state, int type, ArrayList<MilestoneEntity> milestones) {
        this.CK = versionCode;
        this.acs = game;
        this.aeK = questId;
        this.aeL = acceptedTimestamp;
        this.aeM = bannerImageUri;
        this.aeN = bannerImageUrl;
        this.UO = description;
        this.aeO = endTimestamp;
        this.XH = lastUpdatedTimestamp;
        this.aeP = iconImageUri;
        this.aeQ = iconImageUrl;
        this.mName = name;
        this.aeR = notifyTimestamp;
        this.aeS = startTimestamp;
        this.mState = state;
        this.Gt = type;
        this.aeT = milestones;
    }

    public QuestEntity(Quest quest) {
        this.CK = 2;
        this.acs = new GameEntity(quest.getGame());
        this.aeK = quest.getQuestId();
        this.aeL = quest.getAcceptedTimestamp();
        this.UO = quest.getDescription();
        this.aeM = quest.getBannerImageUri();
        this.aeN = quest.getBannerImageUrl();
        this.aeO = quest.getEndTimestamp();
        this.aeP = quest.getIconImageUri();
        this.aeQ = quest.getIconImageUrl();
        this.XH = quest.getLastUpdatedTimestamp();
        this.mName = quest.getName();
        this.aeR = quest.mR();
        this.aeS = quest.getStartTimestamp();
        this.mState = quest.getState();
        this.Gt = quest.getType();
        List mQ = quest.mQ();
        int size = mQ.size();
        this.aeT = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.aeT.add((MilestoneEntity) ((Milestone) mQ.get(i)).freeze());
        }
    }

    static int a(Quest quest) {
        return jv.hashCode(quest.getGame(), quest.getQuestId(), Long.valueOf(quest.getAcceptedTimestamp()), quest.getBannerImageUri(), quest.getDescription(), Long.valueOf(quest.getEndTimestamp()), quest.getIconImageUri(), Long.valueOf(quest.getLastUpdatedTimestamp()), quest.mQ(), quest.getName(), Long.valueOf(quest.mR()), Long.valueOf(quest.getStartTimestamp()), Integer.valueOf(quest.getState()));
    }

    static boolean a(Quest quest, Object obj) {
        if (!(obj instanceof Quest)) {
            return false;
        }
        if (quest == obj) {
            return true;
        }
        Quest quest2 = (Quest) obj;
        return jv.equal(quest2.getGame(), quest.getGame()) && jv.equal(quest2.getQuestId(), quest.getQuestId()) && jv.equal(Long.valueOf(quest2.getAcceptedTimestamp()), Long.valueOf(quest.getAcceptedTimestamp())) && jv.equal(quest2.getBannerImageUri(), quest.getBannerImageUri()) && jv.equal(quest2.getDescription(), quest.getDescription()) && jv.equal(Long.valueOf(quest2.getEndTimestamp()), Long.valueOf(quest.getEndTimestamp())) && jv.equal(quest2.getIconImageUri(), quest.getIconImageUri()) && jv.equal(Long.valueOf(quest2.getLastUpdatedTimestamp()), Long.valueOf(quest.getLastUpdatedTimestamp())) && jv.equal(quest2.mQ(), quest.mQ()) && jv.equal(quest2.getName(), quest.getName()) && jv.equal(Long.valueOf(quest2.mR()), Long.valueOf(quest.mR())) && jv.equal(Long.valueOf(quest2.getStartTimestamp()), Long.valueOf(quest.getStartTimestamp())) && jv.equal(Integer.valueOf(quest2.getState()), Integer.valueOf(quest.getState()));
    }

    static String b(Quest quest) {
        return jv.h(quest).a("Game", quest.getGame()).a("QuestId", quest.getQuestId()).a("AcceptedTimestamp", Long.valueOf(quest.getAcceptedTimestamp())).a("BannerImageUri", quest.getBannerImageUri()).a("BannerImageUrl", quest.getBannerImageUrl()).a("Description", quest.getDescription()).a("EndTimestamp", Long.valueOf(quest.getEndTimestamp())).a("IconImageUri", quest.getIconImageUri()).a("IconImageUrl", quest.getIconImageUrl()).a("LastUpdatedTimestamp", Long.valueOf(quest.getLastUpdatedTimestamp())).a("Milestones", quest.mQ()).a("Name", quest.getName()).a("NotifyTimestamp", Long.valueOf(quest.mR())).a("StartTimestamp", Long.valueOf(quest.getStartTimestamp())).a("State", Integer.valueOf(quest.getState())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public Quest freeze() {
        return this;
    }

    public long getAcceptedTimestamp() {
        return this.aeL;
    }

    public Uri getBannerImageUri() {
        return this.aeM;
    }

    public String getBannerImageUrl() {
        return this.aeN;
    }

    public Milestone getCurrentMilestone() {
        return (Milestone) mQ().get(0);
    }

    public String getDescription() {
        return this.UO;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        le.b(this.UO, dataOut);
    }

    public long getEndTimestamp() {
        return this.aeO;
    }

    public Game getGame() {
        return this.acs;
    }

    public Uri getIconImageUri() {
        return this.aeP;
    }

    public String getIconImageUrl() {
        return this.aeQ;
    }

    public long getLastUpdatedTimestamp() {
        return this.XH;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer dataOut) {
        le.b(this.mName, dataOut);
    }

    public String getQuestId() {
        return this.aeK;
    }

    public long getStartTimestamp() {
        return this.aeS;
    }

    public int getState() {
        return this.mState;
    }

    public int getType() {
        return this.Gt;
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

    public boolean isEndingSoon() {
        return this.aeR <= System.currentTimeMillis() + 1800000;
    }

    public List<Milestone> mQ() {
        return new ArrayList(this.aeT);
    }

    public long mR() {
        return this.aeR;
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        QuestEntityCreator.a(this, out, flags);
    }
}
