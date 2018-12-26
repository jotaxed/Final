package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.model.internal.l;

public final class Marker {
    private final l amo;

    public Marker(l delegate) {
        this.amo = (l) jx.i(delegate);
    }

    public boolean equals(Object other) {
        if (!(other instanceof Marker)) {
            return false;
        }
        try {
            return this.amo.h(((Marker) other).amo);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getAlpha() {
        try {
            return this.amo.getAlpha();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getId() {
        try {
            return this.amo.getId();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public LatLng getPosition() {
        try {
            return this.amo.getPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getRotation() {
        try {
            return this.amo.getRotation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getSnippet() {
        try {
            return this.amo.getSnippet();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getTitle() {
        try {
            return this.amo.getTitle();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.amo.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void hideInfoWindow() {
        try {
            this.amo.hideInfoWindow();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isDraggable() {
        try {
            return this.amo.isDraggable();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isFlat() {
        try {
            return this.amo.isFlat();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isInfoWindowShown() {
        try {
            return this.amo.isInfoWindowShown();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isVisible() {
        try {
            return this.amo.isVisible();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void remove() {
        try {
            this.amo.remove();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setAlpha(float alpha) {
        try {
            this.amo.setAlpha(alpha);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setAnchor(float anchorU, float anchorV) {
        try {
            this.amo.setAnchor(anchorU, anchorV);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setDraggable(boolean draggable) {
        try {
            this.amo.setDraggable(draggable);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setFlat(boolean flat) {
        try {
            this.amo.setFlat(flat);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setIcon(BitmapDescriptor icon) {
        try {
            this.amo.n(icon.nA());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setInfoWindowAnchor(float anchorU, float anchorV) {
        try {
            this.amo.setInfoWindowAnchor(anchorU, anchorV);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(LatLng latlng) {
        try {
            this.amo.setPosition(latlng);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setRotation(float rotation) {
        try {
            this.amo.setRotation(rotation);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setSnippet(String snippet) {
        try {
            this.amo.setSnippet(snippet);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setTitle(String title) {
        try {
            this.amo.setTitle(title);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setVisible(boolean visible) {
        try {
            this.amo.setVisible(visible);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void showInfoWindow() {
        try {
            this.amo.showInfoWindow();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
