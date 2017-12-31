import java.util.HashMap;
import java.util.HashSet;

public class Graph2 {
    HashSet<Integer> visited;
    HashMap<Integer, GraphNode> intToNode;

    public Graph2(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new IllegalArgumentException("Arrays must be the same length");
        }

        this.visited = new HashSet<Integer>();
        this.intToNode = new HashMap<Integer, GraphNode>();

        for (int i = 0; i < arr1.length; i++) {

            if (this.intToNode.containsKey(arr1[i])) {

                GraphNode firstNode = this.intToNode.get(arr1[i]);

                if (this.intToNode.containsKey(arr2[i])) {  // contains first element, contains second element
                    pointToExistingNode(firstNode, arr2[i]);
                } else {                                    // contains first element, doesn't contain second element
                    pointToNewNode(firstNode, arr2[i]);
                }
            } else {

                GraphNode firstNode = new GraphNode(arr1[i]);
                this.intToNode.put(arr1[i], firstNode);

                if (this.intToNode.containsKey(arr2[i])) {  // doesn't contain first element, contains second element
                    pointToExistingNode(firstNode, arr2[i]);
                } else {                                    // doesn't conttain first element, doesn't contain second element
                    pointToNewNode(firstNode, arr2[i]);
                }
            }
        }
    }

    public Graph2(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new IllegalArgumentException("Arrays must be the same length");
        }

        this.visited = new HashSet<Integer>();
        this.intToNode = new HashMap<Integer, GraphNode>();

        for (int i = 0; i < arr1.length; i++) {
            ensureNode(arr1[i]);
            ensureNode(arr2[i]);
            pointToNode(arr1[i], arr2[i]);
        }
    }

    private void pointToExistingNode(GraphNode firstNode, int n) {
        GraphNode newNode = this.intToNode.get(n);
        firstNode.adjacentNodes.add(newNode);
    }

    private void pointToNewNode(GraphNode firstNode, int n) {
        GraphNode newNode = new GraphNode(n);
        firstNode.adjacentNodes.add(newNode);
        this.intToNode.put(n, newNode);
    }

    public Boolean isReachable(int start, int end) {
        if (visited.contains(start)) {
            return false;
        } else {
            visited.add(start);
        }
        if (start == end) {
            return true;
        }

        GraphNode startNode = this.intToNode.get(start);
        for (int i = 0; i < startNode.adjacentNodes.size(); i++) {
            int nextStart = startNode.adjacentNodes.get(i).value;
            if (isReachable(nextStart, end)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 10, 5, 1, 5, 1, 1, 4, 4};
        int[] arr2 = {10, 1, 1, 5, 4, 3, 12, 7, 2};
        Graph2 testGraph = new Graph2(arr1, arr2);
        System.out.println(testGraph.isReachable(7, 4));
    }
}