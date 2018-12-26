package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentOptions implements SafeParcelable {
    public static final Creator<WalletFragmentOptions> CREATOR = new b();
    final int CK;
    private int Oi;
    private int avV;
    private WalletFragmentStyle aww;
    private int mTheme;

    public final class Builder {
        final /* synthetic */ WalletFragmentOptions awx;

        private Builder(WalletFragmentOptions walletFragmentOptions) {
            this.awx = walletFragmentOptions;
        }

        public WalletFragmentOptions build() {
            return this.awx;
        }

        public Builder setEnvironment(int environment) {
            this.awx.avV = environment;
            return this;
        }

        public Builder setFragmentStyle(int styleResourceId) {
            this.awx.aww = new WalletFragmentStyle().setStyleResourceId(styleResourceId);
            return this;
        }

        public Builder setFragmentStyle(WalletFragmentStyle fragmentStyle) {
            this.awx.aww = fragmentStyle;
            return this;
        }

        public Builder setMode(int mode) {
            this.awx.Oi = mode;
            return this;
        }

        public Builder setTheme(int theme) {
            this.awx.mTheme = theme;
            return this;
        }
    }

    private WalletFragmentOptions() {
        this.CK = 1;
    }

    WalletFragmentOptions(int versionCode, int environment, int theme, WalletFragmentStyle fragmentStyle, int mode) {
        this.CK = versionCode;
        this.avV = environment;
        this.mTheme = theme;
        this.aww = fragmentStyle;
        this.Oi = mode;
    }

    public static WalletFragmentOptions a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WalletFragmentOptions);
        int i = obtainStyledAttributes.getInt(R.styleable.WalletFragmentOptions_appTheme, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.WalletFragmentOptions_environment, 1);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.WalletFragmentOptions_fragmentStyle, 0);
        int i3 = obtainStyledAttributes.getInt(R.styleable.WalletFragmentOptions_fragmentMode, 1);
        obtainStyledAttributes.recycle();
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.mTheme = i;
        walletFragmentOptions.avV = i2;
        walletFragmentOptions.aww = new WalletFragmentStyle().setStyleResourceId(resourceId);
        walletFragmentOptions.aww.ab(context);
        walletFragmentOptions.Oi = i3;
        return walletFragmentOptions;
    }

    public static Builder newBuilder() {
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.getClass();
        return new Builder();
    }

    public void ab(Context context) {
        if (this.aww != null) {
            this.aww.ab(context);
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getEnvironment() {
        return this.avV;
    }

    public WalletFragmentStyle getFragmentStyle() {
        return this.aww;
    }

    public int getMode() {
        return this.Oi;
    }

    public int getTheme() {
        return this.mTheme;
    }

    public void writeToParcel(Parcel dest, int flags) {
        b.a(this, dest, flags);
    }
}
