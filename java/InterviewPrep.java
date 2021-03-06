import java.util.ArrayList;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Stack;

public class InterviewPrep {
    public static int calculateClockAngle(int hand1, int hand2) {
        int result = Math.abs(hand1 - hand2);
        if ((0 <= result) && (result < 30)) {
            return result;
        } else if ((0 <= result) && (result < 60)) {
            return 60 - result;
        } else {
            throw new IllegalArgumentException("Input must be in the range [0, 59]");
        }
    }

    public static int removeDuplicates(int[] arr) {
        int duplicateCursor = 0;
        HashSet<Integer> uniqueElements = new HashSet<Integer>();
        for (int scanCursor = 0; scanCursor < arr.length; scanCursor++) {
            if (!uniqueElements.contains(arr[scanCursor])) {
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
        for (int i = 0; i < str.length() / 2; i++) {
            temp = str.charAt(i);
            str.setCharAt(i, str.charAt(j));
            str.setCharAt(j, temp);
            j--;
        }
    }

    public static boolean palindromeNumber(int num) {
        if (num == reverseInteger(num)) {
            return true;
        } else {
            return false;
        }
    }

    private static int reverseInteger(int num) {
        int digits = numberOfDigits(num);
        int j = digits - 1;
        int result = 0;
        int modNum = 0;
        int tempResult = 0;
        for (int i = 0; i < digits - 1; i++) {
            int powerOfTen = (int) Math.pow(10, j);
            modNum = num % powerOfTen;
            tempResult = (num - modNum) / powerOfTen;
            result += tempResult * ((int) Math.pow(10, i));
            j--;
            num = modNum;
        }
        result += num * ((int) Math.pow(10, digits - 1));
        return result;
    }

    private static int numberOfDigits(int num) {
        int i = 1;
        while (num > 0) {
            num = num - (num % (int) Math.pow(10, i));
            i++;
        }
        return i - 1;
    }

    public static int removeElement(int[] nums, int val) {
        int slowCursor = 0;
        for (int fastCursor = 0; fastCursor < nums.length; fastCursor++) {
            if (nums[fastCursor] == val) {
                continue;
            } else {
                nums[slowCursor] = nums[fastCursor];
                slowCursor++;
            }
        }
        return slowCursor;
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[arr.length - 1]);
    }

    public static boolean isValid(String s) {
        if (s.length() == 0) {
            throw new IllegalArgumentException("No characters found");
        }
        Stack<Character> brackets = new Stack<Character>();
        brackets.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (brackets.empty()) {
                brackets.push(s.charAt(i));
            } else if (oppositeParentheses(brackets.peek()) == s.charAt(i)) {
                brackets.pop();
            } else {
                brackets.push(s.charAt(i));
            }
        }
        if (brackets.empty()) {
            return true;
        } else {
            return false;
        }
    }

    private static char oppositeParentheses(char bracket) {
        if (bracket == '(') {
            return ')';
        } else if (bracket == '[') {
            return ']';
        } else if (bracket == '{') {
            return '}';
        } else {
            return '\u0000';
        }
    }

    public static String leastCommonWord(String sentence) {

        HashMap<String, Integer> wordFrequency = new HashMap<String, Integer>();
        String[] wordsArr = stringToWords(sentence);

        if (wordsArr.length == 0) {
            throw new IllegalArgumentException("No words found");
        }

        for (int i = 0; i < wordsArr.length; i++) {
            if (wordFrequency.containsKey(wordsArr[i])) {
                wordFrequency.put(wordsArr[i], wordFrequency.get(wordsArr[i]) + 1);
            } else {
                wordFrequency.put(wordsArr[i], 1);
            }
        }

        double frequency = Double.POSITIVE_INFINITY;
        String result = wordsArr[0];
        for (int i = 0; i < wordsArr.length; i++) {
            if (wordFrequency.get(wordsArr[i]) < frequency) {
                frequency = wordFrequency.get(wordsArr[i]);
                result = wordsArr[i];
            }
        }

        return result;
    }

