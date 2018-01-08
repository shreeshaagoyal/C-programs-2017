import java.util.List;
import java.util.ArrayList;
public class Practice {
    public static void main(String[] args) {
        String[] result = permutation("abc");
        printStringArr(result);

        int[] numsA = {2, 4, 8, 9, 20, 23, 24, 25, 26};
        int[] numsB = {4, 5, 6, 9, 10, 11, 23};
        System.out.println(numSameNumbers(numsA, numsB));

        int[] arr = {1, 3};

        System.out.println(findIndexInSorted2(arr, 3));

        String[] words = {"abab", "aba", ""};
        System.out.println(longestPrefix(words));
    }

    public static String[] permutation(String str) {
        if (str.length() == 1) {
            String[] result = {str};
            return result;
        }
        char firstChar = str.charAt(0);
        String[] permutations = permutation(str.substring(1));
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < permutations.length; i++) {
            String currString = permutations[i];
            for (int j = 0; j <= currString.length(); j++) {
                String insertedStr = insertCharAt(currString, j, firstChar);
                result.add(insertedStr);
            }
        }
        return convertToStringArr(result);
    }

    private static String[] convertToStringArr(List<String> strings) {
        String[] result = new String[strings.size()];
        for (int i = 0; i < strings.size(); i++) {
            result[i] = strings.get(i);
        }
        return result;
    }

    private static String insertCharAt(String str, int index, char c) {
        StringBuffer result = new StringBuffer(str);
        result.insert(index, c);
        return result.toString();
    }

    private static void printStringArr(String[] stringArr) {
        for (int i = 0; i < stringArr.length; i++) {
            System.out.println(stringArr[i]);
        }
    }

    public static int numSameNumbers(int[] numsA, int[] numsB) {
        int counter = 0;
        int cursorA = 0, cursorB = 0;
        while (cursorA < numsA.length) {
            if (cursorB >= numsB.length) {
                break;
            }
            if (numsA[cursorA] == numsB[cursorB]) {
                System.out.println("incrementing counter... " + numsA[cursorA]);
                counter++;
                cursorA++;
            } else if (numsA[cursorA] < numsB[cursorB]) {
                cursorA++;
            } else if (numsA[cursorA] > numsB[cursorB]) {
                cursorB++;
            }
        }

        return counter;
    }

    public static int partiallySortedIndex(int[] nums) {
        return partiallySortedIndex(nums, 0, nums.length - 1);
    }

    private static int partiallySortedIndex(int[] nums, int start, int end) {
        // base case
        if (end - start == 0) {
            return start;
        }
        if (end - start == 1) {
            if (nums[start] < nums[end]) {
                return start;
            } else {
                return end;
            }
        }

        int middle = (start + end) / 2;

        if (nums[start] < nums[middle]) {
            return partiallySortedIndex(nums, middle, end);
        }
        if (nums[start] > nums[middle]) {
            return partiallySortedIndex(nums, start, middle);
        } else {
            return start;
        }
    }

    public static int findIndexInSorted(int[] nums, int num) {
        return findIndexInSorted(nums, 0, nums.length-1, num);
    }

    private static int findIndexInSorted(int[] nums, int start, int end, int num) {
        if (start == end) {
            return start;
        }

        if (end-start == 1) {
            if (nums[start] == num) {
                return start;
            } else if (nums[end] == num) {
                return end;
            } else {
                throw new RuntimeException("Cannot find given number: " + num);
            }
        }

        int middle = (start + end) / 2;

        if (nums[middle] == num) {
            return middle;
        } else if (nums[middle] < num) {
            return findIndexInSorted(nums, middle, end, num);
        } else {
            return findIndexInSorted(nums, start, middle, num);
        }
    }

    public static int findIndexInSorted2(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while(end-start > 1) {
            int middle = (start + end) / 2;
            if (arr[middle] == target) {
                return middle;
            } else if (arr[middle] < target) {
                start = middle;
            } else if (arr[middle] > target) {
                end = middle;
            }
        }

        if ((end-start == 0) || (end-start == 1)) {
            if (arr[start] == target) {
                return start;
            } else if (arr[end] == target) {
                return end;
            }
        }

        throw new RuntimeException("Given number could not be found: " + target);
    }

    public static int reverseInt(int n) {
        int result = 0;
        int remainder = 0;

        while(n != 0) {
            remainder = n%10;
            int newResult = (result * 10) + remainder;
            if ((newResult - remainder) / 10 != result) {
                return 0;
            } else {
                result = newResult;
            }
            n = n / 10;
        }
        
        return result;
    }

    public static String longestPrefix(String[] words) {
        if (words.length == 0) {
            return "";
        }

        StringBuffer base = new StringBuffer(words[0]);

        for (int i = 0; i < words.length; i++) {
            String currWord = words[i];
            int currWordLength = currWord.length();

            for (int j = 0; j < base.length(); j++) {
                if (currWordLength == 0) {
                    StringBuffer result = new StringBuffer("");
                    base = result;
                    break;
                }
                
                if (currWord.charAt(j) != base.charAt(j)) {
                    base = removeSubstring(base, j);
                    break;
                }

                if (j == currWordLength - 1) {
                    base = removeSubstring(base, j + 1);
                }
            }
        }

        return base.toString();
    }

    private static StringBuffer removeSubstring(StringBuffer base, int start) {
        if (start >= base.length()) {
            return base;
        }

        StringBuffer result = new StringBuffer(start);
        for (int i = 0; i < start; i++) {
            result.append(base.charAt(i));
        }

        return result;
    }

    public String longestCommonPrefix(String[] strs) {
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
}