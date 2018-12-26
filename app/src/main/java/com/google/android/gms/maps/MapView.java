package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.x;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class MapView extends FrameLayout {
    private GoogleMap akS;
    private final b akY;

    static class a implements MapLifecycleDelegate {
        private final ViewGroup akZ;
        private final IMapViewDelegate ala;
        private View alb;

        public a(ViewGroup viewGroup, IMapViewDelegate iMapViewDelegate) {
            this.ala = (IMapViewDelegate) jx.i(iMapViewDelegate);
            this.akZ = (ViewGroup) jx.i(viewGroup);
        }

        public void getMapAsync(final OnMapReadyCallback callback) {
            try {
                this.ala.getMapAsync(new com.google.android.gms.maps.internal.m.a(this) {
                    final /* synthetic */ a alc;

                    public void a(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException {
                        callback.onMapReady(new GoogleMap(iGoogleMapDelegate));
                    }
                });
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public IMapViewDelegate nP() {
            return this.ala;
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.ala.onCreate(savedInstanceState);
                this.alb = (View) e.f(this.ala.getView());
                this.akZ.removeAllViews();
                this.akZ.addView(this.alb);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        public void onDestroy() {
            try {
                this.ala.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        public void onLowMemory() {
            try {
                this.ala.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.ala.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.ala.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.ala.onSaveInstanceState(outState);
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
        protected f<a> akW;
        private final List<OnMapReadyCallback> akX = new ArrayList();
        private final ViewGroup ald;
        private final GoogleMapOptions ale;
        private final Context mContext;

        b(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.ald = viewGroup;
            this.mContext = context;
            this.ale = googleMapOptions;
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
            if (this.akW != null && je() == null) {
                try {
                    this.akW.a(new a(this.ald, x.S(this.mContext).a(e.k(this.mContext), this.ale)));
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

    public MapView(Context context) {
        super(context);
        this.akY = new b(this, context, null);
    }

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.akY = new b(this, context, GoogleMapOptions.createFromAttributes(context, attrs));
    }

    public MapView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.akY = new b(this, context, GoogleMapOptions.createFromAttributes(context, attrs));
    }

    public MapView(Context context, GoogleMapOptions options) {
        super(context);
        this.akY = new b(this, context, options);
    }

    @Deprecated
    public final GoogleMap getMap() {
        if (this.akS != null) {
            return this.akS;
        }
        this.akY.nO();
        if (this.akY.je() == null) {
            return null;
        }
        try {
            this.akS = new GoogleMap(((a) this.akY.je()).nP().getMap());
            return this.akS;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getMapAsync(OnMapReadyCallback callback) {
        jx.aU("getMapAsync() must be called on the main thread");
        this.akY.getMapAsync(callback);
    }

    public final void onCreate(Bundle savedInstanceState) {
        this.akY.onCreate(savedInstanceState);
        if (this.akY.je() == null) {
            com.google.android.gms.dynamic.a.b((FrameLayout) this);
        }
    }

    public final void onDestroy() {
        this.akY.onDestroy();
    }

    public final void onLowMemory() {
        this.akY.onLowMemory();
    }

    public final void onPause() {
        this.akY.onPause();
    }

    public final void onResume() {
        this.akY.onResume();
    }

    public final void onSaveInstanceState(Bundle outState) {
        this.akY.onSaveInstanceState(outState);
    }
}
