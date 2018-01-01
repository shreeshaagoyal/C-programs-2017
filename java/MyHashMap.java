import java.util.List;
import java.util.ArrayList;
public class MyHashMap {
    List<MyBucket> buckets;

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
        System.out.println("this.calculateAverageSize(): " + this.calculateAverageSize());
        if (this.calculateAverageSize() > 2) {
            this.decreaseBucketLoad();
        }
    }

    public int get(String s) {
        int index = getIndex(s);
        MyBucket bucket = this.buckets.get(index);
        return bucket.get(s);
    }

    private int getIndex(String s) {
        int hash = s.hashCode();
        int index = hash % this.size();
        index = Math.abs(index);
        return index;
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
    }

    public int size() {
        return this.buckets.size();
    }

    private double calculateAverageSize() {
        double sum = 0;
        for (int i = 0; i < this.buckets.size(); i++) {
            sum += this.buckets.get(i).size();
        }
        System.out.println();
        return sum / this.buckets.size();
    }

    private void decreaseBucketLoad() {
        int doubleSize = 2 * this.buckets.size();
        List<MyBucket> expandedBuckets = new ArrayList<MyBucket>(doubleSize);
        MyBucket emptyBucket = new MyBucket();
        for (int i = 0; i < doubleSize; i++) {
            expandedBuckets.add(emptyBucket);
        }
        for (int i = 0; i < this.buckets.size(); i++) {
            MyBucket currBucket = this.buckets.get(i);
            for (int j = 0; j < currBucket.entries.size(); j++) {
                MyEntry currEntry = currBucket.entries.get(j);
                int hash = Math.abs(currEntry.s.hashCode());
                int index = currEntry.s.hashCode() % expandedBuckets.size();
                index = Math.abs(index);
                expandedBuckets.get(index).add(currEntry.s, currEntry.n);
            }
        }
        this.buckets = expandedBuckets;
    }

    public static void main(String[] args) {
        MyHashMap testHashMap = new MyHashMap(10);
        System.out.println(testHashMap.size());
        testHashMap.put("Shreeshaa", 18);
        System.out.println(testHashMap.size());
        testHashMap.put("Shreeshaa", 20);
        System.out.println(testHashMap.size());
        testHashMap.put("Shivanshu", 24);
        System.out.println(testHashMap.size());
    }
}