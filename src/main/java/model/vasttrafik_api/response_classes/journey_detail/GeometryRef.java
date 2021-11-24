package model.vasttrafik_api.response_classes.journey_detail;

import com.google.gson.annotations.SerializedName;

public class GeometryRef {

    @SerializedName("ref")
    private String ref;

    public String getRef() {
        return ref;
    }
}