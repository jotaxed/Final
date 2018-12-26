package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.google.android.gms.dynamic.c.a;

public final class h extends a {
    private Fragment Mx;

    private h(Fragment fragment) {
        this.Mx = fragment;
    }

    public static h a(Fragment fragment) {
        return fragment != null ? new h(fragment) : null;
    }

    public void d(d dVar) {
        this.Mx.registerForContextMenu((View) e.f(dVar));
    }

    public void e(d dVar) {
        this.Mx.unregisterForContextMenu((View) e.f(dVar));
    }

    public Bundle getArguments() {
        return this.Mx.getArguments();
    }

    public int getId() {
        return this.Mx.getId();
    }

    public boolean getRetainInstance() {
        return this.Mx.getRetainInstance();
    }

    public String getTag() {
        return this.Mx.getTag();
    }

    public int getTargetRequestCode() {
        return this.Mx.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.Mx.getUserVisibleHint();
    }

    public d getView() {
        return e.k(this.Mx.getView());
    }

    public boolean isAdded() {
        return this.Mx.isAdded();
    }

    public boolean isDetached() {
        return this.Mx.isDetached();
    }

    public boolean isHidden() {
        return this.Mx.isHidden();
    }

    public boolean isInLayout() {
        return this.Mx.isInLayout();
    }

    public boolean isRemoving() {
        return this.Mx.isRemoving();
    }

    public boolean isResumed() {
        return this.Mx.isResumed();
    }

    public boolean isVisible() {
        return this.Mx.isVisible();
    }

    public d jf() {
        return e.k(this.Mx.getActivity());
    }

    public c jg() {
        return a(this.Mx.getParentFragment());
    }

    public d jh() {
        return e.k(this.Mx.getResources());
    }

    public c ji() {
        return a(this.Mx.getTargetFragment());
    }

    public void setHasOptionsMenu(boolean hasMenu) {
        this.Mx.setHasOptionsMenu(hasMenu);
    }

    public void setMenuVisibility(boolean menuVisible) {
        this.Mx.setMenuVisibility(menuVisible);
    }

    public void setRetainInstance(boolean retain) {
        this.Mx.setRetainInstance(retain);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.Mx.setUserVisibleHint(isVisibleToUser);
    }

    public void startActivity(Intent intent) {
        this.Mx.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        this.Mx.startActivityForResult(intent, requestCode);
    }
}
