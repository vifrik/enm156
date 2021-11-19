package VasttrafikAPI.ResponseClasses.JourneyDetail;

import com.google.gson.annotations.SerializedName;

public class JourneyId {

    @SerializedName("routeIdxTo")
    private String routeIdxTo;

    @SerializedName("routeIdxFrom")
    private String routeIdxFrom;

    @SerializedName("id")
    private String id;

    public String getRouteIdxTo() {
        return routeIdxTo;
    }

    public String getRouteIdxFrom() {
        return routeIdxFrom;
    }

    public String getId() {
        return id;
    }
}