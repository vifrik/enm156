package VasttrafikAPI.ResponseClasses.Trip;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TripResponse{

    @SerializedName("serverdate")
    private String serverdate;

    @SerializedName("errorText")
    private String errorText;

    @SerializedName("Trip")
    private List<TripItem> trip;

    @SerializedName("servertime")
    private String servertime;

    @SerializedName("noNamespaceSchemaLocation")
    private String noNamespaceSchemaLocation;

    @SerializedName("error")
    private String error;

    public String getServerdate(){
        return serverdate;
    }

    public String getErrorText(){
        return errorText;
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

    public String getError(){
        return error;
    }
}