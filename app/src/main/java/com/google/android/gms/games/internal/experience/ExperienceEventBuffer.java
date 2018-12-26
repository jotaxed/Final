package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class ExperienceEventBuffer extends DataBuffer<ExperienceEvent> {
    public ExperienceEventBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public ExperienceEvent ea(int i) {
        return new ExperienceEventRef(this.JG, i);
    }

    public /* synthetic */ Object get(int x0) {
        return ea(x0);
    }
}
