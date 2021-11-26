package model.vasttrafik_api.response_classes.nearby_stops;

import com.google.gson.annotations.SerializedName;

public class NearbyStopsResponse {
    @SerializedName("LocationList")
    private LocationList locationList;

    public LocationList getLocationList() {
        return locationList;
    }
}
