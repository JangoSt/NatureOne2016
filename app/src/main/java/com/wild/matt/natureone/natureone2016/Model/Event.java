package com.wild.matt.natureone.natureone2016.Model;

import java.util.Date;

/**
 * Created by Matze on 03.08.2016.
 */
public class Event {

    String name;
    String desc;
    int [] artists;
    int event_ID;
    int floor_ID;
    String day;
    int startHour;
    int startMinute;
    int endMinute;
    int endHour;
    boolean isFav;
    int pic_ID;

    public Event(String name, String desc, int[] artists, int event_ID, int floor_ID, String day, int startHour, int startMinute, int endMinute, int endHour, boolean isFav) {
        this.name = name;
        this.desc = desc;
        this.artists = artists;
        this.event_ID = event_ID;
        this.floor_ID = floor_ID;
        this.day = day;
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endMinute = endMinute;
        this.endHour = endHour;
        this.isFav = isFav;
    }

    public int[] getArtists() {
        return artists;
    }

    public void setArtists(int[] artists) {
        this.artists = artists;
    }

    public int getFloor_ID() {
        return floor_ID;
    }

    public void setFloor_ID(int floor_ID) {
        this.floor_ID = floor_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getEvent_ID() {
        return event_ID;
    }

    public void setEvent_ID(int event_ID) {
        this.event_ID = event_ID;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
    }

    public int getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(int endMinute) {
        this.endMinute = endMinute;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public boolean isFav() {
        return isFav;
    }

    public void setFav(boolean fav) {
        isFav = fav;
    }

    public int getPic_ID() {
        return pic_ID;
    }

    public void setPic_ID(int pic_ID) {
        this.pic_ID = pic_ID;
    }
}


