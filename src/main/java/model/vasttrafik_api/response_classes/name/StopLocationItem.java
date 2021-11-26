package model.vasttrafik_api.response_classes.name;

import com.google.gson.annotations.SerializedName;

public class StopLocationItem{

    @SerializedName("name")
    private String name;

    @SerializedName("weight")
    private String weight;

    @SerializedName("lon")
    private String lon;

    @SerializedName("id")
    private String id;

    @SerializedName("idx")
    private String idx;

    @SerializedName("track")
    private String track;

    @SerializedName("lat")
    private String lat;

    public String getName(){
        return name;
    }

    public String getWeight(){
        return weight;
    }

    public String getLon(){
        return lon;
    }

    public String getId(){
        return id;
    }

    public String getIdx(){
        return idx;
    }

    public String getTrack(){
        return track;
    }

    public String getLat(){
        return lat;
    }
}