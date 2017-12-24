class Merger {

    public static List mergeLists(List listA, List listB) {
        List resultList = new List();
        resultList.node = new Node();

        Node currentNode = resultList.node; // This is a fake node

        Node cursorA, cursorB;
        cursorA = listA.node;
        cursorB = listB.node;

        Node cursorANext, cursorBNext;
        cursorANext = cursorA.node;
        cursorBNext = cursorB.node;

        while (true) {
            double listAData = getValue(cursorA);
            double listBData = getValue(cursorB);

            if (listAData == Double.POSITIVE_INFINITY && listBData == Double.POSITIVE_INFINITY) {
                break;
            }

            Node smallerNode = (listAData < listBData) ? cursorA : cursorB;

            currentNode.node = smallerNode;
            currentNode = smallerNode;

            if (listAData < listBData) {
                // Update cursorA
                cursorA = cursorANext;
                cursorANext = (cursorA == null) ? null : cursorA.node;
            } else {
                // Update cursorB
                cursorB = cursorBNext;
                cursorBNext = (cursorB == null) ? null :  cursorB.node;
            }
        }

        // Removing fake node:
        resultList.node = resultList.node.node;

        return resultList;
    }

    private static double getValue(Node node) {
        if (node == null) {
            return Double.POSITIVE_INFINITY;
        } else {
            return node.data;
        }
    }

    public static void main(String[] args) {
        List listA = new List();
        listA.node = new Node(6);
        listA.node.node = new Node(8);
        listA.node.node.node = new Node(9);

        List listB = new List();
        listB.node = new Node(1);
        listB.node.node = new Node(2);
        listB.node.node.node = new Node(7);
        listB.node.node.node.node = new Node(10);

        List merged = mergeLists(listA, listB);
        Node node = merged.node;
        while (node != null) {
            System.out.println(node.data);
            node = node.node;
        }
    }
}

class Node {
    Node node;
    double data;

    Node() {}

    Node(double data) {
        this.data = data;
    }
}

class List {
    Node node;
}