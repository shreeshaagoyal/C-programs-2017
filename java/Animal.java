class Animal {
    public void move() {
        System.out.println("Animal can move");
    }
}

class Dog extends Animal {
    public void move() {
        super.move();
        System.out.println("Dog can walk and run");
    }
    public void bark() {
        System.out.println("Dog can bark");
    }
}