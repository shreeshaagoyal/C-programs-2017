public class LListTest {
    public static void main(String[] args) {
        LList newList = new LList(4);
        newList.addToFront(3);
        newList.addToFront(2);
        newList.addToFront(1);
        newList.addToFront(0);
        newList.addToBack(5);
        newList.addToBack(90);
        for(int i = 0; i < 7; i++) {
            System.out.println(newList.get(i));
        }
        newList.clear();
        System.out.println(newList.get(2));
    }
}