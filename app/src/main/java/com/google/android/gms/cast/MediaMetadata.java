package com.google.android.gms.cast;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.ix;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaMetadata {
    private static final String[] Gc = new String[]{null, "String", "int", "double", "ISO-8601 date String"};
    private static final a Gd = new a().a(KEY_CREATION_DATE, "creationDateTime", 4).a(KEY_RELEASE_DATE, "releaseDate", 4).a(KEY_BROADCAST_DATE, "originalAirdate", 4).a(KEY_TITLE, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 1).a(KEY_SUBTITLE, "subtitle", 1).a(KEY_ARTIST, "artist", 1).a(KEY_ALBUM_ARTIST, "albumArtist", 1).a(KEY_ALBUM_TITLE, "albumName", 1).a(KEY_COMPOSER, "composer", 1).a(KEY_DISC_NUMBER, "discNumber", 2).a(KEY_TRACK_NUMBER, "trackNumber", 2).a(KEY_SEASON_NUMBER, "season", 2).a(KEY_EPISODE_NUMBER, "episode", 2).a(KEY_SERIES_TITLE, "seriesTitle", 1).a(KEY_STUDIO, "studio", 1).a(KEY_WIDTH, "width", 2).a(KEY_HEIGHT, "height", 2).a(KEY_LOCATION_NAME, "location", 1).a(KEY_LOCATION_LATITUDE, "latitude", 3).a(KEY_LOCATION_LONGITUDE, "longitude", 3);
    public static final String KEY_ALBUM_ARTIST = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";
    public static final String KEY_ALBUM_TITLE = "com.google.android.gms.cast.metadata.ALBUM_TITLE";
    public static final String KEY_ARTIST = "com.google.android.gms.cast.metadata.ARTIST";
    public static final String KEY_BROADCAST_DATE = "com.google.android.gms.cast.metadata.BROADCAST_DATE";
    public static final String KEY_COMPOSER = "com.google.android.gms.cast.metadata.COMPOSER";
    public static final String KEY_CREATION_DATE = "com.google.android.gms.cast.metadata.CREATION_DATE";
    public static final String KEY_DISC_NUMBER = "com.google.android.gms.cast.metadata.DISC_NUMBER";
    public static final String KEY_EPISODE_NUMBER = "com.google.android.gms.cast.metadata.EPISODE_NUMBER";
    public static final String KEY_HEIGHT = "com.google.android.gms.cast.metadata.HEIGHT";
    public static final String KEY_LOCATION_LATITUDE = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE";
    public static final String KEY_LOCATION_LONGITUDE = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE";
    public static final String KEY_LOCATION_NAME = "com.google.android.gms.cast.metadata.LOCATION_NAME";
    public static final String KEY_RELEASE_DATE = "com.google.android.gms.cast.metadata.RELEASE_DATE";
    public static final String KEY_SEASON_NUMBER = "com.google.android.gms.cast.metadata.SEASON_NUMBER";
    public static final String KEY_SERIES_TITLE = "com.google.android.gms.cast.metadata.SERIES_TITLE";
    public static final String KEY_STUDIO = "com.google.android.gms.cast.metadata.STUDIO";
    public static final String KEY_SUBTITLE = "com.google.android.gms.cast.metadata.SUBTITLE";
    public static final String KEY_TITLE = "com.google.android.gms.cast.metadata.TITLE";
    public static final String KEY_TRACK_NUMBER = "com.google.android.gms.cast.metadata.TRACK_NUMBER";
    public static final String KEY_WIDTH = "com.google.android.gms.cast.metadata.WIDTH";
    public static final int MEDIA_TYPE_GENERIC = 0;
    public static final int MEDIA_TYPE_MOVIE = 1;
    public static final int MEDIA_TYPE_MUSIC_TRACK = 3;
    public static final int MEDIA_TYPE_PHOTO = 4;
    public static final int MEDIA_TYPE_TV_SHOW = 2;
    public static final int MEDIA_TYPE_USER = 100;
    private final List<WebImage> Fp;
    private final Bundle Ge;
    private int Gf;

    private static class a {
        private final Map<String, String> Gg = new HashMap();
        private final Map<String, String> Gh = new HashMap();
        private final Map<String, Integer> Gi = new HashMap();

        public a a(String str, String str2, int i) {
            this.Gg.put(str, str2);
            this.Gh.put(str2, str);
            this.Gi.put(str, Integer.valueOf(i));
            return this;
        }

        public String aA(String str) {
            return (String) this.Gh.get(str);
        }

        public int aB(String str) {
            Integer num = (Integer) this.Gi.get(str);
            return num != null ? num.intValue() : 0;
        }

        public String az(String str) {
            return (String) this.Gg.get(str);
        }
    }

    public MediaMetadata() {
        this(0);
    }

    public MediaMetadata(int mediaType) {
        this.Fp = new ArrayList();
        this.Ge = new Bundle();
        this.Gf = mediaType;
    }

    private void a(JSONObject jSONObject, String... strArr) {
        try {
            for (String str : strArr) {
                if (this.Ge.containsKey(str)) {
                    switch (Gd.aB(str)) {
                        case 1:
                        case 4:
                            jSONObject.put(Gd.az(str), this.Ge.getString(str));
                            break;
                        case 2:
                            jSONObject.put(Gd.az(str), this.Ge.getInt(str));
                            break;
                        case 3:
                            jSONObject.put(Gd.az(str), this.Ge.getDouble(str));
                            break;
                        default:
                            break;
                    }
                }
            }
            for (String str2 : this.Ge.keySet()) {
                if (!str2.startsWith("com.google.")) {
                    Object obj = this.Ge.get(str2);
                    if (obj instanceof String) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Integer) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Double) {
                        jSONObject.put(str2, obj);
                    }
                }
            }
        } catch (JSONException e) {
        }
    }

    private boolean a(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !a((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
            if (obj == null) {
                if (obj2 != null || !bundle2.containsKey(str)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    private void b(JSONObject jSONObject, String... strArr) {
        Set hashSet = new HashSet(Arrays.asList(strArr));
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (!"metadataType".equals(str)) {
                    String aA = Gd.aA(str);
                    if (aA == null) {
                        Object obj = jSONObject.get(str);
                        if (obj instanceof String) {
                            this.Ge.putString(str, (String) obj);
                        } else if (obj instanceof Integer) {
                            this.Ge.putInt(str, ((Integer) obj).intValue());
                        } else if (obj instanceof Double) {
                            this.Ge.putDouble(str, ((Double) obj).doubleValue());
                        }
                    } else if (hashSet.contains(aA)) {
                        try {
                            Object obj2 = jSONObject.get(str);
                            if (obj2 != null) {
                                switch (Gd.aB(aA)) {
                                    case 1:
                                        if (!(obj2 instanceof String)) {
                                            break;
                                        }
                                        this.Ge.putString(aA, (String) obj2);
                                        break;
                                    case 2:
                                        if (!(obj2 instanceof Integer)) {
                                            break;
                                        }
                                        this.Ge.putInt(aA, ((Integer) obj2).intValue());
                                        break;
                                    case 3:
                                        if (!(obj2 instanceof Double)) {
                                            break;
                                        }
                                        this.Ge.putDouble(aA, ((Double) obj2).doubleValue());
                                        break;
                                    case 4:
                                        if ((obj2 instanceof String) && ix.aL((String) obj2) != null) {
                                            this.Ge.putString(aA, (String) obj2);
                                            break;
                                        }
                                    default:
                                        break;
                                }
                            }
                        } catch (JSONException e) {
                        }
                    }
                }
            }
        } catch (JSONException e2) {
        }
    }

    private void f(String str, int i) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("null and empty keys are not allowed");
        }
        int aB = Gd.aB(str);
        if (aB != i && aB != 0) {
            throw new IllegalArgumentException("Value for " + str + " must be a " + Gc[i]);
        }
    }

    public void addImage(WebImage image) {
        this.Fp.add(image);
    }

    public void c(JSONObject jSONObject) {
        clear();
        this.Gf = 0;
        try {
            this.Gf = jSONObject.getInt("metadataType");
        } catch (JSONException e) {
        }
        ix.a(this.Fp, jSONObject);
        switch (this.Gf) {
            case 0:
                b(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_SUBTITLE, KEY_RELEASE_DATE);
                return;
            case 1:
                b(jSONObject, KEY_TITLE, KEY_STUDIO, KEY_SUBTITLE, KEY_RELEASE_DATE);
                return;
            case 2:
                b(jSONObject, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
                return;
            case 3:
                b(jSONObject, KEY_TITLE, KEY_ALBUM_TITLE, KEY_ARTIST, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
                return;
            case 4:
                b(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
                return;
            default:
                b(jSONObject, new String[0]);
                return;
        }
    }

    public void clear() {
        this.Ge.clear();
        this.Fp.clear();
    }

    public void clearImages() {
        this.Fp.clear();
    }

    public boolean containsKey(String key) {
        return this.Ge.containsKey(key);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaMetadata)) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) other;
        return a(this.Ge, mediaMetadata.Ge) && this.Fp.equals(mediaMetadata.Fp);
    }

    public Calendar getDate(String key) {
        f(key, 4);
        String string = this.Ge.getString(key);
        return string != null ? ix.aL(string) : null;
    }

    public String getDateAsString(String key) {
        f(key, 4);
        return this.Ge.getString(key);
    }

    public double getDouble(String key) {
        f(key, 3);
        return this.Ge.getDouble(key);
    }

    public List<WebImage> getImages() {
        return this.Fp;
    }

    public int getInt(String key) {
        f(key, 2);
        return this.Ge.getInt(key);
    }

    public int getMediaType() {
        return this.Gf;
    }

    public String getString(String key) {
        f(key, 1);
        return this.Ge.getString(key);
    }

    public boolean hasImages() {
        return (this.Fp == null || this.Fp.isEmpty()) ? false : true;
    }

    public int hashCode() {
        int i = 17;
        for (String str : this.Ge.keySet()) {
            i *= 31;
            i = this.Ge.get(str).hashCode() + i;
        }
        return (i * 31) + this.Fp.hashCode();
    }

    public Set<String> keySet() {
        return this.Ge.keySet();
    }

    public void putDate(String key, Calendar value) {
        f(key, 4);
        this.Ge.putString(key, ix.a(value));
    }

    public void putDouble(String key, double value) {
        f(key, 3);
        this.Ge.putDouble(key, value);
    }

    public void putInt(String key, int value) {
        f(key, 2);
        this.Ge.putInt(key, value);
    }

    public void putString(String key, String value) {
        f(key, 1);
        this.Ge.putString(key, value);
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metadataType", this.Gf);
        } catch (JSONException e) {
        }
        ix.a(jSONObject, this.Fp);
        switch (this.Gf) {
            case 0:
                a(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_SUBTITLE, KEY_RELEASE_DATE);
                break;
            case 1:
                a(jSONObject, KEY_TITLE, KEY_STUDIO, KEY_SUBTITLE, KEY_RELEASE_DATE);
                break;
            case 2:
                a(jSONObject, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
                break;
            case 3:
                a(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_ALBUM_TITLE, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
                break;
            case 4:
                a(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
                break;
            default:
                a(jSONObject, new String[0]);
                break;
        }
        return jSONObject;
    }
}
