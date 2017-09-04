public class Shivanshu {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        String a, b;
        a = new String("foo");
        b = new String("foo");

        TrieValue c, d;
        c = new TrieValue('a');
        d = new TrieValue('b');

        System.out.println(c.hashCode());
        System.out.println(d.hashCode());
        System.out.println(c.equals(d));
    }
}