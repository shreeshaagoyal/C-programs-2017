import java.util.HashSet;

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

    public static void main(String[] args) {
        // Testing HashMap2.java, Bucket2.java, Entry2.java classes
        HashMap2 testHashMap2 = new HashMap2(4);
        System.out.println(testHashMap2.calculateIndex("Shreeshaa"));
        System.out.println(testHashMap2.calculateIndex("Shreeshaa"));
        System.out.println(testHashMap2.calculateIndex("Shivanshu"));
        testHashMap2.add("Shreeshaa", 4);
        testHashMap2.add("Shivanshu", 20);
        //System.out.println(testHashMap2.get("Shivanshu"));
        System.out.println(testHashMap2.size());
    }
}