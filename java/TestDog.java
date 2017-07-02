public class TestDog {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.move();
        Animal b = new Dog();
        b.move();
        b.bark();
        a.bark();
    }
}