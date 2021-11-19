package VasttrafikAPI.ResponseClasses.Trip;

import com.google.gson.annotations.SerializedName;

public class Origin {

    @SerializedName("date")
    private String date;

    @SerializedName("$")
    private String unused;

    @SerializedName("routeIdx")
    private String routeIdx;

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    @SerializedName("time")
    private String time;

    @SerializedName("rtDate")
    private String rtDate;

    @SerializedName("type")
    private String type;

    @SerializedName("track")
    private String track;

    @SerializedName("rtTime")
    private String rtTime;

    public String getDate() {
        return date;
    }

    public String getUnused() {
        return unused;
    }

    public String getRouteIdx() {
        return routeIdx;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public String getRtDate() {
        return rtDate;
    }

    public String getType() {
        return type;
    }

    public String getTrack() {
        return track;
    }

    public String getRtTime() {
        return rtTime;
    }
}