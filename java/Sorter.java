import java.util.ArrayList;

public class Sorter {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(124);
        arr.add(148);
        arr.add(275);
        arr.add(177);
        arr.add(57);
        arr.add(180);
        arr.add(219);
        arr.add(106);
        arr.add(180);
        arr.add(114);

        System.out.print("initial array: ");
        printArray(arr);
        System.out.println();

        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(2);
        arr1.add(24);
        // arr1.add(4);
        // arr1.add(50);
        
        ArrayList<Integer> resultArr = sortArrayByX(arr);
        printArray(resultArr);
    }

    public static ArrayList sortArrayByX(ArrayList<Integer> arr) {
        // base case
        if (arr.size() == 2) {
            return arr;
        }

        ArrayList<Integer> arrA = new ArrayList<Integer>();
        ArrayList<Integer> arrB = new ArrayList<Integer>();

        int a = arr.size()/2;
        int b = a/2;
        int c = b*2;

        for (int i = 0; i < c; i++) {
            arrA.add(arr.get(i));
        }
        System.out.print("arrA: ");
        printArray(arrA);
        for (int i = c; i < arr.size(); i++) {
            arrB.add(arr.get(i));
        }
        System.out.print("arrB: ");
        printArray(arrB);
        System.out.println();

        ArrayList<Integer> list1 = sortArrayByX(arrA);
        // System.out.print("list1: ");
        // printArray(list1);
        // System.out.println();

        ArrayList<Integer> list2 = sortArrayByX(arrB);
        // System.out.print("list2: ");
        // printArray(list2);
        // System.out.println();

        return mergeArrayByX(list1, list2);
    }

    public static ArrayList mergeArrayByX(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> resultArr = new ArrayList<Integer>();
        int cursor1 = 0, cursor2 = 0;

        while((cursor1 < list1.size()) || (cursor2 < list2.size())) {
            if ((getVal(list1, cursor1)) < (getVal(list2, cursor2))) {
                resultArr.add(getVal(list1, cursor1));
                resultArr.add(getVal(list1, cursor1+1));
                cursor1+=2;
            } else {
                resultArr.add(getVal(list2, cursor2));
                resultArr.add(getVal(list2, cursor2+1));
                cursor2+=2;
            }
        }
        return resultArr;
    }

    public static Integer getVal(ArrayList<Integer> list, int index) {
        if (index >= list.size()) {
            return Integer.MAX_VALUE;
        } else {
            return list.get(index);
        }
    }

    public static void printArray(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + ", ");
        }
    }
}