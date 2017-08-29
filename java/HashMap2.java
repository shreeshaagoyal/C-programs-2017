public class HashMap2 {
    Bucket2[] buckets;
    int count = 0;
    public HashMap2(int hashMapSize) {
        this.buckets = new Bucket2[hashMapSize];
    }

    public void add(String key, int value) {
        int index = calculateIndex(key);
        buckets[index].setInBucket(key, value);
        count++;
    }

    public int get(String key) {
        return buckets[calculateIndex(key)].getFromBucket(key);
    }

    public int size() {
        return this.count;
    }

    public void delete(String key) {
        buckets[calculateIndex(key)].removeFromBucket(key);
        count--;
    }

    /** PRIVATE FUNCTIONS */
    public int calculateIndex(String key) {
        int hash = key.hashCode();
        int result = Math.abs(hash % this.buckets.length);
        return result;
    }
}