import model.vasttrafik_api.Auth;
import model.vasttrafik_api.StationWeight;
import model.vasttrafik_api.TravelSearch;
import model.vasttrafik_api.response_classes.Token;
import model.vasttrafik_api.response_classes.name.NameResponse;
import model.vasttrafik_api.response_classes.v3.journey.JourneyResponse;
import model.vasttrafik_api.response_classes.v3.token.TokenV3;

import java.util.ArrayList;
import java.util.List;

public class ApiV3App {
    public static void main(String[] args) {
        StationWeight.setup();

        Token token = Auth.getToken();
        TokenV3 tokenV3 = Auth.getTokenV3();

        NameResponse nameResponse = TravelSearch.getName("Chalmers", token);
        String idFrom = nameResponse.getLocationList().getStopLocation().get(0).getId();

        nameResponse = TravelSearch.getName("Ekmanska", token);
        String idTo = nameResponse.getLocationList().getStopLocation().get(0).getId();

        List<String> transportModes = new ArrayList<>();
        transportModes.add("tram");
        transportModes.add("bus");
        transportModes.add("walk");
        transportModes.add("bike");

        String totalBike = "1,500,5000,100";

        JourneyResponse journeyResponse = TravelSearch.getTripV3(idFrom, idTo, transportModes, totalBike,
                null, "1,0,5000", "0", "0", "0",
                null, null, null, null, tokenV3);


        System.out.println(journeyResponse);
    }
}
