public class LList {
    Node head;
    Node tail;
    public LList(int e) {
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
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.value;
    }
    public void clear() {
        tail.next = null;
        head.next = null;
    }

    public void print() {
        Node n = this.head;
        while(true) {
            if(n == this.tail) {
                System.out.println(n.value);
                break;
            }
            System.out.print(n.value + " -> ");
            n = n.next;
        }
    }
}