package VasttrafikAPI.ResponseClasses.Trip;

import VasttrafikAPI.StationWeight;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class TripList {

    @SerializedName("serverdate")
    private String serverdate;

    @SerializedName("Trip")
    private List<TripItem> trips;

    @SerializedName("servertime")
    private String servertime;

    @SerializedName("noNamespaceSchemaLocation")
    private String noNamespaceSchemaLocation;

    public String getServerdate() {
        return serverdate;
    }

    public List<TripItem> getTrips() {
        return trips;
    }

    public String getServertime() {
        return servertime;
    }

    public String getNoNamespaceSchemaLocation() {
        return noNamespaceSchemaLocation;
    }

    public void calculateScores() {
        StationWeight stationWeight = new StationWeight();
        Map<String, Integer> stationWeights = stationWeight.getWeights();

        for (TripItem trip : trips) {
            double score = 0;

            for (LegItem leg : trip.getLeg()) {
                String dest = leg.getDestination().getName();
                score += stationWeights.get(dest);
            }

            trip.setScore(score);
        }
    }
}