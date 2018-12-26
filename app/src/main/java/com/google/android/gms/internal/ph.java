package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

public final class ph extends d implements Moment {
    private pf apk;

    public ph(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    private pf oK() {
        synchronized (this) {
            if (this.apk == null) {
                byte[] byteArray = getByteArray("momentImpl");
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(byteArray, 0, byteArray.length);
                obtain.setDataPosition(0);
                this.apk = pf.CREATOR.dy(obtain);
                obtain.recycle();
            }
        }
        return this.apk;
    }

    public /* synthetic */ Object freeze() {
        return oJ();
    }

    public String getId() {
        return oK().getId();
    }

    public ItemScope getResult() {
        return oK().getResult();
    }

    public String getStartDate() {
        return oK().getStartDate();
    }

    public ItemScope getTarget() {
        return oK().getTarget();
    }

    public String getType() {
        return oK().getType();
    }

    public boolean hasId() {
        return oK().hasId();
    }

    public boolean hasResult() {
        return oK().hasResult();
    }

    public boolean hasStartDate() {
        return oK().hasStartDate();
    }

    public boolean hasTarget() {
        return oK().hasTarget();
    }

    public boolean hasType() {
        return oK().hasType();
    }

    public pf oJ() {
        return oK();
    }
}
