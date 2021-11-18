package VasttrafikAPI.ResponseClasses.JourneyDetail;

import com.google.gson.annotations.SerializedName;

public class GeometryRef {

    @SerializedName("ref")
    private String ref;

    public String getRef() {
        return ref;
    }
}