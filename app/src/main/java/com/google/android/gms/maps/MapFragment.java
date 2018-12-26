package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.w;
import com.google.android.gms.maps.internal.x;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class MapFragment extends Fragment {
    private final b akR = new b(this);
    private GoogleMap akS;

    static class a implements MapLifecycleDelegate {
        private final Fragment TG;
        private final IMapFragmentDelegate akT;

        public a(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.akT = (IMapFragmentDelegate) jx.i(iMapFragmentDelegate);
            this.TG = (Fragment) jx.i(fragment);
        }

        public void getMapAsync(final OnMapReadyCallback callback) {
            try {
                this.akT.getMapAsync(new com.google.android.gms.maps.internal.m.a(this) {
                    final /* synthetic */ a akV;

                    public void a(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException {
                        callback.onMapReady(new GoogleMap(iGoogleMapDelegate));
                    }
                });
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public IMapFragmentDelegate nN() {
            return this.akT;
        }

        public void onCreate(Bundle savedInstanceState) {
            if (savedInstanceState == null) {
                try {
                    savedInstanceState = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.TG.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                w.a(savedInstanceState, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.akT.onCreate(savedInstanceState);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) e.f(this.akT.onCreateView(e.k(inflater), e.k(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.akT.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.akT.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.akT.onInflate(e.k(activity), (GoogleMapOptions) attrs.getParcelable("MapOptions"), savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.akT.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.akT.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.akT.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.akT.onSaveInstanceState(outState);
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
        private final Fragment TG;
        protected f<a> akW;
        private final List<OnMapReadyCallback> akX = new ArrayList();
        private Activity nB;

        b(Fragment fragment) {
            this.TG = fragment;
        }

        private void setActivity(Activity activity) {
            this.nB = activity;
            nO();
        }

        protected void a(f<a> fVar) {
            this.akW = fVar;
            nO();
        }

        public void getMapAsync(OnMapReadyCallback callback) {
            if (je() != null) {
                ((a) je()).getMapAsync(callback);
            } else {
                this.akX.add(callback);
            }
        }

        public void nO() {
            if (this.nB != null && this.akW != null && je() == null) {
                try {
                    MapsInitializer.initialize(this.nB);
                    this.akW.a(new a(this.TG, x.S(this.nB).j(e.k(this.nB))));
                    for (OnMapReadyCallback mapAsync : this.akX) {
                        ((a) je()).getMapAsync(mapAsync);
                    }
                    this.akX.clear();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    public static MapFragment newInstance(GoogleMapOptions options) {
        MapFragment mapFragment = new MapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", options);
        mapFragment.setArguments(bundle);
        return mapFragment;
    }

    @Deprecated
    public final GoogleMap getMap() {
        IMapFragmentDelegate nN = nN();
        if (nN == null) {
            return null;
        }
        try {
            IGoogleMapDelegate map = nN.getMap();
            if (map == null) {
                return null;
            }
            if (this.akS == null || this.akS.nC().asBinder() != map.asBinder()) {
                this.akS = new GoogleMap(map);
            }
            return this.akS;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getMapAsync(OnMapReadyCallback callback) {
        jx.aU("getMapAsync must be called on the main thread.");
        this.akR.getMapAsync(callback);
    }

    protected IMapFragmentDelegate nN() {
        this.akR.nO();
        return this.akR.je() == null ? null : ((a) this.akR.je()).nN();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.akR.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.akR.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.akR.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.akR.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.akR.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.akR.setActivity(activity);
        Parcelable createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attrs);
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", createFromAttributes);
        this.akR.onInflate(activity, bundle, savedInstanceState);
    }

    public void onLowMemory() {
        this.akR.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.akR.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.akR.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.akR.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }
}
