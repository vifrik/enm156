package Vasttrafik.ResponseClasses.JourneyDetail;

import com.google.gson.annotations.SerializedName;

public class DirectionItem {

    @SerializedName("$")
    private String destination;

    @SerializedName("routeIdxTo")
    private String routeIdxTo;

    @SerializedName("routeIdxFrom")
    private String routeIdxFrom;

    public String getDestination() {
        return destination;
    }

    public String getRouteIdxTo() {
        return routeIdxTo;
    }

    public String getRouteIdxFrom() {
        return routeIdxFrom;
    }
}