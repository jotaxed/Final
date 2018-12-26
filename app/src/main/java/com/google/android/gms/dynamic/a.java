package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class a<T extends LifecycleDelegate> {
    private T Tu;
    private Bundle Tv;
    private LinkedList<a> Tw;
    private final f<T> Tx = new f<T>(this) {
        final /* synthetic */ a Ty;

        {
            this.Ty = r1;
        }

        public void a(T t) {
            this.Ty.Tu = t;
            Iterator it = this.Ty.Tw.iterator();
            while (it.hasNext()) {
                ((a) it.next()).b(this.Ty.Tu);
            }
            this.Ty.Tw.clear();
            this.Ty.Tv = null;
        }
    };

    private interface a {
        void b(LifecycleDelegate lifecycleDelegate);

        int getState();
    }

    private void a(Bundle bundle, a aVar) {
        if (this.Tu != null) {
            aVar.b(this.Tu);
            return;
        }
        if (this.Tw == null) {
            this.Tw = new LinkedList();
        }
        this.Tw.add(aVar);
        if (bundle != null) {
            if (this.Tv == null) {
                this.Tv = (Bundle) bundle.clone();
            } else {
                this.Tv.putAll(bundle);
            }
        }
        a(this.Tx);
    }

    public static void b(FrameLayout frameLayout) {
        final Context context = frameLayout.getContext();
        final int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        CharSequence b = GooglePlayServicesUtil.b(context, isGooglePlayServicesAvailable);
        CharSequence c = GooglePlayServicesUtil.c(context, isGooglePlayServicesAvailable);
        View linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        View textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(b);
        linearLayout.addView(textView);
        if (c != null) {
            View button = new Button(context);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(c);
            linearLayout.addView(button);
            button.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    context.startActivity(GooglePlayServicesUtil.aj(isGooglePlayServicesAvailable));
                }
            });
        }
    }

    private void cG(int i) {
        while (!this.Tw.isEmpty() && ((a) this.Tw.getLast()).getState() >= i) {
            this.Tw.removeLast();
        }
    }

    protected void a(FrameLayout frameLayout) {
        b(frameLayout);
    }

    protected abstract void a(f<T> fVar);

    public T je() {
        return this.Tu;
    }

    public void onCreate(final Bundle savedInstanceState) {
        a(savedInstanceState, new a(this) {
            final /* synthetic */ a Ty;

            public void b(LifecycleDelegate lifecycleDelegate) {
                this.Ty.Tu.onCreate(savedInstanceState);
            }

            public int getState() {
                return 1;
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final FrameLayout frameLayout = new FrameLayout(inflater.getContext());
        final LayoutInflater layoutInflater = inflater;
        final ViewGroup viewGroup = container;
        final Bundle bundle = savedInstanceState;
        a(savedInstanceState, new a(this) {
            final /* synthetic */ a Ty;

            public void b(LifecycleDelegate lifecycleDelegate) {
                frameLayout.removeAllViews();
                frameLayout.addView(this.Ty.Tu.onCreateView(layoutInflater, viewGroup, bundle));
            }

            public int getState() {
                return 2;
            }
        });
        if (this.Tu == null) {
            a(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.Tu != null) {
            this.Tu.onDestroy();
        } else {
            cG(1);
        }
    }

    public void onDestroyView() {
        if (this.Tu != null) {
            this.Tu.onDestroyView();
        } else {
            cG(2);
        }
    }

    public void onInflate(final Activity activity, final Bundle attrs, final Bundle savedInstanceState) {
        a(savedInstanceState, new a(this) {
            final /* synthetic */ a Ty;

            public void b(LifecycleDelegate lifecycleDelegate) {
                this.Ty.Tu.onInflate(activity, attrs, savedInstanceState);
            }

            public int getState() {
                return 0;
            }
        });
    }

    public void onLowMemory() {
        if (this.Tu != null) {
            this.Tu.onLowMemory();
        }
    }

    public void onPause() {
        if (this.Tu != null) {
            this.Tu.onPause();
        } else {
            cG(5);
        }
    }

    public void onResume() {
        a(null, new a(this) {
            final /* synthetic */ a Ty;

            {
                this.Ty = r1;
            }

            public void b(LifecycleDelegate lifecycleDelegate) {
                this.Ty.Tu.onResume();
            }

            public int getState() {
                return 5;
            }
        });
    }

    public void onSaveInstanceState(Bundle outState) {
        if (this.Tu != null) {
            this.Tu.onSaveInstanceState(outState);
        } else if (this.Tv != null) {
            outState.putAll(this.Tv);
        }
    }

    public void onStart() {
        a(null, new a(this) {
            final /* synthetic */ a Ty;

            {
                this.Ty = r1;
            }

            public void b(LifecycleDelegate lifecycleDelegate) {
                this.Ty.Tu.onStart();
            }

            public int getState() {
                return 4;
            }
        });
    }

    public void onStop() {
        if (this.Tu != null) {
            this.Tu.onStop();
        } else {
            cG(4);
        }
    }
}
