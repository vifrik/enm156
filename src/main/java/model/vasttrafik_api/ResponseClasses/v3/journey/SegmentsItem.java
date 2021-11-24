package model.vasttrafik_api.responseClasses.v3.journey;

import com.google.gson.annotations.SerializedName;

public class SegmentsItem {

    @SerializedName("orientation")
    private String orientation;

    @SerializedName("distanceInMeters")
    private int distanceInMeters;

    @SerializedName("name")
    private String name;

    @SerializedName("maneuverDescription")
    private String maneuverDescription;

    @SerializedName("maneuver")
    private String maneuver;

    public String getOrientation() {
        return orientation;
    }

    public int getDistanceInMeters() {
        return distanceInMeters;
    }

    public String getName() {
        return name;
    }

    public String getManeuverDescription() {
        return maneuverDescription;
    }

    public String getManeuver() {
        return maneuver;
    }

    @Override
    public String toString() {
        return
                "SegmentsItem{" +
                        "orientation = '" + orientation + '\'' +
                        ",distanceInMeters = '" + distanceInMeters + '\'' +
                        ",name = '" + name + '\'' +
                        ",maneuverDescription = '" + maneuverDescription + '\'' +
                        ",maneuver = '" + maneuver + '\'' +
                        "}";
    }
}