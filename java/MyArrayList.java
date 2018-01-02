public class MyArrayList {
    int[] arr;
    int capacity; // !!! make this private

    public MyArrayList(int n) {
        this.arr = new int[n];
        this.capacity = n;
    }

    public void addToFront(int n) {
        if (this.arr.length > this.capacity) {
            doubleCapacity();
        }
        int[] tempArr = new int[this.arr.length + 1];
        tempArr[0] = n;
        for (int i = 0; i < this.arr.length; i++) {
            tempArr[i + 1] = this.arr[i];
        }
        this.arr = tempArr;
    }

    public void addToBack(int n) {
        if (this.arr.length > this.capacity) {
            doubleCapacity();
        }
        int[] tempArr = new int[this.arr.length + 1];
        for (int i = 0; i < this.arr.length; i++) {
            tempArr[i] = this.arr[i];
        }
        tempArr[tempArr.length - 1] = n;
        this.arr = tempArr;
    }

    public void addToIndex(int index, int n) {
        if (this.arr.length > this.capacity) {
            doubleCapacity();
        }
        int[] tempArr = new int[this.arr.length + 1];
    }

    public void removeFromFront() {

    }

    public void removeFromBack() {

    }

    public void removeFromIndex(int index, int n) {

    }

    public int size() {
        return 0;
    }

    /** PRIVATE METHODS */
    private void doubleCapacity() {
        int doubleSize = 2 * this.capacity;
        int[] biggerArr = new int[doubleSize];
        for (int i = 0; i < this.arr.length; i++) {
            biggerArr[i] = this.arr[i];
        }
        this.capacity = doubleSize;
    }

    public static void main(String[] args) {
        MyArrayList testArr = new MyArrayList(3);
        System.out.println("capacity: " + testArr.capacity);
        System.out.println("adding 10");
        testArr.addToFront(10);
        System.out.println("capacity: " + testArr.capacity);
        System.out.println("adding 6");
        testArr.addToBack(6);
        System.out.println("capacity: " + testArr.capacity);
        System.out.println("adding 9");
        testArr.addToBack(9);
        System.out.println("capacity: " + testArr.capacity);
        System.out.println("adding 19");
        testArr.addToBack(19);
        System.out.println("capacity: " + testArr.capacity);
        System.out.println("adding 9");
        testArr.addToBack(9);
        System.out.println("capacity: " + testArr.capacity);
        System.out.println("adding 9");
        testArr.addToBack(9);
        System.out.println("capacity: " + testArr.capacity);
        System.out.println("adding 9");
        testArr.addToBack(9);
        System.out.println("capacity: " + testArr.capacity);
        System.out.println("adding 9");
        testArr.addToBack(9);
        System.out.println("capacity: " + testArr.capacity);
        System.out.println("adding 9");
        testArr.addToBack(9);
        System.out.println("capacity: " + testArr.capacity);
        System.out.println("adding 9");
        testArr.addToBack(9);
        System.out.println("capacity: " + testArr.capacity);
        System.out.println("adding 9");
        testArr.addToBack(9);
        System.out.println("capacity: " + testArr.capacity);
    }
}