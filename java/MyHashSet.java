import java.util.List;
import java.util.ArrayList;

public class MyHashSet {
    List<MyHashSetBucket> set;
    double maxNumEntriesPerBucket = 1.5;

    public MyHashSet() {
        this.set = new ArrayList<MyHashSetBucket>();
        MyHashSetBucket emptyBucket = new MyHashSetBucket();
        this.set.add(emptyBucket);
    }

    public MyHashSet(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        this.set = new ArrayList<MyHashSetBucket>(n);
        for (int i = 0; i < n; i++) {
            MyHashSetBucket emptyBucket = new MyHashSetBucket();
            this.set.add(emptyBucket);
        }
    }

    public void add(int n) {
        int index = this.getIndex(n);
        MyHashSetBucket currBucket = this.set.get(index);
        currBucket.add(n);
        if (this.averageNumEntriesPerBucket() > this.maxNumEntriesPerBucket) {
            this.decreaseBucketLoad();
        }
    }

    public void remove(int n) {
        int index = this.getIndex(n);
        MyHashSetBucket currBucket = this.set.get(index);
        currBucket.remove(n);
    }

    public Boolean contains(int n) {
        int index = this.getIndex(n);
        MyHashSetBucket currBucket = this.set.get(index);
        return currBucket.contains(n);
    }

    public int size() {
        return this.set.size();
    }

    /** PRIVATE METHODS */
    private int getIndex(int n) {
        Integer num = new Integer(n);
        int hash = num.hashCode();
        int index = hash % this.set.size();
        index = Math.abs(index);
        return index;
    }

    public double averageNumEntriesPerBucket() {
        double sum = 0;
        for (int i = 0; i < this.size(); i++) {
            sum += this.set.get(i).numEntries();
        }
        return sum / this.size();
    }

    private void decreaseBucketLoad() {
        int doubleSize = 2 * this.size();
        List<MyHashSetBucket> expandedSet = new ArrayList<MyHashSetBucket>(doubleSize);
        // adding empty buckets to expandedSet
        for (int i = 0; i < doubleSize; i++) {
            MyHashSetBucket emptyBucket = new MyHashSetBucket();
            expandedSet.add(emptyBucket);
        }

        for (int i = 0; i < this.size(); i++) {
            MyHashSetBucket currBucket = this.set.get(i);
            for (int j = 0; j < currBucket.numEntries(); j++) {
                Integer currNum = currBucket.entries.get(j);
                int hash = currNum.hashCode();
                int index = hash % expandedSet.size();
                index = Math.abs(index);
                MyHashSetBucket bucketToAddTo = expandedSet.get(index);
                bucketToAddTo.add(currNum);
            }
        }
        this.set = expandedSet;
    }

    public static void main(String[] args) {
        MyHashSet testSet = new MyHashSet(2);
        testSet.add(4);
        testSet.add(6);
        testSet.add(6);
        testSet.remove(6);

        System.out.println("4 : " + testSet.contains(4));
        System.out.println("6 : " + testSet.contains(6));
        System.out.println("10 : " + testSet.contains(10));
    }
}