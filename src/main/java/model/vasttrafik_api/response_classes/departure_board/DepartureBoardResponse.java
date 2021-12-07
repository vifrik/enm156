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
        StringBuilder sb = new StringBuilder();
        for (DepartureItem d : departureBoard.getDepartures()) {
            sb.append("[%3s] [%4s] [%s] %s".formatted(d.getSname(), d.getType(), d.getTime(), d.getDirection()));
            sb.append("\n");
        }
        return sb.toString();
    }
}