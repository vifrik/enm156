package model.vasttrafik_api.response_classes.trip;

import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

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
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        for (TripItem trip : trips) {
            double score = 0;

            score += trip.getTimeScore() / 60;
            score += trip.getWeightScore();
            score += trip.getNofStops() * 6;

            trip.setScore(score);
        }
    }
}