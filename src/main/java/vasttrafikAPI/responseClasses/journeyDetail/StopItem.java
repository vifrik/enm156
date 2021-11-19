package vasttrafikAPI.responseClasses.journeyDetail;

import com.google.gson.annotations.SerializedName;

public class StopItem {

    @SerializedName("arrDate")
    private String arrDate;

    @SerializedName("routeIdx")
    private String routeIdx;

    @SerializedName("name")
    private String name;

    @SerializedName("lon")
    private String lon;

    @SerializedName("id")
    private String id;

    @SerializedName("track")
    private String track;

    @SerializedName("arrTime")
    private String arrTime;

    @SerializedName("lat")
    private String lat;

    @SerializedName("depTime")
    private String depTime;

    @SerializedName("depDate")
    private String depDate;

    public String getArrDate() {
        return arrDate;
    }

    public String getRouteIdx() {
        return routeIdx;
    }

    public String getName() {
        return name;
    }

    public String getLon() {
        return lon;
    }

    public String getId() {
        return id;
    }

    public String getTrack() {
        return track;
    }

    public String getArrTime() {
        return arrTime;
    }

    public String getLat() {
        return lat;
    }

    public String getDepTime() {
        return depTime;
    }

    public String getDepDate() {
        return depDate;
    }
}