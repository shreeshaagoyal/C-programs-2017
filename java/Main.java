import java.util.ArrayList;
import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        /*
        int[] a = {2, 5, 8};
        int[] b = {1, 6, 7, 9};

        int size = 100000;

        long startTime = System.currentTimeMillis();
        // int[] resultArr = mergeArrayLists(makeArrayList(true, size), makeArrayList(false, size));
        long endTime = System.currentTimeMillis();

        // System.out.print("Array: ");
        // printArray(resultArr);

        System.out.print("\n");

        System.out.println("Time taken for mergeArrayList: " + (endTime - startTime));

        List listA = new List();
        listA.next = new Node(9);

        List listB = new List();
        listB.next = new Node(2);
        listB.next.next = new Node(5);
        listB.next.next.next= new Node(8);

        List listC = new List();
        listC.next = new Node(1);
        listC.next.next = new Node(6);
        listC.next.next.next = new Node(7);
        listC.next.next.next.next = new Node(9);

        startTime = System.currentTimeMillis();
        // Node mergedLinkedLists = mergeLinkedLists(makeLinkedList(true, size), makeLinkedList(false, size));
        endTime = System.currentTimeMillis();

        // System.out.print("Linked list: ");
        // printNode(mergedLinkedLists);

        System.out.println("Time taken for mergeLinkedLists: " + (endTime - startTime));

        List evenList = makeLinkedList(true, size);
        List oddList = makeLinkedList(false, size);

        startTime = System.currentTimeMillis();
        // mergeLists(evenList, oddList);
        endTime = System.currentTimeMillis();

        System.out.println("Time taken for iterative mergeLinkedLists: " + (endTime - startTime));



        startTime = System.currentTimeMillis();
        primeNumbersBrute(size);
        endTime = System.currentTimeMillis();
        System.out.print("\n");
        System.out.println("Time taken for brute force: " + (endTime - startTime));

        System.out.println("\n");

        startTime = System.currentTimeMillis();
        primeNumbers(size);
        endTime = System.currentTimeMillis();
        System.out.print("\n");
        System.out.println("Time taken for non-brute force: " + (endTime - startTime));

        
        int[] arr = {5, 7, 2, 1, -6, 20, 13};
        printArray(sortList(arr));
        System.out.println("\n\n");

        */

        List list1 = new List();
        list1.next = new Node(9);
        list1.next.next = new Node(9);
        // list1.next.next.next = new Node(3);

        System.out.print("list1: ");
        printNode(list1.next);
        System.out.print("\n");

        List list2 = new List();
        list2.next = new Node(1);
        // list2.next.next = new Node(6);
        // list2.next.next.next = new Node(4);

        System.out.print("list2: ");
        printNode(list2.next);
        System.out.print("\n\n");

        List resultList = addTwoNumbers(list1.next, list2.next);
        System.out.print("sum of two lists: ");
        printNode(resultList.next);

        System.out.println(lengthOfLongestSubstring("pwwkew"));

        System.out.println(isPalindrome("hannah"));

        System.out.println(longestPalindrome("cbbd"));

        HashMap<String, String> names = new HashMap<String, String>();
        names.put("first-name", "Shivanshu");
        names.put("place", "my house");
        System.out.println(templateRender(names, "Hello {first-name} {place}, welcome to {place}"));

        ArrayList<Integer> temp = new ArrayList<Integer>(1);
        System.out.println("temp size: " + temp.size());
    }

    public static int findGCF1(int a, int b) {
        if ((a == 0) || (b == 0)) {
            throw new IllegalArgumentException("Only non-zero numbers allowed");
        }
        int smallerNum;
        if (a < b) {
            smallerNum = a;
        } else {
            smallerNum = b;
        }
        int gcf = 1;
        for (int i = 1; i <= smallerNum; i++) {
            if ((a%i == 0) && (b%i == 0)) {
                gcf = i;
            }
        }
        return gcf;
    }

    public static int findGCF2(int a, int b) {
        while ((a != 0) && (b != 0)) {
            int c = b;
            b = a%b;
            a = c;
        }
        return a+b;
    }

    public static int findGCF(int a, int b) {
        if ((a == 0) || (b == 0)) {
            throw new IllegalArgumentException("Only non-zero numbers allowed");
        }
        int smallerNum;
        if (a < b) {
            smallerNum = a;
        } else {
            smallerNum = b;
        }
        for (int i = smallerNum; i >= 1; i--) {
            if ((a%i == 0) && (b%i == 0)) {
                return i;
            }
        }
        throw new IllegalArgumentException();
    }

    public static int[] primeNumbersBrute(int size) {
        int[] result = new int[size];
        int currNum = 1;
        int cursor = 0;
        
        // special case when size = 0
        if (size == 0) {
            return result;
        }

        while (true) {
            if (isPrime(currNum)) {
                result[cursor] = currNum;
                cursor++;
            }
            currNum++;

            if (cursor == size) {
                break;
            }
        }
        return result;
    }

    public static ArrayList<Integer> primeNumbersBrute2(int size) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        int counter = 0;

        for (int i = 0; counter < size; i++) {
            if (isPrime(i)) {
                result.add(i);
                counter++;
            }
        }

        return result;
    }

    private static Boolean isPrime(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        
        if ((n == 0) || (n == 1)) {
            return false;
        }
        
        int numFactors = 0;
        
        for (int i = 2; i < n; i++) {
            if (n%i == 0) {
                numFactors++;
            }
            if (numFactors > 0) {
                return false;
            }
        }

        return true;
    }

    public static int[] primeNumbers(int size) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int counter = 0;

        for (int i = 2; counter < size; i++) {
            Boolean isPrimeNum = true;

            for (int j = 0; j < result.size(); j++) {
                if (i % (result.get(j)) == 0) {
                    isPrimeNum = false;
                    break;
                }
            }
            if (isPrimeNum) {
                result.add(i);
                counter++;
            }
        }

        return arrayListToIntArray(result);
    }

    private static int[] arrayListToIntArray(ArrayList<Integer> arr) {
        int[] result = new int[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != null) {
                result[i] = arr.get(i);
            }
        }

        return result;
    }

    public static int[] sortList(int[] arr) {
        // base case
        if (arr.length == 1) {
            return arr;
        }

        int[] arrA = new int[arr.length/2];
        for (int i = 0; i < arr.length/2; i++) {
            arrA[i] = arr[i];
        }
        int[] arrB = new int[arr.length - (arr.length/2)];
        for (int i = arr.length/2; i < arr.length; i++) {
            arrB[i-(arr.length/2)] = arr[i];
        }
        int[] list1 = sortList(arrA);
        int[] list2 = sortList(arrB);
        return mergeArrayLists(list1, list2);
    }

    public static int[] mergeArrayLists(int[] arr1, int[] arr2) {
        // base case
        if ((arr1.length == 0) || (arr2.length == 0)) {
            if (arr1.length == 0) {
                return arr2;
            } else {
                return arr1;
            }
        }
        
        if (arr1[0] < arr2[0]) {
            return prependElement(arr1[0], mergeArrayLists(removeElementFromBeginning(arr1), arr2));
        } else {
            return prependElement(arr2[0], mergeArrayLists(arr1, removeElementFromBeginning(arr2)));
        }
    }

    private static int[] prependElement(int e, int[] arr) {
        int[] result = new int[arr.length+1];
        result[0] = e;

        for (int i = 1; i < arr.length+1; i++) {
            result[i] = arr[i-1];
        }

        return result;
    }

    private static int[] removeElementFromBeginning(int[] arr) {
        int[] result = new int[arr.length-1];

        for (int i = 0; i < arr.length-1; i++) {
            result[i] = arr[i+1];
        }

        return result;
    }

