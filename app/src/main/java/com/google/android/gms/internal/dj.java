package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.R;
import java.util.Map;
import org.json.JSONObject;

@ey
public class dj {
    private final Context mContext;
    private final gu mo;
    private final Map<String, String> rd;

    public dj(gu guVar, Map<String, String> map) {
        this.mo = guVar;
        this.rd = map;
        this.mContext = guVar.dI();
    }

    String B(String str) {
        return Uri.parse(str).getLastPathSegment();
    }

    Request b(String str, String str2) {
        Request request = new Request(Uri.parse(str));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
        if (ll.ig()) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
        } else {
            request.setShowRunningNotification(true);
        }
        return request;
    }

    public void execute() {
        if (!new bl(this.mContext).bq()) {
            gr.W("Store picture feature is not supported on this device.");
        } else if (TextUtils.isEmpty((CharSequence) this.rd.get("iurl"))) {
            gr.W("Image url cannot be empty.");
        } else {
            final String str = (String) this.rd.get("iurl");
            if (URLUtil.isValidUrl(str)) {
                final String B = B(str);
                if (gi.N(B)) {
                    Builder builder = new Builder(this.mContext);
                    builder.setTitle(ga.c(R.string.store_picture_title, "Save image"));
                    builder.setMessage(ga.c(R.string.store_picture_message, "Allow Ad to store image in Picture gallery?"));
                    builder.setPositiveButton(ga.c(R.string.accept, "Accept"), new OnClickListener(this) {
                        final /* synthetic */ dj rr;

                        public void onClick(DialogInterface dialog, int which) {
                            try {
                                ((DownloadManager) this.rr.mContext.getSystemService("download")).enqueue(this.rr.b(str, B));
                            } catch (IllegalStateException e) {
                                gr.U("Could not store picture.");
                            }
                        }
                    });
                    builder.setNegativeButton(ga.c(R.string.decline, "Decline"), new OnClickListener(this) {
                        final /* synthetic */ dj rr;

                        {
                            this.rr = r1;
                        }

                        public void onClick(DialogInterface dialog, int which) {
                            this.rr.mo.b("onStorePictureCanceled", new JSONObject());
                        }
                    });
                    builder.create().show();
                    return;
                }
                gr.W("Image type not recognized:");
                return;
            }
            gr.W("Invalid image url:" + str);
        }
    }
}
