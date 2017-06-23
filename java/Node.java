public class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public void print() {
        System.out.println("Node: data = " + this.data);
    }
}