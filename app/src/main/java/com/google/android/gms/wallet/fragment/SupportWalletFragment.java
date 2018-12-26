package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.dynamic.h;
import com.google.android.gms.internal.qa;
import com.google.android.gms.internal.qi;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class SupportWalletFragment extends Fragment {
    private final Fragment Mx = this;
    private b awa;
    private final h awb = h.a(this);
    private final c awc = new c();
    private a awd = new a(this);
    private WalletFragmentOptions awe;
    private WalletFragmentInitParams awf;
    private MaskedWalletRequest awg;
    private MaskedWallet awh;
    private Boolean awi;
    private boolean mCreated = false;

    public interface OnStateChangedListener {
        void onStateChanged(SupportWalletFragment supportWalletFragment, int i, int i2, Bundle bundle);
    }

    static class a extends com.google.android.gms.internal.qb.a {
        private OnStateChangedListener awj;
        private final SupportWalletFragment awk;

        a(SupportWalletFragment supportWalletFragment) {
            this.awk = supportWalletFragment;
        }

        public void a(int i, int i2, Bundle bundle) {
            if (this.awj != null) {
                this.awj.onStateChanged(this.awk, i, i2, bundle);
            }
        }

        public void a(OnStateChangedListener onStateChangedListener) {
            this.awj = onStateChangedListener;
        }
    }

    private static class b implements LifecycleDelegate {
        private final qa awl;

        private b(qa qaVar) {
            this.awl = qaVar;
        }

        private int getState() {
            try {
                return this.awl.getState();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void initialize(WalletFragmentInitParams startParams) {
            try {
                this.awl.initialize(startParams);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void onActivityResult(int requestCode, int resultCode, Intent data) {
            try {
                this.awl.onActivityResult(requestCode, resultCode, data);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void setEnabled(boolean enabled) {
            try {
                this.awl.setEnabled(enabled);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void updateMaskedWallet(MaskedWallet maskedWallet) {
            try {
                this.awl.updateMaskedWallet(maskedWallet);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void updateMaskedWalletRequest(MaskedWalletRequest request) {
            try {
                this.awl.updateMaskedWalletRequest(request);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.awl.onCreate(savedInstanceState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) e.f(this.awl.onCreateView(e.k(inflater), e.k(container), savedInstanceState));
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onDestroy() {
        }

        public void onDestroyView() {
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.awl.a(e.k(activity), (WalletFragmentOptions) attrs.getParcelable("extraWalletFragmentOptions"), savedInstanceState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onLowMemory() {
        }

        public void onPause() {
            try {
                this.awl.onPause();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onResume() {
            try {
                this.awl.onResume();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.awl.onSaveInstanceState(outState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onStart() {
            try {
                this.awl.onStart();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onStop() {
            try {
                this.awl.onStop();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class c extends com.google.android.gms.dynamic.a<b> implements OnClickListener {
        final /* synthetic */ SupportWalletFragment awm;

        private c(SupportWalletFragment supportWalletFragment) {
            this.awm = supportWalletFragment;
        }

        protected void a(FrameLayout frameLayout) {
            View button = new Button(this.awm.Mx.getActivity());
            button.setText(R.string.wallet_buy_button_place_holder);
            int i = -1;
            int i2 = -2;
            if (this.awm.awe != null) {
                WalletFragmentStyle fragmentStyle = this.awm.awe.getFragmentStyle();
                if (fragmentStyle != null) {
                    DisplayMetrics displayMetrics = this.awm.Mx.getResources().getDisplayMetrics();
                    i = fragmentStyle.a("buyButtonWidth", displayMetrics, -1);
                    i2 = fragmentStyle.a("buyButtonHeight", displayMetrics, -2);
                }
            }
            button.setLayoutParams(new LayoutParams(i, i2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        protected void a(f<b> fVar) {
            Activity activity = this.awm.Mx.getActivity();
            if (this.awm.awa == null && this.awm.mCreated && activity != null) {
                try {
                    this.awm.awa = new b(qi.a(activity, this.awm.awb, this.awm.awe, this.awm.awd));
                    this.awm.awe = null;
                    fVar.a(this.awm.awa);
                    if (this.awm.awf != null) {
                        this.awm.awa.initialize(this.awm.awf);
                        this.awm.awf = null;
                    }
                    if (this.awm.awg != null) {
                        this.awm.awa.updateMaskedWalletRequest(this.awm.awg);
                        this.awm.awg = null;
                    }
                    if (this.awm.awh != null) {
                        this.awm.awa.updateMaskedWallet(this.awm.awh);
                        this.awm.awh = null;
                    }
                    if (this.awm.awi != null) {
                        this.awm.awa.setEnabled(this.awm.awi.booleanValue());
                        this.awm.awi = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }

        public void onClick(View view) {
            Context activity = this.awm.Mx.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }
    }

    public static SupportWalletFragment newInstance(WalletFragmentOptions options) {
        SupportWalletFragment supportWalletFragment = new SupportWalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", options);
        supportWalletFragment.Mx.setArguments(bundle);
        return supportWalletFragment;
    }

    public int getState() {
        return this.awa != null ? this.awa.getState() : 0;
    }

    public void initialize(WalletFragmentInitParams initParams) {
        if (this.awa != null) {
            this.awa.initialize(initParams);
            this.awf = null;
        } else if (this.awf == null) {
            this.awf = initParams;
            if (this.awg != null) {
                Log.w("SupportWalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.awh != null) {
                Log.w("SupportWalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        } else {
            Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.awa != null) {
            this.awa.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) savedInstanceState.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.awf != null) {
                    Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
                }
                this.awf = walletFragmentInitParams;
            }
            if (this.awg == null) {
                this.awg = (MaskedWalletRequest) savedInstanceState.getParcelable("maskedWalletRequest");
            }
            if (this.awh == null) {
                this.awh = (MaskedWallet) savedInstanceState.getParcelable("maskedWallet");
            }
            if (savedInstanceState.containsKey("walletFragmentOptions")) {
                this.awe = (WalletFragmentOptions) savedInstanceState.getParcelable("walletFragmentOptions");
            }
            if (savedInstanceState.containsKey("enabled")) {
                this.awi = Boolean.valueOf(savedInstanceState.getBoolean("enabled"));
            }
        } else if (this.Mx.getArguments() != null) {
            WalletFragmentOptions walletFragmentOptions = (WalletFragmentOptions) this.Mx.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletFragmentOptions != null) {
                walletFragmentOptions.ab(this.Mx.getActivity());
                this.awe = walletFragmentOptions;
            }
        }
        this.mCreated = true;
        this.awc.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.awc.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mCreated = false;
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        if (this.awe == null) {
            this.awe = WalletFragmentOptions.a((Context) activity, attrs);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("attrKeyWalletFragmentOptions", this.awe);
        this.awc.onInflate(activity, bundle, savedInstanceState);
    }

    public void onPause() {
        super.onPause();
        this.awc.onPause();
    }

    public void onResume() {
        super.onResume();
        this.awc.onResume();
        FragmentManager supportFragmentManager = this.Mx.getActivity().getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (findFragmentByTag != null) {
            supportFragmentManager.beginTransaction().remove(findFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.Mx.getActivity()), this.Mx.getActivity(), -1);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.awc.onSaveInstanceState(outState);
        if (this.awf != null) {
            outState.putParcelable("walletFragmentInitParams", this.awf);
            this.awf = null;
        }
        if (this.awg != null) {
            outState.putParcelable("maskedWalletRequest", this.awg);
            this.awg = null;
        }
        if (this.awh != null) {
            outState.putParcelable("maskedWallet", this.awh);
            this.awh = null;
        }
        if (this.awe != null) {
            outState.putParcelable("walletFragmentOptions", this.awe);
            this.awe = null;
        }
        if (this.awi != null) {
            outState.putBoolean("enabled", this.awi.booleanValue());
            this.awi = null;
        }
    }

    public void onStart() {
        super.onStart();
        this.awc.onStart();
    }

    public void onStop() {
        super.onStop();
        this.awc.onStop();
    }

    public void setEnabled(boolean enabled) {
        if (this.awa != null) {
            this.awa.setEnabled(enabled);
            this.awi = null;
            return;
        }
        this.awi = Boolean.valueOf(enabled);
    }

    public void setOnStateChangedListener(OnStateChangedListener listener) {
        this.awd.a(listener);
    }

    public void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.awa != null) {
            this.awa.updateMaskedWallet(maskedWallet);
            this.awh = null;
            return;
        }
        this.awh = maskedWallet;
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest request) {
        if (this.awa != null) {
            this.awa.updateMaskedWalletRequest(request);
            this.awg = null;
            return;
        }
        this.awg = request;
    }
}
