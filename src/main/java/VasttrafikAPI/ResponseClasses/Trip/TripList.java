package VasttrafikAPI.ResponseClasses.Trip;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TripList{

    @SerializedName("serverdate")
    private String serverdate;

    @SerializedName("Trip")
    private List<TripItem> trips;

    @SerializedName("servertime")
    private String servertime;

    @SerializedName("noNamespaceSchemaLocation")
    private String noNamespaceSchemaLocation;

    public String getServerdate(){
        return serverdate;
    }

    public List<TripItem> getTrips(){
        return trips;
    }

    public String getServertime(){
        return servertime;
    }

    public String getNoNamespaceSchemaLocation(){
        return noNamespaceSchemaLocation;
    }

    public void calculateScores(){
        for(TripItem trip : trips){
            double score = 0;

            for(LegItem leg : trip.getLeg()){
                String dest = leg.getDestination().getName();
                score += 1; //weight[dest];
            }

            trip.setScore(score);
        }
    }
}