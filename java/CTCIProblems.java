import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import jdk.nashorn.internal.runtime.arrays.IntOrLongElements;

public class CTCIProblems {
    public static boolean checkPermutation(String str1, String str2) {
        HashSet<Character> charSet = new HashSet<Character>();
        if(str1.length() != str2.length()) {
            return false;
        }
        for(int i = 0; i < str1.length(); i++) {
            charSet.add(str1.charAt(i));
        }
        for(int i = 0; i < str2.length(); i++) {
            if(!charSet.contains(str2.charAt(i))) {
                return false;
            }
        }
        return true;
    }

/** Not space efficient */
    public static StringBuffer reverseString(StringBuffer strbuf) {
        StringBuffer newstr = new StringBuffer();
        for(int k = 0; k < strbuf.length(); k++) {
            newstr.append(' ');
        }
        int i = 0, j = strbuf.length()-1;
        while(i < strbuf.length()) {
            newstr.setCharAt(j, strbuf.charAt(i));
            i++; j--;
        }
        return newstr;
    }

    public static void urlify(StringBuffer strbuf, int length) {
        int scanCursor = length-1;
        int printCursor = strbuf.length()-1;
        for(int i = scanCursor; i >= 0; i--) {
            if(strbuf.charAt(scanCursor) != ' ') {
                strbuf.setCharAt(printCursor, strbuf.charAt(scanCursor));
                printCursor--;
            } else if(strbuf.charAt(scanCursor) == ' ') {
                strbuf.setCharAt(printCursor, '0');
                printCursor--;
                strbuf.setCharAt(printCursor, '2');
                printCursor--;
                strbuf.setCharAt(printCursor, '%');
                printCursor--;
            }
            scanCursor--;
        }
    }

    public static int returnKthToLast(Node head, int k) {
        Node startRef = head;
        Node endRef = head;
        for(int i = 0; i < k; i++) {
            endRef = endRef.next;
        }
        while(endRef != null) {
            endRef = endRef.next;
            startRef = startRef.next;
        }
        return startRef.value;
    }

    public static boolean validateBST(TreeNode n) {
        boolean leftValidation = false;
        boolean rightValidation = false;
        /** Base case */
        if(n.left.left == null) {
            if(n.left.value < n.value) {
                return true;
            } else {
                return false;
            }
        }
        if(n.right.right == null) {
            if(n.right.value > n.value) {
                return true;
            } else {
                return false;
            }
        }

        /** Check if left subtree is a BST */
        leftValidation = validateBST(n.left);
        if(!leftValidation) {
            return false;
        }

        /** Check if right subtree is a BST */
        rightValidation = validateBST(n.right);
        if(!rightValidation) {
            return false;
        }

        /** Check if current tree is a BST */
        return leftValidation && rightValidation;
    }

    public static void inOrderTraversal(TreeNode n) {
        if(n != null) {
            inOrderTraversal(n.left);
            printTreeNode(n);
            inOrderTraversal(n.right);
        }
    }
    private static void printTreeNode(TreeNode n) {
        System.out.println(n.value);
    }

