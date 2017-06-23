public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Node n1, n2;
        n1 = new Node(12);
        n2 = new Node(11);
        n1.next = n2;
        n2.next = null;

        n1.print();
        n2.print();
    }
}