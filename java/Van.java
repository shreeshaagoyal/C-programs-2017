public class Van extends Vehicle {
    public void extendBackSeat() {
        System.out.println("Van extending backseat");
    }
    public void brake() {
        System.out.println("Van braking");
    }

    public static void main(String[] args) {
        Vehicle v = getVehicle();
        v.brake();
    }

    public static Vehicle getVehicle() {
        Car c = new Car();
        Boat b = new Boat();
        int num = rand(1, 10);
        if (num < 5) {
            return c;
        } else {
            return b;
        }
    }

    public static void foo() {
        Boat b = new Boat(); // object is of type Boat AND Vehicle
        Vehicle v = new Vehicle(); // object is NOT of type Boat BUT IS of type Vehicle
        if (b instanceof Boat) {

        }
        if (b instanceof Vehicle) {
            
        }
        b.fanOn();
        v.fanOn();
    }

    public static Boat getBoat() {
        
    }

}