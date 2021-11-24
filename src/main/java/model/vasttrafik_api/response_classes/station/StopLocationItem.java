package model.vasttrafik_api.response_classes.station;

import com.google.gson.annotations.SerializedName;

public class StopLocationItem {

    @SerializedName("name")
    private String name;

    @SerializedName("weight")
    private String weight;

    @SerializedName("lon")
    private String lon;

    @SerializedName("id")
    private String id;

    @SerializedName("track")
    private String track;

    @SerializedName("lat")
    private String lat;

    public String getName() {
        return name;
    }

    public String getWeight() {
        return weight;
    }

    public String getLon() {
        return lon;
    }

    public String getId() {
        return id;
    }

    public String getTrack() {
        return track;
    }

    public String getLat() {
        return lat;
    }

    @Override
    public String toString() {
        return
                "StopLocationItem{" +
                        "name = '" + name + '\'' +
                        ",weight = '" + weight + '\'' +
                        ",lon = '" + lon + '\'' +
                        ",id = '" + id + '\'' +
                        ",track = '" + track + '\'' +
                        ",lat = '" + lat + '\'' +
                        "}";
    }
}