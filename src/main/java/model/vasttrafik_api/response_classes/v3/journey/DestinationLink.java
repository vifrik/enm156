package model.vasttrafik_api.response_classes.v3.journey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DestinationLink {

    @SerializedName("notes")
    private List<Object> notes;

    @SerializedName("plannedDurationInMinutes")
    private int plannedDurationInMinutes;

    @SerializedName("estimatedNumberOfSteps")
    private int estimatedNumberOfSteps;

    @SerializedName("linkCoordinates")
    private List<LinkCoordinatesItem> linkCoordinates;

    @SerializedName("transportSubMode")
    private String transportSubMode;

    @SerializedName("distanceInMeters")
    private int distanceInMeters;

    @SerializedName("origin")
    private Origin origin;

    @SerializedName("plannedArrivalTime")
    private String plannedArrivalTime;

    @SerializedName("destination")
    private Destination destination;

    @SerializedName("transportMode")
    private String transportMode;

    @SerializedName("plannedDepartureTime")
    private String plannedDepartureTime;

    @SerializedName("segments")
    private List<SegmentsItem> segments;

    public List<Object> getNotes() {
        return notes;
    }

    public int getPlannedDurationInMinutes() {
        return plannedDurationInMinutes;
    }

    public int getEstimatedNumberOfSteps() {
        return estimatedNumberOfSteps;
    }

    public List<LinkCoordinatesItem> getLinkCoordinates() {
        return linkCoordinates;
    }

    public String getTransportSubMode() {
        return transportSubMode;
    }

    public int getDistanceInMeters() {
        return distanceInMeters;
    }

    public Origin getOrigin() {
        return origin;
    }

    public String getPlannedArrivalTime() {
        return plannedArrivalTime;
    }

    public Destination getDestination() {
        return destination;
    }

    public String getTransportMode() {
        return transportMode;
    }

    public String getPlannedDepartureTime() {
        return plannedDepartureTime;
    }

    public List<SegmentsItem> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return
                "DestinationLink{" +
                        "notes = '" + notes + '\'' +
                        ",plannedDurationInMinutes = '" + plannedDurationInMinutes + '\'' +
                        ",estimatedNumberOfSteps = '" + estimatedNumberOfSteps + '\'' +
                        ",linkCoordinates = '" + linkCoordinates + '\'' +
                        ",transportSubMode = '" + transportSubMode + '\'' +
                        ",distanceInMeters = '" + distanceInMeters + '\'' +
                        ",origin = '" + origin + '\'' +
                        ",plannedArrivalTime = '" + plannedArrivalTime + '\'' +
                        ",destination = '" + destination + '\'' +
                        ",transportMode = '" + transportMode + '\'' +
                        ",plannedDepartureTime = '" + plannedDepartureTime + '\'' +
                        ",segments = '" + segments + '\'' +
                        "}";
    }
}