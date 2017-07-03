import java.io.*;
import java.util.LinkedList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        AList list = new AList(3);
        list.add(2);
        list.add(5);
        list.add(6);
        list.add(7);
        for (int i = 0; i < 10; i++) {
            list.add(i*i);
        }
        for (int i = 0; i < 14; i++) {
            int num = list.get(i);
            System.out.println(num);
        }
    }
}