package vasttrafikAPI.responseClasses.trip;

import vasttrafikAPI.StationWeight;
import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        StationWeight stationWeight = new StationWeight();
        Map<String, Integer> stationWeights = stationWeight.getWeights();

        for (TripItem trip : trips) {
            double score = 0;

            List<LegItem> legs = trip.getLeg();

            Destination lastDest = legs.get(legs.size()-1).getDestination();
            try {
                Date arrival = formatter.parse(lastDest.getDate() + " " + lastDest.getTime());
                score += (arrival.getTime() - System.currentTimeMillis())/1000.0 / 100;
            } catch (ParseException e) {
                e.printStackTrace();
            }


            for (LegItem leg : trip.getLeg()) {
                String dest = leg.getDestination().getName();
                int weight = stationWeights.get(dest);
                double weightContribution = Math.log(weight) / Math.log(2);
                score += weightContribution;
            }

            trip.setScore(score);
        }
    }
}