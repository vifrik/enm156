package model.vasttrafik_api.responseClasses.departureBoard;

import com.google.gson.annotations.SerializedName;

public class DepartureItem {

    @SerializedName("date")
    private String date;

    @SerializedName("fgColor")
    private String fgColor;

    @SerializedName("JourneyDetailRef")
    private JourneyDetailRef journeyDetailRef;

    @SerializedName("accessibility")
    private String accessibility;

    @SerializedName("journeyNumber")
    private String journeyNumber;

    @SerializedName("stopid")
    private String stopid;

    @SerializedName("type")
    private String type;

    @SerializedName("journeyid")
    private String journeyid;

    @SerializedName("stroke")
    private String stroke;

    @SerializedName("stop")
    private String stop;

    @SerializedName("bgColor")
    private String bgColor;

    @SerializedName("sname")
    private String sname;

    @SerializedName("name")
    private String name;

    @SerializedName("time")
    private String time;

    @SerializedName("track")
    private String track;

    @SerializedName("direction")
    private String direction;

    public String getDate() {
        return date;
    }

    public String getFgColor() {
        return fgColor;
    }

    public JourneyDetailRef getJourneyDetailRef() {
        return journeyDetailRef;
    }

    public String getAccessibility() {
        return accessibility;
    }

    public String getJourneyNumber() {
        return journeyNumber;
    }

    public String getStopid() {
        return stopid;
    }

    public String getType() {
        return type;
    }

    public String getJourneyid() {
        return journeyid;
    }

    public String getStroke() {
        return stroke;
    }

    public String getStop() {
        return stop;
    }

    public String getBgColor() {
        return bgColor;
    }

    public String getSname() {
        return sname;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getTrack() {
        return track;
    }

    public String getDirection() {
        return direction;
    }
}