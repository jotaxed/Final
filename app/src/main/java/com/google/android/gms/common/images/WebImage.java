package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.plus.PlusShare;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage implements SafeParcelable {
    public static final Creator<WebImage> CREATOR = new b();
    private final int CK;
    private final Uri LU;
    private final int li;
    private final int lj;

    WebImage(int versionCode, Uri url, int width, int height) {
        this.CK = versionCode;
        this.LU = url;
        this.li = width;
        this.lj = height;
    }

    public WebImage(Uri url) throws IllegalArgumentException {
        this(url, 0, 0);
    }

    public WebImage(Uri url, int width, int height) throws IllegalArgumentException {
        this(1, url, width, height);
        if (url == null) {
            throw new IllegalArgumentException("url cannot be null");
        } else if (width < 0 || height < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    public WebImage(JSONObject json) throws IllegalArgumentException {
        this(d(json), json.optInt("width", 0), json.optInt("height", 0));
    }

    private static Uri d(JSONObject jSONObject) {
        Uri uri = null;
        if (jSONObject.has(PlusShare.KEY_CALL_TO_ACTION_URL)) {
            try {
                uri = Uri.parse(jSONObject.getString(PlusShare.KEY_CALL_TO_ACTION_URL));
            } catch (JSONException e) {
            }
        }
        return uri;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) other;
        return jv.equal(this.LU, webImage.LU) && this.li == webImage.li && this.lj == webImage.lj;
    }

    public int getHeight() {
        return this.lj;
    }

    public Uri getUrl() {
        return this.LU;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int getWidth() {
        return this.li;
    }

    public int hashCode() {
        return jv.hashCode(this.LU, Integer.valueOf(this.li), Integer.valueOf(this.lj));
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PlusShare.KEY_CALL_TO_ACTION_URL, this.LU.toString());
            jSONObject.put("width", this.li);
            jSONObject.put("height", this.lj);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public String toString() {
        return String.format("Image %dx%d %s", new Object[]{Integer.valueOf(this.li), Integer.valueOf(this.lj), this.LU.toString()});
    }

    public void writeToParcel(Parcel out, int flags) {
        b.a(this, out, flags);
    }
}
