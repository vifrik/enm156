package model.vasttrafik_api.responseClasses.trip;

import com.google.gson.annotations.SerializedName;

public class TripResponse {

    @SerializedName("TripList")
    private TripList tripList;

    public TripList getTripList() {
        return tripList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (TripItem t : tripList.getTrips()) {
            sb.append(t);
            sb.append("\n");
        }
        return sb.toString();
    }
}