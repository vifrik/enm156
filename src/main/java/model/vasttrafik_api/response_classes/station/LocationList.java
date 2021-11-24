package model.vasttrafik_api.response_classes.station;

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

    @Override
    public String toString() {
        return
                "LocationList{" +
                        "serverdate = '" + serverdate + '\'' +
                        ",servertime = '" + servertime + '\'' +
                        ",noNamespaceSchemaLocation = '" + noNamespaceSchemaLocation + '\'' +
                        ",stopLocation = '" + stopLocation + '\'' +
                        "}";
    }
}