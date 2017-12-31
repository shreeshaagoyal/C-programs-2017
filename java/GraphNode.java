import java.util.List;
import java.util.ArrayList;
public class GraphNode {
    int value;
    List<GraphNode> adjacentNodes;

    public GraphNode(int value) {
        this.value = value;
        this.adjacentNodes = new ArrayList<GraphNode>();
    }
}