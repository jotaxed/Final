package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;

public final class QuestBuffer extends g<Quest> {
    public QuestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object f(int i, int i2) {
        return n(i, i2);
    }

    protected String ha() {
        return "external_quest_id";
    }

    protected Quest n(int i, int i2) {
        return new QuestRef(this.JG, i, i2);
    }
}
