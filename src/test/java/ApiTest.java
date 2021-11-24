import model.vasttrafik_api.Auth;
import model.vasttrafik_api.response_classes.departure_board.DepartureBoardResponse;
import model.vasttrafik_api.response_classes.departure_board.DepartureItem;
import model.vasttrafik_api.response_classes.journey_detail.JourneyDetailResponse;
import model.vasttrafik_api.response_classes.journey_detail.StopItem;
import model.vasttrafik_api.response_classes.nearby_stops.LocationList;
import model.vasttrafik_api.response_classes.nearby_stops.NearbyStopsResponse;
import model.vasttrafik_api.response_classes.nearby_stops.StopLocationItem;
import model.vasttrafik_api.response_classes.Token;
import model.vasttrafik_api.TravelData;

public class ApiTest {
    public static void main(String[] args) {
        Token token = Auth.getToken();

        NearbyStopsResponse nearbyStations = TravelData.getNearbyStations(11.973372, 57.689953, token);
        LocationList locationList = nearbyStations.getLocationList();

        for (StopLocationItem stopLocationItem : locationList.getStopLocations()) {
            System.out.println(stopLocationItem);
        }

        StopLocationItem stop = locationList.getStopLocations().get(0);
        String stopId = stop.getId();

        DepartureBoardResponse departureBoardResponse = TravelData.getDepartureBoard(stopId, "2021-11-17", "23:54", token);
        DepartureItem departureItem = departureBoardResponse.getDepartureBoard().getDepartures().get(0);
        String refUrl = departureItem.getJourneyDetailRef().getRef();

        JourneyDetailResponse journeyDetailResponse = TravelData.getJourneyDetail(refUrl, token);

        for (StopItem stopItem : journeyDetailResponse.getJourneyDetail().getStops()) {
            System.out.println(stopItem.getName());
        }

    }
}
