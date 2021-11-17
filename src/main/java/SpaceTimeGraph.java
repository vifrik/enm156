import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.swing.mxGraphComponent;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.AllDirectedPaths;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SpaceTimeGraph {
    private final Graph<VertexData, DefaultWeightedEdge> graph = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
    private final ArrayList<TravelData> travelData;
    private final int TIME_DELAY;

    public SpaceTimeGraph(ArrayList<TravelData> travelData, int timeDelay) {
        this.travelData = travelData;
        TIME_DELAY = timeDelay;
    }

    public void BuildGraph() {
        for (TravelData td : travelData) {
            graph.addVertex(td.getVertexDataStation());
            graph.addVertex(td.getVertexDataDestination());

            DefaultWeightedEdge edge = graph.addEdge(td.getVertexDataStation(), td.getVertexDataDestination());
            graph.setEdgeWeight(edge, td.getWeight());
        }

        for (TravelData td : travelData) {
            for (TravelData tdd : travelData) {
                if (td.equals(tdd))
                    continue;

                if (td.getTime() + td.getWeight() < tdd.getTime() && td.getDestination().equals(tdd.getStation())) {
                    DefaultWeightedEdge connection = graph.addEdge(td.getVertexDataDestination(),
                            tdd.getVertexDataStation());
                    graph.setEdgeWeight(connection, TIME_DELAY);
                }
            }
        }
    }

    public List<GraphPath<VertexData, DefaultWeightedEdge>> FindPaths(String src, String dst) {
        AllDirectedPaths<VertexData, DefaultWeightedEdge> dps = new AllDirectedPaths<>(graph);
        List<GraphPath<VertexData, DefaultWeightedEdge>> allPaths = new ArrayList<>();

        for (VertexData vSrc : graph.vertexSet()) {
            for (VertexData vDst : graph.vertexSet()) {
                if (vSrc.equals(vDst))
                    continue;

                if(!vSrc.getName().equals(src) || !vDst.getName().equals(dst))
                    continue;

                if (!vSrc.getIsSource() || vDst.getIsSource())
                    continue;

                allPaths.addAll(dps.getAllPaths(vSrc, vDst, true, null));
            }
        }

        allPaths.sort(new GraphPathComparator());
        return allPaths;
    }

    public void PrintPaths(List<GraphPath<VertexData, DefaultWeightedEdge>> paths) {
        for (GraphPath<VertexData, DefaultWeightedEdge> path : paths) {
            System.out.format("Path: %s, with weight: %f\n", path.getVertexList(), path.getWeight());
        }
    }

    public void DrawGraph() {
        JFrame frame = new JFrame("DemoGraph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JGraphXAdapter<VertexData, DefaultWeightedEdge> graphAdapter = new JGraphXAdapter<>(
                graph);

        mxIGraphLayout layout = new mxCircleLayout(graphAdapter);
        layout.execute(graphAdapter.getDefaultParent());

        frame.add(new mxGraphComponent(graphAdapter));
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}
