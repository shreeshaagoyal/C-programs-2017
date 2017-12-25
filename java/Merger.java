class Merger {

    public static List mergeLists(List listA, List listB) {
        List resultList = new List();
        resultList.next = new Node();

        Node currentNode = resultList.next; // This is a fake node

        Node cursorA, cursorB;
        cursorA = listA.next;
        cursorB = listB.next;

        Node cursorANext, cursorBNext;
        cursorANext = cursorA.next;
        cursorBNext = cursorB.next;

        while (true) {
            double listAData = getValue(cursorA);
            double listBData = getValue(cursorB);

            if (listAData == Double.POSITIVE_INFINITY && listBData == Double.POSITIVE_INFINITY) {
                break;
            }

            Node smallerNode = (listAData < listBData) ? cursorA : cursorB;

            currentNode.next = smallerNode;
            currentNode = smallerNode;

            if (listAData < listBData) {
                // Update cursorA
                cursorA = cursorANext;
                cursorANext = (cursorA == null) ? null : cursorA.next;
            } else {
                // Update cursorB
                cursorB = cursorBNext;
                cursorBNext = (cursorB == null) ? null :  cursorB.next;
            }
        }

        // Removing fake next:
        resultList.next = resultList.next.next;

        return resultList;
    }

    private static double getValue(Node next) {
        if (next == null) {
            return Double.POSITIVE_INFINITY;
        } else {
            return next.data;
        }
    }

    public static void main(String[] args) {
        List listA = new List();
        listA.next = new Node(6);
        listA.next.next = new Node(8);
        listA.next.next.next = new Node(9);

        List listB = new List();
        listB.next = new Node(1);
        listB.next.next = new Node(2);
        listB.next.next.next = new Node(7);
        listB.next.next.next.next = new Node(10);

        List merged = mergeLists(listA, listB);
        Node next = merged.next;
        while (next != null) {
            System.out.println(next.data);
            next = next.next;
        }
    }
}