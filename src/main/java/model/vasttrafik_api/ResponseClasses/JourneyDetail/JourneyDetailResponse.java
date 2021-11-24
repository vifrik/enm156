package model.vasttrafik_api.responseClasses.journeyDetail;

import com.google.gson.annotations.SerializedName;

public class JourneyDetailResponse {

    @SerializedName("JourneyDetail")
    private JourneyDetail journeyDetail;

    public JourneyDetail getJourneyDetail() {
        return journeyDetail;
    }
}