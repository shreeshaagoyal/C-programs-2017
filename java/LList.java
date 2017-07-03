public class LList {
    Node head;
    Node tail;
    public void LList(int e) {
        Node init = new Node(e);
        this.head = init;
        this.tail = init;
    }
    public void addToFront(int e) {
        Node newNode = new Node(e);
        newNode.next = this.head;
        this.head = newNode;
    }
    public void addToBack(int e) {
        Node newNode = new Node(e);
        this.tail.next = newNode;
        this.tail = newNode;
    }
    public int get(int index) {
        Node temp = head.next;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
    }
    public void clear() {
    }
}