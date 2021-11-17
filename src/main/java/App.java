import model.timetable.MockTimeTable;
import model.timetable.TimeTable;
import view.TextView;
import view.BaseView;

public final class App {
    public final static int TIME_DELAY = 10;

    public static void main(String[] args) {
        /*
        Graph<VertexData, DefaultWeightedEdge> g = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);

        FileReader fileReader = new FileReader("data/travel.txt");
        ArrayList<TravelData> travelData = fileReader.getTravelData();

        for (TravelData td : travelData) {
            g.addVertex(td.getVertexDataStation());
            g.addVertex(td.getVertexDataDestination());

            DefaultWeightedEdge edge = g.addEdge(td.getVertexDataStation(), td.getVertexDataDestination());
            g.setEdgeWeight(edge, td.getWeight());
        }

        for (TravelData td : travelData) {
            for (TravelData tdd : travelData) {
                if (td.equals(tdd))
                    continue;

                if (td.getTime() + td.getWeight() < tdd.getTime() && td.getDestination().equals(tdd.getStation())) {
                    DefaultWeightedEdge connection = g.addEdge(td.getVertexDataDestination(),
                            tdd.getVertexDataStation());
                    g.setEdgeWeight(connection, TIME_DELAY);
                }
            }
        }

        AllDirectedPaths<VertexData, DefaultWeightedEdge> dps = new AllDirectedPaths<>(g);
        List<GraphPath<VertexData, DefaultWeightedEdge>> allPaths = new ArrayList<>();

        for (VertexData vd : g.vertexSet()) {
            for (VertexData vdd : g.vertexSet()) {
                if (vd.equals(vdd))
                    continue;

                if (!(vd.getName().equals("Korsvägen") && vdd.getName().equals("Chalmers")))
                    continue;

                if (!vd.getIsSource() || vdd.getIsSource())
                    continue;

                allPaths.addAll(dps.getAllPaths(vd, vdd, true, null));

            }
        }

        allPaths.sort(new GraphPathComparator());

        for (GraphPath<VertexData, DefaultWeightedEdge> path : allPaths) {
            System.out.format("Path: %s, with weight: %f\n", path.getVertexList(), path.getWeight());
        }

        JFrame frame = new JFrame("DemoGraph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JGraphXAdapter<VertexData, DefaultWeightedEdge> graphAdapter = new JGraphXAdapter<VertexData, DefaultWeightedEdge>(
                g);

        mxIGraphLayout layout = new mxCircleLayout(graphAdapter);
        layout.execute(graphAdapter.getDefaultParent());

        frame.add(new mxGraphComponent(graphAdapter));
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
         */

        TimeTable timeTable = new MockTimeTable();
        BaseView userInterface = new TextView(timeTable);
        userInterface.start();
    }
}
