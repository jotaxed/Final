package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.model.internal.j;
import com.google.android.gms.maps.model.internal.k.a;
import java.util.ArrayList;
import java.util.List;

public final class IndoorBuilding {
    private final j ami;

    public IndoorBuilding(j delegate) {
        this.ami = (j) jx.i(delegate);
    }

    public boolean equals(Object other) {
        if (!(other instanceof IndoorBuilding)) {
            return false;
        }
        try {
            return this.ami.b(((IndoorBuilding) other).ami);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getActiveLevelIndex() {
        try {
            return this.ami.getActiveLevelIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getDefaultLevelIndex() {
        try {
            return this.ami.getActiveLevelIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public List<IndoorLevel> getLevels() {
        try {
            List<IBinder> levels = this.ami.getLevels();
            List<IndoorLevel> arrayList = new ArrayList(levels.size());
            for (IBinder bz : levels) {
                arrayList.add(new IndoorLevel(a.bz(bz)));
            }
            return arrayList;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.ami.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isUnderground() {
        try {
            return this.ami.isUnderground();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
