class Circle implements Shape {
    double dim;
    public Circle(double dim) {
        this.dim = dim;
    }
    public double getArea() {
        return this.dim * this.dim * Math.PI;
    }
}

class Square implements Shape {
    double dim;
    public Square(double dim) {
        this.dim = dim;
    }
    public double getArea() {
        return this.dim * this.dim;
    }
}

interface Shape {
    public double getArea();
}

public class MyFirstJavaProgram {
    public static void main(String []args) {
        Circle c1 = new Circle(5);
        Square s1 = new Square(6);
        Shape sh1 = new Circle(7);

        c1.getArea();
        s1.getArea();
        sh1.getArea();
    }
}