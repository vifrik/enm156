package vasttrafikAPI.responseClasses.trip;

import com.google.gson.annotations.SerializedName;

public class LegItem {
    @Override
    public String toString() {
        return origin.getName() + " -> " + destination.getName() + "  (" + type + ")";
    }

    @SerializedName("Origin")
    private Origin origin;

    @SerializedName("fgColor")
    private String fgColor;

    @SerializedName("Destination")
    private Destination destination;

    @SerializedName("JourneyDetailRef")
    private JourneyDetailRef journeyDetailRef;

    @SerializedName("accessibility")
    private String accessibility;

    @SerializedName("journeyNumber")
    private String journeyNumber;

    @SerializedName("type")
    private String type;

    @SerializedName("stroke")
    private String stroke;

    @SerializedName("bgColor")
    private String bgColor;

    @SerializedName("sname")
    private String sname;

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    @SerializedName("direction")
    private String direction;

    public Origin getOrigin() {
        return origin;
    }

    public String getFgColor() {
        return fgColor;
    }

    public Destination getDestination() {
        return destination;
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

    public String getType() {
        return type;
    }

    public String getStroke() {
        return stroke;
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

    public String getId() {
        return id;
    }

    public String getDirection() {
        return direction;
    }
}