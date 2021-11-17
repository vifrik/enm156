import Vasttrafik.Auth;
import Vasttrafik.ResponseClasses.DepartureBoard.DepartureBoardResponse;
import Vasttrafik.ResponseClasses.DepartureBoard.DepartureItem;
import Vasttrafik.ResponseClasses.JourneyDetail.JourneyDetailResponse;
import Vasttrafik.ResponseClasses.JourneyDetail.StopItem;
import Vasttrafik.ResponseClasses.NearbyStops.LocationList;
import Vasttrafik.ResponseClasses.NearbyStops.NearbyStopsResponse;
import Vasttrafik.ResponseClasses.NearbyStops.StopLocationItem;
import Vasttrafik.ResponseClasses.Token;
import Vasttrafik.TravelData;

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
