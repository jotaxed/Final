package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;

public final class InvitationBuffer extends g<Invitation> {
    public InvitationBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object f(int i, int i2) {
        return k(i, i2);
    }

    protected String ha() {
        return "external_invitation_id";
    }

    protected Invitation k(int i, int i2) {
        return new InvitationRef(this.JG, i, i2);
    }
}
