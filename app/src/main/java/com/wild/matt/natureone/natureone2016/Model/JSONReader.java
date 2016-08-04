package com.wild.matt.natureone.natureone2016.Model;

import android.content.Context;
import android.util.EventLog;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;
import android.util.SparseArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;

/**
 * Created by Matze on 03.08.2016.
 */
public class JSONReader {
    String TAG = "JSONReader";
    InputStream in;
    JsonReader reader;
    public JSONReader(Context context) {
        try {
            Log.d(TAG,"try to read from File");
            in = context.getAssets().open("mockdb.json");
            reader = new JsonReader(new InputStreamReader(in, "UTF-8"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }

    public SparseArray<Event> readEventList() throws IOException {

        SparseArray <Event> events = new SparseArray<>();
        String name="";
        try {
            reader.beginObject();
            name = reader.nextName();
            Log.d(TAG, "first NAME = "+name);
            reader.beginArray();
            while (reader.hasNext()){
                if (name.equals("events")) {
                    Event event = readEvent(reader);
                    events.put(event.getEvent_ID(), event);
                }
            }
            reader.endArray();
        } catch (IOException e){

        }
        return events;
    }
    public SparseArray<Floor> readFloorList() throws IOException {
        SparseArray <Floor> floors = new SparseArray<>();
        String name="";
            name = reader.nextName();
            Log.d(TAG, "READ FLOOR = "+name);
            reader.beginArray();
            while (reader.hasNext()){
                if (name.equals("floors")) {
                    Floor floor = readFloor(reader);
                    floors.put(floor.getFloor_ID(), floor);
                }
            }
            reader.endArray();
        return floors;
    }

    public SparseArray<Artist> readArtistList() throws IOException {
        SparseArray <Artist> artists = new SparseArray<>();
        String name="";
        name = reader.nextName();
        Log.d(TAG, "READ FLOOR = "+name);
        reader.beginArray();
        while (reader.hasNext()){
            if (name.equals("artists")) {
                Artist artist = readArtist(reader);
                artists.put(artist.getArtist_ID(), artist);
            }
        }
        return artists;
    }

    private Artist readArtist(JsonReader reader) throws IOException {
        //String name, String desc, int event_ID, String day, int hour, int minute, boolean isFav
        String Jname ="";
        String name ="";
        String place ="";
        String locale ="";
        String desc="";
        int artistID= 1;
        boolean isSpecial= false;
        reader.beginObject();
        while (reader.hasNext()) {
            Jname = reader.nextName();
            Log.d(TAG, "first NAME = "+Jname);
            if(Jname.equals("name"))
                name = reader.nextString();
            else if(Jname.equals("place")){
                place = reader.nextString();
            }
            else if(Jname.equals("locale")){
                locale = reader.nextString();
            }
            else if(Jname.equals("desc")){
                desc = reader.nextString();
            }
            else if(Jname.equals("artist_ID")){
                artistID = reader.nextInt();
            }
            else if(Jname.equals("is_special")){
                isSpecial = reader.nextBoolean();
            }
        }
        reader.endObject();
        return new Artist(name,place,locale, desc,artistID,isSpecial);
    }


    public Event readEvent(JsonReader reader) throws IOException {
        //String name, String desc, int event_ID, String day, int hour, int minute, boolean isFav
        String Jname ="";
        String name ="";
        String desc="";
        int eventID=1;
        int floorID=1;
        int[] artists ={1,2};
        String day = "sat";
        int startHour =20;
        int startMinute=30;
        int endHour =20;
        int endMinute=30;
        reader.beginObject();
        while (reader.hasNext()) {
            Jname = reader.nextName();
            Log.d(TAG, "first NAME = "+Jname);
            if(Jname.equals("name"))
                name = reader.nextString();
            else if(Jname.equals("desc")){
                desc = reader.nextString();
            }
            else if(Jname.equals("artists")){
                artists = readArtists(reader);
            }
            else if(Jname.equals("event_ID")){
                eventID = reader.nextInt();
            }
            else if(Jname.equals("floor_ID")){
                floorID = reader.nextInt();
            }
            else if(Jname.equals("day")){
                day = reader.nextString();
            } else if(Jname.equals("start-hour")){
                startHour = reader.nextInt();
            }
            else if(Jname.equals("start-minute")){
                startMinute = reader.nextInt();
            }else if(Jname.equals("end-hour")){
                endHour = reader.nextInt();
            }
            else if(Jname.equals("end-minute")){
                endMinute = reader.nextInt();
            }
        }
        reader.endObject();
        return new Event(name, desc,artists, eventID,floorID, day, startHour, startMinute, endHour,endMinute,false);
    }
    public Floor readFloor(JsonReader reader) throws IOException {
        //String name, String desc, int event_ID, String day, int hour, int minute, boolean isFav
        String Jname ="";
        String name ="";
        int floorID=1;
        reader.beginObject();
        while (reader.hasNext()) {
            Jname = reader.nextName();
            Log.d(TAG, "first NAME = "+Jname);
            if(Jname.equals("name"))
                name = reader.nextString();
            else if(Jname.equals("floor_ID")){
                floorID = reader.nextInt();
            }
        }
        reader.endObject();
        return new Floor(name, floorID);
    }
    private int[] readArtists(JsonReader reader) throws IOException {
        ArrayList<Integer> values = new ArrayList<Integer>();
        reader.beginArray();
        while (reader.hasNext()) {
            reader.beginObject();
            String Jname = reader.nextName();
            if(Jname.equals("artist_ID"))
                values.add(reader.nextInt());
            reader.endObject();
        }
        reader.endArray();
        int[] ret = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            ret[i]= values.get(i);
        }
        return ret;
    }



}
