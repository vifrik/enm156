package vasttrafikAPI.responseClasses.v3.journey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Origin {

    @SerializedName("gid")
    private String gid;

    @SerializedName("notes")
    private List<Object> notes;

    @SerializedName("latitude")
    private double latitude;

    @SerializedName("name")
    private String name;

    @SerializedName("plannedTime")
    private String plannedTime;

    @SerializedName("locationType")
    private String locationType;

    @SerializedName("longitude")
    private double longitude;

    public String getGid() {
        return gid;
    }

    public List<Object> getNotes() {
        return notes;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getName() {
        return name;
    }

    public String getPlannedTime() {
        return plannedTime;
    }

    public String getLocationType() {
        return locationType;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return
                "Origin{" +
                        "gid = '" + gid + '\'' +
                        ",notes = '" + notes + '\'' +
                        ",latitude = '" + latitude + '\'' +
                        ",name = '" + name + '\'' +
                        ",plannedTime = '" + plannedTime + '\'' +
                        ",locationType = '" + locationType + '\'' +
                        ",longitude = '" + longitude + '\'' +
                        "}";
    }
}