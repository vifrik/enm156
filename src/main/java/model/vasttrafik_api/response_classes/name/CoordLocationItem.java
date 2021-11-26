package model.vasttrafik_api.response_classes.name;

import com.google.gson.annotations.SerializedName;

public class CoordLocationItem{

    @SerializedName("name")
    private String name;

    @SerializedName("lon")
    private String lon;

    @SerializedName("idx")
    private String idx;

    @SerializedName("type")
    private String type;

    @SerializedName("lat")
    private String lat;

    public String getName(){
        return name;
    }

    public String getLon(){
        return lon;
    }

    public String getIdx(){
        return idx;
    }

    public String getType(){
        return type;
    }

    public String getLat(){
        return lat;
    }
}