import java.util.ArrayList;
public class Person2 {
    private int age;
    private String status;

    public Person2(){
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
        Person2 bubbles = new Person2();
        Person2 buttercup = new Person2();
        Person2 blossom = new Person2();
        ArrayList<Person2> people = new ArrayList<Person2>();
        people.add(bubbles);
        people.add(buttercup);
        people.add(blossom);
        int ageAmount = 1;
        for(Person2 p:people){
            p.getOlderByYears(ageAmount++);
            // p.getOlderByYears(ageAmount);
            // ageAmount++;

            //POINT A
        }
        //POINT B
    }
}