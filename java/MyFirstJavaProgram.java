class Circle {
    double dim;
    public Circle(double dim) {
        this.dim = dim;
    }
    public double getArea() {
        return this.dim * this.dim * Math.PI;
    }
}

class Square {
    double dim;
    public Square(double dim) {
        this.dim = dim;
    }
    public double getArea() {
        return this.dim * this.dim;
    }
}

class Shape {
    Circle circleObj;
    Square squareObj;
    ShapeType type;
    enum ShapeType {SQUARE, CIRCLE};
    public Shape(ShapeType type, double dim) {
        this.type = type;
        if (type == ShapeType.SQUARE) {
            this.squareObj = new Square(dim);
        } else {
            this.circleObj = new Circle(dim);
        }
    }
    public double getArea() {
        if (this.type == ShapeType.SQUARE) {
            return this.squareObj.getArea();
        } else {
            return this.circleObj.getArea();
        }
    }
}

public class MyFirstJavaProgram {
    public static void main(String []args) {
        Circle c1 = new Circle(5);
        Square s1 = new Square(6);
        Shape sh1 = new Shape(Shape.ShapeType.SQUARE, 7);

        c1.getArea();
        s1.getArea();
        sh1.getArea();
    }
}