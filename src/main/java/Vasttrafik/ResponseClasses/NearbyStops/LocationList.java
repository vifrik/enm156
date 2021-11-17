package Vasttrafik.ResponseClasses.NearbyStops;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LocationList {
    @SerializedName("serverdate")
    private String serverDate;

    @SerializedName("servertime")
    private String serverTime;

    @SerializedName("noNamespaceSchemaLocation")
    private String noNamespaceSchemaLocation;

    @SerializedName("StopLocation")
    private List<StopLocationItem> stopLocations;

    public String getServerDate() {
        return serverDate;
    }

    public String getServerTime() {
        return serverTime;
    }

    public String getNoNamespaceSchemaLocation() {
        return noNamespaceSchemaLocation;
    }

    public List<StopLocationItem> getStopLocations() {
        return stopLocations;
    }
}