package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.c.a;

public final class b extends a {
    private Fragment TG;

    private b(Fragment fragment) {
        this.TG = fragment;
    }

    public static b a(Fragment fragment) {
        return fragment != null ? new b(fragment) : null;
    }

    public void d(d dVar) {
        this.TG.registerForContextMenu((View) e.f(dVar));
    }

    public void e(d dVar) {
        this.TG.unregisterForContextMenu((View) e.f(dVar));
    }

    public Bundle getArguments() {
        return this.TG.getArguments();
    }

    public int getId() {
        return this.TG.getId();
    }

    public boolean getRetainInstance() {
        return this.TG.getRetainInstance();
    }

    public String getTag() {
        return this.TG.getTag();
    }

    public int getTargetRequestCode() {
        return this.TG.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.TG.getUserVisibleHint();
    }

    public d getView() {
        return e.k(this.TG.getView());
    }

    public boolean isAdded() {
        return this.TG.isAdded();
    }

    public boolean isDetached() {
        return this.TG.isDetached();
    }

    public boolean isHidden() {
        return this.TG.isHidden();
    }

    public boolean isInLayout() {
        return this.TG.isInLayout();
    }

    public boolean isRemoving() {
        return this.TG.isRemoving();
    }

    public boolean isResumed() {
        return this.TG.isResumed();
    }

    public boolean isVisible() {
        return this.TG.isVisible();
    }

    public d jf() {
        return e.k(this.TG.getActivity());
    }

    public c jg() {
        return a(this.TG.getParentFragment());
    }

    public d jh() {
        return e.k(this.TG.getResources());
    }

    public c ji() {
        return a(this.TG.getTargetFragment());
    }

    public void setHasOptionsMenu(boolean hasMenu) {
        this.TG.setHasOptionsMenu(hasMenu);
    }

    public void setMenuVisibility(boolean menuVisible) {
        this.TG.setMenuVisibility(menuVisible);
    }

    public void setRetainInstance(boolean retain) {
        this.TG.setRetainInstance(retain);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.TG.setUserVisibleHint(isVisibleToUser);
    }

    public void startActivity(Intent intent) {
        this.TG.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        this.TG.startActivityForResult(intent, requestCode);
    }
}