    public static boolean palindromePermutation(String str) {
        HashMap<Character, Integer> stringMap = new HashMap<Character, Integer>();
        // set all values to 0
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                continue;
            }
            stringMap.put(str.charAt(i), 0);
        }

        // increments the value
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                continue;
            }
            stringMap.put(str.charAt(i), stringMap.get(str.charAt(i)) + 1);
        }

        int oddCounter = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                continue;
            }
            if(stringMap.get(str.charAt(i))%2 != 0) {
                oddCounter++;
                if(oddCounter > 1) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /** Adding elements of an array using recursion and separating the first element */
    public static int addArray(int[] arr) {
        return addArray(arr, 0);
    }
    public static int addArray(int[] arr, int index) {
        // base case
        if(index == arr.length - 1) {
            return arr[index];
        } else {
            int sum = arr[index] + addArray(arr, index+1);
            return sum;
        }
    }

    /** Separating array into two halves then adding those parts together */
    public static int addElementsInArray(int[] arr) {
        return addElementsInArray(arr, 0, arr.length-1);
    }
    public static int addElementsInArray(int[] arr, int leftIndex, int rightIndex) {
        // base case
        if(rightIndex - leftIndex == 0) {
            return leftIndex;
        }
        
        int leftSum = addElementsInArray(arr, 0, (rightIndex - leftIndex)/2);
        int rightSum = addElementsInArray(arr, (rightIndex - leftIndex)/2 + 1, rightIndex);
        return leftSum + rightSum;
    }

    public static int findStepsPossibility(int n) {
        // base case
        if(n < 3) {
            return n;
        }
        return (n-1) + findStepsPossibility(n-1);
    }

    public static int countWays(int n) {
        // base case
        if(n < 0) {
            return 0;
        } else if(n == 0) {
            return 1;
        } else {
            return countWays(n-1) + countWays(n-2) + countWays(n-3);
        }
    }

    public static String compressString(String str) {
        StringBuffer strbuf = new StringBuffer();
        char currentChar = str.charAt(0);
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == currentChar) {
                count++;
                continue;
            } else if(str.charAt(i) != currentChar) {
                strbuf.append(currentChar);
                strbuf.append(count);
                currentChar = str.charAt(i);
                count = 1;
            }
        }
        strbuf.append(currentChar);
        strbuf.append(count);
        // see which one to return: the original string, or the compressed string
        return (strbuf.length() < str.length()) ? strbuf.toString() : str;
    }

    public static int[][] rotateMatrix(int[][] matrix, int n) {
        for(int layer = 0; layer <= n/2; layer++) {
            int start = layer;
            int end = n - 1 - layer;
            int j = end;
            for(int i = start; i < end; i++) {
                int temp = matrix[start][i];
                matrix[start][i] = matrix[j][start];
                matrix[j][start] = matrix[end][j];
                matrix[end][j] = matrix[i][end];
                matrix[i][end] = temp;
                j--;
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] twoSum(int[] arr, int target) {
        ArrayList<Integer> arrList = new ArrayList<Integer>(arr.length);
        for(int i = 0; i < arr.length; i++) {
            arrList.add(arr[i]);
        }
        Collections.sort(arrList);
        int index;
        for(index = 0; index < arrList.size(); index++) {
            if(arrList.get(index) > target) {
                break;
            }
        }
        index--;
        System.out.println(index);
        for(int i = 0; i < index/2; i++) {
            System.out.println("i: " + i);
            if((arrList.get(i) + arrList.get(index)) == target) {
                System.out.println("i: " + i);
                int[] result = {arrList.get(i), arrList.get(index)};
                return result;
            }
            index--;
        }
        int[] result = {-1};
        return result;
    }

    public static Node addTwoNumbers(Node n1, Node n2) {
        return addTwoNumbers(n1, n2, 0);
    }
    
    public static Node addTwoNumbers(Node n1, Node n2, int carry) {
        // base case
        if(n1 == null && n2 == null) {
            return null;
        }
        int value = carry + n1.value + n2.value;
        Node result = new Node(value%10);
        carry = value - value%10;
        result.next = addTwoNumbers(n1.next, n2.next, carry);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(checkPermutation("configuration", "guracntionfi"));
        StringBuffer strbuf = new StringBuffer("Mr John Smith    ");
        urlify(strbuf, 13);
        System.out.println(strbuf);
        LList sampleLinkedList = new LList(20);
        sampleLinkedList.addToBack(32);
        sampleLinkedList.addToBack(79);
        System.out.println(returnKthToLast(sampleLinkedList.head, 3));

        /** Testing JStack.java */
        System.out.println("Testing min::JStack.java");
        JStack sampleStack = new JStack(3);
        sampleStack.push(4);
        sampleStack.push(2);
        sampleStack.push(5);
        sampleStack.push(1);
        sampleStack.push(90);
        System.out.println(sampleStack.min());
        System.out.println(sampleStack.pop());
        System.out.println(sampleStack.pop());
        System.out.println(sampleStack.min());

        /** Testing validateBST */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(11);
        root.right.right = new TreeNode(13);

        /** Testing inOrderTraversal */
        System.out.println("Testing inOrderTraversal method");
        inOrderTraversal(root);

        /** Testing palindromePermutation */
        System.out.println(palindromePermutation("taco  cat"));

        /** Testing addArray */
        int[] arr = {6, 8, 12, 3, 15, 3, 2, 4};
        System.out.println(addArray(arr));

        /** Testing addElementsInArray */
        // System.out.println(addElementsInArray(arr));

        /** Testing findStepsPossibility */
        // System.out.println(findStepsPossibility(100));

        /** Testing countWays */
        // System.out.println(countWays(100));

        /** Testing compressString */
        System.out.println("\nTesting compressString method\n");
        System.out.println(compressString("abcd"));

        /** Testing rotateMatrix */
        System.out.println("Testing rotateMatrix method");
        int[][] matrix = {  {1, 2, 3, 4, 5},
                            {6, 7, 8, 9, 10},
                            {11, 12, 13, 14, 15},
                            {16, 17, 18, 19, 20},
                            {21, 22, 23, 24, 25}
                            };
        printMatrix(rotateMatrix(matrix, matrix.length));

        /** Testing twoSum */
        System.out.println("Testing twoSum method from LeetCode");
        int[] array = {3, 2, 4, 1};
        System.out.println(java.util.Arrays.toString(twoSum(array, 7)));

        /** Testing addTwoNumbers */
        System.out.println("Testing addTwoNumbers method");
        Node n1 = new Node(2);
        
    }

}