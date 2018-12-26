package com.google.android.gms.auth;

import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.a;
import com.google.android.gms.internal.ii;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.r;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public final class GoogleAuthUtil {
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    private static final ComponentName Ek = new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.auth.GetToken");
    private static final ComponentName El = new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.recovery.RecoveryService");
    private static final Intent Em = new Intent().setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE).setComponent(Ek);
    private static final Intent En = new Intent().setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE).setComponent(El);
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    public static final String KEY_ANDROID_PACKAGE_NAME = (VERSION.SDK_INT >= 14 ? "androidPackageName" : "androidPackageName");
    public static final String KEY_CALLER_UID = (VERSION.SDK_INT >= 11 ? "callerUid" : "callerUid");
    public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";
    @Deprecated
    public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";

    private GoogleAuthUtil() {
    }

    private static void C(Context context) throws GoogleAuthException {
        try {
            GooglePlayServicesUtil.C(context);
        } catch (GooglePlayServicesRepairableException e) {
            throw new GooglePlayServicesAvailabilityException(e.getConnectionStatusCode(), e.getMessage(), e.getIntent());
        } catch (GooglePlayServicesNotAvailableException e2) {
            throw new GoogleAuthException(e2.getMessage());
        }
    }

    private static String a(Context context, String str, String str2, Bundle bundle) throws IOException, GoogleAuthException {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            return getToken(context, str, str2, bundle);
        } catch (GooglePlayServicesAvailabilityException e) {
            GooglePlayServicesUtil.showErrorNotification(e.getConnectionStatusCode(), context);
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
        } catch (UserRecoverableAuthException e2) {
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
        }
    }

    private static boolean ax(String str) {
        return "NetworkError".equals(str) || "ServiceUnavailable".equals(str) || "Timeout".equals(str);
    }

    private static boolean ay(String str) {
        return "BadAuthentication".equals(str) || "CaptchaRequired".equals(str) || "DeviceManagementRequiredOrSyncDisabled".equals(str) || "NeedPermission".equals(str) || "NeedsBrowser".equals(str) || "UserCancel".equals(str) || "AppDownloadRequired".equals(str) || ii.DM_SYNC_DISABLED.fO().equals(str) || ii.DM_ADMIN_BLOCKED.fO().equals(str) || ii.DM_ADMIN_PENDING_APPROVAL.fO().equals(str) || ii.DM_STALE_SYNC_REQUIRED.fO().equals(str) || ii.DM_DEACTIVATED.fO().equals(str) || ii.DM_REQUIRED.fO().equals(str);
    }

    public static void clearToken(Context context, String token) throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException {
        Context applicationContext = context.getApplicationContext();
        jx.aV("Calling this from your main thread can lead to deadlock");
        C(applicationContext);
        Bundle bundle = new Bundle();
        String str = context.getApplicationInfo().packageName;
        bundle.putString("clientPackageName", str);
        if (!bundle.containsKey(KEY_ANDROID_PACKAGE_NAME)) {
            bundle.putString(KEY_ANDROID_PACKAGE_NAME, str);
        }
        ServiceConnection aVar = new a();
        if (applicationContext.bindService(Em, aVar, 1)) {
            try {
                bundle = r.a.a(aVar.gs()).a(token, bundle);
                String string = bundle.getString(ii.Fk);
                if (bundle.getBoolean("booleanResult")) {
                    applicationContext.unbindService(aVar);
                    return;
                }
                throw new GoogleAuthException(string);
            } catch (Throwable e) {
                Log.i("GoogleAuthUtil", "GMS remote exception ", e);
                throw new IOException("remote exception");
            } catch (InterruptedException e2) {
                throw new GoogleAuthException("Interrupted");
            } catch (Throwable th) {
                applicationContext.unbindService(aVar);
            }
        } else {
            throw new IOException("Could not bind to service with the given context.");
        }
    }

    public static List<AccountChangeEvent> getAccountChangeEvents(Context ctx, int eventIndex, String accountName) throws GoogleAuthException, IOException {
        jx.b(accountName, (Object) "accountName must be provided");
        jx.aV("Calling this from your main thread can lead to deadlock");
        Context applicationContext = ctx.getApplicationContext();
        C(applicationContext);
        ServiceConnection aVar = new a();
        if (applicationContext.bindService(Em, aVar, 1)) {
            try {
                List<AccountChangeEvent> events = r.a.a(aVar.gs()).a(new AccountChangeEventsRequest().setAccountName(accountName).setEventIndex(eventIndex)).getEvents();
                applicationContext.unbindService(aVar);
                return events;
            } catch (Throwable e) {
                Log.i("GoogleAuthUtil", "GMS remote exception ", e);
                throw new IOException("remote exception");
            } catch (InterruptedException e2) {
                throw new GoogleAuthException("Interrupted");
            } catch (Throwable th) {
                applicationContext.unbindService(aVar);
            }
        } else {
            throw new IOException("Could not bind to service with the given context.");
        }
    }

    public static String getAccountId(Context ctx, String accountName) throws GoogleAuthException, IOException {
        jx.b(accountName, (Object) "accountName must be provided");
        jx.aV("Calling this from your main thread can lead to deadlock");
        C(ctx.getApplicationContext());
        return getToken(ctx, accountName, "^^_account_id_^^", new Bundle());
    }

    public static String getAppCert(Context context, String packageNameToCertify) {
        return "spatula";
    }

    public static String getToken(Context context, String accountName, String scope) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, accountName, scope, new Bundle());
    }

    public static String getToken(Context context, String accountName, String scope, Bundle extras) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        Context applicationContext = context.getApplicationContext();
        jx.aV("Calling this from your main thread can lead to deadlock");
        C(applicationContext);
        extras = extras == null ? new Bundle() : new Bundle(extras);
        String str = context.getApplicationInfo().packageName;
        extras.putString("clientPackageName", str);
        if (!extras.containsKey(KEY_ANDROID_PACKAGE_NAME)) {
            extras.putString(KEY_ANDROID_PACKAGE_NAME, str);
        }
        ServiceConnection aVar = new a();
        if (applicationContext.bindService(Em, aVar, 1)) {
            try {
                Bundle a = r.a.a(aVar.gs()).a(accountName, scope, extras);
                if (a == null) {
                    Log.w("GoogleAuthUtil", "Binder call returned null.");
                    throw new GoogleAuthException("ServiceUnavailable");
                }
                Object string = a.getString("authtoken");
                if (TextUtils.isEmpty(string)) {
                    String string2 = a.getString("Error");
                    Intent intent = (Intent) a.getParcelable("userRecoveryIntent");
                    if (ay(string2)) {
                        throw new UserRecoverableAuthException(string2, intent);
                    } else if (ax(string2)) {
                        throw new IOException(string2);
                    } else {
                        throw new GoogleAuthException(string2);
                    }
                }
                applicationContext.unbindService(aVar);
                return string;
            } catch (Throwable e) {
                Log.i("GoogleAuthUtil", "GMS remote exception ", e);
                throw new IOException("remote exception");
            } catch (InterruptedException e2) {
                throw new GoogleAuthException("Interrupted");
            } catch (Throwable th) {
                applicationContext.unbindService(aVar);
            }
        } else {
            throw new IOException("Could not bind to service with the given context.");
        }
    }

    public static String getTokenWithNotification(Context context, String accountName, String scope, Bundle extras) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putBoolean("handle_notification", true);
        return a(context, accountName, scope, extras);
    }

    public static String getTokenWithNotification(Context context, String accountName, String scope, Bundle extras, Intent callback) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        h(callback);
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putParcelable("callback_intent", callback);
        extras.putBoolean("handle_notification", true);
        return a(context, accountName, scope, extras);
    }

    public static String getTokenWithNotification(Context context, String accountName, String scope, Bundle extras, String authority, Bundle syncBundle) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        if (TextUtils.isEmpty(authority)) {
            throw new IllegalArgumentException("Authority cannot be empty or null.");
        }
        if (extras == null) {
            extras = new Bundle();
        }
        if (syncBundle == null) {
            syncBundle = new Bundle();
        }
        ContentResolver.validateSyncExtrasBundle(syncBundle);
        extras.putString("authority", authority);
        extras.putBundle("sync_extras", syncBundle);
        extras.putBoolean("handle_notification", true);
        return a(context, accountName, scope, extras);
    }

    private static void h(Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("Callback cannot be null.");
        }
        try {
            Intent.parseUri(intent.toUri(1), 1);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
        }
    }

    @Deprecated
    public static void invalidateToken(Context context, String token) {
        AccountManager.get(context).invalidateAuthToken(GOOGLE_ACCOUNT_TYPE, token);
    }
}
