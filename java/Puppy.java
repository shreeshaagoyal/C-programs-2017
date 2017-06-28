public class Puppy {
    int puppyAge;

    public Puppy(String name) {
        //constructor
        System.out.println("Puppy's name is: " + name);
    }

    public void setAge(int age) {
        puppyAge = age;
    }

    public int getAge() {
        System.out.println("Puppy's age is: " + puppyAge);
        return puppyAge;
    }

    public static void main(String []args) {
        Puppy myPup = new Puppy("Scruffy");
        myPup.setAge(2);
        myPup.getAge();
        System.out.println("Variable value (puppy's age): " + myPup.puppyAge);

    }
}