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
    public static void main(String[] args) {
        LList aCyclicList = new LList(1);
        aCyclicList.addToBack(2);
        aCyclicList.addToBack(3);
        aCyclicList.addToBack(4);
        aCyclicList.addToBack(5);
        aCyclicList.addToBack(6);
        aCyclicList.addToBack(7);
        
        System.out.println(CyclicListTest(aCyclicList.head));
    }
}