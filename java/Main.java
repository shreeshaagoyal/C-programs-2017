public class Main {
    int x;

    Main() {
        x = 10;
    }

    public static void main(String[] args) {
        Main num1 = new Main();
        Main num2 = new Main();
        System.out.println(num1.x);
        System.out.println(num2.x);
    }
}