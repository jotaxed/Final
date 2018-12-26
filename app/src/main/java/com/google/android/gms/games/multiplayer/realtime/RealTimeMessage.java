package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.jx;

public final class RealTimeMessage implements Parcelable {
    public static final Creator<RealTimeMessage> CREATOR = new Creator<RealTimeMessage>() {
        public RealTimeMessage cB(Parcel parcel) {
            return new RealTimeMessage(parcel);
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return cB(x0);
        }

        public RealTimeMessage[] en(int i) {
            return new RealTimeMessage[i];
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return en(x0);
        }
    };
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;
    private final String aee;
    private final byte[] aef;
    private final int aeg;

    private RealTimeMessage(Parcel parcel) {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }

    public RealTimeMessage(String senderParticipantId, byte[] messageData, int isReliable) {
        this.aee = (String) jx.i(senderParticipantId);
        this.aef = (byte[]) ((byte[]) jx.i(messageData)).clone();
        this.aeg = isReliable;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getMessageData() {
        return this.aef;
    }

    public String getSenderParticipantId() {
        return this.aee;
    }

    public boolean isReliable() {
        return this.aeg == 1;
    }

    public void writeToParcel(Parcel parcel, int flag) {
        parcel.writeString(this.aee);
        parcel.writeByteArray(this.aef);
        parcel.writeInt(this.aeg);
    }
}
