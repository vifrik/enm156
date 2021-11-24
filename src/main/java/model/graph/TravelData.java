package model.graph;

public class TravelData {
    private String station;
    private String destination;
    private double weight;
    private int time;
    private VertexData vertexDataStation;
    private VertexData vertexDataDestination;

    public TravelData(String station, String destination, double weight, int time) {
        this.station = station;
        this.destination = destination;
        this.weight = weight;
        this.time = time;
        vertexDataStation = new VertexData(station, time, true);
        vertexDataDestination = new VertexData(destination, time, false);
    }

    public String toString() {
        return String.format("From: %s, to: %s, with weight: %f, at time %d", station, destination, weight, time);
    }

    public String getStation() {
        return station;
    }

    public String getDestination() {
        return destination;
    }

    public Double getWeight() {
        return weight;
    }

    public int getTime() {
        return time;
    }

    public VertexData getVertexDataStation() {
        return vertexDataStation;
    }

    public VertexData getVertexDataDestination() {
        return vertexDataDestination;
    }
}
