package vasttrafikAPI.responseClasses.name;

import com.google.gson.annotations.SerializedName;

public class CoordLocationItem {

    @SerializedName("name")
    private String name;

    @SerializedName("lon")
    private String lon;

    @SerializedName("type")
    private String type;

    @SerializedName("idx")
    private String idx;

    @SerializedName("lat")
    private String lat;

    public String getName() {
        return name;
    }

    public String getLon() {
        return lon;
    }

    public String getType() {
        return type;
    }

    public String getIdx() {
        return idx;
    }

    public String getLat() {
        return lat;
    }
}