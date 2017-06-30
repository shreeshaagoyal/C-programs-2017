public class Main2 {
    private String name;
    private int age;

    Main2() {
        this.age = 18;
        this.name = "";
    }

    Main2(int age) {
        this();
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAge(int age1, int age2) {
        this.age = age1 + age2;
        System.out.println("Person's age is: " + this.age);
    }
}

public class Main {
    public static void main(String[] args) {
        Main2 shivanshu, shreeshaa;
        shivanshu = new Main2();
        shreeshaa = new Main2(23);
        shivanshu.setAge(12, 13);
        System.out.println(shivanshu.age);
        System.out.println(shreeshaa.age);
    }
}