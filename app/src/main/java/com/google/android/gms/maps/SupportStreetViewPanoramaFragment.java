package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.w;
import com.google.android.gms.maps.internal.x;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class SupportStreetViewPanoramaFragment extends Fragment {
    private final b alF = new b(this);
    private StreetViewPanorama alm;

    static class a implements StreetViewLifecycleDelegate {
        private final Fragment Mx;
        private final IStreetViewPanoramaFragmentDelegate aln;

        public a(Fragment fragment, IStreetViewPanoramaFragmentDelegate iStreetViewPanoramaFragmentDelegate) {
            this.aln = (IStreetViewPanoramaFragmentDelegate) jx.i(iStreetViewPanoramaFragmentDelegate);
            this.Mx = (Fragment) jx.i(fragment);
        }

        public void getStreetViewPanoramaAsync(final OnStreetViewPanoramaReadyCallback callback) {
            try {
                this.aln.getStreetViewPanoramaAsync(new com.google.android.gms.maps.internal.u.a(this) {
                    final /* synthetic */ a alG;

                    public void a(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) throws RemoteException {
                        callback.onStreetViewPanoramaReady(new StreetViewPanorama(iStreetViewPanoramaDelegate));
                    }
                });
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public IStreetViewPanoramaFragmentDelegate nR() {
            return this.aln;
        }

        public void onCreate(Bundle savedInstanceState) {
            if (savedInstanceState == null) {
                try {
                    savedInstanceState = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.Mx.getArguments();
            if (arguments != null && arguments.containsKey("StreetViewPanoramaOptions")) {
                w.a(savedInstanceState, "StreetViewPanoramaOptions", arguments.getParcelable("StreetViewPanoramaOptions"));
            }
            this.aln.onCreate(savedInstanceState);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) e.f(this.aln.onCreateView(e.k(inflater), e.k(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.aln.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.aln.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.aln.onInflate(e.k(activity), null, savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.aln.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.aln.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.aln.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.aln.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    static class b extends com.google.android.gms.dynamic.a<a> {
        private final Fragment Mx;
        protected f<a> akW;
        private final List<OnStreetViewPanoramaReadyCallback> alq = new ArrayList();
        private Activity nB;

        b(Fragment fragment) {
            this.Mx = fragment;
        }

        private void setActivity(Activity activity) {
            this.nB = activity;
            nO();
        }

        protected void a(f<a> fVar) {
            this.akW = fVar;
            nO();
        }

        public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback callback) {
            if (je() != null) {
                ((a) je()).getStreetViewPanoramaAsync(callback);
            } else {
                this.alq.add(callback);
            }
        }

        public void nO() {
            if (this.nB != null && this.akW != null && je() == null) {
                try {
                    MapsInitializer.initialize(this.nB);
                    this.akW.a(new a(this.Mx, x.S(this.nB).k(e.k(this.nB))));
                    for (OnStreetViewPanoramaReadyCallback streetViewPanoramaAsync : this.alq) {
                        ((a) je()).getStreetViewPanoramaAsync(streetViewPanoramaAsync);
                    }
                    this.alq.clear();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public static SupportStreetViewPanoramaFragment newInstance() {
        return new SupportStreetViewPanoramaFragment();
    }

    public static SupportStreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions options) {
        SupportStreetViewPanoramaFragment supportStreetViewPanoramaFragment = new SupportStreetViewPanoramaFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("StreetViewPanoramaOptions", options);
        supportStreetViewPanoramaFragment.setArguments(bundle);
        return supportStreetViewPanoramaFragment;
    }

    @Deprecated
    public final StreetViewPanorama getStreetViewPanorama() {
        IStreetViewPanoramaFragmentDelegate nR = nR();
        if (nR == null) {
            return null;
        }
        try {
            IStreetViewPanoramaDelegate streetViewPanorama = nR.getStreetViewPanorama();
            if (streetViewPanorama == null) {
                return null;
            }
            if (this.alm == null || this.alm.nQ().asBinder() != streetViewPanorama.asBinder()) {
                this.alm = new StreetViewPanorama(streetViewPanorama);
            }
            return this.alm;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback callback) {
        jx.aU("getStreetViewPanoramaAsync() must be called on the main thread");
        this.alF.getStreetViewPanoramaAsync(callback);
    }

    protected IStreetViewPanoramaFragmentDelegate nR() {
        this.alF.nO();
        return this.alF.je() == null ? null : ((a) this.alF.je()).nR();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.alF.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.alF.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.alF.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.alF.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.alF.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.alF.setActivity(activity);
        this.alF.onInflate(activity, new Bundle(), savedInstanceState);
    }

    public void onLowMemory() {
        this.alF.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.alF.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.alF.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.alF.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }
}
