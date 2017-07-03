public class AList {
    int[] arr;
    int initialCapacity;
    int size;
    int capacityLeft;
    public AList(int initialCapacity) {
        arr = new int[initialCapacity];
        this.initialCapacity = initialCapacity;
    }

    public void add(int e) {
        this.size++;
        if(capacityLeft() > 0) {
            arr[size] = e;
        } else {
            int[] newArr = new int[2*arr.length];
            for(int i = 0; i<arr.length; i++) {
                newArr[i] = arr[i];
            }
            newArr[size] = e;
            this.arr = newArr;
        }
    }

    private int capacityLeft() {
        return arr.length - this.size;
    }

    public void clear() {
        this.size = 0;
        trimToSize();
    }

    public int get(int index) {
        return arr[index];
    }

    public void trimToSize() {
        int[] newArr = new int[this.size];
        this.arr = newArr;
    }
}