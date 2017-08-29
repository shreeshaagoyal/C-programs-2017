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
            return duplicateCursor;
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }
}