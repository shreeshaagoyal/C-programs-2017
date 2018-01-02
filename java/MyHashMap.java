import java.util.List;
import java.util.ArrayList;
public class MyHashMap {
    List<MyBucket> buckets;
    double maxNumEntriesPerBucket = 1.5;

    public MyHashMap() {
        this.buckets = new ArrayList<MyBucket>();
    }

    public MyHashMap(int n) {
        this.buckets = new ArrayList<MyBucket>(n);
        for (int i = 0; i < n; i++) {
            MyBucket emptyBucket = new MyBucket();
            this.buckets.add(emptyBucket);
        }
    }

    public void put(String s, int n) {
        int index = getIndex(s);
        MyBucket bucket = this.buckets.get(index);
        bucket.add(s, n);
        if (this.averageEntriesPerBucket() > this.maxNumEntriesPerBucket) {
            this.decreaseBucketLoad();
        }
    }

    public int get(String s) {
        int index = getIndex(s);
        MyBucket bucket = this.buckets.get(index);
        return bucket.get(s);
    }

    public Boolean containsKey(String s) {
        try {
            int result = this.get(s);
        }
        catch (RuntimeException e) {
            return false;
        }
        return true;
    }

    public void remove(String s) {
        int index = this.getIndex(s);
        MyBucket bucket = this.buckets.get(index);
        bucket.remove(s);
    }

    public int size() {
        return this.buckets.size();
    }

    

    /** PRIVATE METHODS */
    private double averageEntriesPerBucket() {
        double sum = 0;
        for (int i = 0; i < this.buckets.size(); i++) {
            sum += this.buckets.get(i).size();
        }
        System.out.println();
        return sum / this.buckets.size();
    }

    private int getIndex(String s) {
        int hash = s.hashCode();
        int index = hash % this.size();
        index = Math.abs(index);
        return index;
    }

    private void decreaseBucketLoad() {
        int doubleSize = 2 * this.size();
        List<MyBucket> expandedBuckets = new ArrayList<MyBucket>(doubleSize);

        // making an array of buckets with double the original size
        for (int i = 0; i < doubleSize; i++) {
            MyBucket emptyBucket = new MyBucket();
            expandedBuckets.add(emptyBucket);
        }

        for (int i = 0; i < this.buckets.size(); i++) {
            MyBucket currBucket = this.buckets.get(i);

            for (int j = 0; j < currBucket.size(); j++) {
                MyEntry currEntry = currBucket.entries.get(j);
                int hash = currEntry.s.hashCode();
                int index = hash % expandedBuckets.size();
                index = Math.abs(index);
                MyBucket bucketToAddTo = expandedBuckets.get(index);
                bucketToAddTo.add(currEntry.s, currEntry.n);
            }
        }
        this.buckets = expandedBuckets;
    }
}