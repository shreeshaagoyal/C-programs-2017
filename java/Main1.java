import java.io.*;
public class Main {
    public static void main(String[] args) {        
        char character = 48 + (7%10);
        System.out.println(character);
    }

    public static int findNumberOfDigits(int num) {
        int i = 1;
        while(num > 0) {
            num = num - (num % (int) Math.pow(10, i));
            i++;
        }
        return i-1;
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
    public static boolean checkPalindrome(String a) {
        int i = 0;
        int j = a.length()-1;
        while(i < a.length()/2 && j >= a.length()/2) {
            if(a.codePointAt(i) != a.codePointAt(j)) {
                return false;
            }
            i++; j--;
        }
        return true;
    }
}