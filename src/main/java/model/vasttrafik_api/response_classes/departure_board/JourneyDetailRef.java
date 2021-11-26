package model.vasttrafik_api.response_classes.departure_board;

import com.google.gson.annotations.SerializedName;

public class JourneyDetailRef {

    @SerializedName("ref")
    private String ref;

    public String getRef() {
        return ref;
    }
}