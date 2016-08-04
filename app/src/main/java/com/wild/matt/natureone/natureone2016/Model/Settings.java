package com.wild.matt.natureone.natureone2016.Model;

/**
 * Created by Matze on 03.08.2016.
 */
public class Settings {
    private static Settings ourInstance = new Settings();

    public static Settings getInstance() {
        return ourInstance;
    }

    private Settings() {

    }
}
