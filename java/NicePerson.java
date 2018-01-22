public interface Flyer {
  public void fly();
}

 
public class Penguin implements Flyer {
  @Override
  public void fly() {
      System.out.println("EEEEEEEEEEEEK!");
  }
}

 
public class Seagull implements Flyer {
  @Override
  public void fly() {
      System.out.println("flap flap");
  }
}

 

public class NicePerson {
    public static void main(String[] args) {
        NicePerson nicePerson = new NicePerson();
        Flyer penguin = new Penguin();
        Flyer seagull = new Seagull();
        nicePerson.setFreeOutWindow(seagull); //A
        System.out.println("start of b and c ------------");
        nicePerson.setFreeOutWindow(penguin); //B
        nicePerson.feedFish(seagull);         //C
    }
 
    public void setFreeOutWindow(Flyer flyer){
        System.out.println("Be free, oh flyer!");
        flyer.fly();
    }

    public void feedFish(Penguin penguin){
        System.out.println("Have some fish!");
    }

}