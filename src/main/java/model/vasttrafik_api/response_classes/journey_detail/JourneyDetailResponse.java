package model.vasttrafik_api.response_classes.journey_detail;

import com.google.gson.annotations.SerializedName;

public class JourneyDetailResponse {

    @SerializedName("JourneyDetail")
    private JourneyDetail journeyDetail;

    public JourneyDetail getJourneyDetail() {
        return journeyDetail;
    }
}