class Main {
    public static void main(String[] args) {
        int[] a = {2, 5, 8};
        int[] b = {1, 6, 7, 9};

        int size = 1;

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
        mergeLists(evenList, oddList);
        endTime = System.currentTimeMillis();

        System.out.println("Time taken for iterative mergeLinkedLists: " + (endTime - startTime));

        printArray(primeNumbersBrute(10));
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

        int numOfFactors = 0;

        while (true) {
            if (result.length == size) {
                break;
            }
            for (int i = 1; i <= currNum; i++) {
                if (currNum%i == 0) {
                    numOfFactors++;
                }
                if (numOfFactors > 2) {
                    break;
                }
            }
            if (numOfFactors == 2 || numOfFactors == 1) {
                result[cursor] = currNum;
                System.out.println("currNum: " + currNum);
                cursor++;
            }
            numOfFactors = 0;
            currNum++;
        }
        return result;
    }

/*
    public static int[] sortList(int[] arr) {
        int[] arrA = new int[arr.length/2];
        for (int i = 0; i < arr.length/2; i++) {
            arrA[i] = arr[i];
        }
        int[] arrB = new int[arr.length - (arr.length/2)];
        for (int i = arr.length/2; i < arr.length; i++) {
            arrB[i] = arr[i];
        }
        int[] list1 = sortList(arrA);
        int[] list2 = sortList(arrB);
        return arrA;
    }
*/

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

}

class List {
    Node next;
    public List() {
        this.next = null;
    }
}