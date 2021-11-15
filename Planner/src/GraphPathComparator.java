package Planner.src;

import java.util.Comparator;

import Planner.src.VertexData;
import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultWeightedEdge;

public class GraphPathComparator implements Comparator<GraphPath<VertexData, DefaultWeightedEdge>> {

    @Override
    public int compare(GraphPath<VertexData, DefaultWeightedEdge> o1, GraphPath<VertexData, DefaultWeightedEdge> o2) {
        return Double.compare(o1.getWeight(), o2.getWeight());
    }
}
