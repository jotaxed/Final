package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.R;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.plus.PlusShare;
import java.util.Map;
import org.json.JSONObject;

@ey
public class dh {
    private final Context mContext;
    private final gu mo;
    private final Map<String, String> rd;
    private String re;
    private long rf;
    private long rg;
    private String rh;
    private String ri;

    public dh(gu guVar, Map<String, String> map) {
        this.mo = guVar;
        this.rd = map;
        this.mContext = guVar.dI();
        bQ();
    }

    private String A(String str) {
        return TextUtils.isEmpty((CharSequence) this.rd.get(str)) ? "" : (String) this.rd.get(str);
    }

    private void bQ() {
        this.re = A(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
        this.rh = A("summary");
        this.rf = gi.O((String) this.rd.get("start"));
        this.rg = gi.O((String) this.rd.get("end"));
        this.ri = A("location");
    }

    Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(Events.CONTENT_URI);
        data.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, this.rh);
        data.putExtra("eventLocation", this.ri);
        data.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.re);
        data.putExtra("beginTime", this.rf);
        data.putExtra("endTime", this.rg);
        data.setFlags(DriveFile.MODE_READ_ONLY);
        return data;
    }

    public void execute() {
        if (new bl(this.mContext).bt()) {
            Builder builder = new Builder(this.mContext);
            builder.setTitle(ga.c(R.string.create_calendar_title, "Create calendar event"));
            builder.setMessage(ga.c(R.string.create_calendar_message, "Allow Ad to create a calendar event?"));
            builder.setPositiveButton(ga.c(R.string.accept, "Accept"), new OnClickListener(this) {
                final /* synthetic */ dh rj;

                {
                    this.rj = r1;
                }

                public void onClick(DialogInterface dialog, int which) {
                    this.rj.mContext.startActivity(this.rj.createIntent());
                }
            });
            builder.setNegativeButton(ga.c(R.string.decline, "Decline"), new OnClickListener(this) {
                final /* synthetic */ dh rj;

                {
                    this.rj = r1;
                }

                public void onClick(DialogInterface dialog, int which) {
                    this.rj.mo.b("onCalendarEventCanceled", new JSONObject());
                }
            });
            builder.create().show();
            return;
        }
        gr.W("This feature is not available on this version of the device.");
    }
}
