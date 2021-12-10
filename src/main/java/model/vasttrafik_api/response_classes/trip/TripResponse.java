package model.vasttrafik_api.response_classes.trip;

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
        int index = 0;
        for (TripItem t : tripList.getTrips()) {
            sb.append("Trip: %s%n%s%n".formatted(index, t));
            index++;
        }
        return sb.toString();
    }
}