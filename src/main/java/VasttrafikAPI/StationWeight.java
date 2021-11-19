package VasttrafikAPI;

import VasttrafikAPI.ResponseClasses.StationResponse.StationResponse;
import VasttrafikAPI.ResponseClasses.StationResponse.StopLocationItem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class StationWeight {
    private final Map<String, Integer> weights = new HashMap<>();

    public StationWeight() {
        try {
            String stationsJson = Files.readString(Path.of("data/stations.json"));
            StationResponse stationResponse = JSON.objFromJson(stationsJson, StationResponse.class);

            for (StopLocationItem stopLocationItem : stationResponse.getLocationList().getStopLocation()) {
                if (!weights.containsKey(stopLocationItem.getName())) {
                    weights.put(stopLocationItem.getName(), Integer.parseInt(stopLocationItem.getWeight()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Integer> getWeights() {
        return weights;
    }
}
