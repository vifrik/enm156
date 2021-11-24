package model.vasttrafik_api.responseClasses.journeyDetail;

import com.google.gson.annotations.SerializedName;

public class JourneyNameItem {

    @SerializedName("routeIdxTo")
    private String routeIdxTo;

    @SerializedName("name")
    private String name;

    @SerializedName("routeIdxFrom")
    private String routeIdxFrom;

    public String getRouteIdxTo() {
        return routeIdxTo;
    }

    public String getName() {
        return name;
    }

    public String getRouteIdxFrom() {
        return routeIdxFrom;
    }
}