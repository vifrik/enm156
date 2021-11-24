package model.vasttrafik_api.response_classes.name;

import com.google.gson.annotations.SerializedName;

public class NameResponse {

    @SerializedName("LocationList")
    private LocationList locationList;

    public LocationList getLocationList() {
        return locationList;
    }
}