public class My_Calculation extends Calculation {
    public void multiplication(int x, int y) {
        this.z = x * y;
        System.out.println("Product is: " + this.z);
    }
    public static void main(String[] args) {
        int a = 30, b = 10;
        My_Calculation demo = new My_Calculation();
        demo.addition(a, b);
        demo.subraction(a, b);
        demo.multiplication(a, b);

        //????
        Calculation cal = new My_Calculation();
        demo.addition(a, b);
        demo.multiplication(a, b);
    }
}