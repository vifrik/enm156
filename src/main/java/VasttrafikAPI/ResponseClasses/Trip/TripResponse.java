package VasttrafikAPI.ResponseClasses.Trip;

import com.google.gson.annotations.SerializedName;

public class TripResponse{

    @SerializedName("TripList")
    private TripList tripList;

    public TripList getTripList(){
        return tripList;
    }
}