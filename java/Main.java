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
        //System.out.println(checkPalindrome("hannah"));
    }
    public static int compare(String a, String b) {
        for(int i = 0; i < shorterWordLength(a, b); i++) {
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
    private static int shorterWordLength(String a, String b) {
        if(a.length() > b.length()) {
            return b.length();
        } else {
            return a.length();
        }
    }
    /*
    public static boolean checkPalindrome(String a) {
        for(int i = 0; i < a.length()/2; i++) {
            if(a.codePointAt(i) != a.codePointAt(j)) {
                return false;
            }
        }
        return true;
    }
    */

    public static boolean checkPalindrome(String a) {
        int i = 0; j = a.length();
        while(i < a.length/2 && j >= a.length/2) {
            if(a.codePointAt(i) != a.codePointAt(j)) {
                return false;
            }
            i++; j--;
        }
        return true;
    }
}

for (int i = 0; i < 3; i++) {

}

int i = 0;
while(i < 3) {
    i++;
}