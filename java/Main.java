import java.io.*;
public class Main {
    public static void main(String[] args) {
        try {
            int[] array = {0,1};
            System.out.println("Access element three: " + array[2]);
        } catch(AbstractMethodError e1) {
            System.out.println("1 Exception thrown: " + e1);
        } catch(ArrayStoreException e2) {
            System.out.println("2 Exception thrown: " + e2);
        } catch(ArrayIndexOutOfBoundsException e3) {
            System.out.println("3 Exception thrown: " + e3);
        }
        System.out.println("Out of the block");
    }
}