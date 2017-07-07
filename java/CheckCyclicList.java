public class CheckCyclicList {
    public static boolean CyclicListTest(Node head) {
        Node curNode = head;
        Node temp = head.next;
        int count = 1;
        while(temp != null) {
            curNode = head;
            for(int i = 0; i < count; i++) {
                if(curNode == temp) {
                    return true;
                }
                curNode = curNode.next;
            }
            temp = curNode.next;
            count++;
        }
        return false;
    }
    public static boolean CheckCyclicListWithPointers(Node head) {
        Node fastRef = head.next;
        Node slowRef = head;
        while(fastRef != null) {
            if(fastRef == slowRef) {
                return true;
            }
            fastRef = fastRef.next.next;
            slowRef = slowRef.next;
        }
        return false;
    }
    public static void main(String[] args) {
        LList aCyclicList = new LList(1);
        aCyclicList.addToBack(2);
        aCyclicList.addToBack(3);
        aCyclicList.addToBack(4);
        aCyclicList.addToBack(5);
        aCyclicList.addToBack(6);
        aCyclicList.addToBack(7);
        aCyclicList.tail.next = aCyclicList.head;
        System.out.println(CheckCyclicListWithPointers(aCyclicList.head));
    }
}