/*
    public static List mergeLinkedLists(List a, List b) {
        mergeLinkedLists(a.next, b.next);
        return null;
    }
*/

    private static Node mergeLinkedLists(List listA, List listB) {
        Node a = listA.next;
        Node b = listB.next;
        
        // base case
        if ((a.next == null) || (b.next == null)) {
            if (a.next == null) {
                return mergeBaseCase(listA, listB);
            } else {
                return mergeBaseCase(listB, listA);
            }
        }
        
        if (a.value < b.value) {
            return prependLinkedList(firstOfLinkedList(listA), mergeLinkedLists(listA, listB));
        } else {
            return prependLinkedList(firstOfLinkedList(listB), mergeLinkedLists(listA, listB));
        }
    }

    private static Node prependLinkedList(Node nodeToPrepend, Node n) {
        nodeToPrepend.next = n;
        return nodeToPrepend;
    }

    private static Node firstOfLinkedList(List list) {
        Node tempRef = list.next;
        list.next = list.next.next;
        return tempRef;
    }

    private static Node mergeBaseCase(List singleLength, List list) {
        Node currNode = list.next;
        Node singleNode = singleLength.next;

        if (singleNode.value < currNode.value) {
            singleNode.next = currNode;
            return singleNode;
        }

        while(currNode.next != null) {
            if (currNode.next.value < singleNode.value) {
                currNode = currNode.next;
            } else if (currNode.next.value >= singleNode.value) {
                Node tempRef = currNode.next;
                currNode.next = singleNode;
                singleNode.next = tempRef;
                return list.next;
            }
        }

        currNode.next = singleNode;
        return list.next;
    }

    public static int lengthOf(Node list) {
        int length = 1;
        while (list.next != null) {
            length++;
            list.next = list.next.next;
        }
        return length;
    }

    public static void printNode(Node n) {
        Node currNode = n;
        while(currNode != null) {
            System.out.print(currNode.value);
            System.out.print(", ");
            currNode = currNode.next;
        }
        System.out.println("");
    }

    public static void printList(List list) {
        Node currNode = list.next;
        while(currNode != null) {
            System.out.print(currNode.value);
            System.out.print(", ");
            currNode = currNode.next;
        }
        System.out.println("");
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(", ");
        }
    }

    public static List makeLinkedList(Boolean odd, int size) {
        List list = new List();
        int num;

        if (odd) {
            num = 1;
        } else {
            num = 0;
        }

        Node currNode = new Node(num);
        list.next = currNode;

        for (int i = 1; i < size; i++) {
            num += 2;
            currNode.next = new Node(num);
            currNode = currNode.next;
        }

        return list;
    }

    public static int[] makeArrayList(Boolean odd, int size) {
        int[] arr = new int[size];
        int num;
        if (odd) {
            num = 1;
        } else {
            num = 0;
        }
        for (int i = 0; i < size; i++) {
            arr[i] = num;
            num += 2;
        }
        return arr;
    }



    /** Merger methods */
    public static List mergeLists(List listA, List listB) {
        List resultList = new List();
        resultList.next = new Node();

        Node currentNode = resultList.next; // This is a fake node

        Node cursorA, cursorB;
        cursorA = listA.next;
        cursorB = listB.next;

        Node cursorANext, cursorBNext;
        cursorANext = cursorA.next;
        cursorBNext = cursorB.next;

        while (true) {
            double listAData = getValue(cursorA);
            double listBData = getValue(cursorB);

            if (listAData == Double.POSITIVE_INFINITY && listBData == Double.POSITIVE_INFINITY) {
                break;
            }

            Node smallerNode = (listAData < listBData) ? cursorA : cursorB;

            currentNode.next = smallerNode;
            currentNode = smallerNode;

            if (listAData < listBData) {
                // Update cursorA
                cursorA = cursorANext;
                cursorANext = (cursorA == null) ? null : cursorA.next;
            } else {
                // Update cursorB
                cursorB = cursorBNext;
                cursorBNext = (cursorB == null) ? null :  cursorB.next;
            }
        }

        // Removing fake next:
        resultList.next = resultList.next.next;

        return resultList;
    }

    private static double getValue(Node next) {
        if (next == null) {
            return Double.POSITIVE_INFINITY;
        } else {
            return next.value;
        }
    }

    public static List addTwoNumbers(Node n1, Node n2) {
        makeSameSize(n1, n2);

        List resultList = new List();
        Node currResultNode = new Node(); // temporary node
        resultList.next = currResultNode;

        Node currNode1 = n1;
        Node currNode2 = n2;

        Boolean carryOver = false;

        while ((currNode1 != null) && (currNode2 != null)) {
            int sum = currNode1.value + currNode2.value;
            if (carryOver) {
                sum++;
                carryOver = false;
            }
            if (sum > 9) {
                carryOver = true;
                sum = sum - 10;
            }
            currResultNode.next = new Node(sum);

            currResultNode = currResultNode.next;
            currNode1 = currNode1.next;
            currNode2 = currNode2.next;
        }

        // special case if carry over still left over and need a new node at the end
        if (carryOver) {
            currResultNode.next = new Node(1);
        }

        resultList.next = resultList.next.next;
        return resultList;
    }

    private static void makeSameSize(Node n1, Node n2) {
        Node currNode1 = n1;
        Node currNode2 = n2;

        while ((currNode1.next != null) && (currNode2.next != null)) {
            currNode1 = currNode1.next;
            currNode2 = currNode2.next;
        }

        while ((currNode1.next == null) && (currNode2.next != null)) {
            currNode1.next = new Node(0);
            currNode1 = currNode1.next;
            currNode2 = currNode2.next;
        }

        while ((currNode2.next == null) && (currNode1.next != null)) {
            currNode2.next = new Node(0);
            currNode2 = currNode2.next;
            currNode1 = currNode1.next;
        }
    }

    private static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> alphabetToIndex = new HashMap<Character, Integer>();
        int counter = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (alphabetToIndex.containsKey(s.charAt(i))) {
                i = alphabetToIndex.get(s.charAt(i)) + 1;
                alphabetToIndex.clear();
                counter = 0;
            }
            alphabetToIndex.put(s.charAt(i), i);
            counter++;
            max = Math.max(counter, max);
        }
        return max;
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        int maxLength = 0;
        String result = "";
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                String substring = s.substring(i, j);
                if (isPalindrome(substring)) {
                    if (j - i > maxLength) {
                        result = substring;
                        maxLength = j - i;
                    }
                }   
            }
        }
        return result;
    }

    private static Boolean isPalindrome(String s) {
        int n = s.length();
        int j = n/2 + 1;

        if (n%2 == 0) { // even length string
            j = n/2;
        }

        for (int i = n/2-1; i >= 0; i--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            j++;
        }

        return true;
    }

    public static String templateRender(HashMap<String, String> names, String s) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                MappingResult mappedResult = getMappedString(names, s, i+1);
                String mapped = mappedResult.str;
                result.append(mapped);
                i = mappedResult.endIndex;
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    private static MappingResult getMappedString(HashMap<String, String> names, String s, int index) {
        StringBuffer stringToMap = new StringBuffer();
        int i = index;
        for (; i < s.length(); i++) {
            if (s.charAt(i) == '}') {
                return new MappingResult(names.get(stringToMap.toString()), i);
            }
            stringToMap.append(s.charAt(i));
        }
        return new MappingResult(stringToMap.toString(), i); // throw exception?
    }
}

class MappingResult {
    String str;
    int endIndex;
    public MappingResult(String str, int endIndex) {
        this.str = str;
        this.endIndex = endIndex;
    }
}

class List {
    Node next;
    public List() {
        this.next = null;
    }
}