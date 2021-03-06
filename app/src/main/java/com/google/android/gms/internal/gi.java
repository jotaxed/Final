package com.google.android.gms.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.net.UrlQuerySanitizer.ParameterValuePair;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.ads.AdActivity;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.nio.CharBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public final class gi {
    private static final Object ut = new Object();
    private static final SimpleDateFormat[] wB = new SimpleDateFormat[]{new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"), new SimpleDateFormat("yyyyMMdd")};
    private static boolean wC = true;
    private static String wD;
    private static boolean wE = false;

    private static final class a extends BroadcastReceiver {
        private a() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                gi.wC = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                gi.wC = false;
            }
        }
    }

    public static String L(String str) {
        return Uri.parse(str).buildUpon().query(null).build().toString();
    }

    public static int M(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            gr.W("Could not parse value:" + e);
            return 0;
        }
    }

    public static boolean N(String str) {
        return TextUtils.isEmpty(str) ? false : str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public static long O(String str) {
        long j = -1;
        int i = 0;
        if (!TextUtils.isEmpty(str)) {
            SimpleDateFormat[] simpleDateFormatArr = wB;
            int length = simpleDateFormatArr.length;
            while (i < length) {
                SimpleDateFormat simpleDateFormat = simpleDateFormatArr[i];
                try {
                    simpleDateFormat.setLenient(false);
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                    j = simpleDateFormat.parse(str).getTime();
                    break;
                } catch (ParseException e) {
                    i++;
                }
            }
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException e2) {
            }
        }
        return j;
    }

    public static String a(Readable readable) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence allocate = CharBuffer.allocate(2048);
        while (true) {
            int read = readable.read(allocate);
            if (read == -1) {
                return stringBuilder.toString();
            }
            allocate.flip();
            stringBuilder.append(allocate, 0, read);
        }
    }

    private static JSONArray a(Collection<?> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object a : collection) {
            a(jSONArray, a);
        }
        return jSONArray;
    }

    static JSONArray a(Object[] objArr) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object a : objArr) {
            a(jSONArray, a);
        }
        return jSONArray;
    }

    public static void a(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(c(context, str));
    }

    public static void a(Context context, String str, List<String> list) {
        for (String gpVar : list) {
            new gp(context, str, gpVar).start();
        }
    }

    public static void a(Context context, String str, List<String> list, String str2) {
        for (String gpVar : list) {
            new gp(context, str, gpVar, str2).start();
        }
    }

    public static void a(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        a(context, str, z, httpURLConnection, false);
    }

    public static void a(Context context, String str, boolean z, HttpURLConnection httpURLConnection, String str2) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", str2);
        httpURLConnection.setUseCaches(false);
    }

    public static void a(Context context, String str, boolean z, HttpURLConnection httpURLConnection, boolean z2) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", c(context, str));
        httpURLConnection.setUseCaches(z2);
    }

    public static void a(WebView webView) {
        if (VERSION.SDK_INT >= 11) {
            gm.a(webView);
        }
    }

    private static void a(JSONArray jSONArray, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONArray.put(c((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(t((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(a((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    private static void a(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONObject.put(str, c((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, t((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, a(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    public static boolean a(PackageManager packageManager, String str, String str2) {
        return packageManager.checkPermission(str2, str) == 0;
    }

    public static boolean a(ClassLoader classLoader, Class<?> cls, String str) {
        boolean z = false;
        try {
            z = cls.isAssignableFrom(Class.forName(str, false, classLoader));
        } catch (Throwable th) {
        }
        return z;
    }

    public static void b(WebView webView) {
        if (VERSION.SDK_INT >= 11) {
            gm.b(webView);
        }
    }

    public static String c(final Context context, String str) {
        String str2;
        synchronized (ut) {
            if (wD != null) {
                str2 = wD;
            } else {
                if (VERSION.SDK_INT >= 17) {
                    try {
                        wD = go.getDefaultUserAgent(context);
                        wD += " (Mobile; " + str + ")";
                        str2 = wD;
                    } catch (Exception e) {
                    }
                }
                if (gq.dB()) {
                    try {
                        wD = r(context);
                    } catch (Exception e2) {
                        wD = dw();
                    }
                } else {
                    gq.wR.post(new Runnable() {
                        public void run() {
                            synchronized (gi.ut) {
                                gi.wD = gi.r(context);
                                gi.ut.notifyAll();
                            }
                        }
                    });
                    while (wD == null) {
                        try {
                            ut.wait();
                        } catch (InterruptedException e3) {
                            wD = dw();
                            gr.W("Interrupted, use default user agent: " + wD);
                        }
                    }
                }
                wD += " (Mobile; " + str + ")";
                str2 = wD;
            }
        }
        return str2;
    }

    public static Map<String, String> c(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        UrlQuerySanitizer urlQuerySanitizer = new UrlQuerySanitizer();
        urlQuerySanitizer.setAllowUnregisteredParamaters(true);
        urlQuerySanitizer.setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
        urlQuerySanitizer.parseUrl(uri.toString());
        for (ParameterValuePair parameterValuePair : urlQuerySanitizer.getParameterList()) {
            hashMap.put(parameterValuePair.mParameter, parameterValuePair.mValue);
        }
        return hashMap;
    }

    private static JSONObject c(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            a(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    public static void c(Context context, String str, String str2) {
        List arrayList = new ArrayList();
        arrayList.add(str2);
        a(context, str, arrayList);
    }

    public static boolean dt() {
        return wC;
    }

    public static int du() {
        return VERSION.SDK_INT >= 9 ? 6 : 0;
    }

    public static int dv() {
        return VERSION.SDK_INT >= 9 ? 7 : 1;
    }

    static String dw() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("Mozilla/5.0 (Linux; U; Android");
        if (VERSION.RELEASE != null) {
            stringBuffer.append(" ").append(VERSION.RELEASE);
        }
        stringBuffer.append("; ").append(Locale.getDefault());
        if (Build.DEVICE != null) {
            stringBuffer.append("; ").append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                stringBuffer.append(" Build/").append(Build.DISPLAY);
            }
        }
        stringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return stringBuffer.toString();
    }

    public static String dx() {
        UUID randomUUID = UUID.randomUUID();
        byte[] toByteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] toByteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, toByteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(toByteArray);
                instance.update(toByteArray2);
                Object obj = new byte[8];
                System.arraycopy(instance.digest(), 0, obj, 0, 8);
                bigInteger = new BigInteger(1, obj).toString();
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return bigInteger;
    }

    public static boolean p(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            gr.W("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        boolean z;
        String str = "com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".";
        if ((resolveActivity.activityInfo.configChanges & 16) == 0) {
            gr.W(String.format(str, new Object[]{"keyboard"}));
            z = false;
        } else {
            z = true;
        }
        if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
            gr.W(String.format(str, new Object[]{"keyboardHidden"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 128) == 0) {
            gr.W(String.format(str, new Object[]{"orientation"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 256) == 0) {
            gr.W(String.format(str, new Object[]{"screenLayout"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 512) == 0) {
            gr.W(String.format(str, new Object[]{"uiMode"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 1024) == 0) {
            gr.W(String.format(str, new Object[]{"screenSize"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 2048) != 0) {
            return z;
        }
        gr.W(String.format(str, new Object[]{"smallestScreenSize"}));
        return false;
    }

    public static void q(Context context) {
        if (!wE) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            context.getApplicationContext().registerReceiver(new a(), intentFilter);
            wE = true;
        }
    }

    private static String r(Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }

    public static int s(Context context) {
        int i;
        int i2 = 0;
        if (context instanceof Activity) {
            Window window = ((Activity) context).getWindow();
            Rect rect = new Rect();
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            i = rect.top;
            i2 = window.findViewById(16908290).getTop() - i;
        } else {
            i = 0;
        }
        return i2 + i;
    }

    public static JSONObject t(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                a(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            throw new JSONException("Could not convert map to JSON: " + e.getMessage());
        }
    }

    public static int[] t(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        float f = 160.0f / ((float) displayMetrics.densityDpi);
        int i = (int) (((float) displayMetrics.widthPixels) * f);
        int i2 = (int) (f * ((float) displayMetrics.heightPixels));
        return new int[]{i, i2};
    }
}
