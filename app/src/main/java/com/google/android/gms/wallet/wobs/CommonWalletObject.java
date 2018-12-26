package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.la;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class CommonWalletObject implements SafeParcelable {
    public static final Creator<CommonWalletObject> CREATOR = new a();
    private final int CK;
    String ave;
    String avg;
    String avh;
    String avi;
    String avj;
    String avk;
    ArrayList<p> avl;
    l avm;
    ArrayList<LatLng> avn;
    String avo;
    String avp;
    ArrayList<d> avq;
    boolean avr;
    ArrayList<n> avs;
    ArrayList<j> avt;
    ArrayList<n> avu;
    String fl;
    String name;
    int state;

    public final class a {
        final /* synthetic */ CommonWalletObject awI;

        private a(CommonWalletObject commonWalletObject) {
            this.awI = commonWalletObject;
        }

        public a dh(String str) {
            this.awI.fl = str;
            return this;
        }

        public CommonWalletObject ri() {
            return this.awI;
        }
    }

    CommonWalletObject() {
        this.CK = 1;
        this.avl = la.ie();
        this.avn = la.ie();
        this.avq = la.ie();
        this.avs = la.ie();
        this.avt = la.ie();
        this.avu = la.ie();
    }

    CommonWalletObject(int versionCode, String id, String classId, String name, String issuerName, String barcodeAlternateText, String barcodeType, String barcodeValue, String barcodeLabel, int state, ArrayList<p> messages, l validTimeInterval, ArrayList<LatLng> locations, String infoModuleDataHexFontColor, String infoModuleDataHexBackgroundColor, ArrayList<d> infoModuleDataLabelValueRows, boolean infoModuleDataShowLastUpdateTime, ArrayList<n> imageModuleDataMainImageUris, ArrayList<j> textModulesData, ArrayList<n> linksModuleDataUris) {
        this.CK = versionCode;
        this.fl = id;
        this.avk = classId;
        this.name = name;
        this.ave = issuerName;
        this.avg = barcodeAlternateText;
        this.avh = barcodeType;
        this.avi = barcodeValue;
        this.avj = barcodeLabel;
        this.state = state;
        this.avl = messages;
        this.avm = validTimeInterval;
        this.avn = locations;
        this.avo = infoModuleDataHexFontColor;
        this.avp = infoModuleDataHexBackgroundColor;
        this.avq = infoModuleDataLabelValueRows;
        this.avr = infoModuleDataShowLastUpdateTime;
        this.avs = imageModuleDataMainImageUris;
        this.avt = textModulesData;
        this.avu = linksModuleDataUris;
    }

    public static a rh() {
        CommonWalletObject commonWalletObject = new CommonWalletObject();
        commonWalletObject.getClass();
        return new a();
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.fl;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel dest, int flags) {
        a.a(this, dest, flags);
    }
}
