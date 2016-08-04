package com.wild.matt.natureone.natureone2016.Model;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.util.SparseArray;

import com.wild.matt.natureone.natureone2016.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Matze on 03.08.2016.
 */
public class MockDB {
    String TAG = "MockDB";
     static SparseArray<Floor> floors =new SparseArray<Floor>();
    static SparseArray<Club> clubs=new SparseArray<Club>();
    static SparseArray <Event> events =new SparseArray<Event>();
    static SparseArray <Artist> artists =new SparseArray<Artist>();

    JSONReader jsonReader;

    public MockDB(Context context) {
        jsonReader = new JSONReader(context);
        clubs = new SparseArray<Club>();
        try {
            Log.d(TAG, "try to read from file");
            //DELETE JSONREADer omq, shitty as fuck this thing
            events = jsonReader.readEventList();
            floors = jsonReader.readFloorList();
            artists = jsonReader.readArtistList();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static public SparseArray<Event> getEvents() {
        return events;
    }

    public static SparseArray<Floor> getFloors() {
        return floors;
    }
}
