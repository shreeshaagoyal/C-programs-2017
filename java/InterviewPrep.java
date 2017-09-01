import java.util.ArrayList;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class InterviewPrep {
    public static int calculateClockAngle(int hand1, int hand2) {
        int result = Math.abs(hand1 - hand2);
        if((0 <= result) && (result < 30)) {
            return result;
        } else if((0 <= result) && (result < 60)) {
            return 60 - result;
        } else {
            throw new IllegalArgumentException("Input must be in the range [0, 59]");
        }
    }

    public static int removeDuplicates(int[] arr) {
        int duplicateCursor = 0;
        HashSet<Integer> uniqueElements = new HashSet<Integer>();
        for(int scanCursor = 0; scanCursor < arr.length; scanCursor++) {
            if(!uniqueElements.contains(arr[scanCursor])) {
                uniqueElements.add(arr[scanCursor]);
                arr[duplicateCursor] = arr[scanCursor];
                duplicateCursor++;
            } else {
                continue;
            }
        }
        return duplicateCursor;
    }

    public static void reverseString(StringBuffer str) {
        int j = str.length() - 1;
        char temp = ' ';
        for(int i = 0; i < str.length()/2; i++) {
            temp = str.charAt(i);
            str.setCharAt(i, str.charAt(j));
            str.setCharAt(j, temp);
            j--;
        }
    }

    public static boolean palindromeNumber(int num) {
        return false;
    }

    private static int reverseInteger(int num) {
        int digits = numberOfDigits(num);
        int j = digits - 1;
        int result = 0;
        int modNum = 0;
        int tempResult = 0;
        for(int i = 0; i < digits-1; i++) {
            int powerOfTen = (int) Math.pow(10, j);
            modNum = num % powerOfTen;
            tempResult = (num - modNum) / powerOfTen;
            result += tempResult * ((int) Math.pow(10, i));
            j--;
            num = modNum;
        }
        result += num * ((int) Math.pow(10, digits-1));
        return result;
    }

    private static int numberOfDigits(int num) {
        int i = 1;
        while(num > 0) {
            num = num - (num % (int) Math.pow(10, i));
            i++;
        }
        return i-1;
    }

    public static void main(String[] args) {
        System.out.println(reverseInteger(09090));
    }
}