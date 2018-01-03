public class MyDeque {
    int[] arr;
    int size;

    public MyDeque(int n) {
        this.arr = new int[n];
    }

    public void addToFront(int n) {
        if (this.capacity() == this.size) {
            this.increaseCapacity();
        }
        
        for (int i = (this.size - 1); i >= 0; i--) {
            this.arr[i+1] = this.arr[i];
        }
        this.arr[0] = n;
        this.size++;
    }

    public void addToBack(int n) {
        if (this.capacity() == this.size) {
            this.increaseCapacity();
        }

        this.arr[this.size] = n;
        this.size++;
    }

    public void addToIndex(int index, int n) {
        if ((index < 0) || (index > this.size)) {
            throw new IllegalArgumentException("Index must be between 0 and " + this.size);
        }

        if (this.capacity() == this.size) {
            this.increaseCapacity();
        }

        for (int i = (this.size - 1); i >= index; i--) {
            this.arr[i+1] = this.arr[i];
        }

        this.arr[index] = n;
        this.size++;
    }

    public void removeFromFront() {
        for (int i = 1; i < this.size; i++) {
            this.arr[i-1] = this.arr[i];
        }
        this.size--;

        if (this.size == (this.capacity() / 2)) {
            decreaseCapacity();
        }
    }

    public void removeFromBack() {
        this.size--;

        if (this.size == (this.capacity() / 2)) {
            decreaseCapacity();
        }
    }

    public void removeFromIndex(int index) {
        if ((index < 0) || (index > this.size-1)) {
            throw new IllegalArgumentException("Index must be between 0 and " + (this.size - 1));
        }

        for (int i = (index + 1); i < this.size; i++) {
            this.arr[i-1] = this.arr[i];
        }
        this.size--;

        if (this.size <= (this.capacity() / 2)) {
            decreaseCapacity();
        }
    }

    public int size() {
        return this.size;
    }

    public void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.arr[i]);
            System.out.print(", ");
        }
        System.out.println("\n");
    }

    /** PRIVATE METHODS */
    private void increaseCapacity() {
        int[] expandedArr = new int[2 * this.capacity()];
        for (int i = 0; i < this.size; i++) {
            expandedArr[i] = this.arr[i];
        }
        this.arr = expandedArr;
    }

    private void decreaseCapacity() {
        int half = this.capacity() / 2;
        int[] smallArr = new int[half];
        for (int i = 0; i < half; i++) {
            smallArr[i] = this.arr[i];
        }
        this.arr = smallArr;
    }

    private int capacity() {
        return this.arr.length;
    }

    public static void main(String[] args) {
        MyDeque testArr = new MyDeque(3);
    }
}