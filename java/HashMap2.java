public class HashMap2 {
    Bucket2[] buckets;
    public HashMap2(int hashMapSize) {
        this.buckets = new Bucket2[hashMapSize];
    }

    public void add(String key, int value) {

    }

    public int get(String key) {

    }

    public int count() {

    }

    public void delete(String key) {

    }

    /** PRIVATE FUNCTIONS */
    private int calculateIndex(String key) {
        int hash = key.hashCode();
        int result = hash % this.buckets.length;
    }
}