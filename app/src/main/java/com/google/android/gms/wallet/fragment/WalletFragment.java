package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.google.android.gms.internal.qa;
import com.google.android.gms.internal.qi;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragment extends Fragment {
    private final Fragment TG = this;
    private WalletFragmentOptions awe;
    private WalletFragmentInitParams awf;
    private MaskedWalletRequest awg;
    private MaskedWallet awh;
    private Boolean awi;
    private b awn;
    private final com.google.android.gms.dynamic.b awo = com.google.android.gms.dynamic.b.a(this);
    private final c awp = new c();
    private a awq = new a(this);
    private boolean mCreated = false;

    public interface OnStateChangedListener {
        void onStateChanged(WalletFragment walletFragment, int i, int i2, Bundle bundle);
    }

    static class a extends com.google.android.gms.internal.qb.a {
        private OnStateChangedListener awr;
        private final WalletFragment aws;

        a(WalletFragment walletFragment) {
            this.aws = walletFragment;
        }

        public void a(int i, int i2, Bundle bundle) {
            if (this.awr != null) {
                this.awr.onStateChanged(this.aws, i, i2, bundle);
            }
        }

        public void a(OnStateChangedListener onStateChangedListener) {
            this.awr = onStateChangedListener;
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
        final /* synthetic */ WalletFragment awt;

        private c(WalletFragment walletFragment) {
            this.awt = walletFragment;
        }

        protected void a(FrameLayout frameLayout) {
            View button = new Button(this.awt.TG.getActivity());
            button.setText(R.string.wallet_buy_button_place_holder);
            int i = -1;
            int i2 = -2;
            if (this.awt.awe != null) {
                WalletFragmentStyle fragmentStyle = this.awt.awe.getFragmentStyle();
                if (fragmentStyle != null) {
                    DisplayMetrics displayMetrics = this.awt.TG.getResources().getDisplayMetrics();
                    i = fragmentStyle.a("buyButtonWidth", displayMetrics, -1);
                    i2 = fragmentStyle.a("buyButtonHeight", displayMetrics, -2);
                }
            }
            button.setLayoutParams(new LayoutParams(i, i2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        protected void a(f<b> fVar) {
            Activity activity = this.awt.TG.getActivity();
            if (this.awt.awn == null && this.awt.mCreated && activity != null) {
                try {
                    this.awt.awn = new b(qi.a(activity, this.awt.awo, this.awt.awe, this.awt.awq));
                    this.awt.awe = null;
                    fVar.a(this.awt.awn);
                    if (this.awt.awf != null) {
                        this.awt.awn.initialize(this.awt.awf);
                        this.awt.awf = null;
                    }
                    if (this.awt.awg != null) {
                        this.awt.awn.updateMaskedWalletRequest(this.awt.awg);
                        this.awt.awg = null;
                    }
                    if (this.awt.awh != null) {
                        this.awt.awn.updateMaskedWallet(this.awt.awh);
                        this.awt.awh = null;
                    }
                    if (this.awt.awi != null) {
                        this.awt.awn.setEnabled(this.awt.awi.booleanValue());
                        this.awt.awi = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }

        public void onClick(View view) {
            Context activity = this.awt.TG.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }
    }

    public static WalletFragment newInstance(WalletFragmentOptions options) {
        WalletFragment walletFragment = new WalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", options);
        walletFragment.TG.setArguments(bundle);
        return walletFragment;
    }

    public int getState() {
        return this.awn != null ? this.awn.getState() : 0;
    }

    public void initialize(WalletFragmentInitParams initParams) {
        if (this.awn != null) {
            this.awn.initialize(initParams);
            this.awf = null;
        } else if (this.awf == null) {
            this.awf = initParams;
            if (this.awg != null) {
                Log.w("WalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.awh != null) {
                Log.w("WalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        } else {
            Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.awn != null) {
            this.awn.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) savedInstanceState.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.awf != null) {
                    Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
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
        } else if (this.TG.getArguments() != null) {
            WalletFragmentOptions walletFragmentOptions = (WalletFragmentOptions) this.TG.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletFragmentOptions != null) {
                walletFragmentOptions.ab(this.TG.getActivity());
                this.awe = walletFragmentOptions;
            }
        }
        this.mCreated = true;
        this.awp.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.awp.onCreateView(inflater, container, savedInstanceState);
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
        this.awp.onInflate(activity, bundle, savedInstanceState);
    }

    public void onPause() {
        super.onPause();
        this.awp.onPause();
    }

    public void onResume() {
        super.onResume();
        this.awp.onResume();
        FragmentManager fragmentManager = this.TG.getActivity().getFragmentManager();
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (findFragmentByTag != null) {
            fragmentManager.beginTransaction().remove(findFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.TG.getActivity()), this.TG.getActivity(), -1);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.awp.onSaveInstanceState(outState);
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
        this.awp.onStart();
    }

    public void onStop() {
        super.onStop();
        this.awp.onStop();
    }

    public void setEnabled(boolean enabled) {
        if (this.awn != null) {
            this.awn.setEnabled(enabled);
            this.awi = null;
            return;
        }
        this.awi = Boolean.valueOf(enabled);
    }

    public void setOnStateChangedListener(OnStateChangedListener listener) {
        this.awq.a(listener);
    }

    public void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.awn != null) {
            this.awn.updateMaskedWallet(maskedWallet);
            this.awh = null;
            return;
        }
        this.awh = maskedWallet;
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest request) {
        if (this.awn != null) {
            this.awn.updateMaskedWalletRequest(request);
            this.awg = null;
            return;
        }
        this.awg = request;
    }
}
