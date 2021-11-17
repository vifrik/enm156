package Vasttrafik.ResponseClasses.NearbyStops;

import com.google.gson.annotations.SerializedName;

public class NearbyStopsResponse {
    @SerializedName("LocationList")
    private LocationList locationList;

    public LocationList getLocationList() {
        return locationList;
    }
}
