package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

@ey
public class gw extends WebChromeClient {
    private final gu mo;

    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] xq = new int[MessageLevel.values().length];

        static {
            try {
                xq[MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                xq[MessageLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                xq[MessageLevel.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                xq[MessageLevel.TIP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                xq[MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public gw(gu guVar) {
        this.mo = guVar;
    }

    private static void a(Builder builder, String str, final JsResult jsResult) {
        builder.setMessage(str).setPositiveButton(17039370, new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                jsResult.confirm();
            }
        }).setNegativeButton(17039360, new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                jsResult.cancel();
            }
        }).setOnCancelListener(new OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                jsResult.cancel();
            }
        }).create().show();
    }

    private static void a(Context context, Builder builder, String str, String str2, final JsPromptResult jsPromptResult) {
        View linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        View textView = new TextView(context);
        textView.setText(str);
        final View editText = new EditText(context);
        editText.setText(str2);
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        builder.setView(linearLayout).setPositiveButton(17039370, new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                jsPromptResult.confirm(editText.getText().toString());
            }
        }).setNegativeButton(17039360, new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                jsPromptResult.cancel();
            }
        }).setOnCancelListener(new OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                jsPromptResult.cancel();
            }
        }).create().show();
    }

    private final Context c(WebView webView) {
        if (!(webView instanceof gu)) {
            return webView.getContext();
        }
        gu guVar = (gu) webView;
        Context dI = guVar.dI();
        return dI == null ? guVar.getContext() : dI;
    }

    protected final void a(View view, int i, CustomViewCallback customViewCallback) {
        dp dC = this.mo.dC();
        if (dC == null) {
            gr.W("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        dC.a(view, customViewCallback);
        dC.setRequestedOrientation(i);
    }

    protected boolean a(Context context, String str, String str2, String str3, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        try {
            Builder builder = new Builder(context);
            builder.setTitle(str);
            if (z) {
                a(context, builder, str2, str3, jsPromptResult);
            } else {
                a(builder, str2, jsResult);
            }
        } catch (Throwable e) {
            gr.d("Fail to display Dialog.", e);
        }
        return true;
    }

    public final void onCloseWindow(WebView webView) {
        if (webView instanceof gu) {
            dp dC = ((gu) webView).dC();
            if (dC == null) {
                gr.W("Tried to close an AdWebView not associated with an overlay.");
                return;
            } else {
                dC.close();
                return;
            }
        }
        gr.W("Tried to close a WebView that wasn't an AdWebView.");
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = "JS: " + consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")";
        if (str.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        switch (AnonymousClass7.xq[consoleMessage.messageLevel().ordinal()]) {
            case 1:
                gr.T(str);
                break;
            case 2:
                gr.W(str);
                break;
            case 3:
            case 4:
                gr.U(str);
                break;
            case 5:
                gr.S(str);
                break;
            default:
                gr.U(str);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
        WebViewTransport webViewTransport = (WebViewTransport) resultMsg.obj;
        WebView webView = new WebView(view.getContext());
        webView.setWebViewClient(this.mo.dD());
        webViewTransport.setWebView(webView);
        resultMsg.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String url, String databaseIdentifier, long currentQuota, long estimatedSize, long totalUsedQuota, QuotaUpdater quotaUpdater) {
        long j = 5242880 - totalUsedQuota;
        if (j <= 0) {
            quotaUpdater.updateQuota(currentQuota);
            return;
        }
        if (currentQuota == 0) {
            if (estimatedSize > j || estimatedSize > 1048576) {
                estimatedSize = 0;
            }
        } else if (estimatedSize == 0) {
            estimatedSize = Math.min(Math.min(131072, j) + currentQuota, 1048576);
        } else {
            if (estimatedSize <= Math.min(1048576 - currentQuota, j)) {
                currentQuota += estimatedSize;
            }
            estimatedSize = currentQuota;
        }
        quotaUpdater.updateQuota(estimatedSize);
    }

    public final void onHideCustomView() {
        dp dC = this.mo.dC();
        if (dC == null) {
            gr.W("Could not get ad overlay when hiding custom view.");
        } else {
            dC.cf();
        }
    }

    public final boolean onJsAlert(WebView webView, String url, String message, JsResult result) {
        return a(c(webView), url, message, null, result, null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String url, String message, JsResult result) {
        return a(c(webView), url, message, null, result, null, false);
    }

    public final boolean onJsConfirm(WebView webView, String url, String message, JsResult result) {
        return a(c(webView), url, message, null, result, null, false);
    }

    public final boolean onJsPrompt(WebView webView, String url, String message, String defaultValue, JsPromptResult result) {
        return a(c(webView), url, message, defaultValue, null, result, true);
    }

    public final void onReachedMaxAppCacheSize(long spaceNeeded, long totalUsedQuota, QuotaUpdater quotaUpdater) {
        long j = 131072 + spaceNeeded;
        if (5242880 - totalUsedQuota < j) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j);
        }
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        a(view, -1, customViewCallback);
    }
}
