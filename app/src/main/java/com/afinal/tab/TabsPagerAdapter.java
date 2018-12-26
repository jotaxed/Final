package com.afinal.tab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public Fragment getItem(int index) {
        switch (index) {
            case 0:
                return new RecorridoFragment();
            case 1:
                return new MesFragment();
            default:
                return null;
        }
    }

    public int getCount() {
        return 2;
    }
}
