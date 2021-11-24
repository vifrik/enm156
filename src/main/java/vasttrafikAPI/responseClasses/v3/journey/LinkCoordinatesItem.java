package vasttrafikAPI.responseClasses.v3.journey;

import com.google.gson.annotations.SerializedName;

public class LinkCoordinatesItem {

    @SerializedName("elevation")
    private int elevation;

    @SerializedName("latitude")
    private double latitude;

    @SerializedName("longitude")
    private double longitude;

    public int getElevation() {
        return elevation;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return
                "LinkCoordinatesItem{" +
                        "elevation = '" + elevation + '\'' +
                        ",latitude = '" + latitude + '\'' +
                        ",longitude = '" + longitude + '\'' +
                        "}";
    }
}