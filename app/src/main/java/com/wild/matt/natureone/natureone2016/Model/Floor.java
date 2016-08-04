package com.wild.matt.natureone.natureone2016.Model;

/**
 * Created by Matze on 03.08.2016.
 */
public class Floor {

    String name;
    int floor_ID;

    public Floor(String name, int floor_ID) {
        this.name = name;
        this.floor_ID = floor_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloor_ID() {
        return floor_ID;
    }

    public void setFloor_ID(int floor_ID) {
        this.floor_ID = floor_ID;
    }
}
