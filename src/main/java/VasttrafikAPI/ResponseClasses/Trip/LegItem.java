package VasttrafikAPI.ResponseClasses.Trip;

import com.google.gson.annotations.SerializedName;

public class LegItem{

    @SerializedName("Origin")
    private Origin origin;

    @SerializedName("fgColor")
    private String fgColor;

    @SerializedName("Destination")
    private Destination destination;

    @SerializedName("booking")
    private boolean booking;

    @SerializedName("JourneyDetailRef")
    private JourneyDetailRef journeyDetailRef;

    @SerializedName("accessibility")
    private String accessibility;

    @SerializedName("night")
    private boolean night;

    @SerializedName("type")
    private String type;

    @SerializedName("stroke")
    private String stroke;

    @SerializedName("reachable")
    private boolean reachable;

    @SerializedName("bgColor")
    private String bgColor;

    @SerializedName("sname")
    private String sname;

    @SerializedName("GeometryRef")
    private GeometryRef geometryRef;

    @SerializedName("name")
    private String name;

    @SerializedName("cancelled")
    private boolean cancelled;

    @SerializedName("id")
    private String id;

    @SerializedName("Notes")
    private Notes notes;

    @SerializedName("direction")
    private String direction;

    public Origin getOrigin(){
        return origin;
    }

    public String getFgColor(){
        return fgColor;
    }

    public Destination getDestination(){
        return destination;
    }

    public boolean isBooking(){
        return booking;
    }

    public JourneyDetailRef getJourneyDetailRef(){
        return journeyDetailRef;
    }

    public String getAccessibility(){
        return accessibility;
    }

    public boolean isNight(){
        return night;
    }

    public String getType(){
        return type;
    }

    public String getStroke(){
        return stroke;
    }

    public boolean isReachable(){
        return reachable;
    }

    public String getBgColor(){
        return bgColor;
    }

    public String getSname(){
        return sname;
    }

    public GeometryRef getGeometryRef(){
        return geometryRef;
    }

    public String getName(){
        return name;
    }

    public boolean isCancelled(){
        return cancelled;
    }

    public String getId(){
        return id;
    }

    public Notes getNotes(){
        return notes;
    }

    public String getDirection(){
        return direction;
    }
}