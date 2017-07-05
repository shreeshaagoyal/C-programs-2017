public class AList {
    int[] arr;
    int initialCapacity = 0;
    int size = 0;
    int capacityLeft = 0;
    public AList(int initialCapacity) {
        this.arr = new int[initialCapacity];
        this.initialCapacity = initialCapacity;
    }

    public void add(int e) {
        this.size++;
        if(capacityLeft() > 0) {
            this.arr[size-1] = e;
        } else {
            int[] newArr = new int[2 * this.arr.length];
            for(int i = 0; i < this.arr.length; i++) {
                newArr[i] = this.arr[i];
            }
            newArr[size-1] = e;
            this.arr = newArr;
        }
    }

    public void addToIndex(int index, int e) {
        this.size++;
        if(capacityLeft() > 0) {
            for(int i = this.arr.length-1; i >= index; i--) {
                this.arr[i+1] = this.arr[i];
            }
            this.arr[index] = e;
        } else {
            int[] newArr = new int[2 * this.arr.length];
            for(int i = 0; i < this.arr.length; i++) {
                newArr[i] = this.arr[i];
            }
            for(int i = newArr.length-1; i >= index; i--) {
                newArr[i+1] = newArr[i];
            }
            newArr[index] = e;
            this.arr = newArr;
        }
    }

    private int capacityLeft() {
        return this.arr.length - this.size;
    }

    public void clear() {
        this.size = 0;
    }

    public int get(int index) {
        return this.arr[index];
    }

    public void removeLastElement() {
        this.size--;
    }

    public void trimToSize() {
        int[] newArr = new int[this.size];
        for(int i = 0; i < this.size; i++) {
            newArr[i] = this.arr[i];
        }
        this.arr = newArr;
    }
}