package model.vasttrafik_api.response_classes.journey_detail;

import com.google.gson.annotations.SerializedName;

public class JourneyTypeItem {

    @SerializedName("routeIdxTo")
    private String routeIdxTo;

    @SerializedName("routeIdxFrom")
    private String routeIdxFrom;

    @SerializedName("type")
    private String type;

    public String getRouteIdxTo() {
        return routeIdxTo;
    }

    public String getRouteIdxFrom() {
        return routeIdxFrom;
    }

    public String getType() {
        return type;
    }
}