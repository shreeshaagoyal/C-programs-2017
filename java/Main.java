public class Main {
    public static void main(String []args) {
        double[] myList = {4.3, 6.78, 9.09, 3.5};
        for(int i = 0; i < myList.length; i++) {
            System.out.println(myList[i]);
        }
        System.out.print("\n");
        for( double x : myList) {
            System.out.println(x);
        }
    }
}