package com.google.android.gms.internal;

import android.os.Parcel;
import android.support.v4.util.TimeUtils;
import com.google.ads.AdSize;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.internal.kr.a;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class pd extends ks implements ItemScope {
    public static final pe CREATOR = new pe();
    private static final HashMap<String, a<?, ?>> aom = new HashMap();
    String CE;
    final int CK;
    String UO;
    double agg;
    double agh;
    String aoA;
    pd aoB;
    String aoC;
    String aoD;
    List<pd> aoE;
    String aoF;
    String aoG;
    String aoH;
    String aoI;
    String aoJ;
    String aoK;
    String aoL;
    String aoM;
    pd aoN;
    String aoO;
    String aoP;
    String aoQ;
    pd aoR;
    pd aoS;
    pd aoT;
    List<pd> aoU;
    String aoV;
    String aoW;
    String aoX;
    String aoY;
    pd aoZ;
    final Set<Integer> aon;
    pd aoo;
    List<String> aop;
    pd aoq;
    String aor;
    String aos;
    String aot;
    List<pd> aou;
    int aov;
    List<pd> aow;
    pd aox;
    List<pd> aoy;
    String aoz;
    String apa;
    String apb;
    String apc;
    pd apd;
    String ape;
    String apf;
    String apg;
    String aph;
    String mName;
    String ov;
    String vc;
    String vf;

    static {
        aom.put("about", a.a("about", 2, pd.class));
        aom.put("additionalName", a.m("additionalName", 3));
        aom.put("address", a.a("address", 4, pd.class));
        aom.put("addressCountry", a.l("addressCountry", 5));
        aom.put("addressLocality", a.l("addressLocality", 6));
        aom.put("addressRegion", a.l("addressRegion", 7));
        aom.put("associated_media", a.b("associated_media", 8, pd.class));
        aom.put("attendeeCount", a.i("attendeeCount", 9));
        aom.put("attendees", a.b("attendees", 10, pd.class));
        aom.put("audio", a.a("audio", 11, pd.class));
        aom.put("author", a.b("author", 12, pd.class));
        aom.put("bestRating", a.l("bestRating", 13));
        aom.put("birthDate", a.l("birthDate", 14));
        aom.put("byArtist", a.a("byArtist", 15, pd.class));
        aom.put("caption", a.l("caption", 16));
        aom.put("contentSize", a.l("contentSize", 17));
        aom.put("contentUrl", a.l("contentUrl", 18));
        aom.put("contributor", a.b("contributor", 19, pd.class));
        aom.put("dateCreated", a.l("dateCreated", 20));
        aom.put("dateModified", a.l("dateModified", 21));
        aom.put("datePublished", a.l("datePublished", 22));
        aom.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, a.l(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 23));
        aom.put("duration", a.l("duration", 24));
        aom.put("embedUrl", a.l("embedUrl", 25));
        aom.put("endDate", a.l("endDate", 26));
        aom.put("familyName", a.l("familyName", 27));
        aom.put("gender", a.l("gender", 28));
        aom.put("geo", a.a("geo", 29, pd.class));
        aom.put("givenName", a.l("givenName", 30));
        aom.put("height", a.l("height", 31));
        aom.put("id", a.l("id", 32));
        aom.put("image", a.l("image", 33));
        aom.put("inAlbum", a.a("inAlbum", 34, pd.class));
        aom.put("latitude", a.j("latitude", 36));
        aom.put("location", a.a("location", 37, pd.class));
        aom.put("longitude", a.j("longitude", 38));
        aom.put("name", a.l("name", 39));
        aom.put("partOfTVSeries", a.a("partOfTVSeries", 40, pd.class));
        aom.put("performers", a.b("performers", 41, pd.class));
        aom.put("playerType", a.l("playerType", 42));
        aom.put("postOfficeBoxNumber", a.l("postOfficeBoxNumber", 43));
        aom.put("postalCode", a.l("postalCode", 44));
        aom.put("ratingValue", a.l("ratingValue", 45));
        aom.put("reviewRating", a.a("reviewRating", 46, pd.class));
        aom.put("startDate", a.l("startDate", 47));
        aom.put("streetAddress", a.l("streetAddress", 48));
        aom.put("text", a.l("text", 49));
        aom.put("thumbnail", a.a("thumbnail", 50, pd.class));
        aom.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, a.l(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, 51));
        aom.put("tickerSymbol", a.l("tickerSymbol", 52));
        aom.put("type", a.l("type", 53));
        aom.put(PlusShare.KEY_CALL_TO_ACTION_URL, a.l(PlusShare.KEY_CALL_TO_ACTION_URL, 54));
        aom.put("width", a.l("width", 55));
        aom.put("worstRating", a.l("worstRating", 56));
    }

    public pd() {
        this.CK = 1;
        this.aon = new HashSet();
    }

    pd(Set<Integer> set, int i, pd pdVar, List<String> list, pd pdVar2, String str, String str2, String str3, List<pd> list2, int i2, List<pd> list3, pd pdVar3, List<pd> list4, String str4, String str5, pd pdVar4, String str6, String str7, String str8, List<pd> list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, pd pdVar5, String str18, String str19, String str20, String str21, pd pdVar6, double d, pd pdVar7, double d2, String str22, pd pdVar8, List<pd> list6, String str23, String str24, String str25, String str26, pd pdVar9, String str27, String str28, String str29, pd pdVar10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.aon = set;
        this.CK = i;
        this.aoo = pdVar;
        this.aop = list;
        this.aoq = pdVar2;
        this.aor = str;
        this.aos = str2;
        this.aot = str3;
        this.aou = list2;
        this.aov = i2;
        this.aow = list3;
        this.aox = pdVar3;
        this.aoy = list4;
        this.aoz = str4;
        this.aoA = str5;
        this.aoB = pdVar4;
        this.aoC = str6;
        this.aoD = str7;
        this.ov = str8;
        this.aoE = list5;
        this.aoF = str9;
        this.aoG = str10;
        this.aoH = str11;
        this.UO = str12;
        this.aoI = str13;
        this.aoJ = str14;
        this.aoK = str15;
        this.aoL = str16;
        this.aoM = str17;
        this.aoN = pdVar5;
        this.aoO = str18;
        this.aoP = str19;
        this.CE = str20;
        this.aoQ = str21;
        this.aoR = pdVar6;
        this.agg = d;
        this.aoS = pdVar7;
        this.agh = d2;
        this.mName = str22;
        this.aoT = pdVar8;
        this.aoU = list6;
        this.aoV = str23;
        this.aoW = str24;
        this.aoX = str25;
        this.aoY = str26;
        this.aoZ = pdVar9;
        this.apa = str27;
        this.apb = str28;
        this.apc = str29;
        this.apd = pdVar10;
        this.ape = str30;
        this.apf = str31;
        this.vc = str32;
        this.vf = str33;
        this.apg = str34;
        this.aph = str35;
    }

    public pd(Set<Integer> set, pd pdVar, List<String> list, pd pdVar2, String str, String str2, String str3, List<pd> list2, int i, List<pd> list3, pd pdVar3, List<pd> list4, String str4, String str5, pd pdVar4, String str6, String str7, String str8, List<pd> list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, pd pdVar5, String str18, String str19, String str20, String str21, pd pdVar6, double d, pd pdVar7, double d2, String str22, pd pdVar8, List<pd> list6, String str23, String str24, String str25, String str26, pd pdVar9, String str27, String str28, String str29, pd pdVar10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.aon = set;
        this.CK = 1;
        this.aoo = pdVar;
        this.aop = list;
        this.aoq = pdVar2;
        this.aor = str;
        this.aos = str2;
        this.aot = str3;
        this.aou = list2;
        this.aov = i;
        this.aow = list3;
        this.aox = pdVar3;
        this.aoy = list4;
        this.aoz = str4;
        this.aoA = str5;
        this.aoB = pdVar4;
        this.aoC = str6;
        this.aoD = str7;
        this.ov = str8;
        this.aoE = list5;
        this.aoF = str9;
        this.aoG = str10;
        this.aoH = str11;
        this.UO = str12;
        this.aoI = str13;
        this.aoJ = str14;
        this.aoK = str15;
        this.aoL = str16;
        this.aoM = str17;
        this.aoN = pdVar5;
        this.aoO = str18;
        this.aoP = str19;
        this.CE = str20;
        this.aoQ = str21;
        this.aoR = pdVar6;
        this.agg = d;
        this.aoS = pdVar7;
        this.agh = d2;
        this.mName = str22;
        this.aoT = pdVar8;
        this.aoU = list6;
        this.aoV = str23;
        this.aoW = str24;
        this.aoX = str25;
        this.aoY = str26;
        this.aoZ = pdVar9;
        this.apa = str27;
        this.apb = str28;
        this.apc = str29;
        this.apd = pdVar10;
        this.ape = str30;
        this.apf = str31;
        this.vc = str32;
        this.vf = str33;
        this.apg = str34;
        this.aph = str35;
    }

    protected boolean a(a aVar) {
        return this.aon.contains(Integer.valueOf(aVar.hR()));
    }

    protected Object b(a aVar) {
        switch (aVar.hR()) {
            case 2:
                return this.aoo;
            case 3:
                return this.aop;
            case 4:
                return this.aoq;
            case 5:
                return this.aor;
            case 6:
                return this.aos;
            case 7:
                return this.aot;
            case 8:
                return this.aou;
            case 9:
                return Integer.valueOf(this.aov);
            case 10:
                return this.aow;
            case 11:
                return this.aox;
            case 12:
                return this.aoy;
            case 13:
                return this.aoz;
            case 14:
                return this.aoA;
            case 15:
                return this.aoB;
            case 16:
                return this.aoC;
            case 17:
                return this.aoD;
            case 18:
                return this.ov;
            case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                return this.aoE;
            case 20:
                return this.aoF;
            case 21:
                return this.aoG;
            case 22:
                return this.aoH;
            case 23:
                return this.UO;
            case 24:
                return this.aoI;
            case 25:
                return this.aoJ;
            case 26:
                return this.aoK;
            case 27:
                return this.aoL;
            case 28:
                return this.aoM;
            case 29:
                return this.aoN;
            case 30:
                return this.aoO;
            case Notifications.NOTIFICATION_TYPES_ALL /*31*/:
                return this.aoP;
            case 32:
                return this.CE;
            case 33:
                return this.aoQ;
            case 34:
                return this.aoR;
            case 36:
                return Double.valueOf(this.agg);
            case 37:
                return this.aoS;
            case 38:
                return Double.valueOf(this.agh);
            case 39:
                return this.mName;
            case 40:
                return this.aoT;
            case 41:
                return this.aoU;
            case 42:
                return this.aoV;
            case 43:
                return this.aoW;
            case 44:
                return this.aoX;
            case 45:
                return this.aoY;
            case 46:
                return this.aoZ;
            case 47:
                return this.apa;
            case 48:
                return this.apb;
            case 49:
                return this.apc;
            case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                return this.apd;
            case 51:
                return this.ape;
            case 52:
                return this.apf;
            case 53:
                return this.vc;
            case 54:
                return this.vf;
            case 55:
                return this.apg;
            case 56:
                return this.aph;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + aVar.hR());
        }
    }

    public int describeContents() {
        pe peVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof pd)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        pd pdVar = (pd) obj;
        for (a aVar : aom.values()) {
            if (a(aVar)) {
                if (!pdVar.a(aVar)) {
                    return false;
                }
                if (!b(aVar).equals(pdVar.b(aVar))) {
                    return false;
                }
            } else if (pdVar.a(aVar)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return oI();
    }

    public ItemScope getAbout() {
        return this.aoo;
    }

    public List<String> getAdditionalName() {
        return this.aop;
    }

    public ItemScope getAddress() {
        return this.aoq;
    }

    public String getAddressCountry() {
        return this.aor;
    }

    public String getAddressLocality() {
        return this.aos;
    }

    public String getAddressRegion() {
        return this.aot;
    }

    public List<ItemScope> getAssociated_media() {
        return (ArrayList) this.aou;
    }

    public int getAttendeeCount() {
        return this.aov;
    }

    public List<ItemScope> getAttendees() {
        return (ArrayList) this.aow;
    }

    public ItemScope getAudio() {
        return this.aox;
    }

    public List<ItemScope> getAuthor() {
        return (ArrayList) this.aoy;
    }

    public String getBestRating() {
        return this.aoz;
    }

    public String getBirthDate() {
        return this.aoA;
    }

    public ItemScope getByArtist() {
        return this.aoB;
    }

    public String getCaption() {
        return this.aoC;
    }

    public String getContentSize() {
        return this.aoD;
    }

    public String getContentUrl() {
        return this.ov;
    }

    public List<ItemScope> getContributor() {
        return (ArrayList) this.aoE;
    }

    public String getDateCreated() {
        return this.aoF;
    }

    public String getDateModified() {
        return this.aoG;
    }

    public String getDatePublished() {
        return this.aoH;
    }

    public String getDescription() {
        return this.UO;
    }

    public String getDuration() {
        return this.aoI;
    }

    public String getEmbedUrl() {
        return this.aoJ;
    }

    public String getEndDate() {
        return this.aoK;
    }

    public String getFamilyName() {
        return this.aoL;
    }

    public String getGender() {
        return this.aoM;
    }

    public ItemScope getGeo() {
        return this.aoN;
    }

    public String getGivenName() {
        return this.aoO;
    }

    public String getHeight() {
        return this.aoP;
    }

    public String getId() {
        return this.CE;
    }

    public String getImage() {
        return this.aoQ;
    }

    public ItemScope getInAlbum() {
        return this.aoR;
    }

    public double getLatitude() {
        return this.agg;
    }

    public ItemScope getLocation() {
        return this.aoS;
    }

    public double getLongitude() {
        return this.agh;
    }

    public String getName() {
        return this.mName;
    }

    public ItemScope getPartOfTVSeries() {
        return this.aoT;
    }

    public List<ItemScope> getPerformers() {
        return (ArrayList) this.aoU;
    }

    public String getPlayerType() {
        return this.aoV;
    }

    public String getPostOfficeBoxNumber() {
        return this.aoW;
    }

    public String getPostalCode() {
        return this.aoX;
    }

    public String getRatingValue() {
        return this.aoY;
    }

    public ItemScope getReviewRating() {
        return this.aoZ;
    }

    public String getStartDate() {
        return this.apa;
    }

    public String getStreetAddress() {
        return this.apb;
    }

    public String getText() {
        return this.apc;
    }

    public ItemScope getThumbnail() {
        return this.apd;
    }

    public String getThumbnailUrl() {
        return this.ape;
    }

    public String getTickerSymbol() {
        return this.apf;
    }

    public String getType() {
        return this.vc;
    }

    public String getUrl() {
        return this.vf;
    }

    public String getWidth() {
        return this.apg;
    }

    public String getWorstRating() {
        return this.aph;
    }

    public HashMap<String, a<?, ?>> hK() {
        return aom;
    }

    public boolean hasAbout() {
        return this.aon.contains(Integer.valueOf(2));
    }

    public boolean hasAdditionalName() {
        return this.aon.contains(Integer.valueOf(3));
    }

    public boolean hasAddress() {
        return this.aon.contains(Integer.valueOf(4));
    }

    public boolean hasAddressCountry() {
        return this.aon.contains(Integer.valueOf(5));
    }

    public boolean hasAddressLocality() {
        return this.aon.contains(Integer.valueOf(6));
    }

    public boolean hasAddressRegion() {
        return this.aon.contains(Integer.valueOf(7));
    }

    public boolean hasAssociated_media() {
        return this.aon.contains(Integer.valueOf(8));
    }

    public boolean hasAttendeeCount() {
        return this.aon.contains(Integer.valueOf(9));
    }

    public boolean hasAttendees() {
        return this.aon.contains(Integer.valueOf(10));
    }

    public boolean hasAudio() {
        return this.aon.contains(Integer.valueOf(11));
    }

    public boolean hasAuthor() {
        return this.aon.contains(Integer.valueOf(12));
    }

    public boolean hasBestRating() {
        return this.aon.contains(Integer.valueOf(13));
    }

    public boolean hasBirthDate() {
        return this.aon.contains(Integer.valueOf(14));
    }

    public boolean hasByArtist() {
        return this.aon.contains(Integer.valueOf(15));
    }

    public boolean hasCaption() {
        return this.aon.contains(Integer.valueOf(16));
    }

    public boolean hasContentSize() {
        return this.aon.contains(Integer.valueOf(17));
    }

    public boolean hasContentUrl() {
        return this.aon.contains(Integer.valueOf(18));
    }

    public boolean hasContributor() {
        return this.aon.contains(Integer.valueOf(19));
    }

    public boolean hasDateCreated() {
        return this.aon.contains(Integer.valueOf(20));
    }

    public boolean hasDateModified() {
        return this.aon.contains(Integer.valueOf(21));
    }

    public boolean hasDatePublished() {
        return this.aon.contains(Integer.valueOf(22));
    }

    public boolean hasDescription() {
        return this.aon.contains(Integer.valueOf(23));
    }

    public boolean hasDuration() {
        return this.aon.contains(Integer.valueOf(24));
    }

    public boolean hasEmbedUrl() {
        return this.aon.contains(Integer.valueOf(25));
    }

    public boolean hasEndDate() {
        return this.aon.contains(Integer.valueOf(26));
    }

    public boolean hasFamilyName() {
        return this.aon.contains(Integer.valueOf(27));
    }

    public boolean hasGender() {
        return this.aon.contains(Integer.valueOf(28));
    }

    public boolean hasGeo() {
        return this.aon.contains(Integer.valueOf(29));
    }

    public boolean hasGivenName() {
        return this.aon.contains(Integer.valueOf(30));
    }

    public boolean hasHeight() {
        return this.aon.contains(Integer.valueOf(31));
    }

    public boolean hasId() {
        return this.aon.contains(Integer.valueOf(32));
    }

    public boolean hasImage() {
        return this.aon.contains(Integer.valueOf(33));
    }

    public boolean hasInAlbum() {
        return this.aon.contains(Integer.valueOf(34));
    }

    public boolean hasLatitude() {
        return this.aon.contains(Integer.valueOf(36));
    }

    public boolean hasLocation() {
        return this.aon.contains(Integer.valueOf(37));
    }

    public boolean hasLongitude() {
        return this.aon.contains(Integer.valueOf(38));
    }

    public boolean hasName() {
        return this.aon.contains(Integer.valueOf(39));
    }

    public boolean hasPartOfTVSeries() {
        return this.aon.contains(Integer.valueOf(40));
    }

    public boolean hasPerformers() {
        return this.aon.contains(Integer.valueOf(41));
    }

    public boolean hasPlayerType() {
        return this.aon.contains(Integer.valueOf(42));
    }

    public boolean hasPostOfficeBoxNumber() {
        return this.aon.contains(Integer.valueOf(43));
    }

    public boolean hasPostalCode() {
        return this.aon.contains(Integer.valueOf(44));
    }

    public boolean hasRatingValue() {
        return this.aon.contains(Integer.valueOf(45));
    }

    public boolean hasReviewRating() {
        return this.aon.contains(Integer.valueOf(46));
    }

    public boolean hasStartDate() {
        return this.aon.contains(Integer.valueOf(47));
    }

    public boolean hasStreetAddress() {
        return this.aon.contains(Integer.valueOf(48));
    }

    public boolean hasText() {
        return this.aon.contains(Integer.valueOf(49));
    }

    public boolean hasThumbnail() {
        return this.aon.contains(Integer.valueOf(50));
    }

    public boolean hasThumbnailUrl() {
        return this.aon.contains(Integer.valueOf(51));
    }

    public boolean hasTickerSymbol() {
        return this.aon.contains(Integer.valueOf(52));
    }

    public boolean hasType() {
        return this.aon.contains(Integer.valueOf(53));
    }

    public boolean hasUrl() {
        return this.aon.contains(Integer.valueOf(54));
    }

    public boolean hasWidth() {
        return this.aon.contains(Integer.valueOf(55));
    }

    public boolean hasWorstRating() {
        return this.aon.contains(Integer.valueOf(56));
    }

    public int hashCode() {
        int i = 0;
        for (a aVar : aom.values()) {
            int hashCode;
            if (a(aVar)) {
                hashCode = b(aVar).hashCode() + (i + aVar.hR());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    public pd oI() {
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        pe peVar = CREATOR;
        pe.a(this, out, flags);
    }
}
