public class ImaginaryNum {
    int a, b;
    
    public ImaginaryNum(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public ImaginaryNum add(ImaginaryNum x) {
        ImaginaryNum result = new ImaginaryNum(this.a + x.a , this.b + x.b);
        return result;
    }

    public ImaginaryNum subtract(ImaginaryNum x) {
        ImaginaryNum result = new ImaginaryNum(this.a - x.a , this.b - x.b);
        return result;
    }

    public ImaginaryNum multiply(ImaginaryNum x) {
        ImaginaryNum result = new ImaginaryNum((this.a * x.a) + (this.b * x.b * -1), (this.a * x.b) + (this.b * x.a));
        return result;
    }

    public void printNum() {
        System.out.println(this.a + " + (" + this.b + ")i");
    }

    public static void main(String[] args) {
        ImaginaryNum num1 = new ImaginaryNum(3, -2);
        ImaginaryNum num2 = new ImaginaryNum(4, 1);
        ImaginaryNum num3;
        num1.printNum();
        num2.printNum();
        num3 = num1.add(num2);
        System.out.print("Sum of num1 and num2: ");
        num3.printNum();
        num3 = num1.subtract(num2);
        System.out.print("Difference of num1 and num2: ");
        num3.printNum();
        num3 = num1.multiply(num2);
        System.out.print("Product of num1 and num2: ");
        num3.printNum();
    }
}