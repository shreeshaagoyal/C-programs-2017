class Car {
    int distance;

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String toPrintableString() {
        String s = new String();
        s = "Distance: " + this.distance;
        return s;
    }

    public static double kphToMph(double kph) {
        return kph * 0.621371;
    }

    public static void bar() {
        // foo();
    }
}

public class NewClass {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.setDistance(1000);
        car1.setDistance(2000);

        Car car2 = new Car();
        car2.setDistance(5000);

        double mph = Car.kphToMph(50);

        System.out.println(car1.toPrintableString());
        System.out.println(car2.toPrintableString());
        System.out.println("Speed is " + mph);
    }
}