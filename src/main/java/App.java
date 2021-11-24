import model.graph.SpaceTimeGraph;
import model.graph.TravelData;
import utility.FileReader;
import view.textview.textcmds.MockTimeTable;
import model.timetable.TimeTable;
import view.textview.TextView;
import view.BaseView;
import java.util.ArrayList;

public final class App {
    public App(boolean consoleStart) {
        if (consoleStart)
            startConsole();
        else
            startGraph();
    }

    public App() {this(true);}

    private void startConsole() {
        TimeTable timeTable = new MockTimeTable();
        BaseView userInterface = new TextView(timeTable);
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

    public static void main(String[] args) {
        new App();
    }
}
