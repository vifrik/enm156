import java.util.ArrayList;

public final class App {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader("data/travel.txt");
        ArrayList<TravelData> travelData = fileReader.getTravelData();

        SpaceTimeGraph stGraph = new SpaceTimeGraph(travelData, 10);
        stGraph.BuildGraph();

        var paths = stGraph.FindPaths("Korsvägen", "Chalmers");

        stGraph.PrintPaths(paths);
        stGraph.DrawGraph();
    }

}
