package com.wild.matt.natureone.natureone2016.Model;

/**
 * Created by Matze on 03.08.2016.
 */
public class Artist {

    String name;
    String place;
    String locale;
    String desc;
    int artist_ID;
    boolean isSpecial;
    int pic_ID;

    public Artist(String name, String place, String locale, String desc, int artist_ID, boolean isSpecial) {
        this.name = name;
        this.place = place;
        this.locale = locale;
        this.desc = desc;
        this.artist_ID = artist_ID;
        this.isSpecial = isSpecial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getArtist_ID() {
        return artist_ID;
    }

    public void setArtist_ID(int artist_ID) {
        this.artist_ID = artist_ID;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public void setSpecial(boolean special) {
        isSpecial = special;
    }
}
