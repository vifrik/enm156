package model.vasttrafik_api.responseClasses.name;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class LocationList {

    @SerializedName("serverdate")
    private String serverdate;

    @SerializedName("servertime")
    private String servertime;

    @SerializedName("noNamespaceSchemaLocation")
    private String noNamespaceSchemaLocation;

    @SerializedName("StopLocation")
    private List<StopLocationItem> stopLocation;

    @SerializedName("CoordLocation")
    private List<CoordLocationItem> coordLocation;

    public String getServerdate() {
        return serverdate;
    }

    public String getServertime() {
        return servertime;
    }

    public String getNoNamespaceSchemaLocation() {
        return noNamespaceSchemaLocation;
    }

    public List<StopLocationItem> getStopLocation() {
        return stopLocation;
    }

    public List<CoordLocationItem> getCoordLocation() {
        return coordLocation;
    }
}