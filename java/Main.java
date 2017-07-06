import java.io.*;
public class Main {
    public static void main(String[] args) {
        JSet foo = new JSet();
        foo.add("shivanshu");
        foo.add("shreeshaa");
        System.out.println(foo.contains("fjkdls"));
        System.out.println(foo.contains("shivanshu"));
    }
    public int compare(String a, String b) {
        int longerWordLength;
        if(a.length > b.length) {
            longerWordLength = a.length;
        } else {
            longerWordLength = b.length;
        }
        for(int i = 0; i < longerWordLength; i++) {
            if(a.codePointAt(i) > b.codePointAt(i)) {
                return 1;
            } else if(a.codePointAt(i) < b.codePointAt(i)) {
                return -1;
            }
        }
        return 0;
    }
}