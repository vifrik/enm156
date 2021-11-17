package Vasttrafik.ResponseClasses.NearbyStops;

import com.google.gson.annotations.SerializedName;

public class StopLocationItem {
    @SerializedName("name")
    private String name;

    @SerializedName("lon")
    private String lon;

    @SerializedName("id")
    private String id;

    @SerializedName("lat")
    private String lat;

    @SerializedName("track")
    private String track;

    public String getName() {
        return name;
    }

    public String getLon() {
        return lon;
    }

    public String getId() {
        return id;
    }

    public String getLat() {
        return lat;
    }

    public String getTrack() {
        return track;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, id: %s, lon: %s, lat: %s, track: %s\n", name, id, lon, lat, track);
    }
}
