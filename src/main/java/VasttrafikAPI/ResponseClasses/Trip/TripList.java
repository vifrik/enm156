package VasttrafikAPI.ResponseClasses.Trip;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TripList{

    @SerializedName("serverdate")
    private String serverdate;

    @SerializedName("Trip")
    private List<TripItem> trip;

    @SerializedName("servertime")
    private String servertime;

    @SerializedName("noNamespaceSchemaLocation")
    private String noNamespaceSchemaLocation;

    public String getServerdate(){
        return serverdate;
    }

    public List<TripItem> getTrip(){
        return trip;
    }

    public String getServertime(){
        return servertime;
    }

    public String getNoNamespaceSchemaLocation(){
        return noNamespaceSchemaLocation;
    }
}