    private static String[] stringToWords(String sentence) {
        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                continue;
            }
            StringBuffer word = new StringBuffer();
            while ((sentence.charAt(i) != ' ') && (i < sentence.length() - 1)) {
                word.append(sentence.charAt(i));
                i++;
            }
            words.add(word.toString());
        }

        String[] result = new String[words.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = words.get(i);
        }

        return result;
    }

    public static int searchInsert(int[] nums, int target) {
        return searchInsert(nums, 0, nums.length - 1, target);
    }

    private static int searchInsert(int[] nums, int start, int end, int target) {
        // base case
        if (end - start <= 0) {
            if (target < nums[start]) {
                return start;
            } else {
                return start + 1;
            }
        }

        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return searchInsert(nums, mid + 1, end, target);
        } else {
            return searchInsert(nums, start, mid - 1, target);
        }
    }

    public static int mostFrequent(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Empty array");
        }

        HashMap<Integer, Integer> frequencyNums = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (frequencyNums.containsKey(arr[i])) {
                frequencyNums.put(arr[i], frequencyNums.get(arr[i]) + 1);
            } else {
                frequencyNums.put(arr[i], 1);
            }
        }

        int maxNum = arr[0];
        double maxFrequencySoFar = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < arr.length; i++) {
            if (frequencyNums.get(arr[i]) > maxFrequencySoFar) {
                maxFrequencySoFar = frequencyNums.get(arr[i]);
                maxNum = arr[i];
            }
        }

        return maxNum;
    }

    /** 
    Given a sorted array like the following:
    [2, 5, 7, 8, 9, 10, 22]
    
    And a target value like the following:
    15
    
    Find 2 elements in the array which add up to that number
     */

    public static Tuple findTwoElements(int[] arr, int target) {
        return findTwoElements(arr, target, 0, arr.length - 1);
    }

    private static Tuple findTwoElements(int[] arr, int target, int leftIndex, int rightIndex) {
        int sum = arr[leftIndex] + arr[rightIndex];
        // base case
        if (rightIndex < 0) {
            return null;
        }
        if (leftIndex > arr.length - 1) {
            return null;
        }
        if (rightIndex - leftIndex == 0) {
            return null;
        }

        if (sum == target) {
            Tuple result = new Tuple();
            result.first = arr[leftIndex];
            result.second = arr[rightIndex];
            return result;
        } else if (sum > target) {
            return findTwoElements(arr, target, leftIndex, rightIndex - 1);
        } else {
            return findTwoElements(arr, target, leftIndex + 1, rightIndex);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        if(nums.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }
        HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if(indexMap.containsKey(nums[i])) {
                int[] result = {i, indexMap.get(nums[i])};
                return result;
            } else {
                indexMap.put(difference, i);
            }
        }
        int[] nullResult = {};
        return nullResult;
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) {
            return strs[0];
        }
        if(strs.length == 0) {
            return "";
        }
        StringBuffer base = null;
        double minLengthSoFar = Double.POSITIVE_INFINITY;
        for(int i = 0; i < strs.length; i++) {
            if(strs[i].length() < minLengthSoFar) {
                base = new StringBuffer(strs[i]);
                minLengthSoFar = strs[i].length();
            }
        }
        for(int i = 0; i < strs.length; i++) {
            String curWord = strs[i];
            for(int j = 0; j < base.length(); j++) {
                if(curWord.charAt(j) == base.charAt(j)) {
                    continue;
                } else {
                    base.delete(j, base.length());
                    break;
                }
            }
        }
        return base.toString();
    }


    // Find the contiguous subarray within an array (containing at least one number)
    // which has the largest sum.
    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            ans = Math.max(sum, ans);
        }
        return ans;
    }

    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        for(int i = length-1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            } else if(digits[i] == 9) {
                digits[i] = 0;
            }
        }
        int[] newArr = new int[length + 1];
        newArr[0] = 1;
        return newArr;
    }

    public static int climbingStairs(int n) {
        if(n < 1) {
            throw new IllegalArgumentException("Stairs must be at least one step long");
        }
        if(n < 3) {
            return n;
        }
        int first = 1;
        int second = 2;
        int third = first + second;
        for(int i = 3; i < n; i++) {
            first = second;
            second = third;
            third = first + second;
        }
        return third;
    }

    public static createTree(int[] preOrderArr, int[] inOrderArr) {
        int preOrderCursor = 0;
        int inOrderCursor = 0;
        TreeNode root = new TreeNode(preOrderArr[0]);
        
    }

    public static void main(String[] args) {
        System.out.println(climbingStairs(6));
    }
}