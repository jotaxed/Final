package com.afinal;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MenuItem;
import com.afinal.db.PeajesDataSource;
import com.afinal.tab.TabsPagerAdapter;

public class HistorialTabActivity extends FragmentActivity implements TabListener {
    private ActionBar actionBar;
    PeajesDataSource datasource;
    private TabsPagerAdapter mAdapter;
    private String[] tabs = new String[]{"Por Recorrido", "Por Mes"};
    private ViewPager viewPager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        this.viewPager = (ViewPager) findViewById(R.id.pager);
        this.actionBar = getActionBar();
        this.mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        this.viewPager.setAdapter(this.mAdapter);
        this.actionBar.setNavigationMode(2);
        this.actionBar.setDisplayHomeAsUpEnabled(true);
        for (String tab_name : this.tabs) {
            this.actionBar.addTab(this.actionBar.newTab().setText(tab_name).setTabListener(this));
        }
        this.viewPager.setOnPageChangeListener(new OnPageChangeListener() {
            public void onPageSelected(int position) {
                HistorialTabActivity.this.actionBar.setSelectedNavigationItem(position);
            }

            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            public void onPageScrollStateChanged(int arg0) {
            }
        });
        this.datasource = new PeajesDataSource(this);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        this.viewPager.setCurrentItem(tab.getPosition());
    }

    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
    }

    public void onTabReselected(Tab tab, FragmentTransaction ft) {
    }
}
