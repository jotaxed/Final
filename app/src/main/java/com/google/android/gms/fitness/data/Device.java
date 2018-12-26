package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.mg;

public final class Device implements SafeParcelable {
    public static final Creator<Device> CREATOR = new i();
    public static final int TYPE_CHEST_STRAP = 4;
    public static final int TYPE_PHONE = 1;
    public static final int TYPE_SCALE = 5;
    public static final int TYPE_TABLET = 2;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WATCH = 3;
    private final int CK;
    private final int Gt;
    private final String TU;
    private final String Uw;
    private final String Ux;
    private final String Uy;
    private final int Uz;

    Device(int versionCode, String manufacturer, String model, String version, String uid, int type, int platformType) {
        this.CK = versionCode;
        this.Uw = (String) jx.i(manufacturer);
        this.Ux = (String) jx.i(model);
        this.TU = "";
        this.Uy = (String) jx.i(uid);
        this.Gt = type;
        this.Uz = platformType;
    }

    public Device(String manufacturer, String model, String uid, int type) {
        this(manufacturer, model, "", uid, type, 0);
    }

    public Device(String manufacturer, String model, String version, String uid, int type) {
        this(manufacturer, model, uid, type);
    }

    public Device(String manufacturer, String model, String version, String uid, int type, int platformType) {
        this(1, manufacturer, model, "", uid, type, platformType);
    }

    private static String M(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    private static int N(Context context) {
        switch (P(context)) {
            case 8:
            case 9:
                return 0;
            case 10:
                return O(context) ? 3 : 0;
            default:
                return R(context) ? 1 : 2;
        }
    }

    public static boolean O(Context context) {
        return (context.getResources().getConfiguration().uiMode & 15) == 6;
    }

    private static int P(Context context) {
        return ((Q(context) % 1000) / 100) + 5;
    }

    private static int Q(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("Fitness", "Could not find package info for Google Play Services");
            return -1;
        }
    }

    private static boolean R(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getPhoneType() != 0;
    }

    private boolean a(Device device) {
        return jv.equal(this.Uw, device.Uw) && jv.equal(this.Ux, device.Ux) && jv.equal(this.TU, device.TU) && jv.equal(this.Uy, device.Uy) && this.Gt == device.Gt && this.Uz == device.Uz;
    }

    public static Device getLocalDevice(Context context) {
        int N = N(context);
        return new Device(Build.MANUFACTURER, Build.MODEL, VERSION.RELEASE, M(context), N, 2);
    }

    private boolean jD() {
        return jC() == 1;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof Device) && a((Device) that));
    }

    public String getManufacturer() {
        return this.Uw;
    }

    public String getModel() {
        return this.Ux;
    }

    String getStreamIdentifier() {
        return String.format("%s:%s:%s", new Object[]{this.Uw, this.Ux, this.Uy});
    }

    public int getType() {
        return this.Gt;
    }

    public String getUid() {
        return this.Uy;
    }

    public String getVersion() {
        return this.TU;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.Uw, this.Ux, this.TU, this.Uy, Integer.valueOf(this.Gt));
    }

    public int jC() {
        return this.Uz;
    }

    Device jE() {
        return new Device(mg.bw(this.Uw), mg.bw(this.Ux), mg.bw(this.TU), this.Uy, this.Gt);
    }

    public String jF() {
        return (mg.jN() || jD()) ? this.Uy : mg.bw(this.Uy);
    }

    public String toString() {
        return String.format("Device{%s:%s:%s:%s}", new Object[]{getStreamIdentifier(), this.TU, Integer.valueOf(this.Gt), Integer.valueOf(this.Uz)});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        i.a(this, parcel, flags);
    }
}
