package com.afinal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class AcercaDeActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        ((ImageView) findViewById(R.id.ivLogoEmpresa)).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                AcercaDeActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.stationdomain.com")));
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.acerca_de_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                finish();
                break;
            case R.id.action_email /*2131492944*/:
                Intent sendIntent = new Intent("android.intent.action.VIEW");
                sendIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
                sendIntent.putExtra("android.intent.extra.EMAIL", new String[]{"apps@stationdomain.com"});
                sendIntent.putExtra("android.intent.extra.SUBJECT", "Contacto Tag´z");
                sendIntent.setType("plain/text");
                startActivity(sendIntent);
                break;
            case R.id.action_facebook /*2131492945*/:
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/TagzChile")));
                break;
            case R.id.action_web /*2131492946*/:
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://tagz.stationdomain.com/")));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
