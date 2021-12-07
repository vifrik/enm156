import model.graph.SpaceTimeGraph;
import model.graph.TravelData;
import utility.FileReader;
import view.BaseView;
import view.textview.TextView;

import java.util.ArrayList;

public final class App {
    public App(boolean consoleStart) {
        if (consoleStart)
            startConsole();
        else
            startGraph();
    }

    public App() {
        this(true);
    }

    public static void main(String[] args) {
        new App();
    }

    private void startConsole() {
        BaseView userInterface = new TextView();
        userInterface.start();
    }

    private void startGraph() {
        FileReader fileReader = new FileReader("data/travel.txt");
        ArrayList<TravelData> travelData = fileReader.getTravelData();

        SpaceTimeGraph stGraph = new SpaceTimeGraph(travelData, 10);
        stGraph.BuildGraph();

        var paths = stGraph.FindPaths("Korsvägen", "Chalmers");

        stGraph.PrintPaths(paths);
        stGraph.DrawGraph();
    }
}
