package com.google.android.gms.internal;

import android.content.Context;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ey
public final class ay implements SafeParcelable {
    public static final az CREATOR = new az();
    public final int height;
    public final int heightPixels;
    public final String op;
    public final boolean oq;
    public final ay[] or;
    public final int versionCode;
    public final int width;
    public final int widthPixels;

    public ay() {
        this(2, "interstitial_mb", 0, 0, true, 0, 0, null);
    }

    ay(int i, String str, int i2, int i3, boolean z, int i4, int i5, ay[] ayVarArr) {
        this.versionCode = i;
        this.op = str;
        this.height = i2;
        this.heightPixels = i3;
        this.oq = z;
        this.width = i4;
        this.widthPixels = i5;
        this.or = ayVarArr;
    }

    public ay(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    public ay(Context context, AdSize[] adSizeArr) {
        int i;
        int i2;
        int i3 = 0;
        AdSize adSize = adSizeArr[0];
        this.versionCode = 2;
        this.oq = false;
        this.width = adSize.getWidth();
        this.height = adSize.getHeight();
        int i4 = this.width == -1 ? 1 : 0;
        int i5 = this.height == -2 ? 1 : 0;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (i4 != 0) {
            this.widthPixels = a(displayMetrics);
            i = (int) (((float) this.widthPixels) / displayMetrics.density);
        } else {
            i2 = this.width;
            this.widthPixels = gq.a(displayMetrics, this.width);
            i = i2;
        }
        i2 = i5 != 0 ? c(displayMetrics) : this.height;
        this.heightPixels = gq.a(displayMetrics, i2);
        if (i4 == 0 && i5 == 0) {
            this.op = adSize.toString();
        } else {
            this.op = i + "x" + i2 + "_as";
        }
        if (adSizeArr.length > 1) {
            this.or = new ay[adSizeArr.length];
            while (i3 < adSizeArr.length) {
                this.or[i3] = new ay(context, adSizeArr[i3]);
                i3++;
            }
            return;
        }
        this.or = null;
    }

    public ay(ay ayVar, ay[] ayVarArr) {
        this(2, ayVar.op, ayVar.height, ayVar.heightPixels, ayVar.oq, ayVar.width, ayVar.widthPixels, ayVarArr);
    }

    public static int a(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int b(DisplayMetrics displayMetrics) {
        return (int) (((float) c(displayMetrics)) * displayMetrics.density);
    }

    private static int c(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        return i <= 400 ? 32 : i <= 720 ? 50 : 90;
    }

    public AdSize bh() {
        return a.a(this.width, this.height, this.op);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        az.a(this, out, flags);
    }
}
