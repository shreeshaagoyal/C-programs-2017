class Main {
    public static void main(String[] args) {
        int num1 = 4;
        int num2 = 19;
        int result = findGCF(num1, num2);
        System.out.println("result = " + result);

        Node headA = new Node(10000);
        Node a1 = new Node(1);
        Node a2 = new Node(8);
        headA.next = a1;
        a1.next = a2;

        Node headB = new Node(9999);
        Node b1 = new Node(2);
        Node b2 = new Node(6);
        Node b3 = new Node(7);
        Node b4 = new Node(16);
        headB.next = b1;
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;

        Node resultNode = mergeLists(headA, headB);
        System.out.println("mergeLists result Node value: " + resultNode.value);

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

    public static Node mergeLists(Node headRef1, Node headRef2) {
        // ASSUMPTION: both linked lists are sorted
        Node tempRef = new Node(0);
        Node p1 = new Node(0);
        Node p2 = new Node(0);
        p1.next = headRef1.next;
        p2.next = headRef2.next;
        while((p1.next.next != null) && (p2.next.next != null)) {
            if(p1.next.value < p2.next.value) {
                if(p1.next.next.value < p2.next.value) {
                    p1.next = p1.next.next;
                    continue;
                } else {
                    tempRef.next = p1.next.next;
                    p1.next.next = p2.next;
                    p1.next = tempRef.next;
                    continue;
                }
            } else {
                if (p2.next.next.value < p1.next.value) {
                    p2.next = p2.next.next;
                    continue;
                } else {
                    tempRef.next = p2.next.next;
                    p2.next.next = p1.next;
                    p2.next = tempRef.next;
                    continue;
                }
            }
        }
        if (p1.next.next == null) {
            if (p1.next.value < p2.next.value) {
                p1.next.next = p2.next;
                return headRef1;
            } else {
                while (p2.next.next != null) {
                    if (p2.next.next.value < p1.next.value) {
                        p2.next = p2.next.next;
                        continue;
                    } else {
                        tempRef.next = p2.next.next;
                        p2.next = p1.next;
                        p1.next.next = tempRef.next;
                        continue;
                    }
                }
            }
        } else if (p2.next.next == null) {
            if (p2.next.value < p1.next.value) {
                p2.next.next = p1.next;
                return headRef2;
            } else {
                while (p1.next.next != null) {
                    if (p1.next.next.value < p2.next.value) {
                        p1.next = p1.next.next;
                        continue;
                    } else {
                        tempRef.next = p1.next.next;
                        p1.next = p2.next;
                        p2.next.next = tempRef.next;
                        continue;
                    }
                }
            }
        }
        return headRef1;
    }
}

