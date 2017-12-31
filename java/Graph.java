import java.util.ArrayList;

public class Graph {
    ArrayList<Integer> visited;
    Queue todo;
    int[] arr1;
    int[] arr2;

    public Graph (int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new IllegalArgumentException("Arrays must be the same length");
        }
        this.arr1 = arr1;
        this.arr2 = arr2;
        visited = new ArrayList<Integer>();
        todo = new Queue();
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 10, 5, 1, 5, 1, 1, 4, 4};
        int[] arr2 = {10, 1, 1, 5, 4, 3, 12, 7, 2};
        Graph testGraph = new Graph(arr1, arr2);
        System.out.println(testGraph.isReachable(5, 12));
    }

    public Boolean isReachable(int start, int end) {
        if (start == end) {
            return true;
        }

        int currNum = start;
        visited.add(currNum);
        addToToDo(currNum);

        while(todo.size() != 0) {
            currNum = todo.remove();
            if (!visited.contains(currNum)) {
                visited.add(currNum);
                addToToDo(currNum);
                if (currNum == end) {
                    return true;
                }
            }
        }

        return false;
    }

    private void addToToDo(int n) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == n) {
                todo.add(arr2[i]);
            }
        }
    }
}