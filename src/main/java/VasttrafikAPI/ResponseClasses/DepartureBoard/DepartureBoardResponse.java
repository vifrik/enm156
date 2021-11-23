package VasttrafikAPI.ResponseClasses.DepartureBoard;

import com.google.gson.annotations.SerializedName;

public class DepartureBoardResponse {

    @SerializedName("DepartureBoard")
    private DepartureBoard departureBoard;

    public DepartureBoard getDepartureBoard() {
        return departureBoard;
    }
}