package model.vasttrafik_api.responseClasses.trip;

import com.google.gson.annotations.SerializedName;
import model.vasttrafik_api.StationWeight;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class TripItem {
    @SerializedName("Leg")
    private List<LegItem> leg;
    private double score;
    @SerializedName("alternative")
    private String alternative;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(score);
        sb.append("\n");
        sb.append("Time: ").append(getTimeScore());
        sb.append("\n");
        sb.append("Weight: ").append(getWeightScore());
        sb.append("\n");
        for (LegItem l : leg) {
            sb.append(l);
            sb.append("\n");
        }
        return sb.toString();
    }

    public List<LegItem> getLeg() {
        return leg;
    }

    public String getAlternative() {
        return alternative;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getTimeScore() {
        Destination lastDest = leg.get(leg.size() - 1).getDestination();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date arrival = null;
        try {
            arrival = formatter.parse(lastDest.getDate() + " " + lastDest.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (arrival.getTime() - System.currentTimeMillis()) / 1000.0;
    }

    public double getWeightScore() {
        double weight = 0;

        for (LegItem l : leg) {
            String dest = l.getDestination().getName();
            double weightContribution = Math.log(StationWeight.weights.get(dest)) / Math.log(2);
            weight += weightContribution;
        }

        return weight / leg.size();
    }

    public int getNofStops() {
        return leg.size();
    }

    public static class TripComparator implements Comparator<TripItem> {
        @Override
        public int compare(TripItem o1, TripItem o2) {
            return Double.compare(o1.score, o2.score);
        }
    }
}