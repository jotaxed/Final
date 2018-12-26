package com.afinal;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.MenuItem;
import com.afinal.db.PeajesDataSource;
import com.afinal.libreria.Recorrido;
import com.afinal.tab.TabsPagerAdapter;
import java.util.List;

public class DetailHistorialActivity extends FragmentActivity implements TabListener {
    private static final String LOGTAG = "DetailHistorialActivity";
    private static final int TRAMO_HISTORIAL_ACTIVITY = 1001;
    private ActionBar actionBar;
    PeajesDataSource datasource;
    int id;
    private TabsPagerAdapter mAdapter;
    List<Recorrido> recorridos;
    private String[] tabs = new String[]{"Por Recorrido", "Por Mes"};
    private ViewPager viewPager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_historial);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        this.id = Integer.valueOf(String.valueOf(intent.getLongExtra("id_vehiculo", 0))).intValue();
        setTitle("Historial " + intent.getStringExtra("nombre"));
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
                DetailHistorialActivity.this.actionBar.setSelectedNavigationItem(position);
            }

            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            public void onPageScrollStateChanged(int arg0) {
            }
        });
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

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(LOGTAG, "HOLIIIIIIII onActivityResult");
        Log.i(LOGTAG, "requestCode: " + requestCode);
        Log.i(LOGTAG, "resultCode: " + resultCode);
        if (resultCode == -1) {
            Log.i(LOGTAG, "onActivityResult result code -1");
            Log.i(LOGTAG, "Se debería iniciar broadcast");
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("refresh"));
            Log.i(LOGTAG, "Se inicio LocalBroadcastManager");
        }
    }
}
