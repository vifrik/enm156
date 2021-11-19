package VasttrafikAPI.ResponseClasses.Name;

import com.google.gson.annotations.SerializedName;

public class NameResponse{

    @SerializedName("LocationList")
    private LocationList locationList;

    public LocationList getLocationList(){
        return locationList;
    }
}