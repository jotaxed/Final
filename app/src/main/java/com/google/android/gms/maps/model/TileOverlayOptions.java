package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.aa;
import com.google.android.gms.maps.model.internal.o;
import com.google.android.gms.maps.model.internal.o.a;

public final class TileOverlayOptions implements SafeParcelable {
    public static final w CREATOR = new w();
    private final int CK;
    private float alX;
    private boolean alY;
    private o amD;
    private TileProvider amE;
    private boolean amF;

    public TileOverlayOptions() {
        this.alY = true;
        this.amF = true;
        this.CK = 1;
    }

    TileOverlayOptions(int versionCode, IBinder delegate, boolean visible, float zIndex, boolean fadeIn) {
        this.alY = true;
        this.amF = true;
        this.CK = versionCode;
        this.amD = a.bE(delegate);
        this.amE = this.amD == null ? null : new TileProvider(this) {
            private final o amG = this.amH.amD;
            final /* synthetic */ TileOverlayOptions amH;

            {
                this.amH = r2;
            }

            public Tile getTile(int x, int y, int zoom) {
                try {
                    return this.amG.getTile(x, y, zoom);
                } catch (RemoteException e) {
                    return null;
                }
            }
        };
        this.alY = visible;
        this.alX = zIndex;
        this.amF = fadeIn;
    }

    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions fadeIn(boolean fadeIn) {
        this.amF = fadeIn;
        return this;
    }

    public boolean getFadeIn() {
        return this.amF;
    }

    public TileProvider getTileProvider() {
        return this.amE;
    }

    int getVersionCode() {
        return this.CK;
    }

    public float getZIndex() {
        return this.alX;
    }

    public boolean isVisible() {
        return this.alY;
    }

    IBinder og() {
        return this.amD.asBinder();
    }

    public TileOverlayOptions tileProvider(final TileProvider tileProvider) {
        this.amE = tileProvider;
        this.amD = this.amE == null ? null : new a(this) {
            final /* synthetic */ TileOverlayOptions amH;

            public Tile getTile(int x, int y, int zoom) {
                return tileProvider.getTile(x, y, zoom);
            }
        };
        return this;
    }

    public TileOverlayOptions visible(boolean visible) {
        this.alY = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (aa.ob()) {
            x.a(this, out, flags);
        } else {
            w.a(this, out, flags);
        }
    }

    public TileOverlayOptions zIndex(float zIndex) {
        this.alX = zIndex;
        return this;
    }
}
