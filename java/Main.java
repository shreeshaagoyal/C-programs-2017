import java.io.*;
public class Main {
    public static void main(String[] args) {
        JSet foo = new JSet();
        foo.add("shivanshu");
        foo.add("shreeshaa");
        System.out.println(foo.contains("fjkdls"));
        System.out.println(foo.contains("shivanshu"));
        System.out.println(compare("zamit", "pandhi"));
        System.out.println(compare("dogs", "dogs"));
    }
    public static int compare(String a, String b) {
        int shorterWordLength;
        if(a.length() > b.length()) {
            shorterWordLength = b.length();
        } else {
            shorterWordLength = a.length();
        }
        for(int i = 0; i < shorterWordLength; i++) {
            if(a.codePointAt(i) > b.codePointAt(i)) {
                return 1;
            } else if(a.codePointAt(i) < b.codePointAt(i)) {
                return -1;
            }
        }
        if(a.length() > b.length()) {
            return 1;
        } else if(a.length() < b.length()) {
            return -1;
        } else {
            return 0;
        }
    }
}