package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.pd;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface ItemScope extends Freezable<ItemScope> {

    public static class Builder {
        private String CE;
        private String UO;
        private double agg;
        private double agh;
        private String aoA;
        private pd aoB;
        private String aoC;
        private String aoD;
        private List<pd> aoE;
        private String aoF;
        private String aoG;
        private String aoH;
        private String aoI;
        private String aoJ;
        private String aoK;
        private String aoL;
        private String aoM;
        private pd aoN;
        private String aoO;
        private String aoP;
        private String aoQ;
        private pd aoR;
        private pd aoS;
        private pd aoT;
        private List<pd> aoU;
        private String aoV;
        private String aoW;
        private String aoX;
        private String aoY;
        private pd aoZ;
        private final Set<Integer> aon = new HashSet();
        private pd aoo;
        private List<String> aop;
        private pd aoq;
        private String aor;
        private String aos;
        private String aot;
        private List<pd> aou;
        private int aov;
        private List<pd> aow;
        private pd aox;
        private List<pd> aoy;
        private String aoz;
        private String apa;
        private String apb;
        private String apc;
        private pd apd;
        private String ape;
        private String apf;
        private String apg;
        private String aph;
        private String mName;
        private String ov;
        private String vc;
        private String vf;

        public ItemScope build() {
            return new pd(this.aon, this.aoo, this.aop, this.aoq, this.aor, this.aos, this.aot, this.aou, this.aov, this.aow, this.aox, this.aoy, this.aoz, this.aoA, this.aoB, this.aoC, this.aoD, this.ov, this.aoE, this.aoF, this.aoG, this.aoH, this.UO, this.aoI, this.aoJ, this.aoK, this.aoL, this.aoM, this.aoN, this.aoO, this.aoP, this.CE, this.aoQ, this.aoR, this.agg, this.aoS, this.agh, this.mName, this.aoT, this.aoU, this.aoV, this.aoW, this.aoX, this.aoY, this.aoZ, this.apa, this.apb, this.apc, this.apd, this.ape, this.apf, this.vc, this.vf, this.apg, this.aph);
        }

        public Builder setAbout(ItemScope about) {
            this.aoo = (pd) about;
            this.aon.add(Integer.valueOf(2));
            return this;
        }

        public Builder setAdditionalName(List<String> additionalName) {
            this.aop = additionalName;
            this.aon.add(Integer.valueOf(3));
            return this;
        }

        public Builder setAddress(ItemScope address) {
            this.aoq = (pd) address;
            this.aon.add(Integer.valueOf(4));
            return this;
        }

        public Builder setAddressCountry(String addressCountry) {
            this.aor = addressCountry;
            this.aon.add(Integer.valueOf(5));
            return this;
        }

        public Builder setAddressLocality(String addressLocality) {
            this.aos = addressLocality;
            this.aon.add(Integer.valueOf(6));
            return this;
        }

        public Builder setAddressRegion(String addressRegion) {
            this.aot = addressRegion;
            this.aon.add(Integer.valueOf(7));
            return this;
        }

        public Builder setAssociated_media(List<ItemScope> associated_media) {
            this.aou = associated_media;
            this.aon.add(Integer.valueOf(8));
            return this;
        }

        public Builder setAttendeeCount(int attendeeCount) {
            this.aov = attendeeCount;
            this.aon.add(Integer.valueOf(9));
            return this;
        }

        public Builder setAttendees(List<ItemScope> attendees) {
            this.aow = attendees;
            this.aon.add(Integer.valueOf(10));
            return this;
        }

        public Builder setAudio(ItemScope audio) {
            this.aox = (pd) audio;
            this.aon.add(Integer.valueOf(11));
            return this;
        }

        public Builder setAuthor(List<ItemScope> author) {
            this.aoy = author;
            this.aon.add(Integer.valueOf(12));
            return this;
        }

        public Builder setBestRating(String bestRating) {
            this.aoz = bestRating;
            this.aon.add(Integer.valueOf(13));
            return this;
        }

        public Builder setBirthDate(String birthDate) {
            this.aoA = birthDate;
            this.aon.add(Integer.valueOf(14));
            return this;
        }

        public Builder setByArtist(ItemScope byArtist) {
            this.aoB = (pd) byArtist;
            this.aon.add(Integer.valueOf(15));
            return this;
        }

        public Builder setCaption(String caption) {
            this.aoC = caption;
            this.aon.add(Integer.valueOf(16));
            return this;
        }

        public Builder setContentSize(String contentSize) {
            this.aoD = contentSize;
            this.aon.add(Integer.valueOf(17));
            return this;
        }

        public Builder setContentUrl(String contentUrl) {
            this.ov = contentUrl;
            this.aon.add(Integer.valueOf(18));
            return this;
        }

        public Builder setContributor(List<ItemScope> contributor) {
            this.aoE = contributor;
            this.aon.add(Integer.valueOf(19));
            return this;
        }

        public Builder setDateCreated(String dateCreated) {
            this.aoF = dateCreated;
            this.aon.add(Integer.valueOf(20));
            return this;
        }

        public Builder setDateModified(String dateModified) {
            this.aoG = dateModified;
            this.aon.add(Integer.valueOf(21));
            return this;
        }

        public Builder setDatePublished(String datePublished) {
            this.aoH = datePublished;
            this.aon.add(Integer.valueOf(22));
            return this;
        }

        public Builder setDescription(String description) {
            this.UO = description;
            this.aon.add(Integer.valueOf(23));
            return this;
        }

        public Builder setDuration(String duration) {
            this.aoI = duration;
            this.aon.add(Integer.valueOf(24));
            return this;
        }

        public Builder setEmbedUrl(String embedUrl) {
            this.aoJ = embedUrl;
            this.aon.add(Integer.valueOf(25));
            return this;
        }

        public Builder setEndDate(String endDate) {
            this.aoK = endDate;
            this.aon.add(Integer.valueOf(26));
            return this;
        }

        public Builder setFamilyName(String familyName) {
            this.aoL = familyName;
            this.aon.add(Integer.valueOf(27));
            return this;
        }

        public Builder setGender(String gender) {
            this.aoM = gender;
            this.aon.add(Integer.valueOf(28));
            return this;
        }

        public Builder setGeo(ItemScope geo) {
            this.aoN = (pd) geo;
            this.aon.add(Integer.valueOf(29));
            return this;
        }

        public Builder setGivenName(String givenName) {
            this.aoO = givenName;
            this.aon.add(Integer.valueOf(30));
            return this;
        }

        public Builder setHeight(String height) {
            this.aoP = height;
            this.aon.add(Integer.valueOf(31));
            return this;
        }

        public Builder setId(String id) {
            this.CE = id;
            this.aon.add(Integer.valueOf(32));
            return this;
        }

        public Builder setImage(String image) {
            this.aoQ = image;
            this.aon.add(Integer.valueOf(33));
            return this;
        }

        public Builder setInAlbum(ItemScope inAlbum) {
            this.aoR = (pd) inAlbum;
            this.aon.add(Integer.valueOf(34));
            return this;
        }

        public Builder setLatitude(double latitude) {
            this.agg = latitude;
            this.aon.add(Integer.valueOf(36));
            return this;
        }

        public Builder setLocation(ItemScope location) {
            this.aoS = (pd) location;
            this.aon.add(Integer.valueOf(37));
            return this;
        }

        public Builder setLongitude(double longitude) {
            this.agh = longitude;
            this.aon.add(Integer.valueOf(38));
            return this;
        }

        public Builder setName(String name) {
            this.mName = name;
            this.aon.add(Integer.valueOf(39));
            return this;
        }

        public Builder setPartOfTVSeries(ItemScope partOfTVSeries) {
            this.aoT = (pd) partOfTVSeries;
            this.aon.add(Integer.valueOf(40));
            return this;
        }

        public Builder setPerformers(List<ItemScope> performers) {
            this.aoU = performers;
            this.aon.add(Integer.valueOf(41));
            return this;
        }

        public Builder setPlayerType(String playerType) {
            this.aoV = playerType;
            this.aon.add(Integer.valueOf(42));
            return this;
        }

        public Builder setPostOfficeBoxNumber(String postOfficeBoxNumber) {
            this.aoW = postOfficeBoxNumber;
            this.aon.add(Integer.valueOf(43));
            return this;
        }

        public Builder setPostalCode(String postalCode) {
            this.aoX = postalCode;
            this.aon.add(Integer.valueOf(44));
            return this;
        }

        public Builder setRatingValue(String ratingValue) {
            this.aoY = ratingValue;
            this.aon.add(Integer.valueOf(45));
            return this;
        }

        public Builder setReviewRating(ItemScope reviewRating) {
            this.aoZ = (pd) reviewRating;
            this.aon.add(Integer.valueOf(46));
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.apa = startDate;
            this.aon.add(Integer.valueOf(47));
            return this;
        }

        public Builder setStreetAddress(String streetAddress) {
            this.apb = streetAddress;
            this.aon.add(Integer.valueOf(48));
            return this;
        }

        public Builder setText(String text) {
            this.apc = text;
            this.aon.add(Integer.valueOf(49));
            return this;
        }

        public Builder setThumbnail(ItemScope thumbnail) {
            this.apd = (pd) thumbnail;
            this.aon.add(Integer.valueOf(50));
            return this;
        }

        public Builder setThumbnailUrl(String thumbnailUrl) {
            this.ape = thumbnailUrl;
            this.aon.add(Integer.valueOf(51));
            return this;
        }

        public Builder setTickerSymbol(String tickerSymbol) {
            this.apf = tickerSymbol;
            this.aon.add(Integer.valueOf(52));
            return this;
        }

        public Builder setType(String type) {
            this.vc = type;
            this.aon.add(Integer.valueOf(53));
            return this;
        }

        public Builder setUrl(String url) {
            this.vf = url;
            this.aon.add(Integer.valueOf(54));
            return this;
        }

        public Builder setWidth(String width) {
            this.apg = width;
            this.aon.add(Integer.valueOf(55));
            return this;
        }

        public Builder setWorstRating(String worstRating) {
            this.aph = worstRating;
            this.aon.add(Integer.valueOf(56));
            return this;
        }
    }

    ItemScope getAbout();

    List<String> getAdditionalName();

    ItemScope getAddress();

    String getAddressCountry();

    String getAddressLocality();

    String getAddressRegion();

    List<ItemScope> getAssociated_media();

    int getAttendeeCount();

    List<ItemScope> getAttendees();

    ItemScope getAudio();

    List<ItemScope> getAuthor();

    String getBestRating();

    String getBirthDate();

    ItemScope getByArtist();

    String getCaption();

    String getContentSize();

    String getContentUrl();

    List<ItemScope> getContributor();

    String getDateCreated();

    String getDateModified();

    String getDatePublished();

    String getDescription();

    String getDuration();

    String getEmbedUrl();

    String getEndDate();

    String getFamilyName();

    String getGender();

    ItemScope getGeo();

    String getGivenName();

    String getHeight();

    String getId();

    String getImage();

    ItemScope getInAlbum();

    double getLatitude();

    ItemScope getLocation();

    double getLongitude();

    String getName();

    ItemScope getPartOfTVSeries();

    List<ItemScope> getPerformers();

    String getPlayerType();

    String getPostOfficeBoxNumber();

    String getPostalCode();

    String getRatingValue();

    ItemScope getReviewRating();

    String getStartDate();

    String getStreetAddress();

    String getText();

    ItemScope getThumbnail();

    String getThumbnailUrl();

    String getTickerSymbol();

    String getType();

    String getUrl();

    String getWidth();

    String getWorstRating();

    boolean hasAbout();

    boolean hasAdditionalName();

    boolean hasAddress();

    boolean hasAddressCountry();

    boolean hasAddressLocality();

    boolean hasAddressRegion();

    boolean hasAssociated_media();

    boolean hasAttendeeCount();

    boolean hasAttendees();

    boolean hasAudio();

    boolean hasAuthor();

    boolean hasBestRating();

    boolean hasBirthDate();

    boolean hasByArtist();

    boolean hasCaption();

    boolean hasContentSize();

    boolean hasContentUrl();

    boolean hasContributor();

    boolean hasDateCreated();

    boolean hasDateModified();

    boolean hasDatePublished();

    boolean hasDescription();

    boolean hasDuration();

    boolean hasEmbedUrl();

    boolean hasEndDate();

    boolean hasFamilyName();

    boolean hasGender();

    boolean hasGeo();

    boolean hasGivenName();

    boolean hasHeight();

    boolean hasId();

    boolean hasImage();

    boolean hasInAlbum();

    boolean hasLatitude();

    boolean hasLocation();

    boolean hasLongitude();

    boolean hasName();

    boolean hasPartOfTVSeries();

    boolean hasPerformers();

    boolean hasPlayerType();

    boolean hasPostOfficeBoxNumber();

    boolean hasPostalCode();

    boolean hasRatingValue();

    boolean hasReviewRating();

    boolean hasStartDate();

    boolean hasStreetAddress();

    boolean hasText();

    boolean hasThumbnail();

    boolean hasThumbnailUrl();

    boolean hasTickerSymbol();

    boolean hasType();

    boolean hasUrl();

    boolean hasWidth();

    boolean hasWorstRating();
}
