import java.util.ArrayList;
public class Person {
    private int age;
    private String status;

    public Person(){
        this.status="young";
        this.age=0;
    }

    public void getOlderByYears(int years){
        this.age = this.age+years;
        if (age>1){
            status="old";
        }
    }

    public static void main(String[] args) {
        Person bubbles = new Person();
        Person buttercup = new Person();
        Person blossom = new Person();
        ArrayList<Person> people = new ArrayList<>();
        people.add(bubbles);
        people.add(buttercup);
        people.add(blossom);
        int ageAmount = 1;
        for(Person p:people){
            p.getOlderByYears(ageAmount++);
            //POINT A
            System.out.println("bubbles: " + bubbles.status);
            System.out.println("buttercup: " + buttercup.status);
            System.out.println("blossom: " + blossom.status);
        }
        //POINT B
        System.out.println("ageAmount: " + ageAmount);
    }
}