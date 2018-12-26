package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.in;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CastDevice implements SafeParcelable {
    public static final Creator<CastDevice> CREATOR = new b();
    private final int CK;
    private String FG;
    String FH;
    private Inet4Address FI;
    private String FJ;
    private String FK;
    private String FL;
    private int FM;
    private List<WebImage> FN;
    private int FO;
    private int FP;

    private CastDevice() {
        this(3, null, null, null, null, null, -1, new ArrayList(), 0, -1);
    }

    CastDevice(int versionCode, String deviceId, String hostAddress, String friendlyName, String modelName, String deviceVersion, int servicePort, List<WebImage> icons, int capabilities, int status) {
        this.CK = versionCode;
        this.FG = deviceId;
        this.FH = hostAddress;
        if (this.FH != null) {
            try {
                InetAddress byName = InetAddress.getByName(this.FH);
                if (byName instanceof Inet4Address) {
                    this.FI = (Inet4Address) byName;
                }
            } catch (UnknownHostException e) {
                this.FI = null;
            }
        }
        this.FJ = friendlyName;
        this.FK = modelName;
        this.FL = deviceVersion;
        this.FM = servicePort;
        this.FN = icons;
        this.FO = capabilities;
        this.FP = status;
    }

    public static CastDevice getFromBundle(Bundle extras) {
        if (extras == null) {
            return null;
        }
        extras.setClassLoader(CastDevice.class.getClassLoader());
        return (CastDevice) extras.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CastDevice)) {
            return false;
        }
        CastDevice castDevice = (CastDevice) obj;
        return getDeviceId() == null ? castDevice.getDeviceId() == null : in.a(this.FG, castDevice.FG) && in.a(this.FI, castDevice.FI) && in.a(this.FK, castDevice.FK) && in.a(this.FJ, castDevice.FJ) && in.a(this.FL, castDevice.FL) && this.FM == castDevice.FM && in.a(this.FN, castDevice.FN) && this.FO == castDevice.FO && this.FP == castDevice.FP;
    }

    public int getCapabilities() {
        return this.FO;
    }

    public String getDeviceId() {
        return this.FG;
    }

    public String getDeviceVersion() {
        return this.FL;
    }

    public String getFriendlyName() {
        return this.FJ;
    }

    public WebImage getIcon(int preferredWidth, int preferredHeight) {
        WebImage webImage = null;
        if (this.FN.isEmpty()) {
            return null;
        }
        if (preferredWidth <= 0 || preferredHeight <= 0) {
            return (WebImage) this.FN.get(0);
        }
        WebImage webImage2 = null;
        for (WebImage webImage3 : this.FN) {
            WebImage webImage32;
            int width = webImage32.getWidth();
            int height = webImage32.getHeight();
            if (width < preferredWidth || height < preferredHeight) {
                if (width < preferredWidth && height < preferredHeight && (webImage == null || (webImage.getWidth() < width && webImage.getHeight() < height))) {
                    webImage = webImage2;
                }
                webImage32 = webImage;
                webImage = webImage2;
            } else {
                if (webImage2 == null || (webImage2.getWidth() > width && webImage2.getHeight() > height)) {
                    WebImage webImage4 = webImage;
                    webImage = webImage32;
                    webImage32 = webImage4;
                }
                webImage32 = webImage;
                webImage = webImage2;
            }
            webImage2 = webImage;
            webImage = webImage32;
        }
        if (webImage2 == null) {
            webImage2 = webImage != null ? webImage : (WebImage) this.FN.get(0);
        }
        return webImage2;
    }

    public List<WebImage> getIcons() {
        return Collections.unmodifiableList(this.FN);
    }

    public Inet4Address getIpAddress() {
        return this.FI;
    }

    public String getModelName() {
        return this.FK;
    }

    public int getServicePort() {
        return this.FM;
    }

    public int getStatus() {
        return this.FP;
    }

    int getVersionCode() {
        return this.CK;
    }

    public boolean hasIcons() {
        return !this.FN.isEmpty();
    }

    public int hashCode() {
        return this.FG == null ? 0 : this.FG.hashCode();
    }

    public boolean isOnLocalNetwork() {
        return !this.FG.startsWith("__cast_nearby__");
    }

    public boolean isSameDevice(CastDevice castDevice) {
        return castDevice == null ? false : getDeviceId() == null ? castDevice.getDeviceId() == null : in.a(getDeviceId(), castDevice.getDeviceId());
    }

    public void putInBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
        }
    }

    public String toString() {
        return String.format("\"%s\" (%s)", new Object[]{this.FJ, this.FG});
    }

    public void writeToParcel(Parcel out, int flags) {
        b.a(this, out, flags);
    }
}
