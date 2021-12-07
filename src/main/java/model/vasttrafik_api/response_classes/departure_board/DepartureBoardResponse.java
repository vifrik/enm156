package model.vasttrafik_api.response_classes.departure_board;

import com.google.gson.annotations.SerializedName;

public class DepartureBoardResponse {

    @SerializedName("DepartureBoard")
    private DepartureBoard departureBoard;

    public DepartureBoard getDepartureBoard() {
        return departureBoard;
    }

    @Override
    public String toString() {
        return departureBoard.toString();
    }
}