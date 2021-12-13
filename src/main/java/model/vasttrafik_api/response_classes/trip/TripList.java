package model.vasttrafik_api.response_classes.trip;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import controller.Weights;
import model.vasttrafik_api.StationWeight;
import model.vasttrafik_api.response_classes.AlwaysListTypeAdapterFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TripList {

    @SerializedName("serverdate")
    private String serverdate;

    @SerializedName("Trip")
    @JsonAdapter(AlwaysListTypeAdapterFactory.class)
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

    public void calculateScores(Map<Weights, Integer> weights) {
        StationWeight stationWeight = new StationWeight();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        for (TripItem trip : trips) {
            double score = 0;

            score += trip.getTimeScore() / 30;
            score += trip.getWeightScore(stationWeight) * weights.get(Weights.AVOID_CENTRAL);
            score += trip.getNofStops() * weights.get(Weights.AVOID_CHANGES);

            trip.setScore(score);
        }
    }
}