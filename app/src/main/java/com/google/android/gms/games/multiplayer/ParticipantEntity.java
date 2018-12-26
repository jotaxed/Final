package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.ji;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.le;

public final class ParticipantEntity extends GamesDowngradeableSafeParcel implements Participant {
    public static final Creator<ParticipantEntity> CREATOR = new ParticipantEntityCreatorCompat();
    private final int CK;
    private final int FO;
    private final int FP;
    private final String OS;
    private final Uri WD;
    private final Uri WE;
    private final String WO;
    private final String WP;
    private final PlayerEntity XE;
    private final String Yi;
    private final String Zk;
    private final boolean adZ;
    private final ParticipantResult aea;

    static final class ParticipantEntityCreatorCompat extends ParticipantEntityCreator {
        ParticipantEntityCreatorCompat() {
        }

        public ParticipantEntity cA(Parcel parcel) {
            Object obj = 1;
            if (GamesDowngradeableSafeParcel.c(ji.ht()) || ji.aW(ParticipantEntity.class.getCanonicalName())) {
                return super.cA(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            Uri parse = readString3 == null ? null : Uri.parse(readString3);
            String readString4 = parcel.readString();
            Uri parse2 = readString4 == null ? null : Uri.parse(readString4);
            int readInt = parcel.readInt();
            String readString5 = parcel.readString();
            boolean z = parcel.readInt() > 0;
            if (parcel.readInt() <= 0) {
                obj = null;
            }
            return new ParticipantEntity(3, readString, readString2, parse, parse2, readInt, readString5, z, obj != null ? (PlayerEntity) PlayerEntity.CREATOR.createFromParcel(parcel) : null, 7, null, null, null);
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return cA(x0);
        }
    }

    ParticipantEntity(int versionCode, String participantId, String displayName, Uri iconImageUri, Uri hiResImageUri, int status, String clientAddress, boolean connectedToRoom, PlayerEntity player, int capabilities, ParticipantResult result, String iconImageUrl, String hiResImageUrl) {
        this.CK = versionCode;
        this.Zk = participantId;
        this.OS = displayName;
        this.WD = iconImageUri;
        this.WE = hiResImageUri;
        this.FP = status;
        this.Yi = clientAddress;
        this.adZ = connectedToRoom;
        this.XE = player;
        this.FO = capabilities;
        this.aea = result;
        this.WO = iconImageUrl;
        this.WP = hiResImageUrl;
    }

    public ParticipantEntity(Participant participant) {
        this.CK = 3;
        this.Zk = participant.getParticipantId();
        this.OS = participant.getDisplayName();
        this.WD = participant.getIconImageUri();
        this.WE = participant.getHiResImageUri();
        this.FP = participant.getStatus();
        this.Yi = participant.le();
        this.adZ = participant.isConnectedToRoom();
        Player player = participant.getPlayer();
        this.XE = player == null ? null : new PlayerEntity(player);
        this.FO = participant.getCapabilities();
        this.aea = participant.getResult();
        this.WO = participant.getIconImageUrl();
        this.WP = participant.getHiResImageUrl();
    }

    static int a(Participant participant) {
        return jv.hashCode(participant.getPlayer(), Integer.valueOf(participant.getStatus()), participant.le(), Boolean.valueOf(participant.isConnectedToRoom()), participant.getDisplayName(), participant.getIconImageUri(), participant.getHiResImageUri(), Integer.valueOf(participant.getCapabilities()), participant.getResult(), participant.getParticipantId());
    }

    static boolean a(Participant participant, Object obj) {
        if (!(obj instanceof Participant)) {
            return false;
        }
        if (participant == obj) {
            return true;
        }
        Participant participant2 = (Participant) obj;
        return jv.equal(participant2.getPlayer(), participant.getPlayer()) && jv.equal(Integer.valueOf(participant2.getStatus()), Integer.valueOf(participant.getStatus())) && jv.equal(participant2.le(), participant.le()) && jv.equal(Boolean.valueOf(participant2.isConnectedToRoom()), Boolean.valueOf(participant.isConnectedToRoom())) && jv.equal(participant2.getDisplayName(), participant.getDisplayName()) && jv.equal(participant2.getIconImageUri(), participant.getIconImageUri()) && jv.equal(participant2.getHiResImageUri(), participant.getHiResImageUri()) && jv.equal(Integer.valueOf(participant2.getCapabilities()), Integer.valueOf(participant.getCapabilities())) && jv.equal(participant2.getResult(), participant.getResult()) && jv.equal(participant2.getParticipantId(), participant.getParticipantId());
    }

    static String b(Participant participant) {
        return jv.h(participant).a("ParticipantId", participant.getParticipantId()).a("Player", participant.getPlayer()).a("Status", Integer.valueOf(participant.getStatus())).a("ClientAddress", participant.le()).a("ConnectedToRoom", Boolean.valueOf(participant.isConnectedToRoom())).a("DisplayName", participant.getDisplayName()).a("IconImage", participant.getIconImageUri()).a("IconImageUrl", participant.getIconImageUrl()).a("HiResImage", participant.getHiResImageUri()).a("HiResImageUrl", participant.getHiResImageUrl()).a("Capabilities", Integer.valueOf(participant.getCapabilities())).a("Result", participant.getResult()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    public Participant freeze() {
        return this;
    }

    public int getCapabilities() {
        return this.FO;
    }

    public String getDisplayName() {
        return this.XE == null ? this.OS : this.XE.getDisplayName();
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        if (this.XE == null) {
            le.b(this.OS, dataOut);
        } else {
            this.XE.getDisplayName(dataOut);
        }
    }

    public Uri getHiResImageUri() {
        return this.XE == null ? this.WE : this.XE.getHiResImageUri();
    }

    public String getHiResImageUrl() {
        return this.XE == null ? this.WP : this.XE.getHiResImageUrl();
    }

    public Uri getIconImageUri() {
        return this.XE == null ? this.WD : this.XE.getIconImageUri();
    }

    public String getIconImageUrl() {
        return this.XE == null ? this.WO : this.XE.getIconImageUrl();
    }

    public String getParticipantId() {
        return this.Zk;
    }

    public Player getPlayer() {
        return this.XE;
    }

    public ParticipantResult getResult() {
        return this.aea;
    }

    public int getStatus() {
        return this.FP;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return a(this);
    }

    public boolean isConnectedToRoom() {
        return this.adZ;
    }

    public boolean isDataValid() {
        return true;
    }

    public String le() {
        return this.Yi;
    }

    public String toString() {
        return b((Participant) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        String str = null;
        int i = 0;
        if (hu()) {
            dest.writeString(this.Zk);
            dest.writeString(this.OS);
            dest.writeString(this.WD == null ? null : this.WD.toString());
            if (this.WE != null) {
                str = this.WE.toString();
            }
            dest.writeString(str);
            dest.writeInt(this.FP);
            dest.writeString(this.Yi);
            dest.writeInt(this.adZ ? 1 : 0);
            if (this.XE != null) {
                i = 1;
            }
            dest.writeInt(i);
            if (this.XE != null) {
                this.XE.writeToParcel(dest, flags);
                return;
            }
            return;
        }
        ParticipantEntityCreator.a(this, dest, flags);
    }
}
