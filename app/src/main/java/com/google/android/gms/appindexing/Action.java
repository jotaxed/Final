package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.internal.jx;
import com.google.android.gms.plus.PlusShare;

public final class Action extends Thing {
    public static final String TYPE_ADD = "http://schema.org/AddAction";
    public static final String TYPE_BOOKMARK = "http://schema.org/BookmarkAction";
    public static final String TYPE_LIKE = "http://schema.org/LikeAction";
    public static final String TYPE_LISTEN = "http://schema.org/ListenAction";
    public static final String TYPE_VIEW = "http://schema.org/ViewAction";
    public static final String TYPE_WANT = "http://schema.org/WantAction";
    public static final String TYPE_WATCH = "http://schema.org/WatchAction";

    public static final class Builder extends com.google.android.gms.appindexing.Thing.Builder {
        public Builder(String actionType) {
            jx.i(actionType);
            super.put("type", actionType);
        }

        public Action build() {
            jx.b(this.DJ.get("object"), (Object) "setObject is required before calling build().");
            jx.b(this.DJ.get("type"), (Object) "setType is required before calling build().");
            Bundle bundle = (Bundle) this.DJ.getParcelable("object");
            jx.b(bundle.get("name"), (Object) "Must call setObject() with a valid name. Example: setObject(new Thing.Builder().setName(name).setUrl(url))");
            jx.b(bundle.get(PlusShare.KEY_CALL_TO_ACTION_URL), (Object) "Must call setObject() with a valid app url. Example: setObject(new Thing.Builder().setName(name).setUrl(url))");
            return new Action(this.DJ);
        }

        public Builder put(String key, Thing value) {
            return (Builder) super.put(key, value);
        }

        public Builder put(String key, String value) {
            return (Builder) super.put(key, value);
        }

        public Builder setName(String name) {
            return (Builder) super.put("name", name);
        }

        public Builder setObject(Thing thing) {
            jx.i(thing);
            return (Builder) super.put("object", thing);
        }

        public Builder setUrl(Uri webUrl) {
            if (webUrl != null) {
                super.put(PlusShare.KEY_CALL_TO_ACTION_URL, webUrl.toString());
            }
            return this;
        }
    }

    private Action(Bundle propertyBundle) {
        super(propertyBundle);
    }

    public static Action newAction(String actionType, String objectName, Uri objectUrl) {
        return newAction(actionType, objectName, null, objectUrl);
    }

    public static Action newAction(String actionType, String objectName, Uri objectId, Uri objectUrl) {
        return new Builder(actionType).setObject(new com.google.android.gms.appindexing.Thing.Builder().setName(objectName).setId(objectId == null ? null : objectId.toString()).setUrl(objectUrl).build()).build();
    }
}
