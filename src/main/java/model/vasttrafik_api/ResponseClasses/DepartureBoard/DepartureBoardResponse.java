package model.vasttrafik_api.responseClasses.departureBoard;

import com.google.gson.annotations.SerializedName;

public class DepartureBoardResponse {

    @SerializedName("DepartureBoard")
    private DepartureBoard departureBoard;

    public DepartureBoard getDepartureBoard() {
        return departureBoard;
    }
}