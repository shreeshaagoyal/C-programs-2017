class Circle implements Shape {
    double dim;
    public Circle(double dim) {
        this.dim = dim;
    }
    public double getArea() {
        return this.dim * this.dim * Math.PI;
    }
    public double getCirc() {
        return 2 * Math.PI * this.dim;
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
        Shape sh1;
        
        int inputFromUser = 101;
        if (inputFromUser < 100) {
            sh1 = new Circle(7);
        } else {
            sh1 = new Square(7);
        }
        
        Circle c2 = (Circle) sh1;

        c1.getCirc();
        s1.getArea();
        c2.getCirc();
    }

    
}