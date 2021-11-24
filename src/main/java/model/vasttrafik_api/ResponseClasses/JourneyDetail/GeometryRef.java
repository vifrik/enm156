package model.vasttrafik_api.responseClasses.journeyDetail;

import com.google.gson.annotations.SerializedName;

public class GeometryRef {

    @SerializedName("ref")
    private String ref;

    public String getRef() {
        return ref;
    }
}