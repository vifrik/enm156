package model.vasttrafik_api.responseClasses.stationResponse;

import com.google.gson.annotations.SerializedName;

public class StationResponse {

    @SerializedName("LocationList")
    private LocationList locationList;

    public LocationList getLocationList() {
        return locationList;
    }

    @Override
    public String toString() {
        return
                "StationResponse{" +
                        "locationList = '" + locationList + '\'' +
                        "}";
    }
}